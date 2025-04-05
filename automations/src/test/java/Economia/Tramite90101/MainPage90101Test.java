package Economia.Tramite90101;
import DBYFOLIO.ObtenerFolio;
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

public class MainPage90101Test {
    MainPage90101 mainPage90101 = new MainPage90101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite90101 = new TramitesFirmasLG(
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
    public void Proceso90101() {
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
                    loginFirmSoli.login(tramite90101);
                    mainPage90101.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage90101.btnacep.click();
                    mainPage90101.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage90101.SoliNew.click();
                    mainPage90101.economia.click();
                    mainPage90101.prosec.click();
                    Selenide.sleep(1000L);
                    mainPage90101.programaNuevo.click();
                    mainPage90101.productorDirecto.click();
                    Selenide.sleep(1000L);
                    mainPage90101.domiciliosPlantas.click();
                    mainPage90101.estadoPlantas.sendKeys(new CharSequence[]{"SINALOA"});
                    Selenide.sleep(1000L);
                    mainPage90101.mostrarDomicilios.click();
                    mainPage90101.seleccionaPlanta.click();
                    mainPage90101.agregarPlanta.click();
                    Selenide.sleep(1000L);
                    mainPage90101.actividadProductiva.sendKeys(new CharSequence[]{"AGRICULTURA"});
                    JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage90101.sectoresMercancias.click();
                    mainPage90101.sector.sendKeys(new CharSequence[]{"I-De la Industria Eléctrica"});
                    mainPage90101.agregarSector.click();
                    mainPage90101.selecSector.click();
                    mainPage90101.fraccionArancelaria.sendKeys(new CharSequence[]{"85389099"});
                    mainPage90101.agregarFraccion.click();
                    Selenide.sleep(1000L);
                    mainPage90101.continuarSoli.click();
                    mainPage90101.continuarArchivos.click();
                    mainPage90101.cargarArchivos.click();
                    mainPage90101.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage90101.adjuntar.click();
                    Selenide.sleep(12000L);
                    mainPage90101.btnCerrar.click();
                    mainPage90101.btnSiguiente.click();
                    loginFirmSoli.firma(tramite90101);
                    String folioText = mainPage90101.folio.getText();
                    ObtenerFolio var10000 = obtenerFolio;
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
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
