package Economia.Tramite140104;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140104Test {
    MainPage140104 mainPage140104 = new MainPage140104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite140104  = new TramitesFirmasLG(
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
    public void Proceso140104() throws IOException {
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
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite140104);
            mainPage140104.selecRol.sendKeys("Persona Moral");
            mainPage140104.btnacep.click();
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Secretaría de Economía']").click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Cancelaciones, Modificaciones, Desistimientos y Reactivaciones")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Modificaciones, Cancelaciones y Desistimientos a petición de parte")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Cancelación de Permisos a Petición del Interesado")).click();sleep(15000); sleep(3000);

            // Paso 1
            // Sección Cancelación de permisos previamente autorizados
            mainPage140104.Scrol.scrollTo();
            mainPage140104.tabCancelacionPermisosPrevAutorizado.click();
            mainPage140104.btnAccederBusquedaFolio.click();
            String FolioRubro = obtenerPrimerFolioResolucion();
            System.out.println("Folio de resolución obtenido: " + FolioRubro);
            mainPage140104.FolioResolucion.sendKeys(FolioRubro);
            mainPage140104.FolioResolucion.scrollTo();
            mainPage140104.btnBuscarFolioIngresado.click();
            mainPage140104.btnAgregarFolio.click();
            mainPage140104.ResolucionElemento1.click();
            mainPage140104.MotivoCancelacion.sendKeys("Cancelación QA");
            mainPage140104.btnContinuarAgregarSol.click();

            //Paso 2
            mainPage140104.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage140104.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage140104.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage140104.btnAdjuntar2.click();sleep(2000);
            mainPage140104.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage140104.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage140104.btnContinuar3.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite140104);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage140104.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public static String obtenerPrimerFolioResolucion() {
        String folio = null;

        // Datos de conexión (ajústalos según tu entorno)
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";

        String sql = "SELECT * FROM ( " +
                "    SELECT VR.NUM_FOLIO_RESOLUCION " +
                "    FROM VUC_RESOLUCION VR " +
                "    LEFT JOIN VUC_TRAMITE VT ON VR.NUM_FOLIO_TRAMITE = VT.NUM_FOLIO_TRAMITE " +
                "    LEFT JOIN VUC_SOLICITUD VS ON VT.ID_SOLICITUD = VS.ID_SOLICITUD " +
                "    WHERE VT.NUM_FOLIO_TRAMITE LIKE ? " +
                "      AND VT.IDE_EST_TRAMITE = ? " +
                "      AND VS.IDE_EST_SOLICITUD = ? " +
                "      AND VS.CVE_USUARIO_CAPTURISTA = ? " +
                "      AND VR.IDE_SENT_RESOLUCION = ? " +
                "      AND VR.IDE_EST_RESOLUCION = ? " +
                "      AND VS.NUM_FOLIO_TRAMITE_ORIGINAL IS NULL " +
                "      AND VR.NUM_FOLIO_TRAMITE NOT IN ( " +
                "          SELECT S.NUM_FOLIO_TRAMITE_ORIGINAL " +
                "          FROM VUC_SOLICITUD S " +
                "          WHERE S.NUM_FOLIO_TRAMITE_ORIGINAL IS NOT NULL " +
                "      ) " +
                "    ORDER BY VS.FEC_CREACION DESC " +
                ") " +
                "WHERE ROWNUM = 1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Parámetros de la query
            ps.setString(1, "02013001020%");
            ps.setString(2, "ESTTR.CN");
            ps.setString(3, "ESTSOL.AU");
            ps.setString(4, "AAL0409235E6");
            ps.setString(5, "SERE.AC");
            ps.setString(6, "ESTRES.AT");

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    folio = rs.getString("NUM_FOLIO_RESOLUCION");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return folio;
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}

