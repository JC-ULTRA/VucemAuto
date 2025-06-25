package COFEPRIS.Tramite261402;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage261402 {
    //Tramite 261402
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Busqueda de tramite subsecuente
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[4]/a");
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar Modificación
    public SelenideElement btnSolModificar = $x("//*[@id=\"modificarButton\"]");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement DatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");   //*[@id="ui-id-2"]/label
    public SelenideElement Justificacion = $x("//*[@id=\"justificacionId\"]");

    //Propietario
    public SelenideElement gridPropietario1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_PRO_0\"]");
    public SelenideElement btnModificarPropietario = $x("//*[@id=\"modificarTercero_TIPERS_PRO\"]");

    //Nacionalidad y tipo de persona
    public SelenideElement radbtnNacionalTerceros = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement radbtnExtranjeroTerceros= $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement radPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement radPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement radbtnNoContribuyente = $x("//*[@id=\"terceros_tipoNoContribuyente\"]");

    //Búsqueda persona Nacional
    public SelenideElement TercerosRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement TercerosCURP = $x("//*[@id=\"terceros_curp\"]");
    public SelenideElement btnBuscarTerceroRFC = $x("//*[@id=\"buscarEmpresa\"]");

    //Persona Moral
    public SelenideElement inputTercerosDenominacionRazon = $x("//*[@id=\"terceros_rSocial\"]");
    //Persona Física
    public SelenideElement inputTercerosNombre = $x("//*[@id='terceros_nombre']");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id='terceros_apellidoPaterno']");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id='terceros_apellidoMaterno']");

    //Datos personales Nacional
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
    //Datos personales Extranjero
    public SelenideElement listTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement TercerosEstadotxt = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement CodigoPostaltxt = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement TercerosColoniatxt = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    //Guardar Terceros/Propietario
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");


    //Datos del establecimiento
    public SelenideElement btnEstablecimiento = $x("//*[@id='btnEstablecimiento']");
    public SelenideElement buttonAceptar = $x("/html/body/div[26]/div[3]/div/button");
    public SelenideElement inputSolicitudEstablecimientoRazonSocial = $x("//*[@id='solicitud.establecimiento.razonSocial']");
    public SelenideElement CorreoEstablecimiento = $x("//*[@id=\"solicitud.establecimiento.correoElectronico\"]");    //Domicilio del establecimiento
    //Domicilio establecimiento
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

    //Profesional responsable
    public SelenideElement RfcResponsable = $x("//*[@id=\"solicitud_rfcCertificador\"]");
    public SelenideElement NombreResponsable = $x("//*[@id=\"solicitud_descripcionCertificador\"]");
    public SelenideElement NumLicenciaSanitaria = $x("//*[@id=\"numeroLicenciaSanitaria\"]");
    public SelenideElement btnAgregarLicSani = $x("//*[@id=\"cmdAgregar\"]");

    //Regimen destino mercancía
    public SelenideElement RegimenDestinoMerca = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement AduanaEntrada = $x("//*[@id=\"aduanasEntrada\"]");

    // Modificar mercancía producto
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarAduana\"]");
    public SelenideElement gridMercancia1 = $x("//*[@id=\"jqg_gridMercanciasTram2604_3\"]");

    public SelenideElement NombreEspecifico = $x("//*[@id=\"idDenominacionEspecifica\"]");
    public SelenideElement selectTipoProductoMerca = $x("//*[@id=\"mercanciaGrid.tipoProducto.idTipoProductoTipoTramite\"]");
    public SelenideElement fracArancel = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement CantidadUMTPro = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement CantidadVol = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement UnidadMedida = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[2]/div[8]/div[2]/div/select");
    public SelenideElement PresFarmaEnv = $x("//*[@id=\"presentacion\"]");

    //Condiciones de almacenamiento
    public SelenideElement EnvprimarioAl = $x("//*[@id=\"condicionAlmacenamientoPrimario\"]");
    public SelenideElement EnvSecundariAl = $x("//*[@id=\"condicionAlmacenamientoSecundario\"]");

    //Condiciones de transporte
    public SelenideElement EnvprimarioCT = $x("//*[@id=\"condicionTransPrimario\"]");
    public SelenideElement EnvSecundariTC = $x("//*[@id=\"condicionTransSecundario\"]");

    //País origen
    public SelenideElement btnDesplegarInfoPaisOrigen = $x("//button[contains(@onclick, 'abrirPanelPaisesOrigen')]");
    public SelenideElement btnRestarPaisOrigenTodos = $x("//input[@name='remove_all' and contains(@onclick, 'paisesDeOrigen')]");
    public SelenideElement listaPaisOrigen = $x("//*[@id=\"paisesDeOrigen\"]");
    public SelenideElement inputAdd = $x("//input[contains(@onclick, \"remover('paisesDeOrigen1',\")]");

    //País procedencia
    public SelenideElement btnDesplegarInfoPaisProcedencia = $x("//button[contains(@onclick, 'abrirPanelPaisesProcedencia')]");
    public SelenideElement btnRestarPaisProcedenciaTodos = $x("//input[@name='remove_all' and contains(@onclick, 'paisesDeProcedencia')]");
    public SelenideElement listaPaisProcedencia = $x("//*[@id=\"paisesDeProcedencia\"]");
    public SelenideElement inputAdd2 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");

    //Uso especifico
    public SelenideElement selectUsoEspesifico = $x("//*[@id=\"mercanciaGrid.clavesUsosEspecificos\"]");
    //Guardar modificación
    public SelenideElement btnModificarInfoMercancia = $x("//*[@id=\"btnModificarMercancia\"]");

    //Manifiesto e información
    public SelenideElement radNoHacerPublicoInformacion = $x("//*[@id=\"informacionConfidencialNo\"]");

    //Representabte Legal
    public  SelenideElement RepresentanteRFC = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement  btnBuscarRepresentante = $x("//*[@id=\"consultarIDC\"]");
    public  SelenideElement btnContinuarDatosCompletos = $x("//*[@id=\"guardarSolicitud\"]");

    //ELEMENTOS TERCEROS RELACIONADOS
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement gridProcedencia1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_INFPR_0\"]");
    public SelenideElement btnModificarProcedencia = $x("//*[@id=\"modificarTercero_TIPERS_INFPR\"]");

    //Pago de derechos
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
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[9]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo6 = $x("//*[@id=\"solicitud_5\"]/table/tbody/tr[1]/td[4]/input");

    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
