package HACIENDA.Tramite32618;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32618.MainPage32618;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32618Test {
    Metodos metodos = new Metodos();
    MainPage32618 mainPage32618 = new MainPage32618();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32618  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
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
    public void Proceso32618() {
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
            loginFirmSoli.login(tramite32618);
//            mainPage32618.selecRol.sendKeys("Persona Moral");
//            mainPage32618.btnacep.click();
            mainPage32618.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32618.SoliNew.click();
            mainPage32618.hacienda.click();
            mainPage32618.registrosComercioExt.click();
            mainPage32618.solicitudRegistro.click();
            mainPage32618.rubroAlmacenGeneral.click();
            /// Datos Comunes
            mainPage32618.datosComunes.click();
            mainPage32618.sectorProductivo.sendKeys("Fabricación de artículos de oficina");
            mainPage32618.cumplimientoFiscalesAduaneras.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32618.inputPropios.click();
            mainPage32618.inputEmpPropios.sendKeys("10");
            mainPage32618.inputEmpPropios2.sendKeys("Marzo - Abril");
            mainPage32618.inputIsr.click();
            mainPage32618.inputObreroPatronales.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32618.inputAgregarSubcontratado.click();
            mainPage32618.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32618.inputBuscar.click();
            mainPage32618.inputSubcontratadoEmpleados.sendKeys("10");
            mainPage32618.selectSubcontratadoBimestre.sendKeys("Marzo - Abril");
            mainPage32618.inputSubcontratadoAgregarModalEsquema.click();sleep(1000);
            mainPage32618.btnAceptarSubcontratados.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto9.click();
//            mainPage32618.immexNuevo.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            mainPage32618.immexNuevo.sendKeys("132022");  ///AFC
            mainPage32618.inputAgregarDomicilios.click();
            mainPage32618.selectEntidadFederativaIdc.sendKeys("SINALOA");
            mainPage32618.inputGridDomiciliosModal.click();
            mainPage32618.btnAceptarDomicilios.click();
            mainPage32618.inputGridDomicilios.click();
            mainPage32618.inputModificarDomicilios.click();
            mainPage32618.inputInstalacion.click();
            mainPage32618.selectDomicilioTipoInstalacion.sendKeys("Planta Productora");
            mainPage32618.inputProcesoProd.click();
            mainPage32618.inputAcredita.click();
            mainPage32618.inputPerfil.click();
//            mainPage32618.inputOperacionesExt.click();
//            mainPage32618.inputInstalacionCtpat.click();sleep(1000);
            mainPage32618.inputAceptarDomicilios2.click();sleep(1000);
            mainPage32618.aceptarDomiciliosEmergenetes.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto10.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto11.click();
            mainPage32618.inputArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32618.inputUploadFileExtranjeros.click();sleep(1000);
            mainPage32618.btnOkExtranjeros.click();
            mainPage32618.inputArchivoNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32618.inputUploadFileExtranjeros2.click();sleep(1000);
            mainPage32618.btnOkNacionales.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto12.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto13.click();
            mainPage32618.inputInventario.click();
            mainPage32618.inputNombreInventario.sendKeys("PRUEBAS");
            mainPage32618.lugarInventario.sendKeys("QA");
            mainPage32618.inputAnexoInventario.click();
            mainPage32618.inputAgregarInventario.click();sleep(1000);
            mainPage32618.btnAceptarInventarios.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto15.click();
            mainPage32618.selectSocioCaracter.sendKeys("Administrador Unico");
            mainPage32618.tributarMexicoNo.click();
            mainPage32618.tipoPersona.sendKeys("Moral");
            mainPage32618.tipoPersona.click();
            mainPage32618.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32618.nombreSocio.sendKeys("PRUEBAS");
            mainPage32618.btnAgregarSocio.click();sleep(1000);
            mainPage32618.btnAceptarSocios.click();
            mainPage32618.inputMapDeclaracionSolicitudAcepto16.click();
            mainPage32618.inputAcepto.click();
            mainPage32618.inputAcepto2.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage32618.tercerosRelacionados.click();
            mainPage32618.rfcRepresentanteL.sendKeys("LEQI8101314S7");
            mainPage32618.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32618.btnAceptarRepresentanteL.click();
            mainPage32618.agregarEnlaceO.click();
            mainPage32618.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32618.btnBuscarEnlaceO.click();
            mainPage32618.cargoEnlaceO.sendKeys("QA");
            mainPage32618.btnAgregarEnlaceO.click();
            /// AlmacenGeneral
            mainPage32618.almacenGeneral.click();
            mainPage32618.experienciaPrestacion.click();
            mainPage32618.fechaExperiencia.click();sleep(200);
            mainPage32618.selecFechaExperiencia.click();
            mainPage32618.autorizacionAlmacen.click();
            mainPage32618.fechaFinVigencia.click();sleep(200);
            mainPage32618.selecFechaFinVigencia.click();
            mainPage32618.numOficioAutorizacion.sendKeys("10");
            mainPage32618.cancelacionAlmacen.click();
            mainPage32618.perfilAlmacenes.click();
            mainPage32618.reconomientoMutuo.click();
            mainPage32618.rfcSocioComercial.click();
            mainPage32618.nombreSocioComercial.click();
            mainPage32618.domicilioSocioComercial.click();
            mainPage32618.paginaSocioComercial.click();
            mainPage32618.correoSocioComercial.click();
            mainPage32618.telefonoSocioComercial.click();
            mainPage32618.pagina.sendKeys("www.prueba.com");
            mainPage32618.correo.sendKeys("pruebas@pruebas.qa");
            mainPage32618.lada.sendKeys("66");
            mainPage32618.telefono.sendKeys("999999999");
            mainPage32618.informacionPublica.click();
            mainPage32618.operacionBancaria.sendKeys("10");
            mainPage32618.banco.sendKeys("BANAMEX");
            mainPage32618.llavePago.sendKeys(llavePago);
            mainPage32618.fechaPago.click();
            mainPage32618.selecFechaPago.click();

            mainPage32618.perfilesAG.click();
            mainPage32618.domicilioInstalacion.sendKeys("Calle 123 # 12-12");
            mainPage32618.antiguedad.sendKeys("10");
            mainPage32618.actividad.sendKeys("Prueba");
            mainPage32618.productos.sendKeys("Prueba");
            mainPage32618.numEmbarquesExp.sendKeys("10");
            mainPage32618.numEmbarquesImp.sendKeys("10");
            mainPage32618.numEmpleados.sendKeys("10");
            mainPage32618.superficie.sendKeys("1000");

            mainPage32618.ctpat.click();
            mainPage32618.pip.click();
            mainPage32618.oea.click();
            mainPage32618.otrosProgramas.click();
            mainPage32618.nombreOtrasCert.sendKeys("Prueba");
            mainPage32618.categoriaOtrasCert.sendKeys("Prueba");
            mainPage32618.FechaOtrasCert.click();
            mainPage32618.selecFechaOtrasCert.click();

            mainPage32618.planeacionSeguridad.click();
            mainPage32618.analisis1.click();
            mainPage32618.analisis2.click();
            mainPage32618.planeacion1.sendKeys("Prueba");
            mainPage32618.planeacion2.sendKeys("Prueba");
            mainPage32618.planeacion3.sendKeys("Prueba");
            mainPage32618.planeacion4.sendKeys("Prueba");
            mainPage32618.planeacion5.sendKeys("Prueba");
            mainPage32618.planeacion6.sendKeys("Prueba");
            mainPage32618.analisis3.click();
            mainPage32618.analisis4.click();
            mainPage32618.planeacion7.sendKeys("Prueba");
            mainPage32618.planeacion8.sendKeys("Prueba");
            mainPage32618.analisis5.click();
            mainPage32618.planeacion9.sendKeys("Prueba");
            mainPage32618.analisis6.click();
            mainPage32618.planeacion10.sendKeys("Prueba");
            mainPage32618.planeacion11.sendKeys("Prueba");
            mainPage32618.analisis7.click();
            mainPage32618.analisis8.click();
            mainPage32618.planeacion12.sendKeys("Prueba");
            mainPage32618.planeacion13.sendKeys("Prueba");
            mainPage32618.analisis9.click();
            mainPage32618.analisis10.click();

            mainPage32618.seguridadFisica.click();
            mainPage32618.seguridad1.sendKeys("Prueba");
            mainPage32618.seguridad2.sendKeys("Prueba");
            mainPage32618.seguridad3.sendKeys("Prueba");
            mainPage32618.seguridad4.sendKeys("4");
            mainPage32618.seguridad5.sendKeys("Prueba");
            mainPage32618.seguridad6.sendKeys("Prueba");
            mainPage32618.seguridad7.sendKeys("Prueba");
            mainPage32618.seguridad8.sendKeys("Prueba");
            mainPage32618.seguridad9.sendKeys("Prueba");
            mainPage32618.seguridad10.sendKeys("Prueba");
            mainPage32618.seguridad11.sendKeys("Prueba");
            mainPage32618.seguridad12.sendKeys("Prueba");
            mainPage32618.seguridad13.sendKeys("Prueba");
            mainPage32618.seguridad14.sendKeys("Prueba");
            mainPage32618.seguridad15.sendKeys("Prueba");
            mainPage32618.seguridad16.sendKeys("Prueba");
            mainPage32618.seguridad17.sendKeys("Prueba");
            mainPage32618.seguridad18.sendKeys("Prueba");
            mainPage32618.seguridad19.sendKeys("Prueba");
            mainPage32618.seguridad20.sendKeys("Prueba");
            mainPage32618.seguridad21.sendKeys("Prueba");
            mainPage32618.seguridad22.sendKeys("Prueba");
            mainPage32618.llaves.click();
            mainPage32618.seguridad23.sendKeys("Prueba");
            mainPage32618.seguridad24.sendKeys("Prueba");
            mainPage32618.seguridad25.sendKeys("Prueba");
            mainPage32618.seguridad26.sendKeys("Prueba");
            mainPage32618.seguridad27.sendKeys("Prueba");
            mainPage32618.seguridad28.sendKeys("Prueba");
            mainPage32618.llaves2.click();
            mainPage32618.seguridad29.sendKeys("Prueba");
            mainPage32618.seguridad30.sendKeys("Prueba");
            mainPage32618.seguridad31.sendKeys("Prueba");
            mainPage32618.seguridad32.sendKeys("Prueba");
            mainPage32618.seguridad33.sendKeys("Prueba");
            mainPage32618.seguridad34.sendKeys("Prueba");
            mainPage32618.seguridad35.sendKeys("Prueba");
            mainPage32618.seguridad36.sendKeys("Prueba");
            mainPage32618.seguridad37.sendKeys("Prueba");
            mainPage32618.seguridad38.sendKeys("Prueba");
            mainPage32618.seguridad39.sendKeys("Prueba");
            mainPage32618.seguridad40.sendKeys("Prueba");
            mainPage32618.llaves3.click();
            mainPage32618.seguridad41.sendKeys("Prueba");
            mainPage32618.seguridad42.sendKeys("Prueba");
            mainPage32618.seguridad43.sendKeys("Prueba");
            mainPage32618.seguridad44.sendKeys("Prueba");
            mainPage32618.seguridad45.sendKeys("Prueba");
            mainPage32618.seguridad46.sendKeys("Prueba");
            mainPage32618.seguridad47.sendKeys("Prueba");
            mainPage32618.seguridad48.sendKeys("Prueba");
            mainPage32618.seguridad49.sendKeys("Prueba");
            mainPage32618.seguridad50.sendKeys("Prueba");
            mainPage32618.llaves4.click();
            mainPage32618.seguridad51.sendKeys("Prueba");
            mainPage32618.seguridad52.sendKeys("Prueba");
            mainPage32618.seguridad53.sendKeys("Prueba");
            mainPage32618.seguridad54.sendKeys("Prueba");
            mainPage32618.seguridad55.sendKeys("Prueba");
            mainPage32618.seguridad56.sendKeys("Prueba");

            mainPage32618.controlAccesoFisico.click();
            mainPage32618.acceso1.sendKeys("Prueba");
            mainPage32618.acceso2.sendKeys("25");
            mainPage32618.acceso3.sendKeys("Prueba");
            mainPage32618.acceso4.sendKeys("Prueba");
            mainPage32618.acceso5.sendKeys("Prueba");
            mainPage32618.acceso6.sendKeys("Prueba");
            mainPage32618.acceso7.sendKeys("Prueba");
            mainPage32618.acceso8.sendKeys("Prueba");
            mainPage32618.acceso9.sendKeys("Prueba");
            mainPage32618.acceso10.sendKeys("Prueba");
            mainPage32618.acceso11.sendKeys("Prueba");
            mainPage32618.acceso12.sendKeys("Prueba");
            mainPage32618.acceso13.sendKeys("Prueba");
            mainPage32618.visitas.click();
            mainPage32618.acceso14.sendKeys("Prueba");
            mainPage32618.acceso15.sendKeys("Prueba");
            mainPage32618.acceso16.sendKeys("Prueba");
            mainPage32618.acceso17.sendKeys("Prueba");
            mainPage32618.acceso18.sendKeys("Prueba");
            mainPage32618.acceso19.sendKeys("Prueba");

            mainPage32618.sociosComerciales.click();sleep(1000);
            mainPage32618.socios.sendKeys("Prueba");
            mainPage32618.socios1.sendKeys("Prueba");
            mainPage32618.socios2.sendKeys("Prueba");
            mainPage32618.socios3.sendKeys("Prueba");
            mainPage32618.socios4.sendKeys("Prueba");
            mainPage32618.socios5.sendKeys("Prueba");
            mainPage32618.socios6.sendKeys("Prueba");
            mainPage32618.socios7.sendKeys("Prueba");
            mainPage32618.socios8.sendKeys("Prueba");
            mainPage32618.socios9.sendKeys("Prueba");
            mainPage32618.socios10.sendKeys("Prueba");
            mainPage32618.socios11.sendKeys("Prueba");
            mainPage32618.socios12.sendKeys("Prueba");

            mainPage32618.seguridadProcesos.click();
            mainPage32618.procesos1.sendKeys("Prueba");
            mainPage32618.procesos2.sendKeys("Prueba");
            mainPage32618.procesos3.sendKeys("Prueba");
            mainPage32618.procesos4.sendKeys("Prueba");
            mainPage32618.procesos5.sendKeys("Prueba");
            mainPage32618.procesos6.sendKeys("Prueba");
            mainPage32618.procesos7.sendKeys("Prueba");
            mainPage32618.procesos8.sendKeys("Prueba");
            mainPage32618.procesos9.sendKeys("Prueba");

            mainPage32618.gestionAduanera.click();sleep(1000);

            mainPage32618.seguridadVehiculos.click();
            mainPage32618.vehiculos1.sendKeys("Prueba");
            mainPage32618.vehiculos2.sendKeys("Prueba");
            mainPage32618.vehiculos3.sendKeys("Prueba");
            mainPage32618.vehiculos4.sendKeys("Prueba");
            mainPage32618.vehiculos5.sendKeys("Prueba");
            mainPage32618.inspeccion1.click();
            mainPage32618.inspeccion2.click();
            mainPage32618.vehiculos6.sendKeys("Prueba");

            mainPage32618.seguridadPersonal.click();
            mainPage32618.personal1.sendKeys("Prueba");
            mainPage32618.personal2.sendKeys("Prueba");
            mainPage32618.personal3.sendKeys("Prueba");
            mainPage32618.personal4.sendKeys("Prueba");
            mainPage32618.personal5.sendKeys("Prueba");
            mainPage32618.personal6.sendKeys("Prueba");
            mainPage32618.procedimiento1.click();
            mainPage32618.personal7.sendKeys("Prueba");
            mainPage32618.personal8.sendKeys("Prueba");
            mainPage32618.personal9.sendKeys("Prueba");
            mainPage32618.personal10.sendKeys("Prueba");
            mainPage32618.personal11.sendKeys("Prueba");
            mainPage32618.personal12.sendKeys("Prueba");
            mainPage32618.procedimiento2.click();

            mainPage32618.seguridadInformacionDocumentacion.click();
            mainPage32618.informacion1.sendKeys("Prueba");
            mainPage32618.informacion2.sendKeys("Prueba");
            mainPage32618.informacion3.sendKeys("Prueba");
            mainPage32618.documentacion.click();
            mainPage32618.informacion4.sendKeys("Prueba");
            mainPage32618.informacion5.sendKeys("Prueba");
            mainPage32618.informacion6.sendKeys("Prueba");
            mainPage32618.informacion7.sendKeys("Prueba");
            mainPage32618.informacion8.sendKeys("Prueba");
            mainPage32618.informacion9.sendKeys("Prueba");
            mainPage32618.informacion10.sendKeys("Prueba");
            mainPage32618.informacion11.sendKeys("Prueba");
            mainPage32618.informacion12.sendKeys("Prueba");
            mainPage32618.informacion13.sendKeys("Prueba");
            mainPage32618.informacion14.sendKeys("Prueba");
            mainPage32618.informacion15.sendKeys("Prueba");
            mainPage32618.informacion16.sendKeys("Prueba");
            mainPage32618.informacion17.sendKeys("Prueba");
            mainPage32618.informacion18.sendKeys("Prueba");
            mainPage32618.informacion19.sendKeys("Prueba");
            mainPage32618.informacion20.sendKeys("Prueba");
            mainPage32618.informacion21.sendKeys("Prueba");

            mainPage32618.capacitacionSeguridadConcientizacion.click();
            mainPage32618.capacitacion1.sendKeys("Prueba");
            mainPage32618.capacitacion2.sendKeys("Prueba");
            mainPage32618.capacitacion3.sendKeys("Prueba");
            mainPage32618.capacitacion4.sendKeys("Prueba");
            mainPage32618.capacitacion5.sendKeys("Prueba");
            mainPage32618.capacitacion6.sendKeys("Prueba");
            mainPage32618.capacitacion7.sendKeys("Prueba");
            mainPage32618.capacitacion8.sendKeys("Prueba");
            mainPage32618.capacitacion9.sendKeys("Prueba");
            mainPage32618.capacitacion10.sendKeys("Prueba");
            mainPage32618.capacitacion11.sendKeys("Prueba");

            mainPage32618.manejoInvesitgacionIncidentes.click();
            mainPage32618.investigacion1.sendKeys("Prueba");
            mainPage32618.investigacion2.sendKeys("Prueba");
            mainPage32618.investigacion3.sendKeys("Prueba");
            mainPage32618.investigacion4.sendKeys("Prueba");
            mainPage32618.investigacion5.sendKeys("Prueba");
            mainPage32618.investigacion6.sendKeys("Prueba");
            mainPage32618.investigacion7.sendKeys("Prueba");

            /// Guardar y Firmar
            mainPage32618.btnGuardarSoli.click();
            mainPage32618.btnContinuar.click();
//            mainPage32618.btnAdjuntarDoc.click();sleep(1000);
//            subirDocumentos();
            metodos.cargarDocumentos();
            mainPage32618.btnAdjuntar.click();sleep(35000);
            mainPage32618.btnCerrar.click();
            mainPage32618.btnSiguiente.click();

            loginFirmSoli.firma(tramite32618);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32618.folio.getText();

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

    public void subirDocumentos() {
        String rutaArchivo = "C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"; // Ruta fija

        ElementsCollection inputs = $$x("//input[contains(@name, 'documentos') and contains(@name, '.file')]");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
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
