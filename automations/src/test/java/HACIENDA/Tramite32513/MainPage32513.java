package HACIENDA.Tramite32513;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage32513 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x(" /html/body/main/div/div[3]/div/form/a[1]");
    public SelenideElement linkResgistroComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement linkEnvioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement linkAvisoParaDestrucciMercanc = $x("//a[contains(@onclick, 'isco')]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelTipoAviso2 = $x("//label[contains(@for, 'va')]");
    public SelenideElement inputSolicitudDescripcionGenerica = $x("//*[@id='solicitud.descripcionGenerica1']");
    public SelenideElement inputSolicitudDescripcionGenerica2 = $x("//*[@id='solicitud.descripcionGenerica2']");
    public SelenideElement inputArchivoCargaMasiva = $x("//*[@id='archivoCargaMasiva']");
    public SelenideElement inputCargarArchivoDatosAviso = $x("//*[@id='cargarArchivoDatosAviso']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    //REQUISITOS NECESARIOS
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[1].file']");
    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[2].file']");
    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[3].file']");
    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement inputGuardarButton = $x("//*[@id='guardarButton']");
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement inputDictamenAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form/table[1]/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
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