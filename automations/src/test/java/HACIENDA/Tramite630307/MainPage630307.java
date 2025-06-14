package HACIENDA.Tramite630307;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
// public SelenideElement nombreElemento = $x("");
public class MainPage630307 {

    //Tramite 630104
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Selección rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement ImportacionMercanciaSinPedimento = $x("//*[@id=\"servicios\"]/ul/li[16]/a/span");
    public SelenideElement Retorno = $x("//*[@id=\"servicios\"]/ul/li[16]/ul/li[2]/a/span");
    public SelenideElement elementoTramite630307 = $x("//*[@id=\"servicios\"]/ul/li[16]/ul/li[2]/ul/li[3]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Datos de la Solicitud
    public SelenideElement tabDatosSolicitud= $x("//*[@id=\"ui-id-2\"]/label");
    //Datos de la solicitud
    public SelenideElement selectAduanaRetorno = $x("//*[@id=\"datosImportacionTemporal.cveAduana\"]");
    public SelenideElement selectSeccionAduanaRetorno = $x("//*[@id=\"datosImportacionTemporal.cveSeccionAduanal\"]");
    public SelenideElement fechaEstimadaLimiteRetorno = $x("//*[@id=\"fechaIngreso\"]");
    public SelenideElement selectCuentaProrroga = $x("//*[@id=\"datosImportacionTemporal.cuentaProrroga\"]");

    //Selección Si cuenta prorroga
    //Información general de la prórroga (formato en papel)
    public SelenideElement FolioProrroga = $x("//*[@id=\"folioProrrogaImportacionTemporal\"]");
    public SelenideElement fechaInicioProrroga = $x("//*[@id=\"fechaIngresoRetornoProrroga\"]");
    public SelenideElement fechaVencimientoProrroga = $x("//*[@id=\"fechaRetornoVencimientoProrroga\"]");

    //Selección No cuenta prorroga
    //Información general de la autorización (formato en papel)
    public SelenideElement FolioAutorizacionImpPapel = $x("//*[@id=\"generalAutorizacion\"]/div[2]/div[1]/div/input");
    public SelenideElement selectAduanaIngreso = $x("//*[@id=\"datosImportacionTemporal.datosImportacionRetornoGeneral.aduanaIngreso\"]");
    public SelenideElement selectSeccionAduanera = $x("//*[@id=\"datosImportacionTemporal.datosImportacionRetornoGeneral.seccionAduanera\"]");
    public SelenideElement fechaIngreso = $x("//*[@id=\"fechaIngresoRetorno\"]");
    public SelenideElement fechaVencimiento = $x("//*[@id=\"fechaRetornoVencimiento\"]");


    //Tipo de propietario
    public SelenideElement selectPropietario= $x("//*[@id=\"ddlTipoPropietario\"]");
    //Elementos No es propietario
    public SelenideElement selectTipoPropietario = $x("//*[@id=\"ddlTipoPersona\"]");
    public SelenideElement PropietarioNombre = $x("//*[@id=\"nombre\"]");
    public SelenideElement PropietarioApellidoPaterno = $x("//*[@id=\"apellidoPaterno\"]");
    public SelenideElement PropietarioApellidoMaterno = $x("//*[@id=\"apellidoMaterno\"]");
    public SelenideElement PropietarioDenominacion = $x("//*[@id=\"razonSocial\"]");
    public SelenideElement PropietarioCalle = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.calle\"]");
    public SelenideElement PropietarioNumExterior = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.numeroExterior\"]");
    public SelenideElement PropietarioNumInterior = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.numeroInterior\"]");
    public SelenideElement selectPropietarioPais = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.pais\"]");
    public SelenideElement PropietarioLocalidad = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.estadoLocalidad\"]");
    public SelenideElement PropietarioCorreoElec = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.correoElectronico\"]");
    public SelenideElement PropietarioTelefono = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.telefono\"]");
    public SelenideElement PropiedadCodPostal = $x("//*[@id=\"datosImportacionTemporal.datosNoPropietario.codigoPostal\"]");

    //Datos de la mercancía que se importará al país temporalmente
    public SelenideElement MarcaMercancia = $x("//*[@id=\"numeroPedimentoTMarca\"]");
    public SelenideElement ModeloMercancia = $x("//*[@id=\"numeroPedimentoTModelo\"]");
    public SelenideElement NumSerieMercancia = $x("//*[@id=\"numeroPedimentoTNúmero\"]");
    public SelenideElement NumMotorMercancia = $x("//*[@id=\"numeroPedimentoTMotor\"]");
    public SelenideElement DescripcionMercancia = $x("//*[@id=\"datosAviacionDescripcionMercancia\"]");
    public SelenideElement MotivacionMercancia = $x("//*[@id=\"datosImportacionTemporal.datosMercancia.motivo\"]");

    //Manifiesto
    public SelenideElement checkManifiesto = $x("//*[@id=\"declaracion[0]\"]");
    //Continuar Paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[9]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");

    //Continuar
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

}
