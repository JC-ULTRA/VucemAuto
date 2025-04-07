package HACIENDA.Tramite32617;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32617.MainPage32617;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32617Test {
    MainPage32617 mainPage32617 = new MainPage32617();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32617  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso32617() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamenB8");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacionB8");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucionB8");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32617);
            mainPage32617.selecRol.sendKeys("Persona Moral");
            mainPage32617.btnacep.click();
            mainPage32617.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32617.SoliNew.click();
            mainPage32617.hacienda.click();
            mainPage32617.registrosComercioExt.click();
            mainPage32617.solicitudRegistro.click();
            mainPage32617.rubroTercerizacionLogistica.click();
            /// Datos Comunes
            mainPage32617.datosComunes.click();
            mainPage32617.sectorProductivo.sendKeys("Fabricación de artículos de oficina");
            mainPage32617.cumplimientoFiscalesAduaneras.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32617.inputPropios.click();
            mainPage32617.inputEmpPropios.sendKeys("10");
            mainPage32617.inputEmpPropios2.sendKeys("Marzo - Abril");
            mainPage32617.inputIsr.click();
            mainPage32617.inputObreroPatronales.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32617.inputAgregarSubcontratado.click();
            mainPage32617.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32617.inputBuscar.click();
            mainPage32617.inputSubcontratadoEmpleados.sendKeys("10");
            mainPage32617.selectSubcontratadoBimestre.sendKeys("Marzo - Abril");
            mainPage32617.inputSubcontratadoAgregarModalEsquema.click();sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage32617.immexNuevo.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            mainPage32617.immexNuevo.click();
            mainPage32617.inputGridDomicilios.click();
            mainPage32617.inputModificarDomicilios.click();
            mainPage32617.inputInstalacion.click();
            mainPage32617.selectDomicilioTipoInstalacion.sendKeys("Planta Productora");
            mainPage32617.inputProcesoProd.click();
            mainPage32617.inputAcredita.click();
            mainPage32617.inputPerfil.click();
            mainPage32617.inputOperacionesExt.click();
            mainPage32617.inputInstalacionCtpat.click();sleep(1000);
            mainPage32617.inputAceptarDomicilios2.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.inputMapDeclaracionSolicitudAcepto10.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto11.click();
            mainPage32617.inputArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32617.inputUploadFileExtranjeros.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 448.20001220703125);");
            sleep(1000);

            mainPage32617.inputMapDeclaracionSolicitudAcepto12.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto13.click();
            mainPage32617.inputInventario.click();
            mainPage32617.inputNombreInventario.sendKeys("PRUEBAS");
            mainPage32617.lugarInventario.sendKeys("QA");
            mainPage32617.inputAnexoInventario.click();
            mainPage32617.inputAgregarInventario.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32617.inputMapDeclaracionSolicitudAcepto15.click();
            mainPage32617.selectSocioCaracter.sendKeys("Administrador Unico");
            mainPage32617.tributarMexicoNo.click();
            mainPage32617.tipoPersona.sendKeys("Moral");
            mainPage32617.tipoPersona.click();
            mainPage32617.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32617.nombreSocio.sendKeys("PRUEBAS");
            mainPage32617.btnAgregarSocio.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.inputMapDeclaracionSolicitudAcepto16.click();
            mainPage32617.inputAcepto.click();
            mainPage32617.inputAcepto2.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage32617.tercerosRelacionados.click();
            mainPage32617.rfcRepresentanteL.sendKeys("LEQI8101314S7");
            mainPage32617.btnBuscarRfcRepresentanteL.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.agregarEnlaceO.click();
            mainPage32617.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32617.btnBuscarEnlaceO.click();
            mainPage32617.cargoEnlaceO.sendKeys("QA");
            mainPage32617.btnAgregarEnlaceO.click();
            /// Tercerizacion y Logistica
            mainPage32617.tercerizacionLogistica.click();
            mainPage32617.comercioExteriorNo.click();
            mainPage32617.mismoGrupo.click();
            mainPage32617.fusionNo.click();
            mainPage32617.immexSi.click();
            mainPage32617.fechaPago.click();
            mainPage32617.selecFecha.click();
            mainPage32617.montoPago.sendKeys("1000");
            mainPage32617.operacionBancaria.sendKeys("10");
            mainPage32617.llavePago.sendKeys(llavePago);
            mainPage32617.agregarTransportista.click();
            mainPage32617.rfcTransportista.sendKeys("LEQI8101314S7");
            mainPage32617.btnBuscarTransportista.click();
            mainPage32617.btnAgregarTransportista.click();sleep(1000);
            js.executeScript("function clickEnPosicion(x, y) {" +
                    "const evento = new MouseEvent('click', {" +
                    "view: window," +
                    "bubbles: true," +
                    "cancelable: true," +
                    "clientX: x," +
                    "clientY: y" +
                    "});" +
                    "const elemento = document.elementFromPoint(x, y);" +
                    "if (elemento) {" +
                    "elemento.dispatchEvent(evento);" +
                    "}" +
                    "}" +
                    "clickEnPosicion(843.6000366210938, 417.1000061035156);");
            sleep(1000);
            mainPage32617.immex2si.click();
            mainPage32617.ivaIepsSi.click();
            mainPage32617.instalacionSi.click();
            mainPage32617.propioTransporteSi.click();
            mainPage32617.ctpatExternoSi.click();
            mainPage32617.agregarTerceroCtpat.click();
            mainPage32617.rfcTerceroCtpat.sendKeys("LEQI8101314S7");
            mainPage32617.buscarTerceroCtpat.click();
            mainPage32617.terceroCTPATSi.click();
            mainPage32617.socioComercialSi.click();
            mainPage32617.btnAgregarTerceroCtpat.click();
            /// CTPAT
            mainPage32617.ctpat.click();
            mainPage32617.cbpSi.click();
            mainPage32617.cbp2Si.click();
            mainPage32617.cbp3No.click();

            mainPage32617.btnGuardarSoli.click();
            mainPage32617.btnContinuar.click();
            mainPage32617.btnAdjuntarDoc.click();
            mainPage32617.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32617.btnAdjuntar.click();sleep(6500);
            mainPage32617.btnCerrar.click();
            mainPage32617.btnSiguiente.click();

            loginFirmSoli.firma(tramite32617);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32617.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
        }, repeticiones);
    }


    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }
    public void clickAceptarButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(200);
        }
    }
}
