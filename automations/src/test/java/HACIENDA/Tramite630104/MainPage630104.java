package HACIENDA.Tramite630104;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage630104 {

    //Tramite 630104
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Selección rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement ImportacionMercanciaSinPedimento = $x("//*[@id=\"servicios\"]/ul/li[16]/a/span");
    public SelenideElement Autorizacion = $x("//*[@id=\"servicios\"]/ul/li[16]/ul/li[1]/a/span");
    public SelenideElement elementoTramite630104 = $x("//*[@id=\"servicios\"]/ul/li[16]/ul/li[1]/ul/li[4]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement tabDatosSolicitud= $x("//*[@id=\"ui-id-2\"]/label");
    //Datos de la solicitud
    public SelenideElement selectAduanaIngreso = $x("//*[@id=\"datosImportacionTemporal.cveAduana\"]");
    public SelenideElement selectSeccionAduanera = $x("//*[@id=\"datosImportacionTemporal.cveSeccionAduanal\"]");
    //Fecha de importación
    public SelenideElement fechaEstimadaIngreso = $x("//*[@id=\"fechaIngreso\"]");

    //Tipo de propietario
    public SelenideElement selectPropietario= $x("//*[@id=\"ddlTipoPropietario\"]");
    //Elementos No es propietario
    public SelenideElement selectTipoPropietario = $x("//*[@id=\"ddlTipoPersona\"]");
    public SelenideElement PropietarioNombre = $x("//*[@id=\"nombre\"]");
    public SelenideElement PropietarioApellidoPaterno = $x("//*[@id=\"apellidoPaterno\"]");
    public SelenideElement PropietarioApellidoMaterno = $x("//*[@id=\"apellidoMaterno\"]");
    public SelenideElement PropietarioDenominacion = $x("//*[@id=\"razonSocial\"]");
    public SelenideElement PropietarioCalle = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.calle\"]");
    public SelenideElement PropietarioNumExterior = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.numeroExterior\"]");
    public SelenideElement PropietarioNumInterior = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.numeroInterior\"]");
    public SelenideElement selectPropietarioPais = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.pais\"]");
    public SelenideElement PropietarioLocalidad = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.estadoLocalidad\"]");
    public SelenideElement PropietarioCorreoElec = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.correoElectronico\"]");
    public SelenideElement PropietarioTelefono = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.telefono\"]");
    public SelenideElement PropiedadCodPostal = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.codigoPostal\"]");

    //Datos del nombre o denominación social del representante en México o centro de operaciones
    public SelenideElement selectConsultarRFC = $x("//*[@id=\"ddlRepresentante\"]");
    //Si consultar
    public SelenideElement ConsultarRFC = $x("//*[@id=\"rfcRepresentante\"]");
    public SelenideElement btnConsultarRFC = $x("//*[@id=\"botonConsultaRep\"]/input");
    //No Consultar
    public SelenideElement selectTipoRepresentante = $x("//*[@id=\"ddlTipoPersona_representante\"]");

    //Persona física
    public SelenideElement RepresentanteCURP = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.curp\"]");
    public SelenideElement RepresentanteNombre = $x("//*[@id=\"nombreRep\"]");
    public SelenideElement RepresentanteApellidoPaterno = $x("//*[@id=\"apellidoPaternoRep\"]");
    public SelenideElement RepresentanteApellidoMaterno = $x("//*[@id=\"apellidoMaternoRep\"]");

    //Datos generales de representante
    public SelenideElement RepresentanteRFC = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.rfc\"]");
    public SelenideElement RepresentanteDenominacion = $x("//*[@id=\"razonSocialRep\"]");
    public SelenideElement RepresentanteCalle = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.calle\"]");
    public SelenideElement RepresentanteNumExt = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.numeroExterior\"]");
    public SelenideElement RepresentanteNumInt = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.numeroInterior\"]");
    public SelenideElement selectRepresentanteEntidad = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.entidadFederativa\"]");
    public SelenideElement selectRepresentanteMunicipio = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.municipio\"]");
    public SelenideElement selectRepresentanteLocalidad = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.localidad\"]");
    public SelenideElement selectRepresentanteColonia = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.colonia\"]");
    public SelenideElement DatoRepresentanteCorreo = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.correoElectronico\"]");
    public SelenideElement DatoRepresentanteTelefono = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.telefono\"]");
    public SelenideElement DatoRepresentanteCodigoPostal = $x("//*[@id=\"datosImportacionTemporal.datosRepresentante.codigoPostal\"]");

    //Datos de la mercancía que se importará al país temporalmente
    public SelenideElement DescripcionMercancia = $x("//*[@id=\"tramite.descMercancia\"]");
    public SelenideElement MotivacionMercancia = $x("//*[@id=\"tramite.descMotivo\"]");
    public SelenideElement NombreMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[9]/div[4]/div/input");
    public SelenideElement ObservacionesMercancia = $x("//*[@id=\"tramite.observaciones\"]");
    public SelenideElement ListaMercancia = $x("//*[@id=\"tramite.descCkeckList\"]");

    //Manifiesto
    public SelenideElement checkManifiesto = $x("//*[@id=\"declaracion[0]\"]");
    //Continuar Paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
