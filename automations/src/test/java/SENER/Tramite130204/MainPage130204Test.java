package SENER.Tramite130204;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SENER.Tramite130204.MainPage130204;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130204Test {
    MainPage130204 mainPage130204 = new MainPage130204();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0402600901920254006000003";
    TramitesFirmasLG tramite130204 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130204F = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
        getWebDriver().manage().timeouts().pageLoadTimeout(180000, TimeUnit.SECONDS);
        Configuration.timeout = 180000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130204() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130204");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica130204");
//        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen130204");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion130204");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130204");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica130204");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen130204");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion130204");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130204);
            mainPage130204.selecRol.sendKeys("Persona Moral");
            mainPage130204.btnacep.click();
            mainPage130204.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130204.SoliNew.click();
            mainPage130204.Sener.click();
            mainPage130204.linkPermisoImportExport.click();
            mainPage130204.linkExportacion.click();
            mainPage130204.linkSolExpHidro.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage130204.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130204.labelDatosSolicitud.click();
            mainPage130204.selectRegimenClave.sendKeys("Definitivos");
            mainPage130204.selectClasificacionRegimen.sendKeys("De Exportación");
            //mainPage130204.inputCortoPlazo.click();
            mainPage130204.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
            mainPage130204.inputCveFraccionArancelaria.sendKeys("27112101");
            mainPage130204.inputNICO.sendKeys("00");
            mainPage130204.inputCantidadMercancia.sendKeys("50000");
            mainPage130204.inputValorFactura.sendKeys("100000");
            mainPage130204.inputCantidad.sendKeys("50000");
            mainPage130204.inputDescripcion.sendKeys("PRUEBA QA");
            mainPage130204.inputValorPArtida.sendKeys("100000");
            mainPage130204.btnAgregarPartida.click();sleep(500);
            mainPage130204.btnPaises.click();sleep(1000);
            mainPage130204.inputPaisOrigen.sendKeys("AND");sleep(1000);
            mainPage130204.btnAgregar.click();sleep(1000);
            mainPage130204.inputPaisOrigen.sendKeys("JPN");sleep(1000);
            mainPage130204.btnAgregar.click();sleep(1000);
            //mainPage130204.inputPaisOrigen.sendKeys("PER");sleep(1000);
            //mainPage130204.btnAgregar.click();sleep(1000);
            mainPage130204.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
            mainPage130204.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130204.textareaObservaciones.sendKeys("PRUEBAS QA");
            mainPage130204.inputDeclaracion.click();
            mainPage130204.btnGuarda.click();sleep(1000);
            mainPage130204.btnContinuar.click();sleep(1000);
            //mainPage130204.inputGuarda.click();
            metodos.cargarDocumentos();
            mainPage130204.btnAnexar.click();sleep(28000);
            Selenide.sleep(3000);
            mainPage130204.btnCerrar.click();
            //GUARDAR
            mainPage130204.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130204);Selenide.sleep(2000);Selenide.sleep(2000);
            String folioText = mainPage130204.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen130204")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica130204")) {
                VerificaDictamen(folioNumber);
            }
//            if (selectedMethods.contains("AutorizarDictamen130204")) {
//                AutorizarDictamen(folioNumber);
//            }
            if (selectedMethods.contains("ConfirmarNotificacion130204")) {
                ConfirmarNotificacion(folioNumber);
            }guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite130204F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage130204.iniciofun.click();
        mainPage130204.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage130204.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage130204.inputDictamenAceptado.click();
        mainPage130204.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        mainPage130204.inputTextoDictamen.sendKeys("TEST");
//        Selenide.executeJavaScript("arguments[0].value = '05/02/2026';",mainPage130204.inputInicioFechaVigencia);sleep(100);
        $("input[name='mostrarFirma'][value='Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite130204F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage130204.iniciofun.click();sleep(3000);
        mainPage130204.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage130204.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite130204F);sleep(8000);
    }

//    public void AutorizarDictamen(String folioNumber) {
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        String folioGenerado = folioNumber;
//        String rfcEmpleado = "MAVL621207C95";
//        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
//        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
//        mainPage130204.iniciofun.click();sleep(3000);
//        mainPage130204.numfolio.sendKeys(folioNumber);sleep(1500);
//        mainPage130204.btnBuscarFolio.click();sleep(4500);
//        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
//        $("input[name='mostrarFirma'][value='Autorizar']").click();
//        loginFirmSoli.firmaFun(tramite130204F);sleep(8000);
//    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite130204);sleep(3000);
        mainPage130204.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage130204.Btnacep.click();
        mainPage130204.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite130204);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }


    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados130204.txt";

        // Formato de fecha y hora: 2025-07-02 18:45:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(timestamp + " - " + folioNumber);
            writer.newLine();
            System.out.println("Folio guardado correctamente: " + folioNumber);
        } catch (IOException e) {
            System.err.println("Error al guardar el folio: " + e.getMessage());
        }
    }
}