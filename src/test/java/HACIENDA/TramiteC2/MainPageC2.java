package HACIENDA.TramiteC2;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPageC2 {
    //    datos para firma
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFinal = $x("/html/body/main/div/div[4]/div/form/div[1]/table/tbody/tr[7]/td/input");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement C2 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/ul/li[5]/a");
    public SelenideElement linkDetalle = $x("//*[@id='ui-id-2']");
    public SelenideElement entidadfederativa = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/select/option[14]");
    public SelenideElement municipio = $x("//html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[2]/div[2]/div[2]/select/option[8]");
    public SelenideElement descripcionmercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[4]/div[1]/input");
    public SelenideElement cantidad = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[4]/div[2]/input");
    public SelenideElement peso = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[5]/div[1]/input");
    public SelenideElement volumen = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[5]/div[2]/input");
    public SelenideElement manifiesto1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[7]/div/div/div[1]/input");
    public SelenideElement manifiesto2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[7]/div/div/div[3]/input");
    public SelenideElement manifiesto3 = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div[7]/div/div/div[5]/input");
    public SelenideElement continuar = $x("/html/body/main/div/div[4]/div/form/div[3]/div/div/div[2]/input[1]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}