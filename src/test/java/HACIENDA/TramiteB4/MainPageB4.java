package HACIENDA.TramiteB4;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPageB4 {
    //Firma y Path del Trámite
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement B4 = $x("//a[contains(@onclick, 'ranja')]");
    public SelenideElement tipoAviso = $x("//*[@id='ui-id-2']");

    //Aviso
    public SelenideElement nRegister = $x("//*[@id='numRegistro']");

    //Datos del Donante Exterior
    public SelenideElement nomDomRSocial = $x("//*[@id='donante.razonSocial']");
    public SelenideElement rcfFax = $x("//*[@id='donante.rfcotaxid']");
    public SelenideElement tel = $x("//*[@id='donante.telefono']");
    public SelenideElement mail = $x("//*[@id='donante.email']");

    //Domicilio Fiscal del Donante Extranjero
    public SelenideElement entidadFed = $x("//*[@id='solicitud.donante.domicilio.entidadFederativa.clave']");
    public SelenideElement alcalMun = $x("//*[@id='solicitud.donante.domicilio.delegacionMunicipio.clave']");
    public SelenideElement colonia = $x("//*[@id='solicitud.donante.domicilio.colonia.clave']");
    public SelenideElement codPost = $x("//*[@id='domicilioD.codigoPostal']");
    public SelenideElement calle = $x("//*[@id='domicilioD.calle']");
    public SelenideElement numLetEx = $x("//*[@id='domicilioD.numeroExterior']");
    public SelenideElement numLetInt = $x("//*[@id='domicilioD.numeroInterior']");
    public SelenideElement entreCalle1 = $x("//*[@id='domicilioD.entreCalle1']");
    public SelenideElement entreCalle2 = $x("//*[@id='domicilioD.entreCalle2']");

    //Carga Plantilla
    public SelenideElement checkCarMas = $x("//*[@id='idTipoCarga2']");
    public SelenideElement cargaDocMas = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement btnCarga = $x("//*[@id='cargarArchivoDatosAviso']");
    public SelenideElement btnConti1 = $x("//*[@id='guardarSolicitud']");
    public SelenideElement btnConti2 = $x("//input[@value='Continuar']");

    //Carga doc y firma
    public SelenideElement adjuntDoc = $x("//input[contains(@style, '0px;')]");
    public SelenideElement doc1 = $x("//input[@name='documentos[0].file']");
    public SelenideElement doc2 = $x("//input[@name='documentos[1].file']");
    public SelenideElement btnADJ = $x("//*[@id='btnAnexar']");
    public SelenideElement btnCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement btnConti3 = $x("//*[@id='siguienteButton']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");



}
