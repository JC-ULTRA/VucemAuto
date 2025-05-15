package HACIENDA.Tramite32102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32102 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement inputIdFolio = $x("//*[@id=\"idFolio\"]");
    public SelenideElement inputBuscarButton = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement SolicitudTramite = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputModificacion = $x("//*[@id=\"avisoAmpliacionVigenciaButton\"]");
    public SelenideElement labelAmpliacionSolicitante = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement checkAmpliacion = $x("//*[@id=\"acepto3075\"]");
    public SelenideElement checkProtestaVerdad = $x("//*[@id=\"acepto3061\"]");
    public SelenideElement checkEnterado = $x("//*[@id=\"acepto3062\"]");
    public SelenideElement checkRequisitos = $x("//*[@id=\"acepto3074\"]");

    public SelenideElement btnGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement spanAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement spanCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

    public SelenideElement inputSolicitarModificacion = $x("/html/body/main/div/div[4]/div/form[1]/div[6]/div[2]/input");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
