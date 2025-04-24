package Economia.Tramite110212;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110212 {
    //Tramite  110112
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");

    //Elementos para encontrar tramite
    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificado = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/a/span");
    public SelenideElement elementoTramite110212 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[12]/a");

    //Elementos seccion certificado
    public SelenideElement tabCertificadoOrigen = $x("//*[@id=\"ui-id-2\"]");

    //Elementos Check tercer operador
    public SelenideElement checkTercerOperador = $x("//*[@id=\"idTercerOperador\"]");
    public SelenideElement TercerOperadorNombre = $x("//*[@id=\"solicitud.tercerOperador.nombre\"]");
    public SelenideElement TercerOperadorApellidoP = $x("//*[@id=\"solicitud.tercerOperador.apellidoPaterno\"]");
    public SelenideElement TercerOperadorApellidoM = $x("//*[@id=\"solicitud.tercerOperador.apellidoMaterno\"]");
    public SelenideElement TercerOperadorNumeroFiscal = $x("//*[@id=\"solicitud.tercerOperador.rfc\"]");
    public SelenideElement TercerOperadorRazonSocial= $x("//*[@id=\"solicitud.tercerOperador.razonSocial\"]");

    //Tratado y país o bloque
    public SelenideElement TratadoAcuerdo= $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisBloque= $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"fraccionB\"]");
    public SelenideElement NumeroRegistroProducto= $x("//*[@id=\"numRegistro\"]");
    public SelenideElement NombreComercial= $x("//*[@id=\"nomComercial\"]");
    public SelenideElement fechaInicio= $x("//*[@id=\"fechaInicioCertificado\"]");
    public SelenideElement fechaFin= $x("//*[@id=\"fechaFinCertificado\"]");
    public SelenideElement btnBuscarmercancia =$x("//*[@id=\"idBotonBuscarMercancias\"]");

    //Grid Mercancias disponibles
    public SelenideElement filaMercanciaDisponible =$x("//*[@id=\"3\"]/td[2]");

    //Sección llenado Informacion de la mercancia
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement fechaFactura =  $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NumeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement selectTipoFactura = $x("//*[@id=\"datosMercancia.tipoFactura\"]");
    public SelenideElement btnAgregarDatosMercancia = $x("//*[@id=\"agregarMercancia\"]");
    public SelenideElement btnAceptarNotficacionAgrMercancia = $x("/html/body/div[13]/div[3]/div/button");

    //Sección Destinatario
    public SelenideElement tabDestinatario = $x("//*[@id=\"ui-id-3\"]");
    //Datos generales
    public SelenideElement NombreDestinatario = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement ApellidoPaternoDestinatario = $x("//*[@id=\"solicitud.destinatario.apellidoPaterno\"]");
    public SelenideElement ApellidoMaternoDestinatario = $x("//*[@id=\"solicitud.destinatario.apellidoMaterno\"]");
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
    //Datos del representante legal del exportador
    public SelenideElement LugarRepresentante = $x("//*[@id=\"solicitud.certificadoOrigen.lugarRegistro\"]");
    public SelenideElement NombreRepresentante = $x("//*[@id=\"solicitud.representanteLegal.nombre\"]");
    public SelenideElement CargoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.puesto\"]");
    public SelenideElement LadaRepresentante = $x("//*[@id=\"solicitud.destinatario.domicilio.lada\"]");
    public SelenideElement TelefonoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.telefono\"]");
    public SelenideElement FaxRepresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.fax\"]");
    public SelenideElement CorreoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.correoElectronico\"]");

    //Seccion Datos Certificado
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

