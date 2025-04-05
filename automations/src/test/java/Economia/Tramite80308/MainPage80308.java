package Economia.Tramite80308;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80308 {

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
    public SelenideElement modificacionPrograma = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/a");
    public SelenideElement modificacionDomicilio = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/ul/li[7]/a");
    public SelenideElement tablaProgramas = $x("//*[@id=\"jqgh_gridProgramasDisponiblesModificaciones_idProgramaCompuesto\"]");
    public SelenideElement selecImmex = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div[2]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement modificaion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement entidadPlanta = $x("//*[@id=\"entidadFederativa\"]");
    public SelenideElement btnBuscarPlanta = $x("//*[@id=\"tabs-3\"]/div[6]/div/div/input");
    public SelenideElement selecPlanta = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[7]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnAgregarPlanta = $x("//*[@id=\"seleccionar_plantas\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");



}
