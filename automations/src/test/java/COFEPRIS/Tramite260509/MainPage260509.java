package COFEPRIS.Tramite260509;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage260509 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite 260504
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("//img[contains(@alt, 'para')]");
    public SelenideElement CertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement PermisoImportacionToxicosPeligro = $x("//*[@id=\"servicios\"]/ul/li/ul/li[5]/a/span");
    public SelenideElement elementoTramite260509 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[5]/ul/li[8]/a");

    //PASO 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    //Datos del establecimiento
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[21]/div[3]/div/button");
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

    //Aduanas de entrada
    public SelenideElement listAduanasEntrada = $x("//*[@id=\"origenlistaOrigen1\"]");
    public SelenideElement btnAgregarAduanaentrada = $x("//*[@id=\"addlistaOrigen1\"]");

// Agregar Mercancía
    public SelenideElement btnAgregarMercancia = $x("//*[@id='btnagregarAduana']");
    //Identificación del producto
    public SelenideElement NombreComercial = $x("//*[@id=\"nombreComercial\"]");
    public SelenideElement NombreComun = $x("//*[@id=\"nombreComun\"]");
    public SelenideElement inputDenominacionNombreCientif = $x("//*[@id=\"nombreCientifico\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement PorcentajeConcentracion = $x("//*[@id=\"porcentajeConcentracion\"]");
    //País donde se produce o fabrica el ingrediente activo
    public SelenideElement btnDesplegarInfoPaisFabricante = $x("//button[contains(@onclick, 'abrirPanelPaisesFIA')]");
    public SelenideElement listaPaisFabricante = $x("//*[@id=\"paisesFabricaIngredienteActivo\"]");
    public SelenideElement btnAgregarPaisFabricante = $x("//input[@name='add' and contains(@onclick, 'paisesFabricaIngredienteActivo')]");
    //País donde se elabora el producto
    public SelenideElement btnDesplegarInfoPaisElabora = $x("//button[contains(@onclick, 'abrirPanelPaisesFP')]");
    public SelenideElement listaPaisElabora= $x("//*[@id=\"paisesFormulaProducto\"]");
    public SelenideElement btnAgregarPaisElabora = $x("//input[@name='add' and contains(@onclick, 'paisesFormulaProducto')]");
    //País proveedor (Origen)
    public SelenideElement btnDesplegarInfoPaisProveedor = $x("//button[contains(@onclick, 'abrirPanelPaisesOrigen')]");
    public SelenideElement listaPaisProveedor= $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement btnAgregarPaisProveedor = $x("//input[@name='add' and contains(@onclick, 'paisesDeOrigen')]");
    //País de procedencia/ País del último puerto de embarque
    public SelenideElement btnDesplegarInfoPaisProcedencia = $x("//button[contains(@onclick, 'abrirPanelPaisesProcedencia')]");
    public SelenideElement listaPaisProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement btnAgregarPaisProcedencia = $x("//input[@name='add' and contains(@onclick, 'paisesDeProcedencia')]");
    //Clasificación Toxicológica e importación
    public SelenideElement selectClasificacionToxi = $x("//*[@id=\"mercanciaGrid.clasificacionToxicologica.idClasificacionToxicologicaTipoTramite\"]");
    public SelenideElement selectObjetoImportacion = $x("//*[@id=\"mercanciaGrid.objetoImportacionEnum\"]");
    //Guardar información de la mercancia
    public SelenideElement btnAgregarMercanciaTotalInfo = $x("//*[@id=\"btnAgregarMercancia\"]");

    //Garantías ofrecidas
    public SelenideElement GarantiasOfrecidas = $x("//*[@id=\"descripcionAnalisisGarantizado1\"]");
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
    //Agregar formulador
    public SelenideElement btnAgregarFormulador = $x("//*[@id=\"agregarTercero_TIPERS_FOR\"]");
    //Agregar Proveedor
    public SelenideElement btnAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");

    //Datos Generales
    public  SelenideElement radExtranjeroTerceros= $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public  SelenideElement radNacionalTerceros = $x ("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public  SelenideElement radPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public  SelenideElement radPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public  SelenideElement inputTercerosDenominacionRazon = $x("//*[@id=\"terceros_rSocial\"]");
    public  SelenideElement TercerosRFC = $x("//*[@id=\"terceros_rfc\"]");
    public  SelenideElement btnBuscarTerceroRFC = $x("//*[@id=\"buscarEmpresa\"]");

    //Datos personales Nacional
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

    //Datos personales Extranjero
    public SelenideElement listTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement TercerosEstadotxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement CodigoPostaltxt = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement TercerosColoniatxt = $x("//*[@id=\"terceros_coloniaEquiv\"]");


    //Pago de derechos
    public SelenideElement tabPagoDerechos = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement ClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement CadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement ImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
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
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
