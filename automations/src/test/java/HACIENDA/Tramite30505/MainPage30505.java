package HACIENDA.Tramite30505;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage30505 {

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
    /// Avisos
    public SelenideElement btnModificar = $x("//*[@id=\"AMDButton\"]");
    public SelenideElement tipoAvisos = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement avisoAduanal = $x("//*[@id=\"aviso_1\"]");
    public SelenideElement avisoFusionEscision = $x("//*[@id=\"aviso_4\"]");
    public SelenideElement avisoArticulo99 = $x("//*[@id=\"aviso_5\"]");
    public SelenideElement avisoDenominacion = $x("//*[@id=\"aviso_6\"]");
    /// Fusion Escision
    public SelenideElement fusionEsicion = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement opcion2 = $x("//*[@id=\"fusion2\"]");
    public SelenideElement escision = $x("//*[@id=\"idEscision\"]");
    public SelenideElement certificacionSi = $x("//*[@id=\"idSiCertificacion\"]");
    public SelenideElement rfcEmpresaEscidente = $x("//*[@id=\"idRfcBusqueda\"]");
    public SelenideElement btnBuscarRfcEmpresa = $x("//*[@id=\"btnAceptarDomicilios\"]");
    public SelenideElement fechaEscision = $x("//*[@id=\"fechaFusion\"]");
    public SelenideElement selecFechaEscision = $x("/html/body/div[7]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement folioEscision = $x("//*[@id=\"idFolioFusion\"]");
    public SelenideElement agregarEmpresasEscindidas = $x("//*[@id=\"btnAgregarPersona\"]");
    public SelenideElement certificadoModalSi = $x("//*[@id=\"idSiCertificacionModal\"]");
    public SelenideElement rfcModal = $x("//*[@id=\"idRfcBusquedaModal\"]");
    public SelenideElement btnBuscarRfcModal = $x("//*[@id=\"btnAceptarModal\"]");
    public SelenideElement btnAceptarModal = $x("//*[@id=\"btnAceptarFusionEscision\"]");
    public SelenideElement btnAceptar1 = $x("/html/body/div[11]/div[3]/div/button");
    /// Aduanal
    public SelenideElement aduanal = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[5]/a/label");
    public SelenideElement selectAgente = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div[6]/div/div[2]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement modificarPatente = $x("//*[@id=\"modificarPatente\"]");
    public SelenideElement tipoMovimientoPatente = $x("//*[@id=\"estatusMandatarioScc\"]");
    public SelenideElement btnGuardarModificacionPatente = $x("//*[@id=\"btnGuardarModificarMandatarioScc\"]");
    public SelenideElement btnAgregarPatente = $x("//*[@id=\"agregarPatente\"]");
    public SelenideElement tipoAduanal = $x("//*[@id=\"comboAgenteApoderado\"]");
    public SelenideElement numeroPatente = $x("//*[@id=\"idNumPatenteModal\"]");
    public SelenideElement check1 = $x("//*[@id=\"checkObligFisc\"]");
    public SelenideElement check2 = $x("//*[@id=\"checkAutPantente\"]");
    public SelenideElement btnBuscarPatente = $x("//*[@id=\"btncargarPatente\"]");
    public SelenideElement btnGuardarAduanal = $x("//*[@id=\"btnGuardarSociedadScc\"]");
    public SelenideElement btnAceptar2 = $x("/html/body/div[10]/div[3]/div/button");
    /// Articulo 99
    public SelenideElement articulo99 = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[6]/a/label");
    public SelenideElement ejercicioAnteriorSi = $x("//*[@id=\"idEjercicioSi\"]");
    public SelenideElement montoContribuciones = $x("//*[@id=\"idMontoContribuciones\"]");
    public SelenideElement margenError = $x("//*[@id=\"idMargen\"]");
    public SelenideElement cE = $x("//*[@id=\"idCe\"]");
    public SelenideElement cDV = $x("//*[@id=\"idCdv\"]");
    public SelenideElement cO = $x("//*[@id=\"idCo\"]");
    public SelenideElement cDR = $x("//*[@id=\"idCdr\"]");
    public SelenideElement cPO = $x("//*[@id=\"idCpo\"]");
    public SelenideElement pCO = $x("//*[@id=\"idPco\"]");
    public SelenideElement desarrolloFormula = $x("//*[@id=\"idDesarrollo\"]");
    public SelenideElement mayoraMargenSi = $x("//*[@id=\"idPorcentajeSi\"]");
    public SelenideElement montoTotal = $x("//*[@id=\"idTotalConcepto\"]");
    public SelenideElement observaciones = $x("//*[@id=\"idObservacionesCalculo\"]");
    /// Cambio Denominacion (Se define automaticamente y dice que es la misma)
    public SelenideElement denominacion = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[7]/a");
    public SelenideElement foliosDenominacion = $x("//*[@id=\"folioAcuse\"]");
    /// Pasos siguientes
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement btnAdjuntar2Doc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement segArchivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement segArchivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");




}