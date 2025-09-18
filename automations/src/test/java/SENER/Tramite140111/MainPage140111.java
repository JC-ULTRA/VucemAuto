package SENER.Tramite140111;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140111 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement btnSolicitarCancelación = $x("//*[@id=\"cancelarButton\"]");
    public SelenideElement renunciaDerechos = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement motivoRenuncia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[13]/div/div/textarea");
    public SelenideElement manifiesto = $x("//*[@id=\"idCheckManifiesto\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuarArchivos = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarFirma = $x("//*[@id=\"siguienteButton\"]");
}
