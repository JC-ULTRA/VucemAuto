package Economia.Tramite120601;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120601 {

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
    public SelenideElement CupoExIm = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/a");
    public SelenideElement RegistroEmpresComerIndustFront = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/ul/li[6]/a");
    public SelenideElement Tramite120601 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/ul/li[6]/ul/li[1]/a");
    public SelenideElement PestDatEmpres = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement Estado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
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
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnPasarFirma = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement sentidoAceptado = $x("//*[@id=\"sentidoDictamen\"]");
    public SelenideElement antecedentesDict = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement btnFirmarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[1]");
    public SelenideElement btnAutorizar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[2]");
    //Requerimiento
    public SelenideElement capturaRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[1]/a");
    public SelenideElement justificacionRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[1]/table/tbody/tr[5]/td/textarea");
    public SelenideElement seleccionarDocumentos = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[2]/a");
    public SelenideElement primerDecumento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[2]/table/tbody/tr[2]/td[1]/input[5]");
    //confirmar
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioInicio = $x("//*[@id=\"buscarTareasSolicitante\"]");
    public SelenideElement tablaFolio = $x("/html/body/main/div/div[3]/div/form/div[4]/div[3]/div[3]/div/table");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
    public SelenideElement solicitudes = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[4]/a");
    public SelenideElement idSolicitud = $x("/html/body/main/div/div[3]/div/form/div[3]/div[2]/input");
    public SelenideElement btnBuscarIdSolicitud = $x("/html/body/main/div/div[3]/div/form/div[6]/div/input");
    //Visita
    public SelenideElement numOficioVisita = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[4]/td[2]/input");
    public SelenideElement archivo1Visita = $x("/html/body/div[10]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2Visita = $x("/html/body/div[10]/div[2]/div/form[2]/table/tbody/tr[2]/td[4]/input");
    public SelenideElement justificacionDict = $x("//*[@id=\"justifacionTextarea\"]");
    public SelenideElement justificacionObser = $x("//*[@id=\"observacionId\"]");
    public SelenideElement rfcCapturista = $x("/html/body/main/div/div[1]/div[2]/div/div[1]/form/div[2]/div[2]/select");

}
