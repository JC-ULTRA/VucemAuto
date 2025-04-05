package HACIENDA.TramiteB8;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPageB8 {
    //Tramite Aviso B8 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement B8 = $x("//a[contains(@onclick, 'par')]");
    public SelenideElement tipoAviso = $x("//*[@id='ui-id-2']");

    //Aduana
    public SelenideElement aduana = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement seccionAduanera = $x("//*[@id='solicitud.ideGenerica3']");
    public SelenideElement fechaSalida = $x("//*[@id='fechaInicioVigencia']");

    //Tipo de Transporte
    public SelenideElement tipTransp = $x("//*[@id='solicitud.ideGenerica1']");
    public SelenideElement LAPC = $x("//*[@id='campotexto']");

    //Descripción de la mercancía
    public SelenideElement nombreMerc = $x("//*[@id='nombreMercancia']");
    public SelenideElement marca = $x("//*[@id='calle']");
    public SelenideElement modelo = $x("//*[@id='modelo']");
    public SelenideElement nSerie = $x("//*[@id='serie']");
    public SelenideElement cantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectUMC = $x("//*[@id='solicitud.mercanciaSolicitud.detalleMercancia']");
    public SelenideElement paisOrig = $x("//*[@id='solicitud.descripcionClobGenerica1']");
    public SelenideElement obs = $x("//*[@id='idDescMerc']");

    //Manifiesto
    public SelenideElement checkAcepto = $x("//*[@id='acepto1094']");
    public SelenideElement btnCont1 = $x("//*[@id='guardarSolicitud']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //INICIO
    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='valueTA']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@name='mostrarFirma']");



    //Solo Firma Funcionario
    public SelenideElement cerfF = $x("//*[@id='certificate']");
    public SelenideElement keyfF = $x("//*[@id='privateKey']");
    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");

    //Autorización
    //INICIO
    public SelenideElement InicioA = $x("//img[@alt='       Inicio']");
    public SelenideElement FolioA = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionarioA = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdAutorizarDictamen = $x("//td[@title='Autorizar Dictamen']");
    //Autorizar
    public SelenideElement inputMostrarFirma2 = $x("//input[@value='Autorizar']");

    //Confirmar Notificación Resolución
    public SelenideElement selecRol2 = $x("//*[@id='claveRol']");
    public SelenideElement btnacep2 = $x("//button[@name='ingresar']");
    //Inicio
    public SelenideElement linkInicio = $x("//*[@id='Inicio']");
    //Ingresar Folio
    public SelenideElement inputNumFolio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasSolicitanteB = $x("//*[@id='buscarTareasSolicitante']");
    //Pasar a la firma
    public SelenideElement tdConfirmarNotificaciResoluci = $x("//td[@aria-describedby='gridTareasSolicitante_actionName']");
    public SelenideElement inputAcuse = $x("//*[@id='acuse']");

    public SelenideElement notification = $x("//*[@id='notification']/div/ul/li");


}
