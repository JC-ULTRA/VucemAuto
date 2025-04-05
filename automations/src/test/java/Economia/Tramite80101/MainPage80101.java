package Economia.Tramite80101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=
public class MainPage80101 {
    //Login soli 80101
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");

    //Firma soli 80101
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarF = $x("//*[@id='btnSubmit']");


    //Login fun 80101
    public SelenideElement cerFL = $x("//*[@id='certificate']");
    public SelenideElement keyFL = $x("//*[@id='privateKey']");
    public SelenideElement passFL = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresFL = $x("//*[@id='btnSubmit']");

    //Firma fun 80101
    public SelenideElement cerFF = $x("//*[@id='certificate']");
    public SelenideElement keyFF = $x("//*[@id='privateKey']");
    public SelenideElement passFF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarFF = $x("//*[@id='btnSubmit']");

    //Ingreso al tramite
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement AutoProgramNuevo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement AutoNuevoIndustrial = $x("//a[contains(@onclick, \"','80101','','')\")]");

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
//    public SelenideElement Scrol = Selenide.$x("//label[@for='captura.tab.complementos']");

    //proceso del tramite y  Programa Pre operativo y Datos generales
    public SelenideElement Complementos = $x("//label[@for='captura.tab.complementos']");
    public SelenideElement checkImmex = $x("//*[@id='chkPreoperativo']");
    public SelenideElement paginaWeb = $("#descripcionSistemasMedicion");
    public SelenideElement localizacion = $("#coordenadasGeograficas");

    //Obligaciones fiscales y Datos federatario(s) Constitución y modificaciones de la sociedad
    public SelenideElement OpinionSiSat = $("#opinionSat");
    public SelenideElement FechaExpedicionSat = $("#fechaExpedicionUNOSAT");
    public SelenideElement ManifiestoImmex = $("#manifiestoImmex");
    public SelenideElement nombFedExpDoc = $x("//*[@id='descripcionGenerica1']");
    public SelenideElement numNotaria = $x("//*[@id='descripcionGenerica2']");
    public SelenideElement estado = $x("//*[@id='solicitud.establecimientoTIF']");
    public SelenideElement NumeroActa = $("#numeroDeActa");
    public SelenideElement FechaEmisionActa = $("#fechaEmisionActa");
    public SelenideElement feEmisionActa = $x("/html/body/div[6]/table/tbody/tr[1]/td[3]/a");

    public SelenideElement RFCRepresentLeg = $("#rfcRepresentante");

    //Datos generales socios accionistas
    public SelenideElement NacionalidadExtranSiSocio = $("#tipoNacionalidadExtranjero");
    public SelenideElement PersonaMoralSiSocio = $("#tipoPersonaMoral");
    public SelenideElement taxIDSocio = $("#taxIDSocioM");
    public SelenideElement RazonSocialSocio = $("#razonSocialSocio");
    public SelenideElement paisSocio = $("#entidadFederativaSocioM");
    public SelenideElement CPSocio = $("#cpSocioM");
    public SelenideElement estadoSocio = $("#estadoSocioM");
    public SelenideElement CorreoSocio = $("#correoSocioM");
    public SelenideElement btnAgregarSocio = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[23]/div[5]/div/input");

    //Anexo I
    public SelenideElement AnexoI = $x("//label[@for='captura.tab.anexoI']");
    //Fraccion Exportación
    public SelenideElement FraccionExportacion = $x("//*[@id='fraccionExportacion']");
    public SelenideElement DescFraccionExpo2 = $x("//*[@id='descFraccionExpo']");
    public SelenideElement inputAgregarFraccion = $x("//input[@onclick='actualizaFraccionesExportacion();']");
    public SelenideElement inputSeleccionarFimportacion2 = $x("//input[@name='seleccionarFimportacion']");

    //Datos de la fracción
    public SelenideElement inputAgregarDatosFraccion = $x("//input[@name='agregarDatosFraccionE']");
    public SelenideElement selectCategoriaFraccion = $x("//*[@id='categoriaFraccion']");
    public SelenideElement inputFraccionValorMoneda = $x("//*[@id='fraccionValorMonedaM']");
    public SelenideElement inputFraccionValorMoneda2 = $x("//*[@id='fraccionValorMonedaA']");
    public SelenideElement inputFraccionValorProd = $x("//*[@id='fraccionValorProdM']");
    public SelenideElement inputFraccionValorProd2 = $x("//*[@id='fraccionValorProdA']");
    public SelenideElement inputAgregarFraccion2 = $x("//input[contains(@onclick, 'agregarFraccionAnexo();')]");
    public SelenideElement buttonAceptar = $x("//button[@class='btn btn-primary']");

    //Agregar proveedor
    public SelenideElement inputAgregarProveedor = $x("//input[@onclick=\"mostrarCapturaProveedorCliente('fraccionesArancelariasExportacion');\"]");
    public SelenideElement selectPaisDestino = $x("//*[@id='paisDestino']");
    public SelenideElement inputCliente = $x("//*[@id='rfcCliente']");
    public SelenideElement divCamposObligatorios = $x("//*[@id='razonCliente']");
    public SelenideElement inputAgregaarProveedor = $x("//*[@id='btnAgregaarProveedor']");
    public SelenideElement buttonAceptar7 = $x("/html/body/div[9]/div[3]/div/button");
    public SelenideElement inputCancelarProveedor = $x("//*[@id='btnCancelarProveedor']");

    //Agregar Fracción Importación
    public SelenideElement inputSeleccionarFimportacion3 = $x("//input[@name='seleccionarFimportacion']");
    public SelenideElement inputFraccionImportacion = $x("//*[@id='fraccionImportacion']");
    public SelenideElement textareaDescFraccionImpo = $x("//*[@id='descFraccionImpo']");
    public SelenideElement inputAgregarFraccion3 = $x("//input[@onclick='actualizaFraccionesImportacion();']");
    public SelenideElement SeleccionarFimportacion = $x("//input[@value='3403110134031101']");

    //Datos de la fracción
    public SelenideElement inputAgregarDatosFraccion2 = $x("//input[@name='agregarDatosFraccionI']");
    public SelenideElement selectCategoriaFraccion2 = $x("//*[@id='categoriaFraccion']");
    public SelenideElement inputFraccionValorMoneda3 = $x("//*[@id='fraccionValorMonedaMI']");
    public SelenideElement inputFraccionValorMoneda4 = $x("//*[@id='fraccionValorMonedaAI']");
    public SelenideElement inputFraccionValorProd3 = $x("//*[@id='fraccionValorProdMI']");
    public SelenideElement inputFraccionValorProd4 = $x("//*[@id='fraccionValorProdAI']");
    public SelenideElement inputAgregarFraccion4 = $x("//input[contains(@onclick, 'agregarFraccionAnexo();')]");
    public SelenideElement buttonAceptar2 = $x("/html/body/div[10]/div[3]/div/button");
    public SelenideElement inputSeleccionarFimportacion = $x("//input[@value='3403110134031101']");


    //Agregar proveedor
    public SelenideElement inputAgregarProveedorImp = $x("//input[@name='agregarProveedorImp']");
    public SelenideElement selectPaisOrigen = $x("//*[@id='paisOrigen']");
    public SelenideElement inputProveedor = $x("//*[@id='rfcProveedor']");
    public SelenideElement inputRazonProveedor = $x("//*[@id='razonProveedor']");
    public SelenideElement inputAgregaarProveedor2 = $x("//*[@id='btnAgregaarProveedor']");
    public SelenideElement buttonAceptar8 = $x("/html/body/div[11]/div[3]/div/button");
    public SelenideElement inputCancelarProveedor2 = $x("//*[@id='btnCancelarProveedor']");

    //Federatarios y plantas
    public SelenideElement FederatariosPlantas = $x("//label[@for='captura.tab.notarios']");
    public SelenideElement inputNombreNotario = $x("//*[@id='nombreNotario']");
    public SelenideElement inputApellidoPaterno = $x("//*[@id='apellidoPaterno']");
    public SelenideElement inputApellidoMaterno = $x("//*[@id='apellidoMaterno']");
    public SelenideElement inputNumeroActa = $x("//*[@id='numeroActa']");
    public SelenideElement inputFechaActaNotario = $("#fechaActaNotario");
    public SelenideElement fecha = $x("/html/body/div[6]/table/tbody/tr[1]/td[3]/a");
    public SelenideElement inputNumeroNotaria = $x("//*[@id='numeroNotaria']");
    public SelenideElement selectEntidadFederativa = $x("//*[@id='entidadFederativa']");
    public SelenideElement selectMunicipioDelegacion = $x("//*[@id='municipioDelegacion']");
    public SelenideElement inputAgregar = $x("//input[@name='agregar']");

    //Operaciones IMMEX
    public SelenideElement selectEntidadFederativaPlantasImmex = $x("//*[@id='entidadFederativaPlantasIMMEX']");
    public SelenideElement inputBuscarPlantasImmex = $x("//input[@name='buscarPlantasIMMEX']");
    public SelenideElement seleccionaPlanta = $x("//*[@id='jqg_gridPlantasImmexDisp_1']");
    public SelenideElement inputSeleccionarPlantas = $x("//input[contains(@onclick, \"+'SeleccionarPlantas','clickin');seleccionarPlantasImmexDisponibles();\")]");
    public SelenideElement seleccionaPlantas = $x("    //*[@id='jqg_plantasIMMEX_3']");
    public SelenideElement inputAgregarComplemento = $x("//input[@onclick='mostrarCapturaComplementarios();']");
    public SelenideElement amparoPrograma = $x("//*[@id='amparoPrograma']");
    public SelenideElement selectTipoDocumento = $x("//*[@id='tipoDocumento']");
    public SelenideElement inputFechaFirmaCompl = $x("//*[@id='fechaFirmaCompl']");
    public SelenideElement fecha2 = $x("/html/body/div[6]/table/tbody/tr[1]/td[3]/a");
    public SelenideElement inputFechaFinVigenciaCompl = $x("//*[@id='fechaFinVigenciaCompl']");
    public SelenideElement fecha3 = $x("/html/body/div[6]/table/tbody/tr[5]/td[5]/a");
    public SelenideElement inputAgregarComplemento2 = $x("//input[@name='agregarComp']");
    public SelenideElement buttonAceptar3 = $x("/html/body/div[12]/div[3]/div/button");
    public SelenideElement inputFirmante = $x("//*[@id='rfcFirmante']");
    public SelenideElement selectTipoFirmante = $x("//*[@id='tipoFirmante']");
    public SelenideElement inputAgregarFirmante = $x("//input[@name='agregarFirmante']");
    public SelenideElement inputRegresarComplemento = $x("//*[@id='btnCancelarComplemento']");

    //Montos
    public SelenideElement inputAgregarMontos = $x("//*[@id='btnAgregarMontos']");
    public SelenideElement selectMontoTipo = $x("//*[@id='montoTipo']");
    public SelenideElement inputMontoCantidad = $x("//*[@id='montoCantidad']");
    public SelenideElement textareaMontoDescripcion = $x("//*[@id='montoDescripcion']");
    public SelenideElement inputMontoMoneda = $x("//*[@id='montoMoneda']");
    public SelenideElement inputAgregarMonto = $x("//*[@id='btnAgregarMonto']");
    public SelenideElement buttonAceptar4 = $x("/html/body/div[13]/div[3]/div/button");
    public SelenideElement inputCancelarMonto = $x("//*[@id='btnCancelarMonto']");
    
    //Empleados
    public SelenideElement inputAgregarEmpleados = $x("//*[@id='btnAgregarEmpleados']");
    public SelenideElement inputEmpleadosTotal = $x("//*[@id='empleadosTotal']");
    public SelenideElement inputRadioDirectos = $x("//*[@id='radioDirectos']");
    public SelenideElement inputEmpleadosDirectos = $x("//*[@id='empleadosDirectos']");
    public SelenideElement selectEmpleadosCedula = $x("//*[@id='empleadosCedula']");
    public SelenideElement inputFechaCedulaImms = $x("//*[@id='fechaCedulaImms']");
    public SelenideElement fecha4 = $x("/html/body/div[6]/table/tbody/tr[1]/td[3]/a");
    public SelenideElement inputAgregarEmpleado = $x("//*[@id='btnAgregarEmpleado']");
    public SelenideElement buttonAceptar5 = $x("/html/body/div[14]/div[3]/div/button");
    public SelenideElement inputCancelarEmpleado = $x("//input[contains(@onclick, 'cerrarCapturaEmpleado();')]");

    //Capacidad instalada
    public SelenideElement inputAgregarCapacidad = $x("//input[@value='Capacidad Instalada']");
    public SelenideElement selectCapacidadFraccion = $x("//*[@id='capacidadFraccion']");
    public SelenideElement inputCapacidadTurnos = $x("//*[@id='capacidadTurnos']");
    public SelenideElement inputCapacidadHoras = $x("//*[@id='capacidadHoras']");
    public SelenideElement inputCapacidadEmpleados = $x("//*[@id='capacidadEmpleados']");
    public SelenideElement inputCapacidadMaquinaria = $x("//*[@id='capacidadMaquinaria']");
    public SelenideElement textareaCapacidadDescMaquinaria = $x("//*[@id='capacidadDescMaquinaria']");
    public SelenideElement inputCapacidadMensual = $x("//*[@id='capacidadMensual']");
    public SelenideElement inputCapacidadAnual = $x("//*[@id='capacidadAnual']");
    public SelenideElement inputCapacidadEfectiva = $x("//*[@id='capacidadEfectiva']");
    public SelenideElement inputAgregarCapacidad2 = $x("//input[@name='agregarCapacidad']");
    public SelenideElement buttonAceptar6 = $x("/html/body/div[15]/div[3]/div/button");
    public SelenideElement inputCancelarCapacidad = $x("//*[@id='btnCancelarCapacidad']");
    public SelenideElement selectFederalesImmex = $x("//*[@id='representacionesFederalesIMMEX']");
    public SelenideElement selectActividadProductiva = $x("//*[@id='actividadProductiva']");

    //Continuar Genera folio temporal
    public SelenideElement continuar = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Documentoss solicitados
    public SelenideElement continuar2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Adjuntar documento
    public SelenideElement inputAdjuntarDocumentos = $x("//*[@id=\"docs\"]/tbody/tr[14]/td[2]/div/input[2]");
    public SelenideElement inputDocumentosFile = Selenide.$x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile1 = Selenide.$x("//input[@name='documentos[1].file']");
    public SelenideElement inputDocumentosFile2 = Selenide.$x("//input[@name='documentos[2].file']");
    public SelenideElement inputDocumentosFile3 = Selenide.$x("//input[@name='documentos[3].file']");
    public SelenideElement inputDocumentosFile4 = Selenide.$x("//input[@name='documentos[4].file']");
    public SelenideElement inputDocumentosFile5 = Selenide.$x("//input[@name='documentos[5].file']");
    public SelenideElement inputDocumentosFile6 = Selenide.$x("//input[@name='documentos[6].file']");
    public SelenideElement inputDocumentosFile7 = Selenide.$x("//input[@name='documentos[7].file']");
    public SelenideElement inputDocumentosFile8 = Selenide.$x("//input[@name='documentos[8].file']");
    public SelenideElement inputDocumentosFile9 = Selenide.$x("//input[@name='documentos[9].file']");
    public SelenideElement inputDocumentosFile10 = Selenide.$x("//input[@name='documentos[10].file']");
    public SelenideElement inputAnexar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = Selenide.$x("//*[@id='siguienteButton']");

    //Obtenermos el folio generado
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Solicitar Opinión
    //INICIO
    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Solicitar opinión
    public SelenideElement solicitarOpinion = $x("//input[@value='?mostrarOpinion=']");
    //Sentido AC
    public SelenideElement ContinuarOpinion = $x("//*[@id=\"acciones\"]/input");
    //Selección de fecha visita
    public SelenideElement FechaVisitaOpinion = $x("//img[@alt='...']");
    public SelenideElement fechaOpinion = $x("/html/body/div[2]/table/tbody/tr[2]/td[4]/a");

    //Guardar y Firmar
    public SelenideElement guardarFirmar = $x("//*[@id=\"btnGuardar\"]");

    //Registrar opinion
    //INICIO
    public SelenideElement InicioA = $x("//img[@alt='       Inicio']");
    public SelenideElement FolioA = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioA = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement RegistrarOpinion = $x("//td[@title=' Registrar Opinion']");


    //Regristrar
    public SelenideElement inputOpinionAceptada = $x("//input[@value='SEOP.AC']");
    public SelenideElement textareaDescripcionOpinion = $x("//*[@id='idDescripcionOpinion']");
    public SelenideElement inputConsultarInformacion = $x("//input[@class='largest']");
    public SelenideElement inputArchivoAdjuntar = $x("//*[@id='archivoAdjuntar']");
    public SelenideElement inputCargaArchivo = $x("//*[@id='btnCargaArchivo']");
    public SelenideElement inputEviar = $x("//*[@id='btnGuardar']");

    //Generar Dictamen
    //INICIO
    public SelenideElement InicioD = $x("//img[@alt='       Inicio']");
    public SelenideElement FolioD = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioD = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitudD = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement inputMostrar = $x("//input[@type='submit']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//textarea[@cols='60']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");

    //Autorización
    //INICIO
    public SelenideElement InicioAu = $x("//img[@alt='       Inicio']");
    public SelenideElement FolioAu = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioAu = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdAutorizarDictamen = $x("//td[@title='Autorizar Dictamen']");
    //Autorizar
    public SelenideElement inputMostrarFirma2 = $x("//input[@name='mostrarFirma']");


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
