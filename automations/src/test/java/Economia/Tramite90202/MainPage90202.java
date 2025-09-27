package Economia.Tramite90202;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage90202 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkAmpliacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/a");
    public SelenideElement linkAmpliacionProductoIndirecto = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[2]/ul/li[2]/a");
    public SelenideElement inpuFolioPrograma = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement inputLicitacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputSectorProsecConfirmado = $x("//*[@id=\"sectoresProsecConf\"]");
    public SelenideElement inputFraccionArancelaria = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[7]/div[3]/div/div/input");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Firmar
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement justificacionRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[2]/tbody/tr[4]/td/textarea");
    public SelenideElement btnAutorizaDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement inputFechaVisita = $x("//*[@id=\"fechaVisitaSE\"]");
    //Opinion
    public SelenideElement inputAceptada = $x("//*[@id=\"idAceptada\"]");
    public SelenideElement inputDescribirOpinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement inputAgregarDoc = $x("//*[@id=\"tablaDatosGenerales\"]/tbody/tr[1]/td[2]/input");
    public SelenideElement inputDoc = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement inputCargarArchivo = $x("//*[@id=\"cargaArchivo\"]");
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[1]/input");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
}