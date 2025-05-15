package HACIENDA.Tramite31801;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage31801 {
    public SelenideElement cerS = $x("//*[@id='certificate']");

    public SelenideElement keyS = $x("//*[@id='privateKey']");

    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement idFoli = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolioSub = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tramite31801 = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement soliRenov = $x("//*[@id=\"renovarEsquemaIC2Button\"]");

    public SelenideElement pestRenova = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement fechaPagoR = $x("//*[@id=\"fechaPagoHR\"]");
    public SelenideElement montoMonedaNacionalR = $x("//*[@id=\"solicitud.monto\"]");
    public SelenideElement nOperR = $x("//*[@id=\"solicitud.operacionesBancarias\"]");
    public SelenideElement llavePagoR = $x("//*[@id=\"solicitud.llavePago\"]");
    public SelenideElement manif1 = $x("//*[@id=\"acepto3069\"]");
    public SelenideElement manif2 = $x("//*[@id=\"acepto3061\"]");
    public SelenideElement btnContiR = $x("//*[@id=\"guardarSolicitud\"]");

//    public SelenideElement btnContCargaDocR = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
//    public SelenideElement btnAdjuntDocR = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
//    public SelenideElement dco1R = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
//    public SelenideElement btnOk = $x("//*[@id=\"btnAnexar\"]");





}
