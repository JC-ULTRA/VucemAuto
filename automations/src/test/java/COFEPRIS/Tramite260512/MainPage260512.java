package COFEPRIS.Tramite260512;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260512 {
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
    public SelenideElement linkPermisoImportPlagNutriVegTox = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[5]/a");
    public SelenideElement linkPermisoImportacionSustanciasToxicas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[5]/ul/li[11]/a");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[18]/div[3]/div/button");
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
    public SelenideElement inputLicenciaSanitaria = $x("//*[@id=\"numeroLicencia\"]");
    public SelenideElement inputAduanEntradaDispo = $x("//*[@id=\"origenlistaOrigen1\"]");
    public SelenideElement inputAgregarAduanaEntrada = $x("//*[@id=\"addlistaOrigen1\"]");
    //public SelenideElement solicitudRegimen =$x("//*[@id=\"solicitud.regimen.clave\"]");
    //public SelenideElement aduanaEntrada = $x("//*[@id=\"aduanasEntrada\"]");
    public SelenideElement inputAgregarAduana = $x("//*[@id=\"btnagregarAduana\"]");
    public SelenideElement inputNombreComercial = $x("//*[@id=\"nombreComercial\"]");
    public SelenideElement inputNombrecomun = $x("//*[@id=\"nombreComun\"]");
    public SelenideElement inputNombreCientifico = $x("//*[@id=\"nombreCientifico\"]");
    public SelenideElement inputUsoEspecifico = $x("//*[@id=\"mercanciausoFinal\"]");
    //public SelenideElement inputDenominacionComunInternacional = $x("//*[@id='idDenominacionComunInternacional']");
    //public SelenideElement selectTipoProductoTipoTramite = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    //public SelenideElement selectFormaFarmaceutica = $x("//*[@id='mercanciaGrid.idFormaFarmaceutica']");
    public SelenideElement selectEstadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputCantidadUMT = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUnidadMedidaComercial = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement inputCas = $x("//*[@id=\"numeroCAS\"]");
    public SelenideElement inputPorcentajeConcen = $x("//*[@id=\"porcentajeConcentracion\"]");
    public SelenideElement buttonAbrirPanelPaisesOrigen = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[4]/div[1]/div/div[1]/button");
    public SelenideElement PaisOrigen = $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement inputAgregarSeleccion = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[4]/div[1]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputAbrirPanelPaisesProcedencia = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[4]/div[2]/div/div[1]/button");
    public SelenideElement PaisProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inpiutAgregarPais = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputClasifToxi = $x("//*[@id=\"mercanciaGrid.clasificacionToxicologica.idClasificacionToxicologicaTipoTramite\"]");
    public SelenideElement inputObjetoImport = $x("//*[@id=\"mercanciaGrid.objetoImportacionEnum\"]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");

    //public SelenideElement botonAbrirPanelUsosEspecificos = $x("//*[@id='input44']");
    //public SelenideElement UsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    //public SelenideElement botonAgregarSeleccion = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputDeclaracion = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement inputInformacionConfidencialNo = $x("//*[@id=\"informacionConfidencialNo\"]");
    public SelenideElement inputRepresentanteLegalRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement inputConsultarIDC = $x("//*[@id=\"consultarIDC\"]");
    //PAGO DERECHOS
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelPagoDerechos =$x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");

    //FIRMA
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    //public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    //public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
