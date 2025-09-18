package SENER.Tramite140111;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SENER.Tramite130108.MainPage130108Test;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140111Test {
    MainPage130108Test mainPage130108Test = new MainPage130108Test();
    MainPage140111 mainPage140111 = new MainPage140111();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite140111  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
    public void Proceso140111() {
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto.
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

        ejecutarProcesoNRunnable(() -> {
            String FolioSener = mainPage130108Test.Proceso130108Subsecuente();

            if (FolioSener == null) {
                System.out.println("El proceso de creación de folio fue cancelado, se detendrá la ejecución.");
                return;
            }
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramite140111);
            mainPage140111.selecRol.sendKeys("Persona Moral");
            mainPage140111.btnacep.click();
            mainPage140111.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage140111.soliSubsecuente.click();

            mainPage140111.folioTramite.sendKeys(FolioSener);
            mainPage140111.btnBuscarFolio.click();sleep(1000);
            mainPage140111.tablaFolios.doubleClick();
            mainPage140111.btnSolicitarCancelación.click();
            metodos.scrollDecremento(1);
            mainPage140111.renunciaDerechos.click();
            mainPage140111.motivoRenuncia.sendKeys("PRUEBAS QA ULTRASIST");
            mainPage140111.manifiesto.click();
            mainPage140111.btnGuardarSoli.click();
            mainPage140111.btnContinuarArchivos.click();
            metodos.cargarDocumentos();
            mainPage140111.btnAnexar.click();sleep(5000);
            mainPage140111.btnCerrar.click();
            mainPage140111.btnContinuarFirma.click();
            loginFirmSoli.firma(tramite140111);
            String folioText = mainPage140111.folio.getText();sleep(5000);
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
}
