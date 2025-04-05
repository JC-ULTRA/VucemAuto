package HACIENDA.Tramite32514;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32514 {

    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement envioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement avisoRetornoVehiculosE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[14]/a");
    /// INFORMACION GENERAL
    public SelenideElement tipoAviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement residenteNacionalCheckBx = $x("//*[@id=\"idTipoResidente\"]");
    public SelenideElement permisoInternacional = $x("//*[@id=\"idRGCE1\"]");
    public SelenideElement numInternacioanlTemp = $x("//*[@id=\"numeroInterTem\"]");
    public SelenideElement fechaEmision = $x("//*[@id=\"fechaEmision\"]");
    public SelenideElement selecFechaEmision = $x("/html/body/div[6]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaVencimiento = $x("//*[@id=\"fechaVencimiento\"]");
    public SelenideElement selecFechaV = $x("/html/body/div[6]/table/tbody/tr[5]/td[3]/a");
    public SelenideElement numPedimento = $x("//*[@id=\"pedimento\"]");
    public SelenideElement fechaPedimento = $x("//*[@id=\"fechaPedimento\"]");
    public SelenideElement selecFechaPedimento = $x("/html/body/div[6]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement presentadoSi = $x("//*[@id=\"presentaSi\"]");
    /// Vehiculo
    public SelenideElement marcaVehiculo = $x("//*[@id=\"marca\"]");
    public SelenideElement tipoVehiculo = $x("//*[@id=\"tipo\"]");
    public SelenideElement modeloVehiculo = $x("//*[@id=\"modelo\"]");
    public SelenideElement nivVehiculo = $x("//*[@id=\"vin\"]");
    public SelenideElement placaVehiculo = $x("//*[@id=\"numeroPlacas\"]");
    public SelenideElement estadoEmisor = $x("//*[@id=\"txtEstado\"]");

    public SelenideElement protestaNo = $x("//*[@id=\"protestaNo\"]");
    public SelenideElement fechaAcuse = $x("//*[@id=\"fecAcuseRImpoTemIA\"]");
    public SelenideElement selecFechaAcuse = $x("/html/body/div[6]/table/tbody/tr[1]/td[3]/a");
    public SelenideElement razonesImportacion = $x("//*[@id=\"razonesImpoTemIA\"]");
    public SelenideElement tipoTransporte = $x("//*[@id=\"solicitud.vehiculo.ideTipoVehiculo\"]");
    public SelenideElement numSerieTransporte = $x("//*[@id=\"numeroSerie\"]");


    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");

}
