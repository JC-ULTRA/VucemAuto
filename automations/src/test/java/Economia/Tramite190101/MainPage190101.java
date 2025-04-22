package Economia.Tramite190101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage190101 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkDireccionGeneralNormas = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/a");
    public SelenideElement linkCerfiticacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/a");
    public SelenideElement linkCerfiticacionNOM = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[9]/ul/li[1]/ul/li[1]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");

    public SelenideElement inputSiguienteButton = $x("//*[@id=\"siguienteButton\"]");
////////////////////////////////////////////////////////
public SelenideElement input1 = $x("//*[@id='PRUEBAS_PERIODICAS_AL_PRODUCTO']");

    public SelenideElement linkPestaña1input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[2]/a/label");
    public SelenideElement linkPestaña2input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[3]/a/label");
    public SelenideElement linkPestaña3input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[4]/a/label");
    public SelenideElement linkPestaña4input1 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[5]/a/label");

    // Campos que se llenan con input1
    public SelenideElement opcionllenado1 = $x("//*[@id='CATPR.N']/input");
    public SelenideElement opcionllenado2 = $x("//*[@id='solicitud.descripcionOtroTipoDePropietarioAeronave']");

    public SelenideElement input2 = $x("//*[@id='DICTAMEN_DE_PRODUCTO_PARA_FABRICANTE_NACIONAL_EXTRANJERO']");

    public SelenideElement linkPestaña1input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[2]/a/label");
    public SelenideElement linkPestaña2input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[3]/a/label");
    public SelenideElement linkPestaña3input2 = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div/ul/li[5]/a/label");

    // Campos que se llenan con input2
    public SelenideElement opcionllenado3 = $x("//*[@id='entidadBodega']");

    ///////////////////////////////////////////////////////////////
}
