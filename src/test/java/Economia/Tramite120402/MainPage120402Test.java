package Economia.Tramite120402;
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
public class MainPage120402Test {
    MainPage120402 mainPage120402 = new MainPage120402();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    TramitesFirmasLG tramite120402 = new TramitesFirmasLG(
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
    public void Proceso120402() {
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
                this.ejecutarProcesoNRunnable(() -> {
                    String uuid = UUID.randomUUID().toString();
                    int longitudDeseada = 16;
                    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
                    loginFirmSoli.login(tramite120402);
                    this.mainPage120402.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    Selenide.sleep(1000L);
                    this.mainPage120402.SoliNew.click();
                    Selenide.sleep(1000L);
                    this.mainPage120402.economia.click();
                    this.mainPage120402.cuposImpExp.click();
                    this.mainPage120402.asignacionDirecta.click();
                    this.mainPage120402.asignacionPersonaM.click();
                    JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    this.mainPage120402.asignacion.click();
                    this.mainPage120402.entidadFed.sendKeys(new CharSequence[]{"CHIHUAHUA"});
                    this.mainPage120402.representacionFed.sendKeys(new CharSequence[]{"CIUDAD JUAREZ"});
                    this.mainPage120402.regimenAduanero.sendKeys(new CharSequence[]{"Exportación"});
                    this.mainPage120402.btnBuscar.click();
                    this.mainPage120402.selecCupo.doubleClick();
                    this.mainPage120402.cantidadSolicitada.sendKeys(new CharSequence[]{"500"});
                    this.mainPage120402.continuarSoli.click();
                    this.mainPage120402.btnSiguiente.click();
                    this.mainPage120402.btnCargarArchivos.click();
                    this.mainPage120402.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    this.mainPage120402.adjuntar.click();
                    Selenide.sleep(2000L);
                    this.mainPage120402.btnCerrar.click();
                    this.mainPage120402.btnContinuar.click();
//                    loginFirmSoli.firma(tramite120402);
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