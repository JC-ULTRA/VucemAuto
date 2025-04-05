package HACIENDA.Tramite30506;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage30506 {

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

    public SelenideElement btnRenovar = $x("//*[@id=\"renovarButton\"]");
    public SelenideElement solicitud = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement banco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavedePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement selecFecha = $x("/html/body/div[2]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement manifiesto1 = $x("//*[@id=\"listaDeclaraciones1\"]");
    public SelenideElement manifiesto2 = $x("//*[@id=\"listaDeclaraciones2\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
