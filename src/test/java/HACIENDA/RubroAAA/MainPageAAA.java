package HACIENDA.RubroAAA;

import com.codeborne.selenide.Clipboard;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPageAAA {
    //Tramite Rubro AAA Generar Folio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement ComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement EsquenaIntegral = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[3]/a");
    public SelenideElement RubroAAA = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-aga2-HA/invocarModulo.action?init','/ventanilla-aga2-HA//agace/rubroAAAIC/registrarSolicitud.action?iniciar','31603','','')\"]");
    
    //Datos Comunes
    public SelenideElement DatosComunes = $x("//label[contains(@for, 'comunes')]");
    //pre-operativo
    public SelenideElement PreOperativoAaa = $x("//*[@id='preOperativoAAANo']");
    //Régimen aduanero
    public SelenideElement inputRegimen = $x("//*[@id='regimen_0']");
    public SelenideElement inputRegimen2 = $x("//*[@id='regimen_1']");
    public SelenideElement inputRegimen3 = $x("//*[@id='regimen_2']");
    public SelenideElement inputRegimen4 = $x("//*[@id='regimen_3']");
    //sector productivo
    public SelenideElement selectSectorPro = $x("//*[@id='solicitud.listaCatalogoSolicitud[0].catalogo']");

    public SelenideElement SolicitudAcepto = $x("//*[@id='si190']");
    public SelenideElement SolicitudAcepto2 = $x("//*[@id='si191']");
    public SelenideElement Propios = $x("//*[@id='emPropiosSi']");
    public SelenideElement EmpPropios = $x("//*[@id='empPropios']");
    public SelenideElement selectEmpleadosPropiosBimestre = $x("//*[@id='solicitud.empleadosPropios.bimestre']");
    public SelenideElement MapDeclaracionAcepto = $x("//*[@id='si2011']");
    public SelenideElement AgregarSubcontratado = $x("//*[@id='agregarSubcontratado']");
    public SelenideElement rfcSubcontratadoBusqueda = $x("//*[@id='subcontratado.rfcBusqueda']");
    public SelenideElement inputBuscar = $x("//input[@onclick='javaScript:buscarSubcontratadoRFCEsquemaIC();']");
    public SelenideElement SubcontratadoEmpleados = $x("//*[@id='subcontratado.empleados']");
    public SelenideElement selectSubcontratadoBimestre = $x("//*[@id='subcontratado.bimestre']");
    public SelenideElement AgregarModalEsquema = $x("//*[@id='subcontratadoAgregarModalEsquemaIC']");
    public SelenideElement spanAceptar = $x("/html/body/div[14]/div[3]/div/button/span");
    public SelenideElement MapDeclaracionSolicitudAcepto = $x("//*[@id='si236']");
    public SelenideElement MapDeclaracionSolicitudAcepto2 = $x("//*[@id='si704']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto = $x("//*[@id='no237']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto2 = $x("//*[@id='no238']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto3 = $x("//*[@id='si239']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto4 = $x("//*[@id='si239']");
    public SelenideElement selectImmex = $x("//*[@id='IMMEX']");
    public SelenideElement AgregarDomicilios = $x("//*[@id='btnAgregarDomicilios']");
    public SelenideElement selectEntidadFederativaIdc = $x("//*[@id='entidadFederativaIDC']");
    public SelenideElement inputGridDomiciliosModal = $x("//*[@id='jqg_gridDomiciliosModal_4']");
    public SelenideElement inputDomiciliosModal2 = $x("//*[@id='jqg_gridDomiciliosModal_4']");
    public SelenideElement inputGridDomicilios = $x("//input[@onclick='javaScript:guardarDatosDomicilios()']");



    public SelenideElement inputModificarDomicilios = $x("//*[@id='btnModificarDomicilios']");
    public SelenideElement inputInstalacion = $x("//*[@id='siInstalacion']");
    public SelenideElement selectDomicilioTipoInstalacion = $x("//*[@id='domicilio.tipoInstalacion']");
    public SelenideElement inputProcesoProd = $x("//*[@id='siProcesoProd']");
    public SelenideElement inputAcredita = $x("//*[@id='siAcreditaIn']");
    public SelenideElement inputAceptarDomicilios = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");
    public SelenideElement inputAceptarDomicilios2 = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");
    public SelenideElement MapDeclaracionSolicitudAcepto5 = $x("//*[@id='si243']");
    public SelenideElement MapDeclaracionSolicitudAcepto6 = $x("//*[@id='no244']");
    //Carga Excel Proveedores Extranjeros
    public SelenideElement inputProvedoresExtranjeros = $x("//*[@id='archivo']");
    public SelenideElement cargaDocExtranjeros = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement UploadNewFileExtranjeros = $x("//*[@id='uploadNewFileExtranjeros']");
    public SelenideElement spanButtonText = $x("/html/body/div[21]/div[3]/div/button/span");
    //Carga Excel Proveedores Nacionales
    public SelenideElement inputArchivoNacionalesIva = $x("//*[@id='archivoNacionalesIVA']");
    public SelenideElement cargaDocNacionales = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement UploadNewFileNacionales = $x("//*[@id='uploadNewFileExtranjerosNIVA']");
    public SelenideElement spanButtonText2 = $x("/html/body/div[24]/div[3]/div/button/span");








}
