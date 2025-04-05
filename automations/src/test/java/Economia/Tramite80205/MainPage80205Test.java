package Economia.Tramite80205;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.awt.*;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class MainPage80205Test {
    MainPage80205 mainPage80205 = new MainPage80205();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite80205 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Selenide.open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000L;
        WebDriverRunner.getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10L));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        options.addArguments(new String[]{"--incognito"});
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso80205() {
        String repeticionesStr = JOptionPane.showInputDialog((Component)null, "Ingrese el número de repeticiones:", "Repeticiones", 3);
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
        } else {
            int repeticiones;
            try {
                repeticiones = Integer.parseInt(repeticionesStr);
            } catch (NumberFormatException var8) {
                repeticiones = 1;
                JOptionPane.showMessageDialog((Component)null, "Valor no válido, se utilizará 1 repetición por defecto.");
            }

            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion");

            Object[] params = new Object[]{"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
            int option = JOptionPane.showConfirmDialog((Component)null, params, "Opciones de Métodos", 2);
            if (option != 0) {
                JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
            } else {

                ejecutarProcesoNRunnable(() -> {
                    loginFirmSoli.login(tramite80205);
                    mainPage80205.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage80205.btnacep.click();
                    mainPage80205.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage80205.SoliNew.click();
                    mainPage80205.economia.click();
                    mainPage80205.IMMEX.click();
                    mainPage80205.Ampli.click();
                    mainPage80205.Tramite80205.click(); sleep(15000);
                    mainPage80205.CargaIMMEX.doubleClick();
                    mainPage80205.Servicios.click();

                    mainPage80205.ServicioIMMEX.sendKeys("INTEGRACION DE JUEGOS (KITS) O MATERIAL CON FINES PROMOCIONALES Y QUE SE ACOMPAÑEN EN LOS PRODUCTOS QUE SE EXPORTAN");
                    mainPage80205.btnAgregar.click();
                    mainPage80205.CheckAutorizado.click();
                    mainPage80205.RFC.sendKeys("TSD931210493");
                    mainPage80205.NIMMEX.sendKeys("2347");
                    mainPage80205.AnioImmex.sendKeys("2006");
                    mainPage80205.btnAgregarEmpServ.click();
                    mainPage80205.btnContinuar.click();

//                    loginFirmSoli.login(tramite80205);
//                    String folioText = mainPage80205.folio.getText();
//                    ObtenerFolio var10000 = obtenerFolio;
//                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
                }, repeticiones);
            }
        }
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for(int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }
}



