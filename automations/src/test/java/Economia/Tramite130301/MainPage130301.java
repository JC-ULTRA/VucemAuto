package Economia.Tramite130301;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage130301 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");

    public SelenideElement btnIngresFs = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = Selenide.$x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Permisos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement Prorroga = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[3]/a");
    public SelenideElement Tramite130301 = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[3]/ul/li/a");
    public SelenideElement folioPermiso = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div/input");
    public SelenideElement btnBuscarFolio = $x("/html/body/main/div/div[4]/div/form/div[3]/div[2]/div/input[2]");
    /// Prorroga
    public SelenideElement prorrogas = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]");
    public SelenideElement motivoModificacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[5]/div/div/textarea");
    public SelenideElement otrasDeclaraciones = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[6]/div/div/textarea");

    public SelenideElement inputGuardarSolicitud = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement inputContinuar = Selenide.$x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = Selenide.$x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement inputDocumentosFile = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputAnexar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = Selenide.$x("//*[@id='siguienteButton']");
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
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    public SelenideElement AntecendentesTextoDictamen = $x("//*[@id='textoDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");

}
