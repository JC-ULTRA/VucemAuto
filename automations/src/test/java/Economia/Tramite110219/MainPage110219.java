package Economia.Tramite110219;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage110219 {
    //Tramite Aviso 110219
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li[2]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/a");
    public SelenideElement CancelCertif = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/ul/li[2]/ul/li[19]/a");

    ///Cancelación de certificado de origen
    public SelenideElement CancelCertiOrgPest = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement PaisBloque = $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement TratadoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement btnBuscarCerti = $x("//*[@id=\"buscarListaCertificados\"]");
    public SelenideElement Certific = $x("//*[@id=\"28\"]/td[5]");

    ///Certificado de OrigenPest
    public SelenideElement CertOrigenPest = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement MotivoCancel = $x("//*[@id=\"solicitud.certificadoOrigen.motivoCancelacion\"]");
    public SelenideElement btnContinuarFirm = $x("//*[@id=\"guardarSolicitud\"]");
}
