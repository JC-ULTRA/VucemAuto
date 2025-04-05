package Economia.Tramite110222;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110222 {

    //Tramite Aviso 110222
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
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");

    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidaciCertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement ValidarInicialmenteCert = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-se-HA/invocarModulo.action?init','/ventanilla-se-HA//se/cer_ori/registro/inicialCertificadoOrigenAlianzaDelPacificoWizard.action?solicitud.discriminatorValue=110222&iniciar','110222','','SinBP')\"]");
    public SelenideElement PestCertOrigen = $x("//*[@id='ui-id-2']");

    public SelenideElement selectTratadoAcuerdo = $x("//*[@id='solicitud.idTratadoAcuerdoSeleccionado']");
    public SelenideElement selectClavePais = $x("//*[@id='solicitud.clavePaisSeleccionado']");
    public SelenideElement BuscarMercancias = $x("//*[@id='idBotonBuscarMercancias']");

    //SELECCIONAR LA MERCACIA






}
