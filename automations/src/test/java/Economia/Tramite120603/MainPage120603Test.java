package Economia.Tramite120603;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite120603.MainPage120603;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage120603Test {
    MainPage120603 mainPage120603 = new MainPage120603();
    Metodos metodos = new Metodos();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite120603  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\zcf030121rp0.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\ZCF030121RP0_1012231215.key"
    );
    TramitesFirmasLG tramite120603Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso120603() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion");

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
            loginFirmSoli.login(tramite120603);
//            mainPage120603.selecRol.sendKeys("Persona Moral");
//            mainPage120603.btnacep.click();
            $("#Trámites").click();
            $(byText("Solicitudes nuevas")).click();
            $(byAttribute("alt", "Secretaría de Economía")).click();
            $(byText("Cupos de Importación y Exportación")).click();
            $(byText("Registro de Empresa Comercial e Industria Fronteriza")).click();
            $(byText("Registro como Empresa de la Región Chetumal")).click();
            metodos.scrollDecremento(1);
            mainPage120603.PestDatEmpres.click();
            mainPage120603.Estado.sendKeys("QUINTANA ROO");sleep(1000);
            mainPage120603.CargarDatosDomicilio.doubleClick();
            mainPage120603.TipoEmpresa.sendKeys("OTROS SERVICIOS");sleep(500);
            mainPage120603.Especifique.sendKeys("OTROS SERVICIOS");sleep(500);
            mainPage120603.Clasif.sendKeys("1112");sleep(500);
            mainPage120603.ClickFuera.click();
            mainPage120603.btnContinuar.click();
            mainPage120603.btnContinuarArchivos.click();
            metodos.cargarDocumentos();
            mainPage120603.btnAdjuntar.click();sleep(10000);
            mainPage120603.btnCerrar.click();
            mainPage120603.btnSiguiente.click();
            //firmas
            loginFirmSoli.firma(tramite120603);
            String folioText = mainPage120603.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

           ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

////             Ejecutar métodos seleccionados
            if (selectedMethods.contains("ProcesoDictamen")) {
                ProcesoProgramarVisita(folioNumber);sleep(1000);
                ProcesoRegistrarOpinion(folioNumber);sleep(1000);
                ProcesoDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoAutorizacion")) {
                ProcesoAutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                ProcesoConfirmarNotificacion(folioNumber);
            }

        }, repeticiones);

    }
    public void ProcesoProgramarVisita (String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120603Fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage120603.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage120603.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarOpinion=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        mainPage120603.numOficio.sendKeys("123456789");
        mainPage120603.btnGuardarVisita.click();
    }
    public void ProcesoRegistrarOpinion (String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120603Fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage120603.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage120603.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", " Registrar Opinion")).doubleClick();
        mainPage120603.btnSiguienteOpinion.click();
        mainPage120603.btnAnexarDocumentos.click();
        mainPage120603.doc1AnexarOpinion.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage120603.doc2AnexarOpinion.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage120603.btnAdjuntarOpinion.click();sleep(5000);
        mainPage120603.btnCerrarOpinion.click();
        mainPage120603.guardarOpinion.click();
        loginFirmSoli.firmaFun(tramite120603Fun);
    }
    public void ProcesoDictamen(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120603Fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage120603.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage120603.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage120603.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage120603.btnFirmarDictamen.click();
        loginFirmSoli.firmaFun(tramite120603Fun);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120603Fun);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage120603.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage120603.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage120603.btnFirmarAutorizar.click();
        loginFirmSoli.firmaFun(tramite120603Fun);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite120603);
        mainPage120603.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage120603.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite120603);sleep(1000);sleep(4000);
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