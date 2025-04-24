package HACIENDA.Tramite40403;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage40403 {
    //Tramite 40403
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement CodigoArmonizadoTransportista = $x("//*[@id=\"servicios\"]/ul/li[5]/a/span");
    public SelenideElement RegistroCodigoAereo = $x("//*[@id=\"servicios\"]/ul/li[5]/ul/li[4]/a/span");
    public SelenideElement Tramite40403= $x("//*[@id=\"servicios\"]/ul/li[5]/ul/li[4]/ul/li[3]/a");

    //Paso 1
    //Pestaña Datos del trámite
    public SelenideElement TabDatosTramite = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement CodigoCAAT = $x("//*[@id=\"claveFolioCAAT\"]");
    public SelenideElement btnBuscarCAAT = $x("//*[@id=\"buscarSolicitudPorCAAT\"]");

    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
