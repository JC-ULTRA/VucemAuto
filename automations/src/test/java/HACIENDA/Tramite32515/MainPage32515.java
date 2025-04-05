package HACIENDA.Tramite32515;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32515 {

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
    public SelenideElement avisoSeguroGlobalT = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[15]/a");
    /// INFORMACION GENERAL
    public SelenideElement tipoAviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement ingresosAcumulables = $x("//*[@id=\"ingAcumulables\"]");
    public SelenideElement capitalSocial = $x("//*[@id=\"capSocial\"]");
    public SelenideElement rfcRepresentante = $x("//*[@id=\"rfcRL\"]");
    public SelenideElement nombreRepresentante = $x("//*[@id=\"nombreRL\"]");
    public SelenideElement apellidoPRepresentante = $x("//*[@id=\"paternoRL\"]");
    public SelenideElement apellidoMRepresentante = $x("//*[@id=\"maternoRL\"]");
    public SelenideElement telefonoRepresentante = $x("//*[@id=\"telefono\"]");
    public SelenideElement correoRepresentante = $x("//*[@id=\"email\"]");
    /// SEGUROS
    public SelenideElement fechaInicioVigenciaS = $x("//*[@id=\"fecIniVigS\"]");
    public SelenideElement selecFechaIS = $x("/html/body/div[10]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFinVigenciaS = $x("//*[@id=\"fecFinVigS\"]");
    public SelenideElement selecFechaFS = $x("/html/body/div[10]/table/tbody/tr[5]/td[3]/a");
    public SelenideElement numPolizaS = $x("//*[@id=\"noPolizaSeg\"]");
    public SelenideElement costoTotalS = $x("//*[@id=\"costSegGlobal\"]");
    public SelenideElement valorMercanciasS = $x("//*[@id=\"valMerc\"]");
    public SelenideElement factorAplicableS = $x("//*[@id=\"factorAplicable\"]");
    /// Aseguradora
    public SelenideElement rfcAseguradora = $x("//*[@id=\"rfcC\"]");
    public SelenideElement razonAseguradora = $x("//*[@id=\"razonsocial\"]");
    public SelenideElement estadoAseguradora = $x("//*[@id=\"solicitud.direccionST.entidadFederativa.clave\"]");
    public SelenideElement municipioAseguradora = $x("//*[@id=\"solicitud.direccionST.delegacionMunicipio.clave\"]");
    public SelenideElement coloniaAseguradora = $x("//*[@id=\"solicitud.direccionST.colonia.clave\"]");
    public SelenideElement localidadAseguradora = $x("//*[@id=\"localidad\"]");
    public SelenideElement calleAseguradora = $x("//*[@id=\"calle\"]");
    public SelenideElement numExtAseguradora = $x("//*[@id=\"numExterior\"]");
    public SelenideElement numIntAseguradora = $x("//*[@id=\"numeroLetraInterior\"]");
    public SelenideElement codigoPostalAseguradora = $x("//*[@id=\"codigoPostal\"]");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[10]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");

}
