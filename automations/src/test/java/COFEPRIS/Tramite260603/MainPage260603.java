package COFEPRIS.Tramite260603;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260603 {
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
    public SelenideElement linkAvisoSanitario = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/a");
    public SelenideElement linkAvisoImportPrecurQuim = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/ul/li[3]/a");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement btnAceptar = $x("/html/body/div[25]/div[3]/div/button");
    public SelenideElement inputRazonSocial = $x("//*[@id=\"solicitud.establecimiento.razonSocial\"]");
    public SelenideElement inputCorreoElectronico = $x("//*[@id=\"solicitud.establecimiento.correoElectronico\"]");
    public SelenideElement inputCodigoPostal = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectEntidad = $x("//*[@id=\"entidadFederativa\"]");
    public SelenideElement inputMunicipio = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputLocalidad = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement inputColonia = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionColonia']");
    public SelenideElement inputCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputLada = $x("//*[@id=\"solicitud.establecimiento.domicilio.lada\"]");
    public SelenideElement inputTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
    public SelenideElement inputScianAgregar = $x("//*[@id='btnScianAgregar']");
    public SelenideElement comboSCIAN = $x("//*[@id=\"comboSCIAN\"]");
    public SelenideElement inputAgregar = $x("//input[@onclick='javascript:agregarDatosSCIAN();']");
    public SelenideElement inputAvisoFuncionamiento = $x("//*[@id=\"avisoFuncionamiento\"]");
    public SelenideElement solicitudRegimen =$x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement aduanaEntrada = $x("//*[@id=\"aduanas\"]");
    public SelenideElement inputAgregarAduana = $x("//*[@id=\"btnagregarAduana\"]");

    public SelenideElement selectClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement selectSubClasificacionProducto = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");
    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputNombreCientifico = $x("//*[@id=\"nombreCientifico\"]");
    public SelenideElement selectTipoProductoTipoTramite = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement selectEstadoFisico = $x("//*[@id='mercanciaGrid.idEstadoFisico']");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement inputUMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement inputPorcentaje = $x("//*[@id=\"porcentajeConcentracion\"]");
    public SelenideElement inputValorComercial = $x("//*[@id=\"idImporteFacturaUSD\"]");
    public SelenideElement inputFechaImportExport = $x("//*[@id=\"fechaImpExp\"]");
    public SelenideElement inputPresentacion = $x("//*[@id=\"presentacion\"]");
    public SelenideElement inputPaisPRocedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement inputPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement botonAbrirPanelUsosEspecificos = $x("/html/body/main/div/div[4]/div[2]/form/div[4]/div[4]/div/div[1]/button");
    public SelenideElement UsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement botonAgregarSeleccion = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement inputInformacionConfidencialNo = $x("//*[@id=\"informacionConfidencialNo\"]");
    public SelenideElement inputRepresentanteLegalRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement inputConsultarIDC = $x("//*[@id=\"consultarIDC\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");

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
    public SelenideElement terceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement terceroTelefono4 = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo4 = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTercero4 = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");



    public SelenideElement inputGuarda = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");

    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");

    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");


}
