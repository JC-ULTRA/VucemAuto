package Economia.Tramite90202;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage90202 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CuposImpoExpo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement linkExpCertifiCupo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/a");
    public SelenideElement linkAmpliacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/a");
    public SelenideElement linkAmpliacionProductoIndirecto = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/ul/li[2]/a");
    public SelenideElement inpuFolioPrograma = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement inputLicitacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputSectorProsecConfirmado = $x("//*[@id=\"sectoresProsecConf\"]");
    public SelenideElement inputFraccionArancelaria = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[7]/div[3]/div/div/input");
    public SelenideElement inputMontoExpedir = $x("//*[@id=\"montoExpedir\"]");
    public SelenideElement btnAgregarCertificacion = $x("//*[@id=\"tabs-2\"]/div/div/div[4]/div[2]/div[3]/div/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btnSiguienteBoton = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement folioDobleclic = $x("//*[@id=\"1\"]/td[1]");
    public SelenideElement clicFuera = $x("//*[@id=\"menu_botones\"]");
    public SelenideElement inputOpcion = $x("//*[@id=\"opcion\"]");
    public SelenideElement justificacionRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[2]/tbody/tr[4]/td/textarea");
    public SelenideElement btnAutorizaDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement primerDecumento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[2]/table/tbody/tr[2]/td[1]/input[5]");
    public SelenideElement inputFechaVisita = $x("//*[@id=\"fechaVisitaSE\"]");
    public SelenideElement btnGuardarO = $x("//*[@id=\"btnGuardar\"]");
    //Opinion
    public SelenideElement inputAceptada = $x("//*[@id=\"idAceptada\"]");
    public SelenideElement inputDescribirOpinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement inputAgregarDoc = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[1]/td[2]/input");
    public SelenideElement inputDoc = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement inputCargarArchivo = $x("//*[@id=\"cargaArchivo\"]");
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[1]/input");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
}