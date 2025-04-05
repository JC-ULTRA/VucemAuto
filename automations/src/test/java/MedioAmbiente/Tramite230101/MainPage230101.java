package MedioAmbiente.Tramite230101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage230101 {
    //Tramite Aviso 230101
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement MedioAmbiente = $x("//img[contains(@alt, 'Medio')]");
    public SelenideElement CertLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement RequisitosFito = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement CertFitoImport = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-gubernamentales-HA/invocarModulo.action?init','/ventanilla-gubernamentales-HA//gubernamentales2/semarnat/certificadoFitosanitarioImportacion/solCFI.action?solicitud.discriminatorValue=230101&iniciar','230101','','')\"]");

    public SelenideElement DatosSolicitud = $x("//label[@for='solicitud.titulo']");
    public SelenideElement TipoRegimen = $x("//input[@checked='checked']");
    public SelenideElement optionAcapulcoAeropuerto = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/div[1]/div[2]/select/option[1]");
    public SelenideElement AddlistaOrigen1 = $x("//*[@id='addlistaOrigen1']");
    public SelenideElement optionAeropuertoIntMexico = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/div[1]/div[2]/select/option[2]");
    public SelenideElement AddlistaOrigen2 = $x("//*[@id='addlistaOrigen1']");
    public SelenideElement selectTipoProducto = $x("//*[@id='solicitud.ideGenerica2']");
    public SelenideElement optionAlbaniaRepublica = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[7]/div[2]/div/div[1]/div[2]/select/option[2]");
    public SelenideElement AddlistaOrigen = $x("//*[@id='addlistaOrigen2']");
    public SelenideElement selectPaisProcedencia = $x("//*[@id='solicitud.paisProcedenciaSemarnat.clave']");

    //Destino dentro del pais
    public SelenideElement optionVeracruz = $x("//option[@value='VER']");
    public SelenideElement inputAddlistaOrigen = $x("//*[@id='addlistaOrigen3']");
    public SelenideElement TodoTerritorio = $x("//*[@id='isTodoTerritorio']");
    public SelenideElement optionFraccionesNicas = $x("//option[@value='0']");
    public SelenideElement AgregarMercancias = $x("//input[@name='agregarAduana']");
    public SelenideElement FraccionArancelaria = $x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGenero = $x("//*[@id='mercanciaGrid.genero']");
    public SelenideElement selectMercanciaEspecie = $x("//*[@id='mercanciaGrid.especie']");
    public SelenideElement NombreComun = $x("//*[@id='mercanciaGrid.nombreComun.clave']");
    public SelenideElement AgregarDetalleMercancias = $x("//input[@name='agregarDetalle']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement selectDescripcionProducto = $x("//*[@id='solicitud.descripcionProducto.idDescripcionProducto']");
    public SelenideElement optionKilogramo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div/div/div[17]/div[3]/div/select/option[2]");
    public SelenideElement inputDeclaracion = $x("//*[@id='declaracion[0]']");

    //Pestaña Pago de Derecho
    public SelenideElement PagoDerechos = $x("//label[@for='captura.tab.pagoDerechos']");
    public SelenideElement BancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");

    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    
    
    
    

    










    
}
