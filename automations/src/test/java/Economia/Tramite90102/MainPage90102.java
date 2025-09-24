package Economia.Tramite90102;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage90102 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement Prosec = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement linkAutorizacionProgramaNuevo = $x("//a[contains(text(),'PROSEC')]/following-sibling::ul//a[contains(text(),'Autorización Programa Nuevo')]");
    public SelenideElement linkAutorizacionProductorIndirecto = $x("//a[contains(text(),'PROSEC')]/following-sibling::ul//a[contains(text(),'Autorización Programa Nuevo')]/following-sibling::ul//a[contains(text(),'Autorización Programa Nuevo Productor indirecto')]");
    public SelenideElement elementoTramite90102 = Selenide.$x("//*[@id=\"servicios\"]/ul/li[2]/ul/li[1]/ul/li[2]/a");

    //Lista de productores indirectos
    public SelenideElement gridPrograma1 = $x("//*[@id=\"3\"]/td[3]");

    //Paso 1 CAPTURAR SOLICITUD
    //Consulta de domicilios
    public SelenideElement domiciliosPlantas = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement estadoPlantas = Selenide.$x("//*[@id='entidadFederativaDomicilios']");
    public SelenideElement mostrarDomicilios = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[2]/div/input");
    public SelenideElement seleccionaPlanta = Selenide.$x("//*[@id='jqg_gridPlantasPROSECDisponibles_1']");
    public SelenideElement agregarPlanta = Selenide.$x("//*[@id='agregar_plantas']");
    public SelenideElement actividadProductiva = Selenide.$x("//*[@id='actividadProductiva']");

    //Pestaña Sectores y mercancías
    public SelenideElement sectoresMercancias = Selenide.$x("//*[@id=\"ui-id-3\"]/label");
    //Datos de la solicitud
    public SelenideElement sector = Selenide.$x("//*[@id='sectoresProsecConf']");
    public SelenideElement agregarSector = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[4]/div/div/div/input[2]");
    public SelenideElement selecSector = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    //Mercancías a producir
    public SelenideElement fraccionArancelaria = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[7]/div[3]/div/div/input");
    public SelenideElement agregarFraccion = Selenide.$x("//*[@id='btnAgregarFraccion']");
    //Continuar paso 1
    public SelenideElement continuarSoli = Selenide.$x("//*[@id='guardarSolicitud']");

    //Paso 2 REQUERIMIENTOS NECESARIOS
    public SelenideElement continuarArchivos = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");

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
    public SelenideElement gridDocumento1 = $x("//input[@name='documentos[0].requerido'][@type='checkbox']");
    public SelenideElement btnContinuar1Requerimiento = $x("//*[@id=\"mostrarFirmaId\"]");


    //Generar opinion
    public SelenideElement fechaVisita = $x("//*[@id=\"fechaVisitaSE\"]");
    //Registro opinion
    public SelenideElement Opinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement btnAnexarInformacionOpinion = $x("//input[@type='button' and @value='Anexar información digitalizada']");
    public SelenideElement btnEnviarDocumentoOpinion = $x("//*[@id=\"cargaArchivo\"]");
    public SelenideElement btnCerrarAnexarInformacion = $x("//span[text()='Archivo']/ancestor::div[@role='dialog'][contains(@class, 'ui-dialog')]//button[text()='Cerrar']");
    public SelenideElement btnGuardarEnviarOpinion = $x("//*[@id=\"btnGuardar\"]");


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
    public SelenideElement justificacionDictamen= $x("//*[@id=\"evaluarSolicitud\"]/table[2]/tbody/tr[4]/td/textarea");
    public SelenideElement fechaVigencia = $x("//*[@id=\"fechaVigencia\"]");
    public SelenideElement fechaFinVigencia = $x("//*[@id=\"dFechaFinVigencia\"]");

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
