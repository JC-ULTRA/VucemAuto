package Economia.Tramite90201;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage90201 {
    //
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Prosec = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement Ampliacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/a");
    public SelenideElement Tramite90201 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/ul/li[1]/a");
    public SelenideElement Dobleclick = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[1]/div/div[3]/div[2]/div/table/thead/tr/th[4]/div");
    public SelenideElement FolioDelPrograma = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement DomPlan = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement sector = $x("//*[@id=\"sectoresProsecConf\"]");
    public SelenideElement btnAgregarSector = $x("//*[@id=\"btnAgregarSectores\"]");
    public SelenideElement Check = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement FreacArancel = $x("//*[@id=\"fraccionSector\"]");
    public SelenideElement btnAgregarFracArancel = $x("//*[@id=\"btnAgregarFraccion\"]");
    public SelenideElement CheckArancel = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[7]/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement ProducIndirect = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement RFC = $x("//*[@id=\"rfcProductorIndirecto\"]");
    public SelenideElement btnAgregarProduct = $x("//*[@id=\"btnAgregarProductorIndirecto\"]");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
}
