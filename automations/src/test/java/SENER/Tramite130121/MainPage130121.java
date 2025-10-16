package SENER.Tramite130121;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130121 {
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
    public SelenideElement linkPermisoImportExport = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement linkImportacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement linkSolImpHidros = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a");
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


    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[27]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");


    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement justificacionDictamen = $x("//*[@id=\"justificacionDictamen\"]");
    public SelenideElement antecedentesDictamen = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");

}
