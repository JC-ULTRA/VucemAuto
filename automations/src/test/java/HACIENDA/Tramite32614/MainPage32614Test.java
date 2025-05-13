package HACIENDA.Tramite32614;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
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
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32614Test {
    MainPage32614 mainPage32614 = new MainPage32614();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32614  = new TramitesFirmasLG(
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
    public void Proceso32614() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32614");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32614");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32614");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32614");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32614");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32614");

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
            loginFirmSoli.login(tramite32614);
            mainPage32614.selecRol.sendKeys("Persona Moral");
            mainPage32614.btnacep.click();
            mainPage32614.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32614.SoliNew.click();
            mainPage32614.Hacienda.click();
            mainPage32614.linkResgistroComercioExterior.click();
            mainPage32614.linkSolicitudRegistroEsquemaIntegral.click();
            mainPage32614.linkSolicitudRegistroEsquemaCertificaci.click();sleep(500);
            //DATOS COMUNES
            mainPage32614.labelDatosComunes.click();
            mainPage32614.selectSolicitudListaCatalogo.sendKeys("Fabricación de juguetes, juegos de recreo y artículos deportivos");
            mainPage32614.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32614.inputPropios.click();
            mainPage32614.inputEmpPropios.sendKeys("22");
            mainPage32614.selectSolicitudEmpleadosPropiosBimestre.sendKeys("Enero-Febrero");
            mainPage32614.inputIsr.click();
            mainPage32614.inputObreroPatronales.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32614.inputAgregarSubcontratado.click();
            mainPage32614.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32614.inputBuscar.click();
            mainPage32614.inputSubcontratadoEmpleados.sendKeys("1222");
            mainPage32614.selectSubcontratadoBimestre.sendKeys("Marzo-Abril");
            mainPage32614.inputSubcontratadoAgregarModalEsquema.click();
            mainPage32614.buttonAceptar.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto4.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32614.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage32614.selectImmex.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            mainPage32614.inputGridDomicilios.click();
            mainPage32614.inputModificarDomicilios.click();
            mainPage32614.inputInstalacion.click();
            mainPage32614.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32614.procesoProductivoSi.click();
            mainPage32614.usoGoceInmuebleSi.click();
            mainPage32614.reconocimientoMutuoSi.click();
            mainPage32614.btnHacerModificacion.click();
            mainPage32614.btnAceptarModificacion.click();
            mainPage32614.articulo17KSi.click();
            mainPage32614.suspesionPadronNo.click();
            mainPage32614.provedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32614.agregarProvedoresExtranjeros.click();sleep(1000);
            clickOkButton();
            mainPage32614.provedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32614.agregarProvedoresNacionales.click();
            mainPage32614.btnOkProvedoresNacionales.click();
            mainPage32614.querellaNo.click();
            mainPage32614.inventariosSi.click();
            mainPage32614.nombreInventarios.sendKeys("PRUEBAS");
            mainPage32614.lugarInventarios.sendKeys("QA");
            mainPage32614.anexo24InventariosOk.click();
            mainPage32614.btnAgregarInventario.click();sleep(1000);
            mainPage32614.btnAceptarInventario.click();
            mainPage32614.rmfSi.click();
            mainPage32614.agregarSocio.click();
            mainPage32614.caracterSocio.sendKeys("administrador unico");
            mainPage32614.tributarEnMexicoNo.click();
            mainPage32614.tipoPersona.sendKeys("Moral");
            mainPage32614.tipoPersona.click();
            mainPage32614.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32614.nombreEmpresaSocio.sendKeys("PRUEBAS");
            mainPage32614.btnAgregarSocio.click();sleep(1000);
            mainPage32614.btnAceptarSocio.click();
            mainPage32614.sociosAccionistasNo.click();
            mainPage32614.manifiesto1.click();
            mainPage32614.manifiesto2.click();
            /// Terceros Relacionados
            scrollDecremento();
            mainPage32614.tercerosRelacionados.click();
            mainPage32614.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32614.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32614.btnAceptarRepresentanteL.click();
            mainPage32614.btnAgregarEnlaceOperativo.click();
            mainPage32614.rfcEnlaceO.sendKeys("LEQI8101314S7");
            mainPage32614.btnBuscarEnlaceO.click();
            mainPage32614.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32614.btnAñadirEnlaceO.click();
            ///
            mainPage32614.parqueIndustrial.click();
            mainPage32614.fraccionIV.click();
            mainPage32614.perfilParqueIndustrial.click();
            mainPage32614.autorizoReconocimientoMutuo.click();
            mainPage32614.rfcSocioComercial.click();
            mainPage32614.nombreRazonSocioComercial.click();
            mainPage32614.direccionSocioComercial.click();
            mainPage32614.paginaSocioComercial.click();
            mainPage32614.correoSocioComercial.doubleClick();
            mainPage32614.telefonoSocioComercial.click();
            mainPage32614.nombrePagina.sendKeys("www.prueba.com");sleep(1000);
            mainPage32614.correo.sendKeys("pruebas@pruebas.qa");sleep(1000);
            mainPage32614.lada1.sendKeys("55");
            mainPage32614.num1.sendKeys("12345678");
            mainPage32614.informacionPublica.click();
            mainPage32614.domicilioInstalacion.sendKeys("DOMICILIO DE PRUEBA ULTRASIST");
            mainPage32614.antiguedad.click();
            mainPage32614.antiguedad.sendKeys("10");
            mainPage32614.actividadPreponderante.sendKeys("PUREBAS ULTRASIST");
            mainPage32614.empleadosTotales.sendKeys("50");
            mainPage32614.superficie.sendKeys("1000");
            mainPage32614.nombreOtrasCertificaciones.sendKeys("PRUEBAS ULTRASIST");
            mainPage32614.categoriaOtrasCertificaciones.sendKeys("PRUEBAS");
            mainPage32614.vigenciaOtrasCertificaciones.click();
            mainPage32614.selecVigenciaCertificaciones.click();
            mainPage32614.planeacion.click();
            mainPage32614.planeacion1.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis1.click();sleep(500);
            mainPage32614.analisis2.click();
            mainPage32614.planeacion2.sendKeys("PRUEBAS");
            mainPage32614.planeacion3.sendKeys("PRUEBAS");
            mainPage32614.planeacion4.sendKeys("PRUEBAS");
            mainPage32614.planeacion5.sendKeys("PRUEBAS");
            mainPage32614.planeacion6.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis3.click();sleep(500);
            mainPage32614.analisis4.click();sleep(500);
            mainPage32614.analisis5.click();sleep(500);
            mainPage32614.planeacion7.sendKeys("PRUEBAS");
            mainPage32614.planeacion8.sendKeys("PRUEBAS");
            mainPage32614.planeacion9.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis6.click();
            mainPage32614.planeacion10.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis7.click();
            mainPage32614.planeacion11.sendKeys("PRUEBAS");
            mainPage32614.planeacion12.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis8.click();
            mainPage32614.planeacion13.sendKeys("PRUEBAS");
            mainPage32614.planeacion14.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.analisis9.click();

            /// 2. Seguridad fisica
            mainPage32614.seguridadFisica.click();
            mainPage32614.seguridad1.sendKeys("PRUEBAS");
            mainPage32614.seguridad2.sendKeys("PRUEBAS");
            mainPage32614.seguridad3.sendKeys("10");
            mainPage32614.seguridad4.sendKeys("PRUEBAS");
            mainPage32614.seguridad5.sendKeys("PRUEBAS");
            mainPage32614.seguridad6.sendKeys("PRUEBAS");
            mainPage32614.seguridad7.sendKeys("PRUEBAS");
            mainPage32614.seguridad8.sendKeys("PRUEBAS");
            mainPage32614.seguridad9.sendKeys("PRUEBAS");
            mainPage32614.seguridad10.sendKeys("PRUEBAS");
            mainPage32614.seguridad11.sendKeys("PRUEBAS");
            mainPage32614.seguridad12.sendKeys("PRUEBAS");
            mainPage32614.seguridad13.sendKeys("PRUEBAS");
            mainPage32614.seguridad14.sendKeys("PRUEBAS");
            mainPage32614.seguridad15.sendKeys("PRUEBAS");
            mainPage32614.seguridad16.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.estacionamientos.click();
            mainPage32614.seguridad17.sendKeys("PRUEBAS");
            mainPage32614.seguridad18.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.llaves.click();
            mainPage32614.seguridad19.sendKeys("PRUEBAS");
            mainPage32614.seguridad20.sendKeys("PRUEBAS");
            mainPage32614.seguridad21.sendKeys("PRUEBAS");
            mainPage32614.seguridad22.sendKeys("PRUEBAS");
            mainPage32614.seguridad23.sendKeys("PRUEBAS");
            mainPage32614.seguridad24.sendKeys("PRUEBAS");
            mainPage32614.seguridad25.sendKeys("PRUEBAS");
            mainPage32614.seguridad26.sendKeys("PRUEBAS");
            mainPage32614.seguridad27.sendKeys("PRUEBAS");
            mainPage32614.seguridad28.sendKeys("PRUEBAS");
            mainPage32614.seguridad29.sendKeys("PRUEBAS");
            mainPage32614.seguridad30.sendKeys("PRUEBAS");
            mainPage32614.seguridad31.sendKeys("PRUEBAS");
            mainPage32614.seguridad32.sendKeys("PRUEBAS");
            mainPage32614.seguridad33.sendKeys("PRUEBAS");
            mainPage32614.seguridad34.sendKeys("PRUEBAS");
            mainPage32614.seguridad35.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.alarmas.click();
            mainPage32614.seguridad36.sendKeys("PRUEBAS");
            mainPage32614.seguridad37.sendKeys("PRUEBAS");
            mainPage32614.seguridad38.sendKeys("PRUEBAS");
            mainPage32614.seguridad39.sendKeys("PRUEBAS");
            mainPage32614.seguridad40.sendKeys("PRUEBAS");
            mainPage32614.seguridad41.sendKeys("PRUEBAS");
            mainPage32614.seguridad42.sendKeys("PRUEBAS");
            mainPage32614.seguridad43.sendKeys("PRUEBAS");
            mainPage32614.seguridad44.sendKeys("PRUEBAS");
            mainPage32614.seguridad45.sendKeys("PRUEBAS");
            mainPage32614.seguridad46.sendKeys("PRUEBAS");
            mainPage32614.seguridad47.sendKeys("PRUEBAS");
            mainPage32614.seguridad48.sendKeys("PRUEBAS");
            mainPage32614.seguridad49.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.alarmas2.click();
            mainPage32614.seguridad50.sendKeys("PRUEBAS");

            /// 3. Controles Acceso Fisico
            mainPage32614.controlesAccesoFisico.click();
            mainPage32614.controles1.sendKeys("PRUEBAS");
            mainPage32614.controles2.sendKeys("25");
            mainPage32614.controles3.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.personal.click();
            mainPage32614.controles4.sendKeys("PRUEBAS");
            mainPage32614.controles5.sendKeys("PRUEBAS");
            mainPage32614.controles6.sendKeys("PRUEBAS");
            mainPage32614.controles7.sendKeys("PRUEBAS");
            mainPage32614.controles8.sendKeys("PRUEBAS");
            mainPage32614.controles9.sendKeys("PRUEBAS");
            mainPage32614.controles10.sendKeys("PRUEBAS");
            mainPage32614.controles11.sendKeys("PRUEBAS");
            mainPage32614.controles12.sendKeys("PRUEBAS");
            mainPage32614.controles13.sendKeys("PRUEBAS");
            mainPage32614.controles14.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.visitantes.click();
            mainPage32614.controles15.sendKeys("PRUEBAS");
            mainPage32614.controles16.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.identificacion.click();
            mainPage32614.controles17.sendKeys("PRUEBAS");
            mainPage32614.controles18.sendKeys("PRUEBAS");

            mainPage32614.sociosComerciales.click();sleep(500);
            mainPage32614.criterios.click();
            mainPage32614.socios1.sendKeys("PRUEBAS");
            mainPage32614.socios2.sendKeys("PRUEBAS");
            mainPage32614.socios3.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.requerimentos.click();
            mainPage32614.socios4.sendKeys("PRUEBAS");
            mainPage32614.socios5.sendKeys("PRUEBAS");
            mainPage32614.socios6.sendKeys("PRUEBAS");
            mainPage32614.socios7.sendKeys("PRUEBAS");
            mainPage32614.socios8.sendKeys("PRUEBAS");
            mainPage32614.socios9.sendKeys("PRUEBAS");
            mainPage32614.socios10.sendKeys("PRUEBAS");
            mainPage32614.socios11.sendKeys("PRUEBAS");

            mainPage32614.seguridadProcesos.click();
            mainPage32614.proceso1.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.entrega.click();

            mainPage32614.seguridadVehiculos.click();sleep(500);
            mainPage32614.almacenaje.click();
            mainPage32614.vehiculos1.sendKeys("PRUEBAS");

            mainPage32614.seguridadPersonal.click();
            mainPage32614.personal1.sendKeys("PRUEBAS");
            mainPage32614.personal2.sendKeys("PRUEBAS");
            mainPage32614.personal3.sendKeys("PRUEBAS");
            mainPage32614.personal4.sendKeys("PRUEBAS");
            mainPage32614.personal5.sendKeys("PRUEBAS");
            mainPage32614.personal6.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.verificacion.click();
            mainPage32614.personal7.sendKeys("PRUEBAS");
            mainPage32614.personal8.sendKeys("PRUEBAS");
            mainPage32614.personal9.sendKeys("PRUEBAS");
            mainPage32614.personal10.sendKeys("PRUEBAS");
            mainPage32614.personal11.sendKeys("PRUEBAS");
            mainPage32614.personal12.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.administracion1.click();sleep(500);
            mainPage32614.administracion2.click();sleep(500);
            mainPage32614.administracion3.click();

            mainPage32614.seguridadInformacionyDocumentacion.click();
            mainPage32614.informacion1.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.documentos1.click();
            mainPage32614.informacion2.sendKeys("PRUEBAS");
            mainPage32614.informacion3.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.documentos2.click();
            mainPage32614.informacion4.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.documentos3.click();sleep(500);
            mainPage32614.seguridadTecnologia.click();
            mainPage32614.informacion5.sendKeys("PRUEBAS");
            mainPage32614.informacion6.sendKeys("PRUEBAS");
            mainPage32614.informacion7.sendKeys("PRUEBAS");
            mainPage32614.informacion8.sendKeys("PRUEBAS");
            mainPage32614.informacion9.sendKeys("PRUEBAS");
            mainPage32614.informacion10.sendKeys("PRUEBAS");
            mainPage32614.informacion11.sendKeys("PRUEBAS");
            mainPage32614.informacion12.sendKeys("PRUEBAS");

            mainPage32614.capacitacionSeguridadConcientizacion.click();
            mainPage32614.capacitacion1.sendKeys("PRUEBAS");
            mainPage32614.capacitacion2.sendKeys("PRUEBAS");
            mainPage32614.capacitacion3.sendKeys("PRUEBAS");
            mainPage32614.capacitacion4.sendKeys("PRUEBAS");
            mainPage32614.capacitacion5.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.revision.click();
            mainPage32614.capacitacion6.sendKeys("PRUEBAS");

            mainPage32614.manejoInvestigacionIncidentes.click();
            mainPage32614.manejo1.sendKeys("PRUEBAS");
            mainPage32614.manejo2.sendKeys("PRUEBAS");
            mainPage32614.manejo3.sendKeys("PRUEBAS");
            mainPage32614.manejo4.sendKeys("PRUEBAS");
            mainPage32614.manejo5.sendKeys("PRUEBAS");
            mainPage32614.manejo6.sendKeys("PRUEBAS");
            mainPage32614.manejo7.sendKeys("PRUEBAS");sleep(500);
            mainPage32614.investigacion.click();

            mainPage32614.numeroOperacion.sendKeys("821679371");
            mainPage32614.bancoPago.sendKeys("BANAMEX");
            mainPage32614.llaveDepago.sendKeys(llavePago);
            mainPage32614.fechadePago.click();
            mainPage32614.selecFechadePago.click();

            scrollDecremento();
            mainPage32614.ctpat.click();
            mainPage32614.autorizaCBP.click();
            mainPage32614.instalacionesCBP.click();
            mainPage32614.suspencionCancelacion.click();

            mainPage32614.inputGuardarSolicitud.click();

            //REQUISITOS NECESARIOS
            mainPage32614.inputSiguiente.click();
            //ANEXAR REQUISITOS
            mainPage32614.inputAdjuntarDocumentos.click();
            mainPage32614.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32614.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32614.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32614.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32614.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32614.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.inputDocumentosFile25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32614.buttonAnexar.click();sleep(28000);
            mainPage32614.spanCerrar.click();sleep(500);
//            mainPage32614.Adjuntar.click();
            mainPage32614.inputSiguienteButton.click();sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite32614);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32614.folio.getText();

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
