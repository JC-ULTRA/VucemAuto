package AGRICULTURA.Tramite220203;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220203Test {
    MainPage220203 mainPage220203 = new MainPage220203();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite220203  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite220203fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    TramitesFirmasLG tramite220203fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
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

                // Recopilar los métodos seleccionados
                List<String> selectedMethods = new ArrayList<>();
                if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
                if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
                if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");

                this.ejecutarProcesoNRunnable(() -> {
                    String uuid = UUID.randomUUID().toString();
                    int longitudDeseada = 16;
                    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
                    loginFirmSoli.login(tramite220203);
                    mainPage220203.selecRol.sendKeys("Persona Moral");
                    mainPage220203.btnacep.click();
                    mainPage220203.Tramites.sendKeys("Solicitudes nuevas");
                    mainPage220203.SoliNew.click();
                    mainPage220203.agricultura.click();
                    mainPage220203.certificadosSolicitud.click();
                    mainPage220203.certificadoImportacion.click();
                    mainPage220203.SENASICA03012C.click();
                    mainPage220203.datosSolicitud.click();
                    mainPage220203.aduanaIngreso.sendKeys("ACAPULCO");
                    mainPage220203.oficinaInspeccion.sendKeys("Acapulco");
                    mainPage220203.puntoInspeccion.sendKeys("Acapulco Oficina de Inspección");
                    mainPage220203.numGuia.sendKeys("12345");
                    mainPage220203.regimen.sendKeys("Definitivos");
                    mainPage220203.agregarMercancia.click();
                   metodos.scrollDecremento(4);
                    mainPage220203.tipoRequisito.sendKeys("Número de Oficio Caso Especial");
                    mainPage220203.requisito.sendKeys("1");
                    mainPage220203.numCertificado.sendKeys("12");
                    mainPage220203.fracArancelaria.sendKeys("01061201");
                    Selenide.sleep(500L);
                    mainPage220203.NICO.sendKeys("00");
                    mainPage220203.descripcion.sendKeys("PRUEBAS");
                    mainPage220203.cantUMT.sendKeys("1");
                    mainPage220203.cantUMC.sendKeys("2");
                    mainPage220203.tipoUMC.sendKeys("Cabeza");
                    mainPage220203.tipoUso.sendKeys("Acuacultura");
                    mainPage220203.numLote.sendKeys("12345");
                    mainPage220203.faseDesarrollo.sendKeys("1");
                    mainPage220203.especie.sendKeys("QA");
                    mainPage220203.paisOrigen.sendKeys("ANGUILA");
                    mainPage220203.paisProcedencia.sendKeys("ANTARTIDA");
                    mainPage220203.nombreCientifico.sendKeys("PRUEBAS QA");
                    mainPage220203.btnAgregarDetalle.click();
                    mainPage220203.btnAgregarMercancia.click();
                    mainPage220203.datosMovilizacionN.click();
                    mainPage220203.medioTransporte.sendKeys("Terrestre");
                    mainPage220203.identificacionTransporte.sendKeys("QA12345");
                    mainPage220203.puntoVerificacion.sendKeys("REGIÓN NORTE, ALTAMIRA, TAM.");
                    mainPage220203.nombreTransportista.sendKeys("TRANSPORTES PRUEBA");
                    metodos.scrollDecremento(1);
                    mainPage220203.tercerosRelacionados.click();
                    mainPage220203.agregarExportador.click();
                    mainPage220203.personaMoral.click();
                    mainPage220203.razonTercero.sendKeys("PRUEBA");
                    mainPage220203.paisTercero.sendKeys("ARGELIA");
                    mainPage220203.domicilioTercero.sendKeys("72 Zone d'activités, Draâ Ben Khedda, Draâ Ben Khedda, 15100");
                    mainPage220203.ladaTercero.sendKeys("026");
                    mainPage220203.telefonoTercero.sendKeys("1234567");
                    mainPage220203.correoTercero.sendKeys("qwert@yui.op");
                    mainPage220203.guardarTercero.click();
                    mainPage220203.agregarDestinatario.click();
                    mainPage220203.personaMoral.click();
                    mainPage220203.razonTercero.sendKeys("QA");
                    mainPage220203.cpTercero.sendKeys("80230");
                    mainPage220203.estadoTercero.sendKeys("SINALOA");
                    mainPage220203.municipioTerceros.sendKeys("CULIACAN");
                    mainPage220203.coloniaTercero.sendKeys("5 DE MAYO");
                    mainPage220203.calleTercero.sendKeys("ARROYO");
                    mainPage220203.numExt.sendKeys("1157");
                    mainPage220203.numInt.sendKeys("1");
                    mainPage220203.ladaTercero.sendKeys("667");
                    mainPage220203.telefonoTercero.sendKeys("6671234567");
                    mainPage220203.correoTercero.sendKeys("abcd123@prueba.qa");
                    mainPage220203.guardarTercero.click();
                    mainPage220203.pagoDerechos.click();sleep(1500);
                    mainPage220203.banco.sendKeys("BANAMEX");
                    mainPage220203.llaveBanco.sendKeys(llavePago);
                    mainPage220203.fechaPago.shouldBe(new WebElementCondition[]{Condition.visible}).click();
                    Selenide.$(Selectors.byText("20")).shouldBe(new WebElementCondition[]{Condition.visible}).click();Selenide.sleep(200L);
                    mainPage220203.btnGuardarSoli.click();
                    mainPage220203.btnSiguiente.click();
                    loginFirmSoli.firma(tramite220203);
                    String folioText = mainPage220203.folio.getText();
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
                    if (selectedMethods.contains("ProcesoDictamen")){
                        try {
                            setUpAll();
                            ProcesoGenerarDictamen(folioNumber);
                            System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                            if (selectedMethods.contains("ProcesoAutorizacion")) {
                                ProcesoAutorizarDictamen(folioNumber);
                                System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                                if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                                    ProcesoConfirmarNotificacion(folioNumber);
                                    System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                            e.printStackTrace();
                        }
                    }
                }, repeticiones);
            }
        }
    }

    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite220203fun);
        Selenide.sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage220203.numfolio.sendKeys(folioNumber);
        Selenide.sleep(5000);
        mainPage220203.btnBuscarFolioFun.doubleClick();
        Selenide.sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click(); sleep(2000);
        $("[name='mostrarSiguiente']").shouldBe(visible).click(); sleep(1500);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage220203.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        metodos.scrollDecremento(1);
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite220203fun);
        Selenide.sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage220203.numfolio.sendKeys(folioNumber);
        Selenide.sleep(5000);
        mainPage220203.btnBuscarFolioFun.doubleClick();
        Selenide.sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite220203fun);
        Selenide.sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite220203);
        mainPage220203.selecRol.sendKeys("Persona Moral");
        mainPage220203.btnacep.click();
        mainPage220203.inicioFolio.sendKeys(folioNumber);
        Selenide.sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage220203.btnContinuarConfirmacion.click();
        Selenide.sleep(1000);
        loginFirmSoli.firma(tramite220203);
        Selenide.sleep(1000);
        Selenide.sleep(4000);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for(int i = 0; i < n; ++i) {
            setUpAll();
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }

    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{Condition.visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }
}
