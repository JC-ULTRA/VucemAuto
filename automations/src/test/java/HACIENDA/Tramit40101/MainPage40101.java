package HACIENDA.Tramit40101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage40101 {

    //Tramite Aviso 40101
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");

    public SelenideElement RegistroDelDigoAlfanum = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement RegistroDelDigoAlfanum2 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/a");
    public SelenideElement Tramite40101 = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-aga-HA/invocarModulo.action?init','/ventanilla-aga-HA//aga/registroCaatTerrestreController.action?iniciar','40101','','')\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña
    public SelenideElement PestañaDirectorGeneral = $x("//label[@for='Director general']");
    public SelenideElement NombreDirectorGeneral = $x("//*[@id='nombreDirectorGeneral']");
    public SelenideElement ApellidoPaternoDirectorGeneral = $x("//*[@id='apellidoPaternoDirectorGeneral']");
    public SelenideElement ApellidoMaternoDirectorGeneral = $x("//*[@id='apellidoMaternoDirectorGeneral']");

    //Pestaña choferes
    public SelenideElement PestañaChoferes = $x("//label[@for='choferes']");
    //Agregar chofer nacional
    public SelenideElement inputAgregar = $x("//input[@name='AgregarCHN']");
    public SelenideElement Curp = $x("//*[@id='curpCHN']");
    public SelenideElement RFCPersona = $x("//*[@id='rfcCHN']");
    public SelenideElement BuscarChofer = $x("//*[@id='buscarChofer']");
    public SelenideElement Calle = $x("//*[@id='calleCHN']");
    public SelenideElement NumeroExterior = $x("//*[@id='numeroExteriorCHN']");
    public SelenideElement NumeroInterior = $x("//*[@id='numeroInteriorCHN']");
    public SelenideElement selectEstado = $x("//*[@id='entidadFederativaCHN']");
    public SelenideElement selectMunicipio = $x("//*[@id='delegacionCHN']");
    public SelenideElement selectColonia = $x("//*[@id='coloniaCHN']");
    public SelenideElement selectPaisOrigen = $x("//*[@id='paisOrigenCHN']");
    public SelenideElement Ciudad = $x("//*[@id='ciudadCHN']");
    public SelenideElement Localidad = $x("//*[@id='localidadCHN']");
    public SelenideElement CodigoPostal = $x("//*[@id='codigoPostalCHN']");
    public SelenideElement Correo = $x("//*[@id='correoCHN']");
    public SelenideElement Telefono = $x("//*[@id='telefonoCHN']");
    public SelenideElement inputGuardarChofer = $x("//input[contains(@onclick, \"agregarChoferNacional('dialogoCHN');\")]");

    //Chofer extranjero

    public SelenideElement ChofExtranjero = $x("//label[@for='caat.chofer.extranjero']");

    public SelenideElement ScrolBajo = $x("//label[@for='Choferes extranjeros']");

    public SelenideElement AgregarExtranjero = $x("//input[@name='AgregarCHE']");
    public SelenideElement NombreChe = $x("//*[@id='nombreCHE']");
    public SelenideElement ApellidoPaternoChe = $x("//*[@id='apellidoPaternoCHE']");
    public SelenideElement ApellidoMaternoChe = $x("//*[@id='apellidoMaternoCHE']");
    public SelenideElement selectNacionalidadChe = $x("//*[@id='nacionalidadCHE']");
    public SelenideElement NSS = $x("//*[@id='nssCHE']");
    public SelenideElement IdefiscalChe = $x("//*[@id='idefiscalCHE']");
    public SelenideElement BuscarChoferExt = $x("//*[@id='buscarChoferEx']");
    public SelenideElement btnAceptar = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement selectPaisChe = $x("//*[@id='paisCHE']");
    public SelenideElement CodigoPostalChe = $x("//*[@id='codigoPostalCHE']");
    public SelenideElement Estado = $x("//*[@id='entidadFederativaCHE']");
    public SelenideElement CalleChe = $x("//*[@id='calleCHE']");
    public SelenideElement NumeroExteriorChe = $x("//*[@id='numeroExteriorCHE']");
    public SelenideElement NumeroInteriorChe = $x("//*[@id='numeroInteriorCHE']");
    public SelenideElement selectPaisOrigenChe = $x("//*[@id='paisOrigenCHE']");
    public SelenideElement CiudadChe = $x("//*[@id='ciudadCHE']");
    public SelenideElement CorreoChe = $x("//*[@id='correoCHE']");
    public SelenideElement TelefonoChe = $x("//*[@id='telefonoCHE']");
    public SelenideElement GuardarChofer2 = $x("//input[contains(@onclick, \"agregarChoferExtranjero('dialogoCHE');\")]");

    //Vehiculo
    public SelenideElement Vehiculos = $x("//label[@for='vehiculos']");
    public SelenideElement AgregarVEH = $x("//input[@name='AgregarVEH']");
    public SelenideElement VinVeh = $x("//*[@id='vinVEH']");
    public SelenideElement selectSolicitudVehiculoTipo = $x("//*[@id='solicitudVehiculoTipoVehiculo']");
    public SelenideElement PlacasVeh = $x("//*[@id='placasVEH']");
    public SelenideElement selectSolicitudVehiculoPaisEmisor = $x("//*[@id='solicitudVehiculoPaisEmisor']");
    public SelenideElement EstadoProvincia = $x("//*[@id='estadoVEH']");
    public SelenideElement MarcaVeh = $x("//*[@id='marcaVEH']");
    public SelenideElement ModeloVeh = $x("//*[@id='modeloVEH']");
    public SelenideElement selectAnioVehiculoVeh = $x("//*[@id='anioVehiculoVEH']");
    public SelenideElement TransponderVeh = $x("//*[@id='transponderVEH']");
    public SelenideElement selectSolicitudVehiculoColor = $x("//*[@id='solicitudVehiculoColor']");
    public SelenideElement NumeroEconomicoVeh = $x("//*[@id='numeroEconomicoVEH']");
    public SelenideElement NumeroplacaVeh = $x("//*[@id='numeroplaca2VEH']");
    public SelenideElement EmisorplacaVeh = $x("//*[@id='emisorplaca2VEH']");
    public SelenideElement selectSolicitudVehiculoPaisEmisor2 = $x("//*[@id='solicitudVehiculoPaisEmisor2daPlaca']");
    public SelenideElement inputGuardarVehiculo = $x("//input[contains(@onclick, \"agregarVehiculo('dialogoVEH');\")]");
    public SelenideElement inputGuardarSolicitudPaso2 = $x("//*[@id='guardarSolicitud']");

    








}
