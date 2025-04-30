package HACIENDA.Tramite32501;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32501.MainPage32501;
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
import java.util.UUID;

public class MainPage32501Test {
    MainPage32501 mainPage32501 = new MainPage32501();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32501 = new TramitesFirmasLG(
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
                    loginFirmSoli.login(tramite32501);
                    mainPage32501.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage32501.btnacep.click();
                    mainPage32501.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage32501.SoliNew.click();
                    mainPage32501.hacienda.click();
                    mainPage32501.registrosComercioExt.click();
                    mainPage32501.envioAvisos.click();
                    mainPage32501.avisoImpDivMomMerDesMon.click();
                    mainPage32501.aviso.click();
                    mainPage32501.inputTipoAvisoImp.click();
                    mainPage32501.fracArancelaria.sendKeys(new CharSequence[]{"01013001 - Asnos."});
                    mainPage32501.inputNICO.sendKeys("00");
                    mainPage32501.pesoKG.sendKeys(new CharSequence[]{"12"});
                    mainPage32501.valorUSD.sendKeys(new CharSequence[]{"1000"});
                    mainPage32501.descripcionMercancia.sendKeys("PRUEBAS QA");
                    mainPage32501.nombreComercial.sendKeys(new CharSequence[]{"QA"});
                    mainPage32501.entidadFederativa.sendKeys("GUERRERO");
                    mainPage32501.alcaldiaMunicipio.sendKeys("APAXTLA");
                    mainPage32501.colonia.sendKeys("CENTRO");
                    mainPage32501.calle.sendKeys(new CharSequence[]{"ARROYO"});
                    mainPage32501.numExt.sendKeys(new CharSequence[]{"1157"});
                    mainPage32501.numInt.sendKeys(new CharSequence[]{"1"});
                    mainPage32501.CodigoPostal.sendKeys(new CharSequence[]{"80230"});

//                    mainPage32501.razonImportador.sendKeys(new CharSequence[]{"PRUEBAS"});
//                    mainPage32501.rfcImportador.sendKeys(new CharSequence[]{"QAQA1234567P8"});
//                    mainPage32501.taxID.sendKeys(new CharSequence[]{"12345678Z"});
//                    mainPage32501.fracRegla.sendKeys(new CharSequence[]{"III"});
//                    mainPage32501.NICO.sendKeys(new CharSequence[]{"00"});
//                    mainPage32501.marca.sendKeys(new CharSequence[]{"PRUEBA"});
//                    mainPage32501.fechaImport.click();
//                    mainPage32501.selecFecha.click();
//                    mainPage32501.numSerie.sendKeys(new CharSequence[]{"123456"});
//                    mainPage32501.descripcionMerc.sendKeys(new CharSequence[]{"PRUEBA1"});
//                    mainPage32501.entidad.click();
//                    mainPage32501.entidad.sendKeys(new CharSequence[]{"SINALOA"});
//                    Selenide.sleep(1000L);
//                    mainPage32501.municipio.click();
//                    mainPage32501.municipio.sendKeys(new CharSequence[]{"CULIACAN"});
//                    Selenide.sleep(1000L);
//                    mainPage32501.colonia.click();
//                    mainPage32501.colonia.sendKeys(new CharSequence[]{"5 DE MAYO"});
//                    Selenide.sleep(1000L);
//                    mainPage32501.patenteAgenteA.sendKeys(new CharSequence[]{"4321"});
//                    mainPage32501.rfcAgente.sendKeys(new CharSequence[]{"ABCD654321A2V"});
//                    mainPage32501.numPedimento.sendKeys(new CharSequence[]{"1234567"});
//                    mainPage32501.aduanaImp.sendKeys(new CharSequence[]{"ALTAMIRA"});
//                    mainPage32501.manifiesto.click();
                    mainPage32501.btnContinuar.click();
                    mainPage32501.btnArchivos.click();
                    mainPage32501.btnCargarArch.click();
                    mainPage32501.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    mainPage32501.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500);
                    //mainPage32501.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    //Selenide.sleep(500L);
                    mainPage32501.adjuntarArchivos.click();
                    Selenide.sleep(2000);
                    mainPage32501.btnCerrar.click();
                    mainPage32501.btnSiguiente.click();Selenide.sleep(500);
                    loginFirmSoli.firma(tramite32501);
                    String folioText = mainPage32501.folio.getText();
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
