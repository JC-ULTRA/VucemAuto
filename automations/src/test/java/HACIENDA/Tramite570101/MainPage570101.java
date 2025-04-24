package HACIENDA.Tramite570101;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage570101 {

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

    //Datos generales original
    public SelenideElement tabDatosGeneralesOriginal = $x("//*[@id=\"tabPer0-3\"]/label");
    public SelenideElement panelFechasDentroDelPeriodo = $x("//*[@id=\"btnPanel\"]");
    //Personas responsables del despacho
    public SelenideElement checkPersonaDespacho = $x("//*[@id=\"jqgh_gridPersonas_cb\"]");
    public SelenideElement btnSolicitarCancelacion = $x("/html/body/main/div/div[4]/div/form[1]/div[6]/div[2]/input");

    //Paso1
    //Tab Datos de la solicitud
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement comboTipoCancelacion = $x("//*[@id=\"tipoCancelacion\"]");
    public SelenideElement MotivoCancelacion = $x("//*[@id=\"motivo\"]");
    public SelenideElement btnGuardarFirmar = $x("//*[@id=\"guardarSolicitud\"]");
    //Notificacion
    public SelenideElement btnSiCancelarFolio = $x("/html/body/div[8]/div[3]/div/button[1]");
    public  SelenideElement btnNoCancelarFolio = $x("/html/body/div[8]/div[3]/div/button[2]");



    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
