package HACIENDA.Tramite31602;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPage31602 {
    //Tramite Aviso B8 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement B8 = $x("//a[contains(@onclick, 'par')]");
    public SelenideElement tipoAviso = $x("//*[@id='ui-id-2']");
//Seleccion del tramite
    public SelenideElement linkRegistrosComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement linkSolicitudRegistroEsquenaIntegral = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[3]/a");
    public SelenideElement linkSolicitudRegistroEsquemaCertificaci = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-aga2-HA/invocarModulo.action?init','/ventanilla-aga2-HA//agace/rubroAAIC/registrarSolicitud.action?iniciar','31602','','')\"]");
    public SelenideElement labelDatosComunes = $x("//label[@for='Datos Comunes']");
    public SelenideElement selectSolicitudListaCatalogo = $x("//*[@id='solicitud.listaCatalogoSolicitud[0].catalogo']");
    public SelenideElement selectSolicitudListaCatalogo2 = $x("//*[@id='solicitud.listaCatalogoSolicitud[1].catalogo']");
    /// DATOS COMUNES
    public SelenideElement inputPreOperativo = $x("//*[@id='preOperativoAANo']");

    public SelenideElement inputRegimen = $x("//*[@id='regimen_0']");

    public SelenideElement inputRegimen2 = $x("//*[@id='regimen_1']");

    public SelenideElement inputRegimen3 = $x("//*[@id='regimen_2']");

    public SelenideElement inputRegimen4 = $x("//*[@id='regimen_3']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto = $x("//*[@id='si190']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto2 = $x("//*[@id='si191']");

    public SelenideElement inputPropios = $x("//*[@id='emPropiosSi']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto3 = $x("//*[@id='si2011']");

    public SelenideElement inputEmpPropios = $x("//*[@id='empPropios']");

    public SelenideElement selectSolicitudEmpleadosPropiosBimestre = $x("//*[@id='solicitud.empleadosPropios.bimestre']");

    public SelenideElement inputAgregarSubcontratado = $x("//*[@id='agregarSubcontratado']");

    public SelenideElement inputSubcontratadoBusqueda = $x("/html/body/div[13]/div[2]/form/table/tbody/tr[1]/td/div/div[1]/input[1]");

    public SelenideElement inputBuscar = $x("/html/body/div[13]/div[2]/form/table/tbody/tr[1]/td/div/div[1]/input[2]");

    public SelenideElement inputSubcontratadoAgregarModalEsquema = $x("/html/body/div[13]/div[2]/form/table/tbody/tr[2]/td/input[2]");
    public SelenideElement inputSubcontratadoEmpleados = $x("/html/body/div[13]/div[2]/form/table/tbody/tr[1]/td/div/div[3]/input");
    public SelenideElement selectSubcontratadoBimestre = $x("/html/body/div[13]/div[2]/form/table/tbody/tr[1]/td/div/div[4]/select");
    public SelenideElement inputMapDeclaracionSolicitudAcepto4 = $x("//*[@id='si704']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto5 = $x("//*[@id='no237']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto6 = $x("//*[@id='no238']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto7 = $x("//*[@id='si239']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto8 = $x("//*[@id='no240']");
    public SelenideElement spanAceptar2 = $x("//button[span[text()='Aceptar']]\n");
    public SelenideElement inputAgregarDomicilios = $x("//*[@id='btnAgregarDomicilios']");

    public SelenideElement selectEntidadFederativaIdc = $x("//*[@id='entidadFederativaIDC']");

    public SelenideElement inputGridDomiciliosModal = $x("//*[@id='jqg_gridDomiciliosModal_4']");
    public SelenideElement inputAceptarDomicilios = $x("//input[@onclick='javaScript:guardarDatosDomicilios()']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto9 = $x("//*[@id='si243']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto10 = $x("//*[@id='no244']");

    public SelenideElement inputArchivo = $x("//*[@id=\"archivo\"]");

    public SelenideElement inputUploadNewFileExtranjeros = $x("//*[@id='uploadNewFileExtranjeros']");

    public SelenideElement inputUploadNewFileExtranjeros2 = $x("//button[span[text()='Ok']] ");  //   /html/body/div[16]/div[3]/div/button


    public SelenideElement inputArchivoNacionalesIva = $x("//*[@id='archivoNacionalesIVA']");

    public SelenideElement inputUploadFileExtranjerosNiva = $x("//*[@id='uploadFileExtranjerosNIVA']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto11 = $x("//*[@id='no705']");

    public SelenideElement inputInventario = $x("//*[@id='siInventario']");

    public SelenideElement inputNombreInventario = $x("//*[@id='nombre.inventario']");

    public SelenideElement inputLugarInventario = $x("//*[@id='lugarR.inventario']");

    public SelenideElement inputAnexoInventario = $x("//*[@id='anexo.inventario']");

    public SelenideElement inputAgregarInventario = $x("//*[@id='btnAgregar.inventario']");

//Indique si lleva la contabilidad
    public SelenideElement inputMapDeclaracionSolicitudAcepto12 = $x("//*[@id='si251']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto13 = $x("//*[@id='no706']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto14 = $x("//*[@id='no707']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto15 = $x("//*[@id='no708']");

    public SelenideElement inputAgregarSocio = $x("//*[@id='agregarSocio']");

    public SelenideElement selectSocioCaracter = $x("//*[@id='socio.caracterDe']");//sentke


    public SelenideElement inputSocioTributarMexico = $x("//*[@id='socio.tributarMexicoTrue']");

    public SelenideElement selectSocioTipoPersona = $x("//*[@id='socio.tipoPersona']");

    public SelenideElement inputSocioNombre = $x("//*[@id='socio.nombre']");

    public SelenideElement inputSocioPaterno = $x("//*[@id='socio.apPaterno']");

    public SelenideElement inputSocioMaterno = $x("//*[@id='socio.apMaterno']");

    public SelenideElement inputSocioAgregarModal = $x("//*[@id='btnSocioAgregarModal']");

    public SelenideElement selectSocioNacionalidad = $x("//*[@id='socio.nacionalidad']");

    public SelenideElement manifestado = $x("//*[@id='acepto252']");

    public SelenideElement Bajoprotesta = $x("//*[@id='acepto253']");

    /// TERCEROS RELACIONADOS
    public SelenideElement labelTercerosRelacionados = $x("//label[contains(@for, 'Terceros')]");

    public SelenideElement inputTercero = $x("//*[@id='rfcTercero']");
    public SelenideElement Agregar = $x("//*[@id='btnAgregarEnlaceOperativo']");

    public SelenideElement input = $x("//*[@id='rfc']");

    public SelenideElement inputBuscarEnlaceOperativo = $x("//*[@id='buscarEnlaceOperativo']");

    public SelenideElement inputBuscarEnlaceOperativo2 = $x("//*[@id='btnAceptarEnlace']");

    public SelenideElement inputBuscar2 = $x("//*[@id='buscar']");

    public SelenideElement spanRubroa = $x("//*[@id='rubroa']");

    /// DATOS POR REGIMEN
    public SelenideElement DatosRegimen = $x("//label[@for='Datos por R&eacute;gimen']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto22 = $x("//*[@id='no84']");
    public SelenideElement Indiquecumplido = $x("//*[@id='si85']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto24 = $x("//*[@id='no86']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto25 = $x("//*[@id='si87']");
//Recinto fiscalizado estratégico
    public SelenideElement inputMapDeclaracionSolicitudAcepto26 = $x("//*[@id='no88']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto27 = $x("//*[@id='si89']");

    ///  IVA e IEPS
    public SelenideElement Manifieste = $x("//*[@id='si90aa']");
    public SelenideElement  Proveedores = $x("//*[@id='si3026aa']");
    public SelenideElement  Indique = $x("//*[@id='si72aa']");

    public SelenideElement inputAgregarEmp = $x("//*[@id='btnAgregarEmp']");

    public SelenideElement inputEmpresa = $x("//*[@id='empresa.rfc']");

    public SelenideElement inputBuscarEmpresa = $x("//*[@id='btnBuscarEmpresa']");

    public SelenideElement inputGuardarEmpresa = $x("//*[@id='btnGuardarEmpresa']");

    public SelenideElement inputEmpresa2 = $x("//*[@id='empresa_0']");

    public SelenideElement inputEmpresa3 = $x("//*[@id='empresa_1']");

    public SelenideElement tdMontoInversi = $x("//td[@class='campos'][.//*[@id='empresa_2']]");

    public SelenideElement inputEmpresa4 = $x("//*[@id='empresa_3']");

    public SelenideElement tipoInversion = $x("//*[@id=\'tipo.inversionA\']");
    public SelenideElement ValorPesos = $x("//*[@id=\'cantidad.inversionA\']");
    public SelenideElement descripcionGeneral = $x("//*[@id=\'desc.inversionA\']");
    public SelenideElement btnAgregarTerritorioNacional = $x("//*[@id=\'btnAgregarInversion\']");
    public SelenideElement btnAceptarTerritorio = $x("/html/body/div[25]/div[3]/div/button");

    public SelenideElement inputMapDeclaracionSolicitudAcepto16 = $x("//*[@id='si3011aa']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto17 = $x("//*[@id='si100aa']");
    public SelenideElement inputEmpresaSolicitantePorcentaje = $x("//*[@id='empresa.solicitante.porcentaje.aa']");

    public SelenideElement inputEmpresaSolicitanteMonto = $x("//*[@id='empresa.solicitante.monto.aa']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto18 = $x("//*[@id='si702']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto19 = $x("//*[@id='si703']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto20 = $x("//*[@id='91']");
    public SelenideElement inputFechaRegimen = $x("//*[@id='fechaRegimen91']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto21 = $x("//*[@id='92']");
    public SelenideElement inputNumEmpleados = $x("//*[@id='numEmpleados92']");

    public SelenideElement inputMapDeclaracionSolicitudAcepto23 = $x("//*[@id='93']");

    public SelenideElement inputNumMaquinaria = $x("//*[@id='numMaquinaria93']");


    public SelenideElement inputSolicitudPagoReferenciaBancaria = $x("//*[@id='solicitud.pago.referenciaBancaria']");

    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");

    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");

    public SelenideElement inputGuardarSolicitudParcial = $x("//*[@id='guardarSolicitudParcial']");

    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");

    /// //
    public SelenideElement check = $x("//*[@id='cb_gridDomicilios']");
    public SelenideElement modificar = $x("//*[@id='btnModificarDomicilios']");
    public SelenideElement InstalacionesSI = $x("//*[@id='siInstalacion']");

    public SelenideElement selectDomicilioTipoInstalacion = $x("//*[@id='domicilio.tipoInstalacion']");

    public SelenideElement inputProcesoProd = $x("//*[@id='siProcesoProd']");

    public SelenideElement inputAcredita = $x("//*[@id='siAcreditaIn']");

    public SelenideElement inputAceptarDomicilios2 = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");

    public SelenideElement inputAceptarDomicilios3 = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");

    public SelenideElement selectImmex = $x("//*[@id='IMMEX']");



    /// /
    public SelenideElement inputSocioBusqueda = $x("//*[@id='socio.rfcBusqueda']");

    public SelenideElement inputBuscar3 = $x("//input[@onclick='javaScript:buscarSocioRFC();']");

    public SelenideElement inputTerceroEnlaceOperativoTelefono = $x("//*[@id='terceroEnlaceOperativo.telefono']");
    public SelenideElement fechapago = $x("//*[@id='calendarTo']");

    public SelenideElement inputSiguiente = $x("//input[@value='Siguiente']");

    public SelenideElement inputAdjuntarDocumentos = $x("//input[@class='largemid']");

    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");

    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[1].file']");

    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[2].file']");

    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[3].file']");

    public SelenideElement inputDocumentosFile5 = $x("//input[@name='documentos[4].file']");

    public SelenideElement inputDocumentosFile6 = $x("//input[@name='documentos[5].file']");

    public SelenideElement inputDocumentosFile7 = $x("//input[@name='documentos[6].file']");

    public SelenideElement inputDocumentosFile8 = $x("//input[@name='documentos[7].file']");

    public SelenideElement inputDocumentosFile9 = $x("//input[@name='documentos[8].file']");

    public SelenideElement inputDocumentosFile10 = $x("//input[@name='documentos[9].file']");

    public SelenideElement inputDocumentosFile11 = $x("//input[@name='documentos[10].file']");

    public SelenideElement inputDocumentosFile12 = $x("//input[@name='documentos[11].file']");

    public SelenideElement inputDocumentosFile13 = $x("//input[@name='documentos[12].file']");

    public SelenideElement inputDocumentosFile14 = $x("//input[@name='documentos[13].file']");

    public SelenideElement inputDocumentosFile15 = $x("//input[@name='documentos[14].file']");

    public SelenideElement inputDocumentosFile16 = $x("//input[@name='documentos[15].file']");

    public SelenideElement inputDocumentosFile17 = $x("//input[@name='documentos[16].file']");

    public SelenideElement inputDocumentosFile18 = $x("//input[@name='documentos[17].file']");
    public SelenideElement inputDocumentosFile19 = $x("//input[@name='documentos[18].file']");
    public SelenideElement inputDocumentosFile20 = $x("//input[@name='documentos[19].file']");

    public SelenideElement spanAdjuntar = $x("//*[@id=\"btnAnexar\"]");

    public SelenideElement spanCerrar = $x("//*[@id=\"btnCerrar\"]");

    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

    





















    /// //
    





    /// 



/// /
    













//
//    //Dictaminación
//    //solo para el logueo la firma es diferente
//    public SelenideElement cerF = $x("//*[@id='certificate']");
//    public SelenideElement keyF = $x("//*[@id='privateKey']");
//    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
//    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");
//
//    //INICIO
//    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
//    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
//    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
//    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");
//    //Continuar Generar Dictamen
//    public SelenideElement GenerarDic = $x("//input[@type='submit']");
//    //Sentido AC
//    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
//    //Justificación Dic
//    public SelenideElement JustificacionDic = $x("//*[@id='valueTA']");
//    //Guardar y Firmar
//    public SelenideElement inputMostrarFirma = $x("//input[@name='mostrarFirma']");
//    //Solo Firma Funcionario
//    public SelenideElement cerfF = $x("//*[@id='certificate']");
//    public SelenideElement keyfF = $x("//*[@id='privateKey']");
//    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
//    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");
//
//    //Autorización
//    //INICIO
//    public SelenideElement InicioA = $x("//img[@alt='       Inicio']");
//    public SelenideElement FolioA = $x("//*[@id='idNumFolio']");
//    public SelenideElement inputBuscarTareasFuncionarioA = $x("//*[@id='buscarTareasFuncionario']");
//    public SelenideElement tdAutorizarDictamen = $x("//td[@title='Autorizar Dictamen']");
//    //Autorizar
//    public SelenideElement inputMostrarFirma2 = $x("//input[@value='Autorizar']");
//
//    //Confirmar Notificación Resolución
//    public SelenideElement selecRol2 = $x("//*[@id='claveRol']");
//    public SelenideElement btnacep2 = $x("//button[@name='ingresar']");
//    //Inicio
//    public SelenideElement linkInicio = $x("//*[@id='Inicio']");
//    //Ingresar Folio
//    public SelenideElement inputNumFolio = $x("//*[@id='idNumFolio']");
//    public SelenideElement inputBuscarTareasSolicitanteB = $x("//*[@id='buscarTareasSolicitante']");
//    //Pasar a la firma
//    public SelenideElement tdConfirmarNotificaciResoluci = $x("//td[@aria-describedby='gridTareasSolicitante_actionName']");
//    public SelenideElement inputAcuse = $x("//*[@id='acuse']");
//
//    public SelenideElement notification = $x("//*[@id='notification']/div/ul/li");
//
//    public SelenideElement linkCuentasBancarias = $x("//a[contains(@onclick, 'uentas')]");
//
//
//
//
//
//    
//    
//
//
}


