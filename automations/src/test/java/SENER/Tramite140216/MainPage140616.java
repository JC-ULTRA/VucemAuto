package SENER.Tramite140216;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140616 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Sener = $x("/html/body/main/div/div[3]/div/form/a[11]/img");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement imgOtrasTareas = $x("//*[@id=\"tablaMenuLateral\"]/tbody/tr[7]/td/a/img");
    public SelenideElement labeOtrasTareas = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/a");
    public SelenideElement labelSENER = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[29]/a");
    public SelenideElement labelRevocacionPF = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[29]/ul/li[2]/a");
    public SelenideElement inputFolioTramite = $x("//*[@id=\"parametroBusqueda\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"tabs-solicitante\"]/div[1]/div[2]/input");
    public SelenideElement inputMotivoSuspension = $x("//*[@id=\"motivoText\"]");
    public SelenideElement inputNumeroOficio = $x("//*[@id=\"numOficioText\"]");
    public SelenideElement inputFechaSuspension = $x("//*[@id=\"calendarToSener\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}