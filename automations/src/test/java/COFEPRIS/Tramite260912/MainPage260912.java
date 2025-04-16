package COFEPRIS.Tramite260912;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260912 {
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
    public SelenideElement inputSolicitarModificacion = $x("/html/body/main/div/div[4]/div/form[1]/div[6]/div[2]/input[2]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[2]/a/label");
    public SelenideElement inputModif = $x("//*[@id=\"mod\"]");
    public SelenideElement textareaJustificacionId = $x("//*[@id=\"justificacionId\"]");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos =$x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[4]/a/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");

    public SelenideElement inputGuardarSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[2]/div/div/div[2]/input[1]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    //public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    //public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");

}
