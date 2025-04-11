package HACIENDA.Tramite33303;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage33303 {
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
    public SelenideElement btnModificar = $x("//*[@id=\"avisoModificacionSCCAgaceButton\"]");
    public SelenideElement tipoAvisos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement avisoUsoGoce = $x("//*[@id=\"aviso_6\"]");
    public SelenideElement avisoFusionEscision = $x("//*[@id=\"aviso_8\"]");
    public SelenideElement avisoObservaciones = $x("//*[@id=\"aviso_10\"]");
    public SelenideElement avisoSeguridad = $x("//*[@id=\"aviso_11\"]");
    public SelenideElement avisoModificación = $x("//*[@id=\"aviso_12\"]");
    public SelenideElement avisoAdicionModificacion = $x("//*[@id=\"aviso_14\"]");
    public SelenideElement avisoAltaPagoDeDerecho = $x("//*[@id=\"aviso_15\"]");

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
    public SelenideElement rfcPartes = $x("//*[@id=\"rfcPartesC\"]");
    public SelenideElement buscarRfcPartes = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement caracterDePartes = $x("//*[@id=\"caracterDeCons\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"btnAgregarParteC\"]");
    public SelenideElement observacionesPartes = $x("//*[@id=\"observacionesC\"]");
    public SelenideElement mismoDomicilio = $x("//*[@id=\"no3093\"]");
    public SelenideElement domicilioNuevo = $x("//*[@id=\"direccionInmuebleM\"]");
    public SelenideElement codigoPostalNuevo = $x("//*[@id=\"codigoPostalInmuebleM\"]");
    public SelenideElement estadoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.entidadFederativa\"]");
    public SelenideElement municipioNuevo = $x("//*[@id=\"solicitud.avisoModificacion.municipio\"]");
    public SelenideElement documentoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.doctoAcredita\"]");
    public SelenideElement fechaInicioNueva = $x("//*[@id=\"fechaInicialActualMod\"]");
    public SelenideElement fechaFinNuevo = $x("//*[@id=\"fechaFinalActualMod\"]");
    public SelenideElement rfcPartesNuevo = $x("//*[@id=\"rfcPartesM\"]");
    public SelenideElement buscarRfcPartesNuevo = $x("/html/body/main/div/div[4]/div/form/div[2]/div[6]/div[35]/div[2]/input");
    public SelenideElement caracterDePartesNuevas = $x("//*[@id=\"caracterDePartesMod\"]");
    public SelenideElement btnAgregarNuevo = $x("//*[@id=\"btnAgregarParte\"]");
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

    /// Modificación
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

    ///Adición ó Modificación
    public SelenideElement AvisoAdiciónModificaciónMandatarios  = $x("//*[@id=\"ui-id-13\"]");
    public SelenideElement aduanaAdscrita  = $x("/html/body/main/div/div[4]/div/form/div[2]/div[13]/div/div[3]/div/div[2]/select");
    public SelenideElement aduanaSe  = $x("/html/body/main/div/div[4]/div/form/div[2]/div[13]/div/div[4]/div/div[2]/div/div/select/option[49]");
    public SelenideElement btnAgregarAduana  = $x("/html/body/main/div/div[4]/div/form/div[2]/div[13]/div/div[4]/div/div[3]/div/div[1]/input");
    public SelenideElement btnAgregarPatente  = $x("/html/body/main/div/div[4]/div/form/div[2]/div[13]/div/div[8]/div/input[1]");
    public SelenideElement rfcBusqueda  = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input[1]");
    public SelenideElement btnBuscarRFC  = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input[2]");
    public SelenideElement AduanaAds2  = $x("/html/body/main/div/div[4]/div[2]/form/div[9]/div/div/select");
    public SelenideElement tipoMov  = $x("//*[@id=\"estatusSociedadScc\"]");
    public SelenideElement btnAceptarAduana  = $x("/html/body/main/div/div[4]/div[2]/form/div[13]/div/div/input[1]");
    public SelenideElement btnok1  = $x("/html/body/div[13]/div[3]/div/button");

    public SelenideElement btnAfrefarMandatarioAgenteAduanal  = $x("/html/body/main/div/div[4]/div/form/div[2]/div[13]/div/div[11]/div/input[1]");
    public SelenideElement rfcBusqueda2  = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input[1]");
    public SelenideElement btnBuscarRFC2  = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input[2]");
    public SelenideElement tipoMov2  = $x("/html/body/main/div/div[4]/div[2]/form/div[9]/div/div/select");
    public SelenideElement btnAceptarAduana2  = $x("/html/body/main/div/div[4]/div[2]/form/div[11]/div/div/input[1]");
    public SelenideElement btnok2  = $x("/html/body/div[14]/div[3]/div/button");







    /// Alta Pago de Derecho
    public SelenideElement Noperacion = $x("//*[@id=\"solicitud.pagoSCC.referenciaBancaria\"]");
    public SelenideElement bancoDerecho = $x("//*[@id=\"solicitud.pagoSCC.banco.clave\"]");
    public SelenideElement llaveDePagoDeDerecho = $x("//*[@id=\"solicitud.pagoSCC.llaveDePago\"]");
    public SelenideElement fechaDePago = $x("//*[@id=\"calendarTo\"]");


    /// Pasos siguientes
    public SelenideElement manifiestoAcepto = $x("//*[@id=\"acepto253\"]");
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
