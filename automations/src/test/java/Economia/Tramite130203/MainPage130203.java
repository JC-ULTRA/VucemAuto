package Economia.Tramite130203;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130203 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement direccionGeneralNormas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement exportacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[2]/a");
    public SelenideElement elementoTramite130203 = $x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[2]/ul/li[2]/a");

    //Pestaña Datos de la solicitud
    //Datos del trámite a realizar
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement selectRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement selectClasificacion = $x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    //Datos de la mercancia
    public SelenideElement radbtnProductoNuevo = $x("//*[@id=\"tabs-3\"]/div[3]/div[1]/div[1]/input");
    public SelenideElement radbtnProductoUsado = $x("//*[@id=\"tabs-3\"]/div[3]/div[1]/div[2]/input");
    public SelenideElement inputDescripcion = $x("//*[@id=\"solicitud.mercancia.descripcion\"]");
    public SelenideElement selectFraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFactura = $x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement selectUMT = $x("//*[@id=\"unidadTarifariaComboId\"]");
    //Partidas de la mercancía
    public SelenideElement inputCantidadPartida = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputValorPartida = $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement inputDescripcionPartida = $x("//*[@id=\"descripcion\"]");
    public SelenideElement btnAgregarPartida = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div/input[2]");
    //Pais Destino
    public SelenideElement selectBloquePais = $x("//*[@id=\"bloqueAutocomplete\"]");
    public SelenideElement listaPaisDestino = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregarPais = $x("//*[@id=\"agregarPaisBloque\"]");
    public SelenideElement textareaUsoEspecifico = $x("//*[@id=\"tabs-3\"]/div[17]/div/div[2]/textarea");
    public SelenideElement textareaJustificacion = $x("//*[@id=\"tabs-3\"]/div[18]/div/div/textarea");
    public SelenideElement NumPermisoImport = $x("//*[@id=\"permisoImportacion\"]");
    public SelenideElement textareaObservaciones = $x("//*[@id=\"tabs-3\"]/div[20]/div/div[2]/textarea");
    //Representación Federal
    public SelenideElement selectEntidad = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selectRepresentacionFederal = $x("//*[@id=\"representacionFederalSelect\"]");

    //Pestaña Certificado Kimberley
    public SelenideElement tabCertificadoKimberley = $x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement NumCertificadoKimberley = $x("//*[@id=\"solicitud.certificadoKimberly.idCertificadoKimberlyImportacion\"]");
    public SelenideElement selectPaisEmisorCertificadoKimberley = $x("//*[@id=\"solicitud.certificadoKimberly.certificadoKimberlyPKPais\"]");
    public SelenideElement checkMixedPais = $x("//*[@id=\"origen\"]");
    public SelenideElement selectPaisOrigenKim = $x("//*[@id=\"solicitud.certificadoKimberly.claveOrigen\"]");
    //Datos del exportador
    public SelenideElement DireccionExportador = $x("//*[@id=\"solicitud.certificadoKimberly.direccionExportador\"]");
    //Datos del importador
    public SelenideElement NombreImportador = $x("//*[@id=\"solicitud.certificadoKimberly.nombreImportador\"]");
    public SelenideElement DireccionImportador = $x("//*[@id=\"solicitud.certificadoKimberly.direccionImportador\"]");
    //Daros de la remesa
    public SelenideElement NumLetrasLotes = $x("//*[@id=\"solicitud.certificadoKimberly.descripcionNumeroRemesa\"]");
    public SelenideElement NumLetrasLotesIngles = $x("//*[@id=\"solicitud.certificadoKimberly.descripcionNumeroRemesaIngles\"]");
    public SelenideElement NumFactura = $x("//*[@id=\"solicitud.certificadoKimberly.numeroFacturaRemesa\"]");
    //Datos de los diamantes
    public SelenideElement CantidadQuilates = $x("//*[@id=\"solicitud.certificadoKimberly.numeroKilates\"]");
    public SelenideElement ValorDiamantes = $x("//*[@id=\"solicitud.certificadoKimberly.valorDiamantes\"]");




    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");




}
