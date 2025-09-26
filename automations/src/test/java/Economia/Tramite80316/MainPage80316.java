package Economia.Tramite80316;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80316 {
    public SelenideElement rfc = $x("//*[@id=\"rfcSolId\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"buscarSolicitanteBtn\"]");
    public SelenideElement folioImmex = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/center/div/div[3]/div[3]/div/table/tbody/tr[2]/td[3]");
    public SelenideElement modificacionTab = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    public SelenideElement nombreOir = $x("//*[@id=\"nombreId\"]");
    public SelenideElement apellidoPaternoOir = $x("//*[@id=\"apellidoPaternoId\"]");
    public SelenideElement apellidoMaternoOir = $x("//*[@id=\"apellidoMaternoId\"]");
    public SelenideElement correoElectronicoOir = $x("//*[@id=\"correoElectronicoId\"]");
    public SelenideElement codigoPostalOir = $x("//*[@id=\"codigoPostalId\"]");
    public SelenideElement entidadFederativaOir = $x("//*[@id=\"persona.domicilio.entidadFederativa.claveId\"]");
    public SelenideElement municipioOir = $x("//*[@id=\"municipioId\"]");
    public SelenideElement coloniaOir = $x("//*[@id=\"coloniaId\"]");
    public SelenideElement calleOir = $x("//*[@id=\"calleId\"]");
    public SelenideElement numeroExteriorOir = $x("//*[@id=\"numeroExteriorId\"]");
    public SelenideElement numeroInteriorOir = $x("//*[@id=\"numeroInteriorId\"]");
    public SelenideElement telefonoOir = $x("//*[@id=\"telefonoId\"]");
    public SelenideElement btnGuardarDatosOir = $x("//*[@id=\"btnGuardar\"]");
    public SelenideElement btnSiguienteFirmar = $x("//*[@id=\"siguienteButton\"]");
}
