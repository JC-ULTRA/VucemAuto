package Economia.Tramite80301;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage80301 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ModificacionPrograma = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/a");
    public SelenideElement ModifBajaDomiPBA = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/ul/li[1]/a");
    public SelenideElement inputBaja = $x("//*[@id=\"btnBajaFraEx3\"]");
    public SelenideElement btnAdjuntar = $x("/html/body/div[7]/div[3]/div/button[1]/span");
    public SelenideElement btnCerrar = $x("/html/body/div[7]/div[3]/div/button[2]/span");
}