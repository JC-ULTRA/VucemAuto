package Economia.Tramite80306;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80306 {
        public SelenideElement cerS = $x("//*[@id='certificate']");
        public SelenideElement keyS = $x("//*[@id='privateKey']");
        public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
        public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
        public SelenideElement btnFirmar = $x("//*[@id=\"btnSubmit\"]");
        public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
        public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
        public SelenideElement selecRol = $x("//*[@id='claveRol']");
        public SelenideElement btnacep = $x("//button[@name='ingresar']");
        public SelenideElement Tramites = $x("//*[@id='Trámites']");
        public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
        public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
        public SelenideElement immex = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
        public SelenideElement modificacionPrograma = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/a");
        public SelenideElement modificacionBajaRegSer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[3]/ul/li[6]/a");
        public SelenideElement inputFolioPrograma = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/center/div/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
        public SelenideElement labelModificacion = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
        public SelenideElement btnBaja = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[2]/tbody/tr/td/center/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
        public SelenideElement modificacion = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
        public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
        public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Siguiente']");
        public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
        public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
        public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    }