package Economia.Tramite190101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage190101 {
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
    public SelenideElement linkDireccionGeneralNormas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/a");
    public SelenideElement linkCerfiticacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/a");
    public SelenideElement linkCerfiticacionNOM = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/ul/li[1]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement labelDatosGenerales = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[1]/a/label");
    ////////////////////////////////////////////////////////
    //Certificación con verificación mediante pruebas periódicas al producto
    public SelenideElement input1 = $x("//*[@id='PRUEBAS_PERIODICAS_AL_PRODUCTO']");
    public SelenideElement selectClasificacionNorma = $x("//*[@id='clasificacionNorma']");
    public SelenideElement selectNormaAplicable = $x("//*[@id='normaAplicable']");
    public SelenideElement inputTiuad = $x("//*[@id='TIUAD.DA']"); //*[@id="TIUAD.OCNOM"]
    public SelenideElement inputSolicitudRegimen = $x("//input[@value='NACIONAL']");
    public SelenideElement inputSolicitudRegimen2 = $x("//input[@value='IMPORTACION']");
    public SelenideElement inputSolicitudRegimen3 = $x("//input[@value='EXPORTACION']");
    public SelenideElement inputSolicitudRegimen4 = $x("//input[@value='NACIONAL_IMPORTACION']");
    public SelenideElement inputSolicitudRegimen5 = $x("//input[@value='NACIONAL_EXPORTACION']");
    //MERCANCIA
    public SelenideElement labelMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[2]/a/label");
    public SelenideElement inputNuevo = $x("//input[@name='solicitud.categoriaProducto' and @value='NUEVO']\n");
    public SelenideElement inputSolicitudDescripcionOtroTipo = $x("//*[@id='solicitud.descripcionOtroTipoDePropietarioAeronave']");
    public SelenideElement inputTicp = $x("//*[@id=\"TICP.CFP\"]\n");
    public SelenideElement btnAceptar = $x("/html/body/div[18]/div[3]/div/button");
    public SelenideElement inputSolicitudProductoMarca = $x("//*[@id='solicitud.producto.marca']");
    public SelenideElement inputSolicitudProductoModeloRepresentativo = $x("//input[contains(@name, 'epresentativo')]");
    public SelenideElement inputSolicitudProductoTipo = $x("//input[@maxlength='199']");
    public SelenideElement inputSolicitudProductoSubtipo = $x("//input[@name='solicitud.producto.subtipo']");
    public SelenideElement textareaAccesoriosProducto = $x("//*[@id='accesoriosProducto']");
    public SelenideElement inputAgregarFracciones = $x("//*[@id='btnAgregarFracciones']");
    public SelenideElement inputAgregarFracciones2 = $x("/html/body/main/div/div[4]/div[2]/div[2]/div/div/div/ul/li[1]/a/ins[1]");
    public SelenideElement inputAgregarFracciones4 = $x("/html/body/main/div/div[4]/div[2]/div[4]/div[2]/div/input[2]");

    public SelenideElement inputTicp2 = $x("//*[@id=\"TICP.CFFM\"]");
    public SelenideElement inputFamiliaModelos = $x("//*[@id=\"idTextoFamilia\"]");
    public SelenideElement btnAgregarFamilia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/div[2]/div[3]/div[3]/div[2]/div/input");
    public SelenideElement inputMarcaFamilia = $x("//*[@id=\"solicitud.producto.marcaFamilia\"]");
    public SelenideElement inputModeloRepresentativoFamilia = $x("//*[@id=\"modeloRepresentativoFamilia\"]");
    public SelenideElement inputSolicitudProductoTipoFamilia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/div[2]/div[3]/div[6]/div[3]/input");
    public SelenideElement inputSolicitudProductoSubtipoFamilia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/div[2]/div[3]/div[6]/div[4]/input");
    public SelenideElement textareaAccesoriosProductofamilia = $x("//*[@id=\"accesoriosProducto\"]");
    public SelenideElement inputAgregarFraccionesFamlia = $x("//*[@id='btnAgregarFracciones']");
    public SelenideElement inputAgregarFracciones2Familia = $x("/html/body/main/div/div[4]/div[2]/div[2]/div/div/div/ul/li[1]/a/ins[1]");
    public SelenideElement inputAgregarFracciones4Familia = $x("/html/body/main/div/div[4]/div[2]/div[4]/div[2]/div/input[2]");



    public SelenideElement inputTicp3 = $x("//*[@id='TICP.CFL']");
    public SelenideElement inputTamanoLotes = $x("//*[@id=\"idTamanioProductoLotes\"]");
    public SelenideElement inputUnidadMedida = $x("//*[@id=\"unidadMedida\"]");
    public SelenideElement inputNumSerie = $x("//*[@id=\"modNumSerie\"]");
    public SelenideElement inputMarcaLotes = $x("//*[@id=\"marcaLotes\"]");
    public SelenideElement inputModeloLotes = $x("//*[@id=\"modeloLotes\"]");
    public SelenideElement inputSerieLotes = $x("//*[@id=\"serieLotes\"]");
    public SelenideElement btnAgregarLotes = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/div[2]/div[5]/div[2]/div/div/input");
    public SelenideElement textareaAccesoriosProductoLote = $x("//*[@id=\"accesoriosProducto\"]");

    //BODEGAS
    public SelenideElement labelBodegas = $x("//label[@for='dgn.bodegasPlantas.titulo']");
    public SelenideElement selectEntidadBodega = $x("//*[@id='entidadBodega']");
    public SelenideElement selectEntidadBodegaDomicilio = $x("//*[@id='entidadBodegaDomicilio']");
    public SelenideElement inputAgregarBodega = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div/input[2]");
    //INFROME LABORATORIO
    public SelenideElement labelInformeLaboratorio = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[4]/a/label");
    public SelenideElement inputAgregarNoAcreditado = $x("//*[@id='agregarInformeNoAcreditadoRegistro']");
    public SelenideElement btnBuscarLaboratorio = $x("//*[@id=\"tabs-datosLaboratorio\"]/div/div/div[1]/div[2]/div[2]/div/input");
    public SelenideElement inputLaboratorioNoAcreditado = $x("//*[@id=\"idcampoRfcLaboratorioNoAcreditado\"]");
    public SelenideElement btnObtenerDatosLaboratorio = $x("/html/body/main/div/div[4]/div[3]/div[3]/div/div/input[2]");
    public SelenideElement labelCamposFormulario = $x("/html/body/main/div/div[4]/div[3]/form/div[1]/ul/li[2]/a/label");
    public SelenideElement inputNormaAplicable = $x("//*[@id=\"solicitud.informeLaboratorio.normaAplicable.idNormaAplicable\"]");
    public SelenideElement inputMarca = $x("//*[@id=\"marcaParaInformeNoAcreditado\"]");
    public SelenideElement inputFechaInicioPruebas = $x("//*[@id=\"idFechaPruebasInicial\"]");
    public SelenideElement inputFechaFinalPruebas = $x("//*[@id=\"idFechaPruebasFinal\"]");
    public SelenideElement inputFechaEmision = $x("//*[@id=\"idFechaInicial\"]");
    public SelenideElement inputFechaFinal = $x("//*[@id=\"idFechaFinal\"]");
    public SelenideElement inputModeloEvaluado = $x("//*[@id=\"solicitud.informeLaboratorio.modeloEvaluado\"]");
    public SelenideElement inputNumeroInforme = $x("//*[@id=\"solicitud.informeLaboratorio.numeroInforme\"]");
    public SelenideElement labelNumeroSerie = $x("/html/body/main/div/div[4]/div[3]/form/div[1]/ul/li[3]/a/label");
    public SelenideElement inputUnidadesProducto = $x("//*[@id=\"unidadesDeProducto\"]");
    public SelenideElement inputAgregarSerial = $x("//*[@id=\"agregaSerialNum\"]");
    public SelenideElement btnAgregarSerial = $x("//*[@id=\"agregarSerialNum\"]");
    public SelenideElement btnAgregarInformeLaboratorio = $x("/html/body/main/div/div[4]/div[3]/form/div[1]/div[2]/div/div/div[2]/div[2]/div/input[2]");
    //AMPLIACION TITULARIDAD
    public SelenideElement labelAmpliacionTitularidad = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div/div[2]/div/ul/li[5]/a/label");
    public SelenideElement inputRequiereAmplitudTitularidad = $x("//*[@id=\"checkRequiereAmpliacionTitularidad\"]");
    public SelenideElement inputManifiestoDesclaracion = $x("//*[@id=\"manifiestoDeDeclaracion\"]");
    public SelenideElement inputRFCAmpliacion = $x("//*[@id=\"idRfcAmpliacion\"]");
    public SelenideElement btnAgregarAmpliacion = $x("//*[@id=\"botonAgregarRFCAmpliacion\"]");
    public SelenideElement btnGuardaSolicitud = $x("//*[@id=\"guardarSolicitud\"]");

    public SelenideElement linkPestaña2input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[3]/a/label");
    public SelenideElement linkPestaña3input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[4]/a/label");
    public SelenideElement linkPestaña4input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[5]/a/label");
    public SelenideElement opcionllenado2 = $x("//*[@id='solicitud.descripcionOtroTipoDePropietarioAeronave']");
    //Certificación con verificación mediante el sistema de calidad de la línea de producción
    public SelenideElement input2 = $x("//*[@id=\"SISTEMA_DE_CALIDAD_DE_LA_LINEA_DE_PRODUCCION\"]");
    public SelenideElement inputNumeroInforme2 = $x("//*[@id='numeroInforme']");
    public SelenideElement inputFechaInforme = $x("//*[@id='campoFechaInforme']");
    public SelenideElement btnAgregarInformeCertificacion = $x("//input[@name='agregarInformeCertificacion']");
    public SelenideElement inputCertificadoCalidad = $x("//*[@id='numeroCertificadoCalidad']");
    public SelenideElement inputFechaNumeroCertificado = $x("//*[@id='fechaNumeroCertificado']");
    public SelenideElement btnNumeroCertificado = $x("//input[@name='agregarNumeroCertificado']");
    public SelenideElement inputCampoOrganismo = $x("//*[@id='campoOrganismo']");
    // selectClasificacionNorma
    // selectNormaAplicable
    // inputTiuad
    // inputSolicitudRegimen

    public SelenideElement linkPestaña1input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[2]/a/label");
    public SelenideElement linkPestaña2input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[3]/a/label");
    public SelenideElement linkPestaña3input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[5]/a/label");

    // Campos que se llenan con input2
    public SelenideElement opcionllenado3 = $x("//*[@id='entidadBodega']");

    ///////////////////////////////////////////////////////////////
    public SelenideElement inputSiguienteButton = $x("//*[@id=\"siguienteButton\"]");















}
