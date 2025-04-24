package Economia.Tramite140104;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage140104 {
    //Tramite  140104

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Elementos para encontrar tramite
    public SelenideElement CancelModifDesistReact = $x("//*[@id=\"servicios\"]/ul/li[7]/a/span");
    public SelenideElement PeticionParte = $x("//*[@id=\"servicios\"]/ul/li[7]/ul/li/a/span");
    public SelenideElement elementoTramite140104 = $x("//*[@id=\"servicios\"]/ul/li[7]/ul/li/ul/li[4]/a");

    //Paso1
    //Cancelacion Permisos Previamente Autorizados
    public SelenideElement tabCancelacionPermisosPrevAutorizado = $x("//*[@id=\"ui-id-2\"]/label");
    public SelenideElement btnAccederBusquedaFolio = $x("//*[@id=\"tabs-3\"]/div[2]/div/div/input[4]");
    public SelenideElement FolioResolucion = $x("//*[@id=\"folioResolucion\"]");
    public SelenideElement btnBuscarFolioIngresado = $x("/html/body/main/div/div[4]/div[2]/div[3]/div[2]/div/input[2]");
    public SelenideElement btnAgregarFolio = $x("//*[@id=\"botonAgregarRegistro\"]");
    public SelenideElement MotivoCancelacion = $x("//*[@id=\"motivoCancelacion\"]");
    //Grid Permisos a cancelar
    public SelenideElement ResolucionElemento1= $x("//*[@id=\"jqg_gridCancelacionSolicitudPexim_1\"]");
    //Continuar (Agregar Solicitud)
    public SelenideElement btnContinuarAgregarSol = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");


    //public SelenideElement nombreElemento = $x("");
}

