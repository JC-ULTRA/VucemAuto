package SEDENA.Tramite240107;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage240107 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Tramite 240107
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement SEDENA = $x("//*[@id=\"workingArea\"]/form/a[5]/img");
    public SelenideElement linkCerLicPer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkPermisoAduanalSEDENA = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement elementoTramite240107 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[1]/ul/li[7]/a");

    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputOrigenLista = $x("//*[@id=\"origenlistaOrigen\"]");
    public SelenideElement inputAddOrigenLista = $x("//*[@id=\"addlistaOrigen\"]");
    public SelenideElement inputUsoFinalMercancia = $x("//*[@id=\"solicitud.mercancia.usoFinal\"]");

    public SelenideElement PermisoGeneral = $x("//*[@id=\"tabs-2\"]/div[3]/div[1]/input");//*[@id="tabs-2"]/div[3]/div[1]/input
    public SelenideElement fechaEntrada = $x("//*[@id=\"fechaEntradaMercancia1\"]");
    public SelenideElement UsoFinalMercancia = $x("//*[@id=\"solicitud.mercancia.usoFinal\"]");
    //Agregar Mercancia
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");
    public SelenideElement inputDescripcionMercancia = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement inputFraccionArancelariaMercancia = $x("//*[@id=\"mercanciaGrid.fraccionArancelaria.clave\"]");
    public SelenideElement inputCantidadUMTMercancia = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement inputValorComercialMercancia = $x("//*[@id=\"idImporteFacturaUSD\"]");
    public SelenideElement selectUMCMercancia = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement inputTipoMonedaMercancia = $x("//*[@id=\"mercanciaGrid.tipoMoneda\"]");
    public SelenideElement btnAgregarMercancia2 = $x("//*[@id=\"btnAgregarMercancia\"]");

    //Periodo
    public SelenideElement btnRad1TercerPeriodo = $x("//*[@id=\"semestre1\"]");
    public SelenideElement btnRad2TercerPeriodo = $x("//*[@id=\"semestre2\"]");
    public SelenideElement checkAñoCurso = $x("//*[@id=\"anioCurso\"]");

    //Manifiesto
    public SelenideElement checkManifiesto = $x("//*[@id=\"declaracion[0]\"]");

    //TERCEROS RELACIONADOS
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement btnAgregarProveedor = $x("//*[@id=\"agregarTercero_TIPERS_PVD\"]");
    public SelenideElement inputNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement inputExtranjera = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement inputFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTercerosNombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTercerosDenominacion = $x("//*[@id=\"terceros_rSocial\"]");
    //Domicilio
    public SelenideElement selectPais = $x("//*[@id=\"terceros_selectPais\"]");//*[@id="terceros_selectPais"]
    public SelenideElement inputTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputTercerosEstado = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement EstadoProveedor = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement inputTercerosMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement inputTercerosLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement inputTercerosCP = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement inputTercerosCP2 = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement inputTercerosColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement inputTercerosNumeroExt = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement inputTercerosNumeroInt = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputTercerosLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id=\"terceros_correoElec\"]");
    //Guardar terceros
    public SelenideElement btnGuardarTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}