package Economia.Tramite120204;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120204 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkExpCerCupLicPub = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/ul/li[3]/a");
    public SelenideElement inputLicitacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputEntidadFederativa = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement inputRepresentacionFederativa = $x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement inputMontoExpedir = $x("//*[@id=\"montoExpedir\"]");
    public SelenideElement btnAgregarCertificacion = $x("//*[@id=\"tabs-2\"]/div/div/div[4]/div[2]/div[3]/div/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btnSiguienteBoton = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement capturaRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[1]/a");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
    public SelenideElement seleccionarDocumentos = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[2]/a");
    public SelenideElement primerDecumento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[2]/table/tbody/tr[2]/td[1]/input[5]");
    public SelenideElement inputDictamenAceptado = $x("//*[@id=\"evaluarSolicitud\"]/table[1]/tbody/tr[2]/td[2]/input[1]");
    //Autorización
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
}
