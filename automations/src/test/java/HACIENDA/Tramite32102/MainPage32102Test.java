package HACIENDA.Tramite32102;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32102Test {
    MainPage32102 mainPage32102 = new MainPage32102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    // VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32102 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
    public void Proceso32102() {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// -
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// opción
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// de
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones",
                JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será
        // null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
        }

        // Convertir el valor ingresado a entero, manejando posibles excepciones si el
        // usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto
            // (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// -

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32102);
            mainPage32102.selecRol.sendKeys("Persona Moral");
            mainPage32102.btnacep.click();
            mainPage32102.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage32102.SoliSub.click();
            mainPage32102.inputIdFolio.sendKeys("2500301600320259910000045");
            mainPage32102.inputBuscarButton.click();
            sleep(1000);
            mainPage32102.SolicitudTramite.doubleClick();
mainPage32102.inputModificacion.click();
mainPage32102.labelAmpliacionSolicitante.click();
mainPage32102.checkAmpliacion.click();
mainPage32102.checkProtestaVerdad.click();
mainPage32102.checkEnterado.click();
mainPage32102.checkRequisitos.click();
            Selenide.sleep(500);
            presionarEscYSpace();

            mainPage32102.btnGuardarSolicitud.click();
            mainPage32102.inputSiguiente.click();sleep(1000);
            mainPage32102.inputAdjuntarDocumentos.click();sleep(1000);
            subirDocumentos("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32102.spanAdjuntar.click();
            sleep(4000);
            mainPage32102.spanCerrar.click();
            sleep(500);
            mainPage32102.inputSiguienteButton.click();
            sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite32102);
            String folioText = mainPage32102.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }
    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }
}