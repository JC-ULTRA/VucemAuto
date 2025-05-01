package HACIENDA.Tramite32503;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32503 {
    //Tramite 32503
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Navegación para entrar al tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement EnvioAviso = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a/span");
    public SelenideElement Tramite32503 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[6]/ul/li[3]/a");

    //Tab Aviso
    public SelenideElement tabAviso = $x("//*[@id=\"ui-id-2\"]/label");
    //Datos de la empresa IMMEX que transfiere y presenta el aviso
    public SelenideElement NumeroIMMEX = $x("//*[@id=\"solicitud.valorProgramaImmex\"]");
    public SelenideElement AñoIMMEX = $x("//*[@id=\"solicitud.valorAnioProgramaImmex\"]");
    //Datos del aviso
    public SelenideElement radbtnInicial = $x("//*[@id=\"inicial\"]");
    public SelenideElement radbtnProrroga = $x("//*[@id=\"prorroga\"]");
    public SelenideElement fechaTranslado = $x("//*[@id=\"fechaTranslado\"]");
    //Datos del domicilio de la planta o bodega de origen de las mercancías
    public SelenideElement NombreComercial = $x("//*[@id=\"nombrePlanta\"]");
    public SelenideElement selectEntidadFederativa = $x("//*[@id=\"direccionOrigen.claveEntidadFederativa\"]");
    public SelenideElement selectAlcaldiaMunicipio= $x("//*[@id=\"direccionOrigen.claveDelegacionMunicipio\"]");
    public SelenideElement selectColonia = $x("//*[@id=\"direccionOrigen.claveColonia\"]");
    public SelenideElement Calletxt = $x("//*[@id=\"calle\"]");
    public SelenideElement NumeroExterior = $x("//*[@id=\"numeroExterior\"]");
    public SelenideElement NumeroInterior = $x("//*[@id=\"numeroInterior\"]");
    public SelenideElement CodigoPostal = $x("//*[@id=\"codigoPostal\"]");
    //TipoCarga
    public SelenideElement radbtnManual = $x("//*[@id=\"tabs-2\"]/div/div[11]/div[3]/input[1]");
    public SelenideElement radbtnCargaMasiva = $x("//*[@id=\"tabs-2\"]/div/div[11]/div[3]/input[2]");

    //Datos del Aviso
    public SelenideElement btnAgregarDatos = $x("//*[@id=\"btnAgregarDomiRepara\"]");
    //Datos de quien recibe las mercancías para llevar a cabo procesos de reparación o mantenimiento, análisis y pruebas, calibración o diseño
    public SelenideElement DatosPersonaRFC = $x("//*[@id=\"rfc\"]");
    //Datos del domicilio de la planta o bodega de destino de las mercancías (donde se llevarán a cabo los procesos de reparación o mantenimiento, análisis y pruebas, calibración o diseño)
    public SelenideElement NombreComercialPlantaDest= $x("//*[@id=\"nombreComercial\"]");
    public SelenideElement EntidadFederativaPlantaDestDest = $x("//*[@id=\"claveEntidadFederativa\"]");
    public SelenideElement AlcaldiaMunicipioPlantaDest = $x("//*[@id=\"claveDelegacionMunicipio\"]");
    public SelenideElement ColoniaPlantaDest = $x("//*[@id=\"claveColonia\"]");
    public SelenideElement CallePlantaDestinotxt = $x("//*[@id=\"calleDestino\"]");
    public SelenideElement NumeroExteriorPlantaDest = $x("//*[@id=\"numeroExteriorDestino\"]");
    public SelenideElement NumeroInteriorPlantaDest = $x("//*[@id=\"numeroInteriorDestino\"]");
    public SelenideElement CodigoPostalPlantaDest = $x("//*[@id=\"codigoPostalDestino\"]");
    //Datos de la mercancía que se trasladará
    public SelenideElement btnAgregarDatosMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"claveFraccionArancelaria\"]");
    public SelenideElement NICO = $x("//*[@id=\"nico\"]");
    public SelenideElement Cantidad = $x("//*[@id=\"cantidad\"]");
    public SelenideElement UnidadMedida = $x("//*[@id=\"claveUnidadMedida\"]");
    public SelenideElement ValorUSD = $x("//*[@id=\"valorUSD\"]");
    public SelenideElement DescripcionMercancia = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement Proceso = $x("//*[@id=\"descripcionProceso\"]");
    public SelenideElement NumPedimientoExportacion = $x("//*[@id=\"numPedimentoExportacion\"]");
    public SelenideElement NumPedimientoImportacion = $x("//*[@id=\"numPedimentoImportacion\"]");
    public SelenideElement btAgregarDatosMercancia2 = $x("//*[@id=\"botonAgregarM2\"]");
    public SelenideElement btnAceptarNotificacion1 = $x("/html/body/div[10]/div[3]/div/button");
    //(Continuacion)Datos del domicilio de la planta o bodega de destino de las mercancías (donde se llevarán a cabo los procesos de reparación o mantenimiento, análisis y pruebas, calibración o diseño)
    public SelenideElement btnAgregar2 = $x("//*[@id=\"botonAgregarM1\"]");
    public SelenideElement btnAceptarNotificacion2 = $x("/html/body/div[11]/div[3]/div/button");
    //Boton Continuar Paso 1
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");





}
