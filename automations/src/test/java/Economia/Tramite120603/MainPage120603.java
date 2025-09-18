package Economia.Tramite120603;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120603 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CupoExIm = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement RegistroEmpresComerIndustFront = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[6]/a");
    public SelenideElement Tramite120603 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[6]/ul/li[2]/a");
    public SelenideElement PestDatEmpres = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement Estado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement CargarDatosDomicilio = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement TipoEmpresa = $x("//*[@id=\"solicitud.tipoEmpresaRECIF.clave\"]");
    public SelenideElement Especifique = $x("//*[@id=\"ti_espesifique\"]");
    public SelenideElement Clasif = $x("//*[@id=\"actividadEconomica\"]");
    public SelenideElement ClickFuera = $x("//*[@id=\"tabs-2\"]/div[4]/div[1]/div/h2");
    public SelenideElement ClickSi = $x("//*[@id=\"tipoNacionalidadMexicana\"]");
    public SelenideElement RFC = $x("//*[@id=\"ingresoCurp\"]");
    public SelenideElement CheckSi = $x("//*[@id=\"tipoPersonaFisica\"]");
    public SelenideElement btnAgregar = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[8]/div[2]/div/input");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
