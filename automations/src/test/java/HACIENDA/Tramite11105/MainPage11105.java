package HACIENDA.Tramite11105;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage11105 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SolicitudSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    //Solicitudes subsecuentes
    public SelenideElement inputFolio = $x("//*[@id='idFolio']");
    public SelenideElement inputBuscarButton = $x("//*[@id='buscarButton']");
    public SelenideElement selecTramite = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");

    public SelenideElement btnDesistir = $x("//*[@id=\"desistimientoButton\"]");
    public SelenideElement solicitud = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement motivoDesistimiento = $x("//*[@id=\"justificacion\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
}
