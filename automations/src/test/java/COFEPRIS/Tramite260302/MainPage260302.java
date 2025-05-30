package COFEPRIS.Tramite260302;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage260302 {
    //Tramite 260302
    //Loging y selección de rol
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("//img[contains(@alt, 'para')]");
    public SelenideElement CertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement PermisoSanitarioImporExporEstupefacientes = $x(" /html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/a/span");
    public SelenideElement elementoTramite260302 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[3]/ul/li[2]/a");

    //Paso 1 CAPTURAR  DATOS DE LA SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");   //*[@id="ui-id-2"]/label
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[25]/div[3]/div/button");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");

    //Domicilio del establecimiento
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioMunicipioAlcadia = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioLocalidad = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement getInputSolicitudEstablecimientoDomicilioColonia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionColonia\"]");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");
    public SelenideElement ResponsableSanitarioRFC = $x("//*[@id=\"solicitud.establecimiento.RFCResponsableSanitario\"]");
    public SelenideElement inputSolicitudEstablecimientoDomicilioLada = $x("//*[@id='solicitud.establecimiento.domicilio.lada']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");

//Agregar S.C.I.A.N.
    public SelenideElement btnAgregarScian = $x("//*[@id='btnScianAgregar']");
    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");
    public SelenideElement selectComboDescripcionScian = $x("//*[@id='comboDescripcionSCIAN']");
    public SelenideElement btnAgregar2Scian = $x("//*[@id=\"frmSCIAN\"]/div[4]/div[2]/div/input[3]");

//Check Aviso
    public SelenideElement checkAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");
    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");
    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");
    
// Agregar Mercancía
    public SelenideElement btnAgregarMercancia = $x("//*[@id='btnagregarAduana']");
    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement MercanciaEspecificaClasProd = $x("//*[@id=\"nombreSubClasificacionProducto\"]");
    public SelenideElement DenominacionComunInternacional = $x("//*[@id=\"idDenominacionEspecifica\"]");
    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement selectMercanciaGridTipoProducto = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement selectEstadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");
    //Forma Farmaceutica
    public SelenideElement btnDesplegarFormaFarmaceutica = $x("//*[@id=\"accordion\"]/div/div[1]/button");
    public SelenideElement listaFormaFarmaceutica = $x("//*[@id=\"formaFarmaceuticaCross\"]");
    public SelenideElement btnAgregarFormaFarmaceutica = $x("//*[@id=\"panel-listaFormaFarmaceutica\"]/div/div/div[2]/div/div/input[2]");

    //Información General Mercancía
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGridUnidadMedida = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement NumeroCAS = $x("//*[@id=\"numeroCAS\"]");
    public SelenideElement CantidadLotes = $x("//*[@id=\"cantidadLotes\"]");
    public SelenideElement Presentacion = $x("//*[@id=\"presentacion\"]");

    //Pais Destino
    public SelenideElement selectPaisDestino = $x("//*[@id=\"mercanciaGrid.clavesPaisesDestino\"]");

    //Uso especifico
    public SelenideElement btnDesplegarInfoUsoEspecifico = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[4]/div[2]/div/div[1]/button");
    public SelenideElement listaUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement btnAgregarUsoEspecifico = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement btnAgregarInfoMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");

    //Aduana
    public SelenideElement selectAduanas = $x("//*[@id=\"aduanas\"]");

    //Manifiesto y declaraciones
    public SelenideElement checkCumploRequisitosYNormativas = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement radNoHacerPublicoInformacion = $x("//*[@id=\"informacionConfidencialNo\"]");

    //Representabte Legal
    public  SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");
    public  SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //ELEMENTOS TERCEROS RELACIONADOS
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");
    //Agregar Destino
    public SelenideElement btnAgregarDestinatario =$x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    //Agregar Otros
    public SelenideElement btAgregarOtros = $x("//*[@id=\"agregarTercero_TIPERS_OTR\"]");

    //Datos Generales
    public  SelenideElement selectPaisTerceros = $x("//*[@id=\"terceros_selectPais\"]");
    public  SelenideElement TerceroNombreDescripcion = $x("//*[@id=\"terceros_nombre_descripcion\"]");
    public  SelenideElement radbtnExtranjeroTerceros= $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public  SelenideElement radbtnNacionalTerceros = $x ("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public  SelenideElement radbtnPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public  SelenideElement radbtnPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public  SelenideElement inputTercerosDenominacionRazon = $x("//*[@id=\"terceros_rSocial\"]");
    public  SelenideElement TercerosRFC = $x("//*[@id=\"terceros_rfc\"]");
    public  SelenideElement btnBuscarTercerosRFC = $x("//*[@id=\"buscarEmpresa\"]");

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
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[9]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
