package SEDENA.Tramite240118;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240118.MainPage240118;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240118Test {

    MainPage240118 mainPage240118 = new MainPage240118();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240118  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    TramitesFirmasLG tramite240118Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
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
    public void Proceso240118() {
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

//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240118");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion240118");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion240118");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240118");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion240118");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion240118");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240118);
            mainPage240118.selecRol.sendKeys("Persona Moral");
            mainPage240118.btnacep.click();
            mainPage240118.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240118.SoliNew.click();
            mainPage240118.SEDENA.click();
            mainPage240118.linkCerLicPer.click();
            mainPage240118.linkPermisoAduanalSEDENA.click();
            mainPage240118.linkPermisoOrdExpArtPirotecnicos.click();

            //DATOS SOLICITANTE
            $("[for='solicitud.titulo.datosTramite']").click();
            mainPage240118.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240118.inputAddOrigenLista.click();
            mainPage240118.inputPermisoGeneral.sendKeys("PRUEBAS");
            mainPage240118.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240118.btnAgregarMercancia.click();
            mainPage240118.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240118.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240118.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240118.inputValorComercialMercancia.sendKeys("1234");
            mainPage240118.selectUMCMercancia.sendKeys("Caja");
            mainPage240118.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240118.btnAgregarMercancia2.click();

            //TERCEROS RELACIONADOS
            $("[for='captura.tab.tercerosRelacionados']").click();

            mainPage240118.btnAgregarDestinatario.click();
            mainPage240118.inputFisica.click();
            mainPage240118.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240118.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240118.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240118.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240118.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240118.inputTercerosCP.sendKeys("23456");
            mainPage240118.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240118.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240118.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240118.inputTercerosLada.sendKeys("52");
            mainPage240118.inputTercerosTelefono.sendKeys("23456257");
            mainPage240118.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240118.btnGuardarTerceros.click();
            mainPage240118.btnAgregarProveedor.click();
            mainPage240118.inputNacional.click();
            mainPage240118.inputFisica.click();
            mainPage240118.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240118.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240118.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240118.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            mainPage240118.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240118.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240118.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240118.inputTercerosCP2.sendKeys("28006");
            mainPage240118.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240118.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240118.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240118.inputTercerosNumeroInt.sendKeys("321");
            mainPage240118.inputTercerosLada.sendKeys("52");
            mainPage240118.inputTercerosTelefono.sendKeys("234565432");
            mainPage240118.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240118.btnGuardarTerceros.click();

            //PAGO DERECHOS
            mainPage240118.labelPagoDerechos.click();

            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240118.inputClaveReferencia.setValue(String.valueOf(cveReferencia));

            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240118.inputCadenaDependencia.setValue(factura.toString());
            mainPage240118.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");

            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240118.inputSolicitudPagoLlave.setValue(factura.toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage240118.inputCalendar, fechaHoy);
            mainPage240118.inputImportePago.sendKeys("5000");
            mainPage240118.InputGuardarSolicitud.click();
            mainPage240118.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240118.btmAnexar.click();sleep(4000);
            Selenide.sleep(4000);
            mainPage240118.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage240118.inputSiguiente.click();sleep(3000);

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240118);
            Selenide.sleep(1000);

            String folioText = mainPage240118.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ProcesoDictamen240118(folioNumber);
            ProcesoVerificarDictamenObservar240118(folioNumber);
            ProcesoModificarDictamen240118(folioNumber);
            ProcesoVerificarDictamenFirmar240118(folioNumber);
            ProcesoAutorizarDictamen240118(folioNumber);
            ProcesoConfirmarNotificaciónResolucion240118(folioNumber);

        }, repeticiones);
    }

    public void ProcesoDictamen240118(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite240118Fun);
        //Busqueda de Folio
        mainPage240118.Inicio.click();
        mainPage240118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage240118.inputBuscarTareasFuncionario.click();
        mainPage240118.tdEvaluarSolicitud.doubleClick();
        //Generar Dictamen
        mainPage240118.GenerarDic.click();
        mainPage240118.SentidoDictamen.click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFinVig = LocalDate.now().plusWeeks(2).format(formatter);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage240118.fechaFinVig, fechaFinVig);
        mainPage240118.inputMostrarFirma.click();
        //Firma Funcionario
        loginFirmSoli.firmaFun(tramite240118Fun);
        sleep(5000);
    }

    public void ProcesoVerificarDictamenObservar240118(String folioNumber) {
        //Busqueda de Folio
        mainPage240118.Inicio.click();
        mainPage240118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage240118.inputBuscarTareasFuncionario.click();
        sleep(3000);
        $("[title='Verificar Dictamen']").doubleClick();
        sleep(3000);
        $("[value='Observar']").click();
        mainPage240118.justiOBS.sendKeys("PRUEBAS");
        $("[value='Generar Observacion']").click();
        sleep(5000);
    }

    public void ProcesoModificarDictamen240118(String folioNumber) {
        //Busqueda de Folio
        mainPage240118.Inicio.click();
        mainPage240118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage240118.inputBuscarTareasFuncionario.click();
        sleep(3000);
        mainPage240118.tdEvaluarSolicitud.doubleClick();
        sleep(3000);
        $("[value='?mostrarDictamen=']").click();
        $("[value='Continuar']").click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFinVig = LocalDate.now().plusWeeks(2).format(formatter);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage240118.fechaFinVig, fechaFinVig);
        $("[value='Guardar y Firmar']").click();
        loginFirmSoli.firmaFun(tramite240118Fun);
        sleep(5000);
    }

    public void ProcesoVerificarDictamenFirmar240118(String folioNumber) {
        //Busqueda de Folio
        mainPage240118.Inicio.click();
        mainPage240118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage240118.inputBuscarTareasFuncionario.click();
        sleep(3000);
        $("[title='Verificar Dictamen']").doubleClick();
        sleep(3000);
        $("[value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite240118Fun);
        sleep(5000);
    }

    public void ProcesoAutorizarDictamen240118(String folioNumber) {
        //Busqueda de Folio
        mainPage240118.Inicio.click();
        mainPage240118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage240118.inputBuscarTareasFuncionario.click();
        sleep(3000);
        $("[title='Autorizar Dictamen']").doubleClick();
        sleep(3000);
        $("[value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite240118Fun);
        sleep(5000);
    }

        //Proceso Confirmar Notificación Resolución
    public void ProcesoConfirmarNotificaciónResolucion240118(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite240118);
        mainPage240118.selecRol.sendKeys("Persona Moral");
        mainPage240118.btnacep.click();
        $("[id='Inicio']").click();
        mainPage240118.ShBuscar.sendKeys(folioNumber);
        $("[value='Buscar']").click();
        mainPage240118.tdConfirmarNotificaciResoluci.doubleClick();
        $("[value='Continuar']").click();
        loginFirmSoli.firma(tramite240118);
        sleep(5000);
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
