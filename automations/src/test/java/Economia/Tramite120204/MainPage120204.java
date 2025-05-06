package Economia.Tramite120204;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120204 {
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
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CuposImpoExpo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement linkExpCertifiCupo = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/a");
    public SelenideElement linkExpCerCupLicPub = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[2]/ul/li[3]/a");
    public SelenideElement labelExpedicionCertificados = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputLicitacion = $x("//table[@id='gridLicitacion']//tr[not(contains(@class, 'jqgfirstrow'))][1]");

}
