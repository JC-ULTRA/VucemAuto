package Economia.Tramite110221;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
public class MainPage110221 {
    //Tramite Aviso 110217
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110221 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[20]/a");

    ///Certificado de Origen Captura
    /// Flujo Importación
    public SelenideElement PestCertificadOrigen = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement Check1Import = $x("//*[@id=\"check.una.importacion\"]");
    public SelenideElement TradadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscarMerca = $x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement CargarTramiteEjemplo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[2]/div[14]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[11]");

    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement UMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercanciaDoll = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement NSerie = $x("//*[@id=\"idNumeroSerie\"]");
    public SelenideElement FechaFactura = $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement TipoFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[19]/div[4]/div/select");
    public SelenideElement btnAgregarMerca = $x("/html/body/main/div/div[4]/div[2]/form/div[20]/div/div[2]/div/input[2]");

    ///Flujo Periodo
    public SelenideElement CleckPeriodo2 = $x("//*[@id=\"check.periodo\"]");
    public SelenideElement TradadoAcuerdo2 = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque2 = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscarMerca2 = $x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement CargarTramiteEjemplo2 = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[2]/div[14]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[11]");

    public SelenideElement Cantidad2 = $x("/html/body/main/div/div[4]/div[2]/form/div[12]/div[4]/div[1]/div/input");
    public SelenideElement UMC2 = $x("/html/body/main/div/div[4]/div[2]/form/div[12]/div[4]/div[2]/div/select");
    public SelenideElement ValorMercanciaDoll2 = $x("/html/body/main/div/div[4]/div[2]/form/div[14]/div[2]/div/input");
    public SelenideElement ComplementoDescripcion2 = $x("/html/body/main/div/div[4]/div[2]/form/div[14]/div[1]/div/textarea");
    public SelenideElement NSerie2 = $x("/html/body/main/div/div[4]/div[2]/form/div[15]/div/div[2]/input");
    public SelenideElement FechaFactura2 = $x("/html/body/main/div/div[4]/div[2]/form/div[19]/div[2]/div/input");
    public SelenideElement NFactura2 = $x("/html/body/main/div/div[4]/div[2]/form/div[19]/div[3]/div/input");
    public SelenideElement TipoFactura2 = $x("/html/body/main/div/div[4]/div[2]/form/div[19]/div[4]/div/select");
    public SelenideElement btnAgregarMerca2 = $x("/html/body/main/div/div[4]/div[2]/form/div[20]/div/div[2]/div/input[2]");

    ///Histórico Productores
    public SelenideElement HproductoresPest = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement CheckProductorConfidenciales = $x("//*[@id=\"idConfidencialesProductores\"]");
    public SelenideElement CheckProductorMismaPersona = $x("//*[@id=\"idProductorMismoExportador\"]");
    public SelenideElement nuevoProductor = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div/div[3]/div/div/div/div[3]/div/div/div/div[2]/div/div/div/input[1]");
    public SelenideElement rfcProductor = $x("//*[@id=\"idRfcProductor\"]");
    public SelenideElement faxProductor = $x("//*[@id=\"idFax\"]");
    public SelenideElement btnAgregarProductor = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/div[2]/div/input[2]");
    public SelenideElement CheckInfoProdExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[5]/div/div[3]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnSeleccionar = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[5]/div/div[3]/div/div/div/div[3]/div/div/div/div[2]/div/div/div/input[2]");
    public SelenideElement selecMercancia = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div/div[3]/div/div/div/div[3]/div/div/div/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement asignarProductor = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div/div[3]/div/div/div/div[3]/div/div/div/div[3]/div[3]/div[2]/div/div/div/input");
    public SelenideElement asignarMercancia = $x("/html/body/main/div/div[4]/div[2]/form/div[4]/div[1]/div[2]/div/input[2]");
    public SelenideElement numRegistroFed = $x("//*[@id=\"idRfcProductorProd\"]");

    ///Destinatario
    public SelenideElement detinatarioTab = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[4]");
    public SelenideElement NombreDesti = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement NRFiscalDesi = $x("//*[@id=\"solicitud.destinatario.rfc\"]");
    public SelenideElement CalleDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.calle\"]");
    public SelenideElement NumeroLetraDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.numeroExterior\"]");
    public SelenideElement PaisDesti = $x("//*[@id=\"solicitud.destinatario.paisOrigen.clave\"]");
    public SelenideElement CiudadDestin = $x("//*[@id=\"tabs-4\"]/div/div[3]/div[3]/div[2]/div/input");
    public SelenideElement CorreoDesti = $x("//*[@id=\"solicitud.destinatario.correoElectronico\"]");
    public SelenideElement LadaDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.lada\"]");
    public SelenideElement TelDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.telefono\"]");

    public SelenideElement NombreExport = $x("//*[@id=\"representanteLegal.nombre\"]");
    public SelenideElement LugarExport = $x("//*[@id=\"solicitud.certificadoOrigen.lugarRegistro\"]");
    public SelenideElement CalleExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.calle\"]");
    public SelenideElement NuneroLetraExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.numeroExterior\"]");
    public SelenideElement PaisExport = $x("//*[@id=\"solicitud.representanteLegal.paisOrigen.clave\"]");
    public SelenideElement CiudadExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.ciudad\"]");
    public SelenideElement CargoExport = $x("//*[@id=\"solicitud.representanteLegal.puesto\"]");
    public SelenideElement EmpresaExport = $x("//*[@id=\"solicitud.representanteLegal.razonSocial\"]");
    public SelenideElement NRegistroExport = $x("//*[@id=\"solicitud.representanteLegal.rfc\"]");
    public SelenideElement LadaExport = $x("//*[@id=\"solicitud.destinatario.domicilio.lada\"]");
    public SelenideElement TelefonoExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.telefono\"]");
    public SelenideElement FaxExport = $x("//*[@id=\"solicitud.representanteLegal.domicilio.fax\"]");
    public SelenideElement CorreoExport = $x("//*[@id=\"solicitud.representanteLegal.correoElectronico\"]");

    ///Certificado
    public SelenideElement DatosCertificado = $x("//*[@id=\"ui-id-5\"]");
    public SelenideElement Obs = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[5]/div[1]/div[3]/div/div[2]/textarea");
    public SelenideElement EntidadFederativa = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement btnContinuarCertifi = $x("//*[@id=\"guardarSolicitud\"]");
}
