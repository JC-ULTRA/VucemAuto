package HACIENDA.Tramit40401;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage40401 {
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegCodAlfArmTra = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement RegCodAlfArmTraAereo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/a");
    public SelenideElement Tramite40401 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/ul/li[1]/a");
}
