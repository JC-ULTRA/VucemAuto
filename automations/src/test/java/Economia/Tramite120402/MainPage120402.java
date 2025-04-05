package Economia.Tramite120402;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage120402 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = Selenide.$x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement cuposImpExp = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement asignacionDirecta = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/a");
    public SelenideElement asignacionPersonaM = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[4]/ul/li[1]/a");
    public SelenideElement asignacion = Selenide.$x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement entidadFed = Selenide.$x("//*[@id='solicitud.entidadFederativa.entidad.clave']");
    public SelenideElement representacionFed = Selenide.$x("//*[@id='representacionFederalSelect']");
    public SelenideElement regimenAduanero = Selenide.$x("//*[@id='claveRegimen']");
    public SelenideElement btnBuscar = Selenide.$x("//*[@id='buscarCupos']");
    public SelenideElement selecCupo = Selenide.$x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div[2]/div[7]/div/div/table/tbody/tr/td/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement cantidadSolicitada = Selenide.$x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div[2]/div[17]/div/div/input");
    public SelenideElement continuarSoli = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement btnSiguiente = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnCargarArchivos = Selenide.$x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement archivo1 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement adjuntar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement btnCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement btnContinuar = Selenide.$x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
}
