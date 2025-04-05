package HACIENDA.Tramite10301;

import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.awt.Component;
import java.time.Duration;
import java.util.UUID;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPage10301Test {
    MainPage10301 mainPage10301 = new MainPage10301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    TramitesFirmasLG tramite10301 = new TramitesFirmasLG(
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
    public void Proceso10301() {
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
                    loginFirmSoli.login(tramite10301);
                    mainPage10301.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    Selenide.sleep(1000L);
                    mainPage10301.btnacep.click();
                    mainPage10301.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    Selenide.sleep(1000L);
                    mainPage10301.SoliNew.click();
                    mainPage10301.hacienda.click();
                    mainPage10301.autorizacionExpImp.click();
                    mainPage10301.exencionImpuestos.click();
                    mainPage10301.inscripcionRecibir.click();
                    Selenide.sleep(6000L);
                    JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
                    js.executeScript("function clickEnPosicion(x, y) {const evento = new MouseEvent('click', {view: window,bubbles: true,cancelable: true,clientX: x,clientY: y});const elemento = document.elementFromPoint(x, y);if (elemento) {elemento.dispatchEvent(evento);}}clickEnPosicion(755.9000358581543, 450.5874996185303);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage10301.datosTramite.click();
                    Selenide.sleep(1000L);
                    mainPage10301.manifiesto0.click();
                    mainPage10301.claveAduana.sendKeys(new CharSequence[]{"MEXICALI"});
                    mainPage10301.addMercancia.click();
                    mainPage10301.cultural.click();
                    mainPage10301.agregarMerc.click();
                    mainPage10301.tipoMerc.sendKeys(new CharSequence[]{"QA"});
                    mainPage10301.usoEspecifico.sendKeys(new CharSequence[]{"prueba"});
                    mainPage10301.condicionMerc.sendKeys(new CharSequence[]{"Nuevo"});
                    Selenide.sleep(1000L);
                    mainPage10301.btnAgregar.click();
                    Selenide.sleep(2000L);
                    mainPage10301.aceptMerc.click();
                    Selenide.sleep(1000L);
                    mainPage10301.nombreDonante.sendKeys(new CharSequence[]{"Adfgfyq"});
                    Selenide.sleep(1000L);
                    mainPage10301.calleDonante.sendKeys(new CharSequence[]{"qweqww"});
                    Selenide.sleep(1000L);
                    mainPage10301.numExtDonante.sendKeys(new CharSequence[]{"202"});
                    Selenide.sleep(1000L);
                    mainPage10301.paisDonante.sendKeys(new CharSequence[]{"Canada"});
                    Selenide.sleep(1000L);
                    mainPage10301.cpDonante.sendKeys(new CharSequence[]{"M5H 2N2"});
                    Selenide.sleep(1000L);
                    mainPage10301.estadoDonante.sendKeys(new CharSequence[]{"Ontario"});
                    Selenide.sleep(1000L);
                    mainPage10301.coloniaDonante.sendKeys(new CharSequence[]{"Toronto"});
                    Selenide.sleep(1000L);
                    mainPage10301.opcionNo.click();
                    Selenide.sleep(1000L);
                    mainPage10301.continuar.click();
                    Selenide.sleep(1000L);
                    mainPage10301.btnSig.click();
                    Selenide.sleep(1000L);
                    mainPage10301.adjuntaDocs.click();
                    Selenide.sleep(1000L);
                    mainPage10301.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(100L);
                    mainPage10301.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(100L);
                    mainPage10301.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(100L);
                    mainPage10301.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(100L);
                    mainPage10301.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(100L);
                    mainPage10301.btnAdjuntar.click();
                    Selenide.sleep(10000L);
                    mainPage10301.btnCerrar.click();
                    Selenide.sleep(1000L);
                    mainPage10301.btnContinuarArchivos.click();
                    Selenide.sleep(1000L);
                    loginFirmSoli.firma(tramite10301);
                    Selenide.sleep(1000L);
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
}
