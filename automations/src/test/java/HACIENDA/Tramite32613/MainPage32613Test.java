package HACIENDA.Tramite32613;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32613.MainPage32613;
import HACIENDA.Tramite32613.MainPage32613;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32613Test {
    MainPage32613 mainPage32613 = new MainPage32613();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32613  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void Proceso32613() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32613");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32613");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32613");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32613");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32613");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32613");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32613);
            mainPage32613.selecRol.sendKeys("Persona Moral");
            mainPage32613.btnacep.click();
            mainPage32613.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32613.SoliNew.click();
            mainPage32613.Hacienda.click();
            mainPage32613.linkResgistroComercioExterior.click();
            mainPage32613.linkSolicitudRegistroEsquemaIntegral.click();
            mainPage32613.linkSolicitudRegistroEsquemaCertificaci.click();sleep(500);
            //DATOS COMUNES
            mainPage32613.labelDatosComunes.click();
            mainPage32613.selectSolicitudListaCatalogo.sendKeys("Fabricación de juguetes, juegos de recreo y artículos deportivos");
            mainPage32613.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32613.inputPropios.click();
            mainPage32613.inputEmpPropios.sendKeys("22");
            mainPage32613.selectSolicitudEmpleadosPropiosBimestre.sendKeys("Enero-Febrero");
            mainPage32613.inputIsr.click();
            mainPage32613.inputObreroPatronales.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32613.inputAgregarSubcontratado.click();
            mainPage32613.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32613.inputBuscar.click();
            mainPage32613.inputSubcontratadoEmpleados.sendKeys("1222");
            mainPage32613.selectSubcontratadoBimestre.sendKeys("Marzo-Abril");
            mainPage32613.inputSubcontratadoAgregarModalEsquema.click();
            mainPage32613.buttonAceptar.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto4.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32613.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage32613.selectImmex.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            mainPage32613.inputGridDomicilios.click();
            mainPage32613.inputModificarDomicilios.click();
            mainPage32613.inputInstalacion.click();
            mainPage32613.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32613.procesoProductivoSi.click();
            mainPage32613.usoGoceInmuebleSi.click();
            mainPage32613.transportistaFerroviario.click();
            mainPage32613.btnHacerModificacion.click();
            mainPage32613.btnAceptarModificacion.click();
            mainPage32613.articulo17KSi.click();
            mainPage32613.suspesionPadronNo.click();
            mainPage32613.provedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32613.agregarProvedoresExtranjeros.click();sleep(1000);
            clickOkButton();
            mainPage32613.provedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32613.agregarProvedoresNacionales.click();
            mainPage32613.btnOkProvedoresNacionales.click();
            mainPage32613.querellaNo.click();
            mainPage32613.inventariosSi.click();
            mainPage32613.nombreInventarios.sendKeys("PRUEBAS");
            mainPage32613.lugarInventarios.sendKeys("QA");
            mainPage32613.anexo24InventariosOk.click();
            mainPage32613.btnAgregarInventario.click();sleep(1000);
            mainPage32613.btnAceptarInventario.click();
            mainPage32613.rmfSi.click();
            mainPage32613.agregarSocio.click();
            mainPage32613.caracterSocio.sendKeys("administrador unico");
            mainPage32613.tributarEnMexicoNo.click();
            mainPage32613.tipoPersona.sendKeys("Moral");
            mainPage32613.tipoPersona.click();
            mainPage32613.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32613.nombreEmpresaSocio.sendKeys("PRUEBAS");
            mainPage32613.btnAgregarSocio.click();sleep(1000);
            mainPage32613.btnAceptarSocio.click();
            mainPage32613.sociosAccionistasNo.click();
            mainPage32613.manifiesto1.click();
            mainPage32613.manifiesto2.click();
            /// Terceros Relacionados
            scrollDecremento();
            mainPage32613.tercerosRelacionados.click();
            mainPage32613.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32613.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32613.btnAceptarRepresentanteL.click();
            mainPage32613.btnAgregarEnlaceOperativo.click();
            mainPage32613.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32613.btnBuscarEnlaceO.click();
            mainPage32613.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32613.btnAñadirEnlaceO.click();
            ///
            mainPage32613.transporteFerroviario.click();
            mainPage32613.transporteFerrocarril2Antes.click();
            mainPage32613.fechaTransporte.click();
            mainPage32613.selecFechaTransporte.click();
            mainPage32613.tramoCompleto.click();
            mainPage32613.permisoVigente.click();
            mainPage32613.unidadesPropias.click();
            mainPage32613.numUnidadesPropias.sendKeys("100");
            mainPage32613.numArrendadas.sendKeys("25");
            mainPage32613.perfilTransportista.click();
            mainPage32613.reconocimientoMutuo.click();
            mainPage32613.rfcSocioComercial.click();
            mainPage32613.nombreRazonSocioComercial.click();
            mainPage32613.direccionSocioComercial.click();
            mainPage32613.paginaSocioComercial.click();
            mainPage32613.correoSocioComercial.doubleClick();
            mainPage32613.telefonoSocioComercial.click();
            mainPage32613.nombrePagina.sendKeys("www.prueba.com");sleep(1000);
            mainPage32613.correo.sendKeys("pruebas@pruebas.qa");sleep(1000);
            mainPage32613.lada1.sendKeys("55");
            mainPage32613.num1.sendKeys("12345678");
            mainPage32613.informacionPublica.click();
            mainPage32613.numOperacion.sendKeys("12873");
            mainPage32613.banco.sendKeys("BANAMEX");
            mainPage32613.llavePago.sendKeys(llavePago);
            mainPage32613.fechaPago.click();
            mainPage32613.selecFechaPago.click();
            /// Perfiles Ferroviario
            scrollDecremento();
            mainPage32613.perfilesFerroviarios.click();
            mainPage32613.domicilioInstalacion.sendKeys("DOMICILIO DE PRUEBA ULTRASIST");
            mainPage32613.antiguedad.click();
            mainPage32613.antiguedad.sendKeys("10");
            mainPage32613.actividadPreponderante.sendKeys("PUREBAS ULTRASIST");
            mainPage32613.tipoServicio.sendKeys("PUREBAS");
            mainPage32613.embarquesExportacion.sendKeys("100");
            mainPage32613.embarquesImportacion.sendKeys("100");
            mainPage32613.empleadosTotales.sendKeys("50");
            mainPage32613.superficie.sendKeys("1000");
            mainPage32613.ctpat.click();
//            mainPage32613.numCertificado.sendKeys("12983738927");
//            mainPage32613.numeroCuentaCtpat.sendKeys("1234");
//            mainPage32613.codigoMnufactura.sendKeys("9847");
//            mainPage32613.fechaUltimaVisita.click();
//            mainPage32613.selecFechaVisita.click();
            mainPage32613.pip.click();
//            mainPage32613.numeroRegistroPip.sendKeys("8923698362");
            mainPage32613.oea.click();
//            mainPage32613.nombreProgramaPais.sendKeys("PRUEBAS");
//            mainPage32613.numRegistroOea.sendKeys("82193266398217");
            mainPage32613.programasSeguridad.click();
//            mainPage32613.nombrePrograma.sendKeys("PRUEBASQA");
//            mainPage32613.numRegistroSeguridad.sendKeys("9724398172");
//            mainPage32613.vigenciaSeguridad.click();
//            mainPage32613.selecVigencia.click();
            mainPage32613.nombreOtrasCertificaciones.sendKeys("PRUEBAS ULTRASIST");
            mainPage32613.categoriaOtrasCertificaciones.sendKeys("PRUEBAS");
            mainPage32613.vigenciaOtrasCertificaciones.click();
            mainPage32613.selecVigenciaCertificaciones.click();
            mainPage32613.planeacion.click();
            mainPage32613.planeacion1.sendKeys("PRUEBAS");
            mainPage32613.planeacion2.sendKeys("PRUEBAS");
            mainPage32613.planeacion3.sendKeys("PRUEBAS");
            mainPage32613.planeacion4.sendKeys("PRUEBAS");
            mainPage32613.planeacion5.sendKeys("PRUEBAS");
            mainPage32613.planeacion6.sendKeys("PRUEBAS");
            mainPage32613.planeacion7.sendKeys("PRUEBAS");
            mainPage32613.planeacion8.sendKeys("PRUEBAS");
            mainPage32613.planeacion9.sendKeys("PRUEBAS");
            mainPage32613.suministros.click();
            mainPage32613.auditoriasRealizacion.click();
            mainPage32613.planeacion10.sendKeys("PRUEBAS");
            mainPage32613.planeacion11.sendKeys("PRUEBAS");
            mainPage32613.auditorias2.click();
            mainPage32613.planeacion12.sendKeys("PRUEBAS");
            mainPage32613.auditorias3.click();
            mainPage32613.planeacion13.sendKeys("PRUEBAS");
            mainPage32613.planeacion14.sendKeys("PRUEBAS");
            mainPage32613.auditorias4.click();
            mainPage32613.planes1.click();
            mainPage32613.planeacion15.sendKeys("PRUEBAS");
            mainPage32613.planeacion16.sendKeys("PRUEBAS");
            mainPage32613.planes2.click();
            mainPage32613.planes3.click();
            mainPage32613.seguridadFisica.click();
            mainPage32613.seguridad1.sendKeys("PRUEBAS");
            mainPage32613.seguridad2.sendKeys("PRUEBAS");
            mainPage32613.seguridad3.sendKeys("PRUEBAS");
            mainPage32613.seguridad4.sendKeys("PRUEBAS");
            mainPage32613.seguridad5.sendKeys("PRUEBAS");
            mainPage32613.seguridad6.sendKeys("PRUEBAS");
            mainPage32613.seguridad7.sendKeys("PRUEBAS");
            mainPage32613.seguridad8.sendKeys("PRUEBAS");
            mainPage32613.seguridad9.sendKeys("PRUEBAS");
            mainPage32613.seguridad10.sendKeys("PRUEBAS");
            mainPage32613.seguridad11.sendKeys("PRUEBAS");
            mainPage32613.seguridad12.sendKeys("PRUEBAS");
            mainPage32613.seguridad13.sendKeys("PRUEBAS");
            mainPage32613.seguridad14.sendKeys("PRUEBAS");
            mainPage32613.seguridad15.sendKeys("PRUEBAS");
            mainPage32613.seguridad16.sendKeys("PRUEBAS");
            mainPage32613.seguridad17.sendKeys("PRUEBAS");
            mainPage32613.seguridad18.sendKeys("PRUEBAS");
            mainPage32613.llaves1.click();
            mainPage32613.llaves2.click();
            mainPage32613.seguridad19.sendKeys("PRUEBAS");
            mainPage32613.seguridad20.sendKeys("PRUEBAS");
            mainPage32613.seguridad21.sendKeys("PRUEBAS");
            mainPage32613.seguridad22.sendKeys("PRUEBAS");
            mainPage32613.seguridad23.sendKeys("PRUEBAS");
            mainPage32613.seguridad24.sendKeys("PRUEBAS");
            mainPage32613.alumbrado.click();
            mainPage32613.seguridad25.sendKeys("PRUEBAS");
            mainPage32613.seguridad26.sendKeys("PRUEBAS");
            mainPage32613.seguridad27.sendKeys("PRUEBAS");
            mainPage32613.seguridad28.sendKeys("PRUEBAS");
            mainPage32613.seguridad29.sendKeys("PRUEBAS");
            mainPage32613.aparatos.click();
            mainPage32613.seguridad30.sendKeys("PRUEBAS");
            mainPage32613.seguridad31.sendKeys("PRUEBAS");
            mainPage32613.seguridad32.sendKeys("PRUEBAS");
            mainPage32613.seguridad33.sendKeys("PRUEBAS");
            mainPage32613.seguridad34.sendKeys("PRUEBAS");
            mainPage32613.seguridad35.sendKeys("PRUEBAS");
            mainPage32613.seguridad36.sendKeys("PRUEBAS");
            mainPage32613.sistemasCCTV.click();
            mainPage32613.seguridad37.sendKeys("PRUEBAS");
            mainPage32613.seguridad38.sendKeys("PRUEBAS");
            mainPage32613.seguridad39.sendKeys("PRUEBAS");
            mainPage32613.seguridad40.sendKeys("PRUEBAS");
            mainPage32613.seguridad41.sendKeys("PRUEBAS");
            mainPage32613.seguridad42.sendKeys("PRUEBAS");
            mainPage32613.seguridad43.sendKeys("PRUEBAS");
            mainPage32613.seguridad44.sendKeys("PRUEBAS");
            mainPage32613.seguridad45.sendKeys("PRUEBAS");
            mainPage32613.seguridad46.sendKeys("PRUEBAS");
            mainPage32613.sistemasCCTV2.click();
            mainPage32613.seguridad47.sendKeys("PRUEBAS");
            mainPage32613.seguridad48.sendKeys("PRUEBAS");
            mainPage32613.seguridad49.sendKeys("PRUEBAS");
            mainPage32613.seguridad50.sendKeys("PRUEBAS");
            mainPage32613.sistemasCCTV3.click();
            mainPage32613.seguridad51.sendKeys("PRUEBAS");

            mainPage32613.controlesAccesoFisico.click();
            mainPage32613.controles1.sendKeys("PRUEBAS");
            mainPage32613.controles2.sendKeys("25");
            mainPage32613.controles3.sendKeys("PRUEBAS");
            mainPage32613.controles4.sendKeys("PRUEBAS");
            mainPage32613.controles5.sendKeys("PRUEBAS");
            mainPage32613.controles6.sendKeys("PRUEBAS");
            mainPage32613.controles7.sendKeys("PRUEBAS");
            mainPage32613.controles8.sendKeys("PRUEBAS");
            mainPage32613.controles9.sendKeys("PRUEBAS");
            mainPage32613.controles10.sendKeys("PRUEBAS");
            mainPage32613.controles11.sendKeys("PRUEBAS");
            mainPage32613.controles12.sendKeys("PRUEBAS");
            mainPage32613.controles13.sendKeys("PRUEBAS");
            mainPage32613.registroVisitantes.click();
            mainPage32613.controles14.sendKeys("PRUEBAS");
            mainPage32613.controles15.sendKeys("PRUEBAS");
            mainPage32613.controles16.sendKeys("PRUEBAS");
            mainPage32613.controles17.sendKeys("PRUEBAS");
            mainPage32613.controles18.sendKeys("PRUEBAS");
            mainPage32613.controles19.sendKeys("PRUEBAS");
            mainPage32613.controles20.sendKeys("PRUEBAS");

            mainPage32613.sociosComerciales.click();
            mainPage32613.socios1.sendKeys("PRUEBAS");
            mainPage32613.socios2.sendKeys("PRUEBAS");
            mainPage32613.socios3.sendKeys("PRUEBAS");
            mainPage32613.socios4.sendKeys("PRUEBAS");
            mainPage32613.socios5.sendKeys("PRUEBAS");
            mainPage32613.socios6.sendKeys("PRUEBAS");
            mainPage32613.socios7.sendKeys("PRUEBAS");
            mainPage32613.socios8.sendKeys("PRUEBAS");
            mainPage32613.socios9.sendKeys("PRUEBAS");
            mainPage32613.socios10.sendKeys("PRUEBAS");
            mainPage32613.socios11.sendKeys("PRUEBAS");
            mainPage32613.socios12.sendKeys("PRUEBAS");
            mainPage32613.socios13.sendKeys("PRUEBAS");

            mainPage32613.seguridadProcesos.click();
            mainPage32613.proceso1.sendKeys("PRUEBAS");
            mainPage32613.proceso2.sendKeys("PRUEBAS");
            mainPage32613.proceso3.sendKeys("PRUEBAS");
            mainPage32613.proceso4.sendKeys("PRUEBAS");
            mainPage32613.proceso5.sendKeys("PRUEBAS");
            mainPage32613.proceso6.sendKeys("PRUEBAS");

            mainPage32613.gestionAduanera.click();
            mainPage32613.aduanera1.sendKeys("PRUEBAS");
            mainPage32613.aduanera2.sendKeys("PRUEBAS");
            mainPage32613.aduanera3.sendKeys("PRUEBAS");
            mainPage32613.aduanera4.sendKeys("PRUEBAS");

            mainPage32613.seguridadEquipos.click();
            mainPage32613.equipos1.sendKeys("PRUEBAS");
            mainPage32613.equipos2.sendKeys("PRUEBAS");
            mainPage32613.equipos3.sendKeys("PRUEBAS");
            mainPage32613.equipos4.sendKeys("PRUEBAS");
            mainPage32613.equipos5.sendKeys("PRUEBAS");
            mainPage32613.equipos6.sendKeys("PRUEBAS");
            mainPage32613.equipos7.sendKeys("PRUEBAS");
            mainPage32613.equipos8.sendKeys("PRUEBAS");
            mainPage32613.equipos9.sendKeys("PRUEBAS");
            mainPage32613.equipos10.sendKeys("PRUEBAS");
            mainPage32613.equipos11.sendKeys("PRUEBAS");

            mainPage32613.seguridadPersonal.click();
            mainPage32613.personal1.sendKeys("PRUEBAS");
            mainPage32613.personal2.sendKeys("PRUEBAS");
            mainPage32613.personal3.sendKeys("PRUEBAS");
            mainPage32613.personal4.sendKeys("PRUEBAS");
            mainPage32613.personal5.sendKeys("PRUEBAS");
            mainPage32613.personal6.sendKeys("PRUEBAS");
            mainPage32613.personal7.sendKeys("PRUEBAS");
            mainPage32613.personal8.sendKeys("PRUEBAS");
            mainPage32613.personal9.sendKeys("PRUEBAS");
            mainPage32613.personal10.sendKeys("PRUEBAS");
            mainPage32613.personal11.sendKeys("PRUEBAS");
            mainPage32613.observaciones.click();

            mainPage32613.seguridadInformacionyDocumentacion.click();
            mainPage32613.informacion1.sendKeys("PRUEBAS");
            mainPage32613.informacion2.sendKeys("PRUEBAS");
            mainPage32613.informacion3.sendKeys("PRUEBAS");
            mainPage32613.informacion4.sendKeys("PRUEBAS");
            mainPage32613.informacion5.sendKeys("PRUEBAS");
            mainPage32613.informacion6.sendKeys("PRUEBAS");
            mainPage32613.informacion7.sendKeys("PRUEBAS");
            mainPage32613.informacion8.sendKeys("PRUEBAS");
            mainPage32613.informacion9.sendKeys("PRUEBAS");
            mainPage32613.informacion10.sendKeys("PRUEBAS");
            mainPage32613.informacion11.sendKeys("PRUEBAS");
            mainPage32613.informacion12.sendKeys("PRUEBAS");
            mainPage32613.informacion13.sendKeys("PRUEBAS");
            mainPage32613.informacion14.sendKeys("PRUEBAS");
            mainPage32613.informacion15.sendKeys("PRUEBAS");
            mainPage32613.informacion16.sendKeys("PRUEBAS");
            mainPage32613.informacion17.sendKeys("PRUEBAS");
            mainPage32613.informacion18.sendKeys("PRUEBAS");
            mainPage32613.informacion19.sendKeys("PRUEBAS");
            mainPage32613.informacion20.sendKeys("PRUEBAS");

            mainPage32613.capacitacionSeguridadConcientizacion.click();
            mainPage32613.capacitacion1.sendKeys("PRUEBAS");
            mainPage32613.capacitacion2.sendKeys("PRUEBAS");
            mainPage32613.capacitacion3.sendKeys("PRUEBAS");
            mainPage32613.capacitacion4.sendKeys("PRUEBAS");
            mainPage32613.capacitacion5.sendKeys("PRUEBAS");
            mainPage32613.capacitacion6.sendKeys("PRUEBAS");

            mainPage32613.manejoInvestigacionIncidentes.click();
            mainPage32613.manejo1.sendKeys("PRUEBAS");
            mainPage32613.manejo2.sendKeys("PRUEBAS");
            mainPage32613.manejo3.sendKeys("PRUEBAS");
            mainPage32613.manejo4.sendKeys("PRUEBAS");
            mainPage32613.manejo5.sendKeys("PRUEBAS");
            mainPage32613.manejo6.sendKeys("PRUEBAS");
            mainPage32613.manejo7.sendKeys("PRUEBAS");
            mainPage32613.inputGuardarSolicitud.click();

            //REQUISITOS NECESARIOS
            mainPage32613.inputSiguiente.click();
            //ANEXAR REQUISITOS
            mainPage32613.inputAdjuntarDocumentos.click();
            mainPage32613.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32613.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32613.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32613.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32613.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32613.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile26.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile27.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile28.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile29.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile30.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile33.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile34.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile35.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile36.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile37.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.inputDocumentosFile38.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32613.buttonAnexar.click();sleep(40000);
            mainPage32613.spanCerrar.click();sleep(500);
//            mainPage32613.Adjuntar.click();
            mainPage32613.inputSiguienteButton.click();sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite32613);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32613.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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
