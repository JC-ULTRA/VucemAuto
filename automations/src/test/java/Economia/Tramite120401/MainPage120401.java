package Economia.Tramite120401;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120401 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id=\"subenlaces\"]/ul/li[5]/a");
    public SelenideElement SoliNew = $x("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("//*[@id=\"workingArea\"]/form/a[2]/img");
    public SelenideElement linkCuposimpExp = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/a");
    public SelenideElement linkAsignacionDirectaCupo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[3]/ul/li[4]/a");
    public SelenideElement linkAsiDirCupPerFis = $x("//*[@id=\"servicios\"]/ul/li[3]/ul/li[4]/ul/li[1]/a");
    public SelenideElement labelAsignacion = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement inputEntidadFederativa = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement inputRepresentacionFed = $x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement inputRegimenAduanero = $x("//*[@id=\"claveRegimen\"]");
    public SelenideElement inputTratadoBloqueComercial = $x("//*[@id=\"idTratadoAcuerdo\"]");
    public SelenideElement inputNombreProducto = $x("//*[@id=\"producto\"]");
    public SelenideElement inputNombreSubproducto = $x("//*[@id=\"subproducto\"]");
    public SelenideElement btnBuscarCupos = $x("//*[@id=\"buscarCupos\"]");
    public SelenideElement inputCantidadSoicitada = $x("//*[@id=\"tabs-3\"]/div[2]/div[17]/div/div/input");
    public SelenideElement inputCuposDisponibles = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div[2]/div[7]/div/div/table/tbody/tr/td/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
