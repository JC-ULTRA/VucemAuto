package AGRICULTURA.Tramite220103;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage220103 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Loging
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda Tramite 220103
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Agricultura = $x("//img[contains(@alt, 'Rural')]");
    public SelenideElement certysol = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement RequsitoImpor = $x("//*[@id=\"servicios\"]/ul/li/ul/li[1]/a/span");
    public SelenideElement elementoTramite220103 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[1]/ul/li[2]/a");


    //Paso 1 CAPTURAR SOLICITUD
    // Pestaña Datos Solicitud
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]/label");
    //Datos del tramite
    public SelenideElement selectAduanaIngreso = $x("//*[@id=\"aduanas\"]");
    public SelenideElement selectMedioTransporte = $x("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]");
    public SelenideElement IdTransporte = $x("//*[@id=\"tabs-2\"]/div[2]/div[3]/div/input");

    //Agregar mercancía
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");
    //Datos Mercancía
    public SelenideElement Descripcion = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement FraccionArancelaria = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement CantidadUMT = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement CantidadUMC = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement selectUMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement NombreComun = $x("//*[@id=\"nombreComun\"]");
    public SelenideElement NombreCientifico = $x("//*[@id=\"nombreCientifico\"]");
    public SelenideElement FaseDesarrollo = $x("//*[@id=\"faseDesarrollo\"]");
    public SelenideElement selectUso = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement selectOrigen = $x("//*[@id=\"mercanciaGrid.idOrigen\"]");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement selectPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement btnGuardarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");

    //Pestaña Instalación Procedencia
    public SelenideElement tabInstalacionProcedencia = $x("//*[@id=\"ui-id-3\"]/label");
    //Datos de instalación de procedencia
    public SelenideElement NumEstablecimiento = $x("//*[@id=\"tabs-3\"]/div[2]/div/div/input");
    public SelenideElement CoordenadasGeograficas = $x("//*[@id=\"tabs-3\"]/div[3]/div/div/input");

    //Pestaña Terceros relacionados
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-4\"]/label");
    //Proveedor
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    //INstalación de procedencia
    public SelenideElement btnAgregarInstalacionProcedencia = $x("//*[@id=\"agregarTercero_TIPERS_INSPR\"]");

    //Datos persona física
    public SelenideElement radbtnPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement TercerosNombre =$x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement TercerosApellidoPaterno =$x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement TercerosApellidoMaterno =$x("//*[@id=\"terceros_apellidoMaterno\"]");

    //Datps persona moral
    public SelenideElement radbtnPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement TercerosDenominacionRazon = $x("//*[@id=\"terceros_rSocial\"]");

    //Datos generales
    public SelenideElement selectTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement Domicilio = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement TercerosCodigoPostal = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement selectTercerosEstado = $x("//*[@id='terceros_selectEstado']");
    public SelenideElement selectTercerosMunicipio = $x("//*[@id='terceros_selectMunicipio']");
    public SelenideElement selectTercerosColonia= $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id='terceros_calle']");
    public SelenideElement inputTercerosNumExterior = $x("//*[@id='terceros_numExterior']");
    public SelenideElement inputTercerosNumInterior = $x("//*[@id='terceros_numInterior']");
    public SelenideElement inputTerceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");


    //Pestaña Terceros relacionados
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //PASO 2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub Paso 3
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

}
