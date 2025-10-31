package PROFEPA.Tramite250103;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.WithText;
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

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage250103Test {
    MainPage250103 mainPage250103 = new MainPage250103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0802500100320258319000005";
    TramitesFirmasLG tramite250103 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite250103F = new TramitesFirmasLG(
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
        getWebDriver().manage().timeouts().pageLoadTimeout(19000, TimeUnit.SECONDS);
        Configuration.timeout = 19000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso250103() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen250103");
        JCheckBox confirmarCheckBox = new JCheckBox("ProcesoConfirmar250103");


        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen250103");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar250103");
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen250103");
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion250103");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite250103);
            mainPage250103.selecRol.sendKeys("Persona Moral");
            mainPage250103.btnacep.click();
            mainPage250103.Tramites.sendKeys("Solicitudes nuevas");
            mainPage250103.SoliNew.click();
            mainPage250103.PROFEPA.click();
            mainPage250103.linkCertificadosLicenciasPermisos.click();
            mainPage250103.linkRegistroVerificaci.click();
            mainPage250103.linkTarimasEmbalajesMaderaSoporteMercancia.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage250103.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage250103.labelTipoMovimiento.click();
            mainPage250103.selectSolicitudAduanasAduanaClave.sendKeys("COLOMBIA");
            mainPage250103.selectSolicitudUnidadAdministrativaRepresentacion.sendKeys("COLOMBIA");
            mainPage250103.selectSolicitudEntidadesEntidadClave.sendKeys("NUEVO LEON");
            mainPage250103.inputGuardarSolicitudParcial.click();
            mainPage250103.labelDestinatarioAgenteAduanal.click();
            mainPage250103.inputCapturarDestinatario.click();
            mainPage250103.inputDenominacionDestinatario.sendKeys("PROTEO TOYS");
            //mainPage250103.selectPaisNacionalDestinatario.sendKeys("");
            mainPage250103.selectEntidadFederativa.sendKeys("CIUDAD DE MÉXICO");
            mainPage250103.inputCodigoPostalDestinatario.sendKeys("06934");
            mainPage250103.textareaCalleDestinatario.sendKeys("CONOCIDA");
            mainPage250103.inputRegistroDestinatario.click();
            Selenide.sleep(500);
            mainPage250103.inputAceptarEmergente.click();
            mainPage250103.inputAgregarRequisito.click();
            mainPage250103.inputNombreAgente.sendKeys("RICHARD");
            mainPage250103.inputApellidoPaternoAgente.sendKeys("RICSON");
            Selenide.sleep(500);
            mainPage250103.inputApellidoMaternoAgente.sendKeys("RIVERO");
            mainPage250103.inputPatente.sendKeys("1234");
            mainPage250103.inputAgregarAgente.click();
            mainPage250103.labelMercancSinCfi.click();
            mainPage250103.inputAgregarDescripcion.click();
            mainPage250103.selectDescripcionProducto.sendKeys("CAJAS DE MADERA ALAMBRADAS NUEVAS TRATADAS Y MARCADAS EN BASE A LA ISPM 15");
            mainPage250103.selectFraccionArancelariaClave.sendKeys("44151001");
            mainPage250103.inputCantidad.sendKeys("10");
            mainPage250103.selectUnidadMedidaClave.sendKeys("Pieza");
            mainPage250103.selectGenero.sendKeys("Alnus");
            mainPage250103.selectEspecie.sendKeys("ninguno");
            mainPage250103.selectVidaSilvestre.sendKeys("ninguno");
            mainPage250103.selectPaisesDetalleMercanciaPais.sendKeys("BRASIL");
            mainPage250103.selectPaisesDetalleMercanciaPais2.sendKeys("ALEMANIA");
            mainPage250103.inputAgregarMercancia.click();
            mainPage250103.inputAgregarAgente2.click();
            mainPage250103.inputGuardarSeccionMercancias.click();
            mainPage250103.labelRequisitos.click();
            mainPage250103.selectMedioTransporte.sendKeys("Carretero");
            mainPage250103.inputAgregarRequisito2.click();
            mainPage250103.inputNumIdentificacion.sendKeys("1234");
            mainPage250103.inputNumEconomico.sendKeys("2345");
            mainPage250103.inputPlaca.sendKeys("3465");
            mainPage250103.inputAgregarTransporte.click();
            mainPage250103.inputAgregarRequisito3.click();
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Comprobante");
            mainPage250103.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            Selenide.sleep(500);sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Certificado");sleep(500);
            mainPage250103.inputNumero.sendKeys("1369");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Factura");sleep(500);
            mainPage250103.inputNumero.sendKeys("1369");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Otros");sleep(500);
            mainPage250103.inputTxtNumero.sendKeys("1369");sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.labelPagoDerechos.click();sleep(500);
            mainPage250103.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");sleep(500);
            Random random = new Random();
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage250103.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputSolicitudPagoLlave2);sleep(100);
            mainPage250103.inputGuardarPago.click();
            mainPage250103.inputDatosRevisadosCorrectos.click();
            mainPage250103.inputGuardarSolicitud.click();
            mainPage250103.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            $("button[id='btnAnexar'][type='button']").click();sleep(8000);
            $("button[id='btnCerrar'][type='button']").click();sleep(8000);
            $("input[name='guardarArchivos'][value='Siguiente']").click();sleep(4000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite250103);Selenide.sleep(2000);
            String folioText = mainPage250103.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen250103")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmar250103")) {
                ConfirmarNotificacionRes(folioNumber);
            }guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite250103F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage250103.iniciofun.click();
        mainPage250103.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage250103.btnBuscarFolio.click();
        $(By.cssSelector("td[role='gridcell'][title='" + folioNumber + "']")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();
        mainPage250103.inputDictamenAceptado.click();
        mainPage250103.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
//        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage250103.inputFechaFinVig);sleep(100);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite250103F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void ConfirmarNotificacionRes(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage250103.iniciofun.click();sleep(3000);
        mainPage250103.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage250103.btnBuscarFolio.click();sleep(4500);
        $(By.cssSelector("td[role='gridcell'][title='" + folioNumber + "']")).doubleClick();
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite250103F);sleep(8000);
    }
//
//    public void AutorizarDictamen(String folioNumber) {
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        String folioGenerado = folioNumber;
//        String rfcEmpleado = "MAVL621207C95";
//        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
//        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
//        mainPage250103.iniciofun.click();sleep(3000);
//        mainPage250103.numfolio.sendKeys(folioNumber);sleep(1500);
//        mainPage250103.btnBuscarFolio.click();sleep(4500);
//        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
//        $("input[name='mostrarFirma'][value='Autorizar']").click();
//        loginFirmSoli.firmaFun(tramite250103F);sleep(8000);
//    }
//
//    public void ConfirmarNotificacion(String folioNumber) {
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
//        loginFirmSoli.login(tramite250103);sleep(3000);
//        mainPage250103.SelecRol.sendKeys("Persona Moral");sleep(1000);
//        mainPage250103.Btnacep.click();
//        mainPage250103.inicioFolio.sendKeys(folioNumber);sleep(15000);
//        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
//        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
//        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
//        loginFirmSoli.firma(tramite250103);sleep(1000);sleep(4000);
//    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }


    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados250103.txt";

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