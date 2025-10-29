package HACIENDA.Tramite32301;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32301 {
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
    public SelenideElement avisoModificacion = $x("//*[@id=\"avisoModificacionIvaEIepsAgaceButton\"]");
    public SelenideElement tipoAviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    /// AVISOS///
    public SelenideElement clientesExtranjeros = $x("//*[@id=\"aviso_2\"]");
    public SelenideElement clientesNacionales = $x("//*[@id=\"aviso_3\"]");
    public SelenideElement avisoSocios = $x("//*[@id=\"aviso_5\"]");
    public SelenideElement avisoInmuebles = $x("//*[@id=\"aviso_6\"]");
    public SelenideElement avisoFracciones = $x("//*[@id=\"aviso_10\"]");
    public SelenideElement avisoFusionEscision = $x("//*[@id=\"aviso_8\"]");
    public SelenideElement casillaAcepto = $x("//*[@id=\"acepto253\"]");

    /// PROVEDORES EXTRANJEROS
    public SelenideElement modificacionExtranjeros = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement archivoExtranjeros = $x("//*[@id=\"archivoExtranjero\"]");
    public SelenideElement btnCargarExtranjeros = $x("//*[@id=\"cargarExtranjero\"]");
    public SelenideElement btnOK = $x("/html/body/div[11]/div[3]/div/button");
    /// PROVEDORES NACIONALES
    public SelenideElement modificacionNacionales = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement archivoNacionales = $x("//*[@id=\"archivoNacional\"]");
    public SelenideElement btnCargarNacionales = $x("//*[@id=\"cargaNacional\"]");

    /// SOCIOS
    public SelenideElement modificacionSocios = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[6]/a/label");
    public SelenideElement btnAgregarMiembro = $x("//*[@id=\"btn-agregar-miembrosEmpresa\"]");
    public SelenideElement tipoSocio = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement tributarMexicoNo = $x("//*[@id=\"socio.tributarMexicoFalse\"]");
    public SelenideElement tipoPersona = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement nacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement nombreEmpresa = $x("/html/body/main/div/div[4]/div[2]/form/div[6]/div/div/div[2]/input");
    public SelenideElement btnAgregarSocio = $x("//*[@id=\"socioAgregarModal\"]");
    public SelenideElement btnAceptar = $x("/html/body/div[12]/div[3]/div/button");
    public SelenideElement selecTodos = $x("//*[@id=\"cb_gridMiembrosEmpresas\"]");
    public SelenideElement nuevoNom = $x("/html/body/main/div/div[4]/div/form/div[2]/div[6]/div[6]/div[1]/div/div/div/div[3]/div[3]/div/table/tbody/tr[3]/td[13]");
    public SelenideElement btnRatificar = $x("//*[@id=\"btn-ratificar-miembrosEmpresa\"]");
    public SelenideElement btnAceptarRatificar = $x("/html/body/div[13]/div[3]/div/button");

    /// INMUEBLES
    public SelenideElement inmuebles = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[7]/a/label");
    public SelenideElement domicilioNuevo = $x("//*[@id=\"tipoDireccionAlta\"]");
    public SelenideElement btnAceptarDomicilioNuevo = $x("/html/body/div[11]/div[3]/div/button[2]");
    public SelenideElement btnAgregarDomicilioNuevo = $x("//*[@id=\"btnAgregarDomiciliosNvo\"]");
    public SelenideElement domicilioInmueble = $x("//*[@id=\"direccionInmuebleC\"]");
    public SelenideElement codigoPostalInmueble = $x("//*[@id=\"codigoPostalInmuebleC\"]");
    public SelenideElement entidadInmueble = $x("//*[@id=\"direccionGrid.cveEntidad\"]");
    public SelenideElement municipioInmueble = $x("//*[@id=\"direccionGrid.cveMunicipio\"]");
    public SelenideElement documentoUsoGoce = $x("//*[@id=\"direccionGrid.cveTipoDoc\"]");
    public SelenideElement fechaInicioInmueble = $x("//*[@id=\"fechaInicialActualCon\"]");
    public SelenideElement selecFecha = $x("/html/body/div[7]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFinInmueble = $x("//*[@id=\"fechaFinalActualCon\"]");
    public SelenideElement selecFechaFin = $x("/html/body/div[9]/table/tbody/tr[5]/td[3]/a");
    public SelenideElement rfcPartes = $x("//*[@id=\"rfcPartesC\"]");
    public SelenideElement btnBuscarPersonaM = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement caracterDe = $x("//*[@id=\"caracterDeCons\"]");
    public SelenideElement agregarPersonaM = $x("//*[@id=\"btnAgregarParteC\"]");
    public SelenideElement btnAceptarPersonaM = $x("/html/body/div[12]/div[3]/div/button");
    public SelenideElement observacionesInmueble = $x("//*[@id=\"observacionesC\"]");
    public SelenideElement agregarNuevoDomicilio = $x("//*[@id=\"btnAceptarDomiciliosNvosModal\"]");
    public SelenideElement btnAceptarNuevoDomicilio = $x("/html/body/div[13]/div[3]/div/button");
    public SelenideElement mismoDomicilioSi = $x("//*[@id=\"si3093\"]");
    public SelenideElement documentoUsoGoce2 = $x("//*[@id=\"solicitud.avisoModificacion.doctoAcredita\"]");
    public SelenideElement modificacionVigenciasNo = $x("//*[@id=\"no3094\"]");
    public SelenideElement modificacionPartesSi = $x("//*[@id=\"si3095\"]");
    public SelenideElement rfcPartesM = $x("//*[@id=\"rfcPartesM\"]");
    public SelenideElement btnBuscarPartesM = $x("/html/body/main/div/div[4]/div/form/div[2]/div[7]/div[35]/div[2]/input");
    public SelenideElement caracterDePartesM = $x("//*[@id=\"caracterDePartesMod\"]");
    public SelenideElement btnAgregarParteM = $x("//*[@id=\"btnAgregarParte\"]");
    public SelenideElement observaciones2 = $x("//*[@id=\"observacionesM\"]");

    /// FUSION ESCESION
    public SelenideElement fusionEscesion = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[8]");
    public SelenideElement aviso1 = $x("//*[@id=\"fusion2\"]");
    public SelenideElement escesion = $x("//*[@id=\"idEscision\"]");
    public SelenideElement certificacionNo = $x("//*[@id=\"idNoCertificacion\"]");
    public SelenideElement rfcEmpresa = $x("//*[@id=\"idRfcBusquedaSC\"]");
    public SelenideElement razonSocial = $x("//*[@id=\"idRazonSocialSC\"]");
    public SelenideElement fechaFusEsc = $x("//*[@id=\"fechaFusion\"]");
    public SelenideElement selecFechaFusEsc = $x("/html/body/div[7]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement folioFusEsc = $x("//*[@id=\"idFolioFusion\"]");
    public SelenideElement btnAgregarPersonaFusEsc = $x("//*[@id=\"btnAgregarPersona\"]");
    public SelenideElement certificacionSi = $x("//*[@id=\"idSiCertificacionModal\"]");
    public SelenideElement rfcPersona = $x("//*[@id=\"idRfcBusquedaModal\"]");
    public SelenideElement btnBuscarPersona = $x("//*[@id=\"btnAceptarModal\"]");
    public SelenideElement btnAceptarPersona = $x("//*[@id=\"btnAceptarFusionEscision\"]");
    public SelenideElement clickAceptar = $x("/html/body/div[12]/div[3]/div/button");

    /// FRACCIONES
    public SelenideElement fracciones = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[9]/a");
    public SelenideElement cargaManual = $x("//*[@id=\"idCargaManual\"]");
    public SelenideElement btnAgregarFrraccion = $x("//*[@id=\"agregaFracciones\"]");
    public SelenideElement fraccionDeclarada = $x("//*[@id=\"txtfraccionDeclCert\"]");
    public SelenideElement actividadRelacionada = $x("//*[@id=\"activRelProc\"]");
    public SelenideElement descripcionMercancia = $x("//*[@id=\"txtDescripcionMercancia\"]");
    public SelenideElement fraccionActual = $x("//*[@id=\"cveFraccionCorrelacion\"]");
    public SelenideElement unidadMedida = $x("//*[@id=\"solicitud.FraccionAvisos.unidadMedida\"]");
    public SelenideElement nico = $x("//*[@id=\"solicitud.FraccionAvisos.cveNico\"]");
    public SelenideElement btnAgregarTodosPaises = $x("/html/body/main/div/div[4]/div[2]/form/div[5]/div[2]/div[2]/a/input");
    public SelenideElement btnGuardarCargaManual = $x("/html/body/main/div/div[4]/div[2]/form/div[6]/div/div[2]");
    public SelenideElement manifiestoFracciones = $x("/html/body/main/div/div[4]/div/form/div[2]/div[9]/div[14]/div/div/div[1]/input");
    /// PROCESOS
    public SelenideElement procesos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[10]/a");
    public SelenideElement archivoProcesos = $x("//*[@id=\"archivoProceso\"]");
    public SelenideElement cargarArchivo = $x("//*[@id=\"cargaArchivoProcesos\"]");
    public SelenideElement aceptarCarga = $x("/html/body/div[11]/div[3]/div/button");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnAdjuntar1Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivoUnico = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");

    //Funcionario
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioFun = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement opinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement anexarInfoDigitalizada = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div/div/table[2]/tbody/tr[1]/td[2]/input");
    public SelenideElement archivoAnexar = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement enviarArchivo = $x("//*[@id=\"btnCargaArchivo\"]");
    public SelenideElement destinadoPara = $x("//*[@id=\"tramite.dictamen.usoAutorizadoDictamen\"]");
    public SelenideElement observaciones = $x("//*[@id=\"observacion\"]");
    public SelenideElement plazo = $x("//*[@id=\"tramite.dictamen.plazoVigencia\"]");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[3]");
    public SelenideElement darVoBo = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement firmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[1]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
    public SelenideElement objetoImportacion = $x("//*[@id=\"objetoImportacion\"]");
    public SelenideElement restricciones = $x("//*[@id=\"tramite.dictamen.restriccionesDictamen[0].restriccionTipoTramite.idRestriccionTipoTramite\"]");
    public SelenideElement componentes = $x("//*[@id=\"descripcionDetalladaMercancia\"]");
    public SelenideElement clasificacionToxicologica = $x("//*[@id=\"tramite.dictamen.clasificacionToxicologica.idClasificacionToxicologicaTipoTramite\"]");
    public SelenideElement usoEspecificoMercancia = $x("//*[@id=\"descripcionUsoAutorizado\"]");
    public SelenideElement siglasDictaminador = $x("//*[@id=\"siglasDictaminador\"]");
    public SelenideElement deseaEstablecerFecha = $x("//*[@id=\"blnGenerico1\"]");



}
