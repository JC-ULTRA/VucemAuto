package Economia.Tramite110201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110201 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110201 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[1]/a");
    //CERTIFICADO DE ORIGEN
    public SelenideElement labelCertificadoOrigen = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement SolicitudTratdoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisSeleccionado = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement inputMostrarMercancias = $x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement MercanciaDisponible = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[3]/td[2]");

    public SelenideElement inputIdMarca = $x("//*[@id=\"idMarca\"]");
    public SelenideElement inputIdCantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement inputUMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement inputIdValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement inputIdDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement inputIdMasaBruta = $x("//*[@id=\"idMasaBruta\"]");
    public SelenideElement selectDatosMercanciaUnidadMedida = $x("//*[@id='datosMercancia.unidadMedidaMasaBruta']");
    public SelenideElement inputIdFechaFactura = $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement inputIdNumeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement inputIdTipoFactura = $x("//*[@id=\"datosMercancia.tipoFactura\"]");
    public SelenideElement inputAgregarMercancia = $x("/html/body/main/div/div[4]/div[2]/form/div[17]/div/div[2]/div/input[2]");
    public SelenideElement btnAceptar = $x("/html/body/div[11]/div[3]/div/button");
    //DESTINATARIO
    public SelenideElement labelDestinatario = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a");
    public SelenideElement inputSolicitudDestinatarioNombre = $x("//*[@id='solicitud.destinatario.nombre']");
    public SelenideElement inputSolicitudDestinatarioApellidoPaterno = $x("//*[@id='solicitud.destinatario.apellidoPaterno']");
    public SelenideElement inputSolicitudDestinatarioApellidoMaterno = $x("//*[@id='solicitud.destinatario.apellidoMaterno']");
    public SelenideElement inputSolicitudDestinatarioRFC = $x("//*[@id='solicitud.destinatario.rfc']");
    public SelenideElement inputSolicitudDestinatarioRazonSocial = $x("//*[@id='solicitud.destinatario.razonSocial']");
    public SelenideElement inputSolicitudDestinatarioDomicilioCiudad = $x("//*[@id='solicitud.destinatario.domicilio.ciudad']");
    public SelenideElement inputSolicitudDestinatarioDomicilioCalle = $x("//*[@id='solicitud.destinatario.domicilio.calle']");
    public SelenideElement inputSolicitudDestinatarioDomicilioNumero = $x("//*[@id='solicitud.destinatario.domicilio.numeroExterior']");
    public SelenideElement inputSolicitudDestinatarioDomicilioTelefono = $x("//*[@id='solicitud.destinatario.domicilio.telefono']");
    public SelenideElement inputSolicitudDestinatarioDomicilioFax = $x("//*[@id='solicitud.destinatario.domicilio.fax']");
    public SelenideElement inputSolicitudDestinatarioCorreoElectronico = $x("//*[@id='solicitud.destinatario.correoElectronico']");
    public SelenideElement selectSolicitudDestinatarioPaisOrigen = $x("//*[@id='solicitud.destinatario.paisOrigen.clave']");
    public SelenideElement selectSolicitudCertificadoOrigenMedio = $x("//*[@id='solicitud.certificadoOrigen.medioTransporte']");
    public SelenideElement inputGuardaSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    //DATOS CERTIFICADO
    public SelenideElement labelDatosCertificado = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[4]/a");
    public SelenideElement textareaSolicitudCertificadoOrigenObservaciones = $x("//*[@id='solicitud.certificadoOrigen.observaciones']");
    public SelenideElement textareaSolicitudCertificadoOrigenPrecisa = $x("//*[@id='solicitud.certificadoOrigen.precisa']");
    public SelenideElement textareaSolicitudCertificadoOrigenPresenta = $x("//textarea[contains(@name, 'presenta')]");
    public SelenideElement selectSolicitudCertificadoOrigenLenguaje = $x("//*[@id='solicitud.certificadoOrigen.lenguaje.clave']");
    public SelenideElement selectSolicitudEntidadFederativaClave = $x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement selectRepresentacionFederal = $x("//*[@id='representacionFederalSelect']");
    //CONTINUAR
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    //FIRMAR
}
