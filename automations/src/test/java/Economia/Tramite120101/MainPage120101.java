package Economia.Tramite120101;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120101 {
    //Tramite Aviso 120101
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[2]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/a");
    public SelenideElement Tramite120101 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/ul/li[1]/a");

    ///Consultar Cupo
    public SelenideElement ConsultCupoPest = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement ClasifRegimen = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[2]/div[2]/div/div/select");
    public SelenideElement PaisDestOrg = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[3]/div[1]/div/div/select");
    public SelenideElement FreaccionArancel = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[3]/div[2]/div/div/input");
    public SelenideElement btnBuscarTPL = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[5]/div[2]/div/input");
    public SelenideElement CargaRegistro = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement Estado = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[2]/div[1]/div/div/select");
    public SelenideElement RepreFede = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/select");
    public SelenideElement Descrip = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[2]/div/div/div/input");
    public SelenideElement btnContinuarCupo = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[3]/div/div[2]/input");

}
