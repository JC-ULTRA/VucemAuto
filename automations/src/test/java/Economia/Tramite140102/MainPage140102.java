package Economia.Tramite140102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140102 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Tramite  140101
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    //Continuar (Agregar Solicitud)
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement Obs = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div/textarea");
    public SelenideElement btnContinuaFirma = $x("/html/body/main/div/div[4]/div/form/div[3]/div/div/div[2]/input[1]");


}
