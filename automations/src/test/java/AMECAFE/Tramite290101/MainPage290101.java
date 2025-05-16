package AMECAFE.Tramite290101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage290101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement AMECAFE = $x("//img[contains(@alt, 'Café')]");
    public SelenideElement CerificadosLicenciaPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement RegistroNacionalExportadoresCafe = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement Tramite290101 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/ul/li/a");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputProductorCafe = $x("//*[@id=\"booleanGenericoSi\"]");//*[@id="booleanGenericoNo"]
    public SelenideElement inputClavePatron = $x("//*[@id=\"solicitud.numeroRegistro\"]");
    public SelenideElement btnAgregarRegion = $x("//*[@id=\"btn-agregar-region\"]");
    public SelenideElement inputEstado = $x("//*[@id=\"cveEntidadClave\"]");
    public SelenideElement inputCafeCompra = $x("//*[@id=\"cvcProductoCafe\"]");
    public SelenideElement inputRegion = $x("//*[@id=\"descRegionCompra\"]");
    public SelenideElement inputTipoCafe = $x("//*[@id=\"cveCatalogoClave\"]");
    public SelenideElement inputVolumnen = $x("//*[@id=\"volumen\"]");
    public SelenideElement btnGuardar = $x("//*[@id=\"cancelarBtn\"]");
    public SelenideElement btnAgregarBeneficios = $x("//*[@id=\"btn-agregar-beneficio\"]");
    public SelenideElement inputNombreBeneficio = $x("//*[@id=\"razonSocial\"]");
    public SelenideElement inputPropiaAlquilada = $x("//*[@id=\"booleanAlquilados\"]");
    public SelenideElement inputCalle = $x("//*[@id=\"calle\"]");
    public SelenideElement inputNumExterior = $x("//*[@id=\"numeroExterior\"]");
    public SelenideElement inputNumInterior = $x("//*[@id=\"numeroInterior\"]");
    public SelenideElement inputColonia = $x("//*[@id=\"descripcionColonia\"]");
    public SelenideElement inputEntidadEstado = $x("//*[@id=\"entidadClaves\"]");
    public SelenideElement inputCodigoPostal = $x("//*[@id=\"codigoPostal\"]");
    public SelenideElement inputCapacidadAlmacenaje = $x("//*[@id=\"capacidadAlmacenaje\"]");
    public SelenideElement inputVolumenAlmacenaje = $x("//*[@id=\"volumenAlmacenaje\"]");
    public SelenideElement btnGuardarB = $x("//*[@id=\"cancelarBtnB\"]");
    public SelenideElement btnAgregarBodega = $x("//*[@id=\"btn-agregar-bodega\"]");
    public SelenideElement inputPropiaAlguiladaB = $x("//*[@id=\"booleanAlquilado\"]");
    public SelenideElement inputEntidadEstadoBodegas = $x("//*[@id=\"entidadClave\"]");
    public SelenideElement btnGuardarBodega = $x("//*[@id=\"cancelarBtnBd\"]");
    public SelenideElement btnAgregarCafeExp = $x("//*[@id=\"btn-agregar-cafexport\"]");
    public SelenideElement inputMarcaComercial = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement inputClasificacionTipo = $x("//*[@id=\"catalogoDClave\"]");
    public SelenideElement inputVolumen = $x("//*[@id=\"porcentajeConcentracion\"]");
    public SelenideElement btnGuardarCafe = $x("//*[@id=\"cancelarBtnEx\"]");
    public SelenideElement Observaciones = $x("//*[@id=\"valueTA\"]");
    public SelenideElement checkAutorizacion = $x("//*[@id=\"solicitud.requiereInspeccionInmediata\"]");
    public SelenideElement checkDeclaracionVerdad = $x("//*[@id=\"tabs-2\"]/div[25]/div/div/input");


    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}
