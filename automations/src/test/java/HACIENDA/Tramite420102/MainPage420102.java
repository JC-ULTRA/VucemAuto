package HACIENDA.Tramite420102;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage420102 {
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    public SelenideElement inputRFC = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscarRelacion\"]");
    public SelenideElement radioContibuyente = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnAceptar = $x("/html/body/div[8]/div[3]/div/button[1]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}