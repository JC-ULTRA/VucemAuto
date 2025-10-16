package SENER.Tramite130121;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SENER.Tramite130121.MainPage130121;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130121Test {
    MainPage130121 mainPage130121 = new MainPage130121();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130121  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130121fun  = new TramitesFirmasLG(
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
    public void Proceso130121() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130121");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130121");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130121");

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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130121);
            mainPage130121.selecRol.sendKeys("Persona Moral");
            mainPage130121.btnacep.click();
            mainPage130121.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130121.SoliNew.click();
            mainPage130121.Sener.click();
            mainPage130121.linkPermisoImportExport.click();
            mainPage130121.linkImportacion.click();
            mainPage130121.linkSolImpHidros.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage130121.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130121.labelDatosSolicitud.click();
            mainPage130121.selectRegimenClave.sendKeys("Definitivos");
            mainPage130121.selectClasificacionRegimen.sendKeys("De importación");
            //mainPage130121.inputCortoPlazo.click();
            mainPage130121.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
            mainPage130121.inputCveFraccionArancelaria.sendKeys("27102001");
            mainPage130121.inputNICO.sendKeys("00");
            mainPage130121.inputCantidadMercancia.sendKeys("50000");
            mainPage130121.inputValorFactura.sendKeys("100000");
            mainPage130121.inputCantidad.sendKeys("50000");
            mainPage130121.inputDescripcion.sendKeys("PRUEBA QA");
            mainPage130121.inputValorPArtida.sendKeys("100000");
            mainPage130121.btnAgregarPartida.click();sleep(500);
            mainPage130121.btnPaises.click();sleep(1000);
            mainPage130121.inputPaisOrigen.sendKeys("AND");sleep(1000);
            mainPage130121.btnAgregar.click();sleep(1000);
            mainPage130121.inputPaisOrigen.sendKeys("JPN");sleep(1000);
            mainPage130121.btnAgregar.click();sleep(1000);
            //mainPage130121.inputPaisOrigen.sendKeys("PER");sleep(1000);
            //mainPage130121.btnAgregar.click();sleep(1000);
            mainPage130121.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
            mainPage130121.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130121.textareaObservaciones.sendKeys("PRUEBAS QA");
            mainPage130121.inputDeclaracion.click();
            mainPage130121.btnGuarda.click();sleep(1000);
            mainPage130121.btnContinuar.click();sleep(1000);
            //mainPage130121.inputGuarda.click();
            metodos.cargarDocumentos();
            mainPage130121.btnAnexar.click();sleep(32000);
            mainPage130121.btnCerrar.click();sleep(3000);
            //GUARDAR

            mainPage130121.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130121);
            String folioText = mainPage130121.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    System.out.println("Iniciando ProcesoDictamen...");
                    ProcesoDictamen(folioNumber);
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
    public void ProcesoDictamen(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130121fun);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        // Búsqueda de Folio
        mainPage130121.iniciofun.click();
        mainPage130121.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage130121.btnBuscarFolio.click();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage130121.justificacionDictamen.sendKeys("PRUEBAS QA");
        mainPage130121.antecedentesDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        $("input[type='submit'][value='Firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite130121fun);sleep(1000); sleep(4000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130121.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130121.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite130121fun);sleep(4000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite130121);
        mainPage130121.selecRol.sendKeys("Persona Moral");
        mainPage130121.btnacep.click();
        mainPage130121.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage130121.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite130121);sleep(1000);sleep(4000);
    }
    
    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}