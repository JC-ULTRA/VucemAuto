package HACIENDA.Tramite32101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32101 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
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
    public SelenideElement inputAcreditacion = $x("//*[@id=\"avisoAcreditacionButton\"]");
    public SelenideElement labelSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputTipoInversion = $x("//*[@id=\"tipo.inversion.infraestructura\"]");
    public SelenideElement inputValor = $x("//*[@id=\"cantidad.inversion.infraestructura\"]");
    public SelenideElement inputDescripcionGeneral = $x("//*[@id=\"desc.inversion.infraestructura\"]");
    public SelenideElement inputFormaAdquisicion = $x("//*[@id=\"comboFormaAdquisicion.infraestructura\"]");
    public SelenideElement btnAgregarInfraestructura = $x("//*[@id=\"btnAgregarInfraestructura\"]");
    public SelenideElement checkProtestaVerdad = $x("//*[@id=\"acepto3077\"]");
    public SelenideElement checkCumplimiento = $x("//*[@id=\"acepto3074\"]");
    public SelenideElement checkManifiestoSociosAccionistas = $x("//*[@id=\"acepto3078\"]");
    public SelenideElement inputNumOperacion = $x("//*[@id=\"solicitud.pago.referenciaBancaria\"]");
    public SelenideElement inputBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inputLlavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement inputFechaPago = $x("//*[@id=\"calendarTo\"]");


    public SelenideElement btnGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement spanAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement spanCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

}
