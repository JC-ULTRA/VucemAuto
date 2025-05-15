package HACIENDA.Tramite31501;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage31501Test {
    MainPage31501 mainPage31501 = new MainPage31501();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite31501 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;

        // Configuraciones de Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=1.25"); // Escala 150%
        Configuration.browserCapabilities = options;

        open();
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080)); // Resolución personalizada
        getWebDriver().manage().window().maximize(); // Maximizar la ventana
        Configuration.timeout = 120000; // Tiempo de espera
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
    public void Proceso31501() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            sleep(4000);
            loginFirmSoli.firma(tramite31501);
            mainPage31501.consultas.click();
            mainPage31501.despliegaConsultas.click();
            mainPage31501.requerimientoAutoridad.click();
            mainPage31501.selecTipoRequerimiento.click();
            mainPage31501.rfcBusqueda.sendKeys("AAL0409235E6"); //Sin folio específico
//            mainPage31501.tipoTramite.sendKeys("Solicitud de Registro en el Esquema de Certificación de Empresas Modalidad IVA e IEPS");
            mainPage31501.numeroFolio.sendKeys("2500301600320259910000032");sleep(1000);
            mainPage31501.buscarFolio.click();
            mainPage31501.selecTramite.doubleClick();
            /// Capturar requerimento
            mainPage31501.capturarRequerimento.click();
            mainPage31501.tipoRequerimento.sendKeys("Documentos");
            mainPage31501.justificacionRequerimento.sendKeys("PRUEBAS QA ULTRASIST");
            scrollDecremento();
            mainPage31501.seleccionarDocumentos.click();
            mainPage31501.tipoDocumentos.sendKeys("Comprobante de pago de derechos");
            mainPage31501.agregarNuevoDoc.click();
            scrollDecremento();
            mainPage31501.btnContinuarRequerimento.click();sleep(10000);

            scrollDecremento();
            mainPage31501.btnGuardarSoli.click();
            loginFirmSoli.firma(tramite31501);


            // Obtener el texto del folio desde mainPage31501
            String folioText = mainPage31501.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 3; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}
