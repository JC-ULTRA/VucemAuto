package HACIENDA.Tramite6001;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPage6001 {
    //Firma soli 6001
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarF = $x("//*[@id='btnSubmit']");


    //Firma y Path del Trámite
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement Cuentas = $x("//*[@id=\"servicios\"]/ul/li[10]/a");
    public SelenideElement CuentasBancarias = $x("//*[@id=\"servicios\"]/ul/li[10]/ul/li/a");

    //Captura de la solicitud
    public SelenideElement tdDespachosAduanalesAlcantara = $x("/html/body/main/div/div[4]/div/form/div[2]/div[1]/div/div[2]/fieldset/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement inputAltacuenta = $x("//input[@name='btnAltacuenta']");
    public SelenideElement inputTitularCuenta = $x("//*[@id='txtTitularCuenta']");
    public SelenideElement inputGlowingBorder = $x("//*[@id='txtRfc']");
    public SelenideElement inputNumeroCuenta = $x("//*[@id='txtNumeroCuenta']");
    public SelenideElement selectInstitucion = $x("//*[@id='selectInstitucion']");
    public SelenideElement selectEntidades = $x("//*[@id='selectEntidades']");
    public SelenideElement inputSucursal = $x("//*[@id='txtSucursal']");
    public SelenideElement inputNumeroPlaza = $x("//*[@id='txtNumeroPlaza']");
    public SelenideElement inputGuardarCuenta = $x("//*[@id='btnGuardarCuenta']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    //Obtenermos el folio generado
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");









}
