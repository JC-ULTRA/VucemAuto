package SENER.Tramite130204;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage130204 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Sener = $x("/html/body/main/div/div[3]/div/form/a[11]/img");
    public SelenideElement linkPermisoImportExport = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement linkExportacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/a");
    public SelenideElement linkSolExpHidro = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[2]/ul/li[2]/a");
    //DATOS SOLICITUD
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
    public SelenideElement selectRegimenClave = $x("//*[@id=\"solicitud.regimen.clave\"]");
    public SelenideElement selectClasificacionRegimen = $x("//*[@id=\"solicitud.claveClasificacionRegimen\"]");
    public SelenideElement inputCortoPlazo = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[6]/div/div[2]/input");
    public SelenideElement TextareaDescripcionMercancia = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[7]/div/div/textarea");
    public SelenideElement inputCveFraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    //public SelenideElement inputUMT = $x("//*[@id=\"unidadTarifariaComboId\"]");
    public SelenideElement inputNICO = $x("//*[@id=\"solicitud.mercancia.ideGenerica3\"]");
    public SelenideElement inputCantidadMercancia = $x("//*[@id=\"solicitud_mercancia_cantidadTarifaria\"]");
    public SelenideElement inputValorFactura = $x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputDescripcion = $x("//*[@id=\"descripcion\"]");
    public SelenideElement inputValorPArtida = $x("//*[@id=\"totalUSDPartida\"]");
    public SelenideElement btnAgregarPartida = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[14]/div/div/input");
    public SelenideElement btnPaises = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[20]/div/div/div[2]/div[2]/a/input");
    public SelenideElement inputPaisOrigen = $x("//*[@id=\"sPaisBloqueOrigen\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"agregarPaisBloque\"]/input");
    public SelenideElement textareaUsoEspecifico = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[21]/div[1]/textarea");
    public SelenideElement textareaJustificacion = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[21]/div[2]/textarea");
    public SelenideElement textareaObservaciones = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[22]/div/div/textarea");
    public SelenideElement inputDeclaracion = $x("//*[@id=\"chkman\"]");
    public SelenideElement btnGuarda = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[27]/td[2]/div/input[2]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc7 = $x("/html/body/main/div/div[4]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc8 = $x("/html/body/main/div/div[4]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc9 = $x("/html/body/main/div/div[4]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc10 = $x("/html/body/main/div/div[4]/div[2]/div/form[11]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc11 = $x("/html/body/main/div/div[4]/div[2]/div/form[12]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc12 = $x("/html/body/main/div/div[4]/div[2]/div/form[13]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc13 = $x("/html/body/main/div/div[4]/div[2]/div/form[14]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc14 = $x("/html/body/main/div/div[4]/div[2]/div/form[15]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc15 = $x("/html/body/main/div/div[4]/div[2]/div/form[16]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc16 = $x("/html/body/main/div/div[4]/div[2]/div/form[17]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc17 = $x("/html/body/main/div/div[4]/div[2]/div/form[18]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc18 = $x("/html/body/main/div/div[4]/div[2]/div/form[19]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc19 = $x("/html/body/main/div/div[4]/div[2]/div/form[20]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc20 = $x("/html/body/main/div/div[4]/div[2]/div/form[21]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc21 = $x("/html/body/main/div/div[4]/div[2]/div/form[22]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc22 = $x("/html/body/main/div/div[4]/div[2]/div/form[23]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc23 = $x("/html/body/main/div/div[4]/div[2]/div/form[24]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc24 = $x("/html/body/main/div/div[4]/div[2]/div/form[25]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement inputDictamenAceptado = $x("//*[@id=\"sentidoDictamen\"]");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"justificacionDictamen\"]");
    public SelenideElement inputTextoDictamen = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement inputInicioFechaVigencia = $x("//*[@id=\"dFechaFinVigencia\"]");
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