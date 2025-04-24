package Economia.Tramite130112;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130112 {

    //seleccionar Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Tramite130112
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkPermisosImportaciExportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement linkImportaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement elementoTramite130112 = $x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[1]/ul/li[10]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //paso 1
    //Tab Datos de la solicitud
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/ul/li[2]/a/label");
    //Datos del tramite
    public SelenideElement SelectSolicitudRegimenClave = Selenide.$x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement SelectSolicitudClaveClasificacionRegimen = Selenide.$x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    //DATOS MERCANCÍA
    public SelenideElement radbtnProductoNuevo = $x("//*[@id=\"tabs-3\"]/div[3]/div[3]/div[1]/input[1]");
    public SelenideElement radbtnProductoUsado = $x("//*[@id=\"tabs-3\"]/div[3]/div[3]/div[1]/input[2]");
    public SelenideElement textareaDescripcionMercancia = Selenide.$x("//*[@id=\"tabs-3\"]/div[3]/div[3]/div[2]/textarea");
    public SelenideElement SelectFraccionArancelaria = Selenide.$x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidadTarifaria = Selenide.$x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFacturaUSD = Selenide.$x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement selectMercanciaUMT= Selenide.$x("//*[@id=\"solicitud.mercancia.unidadMedidaComercial.clave\"]");
    //PARTIDAS MERCANCÍA
    public SelenideElement inputCantidad = Selenide.$x("//*[@id=\"cantidad\"]");
    public SelenideElement FraccionArancelariaTIGIE= $x("//*[@id=\"fraccionTigieText\"]");
    public SelenideElement selectTipoFraccionTIGIE = $x("//*[@id=\"fraccionArancelariaTIGIE\"]");
    public SelenideElement textareaDescripcion = Selenide.$x("//*[@id=\"descripcion\"]");
    public SelenideElement inputTotalUSDPartida = Selenide.$x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement inputCargarArchivo = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[10]/div/div/input[1]");
    public SelenideElement btnAgregarMercancia = Selenide.$x("//*[@id=\"tabs-3\"]/div[9]/div/div/input[2]");//*[@id="tabs-3"]/div[9]/div/div/input[2]
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
    public SelenideElement paisBloqueOrigenSearch = Selenide.$x("//*[@id=\"paisBloqueOrigenSearch\"]");
    public SelenideElement selectPaisBloqueOrigen = Selenide.$x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregarTodos = Selenide.$x("//*[@id=\"agregarTodosPaisBloque\"]");
    public SelenideElement btnAgregarSeleccion = Selenide.$x("//*[@id='agregarPaisBloque']");
    public SelenideElement btnRestarSeleccion = Selenide.$x("//*[@id='eliminarPaisBloque']");
    public SelenideElement btnRestarTodos = Selenide.$x("//*[@id='eliminarTodosPaisBloque']");
    public SelenideElement textareaPaisBloqueDestinoSearch = Selenide.$x("//*[@id='paisBloqueDestinoSearch']");
    public SelenideElement selectPaisBloqueDestino = Selenide.$x("//*[@id='sPaisBloqueDestino']");
    public SelenideElement textareaUsoEspecifico = Selenide.$x("//*[@id=\"tabs-3\"]/div[16]/div[1]/div/textarea");
    public SelenideElement textareaJustificacionImportacionExportacion = Selenide.$x("//*[@id=\"tabs-3\"]/div[16]/div[2]/div/textarea");
    public SelenideElement textareaObservaciones = Selenide.$x("//*[@id=\"tabs-3\"]/div[16]/div[3]/div[2]/textarea");
    //REPRESENTACIÓN FEDERAL
    public SelenideElement selectEntidadFederativaClave = Selenide.$x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement selectRepresentacionFederal = Selenide.$x("//*[@id='representacionFederalSelect']");
    //GUARDAR SOLICITUD
    public SelenideElement btnContinuarGuardarSolicitud = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement inputSiguienteButton = Selenide.$x("//*[@id='siguienteButton']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelectArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

}
