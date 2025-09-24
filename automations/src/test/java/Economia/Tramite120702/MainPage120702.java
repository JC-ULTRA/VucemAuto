package Economia.Tramite120702;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120702 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement expedicionTab = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement añoAsignacion = $x("//*[@id=\"solicitud.asignacion.añoAutorizacion\"]");
    public SelenideElement bumAsignacion = $x("//*[@id=\"numFolioAsignacion\"]");
    public SelenideElement btnBuscarOficio = $x("//*[@id=\"btnBuscarAnioOficioAsig\"]");
    public SelenideElement montoExpedir = $x("//*[@id=\"montoExpedir\"]");
    public SelenideElement btnAgregarMonto = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[22]/div/div/input");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

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
