package SEDENA.Tramite240411;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage240411 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliSub = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[4]/a");
    public SelenideElement inputIdFolio = $x("//*[@id=\"idFolio\"]");
    public SelenideElement inputBuscarButton = $x("//*[@id=\"buscarButton\"]");
    public SelenideElement SolicitudTramite = $x("/html/body/main/div/div[3]/div/form[1]/div[6]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]");
    public SelenideElement inputSolicitarProrroga = $x("//*[@id=\"prorrogaButton\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //Tramite 240305
    //Búsqueda de trámite subsecuente
    public SelenideElement FolioTramite = $x("//*[@id=\"idFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarButton\"]");
    public ElementsCollection filaFolioGrid = $$("tr.ui-widget-content");

    //Solicitar Modificación
    public SelenideElement btnSolProrroga = $x("//*[@id=\"prorrogaButton\"]");

    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement Justificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement inputCadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    //Paso 2 REQUISITOS NECESARIOS
    public SelenideElement inputContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Continuar']");
    //Paso 3 ANEXAR REQUISITOS
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio2 = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement inputDictamenAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
    public SelenideElement inputFechaFinVig = $x("//*[@id=\"dFechaFinVigencia\"]");
    //Proceso Confirmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public void seleccionarFacturaPorAño(String año) {
        ElementsCollection filas = $$("tr[role='row'].jqgrow"); // todas las filas de datos

        for (SelenideElement fila : filas) {
            if (fila.getText().contains(año)) {
                // Dentro de la fila, busca el checkbox (2da columna)
                SelenideElement checkbox = fila.$("input[type='checkbox']");
                checkbox.click(); // hace clic en el checkbox
                System.out.println("Seleccionada la fila con fecha del año: " + año);
                break; // detener después de encontrar la primera coincidencia
            }
        }
    }
}