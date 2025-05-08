package HACIENDA.Tramite40301;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage40301Test {

    MainPage40301 mainPage40301 = new MainPage40301();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite40301 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
    );

    // Variable para almacenar el tipo de trámite seleccionado
    @BeforeAll
    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso40301(){

        // Solicitar el número de repeticiones
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

        // Ejecutar el proceso repetidamente
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite40301); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaTramite();

            ///Datos de la Solicitud
            ejecutarPestDatosSoli();

//            ///Firma
//            loginSoli.firma(tramite40301);
//
////          Obtener el texto del folio
//            String folioText = mainPage40301.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaTramite() {
        mainPage40301.selecRol.sendKeys("Persona Física"); sleep(1000);
        mainPage40301.btnacep.click(); sleep(1000);
        mainPage40301.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage40301.SoliNew.click(); sleep(1000);
        mainPage40301.hacienda.click(); sleep(1000);
        mainPage40301.registroCodAlf.click(); sleep(1000);
        mainPage40301.RegCodAlfCarg.click(); sleep(1000);
        mainPage40301.tramite40301.click(); sleep(1000);
    }

    public void ejecutarPestDatosSoli() {
        mainPage40301.PestDatosSoli.click(); sleep(1000);
        mainPage40301.TipoDeAgente.sendKeys("Agente naviero"); sleep(1000);
        mainPage40301.btnConti.click(); sleep(1000);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }
}
