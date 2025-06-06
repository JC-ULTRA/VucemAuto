package HACIENDA.Tramite30401;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage30401 {

    //Tramite 30401
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda del trámite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegistroComercioExt = $x("//*[@id=\"servicios\"]/ul/li[4]/a/span");
    public SelenideElement RegistroTransportistaTransito = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[3]/a/span");
    public SelenideElement elementoTramite30401 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[3]/ul/li[1]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Empresas transportistas
    public SelenideElement tabEmpresasTransportistas= $x("//*[@id=\"ui-id-2\"]");   //*[@id="ui-id-2"]
    //Datos de la solicitud
    public SelenideElement selectTipoTransito = $x("//*[@id=\"solicitud.tipoTransito\"]");
    //Aduanas
    public SelenideElement listaAduanasAutorizadas = $x("//*[@id=\"cboAduanasActuar\"]");
    public SelenideElement btnAgregarAduanaAutorizada = $x("//input[@name='botonAgregarAduanas' and contains(@onclick, 'agregarAduanasSeleccionadas()')]");
    //Domicilio de la empresa para oír y recibir notificaciones
    public SelenideElement CalleEmpresa = $x("//*[@id=\"tabs-2\"]/div[7]/div[1]/input");
    public SelenideElement NumExteriorEmpresa = $x("//*[@id=\"tabs-2\"]/div[7]/div[2]/input");
    public SelenideElement NumInteriorEmpresa = $x("//*[@id=\"tabs-2\"]/div[7]/div[3]/input");
    public SelenideElement selectEntindadFederativaEmpresa = $x("//*[@id=\"solicitud.domicilio.entidadFederativa.clave\"]");
    public SelenideElement selectMunicipioEmpresa = $x("//*[@id=\"solicitud.domicilio.delegacionMunicipio.clave\"]");
    public SelenideElement selectColoniaEmpresa = $x("//*[@id=\"solicitud.domicilio.colonia.clave\"]");
    public SelenideElement LocalidadEmpresa = $x("//*[@id=\"tabs-2\"]/div[9]/div[1]/input");
    public SelenideElement CodigoPostalEmpresa = $x("//*[@id=\"tabs-2\"]/div[9]/div[2]/input");
    //Capital Social
    public SelenideElement CapitalPersonaMoral = $x("//*[@id=\"tabs-2\"]/div[11]/div[2]/input");
    //Permiso expedido por la Dirección General de Autotransporte Federal de la Secretaria de Comunicaciones y Transportes, para prestar el servicio de autotransporte federal de carga
    public SelenideElement NumPermiso = $x("//*[@id=\"numero\"]");
    public SelenideElement fechaPermiso = $x("//*[@id=\"fecha\"]");
    public SelenideElement checkCapitalSocialMenos = $x("//*[@id=\"manifiesto0\"]");
    public SelenideElement checkReponsableEmbarques = $x("//*[@id=\"manifiesto1\"]");

    //Pestaña Vehículos
    public SelenideElement tabVehiculos = $x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement btnAgregarVehiculo = $x("//*[@id=\"tabs-3\"]/div[3]/div/input[1]");
    public SelenideElement MarcaVehiculo = $x("//*[@id=\"marca\"]");
    public SelenideElement ModeloVehiculo = $x("//*[@id=\"modelo\"]");
    public SelenideElement NumIDVehicularSerie = $x("//*[@id=\"serie\"]");
    public SelenideElement btnAgregarInfVehiculo = $x("//*[@id=\"btnAgregarVehiculos\"]");
    public SelenideElement btnAceptarVehiculoNft = $x("/html/body/div[12]/div[3]/div/button");

    //Pago de derechos
    public SelenideElement tabPagoDerechos = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement ClaveReferencia = $x("//*[@id=\"pago.claveDeReferencia\"]");
    public SelenideElement CadenaDependencia = $x("//*[@id=\"pago.cadenaPagoDependencia\"]");
    public SelenideElement listBanco = $x("//*[@id=\"pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement ImportePago = $x("//*[@id=\"pago.impPago\"]");
    public SelenideElement checkEsquemaElectronico = $x("//*[@id=\"manifiestoPago0\"]");

    //Pestaña Consolidación de cargas
    public SelenideElement tabConsolidacionCargas = $x("//*[@id=\"ui-id-5\"]/label");
    public SelenideElement checkSiPrestarServiciosCarga = $x("//*[@id=\"siConsolidadoET\"]");
    public SelenideElement checkNoPrestarServiciosCarga = $x("//*[@id=\"noConsolidadoET\"]");
    //Elementos de pantalla para Carga de archivos Consolidación de cargas
    public SelenideElement SeleccionArchivoCC = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement EnviarArchivoCC = $x("//*[@id=\"cargaArchivo\"]");
    //Registro de Agentes Aduanales
    public SelenideElement btnCargaArchivoAgenteAduanal = $x("//*[@id=\"capturaConsolidacion\"]/div[3]/div/div/input[4]");
    public SelenideElement btnAgregarAgenteAduanal = $x("//*[@id=\"capturaConsolidacion\"]/div[3]/div/div/input[1]");
    public SelenideElement NombreAgente = $x("//*[@id=\"nombreAgente\"]");
    public SelenideElement PrimerApellidoAgente = $x("//*[@id=\"apellidoPaternoAgente\"]");
    public SelenideElement SegundoApellidoAgente = $x("//*[@id=\"apellidoMaternoAgente\"]");
    public SelenideElement NumPatenteAgente = $x("//*[@id=\"patente\"]");
    public SelenideElement btnAgregarInfAgenteAduanal = $x("//*[@id=\"btnAgregarAgente\"]");
    public SelenideElement btnAceptarAgenteNft = $x("/html/body/div[13]/div[3]/div/button");

    //Relación de cajas y/o vehículos con los que se presentará el servicio de consolidación de carga
    public SelenideElement btnAgregarCOnsolidacion = $x("//*[@id=\"capturaConsolidacion\"]/div[8]/div/input[1]");
    //Registro de vehículos
    public SelenideElement NumCajaVehiculo = $x("//*[@id=\"numCaja\"]");
    //Domicilio para la verificación del vehículo
    public SelenideElement CalleVehiculo = $x("//*[@id=\"calleVehiculo\"]");
    public SelenideElement NumExtVehiculo = $x("//*[@id=\"numExteriorVehiculo\"]");
    public SelenideElement NumIntVehiculo = $x("//*[@id=\"numInteriorVehiculo\"]");
    public SelenideElement selectEntidadFederativaVehiculo = $x("//*[@id=\"comboEntidadVehiculo\"]");
    public SelenideElement selectMunicipioVehiculo = $x("//*[@id=\"comboDelegacionVehiculo\"]");
    public SelenideElement selectColoniaVehiculo = $x("//*[@id=\"comboColoniaVehiculo\"]");
    public SelenideElement LocalidadVehiculo = $x("//*[@id=\"localidadVehiculo\"]");
    public SelenideElement CodigoPostalVehiculo = $x("//*[@id=\"codigoPostalVehiculo\"]");
    public SelenideElement selectAduanaVehiculo = $x("//*[@id=\"comboAduanaVehiculo\"]");
    //Nombre de una persona de contacto en la circunscripción de la aduana
    public SelenideElement NombreContactoCircunscripcion = $x("//*[@id=\"nombre\"]");
    public SelenideElement PrimerApellidoContactoCircunscripcion = $x("//*[@id=\"apellidoPaterno\"]");
    public SelenideElement SegundoApellidoContactoCircunscripcion = $x("//*[@id=\"apellidoMaterno\"]");
    public SelenideElement CorreoContactoCircunscripcion = $x("//*[@id=\"correoElectronico\"]");
    public SelenideElement TelefonoContactoCircunscripcion = $x("//*[@id=\"telefonoContacto\"]");

    //Agregar registro vehiculo
    public SelenideElement AgregarInfoConsolidacion = $x("//*[@id=\"btnAgregarVehiculosCC\"]");
    public SelenideElement btnAgregarInfVehiculoNft = $x("/html/body/div[14]/div[3]/div/button");

    //Manifiesto
    public SelenideElement radbtnSiProtestaConsolidacionCarga = $x("//*[@id=\"simanifiesto3100\"]");
    public SelenideElement radbtnNoProtestaConsolidacionCarga = $x("//*[@id=\"nomanifiesto3100\"]");
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
    public SelenideElement listDocumento6Grid = $x("//*[@id=\"idDoc5\"]");
    public SelenideElement listDocumento7Grid = $x("//*[@id=\"idDoc6\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
