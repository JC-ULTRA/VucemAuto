package HACIENDA.Tramite32516;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage32516 {
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
    public SelenideElement HACIENDA = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkRegistroComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement linkEnvioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement linkAvisoHechos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[16]/a");
    public SelenideElement labelTipoAviso = $x("//label[contains(@for, 'eic')]");
    public SelenideElement inputActaHechos = $x("//*[@id='actaDeHechos']");
    public SelenideElement inputAcudioADACESi = $x("//*[@id=\"acudioSi\"]");
    public SelenideElement inputAcudioADACENo = $x("//*[@id=\"acudioNo\"]");
    public SelenideElement inputADACECorresponde = $x("//*[@id='levantarActa']");
    public SelenideElement inputIDTransaccionSi = $x("//input[@onclick='ocultarEscicion1()']");
    public SelenideElement inputIDTransaccionNo = $x("//input[@onclick='ocultarEscicion2()']");
    public SelenideElement btnAgregarMercancia = $x("//*[@id='btnAgregar']");
    public SelenideElement inputNumeroIMMEX = $x("//*[@id='numeroIMMEX']");
    public SelenideElement inputConsecutivo = $x("//*[@id='consecutivo']");
    public SelenideElement inputDescripcion = $x("//*[@id='descripcion']");
    public SelenideElement inputCantidad = $x("//*[@id='cantidad']");
    public SelenideElement inputUnidadMedida = $x("//*[@id='unidadMedida']");
    public SelenideElement inputPeso = $x("//*[@id='peso']");
    public SelenideElement btnAgregar = $x("//*[@id='agregar']");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
