package AMECAFE.Tramite290201;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage290201 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    
    public SelenideElement AMECAFE = $x("//img[contains(@alt, 'Café')]");
    public SelenideElement CerificadosLicenciaPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a/span");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a/span");
    public SelenideElement Tramite290201 = $x("//a[contains(@onclick, 'certificado')]");

    public SelenideElement labelDatosSolicitud = $x("//label[@for='solicitud.titulo']");
    public SelenideElement FormaCafe = $x("//*[@id='solicitud.formasCafe']");
    public SelenideElement Tipos = $x("//*[@id='tipoCafeClasificacion']");
    public SelenideElement Calidad = $x("//*[@id='calidadCafeClasificacion']");
    public SelenideElement Procesos = $x("//*[@id='procesoCafeClasificacion']");
    public SelenideElement Certificaciones = $x("//*[@id='certificacionCafeClasificacion']");

    public SelenideElement selectSolicitudClaveAduana = $x("//*[@id='solicitud.claveAduana']");

    public SelenideElement selectSolicitudPaisProcedenciaClave = $x("//*[@id='solicitud.paisProcedencia.clave']");

    public SelenideElement selectSolicitudEntidadesEntidadClave = $x("//*[@id='solicitud.entidadesSolicitud[0].entidad.clave']");

    public SelenideElement selectSolicitudDescripcionGenerica = $x("//*[@id='solicitud.descripcionGenerica1']");

    public SelenideElement inputAgregarLote = $x("//input[contains(@onclick, 'resetear()')]");

    public SelenideElement selectGenerica = $x("//*[@id='generica1']");

    public SelenideElement selectAceptada = $x("//*[@id='aceptada']");

    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");

    public SelenideElement selectUnidadMedidaComercialClave = $x("//*[@id='unidadMedidaComercial.clave']");

    public SelenideElement inputMercanciasImporteTotalComponente = $x("//*[@id='mercancias.importeTotalComponente']");

    public SelenideElement selectMonedaClave = $x("//*[@id='moneda.clave']");

    public SelenideElement inputNumeroLote = $x("//*[@id='numeroLote']");

    public SelenideElement inputDescripcionMercancia = $x("//*[@id='descripcionMercancia']");

    public SelenideElement selectBooleanGenerico = $x("//*[@id='booleanGenerico1']");

    public SelenideElement inputFechaSalida = $x("//*[@id='fechaSalida']");

    public SelenideElement selectCondicionAlmacenamientoSecundario = $x("//*[@id='condicionAlmacenamientoSecundario']");

    public SelenideElement selectGenerica2 = $x("//*[@id='generica2']");

    public SelenideElement inputMarcasEmbarque = $x("//*[@id='marcasEmbarque']");

    public SelenideElement textareaDescripcionTratamiento = $x("//*[@id='descripcionTratamiento']");

    public SelenideElement inputAgregarLote2 = $x("//input[@onclick='guardarLotes()']");

    //Pestaña Terceros Relacionados




}
