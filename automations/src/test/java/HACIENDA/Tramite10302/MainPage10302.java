package HACIENDA.Tramite10302;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage10302 {

    //Tramite 10302
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement AutorizacionExpImp = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ExencionImpuestos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement elementoTramite10302 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[1]/ul/li[3]/a");

    //PASO 1
    //Datos del Tramite
    public SelenideElement tabDatosTramite = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement selectAduanaIngresoMercancia = $x("//*[@id=\"cveAduana\"]");
    public SelenideElement checkOrganizmoPublico = $x("//*[@id=\"checkBoxOP\"]");

    //Mercancias
    public SelenideElement FinMercancia = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"tabs-2\"]/div[1]/div[6]/div/input[3]");
    //Agregar Mercancia
    public SelenideElement TipoMercancia = $x("//*[@id=\"descripcionMerc\"]");
    public SelenideElement Cantidad = $x("//*[@id=\"cantidadComercial\"]");
    public SelenideElement UnidadMedida = $x("//*[@id=\"unidadMedidaComercial\"]");
    public SelenideElement MarcaEquipoMaquinaria = $x("//*[@id=\"marca\"]");
    public SelenideElement selectAñoImportacion = $x("//*[@id=\"anio\"]");
    public SelenideElement Modelo = $x("//*[@id=\"modelo\"]");
    public SelenideElement NumeroSerie = $x("//*[@id=\"serie\"]");
    public SelenideElement btnAgregarInfoMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement btnAceptarNotifMercancia = $x("/html/body/div[10]/div[3]/div/button");

    //Domicilio Donante
    public SelenideElement DonanteRFC = $x("//*[@id=\"rfc\"]");
    public SelenideElement NumeroImmex = $x("//*[@id=\"numeroProgramaImmex\"]");
    public SelenideElement btnNotificacionImmex = $x("/html/body/div[11]/div[3]/div/button");
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");
    //Domicilio Fiscal
    public SelenideElement CorreoElectronicoFiscal = $x("//*[@id=\"correoElectronico\"]");
    public SelenideElement TelefonoFiscal = $x("//*[@id=\"telefono\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[6]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

}
