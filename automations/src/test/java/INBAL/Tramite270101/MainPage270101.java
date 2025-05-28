package INBAL.Tramite270101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage270101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement inbal = $x("/html/body/main/div/div[3]/div/form/a[8]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkINBA03003 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement linkPerExpTemObrPlaDecArtHisComINBAL = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/ul/li/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputTipoOperacion = $x("//*[@id=\"solicitud.tipoOperacion\"]");
    public SelenideElement inputTipoMovimiento = $x("//*[@id=\"solicitud.tipoMovimiento\"]");
    public SelenideElement btnAgregarObra = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[5]/div/div/input[2]");
    public SelenideElement InputAutor = $x("//*[@id=\"descripcionDenominacionEspecifica\"]");
    public SelenideElement InputTecnica = $x("//*[@id=\"tecnicasRealizacionObra\"]");
    public SelenideElement InputTitulo = $x("//*[@id=\"tituloObra\"]");
    public SelenideElement InputAlto = $x("//*[@id=\"medidaAlto\"]");
    public SelenideElement InputAncho = $x("//*[@id=\"medidaAncho\"]");
    public SelenideElement InputProfundidad = $x("//*[@id=\"profundidad\"]");
    public SelenideElement InputDiametro = $x("//*[@id=\"diametro\"]");
    public SelenideElement InputVariables = $x("//*[@id=\"variables\"]");
    public SelenideElement InputAnoCreacion = $x("//*[@id=\"anoCreacion\"]");
    public SelenideElement InputAvaluo = $x("//*[@id=\"avaluo\"]");
    public SelenideElement InputMoneda = $x("//*[@id=\"moneda.clave\"]");
    public SelenideElement InputPropietario = $x("//*[@id=\"propietario\"]");
    public SelenideElement InputFraccionArancelaria = $x("//*[@id=\"fraccionArancelaria.clave\"]");
    public SelenideElement btnGuardar = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement inputMotivo = $x("//*[@id=\"solicitud.motivoSolicitud.catalogo\"]");
    public SelenideElement inputNombre = $x("//*[@id=\"nombreExposicion\"]");
    public SelenideElement InputPais = $x("//*[@id=\"solicitud.paisDestino.clave\"]");
    public SelenideElement InputCiudadDestino = $x("//*[@id=\"ciudadDestino\"]");
    public SelenideElement InputMedioTransporte = $x("//*[@id=\"solicitud.medioTransporte\"]");
    public SelenideElement inputEmpresaTransportista = $x("//*[@id=\"infAdicional\"]");
    public SelenideElement InputUbicacionFinal = $x("//*[@id=\"solicitud.ubicacionSolicitud.catalogo\"]");
    public SelenideElement inputPeriodo = $x("//*[@id=\"solicitud.catalogoD.clave\"]");
    public SelenideElement inputAduanaEntrada = $x("//*[@id=\"solicitud.aduanaEntrada.clave\"]");
    public SelenideElement InputDeclaracion = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}