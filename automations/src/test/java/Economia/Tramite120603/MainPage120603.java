package Economia.Tramite120603;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120603 {
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
    public SelenideElement CupoExIm = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement RegistroEmpresComerIndustFront = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[6]/a");
    public SelenideElement Tramite120603 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[6]/ul/li[1]/a");
    public SelenideElement PestDatEmpres = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement Estado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement representacionFederal = $x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement CargarDatosDomicilio = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement TipoEmpresa = $x("//*[@id=\"solicitud.tipoEmpresaRECIF.clave\"]");
    public SelenideElement Especifique = $x("//*[@id=\"ti_espesifique\"]");
    public SelenideElement Clasif = $x("//*[@id=\"actividadEconomica\"]");
    public SelenideElement ClickFuera = $x("//*[@id=\"tabs-2\"]/div[4]/div[1]/div/h2");
    public SelenideElement ClickSi = $x("//*[@id=\"tipoNacionalidadMexicana\"]");
    public SelenideElement RFC = $x("//*[@id=\"ingresoCurp\"]");
    public SelenideElement CheckSi = $x("//*[@id=\"tipoPersonaFisica\"]");
    public SelenideElement btnAgregar = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[8]/div[2]/div/input");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuarArchivos = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");

    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");

    public SelenideElement numOficio = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[4]/td[2]/input");
    public SelenideElement btnGuardarVisita = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[1]/td/input");
    public SelenideElement btnSiguienteOpinion = $x("//*[@id=\"btnGuardar\"]");
    public SelenideElement btnAnexarDocumentos = $x("/html/body/div[1]/div[3]/div[3]/div/form/table[2]/tbody/tr[4]/td[2]/input");
    public SelenideElement doc1AnexarOpinion = $x("/html/body/div[7]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc2AnexarOpinion = $x("/html/body/div[7]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntarOpinion = $x("/html/body/div[7]/div[3]/div/button[1]/span");
    public SelenideElement btnCerrarOpinion = $x("/html/body/div[7]/div[3]/div/button[2]/span");
    public SelenideElement guardarOpinion = $x("/html/body/div[1]/div[3]/div[3]/div/form/table[1]/tbody/tr/td/input[2]");
    public SelenideElement justificacionDictamen = $x("//*[@id=\"justifacionTextarea\"]");
    public SelenideElement btnFirmarDictamen = $x("//*[@id=\"btnFirmar\"]");
    public SelenideElement btnFirmarAutorizar = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[1]/input[3]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}
