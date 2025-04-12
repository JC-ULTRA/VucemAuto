package COFEPRIS.Tramite260212;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260212 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("/html/body/main/div/div[3]/div/form/a[3]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkPermisoSanitarioImportacionInsumoSalud = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
    public SelenideElement linkDispositivosMedicosMaquila = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li[12]/a");
    //DATOS SOLICITUD


    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[2]/a/label");
    public SelenideElement inputEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement btnAceptar = $x("/html/body/div[28]/div[3]/div/button");
    public SelenideElement inputSolicitudEstablecimientoResponsableSanitario = $x("//*[@id='solicitud.establecimiento.RFCResponsableSanitario']");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioInformacion = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion2 = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionColonia']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
    public SelenideElement inputScianAgregar = $x("//*[@id='btnScianAgregar']");
    public SelenideElement comboSCIAN = $x("//*[@id=\"comboSCIAN\"]");
    public SelenideElement inputAgregar = $x("//input[@onclick='javascript:agregarDatosSCIAN();']");


    public SelenideElement inputAvisoFuncionamiento = $x("//*[@id=\"avisoFuncionamiento\"]");
    public SelenideElement solicitudRegimen =$x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement aduanaEntrada = $x("//*[@id=\"aduanasEntrada\"]");
    public SelenideElement inputAgregarAduana = $x("//*[@id=\"btnagregarAduana\"]");
    public SelenideElement selectClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement selectSubClasificacionProducto = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");
    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");
    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputDenominacionComunInternacional = $x("//*[@id='idDenominacionComunInternacional']");
    public SelenideElement selectTipoProductoTipoTramite = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    //public SelenideElement selectFormaFarmaceutica = $x("//*[@id='mercanciaGrid.idFormaFarmaceutica']");
    public SelenideElement selectEstadoFisico = $x("//*[@id='mercanciaGrid.idEstadoFisico']");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUMT = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUnidadMedidaComercial = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement textareaPresentacion = $x("//*[@id='presentacion']");
    public SelenideElement inputRgistroSanitario = $x("//*[@id=\"registroSanitario\"]");
    public SelenideElement inputCaducidad = $x("//*[@id=\"fechaDeCaducidad\"]");
    public SelenideElement buttonAbrirPanelPaisesOrigen = $x("//*[@id=\"input27\"]");
    public SelenideElement PaisOrigen = $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement inputAgregarSeleccion = $x("//input[@value='Agregar selección']");
    public SelenideElement inputAbrirPanelPaisesProcedencia = $x("//*[@id=\"input34\"]");
    public SelenideElement PaisProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inputAgregarSeleccion2 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement botonAbrirPanelUsosEspecificos = $x("//*[@id=\"input41\"]");
    public SelenideElement UsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement botonAgregarSeleccion = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement inputDeclaracion = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement inputInformacionConfidencialSi = $x("//*[@id=\"informacionConfidencialSi\"]");
    public SelenideElement inputRepresentanteLegalRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement inputConsultarIDC = $x("//*[@id=\"consultarIDC\"]");


    //TERCEROS RELACIONADOS
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelTerceroRElacionado = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[3]/a/label");
    public SelenideElement inputAgregarFabricante = $x("//*[@id=\"agregarTercero_TIPERS_FAB\"]");
    public SelenideElement inputNacionalidadMexicana = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement inputNacionalidadextranjera = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement inputPErsonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputTerceroRazonSocial = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstado = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement terceroMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement terceroLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement terceroCodigoPostal = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement terceroColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement terceroCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //DESTINATARIO
    public SelenideElement inputAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement inputTipoPeronaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTerceroRFC2 = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputTerceroRazonSocial2 = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputTerceroNombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTerceroApePAter = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTerceroApeMAter = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement terceroEstado2 = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement terceroMunicipio2 = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement terceroLocalidad2 = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement terceroCodigoPostal2 = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement terceroColonia2 = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement terceroCalle2 = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior2 = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior2 = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroTelefono2 = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo2 = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTercero2 = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");

    public SelenideElement inputAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement inputTipoPeronaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTerceroNombre3 = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTerceroApePAter3 = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTerceroApeMAter3 = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputPais3 = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstadoLocalidad3 = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement terceroCodigoPostal3 = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement terceroColoniaEquiv3 = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    public SelenideElement terceroCalle3 = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior3 = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior3 = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroTelefono3 = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo3 = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTercero3 = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement inputAgregarFacturador = $x("//*[@id=\"agregarTercero_TIPERS_FAC\"]");
    public SelenideElement inputTipoPeronaFisica4 = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTerceroNombre4 = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTerceroApePAter4 = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTerceroApeMAter4 = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputPais4 = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstadoLocalidad4 = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement terceroCodigoPostal4 = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement terceroColoniaEquiv4 = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    public SelenideElement terceroCalle4 = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior4 = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior4 = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroTelefono4 = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo4 = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTercero4 = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");

    //PAGO DE DERECHOS

    public SelenideElement labelPagoDerechos =$x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");

    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}
