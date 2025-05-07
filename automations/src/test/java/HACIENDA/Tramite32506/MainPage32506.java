package HACIENDA.Tramite32506;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32506 {
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement EnvioAviso = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement Tramite32506 = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[6]/a");
//AVISO
    public SelenideElement labelAviso = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a");
public SelenideElement NumeroIMMEX = $x("//*[@id=\"solicitud.numeroProgramaImmex\"]");
    public SelenideElement AñoIMMEX = $x("//*[@id=\"solicitud.clavePermisoSedena\"]");
    public SelenideElement inputNoHabitual = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[2]/div[3]/input[1]");
    public SelenideElement btnAceptar = $x("/html/body/div[17]/div[3]/div/button[1]");
    public SelenideElement inputJustificacion = $x("//*[@id=\"solicitud.descripcionGenerica1\"]");
    public SelenideElement inputPeriodicidad = $x("//*[@id=\"solicitud.ideGenerica3\"]");
    public SelenideElement inputNombreComercial = $x("//*[@id=\"solicitud.direccionStOrigen.nombreComercial\"]");
    public SelenideElement selectEntidadFederativa = $x("//*[@id=\"solicitud.direccionStOrigen.entidadFederativa.clave\"]");
    public SelenideElement selectAlcaldiaMunicipio= $x("//*[@id=\"solicitud.direccionStOrigen.delegacionMunicipio.clave\"]");
    public SelenideElement selectColonia = $x("//*[@id=\"solicitud.direccionStOrigen.colonia.clave\"]");
    public SelenideElement inputCalle = $x("//*[@id=\"solicitud.direccionStOrigen.calle\"]");
    public SelenideElement NumeroExterior = $x("//*[@id=\"solicitud.direccionStOrigen.numeroExterior\"]");
    public SelenideElement NumeroInterior = $x("//*[@id=\"solicitud.direccionStOrigen.numeroInterior\"]");
    public SelenideElement CodigoPostal = $x("//*[@id=\"solicitud.direccionStOrigen.codigoPostal\"]");
    public SelenideElement inputManual = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[5]/div[3]/input[1]");
    public SelenideElement inputAgregar =$x("//*[@id=\"btnAgregarDomicilio\"]");
    public SelenideElement NombreComercial = $x("//*[@id=\"nombreComercial\"]");
    public SelenideElement inputEntidadFederal = $x("//*[@id=\"claveEntidadFederativa\"]");
    public SelenideElement inputMunicipio = $x("//*[@id=\"claveDelegacionMunicipio\"]");
    public SelenideElement inputColonia = $x("//*[@id=\"claveColonia\"]");
    public SelenideElement inputCalle1 = $x("//*[@id=\"calle\"]");
    public SelenideElement inputNumExterior = $x("//*[@id=\"numeroExterior\"]");
    public SelenideElement inputNumInterior = $x("//*[@id=\"numeroInterior\"]");
    public SelenideElement inputCodigoPostal = $x("//*[@id=\"codigoPostal\"]");
    public SelenideElement inputHoraRegistro = $x("//*[@id=\"horaRegistro\"]");
    public SelenideElement inputFechaRegistro = $x("//*[@id=\"fechaRegistro\"]");
    public SelenideElement btnAgregarProceso = $x("//*[@id=\"btnAgregarProceso\"]");
    public SelenideElement inputDescripcionProceso = $x("//*[@id=\"descripcionProcesoDestruccion\"]");
    public SelenideElement inputAgregarDesperdicio = $x("//*[@id=\"btnAgregarDesperdicio\"]");
    public SelenideElement inputDescripcion = $x("//*[@id=\"descripcionDesperdicio\"]");
    public SelenideElement inputCantidadDesp = $x("//*[@id=\"cantidadDesp\"]");
    public SelenideElement inputUMD = $x("//*[@id=\"claveUnidadMedidaDesp\"]");
    public SelenideElement inputPorcentaje = $x("//*[@id=\"porcentaje\"]");
    public SelenideElement inputDescripcionMercancia = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement inputDeclaratoria = $x("//*[@id=\"selector\"]");
    public SelenideElement inputHechos = $x("//*[@id=\"circunstanciaHechos\"]");
    public SelenideElement btnAgrgarPedimento = $x("//*[@id=\"btnAgregarPedimento\"]");
    public SelenideElement inputNumPatente = $x("//*[@id=\"patenteAutorizacion\"]");
    public SelenideElement inputNumPedimento = $x("//*[@id=\"pedimento\"]");
    public SelenideElement inputAduana = $x("//*[@id=\"claveAduanaPedimento\"]");
    public SelenideElement inputFraccionArancelaria = $x("//*[@id=\"claveFraccionArancelariaPedimento\"]");
    public SelenideElement inputNICO = $x("//*[@id=\"nicoPedimento\"]");
    public SelenideElement inputCantidad = $x("//*[@id=\"cantidadPedimento\"]");
    public SelenideElement inputUMP = $x("//*[@id=\"claveUnidadMedidaPedimento\"]");
    public SelenideElement inputBotonAgregar = $x("//*[@id=\"botonAgregarM4\"]");
public SelenideElement btnAceptar2 = $x("/html/body/div[12]/div[3]/div/button");
public SelenideElement btnAgregarM3 = $x("//*[@id=\"botonAgregarM3\"]");
public SelenideElement btnAceptar3 = $x("/html/body/div[13]/div[3]/div/button");
public SelenideElement btnAgregarM2 = $x("//*[@id=\"botonAgregarM2\"]");
public SelenideElement btnAceptar4 = $x("/html/body/div[14]/div[3]/div/button");
public SelenideElement btnAgregarM1 = $x("//*[@id=\"botonAgregarM1\"]");
public SelenideElement btnAceptar5 = $x("/html/body/div[15]/div[3]/div/button");
    //Datos del aviso
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[9]/td[2]/div/input[2]");
    public SelenideElement archivo1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = $x("/html/body/main/div/div[4]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");

    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
}
