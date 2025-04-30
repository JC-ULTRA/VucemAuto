package Economia.Tramite130217;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130217 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");

    public SelenideElement btnIngresFs = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = Selenide.$x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkPermisos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement linkExportacion = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[2]/a");
    public SelenideElement linkPermisoPreConExpo = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[2]/ul/li[3]/a");
    //DATOS Solicitud
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement LabelDatosSolicitud = Selenide.$x("//*[@id='ui-id-2']");

    public SelenideElement SelectSolicitudRegimenClave = Selenide.$x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement SelectSolicitudClaveClasificacionRegimen = Selenide.$x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    //DATOS MERCANCÍA
    public SelenideElement radbtnProductoNuevo = $x("//*[@id=\"tabs-3\"]/div[2]/div[1]/div[2]/label/input");
    public SelenideElement radbtnProductoUsado = $x("//*[@id=\"tabs-3\"]/div[4]/div[1]/div[2]/input");
    public SelenideElement textareaDescripcionMercancia = Selenide.$x("//*[@id=\"solicitud.mercancia.descripcion\"]");
    public SelenideElement SelectFraccionArancelaria = Selenide.$x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidadTarifaria = Selenide.$x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFacturaUSD = Selenide.$x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement selectMercanciaUMT= Selenide.$x("//*[@id=\"solicitud.mercancia.unidadMedidaComercial.clave\"]");
    //PARTIDAS MERCANCÍA
    public SelenideElement inputCantidad = Selenide.$x("//*[@id=\"cantidad\"]");
    public SelenideElement inputValor= $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement textareaDescripcion = Selenide.$x("//*[@id=\"descripcion\"]");
    public SelenideElement inputTotalUSDPartida = Selenide.$x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement inputCargarArchivo = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[10]/div/div/input[1]");
    public SelenideElement btnAgregarMercancia = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div/input[2]");
    //CARGAR ARCHIVO (Partida Mercancía)
    public SelenideElement inputBloque = Selenide.$x("//*[@id=\"bloqueAutocomplete\"]");
    public SelenideElement inputPaisOrigen = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement inputAgregarPais = Selenide.$x("//*[@id=\"agregarPaisBloque\"]");
    public SelenideElement textareaUsoEspecifico = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[17]/div/div[2]/textarea");
    public SelenideElement textareaJustificacion = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[18]/div/div/textarea");
    public SelenideElement textareaObservaciones = Selenide.$x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[19]/div/div[2]/textarea");
    public SelenideElement selectEntidadFederativa = Selenide.$x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selesctRepresentacioFederal = Selenide.$x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement inputGuardaSolicitud = Selenide.$x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[5]/td[2]/div/input[2]");
    public SelenideElement inputDocument0 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputDocument1 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputAdjuntarDocumentos = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

}
