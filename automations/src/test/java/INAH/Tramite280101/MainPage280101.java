package INAH.Tramite280101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage280101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement INAH = $x("//*[@id=\"workingArea\"]/form/a[7]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkPermisoExportaciTemporalDefinitiva = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li/a");
    public SelenideElement linkInahPermisoExportaciTemporal = $x("//a[contains(@onclick, 'enu')]");
    //SOLICITUD
    public SelenideElement labelSolicitud = $x("//label[@for='captura.tab.solicitud']");
    //MODALIDAD
    public SelenideElement inputTipoRegimen = $x("//input[@value='01']");
    public SelenideElement inputTipoRegimen2 = $x("//input[@value='02']");
    //EXPOSICION
    public SelenideElement inputRadioExposicion = $x("//input[@value='si']");
    public SelenideElement inputRadioExposicion2 = $x("//input[@value='no']");
    //Lugar de salida
    public SelenideElement selectSolicitudAduanasSalidaClave = $x("//*[@id='solicitud.aduanasSalida[0].clave']");
    //observaciones
    public SelenideElement textareaSolicitudDescripcionClobGenerica = $x("//textarea[@cols='100']");
    //cantidad monumentos
    public SelenideElement inputCantAutoriBienesCult = $x("//*[@id='cantAutoriBienesCult']");
    //MONUMENTOS O BIENES HISTORICOS
    public SelenideElement labelMonumentosBienesMueblesHist = $x("//label[@for='captura.tab.mercancias.inah']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btn-agregar-mercancia']");
    //Datos generales monumentos
    public SelenideElement inputDescripcionMercancia = $x("//input[@name='descripcionMercancia']");
    public SelenideElement selectGenerica = $x("//*[@id='generica2']");
    public SelenideElement inputDescripcionIdentificacion = $x("//input[@name='descripcionIdentificacion']");
    public SelenideElement selectGenerica2 = $x("//*[@id='generica1']");
    //Dimensiones
    public SelenideElement inputCantidadPresentacion = $x("//input[@name='cantidadPresentacion']");
    public SelenideElement inputComponente = $x("//input[@name='componente']");
    public SelenideElement inputImporteTotalComponente = $x("//input[@name='importeTotalComponente']");
    //fraccion arancelaria
    public SelenideElement selectFraccionTipoTramiteGubernamental = $x("//*[@id='fraccionTipoTramite.idFraccionGubernamental']");
    //conservacion del monumento
    public SelenideElement textareaDescripcionUsoMercancia = $x("//textarea[@class='form-control']");
    public SelenideElement inputAgregarParte = $x("//*[@id='btn-agregar-parte']");
    public SelenideElement selectElementoAnadido = $x("//*[@id='idElementoAnadido']");
    public SelenideElement textareaDescripcionPresentacion = $x("//textarea[@rows='2']");
    public SelenideElement inputAlto = $x("//input[@name='alto']");
    public SelenideElement inputAncho = $x("//input[@name='ancho']");
    public SelenideElement inputProfundidad = $x("//input[@name='profundidad']");
    public SelenideElement inputGuardarParte = $x("//input[contains(@onclick, 'gruardarParte();')]");
    public SelenideElement inputGuardarParte2 = $x("//input[contains(@onclick, 'gruardar();')]");
    //DESTINO
    public SelenideElement labelDestino = $x("//label[@for='captura.tab.destino']");
    public SelenideElement selectSolicitudDomicilioPaisClave = $x("//*[@id='solicitud.domicilio.pais.clave']");
    public SelenideElement inputCodigoPostal = $x("//*[@id='codigoPostal']");
    public SelenideElement inputInformacionExtra = $x("//*[@id='informacionExtra']");
    public SelenideElement inputDescripcionMunicipio = $x("//*[@id='descripcionMunicipio']");
    public SelenideElement inputDescUbicacion = $x("//*[@id='descUbicacion']");
    public SelenideElement inputColonia = $x("//*[@id='colonia']");
    public SelenideElement inputNumeroExterior = $x("//*[@id='numeroExterior']");
    public SelenideElement inputNumeroInterior = $x("//*[@id='numeroInterior']");
    public SelenideElement inputCalle = $x("//*[@id='calle']");
    //FIRMA
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}