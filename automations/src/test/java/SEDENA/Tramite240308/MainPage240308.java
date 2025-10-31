package SEDENA.Tramite240308;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage240308 {
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
    public SelenideElement inputSolicitarModificacion = $x("//*[@id=\"modificarButton\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputJustificacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement inputSelectOrigen = $x("//*[@id=\"destinolistaOrigen\"]");
    public SelenideElement inputRestarOrigen = $x("//*[@id=\"removelistaOrigen\"]");
    public SelenideElement inputOrigenLista = $x("//*[@id=\"origenlistaOrigen\"]");
    public SelenideElement inputAddOrigenLista = $x("//*[@id=\"addlistaOrigen\"]");
    public SelenideElement inputPermisoGeneral = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div[1]/input");
    public SelenideElement inputUsoFinalMercancia = $x("//*[@id=\"solicitud.mercancia.usoFinal\"]");

    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement chekboxDestinatario = $x("//*[@id=\"jqg_gridTerceros_TIPERS_DES_0\"]");
    public SelenideElement chekboxProveedor = $x("//*[@id=\"jqg_gridTerceros_TIPERS_PVD_0\"]");
    public SelenideElement btnModificarDestinatario = $x("//*[@id=\"modificarTercero_TIPERS_DES\"]");
    public SelenideElement btnModificarProveedor = $x("//*[@id=\"modificarTercero_TIPERS_PVD\"]");
    public SelenideElement inputNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement inputExtranjera = $x("//*[@id=\"terceros_nacionalidadExtranjera\"]");
    public SelenideElement inputFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement inputTercerosNombre = $x("//*[@id=\"terceros_nombre\"]");
    public SelenideElement inputTercerosApellidoPaterno = $x("//*[@id=\"terceros_apellidoPaterno\"]");
    public SelenideElement inputTercerosApellidoMaterno = $x("//*[@id=\"terceros_apellidoMaterno\"]");
    public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement inputTercerosDenominacion = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputTercerosPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement inputTercerosEstado = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement inputTercerosEstado2 = $x("//*[@id=\"terceros_selectEstado\"]");
    public SelenideElement inputTercerosMunicipio = $x("//*[@id=\"terceros_selectMunicipio\"]");
    public SelenideElement inputTercerosLocalidad = $x("//*[@id=\"terceros_selectLocalidad\"]");
    public SelenideElement inputTercerosCP = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement inputTercerosCP2 = $x("//*[@id=\"terceros_codPostal1\"]");
    public SelenideElement inputTercerosColonia = $x("//*[@id=\"terceros_selectColonia\"]");
    public SelenideElement inputTercerosCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement inputTercerosNumeroExt = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement inputTercerosNumeroInt = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement inputTercerosLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement inputTercerosTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement inputTercerosCorreoElec = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //PAGO DERECHOS
    public SelenideElement labelPagoDerechos = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputClaveReferencia = $x("//*[@id=\"solicitud.pago.claveDeReferencia\"]");
    public SelenideElement inputCadenaDependencia = $x("//*[@id=\"solicitud.pago.cadenaPagoDependencia\"]");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputImportePago = $x("//*[@id=\"solicitud.pago.impPago\"]");
    public SelenideElement InputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("//input[@type='button' and @value='Siguiente']");
    public SelenideElement btmAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("//*[@id=\"siguienteButton\"]");
    //Requerimiento
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
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