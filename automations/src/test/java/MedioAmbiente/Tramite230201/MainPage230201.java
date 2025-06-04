package MedioAmbiente.Tramite230201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage230201 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement MedioAmbiente = $x("//img[contains(@alt, 'Medio')]");
    public SelenideElement linkCerLicPer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement link03046CFER = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
    public SelenideElement linkCerFitExp = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li[1]/a");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form[1]/div[2]/ul/li[2]/a/label");
    public SelenideElement selectAduanas = $x("//*[@id='aduanasSa']");
    public SelenideElement optionCiudadXico = $x("//option[@title='CIUDAD DE MÉXICO']");
    public SelenideElement inputAddlistaOrigen = $x("//*[@id='addlistaOrigen3']");
    public SelenideElement selectSolicitudDescripcionProducto = $x("//*[@id='solicitud.descripcionProducto.idDescripcionProducto']");
    public SelenideElement inputAgregarMercancias = $x("//input[@name='agregarAduana']");
    public SelenideElement selectMercanciaGridFraccionArancelaria = $x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGridGenero = $x("//*[@id='mercanciaGrid.genero']");
    public SelenideElement selectMercanciaGridEspecie = $x("//*[@id='mercanciaGrid.especie']");
    public SelenideElement selectMercanciaGridNombreComun = $x("//*[@id='mercanciaGrid.nombreComun.clave']");
    public SelenideElement inputAgregarMercancias2 = $x("//input[@name='agregarDetalle']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement selectSolicitudCantidadUmc = $x("//*[@id='solicitud.cantidadUMC']");
    public SelenideElement inputEntrada = $x("//*[@id='entrada']");
    public SelenideElement inputDescripcionGenerica = $x("//*[@id='descripcionGenerica1']");
    public SelenideElement selectSolicitudTransporteIdeMedio = $x("//*[@id='solicitud.transporte.ideMedioTransporte']");
    public SelenideElement inputDescripcionTipoContenedor = $x("//*[@id='descripcionTipoContenedor']");
    public SelenideElement inputCodigoPostalDom = $x("//*[@id='codigoPostalDom']");
    public SelenideElement selectUbicacionMercanciaDomicilioEntidad = $x("//*[@id='ubicacionMercancia.domicilio.entidadFederativa.clave']");
    public SelenideElement inputCalleDom = $x("//*[@id='calleDom']");
    public SelenideElement inputDescripcionColoniaDom = $x("//*[@id='descripcionColoniaDom']");
    public SelenideElement inputNumeroExteriorDom = $x("//*[@id='numeroExteriorDom']");
    public SelenideElement inputNumInteriorDom = $x("//*[@id='numInteriorDom']");
    //TERCEROS
    public SelenideElement labelTerceros = $x ("/html/body/main/div[1]/div[4]/div[1]/form[1]/div[2]/ul/li[3]/a/label");
    public SelenideElement inputBotonAgregarDestinatario = $x("//*[@id='botonAgregarDestinatario']");
    //public SelenideElement inputNacional = $x("//*[@id='nacional']");
    //public SelenideElement inputExtranjero = $x("//*[@id='extranjero']");
    //FISICA
    public SelenideElement inputPfisica = $x("//*[@id='pfisica']");
    public SelenideElement inputNombre = $x("//*[@id='nombre']");
    public SelenideElement inputApellidoPaterno = $x("//*[@id='apellidoPaterno']");
    public SelenideElement inputApellidoMaterno = $x("//*[@id='apellidoMaterno']");
    //MORAL
    public SelenideElement inputPmoral = $x("//*[@id='pmoral']");
    public SelenideElement inputRazonSocial = $x("//*[@id='razonSocial']");
    public SelenideElement inputCodigoPostal = $x("//*[@id='codigoPostal']");
    public SelenideElement selectPaisSinMexico = $x("//*[@id='paisSinMexico']");
    public SelenideElement inputCiudad = $x("//*[@id='ciudad']");
    public SelenideElement textareaDomicilio = $x("//*[@id='domicilio']");
    public SelenideElement inputButtonGuardar = $x("//input[@value='Guardar']");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos = $x("//label[@style='font-weight:normal']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}