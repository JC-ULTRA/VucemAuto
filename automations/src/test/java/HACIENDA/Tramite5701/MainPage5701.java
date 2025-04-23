package HACIENDA.Tramite5701;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage5701 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id=\"subenlaces\"]/ul/li[5]/a");
    public SelenideElement SoliNew = $x("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkServiciosExtraordinarios = $x("//*[@id=\"servicios\"]/ul/li[9]/a/span");
    public SelenideElement linkRegistroSolicitudServiciosExtraordinarios = $x("//*[@id=\"servicios\"]/ul/li[9]/ul/li[1]/a");
    public SelenideElement labelDatosSolicitud = $x("//label[@for='Datos de la solicitud']");
    public SelenideElement selectTipoServicio = $x("//*[@id='selectTipoServicio']");
    public SelenideElement inputServiciosDtoImportadorExportador = $x("//*[@id='rfc']");
    public SelenideElement inputFechaInicio = $x("//*[@id='fechaInicio']");
    public SelenideElement inputHoraInicial = $x("//*[@id='horaInicial']");
    public SelenideElement inputFechaFinal = $x("//*[@id='fechaFinal']");
    public SelenideElement inputHoraFinal = $x("//*[@id='horaFinal']");
    public SelenideElement selectAduanaDespacho = $x("//*[@id='aduanaDespacho']");
    public SelenideElement selectSeccionDespacho = $x("//*[@id='idSeccionDespacho']");
    public SelenideElement selectTipoOperacion = $x("//*[@id='selectTipoOperacion']");
    public SelenideElement selectServiciosDtoMercanciaPais = $x("//*[@id='serviciosDTO.mercanciaDTO.paisOrigen']");
    public SelenideElement selectServiciosDtoMercanciaPais3 = $x("//*[@id='serviciosDTO.mercanciaDTO.paisProcedencia']");
    public SelenideElement textareaDescripcionGenerica = $x("//*[@id='descripcionGenerica']");
    public SelenideElement textareaJustificacion = $x("//*[@id='justificacion']");
    public SelenideElement inputGafeteRespoDespacho = $x("//*[@id='gafeteRespoDespacho']");
    public SelenideElement inputBuscar = $x("//*[@id='btnBuscar']");
    public SelenideElement buttonCerrar2 = $x("/html/body/div[9]/div[3]/div/button");
    public SelenideElement inputNombreRespoDespacho = $x("//*[@id='nombreRespoDespacho']");
    public SelenideElement inputPaternoRespoDespacho = $x("//*[@id='paternoRespoDespacho']");
    public SelenideElement inputMaternoRespoDespacho = $x("//*[@id='maternoRespoDespacho']");
    public SelenideElement inputAgregar2 = $x("//input[@onclick='addPersona();']");
    public SelenideElement buttonCerrar3 = $x("/html/body/div[9]/div[3]/div/button");
    public SelenideElement inputLineaCapturaModal = $x("//*[@id='lineaCapturaModal']");
    public SelenideElement inputMontoModal = $x("//*[@id='montoModal']");
    public SelenideElement inputAgregarPago = $x("//*[@id='idBtnAgregarPago']");
    public SelenideElement buttonAceptar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement buttonAceptarNotificacion = $x("/html/body/div[10]/div[3]/div/button");
    public SelenideElement inputGridPagoSea = $x("//*[@id='cb_gridPagoSea']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    public SelenideElement inputBotonAgregarFechas = $x("//input[@class='btn btn-primary ']");
    public SelenideElement labelFechasDentroDelPeriodo = $x("//label[@for='cboFechasSeleccionadas']");//*[@id="cboFechasServicio"]
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[1].file']");
    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[2].file']");
    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[3].file']");
    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement inputsiguiente = $x("//*[@id='siguienteButton']");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //INICIO
    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");
    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@name='mostrarFirma']");
    //Solo Firma Funcionario
    public SelenideElement cerfF = $x("//*[@id='certificate']");
    public SelenideElement keyfF = $x("//*[@id='privateKey']");
    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");

    //Autorización
    //INICIO
    public SelenideElement InicioA = $x("//img[@alt='       Inicio']");
    public SelenideElement FolioA = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioA = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdAutorizarDictamen = $x("//td[@title='Autorizar Dictamen']");
    //Autorizar
    public SelenideElement inputMostrarFirma2 = $x("//input[@value='Autorizar']");

    //Confirmar Notificación Resolución
    public SelenideElement selecRol2 = $x("//*[@id='claveRol']");
    public SelenideElement btnacep2 = $x("//button[@name='ingresar']");
    //Inicio
    public SelenideElement linkInicio = $x("//*[@id='Inicio']");
    //Ingresar Folio
    public SelenideElement inputNumFolio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasSolicitanteB = $x("//*[@id='buscarTareasSolicitante']");
    //Pasar a la firma
    public SelenideElement tdConfirmarNotificaciResoluci = $x("//td[@aria-describedby='gridTareasSolicitante_actionName']");
    public SelenideElement inputAcuse = $x("//*[@id='acuse']");
    public SelenideElement notification = $x("//*[@id='notification']/div/ul/li");



}
