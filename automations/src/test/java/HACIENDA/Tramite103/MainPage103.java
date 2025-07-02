package HACIENDA.Tramite103;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage103 {

    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement AutorizacionesImporExpor = $x("//*[@id=\"servicios\"]/ul/li[1]/a/span");
    public SelenideElement ExcencionImpuestosMercaDonada = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[1]/a");
    public SelenideElement elementoTramite103 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");

    //Paso 1 CAPTURAR SOLICITUD
    //Pestaña Exención impuestos
    public SelenideElement tabDatosInmueble = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
    //Check Manifiesto
    public SelenideElement checkManifiestoMercancia = $x("//*[@id=\"manifiesto0\"]");
    //Aduana
    public SelenideElement selectAduana = $x("//*[@id=\"cveAduana\"]");
    public SelenideElement checkOrganismoPublico = $x("//*[@id=\"checkBoxOP\"]");

    //Mercancías
    public SelenideElement selectFinDestinoMercancia = $x("//*[@id=\"fines\"]");
    //Agregar/Modificar Mercancía
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"tabs-2\"]/div[9]/input[3]");
    public SelenideElement btnModificarMercancia = $x("//*[@id=\"tabs-2\"]/div[9]/input[1]");
    //Datos mercancia
    public SelenideElement TipoMercancia = $x("//*[@id=\"descripcionMerc\"]");
    public SelenideElement UsoEspecifico = $x("//*[@id=\"usoEspecifico\"]");
    public SelenideElement selectCondicion = $x("//*[@id=\"condicionMercancia\"]");
    public SelenideElement Cantidad = $x("//*[@id=\"cantidadComercial\"]");
    public SelenideElement UnidadMedida = $x("//*[@id=\"unidadMedidaComercial\"]");
    public SelenideElement checkVehiculo = $x("//*[@id=\"checkBoxVehiculo\"]");
    public SelenideElement Marca = $x("//*[@id=\"marca\"]");
    public SelenideElement selectAno = $x("//*[@id=\"anio\"]");
    public SelenideElement Modelo = $x("//*[@id=\"modelo\"]");
    public SelenideElement NumSerie = $x("//*[@id=\"serie\"]");
    public SelenideElement btnAgregarInfMercancia = $x("//*[@id=\"btnAgregarMercancia\"]");
    public SelenideElement btnAceptarMercancia = $x("/html/body/div[9]/div[3]/div/button");


    //Datos del donante extranjero
    public SelenideElement NombreDonante = $x("//*[@id=\"solicitud.donante.razonSocial\"]");
    public SelenideElement checkPersonaFisicaDonante = $x("//*[@id=\"checkBoxPF\"]");
    public SelenideElement selectPaisDonante = $x("//*[@id=\"cvePaisId\"]");
    public SelenideElement CodigoPostalDonante = $x("//*[@id=\"solicitud.donante.domicilio.codigoPostal\"]");
    public SelenideElement EstadoDonante = $x("//*[@id=\"solicitud.donante.domicilio.informacionExtra\"]");
    public SelenideElement CalleDonante = $x("//*[@id=\"solicitud.donante.domicilio.calle\"]");
    public SelenideElement NumExteriorDonante = $x("//*[@id=\"solicitud.donante.domicilio.numeroExterior\"]");
    public SelenideElement NumInteriorDonante = $x("//*[@id=\"tabs-2\"]/div[13]/div[3]/div/input");
    public SelenideElement ColoniaDonante = $x("//*[@id=\"solicitud.donante.domicilio.ciudad\"]");
    public SelenideElement CorreoDonante = $x("//*[@id=\"tabs-2\"]/div[14]/div[2]/div/input");
    public SelenideElement TelefonoDonante = $x("//*[@id=\"tabs-2\"]/div[14]/div[3]/div/input");

    //Continuar paso 1
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");

    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]"); //  /html/body/div[8]/div[1]
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");

}
