package HACIENDA.Tramite105;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage105 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement AutorizacionesImporExpor = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a/span");
    public SelenideElement elementoTramite105 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos del inmueble
    public SelenideElement tabDatosTramite = $x("//*[@id=\"ui-id-2\"]/label");

    //Datos del trámite
    public SelenideElement checkImportacion = $x("//*[@id=\"tabs-2\"]/div[3]/div[1]/input");
    public SelenideElement checkExportacion = $x("//*[@id=\"tabs-2\"]/div[3]/div[2]/input");
    public SelenideElement checkDepositoGas = $x("//*[@id=\"tabs-2\"]/div[3]/div[3]/input");
    public SelenideElement checkDepositoVehiculos = $x("//*[@id=\"tabs-2\"]/div[3]/div[4]/input");

    public SelenideElement radbtnSiServiciosTerceros = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div[2]/input");
    public SelenideElement radbtnNoServiciosTerceros = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div[3]/input");
    public SelenideElement radbtnSiActividadGas = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[5]/div[2]/input");
    public SelenideElement radbtnNoActividadGas = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[5]/div[3]/input");
    public SelenideElement radbtnSiTipoVehiculos = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[6]/div[2]/input");
    public SelenideElement radbtnNoTipoVehiculos = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[6]/div[3]/input");


    //Ubicación de las instalaciones solicitadas
    public SelenideElement checkDomicilio = $x("//*[@id=\"checkDomicilio\"]");
    public SelenideElement checkUbicacion = $x("//*[@id=\"checkUbicacion\"]");
    public SelenideElement selectPaisInstalacion = $x("//*[@id=\"cvePais\"]");
    public SelenideElement CodigoInstalacion = $x("//*[@id=\"codigoPostalInstalaciones\"]");
    public SelenideElement selectEntidadInstalacion = $x("//*[@id=\"solicitud.domicilio.entidadFederativa.clave\"]");
    public SelenideElement selectMunicipioInstalacion = $x("//*[@id=\"solicitud.domicilio.delegacionMunicipio.clave\"]");
    public SelenideElement LocalidadInstalacion = $x("//*[@id=\"localidadInstalaciones\"]");
    public SelenideElement selectColoniaInstalacion = $x("//*[@id=\"solicitud.domicilio.colonia.clave\"]");
    public SelenideElement CalleInstalacion = $x("//*[@id=\"calleIntalaciones\"]");
    public SelenideElement NumExteriorInstalacion = $x("//*[@id=\"numExtIntalaciones\"]");
    public SelenideElement NumInteriorInstalacion = $x("//*[@id=\"numIntIntalaciones\"]");
    public SelenideElement UbicacionInstalacion = $x("//*[@id=\"textUbicacion\"]");

    //Aduanas
    public SelenideElement selectAduana = $x("//*[@id=\"solicitud.aduanaSolicitud.aduana.clave\"]");

    //Registro de fracciones arancelarias
    public SelenideElement btnAgregarFraccion = $x("//*[@id=\"tabs-2\"]/div[16]/div[3]/div/div/input[1]");
    public SelenideElement btnModificarFraccion = $x("//*[@id=\"tabs-2\"]/div[16]/div[3]/div/div/input[3]");
    //Fracciones arancelarias
    public SelenideElement selectFraccion = $x("//*[@id=\"comboFraccionArancelaria\"]");
    public SelenideElement DescripcionMercancia = $x("//*[@id=\"descripcionAdicional\"]");
    public SelenideElement btnAgregarInfoFraccion = $x("//*[@id=\"btnAgregarFraccion\"]");
    public SelenideElement btnAceptarFraccionNtf = $x("/html/body/div[14]/div[3]/div/button");

    //Servicios Terceros
    public SelenideElement btnAgregarTerceros = $x("//*[@id=\"agregarTercero\"]");
    public SelenideElement btnModificarTerceros = $x("//*[@id=\"modificarTercero\"]");
    //Datos del Servicio a Terceros
    public SelenideElement radbtnFisicaTercero = $x("//*[@id=\"tipoPersonaFisicaTercero\"]");
    public SelenideElement radbtnMoralTercero = $x("//*[@id=\"tipoPersonaMoralTercero\"]");
    public SelenideElement TerceroRFC = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscarTercero = $x("//*[@id=\"buscar\"]");
    public SelenideElement btnAgregarInfoTercero = $x("//*[@id=\"registroTerceroBtn\"]");
    public SelenideElement btnAceptarTercerosNtf = $x("/html/body/div[15]/div[3]/div/button");



    //Pestaña datos del tramite 2
    public SelenideElement tabDatosTramite2 = $x("//*[@id=\"ui-id-3\"]/label");
    //Mercancías
    public SelenideElement ProcedimientoCargaDescarga = $x("//*[@id=\"cargaDescargaMercancia\"]");
    public SelenideElement SistemasMedicion = $x("//*[@id=\"pesajeMedicion\"]");
    public SelenideElement MotivosNoDespachar = $x("//*[@id=\"tabs-3\"]/div[4]/div/div/textarea");

    //Agentes y apoderados aduanales
    public SelenideElement selectTipoFigura = $x("//*[@id=\"comboAgenteApoderado\"]");

    //Agentes y apoderados aduanales registrados
    public SelenideElement btnAgregarAgente = $x("//*[@id=\"agregarAgente\"]");
    public SelenideElement btnAgregarApoderado = $x("//*[@id=\"agregarApoderado\"]");

    //Registro de Agentes Aduanales
    public SelenideElement NombreAgente = $x("//*[@id=\"nombreAgente\"]");
    public SelenideElement ApellidoPaternoAgente = $x("//*[@id=\"apellidoPaternoAgente\"]");
    public SelenideElement ApellidoMaternoAgente = $x("//*[@id=\"apellidoMaternoAgente\"]");
    public SelenideElement NumPatenteAgente = $x("//*[@id=\"patente\"]");
    public SelenideElement btnAgregarInfoAgente = $x("//*[@id=\"btnAgregarAgente\"]");
    public SelenideElement btnAceptarAduanalNtf = $x("/html/body/div[16]/div[3]/div/button");
    //Registro de Agentes Apoderados
    public SelenideElement NombreApoderado = $x("//*[@id=\"nombreApoderado\"]");
    public SelenideElement ApellidoPaternoApoderado = $x("//*[@id=\"apellidoPaternoApoderado\"]");
    public SelenideElement ApellidoMaternoApoderado = $x("//*[@id=\"apellidoMaternoApoderado\"]");
    public SelenideElement NumAutorizacionApoderado = $x("//*[@id=\"autorizacion\"]");
    public SelenideElement btnAgregarInfoApoderado = $x("//*[@id=\"btnAgregarApoderado\"]");
    public SelenideElement btnAceptarApoderadoNtf = $x("/html/body/div[17]/div[3]/div/button");
    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"ui-id-2\"]");//*[@id="ui-id-2"] //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");


}
