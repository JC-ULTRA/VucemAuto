package Economia.Tramite90201;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.sleep;

public class MainPage90201Test {
    MainPage90201 mainPage90201 = new MainPage90201();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite90201 = new TramitesFirmasLG(
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
    public void Proceso90201() {
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

            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");
            Object[] params = new Object[]{"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
            int option = JOptionPane.showConfirmDialog((Component)null, params, "Opciones de Métodos", 2);
            if (option != 0) {
                JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
            } else {
                ejecutarProcesoNRunnable(() -> {
                    String uuid = UUID.randomUUID().toString();
                    int longitudDeseada = 16;
                    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
                    loginFirmSoli.login(tramite90201);

                    mainPage90201.selecRol.sendKeys("Persona Moral"); sleep(1000);
                    mainPage90201.btnacep.click(); sleep(1000);
                    mainPage90201.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
                    mainPage90201.SoliNew.click(); sleep(1000);
                    mainPage90201.Econom.click(); sleep(1000);
                    mainPage90201.Prosec.click(); sleep(1000);
                    mainPage90201.Ampliacion.click(); sleep(1000);
                    mainPage90201.Tramite90201.click(); sleep(1000);
                    mainPage90201.Dobleclick.doubleClick(); sleep(1000);
                    mainPage90201.FolioDelPrograma.doubleClick(); sleep(1000);
                    mainPage90201.DomPlan.click(); sleep(1000);
                    mainPage90201.sector.sendKeys("I-De la Industria Eléctrica"); sleep(1000);
                    mainPage90201.btnAgregarSector.click(); sleep(1000);
                    mainPage90201.Check.click(); sleep(1000);
                    mainPage90201.FreacArancel.sendKeys("85389099"); sleep(1000);
                    mainPage90201.btnAgregarFracArancel.click(); sleep(1000);
                    mainPage90201.CheckArancel.click(); sleep(1000);
                    mainPage90201.ProducIndirect.click(); sleep(1000);
                    mainPage90201.RFC.sendKeys("AFC000526BJ2"); sleep(1000);
                    mainPage90201.btnAgregarProduct.click(); sleep(1000);
                    mainPage90201.btnContinuar.click(); sleep(1000);

//                    loginFirmSoli.firma(tramite90201);
//                    String folioText = mainPage90201.folio.getText();
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

