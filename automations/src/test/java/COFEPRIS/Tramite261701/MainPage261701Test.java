package COFEPRIS.Tramite261701;

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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage261701Test {
    MainPage261701 mainPage261701 = new MainPage261701();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite261701 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite261701fun = new TramitesFirmasLG(
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
        getWebDriver().manage().timeouts().pageLoadTimeout(80000, TimeUnit.SECONDS);
        Configuration.timeout = 80000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso261701() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen261701");
        JCheckBox verificaCheckBox = new JCheckBox("ProcesoVerifica261701");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmar261701");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificaCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen261701");
        if (verificaCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica261701");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar261701");
        
        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite261701);
            mainPage261701.selecRol.sendKeys("Persona Moral");
            mainPage261701.btnacep.click();
            mainPage261701.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage261701.soliSubsecuente.click();
            mainPage261701.folioTramite.sendKeys(FolioRubro);
            mainPage261701.btnBuscarFolio.click();
            sleep(1000);
            mainPage261701.tablaFolios.doubleClick();
            metodos.scrollIncremento(2);
            mainPage261701.inputSolicitarCancelacion.click();
            //DATOS SOLICITUD
            $(withText("Cancelación")).click();
            sleep(2000);
            mainPage261701.textareaMotivoCancelacion.sendKeys("MOTIVO DE PRUEBA QA");
            mainPage261701.inputDeclaracion.click();
            mainPage261701.inputRFC.sendKeys("MAVL621207C95");
            mainPage261701.inputConsultarIDC.click();
            mainPage261701.inputGuardarSolicitud.click();sleep(3000);
            mainPage261701.btnContinuar.click();sleep(3000);
            metodos.cargarDocumentos();sleep(3000);
            mainPage261701.btnAdjuntar.click();sleep(15000);
            mainPage261701.btnCerrar.click();
            mainPage261701.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite261701);
            String folioText = mainPage261701.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
            if (selectedMethods.contains("ProcesoDictamen261701")) {
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica261701")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmar261701")) {
                ProcesoConfirmar(folioNumber);
            }
            guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite261701fun);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage261701.iniciofun.click();
        mainPage261701.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage261701.btnBuscarFolioR.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage261701.inputDictamenAceptado.click();
        mainPage261701.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        metodos.scrollDecremento(2);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite261701fun);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage261701.iniciofun.click();sleep(3000);
        mainPage261701.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage261701.btnBuscarFolioR.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage261701.btnFirmarAutorizacion.click();sleep(5000);
        loginFirmSoli.firmaFun(tramite261701fun);sleep(8000);
    }

    public void ProcesoConfirmar(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite261701);sleep(3000);
        mainPage261701.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage261701.Btnacep.click();
        mainPage261701.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite261701);sleep(1000);
        sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados261701.txt";

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