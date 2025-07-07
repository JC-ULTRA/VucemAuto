package Economia.Tramite80206;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80206 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement labelAmpliacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/a");
    public SelenideElement labeAmpliacion3R = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/ul/li[4]/a");
    public SelenideElement inputProgramaIMMEX = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement labelAnexoI = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id=\"fraccionExportacion\"]");
    public SelenideElement btnAgregarFraccion = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/input[2]");
    public SelenideElement inputFraccion = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[3]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement inputFraccionImportacion =$x("//*[@id=\"fraccionImportacion\"]");
    public SelenideElement inputclic = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[2]");
    public SelenideElement btnAgregarFraccionI = $x("//input[@name='agregarFraccion' and @value='Agregar' and contains(@class, 'btn-primary')]");
    //public SelenideElement btnAgregarFraccionI = $x("//input[@type='button' and @value='Agregar' and @name='agregarFraccion']");
    public SelenideElement label3Rs = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement selectRegla = $x("//*[@id=\"regla3RsImmex\"]");
    public SelenideElement selectSector = $x("//*[@id=\"sectores3RsImmex\"]");
    public SelenideElement btnAgregarSector = $x("//*[@id=\"acciones\"]/input[2]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Siguiente']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}