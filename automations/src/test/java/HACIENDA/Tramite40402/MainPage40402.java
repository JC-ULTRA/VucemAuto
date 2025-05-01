package HACIENDA.Tramite40402;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage40402 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[1]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registroCAAT =  $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement CAATAereo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/a");
    public SelenideElement tramite40402 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/ul/li[2]/a");
    /// Datos del Tramite
    public SelenideElement datosTramite = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]");
    public SelenideElement tipoCAATAereo = $x("//*[@id=\"solicitud.solicitante.ideGenerica1\"]");
    public SelenideElement codigoTransportacionAerea = $x("//*[@id=\"solicitud.ideCodTransportacionAerea\"]");
    public SelenideElement numCodigo = $x("//*[@id=\"solicitud.codIataIcao\"]");
    /// Asignar Persona
    public SelenideElement asignarPersona = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]");
    public SelenideElement personaFisica = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[3]/div/ul/li[1]");
    public SelenideElement agregarPersonaFisica = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[3]/div/div/div[1]/div[3]/div/input[3]");
    public SelenideElement nombrePersonaFisica = $x("//*[@id=\"personaFisica.nombre\"]");
    public SelenideElement apellidoPaternoPersonaFisica = $x("//*[@id=\"personaFisica.apellidoPaterno\"]");
    public SelenideElement apellidoMaternoPersonaFisica = $x("//*[@id=\"personaFisica.apellidoMaterno\"]");
    public SelenideElement numeroSeguroSocialPersonaFisica =$x("//*[@id=\"personaFisica.NSS\"]");
    public SelenideElement correoElectronicoPersonaFisica = $x("//*[@id=\"personaFisica.correoElectronico\"]");
    public SelenideElement paisPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.pais\"]");
    public SelenideElement codigoPostalPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.codigoPostal\"]");
    public SelenideElement estadoPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.entidadFederativa\"]");
    public SelenideElement ciudadPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.ciudad\"]");
    public SelenideElement callePersonaFisica = $x("//*[@id=\"personaFisica.domicilio.calle\"]");
    public SelenideElement numeroExteriorPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.numeroExterior\"]");
    public SelenideElement numeroInteriorPersonaFisica = $x("//*[@id=\"personaFisica.domicilio.numeroInterior\"]");
    public SelenideElement guardarPersonaFisica = $x("//*[@id=\"btnAceptarPersonaF\"]");
    public SelenideElement btnAceptarPersonaFisica = $x("/html/body/div[9]/div[3]/div/button");
    public SelenideElement btnAceptarResponsabilidad = $x("/html/body/div[10]/div[3]/div/button[1]");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
