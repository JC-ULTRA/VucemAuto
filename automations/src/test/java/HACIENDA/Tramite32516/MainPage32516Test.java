package HACIENDA.Tramite32516;

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

public class MainPage32516Test {
    MainPage32516 mainPage32516 = new MainPage32516();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32516  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite32516fun = new TramitesFirmasLG(
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
    public void Proceso32516() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen270201");
        JCheckBox verificaCheckBox = new JCheckBox("ProcesoVerifica270201");
        JCheckBox autorizaCheckBox = new JCheckBox("ProcesoAutoriza270201");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmar270201");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificaCheckBox, autorizaCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen270201");
        if (verificaCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica270201");
        if (autorizaCheckBox.isSelected()) selectedMethods.add("ProcesoAutoriza270201");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar270201");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32516);
            mainPage32516.selecRol.sendKeys("Persona Moral");
            mainPage32516.btnacep.click();
            mainPage32516.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32516.SoliNew.click();
            mainPage32516.HACIENDA.click();
            mainPage32516.linkRegistroComercioExterior.click();
            $(withText("Envío de Avisos")).click();
            $(withText("Acta de hechos")).click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32516.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32516.labelTipoAviso.click();
            mainPage32516.inputActaHechos.sendKeys("Acta de hechos 4.2.8 de las RGCE: Aviso de la destruccion de mercancías importadas temporalmente para competencias y eventos de automovilismo deportivo");
            mainPage32516.inputAcudioADACENo.click();
            mainPage32516.inputADACECorresponde.sendKeys("Centro");
            mainPage32516.inputIDTransaccionSi.click();
            mainPage32516.inputNumeroIMMEX.sendKeys("5234");
            mainPage32516.btnAgregarMercancia.click();
            mainPage32516.inputConsecutivo.sendKeys("369");
            mainPage32516.inputDescripcion.sendKeys("PRUEBA");
            mainPage32516.inputCantidad.sendKeys("1234");
            mainPage32516.inputUnidadMedida.sendKeys("Kilogramo");
            mainPage32516.inputPeso.sendKeys("10");
            mainPage32516.btnAgregar.click();

            mainPage32516.InputGuardarSolicitud.click();
            mainPage32516.btnContinuar.click();sleep(5000);
            metodos.cargarDocumentos();
            mainPage32516.btmAnexar.click();sleep(8000);
            mainPage32516.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage32516.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite32516);
            String folioText = mainPage32516.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

            if (selectedMethods.contains("ProcesoDictamen32516")) {
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica32516")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoAutoriza32516")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmar32516")) {
                ProcesoConfirmar(folioNumber);
            } guardarFolioEnArchivo(folioNumber);

        }, repeticiones);
    }
    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite32516fun);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage32516.iniciofun.click();
        mainPage32516.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage32516.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage32516.inputDictamenAceptado.click();
        mainPage32516.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite32516fun);sleep(4000);
    }

    public void VerificaDictamen(String folioNumber) {
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage32516.iniciofun.click();
        mainPage32516.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage32516.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage32516.btnFirmarAutorizacion.click();sleep(5000);
        loginFirmSoli.firmaFun(tramite32516fun);sleep(4000);
    }

    public void AutorizarDictamen(String folioNumber) {
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage32516.iniciofun.click();
        mainPage32516.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage32516.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage32516.btnFirmarAutorizacion.click();sleep(5000);
        loginFirmSoli.firmaFun(tramite32516fun);sleep(4000);
    }

    public void ProcesoConfirmar(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.login(tramite32516);sleep(3000);
        mainPage32516.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage32516.Btnacep.click();
        mainPage32516.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(5000);
        loginFirmSoli.firma(tramite32516);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados32516.txt";

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