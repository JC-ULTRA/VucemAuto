package HACIENDA.Tramite6502;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage6502 {
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Tramite  140101
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    //Continuar (Agregar Solicitud)
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    public SelenideElement check1 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table/tbody/tr[2]/td/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnModificar1 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table/tbody/tr[3]/td/div/input");


//    public SelenideElement btnModificar2 = $x("");

}
