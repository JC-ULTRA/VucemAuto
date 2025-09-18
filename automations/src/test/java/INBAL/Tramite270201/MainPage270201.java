package INBAL.Tramite270201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage270201 {
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
    public SelenideElement linkInba04001 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
    public SelenideElement linkAviImpExpObrArtSigXXyXXI = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputTipoOperacion = $x("//*[@id=\"solicitud.tipoOperacion\"]");
    public SelenideElement inputTipoMovimiento = $x("//*[@id=\"solicitud.tipoMovimiento\"]");
    public SelenideElement btnAgregarObra = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[4]/div/div/input[2]");
    public SelenideElement InputAutor = $x("//*[@id=\"autor\"]");
    public SelenideElement InputTitulo = $x("//*[@id=\"tituloObra\"]");
    public SelenideElement InputTecnica = $x("//*[@id=\"tecnicasRealizacionObra\"]");
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
    public SelenideElement InputAduanaEntrada = $x("//*[@id=\"solicitud.aduanaEntrada.clave\"]");
    public SelenideElement InputDeclaracion = $x("//*[@id=\"declaracion[0]\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDocument = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement inputDocument = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement capturaRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[1]/a");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
    public SelenideElement seleccionarDocumentos = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[2]/a");
    public SelenideElement primerDecumento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[2]/table/tbody/tr[2]/td[1]/input[5]");
    public SelenideElement inputDictamenAceptado = $x("//*[@id=\"sentidoDictamen\"]");
    //Autorización
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
}
