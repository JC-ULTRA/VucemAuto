package HACIENDA.Tramite317;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage317 {
    //Tramite 317
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Busqueda folio sub tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar modificación y prórroga
    public SelenideElement btnSolicitarRenovacion= $x("//*[@id=\"renovarButton\"]");

    //Tab Aviso Único de Renovación
    public SelenideElement tabAvisoRenovacion = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement radbtnRubroA = $x("//*[@id=\"avisoA\"]");
    public SelenideElement radbtnRubroAA = $x("//*[@id=\"avisoAA\"]");
    public SelenideElement radbtnRubroAAA = $x("//*[@id=\"avisoAAA\"]");

    public SelenideElement radbtnBajoProtest = $x("//*[@id=\"acepto3061\"]");

    public SelenideElement radbtnConEnvio = $x("//*[@id=\"acepto3062\"]");
    public SelenideElement radbtnCircunstanc = $x("//*[@id=\"acepto3063\"]");

    //Pago de derechos
    public SelenideElement NumOperac = $x("//*[@id=\"solicitud.pago.referenciaBancaria\"]");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");

    //Botones
    public SelenideElement btnBorrarDatos = $x("//*[@id=\"borrarDatosPago\"]");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");



    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelectArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelectArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
}
