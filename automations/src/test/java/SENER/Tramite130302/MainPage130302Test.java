package SENER.Tramite130302;

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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130302Test {
    MainPage130302 mainPage130302 = new MainPage130302();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramiteM = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    TramitesFirmasLG tramiteFun = new TramitesFirmasLG(
            "C:\\Vucem3.0\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\Vucem3.0\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
    public void Proceso130302() {
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


        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130302");
        //JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerificarDictamen130302");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130302");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130302");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox,  autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130302");
        //if (verificarCheckBox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen130302");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130302");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130302");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        ejecutarProcesoNRunnable(() -> {

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25 || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }

//          Ingreso y selección de trámite
            loginFirmSoli.login(tramiteM);
            mainPage130302.selecRol.sendKeys("Persona Moral");
            mainPage130302.btnacep.click();
            sleep(1000);
            mainPage130302.Tramites.click();
            $(withText("Solicitudes subsecuentes")).click();
            mainPage130302.FolioTramite.sendKeys(FolioTramiteN);
            mainPage130302.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage130302.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();
            sleep(1000);
           // mainPage130302.SolicitudTramite.doubleClick();
            mainPage130302.inputSolicitarProrroga.click();
            mainPage130302.textAreaMotivo.sendKeys("TEST");
            mainPage130302.textAreaOtrasObservaciones.sendKeys("TEST");
            mainPage130302.checkManifiesto.click();
            mainPage130302.InputGuardarSolicitud.click();
            mainPage130302.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage130302.btnAnexar.click();
            mainPage130302.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage130302.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage130302.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramiteM);
            Selenide.sleep(2000);
            String folioText = mainPage130302.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            for (String methodName : selectedMethods) {
                switch (methodName) {
                    case "ProcesoDictamen130302":
                        ProcesoDictamen(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    //case "ProcesoVerificarDictamen130302":
                    //    ProcesoVerificarDictamen(folioNumber);
                    //    break;
                    case "ProcesoAutorizacion130302":
                        ProcesoAutorizacion(folioNumber);
                        break;
                    case "ProcesoConfirmarNotificaciónResolucion130302":
                        ProcesoConfirmarNotificaciónResolucion(folioNumber, "Moral");
                        break;
                }

            }

        }, repeticiones);
    }

    public void ProcesoDictamen(String folioNumber, String sentidoDict) {

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        // Obtener la fecha de (hoy+Meses) formateada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicioVigenciaGenerado = LocalDate.now().format(formatter);
        String fechaFinVigenciaGenerado = LocalDate.now().plusDays(15).format(formatter);

        loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        // Búsqueda de Folio
        mainPage130302.iniciofun.click();
        mainPage130302.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);
        mainPage130302.inputBuscarTareasFuncionario.click();sleep(6500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        mainPage130302.generaDict.click();
        mainPage130302.btmContinuarDict.click();
        if (sentidoDict.equals("Autorizado")) {
            $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        } else if (sentidoDict.equals("Rechazado")) {
            $("input[name='sentidoDictamen'][value='SEDI.RZ']").click();
        }
        mainPage130302.JustificacionVigencia.sendKeys("QA test");
        mainPage130302.AntecedentesDictamen.sendKeys("QA sustenten dictamen");
        //executeJavaScript("arguments[0].value = arguments[1];", mainPage130302.fechaVigencia,fechaInicioVigenciaGenerado);
        $("input[type='submit'][value='Firmar']").click(); sleep(1000);
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }


    public void ProcesoVerificarDictamen (String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        //loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage130302.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage130302.inputBuscarTareasFuncionario.click();sleep(2000);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick(); sleep(3000);
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(4000);
    }


    public void ProcesoAutorizacion(String folioNumber) {

        mainPage130302.iniciofun.click();
        mainPage130302.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage130302.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion(String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramiteM); sleep(1000);
            mainPage130302.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage130302.btnacep.click();
            mainPage130302.inputNumFolio.sendKeys(folioNumber);sleep(1500);
            $("input[type='button'][value='Buscar']").click();
            metodos.scrollIncremento(1);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).shouldBe(visible).doubleClick();
            mainPage130302.btnFirmarNotificacion.click();sleep(1000);
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }

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