package Economia.Tramite130109;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130109 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkPermisosImportaciExportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement linkImportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement linkImpNeuRecPruLab = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/ul/li[7]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/ul/li[2]/a/label");
    //DATOS TRÁMITE
    public SelenideElement SelectSolicitudRegimenClave = Selenide.$x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement SelectSolicitudClaveClasificacionRegimen = Selenide.$x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    //DATOS MERCANCÍA
    public SelenideElement inputUsado = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[3]/div[1]/div[2]/input");
    public SelenideElement textareaDescripcionMercancia = Selenide.$x("//*[@id=\"solicitud.mercancia.descripcion\"]");
    public SelenideElement SelectFraccionArancelaria = Selenide.$x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidadTarifaria = Selenide.$x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFacturaUSD = Selenide.$x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement selectUnidadTarifaria = Selenide.$x("//*[@id=\"unidadTarifariaComboId\"]");
    //PARTIDAS MERCANCÍA
    public SelenideElement inputCantidad = Selenide.$x("//*[@id=\"cantidad\"]");
    public SelenideElement inputTotalUSDPartida = Selenide.$x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement textareaDescripcion = Selenide.$x("//*[@id=\"descripcion\"]");
    public SelenideElement inputCargarArchivo = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[10]/div/div/input[1]");
    public SelenideElement btnAgregar = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div/input[2]");
    //CARGAR ARCHIVO
    public SelenideElement inputArchivoAdjuntar = Selenide.$x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement inputDocumentosFile = $x("//input[@type='file']");
    public SelenideElement btnCerrarAdjuntar = Selenide.$x("//*[@id=\"cerrarAdjuntar\"]");
    public SelenideElement btnCargarArchivo = Selenide.$x("//*[@id=\"cargaArchivo\"]");
    public SelenideElement checkPartidaMercancia = Selenide.$x("//*[@id=\"cb_gridPartidaMercancias\"]");
    public SelenideElement textareaCantidadDispobible = Selenide.$x("//*[@id=\"cantidadDispobible\"]");
    public SelenideElement textareaCantidadUsdDispobible = Selenide.$x("//*[@id=\"cantidadUsdDispobible\"]");
    public SelenideElement btnEliminarPArtida = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[14]/div/div/input[1]");
    public SelenideElement btnModificarPArtida = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[14]/div/div/input[2]");
    //PAÍS PROCEDENCIA
    public SelenideElement bloqueAutocomplete = Selenide.$x("//*[@id=\"bloqueAutocomplete\"]");
    public SelenideElement inputPaises = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[16]/div[1]/div[2]/div[2]/a/input");
    public SelenideElement paisBloqueOrigenSearch = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[16]/div[2]/div[1]/div[3]/select/option[2]");
    public SelenideElement selectPaisBloqueOrigen = Selenide.$x("//*[@id=\"agregarPaisBloque\"]");
    public SelenideElement btnAgregarTodos = Selenide.$x("//*[@id=\"agregarTodosPaisBloque\"]");
    public SelenideElement btnAgregarSeleccion = Selenide.$x("//*[@id='agregarPaisBloque']");
    public SelenideElement btnRestarSeleccion = Selenide.$x("//*[@id='eliminarPaisBloque']");
    public SelenideElement btnRestarTodos = Selenide.$x("//*[@id='eliminarTodosPaisBloque']");
    public SelenideElement textareaPaisBloqueDestinoSearch = Selenide.$x("//*[@id='paisBloqueDestinoSearch']");
    public SelenideElement selectPaisBloqueDestino = Selenide.$x("//*[@id='sPaisBloqueDestino']");
    public SelenideElement textareaUsoEspecifico = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[17]/div/div[2]/textarea");
    public SelenideElement textareaJustificacionImportacionExportacion = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[18]/div/div/textarea");
    public SelenideElement textareaObservaciones = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[19]/div/div[2]/textarea");
    //REPRESENTACIÓN FEDERAL
    public SelenideElement selectEntidadFederativaClave = Selenide.$x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement selectRepresentacionFederal = Selenide.$x("//*[@id='representacionFederalSelect']");
    //GUARDAR SOLICITUD
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
