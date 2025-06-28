package AMECAFE.Tramite290201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage290201 {

    //Tramite 290201
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement AMECAFE = $x("//img[contains(@alt, 'Café')]");
    public SelenideElement CerificadosLicenciaPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a/span");
    public SelenideElement Tramite290201 = $x("//a[contains(@onclick, 'certificado')]");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la solicitud
    public SelenideElement labelDatosSolicitud = $x("//label[@for='solicitud.titulo']");
    //Información del cáfe
    public SelenideElement selectFormaCafe = $x("//*[@id='solicitud.formasCafe']");
    public SelenideElement selectTipos = $x("//*[@id='tipoCafeClasificacion']");
    public SelenideElement selectCalidad = $x("//*[@id='calidadCafeClasificacion']");
    public SelenideElement selectProcesos = $x("//*[@id='procesoCafeClasificacion']");
    public SelenideElement selectCertificaciones = $x("//*[@id=\"certificacionCafeClasificacion\"]");

    //Destino
    public SelenideElement selectSolicitudClaveAduana = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement selectSolicitudPaisProcedenciaClave = $x("//*[@id='solicitud.paisProcedencia.clave']");

    //Procedencia
    public SelenideElement selectSolicitudEntidadesEntidadClave = $x("//*[@id='solicitud.entidadesSolicitud[0].entidad.clave']");//*[@id="solicitud.entidadesSolicitud[0].entidad.clave"]

    //Ciclo cafetalero
    public SelenideElement selectSolicitudDescripcionGenerica = $x("//*[@id='solicitud.descripcionGenerica1']");

    //Lotes
    //Agregar lote
    public SelenideElement inputAgregarLote = $x("//*[@id=\"btn-agregar-lote\"]");
    //Datos del café
    public SelenideElement selectGenerica = $x("//*[@id='generica1']");
    public SelenideElement selectAceptada = $x("//*[@id='aceptada']");
    //Si: Café materia prima
    public SelenideElement CantidadUtilizadaElaborar = $x("//*[@id=\"cantidadPresentacion\"]");
    public SelenideElement NumPedimento = $x("//*[@id=\"numeroOficioCasoEspecial\"]");
    public SelenideElement selectPaisImportacion = $x("//*[@id=\"condicionAlmacenamientoPrimario\"]");
    public SelenideElement selectFraccion = $x("//*[@id=\"fraccionTipoTramite.fraccion.clave\"]");

    //Factura y Cantidad
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUnidadMedidaComercialClave = $x("//*[@id='unidadMedidaComercial.clave']");
    public SelenideElement inputMercanciasImporteTotalComponente = $x("//*[@id='mercancias.importeTotalComponente']");
    public SelenideElement selectMonedaClave = $x("//*[@id='moneda.clave']");

    //Marcas
    public SelenideElement inputNumeroLote = $x("//*[@id='numeroLote']");
    public SelenideElement inputDescripcionMercancia = $x("//*[@id='descripcionMercancia']");

    //Características Especiales
    public SelenideElement selectBooleanGenerico = $x("//*[@id='booleanGenerico1']");
    //Sí: Características especiales
    public SelenideElement checkCafeEspecial = $x("//input[@name='detalles.marca' and @value='CARCFE.001']");
    public SelenideElement checkCafePractices = $x("//input[@name='detalles.marca' and @value='CARCFE.009']");
    public SelenideElement checkAves =$x("//input[@name='detalles.marca' and @value='CARCFE.007']");
    public SelenideElement checkComunidad =$x("//input[@name='detalles.marca' and @value='CARCFE.002']");
    public SelenideElement checkComercio =$x("//input[@name='detalles.marca' and @value='CARCFE.004']");
    public SelenideElement checkEuregap =$x("//input[@name='detalles.marca' and @value='CARCFE.003']");
    public SelenideElement checkOtros =$x("//input[@name='detalles.marca' and @value='CARCFE.011']");
    public SelenideElement checkRainforest =$x("//input[@name='detalles.marca' and @value='CARCFE.006']");
    public SelenideElement checkQCoffee = $x("//input[@name='detalles.marca' and @value='CARCFE.005']");
    public SelenideElement checkNespresso = $x("//input[@name='detalles.marca' and @value='CARCFE.010']");
    public SelenideElement checkUTZ = $x("//input[@name='detalles.marca' and @value='CARCFE.008']");

    public SelenideElement inputFechaSalida = $x("//*[@id='fechaSalida']");

    //Transbordo
    public SelenideElement selectCondicionAlmacenamientoSecundario = $x("//*[@id='condicionAlmacenamientoSecundario']");
    public SelenideElement selectGenerica2 = $x("//*[@id='generica2']");
    public SelenideElement inputMarcasEmbarque = $x("//*[@id='marcasEmbarque']");
    //Observaciones
    public SelenideElement textareaDescripcionTratamiento = $x("//*[@id='descripcionTratamiento']");
    public SelenideElement inputAgregarLote2 = $x("//input[@onclick='guardarLotes()']");

    //Pestaña Terceros relacionados
    public SelenideElement tabTercerosRelacionados = $x("//*[@id=\"ui-id-3\"]/label");
    //Agregar destinatario
    public SelenideElement btnAgregarDestinatario = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    //Tipo de persona
    public  SelenideElement radbtnPersonaFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public  SelenideElement radbtnPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    //Tipo de persona física
    public SelenideElement inputTercerosNombre = $x("//*[@id='terceros_nombre']");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id='terceros_apellidoPaterno']");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id='terceros_apellidoMaterno']");
    //Tipo de persona moral
    public SelenideElement DenominacionTerceros = $x("//*[@id=\"terceros_rSocial\"]");
    //Datos generales
    public SelenideElement TercerosDomicilio = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement selectTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement selectTercerosCodPostal = $x("//*[@id=\"terceros_codPostal\"]");//*[@id="terceros_codPostal"]
    public SelenideElement inputTercerosTelefono = $x("//*[@id='terceros_telefono']");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id='terceros_correoElec']");
    public SelenideElement buttonGuardarDatosTercero = $x("//*[@id='btnGuardarFrmDatosTercero']");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");





}
