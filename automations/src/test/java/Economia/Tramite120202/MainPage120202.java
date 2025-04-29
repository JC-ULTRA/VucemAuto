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


    public SelenideElement btnContinuarFirma = $x("/html/body/main/div/div[4]/div/form/div[3]/div/div/div[2]/input[1]");
}
