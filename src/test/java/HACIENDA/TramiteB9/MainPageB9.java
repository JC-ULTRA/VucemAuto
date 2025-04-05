package HACIENDA.TramiteB9;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPageB9 {
    //Firma y Path del Trámite
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement B9 = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-AvisosAgace-HA/invocarModulo.action?init','/ventanilla-AvisosAgace-HA//avisos-agace/avisoB9TransMercDepFiscal/solicitudAvisoB9TransMercDepFiscal.action?iniciar','6909','','')\"]");
    //Pestaña Tipo Aviso
    public SelenideElement linkTipoAviso = $x("//*[@id='ui-id-2']");
    public SelenideElement NumAutorizacion = $x("//input[@name='solicitud.numAutorizacion']");
    public SelenideElement MedioTransporte = $x("//*[@id='solicitud.medioTransporte']");
    public SelenideElement inputEmbarcacion = $x("//*[@id='embarcacion']");
    //Domicilio del que transfiere la mercancía
    public SelenideElement selectDireccionOrigenEntidad = $x("//*[@id='solicitud.direccionStOrigen.entidadFederativa.clave']");
    public SelenideElement selectDireccionOrigenDelegacion = $x("//*[@id='solicitud.direccionStOrigen.delegacionMunicipio.clave']");
    public SelenideElement selectDireccionOrigenColonia = $x("//*[@id='solicitud.direccionStOrigen.colonia.clave']");
    public SelenideElement inputDireccionOrigenCalle = $x("//input[@name='solicitud.direccionStOrigen.calle']");
    public SelenideElement inputDireccionOrigenNumeroExt = $x("//input[@name='solicitud.direccionStOrigen.numeroExterior']");
    public SelenideElement inputDireccionOrigenNumeroInt = $x("//input[@name='solicitud.direccionStOrigen.numeroInterior']");
    public SelenideElement inputDireccionOrigenCP = $x("//input[@name='solicitud.direccionStOrigen.codigoPostal']");
    public SelenideElement inputDireccionOrigenNumAuto = $x("//input[@name='solicitud.direccionStOrigen.generico1']");
    public SelenideElement ReferenciaUbicacion = $x("//*[@id='referencia']");
    //Domicilio del que transfiere la mercancía
    public SelenideElement selectDireccionDestinoEntidad = $x("//*[@id='solicitud.direccionStDestino.entidadFederativa.clave']");
    public SelenideElement selectDireccionDestinoDelegacion = $x("//*[@id='solicitud.direccionStDestino.delegacionMunicipio.clave']");
    public SelenideElement selectDireccionDestinoColonia = $x("//*[@id='solicitud.direccionStDestino.colonia.clave']");
    public SelenideElement inputDireccionDestinoCalle = $x("//input[@name='solicitud.direccionStDestino.calle']");
    public SelenideElement inputDireccionDestinoNumExt = $x("//input[@name='solicitud.direccionStDestino.numeroExterior']");
    public SelenideElement inputDireccionDestinoNumInt = $x("//input[@name='solicitud.direccionStDestino.numeroInterior']");
    public SelenideElement inputDireccionDestinoCP = $x("//input[@name='solicitud.direccionStDestino.codigoPostal']");
    public SelenideElement inputDireccionDestinoNumAuto = $x("//input[@name='solicitud.direccionStDestino.generico1']");
    public SelenideElement Observaciones = $x("//*[@id='observaciones']");
    //Bloque Mercancías
    public SelenideElement inputAgregar = $x("//*[@id='btnAgregar']");
    public SelenideElement inputConsecutivo = $x("//*[@id='consecutivo']");
    public SelenideElement textareaDescripcion = $x("//*[@id='descripcion']");
    public SelenideElement inputCantidad = $x("//*[@id='cantidad']");
    public SelenideElement selectUnidadMedida = $x("//*[@id='unidadMedida']");
    public SelenideElement inputValor = $x("//*[@id='valor']");
    public SelenideElement inputCodigoProducto = $x("//*[@id='codigoProducto']");
    public SelenideElement inputFraccion = $x("//*[@id='fraccion']");
    public SelenideElement inputAgregar2 = $x("//*[@id='agregar']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Prueba final




}
