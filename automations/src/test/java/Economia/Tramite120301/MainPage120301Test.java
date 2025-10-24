package Economia.Tramite120301;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120301Test {
    MainPage120301 mainPage120301 = new MainPage120301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite120301 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite120301F = new TramitesFirmasLG(
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
    public void Proceso120301() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen120301");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica120301");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen120301");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica120301");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            loginFirmSoli.login(tramite120301);
            mainPage120301.selecRol.sendKeys("Persona Moral");
            mainPage120301.btnacep.click();
            mainPage120301.Tramites.sendKeys("Solicitudes nuevas");
            mainPage120301.SoliNew.click();
            mainPage120301.Econom.click();
            mainPage120301.linkCuposImportacion.click();
            mainPage120301.linkExpCerEleBieTexPreVes.click();
            mainPage120301.elementoTramite120301.click();
            sleep(3000);
            // Hacer scroll hasta el elemento
            mainPage120301.Scrol.scrollIntoView(true);
            //DATOS TRAMITE
            mainPage120301.labelConstanciaRegistro.click();
            mainPage120301.btnBuscarInstrumento.click();
            mainPage120301.inputNumeroConstancia.doubleClick();
            mainPage120301.inputGuardarSolPar.click();
            metodos.scrollDecremento(1);
            //Capturar factura
            $(withText("Capturar facturas")).click();sleep(2000);
            $("input[name='mostrarAgregarFacturasTPL'][value='Agregar']").click();sleep(4000);
            String facturaRandom = "F" + (int)(Math.random() * 1000000);  // F+ número de 6 cifras
            mainPage120301.inputNumFacturaNew.sendKeys(facturaRandom);
            mainPage120301.inputCantidadTotal.sendKeys("2000");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage120301.inputFechaExp, fechaActual);
            mainPage120301.inputValorDoll.sendKeys("5");
            mainPage120301.inputRazonS.sendKeys("QWERTY");sleep(2000);
            mainPage120301.inputDomi.sendKeys("QWERTY");sleep(2000);
            mainPage120301.inputCiudad.sendKeys("NEW TEST");sleep(2000);
            mainPage120301.inputCPM.sendKeys("12345");sleep(2000);
            $("input[name='agregarFacturaTPL'][value='Agregar']").click();sleep(4000);
            //Facturas asociadas
            mainPage120301.labelFacturasAsociadas.click();
            metodos.scrollIncremento(1);
            mainPage120301.seleccionarFacturaPorAño("2025");sleep(2000);
            mainPage120301.inputCantidadAsociada.sendKeys("1");sleep(2000);
            $("input[name='agregarExpedicionFactura'][value='Asociar']").click();sleep(4000);
            metodos.scrollDecremento(3);
            //Histórico de fabricantes
            mainPage120301.labelHistoricoFabricantes.click();sleep(2000);
            mainPage120301.inputIdFabExporNo.click();sleep(2000);
            mainPage120301.inputNacional.click();sleep(2000);
            metodos.scrollIncremento(1);
            mainPage120301.next.click();sleep(2000);
            mainPage120301.inputNombreFab.click();sleep(2000);
            mainPage120301.btnSeleccionarFabricante.click();sleep(2000);
            metodos.scrollDecremento(2);
            //Importador en destino
            mainPage120301.labelImportadorDestino.click();
            mainPage120301.inputTipoIOR.selectOptionByValue("IOR.IRS");sleep(2000);
            mainPage120301.inputValor.sendKeys("23786557781");
            mainPage120301.inputRazonSocial.sendKeys("PRUEBAS QA ULTRASIST");
            mainPage120301.inputDomicilio.sendKeys("PRUEBAS");
            mainPage120301.inputCiudadN.sendKeys("QA");
            mainPage120301.inputCP.sendKeys("12345");

            //GUARDA y FIRMA
            $("input[name='guardar'][value='Continuar']").click();
            $("input[type='button'][value='Continuar']").click();
            metodos.cargarDocumentos();
            $("input[name='Adjuntar'][value='Adjuntar']").click();
            $("input[type='button'][value='Cerrar']").click();
            $("input[name='guardarArchivos'][value='Continuar']").click();
//            $("input[name='guardarArchivos'][value='Continuar']").click();
            loginFirmSoli.firma(tramite120301);sleep(2000);
            String folioText = mainPage120301.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
            if (selectedMethods.contains("ProcesoDictamen120301")) {
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica120301")) {
                VerificaDictamen(folioNumber);
            }guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite120301F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage120301.iniciofun.click();
        mainPage120301.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage120301.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage120301.inputDictamenAceptado.click();
        mainPage120301.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite120301F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage120301.iniciofun.click();sleep(3000);
        mainPage120301.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage120301.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite120301F);sleep(8000);
    }

    public void ProcesoConfirmar(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite120301);sleep(3000);
        mainPage120301.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage120301.Btnacep.click();
        mainPage120301.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite120301);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados120301.txt";

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
