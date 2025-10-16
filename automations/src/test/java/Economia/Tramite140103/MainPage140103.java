package Economia.Tramite140103;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage140103 {
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement CancelModifDesistReact = $x("//*[@id=\"servicios\"]/ul/li[7]/a/span");
    public SelenideElement PeticionParte = $x("//*[@id=\"servicios\"]/ul/li[7]/ul/li/a/span");
    public SelenideElement labelCanCerCupPetInt = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[7]/ul/li/ul/li[3]/a");
    public SelenideElement labeCancelacionAutorizacion = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement selectRegimenAduanero = $x("//*[@id=\"cupoBusqueda.claveRegimen\"]");
    public SelenideElement selectMecanismoAsignacion = $x("//*[@id=\"cupoBusqueda.mecanismoAsignacion\"]");
    public SelenideElement selectTratadoBloqueComercial = $x("//*[@id=\"cupoBusqueda.idTratadoAcuerdo\"]");
    public SelenideElement selectNombreProducto = $x("//*[@id=\"cupoBusqueda.nombreProducto\"]");
    public SelenideElement selectNombreSubproducto = $x("//*[@id=\"cupoBusqueda.nombreSubproducto\"]");
    public SelenideElement selectRepresentacionFederal = $x("//*[@id=\"cupoBusqueda.claveRepresentacionFederal\"]");
    public SelenideElement btnBuscarCupo = $x("//*[@id=\"tabs-3\"]/div[4]/div/input");
    public SelenideElement inputCupo = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[6]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement agregarCupo = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[19]/div/div/input");
    public SelenideElement montoCancelar = $x("//*[@id=\"saldoDisponibleCertificado\"]");
    public SelenideElement agregarSaldo = $x("/html/body/main/div/div[4]/div[2]/form/div[1]/div[2]/input[1]");
    public SelenideElement seleccionarCancelado = $x("//*[@id=\"jqg_gridCertificadosCancelados_3\"]");
    public SelenideElement devolverFacturas = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[22]/div/div/input[2]");
    public SelenideElement selectFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement cantidadDevolver = $x("//*[@id=\"cantidadDevolver\"]");
    public SelenideElement devolverMontoFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[5]/div/input");
    public SelenideElement btnCerrarFactura = $x("/html/body/main/div/div[4]/div[2]/form/div[9]/div/input");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
}