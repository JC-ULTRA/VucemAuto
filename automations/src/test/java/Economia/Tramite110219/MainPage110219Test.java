package Economia.Tramite110219;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110219Test {
    MainPage110219 mainPage110219 = new MainPage110219();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110219  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso110219() throws IOException {
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


///Tramite Aviso 110219
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite110219); sleep(1000);

            ///RutaAlTramite
            ejecutarRutaAlTramite();

            ///Cancelación de certificado de origen
            ejecutarCanCertOrgPest();

            ///Certificado de OrigenPest
            ejecutarCertOrgPest();

            ///Firma
            loginSoli.firma(tramite110219);

            // Obtener el texto del folio desde mainPage110219
            String folioText = mainPage110219.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage110219.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage110219.btnacep.click(); sleep(1000);
        mainPage110219.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage110219.SoliNew.click(); sleep(1000);
        mainPage110219.Economia.click(); sleep(1000);
        mainPage110219.CertificadoOrigen.click(); sleep(1000);
        mainPage110219.ValidacionCertificadosOrigen.click(); sleep(1000);
        mainPage110219.CancelCertif.click(); sleep(1000);

    }
    public void ejecutarCanCertOrgPest(){
        String certificadoCancelar = obtenerPrimerCertificadoOrigen();
        mainPage110219.CancelCertiOrgPest.click();
        mainPage110219.numCertificadoOrigen.sendKeys(certificadoCancelar);sleep(1500);
        mainPage110219.btnBuscarCertificado.click();sleep(1500);
        mainPage110219.Certific.scrollIntoView(true).doubleClick();
        executeJavaScript("window.scrollTo(0, 0);");
    }
    public void ejecutarCertOrgPest(){
        mainPage110219.CertOrigenPest.click();
        mainPage110219.MotivoCancel.sendKeys("Prueba QA");
        mainPage110219.btnContinuarFirm.click();

    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            setUpAll();
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public String obtenerPrimerCertificadoOrigen() {
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";

        String numCertificadoOrigen = null;

        String query =
                "SELECT vco.NUM_CERTIFICADO_ORIGEN FROM VUC_CERTIFICADO_ORIGEN vco, VUC_SOLICITUD vs " +
                        "WHERE vco.IDE_EST_CERTIFICADO_ORIGEN = 'ESTCO.02' AND vco.ID_SOLICITUD = vs.ID_SOLICITUD " +
                        "AND vs.CVE_USUARIO_CAPTURISTA LIKE 'AAL%' AND vco.NUM_CERTIFICADO_ORIGEN LIKE 'MX%' ORDER BY vs.FEC_CREACION DESC";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(query)) {

                if (rs.next()) {
                    numCertificadoOrigen = rs.getString("NUM_CERTIFICADO_ORIGEN");
                    System.out.println("✅ Certificado de Origen encontrado: " + numCertificadoOrigen);
                    return numCertificadoOrigen;
                } else {
                    System.out.println("Paso 1: No se encontraron certificados de origen que cumplan los criterios.");
                    return null;
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Error de conexión/SQL al ejecutar la consulta: " + e.getMessage());
            return null;
        }
    }
}
