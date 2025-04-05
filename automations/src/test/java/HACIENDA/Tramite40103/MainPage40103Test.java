package HACIENDA.Tramite40103;
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
import org.openqa.selenium.chrome.ChromeOptions;
public class MainPage40103Test {
    MainPage40103 mainPage40103 = new MainPage40103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite40103 = new TramitesFirmasLG(
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
    public void Proceso40103() {
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
                    loginFirmSoli.login(tramite40103);
                    mainPage40103.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    Selenide.sleep(1000L);
                    mainPage40103.SoliNew.click();
                    mainPage40103.hacienda.click();
                    mainPage40103.registroCodigoAlfanumerico.click();
                    mainPage40103.transporteTerrestre.click();
                    mainPage40103.atencionModificacion.click();
                    mainPage40103.choferes.click();
                    mainPage40103.nuevoChofer.click();
                    mainPage40103.curpChofer.sendKeys(new CharSequence[]{"LEQI810131HDGSXG05"});
                    mainPage40103.rfcChofer.sendKeys(new CharSequence[]{"LEQI8101314S7"});
                    mainPage40103.buscarChofer.click();
                    mainPage40103.entidadChofer.sendKeys(new CharSequence[]{"DURANGO"});
                    mainPage40103.municipioChofer.sendKeys(new CharSequence[]{"DURANGO"});
                    mainPage40103.coloniaChofer.sendKeys(new CharSequence[]{"PORFIRIO DIAZ"});
                    mainPage40103.paisChofer.sendKeys(new CharSequence[]{"MEXICO"});
                    Selenide.sleep(500L);
                    mainPage40103.ciudadChofer.sendKeys(new CharSequence[]{"PORFIRIO DIAZ"});
                    mainPage40103.localidadChofer.sendKeys(new CharSequence[]{"DURANGO"});
                    mainPage40103.cpChofer.sendKeys(new CharSequence[]{"34260"});
                    mainPage40103.correoChofer.sendKeys(new CharSequence[]{"prueba@prue.ba"});
                    mainPage40103.telefonoChofer.sendKeys(new CharSequence[]{"5512345678"});
                    mainPage40103.guardarChofer.click();
                    mainPage40103.vehiculos.click();
                    mainPage40103.nuevoVehiculoP.click();
                    mainPage40103.vinVehiculo.sendKeys(new CharSequence[]{"12345678901234567"});
                    mainPage40103.tipoVehiculo.sendKeys(new CharSequence[]{"TANQUE 20"});
                    mainPage40103.numPlaca.sendKeys(new CharSequence[]{"123FGH"});
                    mainPage40103.paisEmisor.sendKeys(new CharSequence[]{"MEXICO (ESTADOS UNIDOS MEXICANOS"});
                    mainPage40103.estadoVehiculo.sendKeys(new CharSequence[]{"CIUDAD DE MEXICO"});
                    mainPage40103.marcaVehiculo.sendKeys(new CharSequence[]{"SUSUKI"});
                    mainPage40103.modeloVehiculo.sendKeys(new CharSequence[]{"IGNIS"});
                    mainPage40103.añoVehiculo.sendKeys(new CharSequence[]{"2023"});
                    mainPage40103.transponderVehiculo.sendKeys(new CharSequence[]{"n/a"});
                    mainPage40103.colorVehiculo.sendKeys(new CharSequence[]{"ROSA"});
                    mainPage40103.numEconomico.sendKeys(new CharSequence[]{"23456789"});
                    mainPage40103.guardarVehiculo.click();
                    mainPage40103.vehiculoArrastre.click();
                    mainPage40103.nuevoVehiculoA.click();
                    mainPage40103.vinVehiculoA.sendKeys(new CharSequence[]{"12345678901234567"});
                    mainPage40103.tipoVehiculoA.sendKeys(new CharSequence[]{"FLAT 20'"});
                    mainPage40103.numPlacaA.sendKeys(new CharSequence[]{"456JKL"});
                    mainPage40103.paisEmisorA.sendKeys(new CharSequence[]{"MEXICO (ESTADOS UNIDOS MEXICANOS"});
                    mainPage40103.estadoVehiculoA.sendKeys(new CharSequence[]{"CIUDAD DE MEXICO"});
                    mainPage40103.colorVehiculoA.sendKeys(new CharSequence[]{"AMARILLO"});
                    mainPage40103.numEconomicoA.sendKeys(new CharSequence[]{"23467"});
                    mainPage40103.guardarVehiculo.click();
                    mainPage40103.guardarSoli.click();
                    loginFirmSoli.firma(tramite40103);
                    String folioText = mainPage40103.folio.getText();
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
