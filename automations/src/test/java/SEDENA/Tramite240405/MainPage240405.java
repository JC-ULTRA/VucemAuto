package SEDENA.Tramite240405;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage240405 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Tramite 240305
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de trámite subsecuente
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar Modificación
    public SelenideElement btnSolProrroga = $x("//*[@id=\"prorrogaButton\"]");

    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement Justificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement inputOrigenLista = $x("//*[@id=\"origenlistaOrigen\"]");
    public SelenideElement inputAddOrigenLista = $x("//*[@id=\"addlistaOrigen\"]");

    public SelenideElement btnRestarOrigenTodos = $x("//*[@id=\"remove_alllistaOrigen\"]");
    public SelenideElement inputUsoFinalMercancia = $x("//*[@id=\"solicitud.mercancia.usoFinal\"]");
    public SelenideElement PermisoGeneral = $x("//*[@id=\"tabs-2\"]/div[3]/div[1]/input");

    //TERCEROS RELACIONADOS
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    //Destinatario
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement gridDestinatario1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    //Proveedor
    public SelenideElement btnAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement gridProveedor1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_PVD_0\"]");
    public SelenideElement btnModificarProveedor= $x("//*[@id=\"modificarTercero_TIPERS_PVD\"]");

    //Datos
    public SelenideElement inputNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement inputExtranjera = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement inputFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTercerosNombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTercerosDenominacion = $x("//*[@id=\"terceros_rSocial\"]");

    public SelenideElement selectPais = $x("//*[@id=\"terceros_selectPais\"]");//*[@id="terceros_selectPais"]
    public SelenideElement inputTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputTercerosEstado = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");

    public SelenideElement EstadoProveedor = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement inputTercerosMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement inputTercerosLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement inputTercerosCP = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement inputTercerosCP2 = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement inputTercerosColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement inputTercerosNumeroExt = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement inputTercerosNumeroInt = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputTercerosLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id=\"terceros_correoElec\"]");//*[@id="terceros_correoElec"]
    public SelenideElement btnGuardarTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement inputCadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}