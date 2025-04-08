package HACIENDA.Tramite32610;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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

public class MainPage32610Test { MainPage32610 mainPage32610 = new MainPage32610();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32610  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\tsd931210493.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\TSD931210493_1012231144.key"
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
    public void Proceso32610() {
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
            loginFirmSoli.login(tramite32610);
//            mainPage32610.selecRol.sendKeys("Persona Moral");
//            mainPage32610.btnacep.click();
            mainPage32610.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32610.SoliNew.click();
            mainPage32610.hacienda.click();
            mainPage32610.registrosComercioExt.click();
            mainPage32610.solicitudRegistro.click();
            mainPage32610.rubroImportadorExportador.click();
            mainPage32610.datosComunes.click();
            mainPage32610.sectorProductivo.sendKeys("Fabricación de artículos de oficina");
            mainPage32610.cumplimientoObligacionesSi.click();sleep(400);
            mainPage32610.autorizoSATSi.click();
            mainPage32610.empleadosPropiosSi.click();
            mainPage32610.numEmpleadosPropios.sendKeys("10");
            mainPage32610.bimestreEmpleadosPropios.sendKeys("Marzo - Abril");
            mainPage32610.isrSi.click();
            mainPage32610.pagoCuotasObreroPatronalesSi.click();
            mainPage32610.subcontratacionSi.click();
            mainPage32610.agregarSubcontratado.click();
            mainPage32610.rfcSubcontratado.sendKeys("MAVL621207C95");
            mainPage32610.btnBuscarRfcSubcontratado.click();
            mainPage32610.numEmpleadosSubcontratados.sendKeys("10");;
            mainPage32610.bimestreEmpleadosSubcontratados.sendKeys("Marzo - Abril");
            mainPage32610.añadirSubcontratados.click();
            mainPage32610.btnAceptarSubcontratados.click();
            mainPage32610.registroPadronSi.click();
            mainPage32610.listadoEmpresasNo.click();
            mainPage32610.articulo64BCFFNo.click();
            mainPage32610.articulo64BBisNo.click();
            mainPage32610.sellosVigentes.click();
            mainPage32610.articulo17HBis.click();
            mainPage32610.AgregarInstalaciones.click();
            mainPage32610.entidadInstalacion.sendKeys("QUERETARO");
            mainPage32610.seleccionarInstalacion.click();
            mainPage32610.btnAgregarInstalaciones.click();
            mainPage32610.selecInstalacionAModificar.click();
            mainPage32610.modificarInstalacion.click();
            mainPage32610.instalacionPrincipal.click();
            mainPage32610.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32610.procesoProductivoSi.click();
            mainPage32610.usoGoceInmuebleSi.click();
            mainPage32610.comercioExteriorSi.click();
            mainPage32610.reconocimientoMutuoSi.click();
//            mainPage32610.btnHacerModificacion.click();
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
                    "clickEnPosicion(972, 507.1000061035156);");
            sleep(1000);
            mainPage32610.btnAceptarModificacion.click();
            mainPage32610.articulo17KSi.click();
            mainPage32610.suspesionPadronNo.click();
            mainPage32610.provedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32610.agregarProvedoresExtranjeros.click();sleep(1000);
            clickOkButton();
            mainPage32610.provedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32610.agregarProvedoresNacionales.click();
            mainPage32610.btnOkProvedoresNacionales.click();
            mainPage32610.querellaNo.click();
            mainPage32610.inventariosSi.click();
            mainPage32610.nombreInventarios.sendKeys("PRUEBAS");
            mainPage32610.lugarInventarios.sendKeys("QA");
            mainPage32610.anexo24InventariosOk.click();
            mainPage32610.btnAgregarInventario.click();sleep(1000);
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
                    "clickEnPosicion(844.6000366210938, 420.300012588501);");
            sleep(1000);
            mainPage32610.rmfSi.click();
            mainPage32610.agregarSocio.click();
            mainPage32610.caracterSocio.sendKeys("administrador unico");
            mainPage32610.tributarEnMexicoNo.click();
            mainPage32610.tipoPersona.sendKeys("Moral");
            mainPage32610.tipoPersona.click();
            mainPage32610.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32610.nombreEmpresaSocio.sendKeys("PRUEBAS");
            mainPage32610.btnAgregarSocio.click();sleep(1000);
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
                    "clickEnPosicion(844.6000366210938, 420.9000186920166);");
            sleep(1000);
            mainPage32610.sociosAccionistasNo.click();
            mainPage32610.manifiesto1.click();
            mainPage32610.manifiesto2.click();
            /// Terceros Relacionados
            scrollDecremento();
            mainPage32610.tercerosRelacionados.click();
            mainPage32610.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32610.btnBuscarRfcRepresentanteL.click();sleep(1000);
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
                    "clickEnPosicion(844.6000366210938, 420.4999942779541);");
            sleep(1000);
            mainPage32610.btnAgregarEnlaceOperativo.click();
            mainPage32610.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32610.btnBuscarEnlaceO.click();
            mainPage32610.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32610.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            scrollDecremento();
            mainPage32610.importadorYExportador.click();
            mainPage32610.operacionesComercioExterior.click();
            mainPage32610.mismoGrupoNo.click();
            mainPage32610.fusionEscisionNo.click();
            mainPage32610.programaImmexSi.click();
            mainPage32610.fechaPago.click();
            mainPage32610.selecFechaPago.click();
            mainPage32610.montoPago.sendKeys("1000");
            mainPage32610.numOperacionBancaria.sendKeys("12");
            mainPage32610.llaveDEPago.sendKeys(llavePago);
            mainPage32610.agregarTransportistas.click();
            mainPage32610.rfcTransportista.sendKeys("LEQI8101314S7");
            mainPage32610.btnBuscarTransportista.click();
            mainPage32610.btnAgregarTransportista.click();sleep(1000);
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
                    "clickEnPosicion(844.6000366210938, 420.300012588501);");
            sleep(1000);
            mainPage32610.autorizoReconocimientoMutuo.click();
            mainPage32610.informacionPublica.click();




//            /// CTPAT
//            scrollDecremento();
//            mainPage32610.CTPAT.click();
//            mainPage32610.autorizoCBPSi.click();
//            mainPage32610.materiaSeguridadSi.click();
//            mainPage32610.cancelacionNo.click();
//
//            mainPage32610.btnGuardarSoli.click();
//            mainPage32610.btnContinuar.click();
//            mainPage32610.btnAdjuntarDoc.click();
//            mainPage32610.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage32610.btnAdjuntar.click();sleep(3500);
//            mainPage32610.btnCerrar.click();
//            mainPage32610.btnSiguiente.click();

            loginFirmSoli.firma(tramite32610);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32610.folio.getText();

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
        for (int i = 0; i < 10; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(200);
        }
    }
}