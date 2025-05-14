package HACIENDA.Tramite33304;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage33304 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement soliSubsecuente = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement folioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement tablaFolios = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");
    /// ACUSES Y RESOLUCIONES
    public SelenideElement btnAvisoModificacionCeI = $x("//*[@id=\"avisoModificacionComerAgaceButton\"]");
    //AVISO MODIFICACION
    public SelenideElement checkVariacion = $x("//*[@id=\"aviso_6\"]");
    public SelenideElement labelAvisoModGoceInmueble = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement inputDireccionInmueble = $x("//*[@id=\"direccionInmuebleC\"]");
    public SelenideElement inputCodigoPostal = $x("//*[@id=\"codigoPostalInmuebleC\"]");
    public SelenideElement inputEntidadFederativa = $x("//*[@id=\"solicitud.avisoConsulta.entidadFederativa\"]");
    public SelenideElement inputMunicipio = $x("//*[@id=\"solicitud.avisoConsulta.municipio\"]");
    public SelenideElement inputDoctoAcredita = $x("//*[@id=\"solicitud.avisoConsulta.doctoAcredita\"]");
    public SelenideElement inputFechaInicioVigencia = $x("//*[@id=\"fechaInicialActualCon\"]");
    public SelenideElement inputFechaFinVigencia = $x("//*[@id=\"fechaFinalActualCon\"]");
    public SelenideElement inputRFC = $x("//*[@id=\"rfcPartesC\"]");
    public SelenideElement btnBuscarRFC = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement btnAgregarParteC = $x("//*[@id=\"btnAgregarParteC\"]");
    public SelenideElement inputObservaciones = $x("//*[@id=\"observacionesC\"]");
    public SelenideElement inputMismoRegistro = $x("//*[@id=\"si3093\"]");
    public SelenideElement inputDoctoAcreditaUsoGoce = $x("//*[@id=\"solicitud.avisoModificacion.doctoAcredita\"]");
    public SelenideElement inputModificacionVigencias = $x("//*[@id=\"si3094\"]");
    public SelenideElement inputFechaInicialAnterior = $x("//*[@id=\"fechaInicialAnteriorMod\"]");
    public SelenideElement inputFechaFinalAnterior = $x("//*[@id=\"fechaFinalAnteriorMod\"]");
    public SelenideElement inputFechaInicialActual = $x("//*[@id=\"fechaInicialActualMod\"]");
    public SelenideElement inputFechaFinalActual = $x("//*[@id=\"fechaFinalActualMod\"]");
    public SelenideElement inputModificacionPartes = $x("//*[@id=\"si3095\"]");
    public SelenideElement inputRFCPartes = $x("//*[@id=\"rfcPartesM\"]");
    public SelenideElement btnBuscarPersona = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement btnAgregarParte = $x("//*[@id=\"btnAgregarParte\"]");
    public SelenideElement inputObservacionesM = $x("//*[@id=\"observacionesM\"]");
    //AVISO FUSION ESCISIÓN
    public SelenideElement checkAvisoFusionEscision = $x("//*[@id=\"aviso_8\"]");
    public SelenideElement labelAvisoFusionEscision = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputFusion1 = $x("//*[@id=\"fusion1\"]");
    public SelenideElement inputFusion2 = $x("//*[@id=\"fusion2\"]");
    public SelenideElement inputFusion3 = $x("//*[@id=\"fusion3\"]");
    public SelenideElement inputFusion = $x("//*[@id=\"idFusion\"]");
    public SelenideElement inputRegistroEIC = $x("//*[@id=\"idSiCertificacion\"]");
    public SelenideElement inputRFCFusionEIC = $x("//*[@id=\"idRfcBusqueda\"]");
    public SelenideElement btnAceptarDomicilios = $x("//*[@id=\"btnAceptarDomicilios\"]");
    public SelenideElement input = $x("");
    public SelenideElement input1 = $x("");
    public SelenideElement input2 = $x("");
    public SelenideElement input3 = $x("");
    public SelenideElement input4 = $x("");
    public SelenideElement input5 = $x("");
    public SelenideElement input6 = $x("");


    //AVISO PAGO
    public SelenideElement checkPresentacionPago = $x("//*[@id=\"aviso_20\"]");
    public SelenideElement checkProtestaFacultades = $x("//*[@id=\"acepto253\"]");
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[6]/a/label");
    public SelenideElement inputReferenciaBancaria = $x("//*[@id=\"solicitud.pagoSCC.referenciaBancaria\"]");
    public SelenideElement inputBanco = $x("//*[@id=\"solicitud.pagoSCC.banco.clave\"]");
    public SelenideElement inputLlavePago = $x("//*[@id=\"solicitud.pagoSCC.llaveDePago\"]");
    public SelenideElement inputFechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement btnGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDocumentos = $x("/html/body/main/div/div[4]/div[1]/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement selectArchivo = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuar2 = $x("//*[@id=\"siguienteButton\"]");








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
}
