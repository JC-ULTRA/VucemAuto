package COFEPRIS.Tramite260604;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage260604 {
    //Tramite 260604
    public SelenideElement folio = Selenide.$x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("//img[contains(@alt, 'para')]");
    public SelenideElement CertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement AvisoSanitario = $x(" //*[@id=\"servicios\"]/ul/li/ul/li[6]/a/span");
    public SelenideElement Tramite260604 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[6]/ul/li[4]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");   //*[@id="ui-id-2"]/label
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[25]/div[3]/div/button");

    //Datos del establecimiento
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");

    //Domicilio del establecimiento
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");

    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id=\"entidadFederativa\"]");

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

    public SelenideElement btnAgregar2Scian = $x("//*[@id=\"frmSCIAN\"]/div[3]/div[2]/div/input[3]");

    //Check Aviso
    public SelenideElement checkAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");

    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");

    public SelenideElement selectAduanasEntrada = $x("//*[@id=\"aduanas\"]");
    
// Agregar Mercancía
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnagregarAduana\"]");

    public SelenideElement selectMercanciaClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");//*[@id="mercanciaGrid.idClasificacionProducto"]

    public SelenideElement selectMercanciaEspecificaClasProd = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");

    public SelenideElement MarcaDenominacionDistintiva = $x("//*[@id=\"idDenominacionDistintiva\"]");

    public SelenideElement DenominacionGenericaDCI = $x("//*[@id=\"nombreCientifico\"]");

    public SelenideElement selectMercanciaTipoProducto = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");

    public SelenideElement selectEstadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");

    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");

    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");

    public SelenideElement selectMercanciaGridUnidadMedida = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");

    public SelenideElement PorcentajeConcentracion = $x("//*[@id=\"porcentajeConcentracion\"]");

    public SelenideElement ValorComercial = $x("//*[@id=\"idImporteFacturaUSD\"]");

    public SelenideElement fechaImporExpor = $x("//*[@id=\"fechaImpExp\"]");

    public SelenideElement PresentacionTipoEnvase = $x("//*[@id=\"presentacion\"]");

    public SelenideElement selectPaisDestino = $x("//*[@id=\"mercanciaGrid.clavesPaisesDestino\"]");

    public SelenideElement selectPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");


    //Uso especifico

    public  SelenideElement btnDesplegarInfoUsoEspecifico = $x("//*[@id=\"accordion\"]/div/div[1]/button");

    public SelenideElement selectUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");

    public SelenideElement inputAdd3 = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");

    public SelenideElement btnAgregarMercanciaTotalInfo = $x("//*[@id=\"btnAgregarMercancia\"]");


    //Manifiesto y declaraciones
    public SelenideElement radNoHacerPublicoInformacion = $x("//*[@id=\"informacionConfidencialNo\"]");

    //Representabte Legal
    public SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");

    //ELEMENTOS TERCEROS RELACIONADOS
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");

    //Agregar facturador
    public SelenideElement btnAgregarFacturador = $x("//*[@id=\"agregarTercero_TIPERS_FAC\"]");

    //Datos Generales
    public  SelenideElement radPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public  SelenideElement FabricanteRFC = $x("//*[@id=\"terceros_rfc\"]");

    //Datos personales
    public SelenideElement inputTercerosNombre = $x("//*[@id='terceros_nombre']");

    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id='terceros_apellidoPaterno']");

    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id='terceros_apellidoMaterno']");

    public SelenideElement TercerosEstadotxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");

    public SelenideElement CodigoPostaltxt = $x("//*[@id=\"terceros_codPostal\"]");

    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");

    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");

    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");

    public SelenideElement inputTerceroLada = $x("//*[@id=\"terceros_lada\"]");

    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");

    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");

    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");

    public SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");
    public SelenideElement listDocumento6Grid = $x("//*[@id=\"idDoc5\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarSolicitud\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo6 = $x("//*[@id=\"solicitud_5\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo7 = $x("//*[@id=\"solicitud_6\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");






}
