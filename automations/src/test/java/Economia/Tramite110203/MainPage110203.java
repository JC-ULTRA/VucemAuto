package Economia.Tramite110203;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110203 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Loging y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    //Busqueda Tramite 110203
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110203 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[3]/a");

    //Búsqueda de certificado
    public SelenideElement radbtnNumCertificado = $x("//*[@id=\"check.numero.certificado\"]");
    public SelenideElement radbtnPorAcuerdoBloque = $x("//*[@id=\"check.paisbloque.tragadoacuerdo\"]");
    public SelenideElement NumCertificado = $x("//*[@id=\"numCertificadoIngresado\"]");
    public SelenideElement selectTratadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement selectPaisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"botonBuscarPorTratadoAcuerdo\"]");
    public SelenideElement gridCertificadoFila1 = $x("//*[@id=\"3\"]/td[1]/input");
    public SelenideElement btnConsultar = $x("//*[@id=\"divConsulta\"]/div[2]/div/input");


    //Pestaña Destinatario
    //Datos del destinatario
    public SelenideElement tabDestinatario = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement inputDestinatarioNombre = $x("//*[@id=\"idDestinatarioNombre\"]");
    public SelenideElement inputDestinatarioApellidoPaterno = $x("//*[@id=\"idDestinatarioApPaterno\"]");
    public SelenideElement inputDestinatarioApellidoMaterno = $x("//*[@id=\"idDestinatarioApMaterno\"]");
    public SelenideElement inputDestinatarioRFC = $x("//*[@id=\"idDestinatarioRfc\"]");
    // public SelenideElement inputDestinatarioRazonSocial = $x("//*[@id=\"idDestinatarioRazonSocial\"]");
    //Domicilio del destinatario
    public SelenideElement inputDestinatarioDomicilioCalle = $x("//*[@id=\"idDestinatarioCalle\"]");
    public SelenideElement inputDestinatarioDomicilioNumero = $x("//*[@id=\"idDestinatarioNumero\"]");
    public SelenideElement inputDestinatarioCorreoElectronico = $x("//*[@id=\"idDestinatarioCorreo\"]");
    public SelenideElement inputDestinatarioDomicilioFax = $x("//*[@id=\"idDestinatarioFax\"]");
    public SelenideElement inputDestinatarioDomicilioTelefono = $x("//*[@id=\"idDestinatarioTelefono\"]");

    //Pestaña Transporte
    public SelenideElement tabTransporte = $x("//*[@id=\"ui-id-4\"]");
    public SelenideElement selectMedioTransporte = $x("//*[@id=\"solicitud.certificadoOrigen.medioTransporte\"]");

    //Pestaña Datos Certificado
    //Datos del Certificado
    public SelenideElement tabDatosCetificado = $x("//*[@id=\"ui-id-5\"]");
    public SelenideElement textareaCertificadoOrigenObservaciones = $x("//*[@id=\"idTransporteObservaciones\"]");
    public SelenideElement textareaCertificadoOrigenPrecisa = $x("//*[@id=\"solicitud.certificadoOrigen.precisa\"]");
    public SelenideElement textareaCertificadoOrigenPresenta = $x("//*[@id=\"tabs-8\"]/div[4]/div/div/textarea");
    //Mercancias seleccionadas
    public SelenideElement gridMercanciaFila1 = $x("//*[@id=\"4354498\"]/td[1]/input");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"tabs-8\"]/div[6]/div/div/input");
    //Modificación mercancia
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idDescripcion\"]");
    public SelenideElement Marca = $x("//*[@id=\"idMarca\"]");
    public SelenideElement ValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"mercanciaCertificado.unidadMedidaComercial\"]");
    public SelenideElement MasaBruta = $x("//*[@id=\"idMasaBruta\"]");
    public SelenideElement selectUnidadMasaBruta = $x("//*[@id=\"mercanciaCertificado.unidadMedidaMasaBruta\"]");
    public SelenideElement NumFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement selectTipoFactura = $x("//*[@id=\"mercanciaCertificado.tipoFactura\"]");
    public SelenideElement btnModificarMercancia2 = $x("//*[@id=\"formMercanciaCertificado\"]/div[3]/div[4]/div/input[2]");
    //Completar Modificación
    public SelenideElement btnContinuarPaso1 = $x("//*[@id='guardarSolicitud']");

}
