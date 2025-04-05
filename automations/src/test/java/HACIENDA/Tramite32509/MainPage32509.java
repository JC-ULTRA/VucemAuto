package HACIENDA.Tramite32509;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32509 {

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
    public SelenideElement avisoDestruccionDonacion = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[9]/a");
    public SelenideElement tipoAviso = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement avisoDonacion = $x("//*[@id=\"fusion2\"]");
    public SelenideElement razonAlmacen = $x("//*[@id=\"circunstanciaHechosNombre\"]");
    public SelenideElement rfcAlmacen = $x("//*[@id=\"numPedimentoExportacionRfc\"]");
    public SelenideElement estadoAlmacen = $x("//*[@id=\"solicitud.direccionStOrigenDeposito.entidadFederativa.clave\"]");
    public SelenideElement municipioAlmacen = $x("//*[@id=\"solicitud.direccionStOrigenDeposito.delegacionMunicipio.clave\"]");
    public SelenideElement coloniaAlmacen = $x("//*[@id=\"solicitud.direccionStOrigenDeposito.colonia.clave\"]");
    public SelenideElement calleAlmacen = $x("//*[@id=\"calleAlmacen\"]");
    public SelenideElement numExt = $x("//*[@id=\"numeroExteriorAlmacen\"]");
    public SelenideElement numInt = $x("//*[@id=\"numeroInteriorP\"]");
    public SelenideElement codigoPostalAlmacen = $x("//*[@id=\"codigoPostalAlmacen\"]");
    public SelenideElement folioCartaCupo = $x("//*[@id=\"cartaCupo\"]");
    public SelenideElement numAcuse = $x("//*[@id=\"acuseElectronico\"]");
    public SelenideElement causaDonacion = $x("//*[@id=\"causasDonacion\"]");

    public SelenideElement entidadMercancia = $x("//*[@id=\"solicitud.direccionStOrigenDonacion.entidadFederativa.clave\"]");
    public SelenideElement municipioMercancia = $x("//*[@id=\"solicitud.direccionStOrigenDonacion.delegacionMunicipio.clave\"]");
    public SelenideElement coloniaMercancia = $x("//*[@id=\"solicitud.direccionStOrigenDonacion.colonia.clave\"]");
    public SelenideElement calleMercancia = $x("//*[@id=\"calleD\"]");
    public SelenideElement numExtMerc = $x("//*[@id=\"numeroExteriorD\"]");
    public SelenideElement numIntMerc = $x("//*[@id=\"numeroInteriorD\"]");
    public SelenideElement codigoPostalMercancia = $x("//*[@id=\"codigoPostalD\"]");
    public SelenideElement cantidadMercancia = $x("//*[@id=\"cantidadD\"]");
    public SelenideElement unidadMedida = $x("//*[@id=\"solicitud.mercanciaSTDonacion.unidadMedida.clave\"]");
    public SelenideElement pregunta1 = $x("//*[@id=\"descripcionProceso\"]");
    public SelenideElement pregunta2 = $x("//*[@id=\"descripcionDesperdicio\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[6]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
