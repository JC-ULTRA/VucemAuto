package Economia.Tramite110223;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110223 {
    //Tramite Aviso 110223
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[2]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110223 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[22]/a");

    ///Certificado de Origen Captura
    public SelenideElement PestCertificadOrigen = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement TradadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscarMerca = $x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement CargarTramiteEjemplo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[2]/div[13]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement UMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercanciaDoll = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement FechaFactura = $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement TipoFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[18]/div[1]/div/select");
    public SelenideElement NSerie = $x("/html/body/main/div/div[4]/div[2]/form/div[18]/div[2]/div/input");
    public SelenideElement btnAgregarMerca = $x("//*[@id=\"agregarMercancia\"]");

    ///Histórico Productores
    public SelenideElement HproductoresPest = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement CheckProductorConfidenciales = $x("//*[@id=\"idConfidencialesProductores\"]");
    public SelenideElement CheckProductorMismaPersona = $x("//*[@id=\"idProductorMismoExportador\"]");
    public SelenideElement CheckInfoProdExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div[3]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnSeleccionar = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div[3]/div/div/div/div[3]/div/div/div/div[2]/div/div/div/input[2]");

    ///Destinatario
    public SelenideElement Destinatario = $x("//*[@id=\"ui-id-4\"]");
    public SelenideElement NombreDesti = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement NRegisFiscal = $x("//*[@id=\"solicitud.destinatario.rfc\"]");
    public SelenideElement CalleDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.calle\"]");
    public SelenideElement NumeoLetraDesti = $x("//*[@id=\"solicitud.destinatario.domicilio.numeroExterior\"]");
    public SelenideElement CiudadDesti = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[7]/div[1]/div/input");
    public SelenideElement CorreoDesti = $x("//html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[9]/div[1]/div/input");
    public SelenideElement TelefonoDesti = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[9]/div[2]/div/input");
    public SelenideElement FaxDesti = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[9]/div[3]/div/input");

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public SelenideElement LugarExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[11]/div[2]/div/input");
    public SelenideElement NombreRepreExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[12]/div[2]/div/input");
    public SelenideElement EmpresaExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[14]/div[1]/div/input");
    public SelenideElement CargoExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[14]/div[2]/div/input");
    public SelenideElement NumRegFiscalExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[14]/div[3]/div/input[1]");
    public SelenideElement TelefonoExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[16]/div[2]/div/input");
    public SelenideElement FaxExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[16]/div[3]/div/input");
    public SelenideElement CorreoExport = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[4]/div[16]/div[1]/div/input");

    ///Certificado
    public SelenideElement DatosCertificado = $x("//*[@id=\"ui-id-5\"]");
    public SelenideElement Obs = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[5]/div[1]/div[3]/div/div[2]/textarea");
    public SelenideElement EntidadFederativa = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement btnContinuarCertifi = $x("//*[@id=\"guardarSolicitud\"]");
}
