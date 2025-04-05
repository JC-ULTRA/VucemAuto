package Economia.Tramite80208;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage80208 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = Selenide.$x("//*[@id=\"btnSubmit\"]");
    public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = Selenide.$x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement immex = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ampliacion = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/a");
    public SelenideElement ampliacionModalidad = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/ul/li[6]/a");
    public SelenideElement tablaIMMEX = Selenide.$x("//*[@id=\"jqgh_ampliacionesDisponibles_numeroImmex\"]");
    public SelenideElement selecPrograma = Selenide.$x("/html/body/main/div/div[4]/div/form/div[1]/div/div/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[4]");
    public SelenideElement cambioModalidad = Selenide.$x("/html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a/label");
    public SelenideElement selecModalidad = Selenide.$x("//*[@id=\"modalidadImmex\"]");
    public SelenideElement btnContinuar = Selenide.$x("/html/body/main/div/div[4]/div/form[1]/div[3]/div/div/div[2]/input[1]");
    public SelenideElement btnSiguiente = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement adjuntarDocumentos = Selenide.$x("/html/body/main/div/div[4]/div[1]/form[1]/table/tbody/tr[12]/td[2]/div/input[2]");
    public SelenideElement archivo1 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo7 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo8 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo9 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement anexarDocumentos = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/div[6]/div/input[2]");
    public SelenideElement btnCerrar = Selenide.$x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnPasaFirma = Selenide.$x("//*[@id=\"siguienteButton\"]");
}
