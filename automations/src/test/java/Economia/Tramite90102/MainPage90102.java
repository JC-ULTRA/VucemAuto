package Economia.Tramite90102;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage90102 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement Prosec = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/a");
    public SelenideElement ProgramaNuevo = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[2]/ul/li[1]/a");
    public SelenideElement elementoTramite90102 = Selenide.$x("//*[@id=\"servicios\"]/ul/li[2]/ul/li[1]/ul/li[2]/a");

    //Lista de productores indirectos
    public SelenideElement gridPrograma1 = $x("//*[@id=\"3\"]/td[3]");

    //Paso 1 CAPTURAR SOLICITUD
    //Consulta de domicilios
    public SelenideElement domiciliosPlantas = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement estadoPlantas = Selenide.$x("//*[@id='entidadFederativaDomicilios']");
    public SelenideElement mostrarDomicilios = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[4]/div[2]/div/input");
    public SelenideElement seleccionaPlanta = Selenide.$x("//*[@id='jqg_gridPlantasPROSECDisponibles_1']");
    public SelenideElement agregarPlanta = Selenide.$x("//*[@id='agregar_plantas']");
    public SelenideElement actividadProductiva = Selenide.$x("//*[@id='actividadProductiva']");

    //Pestaña Sectores y mercancías
    public SelenideElement sectoresMercancias = Selenide.$x("//*[@id=\"ui-id-3\"]/label");
    //Datos de la solicitud
    public SelenideElement sector = Selenide.$x("//*[@id='sectoresProsecConf']");
    public SelenideElement agregarSector = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[4]/div/div/div/input[2]");
    public SelenideElement selecSector = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[6]/div/div[1]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    //Mercancías a producir
    public SelenideElement fraccionArancelaria = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[7]/div[3]/div/div/input");
    public SelenideElement agregarFraccion = Selenide.$x("//*[@id='btnAgregarFraccion']");
    //Continuar paso 1
    public SelenideElement continuarSoli = Selenide.$x("//*[@id='guardarSolicitud']");

    //Paso 2 REQUERIMIENTOS NECESARIOS
    public SelenideElement continuarArchivos = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");

    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btnAnexar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement MensajeCarga = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement btnCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement btnContinuarPaso3 = Selenide.$x("//*[@id='siguienteButton']");
   }
