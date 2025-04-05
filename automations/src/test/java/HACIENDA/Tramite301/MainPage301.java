package HACIENDA.Tramite301;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPage301 {
    //Tramite Aviso B8 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("//*[@id=\"servicios\"]/ul/li[4]/a");
    public SelenideElement t301 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[1]/a");
    public SelenideElement tipoAviso = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement btnIni = $x("//*[@id=\"iniciarTomaMuestra\"]");
    public SelenideElement optionNo = $x("//*[@id=\"comboTramiteRealizado\"]");
    public SelenideElement fAranc = $x("//*[@id=\"comboFraccionConcatenada\"]");
    public SelenideElement nico = $x("//*[@id=\"comboNicos\"]");
    public SelenideElement name = $x("//*[@id=\"textNombreQuimico\"]");
    public SelenideElement nameComer = $x("//*[@id=\"textNombreComercial\"]");
    public SelenideElement CAS = $x("//*[@id=\"textNumeroCas\"]");
    public SelenideElement estadoF = $x("//*[@id=\"ideGenerica1\"]");
    public SelenideElement estado = $x("//*[@id=\"textDescClobGenerica1\"]");
    public SelenideElement pagoDer = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement lineaPago = $x("//*[@id=\"lineaCaptura\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"agregar\"]");
    public SelenideElement btnConti = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement checkDoc = $x("//*[@id=\"cb_jqgridDoctosEspecificos\"]");
    public SelenideElement elimiDoc = $x("//*[@id=\"deleteButton\"]");
    public SelenideElement btnConti2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"docs\"]/tbody/tr[6]/td[2]/div/input[2]");
    public SelenideElement doc1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement doc3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnUpDocs = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@name=\"Cerrar\"]");
    public SelenideElement btnConti3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnIngresFs = $x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //Solo Firma Funcionario
    public SelenideElement cerfF = $x("//*[@id='certificate']");
    public SelenideElement keyfF = $x("//*[@id='privateKey']");
    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");

    //ProcesoRegistroRecepcionMuestras
    public SelenideElement InicioA = $x("//*[@id=\"tablaMenuLateral\"]/tbody/tr[2]/td/a/img");
    public SelenideElement FolioA = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioA = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdRecepcionMuestras = $x("//*[@id=\"1\"]/td[4]");
    public SelenideElement estRecep = $x("//*[@id=\"comboEstatusRecepcion\"]");
    public SelenideElement btnSig = $x("//*[@id=\"siguiente\"]");

    //ProcesoREvaluarSolicitudGenDictamen
    public SelenideElement InicioB = $x("//*[@id=\"tablaMenuLateral\"]/tbody/tr[2]/td/a/img");
    public SelenideElement FolioB = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioB = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tamite = $x("//*[@id=\"1\"]/td[4]");
    public SelenideElement genDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btnConti4 = $x("//*[@id=\"acciones\"]/input");
    public SelenideElement checkAcep = $x("//*[@id=\"checkSentidoDictamen\"]");
    public SelenideElement justDict = $x("//*[@id=\"valueTA\"]");
    public SelenideElement aniosPlazo = $x("//*[@id=\"plazoAnio\"]");
    public SelenideElement btnConti5 = $x("//*[@id=\"acciones\"]/input[3]");

    public SelenideElement oficioTex = $x("//*[@id=\"textoLibre[0]\"]");
    public SelenideElement asuntoTex = $x("//*[@id=\"textoLibre[1]\"]");
    public SelenideElement tex1 = $x("//*[@id=\"textoLibre[2]\"]");
    public SelenideElement tex2 = $x("//*[@id=\"textoLibre[3]\"]");
    public SelenideElement tex3 = $x("//*[@id=\"textoLibre[4]\"]");
    public SelenideElement tex4 = $x("//*[@id=\"textoLibre[4]\"]");
    public SelenideElement tex5 = $x("//*[@id=\"textoLibre[4]\"]");

    public SelenideElement tex6 = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[33]/td[2]/span/textarea");
    public SelenideElement tex7 = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[34]/td[2]/span/textarea");
    public SelenideElement tex8 = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[35]/td[2]/span/textarea");
    public SelenideElement tex9 = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[36]/td[2]/span/textarea");
    public SelenideElement tex10 = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[37]/td[2]/span/textarea");
    public SelenideElement textAtentamente = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td[2]/table/tbody/tr[39]/td[2]/span/textarea");
    public SelenideElement btnGuarFirm = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input[1]");





























}