package HACIENDA.Tramite570102;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage570102 {

    //Tramite 40403
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Seleccionar desestimiento al tramite
    public SelenideElement btnDesestimiento = $x("//*[@id=\"desistimientoButton\"]");
    //Desestimiento
    //Solicitud
    public SelenideElement tabSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement MotivoDesistimiento = $x("//*[@id=\"motivoDes\"]");

    //GUardar y firmar Desistimiento
    public SelenideElement btnGuardarFirmar = $x("//*[@id=\"guardarSolicitud\"]");

    //Notificacion
    public SelenideElement btnSiNotificacionDes = $x("/html/body/div[8]/div[3]/div/button[1]");
    public SelenideElement btnNoNotificacionDes = $x("/html/body/div[8]/div[3]/div/button[2]");

    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
