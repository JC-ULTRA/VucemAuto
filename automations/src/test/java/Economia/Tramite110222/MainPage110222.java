package Economia.Tramite110222;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110222 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificado = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/a/span");
    public SelenideElement elementoTramite110222 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[21]/a");


    //Pestaña certificado de origen
    public SelenideElement tabCertificadoOrigen = $x("//*[@id=\"ui-id-2\"]");
    //Validación inicial del certificado de circulación de mercancías
    public SelenideElement checkTercerOperador = $x("//*[@id=\"idTercerOperador\"]");

    //Elementos check tercer operador
    //Datos tercer operador
    public SelenideElement TercerOperadorNombre = $x("//*[@id=\"solicitud.tercerOperador.nombre\"]");
    public SelenideElement TercerOperadorApellidoP = $x("//*[@id=\"solicitud.tercerOperador.apellidoPaterno\"]");
    public SelenideElement TercerOperadorApellidoM = $x("//*[@id=\"solicitud.tercerOperador.apellidoMaterno\"]");
    public SelenideElement TercerOperadorNumeroFiscal = $x("//*[@id=\"solicitud.tercerOperador.rfc\"]");
    public SelenideElement TercerOperadorRazonSocial= $x("//*[@id=\"solicitud.tercerOperador.razonSocial\"]");
    //Domicilio del tercer operador
    public SelenideElement TercerOperadorCalle = $x("//*[@id=\"solicitud.tercerOperador.domicilio.calle\"]");
    public SelenideElement TercerOperadorNumLetra = $x("//*[@id=\"solicitud.tercerOperador.domicilio.numeroExterior\"]");
    public SelenideElement TercerOperadorCiudad = $x("//*[@id=\"solicitud.tercerOperador.domicilio.ciudad\"]");
    public SelenideElement selectTercerOperadorPais = $x("//*[@id=\"solicitud.tercerOperador.paisOrigen.clave\"]");
    public SelenideElement TercerOperadorCorreo = $x("//*[@id=\"solicitud.tercerOperador.correoElectronico\"]");
    public SelenideElement TercerOperadorTelefono = $x("//*[@id=\"solicitud.tercerOperador.domicilio.telefono\"]");
    public SelenideElement TercerOperadorFax = $x("//*[@id=\"solicitud.tercerOperador.domicilio.fax\"]");

    //Tratado y país o bloque
    public SelenideElement selectTratadoAcuerdo= $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement selectPaisBloque= $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"fraccionB\"]");
    public SelenideElement NumeroRegistroProducto= $x("//*[@id=\"numRegistro\"]");
    public SelenideElement NombreComercial= $x("//*[@id=\"nomComercial\"]");
    public SelenideElement fechaInicio= $x("//*[@id=\"fechaInicioCertificado\"]");
    public SelenideElement fechaFin= $x("//*[@id=\"fechaFinCertificado\"]");
    public SelenideElement btnBuscarmercancias =$x("//*[@id=\"idBotonBuscarMercancias\"]");

    //Grid Mercancias disponibles
    public SelenideElement gridMercanciaDisponible1 =$x("//*[@id=\"3\"]/td[2]");
    //Sección llenado Informacion de la mercancia
    public SelenideElement Cantidad = $x("//*[@id=\"idCantidad\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"datosMercancia.unidadMedidaComercializacion\"]");
    public SelenideElement ValorMercancia = $x("//*[@id=\"idValorMercancia\"]");
    public SelenideElement ComplementoDescripcion = $x("//*[@id=\"idComplementoDescripcion\"]");
    public SelenideElement fechaFactura =  $x("//*[@id=\"idFechaFactura\"]");
    public SelenideElement NumeroFactura = $x("//*[@id=\"idNumeroFactura\"]");
    public SelenideElement selectTipoFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[18]/div[1]/div/select");
    public SelenideElement NumSerie = $x("//*[@id=\"idNumeroSerie\"]");
    public SelenideElement btnAgregarDatosMercancia = $x("//*[@id=\"agregarMercancia\"]");
    public SelenideElement btnAceptarNotficacionAgrMercancia = $x("/html/body/div[10]/div[3]/div/button");

    //Pestaña Historico Productores
    public SelenideElement tabHistoricoProductores = $$("ul.ui-tabs-nav li a").findBy(Condition.matchText("(?i)^\\s*Histórico productores\\s*$"));
    public SelenideElement checkDatosProductorNoConfidencial = $x("//*[@id=\"idConfidencialesProductores\"]");
    public SelenideElement checkExpImpNoMismaPersona = $x("//*[@id=\"idProductorMismoExportador\"]");

    //Grid Productores por exportador
    public SelenideElement fila1Productor = $x("//*[@id=\"jqg_gridProductoresPorExportador_3\"]");
    public SelenideElement btnSeleccionarAgrProductor = $x("//*[@id=\"acciones\"]/input[2]");
    public SelenideElement fila1ProductorSeleccionado = $x("//*[@id=\"jqg_gridProductoresPorExportadorSeleccionados_3\"]");
    //Agregar nuevo productor
    public SelenideElement btnAgregarProductorNuevo = $x("//*[@id=\"acciones\"]/input[1]");
    //Datos productores por exportador
    public SelenideElement NumRegistroFiscal = $x("//*[@id=\"idRfcProductor\"]");
    public SelenideElement Fax = $x("//*[@id=\"idFax\"]");
    public SelenideElement btnAgregarInfoProductorNuevo = $x("//*[@id=\"Agregar\"]");

    //grid Mercancias seleccionadas
    public SelenideElement fila1MercanciasSeleccionada = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div[3]/div/div/div/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnAsignarProductor = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[3]/div[3]/div/div/div/div[3]/div/div/div/div[6]/div/div/div/input");
    //Asignación productor a mercancia
    public SelenideElement NumRegistroFederal = $x("//*[@id=\"idRfcProductorProd\"]");
    public SelenideElement btnAsignar = $x("//*[@id=\"agregarMercanciaProd\"]");

    //Pestaña Destinatario
    public SelenideElement tabDestinatario = $$("ul.ui-tabs-nav li a").findBy(Condition.matchText("(?i)^\\s*Destinatario\\s*$"));
    //Datos generales
    public SelenideElement NombreDestinatario = $x("//*[@id=\"solicitud.destinatario.nombre\"]");
    public SelenideElement ApellidoPaternoDestinatario = $x("//*[@id=\"solicitud.destinatario.apellidoPaterno\"]");
    public SelenideElement ApellidoMaternoDestinatario = $x("//*[@id=\"solicitud.destinatario.apellidoMaterno\"]");
    public SelenideElement RFCDestinatario = $x("//*[@id=\"solicitud.destinatario.rfc\"]");
    public SelenideElement RazonSocialDestinatario = $x("//*[@id=\"solicitud.destinatario.razonSocial\"]");
    //Domicilio del destinatario
    public SelenideElement CalleDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.calle\"]");
    public SelenideElement NumeroLetraDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.numeroExterior\"]");
    public SelenideElement CiudadDestinatario = $x("//*[@id=\"tabs-4\"]/div[7]/div[1]/div/input");
    public SelenideElement CorreoDestinatario = $x("//*[@id=\"solicitud.destinatario.correoElectronico\"]");
    public SelenideElement TelefonoDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.telefono\"]");
    public SelenideElement FaxDestinatario = $x("//*[@id=\"solicitud.destinatario.domicilio.fax\"]");
    //Datos del representante legal del exportador
    public SelenideElement LugarRepresentante = $x("//*[@id=\"solicitud.certificadoOrigen.lugarRegistro\"]");
    public SelenideElement NombreRepresentante = $x("//*[@id=\"representanteLegal.nombre\"]");
    public SelenideElement CargoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.puesto\"]");
    public SelenideElement EmpresaRepresentante = $x("//*[@id=\"solicitud.representanteLegal.razonSocial\"]");
    public SelenideElement NumRegistroFiscalRepresentante = $x("//*[@id=\"solicitud.representanteLegal.rfc\"]");
    public SelenideElement CorreoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.correoElectronico\"]");
    public SelenideElement TelefonoRepresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.telefono\"]");
    public SelenideElement FaxRpresentante = $x("//*[@id=\"solicitud.representanteLegal.domicilio.fax\"]");
    //Pestaña Datos Certificado
    public SelenideElement tabDatosCertificado = $$("ul.ui-tabs-nav li a").findBy(Condition.matchText("(?i)^\\s*Datos certificado\\s*$"));
    //Datos del certificado
    public SelenideElement Observaciones = $x("//*[@id=\"solicitud.certificadoOrigen.observaciones\"]");
    //Representación Federal
    public SelenideElement selectEstado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selectRrepreFederal = $x("//*[@id=\"representacionFederalSelect\"]");

    //Continuar Paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

}
