package COFEPRIS.Tramite260914;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage260914 {
    //Tramite 260104
    //Tramite 260216
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite subsecuente
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar Modificación y Prórroga
    public SelenideElement btnSolModificaryProrroga = $x("//*[@id=\"MYPButton\"]");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");   //*[@id="ui-id-2"]/label
    //Seleccione el tipo de operación que desea realizar
    public SelenideElement radbtnModificar = $x("//*[@id=\"mod\"]");
    public SelenideElement JustificacionMod = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement JustificacionDatos = $x("//*[@id=\"justificacionId\"]");
    //Datos del establecimiento
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
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
    public SelenideElement btnAgregarAduana = $x("//*[@id='btnagregarAduana']");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarAduana\"]");
    public SelenideElement gridMercancia1 = $x("//*[@id=\"jqg_gridMercanciasTram2602_3\"]");
    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement selectMercanciaGridEspecificaClasProd = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");
    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");
    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputDenominacionNombreCientif = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement selectMercanciaGridTipoProducto = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement selectEstadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");
    public SelenideElement Especifique = $x("//*[@id=\"idEstadoFisicoDescripcionOtros\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGridUnidadMedida = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement PresentacionFarmaTipoEnvase = $x("//*[@id=\"presentacion\"]");
    public SelenideElement NumRegistroSanitario = $x("//*[@id=\"registroSanitario\"]");

//País origen
    public SelenideElement btnDesplegarInfoPaisOrigen = $x("//button[contains(@onclick, 'abrirPanelPaisesOrigen')]");
    public SelenideElement buttonResolution = $x("//button[@href='#panel-listaPaisesDeOrigen']");
    public SelenideElement listaPaisOrigen = $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");
    public SelenideElement btnRestarPaisOrigenTodos = $x("//input[@name='remove_all' and contains(@onclick, 'paisesDeOrigen')]");

//País procedencia
    public SelenideElement btnDesplegarInfoPaisProcedencia = $x("//button[contains(@onclick, 'abrirPanelPaisesProcedencia')]");
    public SelenideElement buttonResolution2 = $x("//button[@aria-controls='panel-listaPaisesDeProcedencia']");
    public SelenideElement listaPaisesProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inputAdd2 = $x("//*[@id=\"panel-listaPaisesDeProcedencia\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement btnRestarPaisProveedorTodos = $x("//input[@name='remove_all' and contains(@onclick, 'paisesDeProcedencia')]");
    //Uso especifico
    public  SelenideElement btnDesplegarInfoUsoEspecifico = $x("//*[@id=\"input41\"]");
    public SelenideElement listaUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement inputAdd3 = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");

    public SelenideElement btnAgregarMercanciaTotalInfo = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement btnModificarTotalInfo = $x("//*[@id=\"btnModificarMercancia\"]");
    //Manifiesto y declaraciones
    public SelenideElement checkCumploRequisitosYNormativas = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement radNoHacerPublicoInformacion = $x("//*[@id=\"informacionConfidencialNo\"]");

    //Representabte Legal
    public  SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");
    public  SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //ELEMENTOS TERCEROS RELACIONADOS
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");

    //Agregar fabricante
    public  SelenideElement btnAgregarFabricante = $x("//*[@id=\"agregarTercero_TIPERS_FAB\"]");
    public SelenideElement gridFabricante1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAB_0\"]");
    public SelenideElement btnModificarFabricante = $x("//*[@id=\"modificarTercero_TIPERS_FAB\"]");

    //Datos Generales
    public  SelenideElement radNacionalTerceros = $x ("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public  SelenideElement radPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public  SelenideElement radPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public  SelenideElement radbtnExtranjero = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public  SelenideElement radbtnNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
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
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");

    //Agregar Destino
    public SelenideElement btnAgregarDestinatario =$x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement gridDestinatario1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarDestinatario= $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");

    //Agregar Proveedor
    public SelenideElement btnAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement gridProveedor1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_PVD_0\"]");
    public SelenideElement btnModificarProveedor = $x("//*[@id=\"modificarTercero_TIPERS_PVD\"]");
    public SelenideElement listTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement TercerosEstadotxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement CodigoPostaltxt = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement TercerosColoniatxt = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    //Agregar facturador
    public SelenideElement btnAgregarFacturador = $x("//*[@id=\"agregarTercero_TIPERS_FAC\"]");
    public SelenideElement gridFacturador1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAC_0\"]");
    public SelenideElement btnModificarFacturador = $x("//*[@id=\"modificarTercero_TIPERS_FAC\"]");




    //Pago de derechos
    public SelenideElement tabPagoDerechos = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement ClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement CadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement ImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");
    public SelenideElement listDocumento6Grid = $x("//*[@id=\"idDoc5\"]");
    public SelenideElement listDocumento7Grid = $x("//*[@id=\"idDoc6\"]");
    public SelenideElement listDocumento8Grid = $x("//*[@id=\"idDoc7\"]");
    public SelenideElement listDocumento9Grid = $x("//*[@id=\"idDoc8\"]");
    public SelenideElement listDocumento10Grid = $x("//*[@id=\"idDoc9\"]");
    public SelenideElement listDocumento11Grid = $x("//*[@id=\"idDoc10\"]");
    public SelenideElement listDocumento12Grid = $x("//*[@id=\"idDoc11\"]");
    public SelenideElement listDocumento13Grid = $x("//*[@id=\"idDoc12\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[16]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
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

    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
