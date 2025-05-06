package COFEPRIS.Tramite260401;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage260401 {
    ///Ruta al Tramite 2560402
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Cofepris = $x("/html/body/main/div/div[3]/div/form/a[3]/img");
    public SelenideElement CertiLicPer = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement PermisosInterSalidaProdHumano = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[4]/a");
    public SelenideElement Tramite260401 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[4]/ul/li[1]/a");
    //DATOS SOLICITUD
    public SelenideElement labelDatosSolicitud = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[2]/a/label");
    public SelenideElement btnAgregarPropietario = $x("//*[@id=\"agregarTercero_TIPERS_PRO\"]");
    public SelenideElement CheckNacional = $x("//*[@id=\"terceros_nacionalidadMexicana\"]");
    public SelenideElement CheckPerFisica = $x("//*[@id=\"terceros_tipoPersonaFisica\"]");
    public SelenideElement rfcPropietario = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement btnBuscarRFC = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[1]/fieldset/div[3]/div[1]/div[4]/div[1]/div/button");
    public SelenideElement btnGuardarPropietario = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    ///Datos del establecimiento
    public SelenideElement DenomiSocial = $x("//*[@id=\"solicitud.establecimiento.razonSocial\"]");
    public SelenideElement Correo = $x("//*[@id=\"solicitud.establecimiento.correoElectronico\"]");
    public SelenideElement CP = $x("//*[@id=\"solicitud.establecimiento.domicilio.codigoPostal\"]");
    public SelenideElement Estado = $x("//*[@id=\"solicitud.establecimiento.domicilio.entidadFederativa.clave\"]");
    public SelenideElement MunAlcald = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionMunicipio\"]");
    public SelenideElement Localidad = $x("//*[@id=\"solicitud.establecimiento.domicilio.informacionExtra\"]");
    public SelenideElement Colonia = $x("//*[@id=\"solicitud.establecimiento.domicilio.descripcionColonia\"]");
    public SelenideElement CalleEs = $x("//*[@id=\"solicitud.establecimiento.domicilio.calle\"]");
    public SelenideElement Lada = $x("//*[@id=\"solicitud.establecimiento.domicilio.lada\"]");
    public SelenideElement Telefono = $x("//*[@id=\"solicitud.establecimiento.domicilio.telefono\"]");
    ///SCIAN
    public SelenideElement btnAgregarSCIAN = $x("//*[@id=\"btnScianAgregar\"]");
    public SelenideElement ClaveSCIAN = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[1]/div[2]/div/select");
    public SelenideElement btnAgregarSCIANOK = $x("/html/body/main/div[1]/div[4]/div[4]/form/div[1]/div[4]/div[2]/div/input[3]");
    ///Formulario
    public SelenideElement rfcResponsable = $x("//*[@id=\"solicitud_rfcCertificador\"]");
    public SelenideElement nombreResponsable = $x("//*[@id=\"solicitud_descripcionCertificador\"]");
    public SelenideElement nLicSani = $x("//*[@id=\"numeroLicenciaSanitaria\"]");
    public SelenideElement btnAgregarLicSani = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[16]/div[2]/div[1]/div[2]/div/input");
    public SelenideElement regiDestMerca = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[17]/div[1]/div/select");
    public SelenideElement AduanaEntrada = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[17]/div[2]/div/select");
    public SelenideElement btnAgregarProducto = $x("//*[@id=\"btnagregarAduana\"]");
    public SelenideElement nombreEspecifico = $x("//*[@id=\"idDenominacionEspecifica\"]");
    public SelenideElement tipoProductoMerca = $x("//*[@id=\"mercanciaGrid.tipoProducto.idTipoProductoTipoTramite\"]");
    public SelenideElement fracArancel = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement cantidadUMTPro = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement cantidadVol = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement unIdadMedida = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[2]/div[8]/div[2]/div/select");
    public SelenideElement PresFarmaEnv = $x("//*[@id=\"presentacion\"]");
    public SelenideElement EnvprimarioAl = $x("//*[@id=\"condicionAlmacenamientoPrimario\"]");
    public SelenideElement EnvSecundariAl = $x("//*[@id=\"condicionAlmacenamientoSecundario\"]");
    public SelenideElement EnvprimarioCT = $x("//*[@id=\"condicionTransPrimario\"]");
    public SelenideElement EnvSecundariTC = $x("//*[@id=\"condicionTransSecundario\"]");
    public SelenideElement PaisOrgClick1 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[1]/button");
    public SelenideElement PaisOrgAntartida2 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[1]/div[2]/select/option[6]");
    public SelenideElement PaisOrgClick3 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[1]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement PaisOrgClick4 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[1]/button");
    public SelenideElement PaisOrgAntartida5 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[1]/div[2]/select/option[7]");
    public SelenideElement PaisOrgANGUILA6 = $x("/html/body/main/div[1]/div[4]/div[5]/form/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div/input[2]");
    public SelenideElement usEspesific = $x("//*[@id=\"mercanciaGrid.clavesUsosEspecificos\"]");
    public SelenideElement btnAgregarUsEspecifico = $x("//*[@id=\"btnAgregarMercancia\"]");
    ///Manifiesto y Representante Legal
    public SelenideElement CheckManifiesto = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[24]/div/div/div/div[1]/div[1]/div/input");
    public SelenideElement CheckNo = $x("//*[@id=\"informacionConfidencialNo\"]");
    public SelenideElement RFCRepreLegal = $x("//*[@id=\"representanteLegalRFC\"]");
    public SelenideElement btnBuscarRfcRepreLegal = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/div/div[2]/div[27]/div[2]/input");
    public SelenideElement labelTercerosRelacionados = $x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[3]/a/label");
    public SelenideElement inputAgregarTercero = $x("//*[@id=\"agregarTercero_TIPERS_DES\"]");
    public SelenideElement inputPersonaMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    //public SelenideElement inputTerceroRFC = $x("//*[@id=\"terceros_rfc\"]");
    public SelenideElement inputTerceroRazonSocial = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement inputPais = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement terceroEstadoLocalidad = $x("//*[@id=\"terceros_txtEstadoLocalidad\"]");
    public SelenideElement terceroCodigoPostal = $x("//*[@id=\"terceros_codPostal\"]");
    public SelenideElement terceroColoniaEquiv = $x("//*[@id=\"terceros_coloniaEquiv\"]");
    public SelenideElement terceroCalle = $x("//*[@id=\"terceros_calle\"]");
    public SelenideElement terceroNumExterior = $x("//*[@id=\"terceros_numExterior\"]");
    public SelenideElement terceroNumInterior = $x("//*[@id=\"terceros_numInterior\"]");
    public SelenideElement terceroLada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement terceroTelefono = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement terceroCorreo = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardarDatosTerceros = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos =$x("/html/body/main/div[1]/div[4]/div[1]/form/div[2]/ul/li[4]/a/label");
    public SelenideElement inputSolicitudPagoClaveReferencia = $x("//*[@id='solicitud.pago.claveDeReferencia']");
    public SelenideElement inputSolicitudPagoCadenaDependencia = $x("//*[@id='solicitud.pago.cadenaPagoDependencia']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    public SelenideElement inputSolicitudPagoImp = $x("//*[@id='solicitud.pago.impPago']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement inputAdjuntar = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[11]/td[2]/div/input[2]");
    //ADJUNTAR
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
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
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement inputSiguiente = $x("/html/body/main/div/div[4]/div[1]/form[2]/div[2]/div/input[2]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
}
