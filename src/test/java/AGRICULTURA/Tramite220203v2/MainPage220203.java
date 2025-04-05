package AGRICULTURA.Tramite220203v2;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPage220203 {
    //Tramite Aviso B8 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement btnFirmar = $x("//button[@onclick='ejecutarProcesoFirma(1)']");

    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //Inicio y seleccion de tramite 220203
    public SelenideElement agricultura = $x("//*[@id=\"workingArea\"]/form/a[10]/img");

    public SelenideElement linkCertificadosSolicitudRequisitos2 = $x("//*[@id=\"servicios\"]/ul/li/a");
    public SelenideElement linkCertificadoParaImportaciSolicitud = $x("//*[@id=\"servicios\"]/ul/li/ul/li[2]/a");
    public SelenideElement linkSenasicaSolicitudParaExpedici = $x("//*[@id=\"servicios\"]/ul/li/ul/li[2]/ul/li[3]/a");

    /** Captura de tramite **/
    //Datos de la solicitud
    public SelenideElement datosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");

    public SelenideElement selectAduana = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement seleccionAduana = $x("//*[@id=\"solicitud.claveAduana\"]/option[19]");

    public SelenideElement selectOficina = $x("//*[@id=\"solicitud.oficinaInspeccionAgropecuaria.clave\"]");
    public SelenideElement seleccionOficina = $x("//*[@id=\"solicitud.oficinaInspeccionAgropecuaria.clave\"]/option[2]");

    public SelenideElement selectPuntoInspeccion = $x("//*[@id=\"solicitud.unidadAdministrativaRepresentacionFederal.clave\"]");
    public SelenideElement seleccionPunto = $x("//*[@id=\"solicitud.unidadAdministrativaRepresentacionFederal.clave\"]/option[2]");

    public SelenideElement regimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement seleccionRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]/option[3]");

    /** Agregar mercancia **/
    public SelenideElement agregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");

    public SelenideElement tipoRequisito = $x("//*[@id=\"mercanciaGrid.idTipoRequisito\"]");
    public SelenideElement seleccionTipoRequisito = $x("//*[@id=\"mercanciaGrid.idTipoRequisito\"]/option[2]");

    public SelenideElement requisito = $x("//*[@id=\"requisitos\"]");

    public SelenideElement numCertInternacional = $x("//*[@id=\"numeroCertificado\"]");

    public SelenideElement selectFraccion = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]");
    public SelenideElement seleccionFraccion = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]/option[12]");

    public SelenideElement nico = $x("//*[@id=\"idFraccionNico\"]");
    public SelenideElement seleccionNico = $x("//*[@id=\"idFraccionNico\"]/option[2]");

    public SelenideElement descripccion = $x("//*[@id=\"mostrarDescripcionFraccionUsuario\"]");

    public SelenideElement cantidadUmt = $x("//*[@id=\"cantidadUMT\"]");

    public SelenideElement cantidadUmc = $x("//*[@id=\"cantidadUMC\"]");

    public SelenideElement selectUmc = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement seleccionUmc = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]/option[17]");

    public SelenideElement uso = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement selectUso = $x("//*[@id=\"mercanciaGrid.idUso\"]/option[2]");

    public SelenideElement numeroLote = $x("//*[@id=\"numeroLote\"]");

    public SelenideElement especie = $x("//*[@id=\"descripcionEspecie\"]");

    public SelenideElement paisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement seleccionPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]/option[18]");

    public SelenideElement paisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement seleccionPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]/option[15]");

    public SelenideElement guardarMercancia = $x("/html/body/main/div[1]/div[4]/div[3]/form/div[32]/div[2]/div/input[4]");

    /** Movilizacion y transporte **/
    public SelenideElement datosMovilizacion = $x("//*[@id='ui-id-3']/label");

    public SelenideElement selectTransporte = $x("//*[@id='solicitud.transporte.ideMedioTransporte']");
    public SelenideElement seleccionTransporte = $x("//*[@id='solicitud.transporte.ideMedioTransporte']/option[3]");

    public SelenideElement selectPuntoVerificacion = $x("//*[@id='solicitud.transporte.puntoVerificacion.idPuntoVerificacion']");
    public SelenideElement seleccionPuntoVerficacion = $x("//*[@id='solicitud.transporte.puntoVerificacion.idPuntoVerificacion']/option[20]");

    public SelenideElement nombreEmpresa = $x("//*[@id=\"tabs-3\"]/div[3]/div/div[2]/input");
    public SelenideElement guardarTransporte = $x("//*[@id=\"guardarSolicitudParcial\"]");

    /** Terceros **/
    public SelenideElement terceros = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement agregarExportador = $x("//*[@id=\"agregarTercero_TIPERS_EXP\"]");
    public SelenideElement tipoPersona = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement nombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement aPaterno = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement aMaterno = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement selectPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement seleccionPais = $x("//*[@id='terceros_selectPais']/option[20]");
    public SelenideElement domicilio = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement guardarExportador = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");

    /** Destinatario **/
    public SelenideElement agregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");

    public SelenideElement checkTipoPersona = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement razonSocial = $x("//*[@id=\"terceros_rSocial\"]");

    public SelenideElement selectEstado = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement seleccionEstado = $x("//*[@id=\"terceros_selectEstado\"]/option[20]");

    public SelenideElement selectMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement seleccionMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]/option[19]");

    public SelenideElement selectColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement seleccionColonia = $x("//*[@id=\"terceros_selectColonia\"]/option[17]");

    public SelenideElement calle = $x("//*[@id='terceros_calle']");
    public SelenideElement numeroExterior = $x("//*[@id=\"terceros_numExterior\"]");

    public SelenideElement guardarDestinatario = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");

    /** Pago de derechos **/
    public SelenideElement pagoDerechos = $x("//*[@id=\"ui-id-5\"]/label");

    public SelenideElement checkExentoPago = $x("//*[@id=\"exentoPagoNo\"]");

    public SelenideElement selectBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement seleccionBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]/option[19]");

    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");

    public SelenideElement seleccionFecha = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement selectDia = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a");


    //public SelenideElement guardarPago = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a");
    public SelenideElement guardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");

    /** Paso 2 y 3 **/
    public SelenideElement siguiente = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    /** Firmar solicitud **/
    public SelenideElement cer = $x("//*[@id=\"certificate\"]");
    public SelenideElement key = $x("//*[@id=\"privateKey\"]");
    public SelenideElement passw = $x("//*[@id='privateKeyPassword']");
    public SelenideElement firmarSolicitud = $x("//*[@id=\"btnSubmit\"]");

    //Obtenermos el folio generado
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[3]/div/div/ul/li");

}

