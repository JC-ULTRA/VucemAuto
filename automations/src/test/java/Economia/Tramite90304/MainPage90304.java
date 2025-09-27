package Economia.Tramite90304;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage90304 {
    //TRÁMITE
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkModificacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[3]/a");
    public SelenideElement linkModificacionBajaProductorI = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[3]/ul/li[3]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //FIRMAR
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnSiguienteBoton = $x("//*[@id=\"siguienteButton\"]");
}