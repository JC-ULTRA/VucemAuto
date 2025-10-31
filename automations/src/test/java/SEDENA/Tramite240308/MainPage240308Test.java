package SEDENA.Tramite240308;

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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240308Test {
    MainPage240308 mainPage240308 = new MainPage240308();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0602400300820254011000004";
    TramitesFirmasLG tramite240308 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite240308F = new TramitesFirmasLG(
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
    public void Proceso240308() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240308");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica240308");
        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen240308");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion240308");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox, autorizarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240308");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica240308");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen240308");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion240308");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        ejecutarProcesoNRunnable(() -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite240308);
            mainPage240308.selecRol.sendKeys("Persona Moral");
            mainPage240308.btnacep.click();
            mainPage240308.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage240308.SoliSub.click();
            mainPage240308.inputIdFolio.sendKeys("0602400100820254011000010");
            mainPage240308.inputBuscarButton.click();
            sleep(1000);
            mainPage240308.SolicitudTramite.doubleClick();
            mainPage240308.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240308.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage240308.labelDatosSolicitud.click();
            mainPage240308.inputJustificacion.sendKeys("TESTING");
            mainPage240308.inputSelectOrigen.sendKeys("ALTAMIRA");
            mainPage240308.inputRestarOrigen.click();
            mainPage240308.inputOrigenLista.sendKeys("DOS BOCAS");
            mainPage240308.inputAddOrigenLista.click();
            mainPage240308.inputPermisoGeneral.setValue("PRUEBAS MODIFICACION");
            mainPage240308.inputUsoFinalMercancia.setValue("PRUEBA MODIFICACION");
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240308.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240308.labelTercerosRelacionados.click();
            mainPage240308.chekboxDestinatario.click();
            mainPage240308.btnModificarDestinatario.click();
            mainPage240308.inputNacional.click();
            mainPage240308.inputFisica.click();
            mainPage240308.inputTerceroRFC.setValue("MAVL621207C95");
            mainPage240308.inputTercerosNombre.setValue("REGINO");
            mainPage240308.inputTercerosApellidoPaterno.setValue("RENEGADO");
            mainPage240308.inputTercerosApellidoMaterno.setValue("REYES");
            mainPage240308.inputTercerosEstado2.sendKeys("GUERRERO");
            mainPage240308.inputTercerosMunicipio.sendKeys("AZOYU");
            mainPage240308.inputTercerosLocalidad.sendKeys("BANCO DE ORO");
            mainPage240308.inputTercerosCP2.sendKeys("41909");
            mainPage240308.inputTercerosColonia.sendKeys("CENTRO");
            mainPage240308.inputTercerosCalle.setValue("CONOCIDA");
            mainPage240308.inputTercerosNumeroExt.setValue("98765");
            mainPage240308.inputTercerosNumeroInt.setValue("345");
            mainPage240308.inputTercerosLada.setValue("55");
            mainPage240308.inputTercerosTelefono.setValue("76341298");
            mainPage240308.inputTercerosCorreoElec.sendKeys("modificacion_pruebas@test.com");
            mainPage240308.btnGuardarTerceros.click();
            mainPage240308.chekboxProveedor.click();
            mainPage240308.btnModificarProveedor.click();
            mainPage240308.inputFisica.click();
            mainPage240308.inputTercerosNombre.setValue("REGINO");
            mainPage240308.inputTercerosApellidoPaterno.setValue("RENEGADO");
            mainPage240308.inputTercerosApellidoMaterno.setValue("REYES");

            mainPage240308.inputTercerosPais.sendKeys("ALEMANIA");
            mainPage240308.inputTercerosEstado.setValue("BERLIN");
            mainPage240308.inputTercerosCP.setValue("41909");
            mainPage240308.inputTercerosCalle.setValue("CONOCIDA");
            mainPage240308.inputTercerosNumeroExt.setValue("98765");
            mainPage240308.inputTercerosNumeroInt.setValue("345");
            mainPage240308.inputTercerosLada.setValue("55");
            mainPage240308.inputTercerosTelefono.setValue("76341298");
            mainPage240308.inputTercerosCorreoElec.sendKeys("modificacion_pruebas@test.com");
            mainPage240308.btnGuardarTerceros.click();

            mainPage240308.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240308.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240308.inputCadenaDependencia.setValue(factura.toString());
            mainPage240308.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240308.inputSolicitudPagoLlave.setValue(factura.toString());
            executeJavaScript("arguments[0].value = arguments[1];", mainPage240308.inputCalendar, fechaHoy);sleep(2000);
            mainPage240308.inputImportePago.sendKeys("2000");
            mainPage240308.InputGuardarSolicitud.click();
            mainPage240308.btnContinuar.click();sleep(5000);
            metodos.cargarDocumentos();
            $$(By.cssSelector("button[type='button']")).findBy(text("Adjuntar")).click();sleep(5000);
            $$(By.cssSelector("button[type='button']")).findBy(text("Cerrar")).click();sleep(4000);
            $("input[name='guardarArchivos'][value='Siguiente']").click();sleep(4000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240308);
            Selenide.sleep(2000);
            String folioText = mainPage240308.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

            if (selectedMethods.contains("ProcesoDictamen240308")) {
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica240308")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen240308")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ConfirmarNotificacion240308")) {
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
        loginFirmSoli.loginFun(tramite240308F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage240308.iniciofun.click();
        mainPage240308.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240308.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage240308.inputDictamenAceptado.click();
        mainPage240308.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage240308.inputFechaFinVig);sleep(100);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite240308F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240308.iniciofun.click();sleep(3000);
        mainPage240308.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240308.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite240308F);sleep(8000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240308.iniciofun.click();sleep(3000);
        mainPage240308.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240308.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite240308F);sleep(8000);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite240308);sleep(3000);
        mainPage240308.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage240308.Btnacep.click();
        mainPage240308.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Firmar']").click();sleep(3000);
        loginFirmSoli.firma(tramite240308);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados240308.txt";

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