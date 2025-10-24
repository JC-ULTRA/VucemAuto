package COFEPRIS.Tramite260701;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage260701 {
    //Tramite 260701
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Busqueda folio sub tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar modificación y prórroga
    public SelenideElement btnModificacionProrroga = $x("//*[@id=\"MYPButton\"]");
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");   //*[@id="ui-id-2"]/label
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[28]/div[3]/div/button");

    //LLenado de datos
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement radbtnModificacion = $x("//*[@id=\"mod\"]");
    public SelenideElement JustificacionModificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement inputSolicitudEstablecimientoCorreoElectronico = $x("//*[@id='solicitud.establecimiento.correoElectronico']");

    //Domicilio del establecimiento
    public SelenideElement inputSolicitudEstablecimientoDomicilioCodigo = $x("//*[@id='solicitud.establecimiento.domicilio.codigoPostal']");
    public SelenideElement selectSolicitudEstablecimientoDomicilioEntidad = $x("//*[@id='solicitud.establecimiento.domicilio.entidadFederativa.clave']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioMunicipioAlcadia = $x("//*[@id='solicitud.establecimiento.domicilio.descripcionMunicipio']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioLocalidad = $x("//*[@id='solicitud.establecimiento.domicilio.informacionExtra']");
    public SelenideElement getInputSolicitudEstablecimientoDomicilioColonia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionColonia\"]");
    public SelenideElement inputSolicitudEstablecimientoDomicilioCalle = $x("//*[@id='solicitud.establecimiento.domicilio.calle']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioLada = $x("//*[@id='solicitud.establecimiento.domicilio.lada']");
    public SelenideElement inputSolicitudEstablecimientoDomicilioTelefono = $x("//*[@id='solicitud.establecimiento.domicilio.telefono']");

    //Agregar S.C.I.A.N.
    public SelenideElement btnAgregarScian = $x("//*[@id='btnScianAgregar']");
    public SelenideElement selectComboScian = $x("//*[@id='comboSCIAN']");
    public SelenideElement selectComboDescripcionScian = $x("//*[@id='comboDescripcionSCIAN']");
    public SelenideElement btnAgregar2Scian = $x("//*[@id=\"frmSCIAN\"]/div[1]/div[4]/div[2]/div/input[3]");

    //Check Aviso
    public SelenideElement checkAvisoFuncionamiento = $x("//*[@id='avisoFuncionamiento']");
    public SelenideElement inputNumeroLicencia = $x("//*[@id='numeroLicencia']");

    //check VIVO/Fresco/ENHIELADO
    public SelenideElement checkVivoFrescEnhielado = $x("//*[@id=\"tabs-2\"]/div[19]/div/label/input");
    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectAduanasEntrada = $x("//*[@id=\"aduanas\"]");

    //Mercancias Modificar
    public SelenideElement selectGridElemento1Mercancia = $x("//*[@id=\"jqg_gridMercanciasTram2601_3\"]");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarAduana\"]");
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
    //País origen
    public SelenideElement btnDesplegarInfoPaisOrigen = $x("//*[@id=\"input32\"]");
    public SelenideElement buttonResolution = $x("//button[@href='#panel-listaPaisesDeOrigen']");
    public SelenideElement optionAntartida = $x("//*[@id=\"paisesDeOrigen\"]/option[7]");
    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");
    //País procedencia
    public SelenideElement btnDesplegarInfoPaisProcedencia = $x("//*[@id=\"input39\"]");//*[@id="input39"]
    public SelenideElement buttonResolution2 = $x("//button[@aria-controls='panel-listaPaisesDeProcedencia']");
    public SelenideElement MenuPaisesProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inputAdd2 = $x("//*[@id=\"panel-listaPaisesDeProcedencia\"]/div/div/div[2]/div/div/input[2]");
    //Clave Lotes y fechas
    public SelenideElement checkGridClaveLote1 = $x("//*[@id=\"jqg_gridNumeroLotes_3\"]");
    public SelenideElement btnModificarClaveLote = $x("//*[@id=\"modificarNumeroLote\"]");
    public SelenideElement btnGuardarModificarClaveLote = $x("//*[@id=\"saveNumeroLote\"]");
    public SelenideElement inputClaveLotes = $x("//*[@id='claveLotes']");
    public SelenideElement inputFechaElaboracion = $x("//*[@id='fechaDeElaboracion']");
    public SelenideElement inputFechaCaducidad = $x("//*[@id='fechaDeCaducidad']");
    public SelenideElement inputAgregarNumeroLote = $x("//*[@id='agregarNumeroLote']");
    //Uso especifico
    public  SelenideElement btnDesplegarInfoUsoEspecifico = $x("//*[@id=\"input46\"]");
    public SelenideElement MenuUsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement inputAdd3 = $x("//*[@id=\"panel-listaUsosEspecificos\"]/div/div/div[2]/div/div/input[2]");

    public SelenideElement btnGuardarModificarMercancia = $x("//*[@id=\"btnModificarMercancia\"]");

    //Representabte Legal
    public SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");
    public SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");


    //ELEMENTOS PESTAÑA TERCEROS RELACIONADOS
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");
    //Modificar Destinatario (FInal)
    public SelenideElement checkGridTerceroDestino1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarTerceroDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    public SelenideElement radbtnTipoPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement radbtnTipoPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement MoralFabricanteRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement DenominacionFabricanteMoral = $x("//*[@id=\"terceros_rSocial\"]");
    //Domicilio Destinatario
    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");
    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");
    public SelenideElement selectTercerosLocalidad = $x("//*[@id='terceros_selectLocalidad']");
    public SelenideElement selectTercerosCodPostal = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement selectTercerosColonia = $x("//*[@id='terceros_selectColonia']");
    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");
    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");
    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");
    public SelenideElement inputTerceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    public SelenideElement btnGuardarTerceroDestinatario = $x("//*[@id='btnGuardarFrmDatosTercero']");
    //Modificar Fabricante
    public SelenideElement checkGridTerceroFabricante1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_FAB_0\"]");
    public SelenideElement btnModificarTerceroFabricante = $x("//*[@id=\"modificarTercero_TIPERS_FAB\"]");
    public SelenideElement btnAgregarFabricante = $x("//*[@id=\"agregarTercero_TIPERS_FAB\"]");
    public SelenideElement radbtnNacionalTerceros = $x ("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement radbtnPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement radbtnPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement FabricanteRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement btnBuscarFabricante = $x("//*[@id=\"buscarEmpresa\"]");
    public SelenideElement btnGuardarModificarFabricante = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");


    //ELEMENTO PESTALA PAGO DE DERECHOS
    public SelenideElement tabPagoDerechos = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement ClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement CadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement ImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelectArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelectArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnPasarFirma = $x("//*[@id=\"siguienteButton\"]");

    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioFun = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement justificacionDictamen = $x("//*[@id=\"observaciones\"]");
    public SelenideElement requisito = $x("//*[@id=\"tramite.dictamen.restriccionesDictamen[0].restriccionTipoTramite.idRestriccionTipoTramite\"]");
    public SelenideElement tipoAnalisis = $x("//*[@id=\"valueTO\"]");
    public SelenideElement numMuestras = $x("//*[@id=\"idNoMuestras\"]");
    public SelenideElement siglasDictaminador = $x("//*[@id=\"siglasDictaminador\"]");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[3]");
    public SelenideElement darVoBo = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement firmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form/table[2]/tbody/tr/td/input[1]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}
