package Economia.Tramite140205;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140205 {
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement rfcEmpresa = $x("//*[@id=\"rfcEmpresa\"]");
    public SelenideElement cancelacionTab = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement regimenAduanero = $x("//*[@id=\"cupoBusqueda.claveRegimen\"]");
    public SelenideElement mecanismoAsignacion = $x("//*[@id=\"cupoBusqueda.mecanismoAsignacion\"]");
    public SelenideElement cupoTabla = $x("//*[@id=\"3\"]");
    public SelenideElement motivoCancelacion = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[5]/tbody/tr[2]/td/textarea");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");

}
