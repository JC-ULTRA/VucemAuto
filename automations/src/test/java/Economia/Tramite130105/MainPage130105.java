package Economia.Tramite130105;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130105 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    //seleccionar Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    //Búsqueda Tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement PermisosImporExpor = $x("//*[@id=\"servicios\"]/ul/li[6]/a/span");
    public SelenideElement importacion = $x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[1]/a/span");
    public SelenideElement elementoTramite130105 = $x("//*[@id=\"servicios\"]/ul/li[6]/ul/li[1]/ul/li[4]/a");

    //Pestaña Datos de la solicitud
    //Datos del trámite a realizar
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement selectRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement selectClasificacion = $x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    //Datos de la mercancia
    public SelenideElement radbtnProductoNuevo = $x("//*[@id=\"tabs-3\"]/div[3]/div[1]/div[1]/input");
    public SelenideElement radbtnProductoUsado = $x("//*[@id=\"tabs-3\"]/div[3]/div[1]/div[2]/input");
    public SelenideElement inputDescripcion = $x("//*[@id=\"solicitud.mercancia.descripcion\"]");
    public SelenideElement selectFraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFactura = $x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement selectUMT = $x("//*[@id=\"unidadTarifariaComboId\"]");
    //Partidas de la mercancía
    public SelenideElement inputCantidadPartida = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputValorPartida = $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement inputDescripcionPartida = $x("//*[@id=\"descripcion\"]");
    public SelenideElement btnAgregarPartida = $x("/html/body/main/div[1]/div[4]/div/form/div[2]/div/div[2]/div[10]/div/div/input[2]");
    //Pais Procedencia
    public SelenideElement selectBloquePais = $x("//*[@id=\"bloqueAutocomplete\"]");
    public SelenideElement listaPaisProcedencia = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregarPais = $x("//*[@id=\"agregarPaisBloque\"]");
    public SelenideElement textareaUsoEspecifico = $x("//*[@id=\"tabs-3\"]/div[17]/div/div[2]/textarea");
    public SelenideElement textareaJustificacion = $x("//*[@id=\"tabs-3\"]/div[18]/div/div/textarea");
    public SelenideElement textareaObservaciones = $x("//*[@id=\"tabs-3\"]/div[19]/div/div[2]/textarea");
    //Representación Federal
    public SelenideElement selectEntidad = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement selectRepresentacionFederal = $x("//*[@id=\"representacionFederalSelect\"]");
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement JustificacionDictamen = $x("//*[@id=\"justificacionDictamen\"]");
    public SelenideElement AntecedentesDictamen = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement btnFirmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[3]");
    public SelenideElement btnAutorizarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr/td/input[3]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}