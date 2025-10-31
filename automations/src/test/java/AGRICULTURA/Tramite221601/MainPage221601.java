package AGRICULTURA.Tramite221601;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage221601 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SolicitudSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    //Solicitudes subsecuentes
    public SelenideElement inputFolio = $x("//*[@id='idFolio']");
    //1502200200120250101000016
    public SelenideElement inputBuscarButton = $x("//*[@id='buscarButton']");
    public SelenideElement td = $x("//td[@style='text-align:left;']");
    //public SelenideElement folio = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    //dobleclick

    public SelenideElement linkTabPer = $x("//a[@href='/ventanilla-sagarpa-HA/gubernamentales2/sagarpa/revisionDocumental/consultarSolicitud.action?showDet']");

    public SelenideElement inputModificarButton = $x("//*[@id='modificarButton']");
public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[2]/a/label");
    //*[@id='ui-id-2']
    public SelenideElement textareaJustificacion = $x("//*[@id='justificacionId']");
public SelenideElement labelPAgoDerechos = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[5]/a/label");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");

    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");

    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");

    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");

    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");

    public SelenideElement inputDocumentosFile = $x("//input[@type='file']");
//Lorem

    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuar = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioFun = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[3]");
    public SelenideElement darVoBo = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement firmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[1]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
    public SelenideElement justificacionDictamen = $x("//*[@id=\"valueTA\"]");
    public SelenideElement condicionesDictamen = $x("//*[@id=\"valueTD\"]");
    public SelenideElement selectMercanciaDict = $x("//*[@id=\"jqg_gridMercanciaCITES_1\"]");
    public SelenideElement btnModificarMercanciaDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[8]/table/tbody/tr[3]/td/input");
    public SelenideElement numPermisoOrigen = $x("//*[@id=\"numPermisoOrigen\"]");
    public SelenideElement numCertificadoOrigen = $x("//*[@id=\"numCertificadoProcedenciaCITES\"]");
    public SelenideElement fechaPermisoOrigen = $x("//*[@id=\"fechaPermisoOrigenText\"]");
    public SelenideElement fechaCertificadoOrigen = $x("//*[@id=\"fechaCertificadoProcedenciaCites\"]");
    public SelenideElement apendiceCodigoProcedencia = $x("//*[@id=\"codigoProcedencia\"]");
    public SelenideElement marcas = $x("//*[@id=\"idMarcasCites\"]");
    public SelenideElement btnAgregarMercanciaDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[9]/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a/input");
    public SelenideElement btnGuardarMercancia = $x("/html/body/div[9]/div[3]/div/button[1]");
    public SelenideElement btnAgregarFinalidad = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[9]/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a/input");
    public SelenideElement agregarMovimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[9]/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a/input");
    public SelenideElement finalidadMovimientosTodos = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[9]/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/a/input");
    public SelenideElement numCites = $x("//*[@id=\"valueTA2\"]");
}
