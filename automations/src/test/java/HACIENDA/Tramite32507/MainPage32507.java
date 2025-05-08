package HACIENDA.Tramite32507;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32507 {
    //Tramite 32507
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Navegación para entrar al tramite
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement EnvioAviso = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a/span");  //*[@id="servicios"]/ul/li/ul/li[5]/a/span
    public SelenideElement elementoTramite32507 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[6]/ul/li[7]/a");

    //PASO 1 Capturar solicitud
    //Tab Aviso
    public SelenideElement tabAviso = $x("//*[@id=\"ui-id-2\"]");
    //Datos de la empresa IMMEX que presenta la documentación complementaria del aviso
    public SelenideElement NumeroImmex = $x("//*[@id=\"numeroIMMEX\"]");
    public SelenideElement AñoProgramaImmex = $x("//*[@id=\"anioIMMEX\"]");
    //Datos de la ADACE que asistió a la destrucción
    public SelenideElement radbtnSiAcudioADACE = $x("//*[@id=\"acudioSi\"]");
    public SelenideElement radbtnNoAcudioADACE = $x("//*[@id=\"acudioNo\"]");
    public SelenideElement selectActaADACE = $x("//*[@id=\"levantarActa\"]");

    //Tabla Datos de las mercancías destruídas
    public SelenideElement btnAgregarMercanciaDestruida = $x("//*[@id=\"btnAgregar\"]");

    //Agregar Datos mercancia destruida
    public SelenideElement IdTransaccion = $x("//*[@id=\"numeroSerie\"]");
    //Datos de la mercancia
    public SelenideElement Cantidad = $x("//*[@id=\"cantidad\"]");
    public SelenideElement PesoKG = $x("//*[@id=\"peso\"]");
    public SelenideElement selectUnidadMedida = $x("//*[@id=\"unidadMedida\"]");
    public SelenideElement Descripcion = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement btnAgregarInfoMercancia = $x("//*[@id=\"agregar\"]");

    //Botón Continuar Paso 1
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

}
