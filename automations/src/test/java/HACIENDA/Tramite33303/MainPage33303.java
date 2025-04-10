package HACIENDA.Tramite33303;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage33303 {
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
    public SelenideElement btnModificar = $x("//*[@id=\"avisoModificacionSCCAgaceButton\"]");

    public SelenideElement tipoAvisos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");

    public SelenideElement avisoUsoGoce = $x("//*[@id=\"aviso_6\"]");

    /// Uso y Goce
    public SelenideElement usoGoce = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[6]/a/label");
    public SelenideElement domicilio = $x("//*[@id=\"direccionInmuebleC\"]");
    public SelenideElement codigoPostal = $x("//*[@id=\"codigoPostalInmuebleC\"]");
    public SelenideElement entidadFederativa = $x("//*[@id=\"solicitud.avisoConsulta.entidadFederativa\"]");
    public SelenideElement municipio = $x("//*[@id=\"solicitud.avisoConsulta.municipio\"]");
    public SelenideElement documentoUsoGoce = $x("//*[@id=\"solicitud.avisoConsulta.doctoAcredita\"]");
    public SelenideElement fechaInicioUsoGoce = $x("//*[@id=\"fechaInicialActualCon\"]");
    public SelenideElement selecFecha = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFin = $x("//*[@id=\"fechaFinalActualCon\"]");
    public SelenideElement selecFechaFin = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a");
    public SelenideElement rfcPartes = $x("//*[@id=\"rfcPartesC\"]");
    public SelenideElement buscarRfcPartes = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement caracterDePartes = $x("//*[@id=\"caracterDeCons\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"btnAgregarParteC\"]");
    public SelenideElement observacionesPartes = $x("//*[@id=\"observacionesC\"]");
    public SelenideElement mismoDomicilio = $x("//*[@id=\"no3093\"]");
    public SelenideElement domicilioNuevo = $x("//*[@id=\"direccionInmuebleM\"]");
    public SelenideElement codigoPostalNuevo = $x("//*[@id=\"codigoPostalInmuebleM\"]");
    public SelenideElement estadoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.entidadFederativa\"]");
    public SelenideElement municipioNuevo = $x("//*[@id=\"solicitud.avisoModificacion.municipio\"]");
    public SelenideElement documentoNuevo = $x("//*[@id=\"solicitud.avisoModificacion.doctoAcredita\"]");
    public SelenideElement fechaInicioNueva = $x("//*[@id=\"fechaInicialActualMod\"]");
    public SelenideElement selecFechaNuevo = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement fechaFinNuevo = $x("//*[@id=\"fechaFinalActualMod\"]");
    public SelenideElement selecFechaFinNuevo = $x("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[3]/a");
    public SelenideElement rfcPartesNuevo = $x("//*[@id=\"rfcPartesM\"]");
    public SelenideElement buscarRfcPartesNuevo = $x("//*[@id=\"btnBuscarPersonaM\"]");
    public SelenideElement caracterDePartesNuevas = $x("//*[@id=\"caracterDePartesMod\"]");
    public SelenideElement observacionesPartesNuevo = $x("//*[@id=\"observacionesM\"]");

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
