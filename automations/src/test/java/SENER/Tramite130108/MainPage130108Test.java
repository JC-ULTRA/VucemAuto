package SENER.Tramite130108;

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
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130108Test {
    MainPage130108 mainPage130108 = new MainPage130108();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130108  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130108Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130108() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
        }

        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130108");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130108");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130108");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130108");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130108");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130108");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130108);
            mainPage130108.selecRol.sendKeys("Persona Moral");
            mainPage130108.btnacep.click();
            mainPage130108.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130108.SoliNew.click();
            mainPage130108.Sener.click();
            mainPage130108.linkPermisoImportExport.click();
            mainPage130108.linkImportacion.click();
            mainPage130108.linkSolImpPetro.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage130108.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130108.labelDatosSolicitud.click();
            mainPage130108.selectRegimenClave.sendKeys("Definitivos");
            mainPage130108.selectClasificacionRegimen.sendKeys("De importación");
            mainPage130108.inputCortoPlazo.click();
            mainPage130108.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
            mainPage130108.inputCveFraccionArancelaria.sendKeys("27101299");
            mainPage130108.inputNICO.sendKeys("01");
            mainPage130108.inputCantidadMercancia.sendKeys("1");
            mainPage130108.inputValorFactura.sendKeys("1");
            mainPage130108.inputCantidad.sendKeys("1");
            mainPage130108.inputDescripcion.sendKeys("PRUEBA QA");
            mainPage130108.inputValorPArtida.sendKeys("1");
            mainPage130108.btnAgregarPartida.click();sleep(500);
            mainPage130108.btnPaises.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("CHL");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("COL");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("PER");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
            mainPage130108.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130108.textareaObservaciones.sendKeys("PRUEBAS QA");
            mainPage130108.inputDeclaracion.click();
            mainPage130108.btnGuarda.click();sleep(1000);
            mainPage130108.btnContinuar.click();sleep(1000);
            //GUARDAR
//            mainPage130108.inputGuarda.click();sleep(1000);
//            mainPage130108.inputAdjuntar.click();
//            mainPage130108.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.btnAnexar.click();sleep(20000);
//            mainPage130108.btnCerrar.click();
            mainPage130108.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130108);
            String folioText = mainPage130108.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    /// Para subsecuentes
    public String Proceso130108Subsecuente() {
        // Ingreso y selección de trámite
        loginFirmSoli.login(tramite130108);
        mainPage130108.selecRol.sendKeys("Persona Moral");
        mainPage130108.btnacep.click();
        mainPage130108.Tramites.sendKeys("Solicitudes nuevas");
        mainPage130108.SoliNew.click();
        mainPage130108.Sener.click();
        mainPage130108.linkPermisoImportExport.click();
        mainPage130108.linkImportacion.click();
        mainPage130108.linkSolImpPetro.click();

        // DATOS SOLICITUD
        try {
            Thread.sleep(2000);
            mainPage130108.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage130108.labelDatosSolicitud.click();
        mainPage130108.selectRegimenClave.sendKeys("Definitivos");
        mainPage130108.selectClasificacionRegimen.sendKeys("De importación");
        mainPage130108.inputCortoPlazo.click();
        mainPage130108.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
        mainPage130108.inputCveFraccionArancelaria.sendKeys("27101299");
        mainPage130108.inputNICO.sendKeys("01");
        mainPage130108.inputCantidadMercancia.sendKeys("1");
        mainPage130108.inputValorFactura.sendKeys("1");
        mainPage130108.inputCantidad.sendKeys("1");
        mainPage130108.inputDescripcion.sendKeys("PRUEBA QA");
        mainPage130108.inputValorPArtida.sendKeys("1");
        mainPage130108.btnAgregarPartida.click();sleep(500);
        mainPage130108.btnPaises.click();sleep(1000);
        mainPage130108.inputPaisOrigen.sendKeys("CHL");sleep(1000);
        mainPage130108.btnAgregar.click();sleep(1000);
        mainPage130108.inputPaisOrigen.sendKeys("COL");sleep(1000);
        mainPage130108.btnAgregar.click();sleep(1000);
        mainPage130108.inputPaisOrigen.sendKeys("PER");sleep(1000);
        mainPage130108.btnAgregar.click();sleep(1000);
        mainPage130108.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
        mainPage130108.textareaJustificacion.sendKeys("PRUEBA QA");
        mainPage130108.textareaObservaciones.sendKeys("PRUEBAS QA");
        mainPage130108.inputDeclaracion.click();
        mainPage130108.btnGuarda.click();sleep(1000);
        mainPage130108.btnContinuar.click();sleep(1000);
//        metodos.cargarDocumentos();
//        mainPage130108.btnAnexar.click();sleep(32000);
//        mainPage130108.btnCerrar.click();
        mainPage130108.inputSiguiente.click();

        // FIRMAR SOLICITUD y obtener el folio
        loginFirmSoli.firma(tramite130108);
        String folioText = mainPage130108.folio.getText();sleep(5000);
        String folioNumber = obtenerFolio.obtenerFolio(folioText);
        int T = 0;
        try {
            ProcesoSolicitarOpinion(folioNumber);
            try {
                ProcesoRegistrarOpinion(folioNumber);
                try {
                    ProcesoGenerarDictamen(folioNumber);
                    try {
                        ProcesoAutorizarDictamen(folioNumber);
                        try {
                            ProcesoConfirmarNotificacion(folioNumber);
                            T = 1;
                        } catch (Throwable e) {
                            T = 0;
                            e.printStackTrace();
                        }
                    } catch (Throwable e) {
                        T = 0;
                        e.printStackTrace();
                    }
                } catch (Throwable e) {
                    T = 0;
                    e.printStackTrace();
                }
            } catch (Throwable e) {
                T = 0;
                e.printStackTrace();
            }
        } catch (Throwable e) {
            T = 0;
            e.printStackTrace();
        }
        if (T == 1) {
            return folioNumber;
        } else {
            return null;
        }
    }
    public void ProcesoSolicitarOpinion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130108Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage130108.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130108.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarOpinion=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        mainPage130108.justificacionObservacion.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage130108.btnGuardarJust.click();sleep(1000);
        mainPage130108.btnEnviar.click();
    }
    public void ProcesoRegistrarOpinion(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage130108.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130108.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", " Registrar Opinion")).doubleClick();
        mainPage130108.sentidoOpinion.click();
        mainPage130108.opinion.sendKeys("AUTORIZAR PRUEBAS QA ULTRASIST");
        mainPage130108.anexarInfoDigitalizada.click();sleep(1500);
        mainPage130108.archivoAnexar.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage130108.enviarArchivo.click();sleep(3000);
        mainPage130108.cerrarArchivos.click();
        $("input[value='Guardar y firmar']").click();
        loginFirmSoli.firmaFun(tramite130108Fun); sleep(5000);
    }
    public void ProcesoGenerarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130108.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130108.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage130108.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage130108.antecedentesDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage130108.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite130108Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130108.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130108.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("input[name='mostrarFirma']").click();
        loginFirmSoli.firmaFun(tramite130108Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite130108);
        mainPage130108.selecRol.sendKeys("Persona Moral");
        mainPage130108.btnacep.click();
        mainPage130108.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage130108.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite130108);sleep(1000);sleep(4000);
    }
}

