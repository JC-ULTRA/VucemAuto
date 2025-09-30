package COFEPRIS.Tramite261401;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage261401 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement inputIdFolio = $x("//*[@id=\"idFolio\"]");
    public SelenideElement inputBuscarButton = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement SolicitudTramite = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputSolicitarModificacion = $x("//*[@id=\"modificarButton\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement inputProrroga = $x("//*[@id=\"pro\"]");
    public SelenideElement inputModif = $x("//*[@id=\"mod\"]");
    public SelenideElement inputModificacionProrroga = $x("//*[@id=\"modPro\"]");
    public SelenideElement textareaJustificacionId = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement inputRazonSocial = $x("//*[@id=\"solicitud.establecimiento.RFCResponsableSanitario\"]");
    public SelenideElement inputDenominación = $x("//*[@id=\"solicitud.establecimiento.razonSocial\"]");
    public SelenideElement inputEmail = $x("//*[@id=\"solicitud.establecimiento.correoElectronico\"]");
    public SelenideElement inputCodigoPostal = $x("//*[@id=\"solicitud.establecimiento.domicilio.codigoPostal\"]");
    public SelenideElement inputEstado = $x("//*[@id=\"solicitud.establecimiento.domicilio.entidadFederativa.clave\"]");
    public SelenideElement inputMunicipoAlcaldia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionMunicipio\"]");
    public SelenideElement inputLocalidad = $x("//*[@id=\"solicitud.establecimiento.domicilio.informacionExtra\"]");
    public SelenideElement inputColonia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionColonia\"]");
    public SelenideElement inputCalle = $x("//*[@id=\"solicitud.establecimiento.domicilio.calle\"]");
    public SelenideElement inputLada = $x("//*[@id=\"solicitud.establecimiento.domicilio.lada\"]");
    public SelenideElement inputTelefono = $x("//*[@id=\"solicitud.establecimiento.domicilio.telefono\"]");
    public SelenideElement inputRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement inputRFCProfesionalResponsable = $x("//*[@id=\"solicitud_rfcCertificador\"]");
    public SelenideElement inputNombreResponsable = $x("//*[@id=\"solicitud_descripcionCertificador\"]");
    public SelenideElement inputAvisoFuncionamiento = $x("//*[@id=\"avisoFuncionamiento\"]");
    public SelenideElement inputLicenciaNumero = $x("//*[@id=\"numeroLicenciaSanitaria\"]//*[@id=\"numeroLicenciaSanitaria\"]");
    public SelenideElement btnAgregarSanitario = $x("//*[@id=\"cmdAgregar\"]");
    public SelenideElement inputAduana = $x("//*[@id=\"aduanasEntrada\"]");
    public SelenideElement inputAduanaSalida = $x("//*[@id=\"aduanasSalida\"]");
    public SelenideElement checkBoxMercancia = $x("//*[@id=\"jqg_gridMercanciasTram2604_3\"]");
    public SelenideElement btnModificar = $x("//*[@id=\"btnModificarAduana\"]");
    public SelenideElement selectClasificacionProducto = $x("//*[@id=\"mercanciaGrid.idClasificacionProducto\"]");
    public SelenideElement selectSubClasificacionProducto = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");
    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");
    public SelenideElement selectTipoProductoTipoTramite = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputDenominacionComunInternacional = $x("//*[@id='idDenominacionComunInternacional']");
    public SelenideElement inputEspecifique = $x("//*[@id=\"idTipoProductoDescripcionOtros\"]");
    public SelenideElement selectFormaFarmaceutica = $x("//*[@id='mercanciaGrid.idFormaFarmaceutica']");
    public SelenideElement selectEstadoFisico = $x("//*[@id='mercanciaGrid.idEstadoFisico']");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUMT = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUnidadMedidaComercial = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement textareaPresentacion = $x("//*[@id='presentacion']");
    public SelenideElement inputEnvasePrimario = $x("//*[@id=\"condicionAlmacenamientoPrimario\"]");
    public SelenideElement inputEnvaseSecundario = $x("//*[@id=\"condicionAlmacenamientoSecundario\"]");

    public SelenideElement inputNumeroRegistroSanitario = $x("//*[@id=\"registroSanitario\"]");
    public SelenideElement inputFechaCaducidad = $x("//*[@id=\"fechaDeCaducidad\"]");
    public SelenideElement buttonAbrirPanelPaisesOrigen = $x("//*[@id=\"accordion\"]/div/div[1]/button");
    public SelenideElement PaisOrigen = $x("//*[@id=\"paisesDestino\"]");
    public SelenideElement inputAgregarSeleccion = $x("//*[@id=\"panel-listaPaisesDestino\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputUsoEspecifico = $x("//*[@id=\"mercanciaGrid.clavesUsosEspecificos\"]");
    public SelenideElement inputAbrirPanelPaisesProcedencia = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[1]/button");
    public SelenideElement PaisProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inputClaveLotes = $x("//*[@id='claveLotes']");
    public SelenideElement inputFechaElaboracion = $x("//*[@id='fechaDeElaboracion']");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarMercancia\"]");
    public SelenideElement inputRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRFC = $x("//*[@id=\"consultarIDC\"]");
    public SelenideElement labelTerceros = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement checkBoxFabricante = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAB_0\"]");
    public SelenideElement btnModificarFabricante = $x("//*[@id=\"modificarTercero_TIPERS_FAB\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement btnBuscarEmpresa = $x("//*[@id=\"buscarEmpresa\"]");
    public SelenideElement inputTerceroRazonSocial = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstadoLocalidad = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement inputEstadoLocalidad = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement inputTerceroMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement inputTerceroLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement terceroCodigoPostal = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement inputCodigoPostalFabricante = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement terceroColoniaEquiv = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    public SelenideElement terceroCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputTerceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement terceroTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement checkBoxDestinatario = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    public SelenideElement checkBoxMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputCodigoPostalEquivalente = $x("//*[@id=\"terceros_selectColonia\"]");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    //public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");


    //INICIO
    public SelenideElement Inicio = $x("//a[contains(text(),'Inicio')]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
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
    public SelenideElement RestriccionesDictamen = $x("//*[@id=\"textAreaRestriccion\"]");
    public SelenideElement JustificacionVigencia = $x("//*[@id=\"justificacion\"]");
    public SelenideElement DestinoPara = $x("//*[@id=\"usoAutorizadoDictamen\"]");
    public SelenideElement SiglasDictaminador = $x("//*[@id=\"siglasDictaminador\"]");
    public SelenideElement selectAsignarAutorizador = $x("//*[@id=\"tramite.dictamen.numeroGenerico1\"]");
    public SelenideElement AntecedentesDictamen = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement antecedentesDict = $x("//*[@id=\"valueTA\"]");
    public SelenideElement fechaVigencia = $x("//*[@id=\"fechaVigencia\"]");
    public SelenideElement fechaFinVigencia = $x("//*[@id=\"fechaFinVig\"]");

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