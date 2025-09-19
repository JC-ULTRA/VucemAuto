package MedioAmbiente.Tramite230202;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage230202 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement MedioAmbiente = $x("//img[contains(@alt, 'Medio')]");
    public SelenideElement linkCerLicPer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement link03046CFER = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
    public SelenideElement linkCerFitREE = $x("//a[contains(text(),'Certificado Fitosanitario de Reexportación')]");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form[1]/div[2]/ul/li[2]/a/label");
    public SelenideElement inputCertificado = $x("//*[@id=\"solicitud.numeroCertificado\"]");
    public SelenideElement selectAduanas = $x("//*[@id='aduanasSa']");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"origenlistaOrigen2\"]/option[7]");
    public SelenideElement inputAddlistaOrigen2 = $x("//*[@id=\"addlistaOrigen2\"]");
    public SelenideElement optionCiudadXico = $x("//option[@title='CIUDAD DE MÉXICO']");
    public SelenideElement inputAddlistaOrigen = $x("//*[@id='addlistaOrigen3']");
    public SelenideElement selectSolicitudDescripcionProducto = $x("//*[@id='solicitud.descripcionProducto.idDescripcionProducto']");
    public SelenideElement inputAgregarMercancias = $x("//input[@name='agregarAduana']");
    public SelenideElement selectMercanciaGridFraccionArancelaria = $x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGridGenero = $x("//*[@id='mercanciaGrid.genero']");
    public SelenideElement selectMercanciaGridEspecie = $x("//*[@id='mercanciaGrid.especie']");
    public SelenideElement selectMercanciaGridNombreComun = $x("//*[@id='mercanciaGrid.nombreComun.clave']");
    public SelenideElement inputAgregarMercancias2 = $x("//input[@name='agregarDetalle']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement selectSolicitudCantidadUmc = $x("//*[@id='solicitud.cantidadUMC']");
    public SelenideElement inputEntrada = $x("//*[@id='entrada']");
    public SelenideElement inputDescripcionGenerica = $x("//*[@id='descripcionGenerica1']");
    public SelenideElement selectSolicitudTransporteIdeMedio = $x("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]");
    public SelenideElement inputDescripcionTipoContenedor = $x("//*[@id=\"descripcionTipoContenedor\"]");
    public SelenideElement inputCodigoPostalDom = $x("//*[@id='codigoPostalDom']");
    public SelenideElement selectUbicacionMercanciaDomicilioEntidad = $x("//*[@id='ubicacionMercancia.domicilio.entidadFederativa.clave']");
    public SelenideElement inputCalleDom = $x("//*[@id='calleDom']");
    public SelenideElement inputDescripcionColoniaDom = $x("//*[@id='descripcionColoniaDom']");
    public SelenideElement inputNumeroExteriorDom = $x("//*[@id='numeroExteriorDom']");
    public SelenideElement inputNumInteriorDom = $x("//*[@id='numInteriorDom']");
    //TERCEROS
    public SelenideElement labelTerceros = $x ("/html/body/main/div[1]/div[4]/div[1]/form[1]/div[2]/ul/li[3]/a/label");
    public SelenideElement inputBotonAgregarDestinatario = $x("//*[@id='botonAgregarDestinatario']");
    //public SelenideElement inputNacional = $x("//*[@id='nacional']");
    //public SelenideElement inputExtranjero = $x("//*[@id='extranjero']");
    //FISICA
    public SelenideElement inputPfisica = $x("//*[@id='pfisica']");
    public SelenideElement inputNombre = $x("//*[@id='nombre']");
    public SelenideElement inputApellidoPaterno = $x("//*[@id='apellidoPaterno']");
    public SelenideElement inputApellidoMaterno = $x("//*[@id='apellidoMaterno']");
    //MORAL
    public SelenideElement inputPmoral = $x("//*[@id='pmoral']");
    public SelenideElement inputRazonSocial = $x("//*[@id='razonSocial']");
    public SelenideElement inputCodigoPostal = $x("//*[@id='codigoPostal']");
    public SelenideElement selectPaisSinMexico = $x("//*[@id='paisSinMexico']");
    public SelenideElement inputCiudad = $x("//*[@id='ciudad']");
    public SelenideElement textareaDomicilio = $x("//*[@id='domicilio']");
    public SelenideElement inputButtonGuardar = $x("//input[@value='Guardar']");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos = $x("//label[@style='font-weight:normal']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

    //INICIO
    public SelenideElement Inicio = $x("//a[contains(text(),'Inicio')]");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    public SelenideElement AntecendentesTextoDictamen = $x("//*[@id='textoDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");


    //OBSERVAR REQUERIMIENTO
    public SelenideElement JustificacionObservacionReq = $x("//*[@id=\"requerimientoSolicitud\"]/table/tbody/tr[5]/td/textarea");

    //ATENDER/MODIFICAR REQUERIMIENTO
    public SelenideElement tabCapRequerimiento = $x("//*[@id=\"tabs\"]/ul/li[1]/a/label");
    public SelenideElement justificaRequerimiento  = $x("//*[@id=\"justId\"]");
    public SelenideElement selecDocumentos = $x("//*[@id=\"alcanceRequerimientoId\"]");
    public SelenideElement tabSeleccionarDocumentos = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    public SelenideElement selectVerificacionDictamenDoc = $x("//a[text()='Dictamen de Verificación o Inspección']");
    public SelenideElement btnAgregarNuevoDocumento = $x("//*[@id=\"addDoctoEspecificoId\"]");
    public SelenideElement gridDocumento1 = $x("//td[text()='Dictamen de Verificación o inspección']/parent::tr//input[@type='checkbox']");
    public SelenideElement btnContinuar1Requerimiento = $x("//*[@id=\"mostrarFirmaId\"]");


    //Dictamen
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    //public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("//*[@id=\"1\"]/td[1]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement sentidoAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement CedulaInscripcion = $x("/html/body/div[1]/div[3]/div[3]/div/form/fieldset/table[3]/tbody/tr[4]/td[1]/input");
    public SelenideElement antecedentesDict = $x("//*[@id=\"valueTA\"]");
    public SelenideElement fechaVigencia = $x("//*[@id=\"fechaVigencia\"]");
    public SelenideElement fechaFinVigencia = $x("//*[@id=\"fechaFinVig\"]");

    //OBSERVAR DICTAMEN
    public SelenideElement JustificacionObservacionDictamen = $x("//*[@id=\"observacionId\"]");
    public SelenideElement btnGenerarObservacionDictamen = $x("//*[@id=\"acciones\"]/input[2]");

    //Confirmación
    public SelenideElement linkInicio = $x("//*[@id=\"bandejaSol\"]");//*[@id="Inicio"]
    public SelenideElement inputNumFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioTarea= $x("//*[@id=\"buscarTareasSolicitante\"]");
    public SelenideElement gridFolio = $x("//*[@id=\"0\"]/td[1]");
    public SelenideElement btnFirmarNotificacion = $x("//*[@id=\"acuse\"]");

}