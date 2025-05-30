package HACIENDA.Tramite104;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage104 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement AutorizacionesImporExpor = $x("//*[@id=\"servicios\"]/ul/li[1]/a/span");
    public SelenideElement elementoTramite104 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[2]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos del inmueble
    public SelenideElement tabDatosInmueble = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    //Programa de fomento a la exportación
    public SelenideElement selectTipoPrograma = $x("//*[@id=\"solicitud.tipoProgFomExp\"]");
    public SelenideElement selectFolioAutorización = $x("//*[@id=\"solicitud.folioProgramaEconomia\"]");
    //Datos de la planta para realizar los procesos de ensamble y fabricación
    public SelenideElement btnAgregarPlanta = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table/tbody/tr[3]/td/input[1]");
    public SelenideElement CallePlanta = $x("//*[@id=\"callePlantasBodegas\"]");
    public SelenideElement NumExterior = $x("//*[@id=\"numeroExteriorPlantasBodegas\"]");
    public SelenideElement NumInterior = $x("//*[@id=\"numeroInteriorPlantasBodegas\"]");
    public SelenideElement selectPais = $x("//*[@id=\"paisPlantasBodegas\"]");
    public SelenideElement selectEntidad = $x("//*[@id=\"entidadPlantasBodegas\"]");
    public SelenideElement selectMunicipio = $x("//*[@id=\"delegacionPlantasBodegas\"]");
    public SelenideElement selectColonia = $x("//*[@id=\"coloniaPlantasBodegas\"]");
    public SelenideElement selectLocalidad = $x("//*[@id=\"localidadPlantasBodegas\"]");
    public SelenideElement CodigoPostal = $x("//*[@id=\"codigoPostalPlantasBodegas\"]");
    public SelenideElement btnGuardarPlanta = $x("//*[@id=\"registroPlantasBtn\"]");
    public SelenideElement btnSiguientePaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]/span");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]/span");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");


}
