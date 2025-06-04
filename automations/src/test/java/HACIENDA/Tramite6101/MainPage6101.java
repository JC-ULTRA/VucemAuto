package HACIENDA.Tramite6101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage6101 {

    //Tramite 5601
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda del trámite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    /*
    public SelenideElement InfoValorComercializacion = $x("//div[@id='servicios']//a[contains(text(),'Juntas técnicas de clasificación arancelaria')]");
    public SelenideElement tabCertificaciones = $x("//div[@id='servicios']//a[contains(text(),'Certificaciones')]");
    */
    public SelenideElement JuntasTecnicasArancelarias = $x("//*[@id=\"servicios\"]/ul/li[14]/a/span");
    public SelenideElement SolJuntasTecnicasConsultivas = $x("//*[@id=\"servicios\"]/ul/li[14]/ul/li/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña certificaciones
    public SelenideElement tabSolicitud = $x("//*[@id=\"ui-id-2\"]");   //*[@id="ui-id-2"]
    //Datos de la solicitud
    public SelenideElement selectAduana = $x("//*[@id=\"idAduana\"]");
    public SelenideElement selectJuntaDerivada = $x("//*[@id=\"slcJuntaTecnicaDerivada\"]");
    //Datos de la mercancia
    public SelenideElement NombreComercialMercancia = $x("//*[@id=\"solicitud.juntaTecnica.nombreComercialMercancia\"]");
    public SelenideElement DescripcionMercancia = $x("//*[@id=\"solicitud.juntaTecnica.descDetalladaMercancia\"]");

    //Fracciones considerables propuestas
    public SelenideElement FraccionI = $x("//*[@id=\"fraccion1\"]");
    public SelenideElement FraccionII = $x("//*[@id=\"fraccion2\"]");
    public SelenideElement FraccionIII = $x("//*[@id=\"fraccion3\"]");
    //Manifiesto
    public SelenideElement checkManifiestoProtesta = $x("//*[@id=\"manifiesto0\"]");
    //Continuar Paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
