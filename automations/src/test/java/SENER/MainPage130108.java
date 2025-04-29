package SENER;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130108 {
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
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement linkPermisoSanitarioImportacionInsumoSalud = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement linkPerSanImpDisMedDesPruLab = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement selectRegimenClave = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement selectClasificacionRegimen = $x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    public SelenideElement inputCortoPlazo = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[6]/div/div[2]/input");
    public SelenideElement TextareaDescripcionMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[7]/div/div/textarea");
    public SelenideElement inputCveFraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    //public SelenideElement inputUMT = $x("//*[@id=\"unidadTarifariaComboId\"]");
    public SelenideElement inputNICO = $x("//*[@id=\"solicitud.mercancia.ideGenerica3\"]");
    public SelenideElement inputCantidadMercancia = $x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFactura = $x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputDescripcion = $x("//*[@id=\"descripcion\"]");
    public SelenideElement inputValorPArtida = $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement btnAgregarPartida = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[14]/div/div/input");
    public SelenideElement btnPaises = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[20]/div/div/div[2]/div[2]/a/input");
    public SelenideElement inputPaisOrigen = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"agregarPaisBloque\"]/input");
    public SelenideElement textareaUsoEspecifico = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[21]/div[1]/textarea");
    public SelenideElement textareaJustificacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[21]/div[2]/textarea");
    public SelenideElement textareaObservaciones = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[22]/div/div/textarea");
    public SelenideElement inputDeclaracion = $x("//*[@id=\"chkman\"]");
    public SelenideElement btnGuarda = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");

    //*[@id="siguienteButton"]
//    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
//    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[10]/td[2]/div/input[2]");
//    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
//    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");


}
