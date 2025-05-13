package HACIENDA.Tramite32612;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
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
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32612Test {

    MainPage32612 mainPage32612 = new MainPage32612();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32612 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
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
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32612() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32612");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32612");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32612");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32612");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32612");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32612");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32612);
            mainPage32612.selecRol.sendKeys("Persona Moral");
            mainPage32612.btnacep.click();
            mainPage32612.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32612.SoliNew.click();
            mainPage32612.hacienda.click();
            mainPage32612.registrosComercioExt.click();
            mainPage32612.solicitudRegistro.click();
            mainPage32612.rubroAgenteAduanal.click();
            mainPage32612.datosComunes.click();
            mainPage32612.servicio.sendKeys("Reparación, re-trabajo o mantenimiento de mercancías");
            mainPage32612.cumplimientoObligacionesSi.click();sleep(400);
            mainPage32612.autorizoSATSi.click();
            mainPage32612.empleadosPropiosSi.click();
            mainPage32612.numEmpleadosPropios.sendKeys("1");
            mainPage32612.bimestreEmpleadosPropios.sendKeys("Julio - Agosto");
            mainPage32612.isrNo.click();
            mainPage32612.btnAceptarISR.click();
            mainPage32612.pagoCuotasObreroPatronalesNo.click();
            mainPage32612.btnAceptarCuotasPatronales.click();
            mainPage32612.subcontratacionNo.click();
            mainPage32612.listadoEmpresasNo.click();
            mainPage32612.articulo64BCFFNo.click();
            Selenide.executeJavaScript("arguments[0].click();", mainPage32612.articulo64BBisSi);
            mainPage32612.sellosVigentes.click();
            mainPage32612.articulo17HBis.click();
            mainPage32612.articulo17KSi.click();
            mainPage32612.querellaNo.click();
            mainPage32612.ingresoMensual.click();
            mainPage32612.sociosAccionistasNo.click();
            mainPage32612.manifiesto1.click();
            mainPage32612.manifiesto2.click();
            /// Terceros Relacionados
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32612.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32612.tercerosRelacionados.click();
            mainPage32612.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32612.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32612.btnAceptarRepresentanteL.click();
            mainPage32612.btnAgregarEnlaceOperativo.click();
            mainPage32612.rfcEnlaceO.sendKeys("MAVL621207C95");
            mainPage32612.btnBuscarEnlaceO.click();
            mainPage32612.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32612.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            //scrollDecremento();
            mainPage32612.agenteAduanal.click();
            mainPage32612.aduanaDescripcion.sendKeys("AGUA PRIETA, SONORA.");
            mainPage32612.aduanasAutorizadas.doubleClick();
            mainPage32612.inputNumTraIMSS.sendKeys("123");
            mainPage32612.inputNumTraServ.sendKeys("324");
            mainPage32612.inputServicios.sendKeys("PRUEBAS QA");
            mainPage32612.inputAgregarInstalacion.click();
            mainPage32612.inputRazonSocial.sendKeys("LEQI8101314S7");
            mainPage32612.inputEntidadFederativa.sendKeys("AGUASCALIENTES");
            mainPage32612.inputInstalacionModal.click();
            mainPage32612.inputAceptarInstalacion.click();
            mainPage32612.inputSelecionInstalacion.click();
            mainPage32612.inputModificarInstalacion.click();
            mainPage32612.inputInstalacionPrincipal.click();
            mainPage32612.inputPedimento.click();
            mainPage32612.inputActualizarPerfil.click();
            mainPage32612.inputAceptarModificacion.click();
            mainPage32612.aceptarModif.click();

            mainPage32612.input3034AA.click();
            mainPage32612.inputAgregarMandatorio.click();
            mainPage32612.inputMandatorioRFC.sendKeys("MAVL621207C95");
            mainPage32612.inputBuscarMandatorio.click();
            mainPage32612.inputCumplimiento.click();
            mainPage32612.inputGuardarMandatorio.click();
            mainPage32612.inputAceptarMandatorio.click();
            mainPage32612.input3035AA.click();
            mainPage32612.input306AA.click();
            mainPage32612.input307AA.click();
            mainPage32612.inputReconocimientoMutuo.click();
            mainPage32612.inputRFCAgen.click();
            mainPage32612.inputRazonSocialAgen.click();
            mainPage32612.inputDireccionFiscalAgen.click();
            mainPage32612.inputPaginaElectronicaAgen.click();
            mainPage32612.inputCorreoElectronicoAgen.click();
            mainPage32612.inputTelefonoAgen.click();
            mainPage32612.inputPublica.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage32612.inputNumOperacion.setValue(String.valueOf(nFacturaR));
            mainPage32612.inputBanco.sendKeys("HSBC");
            Random variant = new Random();
            int nLlaveP = 10_000_000 + variant.nextInt(90_000_000);
            mainPage32612.inputLlavePago.setValue(String.valueOf(nLlaveP));
            Selenide.executeJavaScript("arguments[0].value = '01/05/2025';", mainPage32612.inputFechaPago);sleep(100);
            //PERFILES
            mainPage32612.spanPerfilesTittle.click();
            mainPage32612.inputNomAgenAdua.sendKeys("prueba");sleep(500);
            mainPage32612.inputTipoInstalacion.sendKeys("prueba");sleep(500);
            mainPage32612.inputAntiguedad.sendKeys("234");
            mainPage32612.inputActividad.sendKeys("PRUEBA");
            mainPage32612.inputTipoServicio.sendKeys("PRUEBA");
            mainPage32612.inputNumEmbarque.sendKeys("123");
            mainPage32612.inputEmbarque.sendKeys("235");
            mainPage32612.inputNumEmpleado.sendKeys("234");
            mainPage32612.inputSuperficie.sendKeys("345");
            mainPage32612.inputPrograma.click();
            mainPage32612.inputCertNombre.sendKeys("PROTEO");
            mainPage32612.inputCertCategoria.sendKeys("CLASIFICADA");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32612.inputCertFecha); sleep(1000);
             //Planeación de la seguridad en la cadena de suministros
            mainPage32612.linkPlaneaciSeguridadCadenaSuministros.click();
            mainPage32612.inputProcedPerm.click();
            mainPage32612.inputMecanismoControl.click();
            mainPage32612.textareaComiteSeg.sendKeys("PRUEBA");
            mainPage32612.textareaFuentesInformacionCal.sendKeys("PRUEBA");
            mainPage32612.textareaPoliticasSeg.sendKeys("PRUEBA");
            mainPage32612.textareaResponsableRevision.sendKeys("PRUEBA");
            mainPage32612.textareaPeriodicidadActualizada.sendKeys("PRUEBA");
            mainPage32612.textareaProgramaCampaña.sendKeys("PRUEBA");
            mainPage32612.inputRegistoCapacitacion.click();
            mainPage32612.inputProcDocumentado.click();
            mainPage32612.textareaDescDocumentInterna.sendKeys("PRUEBA");
            mainPage32612.textareaProcedAuditoria.sendKeys("PRUEBA");
            mainPage32612.inputEnfoqueOrg.click();
            mainPage32612.textareaPerfilPlaneacionProcesoTopicos.sendKeys("PRUEBA");
            mainPage32612.inputRegistroResultAud.click();
            mainPage32612.textareaProgamacionAud.sendKeys("PRUEBA");
            mainPage32612.textareaPerfilPlaneacionParticipanteAuditoria.sendKeys("PRUEBA");
            mainPage32612.inputGerenciaResultAud.click();
            mainPage32612.inputProcedimientoConti.click();
            mainPage32612.textareaPerfilPlaneacionDesSituaciones.sendKeys("PRUEBA");
            mainPage32612.textareaPerfilPlaneacionDesMecanismos.sendKeys("PRUEBA");
            mainPage32612.inputCapacitacionesPlanContin.click();
            //Seguridad física
            mainPage32612.linkSeguridadSica.click();
            mainPage32612.textareaMaterialPredominante.sendKeys("PRUEBA");
            mainPage32612.inputInspecPeriodicas.click();
            mainPage32612.textareaFormaRevision.sendKeys("PRUEBA");
            mainPage32612.inputPerfilPersonaInspeccion.sendKeys("PRUEBA");
            mainPage32612.textareaNumPuertas.sendKeys("123");
            mainPage32612.textareaDetalleExisPuertas.sendKeys("PRUEBA");
            mainPage32612.textareaControlesAccesoAreas.sendKeys("PRUEBA");
            mainPage32612.textareaDesTipoBarrera.sendKeys("PRUEBA");
            mainPage32612.textareaTieneBardas.click();
            mainPage32612.textareaCaracteristicasCerca.sendKeys("PRUEBA");
            mainPage32612.textareaPeriodoVerificaBarda.sendKeys("PRUEBA");
            mainPage32612.textareaReparacionDanos.sendKeys("PRUEBA");
            mainPage32612.textareaDivididosPatios.sendKeys("PRUEBA");
            mainPage32612.textareaCuentaBardasDesc.sendKeys("PRUEBA");
            mainPage32612.textareaProcedimientoCtrlEst.sendKeys("PRUEBA");
            mainPage32612.textareaResponAccesoEstacionamiento.sendKeys("PRUEBA");
            mainPage32612.textareaIdentificacionEstacionamientos.sendKeys("PRUEBA");
            mainPage32612.textareaControlEsntradaSalida.sendKeys("PRUEBA");
            mainPage32612.textareaIngVehiPriva.sendKeys("PRUEBA");
            mainPage32612.textareaResponsableAdminCtrlLlaves.sendKeys("PRUEBA");
            mainPage32612.textareaRegCtrlLlaves.click();
            mainPage32612.textareaPerdidaLlaves.sendKeys("PRUEBA");
            mainPage32612.inputMecanismoCierreEntrada.click();
            mainPage32612.textareaAreaAccesoElectronico.sendKeys("PRUEBA");
            mainPage32612.textareaMantenimientoIluma.sendKeys("PRUEBA");
            mainPage32612.inputSistemaEmergencia.click();
            mainPage32612.textareaAreasIluminadas.sendKeys("PRUEBA");
            mainPage32612.inputPlanataPoderAuxiliar.click();
            mainPage32612.textareaMecanismoContingencia.sendKeys("PRUEBA");
            mainPage32612.textareaCercioraIlumina.sendKeys("PRUEBA");
            mainPage32612.textareaControlIlum.sendKeys("PRUEBA");
            mainPage32612.textareaProgramaManYRevs.sendKeys("PRUEBA");
            mainPage32612.textareaFuncionamientoSist.sendKeys("PRUEBA");
            mainPage32612.inputSensoresPtaVent.click();
            mainPage32612.textareaActivarAlarma.sendKeys("PRUEBA");
            mainPage32612.textareaMantenimiento.sendKeys("PRUEBA");
            mainPage32612.textareaProcDocCctv.sendKeys("PRUEBA");
            mainPage32612.textareaCamarasCctv.sendKeys("PRUEBA");
            mainPage32612.textareaUbicacionCctv.sendKeys("PRUEBA");
            mainPage32612.textareaHorariosOperacion.sendKeys("PRUEBA");
            mainPage32612.textareaRevisionPeriodicaGraba.sendKeys("PRUEBA");
            mainPage32612.textareaDesignado.sendKeys("PRUEBA");
            mainPage32612.textareaResultadosRevision.sendKeys("PRUEBA");
            mainPage32612.textareaTiempoGrabaciones.sendKeys("PRUEBA");
            mainPage32612.inputSistemaCctvRespaldado.click();
            mainPage32612.textareaMecanismoEnerg.sendKeys("PRUEBA");
            mainPage32612.textareaAlarmaPorFalla.sendKeys("PRUEBA");
            mainPage32612.textareaRobustecerSeguridad.sendKeys("PRUEBA");
            mainPage32612.textareaProbarSistAlarmas.sendKeys("PRUEBA");
            mainPage32612.inputProvConAccesoCam.click();
            mainPage32612.textareaContrlAccesos.sendKeys("PRUEBA");
            //Controles de acceso físico
            mainPage32612.linkControlesAccesoSico.click();
            mainPage32612.textareaPerSeg.sendKeys("PRUEBA");
            mainPage32612.inputProcPersonalSeg.sendKeys("PRUEBA");
            mainPage32612.textareaAparatosComunicacion.sendKeys("PRUEBA");
            mainPage32612.textareaNumPersonalSeg.sendKeys("123");
            mainPage32612.textareaCargosFunPersonal.sendKeys("PRUEBA");
            mainPage32612.textareaContratoServicioExt.sendKeys("PRUEBA");
            mainPage32612.textareaPersonalArmado.sendKeys("PRUEBA");
            mainPage32612.textareaPerfilIdentificacion.sendKeys("PRUEBA");
            mainPage32612.textareaProcIdentificacionEmpl.sendKeys("PRUEBA");
            mainPage32612.textareaMecanismosIdentificacion.sendKeys("PRUEBA");
            mainPage32612.textareaAsignacionUniformes.sendKeys("PRUEBA");
            mainPage32612.textareaIdentificarPersonalSC.sendKeys("PRUEBA");
            mainPage32612.textareaPerfilEmpresaCambiaIden.sendKeys("PRUEBA");
            mainPage32612.textareaAccesoAreasSen.sendKeys("PRUEBA");
            mainPage32612.textareaProcControlAcceso.sendKeys("PRUEBA");
            mainPage32612.textareaRegistroBitacora.sendKeys("PRUEBA");
            mainPage32612.inputRegistroVisitantes.click();
            mainPage32612.textareaPersonaRespVisitantes.sendKeys("PRUEBA");
            mainPage32612.textareaMensajeriaPaqueteria.sendKeys("PRUEBA");
            mainPage32612.textareaProcedimiento.sendKeys("PRUEBA");
            mainPage32612.textareaProveedorServicioId.sendKeys("PRUEBA");
            mainPage32612.textareaRevisaPaquet.sendKeys("PRUEBA");
            mainPage32612.textareaMenPaqSos.sendKeys("PRUEBA");
            mainPage32612.textareaAccionDetPaqSospechoso.sendKeys("PRUEBA");

            //Socios Comerciales
            mainPage32612.linkSociosComerciales.click();
            mainPage32612.textareaProgCumplimientoSoc.sendKeys("PRUEBA");
            mainPage32612.textareaProcedimientoIdentiSC.sendKeys("PRUEBA");
            mainPage32612.textareaSocioComReqSeg.sendKeys("PRUEBA");
            mainPage32612.textareaDocRequeScSegu.sendKeys("PRUEBA");
            mainPage32612.textareaAcuerdoContSeg.sendKeys("PRUEBA");
            mainPage32612.textareaCalendarioRevSeg.sendKeys("PRUEBA");
            mainPage32612.textareaIdentificacionSc.sendKeys("PRUEBA");
            mainPage32612.textareaNumTotalPedimentos.sendKeys("123");
            mainPage32612.inputSociedadesOtros.click();
            mainPage32612.textareaPerfilSocioComerRegistro.sendKeys("PRUEBA");
            mainPage32612.textareaNomSociedad.sendKeys("PRUEBA");
            mainPage32612.textareaAduanasOperaSociedad.sendKeys("PRUEBA");
            mainPage32612.textareaDirInstalacion.sendKeys("PRUEBA");
            mainPage32612.textareaDescSociedadesCumplenSegu.sendKeys("PRUEBA");
            mainPage32612.textareaProcVerificarReqMateriaSeg.sendKeys("PRUEBA");
            mainPage32612.textareaPeriocidadVisSc.sendKeys("PRUEBA");
            mainPage32612.textareaCalEjecRevSeg.sendKeys("PRUEBA");
            mainPage32612.textareaRegistroVerificacion.sendKeys("PRUEBA");
            mainPage32612.textareaFormatoVerificacion.sendKeys("PRUEBA");
            mainPage32612.textareaMedidasAccionScNoCumple.sendKeys("PRUEBA");
            mainPage32612.textareaPeriodicidadRevisadoEstatus.sendKeys("PRUEBA");
            // Seguridad de procesos
            mainPage32612.linkSeguridadProcesos.click();
            mainPage32612.textareaRecibeTransmiteInfo.sendKeys("123");sleep(500);
            mainPage32612.textareaAsegNumeroSello.sendKeys("123");sleep(500);
            mainPage32612.textareaPerfilSegFormaAsocTranInfo.sendKeys("PRUEBA");sleep(500);
            mainPage32612.textareaDescComunicaAAMercancia.sendKeys("PRUEBA");sleep(500);
            mainPage32612.inputPersonalOperaAparatos.click();sleep(500);
            mainPage32612.textareaDescProcDocComunicacion.sendKeys("PRUEBA");
            mainPage32612.textareaPoliticasComu.sendKeys("PRUEBA");
            mainPage32612.textareaProgMantto.sendKeys("PRUEBA");
            mainPage32612.textareaCuentaAparaResp.sendKeys("PRUEBA");
            // Gestión Aduanera
            mainPage32612.linkGestionAduanera.click();
            mainPage32612.textareaPagoContribuciones.sendKeys("PRUEBA");
            mainPage32612.inputProcDocGafetes.click();
            mainPage32612.inputRelacionGafetes.click();
            mainPage32612.textareaProcDocCertiicaciones.sendKeys("PRUEBA");
            mainPage32612.inputEvidenciaEval.click();
            // Seguridad de los vehículos de carga

            mainPage32612.linkSegTransporte.click();sleep(500);
            mainPage32612.inputUnidadesPropias.click();sleep(500);
            mainPage32612.inputProcDocSellos.click();sleep(500);
            mainPage32612.inputProcDocCandados.click();
            mainPage32612.textareaProcAACandados.sendKeys("PRUEBA");
            mainPage32612.textareaProveedorIso17712.sendKeys("PRUEBA");
            mainPage32612.textareaPatioAlmacenajeAATransp.sendKeys("PRUEBA");
            mainPage32612.inputTienePatio.click();
            mainPage32612.inputProcDocInsp.click();
            mainPage32612.inputFormatoInsp.click();
            mainPage32612.textareaLugarReparacionTransporte.sendKeys("PRUEBA");
            // Seguridad del personal
            mainPage32612.linkPerfilSegPers.click();
            mainPage32612.textareaProcContPers.sendKeys("PRUEBA");
            mainPage32612.textareaDocExigida.sendKeys("PRUEBA");
            mainPage32612.textareaPruebasExamSol.sendKeys("PRUEBA");
            mainPage32612.textareaAreasCriticas.sendKeys("PRUEBA");
            mainPage32612.textareaReqAdicionales.sendKeys("PRUEBA");
            mainPage32612.textareaCandidatoFirmaDoc.sendKeys("PRUEBA");
            mainPage32612.textareaCuentaProcDocCont.sendKeys("PRUEBA");
            mainPage32612.textareaDesBajaPersonal.sendKeys("PRUEBA");
            mainPage32612.textareaDarSeg.sendKeys("PRUEBA");
            mainPage32612.textareaEntregaIdentif.sendKeys("PRUEBA");
            mainPage32612.textareaCuentaRegBaja.sendKeys("PRUEBA");
            mainPage32612.textareaMantieneRegBaja.sendKeys("PRUEBA");
            mainPage32612.inputEmpBd.click();
            // Seguridad de la información y documentación
            mainPage32612.linkPerfilSegInfor.click();
            mainPage32612.textareaPersDesProcArchivar.sendKeys("PRUEBA");
            mainPage32612.textareaConexionVpn.sendKeys("PRUEBA");
            mainPage32612.textareaDispositivoPersonal.sendKeys("PRUEBA");
            mainPage32612.textareaAcceso.sendKeys("PRUEBA");
            mainPage32612.inputEquipoResp.click();
            mainPage32612.textareaTiempoAlmacenaDatos.sendKeys("PRUEBA");
            mainPage32612.textareaPlanContinuidad.sendKeys("PRUEBA");
            mainPage32612.textareaFrecuenciaCopias.sendKeys("PRUEBA");
            mainPage32612.textareaCopiasSeguridadCP.sendKeys("PRUEBA");
            mainPage32612.textareaPruebasValidezDatos.sendKeys("PRUEBA");
            mainPage32612.textareaProtecInf.sendKeys("PRUEBA");
            mainPage32612.textareaProteccionAccNoAut.sendKeys("PRUEBA");
            mainPage32612.textareaOperaConSisMult.sendKeys("PRUEBA");
            mainPage32612.textareaRespProtSis.sendKeys("PRUEBA");
            mainPage32612.textareaConcederAutAcces.sendKeys("PRUEBA");
            mainPage32612.textareaFormatoContrasenias.sendKeys("PRUEBA");
            mainPage32612.textareaNomAntivirus.sendKeys("PRUEBA");
            mainPage32612.textareaMedidasPrevProductosTecno.sendKeys("PRUEBA");
            mainPage32612.textareaFormatearDiscos.sendKeys("PRUEBA");
//            mainPage32612.textareaProcFormateo.sendKeys("PRUEBA");
//            mainPage32612.textareaProcBajaPersonal.sendKeys("PRUEBA");
//            mainPage32612.textareaPrevUsoProdFal.sendKeys("PRUEBA");
//            mainPage32612.textareaElimAccesosBajaPers.sendKeys("PRUEBA");
            mainPage32612.textareaMedidaIncidente.sendKeys("PRUEBA");
            mainPage32612.textareaMedidadPrevIncidentes.sendKeys("PRUEBA");
            // Capacitación en seguridad y concientización
            mainPage32612.linkPerfilCapacitacionT.click();
            mainPage32612.textareaTemasPrograma.sendKeys("PRUEBA");
            mainPage32612.textareaMomentoImparte.sendKeys("PRUEBA");
            mainPage32612.textareaPeriodicidadCapac.sendKeys("PRUEBA");
            mainPage32612.textareaFormaDocCapac.sendKeys("PRUEBA");
            mainPage32612.textareaFomentaParticipacion.sendKeys("PRUEBA");
            mainPage32612.textareaCapacitacionesTransporte.sendKeys("PRUEBA");
            // Manejo e investigación de incidentes
            mainPage32612.linkPerfilManejo.click();
            mainPage32612.textareaDesProcAnomalias.sendKeys("PRUEBA");
            mainPage32612.textareaResponsableReporta.sendKeys("PRUEBA");
            mainPage32612.textareaDetalleComAuto.sendKeys("PRUEBA");
            mainPage32612.textareaLlevaRegReporte.sendKeys("PRUEBA");
            mainPage32612.textareaDesProcIniInv.sendKeys("PRUEBA");
            mainPage32612.textareaResponsableInv.sendKeys("PRUEBA");
            mainPage32612.textareaDoctoExpediente.sendKeys("PRUEBA");
//
            mainPage32612.btnGuardarSoli.click();
            mainPage32612.btnContinuar.click();
            mainPage32612.btnAdjuntarDoc.click();
            mainPage32612.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo26.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo27.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo28.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo29.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo30.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.archivo32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage32612.btnAdjuntar.click();sleep(7500);
            mainPage32612.btnCerrar.click();
            mainPage32612.btnSiguiente.click();
            loginFirmSoli.firma(tramite32612);
            String folioText = mainPage32612.folio.getText();
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
}

