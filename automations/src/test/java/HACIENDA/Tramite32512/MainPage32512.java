package HACIENDA.Tramite32512;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage32512 {
    //Tramite 32512
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement CuadroText = $x("//*[@id=\"notification\"]/div");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");

    //Navegación por menús desplegables
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement EnvioAviso = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a/span");
    public SelenideElement Tramite32512 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[6]/ul/li[12]/a");

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña Tipo de Aviso
    public SelenideElement TabTipAviso = Selenide.$x("//*[@id=\"ui-id-2\"]/label");

    //Datos del lugar donde se encuentra la mercancía
    public SelenideElement CondiMateriaMerc = $x("//*[@id=\"nombreComercial\"]");    //*[@id="nombreComercial"]
    public SelenideElement ComboEntidFederati = $x("//*[@id=\"solicitud.direccionStOrigen.entidadFederativa.clave\"]");
    public SelenideElement ComboMuncAlcaldia = $x("//*[@id=\"solicitud.direccionStOrigen.delegacionMunicipio.clave\"]");
    public SelenideElement ComboColonia = $x("//*[@id=\"solicitud.direccionStOrigen.colonia.clave\"]");
    public SelenideElement Calle = $x("//*[@id=\"calle\"]");
    public SelenideElement NumLetraExterior = $x("//*[@id=\"numeroExterior\"]");
    public SelenideElement NumLetraInterior = $x("//*[@id=\"numeroInterior\"]");
    public SelenideElement CPostal = $x("//*[@id=\"codigoPostal\"]");

    //Lugar, fecha y hora donde se llevará a cabo la destrucción de la mercancía
    public SelenideElement ComboEntidFederativ2 = $x("//*[@id=\"solicitud.dpd.entidadFederativa.clave\"]");
    public SelenideElement ComboMuncAlcaldia2 = $x("//*[@id=\"solicitud.dpd.delegacionMunicipio.clave\"]");
    public SelenideElement ComboColonia2 = $x("//*[@id=\"solicitud.dpd.colonia.clave\"]");
    public SelenideElement Calle2 = $x("//*[@id=\"calleDes\"]");
    public SelenideElement NumLetraExterior2 = $x("//*[@id=\"numeroExteriorDes\"]");
    public SelenideElement NumLetraInterior2 = $x("//*[@id=\"numeroInteriorDes\"]");
    public SelenideElement CPostal2 = $x("//*[@id=\"codigoPostalDes\"]");

    //Datos de la mercancía que se destruirá y proceso de destrucción
    public SelenideElement FechaDestrucMerc = $x("//*[@id=\"fechaInicioUsoMerc\"]");
    public SelenideElement HoraDestruc = $x("//*[@id=\"hora\"]");

    //Datos de la mercancía que se destruirá y proceso de destrucción

   public SelenideElement btnSelectArch = $x("//*[@id=\"archivoDestruccion\"]");
    public SelenideElement btnCargarArch = $x("//*[@id=\"adjuntarDestruccion\"]");
    public SelenideElement btnAceptNoti = $x("/html/body/div[8]/div[3]/div/button");
    public SelenideElement btnCont = $x("//*[@id=\"guardarSolicitud\"]");


    //Paso 2 Requisitos necesarios
    public SelenideElement btnContPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement btnFirmarDes = $x("//*[@id='btnSubmit']");
    //Paso 3
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");
    public SelenideElement btnContPaso3 = $x("//*[@id=\"siguienteButton\"]");
    //*[@id="guardarButton"]
    //*[@id="workingArea"]/form/div[4]/div/div/input[2]
    /*public SelenideElement nombreElemento = $x("");
    public SelenideElement nombreElemento = $x("");

*/




    


}
