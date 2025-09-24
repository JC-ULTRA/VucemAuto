package Economia.Tramite120202;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage120202 {
    ///Tramite Aviso 120202
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CuposImportExport = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement ExpediCertificCupo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/a");
    public SelenideElement Tramite120202 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/ul/li[1]/a");

    ///Expedición Certificado Cupo Persona Moral
    public SelenideElement PestAsigDirecta = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement AnioOficioAsig = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[1]/div/div/select");
    public SelenideElement NumOficioAsig = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[2]/div/input");
    public SelenideElement btnBuscarOficioAsig = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div/div/input");
    public SelenideElement Monto = $x("//*[@id=\"montoExpedir\"]");
    public SelenideElement btnAgregarMonto = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[22]/div/div/input");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement otrasTareas = $x("//*[@id=\" Otras tareas\"]");
    public SelenideElement CUPOS = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[4]/a");
    public SelenideElement generarCertificado = $x("/html/body/div[1]/div[3]/div[2]/div/div/ul/li/ul/li[4]/ul/li[4]/a");
    public SelenideElement consultaFolio = $x("//*[@id=\"radioTodos\"]");
    public SelenideElement numFolioCert = $x("//*[@id=\"numeroFolioTramite\"]");
    public SelenideElement btnBuscarFolioConsilta = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr[11]/td/input");
    public SelenideElement folioTabla = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr[13]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement btnGenerar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/table/tbody/tr[2]/td[8]/input");
    public SelenideElement btnEntregado = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/table/tbody/tr[2]/td[8]/input");
    public SelenideElement celdaCertificado = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/table/tbody/tr[2]/td[5]");

    public SelenideElement btnContinuarFirma = $x("/html/body/main/div/div[4]/div/form/div[3]/div/div/div[2]/input[1]");
}
