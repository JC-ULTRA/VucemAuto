package AGRICULTURA.Tramite220503;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage220503 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Agricultura = $x("/html/body/main/div/div[3]/div/form/a[10]/img");
    public SelenideElement LinkCertificadosSolicitudRequisitos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement LinkCertificadoImportInspeccionFisica = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[4]/a");
    public SelenideElement LinkCertificadoSanidadAcuicolaInspeccionFisica = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[4]/ul/li[3]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    public SelenideElement LabelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement selectSolicitudNumAutorizacion = $x("//*[@id=\"solicitud.numAutorizacion\"]");
    public SelenideElement inputSolicitudFechaInspeccion = $x("//*[@id='solicitud.fechaInspeccion']");
    public SelenideElement selectHoraInspeccion = $x("//*[@id='horaInspeccion']");
    public SelenideElement inputPuntoInspeccion = $x("//*[@id=\"solicitud.unidadAdministrativaRepresentacionFederal.clave\"]");
    public SelenideElement inputNombreInsp = $x("//*[@id='nombreInsp']");
    public SelenideElement inputApePater = $x("//*[@id='apePater']");
    public SelenideElement inputApeMater = $x("//*[@id='apeMater']");
    public SelenideElement inputSolicitudNumeroTotalCarros = $x("//*[@id='solicitud.numeroTotalCarros']");

    //public SelenideElement selectSolicitudContenedorClave = $x("//*[@id='solicitud.contenedor.clave']");
    public SelenideElement selectSolicitudTransporteIdeMedio = $x("//*[@id='solicitud.transporte.ideMedioTransporte']");

    public SelenideElement inputIdentificacionTransporte = $x("//*[@id='identificacionTransporte']");

    public SelenideElement inputSolicitudFerros = $x("//*[@id='SiSolicitudFerros']");

    public SelenideElement inputSolicitudFerros2 = $x("//*[@id='NoSolicitudFerros']");
    public SelenideElement inpuCheck = $x("//*[@id=\"jqg_gridSagarpa2205_3\"]");
    public SelenideElement btnSaldoMercancia = $x("//*[@id=\"btnSaldoMercancia\"]");
    public SelenideElement inputCantidadUMT = $x("/html/body/main/div/div[4]/div[2]/form/div[5]/div/div/input");
    public SelenideElement inputModificar = $x("/html/body/main/div/div[4]/div[2]/form/div[6]/div[3]/div/input[2]");
    public SelenideElement btnAceptar = $x("/html/body/div[11]/div[3]/div/button");
    public SelenideElement inputTotalGuia =$x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[2]/div[16]/div[1]/div/input");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");

    public SelenideElement inputAgregarNuevo = $x("//input[@value='Agregar nuevo']");

    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
}
