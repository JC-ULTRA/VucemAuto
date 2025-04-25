package Economia.Tramite120101;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage120101 {
    ///Tramite Aviso 120101
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CertificadoOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement ValidacionCertificadosOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/a");
    public SelenideElement Tramite120101 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[1]/ul/li[1]/a");

    ///Consultar Cupo
    public SelenideElement ConsultCupoPest = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement ClasifRegimen = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[2]/div[2]/div/div/select");
    public SelenideElement PaisDestOrg = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[3]/div[1]/div/div/select");
    public SelenideElement FreaccionArancel = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[3]/div[2]/div/div/input");
    public SelenideElement btnBuscarTPL = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[5]/div[2]/div/input");
    public SelenideElement CargaRegistro = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]");
    public SelenideElement Estado = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[2]/div[1]/div/div/select");
    public SelenideElement RepreFede = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/select");
    public SelenideElement Descrip = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[2]/div/div/div/input");
    public SelenideElement btnContinuarCupo = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[3]/div/div[2]/input");

    ///Insumos
    public SelenideElement InsumosPest = $x("//*[@id=\"ui-id-3\"]");
    public SelenideElement btnAgregarInsumo = $x("//*[@id=\"botonAgregarInsumos\"]");
    public SelenideElement DescripInsumo = $x("//*[@id=\"insumo.nombre\"]");
    public SelenideElement InsumoFraccArancel = $x("//*[@id=\"insumo.claveFraccionArancelaria\"]");
    public SelenideElement DescripFraccArancel = $x("//*[@id=\"descripcionFraccionInsumo\"]");
    public SelenideElement PaisDeOrigen = $x("//*[@id=\"insumo.paisOrigen.clave\"]");
    public SelenideElement btnAgregarInsumo2 = $x("//*[@id=\"agregaInsumo\"]");

    ///Proceso Productivo:
    public SelenideElement ProcesoProductivoPest = $x("//*[@id=\"ui-id-4\"]");

    //Hilo
    public SelenideElement CheckHilo = $x("//*[@id=\"TIBFR.HL\"]");
    public SelenideElement PaisOrgFibra = $x("//*[@id=\"solicitud.paisOrigenFibra\"]");
    public SelenideElement PaisRealizoHilado = $x("//*[@id=\"solicitud.paisOrigenHiladoTLCAN\"]");

    //Tela
    public SelenideElement CheckTela = $x("//*[@id=\"TIBFR.TL\"]");
    public SelenideElement PaisRealizoHilado2 = $x("//*[@id=\"solicitud.paisOrigenHilado\"]");
    public SelenideElement PaisRealizoTejido = $x("//*[@id=\"solicitud.paisOrigenTejidoTLCAN\"]");

    //Bienes tejidos a forma
    public SelenideElement CheckBienes = $x("//*[@id=\"TIBFR.BT\"]");
    public SelenideElement PaisRealizoHilado3 = $x("//*[@id=\"solicitud.paisOrigenHilado\"]");
    public SelenideElement PaisRealizoTejidoForma = $x("//*[@id=\"solicitud.paisOrigenTejidoAForma\"]");

    //Prendas y otras manufacturas
    public SelenideElement CheckPrendas = $x("//*[@id=\"TIBFR.PM\"]");
    public SelenideElement PaisRealizoHilado4 = $x("//*[@id=\"solicitud.paisOrigenHilado\"]");
    public SelenideElement PaisRealizoTejido4 = $x("//*[@id=\"solicitud.paisOrigenTejido\"]");
    public SelenideElement PaisRealizoCorte = $x("//*[@id=\"solicitud.paisOrigenCorte\"]");
    public SelenideElement PaisRealizoEnsamble = $x("//*[@id=\"solicitud.paisOrigenEnsamble\"]");

    public SelenideElement btnContinuarFirma = $x("//*[@id=\"guardarSolicitud\"]");
}
