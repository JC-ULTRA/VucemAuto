package HACIENDA.Tramite32606;

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

public class MainPage32606Test {
    MainPage32606 mainPage32606 = new MainPage32606();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32606  = new TramitesFirmasLG(
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
    public void Proceso32606() {
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
            loginFirmSoli.login(tramite32606);
            mainPage32606.selecRol.sendKeys("Persona Moral");
            mainPage32606.btnacep.click();
            mainPage32606.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32606.SoliNew.click();
            mainPage32606.hacienda.click();
            mainPage32606.registrosComercioExt.click();
            mainPage32606.solicitudRegistro.click();
            mainPage32606.rubroControladora.click();
            mainPage32606.datosComunes.click();
            mainPage32606.sectorProductivo.sendKeys("Fabricación de artículos de oficina");
            mainPage32606.cumplimientoFiscalesAduaneras.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32606.inputPropios.click();
            mainPage32606.inputEmpPropios.sendKeys("10");
            mainPage32606.inputEmpPropios2.sendKeys("Marzo - Abril");
            mainPage32606.inputIsr.click();
            mainPage32606.inputObreroPatronales.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32606.inputAgregarSubcontratado.click();
            mainPage32606.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32606.inputBuscar.click();
            mainPage32606.inputSubcontratadoEmpleados.sendKeys("10");
            mainPage32606.selectSubcontratadoBimestre.sendKeys("Marzo - Abril");
            mainPage32606.inputSubcontratadoAgregarModalEsquema.click();sleep(1000);
            mainPage32606.btnAceptarSubcontratados.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage32606.inputAgregarDomicilios.click();
            mainPage32606.selectEntidadFederativaIdc.sendKeys("QUERETARO");
            mainPage32606.inputGridDomiciliosModal.click();
            mainPage32606.inputAceptarDomicilios.click();
            mainPage32606.inputGridDomicilios.click();
            mainPage32606.inputModificarDomicilios.click();
            mainPage32606.inputInstalacion.click();
            mainPage32606.selectDomicilioTipoInstalacion.sendKeys("Planta Productora");
            mainPage32606.inputProcesoProd.click();
            mainPage32606.inputAcredita.click();
            mainPage32606.inputPerfil.click();
            mainPage32606.inputOperacionesExt.click();
            mainPage32606.inputInstalacionCtpat.click();sleep(1000);
            mainPage32606.inputAceptarDomicilios2.click();sleep(1000);
            mainPage32606.btnAceptarDomicilios.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto10.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto11.click();
            mainPage32606.inputArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32606.inputUploadFileExtranjeros.click();sleep(1000);
            mainPage32606.btnOkExtranjeros.click();
            mainPage32606.inputArchivoNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32606.inputUploadFileExtranjeros2.click();sleep(1000);
            mainPage32606.btnOkNacionales.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto12.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto13.click();
            mainPage32606.inputInventario.click();
            mainPage32606.inputNombreInventario.sendKeys("PRUEBAS");
            mainPage32606.lugarInventario.sendKeys("QA");
            mainPage32606.inputAnexoInventario.click();
            mainPage32606.inputAgregarInventario.click();sleep(1000);
            mainPage32606.btnAceptarInventarios.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto15.click();
            mainPage32606.selectSocioCaracter.sendKeys("Administrador Unico");
            mainPage32606.tributarMexicoNo.click();
            mainPage32606.tipoPersona.sendKeys("Moral");
            mainPage32606.tipoPersona.click();
            mainPage32606.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32606.nombreSocio.sendKeys("PRUEBAS");
            mainPage32606.btnAgregarSocio.click();sleep(1000);
            mainPage32606.btnAceptarSocios.click();
            mainPage32606.inputMapDeclaracionSolicitudAcepto16.click();
            mainPage32606.inputAcepto.click();
            mainPage32606.inputAcepto2.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage32606.tercerosRelacionados.click();
            mainPage32606.rfcRepresentanteL.sendKeys("LEQI8101314S7");
            mainPage32606.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32606.btnAceptarRepresentanteL.click();
            mainPage32606.agregarEnlaceO.click();
            mainPage32606.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32606.btnBuscarEnlaceO.click();
            mainPage32606.cargoEnlaceO.sendKeys("QA");
            mainPage32606.btnAgregarEnlaceO.click();
            /// Controladora
            scrollDecremento();
            mainPage32606.controladora.click();
            mainPage32606.operacionesComercioExterior.click();
            mainPage32606.mismoGrupoNo.click();
            mainPage32606.fusionEsicionNo.click();
            mainPage32606.immexExtranjeroNo.click();
            mainPage32606.fechaPago.click();
            mainPage32606.selecFechaPago.click();
            mainPage32606.montoPago.sendKeys("1000");
            mainPage32606.numOperacionBancaria.sendKeys("12");
            mainPage32606.llavePago.sendKeys(llavePago);
            mainPage32606.agregarTransportista.click();
            mainPage32606.rfcTransportista.sendKeys("MAVL621207C95");sleep(1000);
            mainPage32606.buscarRfcTransportista.click();
            mainPage32606.btnAgregarTransportista.click();sleep(1000);
            mainPage32606.btnAceptarTransportista.click();
            mainPage32606.immexsi.click();
            mainPage32606.ivaIepsSi.click();
            mainPage32606.agregarControladora.click();
            mainPage32606.rfcControladora.sendKeys("TSD931210493");
            mainPage32606.btnBuscarRfcControladora.click();
            mainPage32606.participacionAccionaria.sendKeys("100");
            mainPage32606.montoImportaciones.sendKeys("10");
            mainPage32606.montoExportaciones.sendKeys("10");
            mainPage32606.btnAgregarControladora.click();sleep(1000);
            mainPage32606.btnAceptarControladora.click();
            mainPage32606.reconocimientoMutuoNo.click();
            mainPage32606.informacionPrivada.click();
            /// CTPAT
            mainPage32606.ctpat.click();
            mainPage32606.cbpSi.click();
            mainPage32606.cbp2Si.click();
            mainPage32606.cbp3No.click();

            mainPage32606.btnGuardarSoli.click();
            mainPage32606.btnContinuar.click();
            mainPage32606.btnAdjuntarDoc.click();
            mainPage32606.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.archivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32606.btnAdjuntar.click();sleep(6500);
            mainPage32606.btnCerrar.click();
            mainPage32606.btnSiguiente.click();

            loginFirmSoli.firma(tramite32606);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32606.folio.getText();

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
