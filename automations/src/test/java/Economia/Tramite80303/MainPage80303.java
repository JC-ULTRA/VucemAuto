package Economia.Tramite80303;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80303 {
    //Tramite 80303
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ModificacionPrograma = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/a/span");
    public SelenideElement elementoTramite80303 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/ul/li[3]/a");

    //Lista de programas
    public SelenideElement listaPrograma1 = $x("//*[@id=\"1\"]/td[3]");
    //Modificacion
    public SelenideElement tabModificacion = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement btnModificarBajaPlanta1 = $x("//*[@id=\"btnBajaEmpresas3\"]");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Continuar paso 2
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento1 = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement getIconoVerDocumento2 = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub Paso 3
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

}
