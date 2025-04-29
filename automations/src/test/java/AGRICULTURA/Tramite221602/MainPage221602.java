package AGRICULTURA.Tramite221602;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage221602 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[3]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    /// Avisos
    public SelenideElement btnModificar = $x("//*[@id=\"modificarButton\"]");
    /// Datos de la Solicitud
    public SelenideElement datosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[2]");
    public SelenideElement justificacionModificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement numeroGuia = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[7]/div[1]/div[2]/input");
    public SelenideElement numeroFerrocarril = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[8]/div/div[2]/input");
    public SelenideElement selecMercancia = $x("//*[@id=\"jqg_gridMercanciasTram220202_3\"]");
    public SelenideElement modificarMercancia = $x("//*[@id=\"btnModificarMercancias\"]");
    public SelenideElement fraccionArancelaria = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]");
    public SelenideElement nico = $x("//*[@id=\"idFraccionNico\"]");
    public SelenideElement descripcion = $x("//*[@id=\"mostrarDescripcionFraccionUsuario\"]");
    public SelenideElement cantidadUmt = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement cantidadUmc = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement tipoUmc = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement usoMercancia = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement tipoProducto = $x("//*[@id=\"mercanciaGrid.tipoProducto.idTipoProductoTipoTramite\"]");
    public SelenideElement numeroLote = $x("//*[@id=\"idNumeroLote\"]");
    public SelenideElement paisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement paisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement selecNombreCientifico = $x("//*[@id=\"nombreCientificoCross\"]/option[5]");
    public SelenideElement agregarNombreCientifico = $x("/html/body/main/div[1]/div[4]/div[3]/form/div[17]/div[11]/div/div[2]/div/div/input[2]");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarMercancia\"]");
    /// Datos Para la Movilizcion Nacional
    public SelenideElement datosMovilizacion = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[3]");
    public SelenideElement medioTransporte = $x("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]");
    public SelenideElement identificacionTransporte = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[3]/div[1]/div[2]/div[2]/input");
    public SelenideElement puntoVerificacion = $x("//*[@id=\"solicitud.transporte.puntoVerificacion.idPuntoVerificacion\"]");
    /// Terceros Relacionados
    public SelenideElement tercerosRelacionados = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[4]");
    public SelenideElement selecExportador = $x("//*[@id=\"jqg_gridTerceros_TIPERS_EXP_0\"]");
    public SelenideElement modExportador = $x("//*[@id=\"modificarTercero_TIPERS_EXP\"]");
    public SelenideElement tercerosRsocial = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement domicilioTerceros = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement selecDestinatario = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement modDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    public SelenideElement personaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement nombrePFisica = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement apellido1PFisica = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement apellido2PFisica = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement numInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement guardarTercero = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    /// Pago de Derechos
    public SelenideElement pagoDerechos = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[5]");
    public SelenideElement banco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement importePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    /// Pasos siguientes
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
