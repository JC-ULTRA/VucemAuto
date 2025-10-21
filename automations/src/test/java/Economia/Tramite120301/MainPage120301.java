package Economia.Tramite120301;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage120301 {
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    //Tramite130112
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Econom = $x("//img[contains(@alt, 'Economía')]");
    public SelenideElement linkCuposImportacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/a");
    public SelenideElement linkExpCerEleBieTexPreVes = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[3]/a");
    public SelenideElement elementoTramite120301 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[5]/ul/li[3]/ul/li[1]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Tab Datos de la solicitud
    public SelenideElement labelConstanciaRegistro = $x("//*[@id=\"ui-id-2\"]/label");
    //Datos de la constancia de registro
    public SelenideElement btnBuscarInstrumento = Selenide.$x("//*[@id=\"acciones\"]/input");
    public SelenideElement inputNumeroConstancia = Selenide.$x("//*[@id=\"4\"]/td[2]");
    public SelenideElement inputGuardarSolPar = $x("//*[@id=\"tabs-buscarAsignacion\"]/div[7]/div/div/div/input");
    //Capturar facturas
    public SelenideElement inputNumFacturaNew = $x("//*[@id=\"numFactura\"]");
    public SelenideElement inputCantidadTotal = $x("//*[@id=\"cantidad\"]");
    public SelenideElement inputUnidad = $x("//*[@id=\"unidadMedidaClave\"]");
    public SelenideElement inputFechaExp = $x("//*[@id=\"fechaExpedicion\"]");
    public SelenideElement inputValorDoll = $x("//*[@id=\"importeDolares\"]");
    public SelenideElement inputRazonS = $x("//*[@id=\"razonSocial\"]");
    public SelenideElement inputDomi = $x("//*[@id=\"domicilio\"]");
    public SelenideElement inputCiudad = $x("//*[@id=\"ciudadFactura\"]");
    public SelenideElement inputCPM = $x("//*[@id=\"cpFactura\"]");
    //Facturas asociadas
    public SelenideElement labelFacturasAsociadas = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement inputHoja2 = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[4]/div/div[2]/div/div[2]/ul/li[2]/a");
    public SelenideElement inputNumFactura = $x("//*[@id=\"15\"]/td[6]");
    public SelenideElement inputNumFacturaG = $x("//*[@id=\"jqg_gridFacturasDisponiblesTPL_6\"]");
    public SelenideElement inputCantidadAsociada = Selenide.$x("//*[@id=\"cantidadAsociada\"]");
    public SelenideElement btnAsociar = Selenide.$x("//*[@id=\"tabs-asociarFacturas\"]/div/div[4]/div/div/input");
    public SelenideElement inputValorFacturaUSD = Selenide.$x("//*[@id=\"solicitud_mercancia_valorFacturaUSD\"]");
    //Histórico de fabricantes
    public SelenideElement labelHistoricoFabricantes = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[5]/a/label");
    public SelenideElement inputIdFabExporNo = $x("//*[@id=\"idFabricanteMismoExportador\"]");
    public SelenideElement inputNacional = $x("//*[@id=\"contenedorRadiosFabricante\"]/input");
    public SelenideElement next = $x("//*[@id=\"pagerFabricantesNPorExportador\"]/ul/li[3]/a");
    public SelenideElement inputNombreFab = $x("//*[@id=\"jqg_gridFabricantesNPorExportador_13\"]");
    public SelenideElement inputNombreFabF = $x("//*[@id=\"jqg_gridFabricantesNPorExportador_3\"]");
    public SelenideElement btnSeleccionarFabricante = $x("//*[@id=\"acciones\"]/input[2]");
    //Importador en destino
    public SelenideElement labelImportadorDestino = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[6]/a/label");
    public SelenideElement inputTipoIOR = $x("//*[@id=\"solicitud.descripcionGenerica2\"]");
    public SelenideElement inputValor = $x("//*[@id=\"IdValor\"]");
    public SelenideElement inputRazonSocial = $x("//*[@id=\"razonSocialImp\"]");
    public SelenideElement inputDomicilio = $x("//*[@id=\"domicilioImp\"]");
    public SelenideElement inputCiudadN = $x("//*[@id=\"ciudadImp\"]");
    public SelenideElement inputCP = $x("//*[@id=\"cpImp\"]");
    //GUARDAR
    public SelenideElement btnGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputAcuse = $x("//*[@id=\"acuse\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement inputDictamenAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement justificacionRequerimiento = $x("//*[@id=\"valueTA\"]");
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