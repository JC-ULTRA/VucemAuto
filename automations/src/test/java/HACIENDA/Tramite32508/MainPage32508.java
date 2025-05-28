package HACIENDA.Tramite32508;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32508 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement envioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement aprovechamientoRecintosFiscalizado = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[8]/a");

    public SelenideElement aviso = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement claveRecinto = $x("//*[@id=\"claveRecinto\"]");
    public SelenideElement disminucion = $x("//*[@id=\"disminucion\"]");
    public SelenideElement compensacion = $x("//*[@id=\"compensacion\"]");
    public SelenideElement disminucionCompensacion = $x("//*[@id=\"disminucionCompesacion\"]");

    public SelenideElement rfcCpi = $x("//*[@id=\"rfc\"]");
    public SelenideElement numeroInscripcion= $x("//*[@id=\"numeroInscripcion\"]");
    public SelenideElement añoPeriodoReportado = $x("//*[@id=\"anioPeriodo\"]");
    public SelenideElement mesPeriodoReportado = $x("//*[@id=\"mesPeriodo\"]");
    public SelenideElement fechaElaboracionDictamen = $x("//*[@id=\"fecElaboracion\"]");
    public SelenideElement pagoAprovechamiento = $x("//*[@id=\"pagoAprovechamientoSi\"]");
    public SelenideElement aprovechamiento = $x("//*[@id=\"aprovechamientoSi\"]");
    public SelenideElement saldoPendienteCompensarAnterior = $x("//*[@id=\"saldoCompensarAnterior\"]");
    public SelenideElement saldoPendienteDisminuirAnterior = $x("//*[@id=\"saldoDisminuirAnterior\"]");
    public SelenideElement aprovechamientoCargo = $x("//*[@id=\"aprovechamientoTotal\"]");
    public SelenideElement compensacionAplicada = $x("//*[@id=\"compensacionAplicada\"]");
    public SelenideElement disminucionAplicada = $x("//*[@id=\"disminucionAplicada\"]");
    public SelenideElement saldoPendienteCompensar = $x("//*[@id=\"saldoCompensar\"]");
    public SelenideElement saldoPendienteDisminuir = $x("//*[@id=\"saldoDisminuir\"]");
    public SelenideElement cantidadPagada = $x("//*[@id=\"cantidadPagada\"]");
    public SelenideElement llavedePago = $x("//*[@id=\"llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"fechPago\"]");

    public SelenideElement archivoDisminucion = $x("//*[@id=\"archivoDisminucion\"]");
    public SelenideElement cargarArchivoDisminucion = $x("//*[@id=\"adjuntarDisminucion\"]");
    public SelenideElement btnAceptarCarga = $x("/html/body/div[8]/div[3]/div/button");



    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
