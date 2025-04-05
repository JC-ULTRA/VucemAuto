package HACIENDA.Tramite11201;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage11201 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = Selenide.$x("//img[contains(@alt, 'General')]");
    public SelenideElement autorizacionImpExp = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement constanciaImp = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li/a");
    public SelenideElement impTemporalCont = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li/ul/li[1]/a");
    public SelenideElement contenedor = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement selecContenedor = Selenide.$x("//*[@id='idRadioContenedor']");
    public SelenideElement aduana = Selenide.$x("//*[@id='aduana']");
    public SelenideElement fechaAduana = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[2]/div[4]/div[3]/div/div/input");
    public SelenideElement selecFecha = Selenide.$x("/html/body/div[6]/table/tbody/tr[3]/td[4]/a");
    public SelenideElement inicialesEquipo = Selenide.$x("//*[@id='inicialesContenedor']");
    public SelenideElement numEquipo = Selenide.$x("//*[@id='numeroContenedor']");
    public SelenideElement digitoVerif = Selenide.$x("//*[@id='digitoDeControl']");
    public SelenideElement tipoEquipo = Selenide.$x("//*[@id='contenedores']");
    public SelenideElement btnAgregar = Selenide.$x("//*[@id='buscar']");
    public SelenideElement btnAceptar = Selenide.$x("/html/body/div[8]/div[3]/div/button");
    public SelenideElement continuar = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement lineaCaptura = Selenide.$x("//*[@id='lineaCaptura']");
    public SelenideElement monto = Selenide.$x("//*[@id='monto']");
    public SelenideElement agregarPago = Selenide.$x("//*[@id='agregar']");
    public SelenideElement continuarPago = Selenide.$x("//*[@id='guardarSolicitud']");
}
