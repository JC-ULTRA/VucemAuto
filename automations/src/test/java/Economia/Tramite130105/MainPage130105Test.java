package Economia.Tramite130105;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130105.MainPage130105;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130105Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage130105Test.class);
    MainPage130105 mainPage130105 = new MainPage130105();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130105  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130103fun  = new TramitesFirmasLG(
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
    public void Proceso130105() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130105");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130105");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130105");

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
            // Ingreso y Rol
            loginFirmSoli.login(tramite130105);
            mainPage130105.selecRol.sendKeys("Persona Moral");
            mainPage130105.btnacep.click();
            //Búsqueda de Tramite
            mainPage130105.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130105.SoliNew.click();
            mainPage130105.economia.click();
            mainPage130105.PermisosImporExpor.click();
            mainPage130105.importacion.click();
            mainPage130105.elementoTramite130105.click(); sleep(500);
            // Hacer scroll hasta el elemento
            mainPage130105.Scrol.scrollIntoView(true);

//            try {
//                Thread.sleep(1000); // Pausa de 3 segundos
//                // Hacer scroll hasta el elemento
//                mainPage130105.Scrol.scrollIntoView(true);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //Pestaña Datos de la solicitud
            //Datos del trámite a realizar
            mainPage130105.tabDatosSolicitud.click();
            mainPage130105.selectRegimen.sendKeys("Definitivos");
            mainPage130105.selectClasificacion.sendKeys(" De importación");
            //Datos de la mercancía
            mainPage130105.radbtnProductoUsado.click();
            mainPage130105.inputDescripcion.sendKeys("PRUEBAS");
            mainPage130105.selectFraccionArancelaria.sendKeys("87037002");
            mainPage130105.inputCantidad.sendKeys("10");
            mainPage130105.inputValorFactura.sendKeys("2000");
            mainPage130105.selectUMT.sendKeys("Pieza");
            mainPage130105.inputCantidadPartida.sendKeys("10");
            mainPage130105.inputValorPartida.sendKeys("2000");
            mainPage130105.inputDescripcionPartida.sendKeys("PRUEBAS");
            mainPage130105.btnAgregarPartida.click();
            //Pais Procedencia
            mainPage130105.selectBloquePais.selectOption("T-MEC");
            mainPage130105.listaPaisProcedencia.selectOption("CANADA");
            mainPage130105.btnAgregarPais.click();
            mainPage130105.textareaUsoEspecifico.sendKeys("Uso PRUEBA");
            mainPage130105.textareaJustificacion.sendKeys("Justificación PRUEBA");
            mainPage130105.textareaObservaciones.sendKeys("Observación PRUEBAS");
            //Representación federal
            mainPage130105.selectEntidad.selectOption("SINALOA");
            mainPage130105.selectRepresentacionFederal.selectOption("CENTRAL CDMX");
            mainPage130105.btnContinuarPaso1.click();

            //Paso 2 Requisitos Necesarios
            mainPage130105.btnContinuarPaso2.click();

            //Paso 3 Anexar Requisitos
            metodos.cargarDocumentos();
            mainPage130105.btnAnexar.click();
            mainPage130105.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage130105.btnCerrar.click();sleep(1000);
            mainPage130105.btnContinuarPaso3.click();

            //Paso 4 Firmar Solicitud
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130105);

            //LLamar Metodo para obtener folio
            String folioText = mainPage130105.folio.getText();
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

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void ProcesoDictamen(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130103fun);

        // Búsqueda de Folio
        mainPage130105.iniciofun.click();
        mainPage130105.numfolio.sendKeys(folioNumber);sleep(1000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130105.btnBuscarFolio.click();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage130105.JustificacionDictamen.sendKeys("PRUEBASQA ULTRASIST");
        mainPage130105.AntecedentesDictamen.sendKeys("PRUEBASQA ULTRASIST");
        mainPage130105.btnFirmarDictamen.click();
//        $("input[type='submit'][value='Firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite130103fun);sleep(1000); sleep(4000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130105.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130105.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite130103fun);sleep(4000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite130105);
        mainPage130105.selecRol.sendKeys("Persona Moral");
        mainPage130105.btnacep.click();
        mainPage130105.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage130105.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite130105
        );sleep(1000);sleep(4000);
    }
}