package HACIENDA.Tramite32616;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32616 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement solicitudRegistro = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement Tramite32616 = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/ul/li[12]/a");

    /// datos comunes
    public SelenideElement datosComunes = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement sectorProductivo = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    public SelenideElement servicio = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[1].catalogo\"]");
    public SelenideElement cumplimientoObligacionesSi = $x("//*[@id=\"si190\"]");
    public SelenideElement autorizoSATSi = $x("//*[@id=\"si191\"]");
    public SelenideElement empleadosPropiosSi = $x("//*[@id=\"emPropiosSi\"]");
    public SelenideElement numEmpleadosPropios = $x("//*[@id=\"empPropios\"]");
    public SelenideElement bimestreEmpleadosPropios = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");
    public SelenideElement isrSi = $x("//*[@id=\"isrSi\"]");
    public SelenideElement pagoCuotasObreroPatronalesSi = $x("//*[@id=\"obreroPatronalesSi\"]");
    public SelenideElement subcontratacionSi = $x("//*[@id=\"si2011\"]");
    public SelenideElement agregarSubcontratado = $x("//*[@id=\"agregarSubcontratado\"]");
    public SelenideElement rfcSubcontratado = $x("//*[@id=\"subcontratado.rfcBusqueda\"]");
    public SelenideElement click = $x("//*[@id=\"subcontratado.rfc\"]");
    public SelenideElement btnBuscarRfcSub = $x("/html/body/div[9]/div[2]/table/tbody/tr[1]/td/div/div[1]/input[2]");
    public SelenideElement NumEmpleado = $x("//*[@id=\"subcontratado.empleados\"]");
    public SelenideElement Periodo = $x("//*[@id=\"subcontratado.bimestre\"]");
    public SelenideElement btnAcept = $x("//*[@id=\"subcontratadoAgregarModalEsquemaIC\"]");
    public SelenideElement btnAcept2 = $x("/html/body/div[16]/div[3]/div/button");
    public SelenideElement Check1 = $x("//*[@id=\"si236\"]");
    public SelenideElement Check2 = $x("//*[@id=\"no237\"]");
    public SelenideElement Check3 = $x("//*[@id=\"no238\"]");
    public SelenideElement Check4 = $x("//*[@id=\"no462\"]");
    public SelenideElement Check5 = $x("//*[@id=\"si239\"]");
    public SelenideElement Check6 = $x("//*[@id=\"no240\"]");
    public SelenideElement Immex = $x("//*[@id=\"IMMEX\"]");
    public SelenideElement btnAgregarInstal = $x("//*[@id=\"btnAgregarDomicilios\"]");
    public SelenideElement Entidad = $x("//*[@id=\"entidadFederativaIDC\"]");
    public SelenideElement checkEntidad = $x("//*[@id=\"cb_gridDomiciliosModal\"]");
    public SelenideElement btnAceptEntidad = $x("/html/body/div[10]/div[2]/table/tbody/tr[4]/td/input[1]");
    public SelenideElement CheckSelec = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnModif = $x("//*[@id=\"btnModificarDomicilios\"]");

    public SelenideElement CheckSi = $x("//*[@id=\"siInstalacion\"]");
    public SelenideElement TipoInstalacion = $x("//*[@id=\"domicilio.tipoInstalacion\"]");
    public SelenideElement CheckNo1 = $x("//*[@id=\"noProcesoProd\"]");
    public SelenideElement CheckNo2 = $x("//*[@id=\"noAcreditaIn\"]");
    public SelenideElement CheckNo3 = $x("//*[@id=\"siPerfilMenPaq\"]");
    public SelenideElement btnAceptModif1 = $x("/html/body/div[17]/div[2]/table/tbody/tr[15]/td/input[1]");
    public SelenideElement btnAceptModif2 = $x("/html/body/div[18]/div[3]/div/button");

    public SelenideElement Check7 = $x("//*[@id=\"si243\"]");
    public SelenideElement Check8 = $x("//*[@id=\"no244\"]");
    public SelenideElement CargaExtranjero = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[1]/div/input");
    public SelenideElement CargaExtAcept = $x("//*[@id=\"uploadFileExtranjeros\"]");
    public SelenideElement CargaNacional = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[1]/div/input");
    public SelenideElement CargaNacAcept = $x("//*[@id=\"uploadFileExtranjerosN\"]");
    public SelenideElement Querella = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[5]/tbody/tr[4]/td[2]/input[1]");
    public SelenideElement ControlInvent = $x("//*[@id=\"siInventario\"]");
    public SelenideElement NombreCInvent = $x("//*[@id=\"nombre.inventario\"]");
    public SelenideElement LugarCInvent = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement btnAgregarControlInvent = $x("//*[@id=\"btnAgregar.inventario\"]");
    public SelenideElement btnAceptControlInvent = $x("/html/body/div[22]/div[3]/div/button");
    public SelenideElement CheckInvt = $x("//*[@id=\"si251\"]");
    public SelenideElement btnAgregarMiembroEmpresa = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement Caracter = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement Obligado = $x("//*[@id=\"socio.tributarMexicoTrue\"]");
    public SelenideElement RFCMiembroEmpresa = $x("//*[@id=\"socio.rfcBusqueda\"]");
    public SelenideElement btnBuscarEmpresa = $x("//*[@id=\"buscarRFC\"]");
    public SelenideElement Nacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement btnAceptarMiembroEmpresa = $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptMiemEmpres = $x("/html/body/div[23]/div[3]/div/button");
    public SelenideElement Manifiesto1 = $x("//*[@id=\"no463\"]");
    public SelenideElement Manifiesto2 = $x("//*[@id=\"acepto252\"]");
    public SelenideElement Manifiesto3 = $x("//*[@id=\"acepto253\"]");

    /// Terceros Relacionados
    public SelenideElement PestTercerosR = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[3]/a");
    public SelenideElement RFCTerceros = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscarRFCTerceros = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[3]/table[1]/tbody/tr[3]/td[2]/div/input");
    public SelenideElement btnAceptRFCTerceros = $x("/html/body/div[24]/div[3]/div/button");

    public SelenideElement btnAgregarEnOp = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[3]/table[2]/tbody/tr[4]/td/input[1]");
    public SelenideElement RFCenop = $x("/html/body/div[8]/div[2]/table/tbody/tr[2]/td[1]/div/input");
    public SelenideElement btnBuscarEnop = $x("/html/body/div[8]/div[2]/table/tbody/tr[2]/td[2]/div/input");
    public SelenideElement cargo1 = $x("/html/body/div[8]/div[2]/table/tbody/tr[8]/td[2]/div/input");
    public SelenideElement CheckSuplente = $x("/html/body/div[8]/div[2]/table/tbody/tr[10]/td[3]/div/input");
    public SelenideElement btnAgreEnop = $x("/html/body/div[8]/div[2]/table/tbody/tr[11]/td/input[1]");

    /// Mesnajeria y Paqueteria
    public SelenideElement MesnajeriayPaqueteria = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[5]/a");
    public SelenideElement CheckSoli1 = $x("//*[@id=\"3012Solicitante\"]");
    public SelenideElement CheckSoli2 = $x("//*[@id=\"check1\"]");
    public SelenideElement Si1 = $x("//*[@id=\"si3014\"]");
    public SelenideElement Si2 = $x("//*[@id=\"si3015\"]");
    public SelenideElement FechaVig = $x("//*[@id=\"fechaFinVigenciaRegimenMensajerias\"]");
    public SelenideElement nAutoriza = $x("//*[@id=\"rubroMensajerias\"]");
    public SelenideElement Si3 = $x("//*[@id=\"si3016\"]");
    public SelenideElement Si4 = $x("//*[@id=\"perfilMsi3053\"]");
    public SelenideElement SiAutorizo = $x("//*[@id=\"reconocimientoMutuoMenPaqSi\"]");
    public SelenideElement Si5 = $x("//*[@id=\"RFCMensajeriaPaqueteriaSi\"]");
    public SelenideElement Si6 = $x("//*[@id=\"razonSocialMensajeriaPaqueteriaSi\"]");
    public SelenideElement Si7 = $x("//*[@id=\"direccionFiscalMensajeriaPaqueteriaSi\"]");
    public SelenideElement No1 = $x("//*[@id=\"pagElectronicaMensajeriaPaqueteriaNo\"]");
    public SelenideElement No2 = $x("//*[@id=\"correoElectronicoMensajeriaPaqueteriaNo\"]");
    public SelenideElement No3 = $x("//*[@id=\"telefonoMensajeriaPaqueteriaNo\"]");
    public SelenideElement Public = $x("//*[@id=\"clasiInfoMenPaqSi\"]");
    public SelenideElement nOperacion = $x("//*[@id=\"solicitud.pagoSCC.referenciaBancaria\"]");
    public SelenideElement Banco = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[5]/div[2]/div[1]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/select");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pagoSCC.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarToSCC\"]");

    public SelenideElement perfilMensajeria = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[6]/a");
    public SelenideElement DomicInstalacion = $x("//*[@id=\"domicilioInstalacionMP0\"]");

    public SelenideElement aOpe = $x("//*[@id=\"perfilMensPaq.antiguedad0\"]");
    public SelenideElement prodPre = $x("//*[@id=\"perfilMensPaq.productos0\"]");
    public SelenideElement exp = $x("//*[@id=\"perfilMensPaq.numEmbarquesExp0\"]");
    public SelenideElement imp = $x("//*[@id=\"perfilMensPaq.numEmbarquesImo0\"]");
    public SelenideElement nTotalInst = $x("//*[@id=\"perfilMensPaq.numEmpleadosTotal0\"]");
    public SelenideElement m2 = $x("//*[@id=\"perfilMensPaq.superficie0\"]");

    public SelenideElement nombre1 = $x("//*[@id=\"perfilMensPaq.nombreCetificacion10\"]");
    public SelenideElement cat1 = $x("//*[@id=\"perfilMensPaq.categoriaCertificacion10\"]");
    public SelenideElement Vig1 = $x("//*[@id=\"perfilMensPaq.fechaCertificacion10\"]");

    public SelenideElement nombre2 = $x("//*[@id=\"perfilMensPaq.nombreCetificacion20\"]");
    public SelenideElement cat2 = $x("//*[@id=\"perfilMensPaq.categoriaCertificacion20\"]");
    public SelenideElement Vig2 = $x("//*[@id=\"perfilMensPaq.fechaCertificacion20\"]");

    public SelenideElement nombre3 = $x("//*[@id=\"perfilMensPaq.nombreCetificacion30\"]");
    public SelenideElement cat3 = $x("//*[@id=\"perfilMensPaq.categoriaCertificacion30\"]");
    public SelenideElement Vig3 = $x("//*[@id=\"perfilMensPaq.fechaCertificacion30\"]");

    public SelenideElement Pest1 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[6]/form/div[1]/table/tbody/tr[12]/td/div/div[1]/a");
    public SelenideElement pest1M1 = $x("//*[@id=\"idComiteSeguridad0\"]");
    public SelenideElement pest1M2 = $x("//*[@id=\"idFuentesInformacion0\"]");
    public SelenideElement pest1M3 = $x("//*[@id=\"idDesPoliticasSeguridad0\"]");
    public SelenideElement pest1M4 = $x("//*[@id=\"idDesPoliticasSeguridad0\"]");
    public SelenideElement pest1M5 = $x("//*[@id=\"idPeriodicidadActualizacion0\"]");
    public SelenideElement pest1M6 = $x("//*[@id=\"idProgramaDifusion0\"]");
    public SelenideElement pest1Check1 = $x("//*[@id=\"idBlnRegistoCapacitacionNo0\"]");
    public SelenideElement pest1Check2 = $x("//*[@id=\"idBlnProcedimientoDocumentadoNo0\"]");
    public SelenideElement pest1M7 = $x("//*[@id=\"desProcedimientoDocumentado0\"]");
    public SelenideElement pest1M8 = $x("//*[@id=\"idNombreProcedimiento0\"]");
    public SelenideElement pest1M9 = $x("//*[@id=\"idResponsableAuditorias0\"]");
    public SelenideElement pest1M10 = $x("//*[@id=\"idDescParticipanRegistro0\"]");
    public SelenideElement pest1Check3 = $x("//*[@id=\"idBlnEnfoqueOrgNo0\"]");
    public SelenideElement pest1M11 = $x("//*[@id=\"idProcesoTopicosAuditan0\"]");
    public SelenideElement pest1M12 = $x("//*[@id=\"idDesRegistroResultAud0\"]");
    public SelenideElement pest1M13 = $x("//*[@id=\"idAuditoriaInterneExterna0\"]");
    public SelenideElement pest1M14 = $x("//*[@id=\"idParticipanteAuditoria0\"]");
    public SelenideElement pest1M15 = $x("//*[@id=\"idGerenciaResultAud0\"]");
    public SelenideElement pest1Check4 = $x("//*[@id=\"idBlnProcedimientoContiNo0\"]");

    public SelenideElement pest2 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[6]/form/div[1]/table/tbody/tr[12]/td/div/div[2]/a");
    public SelenideElement pest2M1 = $x("//*[@id=\"idDesMatarialesProdominantes0\"]");
    public SelenideElement pest2M2 = $x("//*[@id=\"idFormaRevision0\"]");
    public SelenideElement pest2M3 = $x("//*[@id=\"idPersonalInspeccionInst0\"]");
    public SelenideElement pest2M4 = $x("//*[@id=\"idHorarioOperarPuertas0\"]");
    public SelenideElement pest2M5 = $x("//*[@id=\"idFormaMonitoreoPuestas0\"]");
    public SelenideElement pest2M6 = $x("//*[@id=\"idDetallesExisPuertas0\"]");
    public SelenideElement pest2M7 = $x("//*[@id=\"idControlesAccesoAreas0\"]");
    public SelenideElement pest2M8 = $x("//*[@id=\"idTipoBarrera0\"]");
    public SelenideElement pest2M9 = $x("//*[@id=\"idAreasEncierraCerca0\"]");
    public SelenideElement pest2M10 = $x("//*[@id=\"idCaracteristicasCerca0\"]");
    public SelenideElement pest2M11 = $x("//*[@id=\"idNoCuentaBardasDescRfe0\"]");
    public SelenideElement pest2M12 = $x("//*[@id=\"idPeriodoVerificaBardas0\"]");
    public SelenideElement pest2M13 = $x("//*[@id=\"idRespReparacionDanos0\"]");
    public SelenideElement pest2M14 = $x("//*[@id=\"idDescCargaExtranjero0\"]");
    public SelenideElement pest2M15 = $x("//*[@id=\"idSeparaMercanciaNacional0\"]");
    public SelenideElement pest2M16 = $x("//*[@id=\"idAreasAccesoRestringido0\"]");
    public SelenideElement pest2M17 = $x("//*[@id=\"idProcEstacionamiento0\"]");
    public SelenideElement pest2M18 = $x("//*[@id=\"idResponAccesoEstacionamiento0\"]");
    public SelenideElement pest2M19 = $x("//*[@id=\"idIdentificacionEstacionamientos0\"]");
    public SelenideElement pest2M20 = $x("//*[@id=\"idControlEntradaSalidaEstMP0\"]");
    public SelenideElement pest2M21 = $x("//*[@id=\"idPolMecanismosNoVehiculos0\"]");

    public SelenideElement pest2Check1 = $x("//*[@id=\"idBlnControlInExtLlavesNo0\"]");

    public SelenideElement pest2M22 = $x("//*[@id=\"idDesProcIlumincacion0\"]");
    public SelenideElement pest2M23 = $x("//*[@id=\"idAreasIlumindas0\"]");

    public SelenideElement pest2Check2 = $x("//*[@id=\"idBlnPlantaPoderAuxNo0\"]");

    public SelenideElement pest2M24 = $x("//*[@id=\"idSumMecanismoEnContingencia0\"]");
    public SelenideElement pest2M25 = $x("//*[@id=\"idIluminacionApropiada0\"]");
    public SelenideElement pest2M26 = $x("//*[@id=\"idDescProcAparatosComunicacion0\"]");
    public SelenideElement pest2M27 = $x("//*[@id=\"idCtaPersaparatos0\"]");
    public SelenideElement pest2M28 = $x("//*[@id=\"idAparatosComunicacionMen0\"]");
    public SelenideElement pest2M29 = $x("//*[@id=\"idDescMantenimientoAparato0\"]");
    public SelenideElement pest2M30 = $x("//*[@id=\"idPoliticasComunicacion0\"]");
    public SelenideElement pest2M31 = $x("//*[@id=\"idProgramaMantenimentoCom0\"]");
    public SelenideElement pest2M32 = $x("//*[@id=\"idCuentaAparatosResp0\"]");

    public SelenideElement pest2Check3 = $x("//*[@id=\"idBlnProcOperaCctvNo0\"]");
    public SelenideElement pest2Check4 = $x("//*[@id=\"idBlnSensoresPtaVentNo0\"]");

    public SelenideElement pest2M33 = $x("//*[@id=\"idProActivarAlarma0\"]");
    public SelenideElement pest2M34 = $x("//*[@id=\"idDesProcMantenimientoCom0\"]");
    public SelenideElement pest2M35 = $x("//*[@id=\"idDondeInspeccionSub0\"]");
    public SelenideElement pest2M36 = $x("//*[@id=\"idNumcamarasCctv0\"]");
    public SelenideElement pest2M37 = $x("//*[@id=\"idRegistroInspec0\"]");
    public SelenideElement pest2M38 = $x("//*[@id=\"idUbicacionCctv0\"]");
    public SelenideElement pest2M39 = $x("//*[@id=\"idHorariosOperacion0\"]");
    public SelenideElement pest2M40 = $x("//*[@id=\"idRevisionPeriodicaGraba0\"]");
    public SelenideElement pest2M41 = $x("//*[@id=\"idPersonalDesignadoRev0\"]");
    public SelenideElement pest2M42 = $x("//*[@id=\"idDocumentanResultadosRevAud0\"]");
    public SelenideElement pest2M43 = $x("//*[@id=\"idTiempoGrabaciones0\"]");

    public SelenideElement pest2Check5 = $x("//*[@id=\"idSistemaCctvRespaldadoNo0\"]");

    public SelenideElement pest2M44 = $x("//*[@id=\"idNoPlantaElect0\"]");
    public SelenideElement pest2M45 = $x("//*[@id=\"idSistFunciAlarma0\"]");
    public SelenideElement pest2M46 = $x("//*[@id=\"idAdiSistAlarmaTecno0\"]");
    public SelenideElement pest2M47 = $x("//*[@id=\"idDescProcedimientoImpProbarInspeccionar0\"]");

    public SelenideElement pest2Check6 = $x("//*[@id=\"idBlnProvConAccesoCamNo0\"]");

    public SelenideElement pest2M48 = $x("//*[@id=\"idFormaControlanAccesosResp0\"]");

    public SelenideElement pest3 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[6]/form/div[1]/table/tbody/tr[12]/td/div/div[3]/a");
    public SelenideElement pest3M1 = $x("//*[@id=\"idDesProcPersonalSeg0\"]");
    public SelenideElement pest3M2 = $x("//*[@id=\"idNumPersonalSeg0\"]");
    public SelenideElement pest3M3 = $x("//*[@id=\"idCargosFunPersonalOp0\"]");
    public SelenideElement pest3M4 = $x("//*[@id=\"idContratoServicioExt0\"]");
    public SelenideElement pest3M5 = $x("//*[@id=\"idDesPersonalArmado0\"]");
    public SelenideElement pest3M6 = $x("//*[@id=\"idDesProcIdentificacionEmpl0\"]");
    public SelenideElement pest3M7 = $x("//*[@id=\"idMecanismosIdentificacion0\"]");
    public SelenideElement pest3M8 = $x("//*[@id=\"idUniformePersonalSC0\"]");
    public SelenideElement pest3M9 = $x("//*[@id=\"idIdentificarPersonalSC0\"]");
    public SelenideElement pest3M10 = $x("//*[@id=\"idDesEmpresaCambiaIden0\"]");
    public SelenideElement pest3M11 = $x("//*[@id=\"idDesAccesoAreasRest0\"]");
    public SelenideElement pest3M12 = $x("//*[@id=\"idIdentificarPersonalExtSC0\"]");
    public SelenideElement pest3M13 = $x("//*[@id=\"idRegistroBitacora0\"]");

    public SelenideElement pest3Check1 = $x("//*[@id=\"idBlnNombreVisitanteNo0\"]");

    public SelenideElement pest3M14 = $x("//*[@id=\"idPersonaRespVisitantes0\"]");
    public SelenideElement pest3M15 = $x("//*[@id=\"idDesMensajeriaPaqueteria0\"]");
    public SelenideElement pest3M16 = $x("//*[@id=\"idRespAccesoExternoAreas0\"]");
    public SelenideElement pest3M17 = $x("//*[@id=\"idProveedorServicioId0\"]");
    public SelenideElement pest3M18 = $x("//*[@id=\"idFormaRevisaPaq0\"]");
    public SelenideElement pest3M19 = $x("//*[@id=\"idProcAdiAcceso0\"]");
    public SelenideElement pest3M20 = $x("//*[@id=\"idAccionDetPaqSospechoso0\"]");

    public SelenideElement pest4 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[4]/a");
    public SelenideElement pest4M1 = $x("//*[@id=\"idDescRegistroSc0\"]");
    public SelenideElement pest4M2 = $x("//*[@id=\"idAcuerdoContSeg0\"]");
    public SelenideElement pest4M3 = $x("//*[@id=\"idDescCuentaInformacionDocSeg0\"]");
    public SelenideElement pest4M4 = $x("//*[@id=\"idFormaDocRequeScSegu0\"]");
    public SelenideElement pest4M5 = $x("//*[@id=\"idProgramaCalendarioSeg0\"]");
    public SelenideElement pest4M6 = $x("//*[@id=\"idDescSociedadesCumplenSegu0\"]");
    public SelenideElement pest4M7 = $x("//*[@id=\"idFormatoVerificacion0\"]");
    public SelenideElement pest4M8 = $x("//*[@id=\"idPeriocidadVisSc0\"]");
    public SelenideElement pest4M9 = $x("//*[@id=\"idsCProgramaSeguridad0\"]");
    public SelenideElement pest4M10 = $x("//*[@id=\"idRegistroVerificacion0\"]");
    public SelenideElement pest4M11 = $x("//*[@id=\"idDescProcedimientoIdentiSC0\"]");
    public SelenideElement pest4M12 = $x("//*[@id=\"idMedidasAccionScNoCumple0\"]");
    public SelenideElement pest4Check1 = $x("//*[@id=\"idBlnScCertCtpatNo0\"]");

    public SelenideElement pest5 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[6]/form/div[1]/table/tbody/tr[12]/td/div/div[5]/a");
    public SelenideElement pest5M1 = $x("//*[@id=\"idAlmacenesDistrito0\"]");
    public SelenideElement pest5M2 = $x("//*[@id=\"idExplicarActividad0\"]");

    public SelenideElement pest5Check1 = $x("//*[@id=\"idBlnCentrosPertEmprNo0\"]");

    public SelenideElement pest5M3 = $x("//*[@id=\"idDesCumpleReqMinSeg0\"]");
    public SelenideElement pest5M4 = $x("//*[@id=\"idExplicarActividad0\"]");
    public SelenideElement pest5M5 = $x("//*[@id=\"idDescProcedimientoEntregaRecepcionMerc0\"]");
    public SelenideElement pest5M6 = $x("//*[@id=\"idAreaRespSuperEmbarque0\"]");
    public SelenideElement pest5M7 = $x("//*[@id=\"idMecanismosSuperIntegridad0\"]");
    public SelenideElement pest5M8 = $x("//*[@id=\"idDesProcesamiento0\"]");
    public SelenideElement pest5M9 = $x("//*[@id=\"idDetalleTransInfo0\"]");
    public SelenideElement pest5M10 = $x("//*[@id=\"idUtilizaSisInformatico0\"]");
    public SelenideElement pest5M11 = $x("//*[@id=\"idDetalleValInfo0\"]");
    public SelenideElement pest5M12 = $x("//*[@id=\"idDesAseguraOperCarga0\"]");
    public SelenideElement pest5M13 = $x("//*[@id=\"idFormaAsocTranInfo0\"]");

    public SelenideElement pest6 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[6]/form/div[1]/table/tbody/tr[12]/td/div/div[6]/a");
    public SelenideElement pest6M1 = $x("//*[@id=\"idDesProcSelecAa0\"]");
    public SelenideElement pest6M2 = $x("//*[@id=\"idCriteriosSeleccion0\"]");
    public SelenideElement pest6M3 = $x("//*[@id=\"idMetodosEvalPer0\"]");
    public SelenideElement pest6M4 = $x("//*[@id=\"idIndicadoresEvaluaAA0\"]");
    public SelenideElement pest6M5 = $x("//*[@id=\"idNomNumPatente0\"]");


    public SelenideElement pest7 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[7]/a");
    public SelenideElement pest7M1 = $x("//*[@id=\"idEnlistMedTrans0\"]");
    public SelenideElement pest7M2 = $x("//*[@id=\"idLugarReparacionTransporte0\"]");
    public SelenideElement pest7Check1 = $x("//*[@id=\"idBlnAlmacenaInteriorNo0\"]");
    public SelenideElement pest7Check2 = $x("//*[@id=\"idBlnEmpAlmacenaContNo0\"]");
    public SelenideElement pest7M3 = $x("//*[@id=\"idVehiculosCargaContRemolTraficoInt0\"]");
    public SelenideElement pest7M4 = $x("//*[@id=\"idTipoCandadoSellos0\"]");
    public SelenideElement pest7M5 = $x("//*[@id=\"idUtilizarAlgunContedor0\"]");

    public SelenideElement pest8 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[8]/a");
    public SelenideElement pest8M1 = $x("//*[@id=\"idProcDocContratacionPer0\"]");
    public SelenideElement pest8M2 = $x("//*[@id=\"idReqDocExigida0\"]");
    public SelenideElement pest8M3 = $x("//*[@id=\"idPruebasExamSol0\"]");
    public SelenideElement pest8M4 = $x("//*[@id=\"idAreasCriticas0\"]");
    public SelenideElement pest8M5 = $x("//*[@id=\"idReqAdicionales0\"]");
    public SelenideElement pest8M6 = $x("//*[@id=\"idCandidatoFirmaDoc0\"]");
    public SelenideElement pest8Check1 = $x("//*[@id=\"idBlnServAdicNo0\"]");
    public SelenideElement pest8M7 = $x("//*[@id=\"idCuentaProcDocContMP0\"]");
    public SelenideElement pest8M8 = $x("//*[@id=\"idRespProcBajaPersona0\"]");
    public SelenideElement pest8M9 = $x("//*[@id=\"idDesProcContPers0\"]");
    public SelenideElement pest8M10 = $x("//*[@id=\"idEntregaIdentif0\"]");
    public SelenideElement pest8M11 = $x("//*[@id=\"idCuentaRegBaja0\"]");
    public SelenideElement pest8M12 = $x("//*[@id=\"idMantieneRegBaja0\"]");
    public SelenideElement pest8Check2 = $x("//*[@id=\"idBlnEmpBdNo0\"]");

    public SelenideElement pest9 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[9]/a");
    public SelenideElement pest9M1 = $x("//*[@id=\"idDesProcArchivar0\"]");
    public SelenideElement pest9M2 = $x("//*[@id=\"idMedidasSegInfo0\"]");
    public SelenideElement pest9M3 = $x("//*[@id=\"idPoliticasProcSegCiber0\"]");
    public SelenideElement pest9M4 = $x("//*[@id=\"idAccesoSociosSisInformaticos0\"]");
    public SelenideElement pest9M5 = $x("//*[@id=\"idDescSisRespaldoElecComputo0\"]");
    public SelenideElement pest9M6 = $x("//*[@id=\"idFrecuenciaCopias0\"]");
    public SelenideElement pest9M7 = $x("//*[@id=\"idProcRespaldoInformacion0\"]");
    public SelenideElement pest9M8 = $x("//*[@id=\"idProcRespaldoParqueInd0\"]");
    public SelenideElement pest9M9 = $x("//*[@id=\"idProcProteccionInfParqueInd0\"]");
    public SelenideElement pest9M10 = $x("//*[@id=\"idDispositivoPersonal0\"]");
    public SelenideElement pest9M11 = $x("//*[@id=\"idMedidaIncidente0\"]");
    public SelenideElement pest9M12 = $x("//*[@id=\"idSistemasProtegidos0\"]");
    public SelenideElement pest9M13 = $x("//*[@id=\"idSistemasMultiples0\"]");
    public SelenideElement pest9M14 = $x("//*[@id=\"idResponsableProtecSist0\"]");
    public SelenideElement pest9M15 = $x("//*[@id=\"idDesProcProteccion0\"]");
    public SelenideElement pest9M16 = $x("//*[@id=\"idSistemasProtegidos0\"]");
    public SelenideElement pest9M17 = $x("//*[@id=\"idMecanismosSistemas0\"]");
    public SelenideElement pest9M18 = $x("//*[@id=\"idPruebasRecuperacionDatos0\"]");
    public SelenideElement pest9M19 = $x("//*[@id=\"idCopiaSeguridadInstalaciones0\"]");
    public SelenideElement pest9M20 = $x("//*[@id=\"idFrecuenciaLocalizacionCopiaSeguridad0\"]");
    public SelenideElement pest9M21 = $x("//*[@id=\"idPlanContinuidadNegocioIncidente0\"]");

    public SelenideElement pest10 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[10]/a");
    public SelenideElement pest10M1 = $x("//*[@id=\"idDescPrograma0\"]");
    public SelenideElement pest10M2 = $x("//*[@id=\"idTemasPrograma0\"]");
    public SelenideElement pest10M3 = $x("//*[@id=\"idMomentoImparte0\"]");
    public SelenideElement pest10M4 = $x("//*[@id=\"idPeriodicidadCapac0\"]");
    public SelenideElement pest10M5 = $x("//*[@id=\"idFormaDocCapac0\"]");
    public SelenideElement pest10M6 = $x("//*[@id=\"idFomentaParticipacion0\"]");
    public SelenideElement pest10M7 = $x("//*[@id=\"idProgramaCapacitacion0\"]");
    public SelenideElement pest10M8 = $x("//*[@id=\"idCaboDifusion0\"]");
    public SelenideElement pest10M9 = $x("//*[@id=\"idTemasCubren0\"]");
    public SelenideElement pest10M10 = $x("//*[@id=\"idServScPolSeg0\"]");
    public SelenideElement pest10M11 = $x("//*[@id=\"idFormaDocumPartic0\"]");

    public SelenideElement pest11 = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[12]/td/div/div[11]/a");
    public SelenideElement pest11M1 = $x("//*[@id=\"idDesProcAnomalias0\"]");
    public SelenideElement pest11M2 = $x("//*[@id=\"idResponsableReporta0\"]");
    public SelenideElement pest11M3 = $x("//*[@id=\"idDetalleComAuto0\"]");
    public SelenideElement pest11M4 = $x("//*[@id=\"idLlevaRegReporte0\"]");
    public SelenideElement pest11M5 = $x("//*[@id=\"idDesRegReportActividades0\"]");
    public SelenideElement pest11M6 = $x("//*[@id=\"idResponsableInv0\"]");
    public SelenideElement pest11M7 = $x("//*[@id=\"idDoctoExpediente0\"]");

    public SelenideElement btnContiReq = $x("//*[@id=\"guardarSolicitud\"]");

    ///Carga document
    public SelenideElement btnSig = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement btnAdjunt = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[3]/tbody/tr[54]/td[2]/input");
    public SelenideElement doc1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc6 = $x("//*[@id=\"solicitud_5\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc7 = $x("//*[@id=\"solicitud_6\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc8 = $x("//*[@id=\"solicitud_7\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc9 = $x("//*[@id=\"solicitud_8\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc10 = $x("//*[@id=\"solicitud_9\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc11 = $x("//*[@id=\"solicitud_10\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc12 = $x("//*[@id=\"solicitud_11\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc13 = $x("//*[@id=\"solicitud_12\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc14 = $x("//*[@id=\"solicitud_13\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc15 = $x("//*[@id=\"solicitud_14\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc16 = $x("//*[@id=\"solicitud_15\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc17 = $x("//*[@id=\"solicitud_16\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc18 = $x("//*[@id=\"solicitud_17\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc19 = $x("//*[@id=\"solicitud_18\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc20 = $x("//*[@id=\"solicitud_19\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc21 = $x("//*[@id=\"solicitud_20\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc22 = $x("//*[@id=\"solicitud_21\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc23 = $x("//*[@id=\"solicitud_22\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc24 = $x("//*[@id=\"solicitud_23\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc25 = $x("//*[@id=\"solicitud_24\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc26 = $x("//*[@id=\"solicitud_25\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc27 = $x("//*[@id=\"solicitud_26\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc28 = $x("//*[@id=\"solicitud_27\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc29 = $x("//*[@id=\"solicitud_28\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc30 = $x("//*[@id=\"solicitud_29\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc31 = $x("//*[@id=\"solicitud_30\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc32 = $x("//*[@id=\"solicitud_31\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc33 = $x("//*[@id=\"solicitud_32\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc34 = $x("//*[@id=\"solicitud_33\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc35 = $x("//*[@id=\"solicitud_34\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc36 = $x("//*[@id=\"solicitud_35\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc37 = $x("//*[@id=\"solicitud_36\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc38 = $x("//*[@id=\"solicitud_37\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc39 = $x("//*[@id=\"solicitud_38\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc40 = $x("//*[@id=\"solicitud_39\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc41 = $x("//*[@id=\"solicitud_40\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc42 = $x("//*[@id=\"solicitud_41\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc43 = $x("//*[@id=\"solicitud_42\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc44 = $x("//*[@id=\"solicitud_43\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc45 = $x("//*[@id=\"solicitud_44\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc46 = $x("//*[@id=\"solicitud_45\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc47 = $x("//*[@id=\"solicitud_46\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc48 = $x("//*[@id=\"solicitud_47\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc49 = $x("//*[@id=\"solicitud_48\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc50 = $x("//*[@id=\"solicitud_49\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc51 = $x("//*[@id=\"solicitud_50\"]/table/tbody/tr[1]/td[4]/input");

    public SelenideElement btnCargarDigi = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrarDigi = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContiFirm = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[3]");
}
