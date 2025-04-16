package Economia.Tramite110201;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110201 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement Tramite110201 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[1]/a");

    public SelenideElement SolicitudTratdoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement PaisSeleccionado = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement inputMostrarMErcancias = $x("//*[@id=\"idBotonBuscarMercancias\"]");


}
