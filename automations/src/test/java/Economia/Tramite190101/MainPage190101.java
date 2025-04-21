package Economia.Tramite190101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage190101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkDireccionGeneralNormas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/a");
    public SelenideElement linkCerfiticacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/a");
    public SelenideElement linkCerfiticacionNOM = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/ul/li[1]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement inputSiguienteButton = $x("//*[@id=\"siguienteButton\"]");

}
