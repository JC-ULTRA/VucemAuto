package Economia.Tramite150101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage150101 {
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
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement reporteAnual = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[8]/a");
    public SelenideElement reporteAnualSE = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[8]/ul/li/a");
    public SelenideElement programasPresentados = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement selecPrograma = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement datosReporteAnual = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a");
    public SelenideElement ventasTotales = $x("//*[@id=\"ventasTotales\"]");
    public SelenideElement totalExportaciones = $x("//*[@id=\"totalExportaciones\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");


}
