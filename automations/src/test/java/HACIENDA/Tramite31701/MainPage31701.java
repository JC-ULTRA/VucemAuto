package HACIENDA.Tramite31701;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage31701 {
    //Tramite 32512
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement CuadroText = $x("//*[@id=\"notification\"]/div");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    /// html/body/main/div/div[4]/div/div[4]/div/div/ul/li
    /// html/body/main/div/div[4]/div/div[4]/div/div/ul/li
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");

    //Acuses y resoluciones (Busqueda de folio)
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement FolioGrid = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]");

    //Pantalla Azul: Acuses y resoluciones
    public SelenideElement btnSolRenovacion = $x(" //*[@id=\"renovarButton\"]");

    //BEGING FLUJO ALTERNO
    public SelenideElement SolicitudesMen = $x("//*[@id=\"Solicitudes\"]");
    public SelenideElement IdSolicitud = $x("//*[@id=\"idSolicitud\"]"); //202770810
    public SelenideElement btnBuscarAlter = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement IdSolGrid = $x("//*[@id=\"3\"]/td[1]");
    //public SelenideElement nombreElemento = $x("");




    //END FLUJO ALTERNO

    //Tab Aviso Unico de Renovacion
    public SelenideElement tabAvisoRenovacion = $x("//*[@id=\"ui-id-2\"]/label");

    //Paso 1

    //* Renovación Modalidad IVA e IEPS
    public SelenideElement rdbtnRubroA = $x("//*[@id=\"avisoA\"]");
    public SelenideElement rdbtnRubroAA = $x("//*[@id=\"avisoAA\"]");
    public SelenideElement rdbtnRubroAAA = $x("//*[@id=\"avisoAAA\"]");
    public SelenideElement rdbtnBajoProtest = $x("//*[@id=\"acepto3061\"]");

    public SelenideElement rdbtnConEnvio = $x("//*[@id=\"acepto3062\"]");
    public SelenideElement rdbtnCircunstanc = $x("//*[@id=\"acepto3063\"]");

    //Pago de derechos
    public SelenideElement NumOperac = $x("//*[@id=\"solicitud.pago.referenciaBancaria\"]");
    public SelenideElement listBanco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inpLLavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement FechaPago = $x("//*[@id=\"calendarTo\"]");

    //Botones
    public SelenideElement btnBorrarDatos = $x("//*[@id=\"borrarDatosPago\"]");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso2
    public SelenideElement comboTipoDoc = $x("//*[@id=\"selectDoctosEspecificos\"]");
    public SelenideElement btnEliminar = $x("//*[@id=\"deleteButton\"]");
    public SelenideElement btnAgreNuevo = $x("//*[@id=\"divGridDoctosEsp\"]/div[2]/div[2]/div[2]/div[2]/input[2]");
    public SelenideElement btnContinuar2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement comboDocumentoGrid = $x("//*[@id=\"idDoc0\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

    //
    public SelenideElement continuarSoli = $x("//*[@id=\"siguienteButton\"]");




    //C:\Users\ErickALD\Desktop\Aqua\automations\src\test\resources\Lorem_ipsum.pdf
    //*[@id="guardarButton"]
    //*[@id="workingArea"]/form/div[4]/div/div/input[2]
    /*public SelenideElement nombreElemento = $x("");
    public SelenideElement nombreElemento = $x("");

*/




    


}
