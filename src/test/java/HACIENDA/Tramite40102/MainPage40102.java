package HACIENDA.Tramite40102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage40102 {
    //Tramite Aviso 40102
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
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");

    public SelenideElement RegistroDelDigoAlfanum = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement RegistroDelDigoAlfanum2 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/a");
    public SelenideElement Tramite40102  = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-aga-HA/invocarModulo.action?init','/ventanilla-aga-HA//aga/renovarCaatTerrestreController.action?iniciar','40102','','')\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña Director General
    public SelenideElement DirectorGeneral = $x("//*[@id='ui-id-2']");
    public SelenideElement GuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    


}
