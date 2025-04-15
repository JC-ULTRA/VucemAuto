package Economia.Tramite110204;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110204 {
    //Tramite Aviso 110102
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li[2]");


    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");

    //Elementos para encontrar tramite
    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificado = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/a/span");
    public SelenideElement ExportacionAladi = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[4]/a");
    public SelenideElement TituloPrincipal = Selenide.$x("//*[@id=\"h1_title\"]");
    public SelenideElement tabCertificadoOrigen = $x("//*[@id=\"ui-id-2\"]");

    //Validación inicial del certificado de circulación de mercancías
    public SelenideElement checkTercerOperador = $x("//*[@id=\"idTercerOperador\"]");
    public SelenideElement TercerOperadorNombre = $x("//*[@id=\"solicitud.tercerOperador.nombre\"]");
    public SelenideElement TercerOperadorApellidoP = $x("//*[@id=\"solicitud.tercerOperador.apellidoPaterno\"]");
    public SelenideElement TercerOperadorApellidoM = $x("//*[@id=\"solicitud.tercerOperador.apellidoMaterno\"]");
    public SelenideElement TercerOperadorNumeroFiscal = $x("//*[@id=\"solicitud.tercerOperador.rfc\"]");
    public SelenideElement TercerOperadorRazonSocial= $x("//*[@id=\"solicitud.tercerOperador.razonSocial\"]");

    //Domicilio del tercer operador
    public SelenideElement selectTercerOperadorPais = $x("//*[@id=\"solicitud.tercerOperador.paisOrigen.clave\"]");
    public SelenideElement TercerOperadorCiudad = $x("//*[@id=\"solicitud.tercerOperador.domicilio.ciudad\"]");
    public SelenideElement TercerOperadorCalle = $x("//*[@id=\"solicitud.tercerOperador.domicilio.calle\"]");
    public SelenideElement TercerOperadorNumeroLetra = $x("//*[@id=\"solicitud.tercerOperador.domicilio.numeroExterior\"]");
    public SelenideElement TercerOperadorLada= $x("//*[@id=\"solicitud.tercerOperador.domicilio.lada\"]");
    public SelenideElement TercerOperadorTelefono = $x("//*[@id=\"solicitud.tercerOperador.domicilio.telefono\"]");
    public SelenideElement TercerOperadorFax = $x("//*[@id=\"solicitud.tercerOperador.domicilio.fax\"]");
    public SelenideElement TercerOperadorCorreo = $x("//*[@id=\"solicitud.tercerOperador.correoElectronico\"]");

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
    public SelenideElement filaMercanciaDisponible =$x("//*[@id=\"3\"]/td[4]");

    //Informacion de la mercancia
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement fechaFactura =  $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NumeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement selectTipoFactura = $x("//*[@id=\"datosMercancia.tipoFactura\"]");
    public SelenideElement btnAgregarDatosMercancia = $x("//*[@id=\"agregarMercancia\"]");
    public SelenideElement btnAceptarNotficacionAgrMercancia = $x("/html/body/div[11]/div[3]/div/button");

    //Continuar Tramite
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement Paso1Textoreferencia= $x("//*[@id=\"h1_title\"]");
    //Datos Certificado
    public SelenideElement tabDatosCertificado = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement Observaciones = $x("//*[@id=\"solicitud.certificadoOrigen.observaciones\"]");
    public SelenideElement selectIdioma = $x("//*[@id=\"solicitud.certificadoOrigen.lenguaje.clave\"]");

    //Representacion Federal
    public SelenideElement selectEstado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selectRrepreFederal = $x("//*[@id=\"representacionFederalSelect\"]");

}

