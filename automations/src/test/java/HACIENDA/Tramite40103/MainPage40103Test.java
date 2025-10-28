package HACIENDA.Tramite40103;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
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
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage40103Test {
    MainPage40103 mainPage40103 = new MainPage40103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite40103 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
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
//                    mainPage40103.selecRol.sendKeys("Persona Moral");sleep(1000);
//                    mainPage40103.btnacep.click();sleep(1000);
                    $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
                    $(withText("Solicitudes nuevas")).click();sleep(1000);
                    $("[alt='Administración General de Aduanas']").click();sleep(1000);
                    $$(By.cssSelector("a[href='#']")).findBy(text("Registro del Código Alfanumérico Armonizado del Transportista")).click();sleep(1000);
                    $$(By.cssSelector("a[href='#']")).findBy(text("Registro del Código Alfanumérico Armonizado del Transportista (Transportista Terrestre)")).click();sleep(1000);
                    mainPage40103.Tramite40103.click();sleep(1000);
                    mainPage40103.choferes.click();sleep(1000);
                    mainPage40103.nuevoChofer.click();sleep(1000);
                    mainPage40103.curpChofer.sendKeys(new CharSequence[]{"MAVD940219MDFRLN06"});sleep(1000);
                    mainPage40103.rfcChofer.sendKeys(new CharSequence[]{"MAVD940219MDFR"});sleep(1000);
                    mainPage40103.buscarChofer.click();sleep(1000);

                    metodos.scrollIncremento(1);
                    $$("button").findBy(Condition.exactText("Aceptar")).click();

                    $("[id='calleCHN']").sendKeys("QA 1");sleep(1000);
                    $("[id='numeroExteriorCHN']").sendKeys("2");sleep(1000);
                    $("[id='numeroExteriorCHN']").sendKeys("2");sleep(1000);

                    mainPage40103.entidadChofer.sendKeys(new CharSequence[]{"DURANGO"});sleep(1000);
                    mainPage40103.municipioChofer.sendKeys(new CharSequence[]{"DURANGO"});sleep(1000);
                    mainPage40103.coloniaChofer.sendKeys(new CharSequence[]{"PORFIRIO DIAZ"});sleep(1000);
                    mainPage40103.paisChofer.sendKeys(new CharSequence[]{"MEXICO"});sleep(1000);
                    mainPage40103.ciudadChofer.sendKeys(new CharSequence[]{"PORFIRIO DIAZ"});sleep(1000);
                    mainPage40103.localidadChofer.sendKeys(new CharSequence[]{"DURANGO"});sleep(1000);
                    mainPage40103.cpChofer.sendKeys(new CharSequence[]{"34260"});sleep(1000);
                    SelenideElement botonGuardar = $("#guardarChofer");
                    try {
                        botonGuardar.shouldBe(Condition.enabled, Duration.ofSeconds(5)).click();
                    } catch (Exception e) {
                        executeJavaScript("arguments[0].click();", botonGuardar);
                    }

                    mainPage40103.vehiculos.click();sleep(1000);
                    mainPage40103.nuevoVehiculoP.click();sleep(1000);
                    mainPage40103.vinVehiculo.sendKeys(new CharSequence[]{"12345678912345678"});sleep(1000);
                    mainPage40103.tipoVehiculo.sendKeys(new CharSequence[]{"TANQUE 20"});sleep(1000);
                    mainPage40103.numPlaca.sendKeys(new CharSequence[]{"123FGH"});sleep(1000);
                    mainPage40103.paisEmisor.sendKeys(new CharSequence[]{"MEXICO (ESTADOS UNIDOS MEXICANOS"});sleep(1000);
                    mainPage40103.estadoVehiculo.sendKeys(new CharSequence[]{"CIUDAD DE MEXICO"});sleep(1000);
                    mainPage40103.marcaVehiculo.sendKeys(new CharSequence[]{"SUSUKI"});sleep(1000);
                    mainPage40103.modeloVehiculo.sendKeys(new CharSequence[]{"IGNIS"});sleep(1000);
                    mainPage40103.añoVehiculo.sendKeys(new CharSequence[]{"2023"});sleep(1000);
                    mainPage40103.transponderVehiculo.sendKeys(new CharSequence[]{"n/a"});sleep(1000);
                    mainPage40103.colorVehiculo.sendKeys(new CharSequence[]{"ROSA"});sleep(1000);
                    mainPage40103.numEconomico.sendKeys(new CharSequence[]{"23456789"});sleep(1000);
                    SelenideElement botonVehiculo = $("#guardarVehiculo");
                    try {
                        botonVehiculo.shouldBe(Condition.enabled, Duration.ofSeconds(5)).click();
                    } catch (Exception e) {
                        executeJavaScript("arguments[0].click();", botonVehiculo);
                    }
                    mainPage40103.vehiculoArrastre.click();sleep(1000);
                    mainPage40103.nuevoVehiculoA.click();sleep(1000);
                    mainPage40103.vinVehiculoA.sendKeys(new CharSequence[]{"12345678912345678"});sleep(1000);
                    mainPage40103.tipoVehiculoA.sendKeys(new CharSequence[]{"FLAT 20'"});sleep(1000);
                    mainPage40103.numPlacaA.sendKeys(new CharSequence[]{"456JKL"});sleep(1000);
                    mainPage40103.paisEmisorA.sendKeys(new CharSequence[]{"MEXICO (ESTADOS UNIDOS MEXICANOS"});sleep(1000);
                    mainPage40103.estadoVehiculoA.sendKeys(new CharSequence[]{"CIUDAD DE MEXICO"});sleep(1000);
                    mainPage40103.colorVehiculoA.sendKeys(new CharSequence[]{"AMARILLO"});sleep(1000);
                    mainPage40103.numEconomicoA.sendKeys(new CharSequence[]{"23467"});sleep(1000);
                    mainPage40103.guardarVehiculo.click();sleep(1000);
                    mainPage40103.guardarSoli.click();sleep(1000);
                    loginFirmSoli.firma(tramite40103);sleep(1000);
                    String folioText = mainPage40103.folio.getText();sleep(1000);
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



