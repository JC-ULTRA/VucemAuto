package Economia.Tramite80207;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80207 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ampliacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/a");
    public SelenideElement ampliacionRegistro = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/ul/li[5]/a");
    public SelenideElement tablaProgramas = $x("//*[@id=\"jqgh_ampliacionesDisponibles_numeroImmex\"]");
    public SelenideElement selecImmex = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement empresasSub = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a");
    public SelenideElement rfcEmpresa = $x("//*[@id=\"rfcEmpresaSubManufacturera\"]");
    public SelenideElement entidadEmpresa = $x("//*[@id=\"entidadFederativaEmpresaSub\"]");
    public SelenideElement btnBuscarPlantas = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div/input");
    public SelenideElement selecPlantas = $x("//*[@id=\"cb_gridPlantasDispSubMan\"]");
    public SelenideElement agregarPlantas = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[6]/div/input");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnAceptar = $x("/html/body/div[8]/div[3]/div/button");

}
