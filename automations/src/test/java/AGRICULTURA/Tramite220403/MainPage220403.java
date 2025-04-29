package AGRICULTURA.Tramite220403;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage220403 {
    //Tramite 220403 Generar Oficio
    //LOGIN
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");

    //RUTA TRAMITE
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement agriCultura = $x("//*[@id=\"workingArea\"]/form/a[10]/img");
    public SelenideElement certSoliReq = $x("//*[@id=\"servicios\"]/ul/li/a");
    public SelenideElement cerExport = $x("//*[@id=\"servicios\"]/ul/li/ul/li[3]/a");
    public SelenideElement tramite220403 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/ul/li[3]/a");

    public SelenideElement DatosDeSoLI = $x("//*[@id=\"ui-id-2\"]/label");
    //llenado de la solicitud
    public SelenideElement checkAnimal = $x("//*[@id=\"tipoMercanciaA\"]");
    public SelenideElement aduana = $x("//*[@id=\"solicitud.claveAduana\"]");
    public SelenideElement numConten = $x("//*[@id=\"tabs-2\"]/div[5]/div[2]/div[2]/input");
    public SelenideElement paisOrig = $x("//*[@id=\"solicitud.paisOrigenSagarpa.clave\"]");
    public SelenideElement entidFede = $x("//*[@id=\"solicitud.entidadOrigen.clave\"]");
    public SelenideElement munDeOrig = $x("//*[@id=\"solicitud.municipioOrigen.clave\"]");
    public SelenideElement puntoIngres = $x("//*[@id=\"tabs-2\"]/div[7]/div/div[2]/input");

    //Combinación requerida
    public SelenideElement especie = $x("//*[@id=\"solicitud.catalogoD.clave\"]");
    public SelenideElement paisDestino = $x("//*[@id=\"solicitud.paisProcedencia.clave\"]");
    public SelenideElement nombreEmpresa = $x("//*[@id=\"solicitud.empresaGobierno.empresa\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"btnAgregarMercanciasA\"]");

    //Datos Generales de la Mercancía Animales
    public SelenideElement fracAran = $x("//*[@id=\"fraccionArancelaria\"]");
    public SelenideElement descrip = $x("//*[@id=\"mostrarDescripcionFraccionUsuario\"]");
    public SelenideElement cantidadUMC = $x("//*[@id=\"cantidadUMC\"]");
    public SelenideElement cantidadUMT = $x("//*[@id=\"cantidadUMT\"]");
    public SelenideElement uMC = $x("//*[@id=\"mercanciaGrid.unidadMedidaComercial.clave\"]");
    public SelenideElement tipMerca = $x("//*[@id=\"mercanciaGrid.idTipoMercancia\"]");
    public SelenideElement uso = $x("//*[@id=\"mercanciaGrid.idUso\"]");
    public SelenideElement nombreC = $x("//*[@id=\"nombreCientifico\"]");
    public SelenideElement nombreCoun = $x("//*[@id=\"nombreComun\"]");
    public SelenideElement faseDes = $x("//*[@id=\"faseDesarrollo\"]");
    public SelenideElement pres = $x("//*[@id=\"presentacion\"]");
    public SelenideElement paisProc = $x("//*[@id=\"mercanciaGrid.clavesPaisesProcedencia\"]");
    public SelenideElement btnAgregarAnimal = $x("//*[@id=\"btnAgregarMercancia\"]");

    //Transporte
    public SelenideElement pestTransporte = $x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement mTransport = $x("//*[@id=\"solicitud.transporte.ideMedioTransporte\"]");
    public SelenideElement idDeTransport = $x("//*[@id=\"identificacionTransporte\"]");
    public SelenideElement nContenedor = $x("//*[@id=\"tabs-3\"]/div[1]/div[3]/div[2]/input");
    public SelenideElement nRazonSocial = $x("//*[@id=\"tabs-3\"]/div[2]/div[1]/div[2]/input");
    public SelenideElement numFlet = $x("//*[@id=\"tabs-3\"]/div[2]/div[2]/div[2]/input");

    //Pago de derechos
    public SelenideElement pestaPago = $x("//*[@id=\"ui-id-4\"]/label");
    public SelenideElement banco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement CalendarioFechaPago = $x("//*[@id=\"calendarTo\"]");

    //Terceros relacionados
    public SelenideElement pestaTerceRelacio = $x("//*[@id=\"ui-id-5\"]/label");
    public SelenideElement btnAgregarTercerR = $x("//*[@id=\"agregarTercero_TIPERS_IMP\"]");
    public SelenideElement checkMoral = $x("//*[@id=\"terceros_tipoPersonaMoral\"]");
    public SelenideElement nomRazSocTercer = $x("//*[@id=\"terceros_rSocial\"]");
    public SelenideElement paisTercer = $x("//*[@id=\"terceros_selectPais\"]");
    public SelenideElement domTercer = $x("//*[@id=\"terceros_domicilioExtranjero\"]");
    public SelenideElement lada = $x("//*[@id=\"terceros_lada\"]");
    public SelenideElement tel = $x("//*[@id=\"terceros_telefono\"]");
    public SelenideElement correo = $x("//*[@id=\"terceros_correoElec\"]");
    public SelenideElement btnGuardar = $x("//*[@id=\"btnGuardarFrmDatosTercero\"]");
    public SelenideElement btnConti = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnConti2 = $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");

    //Firmna
    public SelenideElement cer = $x("//*[@id='certificate']");
    public SelenideElement key = $x("//*[@id='privateKey']");
    public SelenideElement pas= $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngre = $x("//*[@id=\"btnSubmit\"]");



}
