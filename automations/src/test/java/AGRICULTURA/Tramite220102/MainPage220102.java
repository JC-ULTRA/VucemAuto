package AGRICULTURA.Tramite220102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage220102 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Loging
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda Tramite 220102
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Agricultura = $x("//img[contains(@alt, 'Rural')]");
    public SelenideElement certysol = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement RequsitoImpor = $x("//*[@id=\"servicios\"]/ul/li/ul/li[1]/a/span");
    public SelenideElement elementoTramite220102 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[1]/ul/li[1]/a");

    //Pestaña Datos Solicitud
    //Datos Mercancía
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");
    public SelenideElement selectNombreComun = $x("//*[@id=\"mercanciaGrid.idNombreComun\"]");
    public SelenideElement selectNombreCientifico = $x("//*[@id=\"mercanciaGrid.idNombreCientifico\"]");
    public SelenideElement selectUso = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement selectPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement selectTipoProducto = $x("//*[@id=\"mercanciaGrid.tipoProducto.idTipoProductoTipoTramite\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement CantidadUMT = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement CantidadUMC = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement Descripcion = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement btnGuardarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //PASO 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub Paso 3
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
