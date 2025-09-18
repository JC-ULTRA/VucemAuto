package AGRICULTURA.Tramite220201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage220201 {
    //Tramite Aviso 220201 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement Agricultura = $x("//img[contains(@alt, 'Rural')]");
    public SelenideElement certysol = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement certImport = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a/span");
    public SelenideElement SelectTramite220201 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li[1]/a");
    //DatosSolicitud
    public SelenideElement labelDatosSolicitud = $x("//label[@for='solicitud.titulo']");
    public SelenideElement selectSolicitudClaveAduana = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement SolicitudOfiInspecAgrop = $x("//*[@id='solicitud.oficinaInspeccionAgropecuaria.clave']");
    public SelenideElement puntoInspec = $x("//*[@id='solicitud.unidadAdministrativaRepresentacionFederal.clave']");
    public SelenideElement ClaveUcon = $x("//*[@id='claveUcon']");
    public SelenideElement selectEstabTif = $x("//*[@id='solicitud.establecimientoTIF']");
    public SelenideElement NombreMedVet = $x("//*[@id='solicitud.descripcionClobGenerica2']");
    public SelenideElement NumGui = $x("//input[@size='25']");
    public SelenideElement Regimen = $x("//*[@id='solicitud.regimen.clave']");
    //CAPTURA DATOS MERCANCIA
    public SelenideElement inputAnimalesVivos = $x("//*[@id='tipoMercanciaNo']");
    public SelenideElement inputProductosSubproductos = $x("//*[@id='tipoMercanciaSi']");
    //AGREGAR MERCANCIA
    public SelenideElement btnAgregarMercanciaA = $x("//*[@id=\"btnAgregarMercanciasA\"]");
    public SelenideElement bntAgregarMercanciaP = $x("//*[@id=\"btnAgregarMercanciasP\"]");
    //Datos Generales de la Mercancía Animal
    public SelenideElement selectTipoRequisito = $x("//*[@id=\"mercanciaGrid.idTipoRequisito\"]");
    public SelenideElement inputRequisito = $x("//*[@id=\"requisitos\"]");
    public SelenideElement inputCertificadoInternacional = $x("//*[@id=\"numeroCertificado\"]");
    public SelenideElement selectFraccionArancelaria = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]");
    public SelenideElement selectNICO = $x("//*[@id=\"idFraccionNico\"]");
    public SelenideElement inputDescripcion = $x("//*[@id=\"mostrarDescripcionFraccionUsuario\"]");
    public SelenideElement inputCantidadUMT = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement inputCantidadUMC = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement selectEspecie = $x("//*[@id=\"mercanciaGrid.idEspecie\"]");
    public SelenideElement selectUso = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement selectPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    //Datos Generales de la Mercancía Producto
    public SelenideElement selectPresentacion = $x("//*[@id=\"mercanciaGrid.idPresentacion\"]");
    public SelenideElement inputCantidadPresentacion = $x("//*[@id=\"cantidadPresentacion\"]");
    public SelenideElement inputTipoPresentacion = $x("//*[@id=\"mercanciaGrid.idTipoPresentacion\"]");
    public SelenideElement selectTipoPlanta = $x("//*[@id=\"mercanciaGrid.idTipoPlanta\"]");
    public SelenideElement selectCantidadPresentacion = $x("//*[@id=\"cantidadPresentacion\"]");
    public SelenideElement selectPlantaAutorizada = $x("//*[@id=\"mercanciaGrid.idPlantaAutorizada\"]");
    //DETALLE ANIMALES
    public SelenideElement inputNumeroLote = $x("//*[@id=\"numeroLoteDetalle\"]");
    public SelenideElement inputColorPelaje = $x("//*[@id=\"colorPelajeDetalle\"]");
    public SelenideElement inputEdadAnimal = $x("//*[@id=\"edadAnimalDetalle\"]");
    public SelenideElement inputFaseDesarrollo = $x("//*[@id=\"faseDesarrolloDetalle\"]");
    public SelenideElement inputFuncionZootecnica = $x("//*[@id=\"funcionZootecnicaDetalle\"]");
    public SelenideElement inputNombreMercancia = $x("//*[@id=\"nombreMercanciaDetalle\"]");
    public SelenideElement inputNumeroIdentificacion = $x("//*[@id=\"numeroidentificacionDetalle\"]");
    public SelenideElement inputRaza = $x("//*[@id=\"razaDetalle\"]");
    public SelenideElement inputNombreCientifico = $x("//*[@id=\"nombreCientificoDetalle\"]");
    public SelenideElement selectSexo = $x("//*[@id=\"mercanciaGrid.idSexo\"]");
    public SelenideElement btnEliminarDetalle = $x("//*[@id=\"btnEliminarMercanciasDetalle\"]");
    public SelenideElement btnAgregarDetalle = $x("//*[@id=\"btnAgregarMercanciasDetalle\"]");
    public SelenideElement checkDetalle = $x("//*[@id=\"jqg_gridDetalle2201Producto_0\"]");
    public SelenideElement btnCargaArchivo = $x("//*[@id=\"btnAgregarDetalleMasiva\"]");
    public SelenideElement btnLimpiar = $x("//*[@id=\"btnLimpiarMercancia\"]");
    public SelenideElement btnCancelar = $x("//*[@id=\"btnCancelarMercancia\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"btnAgregarMercancia\"]");
    //DETALLE PRODUCTOS
    public SelenideElement inputRangoFechaNo = $x("//*[@id=\"rangoFechasDetalleUno\"]");
    public SelenideElement inputRangoFechaSi = $x("//*[@id=\"rangoFechasDetalleDos\"]");
    public SelenideElement inputFechaElaboracionDe = $x("//*[@id=\"fechaDeElaboracion\"]");
    public SelenideElement inputFechaElaboracionHa = $x("//*[@id=\"fechaElaboracionFin\"]");
    public SelenideElement inputFechaProduccionDe = $x("//*[@id=\"fechaSacrificio\"]");
    public SelenideElement inputFechaProduccionHa = $x("//*[@id=\"fechaSacrificioFin\"]");
    public SelenideElement inputFechaCaducidadDe = $x("//*[@id=\"fechaDeCaducidad\"]");
    public SelenideElement inputFechaCaducidadHa = $x("//*[@id=\"fechaDeCaducidadFin\"]");
    //Datos para movilizacion nacional
    public SelenideElement labelDatosMovilizacionNacional = $x("//*[@id=\"ui-id-3\"]/label");
    //Destino
    public SelenideElement inputCoordenadasGeograficas = $x("//*[@id=\"tabs-3\"]/div[1]/div/div[2]/input");
    //Medio de transporte
    public SelenideElement selectMedioTransporte = $x("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]");
    public SelenideElement inputIdentificacionTrasnporte = $x("//*[@id=\"tabs-3\"]/div[2]/div[2]/div[2]/input");
    public SelenideElement selectPuntoVerificacionFed = $x("//*[@id=\"solicitud.transporte.puntoVerificacion.idPuntoVerificacion\"]");
    public SelenideElement inputNombreEmpresaTrasnportista = $x("//*[@id=\"tabs-3\"]/div[4]/div/div[2]/input");
    //Terceros Relacionados
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[3]/ul/li[4]/a/label");
    //Exportador
    public SelenideElement btnAgregarExportador = $x("//*[@id=\"agregarTercero_TIPERS_EXP\"]");
    public SelenideElement btnBuscarExportador = $x("//*[@id=\"buscarTercero_TIPERS_EXP\"]");
    //Destinatario
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement btnBuscarDestinatario = $x("//*[@id=\"buscarTercero_TIPERS_DES\"]");
    //Agregar Terceros Moral
    public SelenideElement inputMoralAT = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputAgregarRazonSocial = $x("//*[@id=\"terceros_rSocial\"]");
    //Buscar Terceros Moral
    public SelenideElement inputMoral = $x("//*[@id=\"tipoPersonaMoral\"]");
    public SelenideElement inputRazonSocial = $x("//*[@id=\"razonSocial\"]");
    //Agregar Terceros Fisica
    public SelenideElement inputFisicaAT = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputNombreTF = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputApellidoPTF = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputApellidoMTF = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement selectPaisTF = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputCodigoPostalTF = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement selectEstadoTF = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement selectMunicipioTF = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement selectColoniaTF = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputCalleTF = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement inputDomicilioTF = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement inputNumExterior = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement inputNumInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputLadaTF = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTelefonoTF = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement inputCorreoTF = $x("//*[@id=\"terceros_correoElec\"]");
    //TIF
    public SelenideElement inputTIF = $x("//*[@id=\"terceros_plantaTIF\"]");
    public SelenideElement inputNombreEstaTIF = $x("//*[@id=\"terceros_nomTIF\"]");
    public SelenideElement inputNumeroEstaTIF = $x("//*[@id=\"terceros_numeroTIF\"]");
    public SelenideElement btnBuscarTIF = $x("//*[@id=\"buscarPlantaTIF\"]");
    //Buscar Terceros Fisica
    public SelenideElement inputFisica = $x("//*[@id=\"tipoPersonaFisica\"]");
    public SelenideElement inputNombre = $x("//*[@id=\"nombre\"]");
    public SelenideElement inputApellidoPaterno = $x("//*[@id=\"apellidoPaterno\"]");
    public SelenideElement inputApellidoMaterno = $x("//*[@id=\"apellidoMaterno\"]");
    public SelenideElement inputCorreoElectronicoF = $x("//*[@id=\"correoElectronico\"]");
    public SelenideElement selectPais = $x("//*[@id=\"tercero_selectPais\"]");
    public SelenideElement selectEntidadFederativa = $x("//*[@id=\"tercero_selectEstado\"]");
    //Botones Agregar Terceros
    public SelenideElement btnLimpiarAgregarTerceros = $x("//*[@id=\"btnLimpiarFrmDatosTercero\"]");
    public SelenideElement btnCancelarAgregarTerceros = $x("//*[@id=\"btnCancelarFrmDatosTercero\"]");
    public SelenideElement btnAgregarTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //Botones Buscar Terceros
    public SelenideElement btnCerrarTerceros = $x("//*[@id=\"btnCerrarFrmDatosTercero\"]");
    public SelenideElement btnLimpiarTerceros = $x("//*[@id=\"btnLimpiarFrmDatosTercero\"]");
    public SelenideElement btnBuscarTerceros = $x("//*[@id=\"buscarTerceros\"]");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("//*[@id=\"ui-id-5\"]/label");
    public SelenideElement inputExentoPagoNo = $x("//*[@id=\"exentoPagoNo\"]");
    public SelenideElement inputExentoPagoSi = $x("//*[@id=\"exentoPagoSi\"]");
    public SelenideElement inputJustificacion = $x("//*[@id=\"solicitud.pago.motivoExentoPago\"]");
    public SelenideElement selectBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inputLlavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement inputFechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement btnBorrarDatosPago = $x("//*[@id=\"borrarDatosPago\"]");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarSolicitudParcial\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}