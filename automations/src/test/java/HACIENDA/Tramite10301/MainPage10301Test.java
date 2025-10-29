package HACIENDA.Tramite10301;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.awt.Component;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage10301Test {
    MainPage10301 mainPage10301 = new MainPage10301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";

    TramitesFirmasLG tramite10301 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite10301Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Selenide.open();
        getWebDriver().manage().window().maximize();
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 200000;
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
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
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////-
            // Crear checkboxes
            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen10301");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion10301");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion10301");

            // Panel vertical para presentación
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Seleccione los métodos a ejecutar:"));
            panel.add(dictamenCheckBox);
            panel.add(autorizacionCheckBox);
            panel.add(confirmacionCheckBox);

            // Mostrar diálogo
            int option = JOptionPane.showConfirmDialog(null, panel, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

            // Validar opción
            if (option != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
                return;
            }

            // Recopilar los métodos seleccionados
            List<String> selectedMethods = new ArrayList<>();
            if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen10301");
            if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion10301");
            if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion10301");

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
                    metodos.scrollIncremento(1);
                    $$("button").findBy(Condition.exactText("Aceptar")).click();
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
                    metodos.cargarDocumentos();
                    Selenide.sleep(100L);
                    mainPage10301.btnAdjuntar.click();
                    Selenide.sleep(10000L);
                    mainPage10301.btnCerrar.click();
                    Selenide.sleep(1000L);
                    mainPage10301.btnContinuarArchivos.click();
                    Selenide.sleep(1000L);
                    loginFirmSoli.firma(tramite10301); sleep(1500);
                    String folioText = mainPage10301.folio.getText();sleep(1000);
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
                    ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

                //            Ejecutar métodos seleccionados
                if (selectedMethods.contains("ProcesoDictamen10301")) {
                    ProcesoDictamen10301(folioNumber);
                    ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

                    if (selectedMethods.contains("ProcesoAutorizacion10301")) {
                        ProcesoAutorizarDictamen(folioNumber);

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion10301")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                        }
                    }
                }

            }, repeticiones);
        }
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for(int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }

    //Proceso Dictamen
    public void ProcesoDictamen10301(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        setUpAll();
        loginFirmSoli.loginFun(tramite10301Fun);sleep(1500);
        mainPage10301.iniciofun.click();
        mainPage10301.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage10301.btnBuscarFolio.click();sleep(1500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(6000);
        mainPage10301.inputDictamenAceptado.click();
        $("textarea[name='tramite.dictamen.justificacion'][id='valueTA']").sendKeys("PRUEBAS QA");sleep(6000);

        mainPage10301.scrollEv.scrollIntoView(true);sleep(1000);
        mainPage10301.scrollEv.click();
        mainPage10301.scrollEv2.click();
        metodos.scrollDecremento(1);

        executeJavaScript("arguments[0].value = '" + LocalDate.now().plusDays(13).plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "';",mainPage10301.fechIni);sleep(1000);
        executeJavaScript("arguments[0].value = '" + LocalDate.now().plusDays(14).plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "';",mainPage10301.fechFin);sleep(1000);

        $("input[name='mostrarReporte'][value='Continuar']").click();sleep(1000);
        SelenideElement boton = $(By.xpath("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input[1]"));
        executeJavaScript("arguments[0].click();", boton);
        loginFirmSoli.firmaFun(tramite10301Fun);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
    }

    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage10301.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage10301.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("input[name='mostrarFirma']").click();
        loginFirmSoli.firmaFun(tramite10301Fun);sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite10301);
        mainPage10301.selecRol.sendKeys("Persona Moral");
        mainPage10301.btnacep.click();
        mainPage10301.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage10301.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite10301);sleep(1000);sleep(4000);
    }
    
    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }
}
