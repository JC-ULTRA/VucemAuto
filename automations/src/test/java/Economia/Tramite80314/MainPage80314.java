package Economia.Tramite80314;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80314 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement IMMEX = $x("//*[@id=\"servicios\"]/ul/li[1]/a/span");
    public SelenideElement ModificacionPrograma = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/a/span");
    public SelenideElement elementoTramite130203 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/ul/li[8]/a");

    //Lista de programas
    public SelenideElement gridPrograma1 = $x("//*[@id=\"1\"]/td[3]");

    //Pestaña Modificación
    public SelenideElement tabModificacion = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");

    // Encuentra el select oculto por ID o name
    SelenideElement comboActividadProductiva = $x("//a[contains(@class,'sbSelector')]");

    // Encuentra el label y luego el combo visual
    //SelenideElement comboActividadProductiva = $x("//class[contains(text(),'Actividad productiva')]/following::a[contains(@class,'sbSelector')]");



    // Esperar que se despliegue la lista y seleccionar opción
    SelenideElement comboSeleccionGanaderia = $x("//ul[contains(@class,'sbOptions')]/li/a[@rel='APRO.24']");

    //public SelenideElement comboActividadProductiva = $x("//*[@id=\"sbSelector_10668595\"]");

    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]/span");
    public SelenideElement MensajeCarga = $x("//*[@id=\"ui-dialog-title-divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]/span");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");




}
