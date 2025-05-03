package COFEPRIS.Tramite260301;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260301 {
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
    public SelenideElement linkPermisoSanImpExpEstPsi = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/a");
    public SelenideElement linkPermisoImpMatPriEstPsi = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/ul/li[1]/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement divAceptar = $x("/html/body/div[25]/div[3]/div/button");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioInformacion = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion2 = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionColonia']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");
    public SelenideElement InputSolicitudEstablecimientoRFC = $x("//*[@id=\"solicitud.establecimiento.RFCResponsableSanitario\"]");
    public SelenideElement InputSolicitudEstablecimientoLada = $x("//*[@id=\"solicitud.establecimiento.domicilio.lada\"]");
    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
    public SelenideElement inputScianAgregar = $x("//*[@id='btnScianAgregar']");
    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");
    public SelenideElement inputAgregar = $x("//input[@onclick='javascript:agregarDatosSCIAN();']");
    public SelenideElement inputAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");
    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");
    public SelenideElement inputSolicitudTienePrioridad = $x("//input[@name='solicitud.tienePrioridad']");
    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectSolicitudRegimenClave2 = $x("//*[@id='aduanas']");
    public SelenideElement selectAduanas = $x("//*[@id='btnagregarAduana']");


    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement selectMercanciaGridClasificacionProducto2 = $x("//*[@id=\"nombreSubClasificacionProducto\"]");
    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");
    public SelenideElement inputDenominacionEspecifica2 = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputTipoTramiteMercancia = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement inputTipoTramiteEstadoTramite = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");
    public SelenideElement inputFormaFarmaceutica = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[2]/div[10]/div/div[1]/button");
    public SelenideElement selectFormaFarmaceutica = $x("//*[@id=\"formaFarmaceuticaCross\"]");
    public SelenideElement btnAgregarFormaFarmaceutica = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[2]/div[10]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputTipoProductoDescripcionOtros = $x("//*[@id='idTipoProductoDescripcionOtros']");
    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement inputDetalleUmc = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement inputNumeroCAS = $x("//*[@id=\"numeroCAS\"]");
    public SelenideElement inputCantidadLotes = $x("//*[@id=\"cantidadLotes\"]");
    public SelenideElement inputKGLotes = $x("//*[@id=\"kgPorLote\"]");
    public SelenideElement inputPaisOrigen = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[4]/div[2]/div/div[1]/button");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"paisesDeOrigen\"]/option[12]");
    public SelenideElement btnAgregarSeleccion = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement inputUsoEspecifico = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[4]/div[4]/div/div[1]/button");
    public SelenideElement selectUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]/option[5]");
    public SelenideElement inputAgregarUsoEspecifico = $x("/html/body/main/div[1]/div[4]/div[2]/form/div[4]/div[4]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputDetallaUsoEspecifico = $x("//*[@id=\"especificaUsoEspecifico\"]");
    public SelenideElement inputPiezaFabricar = $x("//*[@id=\"piezasAFabricar\"]");
    public SelenideElement inputDetalle = $x("//*[@id=\"detallePiezasAFabricar\"]");
    public SelenideElement inputRegistroSanitario = $x("//*[@id=\"registroSanitario\"]");
    public SelenideElement inputPresentacion = $x("//*[@id=\"presentacion\"]");
    public SelenideElement btnAgregarDetalle = $x("//*[@id=\"btnAgregarMercancias\"]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement inputAduanas = $x("//*[@id=\"aduanas\"]");
    public SelenideElement inputDeclaracion = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement inputNoConfidencial = $x("//*[@id=\"informacionConfidencialNo\"]");
    public SelenideElement inputInformacionConfidencial = $x("//*[@id='informacionConfidencialSi']");
    public SelenideElement inputResultadoIdc = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement inputConsultarIdc = $x("//*[@id=\"consultarIDC\"]");
    //TERCEROS RELACIONADOS
    public SelenideElement labelTerceros = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    //FABRICANTE
    public SelenideElement inputAgregarTerceroTipersFab = $x("//*[@id='agregarTercero_TIPERS_FAB']");
    public SelenideElement inputDenominacion = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputEstado = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement selectTercerosCodPostal = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");
    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");
    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");
    public SelenideElement inputTercerosLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");
//*[@id="terceros_calle"]

    public SelenideElement inputTercerosNacionalidadMexicana = $x("//*[@id='terceros_nacionalidadMexicana']");
    public SelenideElement inputTercerosTipoPersonaMoral2 = $x("//*[@id='terceros_tipoPersonaMoral']");
    public SelenideElement inputTerceros2 = $x("//*[@id='terceros_rfc']");
    public SelenideElement btnBuscarEmpresa = $x("//*[@id=\"buscarEmpresa\"]");
    public SelenideElement buttonGuardarDatosTercero2 = $x("//*[@id='btnGuardarFrmDatosTercero']");
    //FACTURADOR
    public SelenideElement btnAgregarFacturador = $x("//*[@id=\"agregarTercero_TIPERS_FAC\"]");
    public SelenideElement inputTercerosTipoPersonaMoral = $x("//*[@id='terceros_tipoPersonaMoral']");
    public SelenideElement inputTerceros = $x("//*[@id='terceros_rfc']");
    public SelenideElement inputTercerosSocial = $x("//*[@id='terceros_rSocial']");
    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");
    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");
    public SelenideElement selectTercerosLocalidad = $x("//*[@id='terceros_selectLocalidad']");
    public SelenideElement PostalCode = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[1]/fieldset/div[3]/div[1]/div[7]/div[5]/div/div[1]/select");
    public SelenideElement selectTercerosColonia = $x("//*[@id='terceros_selectColonia']");





    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[10]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
