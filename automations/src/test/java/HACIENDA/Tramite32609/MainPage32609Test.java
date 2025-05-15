package HACIENDA.Tramite32609;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32609.MainPage32609;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32609Test {

    MainPage32609 mainPage32609 = new MainPage32609();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32608  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32609() throws IOException {
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



        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de hoy formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaVigenciaCertificacion = LocalDate.now().plusMonths(2).format(formatter);

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite32608);
            mainPage32609.selecRol.sendKeys("Persona Moral");
            mainPage32609.btnacep.click();

            //Busqueda de tramite
            mainPage32609.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32609.SoliNew.click();
            mainPage32609.Hacienda.click();
            mainPage32609.menuAGACERegistroCE.click();
            mainPage32609.submenuSREIC.click();
            mainPage32609.elemTramite32609.click();sleep(1000);

            //Paso 1 Llenado de datos
            //Datos comunes
            mainPage32609.tabDatosComunes.click();sleep(1000);
            mainPage32609.listSectorProduct.sendKeys("Bebidas y tabacos");
            //mainPage32609.listServicio.sendKeys("Servicios de agencias aduanales");//sleep(1000);
            mainPage32609.radSicumplimientoObligaciones.click();//sleep(1000);
            mainPage32609.radSiAutorizarSatOpinion.click();//sleep(1000);
            mainPage32609.radSiEmpleadosIMSS.click();//sleep(1000);
            // LLenado para campos IMSS
            mainPage32609.NumEmpleadosPropios.sendKeys("10");
            mainPage32609.listBimestreEmpleadosPropios.sendKeys("Enero-Febrero");

            mainPage32609.radSiISRTrabajadores.click(); //sleep(1000);
            mainPage32609.radSiPagoObrero.click(); //sleep(1000);
            mainPage32609.radSiSubcontraServEspecial.click(); //sleep(1000);

            //Agregar Empleado
            mainPage32609.agregarSubcontratado.click();//sleep(1000);
            mainPage32609.rfcSubcontratado.sendKeys("MAVL621207C95"); //sleep(1000);
            mainPage32609.btnBuscarRfcSubcontratado.click();sleep(1000);//sleep(1000);
            mainPage32609.numEmpleadosSubcontratados.sendKeys("10"); //sleep(10000);
            mainPage32609.bimestreEmpleadosSubcontratados.sendKeys("Enero-Febrero");
            mainPage32609.btnAñadirSubcontratados.click();
            mainPage32609.btnAceptarSubcontratados.click();

            mainPage32609.radSiRegistroPadron.click();
            mainPage32609.radNoArticulo69.click();
            mainPage32609.radNoArticulo69BCFF.click();
            mainPage32609.radNoArticulo69BBis.click();
            mainPage32609.radSiSellosVigentes.click();
            mainPage32609.radNoInfracArt17HBis.click();


            //Seccion Lista 2 y Tabla
            mainPage32609.listDomicilioRegistrado.sendKeys("82024 - Autoriazión Programa Nuevo Servicio");
            //Agregar Instalacion
            mainPage32609.btnAgregarInstalaciones.click();
            mainPage32609.listEntidadInstalacion.sendKeys("AGUASCALIENTES");
            mainPage32609.seleccionarInstalacion.click();
            mainPage32609.btnAceptarInstalaciones.click();

            //Begin Flujo Modificar Instalación
            mainPage32609.selecInstalacionAModificar.click();
            mainPage32609.btnmodificarInstalacion.click();
            mainPage32609.radSiInstalacionPrincipal.click();
            mainPage32609.listTipoInstalacion.sendKeys("Planta Productiva");
            mainPage32609.radSiProcesoProductivo.click();
            mainPage32609.radSiUsoGoceInmueble.click();
            mainPage32609.radSiPerfilEmpresa.click();
            mainPage32609.radSiComercioExterior.click();
            mainPage32609.radNoReconocimientoMutuo.click();
            mainPage32609.btnHacerModificacion.click();
            mainPage32609.btnAceptarModificacion.click();
            //End Flujo

            mainPage32609.radSiArticulo17K.click();
            mainPage32609.radNoSuspesionPadron.click();

            //CLientes y Proveedores en el Extranjero
            mainPage32609.ProvedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32609.btnAgregarProvedoresExtranjeros.click();sleep(1000);
            mainPage32609.btnOkProvedoresExtranjeros.click();

            //Proveedores
            mainPage32609.ProvedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32609.btnAgregarProvedoresNacionales.click();sleep(1000);
            mainPage32609.btnOkProvedoresNacionales.click();sleep(1000);

            //Querella
            mainPage32609.radNoQuerella.click();

            //Control Inventarios
            mainPage32609.radSiInventarios.click();
            mainPage32609.NombreInventarios.sendKeys("TestIdentificación");
            mainPage32609.LugarInventarios.sendKeys("TestLugar");
            mainPage32609.checkAnexo24Inventarios.click();
            mainPage32609.btnAgregarInventario.click();
            mainPage32609.btnAceptarInventariosNtf.click();
            mainPage32609.radSiRMF.click();

            //Agregar miembro de la empresa
            mainPage32609.btnAgregarMiembro.click();
            mainPage32609.selectSocioCaracter.sendKeys("Administrador único");
            mainPage32609.inputSocioTributarMexico.click();
            mainPage32609.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32609.inputBuscar2.click();
            mainPage32609.selectSocioNacionalidad.sendKeys("AZERBAIJAN (REPUBLICA AZERBAIJANI)");
            mainPage32609.inputSocioAgregarModal.click();
            mainPage32609.btnAceptarMiembroNtf.click();
            mainPage32609.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32609.inputAcepto.click();
            mainPage32609.inputAcepto2.click();

            //terceros relacionados
            //TERCERO RELACIONADO
            mainPage32609.labelTercerosRelacionados.click();
            mainPage32609.inputTercero.sendKeys("LEQI8101314S7");sleep(500);
            mainPage32609.inputBuscar3.click();sleep(500);
            mainPage32609.spanAceptar8.click();
            mainPage32609.inputAgregarEnlaceOperativo.click();
            mainPage32609.input.sendKeys("LEQI8101314S7");
            mainPage32609.inputBuscarEnlaceOperativo.click();
            mainPage32609.inputAceptarEnlace.click();
            mainPage32609.inputAgregarEnlaceOperativo.click();
            mainPage32609.input.sendKeys("FOGI720331SIA");
            mainPage32609.inputBuscarEnlaceOperativo.click();
            mainPage32609.inputTerceroEnlaceOperativoSuplente.click();
            mainPage32609.inputAceptarEnlace.click();

            //Textil
            mainPage32609.tabTextil.click();
            mainPage32609.radbtnSiOperacionesExteriores.click();
            //Pago de derecho
            Selenide.executeJavaScript("arguments[0].value = '01/04/2023';", mainPage32609.fechaInicioOperacionesExt);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32609.fechaPagoDerecho);
            mainPage32609.MontoDerecho.sendKeys("38797");
            mainPage32609.NumeroOperacionBancaria.sendKeys("31456fll");
            mainPage32609.LLavePago.sendKeys("5446epp");

            //Ventana Agregar transportista
            mainPage32609.inputAgregarTransportista.click();
            mainPage32609.inputTransportistaCertificacion.sendKeys("MAVL621207C95");
            mainPage32609.inputBuscarEmpresa.click();
            mainPage32609.inputGuardarTransportista.click();
            //mainPage32609.btnAceptarTransportistaNtf.click();
            mainPage32609.radbtnSiProgramaIMMEX.click();
            mainPage32609.radbtnSiDeclaracionISR.click();
            mainPage32609.radbtnSiRegistroEsquemaCer.click();

            //Reconocimiento Mutuo
            mainPage32609.radbtnSiReconocimiento.click();
            //Clasificacion de la información
            mainPage32609.radbtnInfoPrivada.click();

            //PERFILES
            mainPage32609.Scrol.scrollTo();
            mainPage32609.tabPerfiles.click();
            //Información general
            mainPage32609.AntiguedadOperacion.sendKeys("90");
            mainPage32609.ProductosManejadosPlanta.sendKeys("QA Producto");
            mainPage32609.NoEmbarqueEXP.sendKeys("156");
            mainPage32609.NoEmbarqueIMP.sendKeys("200");
            mainPage32609.NumEmpleadosTotal.sendKeys("1000");
            mainPage32609.SuperficieInstalacion.sendKeys("500");
            mainPage32609.radbtnNoCTPAT.click();
            mainPage32609.radbtnNoPIP.click();
            mainPage32609.radbtnNoOEA.click();
            mainPage32609.radbtnNoOtrosSeguridad.click();
            mainPage32609.NombreCertificacion1.sendKeys("Nombre 1 QA");
            mainPage32609.CategoriaCertificacion1.sendKeys("QA");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32609.fechaVigencia1, fechaVigenciaCertificacion);
            mainPage32609.NombreCertificacion2.sendKeys("Nombre 2 QA");
            mainPage32609.CategoriaCertificacion2.sendKeys("");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32609.fechaVigencia2, fechaVigenciaCertificacion);
            mainPage32609.NombreCertificacion3.sendKeys("Nombre 3 QA");
            mainPage32609.CategoriaCertificacion3.sendKeys("QA");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32609.fechaVigencia3, fechaVigenciaCertificacion);

            //1. Planeación de la seguridad en la cadena de suministros
            mainPage32609.seccion1.click();
            //1.1 Análisis de riesgo
            mainPage32609.radbtnNoIdentificacionRiesgo.click();
            mainPage32609.radbtnNoIndentificacionCumplimiento.click();
            mainPage32609.MiembrosComiteSeguridad.sendKeys("QA");
            mainPage32609.FuentesInfoRiesgos.sendKeys("QA");
            //1,2 Políticas de seguridad
            mainPage32609.SeguridadOrientadoAmenazas.sendKeys("QA");
            mainPage32609.ResponsableRevision.sendKeys("QA");
            mainPage32609.PeriodicidadActualizacion.sendKeys("QA");
            mainPage32609.ProgramaDifusionPolitica.sendKeys("QA");
            mainPage32609.radbtnNoCapacitacionInicial.click();
            //1.3 Auditorias internas en la cadena de suministro
            mainPage32609.radbtnNoProcedimientoDocumentado.click();
            mainPage32609.DescripcionProcedimiento.sendKeys("QA");
            mainPage32609.NombreProcedimiento.sendKeys("QA");
            mainPage32609.radbtnNoAuditoriasRiesgo.click();
            mainPage32609.ProcesosAuditan.sendKeys("QA");
            mainPage32609.radbtnNoRegistroResultados.click();
            mainPage32609.ProgramacionAuditoriaInterna.sendKeys("QA");
            mainPage32609.ParticipantesAuditoriaInterna.sendKeys("QA");
            mainPage32609.radbtnNoGerenciaVerificaAuditoria.click();
            //1.4 Planes de contingéncia y/o emergencia
            mainPage32609.radbtnNoProcedimientosExterior.click();
            mainPage32609.PlanCrisis.sendKeys("QA");
            mainPage32609.MecanismoDifunsion.sendKeys("QA");
            mainPage32609.radbtnNoRegistrosCapacitaciones.click();
            //Minimizar seccion 1
            mainPage32609.seccion1.click();

            //2 Seguridad Física
            mainPage32609.seccion2.click();
            //2.1 Instalaciones
            mainPage32609.MateriasPredominantes.sendKeys("QA");
            mainPage32609.FormaRevision.sendKeys("QA");
            mainPage32609.PersonalInspeccion.sendKeys("QA");
            //2.2 Accesos en puertas y casetas
            mainPage32609.NumPuertasAccesos.sendKeys("5");
            mainPage32609.HorarioOperacion.sendKeys("QA");
            mainPage32609.Monitoreo.sendKeys("QA");
            mainPage32609.PuertasBloqueadas.sendKeys("QA");
            mainPage32609.AseguramientoAccesos.sendKeys("QA");
            //2.3 Bardas perimetrales
            mainPage32609.TipoCercaBarrera.sendKeys("QA");
            mainPage32609.AreasSegregadas.sendKeys("QA");
            mainPage32609.CaracteristicasAreas.sendKeys("QA");
            mainPage32609.RazonNoBardas.sendKeys("QA");
            mainPage32609.PeriodoVerificacion.sendKeys("QA");
            mainPage32609.PersonalInspeccionDaños.sendKeys("QA");
            mainPage32609.ManeraSegregacion.sendKeys("QA");
            mainPage32609.SeparacionMercancia.sendKeys("QA");
            mainPage32609.AreasRestringidas.sendKeys("QA");
            //2.4 Estacionamientos
            mainPage32609.ProcedimientosControl.sendKeys("QA");
            mainPage32609.ResponsablesControl.sendKeys("QA");
            mainPage32609.IndentificacionEstacionamientos.sendKeys("QA");
            mainPage32609.EntradaSalidaVehiculos.sendKeys("QA");
            mainPage32609.NoVehiculosPrivados.sendKeys("QA");
            //2.5 Control de llaves y dispositivos de cerraduras
            mainPage32609.radbtnNoMecanismoCierreVehiculo.click();
            mainPage32609.ResponsableSeguridadLLaves.sendKeys("QA");
            mainPage32609.RegistroLLaves.sendKeys("QA");
            mainPage32609.PerdidaLlaves.sendKeys("QA");
            mainPage32609.AccesoElectronicos.sendKeys("QA");
            //2.6 Alumbrado
            mainPage32609.MantenimientoIluminacion.sendKeys("QA");
            mainPage32609.AreasIluminadas.sendKeys("QA");
            mainPage32609.radbtnNoPlantaAuxiliar.click();
            mainPage32609.MecanismoContigenciaEnergia.sendKeys("QA");
            mainPage32609.DescripcionControlIluminacion.sendKeys("QA");
            mainPage32609.ResponsableControlIluminacion.sendKeys("QA");
            mainPage32609.ProgramaMantenimiento.sendKeys("QA");
            //2.7 Aparatos de comunicación
            mainPage32609.ProcContactoPersonalSeguridad.sendKeys("QA");
            mainPage32609.PersonalAparatosSeguridad.sendKeys("QA");
            mainPage32609.TipoAparatos.sendKeys("QA");
            mainPage32609.DescripcionControlAparatos.sendKeys("QA");
            mainPage32609.PoliticasAsignacionAparatos.sendKeys("QA");
            mainPage32609.ProgramaMantenimientoAparatos.sendKeys("QA");
            mainPage32609.AparatosRespaldo.sendKeys("QA");
            //2.8 Sistemas de alarma y circuito cerrado de television y video vigilancia
            mainPage32609.DescripcionFuncionAlarmas.sendKeys("QA");
            mainPage32609.radbtnNoSensoresPuertasVentanas.click();
            mainPage32609.DescripcionProcedimientoActivacionAlarma.sendKeys("QA");
            mainPage32609.DescripcionProcedimientoOperacionAlarma.sendKeys("QA");
            mainPage32609.NumCamarasUbicacion.sendKeys("QA");
            mainPage32609.LugarInspeccion.sendKeys("QA");
            mainPage32609.UbicacionMonitores.sendKeys("QA");
            mainPage32609.HorariosOperacion.sendKeys("QA");
            mainPage32609.FormaRevisionGrabaciones.sendKeys("QA");
            mainPage32609.PersonalRevisiones.sendKeys("QA");
            mainPage32609.DocumentacionRevisiones.sendKeys("QA");
            mainPage32609.TiempoGrabacionesGuardadas.sendKeys("QA");
            mainPage32609.radbtnNoRespaldoPlantaElectrica.click();
            mainPage32609.MecanismoAlternoEnergia.sendKeys("QA");
            mainPage32609.NotfFallaFuncionamiento.sendKeys("QA");
            mainPage32609.TecnologiaRobustescaSeguridad.sendKeys("QA");
            mainPage32609.DescripcionProcedimientoInspRegularSeguridad.sendKeys("QA");
            mainPage32609.radbtnNoProveedorAccesoCamaras.click();
            mainPage32609.ControlAccesosMonitoreo.sendKeys("QA");
            //Minimizar seccion 2
            mainPage32609.seccion2.click();

            //3.Controles de acceso físico
            mainPage32609.seccion3.click();
            //3.1 Personal de seguridad
            mainPage32609.DescribirOperacionPersonalSeguridad.sendKeys("QA");
            mainPage32609.NumPersonalSeguridad.sendKeys("900");
            mainPage32609.CargosFuncionesPersonal.sendKeys("QA");
            mainPage32609.ServicioExterno.sendKeys("QA");
            mainPage32609.PersonalArmado.sendKeys("QA");
            //3.2 Identificación de los empleados
            mainPage32609.DescribirIdentificacionEmpleados.sendKeys("QA");
            mainPage32609.MecanismoIdentificacion.sendKeys("QA");
            mainPage32609.AsignacionUniformesEmpleados.sendKeys("QA");
            mainPage32609.PersonalSocioComercial.sendKeys("QA");
            mainPage32609.DescribirControlesAcceso.sendKeys("QA");
            mainPage32609.AccesoAreasSensibles.sendKeys("QA");
            //3.3 Identificación de visitantes y proveedores
            mainPage32609.ControlVisitantesProveedores.sendKeys("QA");
            mainPage32609.RegistrosVisitas.sendKeys("QA");
            mainPage32609.radbtnNoRegistroVisitasLista.click();
            mainPage32609.ResponsableAcompañanteVisitante.sendKeys("QA");
            //3.4 Entregas de mensajería y paquetería
            mainPage32609.RecepcionMensajeriaPaqueteria.sendKeys("QA");
            mainPage32609.IdentificarProveedorServicio.sendKeys("QA");
            mainPage32609.RevisionMensajeriaPaqueteria.sendKeys("QA");
            mainPage32609.MensajeriaPaqueteriaSospechosa.sendKeys("QA");
            //Minimizar seccion 3
            mainPage32609.seccion3.click();

            //4.-Socios Comerciales
            mainPage32609.seccion4.click();
            //4.1 Criterios de selección
            mainPage32609.ProgramaSocial.sendKeys("QA");
            //4.2 Requerimientos en seguridad
            mainPage32609.IdentificacionSociosComerciales.sendKeys("QA");
            mainPage32609.SociosCumplirSeguridad.sendKeys("QA");
            mainPage32609.FormaCumplimientoSeguridad.sendKeys("QA");
            mainPage32609.ConveniosImplementacionSeguridad.sendKeys("QA");
            mainPage32609.SociosEnProgramaSeguridad.sendKeys("QA");
            //4.3 Revisiones del socio comercial
            mainPage32609.ListaProcedimiento.sendKeys("QA");
            mainPage32609.PeriodicidadVisitaSociosComerciales.sendKeys("QA");
            mainPage32609.ProgramaRevisionesSeguridad.sendKeys("QA");
            mainPage32609.RegistroVerificacion.sendKeys("QA");
            mainPage32609.FormatoVerificacion.sendKeys("QA");
            mainPage32609.MedidasIncumplimientoSocios.sendKeys("QA");
            mainPage32609.SociosCTPAT.sendKeys("QA");
            //Minimizar seccion 4
            mainPage32609.seccion4.click();

            //5.-Seguridad de procesos
            mainPage32609.seccion5.click();
            //5.1 Mapeo de procesos
            mainPage32609.ProcesoSubManufactura.sendKeys("QA");
            //5.2 Almacenes y centros de distribución
            mainPage32609.ActividadInstalacion.sendKeys("QA");
            //5.3 Entrega y recepción de carga
            mainPage32609.ProcedimientoEntregaMercancia.sendKeys("QA");
            //5.4 Procedimiento de seguimiento de la mercancía
            mainPage32609.CustodiaEmbarque.sendKeys("QA");
            //5.6 Procesamiento de la información y documentación de la carga
            mainPage32609.ProcesamientoInfoCarga.sendKeys("QA");
            mainPage32609.TransmicionInfoTransladoCarga.sendKeys("QA");
            mainPage32609.AseguramientoFormularios.sendKeys("QA");
            mainPage32609.TransmitirInfoEmpresaAsociados.sendKeys("QA");
            //Minimizar seccion 5
            mainPage32609.seccion5.click();

            //6.-Gestión Aduanera
            mainPage32609.seccion6.click();
            //6.1 Gestión del despacho aduanero.
            mainPage32609.EvaluacionAduanal.sendKeys("QA");
            mainPage32609.CriteriosSeleccion.sendKeys("QA");
            mainPage32609.MetodosEvaluacionPeriodicidadAduana.sendKeys("QA");
            mainPage32609.IndicadoresEvaluacionAgentesAduanales.sendKeys("QA");
            mainPage32609.NombrePatenteAgenteAduanal.sendKeys("QA");
            //6.2 Obligaciones aduaneras
            mainPage32609.radbtnNoArticulo59.click();
            mainPage32609.radbtnNoProgramaIMMEXAduana.click();
            mainPage32609.NumRegistroAduana.sendKeys("1892");
            mainPage32609.radbtnNoProgramaExportacion.click();
            mainPage32609.NombrePrograma.sendKeys("QA");
            mainPage32609.NumRegistroPrograma.sendKeys("9807");
            //Minimizar seccion 6
            mainPage32609.seccion6.click();

            //7. Seguridad de los vehículos de carga, contenedores, carros de tren, remolques y/o semirremolques.
            mainPage32609.seccion7.click();
            //7.1 Integridad de la carga y uso de sellos en contenedores y remolques.
            mainPage32609.DetalleVehiculoTransladoMerca.sendKeys("QA");
            mainPage32609.TransportePropiedad.sendKeys("QA");
            mainPage32609.EmpresasTransportistasContratadas.sendKeys("QA");
            //7.2 Inspección de los medios de transporte, contenedores, carros de tren, remolques y semirremolques
            mainPage32609.LugarReparacionesTransportes.sendKeys("QA");
            mainPage32609.CumplimientoCondicionesTransporte.sendKeys("QA");
            mainPage32609.radbtnNoRevisionesAleatorias.click();
            //7.3 Almacenaje de vehículos, medios de transporte, contenedores, carros de tren, remolques y semirremolques.
            mainPage32609.radbtnNoAlamacenPrevContenedores.click();
            mainPage32609.IntegridadContenedores.sendKeys("QA");
            mainPage32609.AlmacenMateriaPrima.sendKeys("QA");
            //Minimizar seccion 7
            mainPage32609.seccion7.click();

            //8. Seguridad del personal
            mainPage32609.seccion8.click();
            //8.1 Verificación de antecedentes laborales.
            mainPage32609.ProcedimientoContratacionPersonal.sendKeys("QA");
            mainPage32609.RequisitosContratacion.sendKeys("QA");
            mainPage32609.PruebasExamenesSeguridad.sendKeys("QA");
            mainPage32609.AreasRiesgo.sendKeys("QA");
            mainPage32609.RequerimientosAdicionales.sendKeys("QA");
            mainPage32609.AcuerdoConfidencialidad.sendKeys("QA");
            mainPage32609.ProcedimientoAgernciaServicios.sendKeys("QA");
            //8.2 Procedimiento para baja del personal
            mainPage32609.BajaPersonal.sendKeys("QA");
            mainPage32609.ResponsableEjecutarBajaPersonal.sendKeys("QA");
            mainPage32609.EntregaIdentificaciones.sendKeys("QA");
            mainPage32609.ControlEntregaMaterial.sendKeys("QA");
            mainPage32609.PersonalFinalizoRelacionLaboral.sendKeys("QA");
            //8.3 Administración de personal
            mainPage32609.radbtnNoListaAdminPersonal.click();
            //Minimizar sección 8
            mainPage32609.seccion8.click();

            //9. Seguridad de la información y documentación
            mainPage32609.seccion9.click();
            //9.2 Seguridad de la tecnología de la información.
            mainPage32609.PoliticasAtaquesRiesgos.sendKeys("QA");
            mainPage32609.SeguridadVPNEmpleados.sendKeys("QA");
            mainPage32609.PermisoDispositivosPersonales.sendKeys("QA");
            mainPage32609.AccesoSociosSistema.sendKeys("QA");
            mainPage32609.radbtnNoRespladoSuministro.click();
            mainPage32609.TiempoDatosAlmacenados.sendKeys("QA");
            mainPage32609.PlanRecuperacionDatos.sendKeys("QA");
            mainPage32609.LocalizacionCopiasSeguridad.sendKeys("QA");
            mainPage32609.LozalizacionCopiasSeguridadAlter.sendKeys("QA");
            mainPage32609.PruebaValidezRecuperacion.sendKeys("QA");
            mainPage32609.ProcedimientoProteccionInfo.sendKeys("QA");
            mainPage32609.PoliticaProteccionInfo.sendKeys("QA");
            mainPage32609.MultiSedesControlSistemas.sendKeys("QA");
            mainPage32609.ResponsableProteccionInfo.sendKeys("QA");
            mainPage32609.MonitoreoAccesoInfo.sendKeys("QA");
            mainPage32609.FormatoContrasena.sendKeys("QA");
            mainPage32609.NombreCortafuegosAntivirus.sendKeys("QA");
            mainPage32609.PrevencionUsoTecnologiaFalsa.sendKeys("QA");
            mainPage32609.ProcedimientoFormateo.sendKeys("QA");
            mainPage32609.ProcedimientoEliminarAcceso.sendKeys("QA");
            mainPage32609.MedidasPrevAccesoComprometido.sendKeys("QA");
            //Minimizar sección 9
            mainPage32609.seccion9.click();

            //10. Capacitación en Seguridad y concientización
            mainPage32609.seccion10.click();
            //10.1 Capacitación y concientización sobre amenazas
            mainPage32609.TemasImpartidos.sendKeys("QA");
            mainPage32609.MomentoImpartirTemas.sendKeys("QA");
            mainPage32609.PeriodicidadCapacitaciones.sendKeys("QA");
            mainPage32609.DocumentarParticipacionCapacitaciones.sendKeys("QA");
            mainPage32609.FomentacionParticipacion.sendKeys("QA");
            //10.2 Concientización a los operadores de los medios de transporte.
            mainPage32609.ProgramaDifusionSeguridad.sendKeys("QA");
            mainPage32609.FormaDifusion.sendKeys("QA");
            mainPage32609.ListaTemasSeguridad.sendKeys("QA");
            mainPage32609.PoliticasSocioComercialSeguridad.sendKeys("QA");
            mainPage32609.DocumentarCapacitacionSeguridadSuministros.sendKeys("QA");
            //Minimizar sección 10
            mainPage32609.seccion10.click();

            //11 Manejo e investigación de incidentes
            mainPage32609.seccion11.click();
            //11.1 Reporte de anomalías y/o actividades sospechosas
            mainPage32609.DenunciaActividadSospechosa.sendKeys("QA");
            mainPage32609.ResponsableReporteActividadSospechosa.sendKeys("QA");
            mainPage32609.IdentificacionComunicacionAutoridad.sendKeys("QA");
            mainPage32609.ReporteActividadSospechosa.sendKeys("QA");
            //11.2 Investigación y análisis
            mainPage32609.InvestigacionPorIncidente.sendKeys("QA");
            mainPage32609.ResponsableInvestigacion.sendKeys("QA");
            mainPage32609.ExpedienteInvestigacion.sendKeys("QA");
            //Minimizar sección 11
            mainPage32609.seccion11.click();

            //Boton Siguente Paso 1
            mainPage32609.btnSiguientePaso1.click();

            //Paso 2 Requisitos necesarios
            mainPage32609.btnSiguientePaso2.click();

            //Paso 3
            mainPage32609.btnAdjuntarDoc.click();
            //SubPaso3
            //subirDocumentos("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo26.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo27.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo28.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo29.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo30.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo33.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo34.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo35.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo36.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo37.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo38.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo39.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnSelecArchivo39.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32609.btnAdjuntar2.click();
            mainPage32609.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            mainPage32609.btnCerrar3.click();

            mainPage32609.btnSiguientePaso3.click();

            //Firma
            loginFirmSoli.firma(tramite32608);sleep(4000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32609.folio.getText();

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

    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }


}