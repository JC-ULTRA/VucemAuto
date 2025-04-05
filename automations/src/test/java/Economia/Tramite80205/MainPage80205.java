package Economia.Tramite80205;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80205 {
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement IMMEX = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement Ampli = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/a");
    public SelenideElement Tramite80205 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/ul/li[3]/a");
    public SelenideElement CargaIMMEX = $x("/html/body/main/div/div[4]/div/form/div[1]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[6]/td[4]");
    public SelenideElement Servicios = $x("//*[@id=\"ui-id-2\"]"); ///html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a
    public SelenideElement ServicioIMMEX = $x("//*[@id=\"serviciosImmexServ\"]");
    public SelenideElement btnAgregar = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div/div/input[2]");
    public SelenideElement CheckAutorizado = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[5]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement RFC = $x("//*[@id=\"rfcEmpresa\"]");
    public SelenideElement NIMMEX = $x("//*[@id=\"numeroPrograma\"]");
    public SelenideElement AnioImmex = $x("//*[@id=\"tiempoPrograma\"]");
    public SelenideElement btnAgregarEmpServ = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[10]/div/div/input[2]");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
}
