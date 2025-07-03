package Economia.Tramite130401;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130401 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    //Búsqueda de tramite
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = Selenide.$x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Permisos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement ModificacionMercancia = Selenide.$x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[4]/a");
    public SelenideElement elementoTramite130401 = Selenide.$x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[4]/ul/li/a");

    //Búsqueda de folio
    public SelenideElement folioPermiso = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div/input");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"formmodificacionMercancia\"]/div[3]/div[2]/div/input[2]");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Modificación Descripción Mercancía
    public SelenideElement tabModDescripMercancia = $x("//*[@id=\"ui-id-3\"]/label");
    //Modificación de la descripción de la mercancía
    public SelenideElement ModificarDescripcionSigue = $x("//*[@id=\"tabs-modmercancia\"]/div[3]/div/div/textarea");
    //Partidas de la mercancía
    public SelenideElement gridParMercancia1 = $x("//*[@id=\"jqg_gridPartidaMercanciasModificacion_3\"]");
    public SelenideElement btnModParMercancia = $x("//*[@id=\"botonModificarPartidasDescripcionPexim\"]/div/input");
    //Modificación de descripción mercancía Partida
    public SelenideElement DescripcionSol = $x("//*[@id=\"datosPartida\"]/div/div/div/textarea");
    public SelenideElement btnModificarInfoMercancia = $x("//*[@id=\"botonModificarPartidaDescripcion\"]");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
