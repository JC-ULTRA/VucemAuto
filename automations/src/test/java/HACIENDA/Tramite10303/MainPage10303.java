package HACIENDA.Tramite10303;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage10303 {
    //Tramite Aviso 10303
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement AutorizacionesImportadorExportador = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement ExenciImpuestosComercioExterior = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement TramiteDonaciMercancia = $x("//a[contains(@onclick, 'donaciones')]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Pestaña de registro de donación
    public SelenideElement RegistroDonaci = $x("//label[@for='captura.tab.solicitud']");
    public SelenideElement DonanteExtranjero = $x("//*[@id='manifiesto0']");
    public SelenideElement DonantePropietario = $x("//*[@id='manifiesto1']");
    public SelenideElement MercanciaEstado = $x("//*[@id='manifiesto2']");
    public SelenideElement MercanciaNoComer = $x("//*[@id='manifiesto3']");
    public SelenideElement ManifiestoVerdad = $x("//*[@id='manifiesto4']");
    public SelenideElement selectAduana = $x("//*[@id='cveAduana']");
    public SelenideElement Alimentacion = $x("//*[@id='reqBasicoAlimentacion']");
    public SelenideElement BasicoEducacion = $x("//*[@id='reqBasicoEducacion']");
    public SelenideElement BasicoProteccionCivil = $x("//*[@id='reqBasicoProteccionCivil']");
    public SelenideElement BasicoSalud = $x("//*[@id='reqBasicoSalud']");
    public SelenideElement BasicoVestido = $x("//*[@id='reqBasicoVestido']");
    public SelenideElement BasicoVivienda = $x("//*[@id='reqBasicoVivienda']");
    public SelenideElement AgregarMercancias = $x("//input[@name='agregarMercancias']");
    public SelenideElement selectDestino = $x("//*[@id='destinoDonacion']");
    public SelenideElement PosibleFraccion = $x("//*[@id='posibleFraccion']");
    public SelenideElement OpcionPermisoNo = $x("//*[@id='opcionNoPermisos']");
    public SelenideElement JustificacionMerca = $x("//*[@id='justificacionMerca']");
    public SelenideElement DescripcionMercanciaOtro = $x("//*[@id='descripcionMercanciaOtro']");
    public SelenideElement selectTipoMercancia = $x("//*[@id='tipoMercancia']");
    public SelenideElement CantidadUMC = $x("//*[@id='cantidadUMC']");
    public SelenideElement CantidadUMT  = $x("//*[@id='cantidadUMT']");
    public SelenideElement UMC = $x("//*[@id='unidadMedida']");
    public SelenideElement UMT = $x("//*[@id='UMT']");
    public SelenideElement selectPaisProcedenciaOtro = $x("//*[@id='cvePaisProcedenciaOtro']");
    public SelenideElement selectCondicionMercanciaOtro = $x("//*[@id='condicionMercanciaOtro']");
    public SelenideElement AgregarMerc = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement buttonAceptar = $x("//button[contains(@class, 'btn')]");

    //Datos del donante extranjero
    public SelenideElement DatosdeDonanteExt = $x("//button[@href='#panel-donanteExtranjero']");
    public SelenideElement NomDonExt = $x("//*[@id='nombreDonante']");
    public SelenideElement CalleDonExt = $x("//*[@id='calleDonante']");
    public SelenideElement NumExteriorDonante = $x("//*[@id='numExteriorDonante']");
    public SelenideElement NumInteriorDonante = $x("//*[@id='numInteriorDonante']");
    public SelenideElement selectPaisDonante = $x("//*[@id='cvePaisDonante']");
    public SelenideElement CodigoPostalDonante = $x("//*[@id='codigoPostalDonante']");
    public SelenideElement EstadoDonante = $x("//*[@id='estadoDonante']");
    public SelenideElement RegionDonante = $x("//*[@id='coloniaDonante']");
    public SelenideElement CorreoElectronicoDonante = $x("//*[@id='correoElectronicoDonante']");
    public SelenideElement TelefonoDonante = $x("//*[@id='telefonoDonante']");
    public SelenideElement selectDocumentoResidencia = $x("//*[@id='cveDocumentoResidencia']");
    
    //Datos del donatario
    public SelenideElement DatosDonatario = $x("//button[@href='#panel-donatario']");
    public SelenideElement inputDonatario = $x("//*[@id='rfcDonatario']");

    //Datos del representante legal del donatario
    public SelenideElement DatosRepreLegalDonatario = $x("//button[@href='#panel-repLegalDonatario']");
    public SelenideElement inputRepLegalDonatario = $x("//*[@id='rfcRepLegalDonatario']");
    
    //Datos del representante legal autorizado para recibir la donación
    public SelenideElement DatosRepreLegRecDonaciones = $x("//button[@href='#panel-repLegalRecibirDonacion']");
    public SelenideElement inputRepLegalAutorizado = $x("//*[@id='rfcRepLegalAutorizado']");
    
    //Datos de la persona autorizada para oír y recibir notificaciones
    public SelenideElement DatosPersOirNoti = $x("//button[@href='#panel-personaRecibirOir']");

    public SelenideElement inputPersonaAutorizada = $x("//*[@id='rfcPersonaAutorizada']");

    //Continuar paso 2
    public SelenideElement ContinuarSolicitud = $x("//*[@id='guardarSolicitud']");

    //Requisitos 
    public SelenideElement ReqOpcionales = $x("//*[@id='cb_jqgridDoctosEspecificos']");
    public SelenideElement inputDeleteButton = $x("//*[@id='deleteButton']");
    
    //Continuar paso 3
    public SelenideElement inputContinuarPaso3 = $x("//input[@value='Continuar']");
    public SelenideElement AdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile1 = $x("//input[@name='documentos[1].file']");
    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[2].file']");
    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[3].file']");
    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[4].file']");
    public SelenideElement inputDocumentosFile5 = $x("//input[@name='documentos[5].file']");
    public SelenideElement inputDocumentosFile6 = $x("//input[@name='documentos[6].file']");
    public SelenideElement inputDocumentosFile7 = $x("//input[@name='documentos[7].file']");

    public SelenideElement inputAnexar = $x("//*[@id='btnAnexar']");

    public SelenideElement inputCerrar = $x("//*[@id='btnCerrar']");

    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");

    













}
