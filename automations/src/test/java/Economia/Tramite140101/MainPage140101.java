package Economia.Tramite140101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage140101 {

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    //Loging y selección de rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Tramite  140101
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    //Elementos para encontrar tramite
    public SelenideElement CancelModifDesistReact = $x("//*[@id=\"servicios\"]/ul/li[7]/a/span");
    public SelenideElement PeticionParte = $x("//*[@id=\"servicios\"]/ul/li[7]/ul/li/a/span");
    public SelenideElement elementoTramite140101 = $x("//*[@id=\"servicios\"]/ul/li[7]/ul/li/ul/li[1]/a");

    //Paso1
    //Cancelación de Autorizaciones
    public SelenideElement tabCancelacionAutorizaciones = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement gridProgramaFila1 = $x("//*[@id=\"3\"]/td[1]/input");
    public SelenideElement MotivoCancelacion = $x("//*[@id=\"motivoCancelacion\"]");
    public SelenideElement checkConfirmoCancelarPrograma = $x("//*[@id=\"confirmar\"]");

    //Continuar (Agregar Solicitud)
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

}

