package TestProd;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageProd {
    //Login Prod
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnIngresFF = $x("//*[@id=\"btnSubmit\"]");

    //Tareas Pendientes
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement refreshInicio = $x("//*[@id=\"bandejaSol\"]");

    //Consulta Subsecuentes
    public SelenideElement Tramites = $x("//*[@id=\"subenlaces\"]/ul/li[5]/a");
    public SelenideElement SubSec = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[3]/a");
    public SelenideElement folioConsultar = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tramiteSub = $x("//*[@id=\"3\"]/td[3]");

    //Consulta Estado de Trámite Fucionario
    public SelenideElement Consultas = $x("//*[@id=\"tablaMenuLateral\"]/tbody/tr[3]/td/a/img");
    public SelenideElement DespConsultas = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/a");
    public SelenideElement ConsultEstTram = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[15]/a");
    public SelenideElement FolioConsultar = $x("//*[@id=\"folioTramite\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");

}
