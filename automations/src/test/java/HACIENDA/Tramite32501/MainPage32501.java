package HACIENDA.Tramite32501;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32501 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement envioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement avisoImpDivMomMerDesMon = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[1]/a");
    public SelenideElement aviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement inputTipoAvisoImp = $x("//*[@id=\"idTipoAvisoImp\"]");
    public SelenideElement inputTipoAvisoMon = $x("//*[@id=\"idTipoAvisoMon\"]");
    public SelenideElement fracArancelaria = $x("//*[@id='solicitud.mercanciaST.cveFraccionArancelaria']");
    public SelenideElement inputNICO = $x("//*[@id=\"solicitud.mercanciaST.nico\"]");
    public SelenideElement pesoKG = $x("//*[@id=\"solicitud.mercanciaST.peso\"]");
    public SelenideElement valorUSD = $x("//*[@id=\"solicitud.mercanciaST.valorUSD\"]");
    public SelenideElement descripcionMercancia = $x("//*[@id=\"solicitud.mercanciaST.descripcionMercancia\"]");
    public SelenideElement nombreComercial = $x("//*[@id=\"solicitud.direccionST.nombreComercial\"]");
    public SelenideElement entidadFederativa = $x("//*[@id=\"solicitud.direccionST.entidadFederativa.clave\"]");
    public SelenideElement alcaldiaMunicipio = $x("//*[@id=\"solicitud.direccionST.delegacionMunicipio.clave\"]");
    public SelenideElement colonia = $x("//*[@id=\"solicitud.direccionST.colonia.clave\"]");
    public SelenideElement calle = $x("//*[@id=\"solicitud.direccionST.calle\"]");
    public SelenideElement numExt = $x("//*[@id=\"solicitud.direccionST.numeroExterior\"]");
    public SelenideElement numInt = $x("//*[@id=\"solicitud.direccionST.numeroInterior\"]");
    public SelenideElement CodigoPostal = $x("//*[@id=\"solicitud.direccionST.codigoPostal\"]");

    public SelenideElement razonImportador = $x("//*[@id='idRazonSocial']");
    public SelenideElement rfcImportador = $x("//*[@id='idRFC']");
    public SelenideElement taxID = $x("//*[@id='idTaxID']");
    public SelenideElement fracRegla = $x("//*[@id='solicitud.mercanciaST.reglaFraccion']");
    public SelenideElement NICO = $x("//*[@id='idNICO']");
    public SelenideElement marca = $x("//*[@id='idMarca']");
    public SelenideElement fechaImport = $x("//*[@id='idFechaInicioVigencia']");
    public SelenideElement selecFecha = $x("/html/body/div[6]/table/tbody/tr[5]/td[2]/a");
    public SelenideElement numSerie = $x("//*[@id='idNumSerie']");
    public SelenideElement descripcionMerc = $x("//*[@id='idDescMerc']");
    public SelenideElement entidad = $x("//*[@id='solicitud.direccionST.entidadFederativa']");
    public SelenideElement municipio = $x("//*[@id='solicitud.direccionST.delegacionMunicipio']");
    public SelenideElement patenteAgenteA = $x("//*[@id='idPatAutAgeAdu']");
    public SelenideElement rfcAgente = $x("//*[@id='idRfcAgentAdu']");
    public SelenideElement numPedimento = $x("//*[@id='idNumPedimento']");
    public SelenideElement aduanaImp = $x("//*[@id='solicitud.pedimentoST.clave']");
    public SelenideElement manifiesto = $x("//*[@id='manifiesto0']");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnArchivos = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnCargarArch = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[11]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo8 = $x("/html/body/main/div/div[4]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo9 = $x("/html/body/main/div/div[4]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement adjuntarArchivos = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement btnSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}
