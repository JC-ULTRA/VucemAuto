package AGRICULTURA.Tramite220703;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage220703 {

    //Tramite 220703
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite subsecuente
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar prórroga
    public SelenideElement btnSolicitarProroga = $x("//*[@id=\"prorrogaButton\"]");

    //Paso 1 Capturar la solicitud
    //Pestaña datos de la solicitud
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement Justificacion = $x("//*[@id=\"justificacionId\"]");

    //Pestaña Pago de derechos
    public SelenideElement tabPagoDerechos = $x("//*[@id=\"ui-id-5\"]/label");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement ImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    public SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
