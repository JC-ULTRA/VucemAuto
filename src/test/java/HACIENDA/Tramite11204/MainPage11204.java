package HACIENDA.Tramite11204;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage11204 {

    //Tramite Aviso 11204
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
    public SelenideElement AutorizacionesImportadorExportador = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement ConstanciaImportaciTemporalRetorno = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li/a");
    public SelenideElement Tramite11204 = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-constanciaITC-HA/invocarModulo.action?init','/ventanilla-constanciaITC-HA//aga/transferenciaContenedor/registrarSolicitud.action?inicio','11204','','')\"]");

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña de Contenedor
    public SelenideElement Contenedor = $x("//label[@for='contenedor']");
    public SelenideElement RadioContenedor = $x("//*[@id='idRadioContenedor']");
    public SelenideElement selectAduana = $x("//*[@id='aduana']");
    public SelenideElement InicialesContenedor = $x("//*[@id='inicialesContenedor']");
    public SelenideElement NumeroContenedor = $x("//*[@id='numeroContenedor']");
    public SelenideElement inputBuscar = $x("//*[@id='buscar']");
    public SelenideElement buttonModal = $x("//button[@onclick='mostrarTIpoContenedor();']");
    public SelenideElement selectContenedores = $x("//*[@id='contenedores']");
    public SelenideElement DigitoControl = $x("//*[@id='digitoDeControl']");

    public SelenideElement FechaIngrgeso = $x("//*[@id='fechaIngrgeso']");
    public SelenideElement selecFecha = $x("/html/body/div[6]/table/tbody/tr[4]/td[1]/a");
    public SelenideElement FechaVigencia = $x("//*[@id='Vigencia']");
    public SelenideElement selectFecVig = $x("/html/body/div[6]/table/tbody/tr[6]/td[1]/a");
    public SelenideElement inputAgregar = $x("//*[@id='agregar']");
    public SelenideElement GuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile1 = $x("//input[@name='documentos[1].file']");
    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");






    








}
