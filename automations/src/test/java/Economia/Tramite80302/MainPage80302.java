package Economia.Tramite80302;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage80302 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = Selenide.$x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = Selenide.$x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ModificacionPrograma = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/a");
    public SelenideElement ModifBajaDomiPBA = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/ul/li[2]/a");
}
