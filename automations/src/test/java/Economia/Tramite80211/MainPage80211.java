package Economia.Tramite80211;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage80211 {
    public SelenideElement tabEmpresas = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a/label");
    public SelenideElement rfc = $x("//*[@id=\"rfcEmpresaTerciarizadora\"]");
    public SelenideElement estado = $x("//*[@id=\"entidadFederativaEmpresaTerciarizadora\"]");
    public SelenideElement selecionarPlanta1 = $x("//*[@id=\"jqg_gridTerciarizadorasDisponibles_1\"]");
    public SelenideElement btnAgregarPlanta = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[6]/div/input");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuarDocs = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement justificacionDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/fieldset[1]/table/tbody/tr[4]/td/textarea");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr/td/input[2]");
    public SelenideElement autorizarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr/td/input[2]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}
