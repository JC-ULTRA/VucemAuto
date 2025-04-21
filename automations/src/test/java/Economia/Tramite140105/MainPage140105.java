package Economia.Tramite140105;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140105 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkCancelDesistReactiv = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[7]/a");
    public SelenideElement linkModifCancelDesistPeticion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[7]/ul/li/a");
    public SelenideElement linkDesistSolPermPetInteresado = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[7]/ul/li/ul/li[5]/a");
    //CANCELACION DE SOLICITUDES
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelCancelacinoSolicitud = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a/label");
    public SelenideElement inputBusquedaFolio = $x("//*[@id=\"tabs-3\"]/div[2]/div/div/input[4]");
    public SelenideElement inputNumFolioTramite = $x("//*[@id=\"numFolioTramite\"]");
    public SelenideElement inputValidaFolioResolucionCancelacion = $x("/html/body/main/div/div[4]/div[2]/div[3]/div[2]/div/input[2]");
    public SelenideElement inputAgregarRegistro = $x("//*[@id=\"botonAgregarRegistro\"]");
    public SelenideElement textareaMotivoCancelacion = $x("//*[@id=\"motivoCancelacion\"]");
    public SelenideElement inputGuardaSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement inputDocumento = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguienteButton = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

}
