package HACIENDA.Tramite33201;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage33201 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement avisoAnexo = $x("//*[@id=\"autorizacionAnexoVeintiochoEsquemaIC2Button\"]");
    public SelenideElement tipoAviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    /// Solicitud
    public SelenideElement solicitud = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement checkbox1 = $x("//*[@id=\"regimen_0\"]");
    public SelenideElement checkbox2 = $x("//*[@id=\"regimen_1\"]");
    public SelenideElement checkbox3 = $x("//*[@id=\"regimen_2\"]");
    public SelenideElement checkbox4 = $x("//*[@id=\"regimen_3\"]");
    public SelenideElement certificacionSi = $x("//*[@id=\"si479\"]");
    public SelenideElement immexSi = $x("//*[@id=\"si480\"]");
    public SelenideElement importaciones80Si = $x("//*[@id=\"si481\"]");
    public SelenideElement valorImportaciones = $x("//*[@id=\"montoTotal\"]");
    public SelenideElement retotnosValorComercial = $x("//*[@id=\"retornoValorComercial\"]");
    public SelenideElement retornosAduana = $x("//*[@id=\"retornoValorAduana\"]");
    public SelenideElement retornosPorcentaje = $x("//*[@id=\"retornoPorcentaje\"]");
    public SelenideElement transferenciasValorComercial = $x("//*[@id=\"transferenciaValorComercial\"]");
    public SelenideElement transferenciasAduana = $x("//*[@id=\"transferenciaValorAduana\"]");
    public SelenideElement transferenciasPorcentaje = $x("//*[@id=\"transferenciaPorcentaje\"]");
    public SelenideElement desperdiciosValorComercial = $x("//*[@id=\"desperdiciosValorComercial\"]");
    public SelenideElement desperdiciosAduana = $x("//*[@id=\"desperdiciosValorAduana\"]");
    public SelenideElement desperdiciosPorcentaje = $x("//*[@id=\"desperdiciosPorcentaje\"]");
    public SelenideElement constanciasValorComercial = $x("//*[@id=\"constanciasValorComercial\"]");
    public SelenideElement constanciasAduana = $x("//*[@id=\"constanciasValorAduana\"]");
    public SelenideElement constanciasPorcentajes = $x("//*[@id=\"constanciasPorcentaje\"]");
    public SelenideElement cargaProveedoresNacionales = $x("//*[@id=\"archivoNacionales\"]");
    public SelenideElement btnCargarProveedoresN = $x("//*[@id=\"uploadArchivoNacionales\"]");
    public SelenideElement btnOkProveedoresNacionales = $x("/html/body/div[11]/div[3]/div/button");
    public SelenideElement manifiestoOk = $x("//*[@id=\"empresa_4\"]");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnAdjuntar1Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivoUnico = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");

}
