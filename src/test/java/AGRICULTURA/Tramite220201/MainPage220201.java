package AGRICULTURA.Tramite220201;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage220201 {
    //Tramite Aviso 220201 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement Agricultura = $x("//img[contains(@alt, 'Rural')]");
    public SelenideElement certysol = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement certImport = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a/span");
    public SelenideElement Selecttramite220201 = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-sagarpa-HA/invocarModulo.action?init','/ventanilla-sagarpa-HA//gubernamentales2/sagarpa/revisionDocumental/regSolRDZS.action?solicitud.discriminatorValue=220201&iniciar','220201','','')\"]");
    public SelenideElement tramite220201 = $x("//label[@for='solicitud.titulo']");

    public SelenideElement selectSolicitudClaveAduana = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement SolicitudOfiInspecAgrop = $x("//*[@id='solicitud.oficinaInspeccionAgropecuaria.clave']");
    public SelenideElement puntoInspec = $x("//*[@id='solicitud.unidadAdministrativaRepresentacionFederal.clave']");
    public SelenideElement ClaveUcon = $x("//*[@id='claveUcon']");
    public SelenideElement selectEstabTif = $x("//*[@id='solicitud.establecimientoTIF']");
    public SelenideElement NombreMedVet = $x("//*[@id='solicitud.descripcionClobGenerica2']");
    public SelenideElement NumGui = $x("//input[@size='25']");
    public SelenideElement Regimen = $x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement inputTipoMercancia = $x("//*[@id='tipoMercanciaNo']");
    public SelenideElement inputTipoMercancia2 = $x("//*[@id='tipoMercanciaSi']");

    


}
