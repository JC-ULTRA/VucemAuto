package HACIENDA.Tramite10703;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage10703 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite subsecuente
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar Modificación
    public SelenideElement btnSolModificar = $x("//*[@id=\"modificarButton\"]");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Exención impuestos
    public SelenideElement tabDatosInmueble = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    //Aduana
    public SelenideElement selectAduana = $x("//*[@id=\"tabs-2\"]/div[2]/div[1]/div/select");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");

}
