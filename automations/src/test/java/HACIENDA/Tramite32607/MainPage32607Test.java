package HACIENDA.Tramite32607;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32607.MainPage32607;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage32607Test {
    MainPage32607 mainPage32607 = new MainPage32607();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32607  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso32607() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32607");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32607");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32607");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32607");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32607");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32607");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32607);
            mainPage32607.selecRol.sendKeys("Persona Moral");
            mainPage32607.btnacep.click();
            mainPage32607.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32607.SoliNew.click();
            mainPage32607.Hacienda.click();
            mainPage32607.linkResgistroComercioExterior.click();
            mainPage32607.linkSolicitudRegistroEsquemaIntegral.click();
            mainPage32607.linkSolicitudRegistroEsquemaCertificaci.click();sleep(500);
            //DATOS COMUNES
            mainPage32607.labelDatosComunes.click();
            mainPage32607.selectSolicitudListaCatalogo.sendKeys("Fabricación de juguetes, juegos de recreo y artículos deportivos");
            mainPage32607.inputMapDeclaracionSolicitudAcepto.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage32607.inputPropios.click();
            mainPage32607.inputEmpPropios.sendKeys("22");
            mainPage32607.selectSolicitudEmpleadosPropiosBimestre.sendKeys("Enero-Febrero");
            mainPage32607.inputIsr.click();
            mainPage32607.inputObreroPatronales.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto3.click();
            mainPage32607.inputAgregarSubcontratado.click();
            mainPage32607.inputSubcontratadoBusqueda.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscar.click();
            mainPage32607.inputSubcontratadoEmpleados.sendKeys("1222");
            mainPage32607.selectSubcontratadoBimestre.sendKeys("Marzo-Abril");
            mainPage32607.inputSubcontratadoAgregarModalEsquema.click();
            mainPage32607.buttonAceptar.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto4.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto8.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage32607.selectImmex.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            //mainPage32607.inputAgregarDomicilios.click();
            //mainPage32607.selectEntidadFederativaIdc.sendKeys("SINALOA");
            //mainPage32607.inputGridDomiciliosModal.click();
            //mainPage32607.inputAceptarDomicilios.click();

            mainPage32607.inputGridDomicilios.click();
            mainPage32607.inputModificarDomicilios.click();
            mainPage32607.inputInstalacion.click();
            mainPage32607.selectDomicilioTipoInstalacion.sendKeys("Planta Productiva");
            mainPage32607.inputProcesoProd.click();
            mainPage32607.inputAcredita.click();
            mainPage32607.inputPerfil.click();
            mainPage32607.inputOperacionesExt.click();
            mainPage32607.inputInstalacionCtpat.click();
            mainPage32607.inputAceptarDomicilios2.click();
            mainPage32607.spanAceptar.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto10.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto11.click();
            mainPage32607.inputArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32607.inputArchivoNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32607.inputMapDeclaracionSolicitudAcepto12.click();
            mainPage32607.inputInventario.click();
            mainPage32607.inputNombreInventario.sendKeys("QA");sleep(500);
            mainPage32607.inputAgregarInventario.sendKeys("QA");sleep(500);
            mainPage32607.inputAnexoInventario.click();
            mainPage32607.spanAceptar2.click();
            mainPage32607.aceptar.click();
            mainPage32607.inputMapDeclaracionSolicitudAcepto13.click();
            mainPage32607.inputAgregarSocio.click();
            mainPage32607.selectSocioCaracter.sendKeys("Representante legal con actos de dominio");
            mainPage32607.inputSocioTributarMexico.click();
            mainPage32607.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscar2.click();
            mainPage32607.selectSocioNacionalidad.sendKeys("AZERBAIJAN (REPUBLICA AZERBAIJANI)");
            mainPage32607.inputSocioAgregarModal.click();
            mainPage32607.spanAceptar3.click();

            mainPage32607.inputAgregarSocio.click();
            mainPage32607.selectSocioCaracter.sendKeys("Accionista");
            mainPage32607.inputSocioTributarMexico.click();
            mainPage32607.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscar2.click();
            mainPage32607.selectSocioNacionalidad.sendKeys("AUSTRIA");
            mainPage32607.inputSocioAgregarModal.click();
            mainPage32607.spanAceptar4.click();

            mainPage32607.inputAgregarSocio.click();
            mainPage32607.selectSocioCaracter.sendKeys("Administrador único");
            mainPage32607.inputSocioTributarMexico.click();
            mainPage32607.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscar2.click();
            mainPage32607.selectSocioNacionalidad.sendKeys("BAHAMAS");
            mainPage32607.inputSocioAgregarModal.click();
            mainPage32607.spanAceptar5.click();

            mainPage32607.inputAgregarSocio.click();
            mainPage32607.selectSocioCaracter.sendKeys("Socio");
            mainPage32607.inputSocioTributarMexico.click();
            mainPage32607.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscar2.click();
            mainPage32607.selectSocioNacionalidad.sendKeys("BAHREIN ");
            mainPage32607.inputSocioAgregarModal.click();
            mainPage32607.spanAceptar6.click();

            mainPage32607.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32607.inputAcepto.click();
            mainPage32607.inputAcepto2.click();
            //TERCERO RELACIONADO
            mainPage32607.labelTercerosRelacionados.click();
            mainPage32607.inputTercero.sendKeys("LEQI8101314S7");sleep(500);
            mainPage32607.inputBuscar3.click();sleep(500);
            mainPage32607.spanAceptar8.click();
            mainPage32607.inputAgregarEnlaceOperativo.click();
            mainPage32607.input.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscarEnlaceOperativo.click();
            mainPage32607.inputAceptarEnlace.click();
            mainPage32607.inputAgregarEnlaceOperativo.click();
            mainPage32607.input.sendKeys("FOGI720331SIA");
            mainPage32607.inputBuscarEnlaceOperativo.click();
            mainPage32607.inputTerceroEnlaceOperativoSuplente.click();
            mainPage32607.inputAceptarEnlace.click();
            //AERONAVES
            mainPage32607.labelAeronaves.click();
            mainPage32607.inputComExt.click();
            //mainPage32607.imageCalendar.click();
            //mainPage32607.inputFechaIniOperaCom.doubleClick();
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32607.inputFechaIniOperaCom); sleep(1000);
            //mainPage32607.inputFechaPagoOea.sendKeys("01/04/2025");
            Selenide.executeJavaScript("arguments[0].value = '05/04/2025';", mainPage32607.inputFechaPagoOea); sleep(1000);
            mainPage32607.inputMontoOea.sendKeys("333");
            mainPage32607.inputOperBancOea.sendKeys("123");
            mainPage32607.inputLlaveOea.sendKeys("543");
            mainPage32607.inputAgregarTransportista.click();
            mainPage32607.inputTransportistaCertificacion.sendKeys("LEQI8101314S7");
            mainPage32607.inputBuscarEmpresa.click();
            mainPage32607.inputGuardarTransportista.click();
            mainPage32607.spanAceptar9.click();
            mainPage32607.inputImmex.click();
            mainPage32607.inputNumeroAeronaves.sendKeys("50");
            mainPage32607.inputModalidadAeronaves.sendKeys("50");
            mainPage32607.inputIva.click();
            mainPage32607.inputAeronaves.click();
            mainPage32607.inputAeronaves2.click();
            //PERFILES
            mainPage32607.spanPerfilesTittle.click();
            mainPage32607.inputAntiguedadEmpresa.sendKeys("prueba");sleep(500);
            mainPage32607.inputProductosEmpresa.sendKeys("prueba");sleep(500);
            mainPage32607.inputNumEmbarquesExpEmpresa.sendKeys("234");
            mainPage32607.inputNumEmbarquesImoEmpresa.sendKeys("543");
            mainPage32607.inputNumEmpleadosTotalEmpresa.sendKeys("123");
            mainPage32607.inputSuperficieAutoEmpresa.sendKeys("12341234");
            mainPage32607.inputCtpatEmpresa.click();
            mainPage32607.inputNiverCertificadoEmpresa.sendKeys("234");
            mainPage32607.inputCtpatEmpresa2.sendKeys("345");
            mainPage32607.inputCodigoMidempresa.sendKeys("345");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32607.inputPerfilEmpFecUltima); sleep(1000);
            mainPage32607.inputEmpresaPip.click();
            mainPage32607.inputNumRegistroPipempresa.sendKeys("33");
            mainPage32607.inputOeaEmpresa.click();
            mainPage32607.inputNomProgramapaisOeaEmpresa.sendKeys("México");
            mainPage32607.inputNumRegistroOeaEmpresa.sendKeys("33");
            mainPage32607.inputSuministroEmpresa.click();
            mainPage32607.inputNombreProgramaOtrosEmpresa.sendKeys("SOLARIS");
            mainPage32607.inputNumRegistroOtrosEmpresa.sendKeys("33");
            Selenide.executeJavaScript("arguments[0].value = '07/04/2025';", mainPage32607.inputPerfilEmpFechaVigencia); sleep(1000);
            mainPage32607.inputPerfilNombreCetificacion.sendKeys("JAVIER");
            mainPage32607.inputPerfilCategoriaCertificacion.sendKeys("DELIVERY");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32607.inputPerfilEmpFechaCertificacion); sleep(1000);
            //Planeación de la seguridad en la cadena de suministros
            mainPage32607.linkPlaneaciSeguridadCadenaSuministros.click();
            mainPage32607.inputProcedDocRiesgoEmpresa.click();
            mainPage32607.inputProcedimientosPolSegEmp.click();
            mainPage32607.textareaNombrepuesto.sendKeys("PRUEBA");
            mainPage32607.textareaFuentesInformacionCal.sendKeys("PRUEBA");
            mainPage32607.textareaPoliticasSeguridadEmpresa.sendKeys("PRUEBA");
            mainPage32607.textareaResponsableRevisionAct.sendKeys("PRUEBA");
            mainPage32607.textareaPeriodicidadActualizacion.sendKeys("PRUEBA");
            mainPage32607.textareaProgramaDifusion.sendKeys("PRUEBA");
            mainPage32607.inputRegistoCapacitacion.click();
            mainPage32607.inputProcDocumentado.click();
            mainPage32607.textareaPerfilPlaneacionDesDocument.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilPlaneacionResponsableAuditorias.sendKeys("PRUEBA");
            mainPage32607.inputEnfoqueOrg.click();
            mainPage32607.textareaPerfilPlaneacionProcesoTopicos.sendKeys("PRUEBA");
            mainPage32607.inputRegistroResultAud.click();
            mainPage32607.textareaProgamacionAud.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilPlaneacionParticipanteAuditoria.sendKeys("PRUEBA");
            mainPage32607.inputGerenciaResultAud.click();
            mainPage32607.inputProcedimientoConti.click();
            mainPage32607.textareaPerfilPlaneacionDesSituaciones.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilPlaneacionDesMecanismos.sendKeys("PRUEBA");
            mainPage32607.inputCapacitacionesPlanContin.click();
            mainPage32607.linkSeguridadSica.click();
            //Seguridad física
            mainPage32607.textareaPerfilSegFisicaDes.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaForma.sendKeys("PRUEBA");
            mainPage32607.textareaPersonalInspeccionInst.sendKeys("PRUEBA");
            mainPage32607.inputPerfilSegFisicaNum.sendKeys("123");
            mainPage32607.textareaPerfilSegFisicaHorario.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaForma2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDetalles.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaControles.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaAreas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaCaracteristicas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaBardas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPeriodo.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaResp.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDesc.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaSepara.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaAreas2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes3.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaRespon.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaIdentificacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaControl.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPol.sendKeys("PRUEBA");
            mainPage32607.inputControlExtLlaves.click();
            mainPage32607.textareaPerfilSegFisicaResponsables.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaRegistro.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPerdida.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes4.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes5.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaAreas3.sendKeys("PRUEBA");
            mainPage32607.inputPlantaPoderAux.click();
            mainPage32607.textareaPerfilSegFisicaSum.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaIluminacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaResp2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPrograma.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDesc2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaCta.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaAparatos.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes6.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPoliticas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPrograma2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaCuenta.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDesc3.sendKeys("PRUEBA");
            mainPage32607.inputBlnpuertasVentanasAlarma.click();
            mainPage32607.textareaPerfilSegFisicaProc.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDes7.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaNumcamaras.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDonde.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaUbicacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaHorarios.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaRevision.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDocumentan.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaTiempo.sendKeys("PRUEBA");
            mainPage32607.inputSistemaRespaldado.click();
            mainPage32607.textareaPerfilSegFisicaPlanta.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaSist.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaAdi.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegFisicaDesc4.sendKeys("PRUEBA");
            mainPage32607.inputProvConAccesoCam.click();
            mainPage32607.textareaPerfilSegFisicaForma3.sendKeys("PRUEBA");
            //Controles de acceso físico
            mainPage32607.linkControlesAccesoSico.click();
            mainPage32607.textareaPerfilControlesDesProc.sendKeys("PRUEBA");
            mainPage32607.inputPerfilControlesNumPersonal.sendKeys("123");
            mainPage32607.textareaPerfilControlesCargosFun.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesContratoServicio.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesProc2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesMecanismosIdentificacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesUniformePersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesIdentificarPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesEmpresa.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesAcceso.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesProc3.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesRegistroBitacora.sendKeys("PRUEBA");
            mainPage32607.inputRegistroVisitantesProveedores.click();
            mainPage32607.textareaPerfilControlesPersonaResp.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesDesMensajeria.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesProveedorServicio.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesFormaRevisa.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilControlesAccionDet.sendKeys("PRUEBA");
            //Socios Comerciales
            mainPage32607.linkSociosComerciales.click();
            mainPage32607.textareaPerfilSocioComerPrograma.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerDesc.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerReg.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerForma.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerAcuerdo.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerPrograma2.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerDes.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerPeriocidad.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerPrograma3.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerRegistro.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerFormato.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerMedidas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSocioComerPeriodicidad.sendKeys("PRUEBA");
            // Seguridad de procesos
            mainPage32607.linkSeguridadProcesos.click();
            mainPage32607.textareaPerfilSegProceProceso.sendKeys("123");sleep(500);
            mainPage32607.textareaPerfilSegProceExplicar.sendKeys("123");sleep(500);
            mainPage32607.textareaPerfilSegProceDescProcedimientoEntrega.sendKeys("PRUEBA");sleep(500);
            mainPage32607.textareaPerfilSegProceEmpresaServiciosCustodia.sendKeys("PRUEBA");sleep(500);
            mainPage32607.textareaPerfilSegProceDesProcInfo.sendKeys("PRUEBA");sleep(500);
            mainPage32607.textareaPerfilSegProceDesProcesamiento.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegProceUtilizaSisInformatico.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegProceFormaAsocTranInfo.sendKeys("PRUEBA");
            // Gestión Aduanera
            mainPage32607.linkGestionAduanera.click();
            mainPage32607.textareaGestAduaneraDesProcSelec.sendKeys("PRUEBA");
            mainPage32607.textareaGestAduaneraCriteriosSeleccion.sendKeys("PRUEBA");
            mainPage32607.textareaGestAduaneraMetodosEvalPer.sendKeys("PRUEBA");
            mainPage32607.textareaGestAduaneraIndicadoresEvalua.sendKeys("PRUEBA");
            mainPage32607.textareaGestAduaneraNomNumPatente.sendKeys("PRUEBA");
            mainPage32607.inputProcDocCtrlInv.click();
            mainPage32607.inputProgremaImmex.click();
            mainPage32607.textareaGestAduaneraNumRegistroImmex.sendKeys("123");
            mainPage32607.inputGestAdOtroProg.click();
            mainPage32607.textareaGestAduaneraNomPrograma.sendKeys("PRUEBA");
            mainPage32607.textareaGestAduaneraNumRegistro.sendKeys("123");
            // Seguridad de los vehículos de carga
            mainPage32607.linkSegTransporte.click();
            mainPage32607.textareaPerfilSegTransporteDetTipoVehiculo.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegTransporteUnidadesPropiedadEmp.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegTransporteEmpTranspContratadas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegTransporteReparaMattoTrans.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegTransporteVehiculosCargaContRemolTraficoInt.sendKeys("PRUEBA");
            mainPage32607.inputRevAleaPeriod.click();
            mainPage32607.inputEmpAlmacenaCont.click();
            mainPage32607.textareaPerfilSegTransporteTipoCandadoSellos.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegTransporteUtilizarAlgunContedor.sendKeys("PRUEBA");
            // Seguridad del personal
            mainPage32607.linkPerfilSegPers.click();
            mainPage32607.textareaPerfilSegPersDesProcContPers.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersReqDocExigida.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersPruebasExamSol.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersAreasCriticas.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersReqAdicionales.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersCandidatoFirmaDoc.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersCuentaProcDocCont.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersDesBajaPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersRespProcBajaPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersEntregaIdentif.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersCuentaRegBaja.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegPersMantieneRegBaja.sendKeys("PRUEBA");
            mainPage32607.inputEmpBd.click();
            // Seguridad de la información y documentación
            mainPage32607.linkPerfilSegInfor.click();
            mainPage32607.textareaPerfilSegInforPersDesProcArchivar.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforDesProcArchivar.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforMedidasSegInfo.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforDispositivoPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforFrecuenciaCopias.sendKeys("PRUEBA");
            mainPage32607.inputEquipoCompSistRes.click();
            mainPage32607.textareaPerfilSegInforProcRespaldoInformacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforPlanContinuidadNegocioIncidente.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforFrecuenciaLocalizacionCopiaSeguridad.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforCopiaSeguridadInstalaciones.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforPruebasRecuperacionDatos.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforesProcProteccion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforPoliticaProteccion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforDetalleSistMult.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforResponsableProtecSist.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforCcuentasIndivRestringido.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforSistemasProtegidos.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforFirewall.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforMedidasPrevProductosTecno.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforProcFormateo.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforProcBajaPersonal.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilSegInforMedidaIncidente.sendKeys("PRUEBA");
            // Capacitación en seguridad y concientización
            mainPage32607.linkPerfilCapacitacionT.click();
            mainPage32607.textareaPerfilCapacitacionTemasPrograma.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionMomentoImparte.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionPeriodicidadCapac.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionFormaDocCapac.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionFomentaParticipacion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionDesProcMatSeg.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionCaboDifusion.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionTemasCubren.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionServScPolSeg.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilCapacitacionFormaDocumPartic.sendKeys("PRUEBA");
            // Manejo e investigación de incidentes
            mainPage32607.linkPerfilManejo.click();
            mainPage32607.textareaPerfilManejoDesProcAnomalias.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoResponsableReporta.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoDetalleComAuto.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoLlevaRegReporte.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoDesProcIniInv.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoResponsableInv.sendKeys("PRUEBA");
            mainPage32607.textareaPerfilManejoDoctoExpediente.sendKeys("PRUEBA");
            mainPage32607.inputGuardarSolicitud.click();
            //REQUISITOS NECESARIOS
            mainPage32607.inputSiguiente.click();
            //ANEXAR REQUISITOS
            mainPage32607.inputAdjuntarDocumentos.click();
            mainPage32607.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32607.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32607.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32607.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32607.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32607.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile26.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile27.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile28.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile29.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile30.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile33.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile34.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile35.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile36.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.inputDocumentosFile37.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage32607.buttonAnexar.click();sleep(40000);
            mainPage32607.spanCerrar.click();sleep(500);
//            mainPage32607.Adjuntar.click();
            mainPage32607.inputSiguienteButton.click();sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite32607);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32607.folio.getText();

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
}

