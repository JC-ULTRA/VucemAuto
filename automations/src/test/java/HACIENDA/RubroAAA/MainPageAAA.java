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
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");

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
    public SelenideElement infringioPrevistosNo = $x("//*[@id=\"no240\"]");
    public SelenideElement selectImmex = $x("//*[@id='IMMEX']");
    public SelenideElement AgregarDomicilios = $x("//*[@id='btnAgregarDomicilios']");
    public SelenideElement selectEntidadFederativaIdc = $x("//*[@id='entidadFederativaIDC']");
    public SelenideElement inputGridDomiciliosModal = $x("//*[@id='jqg_gridDomiciliosModal_3']");
    public SelenideElement inputDomiciliosModal2 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[5]/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement inputGridDomicilios = $x("//input[@onclick='javaScript:guardarDatosDomicilios()']");



    public SelenideElement inputModificarDomicilios = $x("//*[@id='btnModificarDomicilios']");
    public SelenideElement inputInstalacion = $x("//*[@id='siInstalacion']");
    public SelenideElement selectDomicilioTipoInstalacion = $x("//*[@id='domicilio.tipoInstalacion']");
    public SelenideElement inputProcesoProd = $x("//*[@id='siProcesoProd']");
    public SelenideElement inputAcredita = $x("//*[@id='siAcreditaIn']");
    public SelenideElement inputAceptarDomicilios = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");
    public SelenideElement inputAceptarDomicilios2 = $x("/html/body/div[16]/div[3]/div/button");
    public SelenideElement MapDeclaracionSolicitudAcepto5 = $x("//*[@id='si243']");
    public SelenideElement MapDeclaracionSolicitudAcepto6 = $x("//*[@id='no244']");
    //Carga Excel Proveedores Extranjeros
    public SelenideElement inputProvedoresExtranjeros = $x("//*[@id='archivo']");
    public SelenideElement cargaDocExtranjeros = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement UploadNewFileExtranjeros = $x("//*[@id='uploadNewFileExtranjeros']");
    public SelenideElement spanButtonText = $x("/html/body/div[17]/div[3]/div/button");
    //Carga Excel Proveedores Nacionales
    public SelenideElement inputArchivoNacionalesIva = $x("//*[@id='archivoNacionalesIVA']");
    public SelenideElement cargaDocNacionales = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement UploadNewFileNacionales = $x("//*[@id='uploadNewFileExtranjerosNIVA']");
    public SelenideElement spanButtonText2 = $x("/html/body/div[20]/div[3]/div/button");

    public SelenideElement querellaNo = $x("//*[@id=\"no705\"]");
    public SelenideElement inventarioSi = $x("//*[@id=\"siInventario\"]");
    public SelenideElement nombreInventario = $x("//*[@id=\"nombre.inventario\"]");
    public SelenideElement lugarInventario = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement anexo24 = $x("//*[@id=\"anexo.inventario\"]");
    public SelenideElement btnAgregarInventario = $x("//*[@id=\"btnAgregar.inventario\"]");
    public SelenideElement btnAceptarInventario = $x("/html/body/div[20]/div[3]/div/button");
    public SelenideElement contabilidadElectronicosSi = $x("//*[@id=\"si251\"]");
    public SelenideElement contabilidadPortalNo = $x("//*[@id=\"no706\"]");
    public SelenideElement sociosNo = $x("//*[@id=\"no707\"]");
    public SelenideElement provedoresListadoNo = $x("//*[@id=\"no708\"]");
    public SelenideElement btnAgregarMiembroEmpresa = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement enCaracterDe = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement obligadoTributarMexNo = $x("//*[@id=\"socio.tributarMexicoFalse\"]");
    public SelenideElement TipPersonaEmpresa = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement nombreEmpresa = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement nacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement btnAceptalEmpresa = $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptalEmpresa2 = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement manif1Check = $x("//*[@id=\"acepto252\"]");
    public SelenideElement manif2Check = $x("//*[@id=\"acepto253\"]");
    public SelenideElement tercerosRelacionados = $x("//*[@id=\"tabs\"]/ul/li[3]/a");
    public SelenideElement rfc = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscar\"]");
    public SelenideElement btnAceptarRFC = $x("/html/body/div[22]/div[3]/div/button");
    //public SelenideElement btnAceptarRFC = $x("/html/body/div[16]/div[3]/div/button");
    public SelenideElement telefonoTerceroR = $x("//*[@id=\"terceroRepresentanteLegal.telefono\"]");
    public SelenideElement btnAgregarTerceroR = $x("//*[@id=\"btnAgregarEnlaceOperativo\"]");
    public SelenideElement rfcTerceroR2 = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscar2 = $x("//*[@id=\"buscarEnlaceOperativo\"]");
    public SelenideElement inputCargo = $x("//*[@id=\"terceroEnlaceOperativo.puesto\"]");
    public SelenideElement btnAceptar3 = $x("//*[@id=\"btnAceptarEnlace\"]");
    public SelenideElement checkSuplenteOpcional = $x("//*[@id=\"terceroEnlaceOperativo.suplente\"]");

    //Datos por Regimen
    public SelenideElement datosRegimen = $x("//*[@id=\"datPorReg\"]/a");
    public SelenideElement opcion1Regimen = $x("//*[@id=\"si103\"]");
    public SelenideElement opcion2Regimen = $x("//*[@id=\"si79\"]");
    public SelenideElement opcion3Regimen = $x("//*[@id=\"si5050\"]");
    public SelenideElement valorTotalImp = $x("//*[@id=\"importacionDTO.solicitudm.monto\"]");
    public SelenideElement transferenciasVirtuales = $x("//*[@id=\"imporTemporalImmexMoneda\"]");
    public SelenideElement transferenciasVirtualesPorcentaje = $x("//*[@id=\"imporTemporalImmexPorcentaje\"]");
    public SelenideElement retornos = $x("//*[@id=\"retornosImmexMoneda\"]");
    public SelenideElement retornosPorcentaje = $x("//*[@id=\"retornosImmexPorcentaje\"]");
    public SelenideElement constanciaTransferencia = $x("//*[@id=\"ctmImmexMoneda\"]");
    public SelenideElement constanciaTransferenciaPorcentaje = $x("//*[@id=\"ctmImmexPorcentaje\"]");
    public SelenideElement opcion4Regimen = $x("//*[@id=\"no84\"]");
    public SelenideElement opcion5Regimen = $x("//*[@id=\"si85\"]");
    public SelenideElement opcion6Regimen = $x("//*[@id=\"no86\"]");
    public SelenideElement opcion7Regimen = $x("//*[@id=\"si87\"]");
    public SelenideElement opcion8Regimen = $x("//*[@id=\"no88\"]");
    public SelenideElement opcion9Regimen = $x("//*[@id=\"si89\"]");
    /// IVA e IEPS AAA
    public SelenideElement ivaIeeps = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[5]/a");
    public SelenideElement grupoEmpresas = $x("//*[@id=\"si72aaa\"]");
    public SelenideElement agregarEmpresaIvaIeps = $x("//*[@id=\"btnAgregarEmp\"]");
    public SelenideElement rfcEmpresaIvaIeps = $x("//*[@id=\"empresa.rfc\"]");
    public SelenideElement btnBuscarRfcIvaIeps = $x("//*[@id=\"btnBuscarEmpresa\"]");
    public SelenideElement btnGuardarEmpresaIvaIeps = $x("//*[@id=\"btnGuardarEmpresa\"]");
    public SelenideElement btnAceptarEmpresaIvaIeps = $x("/html/body/div[23]/div[3]/div/button");
    public SelenideElement servicio1Empresa = $x("//*[@id=\"empresa_0\"]");
    public SelenideElement servicio2Empresa = $x("//*[@id=\"empresa_1\"]");
    public SelenideElement servicio3Empresa = $x("//*[@id=\"empresa_2\"]");
    public SelenideElement servicio4Empresa = $x("//*[@id=\"empresa_3\"]");
    public SelenideElement tipoInversion = $x("//*[@id=\"tipo.inversionA\"]");
    public SelenideElement valorInversion = $x("//*[@id=\"cantidad.inversionA\"]");
    public SelenideElement descripcionInversion = $x("//*[@id=\"desc.inversionA\"]");
    public SelenideElement btnAgregarInversion = $x("//*[@id=\"btnAgregarInversion\"]");
    public SelenideElement btnAceptarInversion = $x("/html/body/div[24]/div[3]/div/button");
    public SelenideElement opcion2IvaIeps = $x("//*[@id=\"si3026\"]");
    public SelenideElement opcion3IvaIeps = $x("//*[@id=\"si99\"]");
    public SelenideElement opcion4IvaIeps = $x("//*[@id=\"si710aaa\"]");
    public SelenideElement devolucionesIVA = $x("//*[@id=\"empresa.solicitante.porcentaje.aaa\"]");
    public SelenideElement devolucionesIVAmonto = $x("//*[@id=\"empresa.solicitante.monto.aaa\"]");
    public SelenideElement opcion5IvaIeps = $x("//*[@id=\"si702\"]");
    public SelenideElement opcion6IvaIeps = $x("//*[@id=\"si703\"]");
    public SelenideElement maquinariaMayor = $x("//*[@id=\"98\"]");
    public SelenideElement montoMaquinaria = $x("//*[@id=\"numMaquinaria98\"]");
    public SelenideElement numOperacion = $x("//*[@id=\"solicitud.pago.referenciaBancaria\"]");
    public SelenideElement bancoPago = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    /// Pasos Finales
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[3]/tbody/tr[25]/td[2]/input");
    public SelenideElement archivo1 = $x("/html/body/div[7]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/div[7]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/div[7]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/div[7]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/div[7]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = $x("/html/body/div[7]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo7 = $x("/html/body/div[7]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo8 = $x("/html/body/div[7]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo9 = $x("/html/body/div[7]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo10 = $x("/html/body/div[7]/div[2]/div/form[11]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo11 = $x("/html/body/div[7]/div[2]/div/form[12]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo12 = $x("/html/body/div[7]/div[2]/div/form[13]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo13 = $x("/html/body/div[7]/div[2]/div/form[14]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo14 = $x("/html/body/div[7]/div[2]/div/form[15]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo15 = $x("/html/body/div[7]/div[2]/div/form[16]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo16 = $x("/html/body/div[7]/div[2]/div/form[17]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo17 = $x("/html/body/div[7]/div[2]/div/form[18]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo18 = $x("/html/body/div[7]/div[2]/div/form[19]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo19 = $x("/html/body/div[7]/div[2]/div/form[20]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo20 = $x("/html/body/div[7]/div[2]/div/form[21]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo21 = $x("/html/body/div[7]/div[2]/div/form[22]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo22 = $x("/html/body/div[7]/div[2]/div/form[23]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");





}
