package HACIENDA.Tramite33302;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage33302 {

    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    /// Avisos
    public SelenideElement btnModificar = $x("//*[@id=\"avisoModificacionOEAAgaceButton\"]");
    public SelenideElement tipoAvisos = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement avisoUsoGoce = $x("//*[@id=\"aviso_6\"]");
    public SelenideElement avisoFusionEscision = $x("//*[@id=\"aviso_8\"]");
    public SelenideElement avisoObservaciones = $x("//*[@id=\"aviso_10\"]");
    public SelenideElement avisoSeguridad = $x("//*[@id=\"aviso_11\"]");
    public SelenideElement avisoCircunstancias = $x("//*[@id=\"aviso_12\"]");
    public SelenideElement avisoAdicionRevocacion = $x("//*[@id=\"aviso_13\"]");
    public SelenideElement avisoSeciit = $x("//*[@id=\"aviso_14\"]");
    public SelenideElement avisoAltaTercerizacion = $x("//*[@id=\"aviso_15\"]");
    public SelenideElement avisoBajaTercerizacion = $x("//*[@id=\"aviso_16\"]");
    public SelenideElement avisoPago = $x("//*[@id=\"aviso_20\"]");
    public SelenideElement manifiestoAvisos = $x("//*[@id=\"acepto253\"]");
    /// Uso y Goce
    public SelenideElement usoGoce = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[6]/a/label");
    public SelenideElement domicilio = $x("//*[@id=\"direccionInmuebleC\"]");
    public SelenideElement codigoPostal = $x("//*[@id=\"codigoPostalInmuebleC\"]");
    public SelenideElement entidadFederativa = $x("//*[@id=\"solicitud.avisoConsulta.entidadFederativa\"]");
    public SelenideElement municipio = $x("//*[@id=\"solicitud.avisoConsulta.municipio\"]");
    public SelenideElement documentoUsoGoce = $x("//*[@id=\"solicitud.avisoConsulta.doctoAcredita\"]");
    public SelenideElement fechaInicioUsoGoce = $x("//*[@id=\"fechaInicialActualCon\"]");
    public SelenideElement selecFecha = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFin = $x("//*[@id=\"fechaFinalActualCon\"]");
    public SelenideElement selecFechaFin = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a");
    public SelenideElement rfcPartes = $x("//*[@id=\"rfcPartesC\"]");
    public SelenideElement buscarRfcPartes = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement caracterDePartes = $x("//*[@id=\"caracterDeCons\"]");
    public SelenideElement btnAgregarPartes = $x("//*[@id=\"btnAgregarParteC\"]");
    public SelenideElement observacionesPartes = $x("//*[@id=\"observacionesC\"]");
    public SelenideElement mismoDomicilio = $x("//*[@id=\"no3093\"]");
    public SelenideElement domicilioNuevo = $x("//*[@id=\"direccionInmuebleM\"]");
    public SelenideElement codigoPostalNuevo = $x("//*[@id=\"codigoPostalInmuebleM\"]");
    public SelenideElement estadoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.entidadFederativa\"]");
    public SelenideElement municipioNuevo = $x("//*[@id=\"solicitud.avisoModificacion.municipio\"]");
    public SelenideElement documentoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.doctoAcredita\"]");
    public SelenideElement fechaInicioNueva = $x("//*[@id=\"fechaInicialActualMod\"]");
    public SelenideElement selecFechaNuevo = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFinNuevo = $x("//*[@id=\"fechaFinalActualMod\"]");
    public SelenideElement selecFechaFinNuevo = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[3]/a");
    public SelenideElement rfcPartesNuevo = $x("//*[@id=\"rfcPartesM\"]");
    public SelenideElement buscarRfcPartesNuevo = $x("/html/body/main/div/div[4]/div/form/div[2]/div[6]/div[35]/div[2]/input");
    public SelenideElement caracterDePartesNuevas = $x("//*[@id=\"caracterDePartesMod\"]");
    public SelenideElement btnAgregarPartesNuevo = $x("//*[@id=\"btnAgregarParte\"]");
    public SelenideElement observacionesPartesNuevo = $x("//*[@id=\"observacionesM\"]");
    /// Fusion o Escision
    public SelenideElement fusionEscision = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[7]/a");
    public SelenideElement fusion1 = $x("//*[@id=\"fusion1\"]");
    public SelenideElement fusionEmpresa = $x("//*[@id=\"idFusion\"]");
    public SelenideElement certificacionSi = $x("//*[@id=\"idSiCertificacion\"]");
    public SelenideElement rfcFusion = $x("//*[@id=\"idRfcBusqueda\"]");
    public SelenideElement busquedaRfcFusion = $x("//*[@id=\"btnAceptarDomicilios\"]");
    public SelenideElement fechaFusion = $x("//*[@id=\"fechaFusion\"]");
    public SelenideElement selecFechaFusion = $x("/html/body/div[3]/table/tbody/tr[2]/td[1]/a");
    public SelenideElement folioFusion = $x("//*[@id=\"idFolioFusion\"]");
    public SelenideElement agregarEmpresaFusionada = $x("//*[@id=\"btnAgregarPersona\"]");
    public SelenideElement certificacionFusionSi = $x("//*[@id=\"idSiCertificacionModal\"]");
    public SelenideElement rfcFusionada = $x("//*[@id=\"idRfcBusquedaModal\"]");
    public SelenideElement buscarRfcFusionada = $x("//*[@id=\"btnAceptarModal\"]");
    public SelenideElement btnAgregarFusionada = $x("//*[@id=\"btnAceptarFusionEscision\"]");
    /// Observaciones
    public SelenideElement observaciones = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[9]/a");
    public SelenideElement agregarObservaciones = $x("//*[@id=\"btnAgregarObservaciones\"]");
    public SelenideElement entidadObservaciones = $x("//*[@id=\"entidadFederativaOb\"]");
    public SelenideElement selecDomicilioObservacion = $x("//*[@id=\"5\"]/td[8]");
    public SelenideElement aceptarDomicilioObservacion = $x("//*[@id=\"btnAceptarModalObservacion\"]");
    public SelenideElement selecDomicilioModificarOb = $x("/html/body/main/div/div[4]/div/form/div[2]/div[9]/div[4]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[8]");
    public SelenideElement modificarDomicilioOb = $x("//*[@id=\"btnModificarObservaciones\"]");
    public SelenideElement tipoDomicilio = $x("//*[@id=\"domicilio.tipoInstalacionOB\"]");
    public SelenideElement numActaVisita = $x("//*[@id=\"domicilio.numActaVisita\"]");
    public SelenideElement fechaVisita = $x("/html/body/main/div/div[4]/div[2]/form/div[2]/div[3]/div/input");
    public SelenideElement selecFechaVisita = $x("/html/body/div[3]/table/tbody/tr[2]/td[4]/a");
    public SelenideElement subestandaresVisita = $x("//*[@id=\"idEstandaresObservacion\"]");
    public SelenideElement btnAceptarObservaciones = $x("/html/body/main/div/div[4]/div[2]/form/div[19]/div/div/input[1]");
    /// Seguridad
    public SelenideElement seguridad = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[10]/a");
    public SelenideElement agregarDomiciliosIncidencias = $x("/html/body/main/div/div[4]/div/form/div[2]/div[10]/div[5]/div/div/input[1]");
    public SelenideElement entidadFederativaIncidencias = $x("//*[@id=\"entidadFederativaIDCIS\"]");
    public SelenideElement selecPlantaAgregar = $x("/html/body/main/div/div[4]/div[2]/form/div[1]/div[3]/div/div/div/div[3]/div[3]/div/table/tbody/tr[4]/td[9]");
    public SelenideElement btnAgregarDomicilio = $x("/html/body/main/div/div[4]/div[2]/form/div[1]/div[4]/div/div/input[2]");
    public SelenideElement selecPlantaModificarIncidencias = $x("/html/body/main/div/div[4]/div/form/div[2]/div[10]/div[4]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[8]");
    public SelenideElement modificarPlantaIncidencias = $x("/html/body/main/div/div[4]/div/form/div[2]/div[10]/div[5]/div/div/input[3]");
    public SelenideElement tipoInstalacionIncidencias = $x("//*[@id=\"domicilio.tipoInstalacionIS\"]");
    public SelenideElement cambiosSubestandares = $x("//*[@id=\"idObservacionesPPIS\"]");
    public SelenideElement btnAceptarModificacionIncidencis = $x("/html/body/main/div/div[4]/div[2]/form/div[13]/div/div/input[1]");
    /// Circunstancias
    public SelenideElement circunstancias = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[11]/a");
    public SelenideElement agregarDomiciliosCircunstancias = $x("/html/body/main/div/div[4]/div/form/div[2]/div[11]/div[5]/div/div/input[1]");
    public SelenideElement entidadFederativaCircunstancias = $x("//*[@id=\"entidadFederativaIDCFD\"]");
    public SelenideElement selecPlantaAgregarCircunstancias = $x("/html/body/main/div/div[4]/div[2]/form/div[1]/div[3]/div/div/div/div[3]/div[3]/div/table/tbody/tr[4]/td[9]");
    public SelenideElement btnAgregarPlantaCircunstancias = $x("/html/body/main/div/div[4]/div[2]/form/div[1]/div[4]/div/div/input[2]");
    public SelenideElement selecPlantaModificar = $x("/html/body/main/div/div[4]/div/form/div[2]/div[11]/div[4]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[8]");
    public SelenideElement modificarPlantaCircunstancias = $x("/html/body/main/div/div[4]/div/form/div[2]/div[11]/div[5]/div/div/input[3]");
    public SelenideElement tipoPlantaCircunstancias = $x("//*[@id=\"domicilio.tipoInstalacionFD\"]");
    public SelenideElement folioAltaInstalacion = $x("//*[@id=\"idFolioAlta\"]");
    public SelenideElement fechaCircunstancias = $x("//*[@id=\"idFechaAviso\"]");
    public SelenideElement selecFechaCircunstancias = $x("/html/body/div[3]/table/tbody/tr[2]/td[3]/a");
    public SelenideElement cambioEstandaresCircunstancias = $x("//*[@id=\"idObservacionesPPFD\"]");
    public SelenideElement btnAceptarModificacionCircunstancias = $x("/html/body/main/div/div[4]/div[2]/form/div[13]/div/div/input[1]");
    /// Adicion o Revocacion
    public SelenideElement adicionRevocacion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[12]/a");
    public SelenideElement selecTransportistaModificar = $x("/html/body/main/div/div[4]/div/form/div[2]/div[12]/div[4]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement modificarTransportista = $x("//*[@id=\"modificarTransportista\"]");
    public SelenideElement estatusTransportista = $x("//*[@id=\"estatusTransportistas\"]");
    public SelenideElement btnModificarTransportista = $x("//*[@id=\"btnGuardarModificarTransportista\"]");
    public SelenideElement agregarTransportista = $x("//*[@id=\"agregarTransportista\"]");
    public SelenideElement rfcNuevoTransportista = $x("//*[@id=\"trRfc\"]");
    public SelenideElement btnBuscarRfcTransportista = $x("//*[@id=\"btnBuscarEmpresa\"]");
    public SelenideElement btnAgregarTransportista = $x("//*[@id=\"btnGuardarTransportista\"]");
    /// SECIIT
    public SelenideElement seciit = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[13]/a");
    public SelenideElement modifFusionEscisionSeciit = $x("//*[@id=\"checkModifFusExc\"]");
    public SelenideElement modifSistemaControl = $x("//*[@id=\"checkCambSistContr\"]");
    public SelenideElement modifProvedores = $x("//*[@id=\"checkCambProv\"]");
    public SelenideElement modifSistemaPropios = $x("//*[@id=\"checkActuaSistPropEmpr\"]");
    public SelenideElement modifOtro = $x("//*[@id=\"checkSistCorpSeciitOtro\"]");
    public SelenideElement descripcionOtros = $x("//*[@id=\"txtSistCorpSeciitOtro\"]");
    /// Alta Tercerizacion
    public SelenideElement altaTercerizacion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[14]/a");
    public SelenideElement agregarTerceroAlta = $x("//*[@id=\"agregarAltaTercerizacion\"]");
    public SelenideElement rfcTerceroAlta = $x("//*[@id=\"trRfcAlta\"]");
    public SelenideElement btnBuscarRfcTerceroAlta = $x("//*[@id=\"btnBuscarAltaTer\"]");
    public SelenideElement tipoRegistroTerceroAlta = $x("//*[@id=\"trTipoRegistro\"]");
    public SelenideElement btnGuardarTerceroAlta = $x("//*[@id=\"btnGuardarAltaTercerizacion\"]");
    /// Baja Tercerizacion
    public SelenideElement bajaTercerizacion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[15]/a");
    public SelenideElement agregarTerceroBaja = $x("//*[@id=\"agregarBajaTercerizacion\"]");
    public SelenideElement rfcTerceroBaja = $x("//*[@id=\"trRfcBaja\"]");
    public SelenideElement btnBuscarRfcTerceroBaja = $x("//*[@id=\"btnBuscarBajaTer\"]");
    public SelenideElement tipoRegistroTerceroBaja = $x("//*[@id=\"trTipoRegistroBaja\"]");
    public SelenideElement btnGuardarTerceroBaja = $x("//*[@id=\"btnGuardarBajaTercerizacion\"]");
    /// Pago Derechos
    public SelenideElement pagoDerechos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[16]/a");
    public SelenideElement numOperacion = $x("//*[@id=\"solicitud.pagoSCC.referenciaBancaria\"]");
    public SelenideElement bancoPago = $x("/html/body/main/div/div[4]/div/form/div[2]/div[16]/div[1]/div[3]/div[2]/select");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pagoSCC.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    /// Un solo documento
    public SelenideElement btnAdjuntar1Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivoUnico = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    /// Dos Documentos
    /// Tres Documentos
    public SelenideElement btnAdjuntar3Doc = $x("/html/body/main/div/div[4]/div[1]/form[1]/table/tbody/tr[6]/td[2]/div/input[2]");
    public SelenideElement archivo31 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo32 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo33 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    /// Cuatro Documentos
    public SelenideElement btnAdjuntar4Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement archivo41 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo42 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo43 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo44 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    /// Cinco Documentos
    public SelenideElement btnAdjuntar5Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement archivo51 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo52 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo53 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo54 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo55 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    /// Seis Documentos
    public SelenideElement btnAdjuntar6Doc = $x("/html/body/main/div/div[4]/div[1]/form[1]/table/tbody/tr[9]/td[2]/div/input[2]");
    public SelenideElement archivo61 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo62 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo63 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo64 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo65 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo66 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    /// Pasos siguientes
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnAdjuntar2Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement segArchivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement segArchivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");



}
