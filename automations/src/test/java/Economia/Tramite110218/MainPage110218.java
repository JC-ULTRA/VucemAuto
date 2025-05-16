package Economia.Tramite110218;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110218 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[2]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement motivosTecnicosJapon = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[18]/a");

    /// Consulta Certificado
    public SelenideElement porTratatdoAcuerdo = $x("//*[@id=\"check.paisbloque.tragadoacuerdo\"]");
    public SelenideElement tratadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement paisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"botonBuscarPorTratadoAcuerdo\"]");
    public SelenideElement radio1 = $x("/html/body/main/div/div[4]/div/form/div[5]/div[1]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnConsultar = $x("/html/body/main/div/div[4]/div/form/div[5]/div[2]/div/input");

    ///Validaciones
    public SelenideElement tratados = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement destinatario = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement nombreDestinatario = $x("//*[@id=\"idDestinatarioNombre\"]");
    public SelenideElement primerApellidoDestinatario = $x("//*[@id=\"idDestinatarioApPaterno\"]");
    public SelenideElement segundoApellidoDestinatario = $x("//*[@id=\"idDestinatarioApMaterno\"]");
    public SelenideElement numeroRegistroFiscal = $x("//*[@id=\"idDestinatarioRfc\"]");
    public SelenideElement razonSocial = $x("//*[@id=\"idDestinatarioRazonSocial\"]");
    public SelenideElement calleDestinatario = $x("//*[@id=\"idDestinatarioCalle\"]");
    public SelenideElement numeroDestinatario = $x("//*[@id=\"idDestinatarioNumero\"]");
    public SelenideElement ciudadDestinatario = $x("//*[@id=\"idDestinatarioCiudad\"]");
    public SelenideElement correoDestinatario = $x("//*[@id=\"idDestinatarioCorreo\"]");
    public SelenideElement telefonoDestinatario = $x("//*[@id=\"idDestinatarioTelefono\"]");
    public SelenideElement faxDestinatario = $x("//*[@id=\"idDestinatarioFax\"]");
    public SelenideElement transporte = $x("//*[@id=\"ui-id-4\"]");
    public SelenideElement puertoEmbarque = $x("//*[@id=\"idTransporteEmbarque\"]");
    public SelenideElement puertoDesembarque = $x("//*[@id=\"idTransporteDesembarque\"]");
    public SelenideElement puertoTransito = $x("//*[@id=\"idTransporteTransito\"]");
    public SelenideElement nombreEmbarcacion = $x("//*[@id=\"idTransporteEmbarcacion\"]");
    public SelenideElement numeroVuelo = $x("//*[@id=\"idTransporteVuelo\"]");
    public SelenideElement representanteLegal = $x("//*[@id=\"ui-id-5\"]");
    public SelenideElement nombreRepresentante = $x("//*[@id=\"idRepresentanteLegalNombre\"]");
    public SelenideElement cargoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.puesto\"]");
    public SelenideElement telefonoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.telefono\"]");
    public SelenideElement faxRepresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.fax\"]");
    public SelenideElement correoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.correoElectronico\"]");
    public SelenideElement datosCertificado = $x("//*[@id=\"ui-id-6\"]");
    public SelenideElement lugarDatos = $x("//*[@id=\"idCertificadoLugar\"]");
    public SelenideElement observaciones = $x("//*[@id=\"idTransporteObservaciones\"]");
    public SelenideElement seleccionaMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[6]/div[4]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnModificaMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[6]/div[5]/div/div/input");
    public SelenideElement complementoDescripcion = $x("//*[@id=\"idDescripcion\"]");
    public SelenideElement marcaMercancia = $x("//*[@id=\"idMarca\"]");
    public SelenideElement valorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement unidadMedidaComercializacion = $x("//*[@id=\"mercanciaCertificado.unidadMedidaComercial\"]");
    public SelenideElement numeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement tipoFactura = $x("//*[@id=\"mercanciaCertificado.tipoFactura\"]");
    public SelenideElement btnHacerModificacion = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div[4]/div/input[2]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");



}
