package Economia.Tramite130116;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130116 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement direccionGeneralNormas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement importacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement importacionAmbuRecoReac = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/ul/li[14]/a");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement inputClasificacion = $x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    public SelenideElement inputProducto = $x("//*[@id=\"tabs-3\"]/div[3]/div[1]/div[2]/input");
    public SelenideElement inputDescripcion = $x("//*[@id=\"solicitud.mercancia.descripcion\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFactura = $x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement inputUMT = $x("//*[@id=\"unidadTarifariaComboId\"]");
    public SelenideElement inputCantidadPartida = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputValorPartida = $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement inputFraccionArancelariaTIGIE = $x("//*[@id=\"fraccionTigieText\"]");
    public SelenideElement getInputFraccionArancelariaTIGIE2 = $x("//*[@id=\"fraccionArancelariaTIGIE\"]");
    public SelenideElement inputDescripcionPartida = $x("//*[@id=\"descripcion\"]");
    public SelenideElement btnAgregarPartida = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div/input[2]");
    public SelenideElement inputBloquePaisDestino = $x("//*[@id=\"bloqueAutocomplete\"]/option[14]");
    public SelenideElement inputPaisDedstino = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregarBloque = $x("//*[@id=\"agregarPaisBloque\"]");
    public SelenideElement textareaUsoEspecifico = $x("//*[@id=\"tabs-3\"]/div[17]/div/div[2]/textarea");
    public SelenideElement textareaJustificacion = $x("//*[@id=\"tabs-3\"]/div[18]/div/div/textarea");
    public SelenideElement textareaObservaciones = $x("//*[@id=\"tabs-3\"]/div[19]/div/div[2]/textarea");
    public SelenideElement inputEntidad = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement inputRepresentacionFederal = $x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}