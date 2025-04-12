package COFEPRIS.Tramite260101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("/html/body/main/div/div[3]/div/form/a[3]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkPermisoSanitarioImportaciProductos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement linkPermisoSanitarioPrevioImportaci = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-gubernamentales-HA/invocarModulo.action?init','/ventanilla-gubernamentales-HA//gubernamentales2/cofepris/importacionProductos/registrarSolicitudIP.action?solicitud.discriminatorValue=260101&iniciar','260101','','')\"]");
    //DATOS
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[1]/ul/li[2]/a/label");
    public SelenideElement inputEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement divAceptar = $x("/html/body/div[26]/div[3]/div/button");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioInformacion = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion2 = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionColonia']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
    public SelenideElement inputScianAgregar = $x("//*[@id='btnScianAgregar']");
    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");
    public SelenideElement inputAgregar = $x("//input[@onclick='javascript:agregarDatosSCIAN();']");
    public SelenideElement inputAgregar2 = $x("//*[@id='avisoFuncionamiento']");
    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");
    public SelenideElement inputSolicitudTienePrioridad = $x("//input[@name='solicitud.tienePrioridad']");
    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectSolicitudRegimenClave2 = $x("//*[@id='aduanas']");
    public SelenideElement selectAduanas = $x("//*[@id='btnagregarAduana']");
    //Datos Mercancia
    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");
    public SelenideElement selectMercanciaGridClasificacionProducto2 = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");
    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");
    public SelenideElement inputDenominacionEspecifica2 = $x("//*[@id='idDenominacionDistintiva']");
    public SelenideElement inputTipoTramiteMercancia = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");
    public SelenideElement inputTipoProductoDescripcionOtros = $x("//*[@id='idTipoProductoDescripcionOtros']");
    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement inputDetalleUmc = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement buttonResolution = $x("//button[@href='#panel-listaPaisesDeOrigen']");
    public SelenideElement buttonResolution2 = $x("//button[@href='#panel-listaPaisesDeOrigen']");
    public SelenideElement optionAnguila = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[1]/div[2]/select/option[6]");
    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");
    public SelenideElement buttonResolution3 = $x("//button[@aria-controls='panel-listaPaisesDeProcedencia']");
    public SelenideElement optionAndorraPrincipado = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[1]/div[2]/select/option[4]");
    public SelenideElement inputAdd2 = $x("//input[contains(@onclick, \"remover('paisesDeProcedencia1',\")]");
    public SelenideElement inputClaveLotes = $x("//*[@id='claveLotes']");
    public SelenideElement inputFechaElaboracion = $x("//*[@id='fechaDeElaboracion']");
    public SelenideElement inputFechaCaducidad = $x("//*[@id='fechaDeCaducidad']");
    public SelenideElement inputAgregarNumeroLote = $x("//*[@id='agregarNumeroLote']");
    public SelenideElement buttonResolution4 = $x("//button[@aria-expanded='false']");
    public SelenideElement optionDonaciones = $x("//option[@title='DONACIONES ']");
    public SelenideElement inputAdd3 = $x("//input[contains(@onclick, \"remover('usoEspecifico1',\")]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement inputDeclaracion = $x("//*[@id='declaracion[0]']");
    public SelenideElement inputInformacionConfidencial = $x("//*[@id='informacionConfidencialSi']");
    public SelenideElement inputResultadoIdc = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement inputConsultarIdc = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[1]/div/div[2]/div[29]/div[2]/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //TERCEROS RELACIONADOS
    public SelenideElement labelTerceros = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[1]/ul/li[3]/a/label");
    public SelenideElement inputAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement inputTercerosTipoPersonaMoral = $x("//*[@id='terceros_tipoPersonaMoral']");
    public SelenideElement inputTerceros = $x("//*[@id='terceros_rfc']");
    public SelenideElement inputTercerosSocial = $x("//*[@id='terceros_rSocial']");
    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");
    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");
    public SelenideElement selectTercerosLocalidad = $x("//*[@id='terceros_selectLocalidad']");
    public SelenideElement selectTercerosCodPostal = $x("//*[@id=\"divContenidoCampoSelectCodPostal1\"]");
    public SelenideElement PostalCode = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[1]/fieldset/div[3]/div[1]/div[7]/div[5]/div/div[1]/select");
    public SelenideElement selectTercerosColonia = $x("//*[@id='terceros_selectColonia']");
    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");
    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");
    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");
    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");
    //Fabricante
    public SelenideElement inputAgregarTerceroTipersFab = $x("//*[@id='agregarTercero_TIPERS_FAB']");
    public SelenideElement inputTercerosNacionalidadMexicana = $x("//*[@id='terceros_nacionalidadMexicana']");
    public SelenideElement inputTercerosTipoPersonaMoral2 = $x("//*[@id='terceros_tipoPersonaMoral']");
    public SelenideElement inputTerceros2 = $x("//*[@id='terceros_rfc']");
    public SelenideElement btnBuscarEmpresa = $x("//*[@id=\"buscarEmpresa\"]");
    public SelenideElement buttonGuardarDatosTercero2 = $x("//*[@id='btnGuardarFrmDatosTercero']");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos =$x("/html/body/main/div[1]/div[4]/div[1]/form/div[1]/ul/li[4]/a/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("//*[@id=\"docs\"]/tbody/tr[14]/td[2]/div/input[2]");
    //ADJUNTAR
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc8 = $x("/html/body/main/div/div[4]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc9 = $x("/html/body/main/div/div[4]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc10 = $x("/html/body/main/div/div[4]/div[2]/div/form[11]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc11 = $x("/html/body/main/div/div[4]/div[2]/div/form[12]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");



}
