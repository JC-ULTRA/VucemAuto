package HACIENDA.Tramite32608;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32608 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = Selenide.$x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement menuRegistroCE = Selenide.$x("//*[@id=\"servicios\"]/ul/li[4]/a/span");
    public SelenideElement elemTramite32608 = Selenide.$x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[1]/a");
    public SelenideElement tabRegisTomaMercancia = Selenide.$x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement btnIniciar = Selenide.$x("//*[@id=\"iniciarTomaMuestra\"]");
    public SelenideElement listPrevImporExpor = Selenide.$x("//*[@id=\"comboTramiteRealizado\"]");
    public SelenideElement listPrevInscrMuestras = Selenide.$x("//*[@id=\"comboMuestraDespacho\"]");
    public SelenideElement FolioAnterior = Selenide.$x("//*[@id=\"textMotivoFaltaMuestra\"]");
    public SelenideElement listFraccion = Selenide.$x("//*[@id=\"comboFraccionConcatenada\"]");
    public SelenideElement listNico = Selenide.$x("//*[@id=\"comboNicos\"]");
    public SelenideElement NombreQuimico = Selenide.$x("//*[@id=\"textNombreQuimico\"]");
    public SelenideElement NombreComercial = Selenide.$x("//*[@id=\"textNombreComercial\"]");
    public SelenideElement NumeroCAS = Selenide.$x("//*[@id=\"textNumeroCas\"]");
    public SelenideElement listEstadoFis = Selenide.$x("//*[@id=\"ideGenerica1\"]");
    public SelenideElement DescAcondicionamiento = Selenide.$x("//*[@id=\"textDescClobGenerica1\"]");
    public SelenideElement btnContinuar = Selenide.$x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement tabPagoDer = Selenide.$x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement LineaPago = Selenide.$x("//*[@id=\"lineaCaptura\"]");
    public SelenideElement btnAgregar = Selenide.$x("//*[@id=\"agregar\"]");
    public SelenideElement btnContinuar2 = Selenide.$x("//*[@id=\"guardarSolicitud\"]");


    //Paso2
    public SelenideElement listTipoDoc = $x("//*[@id=\"selectDoctosEspecificos\"]");
    public SelenideElement btnEliminar = $x("//*[@id=\"deleteButton\"]");
    public SelenideElement btnAgreNuevo = $x("//*[@id=\"divGridDoctosEsp\"]/div[2]/div[2]/div[2]/div[2]/input[2]");
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");




}
