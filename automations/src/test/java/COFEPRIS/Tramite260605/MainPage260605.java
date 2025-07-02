package COFEPRIS.Tramite260605;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260605 {
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("//img[contains(@alt, 'para')]");
    public SelenideElement CertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement labelAvisoSanitario = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/a");
    public SelenideElement labelAvisoModificacionAduana = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/ul/li[5]/a");
    //DATOS SOLICITUD
    public SelenideElement DatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputNumeroPermiso = $x("//*[@id=\"numeroPlafest\"]");
    public SelenideElement btmCargarAduanas = $x("//*[@id=\"btnCargarAduanas\"]");
    //Aduanas
    public SelenideElement inputAduanasDisponibles = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/select");
    public SelenideElement btnAgregarSeleccion = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement inputAduanaSeleccionadas = $x("//*[@id=\"aduanasMod\"]");
    public SelenideElement btnRestarSeleccion = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/input[3]");
    public SelenideElement inputJustificacion = $x("//*[@id=\"modAduana\"]");
    public SelenideElement inputRFCLegal = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRFC = $x("//*[@id=\"consultarIDC\"]");
    //FIRMA
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[3]");
}