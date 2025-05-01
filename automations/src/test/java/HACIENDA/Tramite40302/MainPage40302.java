package HACIENDA.Tramite40302;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage40302 {

    //Tramite 40302
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement CodigoArmonizadoTransportista = $x("//*[@id=\"servicios\"]/ul/li[5]/a/span");
    public SelenideElement RegistroCodigoNavieroBuque = $x("//*[@id=\"servicios\"]/ul/li[5]/ul/li[3]/a/span");
    public SelenideElement elementoTramite40302= $x("//*[@id=\"servicios\"]/ul/li[5]/ul/li[3]/ul/li[2]/a");

    //Paso 1
    //Pestaña Datos del trámite
    public SelenideElement Scroll = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement TabDatosTramite = $x("//*[@id=\"ui-id-2\"]/label");

    //Nombre del director general
    public SelenideElement Nombre = $x("//*[@id=\"nombreDirectorGeneral\"]");
    public SelenideElement ApellidoPaterno = $x("//*[@id=\"apellidoPaternoDirectorGeneral\"]");
    public SelenideElement ApellidoMaterno = $x("//*[@id=\"apellidoMaternoDirectorGeneral\"]");

    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
