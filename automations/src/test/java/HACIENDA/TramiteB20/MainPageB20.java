package HACIENDA.TramiteB20;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPageB20 {
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
    public SelenideElement B20 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/ul/li[9]/a");
    public SelenideElement linkDetalle = $x("//*[@id='ui-id-2']");
    public SelenideElement oficio = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[2]/div/div/input");
    public SelenideElement fechaoficio1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[1]/div/div/input");
    public SelenideElement fechaoficio2 = $x("/html/body/div[7]/table/tbody/tr[5]/td[4]/a");
    public SelenideElement aduana = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[2]/select/option[16]");
    public SelenideElement seccionaduanera = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div/div/div[1]/select/option[2]");
    public SelenideElement claveautorización = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div/div/div[2]/div/div/select/option[2]");
    public SelenideElement superficie = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[6]/div[1]/div/input");
    public SelenideElement capacidad = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[6]/div[2]/div/input");
    public SelenideElement almacenaje = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[7]/div[1]/div/input");
    public SelenideElement espacioUsado = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[7]/div[2]/div/div[1]/input[1]");
    public SelenideElement manifiesto1 = $("#tratado");
    public SelenideElement continuar = $x("/html/body/main/div/div[4]/div/form/div[3]/div/div/div[2]/input[1]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}