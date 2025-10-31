package HACIENDA.Tramite32505;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32505 {
    //Tramite 32505
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Navegación para entrar al tramite
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement EnvioAviso = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a/span");  //*[@id="servicios"]/ul/li/ul/li[5]/a/span
    public SelenideElement elementoTramite32505 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[6]/ul/li[5]/a");

    //PASO 1 Capturar solicitud
    //Tab Aviso
    public SelenideElement tabAviso = $x("//*[@id=\"ui-id-2\"]");
    //Datos del periodo del aviso
    public SelenideElement MesAviso = $x("//*[@id=\"solicitud.ideGenerica1\"]");
    public SelenideElement AñoAviso = $x("//*[@id=\"solicitud.descripcionGenerica1\"]");
    public SelenideElement articulo8 = $x("//*[@id=\"declaraSi\"]");
    //Tipo de carga
    public SelenideElement radbtnManualCarga = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[2]/div[2]/div/input[1]");
    public SelenideElement radbtnMasivaCarga = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[2]/div[2]/div/input[2]");
    //Carga Masiva
    public SelenideElement btnSeleccionarArchivo = $x("//*[@id=\"fileBean\"]");
    public SelenideElement bnCargarArchivo = $x("//*[@id=\"cargarArchivoDatosAviso\"]");
    //Datos Aviso Tabla
    public SelenideElement btnAgregarAviso = $x("//*[@id=\"agregarAvisoVehiculo\"]");
    public SelenideElement checkTodosLosAviso = $x("//*[@id=\"cb_gridDatosAviso\"]");
    //Agregar Aviso
    //Tipo de operación
    public SelenideElement radbtnImportacion = $x("//*[@id=\"idTipoRegistroImp\"]");
    public SelenideElement radbtnVenta = $x("//*[@id=\"idTipoRegistroVen\"]");
    public SelenideElement radbtnImportacionVenta = $x("//*[@id=\"idTipoRegistroVen\"]");
    public SelenideElement radbtnSiFolioImportacion = $x("//*[@id=\"idFolioImpSi\"]");
    public SelenideElement radbtnNoFolioImportacion = $x("//*[@id=\"idFolioImpNo\"]");
    public SelenideElement IdentificadorTransaccion = $x("//*[@id=\"identificadorVucem\"]");
    public SelenideElement BusquedaNumeroSerieNiv = $x("//*[@id=\"busquedaNivNumeroSerie\"]");

    //Datos del vehículo
    public SelenideElement NumeroSerieNiv = $x("//*[@id=\"nivNumeroSerie\"]");
    public SelenideElement selectAñoModelo = $x("//*[@id=\"idAnio\"]");
    public SelenideElement MarcaVehiculo = $x("//*[@id=\"marca\"]");
    public SelenideElement ModeloVehiculo = $x("//*[@id=\"modelo\"]");
    public SelenideElement TipoVarianteVersion = $x("//*[@id=\"tipoVarianteVersion\"]");
    public SelenideElement selectNoCilindros = $x("//*[@id=\"numeroCilindros\"]");
    public SelenideElement selectNoPuertas = $x("//*[@id=\"numeroPuertas\"]");
    public SelenideElement selectTipoCombustible = $x("//*[@id=\"tipoCombustible\"]");
    public SelenideElement NoTituloPropiedad = $x("//*[@id=\"tituloPropiedad\"]");
    public SelenideElement NombreTituloPersona = $x("//*[@id=\"nombreTituloPropiedad\"]");
    public SelenideElement selectPaisEmitioTitulo = $x("//*[@id=\"pais\"]");
    public SelenideElement EstadoEmisionTitulo = $x("//*[@id=\"txtEstadoTituloPropiedad\"]");
    public SelenideElement NoPlacasPaisProcedencia = $x("//*[@id=\"numeroPlacas\"]");
    public SelenideElement selectFormaAdquisicionVehiculo =  $x("//*[@id=\"tipoAdquisicion\"]");
    public SelenideElement NoDocumentoExpor = $x("//*[@id=\"numeroDocumento\"]");

    //Datos Importacion
    public SelenideElement selectAduanaImportacion = $x("//*[@id=\"aduana\"]");
    public SelenideElement PatenteImportacion = $x("//*[@id=\"patenteAutorizacion\"]");
    public SelenideElement PedimientoImportacion = $x("//*[@id=\"pedimento\"]");
    public SelenideElement KilometrajeImportacion = $x("//*[@id=\"kilometraje\"]");
    public SelenideElement ValorAduana = $x("//*[@id=\"valorAduana\"]");
    public SelenideElement MontoPagadoIGI = $x("//*[@id=\"montoIGI\"]");
    public SelenideElement FormaPagoIGI = $x("//*[@id=\"formaPagoIGI\"]");
    public SelenideElement MontoDTA = $x("//*[@id=\"montoDTA\"]");
    public SelenideElement MontoIVA = $x("//*[@id=\"montoIVA\"]");
    public SelenideElement ValorDolares = $x("//*[@id=\"valorDolares\"]");
    public SelenideElement FolioImportacionCFDI = $x("//*[@id=\"folioCFDI\"]");

    //Datos de la venta en territorio nacional
    public SelenideElement FolioCFDIVenta = $x("//*[@id=\"folioVenta\"]");
    public SelenideElement ValorVentaSinIVA = $x("//*[@id=\"valorVenta\"]");
    public SelenideElement btnGuardarAviso = $x("//*[@id=\"agregarDatosAviso\"]");
    public SelenideElement btnAceptarNotifAgrAviso = $x("/html/body/div[7]/div[3]/div/button");

    //Botón Continuar Paso 1
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
