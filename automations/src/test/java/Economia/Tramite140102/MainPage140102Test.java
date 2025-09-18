package Economia.Tramite140102;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140102Test {
    MainPage140102 mainPage140102 = new MainPage140102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite140102  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso140102() throws IOException {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
        }

        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-

        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Reactivar el programa en la base de datos
            ReactivarProsec();
            sleep(2000);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite140102);

            mainPage140102.selecRol.sendKeys("Persona Moral");
            mainPage140102.btnacep.click();


            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();
            $(withText("Solicitudes nuevas")).click();
            $("[alt='Secretaría de Economía']").click();
            $(withText("Cancelaciones, Modificaciones, Desistimientos y Reactivaciones")).click();
            $(withText("Modificaciones, Cancelaciones y Desistimientos a petición de parte")).click();
            $(withText("Cancelación de Programa de la SE PROSEC")).click();
            sleep(5000);
            $(withText("Cancelación de autorizaciones")).click();

            $$("tr").findBy(Condition.text("2025-9429"))
                    .find("input[type='radio']")
                    .click();
sleep(5000);
mainPage140102.Obs.sendKeys("X");
            $("#confirmar").click();
            mainPage140102.btnContinuaFirma.click();

    //Firma de la solicitud
            loginFirmSoli.firma(tramite140102);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage140102.folio.getText();

            //Llamar al Metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public static void ReactivarProsec() {
        Connection conexion = null;
        PreparedStatement ps = null;

        String sql = "UPDATE VUC_PROGRAMA_AUTORIZADO_SE " +
                "SET IDE_MOVIMIENTO_PROG_SE = 'MOVPSE.AT', FEC_FIN_VIGENCIA = NULL " +
                "WHERE NUM_FOLIO_PROGRAMA_SE = '9429' AND ANIO_PROGRAMA = '2025'";

        try {
            // Conexión a la BD (ajusta según tus datos de Oracle u otra BD)
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                    "vucem_app_p01",
                    "Mfk22nvW6na71DgBXi5R"
            );

            // Crear PreparedStatement
            ps = conexion.prepareStatement(sql);

            // Ejecutar UPDATE
            int filas = ps.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);
            System.out.println("Actualización exitosa.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

