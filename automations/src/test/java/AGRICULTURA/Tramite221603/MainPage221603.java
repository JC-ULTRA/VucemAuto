package AGRICULTURA.Tramite221603;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage221603 {

    //Tramite 221603
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

    //Datos del trámite a realizar
    public SelenideElement numGuia = Selenide.$x("//*[@id=\"tabs-2\"]/div[7]/div[1]/div[2]/input");
    public SelenideElement regimen = Selenide.$x("//*[@id='solicitud.regimen.clave']");

    //Agregar/Modificar Mercancía
    public SelenideElement agregarMercancia = Selenide.$x("//*[@id='btnAgregarMercancias']");
    public SelenideElement gridMercancia1 = $x("//*[@id=\"jqg_gridMercanciasTram220203_3\"]");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"btnModificarMercancias\"]");
    //Datos mercancía
    public SelenideElement tipoRequisito = Selenide.$x("//*[@id='mercanciaGrid.idTipoRequisito']");
    public SelenideElement requisito = Selenide.$x("//*[@id='requisitos']");
    public SelenideElement numCertificado = Selenide.$x("//*[@id='numeroCertificado']");
    public SelenideElement fracArancelaria = Selenide.$x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
    public SelenideElement NICO = Selenide.$x("//*[@id='idFraccionNico']");
    public SelenideElement descripcion = Selenide.$x("//*[@id='mostrarDescripcionFraccionUsuario']");
    public SelenideElement cantUMT = Selenide.$x("//*[@id='cantidadUMT']");
    public SelenideElement cantUMC = Selenide.$x("//*[@id='cantidadUMC']");
    public SelenideElement tipoUMC = Selenide.$x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
    public SelenideElement tipoUso = Selenide.$x("//*[@id='mercanciaGrid.idUso']");
    public SelenideElement numLote = Selenide.$x("//*[@id='numeroLote']");
    public SelenideElement faseDesarrollo = Selenide.$x("//*[@id='faseDesarrollo']");
    public SelenideElement especie = Selenide.$x("//*[@id='descripcionEspecie']");
    public SelenideElement paisOrigen = Selenide.$x("//*[@id='mercanciaGrid.clavesPaisesOrigen']");
    public SelenideElement paisProcedencia = Selenide.$x("//*[@id='mercanciaGrid.clavesPaisesProcedencia']");
    //Detalle
    public SelenideElement nombreCientifico = Selenide.$x("//*[@id='nombreCientificoDetalle220203']");
    public SelenideElement btnAgregarDetalle = Selenide.$x("//*[@id='btnAgregarMercanciasDetalle']");
    //Guardar registro o modificación de mercancía
    public SelenideElement btnAgregarMercancia = Selenide.$x("//*[@id='btnAgregarMercancia']");
    public SelenideElement btnModificacionInfoMercancia = $x("//*[@id=\"btnModificarMercancia\"]");

    //Pestaña Datos para movilización nacional
    public SelenideElement datosMovilizacionN = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[3]/a/label");
    //Medio de transporte
    public SelenideElement medioTransporte = Selenide.$x("//*[@id='solicitud.transporte.ideMedioTransporte']");
    public SelenideElement identificacionTransporte = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[3]/div[1]/div[2]/div[2]/input");
    public SelenideElement puntoVerificacion = Selenide.$x("//*[@id='solicitud.transporte.puntoVerificacion.idPuntoVerificacion']");
    public SelenideElement nombreTransportista = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[3]/div[3]/div/div[2]/input");

    //Pestaña Terceros relacionados
    public SelenideElement tercerosRelacionados = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[4]/a/label");

    //Agregar/Modificar Exportador
    public SelenideElement agregarExportador = Selenide.$x("//*[@id='agregarTercero_TIPERS_EXP']");
    public SelenideElement gridExportador1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_EXP_0\"]");
    public SelenideElement btnModificarExportador = $x("//*[@id=\"modificarTercero_TIPERS_EXP\"]");

    //Agregar/Modificar Destinatario
    public SelenideElement agregarDestinatario = Selenide.$x("//*[@id='agregarTercero_TIPERS_DES']");
    public SelenideElement gridDestinatario1 = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement btnModificarDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");

    //Datos personales Terceros
    public SelenideElement paisTercero = Selenide.$x("//*[@id='terceros_selectPais']");
    public SelenideElement domicilioTercero = Selenide.$x("//*[@id='terceros_domicilioExtranjero']");
    public SelenideElement personaMoral = Selenide.$x("//*[@id='terceros_tipoPersonaMoral']");
    public SelenideElement razonTercero = Selenide.$x("//*[@id='terceros_rSocial']");
    public SelenideElement cpTercero = Selenide.$x("//*[@id='terceros_codPostal']");
    public SelenideElement estadoTercero = Selenide.$x("//*[@id='terceros_selectEstado']");
    public SelenideElement municipioTerceros = Selenide.$x("//*[@id='terceros_selectMunicipio']");
    public SelenideElement coloniaTercero = Selenide.$x("//*[@id='terceros_selectColonia']");
    public SelenideElement calleTercero = Selenide.$x("//*[@id='terceros_calle']");
    public SelenideElement numExt = Selenide.$x("//*[@id='terceros_numExterior']");
    public SelenideElement numInt = Selenide.$x("//*[@id='terceros_numInterior']");
    public SelenideElement ladaTercero = Selenide.$x("//*[@id='terceros_lada']");
    public SelenideElement telefonoTercero = Selenide.$x("//*[@id='terceros_telefono']");
    public SelenideElement correoTercero = Selenide.$x("//*[@id='terceros_correoElec']");
    public SelenideElement guardarTercero = Selenide.$x("//*[@id='btnGuardarFrmDatosTercero']");

    //Pago de derechos
    public SelenideElement radbtnExentoPago = $x("//*[@id=\"exentoPagoSi\"]");
    public SelenideElement selectJustificacionExentoPago = $x("//*[@id=\"solicitud.pago.motivoExentoPago\"]");
    public SelenideElement pagoDerechos = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[5]/a/label");
    public SelenideElement banco = Selenide.$x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement llaveBanco = Selenide.$x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement fechaPago = Selenide.$x("//*[@id='calendarTo']");
    //Continuar Paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //PASO 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub Paso 3
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");


}
