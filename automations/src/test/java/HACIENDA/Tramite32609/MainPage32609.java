package HACIENDA.Tramite32609;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32609 {

    //public SelenideElement nombreElemento = $x("");
    //Elementos para Login y selección Rol
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Elementos para acceder al tramite
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = Selenide.$x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement menuAGACERegistroCE = Selenide.$x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement submenuSREIC = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/a/span");
    public SelenideElement elemTramite32609 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/ul/li[6]/a");

    //TRAMITE
    //Datos comunes
    //Seccion 1 Listas
    public SelenideElement tabDatosComunes = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    public SelenideElement listSectorProduct = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    //Seccion Radio botones
    public SelenideElement listServicio = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[1].catalogo\"]");
    public SelenideElement radSicumplimientoObligaciones = $x("//*[@id=\"si190\"]");
    public SelenideElement radSiAutorizarSatOpinion = $x("//*[@id=\"si191\"]");
    public SelenideElement radSiEmpleadosIMSS = $x("//*[@id=\"emPropiosSi\"]");
    //Despliega para radio boton IMSS
    public SelenideElement NumEmpleadosPropios = $x("//*[@id=\"empPropios\"]");
    public SelenideElement listBimestreEmpleadosPropios = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");

    public SelenideElement radSiISRTrabajadores = $x("//*[@id=\"isrSi\"]");
    public SelenideElement radNoISRTrabajadores = $x("//*[@id=\"isrNo\"]");
    public SelenideElement radSiPagoObrero = $x("//*[@id=\"obreroPatronalesSi\"]");
    public SelenideElement radSiSubcontraServEspecial = $x("//*[@id=\"si2011\"]");

    //Revisar Subcotrato = Si
    public SelenideElement agregarSubcontratado = $x("//*[@id=\"agregarSubcontratado\"]");
    public SelenideElement rfcSubcontratado = $x("//*[@id=\"subcontratado.rfcBusqueda\"]");
    public SelenideElement btnBuscarRfcSubcontratado = $x("/html/body/div[9]/div[2]/table/tbody/tr[1]/td/div/div[1]/input[2]");
    public SelenideElement numEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.empleados\"]");
    public SelenideElement bimestreEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.bimestre\"]");
    public SelenideElement btnAñadirSubcontratados = $x("/html/body/div[9]/div[2]/table/tbody/tr[2]/td/input[2]");
    public SelenideElement btnAceptarSubcontratados = $x("/html/body/div[13]/div[3]/div/button");

    //
    public SelenideElement radSiRegistroPadron = $x("//*[@id=\"si236\"]");
    public SelenideElement radNoArticulo69 = $x("//*[@id=\"no237\"]");
    public SelenideElement radNoArticulo69BCFF = $x("//*[@id=\"no238\"]");
    public SelenideElement radNoArticulo69BBis = $x("//*[@id=\"no462\"]");
    public SelenideElement radSiSellosVigentes = $x("//*[@id=\"si239\"]");
    public SelenideElement radNoInfracArt17HBis = $x("//*[@id=\"no240\"]");
    //Seccion Lista 2 y Tabla
    public SelenideElement listDomicilioRegistrado = $x("//*[@id=\"IMMEX\"]");
    public SelenideElement btnAgregarInstalaciones = $x("//*[@id=\"btnAgregarDomicilios\"]");
    public SelenideElement listEntidadInstalacion = $x("//*[@id=\"entidadFederativaIDC\"]");
    public SelenideElement seleccionarInstalacion = $x("//*[@id=\"jqg_gridDomiciliosModal_3\"]");
    public SelenideElement btnAceptarInstalaciones = $x("/html/body/div[7]/div[2]/table/tbody/tr[4]/td/input[1]");
    public SelenideElement selecInstalacionAModificar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[4]/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnmodificarInstalacion = $x("//*[@id=\"btnModificarDomicilios\"]");

    //Modificacion instalacion (Revisar)
    public SelenideElement radSiInstalacionPrincipal = $x("//*[@id=\"siInstalacion\"]");
    public SelenideElement listTipoInstalacion = $x("//*[@id=\"domicilio.tipoInstalacion\"]");
    public SelenideElement radSiProcesoProductivo = $x("//*[@id=\"siProcesoProd\"]");
    public SelenideElement radSiUsoGoceInmueble = $x("//*[@id=\"siAcreditaIn\"]");
    public SelenideElement radSiComercioExterior = $x("//*[@id=\"siOperacionesCExt\"]");
    public SelenideElement radSiReconocimientoMutuo = $x("//*[@id=\"siInstalacionCtpat\"]");
    public SelenideElement radNoReconocimientoMutuo = $x("//*[@id=\"noInstalacionCtpat\"]");
    public SelenideElement radNoPerfilEmpresa = $x("//*[@id=\"noPerfil\"]");
    public SelenideElement radSiPerfilEmpresa = $x("//*[@id=\"siPerfil\"]");
    public SelenideElement btnAceptarModificacion = $x("/html/body/div[15]/div[3]/div/button");
    public SelenideElement btnHacerModificacion = $x("/html/body/div[14]/div[2]/table/tbody/tr[15]/td/input[1]");

    //Seccion Radio botones2
    public SelenideElement radSiArticulo17K = $x("//*[@id=\"si243\"]");
    public SelenideElement radNoSuspesionPadron = $x("//*[@id=\"no244\"]");

    //Clientes y Proveedores en el Extranjero
    public SelenideElement ProvedoresExtranjeros = $x("//*[@id=\"archivo\"]");
    public SelenideElement btnAgregarProvedoresExtranjeros = $x("//*[@id=\"uploadFileExtranjeros\"]");
    public SelenideElement btnOkProvedoresExtranjeros = $x("/html/body/div[16]/div[3]/div/button");
    //Proveedores
    public SelenideElement ProvedoresNacionales = $x("//*[@id=\"archivoNacionales\"]");
    public SelenideElement btnAgregarProvedoresNacionales = $x("//*[@id=\"uploadFileExtranjerosN\"]");
    public SelenideElement btnOkProvedoresNacionales = $x("/html/body/div[19]/div[3]/div/button");

    //Querella
    public SelenideElement radNoQuerella = $x("//*[@id=\"no248\"]");

    //Control Inventarios
    public SelenideElement radSiInventarios = $x("//*[@id=\"siInventario\"]");
    public SelenideElement NombreInventarios = $x("//*[@id=\"nombre.inventario\"]");
    public SelenideElement LugarInventarios = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement checkAnexo24Inventarios = $x("//*[@id=\"anexo.inventario\"]");
    public SelenideElement btnAgregarInventario = $x("//*[@id=\"btnAgregar.inventario\"]");
    public SelenideElement radSiRMF = $x("//*[@id=\"si251\"]");
    public SelenideElement btnAceptarInventariosNtf=  $x("/html/body/div[19]/div[3]/div/button/span");
    //Agregar Miembro
    public SelenideElement btnAgregarMiembro = $x("//*[@id='agregarSocio']");
    public SelenideElement selectSocioCaracter = $x("//*[@id='socio.caracterDe']");
    public SelenideElement selectSocioCaracter2 = $x("//*[@id='socio.caracterDe']");
    public SelenideElement inputSocioTributarMexico = $x("//*[@id='socio.tributarMexicoTrue']");
    public SelenideElement inputSocioBusqueda = $x("//*[@id='socio.rfcBusqueda']");
    public SelenideElement inputBuscar2 = $x("//input[@onclick='javaScript:buscarSocioRFC();']");
    public SelenideElement selectSocioNacionalidad = $x("//*[@id='socio.nacionalidad']");
    public SelenideElement inputSocioAgregarModal = $x("//*[@id='btnSocioAgregarModal']");
    public SelenideElement btnAceptarMiembroNtf = $x("/html/body/div[20]/div[3]/div/button/span");
    public SelenideElement inputMapDeclaracionSolicitudAcepto14 = $x("//*[@id='no463']");
    public SelenideElement inputAcepto = $x("//*[@id='acepto252']");
    public SelenideElement inputAcepto2 = $x("//*[@id='acepto253']");

    //Terceros relacionados
    public SelenideElement labelTercerosRelacionados = $x("//label[contains(@for, 'terceros')]");
    public SelenideElement inputTercero = $x("//*[@id='rfcTercero']");
    public SelenideElement inputBuscar3 = $x("//*[@id='buscar']");
    public SelenideElement spanAceptar8 = $x("/html/body/div[21]/div[3]/div/button/span");
    public SelenideElement inputAgregarEnlaceOperativo = $x("//*[@id='btnAgregarEnlaceOperativo']");
    public SelenideElement input = $x("//*[@id='rfc']");
    public SelenideElement inputBuscarEnlaceOperativo = $x("//*[@id='buscarEnlaceOperativo']");
    public SelenideElement inputTerceroEnlaceOperativoSuplente = $x("//*[@id='terceroEnlaceOperativo.suplente']");
    public SelenideElement inputAceptarEnlace = $x("//*[@id='btnAceptarEnlace']");

    //Textil
    public SelenideElement tabTextil = $x("//*[@id=\"tabs\"]/ul/li[4]/a");
    public SelenideElement radbtnSiOperacionesExteriores = $x("//*[@id=\"comExtSi\"]");
    public SelenideElement radbtnNoOperacionesExteriores = $x("//*[@id=\"comExtNo\"]");
    public SelenideElement fechaInicioOperacionesExt = $x("//*[@id=\"fechaIniOperaComExt\"]");
    //Pago de derecho
    public SelenideElement fechaPagoDerecho = $x("//*[@id=\"fechaPagoOEA\"]");
    public SelenideElement MontoDerecho = $x("//*[@id=\"montoOEA\"]");
    public SelenideElement NumeroOperacionBancaria = $x("//*[@id=\"operBancOEA\"]");
    public SelenideElement LLavePago = $x("//*[@id=\"llaveOEA\"]");
    //Inicio Ventana Agregar transportista
    public SelenideElement inputAgregarTransportista = $x("//*[@id='agregarTransportista']");
    public SelenideElement inputTransportistaCertificacion = $x("//*[@id='trRfc']");
    public SelenideElement inputBuscarEmpresa = $x("//*[@id=\"btnBuscarEmpresa\"]");
    public SelenideElement inputGuardarTransportista = $x("//*[@id=\"btnGuardarTransportista\"]");
    public SelenideElement btnAceptarTransportistaNtf = $x("/html/body/div[23]/div[3]/div/button/span");
    //Fin Ventana Agregar transportista
    public SelenideElement radbtnSiProgramaIMMEX = $x("//*[@id=\"immexSi2075\"]");
    public SelenideElement radbtnSiDeclaracionISR = $x("//*[@id=\"immexSi2079\"]");
    public SelenideElement radbtnSiRegistroEsquemaCer = $x("//*[@id=\"ivaSi2076\"]");
    //Reconocimiento Mutuo
    public SelenideElement radbtnSiReconocimiento = $x("//*[@id=\"si4050Textil\"]");
    public SelenideElement radbtnNoReconocimiento = $x("//*[@id=\"no4050Textil\"]");

    //Clasificacion de la información
    public SelenideElement radbtnInfoPrivada = $x("//*[@id=\"no1090Textil\"]");

    //PERFILES
    public SelenideElement tabPerfiles = $x("//*[@id=\"perfilesTabA\"]");
    //Información general
    public SelenideElement AntiguedadOperacion = $x("//*[@id=\"antiguedadEmpresa0\"]");
    public SelenideElement ProductosManejadosPlanta = $x("//*[@id=\"productosEmpresa0\"]");
    public SelenideElement NoEmbarqueEXP = $x("//*[@id=\"numEmbarquesExpEmpresa0\"]");
    public SelenideElement NoEmbarqueIMP = $x("//*[@id=\"numEmbarquesImoEmpresa0\"]");
    public SelenideElement NumEmpleadosTotal = $x("//*[@id=\"numEmpleadosTotalEmpresa0\"]");
    public SelenideElement SuperficieInstalacion = $x("//*[@id=\"superficieAutoEmpresa0\"]");
    public SelenideElement radbtnSiCTPAT = $x("//*[@id=\"ctpatEmpresaSi0\"]");
    public SelenideElement radbtnNoCTPAT = $x("//*[@id=\"ctpatEmpresaNo0\"]");
    public SelenideElement radbtnSiPIP = $x("//*[@id=\"empresaPipSi0\"]");
    public SelenideElement radbtnNoPIP = $x("//*[@id=\"empresaPipNo0\"]");
    public SelenideElement radbtnSiOEA = $x("//*[@id=\"oeaEmpresaSi0\"]");
    public SelenideElement radbtnNoOEA = $x("//*[@id=\"oeaEmpresaNo0\"]");
    public SelenideElement radbtnSiOtrosSeguridad = $x("//*[@id=\"suministroEmpresaSi0\"]");
    public SelenideElement radbtnNoOtrosSeguridad = $x("//*[@id=\"suministroEmpresaNo0\"]");
    public SelenideElement NombreCertificacion1 = $x("//*[@id=\"perfilIC.nombreCetificacion10\"]");
    public SelenideElement CategoriaCertificacion1 = $x("//*[@id=\"perfilIC.categoriaCertificacion10\"]");
    public SelenideElement fechaVigencia1 = $x("//*[@id=\"perfilEmp.perfilIC.fechaCertificacion10\"]");
    public SelenideElement NombreCertificacion2 = $x("//*[@id=\"perfilIC.nombreCetificacion20\"]");
    public SelenideElement CategoriaCertificacion2 = $x("//*[@id=\"perfilIC.categoriaCertificacion20\"]");
    public SelenideElement fechaVigencia2 = $x("//*[@id=\"perfilEmp.perfilIC.fechaCertificacion20\"]");
    public SelenideElement NombreCertificacion3 = $x("//*[@id=\"perfilIC.nombreCetificacion30\"]");
    public SelenideElement CategoriaCertificacion3 = $x("//*[@id=\"perfilIC.categoriaCertificacion30\"]");
    public SelenideElement fechaVigencia3 = $x("//*[@id=\"perfilEmp.perfilIC.fechaCertificacion30\"]");

    //1. Planeación de la seguridad en la cadena de suministros
    public SelenideElement seccion1 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[1]/a");
    //1.1 Análisis de riesgo
    public SelenideElement radbtnSiIdentificacionRiesgo = $x("//*[@id=\"procedDocRiesgoEmpresaSi0\"]");
    public SelenideElement radbtnNoIdentificacionRiesgo = $x("//*[@id=\"procedDocRiesgoEmpresaNo0\"]");
    public SelenideElement radbtnSiIndentificacionCumplimiento = $x("//*[@id=\"procedimientosPolSegEmpSi0\"]");
    public SelenideElement radbtnNoIndentificacionCumplimiento = $x("//*[@id=\"procedimientosPolSegEmpNo0\"]");
    public SelenideElement MiembrosComiteSeguridad = $x("//*[@id=\"nombrepuesto0\"]");
    public SelenideElement FuentesInfoRiesgos = $x("//*[@id=\"fuentesInformacionCalR0\"]");
    //1,2 Políticas de seguridad
    public SelenideElement SeguridadOrientadoAmenazas = $x("//*[@id=\"politicasSeguridadEmpresa0\"]");
    public SelenideElement ResponsableRevision = $x("//*[@id=\"responsableRevisionAct0\"]");
    public SelenideElement PeriodicidadActualizacion = $x("//*[@id=\"periodicidadActualizacion0\"]");
    public SelenideElement ProgramaDifusionPolitica = $x("//*[@id=\"programaDifusion0\"]");
    public SelenideElement radbtnSiCapacitacionInicial = $x("//*[@id=\"blnRegistoCapacitacionSi0\"]");
    public SelenideElement radbtnNoCapacitacionInicial = $x("//*[@id=\"blnRegistoCapacitacionNo0\"]");
    //1.3 Auditorias internas en la cadena de suministro
    public SelenideElement radbtnSiProcedimientoDocumentado = $x("//*[@id=\"blnProcDocumentadoSi0\"]");
    public SelenideElement radbtnNoProcedimientoDocumentado = $x("//*[@id=\"blnProcDocumentadoNo0\"]");
    public SelenideElement DescripcionProcedimiento = $x("//*[@id=\"perfilPlaneacion.desDocumentInterna0\"]");
    public SelenideElement NombreProcedimiento = $x("//*[@id=\"perfilPlaneacion.responsableAuditorias0\"]");
    public SelenideElement radbtnSiAuditoriasRiesgo = $x("//*[@id=\"blnEnfoqueOrgSi0\"]");
    public SelenideElement radbtnNoAuditoriasRiesgo = $x("//*[@id=\"blnEnfoqueOrgNo0\"]");
    public SelenideElement ProcesosAuditan = $x("//*[@id=\"perfilPlaneacion.procesoTopicosAuditan0\"]");
    public SelenideElement radbtnSiRegistroResultados = $x("//*[@id=\"blnRegistroResultAudSi0\"]");
    public SelenideElement radbtnNoRegistroResultados = $x("//*[@id=\"blnRegistroResultAudNo0\"]");
    public SelenideElement ProgramacionAuditoriaInterna = $x("//*[@id=\"progamacionAud0\"]");
    public SelenideElement ParticipantesAuditoriaInterna = $x("//*[@id=\"perfilPlaneacion.participanteAuditoria0\"]");
    public SelenideElement radbtnSiGerenciaVerificaAuditoria = $x("//*[@id=\"gerenciaResultAudSi0\"]");
    public SelenideElement radbtnNoGerenciaVerificaAuditoria = $x("//*[@id=\"gerenciaResultAudNo0\"]");
    //1.4 Planes de contingéncia y/o emergencia
    public SelenideElement radbtnSiProcedimientosExterior = $x("//*[@id=\"blnProcedimientoContiSi0\"]");
    public SelenideElement radbtnNoProcedimientosExterior = $x("//*[@id=\"blnProcedimientoContiNo0\"]");
    public SelenideElement PlanCrisis = $x("//*[@id=\"perfilPlaneacion.desSituacionesContin0\"]");
    public SelenideElement MecanismoDifunsion = $x("//*[@id=\"perfilPlaneacion.desMecanismosContin0\"]");
    public SelenideElement radbtnSiRegistrosCapacitaciones = $x("//*[@id=\"blnCapacitacionesPlanContinSi0\"]");
    public SelenideElement radbtnNoRegistrosCapacitaciones = $x("//*[@id=\"blnCapacitacionesPlanContinNo0\"]");

    //2 Seguridad Física
    public SelenideElement seccion2 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[2]/a");
    //2.1 Instalaciones
    public SelenideElement MateriasPredominantes = $x("//*[@id=\"perfilSegFisica.desMaterialesProdominantes0\"]");
    public SelenideElement FormaRevision = $x("//*[@id=\"perfilSegFisica.formaRevision0\"]");
    public SelenideElement PersonalInspeccion = $x("//*[@id=\"personalInspeccionInst0\"]");
    //2.2 Accesos en puertas y casetas
    public SelenideElement NumPuertasAccesos = $x("//*[@id=\"perfilSegFisica.numPuertasAcceso0\"]");
    public SelenideElement HorarioOperacion = $x("//*[@id=\"perfilSegFisica.horarioOperarPuertas0\"]");
    public SelenideElement Monitoreo = $x("//*[@id=\"perfilSegFisica.formaMonitoreoPuestas0\"]");
    public SelenideElement PuertasBloqueadas = $x("//*[@id=\"perfilSegFisica.detallesExisPuertas0\"]");
    public SelenideElement AseguramientoAccesos = $x("//*[@id=\"perfilSegFisica.controlesAccesoAreas0\"]");
    //2.3 Bardas perimetrales
    public SelenideElement TipoCercaBarrera = $x("//*[@id=\"perfilSegFisica.desTipoBarrera0\"]");
    public SelenideElement AreasSegregadas = $x("//*[@id=\"perfilSegFisica.areasEncierraCerca0\"]");
    public SelenideElement CaracteristicasAreas = $x("//*[@id=\"perfilSegFisica.caracteristicasCerca0\"]");
    public SelenideElement RazonNoBardas = $x("//*[@id=\"perfilSegFisica.noBardasJust0\"]");
    public SelenideElement PeriodoVerificacion = $x("//*[@id=\"perfilSegFisica.periodoVerificaBardas0\"]");
    public SelenideElement PersonalInspeccionDaños = $x("//*[@id=\"perfilSegFisica.respReparacionDanos0\"]");
    public SelenideElement ManeraSegregacion = $x("//*[@id=\"perfilSegFisica.descSegregadaLaCarga0\"]");
    public SelenideElement SeparacionMercancia = $x("//*[@id=\"perfilSegFisica.separaMercanciaNacional0\"]");
    public SelenideElement AreasRestringidas = $x("//*[@id=\"perfilSegFisica.areasAccesoRestringido0\"]");
    //2.4 Estacionamientos
    public SelenideElement ProcedimientosControl = $x("//*[@id=\"perfilSegFisica.desProcedimientoCtrlEst0\"]");
    public SelenideElement ResponsablesControl = $x("//*[@id=\"perfilSegFisica.responAccesoEstacionamiento0\"]");
    public SelenideElement IndentificacionEstacionamientos = $x("//*[@id=\"perfilSegFisica.identificacionEstacionamientos0\"]");
    public SelenideElement EntradaSalidaVehiculos = $x("//*[@id=\"perfilSegFisica.controlEntradaSalidaEst0\"]");
    public SelenideElement NoVehiculosPrivados = $x("//*[@id=\"perfilSegFisica.polMecanismosNoVehiculos0\"]");
    //2.5 Control de llaves y dispositivos de cerraduras
    public SelenideElement radbtnSiMecanismoCierreVehiculo = $x("//*[@id=\"blnControlInExtLlavesSi0\"]");
    public SelenideElement radbtnNoMecanismoCierreVehiculo = $x("//*[@id=\"blnControlInExtLlavesNo0\"]");
    public SelenideElement ResponsableSeguridadLLaves = $x("//*[@id=\"perfilSegFisica.responsablesAdmiCtrlLlaves0\"]");
    public SelenideElement RegistroLLaves = $x("//*[@id=\"perfilSegFisica.registroControlLlaves0\"]");
    public SelenideElement PerdidaLlaves = $x("//*[@id=\"perfilSegFisica.perdidaLlaves0\"]");
    public SelenideElement AccesoElectronicos = $x("//*[@id=\"perfilSegFisica.desAreasAccesoElectro0\"]");
    //2.6 Alumbrado
    public SelenideElement MantenimientoIluminacion = $x("//*[@id=\"perfilSegFisica.desProcIluminacion0\"]");
    public SelenideElement AreasIluminadas = $x("//*[@id=\"perfilSegFisica.areasIlumindas0\"]");
    public SelenideElement radbtnSiPlantaAuxiliar = $x("//*[@id=\"blnPlantaPoderAuxSi0\"]");
    public SelenideElement radbtnNoPlantaAuxiliar = $x("//*[@id=\"blnPlantaPoderAuxNo0\"]");
    public SelenideElement MecanismoContigenciaEnergia = $x("//*[@id=\"perfilSegFisica.sumMecanismoEnContingencia0\"]");
    public SelenideElement DescripcionControlIluminacion = $x("//*[@id=\"perfilSegFisica.iluminacionApropiada0\"]");
    public SelenideElement ResponsableControlIluminacion = $x("//*[@id=\"perfilSegFisica.respControlIlum0\"]");
    public SelenideElement ProgramaMantenimiento = $x("//*[@id=\"perfilSegFisica.programaManYRev0\"]");
    //2.7 Aparatos de comunicación
    public SelenideElement ProcContactoPersonalSeguridad = $x("//*[@id=\"perfilSegFisica.descProcAparatosComunicacion0\"]");
    public SelenideElement PersonalAparatosSeguridad = $x("//*[@id=\"perfilSegFisica.ctaPersaparatos0\"]");
    public SelenideElement TipoAparatos = $x("//*[@id=\"perfilSegFisica.aparatosComunicacion0\"]");
    public SelenideElement DescripcionControlAparatos = $x("//*[@id=\"perfilSegFisica.desProcMantenimientoCom0\"]");
    public SelenideElement PoliticasAsignacionAparatos = $x("//*[@id=\"perfilSegFisica.politicasComunicacion0\"]");
    public SelenideElement ProgramaMantenimientoAparatos = $x("//*[@id=\"perfilSegFisica.programaMantenimentoCom0\"]");
    public SelenideElement AparatosRespaldo = $x("//*[@id=\"perfilSegFisica.cuentaAparatosResp0\"]");
    //2.8 Sistemas de alarma y circuito cerrado de television y video vigilancia
    public SelenideElement DescripcionFuncionAlarmas = $x("//*[@id=\"perfilSegFisica.descProcediminetoFuncAlarma0\"]");
    public SelenideElement radbtnSiSensoresPuertasVentanas = $x("//*[@id=\"blnpuertasVentanasAlarmaSi0\"]");
    public SelenideElement radbtnNoSensoresPuertasVentanas = $x("//*[@id=\"blnpuertasVentanasAlarmaNo0\"]");
    public SelenideElement DescripcionProcedimientoActivacionAlarma = $x("//*[@id=\"perfilSegFisica.procActivarAlarma0\"]");
    public SelenideElement DescripcionProcedimientoOperacionAlarma = $x("//*[@id=\"perfilSegFisica.desProcDocCctv0\"]");
    public SelenideElement NumCamarasUbicacion = $x("//*[@id=\"perfilSegFisica.numcamarasCctv0\"]");
    public SelenideElement LugarInspeccion = $x("//*[@id=\"perfilSegFisica.dondeInspeccionSub0\"]");
    public SelenideElement UbicacionMonitores = $x("//*[@id=\"perfilSegFisica.ubicacionCctv0\"]");
    public SelenideElement HorariosOperacion = $x("//*[@id=\"perfilSegFisica.horariosOperacion0\"]");
    public SelenideElement FormaRevisionGrabaciones = $x("//*[@id=\"perfilSegFisica.revisionPeriodicaGraba0\"]");
    public SelenideElement PersonalRevisiones = $x("//*[@id=\"perfilSegFisica.personalDesignadoRev0\"]");
    public SelenideElement DocumentacionRevisiones = $x("//*[@id=\"perfilSegFisica.documentanResultadosRevAud0\"]");
    public SelenideElement TiempoGrabacionesGuardadas = $x("//*[@id=\"perfilSegFisica.tiempoGrabaciones0\"]");
    public SelenideElement radbtnSiRespaldoPlantaElectrica = $x("//*[@id=\"sistemaCctvRespaldadoSi0\"]");
    public SelenideElement radbtnNoRespaldoPlantaElectrica = $x("//*[@id=\"sistemaCctvRespaldadoNo0\"]");
    public SelenideElement MecanismoAlternoEnergia = $x("//*[@id=\"perfilSegFisica.noPlantaElect0\"]");
    public SelenideElement NotfFallaFuncionamiento = $x("//*[@id=\"perfilSegFisica.sistFunciAlarma0\"]");
    public SelenideElement TecnologiaRobustescaSeguridad = $x("//*[@id=\"perfilSegFisica.adiSistAlarmaTecno0\"]");
    public SelenideElement DescripcionProcedimientoInspRegularSeguridad = $x("//*[@id=\"perfilSegFisica.descProcedimientoImpProbarInspeccionar0\"]");
    public SelenideElement radbtnSiProveedorAccesoCamaras = $x("//*[@id=\"blnProvConAccesoCamSi0\"]");
    public SelenideElement radbtnNoProveedorAccesoCamaras = $x("//*[@id=\"blnProvConAccesoCamNo0\"]");
    public SelenideElement ControlAccesosMonitoreo = $x("//*[@id=\"perfilSegFisica.formaControlanAccesosResp0\"]");

    //3.-Controles de acceso físico
    public SelenideElement seccion3 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[3]/a");
    //3.1 Personal de seguridad
    public SelenideElement DescribirOperacionPersonalSeguridad = $x("//*[@id=\"perfilControles.desProcPersonalSeg0\"]");
    public SelenideElement NumPersonalSeguridad = $x("//*[@id=\"perfilControles.numPersonalSeg0\"]");
    public SelenideElement CargosFuncionesPersonal = $x("//*[@id=\"perfilControles.cargosFunPersonalOp0\"]");
    public SelenideElement ServicioExterno = $x("//*[@id=\"perfilControles.contratoServicioExt0\"]");
    public SelenideElement PersonalArmado = $x("//*[@id=\"perfilControles.desPersonalArmado0\"]");
    //3.2 Identificación de los empleados
    public SelenideElement DescribirIdentificacionEmpleados = $x("//*[@id=\"perfilControles.desProcIdentificacionEmpl0\"]");
    public SelenideElement MecanismoIdentificacion = $x("//*[@id=\"perfilControles.mecanismosIdentificacion0\"]");
    public SelenideElement AsignacionUniformesEmpleados = $x("//*[@id=\"perfilControles.uniformePersonalSC0\"]");
    public SelenideElement PersonalSocioComercial = $x("//*[@id=\"perfilControles.identificarPersonalSC0\"]");
    public SelenideElement DescribirControlesAcceso = $x("//*[@id=\"perfilControles.desEmpresaCambiaIden0\"]");
    public SelenideElement AccesoAreasSensibles = $x("//*[@id=\"perfilControles.desAccesoAreasRest0\"]");
    //3.3 Identificación de visitantes y proveedores
    public SelenideElement ControlVisitantesProveedores = $x("//*[@id=\"perfilControles.desProcControlAcceso0\"]");
    public SelenideElement RegistrosVisitas = $x("//*[@id=\"perfilControles.registroBitacora0\"]");
    public SelenideElement radbtnSiRegistroVisitasLista = $x("//*[@id=\"blnRegistroVisitantesProveedoresSi0\"]");
    public SelenideElement radbtnNoRegistroVisitasLista = $x("//*[@id=\"blnRegistroVisitantesProveedoresNo0\"]");
    public SelenideElement ResponsableAcompañanteVisitante = $x("//*[@id=\"perfilControles.personaRespVisitantes0\"]");
    //3.4 Entregas de mensajería y paquetería
    public SelenideElement RecepcionMensajeriaPaqueteria = $x("//*[@id=\"perfilControles.desMensajeriaPaqueteria0\"]");
    public SelenideElement IdentificarProveedorServicio = $x("//*[@id=\"perfilControles.proveedorServicioId0\"]");
    public SelenideElement RevisionMensajeriaPaqueteria = $x("//*[@id=\"perfilControles.formaRevisaPaquet0\"]");
    public SelenideElement MensajeriaPaqueteriaSospechosa = $x("//*[@id=\"perfilControles.accionDetPaqSospechoso0\"]");

    //4.-Socios Comerciales
    public SelenideElement seccion4 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[4]/a");
    //4.1 Criterios de selección
    public SelenideElement ProgramaSocial = $x("//*[@id=\"perfilSocioComer.programaCumplimientoSocialEmpleadosSC0\"]");
    //4.2 Requerimientos en seguridad
    public SelenideElement IdentificacionSociosComerciales = $x("//*[@id=\"perfilSocioComer.descProcedimientoIdentiSC0\"]");
    public SelenideElement SociosCumplirSeguridad = $x("//*[@id=\"perfilSocioComer.regSocioComReqSeg0\"]");
    public SelenideElement FormaCumplimientoSeguridad = $x("//*[@id=\"perfilSocioComer.formaDocRequeScSegu0\"]");
    public SelenideElement ConveniosImplementacionSeguridad = $x("//*[@id=\"perfilSocioComer.acuerdoContSeg\"]");
    public SelenideElement SociosEnProgramaSeguridad = $x("//*[@id=\"perfilSocioComer.sCProgramaSeguridad\"]");
    //4.3 Revisiones del socio comercial
    public SelenideElement ListaProcedimiento = $x("//*[@id=\"perfilSocioComer.desProcVerificarReqMateriaSeg0\"]");
    public SelenideElement PeriodicidadVisitaSociosComerciales = $x("//*[@id=\"perfilSocioComer.periocidadVisSc0\"]");
    public SelenideElement ProgramaRevisionesSeguridad = $x("//*[@id=\"perfilSocioComer.programaCalendarioSeg0\"]");
    public SelenideElement RegistroVerificacion = $x("//*[@id=\"perfilSocioComer.registroVerificacion0\"]");
    public SelenideElement FormatoVerificacion = $x("//*[@id=\"perfilSocioComer.formatoVerificacion0\"]");
    public SelenideElement MedidasIncumplimientoSocios = $x("//*[@id=\"perfilSocioComer.medidasAccionScNoCumple0\"]");
    public SelenideElement SociosCTPAT = $x("//*[@id=\"perfilSocioComer.periodicidadRevisadoEstatus0\"]");

    //5.-Seguridad de procesos
    public SelenideElement seccion5 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[5]/a");
    //5.1 Mapeo de procesos
    public SelenideElement ProcesoSubManufactura = $x("//*[@id=\"perfilSegProce.procesoSubManofactura0\"]");
    //5.2 Almacenes y centros de distribución
    public SelenideElement ActividadInstalacion = $x("//*[@id=\"perfilSegProce.explicarActividad0\"]");
    //5.3 Entrega y recepción de carga
    public SelenideElement ProcedimientoEntregaMercancia = $x("//*[@id=\"perfilSegProce.descProcedimientoEntregaRecepcionMerc0\"]");
    //5.4 Procedimiento de seguimiento de la mercancía
    public SelenideElement CustodiaEmbarque = $x("//*[@id=\"perfilSegProce.empresaServiciosCustodiaEmbarques0\"]");
    //5.6 Procesamiento de la información  y documentación de la carga
    public SelenideElement ProcesamientoInfoCarga = $x("//*[@id=\"perfilSegProce.desProcInfoAA0\"]");
    public SelenideElement TransmicionInfoTransladoCarga = $x("//*[@id=\"perfilSegProce.desProcesamiento0\"]");
    public SelenideElement AseguramientoFormularios = $x("//*[@id=\"perfilSegProce.utilizaSisInformatico0\"]");
    public SelenideElement TransmitirInfoEmpresaAsociados = $x("//*[@id=\"perfilSegProce.formaAsocTranInfo0\"]");

    //6.-Gestión Aduanera
    public SelenideElement seccion6 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[6]/a");
    //6.1 Gestión del despacho aduanero.
    public SelenideElement EvaluacionAduanal = $x("//*[@id=\"perfilGestAduanera.desProcSelecAa0\"]");
    public SelenideElement CriteriosSeleccion = $x("//*[@id=\"perfilGestAduanera.criteriosSeleccion0\"]");
    public SelenideElement MetodosEvaluacionPeriodicidadAduana = $x("//*[@id=\"perfilGestAduanera.metodosEvalPer0\"]");
    public SelenideElement IndicadoresEvaluacionAgentesAduanales = $x("//*[@id=\"perfilGestAduanera.indicadoresEvaluaAA0\"]");
    public SelenideElement NombrePatenteAgenteAduanal = $x("//*[@id=\"perfilGestAduanera.nomNumPatente0\"]");
    //6.2 Obligaciones aduaneras
    public SelenideElement radbtnSiArticulo59 = $x("//*[@id=\"blnProcDocCtrlInvSi0\"]");
    public SelenideElement radbtnNoArticulo59 = $x("//*[@id=\"blnProcDocCtrlInvNo0\"]");
    public SelenideElement radbtnSiProgramaIMMEXAduana = $x("//*[@id=\"blnProgremaImmexSi0\"]");
    public SelenideElement radbtnNoProgramaIMMEXAduana = $x("//*[@id=\"blnProgremaImmexNo0\"]");
    public SelenideElement NumRegistroAduana = $x("//*[@id=\"perfilGestAduanera.numRegistroImmex0\"]");
    public SelenideElement radbtnSiProgramaExportacion = $x("//*[@id=\"blnGestAdOtroProgSi0\"]");
    public SelenideElement radbtnNoProgramaExportacion = $x("//*[@id=\"blnGestAdOtroProgNo0\"]");
    public SelenideElement NombrePrograma = $x("//*[@id=\"perfilGestAduanera.nomPrograma0\"]");
    public SelenideElement NumRegistroPrograma = $x("//*[@id=\"perfilGestAduanera.numRegistro0\"]");

    //7. Seguridad de los vehículos de carga, contenedores, carros de tren, remolques y/o semirremolques.
    public SelenideElement seccion7 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[7]/a");
    //7.1 Integridad de la carga y uso de sellos en contenedores y remolques.
    public SelenideElement DetalleVehiculoTransladoMerca = $x("//*[@id=\"perfilSegTransporte.detTipoVehiculo0\"]");
    public SelenideElement TransportePropiedad = $x("//*[@id=\"perfilSegTransporte.unidadesPropiedadEmp0\"]");
    public SelenideElement EmpresasTransportistasContratadas = $x("//*[@id=\"perfilSegTransporte.empTranspContratadas0\"]");
    //7.2 Inspección de los medios de transporte, contenedores, carros de tren, remolques y semirremolques
    public SelenideElement LugarReparacionesTransportes = $x("//*[@id=\"perfilSegTransporte.reparaMattoTrans0\"]");
    public SelenideElement CumplimientoCondicionesTransporte = $x("//*[@id=\"perfilSegTransporte.vehiculosCargaContRemolTraficoInt0\"]");
    public SelenideElement radbtnSiRevisionesAleatorias = $x("//*[@id=\"blnRevAleaPeriodSi0\"]");
    public SelenideElement radbtnNoRevisionesAleatorias = $x("//*[@id=\"blnRevAleaPeriodNo0\"]");
    //7.3 Almacenaje de vehículos, medios de transporte, contenedores, carros de tren, remolques y semirremolques.
    public SelenideElement radbtnSiAlamacenPrevContenedores = $x("//*[@id=\"blnEmpAlmacenaContSi0\"]");
    public SelenideElement radbtnNoAlamacenPrevContenedores = $x("//*[@id=\"blnEmpAlmacenaContNo0\"]");
    public SelenideElement IntegridadContenedores = $x("//*[@id=\"perfilSegTransporte.tipoCandadoSellos0\"]");
    public SelenideElement AlmacenMateriaPrima = $x("//*[@id=\"perfilSegTransporte.utilizarAlgunContedor0\"]");

    //8. Seguridad del personal
    public SelenideElement seccion8 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[8]/a");
    //8.1 Verificación de antecedentes laborales.
    public SelenideElement ProcedimientoContratacionPersonal = $x("//*[@id=\"perfilSegPers.desProcContPers0\"]");
    public SelenideElement RequisitosContratacion = $x("//*[@id=\"perfilSegPers.reqDocExigida0\"]");
    public SelenideElement PruebasExamenesSeguridad = $x("//*[@id=\"perfilSegPers.pruebasExamSol0\"]");
    public SelenideElement AreasRiesgo = $x("//*[@id=\"perfilSegPers.areasCriticas0\"]");
    public SelenideElement RequerimientosAdicionales = $x("//*[@id=\"perfilSegPers.reqAdicionales0\"]");
    public SelenideElement AcuerdoConfidencialidad = $x("//*[@id=\"perfilSegPers.candidatoFirmaDoc0\"]");
    public SelenideElement ProcedimientoAgernciaServicios = $x("//*[@id=\"perfilSegPers.cuentaProcDocCont0\"]");

    //8.2 Procedimineto para baja del personal
    public SelenideElement BajaPersonal = $x("//*[@id=\"perfilSegPers.desBajaPersonal0\"]");
    public SelenideElement ResponsableEjecutarBajaPersonal = $x("//*[@id=\"perfilSegPers.respProcBajaPersonal0\"]");
    public SelenideElement EntregaIdentificaciones = $x("//*[@id=\"perfilSegPers.entregaIdentif0\"]");
    public SelenideElement ControlEntregaMaterial = $x("//*[@id=\"perfilSegPers.cuentaRegBaja0\"]");
    public SelenideElement PersonalFinalizoRelacionLaboral = $x("//*[@id=\"perfilSegPers.mantieneRegBaja0\"]");
    //8.3 Administración de personal
    public SelenideElement radbtnSiListaAdminPersonal = $x("//*[@id=\"blnEmpBdSi0\"]");
    public SelenideElement radbtnNoListaAdminPersonal = $x("//*[@id=\"blnEmpBdNo0\"]");

    //9. Seguridad de la información y documentación
    public SelenideElement seccion9 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[9]/a");
    //9.2 Seguridad de la tecnología de la información.
    public SelenideElement PoliticasAtaquesRiesgos = $x("//*[@id=\"perfilSegInfor.desProcArchivar0\"]");
    public SelenideElement SeguridadVPNEmpleados = $x("//*[@id=\"perfilSegInfor.medidasSegInfo0\"]");
    public SelenideElement PermisoDispositivosPersonales = $x("//*[@id=\"perfilSegInfor.dispositivoPersonal0\"]");
    public SelenideElement AccesoSociosSistema = $x("//*[@id=\"perfilSegInfor.frecuenciaCopias0\"]");
    public SelenideElement radbtnSiRespladoSuministro = $x("//*[@id=\"blnEquipoCompSistResSi0\"]");
    public SelenideElement radbtnNoRespladoSuministro = $x("//*[@id=\"blnEquipoCompSistResNo0\"]");
    public SelenideElement TiempoDatosAlmacenados = $x("//*[@id=\"perfilSegInfor.procRespaldoInformacion0\"]");
    public SelenideElement PlanRecuperacionDatos = $x("//*[@id=\"perfilSegInfor.planContinuidadNegocioIncidente0\"]");
    public SelenideElement LocalizacionCopiasSeguridad = $x("//*[@id=\"perfilSegInfor.frecuenciaLocalizacionCopiaSeguridad0\"]");
    public SelenideElement LozalizacionCopiasSeguridadAlter = $x("//*[@id=\"perfilSegInfor.copiaSeguridadInstalaciones0\"]");
    public SelenideElement PruebaValidezRecuperacion = $x("//*[@id=\"perfilSegInfor.pruebasRecuperacionDatos0\"]");
    public SelenideElement ProcedimientoProteccionInfo = $x("//*[@id=\"perfilSegInfor.desProcProteccion0\"]");
    public SelenideElement PoliticaProteccionInfo = $x("//*[@id=\"perfilSegInfor.politicaProteccion0\"]");
    public SelenideElement MultiSedesControlSistemas = $x("//*[@id=\"perfilSegInfor.detalleSistMult0\"]");
    public SelenideElement ResponsableProteccionInfo = $x("//*[@id=\"perfilSegInfor.responsableProtecSist0\"]");
    public SelenideElement MonitoreoAccesoInfo = $x("//*[@id=\"perfilSegInfor.cuentasIndivRestringido0\"]");
    public SelenideElement FormatoContrasena = $x("//*[@id=\"perfilSegInfor.sistemasProtegidos0\"]");
    public SelenideElement NombreCortafuegosAntivirus = $x("//*[@id=\"perfilSegInfor.firewall0\"]");
    public SelenideElement PrevencionUsoTecnologiaFalsa = $x("//*[@id=\"perfilSegInfor.medidasPrevProductosTecno0\"]");
    public SelenideElement ProcedimientoFormateo = $x("//*[@id=\"perfilSegInfor.procFormateo0\"]");
    public SelenideElement ProcedimientoEliminarAcceso = $x("//*[@id=\"perfilSegInfor.procBajaPersonal0\"]");
    public SelenideElement MedidasPrevAccesoComprometido = $x("//*[@id=\"perfilSegInfor.medidaIncidente0\"]");

    //10. Capacitación en Seguridad y concientización
    public SelenideElement seccion10 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[10]/a");
    //10.1 Capacitación y concientización sobre amenazas
    public SelenideElement TemasImpartidos = $x("//*[@id=\"perfilCapacitacion.temasPrograma0\"]");
    public SelenideElement MomentoImpartirTemas = $x("//*[@id=\"perfilCapacitacion.momentoImparte0\"]");
    public SelenideElement PeriodicidadCapacitaciones = $x("//*[@id=\"perfilCapacitacion.periodicidadCapac0\"]");
    public SelenideElement DocumentarParticipacionCapacitaciones = $x("//*[@id=\"perfilCapacitacion.formaDocCapac0\"]");
    public SelenideElement FomentacionParticipacion = $x("//*[@id=\"perfilCapacitacion.fomentaParticipacion0\"]");
    //10.2 Concientización a los operadores de los medios de transporte.
    public SelenideElement ProgramaDifusionSeguridad = $x("//*[@id=\"perfilCapacitacion.desProcMatSeg0\"]");
    public SelenideElement FormaDifusion = $x("//*[@id=\"perfilCapacitacion.caboDifusion0\"]");
    public SelenideElement ListaTemasSeguridad = $x("//*[@id=\"perfilCapacitacion.temasCubren0\"]");
    public SelenideElement PoliticasSocioComercialSeguridad = $x("//*[@id=\"perfilCapacitacion.servScPolSeg0\"]");
    public SelenideElement DocumentarCapacitacionSeguridadSuministros = $x("//*[@id=\"perfilCapacitacion.formaDocumPartic0\"]");

    //11 Manejo e investigación de incidentes
    public SelenideElement seccion11 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[10]/td/div/div[11]/a");
    //11.1 Reporte de anomalías y/o actividades sospechosas
    public SelenideElement DenunciaActividadSospechosa = $x("//*[@id=\"perfilManejo.desProcAnomalias0\"]");
    public SelenideElement ResponsableReporteActividadSospechosa = $x("//*[@id=\"perfilManejo.responsableReporta0\"]");
    public SelenideElement IdentificacionComunicacionAutoridad = $x("//*[@id=\"perfilManejo.detalleComAuto0\"]");
    public SelenideElement ReporteActividadSospechosa = $x("//*[@id=\"perfilManejo.llevaRegReporte0\"]");
    //11.2 Investigación y análisis
    public SelenideElement InvestigacionPorIncidente = $x("//*[@id=\"perfilManejo.desProcIniInv0\"]");
    public SelenideElement ResponsableInvestigacion = $x("//*[@id=\"perfilManejo.responsableInv0\"]");
    public SelenideElement ExpedienteInvestigacion = $x("//*[@id=\"perfilManejo.doctoExpediente0\"]");

    //CTPAT
    public SelenideElement tabCTPAT = $x("//*[@id=\"ctpatTab\"]/a");
    public SelenideElement radbtnSiAutorizaCTPAT = $x("//*[@id=\"si2089\"]");
    public SelenideElement radbtnSicertificacionCTPAT = $x("//*[@id=\"si2090\"]");
    public SelenideElement radbtnNoFechaCancelacionSuspencion = $x("//*[@id=\"no2091\"]");

    //Continuar de Paso 1
    public SelenideElement btnSiguientePaso1= $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos necesarios
    public SelenideElement btnSiguientePaso2 = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[42]/td[2]/input");
    public SelenideElement btnSiguientePaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo6 = $x("//*[@id=\"solicitud_5\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo7 = $x("//*[@id=\"solicitud_6\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo8 = $x("//*[@id=\"solicitud_7\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo9 = $x("//*[@id=\"solicitud_8\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo10 = $x("//*[@id=\"solicitud_9\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo11 = $x("//*[@id=\"solicitud_10\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo12 = $x("//*[@id=\"solicitud_11\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo13 = $x("//*[@id=\"solicitud_12\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo14 = $x("//*[@id=\"solicitud_13\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo15 = $x("//*[@id=\"solicitud_14\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo16 = $x("//*[@id=\"solicitud_15\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo17 = $x("//*[@id=\"solicitud_16\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo18 = $x("//*[@id=\"solicitud_17\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo19 = $x("//*[@id=\"solicitud_18\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo20 = $x("//*[@id=\"solicitud_19\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo21 = $x("//*[@id=\"solicitud_20\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo22 = $x("//*[@id=\"solicitud_21\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo23 = $x("//*[@id=\"solicitud_22\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo24 = $x("//*[@id=\"solicitud_23\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo25 = $x("//*[@id=\"solicitud_24\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo26 = $x("//*[@id=\"solicitud_25\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo27 = $x("//*[@id=\"solicitud_26\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo28 = $x("//*[@id=\"solicitud_27\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo29 = $x("//*[@id=\"solicitud_28\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo30 = $x("//*[@id=\"solicitud_29\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo31 = $x("//*[@id=\"solicitud_30\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo32 = $x("//*[@id=\"solicitud_31\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo33 = $x("//*[@id=\"solicitud_32\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo34 = $x("//*[@id=\"solicitud_33\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo35 = $x("//*[@id=\"solicitud_34\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo36 = $x("//*[@id=\"solicitud_35\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo37 = $x("//*[@id=\"solicitud_36\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo38 = $x("//*[@id=\"solicitud_37\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo39 = $x("//*[@id=\"solicitud_38\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");




}
