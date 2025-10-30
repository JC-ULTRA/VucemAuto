package Economia.Tramite110217;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110217 {
    //Tramite Aviso 110217
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[2]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110217 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[17]/a");

    ///Certificado de Origen Captura
    public SelenideElement PestCertificadOrigen = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement TradadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscarMerca = $x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement CargarTramiteEjemplo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div[14]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[8]");
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement UMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercanciaDoll = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement FechaFactura = $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement TipoFactura = $x("//*[@id=\"datosMercancia.tipoFactura\"]");
    public SelenideElement btnAgregarMerca = $x("//*[@id=\"agregarMercancia\"]");


    ///Histórico Productores
    public SelenideElement HproductoresPest = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement CheckProductorConfidenciales = $x("//*[@id=\"idConfidencialesProductores\"]");
    public SelenideElement CheckProductorMismaPersona = $x("//*[@id=\"idProductorMismoExportador\"]");
    public SelenideElement CheckInfoProdExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[5]/div/div[3]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnSeleccionar = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[5]/div/div[3]/div/div/div/div[3]/div/div/div/div[2]/div/div/div/input[2]");
    //Grid Productores por exportador
    public SelenideElement productorNuevo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[5]/div/div[3]/div/div/div/div[3]/div/div/div/div[2]/div/div/div/input[1]");
    public SelenideElement rfcProduductor = $x("//*[@id=\"idRfcProductor\"]");
    public SelenideElement btnAgregarProductor = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/div[2]/div/input[2]");
    public SelenideElement fila1Productor = $x("//*[@id=\"jqg_gridProductoresPorExportador_3\"]");
    public SelenideElement btnSeleccionarAgrProductor = $x("//*[@id=\"acciones\"]/input[2]");
    public SelenideElement fila1ProductorSeleccionado = $x("//*[@id=\"jqg_gridProductoresPorExportadorSeleccionados_3\"]");
    public SelenideElement btnProductorNuevo = $x("//*[@id=\"acciones\"]/input[1]");
    public SelenideElement fila1MercanciasSeleccionada = $x("//*[@id=\"jqg_gridMercanciasProductor_3\"]");
    public SelenideElement btnAsignarProductor = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[5]/div[3]/div/div/div/div[3]/div/div/div/div[6]/div/div/div/input");

    ///Destinatario
    public SelenideElement Destinatario = $x("//*[@id=\"ui-id-4\"]");
    public SelenideElement NombreDesti = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement PrimerApellido = $x("//*[@id=\"solicitud.destinatario.apellidoPaterno\"]");
    public SelenideElement SegundoApellido = $x("//*[@id=\"solicitud.destinatario.apellidoMaterno\"]");
    public SelenideElement RFC = $x("//*[@id=\"solicitud.destinatario.rfc\"]");
    public SelenideElement CiudadDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.ciudad\"]");
    public SelenideElement CalleDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.calle\"]");
    public SelenideElement NumeoLetraDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.numeroExterior\"]");
    public SelenideElement LadaDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.lada\"]");
    public SelenideElement TelefonoDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.telefono\"]");
    public SelenideElement FaxDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.fax\"]");
    public SelenideElement CorreoDesti = $x("//*[@id=\"solicitud.destinatario.correoElectronico\"]");
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public SelenideElement LugarExport = $x("//*[@id=\"solicitud.certificadoOrigen.lugarRegistro\"]");
    public SelenideElement NombreRepreExport = $x("//*[@id=\"solicitud.representanteLegal.nombre\"]");
    public SelenideElement EmpresaExport = $x("//*[@id=\"solicitud.representanteLegal.razonSocial\"]");
    public SelenideElement CargoExport = $x("//*[@id=\"solicitud.representanteLegal.puesto\"]");
    public SelenideElement LadaExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[3]/div[10]/div[3]/div/input");
    public SelenideElement TelefonoExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.telefono\"]");
    public SelenideElement FaxExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.fax\"]");
    public SelenideElement CorreoExport = $x("//*[@id=\"solicitud.representanteLegal.correoElectronico\"]");
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public SelenideElement PuertoEmbarqueTrans = $x("//*[@id=\"tabs-4\"]/div[13]/div[1]/div/input");
    public SelenideElement PuertoDesembarqueTrans = $x("//*[@id=\"tabs-4\"]/div[13]/div[2]/div/input");
    public SelenideElement PuertoTransitoTrans = $x("//*[@id=\"tabs-4\"]/div[14]/div[1]/div/input");
    public SelenideElement NombreEmbarcacionTrans = $x("//*[@id=\"tabs-4\"]/div[14]/div[2]/div/input");
    public SelenideElement NumeroVueloTrans = $x("//*[@id=\"tabs-4\"]/div[15]/div/div/input");

    ///Certificado
    public SelenideElement DatosCertificado = $x("//*[@id=\"ui-id-5\"]");
    public SelenideElement Obs = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[4]/div[3]/div/div[2]/textarea");
    public SelenideElement Idioma = $x("//*[@id=\"solicitud.certificadoOrigen.lenguaje.clave\"]");
    public SelenideElement EntidadFederativa = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement btnContinuarCertifi = $x("//*[@id=\"guardarSolicitud\"]");
}

