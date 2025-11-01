package Economia.Tramite110102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110102 {
    //Tramite Aviso 110102
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
    public SelenideElement RegistroProductosEle = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[1]/a");
    public SelenideElement AladiAlianza = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-se-HA/invocarModulo.action?init','/ventanilla-se-HA//se/cer_ori/registro/inicialRegistroComercializadorWizard.action?solicitud.discriminatorValue=110102&iniciar','110102','RecibirSolicitud','SE_ID110102_CertificadosService')\"]");

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement DatosMercanc = $x("//label[contains(@for, 'ertificado')]");
    public SelenideElement RegistroProductor = $x("//*[@id='cveRegistroProductor']");
    public SelenideElement BuscarProductos = $x("//input[@type='button']");

    public SelenideElement EntidadFede = $x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement RepresentacionFederal = $x("//*[@id='representacionFederalSelect']");
    public SelenideElement DeclaracionesManifiestoDeclaracion = $x("//*[@id='chkman']");
    public SelenideElement inputContinuarSoli = $x("//*[@id='guardarSolicitud']");

    //Proceso Confirmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");

}
