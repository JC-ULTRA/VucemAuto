package Economia.Tramite110207;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110207 {
    //Tramite Aviso 110207
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");


    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");

    //Elementos para encontrar tramite
    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificado = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/a/span");
    public SelenideElement elementoTramite110207 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[7]/a");

    public SelenideElement tabCertificadoOrigen = $x("//*[@id=\"ui-id-2\"]");

  //Tratado y país o bloque
    public SelenideElement TratadoAcuerdo= $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque= $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"fraccionB\"]");
    public SelenideElement NumeroRegistroProducto= $x("//*[@id=\"numRegistro\"]");
    public SelenideElement NombreComercial= $x("//*[@id=\"nomComercial\"]");
    public SelenideElement fechaInicio= $x("//*[@id=\"fechaInicioCertificado\"]");
    public SelenideElement fechaFin= $x("//*[@id=\"fechaFinCertificado\"]");
    public SelenideElement btnBuscarmercancia =$x("//*[@id=\"idBotonBuscarMercancias\"]");
    public SelenideElement checkAnexoJapon = $x("//*[@id=\"idAnexoJapon\"]");

    //Grid Mercancias disponibles
    public SelenideElement filaMercanciaDisponible =$x("//*[@id=\"3\"]/td[2]");

    //Informacion de la mercancia
    public SelenideElement MarcaMercancia= $x("//*[@id=\"idMarca\"]");
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement fechaFactura =  $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NumeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement selectTipoFactura = $x("//*[@id=\"datosMercancia.tipoFactura\"]");
    public SelenideElement btnAgregarDatosMercancia = $x("//*[@id=\"agregarMercancia\"]");
    public SelenideElement btnAceptarNotficacionAgrMercancia = $x("/html/body/div[11]/div[3]/div/button");


    //Destinatario
    public SelenideElement tabDestinatario = $x("//*[@id=\"ui-id-3\"]");
    //Datos generales
    public SelenideElement NombreDestinatario = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement ApellidoPaternoDestinatario = $x("//*[@id=\"solicitud.destinatario.apellidoPaterno\"]");
    public SelenideElement ApellidoMaterno = $x("//*[@id=\"solicitud.destinatario.apellidoMaterno\"]");
    public SelenideElement RFCDestinatario = $x("//*[@id=\"solicitud.destinatario.rfc\"]");
    public SelenideElement RazonSocialDestinatario = $x("//*[@id=\"solicitud.destinatario.razonSocial\"]");
    //Domicilio del destinatario
    public SelenideElement CiudadDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.ciudad\"]");
    public SelenideElement CalleDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.calle\"]");
    public SelenideElement NumeroLetraDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.numeroExterior\"]");
    public SelenideElement LadaDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.lada\"]");
    public SelenideElement TelefonoDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.telefono\"]");
    public SelenideElement FaxDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.fax\"]");
    public SelenideElement CorreoDestinatario = $x("//*[@id=\"solicitud.destinatario.correoElectronico\"]");
    public SelenideElement selectPaisDestino = $x("//*[@id=\"solicitud.destinatario.paisOrigen.clave\"]");

    //Detalles del transporte
    public SelenideElement selectMedioTransporte = $x("//*[@id=\"solicitud.certificadoOrigen.medioTransporte\"]");
    public SelenideElement RutaCompleta = $x("//*[@id=\"solicitud.certificadoOrigen.rutaCompleta\"]");
    public SelenideElement PuertoEmbarque = $x("//*[@id=\"tabs-4\"]/div[12]/div[1]/div/input");
    public SelenideElement PuertoDesembarque = $x("//*[@id=\"tabs-4\"]/div[12]/div[2]/div/input");
    public SelenideElement btnContinuarDestinatario = $x("//*[@id=\"guardarSolicitud\"]");

    //Datos Certificado
    public SelenideElement Paso1Textoreferencia= $x("//*[@id=\"h1_title\"]");


    public SelenideElement tabDatosCertificado = $$("ul.ui-tabs-nav li a").findBy(Condition.matchText("(?i)^\\s*Datos certificado\\s*$"));
    public SelenideElement Observaciones = $x("//*[@id=\"solicitud.certificadoOrigen.observaciones\"]");
    public SelenideElement selectIdioma = $x("//*[@id=\"solicitud.certificadoOrigen.lenguaje.clave\"]");
    //Representacion Federal
    public SelenideElement selectEstado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selectRrepreFederal = $x("//*[@id=\"representacionFederalSelect\"]");

    //Continuar Tramite
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");


    //public SelenideElement nombreElemento = $x("");
}

