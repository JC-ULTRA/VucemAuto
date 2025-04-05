package Economia.Tramite130118;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130118 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkPermisosImportaciExportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement linkImportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement linkAvisoAutomTicoImportaci = $x("//a[contains(@onclick, 'cero')]");
    public SelenideElement labelDatosSolicitud = $x("//label[@for='solicitud.titulo']");
    public SelenideElement selectSolicitudRegimenClave = $x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectSolicitudClaveClasificacionRegimen = $x("//*[@id='solicitud.claveClasificacionRegimen']");
    public SelenideElement textareaValue = $x("//*[@id='valueTA']");
    public SelenideElement selectFraccionArancelaria = $x("//*[@id='cveFraccionArancelaria']");
    public SelenideElement selectSubdivision = $x("//*[@id='cveSubdivision']");
    public SelenideElement selectUnidadTarifariaCombo = $x("//*[@id='unidadTarifariaComboId']");
    public SelenideElement inputSolicitudMercanciaCantidadTarifaria = $x("//*[@id='solicitud.mercancia.cantidadTarifaria']");
    public SelenideElement inputSolicitudMercanciaValorFactura = $x("//*[@id='solicitud.mercancia.valorFacturaUSD']");
    public SelenideElement selectSolicitudMercanciaPaisOrigen = $x("//*[@id='solicitud.mercancia.paisOrigen.clave']");
    public SelenideElement selectSolicitudMercanciaPaisDestino = $x("//*[@id='solicitud.mercancia.paisDestino.clave']");
    public SelenideElement inputSolicitudMercanciaLote = $x("//input[@class='required form-control']");
    public SelenideElement inputFecSalida = $x("//*[@id='fecSalida']");
    public SelenideElement textareaValueObs = $x("//*[@id='valueTAObs']");
    public SelenideElement selectMolinoSeleccion = $x("//*[@id='molinoSeleccion']");
    public SelenideElement textareaSolicitudProductorDomicilioDescripcion = $x("//textarea[@rows='7']");
    public SelenideElement selectSolicitudEntidadFederativaClave = $x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement selectRepresentacionFederal = $x("//*[@id='representacionFederalSelect']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = $x("//input[@type='file']");
    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");
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

    public SelenideElement textareaValue2 = $x("//*[@id='valueTA']");











    //public SelenideElement btnIngresFs = $x("//*[@id=\"btnSubmit\"]");
    //public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");




}
