package SENER.Tramite300105;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage300105 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Sener = $x("/html/body/main/div/div[3]/div/form/a[11]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement linkAutComExtFueRadIon = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li/a");
    public SelenideElement linkAutImpExpRayosX = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li/ul/li/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement inputNumeroCertificado = $x("//*[@id='numeroCertificado']");
    public SelenideElement inputTipoOperacion = $x("//*[@id='tipoOperacion']");
    public SelenideElement inputFinalidad = $x("//*[@id='finalidadMovimiento']");
    public SelenideElement inputExento = $x("//*[@id='isExento']");
    public SelenideElement inputAutorizacion = $x("//*[@id='isAutorizacion']");
    public SelenideElement inputNumeroAuto1 = $x("//*[@id='numAutorizacion1']");
    public SelenideElement inputNumeroAuto2 = $x("//*[@id='numAutorizacion2']");
    public SelenideElement inputNumeroAuto3 = $x("//*[@id='numAutorizacion3']");
    //INFORAYOSX
    public SelenideElement btnAgregarRayosX = $x("//*[@id='btn-agregar-rayosX']");
    public SelenideElement inputNumeroEquipos = $x("//*[@id='numeroEquipos']");
    public SelenideElement inputMarca = $x("//*[@id='marca']");
    public SelenideElement inputModelo = $x("//*[@id='modelo']");
    public SelenideElement inputVoltajeRayos = $x("//*[@id='voltajeRayosX']");
    public SelenideElement selectUnidadMedidaVoltaje = $x("//*[@id='unidadMedidaVoltaje']");
    public SelenideElement inputCorrienteRayos = $x("//*[@id='corrienteRayosX']");
    public SelenideElement selectUnidadMedidaCorriente = $x("//*[@id='unidadMedidaCorriente']");
    public SelenideElement selectFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputSerie = $x("//*[@id='serie']");
    public SelenideElement inputAgregarSerie = $x("//*[@id='btnAgregarSerie']");
    public SelenideElement inputAgregarRayos = $x("//*[@id='btnAgregarRayosX']");
    public SelenideElement textareaObservaciones2 = $x("//*[@id='observaciones']");
    public SelenideElement selectAduanas = $x("//*[@id='select1Aduanas']");
    public SelenideElement inputAdd = $x("//*[@id='add']");
    //TERCEROS
    public SelenideElement labelTercerosRelacionados = $x("//label[contains(@for, 'elacionados')]");
    public SelenideElement inputAgregarDes = $x("//*[@id='btnAgregarDes']");
    public SelenideElement inputDenominacionRazon = $x("//*[@id='denominacionRazon']");
    public SelenideElement textareaDomicilio = $x("//*[@id='domicilio']");
    public SelenideElement selectPaisExtranjero = $x("//*[@id='cvePaisExtranjero']");
    public SelenideElement inputCorreo = $x("//*[@id='correo']");
    public SelenideElement inputPaginaWeb = $x("//*[@id='paginaWeb']");
    public SelenideElement selectTipoMercancia = $x("//*[@id='tipoMercancia']");
    public SelenideElement inputRelacionarMer = $x("//*[@id='btnRelacionarMer']");
    public SelenideElement inputAgregarTerceros = $x("//*[@id='btnAgregarTerceros']");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("//label[@for='captura.tab.pagoDerechos']");
    public SelenideElement inputCveBanco = $x("//*[@id='cveBanco']");
    public SelenideElement inputLlavePago = $x("//*[@id='keyPago']");
    public SelenideElement inputFechaPago = $x("//*[@id='fechaPago']");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
