package HACIENDA.Tramite202;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage202 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement AutorizacionesPrestadorServicio = $x("//*[@id=\"servicios\"]/ul/li[3]/a/span");
    public SelenideElement elementoTramite202 = $x("//*[@id=\"servicios\"]/ul/li[3]/ul/li[1]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Maniobras Mercancías
    public SelenideElement tabManiobrasMerca = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    //Datos del trámite
    public SelenideElement checkDeclaracion = $x("//*[@id=\"manifiesto0\"]");
    public SelenideElement selectAduana = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[2]/td/select");
    public SelenideElement btnSiguientePaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]/span");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]/span");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");


}
