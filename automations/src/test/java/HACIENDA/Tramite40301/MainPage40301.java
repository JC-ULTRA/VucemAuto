package HACIENDA.Tramite40301;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage40301 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registroCodAlf =  $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/a");
    public SelenideElement RegCodAlfCarg = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/ul/li[3]/a");
    public SelenideElement tramite40301 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/ul/li[3]/ul/li[1]/a");

    public SelenideElement PestDatosSoli = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement TipoDeAgente = $x("//*[@id=\"tipoAgente\"]");
    public SelenideElement btnConti = $x("//*[@id=\"guardarSolicitud\"]");
}
