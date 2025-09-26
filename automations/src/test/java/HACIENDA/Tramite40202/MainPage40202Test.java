package HACIENDA.Tramite40202;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static DBYFOLIO.ObtenerFolio.obtenerFolioTemp;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.files.DownloadActions.click;

public class MainPage40202Test {

    MainPage40202 mainPage40202 = new MainPage40202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite40202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    TramitesFirmasLG tramite40202Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso40202() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
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
        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite40202);sleep(1000);
            mainPage40202.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage40202.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Administración General de Aduanas']").click();sleep(1000);
            $(withText("Registro del Código Alfanumérico Armonizado del Transportista")).click();sleep(1000);
            $(withText("Registro del Código Alfanumérico Armonizado del Transportista (Empresas de Transportación Marítima)")).click();sleep(1000);
            $(withText("Atención de Modificación")).click();sleep(1000);
            $("[for='modificarCaat.maritimo']").click();sleep(1000);
            $("[id='checkBuscaExtranjero']").click();sleep(1000);
          //  $("[id='folioCaatBusquedaNa']").sendKeys("3LMH");sleep(1000);
            $("[id='folioCaatBusquedaNa']").sendKeys("3LMH");sleep(1000);
            $("[id='buscaCandidato1']").click();sleep(1000);
            $("[id='jqg_PersonaBuscadaCAAT_3']").click();sleep(1000);
            $("[id='guardarBuscado2']").click();sleep(1000);
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);sleep(1000);
            $("[id='numeroInteriorPME']").clear();
            $("[id='numeroInteriorPME']").sendKeys("" + randomNum);sleep(1000);
            $("[id='numeroInteriorPME']").click();sleep(1000);
            $("[id='guardarPME']").click();sleep(1000);
            $("[id='jqg_EmpresaMaritimaCAAT_1']").click();sleep(1000);
            $("[value='Modificar']").click();sleep(1000);

            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 101);sleep(1000);
            $("[id='numeroInteriorPME']").clear();
            $("[id='numeroInteriorPME']").sendKeys("" + randomNum2);sleep(1000);

            $("[id='numeroInteriorPME']").click();sleep(1000);
            $("[value='Guardar']").click();sleep(1000);
            $("[name='guardar']").click();sleep(2000);

            String numeroTemporal = obtenerFolioTemp(mainPage40202.folio.getText());sleep(1000);

            String unidadAdmin = "1500301";sleep(1000);
                            System.out.println("Número temporal extraído: " + numeroTemporal);sleep(1000);
                            System.out.println(unidadAdmin);
            ejecutarUpdate(unidadAdmin, numeroTemporal);sleep(10000);
            $("[id='Solicitudes']").click();sleep(1000);
            $("[name='parametrosSolicitud.idSolicitud']").sendKeys(numeroTemporal);sleep(1000);
            $("[value='Buscar']").click();sleep(1000);
            $("td[aria-describedby='solicitud_nombreTramite']").doubleClick();
            $("[name='guardar']").click();sleep(2000);

            loginFirmSoli.firma(tramite40202);sleep(1000);
            String folioText = mainPage40202.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(1000);


        }, repeticiones);
    }


    public static void ejecutarUpdate(String CVUAdmin, String IdSolicitud) {
        String sql = "UPDATE VUC_SOLICITUD SET CVE_UNIDAD_ADMINISTRATIVA = ? WHERE ID_SOLICITUD = ?";

        // Ajusta con tus credenciales y cadena de conexión
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String usuario = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";

        try (
                Connection conn = DriverManager.getConnection(url, usuario, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Asignar parámetros
            pstmt.setString(1, CVUAdmin);
            pstmt.setString(2, IdSolicitud);

            int filas = pstmt.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
