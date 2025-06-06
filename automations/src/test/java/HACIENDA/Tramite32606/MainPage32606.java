package HACIENDA.Tramite32606;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32606 {

    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement solicitudRegistro = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement rubroControladora = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/ul/li[3]/a");
    /// Datos comunes
    public SelenideElement datosComunes = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement sectorProductivo = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    public SelenideElement cumplimientoFiscalesAduaneras = $x("//*[@id=\"si190\"]");
    public SelenideElement inputMapDeclaracionSolicitudAcepto = $x("//*[@id='si191']");
    public SelenideElement inputPropios = $x("//*[@id='emPropiosSi']");
    public SelenideElement inputEmpPropios = $x("//*[@id='empPropios']");
    public SelenideElement inputEmpPropios2 = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");
    public SelenideElement inputIsr = $x("//*[@id='isrSi']");
    public SelenideElement inputObreroPatronales = $x("//*[@id='obreroPatronalesSi']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto2 = $x("//*[@id='si2011']");
    public SelenideElement inputAgregarSubcontratado = $x("//*[@id='agregarSubcontratado']");
    public SelenideElement inputSubcontratadoBusqueda = $x("//*[@id='subcontratado.rfcBusqueda']");
    public SelenideElement inputBuscar = $x("//input[@onclick='javaScript:buscarSubcontratadoRFCEsquemaIC();']");
    public SelenideElement inputSubcontratadoEmpleados = $x("//*[@id='subcontratado.empleados']");
    public SelenideElement selectSubcontratadoBimestre = $x("//*[@id='subcontratado.bimestre']");
    public SelenideElement inputSubcontratadoAgregarModalEsquema = $x("//*[@id='subcontratadoAgregarModalEsquemaIC']");
    public SelenideElement btnAceptarSubcontratados = $x("/html/body/div[15]/div[3]/div/button");
    public SelenideElement inputMapDeclaracionSolicitudAcepto3 = $x("//*[@id='si236']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto5 = $x("//*[@id='no237']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto6 = $x("//*[@id='no238']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto7 = $x("//*[@id='no462']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto8 = $x("//*[@id='si239']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto9 = $x("//*[@id='no240']");
    public SelenideElement inputAgregarDomicilios = $x("//*[@id='btnAgregarDomicilios']");
    public SelenideElement selectEntidadFederativaIdc = $x("//*[@id='entidadFederativaIDC']");
    public SelenideElement inputGridDomiciliosModal = $x("//*[@id='jqg_gridDomiciliosModal_3']");
    public SelenideElement inputAceptarDomicilios = $x("//input[@onclick='javaScript:guardarDatosDomicilios()']");
    public SelenideElement inputGridDomicilios = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[4]/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement inputModificarDomicilios = $x("//*[@id='btnModificarDomicilios']");
    public SelenideElement inputInstalacion = $x("//*[@id='siInstalacion']");
    public SelenideElement selectDomicilioTipoInstalacion = $x("//*[@id='domicilio.tipoInstalacion']");
    public SelenideElement inputProcesoProd = $x("//*[@id='siProcesoProd']");
    public SelenideElement inputAcredita = $x("//*[@id='siAcreditaIn']");
    public SelenideElement inputPerfil = $x("//*[@id='noPerfil']");
    public SelenideElement inputOperacionesExt = $x("//*[@id='siOperacionesCExt']");
    public SelenideElement inputInstalacionCtpat = $x("//*[@id='siInstalacionCtpat']");
    public SelenideElement inputAceptarDomicilios2 = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");
    public SelenideElement btnAceptarDomicilios = $x("/html/body/div[17]/div[3]/div/button");
    public SelenideElement inputMapDeclaracionSolicitudAcepto10 = $x("//*[@id='si243']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto11 = $x("//*[@id='no244']");
    public SelenideElement inputArchivo = $x("//*[@id='archivo']");
    public SelenideElement inputUploadFileExtranjeros = $x("//*[@id='uploadFileExtranjeros']");
    public SelenideElement btnOkExtranjeros = $x("/html/body/div[18]/div[3]/div/button");
    public SelenideElement inputArchivoNacionales = $x("//*[@id='archivoNacionales']");
    public SelenideElement inputUploadFileExtranjeros2 = $x("//*[@id='uploadFileExtranjerosN']");
    public SelenideElement btnOkNacionales = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement inputMapDeclaracionSolicitudAcepto12 = $x("//*[@id='no248']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto13 = $x("//*[@id='siInventario']");
    public SelenideElement inputInventario = $x("//*[@id='nombre.inventario']");
    public SelenideElement inputNombreInventario = $x("//*[@id='nombre.inventario']");
    public SelenideElement lugarInventario = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement inputAnexoInventario = $x("//*[@id='anexo.inventario']");
    public SelenideElement inputAgregarInventario = $x("//*[@id='btnAgregar.inventario']");
    public SelenideElement btnAceptarInventarios = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement inputMapDeclaracionSolicitudAcepto14 = $x("//*[@id='si251']");
    public SelenideElement inputMapDeclaracionSolicitudAcepto15 = $x("//*[@id='agregarSocio']");
    public SelenideElement selectSocioCaracter = $x("//*[@id='socio.caracterDe']");
    public SelenideElement tributarMexicoNo = $x("//*[@id=\"socio.tributarMexicoFalse\"]");
    public SelenideElement tipoPersona = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement nacionalidadSocio = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement nombreSocio = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement btnAgregarSocio = $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptarSocios = $x("/html/body/div[22]/div[3]/div/button");
    public SelenideElement inputMapDeclaracionSolicitudAcepto16 = $x("//*[@id='no463']");
    public SelenideElement inputAcepto = $x("//*[@id='acepto252']");
    public SelenideElement inputAcepto2 = $x("//*[@id='acepto253']");
    /// Terceros Relacionados
    public SelenideElement tercerosRelacionados = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement rfcRepresentanteL = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscarRfcRepresentanteL = $x("//*[@id=\"buscar\"]");
    public SelenideElement btnAceptarRepresentanteL = $x("/html/body/div[23]/div[3]/div/button");
    public SelenideElement agregarEnlaceO = $x("//*[@id=\"btnAgregarEnlaceOperativo\"]");
    public SelenideElement rfcEnlaceO = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscarEnlaceO = $x("//*[@id=\"buscarEnlaceOperativo\"]");
    public SelenideElement cargoEnlaceO = $x("//*[@id=\"terceroEnlaceOperativo.puesto\"]");
    public SelenideElement btnAgregarEnlaceO = $x("//*[@id=\"btnAceptarEnlace\"]");
    /// Controladora
    public SelenideElement controladora = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement operacionesComercioExterior = $x("//*[@id=\"comExtNo\"]");
    public SelenideElement mismoGrupoNo = $x("//*[@id=\"grupEmpNo\"]");
    public SelenideElement fusionEsicionNo = $x("//*[@id=\"empFusNo\"]");
    public SelenideElement immexExtranjeroNo = $x("//*[@id=\"empExtNo\"]");
    public SelenideElement fechaPago = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[5]/div/table[3]/tbody/tr[2]/td[2]/img");
    public SelenideElement selecFechaPago = $x("/html/body/div[2]/table/tbody/tr[2]/td[1]/a");
    public SelenideElement montoPago = $x("//*[@id=\"montoOEA\"]");
    public SelenideElement numOperacionBancaria = $x("//*[@id=\"operBancOEA\"]");
    public SelenideElement llavePago = $x("//*[@id=\"llaveOEA\"]");
    public SelenideElement agregarTransportista = $x("//*[@id=\"agregarTransportista\"]");
    public SelenideElement rfcTransportista = $x("//*[@id=\"trRfc\"]");
    public SelenideElement buscarRfcTransportista = $x("/html/body/div[24]/div[2]/form/table/tbody/tr[2]/td/input[2]");
    public SelenideElement btnAgregarTransportista = $x("//*[@id=\"btnGuardarTransportista\"]");
    public SelenideElement btnAceptarTransportista = $x("/html/body/div[25]/div[3]/div/button");
    public SelenideElement agregarControladora = $x("//*[@id=\"btnAgregarEmpControladora\"]");
    public SelenideElement rfcControladora = $x("//*[@id=\"empresaRfc\"]"); //TSD
    public SelenideElement btnBuscarRfcControladora = $x("//*[@id=\"btnBuscarEmpresa\"]");
    public SelenideElement participacionAccionaria = $x("//*[@id=\"controladora.participacionAccionaria\"]");
    public SelenideElement montoImportaciones = $x("//*[@id=\"controladora.montoImportaciones\"]");
    public SelenideElement montoExportaciones = $x("//*[@id=\"controladora.montoExportaciones\"]");
    public SelenideElement immexsi = $x("//*[@id=\"si2048\"]");
    public SelenideElement ivaIepsSi = $x("//*[@id=\"si2049\"]");
    public SelenideElement btnAgregarControladora = $x("//*[@id=\"btnGuardarControlEmpControladora\"]");
    public SelenideElement btnAceptarControladora = $x("/html/body/div[26]/div[3]/div/button");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[3]/tbody/tr[16]/td[2]/input");
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
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement reconocimientoMutuoNo = $x("//*[@id=\"si4020Controladora\"]");
    public SelenideElement informacionPrivada = $x("//*[@id=\"no1087Contr\"]");
    /// CTPAT
    public SelenideElement ctpat = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[6]/a/span");
    public SelenideElement cbpSi = $x("//*[@id=\"si2089\"]");
    public SelenideElement cbp2Si = $x("//*[@id=\"si2090\"]");
    public SelenideElement cbp3No = $x("//*[@id=\"no2091\"]");




}
