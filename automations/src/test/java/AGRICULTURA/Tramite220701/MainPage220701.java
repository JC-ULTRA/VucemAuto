package AGRICULTURA.Tramite220701;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage220701 {
    ///Tramite Aviso 220701
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioBusqueda = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolioSub = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement TramiteSeleccionar = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement ProrrogaDelTramite = $x("//*[@id=\"prorrogaButton\"]");
    public SelenideElement PestDatosSoli = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement Justific = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement btnContiRequerimiento = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContiCarga = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDocs = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement Doc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnex = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrarMod = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement btnContFirm = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");

}
