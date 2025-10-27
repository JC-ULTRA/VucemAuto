package SEDENA.Tramite240102;

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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240102Test {
    MainPage240102 mainPage240102 = new MainPage240102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0602400100220254011000003";
    TramitesFirmasLG tramite240102 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite240102F = new TramitesFirmasLG(
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
    public void Proceso240102() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240102");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica240102");
        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen240102");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion240102");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox, autorizarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica240102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen240102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion240102");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240102);
            mainPage240102.selecRol.sendKeys("Persona Moral");
            mainPage240102.btnacep.click();
            mainPage240102.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240102.SoliNew.click();
            mainPage240102.SEDENA.click();
            mainPage240102.linkCerLicPer.click();
            mainPage240102.linkPermisoAduanalSEDENA.click();
            mainPage240102.linkPermisoExtImpArmMunDivMatPerFisMor.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240102.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240102.labelDatosSolicitud.click();
            mainPage240102.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240102.inputAddOrigenLista.click();
            //mainPage240102.inputPermisoGeneral.sendKeys("PRUEBAS");
            mainPage240102.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240102.btnAgregarMercancia.click();
            mainPage240102.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240102.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240102.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240102.inputValorComercialMercancia.sendKeys("1234");
            mainPage240102.selectUMCMercancia.sendKeys("Caja");
            mainPage240102.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240102.inputPaisOrigenMercancia.sendKeys("ANTARTIDA");
            mainPage240102.btnAgregarPaisSeleccion.click();
            mainPage240102.btnAgregarMercancia2.click();
//            mainPage240102.inputSemestre2.click();
//            mainPage240102.inputAnoCurso.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240102.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240102.labelTercerosRelacionados.click();
            mainPage240102.btnAgregarDestinatario.click();
            mainPage240102.inputNacional.click();
            mainPage240102.inputFisica.click();
            mainPage240102.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240102.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240102.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240102.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            mainPage240102.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240102.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240102.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240102.inputTercerosCP2.sendKeys("28006");
            mainPage240102.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240102.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240102.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240102.inputTercerosNumeroInt.sendKeys("321");
            mainPage240102.inputTercerosLada.sendKeys("52");
            mainPage240102.inputTercerosTelefono.sendKeys("234565432");
            mainPage240102.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240102.btnGuardarTerceros.click();
            mainPage240102.btnAgregarProveedor.click();
            mainPage240102.inputFisica.click();
            mainPage240102.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240102.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240102.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240102.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240102.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240102.inputTercerosCP.sendKeys("23456");
            mainPage240102.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240102.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240102.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240102.inputTercerosLada.sendKeys("52");
            mainPage240102.inputTercerosTelefono.sendKeys("23456257");
            mainPage240102.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240102.btnGuardarTerceros.click();
            mainPage240102.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240102.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240102.inputCadenaDependencia.setValue(factura.toString());
            mainPage240102.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240102.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240102.inputCalendar);sleep(100);
            mainPage240102.inputImportePago.sendKeys("5000");
            mainPage240102.InputGuardarSolicitud.click();
            mainPage240102.btnContinuar.click();sleep(5000);Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240102.btmAnexar.click();sleep(4000);Selenide.sleep(8000);
            $("input[type='button'][value='Cerrar']").click();
            mainPage240102.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240102);Selenide.sleep(2000);
            String folioText = mainPage240102.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

            if (selectedMethods.contains("ProcesoDictamen240102")) {
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica240102")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen240102")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ConfirmarNotificacion240102")) {
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
        loginFirmSoli.loginFun(tramite240102F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage240102.iniciofun.click();
        mainPage240102.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240102.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage240102.inputDictamenAceptado.click();
        mainPage240102.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage240102.inputFechaFinVig);sleep(100);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite240102F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240102.iniciofun.click();sleep(3000);
        mainPage240102.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240102.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite240102F);sleep(8000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240102.iniciofun.click();sleep(3000);
        mainPage240102.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240102.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite240102F);sleep(8000);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite240102);sleep(3000);
        mainPage240102.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage240102.Btnacep.click();
        mainPage240102.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite240102);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados240102.txt";

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