package HACIENDA.Tramite32605;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32605.MainPage32605;
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

public class MainPage32605Test {
    MainPage32605 mainPage32605 = new MainPage32605();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32605  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
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
    public void Proceso32605() {
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
            loginFirmSoli.login(tramite32605);
            mainPage32605.selecRol.sendKeys("Persona Moral");
            mainPage32605.btnacep.click();
            mainPage32605.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32605.SoliNew.click();
            mainPage32605.hacienda.click();
            mainPage32605.registrosComercioExt.click();
            mainPage32605.solicitudRegistro.click();
            mainPage32605.rubroImportadorExportador.click();
            mainPage32605.datosComunes.click();
            mainPage32605.sectorProductivo.sendKeys("Fabricación de artículos de oficina");
            mainPage32605.cumplimientoObligacionesSi.click();sleep(400);
            mainPage32605.autorizoSATSi.click();
            mainPage32605.empleadosPropiosSi.click();
            mainPage32605.numEmpleadosPropios.sendKeys("10");
            mainPage32605.bimestreEmpleadosPropios.sendKeys("Marzo - Abril");
            mainPage32605.isrSi.click();
            mainPage32605.pagoCuotasObreroPatronalesSi.click();
            mainPage32605.subcontratacionSi.click();
            mainPage32605.agregarSubcontratado.click();
            mainPage32605.rfcSubcontratado.sendKeys("MAVL621207C95");
            mainPage32605.btnBuscarRfcSubcontratado.click();
            mainPage32605.numEmpleadosSubcontratados.sendKeys("10");;
            mainPage32605.bimestreEmpleadosSubcontratados.sendKeys("Marzo - Abril");
            mainPage32605.añadirSubcontratados.click();
            mainPage32605.btnAceptarSubcontratados.click();
            mainPage32605.registroPadronSi.click();
            mainPage32605.listadoEmpresasNo.click();
            mainPage32605.articulo64BCFFNo.click();
            mainPage32605.articulo64BBisNo.click();
            mainPage32605.sellosVigentes.click();
            mainPage32605.articulo17HBis.click();
            mainPage32605.AgregarInstalaciones.click();
            mainPage32605.entidadInstalacion.sendKeys("SINALOA");
            mainPage32605.seleccionarInstalacion.click();
            mainPage32605.btnAgregarInstalaciones.click();
            mainPage32605.selecInstalacionAModificar.click();
            mainPage32605.modificarInstalacion.click();
            mainPage32605.instalacionPrincipal.click();
            mainPage32605.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32605.procesoProductivoSi.click();
            mainPage32605.usoGoceInmuebleSi.click();
            mainPage32605.comercioExteriorSi.click();
            mainPage32605.reconocimientoMutuoSi.click();
            mainPage32605.perfilEmpresaNo.click();
            mainPage32605.btnHacerModificacion.click();
            mainPage32605.btnAceptarModificacion.click();
            mainPage32605.articulo17KSi.click();
            mainPage32605.suspesionPadronNo.click();
            mainPage32605.provedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32605.agregarProvedoresExtranjeros.click();sleep(1000);
            clickOkButton();
            mainPage32605.provedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32605.agregarProvedoresNacionales.click();
            mainPage32605.btnOkProvedoresNacionales.click();
            mainPage32605.querellaNo.click();
            mainPage32605.inventariosSi.click();
            mainPage32605.nombreInventarios.sendKeys("PRUEBAS");
            mainPage32605.lugarInventarios.sendKeys("QA");
            mainPage32605.anexo24InventariosOk.click();
            mainPage32605.btnAgregarInventario.click();sleep(1000);
            mainPage32605.btnAceptarInventario.click();
            mainPage32605.rmfSi.click();
            mainPage32605.agregarSocio.click();
            mainPage32605.caracterSocio.sendKeys("administrador unico");
            mainPage32605.tributarEnMexicoNo.click();
            mainPage32605.tipoPersona.sendKeys("Moral");
            mainPage32605.tipoPersona.click();
            mainPage32605.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32605.nombreEmpresaSocio.sendKeys("PRUEBAS");
            mainPage32605.btnAgregarSocio.click();sleep(1000);
            mainPage32605.btnAceptarSocio.click();
            mainPage32605.sociosAccionistasNo.click();
            mainPage32605.manifiesto1.click();
            mainPage32605.manifiesto2.click();
            /// Terceros Relacionados
            scrollDecremento();
            mainPage32605.tercerosRelacionados.click();
            mainPage32605.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32605.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32605.btnAceptarRepresentanteL.click();
            mainPage32605.btnAgregarEnlaceOperativo.click();
            mainPage32605.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32605.btnBuscarEnlaceO.click();
            mainPage32605.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32605.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            scrollDecremento();
            mainPage32605.importadorYExportador.click();
            mainPage32605.operacionesComercioExterior.click();
            mainPage32605.mismoGrupoNo.click();
            mainPage32605.fusionEscisionNo.click();
            mainPage32605.programaImmexSi.click();
            mainPage32605.fechaPago.click();
            mainPage32605.selecFechaPago.click();
            mainPage32605.montoPago.sendKeys("1000");
            mainPage32605.numOperacionBancaria.sendKeys("12");
            mainPage32605.llaveDEPago.sendKeys(llavePago);
            mainPage32605.agregarTransportistas.click();
            mainPage32605.rfcTransportista.sendKeys("LEQI8101314S7");
            mainPage32605.btnBuscarTransportista.click();
            mainPage32605.btnAgregarTransportista.click();sleep(1000);
            mainPage32605.btnAceptarTransportista.click();
            mainPage32605.autorizoReconocimientoMutuo.click();
            mainPage32605.informacionPublica.click();
            /// CTPAT
            scrollDecremento();
            mainPage32605.CTPAT.click();
            mainPage32605.autorizoCBPSi.click();
            mainPage32605.materiaSeguridadSi.click();
            mainPage32605.cancelacionNo.click();

            mainPage32605.btnGuardarSoli.click();
            mainPage32605.btnContinuar.click();
            mainPage32605.btnAdjuntarDoc.click();
            mainPage32605.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32605.btnAdjuntar.click();sleep(4500);
            mainPage32605.btnCerrar.click();
            mainPage32605.btnSiguiente.click();

            loginFirmSoli.firma(tramite32605);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32605.folio.getText();

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
