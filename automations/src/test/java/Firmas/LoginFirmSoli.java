package Firmas;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginFirmSoli {

    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("/html/body/div[2]/form/div[1]/div/div[2]/div/div[4]/div/button[2]");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");

    public SelenideElement selecSinFiel = $x("/html/body/div[2]/form/div[1]/ul/li[2]/a");
    public SelenideElement inputUser = $x("/html/body/div[2]/form/div[1]/div/div[3]/div[1]/div/input");
    public SelenideElement InputPasww = $x("/html/body/div[2]/form/div[1]/div/div[3]/div[2]/div/input");
    public SelenideElement btnIngresSinFiel = $x("/html/body/div[2]/form/div[1]/div/div[3]/div[3]/div/button[2]");

    // Método que acepta un objeto TramitesFirmasLG y hace uso de sus rutas
public void login(TramitesFirmasLG tramite) {
    cerS.setValue(tramite.getCer());
    keyS.setValue(tramite.getKey());
    pass.setValue("delfin40");
    btnIngres.click();
}

    public void firma(TramitesFirmasLG tramite) {
        cerS.setValue(tramite.getCer());
        keyS.setValue(tramite.getKey());
        pass.setValue("delfin40");
        btnFirmar.click();
    }

    public void login2(TramitesFirmasLG tramite) {
        cerS.setValue(tramite.getCer());
        keyS.setValue(tramite.getKey());
        pass.setValue("12345678a");
        btnIngres.click();
    }

    public void firma2(TramitesFirmasLG tramite) {
        cerS.setValue(tramite.getCer());
        keyS.setValue(tramite.getKey());
        pass.setValue("12345678a");
        btnFirmar.click();
    }

    public void loginFun(TramitesFirmasLG tramite) {
        cerS.setValue(tramite.getCer());
        keyS.setValue(tramite.getKey());
        pass.setValue("delfin40");
        btnFirmar.click();
    }

    public void firmaFun(TramitesFirmasLG tramite) {
        cerS.setValue(tramite.getCer());
        keyS.setValue(tramite.getKey());
        pass.setValue("delfin40");
        btnFirmar.click();
    }

    public void LoginPerCapPriv() {
        selecSinFiel.click();
        inputUser.setValue("ZUXR540125MPLRXC07");
        InputPasww.setValue("NS56hYnZ");
        btnIngresSinFiel.click();
    }



}