package Economia.Tramite120404;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite120404.MainPage120404;
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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120404Test {
    MainPage120404 mainPage120404 = new MainPage120404();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite120404 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(40));
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
    public void Proceso120404() {
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
                    loginFirmSoli.login(tramite120404);
                    mainPage120404.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage120404.SoliNew.click();
                    mainPage120404.economia.click();
                    mainPage120404.cuposImpExp.click();
                    mainPage120404.asignacionDirecta.click();
                    mainPage120404.ampliacionPersonaM.click();
                    mainPage120404.asignacion.click();
                    mainPage120404.ampliacionMonto.click();
                    mainPage120404.añoOficio.sendKeys("2025");
                    ////El numOficio puede ser 1 o 2
                    mainPage120404.numOficio.sendKeys("1");
                    mainPage120404.btnBuscar.click();
                    ////El monto a ampliar se tiene que aumentar al que esta puesto en la automatización
                    ////para el numOficio = 1 que sea mayor a 2
                    ////para el numOficio = 2 que sea mayor a 502
                    mainPage120404.montoAmpliar.sendKeys("2");//Aumentar cada que se haga una prueba
                    mainPage120404.btnGuardarSoli.click();
                    mainPage120404.btnContinuar.click();
                    mainPage120404.btnAdjuntarDoc.click();
                    mainPage120404.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");Selenide.sleep(100);
                    mainPage120404.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");Selenide.sleep(100);
                    mainPage120404.btnAdjuntar.click();sleep(1000);
                    mainPage120404.btnCerrar.click();
                    mainPage120404.btnSiguiente.click();

                    //Firmar Tramite
                    loginFirmSoli.firma(tramite120404);
                    String folioText = mainPage120404.folio.getText();
                    ObtenerFolio var10000 = obtenerFolio;
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
                    /////Hay que autorizar todo el tramite para que se pueda volver a correr la automatizacion////
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

    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{Condition.visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}
