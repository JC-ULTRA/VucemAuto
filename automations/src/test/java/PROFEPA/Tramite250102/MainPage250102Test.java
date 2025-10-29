package PROFEPA.Tramite250102;

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

public class MainPage250102Test {
    MainPage250102 mainPage250102 = new MainPage250102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0802500100220258319000010";
    TramitesFirmasLG tramite250102 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite250102F = new TramitesFirmasLG(
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
    public void Proceso250102() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen250102");
        JCheckBox confirmarCheckBox = new JCheckBox("ProcesoConfirmar250102");


        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen250102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar250102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen250102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion250102");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite250102);
            mainPage250102.selecRol.sendKeys("Persona Moral");
            mainPage250102.btnacep.click();
            mainPage250102.Tramites.sendKeys("Solicitudes nuevas");
            mainPage250102.SoliNew.click();
            mainPage250102.PROFEPA.click();
            mainPage250102.linkCertificadosLicenciasPermisos.click();
            mainPage250102.linkRegistroVerificaci.click();
            mainPage250102.linkProfepaSiiFloraFaunaDifComercio.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage250102.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage250102.labelTipoMovimiento.click();
            mainPage250102.selectSolicitudAduanasAduanaClave.sendKeys("COLOMBIA");
            mainPage250102.selectSolicitudUnidadAdministrativaRepresentacion.sendKeys("COLOMBIA");
            mainPage250102.selectSolicitudEntidadesEntidadClave.sendKeys("NUEVO LEON");
            mainPage250102.inputGuardarSolicitudParcial.click();
            mainPage250102.labelDestinatarioAgenteAduanal.click();
            mainPage250102.inputCapturarDestinatario.click();
            mainPage250102.inputDenominacionDestinatario.sendKeys("PROTEO TOYS");
            //mainPage250102.selectPaisNacionalDestinatario.sendKeys("");
            mainPage250102.selectEntidadFederativa.sendKeys("CIUDAD DE MÉXICO");
            mainPage250102.inputCodigoPostalDestinatario.sendKeys("06934");
            mainPage250102.textareaCalleDestinatario.sendKeys("CONOCIDA");
            mainPage250102.inputRegistroDestinatario.click();
            Selenide.sleep(500);
            metodos.presionarEscYSpace();
            mainPage250102.inputAgregarRequisito.click();
            mainPage250102.inputNombreAgente.sendKeys("RICHARD");
            mainPage250102.inputApellidoPaternoAgente.sendKeys("RICSON");
            mainPage250102.inputApellidoMaternoAgente.sendKeys("RIVERO");
            mainPage250102.inputPatente.sendKeys("1234");
            mainPage250102.inputAgregarAgente.click();
            mainPage250102.labelMercancSinCfi.click();
            mainPage250102.inputAgregarDescripcion.click();
            mainPage250102.selectDescripcionProducto.sendKeys("ASERRIN");
            mainPage250102.selectFraccionArancelariaClave.sendKeys("44013999");
            mainPage250102.inputCantidad.sendKeys("10");
            mainPage250102.selectUnidadMedidaClave.sendKeys("Gramo");
            mainPage250102.selectGenero.sendKeys("Alnus");
            mainPage250102.selectEspecie.sendKeys("ninguno");
            mainPage250102.selectVidaSilvestre.sendKeys("ninguno");
            mainPage250102.selectPaisesDetalleMercanciaPais.sendKeys("BRASIL");
            mainPage250102.selectPaisesDetalleMercanciaPais2.sendKeys("ALEMANIA");
            mainPage250102.inputAgregarMercancia.click();
            mainPage250102.inputAgregarAgente2.click();
            mainPage250102.inputGuardarSeccionMercancias.click();
            mainPage250102.labelRequisitos.click();
            mainPage250102.selectMedioTransporte.sendKeys("Carretero");
            mainPage250102.inputAgregarRequisito2.click();
            mainPage250102.inputNumIdentificacion.sendKeys("1234");
            mainPage250102.inputNumEconomico.sendKeys("2345");
            mainPage250102.inputPlaca.sendKeys("3465");
            mainPage250102.inputAgregarTransporte.click();
            mainPage250102.inputAgregarRequisito3.click();
            mainPage250102.selectRegistroRequisitoCaption.sendKeys("Comprobante");
            mainPage250102.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250102.inputCalendarFrom);sleep(100);
            mainPage250102.inputAgregarAgente3.click();
            mainPage250102.inputAgregarRequisito3.click();
            mainPage250102.selectRegistroRequisitoCaption.sendKeys("Certificado");
            mainPage250102.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250102.inputCalendarFrom);sleep(100);
            mainPage250102.inputAgregarAgente3.click();
            mainPage250102.inputAgregarRequisito3.click();
            mainPage250102.selectRegistroRequisitoCaption.sendKeys("Factura");
            mainPage250102.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250102.inputCalendarFrom);sleep(100);
            mainPage250102.inputAgregarAgente3.click();
            mainPage250102.inputAgregarRequisito3.click();
            mainPage250102.selectRegistroRequisitoCaption.sendKeys("Otros");
            mainPage250102.inputTxtNumero.sendKeys("1369");
            mainPage250102.inputAgregarAgente3.click();
            mainPage250102.labelPagoDerechos.click();
            mainPage250102.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage250102.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250102.inputSolicitudPagoLlave2);sleep(100);
            mainPage250102.inputGuardarPago.click();sleep(4000);
            mainPage250102.inputDatosRevisadosCorrectos.click();sleep(5000);
            mainPage250102.inputGuardarSolicitud.click();sleep(200);
            mainPage250102.inputGuarda.click();sleep(1000);
            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            $("input[name='Adjuntar'][value='Adjuntar']").click();sleep(2000);
            $("input[type='button'][value='Cerrar']").click();

            $("input[name='guardarArchivos'][value='Continuar']").click();sleep(4000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite250102);
            Selenide.sleep(2000);
            String folioText = mainPage250102.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen250102")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmar250102")) {
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
        loginFirmSoli.loginFun(tramite250102F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage250102.iniciofun.click();
        mainPage250102.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage250102.btnBuscarFolio.click();
        $(By.cssSelector("td[role='gridcell'][title='" + folioNumber + "']")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();
        mainPage250102.inputDictamenAceptado.click();
        mainPage250102.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
//        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage250102.inputFechaFinVig);sleep(100);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite250102F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void ConfirmarNotificacionRes(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage250102.iniciofun.click();sleep(3000);
        mainPage250102.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage250102.btnBuscarFolio.click();sleep(4500);
        $(By.cssSelector("td[role='gridcell'][title='" + folioNumber + "']")).doubleClick();
        $("input[name='mostrarFirma'][value='Continuar']").click();
        loginFirmSoli.firmaFun(tramite250102F);sleep(8000);
    }
//
//    public void AutorizarDictamen(String folioNumber) {
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        String folioGenerado = folioNumber;
//        String rfcEmpleado = "MAVL621207C95";
//        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
//        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
//        mainPage250102.iniciofun.click();sleep(3000);
//        mainPage250102.numfolio.sendKeys(folioNumber);sleep(1500);
//        mainPage250102.btnBuscarFolio.click();sleep(4500);
//        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
//        $("input[name='mostrarFirma'][value='Autorizar']").click();
//        loginFirmSoli.firmaFun(tramite250102F);sleep(8000);
//    }
//
//    public void ConfirmarNotificacion(String folioNumber) {
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
//        loginFirmSoli.login(tramite250102);sleep(3000);
//        mainPage250102.SelecRol.sendKeys("Persona Moral");sleep(1000);
//        mainPage250102.Btnacep.click();
//        mainPage250102.inicioFolio.sendKeys(folioNumber);sleep(15000);
//        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
//        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
//        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
//        loginFirmSoli.firma(tramite250102);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados250102.txt";

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