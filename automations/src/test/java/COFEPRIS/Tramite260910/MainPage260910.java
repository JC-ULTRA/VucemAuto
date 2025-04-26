package COFEPRIS.Tramite260910;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260910 {
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
    public SelenideElement inputSolicitarModificacion = $x("/html/body/main/div/div[4]/div/form[1]/div[6]/div[2]/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[2]/a/label");
    public SelenideElement inputModif = $x("//*[@id=\"mod\"]");
    public SelenideElement textareaJustificacionId = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement btnEstablecimiento = $x("//*[@id=\"btnEstablecimiento\"]");
    public SelenideElement buttonAceptar = $x("/html/body/div[28]/div[3]/div/button");

    public SelenideElement ResponsableSanitarioRFC = $x("//*[@id=\"solicitud.establecimiento.RFCResponsableSanitario\"]");

    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");

    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");

    //Domicilio del establecimiento
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");

    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioMunicipioAlcadia = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioLocalidad = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");

    public SelenideElement getInputSolicitudEstablecimientoDomicilioColonia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionColonia\"]");

    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioLada = $x("//*[@id='solicitud.establecimiento.domicilio.lada']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
    //Agregar S.C.I.A.N.
    public SelenideElement btnAgregarScian = $x("//*[@id='btnScianAgregar']");

    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");

    public SelenideElement selectComboDescripcionScian = $x("//*[@id='comboDescripcionSCIAN']");

    public SelenideElement btnAgregar2Scian = $x("//*[@id=\"frmSCIAN\"]/div[1]/div[4]/div[2]/div/input[3]");
    //Check Aviso
    public SelenideElement checkAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");

    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");

    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");

    public SelenideElement selectAduanasEntrada = $x("//*[@id=\"aduanasEntrada\"]"); //*[@id="aduanasEntrada"]

    // Agregar Mercancía
    public SelenideElement selectaduana =$x("//*[@id=\"jqg_gridMercanciasTram2602_3\"]");

    public SelenideElement btnModificarAduana = $x("//*[@id=\"btnModificarAduana\"]");

    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");

    public SelenideElement selectMercanciaGridEspecificaClasProd = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");

    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");

    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");

    public SelenideElement inputDenominacionNombreCientif = $x("//*[@id=\"idDenominacionComunInternacional\"]");

    public SelenideElement selectMercanciaGridTipoProducto = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");

    public SelenideElement comboFormaFarmaceutica= $x("//*[@id=\"mercanciaGrid.idFormaFarmaceutica\"]");

    public SelenideElement comboEstadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");

    public SelenideElement Especifique = $x("//*[@id=\"idEstadoFisicoDescripcionOtros\"]");

    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");

    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");

    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");

    public SelenideElement selectMercanciaGridUnidadMedida = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");

    public SelenideElement PresentacionFarmaTipoEnvase = $x("//*[@id=\"presentacion\"]");

    public SelenideElement NumRegistroSanitario = $x("//*[@id=\"registroSanitario\"]");


//País origen

    public SelenideElement btnDesplegarInfoPaisOrigen = $x("//*[@id=\"input33\"]");

    public SelenideElement buttonResolution = $x("//button[@href='#panel-listaPaisesDeOrigen']");

    public SelenideElement optionAntartida = $x("//*[@id=\"paisesDeOrigen\"]/option[6]");

    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");
    //País procedencia
    public SelenideElement btnDesplegarInfoPaisProcedencia = $x("//*[@id=\"input40\"]");

    public SelenideElement buttonResolution2 = $x("//button[@aria-controls='panel-listaPaisesDeProcedencia']");

    public SelenideElement MenuPaisesProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");

    public SelenideElement inputAdd2 = $x("//*[@id=\"panel-listaPaisesDeProcedencia\"]/div/div/div[2]/div/div/input[2]");

    public SelenideElement inputClaveLotes = $x("//*[@id='claveLotes']");

    //Uso especifico

    public  SelenideElement btnDesplegarInfoUsoEspecifico = $x("//*[@id=\"input47\"]");

    public SelenideElement MenuUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");

    public SelenideElement inputAdd3 = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");

    //public SelenideElement

    public SelenideElement btnAgregarMercanciaTotalInfo = $x("//*[@id=\"btnModificarMercancia\"]");

    //Manifiesto y declaraciones
    public SelenideElement checkCumploRequisitosYNormativas = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement radSiHacerPublicoInformacion = $x("//*[@id=\"informacionConfidencialSi\"]");

    //Representabte Legal
    public  SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");
    public  SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //ELEMENTOS TERCEROS RELACIONADOS
    public SelenideElement pestañaPaso1 = $x("//*[@id=\"h1_title\"]");
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");

    //Agregar fabricante
    public SelenideElement inputModifFabricante = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAB_0\"]");
    public  SelenideElement btnModificaFabricante = $x("//*[@id=\"modificarTercero_TIPERS_FAB\"]");

    //Datos Generales
    //public  SelenideElement radNacionalTerceros = $x ("//*[@id=\"terceros_nacionalidadMexicana\"]");
    //public  SelenideElement radPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    //public  SelenideElement radPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public  SelenideElement inputTercerosDenominacionRazon = $x("//*[@id=\"terceros_rSocial\"]");
    public  SelenideElement FabricanteRFC = $x("//*[@id=\"terceros_rfc\"]");

    //Datos personales
    public SelenideElement inputTercerosNombre = $x("//*[@id='terceros_nombre']");

    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id='terceros_apellidoPaterno']");

    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id='terceros_apellidoMaterno']");

    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");

    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");

    public SelenideElement selectTercerosLocalidad = $x("//*[@id='terceros_selectLocalidad']");

    public SelenideElement selectTercerosCodPostal = $x("//*[@id=\"terceros_codPostal1\"]");

    public SelenideElement selectTercerosColonia = $x("//*[@id='terceros_selectColonia']");

    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");

    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");

    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");

    public SelenideElement inputTerceroLada = $x("//*[@id=\"terceros_lada\"]");

    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");

    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");

    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");

    //Agregar Destino
    public SelenideElement inputDestinatario = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarDestinatario =$x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    //Agregar Proveedor
    public SelenideElement inputProveedor = $x("//*[@id=\"jqg_gridTerceros_TIPERS_PVD_0\"]");
    public SelenideElement btnModificaProveedor = $x("//*[@id=\"modificarTercero_TIPERS_PVD\"]");

    public SelenideElement listTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement TercerosEstadotxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement CodigoPostaltxt = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement TercerosColoniatxt = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    //Agregar facturador
    public SelenideElement inputFacturador = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAC_0\"]");
    public SelenideElement btnModificaFacturador = $x("//*[@id=\"modificarTercero_TIPERS_FAC\"]");

    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos =$x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[4]/a/label");
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
    //public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}