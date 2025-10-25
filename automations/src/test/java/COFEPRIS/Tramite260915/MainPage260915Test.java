package COFEPRIS.Tramite260915;

import COFEPRIS.Tramite260215.MainPage260215Test;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260915Test {
    Metodos metodos = new Metodos();
    MainPage260915 mainPage260915 = new MainPage260915();
    MainPage260215Test mainPage260215Test = new MainPage260215Test();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260915  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260915Fun  = new TramitesFirmasLG(
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
    public void Proceso260915() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260915");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260915");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260915");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            String FolioRubro = mainPage260215Test.RetornoFolio();
            setUpAll();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            /// Fecha del dia
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260915);
            mainPage260915.selecRol.sendKeys("Persona Moral");
            mainPage260915.btnacep.click();
            mainPage260915.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260915.soliSubsecuente.click();
            mainPage260915.folioTramite.sendKeys(FolioRubro);
            mainPage260915.btnBuscarFolio.click();sleep(1000);
            mainPage260915.tablaFolios.doubleClick();
            mainPage260915.btnModificar.click();
            /// Datos de la Solicitud
            mainPage260915.datosSolicitud.click();
            mainPage260915.tipoModificacion.click();
            mainPage260915.justificacionModificacion.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage260915.mercanciaAModificar.click();
            mainPage260915.modificarMercancia.click();
            mainPage260915.clasificacionMod.sendKeys("BIOLOGICOS");
            mainPage260915.especificarClasificacionMod.sendKeys("I. Toxoides");
            mainPage260915.denominacionEspecifica.sendKeys(" Pruebas");
            mainPage260915.denominacionDistintiva.sendKeys(" Pruebas");
            mainPage260915.nombreCientifico.doubleClick();
            mainPage260915.nombreCientifico.sendKeys("Nombre Cientifico");
            mainPage260915.tipoProducto.sendKeys("Materia prima");
            mainPage260915.estadoFisico.sendKeys("Solido");
            mainPage260915.fraccionArancelaria.doubleClick();
            mainPage260915.fraccionArancelaria.sendKeys("30039014");
            mainPage260915.umtCantidad.sendKeys("0");
            mainPage260915.umcCantidad.sendKeys("0");
            mainPage260915.umcTipo.sendKeys("Bolsa");
            mainPage260915.presentacion.setValue("Bolsas Prueba");
            mainPage260915.paisOrigenMod.click();
            mainPage260915.quitarPaisO.click();
            mainPage260915.selecPaisO.click();
            mainPage260915.agregarPaisO.click();
            mainPage260915.paisProcedenciaMod.click();
            mainPage260915.quitarPaisProc.click();
            mainPage260915.selecPaisProc.click();
            mainPage260915.agregarPaisProc.click();
            mainPage260915.usoEspecifico.click();
            mainPage260915.btnModificarMercancia.click();
            mainPage260915.rfcRepresentante.sendKeys("LEQI8101314S7");
            mainPage260915.buscarRfc.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage260915.tercerosRelacionados.click();
            mainPage260915.selecFabricante.click();
            mainPage260915.modFabricante.click();
            mainPage260915.modRSocial.setValue("FABRICANTE PRUEBAS");
            mainPage260915.codigoPostalMod.sendKeys("16000");
            mainPage260915.coloniaEquivalente.sendKeys("COLONIA");
            mainPage260915.calleMod.setValue("CALLE DE PRUEBA");
            mainPage260915.guardarMod.click();
            mainPage260915.selecDestinatarioFinal.click();
            mainPage260915.modDestinatario.click();
            mainPage260915.modRSocial.setValue("DESTINATARIO PRUEBAS");
            mainPage260915.codigoPostalMod.sendKeys("06101");
            mainPage260915.calleMod.setValue("CALLE PRUEBA");
            mainPage260915.guardarMod.click();
            mainPage260915.selecProveedor.click();
            mainPage260915.modProveedor.click();
            mainPage260915.calleMod.setValue("CALLE PRUEBA");
            mainPage260915.guardarMod.click();
            mainPage260915.selecFacturador.click();
            mainPage260915.modFacturador.click();
            mainPage260915.modRSocial.setValue("FACTURADOR PRUEBA");
            mainPage260915.calleMod.setValue("CALLE PRUEBA");
            mainPage260915.guardarMod.click();
            /// Pago de Derechos
            scrollDecremento();
            mainPage260915.pagoDerechos.click();
            mainPage260915.claveReferencia.sendKeys("81228649");
            mainPage260915.cadenaDepenedencia.sendKeys("123456");
            mainPage260915.banco.sendKeys("BANAMEX");
            mainPage260915.llavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260915.fechaPago, fechaHoy);sleep(1000);
            mainPage260915.importePago.sendKeys("1000");

            mainPage260915.btnGuardarSoli.click();
            mainPage260915.btnContinuar.click();
            mainPage260915.btnAdjuntarDoc.click();
            mainPage260915.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260915.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260915.btnAdjuntar.click();sleep(1000);
            mainPage260915.btnCerrar.click();
            mainPage260915.btnSiguiente.click();
            loginFirmSoli.firma(tramite260915);

            // Obtener el texto del folio desde mainPage260915
            String folioText = mainPage260915.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    ProcesoVerificarDictamen(folioNumber);
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
    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite260915Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260915.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260915.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260915.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260915Fun);sleep(5000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260915.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260915.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260915.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260915Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260915.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260915.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260915.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260915Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260915);
        mainPage260915.selecRol.sendKeys("Persona Moral");
        mainPage260915.btnacep.click();
        mainPage260915.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260915.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260915);sleep(1000);sleep(4000);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 3; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
}

