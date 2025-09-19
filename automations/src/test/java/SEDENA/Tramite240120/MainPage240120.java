package SEDENA.Tramite240120;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage240120 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement SEDENA = $x("//*[@id=\"workingArea\"]/form/a[5]/img");
    public SelenideElement linkCerLicPer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkPermisoAduanalSEDENA = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement linkPermisoExtExpArtPir = $x("//a[contains(text(),'Permiso extraordinario para la exportación de artificios pirotécnicos')]");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputOrigenLista = $x("//*[@id=\"origenlistaOrigen1\"]");
    public SelenideElement inputAddOrigenLista = $x("//*[@id=\"addlistaOrigen1\"]");
    public SelenideElement inputUsoFinalMercancia = $x("//*[@id=\"solicitud.mercancia.usoFinal\"]");
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");
    public SelenideElement inputDescripcionMercancia = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement inputFraccionArancelariaMercancia = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]");
    public SelenideElement inputCantidadUMTMercancia = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement inputValorComercialMercancia = $x("//*[@id=\"idImporteFacturaUSD\"]");
    public SelenideElement selectUMCMercancia = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement inputTipoMonedaMercancia = $x("//*[@id=\"mercanciaGrid.tipoMoneda\"]");
    public SelenideElement inputPaisOrigenMercancia = $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement btnAgregarPaisSeleccion = $x("/html/body/main/div/div[4]/div[2]/form/div[7]/div/div/div/div[2]/div/div/input[2]");
    public SelenideElement btnAgregarMercancia2 = $x("//*[@id=\"btnAgregarMercancia\"]");
    //TERCEROS RELACIONADOS
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement btnAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement inputNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement inputExtranjera = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement inputFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTercerosNombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTercerosDenominacion = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputTercerosEstado = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement inputTercerosEstado2 = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement inputTercerosMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement inputTercerosLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement inputTercerosCP = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement inputTercerosCP2 = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement inputTercerosColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement inputTercerosNumeroExt = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement inputTercerosNumeroInt = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputTercerosLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement inputCadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

    //INICIO
    public SelenideElement Inicio = $x("//a[contains(text(),'Inicio')]");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    public SelenideElement AntecendentesTextoDictamen = $x("//*[@id='textoDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");


    //OBSERVAR REQUERIMIENTO
    public SelenideElement JustificacionObservacionReq = $x("//*[@id=\"requerimientoSolicitud\"]/table/tbody/tr[5]/td/textarea");

    //ATENDER/MODIFICAR REQUERIMIENTO
    public SelenideElement tabCapRequerimiento = $x("//*[@id=\"tabs\"]/ul/li[1]/a/label");
    public SelenideElement justificaRequerimiento  = $x("//*[@id=\"justId\"]");
    public SelenideElement selecDocumentos = $x("//*[@id=\"alcanceRequerimientoId\"]");
    public SelenideElement tabSeleccionarDocumentos = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    public SelenideElement selectVerificacionDictamenDoc = $x("//a[text()='Dictamen de Verificación o Inspección']");
    public SelenideElement btnAgregarNuevoDocumento = $x("//*[@id=\"addDoctoEspecificoId\"]");
    public SelenideElement gridDocumento1 = $x("//td[text()='Dictamen de Verificación o inspección']/parent::tr//input[@type='checkbox']");
    public SelenideElement btnContinuar1Requerimiento = $x("//*[@id=\"mostrarFirmaId\"]");


    //Dictamen
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    //public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("//*[@id=\"1\"]/td[1]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement sentidoAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement CedulaInscripcion = $x("/html/body/div[1]/div[3]/div[3]/div/form/fieldset/table[3]/tbody/tr[4]/td[1]/input");
    public SelenideElement antecedentesDict = $x("//*[@id=\"valueTA\"]");
    public SelenideElement fechaVigencia = $x("//*[@id=\"fechaVigencia\"]");
    public SelenideElement fechaFinVigencia = $x("//*[@id=\"dFechaFinVigencia\"]");

    //OBSERVAR DICTAMEN
    public SelenideElement JustificacionObservacionDictamen = $x("//*[@id=\"observacionId\"]");
    public SelenideElement btnGenerarObservacionDictamen = $x("//*[@id=\"acciones\"]/input[2]");

    //Confirmación
    public SelenideElement linkInicio = $x("//*[@id=\"bandejaSol\"]");//*[@id="Inicio"]
    public SelenideElement inputNumFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioTarea= $x("//*[@id=\"buscarTareasSolicitante\"]");
    public SelenideElement gridFolio = $x("//*[@id=\"0\"]/td[1]");
    public SelenideElement btnFirmarNotificacion = $x("//*[@id=\"acuse\"]");
}