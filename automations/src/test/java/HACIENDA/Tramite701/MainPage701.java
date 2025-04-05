package HACIENDA.Tramite701;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage701 {

    //Tramite Aviso 701
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement Digitalizar = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a/span");
    public SelenideElement TramiteDigi = $x("//a[contains(@onclick, \"','701','','')\")]");
    public SelenideElement Continuar = $x("//*[@id='guardarSolicitud']");

    public SelenideElement DocComDomicilio = $x("//option[@value='179']");
    public SelenideElement Agregar = $x("//input[@value='Agregar nuevo']");
    public SelenideElement RfcConsulta = $x("//*[@id='idRFC1']");
    public SelenideElement CheckDoc = $x("//*[@id='jqg_jqgridDoctosEspecificos_1']");
    public SelenideElement Continuar2 = $x("//input[@name='Continuar']");

    public SelenideElement Adjuntar = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = $x("//input[@type='file']");
    public SelenideElement Anexar = $x("//*[@id='btnAnexar']");

    public SelenideElement Cerrar = $x("//*[@id='btnCerrar']");
            
    public SelenideElement Siguiente = $x("//*[@id='siguienteButton']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");













}
