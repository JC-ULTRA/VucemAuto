package HACIENDA.Tramite420102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage420102 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement inbal = $x("/html/body/main/div/div[3]/div/form/a[8]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkInba04001 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
    public SelenideElement linkAviImpExpObrArtSigXXyXXI = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement inputRFC = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscarRelacion\"]");
    public SelenideElement radioContibuyente = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnGuardar = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAceptar = $x("/html/body/div[8]/div[3]/div/button[1]");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement capturaRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[1]/a");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
    public SelenideElement seleccionarDocumentos = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/ul/li[2]/a");
    public SelenideElement primerDecumento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[4]/div[2]/table/tbody/tr[2]/td[1]/input[5]");
    public SelenideElement inputDictamenAceptado = $x("//*[@id=\"sentidoDictamen\"]");
    //Autorización
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
}