package HACIENDA.Tramite32401;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32401 {
    public SelenideElement cerS = $x("/html/body/form/div[1]/table/tbody/tr[2]/td/input");
    public SelenideElement keyS = $x("/html/body/form/div[1]/table/tbody/tr[4]/td/input");
    public SelenideElement pass = $x("/html/body/form/div[1]/table/tbody/tr[6]/td/input");
    public SelenideElement btnIngresFs = $x("/html/body/form/div[1]/table/tbody/tr[7]/td/input");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement consultas = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[3]/td/a/img");
    public SelenideElement despliegaConsultas = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/a");
    public SelenideElement requerimientoAutoridad = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[20]/a");
    public SelenideElement selecTipoRequerimiento = $x("//*[@id=\"requerimiento_0\"]");
    public SelenideElement rfcBusqueda = $x("//*[@id=\"rfcFiltro\"]");
    public SelenideElement tipoTramite = $x("//*[@id=\"listaTramitesAgace\"]");
    public SelenideElement numeroFolio = $x("//*[@id=\"folioTramiteFiltro\"]");
    public SelenideElement buscarFolio = $x("//*[@id=\"btnAgregarDep\"]");
    public SelenideElement selecTramite = $x("/html/body/main/div/div[4]/div/form[2]/div[5]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    /// Capturar requerimento
    public SelenideElement capturarRequerimento = $x("/html/body/main/div/div[4]/div/form[1]/div[3]/ul/li[1]");
    public SelenideElement tipoRequerimento = $x("//*[@id=\"alcanceRequerimientoId\"]");
    public SelenideElement justificacionRequerimento = $x("/html/body/main/div/div[4]/div/form[1]/div[3]/div/div[1]/div[3]/div/textarea");

    public SelenideElement seleccionarDocumentos = $x("/html/body/main/div/div[4]/div/form[1]/div[3]/ul/li[2]/a");
    public SelenideElement tipoDocumentos = $x("//*[@id=\"selectDoctosEspecificos\"]");
    public SelenideElement agregarNuevoDoc = $x("/html/body/main/div/div[4]/div/form[1]/div[3]/div/div[2]/div/div[4]/div[2]/div/input");
    public SelenideElement btnContinuarRequerimento = $x("//*[@id=\"mostrarFirmaId\"]");

    public SelenideElement btnGuardarSoli = $x("/html/body/main/div/div[4]/div/form/div[1]/input[1]");
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
