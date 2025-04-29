package MedioAmbiente.Tramite230901;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage230901 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement MedioAmbiente = $x("/html/body/main/div/div[3]/div/form/a[4]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkSEMARNAT08009 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[5]/a");
    public SelenideElement linkAutImpExpReeEjeParDerVidSal = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[5]/ul/li[1]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement selectTipoMovimiento = $(By.xpath("//*[@id='solicitud.claveClasificacionRegimen']"));
    public SelenideElement inputTipoRegimen = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement selectListaOrigen = $x("//*[@id=\"origenlistaOrigen1\"]");
    public SelenideElement selectListaOrigen2 = $x("//*[@id=\"origenlistaOrigen2\"]");
    public SelenideElement inputAgregarLista = $x("//*[@id=\"addlistaOrigen1\"]");
    public SelenideElement inputAgregarLista2 = $x("//*[@id=\"addlistaOrigen2\"]");
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btnAgregarMercancias\"]");
    public SelenideElement selectFraccionAran = $x("//*[@id=\"fraccionCombo\"]");
    public SelenideElement textDescripcion = $x("//*[@id=\"idDenominacionComunInternacional\"]");
    public SelenideElement textRendimiento = $x("//*[@id=\"rendimientoProductoSemarnat\"]");
    public SelenideElement selectClasificacionTaxo = $x("//*[@id=\"mercanciaGrid.claveClasificacionTaxonomica\"]");
    public SelenideElement selectNombreCientifico = $x("//*[@id=\"mercanciaGrid.idNombreCientifico\"]");
    public SelenideElement selectNombreComun = $x("//*[@id=\"mercanciaGrid.idNombreComun\"]");
    public SelenideElement inputMarca = $x("//*[@id=\"marcaMarcaje\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement selectUDM = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement selectPaisOrigen = $x("//*[@id=\"mercanciaGrid.clavesPaisesOrigen\"]");
    public SelenideElement selectPaisProcedencia = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement inputAgregarMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement selectMovimientoDisponible = $x("//*[@id=\"origenlistaOrigen3\"]");
    public SelenideElement btnAgregarSeleccion = $x("//*[@id=\"addlistaOrigen3\"]");
    public SelenideElement selectDestinoOrigen = $x("//*[@id=\"destinolistaOrigen3\"]");
    //TERCEROS
    public SelenideElement labelTerceros = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement inputEntidadFederativa = $x("//*[@id=\"destinatarioTerceros\"]");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement selectBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inputLlavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement inputFechaPago = $x ("//*[@id=\"calendarTo\"]");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    //FIRMA
    public SelenideElement inputContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement inputDocumento = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputDocumento2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputDocumento3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputDocumento4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement inputCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement btnContinuar = $x("//*[@id=\"siguienteButton\"]");

    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
