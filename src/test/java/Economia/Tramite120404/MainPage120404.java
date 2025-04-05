package Economia.Tramite120404;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120404 {

    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement cuposImpExp = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement asignacionDirecta = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/a");
    public SelenideElement ampliacionPersonaM = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/ul/li[2]/a");
    public SelenideElement asignacion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement ampliacionMonto = $x("//*[@id=\"TIASD.AM\"]");
    public SelenideElement añoOficio = $x("//*[@id=\"solicitud.asignacionBusqueda.añoAutorizacion\"]");
    public SelenideElement numOficio =$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[5]/div[2]/div[2]/input");
    public SelenideElement btnBuscar = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[6]/div/input");
    public SelenideElement montoAmpliar = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[12]/input");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");


}
