package HACIENDA.Tramite32502;
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
public class MainPage32502Test {
    MainPage32502 mainPage32502 = new MainPage32502();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32502 = new TramitesFirmasLG(
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
    public void Proceso30502() {
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
                    loginFirmSoli.login(tramite32502);
                    mainPage32502.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage32502.btnacep.click();
                    mainPage32502.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage32502.SoliNew.click();
                    mainPage32502.hacienda.click();
                    mainPage32502.registrosComercioExt.click();
                    mainPage32502.envioAvisos.click();
                    mainPage32502.avisoImpTemporal106.click();
                    mainPage32502.aviso.click();
                    mainPage32502.razonImportador.sendKeys(new CharSequence[]{"PRUEBAS"});
                    mainPage32502.rfcImportador.sendKeys(new CharSequence[]{"QAQA1234567P8"});
                    mainPage32502.taxID.sendKeys(new CharSequence[]{"12345678Z"});
                    mainPage32502.fracArancelaria.sendKeys(new CharSequence[]{"01013001 - Asnos."});
                    mainPage32502.fracRegla.sendKeys(new CharSequence[]{"III"});
                    mainPage32502.NICO.sendKeys(new CharSequence[]{"00"});
                    mainPage32502.valorUSD.sendKeys(new CharSequence[]{"1000"});
                    mainPage32502.marca.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage32502.pesoKG.sendKeys(new CharSequence[]{"12"});
                    mainPage32502.fechaImport.click();
                    mainPage32502.selecFecha.click();
                    mainPage32502.numSerie.sendKeys(new CharSequence[]{"123456"});
                    mainPage32502.descripcionMerc.sendKeys(new CharSequence[]{"PRUEBA1"});
                    mainPage32502.nombreComercial.sendKeys(new CharSequence[]{"QA"});
                    mainPage32502.entidad.click();
                    mainPage32502.entidad.sendKeys(new CharSequence[]{"SINALOA"});
                    Selenide.sleep(1000L);
                    mainPage32502.municipio.click();
                    mainPage32502.municipio.sendKeys(new CharSequence[]{"CULIACAN"});
                    Selenide.sleep(1000L);
                    mainPage32502.colonia.click();
                    mainPage32502.colonia.sendKeys(new CharSequence[]{"5 DE MAYO"});
                    Selenide.sleep(1000L);
                    mainPage32502.calle.sendKeys(new CharSequence[]{"ARROYO"});
                    mainPage32502.numExt.sendKeys(new CharSequence[]{"1157"});
                    mainPage32502.numInt.sendKeys(new CharSequence[]{"1"});
                    mainPage32502.CP.sendKeys(new CharSequence[]{"80230"});
                    mainPage32502.patenteAgenteA.sendKeys(new CharSequence[]{"4321"});
                    mainPage32502.rfcAgente.sendKeys(new CharSequence[]{"ABCD654321A2V"});
                    mainPage32502.numPedimento.sendKeys(new CharSequence[]{"1234567"});
                    mainPage32502.aduanaImp.sendKeys(new CharSequence[]{"ALTAMIRA"});
                    mainPage32502.manifiesto.click();
                    mainPage32502.btnContinuar.click();
                    mainPage32502.btnArchivos.click();
                    mainPage32502.btnCargarArch.click();
                    mainPage32502.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage32502.adjuntarArchivos.click();
                    Selenide.sleep(13000L);
                    mainPage32502.btnCerrar.click();
                    mainPage32502.btnSiguiente.click();
                    loginFirmSoli.firma(tramite32502);
                    String folioText = mainPage32502.folio.getText();
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
