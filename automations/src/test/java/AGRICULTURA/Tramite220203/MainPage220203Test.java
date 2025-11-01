package AGRICULTURA.Tramite220203;
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
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage220203Test {
    MainPage220203 mainPage220203 = new MainPage220203();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
//    String FunRFC = "MAVL621207C95";

    TramitesFirmasLG tramite220203 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    TramitesFirmasLG tramite220203fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
    public void Proceso220203() {
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

            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen220203");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion220203");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion220203");
            Object[] params = new Object[]{"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
            int option = JOptionPane.showConfirmDialog((Component)null, params, "Opciones de Métodos", 2);
            if (option != 0) {
                JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
            } else {
                this.ejecutarProcesoNRunnable(() -> {
                    String uuid = UUID.randomUUID().toString();
                    int longitudDeseada = 16;
                    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
                    loginFirmSoli.login(tramite220203);
                    mainPage220203.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage220203.btnacep.click();
                    mainPage220203.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage220203.SoliNew.click();
                    mainPage220203.agricultura.click();
                    mainPage220203.certificadosSolicitud.click();
                    mainPage220203.certificadoImportacion.click();
                    mainPage220203.SENASICA03012C.click();Selenide.sleep(5000L);
                    metodos.scrollIncremento(1);
                    $("[for='solicitud.titulo']").click();
                    mainPage220203.aduanaIngreso.sendKeys(new CharSequence[]{"ACAPULCO"});
                    mainPage220203.oficinaInspeccion.sendKeys(new CharSequence[]{"Acapulco"});
                    mainPage220203.puntoInspeccion.sendKeys(new CharSequence[]{"Acapulco Oficina de Inspección"});
                    mainPage220203.numGuia.sendKeys(new CharSequence[]{"12345"});
                    mainPage220203.regimen.sendKeys(new CharSequence[]{"Definitivos"});
                    mainPage220203.agregarMercancia.click(); Selenide.sleep(1000L);
                    mainPage220203.tipoRequisito.sendKeys(new CharSequence[]{"Número de Oficio Caso Especial"});
                    mainPage220203.requisito.sendKeys(new CharSequence[]{"1"});
                    mainPage220203.numCertificado.sendKeys(new CharSequence[]{"12"});
                    mainPage220203.fracArancelaria.sendKeys(new CharSequence[]{"01061201"}); Selenide.sleep(500L);
                    mainPage220203.NICO.sendKeys(new CharSequence[]{"00"});
                    mainPage220203.descripcion.sendKeys(new CharSequence[]{"PRUEBAS"});
                    mainPage220203.cantUMT.sendKeys(new CharSequence[]{"1"});
                    mainPage220203.cantUMC.sendKeys(new CharSequence[]{"2"});
                    mainPage220203.tipoUMC.sendKeys(new CharSequence[]{"Cabeza"});
                    mainPage220203.tipoUso.sendKeys(new CharSequence[]{"Acuacultura"});
                    mainPage220203.numLote.sendKeys(new CharSequence[]{"12345"});
                    mainPage220203.faseDesarrollo.sendKeys(new CharSequence[]{"1"});
                    mainPage220203.especie.sendKeys(new CharSequence[]{"QA"});
                    mainPage220203.paisOrigen.sendKeys(new CharSequence[]{"ANGUILA"});
                    mainPage220203.paisProcedencia.sendKeys(new CharSequence[]{"ANTARTIDA"});
                    mainPage220203.nombreCientifico.sendKeys(new CharSequence[]{"PRUEBAS QA"});
                    mainPage220203.btnAgregarDetalle.click();
                    mainPage220203.btnAgregarMercancia.click();
                    mainPage220203.datosMovilizacionN.click();
                    mainPage220203.medioTransporte.sendKeys(new CharSequence[]{"Terrestre"});
                    mainPage220203.identificacionTransporte.sendKeys(new CharSequence[]{"QA12345"});
                    mainPage220203.puntoVerificacion.sendKeys(new CharSequence[]{"REGIÓN NORTE, ALTAMIRA, TAM."});
                    mainPage220203.nombreTransportista.sendKeys(new CharSequence[]{"TRANSPORTES PRUEBA"});
                    mainPage220203.tercerosRelacionados.click();
                    mainPage220203.agregarExportador.click();
                    mainPage220203.personaMoral.click();
                    mainPage220203.razonTercero.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage220203.paisTercero.sendKeys(new CharSequence[]{"ARGELIA"});
                    mainPage220203.domicilioTercero.sendKeys(new CharSequence[]{"72 Zone d'activités, Draâ Ben Khedda, Draâ Ben Khedda, 15100"});
                    mainPage220203.ladaTercero.sendKeys(new CharSequence[]{"026"});
                    mainPage220203.telefonoTercero.sendKeys(new CharSequence[]{"1234567"});
                    mainPage220203.correoTercero.sendKeys(new CharSequence[]{"qwert@yui.op"});
                    mainPage220203.guardarTercero.click();
                    mainPage220203.agregarDestinatario.click();
                    mainPage220203.personaMoral.click();
                    mainPage220203.razonTercero.sendKeys(new CharSequence[]{"QA"});
                    mainPage220203.cpTercero.sendKeys(new CharSequence[]{"80230"});
                    mainPage220203.estadoTercero.sendKeys(new CharSequence[]{"SINALOA"});
                    mainPage220203.municipioTerceros.sendKeys(new CharSequence[]{"CULIACAN"});
                    mainPage220203.coloniaTercero.sendKeys(new CharSequence[]{"5 DE MAYO"});
                    mainPage220203.calleTercero.sendKeys(new CharSequence[]{"ARROYO"});
                    mainPage220203.numExt.sendKeys(new CharSequence[]{"1157"});
                    mainPage220203.numInt.sendKeys(new CharSequence[]{"1"});
                    mainPage220203.ladaTercero.sendKeys(new CharSequence[]{"667"});
                    mainPage220203.telefonoTercero.sendKeys(new CharSequence[]{"6671234567"});
                    mainPage220203.correoTercero.sendKeys(new CharSequence[]{"abcd123@prueba.qa"});
                    mainPage220203.guardarTercero.click();
                    mainPage220203.pagoDerechos.click();
                    mainPage220203.banco.sendKeys(new CharSequence[]{"BANAMEX"});
                    mainPage220203.llaveBanco.sendKeys(new CharSequence[]{llavePago});
                    mainPage220203.fechaPago.shouldBe(new WebElementCondition[]{Condition.visible}).click();
                    Selenide.$(Selectors.byText("20")).shouldBe(new WebElementCondition[]{Condition.visible}).click();Selenide.sleep(200L);
                    mainPage220203.btnGuardarSoli.click();
                    mainPage220203.btnSiguiente.click();
                    loginFirmSoli.firma(tramite220203);
                    String folioText = mainPage220203.folio.getText();
                    ObtenerFolio var10000 = obtenerFolio;
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);

                    if (dictamenCheckBox.isSelected()) {
                        ProcesoDictamen(folioNumber);

                        if (autorizacionCheckBox.isSelected()) {
                            AutorizarDictamen(folioNumber);

                            if (confirmacionCheckBox.isSelected()) {
                                ConfirmarNotificacion(folioNumber);
                            }
                        }
                    }

                }, repeticiones);
            }
        }
    }

    public void ProcesoDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite220203fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        $("input[name='parametrosFiltro.numFolio']").sendKeys(new CharSequence[]{folioNumber});
        $("input[id='buscarTareasFuncionario']").click();
        $$("td[role='gridcell']").findBy(attribute("title", folioNumber)).doubleClick();
        $("input[value='?mostrarDictamen=']").click();
        $("input[value='Continuar']").click();
        $("input[name='mostrarSiguiente']").click();
        $("input[value='SEDI.AC']").click();
        executeJavaScript("arguments[0].value = ''; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", $("#valueTA"));
        executeJavaScript("arguments[0].value = 'OK TEST'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", $("#valueTA"));
        $("input[name='mostrarFirma']").click();
        loginFirmSoli.firmaFun(tramite220203fun);Selenide.sleep(3000L);
        System.out.println("Dictamen firmado para el folio: " + folioNumber);
    }

    public void AutorizarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite220203fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        $("input[name='parametrosFiltro.numFolio']").sendKeys(new CharSequence[]{folioNumber});
        $("input[id='buscarTareasFuncionario']").click();
        $$("td[role='gridcell']").findBy(attribute("title", folioNumber)).doubleClick();
        $("[name='mostrarFirma']").click();
        loginFirmSoli.firmaFun(tramite220203fun);Selenide.sleep(3000L);
        System.out.println("Dictamen firmado para el folio: " + folioNumber);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        setUpAll();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        Selenide.sleep(2000);
        loginFirmSoli.login(tramite220203);
        Selenide.sleep(3000);
        mainPage220203.SelecRol.sendKeys("Persona Moral");
        Selenide.sleep(1000);
        mainPage220203.Btnacep.click();
        mainPage220203.inicioFolio.sendKeys(folioNumber);
        Selenide.sleep(2000);
        $("input[type='button'][value='Buscar']").doubleClick();
        Selenide.sleep(2000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        Selenide.sleep(2000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        Selenide.sleep(2000);
        loginFirmSoli.firma(tramite220203);
        Selenide.sleep(1000);
        System.out.println("Proceso de Confirmar Notificación completado para el folio: " + folioNumber);
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
