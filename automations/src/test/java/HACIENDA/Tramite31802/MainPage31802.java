package HACIENDA.Tramite31802;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage31802 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement inputIdFolio = $x("//*[@id=\"idFolio\"]");
    public SelenideElement inputBuscarButton = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement SolicitudTramite = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputSolicitarModificacion = $x("/html/body/main/div/div[4]/div/form[1]/div[6]/div[2]/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement inputRenovarEsquema = $x("//*[@id=\"renovarEsquemaIC2Button\"]");
    public SelenideElement inputCheckRenov = $x("//*[@id=\"checkRenovacion\"]");
    public SelenideElement labelRenovacion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputFechaPago = $x("//*[@id=\"fechaPagoHR\"]");
    public SelenideElement inputMontoMoneda = $x("//*[@id=\"solicitud.oeaICImpExp.monto\"]");
    public SelenideElement inputNumOperacion = $x("//*[@id=\"solicitud.oeaICImpExp.operacionesBancarias\"]");
    public SelenideElement inputLlavePago = $x("//*[@id=\"solicitud.oeaICImpExp.llavePago\"]");
    public SelenideElement inputManifiestoVerdad = $x("//*[@id=\"acepto3069\"]");
    public SelenideElement inputManifiestoAnterior = $x("//*[@id=\"acepto3070\"]");
    public SelenideElement inputProtestaVerdad = $x("//*[@id=\"acepto3061\"]");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    //ADJUNTAR
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc8 = $x("/html/body/main/div/div[4]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc9 = $x("/html/body/main/div/div[4]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc10 = $x("/html/body/main/div/div[4]/div[2]/div/form[11]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc11 = $x("/html/body/main/div/div[4]/div[2]/div/form[12]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
