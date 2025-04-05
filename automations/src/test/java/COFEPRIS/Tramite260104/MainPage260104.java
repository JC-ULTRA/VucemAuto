package COFEPRIS.Tramite260104;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage260104 {
    //Tramite 260104
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("//img[contains(@alt, 'para')]");
    public SelenideElement CertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement PermisoSanitarioImportaciProductos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement Tramite260104 = $x("//a[contains(@onclick, 'ab')]");
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id='ui-id-2']");
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[27]/div[3]/div/button");

    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");

    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
//select
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioDescripcion = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioInformacion = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioLada = $x("//*[@id='solicitud.establecimiento.domicilio.lada']");

    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");
//Agregar S.C.I.A.N.
    public SelenideElement inputScianAgregar = $x("//*[@id='btnScianAgregar']");

    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");

    public SelenideElement selectComboDescripcionScian = $x("//*[@id='comboDescripcionSCIAN']");

    public SelenideElement inputAgregar = $x("//input[@onclick='javascript:agregarDatosSCIAN();']");
//Check Aviso
    public SelenideElement inputAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");

    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");

    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");

    public SelenideElement selectAduanas = $x("//*[@id='aduanas']");
    
// Agregar Mercancía
    public SelenideElement inputBtnagregarAduana = $x("//*[@id='btnagregarAduana']");

    public SelenideElement selectMercanciaGridClasificacionProducto = $x("//*[@id='mercanciaGrid.idClasificacionProducto']");

    public SelenideElement selectMercanciaGridIdeSub = $x("//*[@id='mercanciaGrid.ideSubClasificacionProducto']");

    public SelenideElement inputDenominacionEspecifica = $x("//*[@id='idDenominacionEspecifica']");

    public SelenideElement inputDenominacionDistintiva = $x("//*[@id='idDenominacionDistintiva']");

    public SelenideElement selectMercanciaGridTipoProducto = $x("//*[@id='mercanciaGrid.tipoProducto.idTipoProductoTipoTramite']");

    public SelenideElement inputFraccionArancelaria = $x("//*[@id='fraccionArancelaria']");

    public SelenideElement inputCantidadUmt = $x("//*[@id='cantidadUMT']");

    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");

    public SelenideElement selectMercanciaGridUnidadMedida = $x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");

//País origen
    public SelenideElement buttonResolution = $x("//button[@href='#panel-listaPaisesDeOrigen']");

    public SelenideElement optionAntartida = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[1]/div[2]/select/option[7]");

    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");
//País procedencia
    public SelenideElement buttonResolution2 = $x("//button[@aria-controls='panel-listaPaisesDeProcedencia']");

    public SelenideElement optionAlbaniaRepublica = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[1]/div[2]/select/option[2]");

    public SelenideElement inputAdd2 = $x("//input[contains(@onclick, \"remover('paisesDeProcedencia1',\")]");

    public SelenideElement inputClaveLotes = $x("//*[@id='claveLotes']");
//Fecha fabricación
    public SelenideElement inputFechaElaboracion = $x("//*[@id='fechaDeElaboracion']");

//Fecha de caducidad
    public SelenideElement inputFechaCaducidad = $x("//*[@id='fechaDeCaducidad']");

    public SelenideElement inputAgregarNumeroLote = $x("//*[@id='agregarNumeroLote']");
//Uso específco
    public SelenideElement buttonResolution3 = $x("//button[@aria-expanded='false']");

    public SelenideElement optionDistribuci = $x("//option[@value='83']");

    public SelenideElement inputAdd3 = $x("//input[contains(@onclick, \"remover('usoEspecifico1',\")]");

    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    
//Check Manifiesto
    public SelenideElement inputDeclaracion = $x("//*[@id='declaracion[0]']");

    public SelenideElement inputInformacionConfidencial = $x("//*[@id='informacionConfidencialNo']");

//Representante legal
    public SelenideElement inputRepresentanteLegal = $x("//*[@id='representanteLegalRFC']");

    public SelenideElement inputConsultarIdc = $x("//*[@id='consultarIDC']");
//Pestaña Terceros Relacionados
    public SelenideElement linkTercerosRelacionados = $x("//*[@id='ui-id-3']");

//Destinatatio
    public SelenideElement inputAgregarTerceroTipersDes = $x("//*[@id='agregarTercero_TIPERS_DES']");

    public SelenideElement inputTercerosTipoPersonaMoral = $x("//*[@id='terceros_tipoPersonaMoral']");

    public SelenideElement inputTerceros = $x("//*[@id='terceros_rfc']");

    public SelenideElement inputTercerosSocial = $x("//*[@id='terceros_rSocial']");

    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");

    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");

    public SelenideElement selectTercerosLocalidad = $x("//*[@id='terceros_selectLocalidad']");

    public SelenideElement selectTercerosCodPostal = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[1]/fieldset/div[3]/div[1]/div[8]/div[2]/div/div[1]/select");

    public SelenideElement selectTercerosColonia = $x("//*[@id='terceros_selectColonia']");

    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");

    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");

    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");

    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");

    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    //Fabricante
    public SelenideElement inputAgregarTerceroTipersFab = $x("//*[@id='agregarTercero_TIPERS_FAB']");

    public SelenideElement inputTercerosTipoPersonaFisica = $x("//*[@id='terceros_tipoPersonaFisica']");

    public SelenideElement inputTercerosNombre = $x("//*[@id='terceros_nombre']");

    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id='terceros_apellidoPaterno']");

    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id='terceros_apellidoMaterno']");

    public SelenideElement selectTercerosPais = $x("//*[@id='terceros_selectPais']");

    public SelenideElement inputTercerosEstadoLocalidad = $x("//*[@id='terceros_txtEstadoLocalidad']");

    public SelenideElement inputTercerosCodPostal = $x("//*[@id='terceros_codPostal']");

    public SelenideElement inputTercerosCalle2 = $x("//*[@id='terceros_calle']");

    public SelenideElement inputTercerosNumExterior2 = $x("//*[@id='terceros_numExterior']");

    public SelenideElement inputTercerosNumInterior2 = $x("//*[@id='terceros_numInterior']");

    public SelenideElement inputTercerosTelefono2 = $x("//*[@id='terceros_telefono']");

    public SelenideElement inputTercerosCorreoElec2 = $x("//*[@id='terceros_correoElec']");

    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");

    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    //Pestaña Pago de Derechos excento de pago si
    public SelenideElement button = $x("/html/body/div[28]/div[3]/div/button[2]");


    //Check tipo documento
    public SelenideElement inputDoctosEspecificos = $x("//*[@id='cb_jqgridDoctosEspecificos']");

    public SelenideElement inputDeleteButton = $x("//*[@id='deleteButton']");
//BTN Continuar
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");


//Adjuntar Documentos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");

    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");

    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[1].file']");

    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[2].file']");

    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[3].file']");

    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
//Btn Cerrar
    public SelenideElement inputCerrar = $x("//*[@id='btnCerrar']");
//Btn Continuar a firma solicitante
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");






}
