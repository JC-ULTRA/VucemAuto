package COFEPRIS.Tramite260918;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260918 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    /// Avisos
    public SelenideElement btnModificar = $x("//*[@id=\"MYPButton\"]");
    /// Datos de la Solicitud
    public SelenideElement datosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[2]");
    public SelenideElement tipoModificacion = $x("//*[@id=\"mod\"]");
    public SelenideElement justificacionModificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement mercanciaAModificar = $x("//*[@id=\"jqg_gridMercanciasTram2602_3\"]");
    public SelenideElement modificarMercancia = $x("//*[@id=\"btnModificarAduana\"]");
    public SelenideElement clasificacionMod = $x("//*[@id=\"mercanciaGrid.idClasificacionProducto\"]");
    public SelenideElement especificarClasificacionMod = $x("//*[@id=\"mercanciaGrid.ideSubClasificacionProducto\"]");
    public SelenideElement denominacionEspecifica = $x("//*[@id=\"idDenominacionEspecifica\"]");
    public SelenideElement denominacionDistintiva = $x("//*[@id=\"idDenominacionDistintiva\"]");
    public SelenideElement nombreCientifico = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement tipoProducto = $x("//*[@id=\"mercanciaGrid.tipoProducto.idTipoProductoTipoTramite\"]");
    public SelenideElement estadoFisico = $x("//*[@id=\"mercanciaGrid.idEstadoFisico\"]");
    public SelenideElement fraccionArancelaria = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement umtCantidad = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement umcCantidad = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement umcTipo = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement presentacion = $x("//*[@id=\"presentacion\"]");
    public SelenideElement paisOrigenMod = $x("//*[@id=\"input28\"]");
    public SelenideElement quitarPaisO = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[2]/div/div/input[4]");
    public SelenideElement selecPaisO = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[1]/div[2]/select/option[12]");
    public SelenideElement agregarPaisO = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement paisProcedenciaMod = $x("//*[@id=\"input35\"]");
    public SelenideElement quitarPaisProc = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[4]");
    public SelenideElement selecPaisProc = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[1]/div[2]/select/option[11]");
    public SelenideElement agregarPaisProc = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement usoEspecifico = $x("//*[@id=\"input42\"]");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarMercancia\"]");
    public SelenideElement rfcRepresentante = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement buscarRfc = $x("//*[@id=\"consultarIDC\"]");
    /// Terceros Relacionados
    public SelenideElement tercerosRelacionados = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[3]");
    public SelenideElement agregarFabricante = $x("//*[@id=\"agregarTercero_TIPERS_FAB\"]");
    public SelenideElement terceroNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement terceroMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement terceroRfc = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement terceroRSocial = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement terceroEstado = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement terceroMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement terceroLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement terceroCodigoPostal = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement terceroColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement terceroCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement terceroNumero = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement guardarTercero = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement agregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement agregarProveedores = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement paisTerceros = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstadoTxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement terceroCodigoPostalTxt = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement terceroColoniaTxt = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    public SelenideElement agregarFacturador = $x("//*[@id=\"agregarTercero_TIPERS_FAC\"]");
    /// Pago de Derechos
    public SelenideElement pagoDerechos = $x("/html/body/main/div[1]/div[4]/div[1]/div[6]/form/div[1]/ul/li[4]");
    public SelenideElement claveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement cadenaDepenedencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement banco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement importePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    /// Pasos siguientes
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div[1]/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");

}
