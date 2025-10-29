package MedioAmbiente.Tramite230101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage230101 {
    //Tramite Aviso 230101
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement MedioAmbiente = $x("//img[contains(@alt, 'Medio')]");
    public SelenideElement CertLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement RequisitosFito = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[1]/a");
    public SelenideElement CertFitoImport = $x("//a[@onclick=\"javascript:callMenuTramite('/ventanilla-gubernamentales-HA/invocarModulo.action?init','/ventanilla-gubernamentales-HA//gubernamentales2/semarnat/certificadoFitosanitarioImportacion/solCFI.action?solicitud.discriminatorValue=230101&iniciar','230101','','')\"]");

    public SelenideElement DatosSolicitud = $x("//label[@for='solicitud.titulo']");
    public SelenideElement TipoRegimen = $x("//input[@checked='checked']");
    public SelenideElement optionAcapulcoAeropuerto = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/div[1]/div[2]/select/option[1]");
    public SelenideElement AddlistaOrigen1 = $x("//*[@id='addlistaOrigen1']");
    public SelenideElement optionAeropuertoIntMexico = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[4]/div[2]/div/div/div/div[1]/div[2]/select/option[2]");
    public SelenideElement AddlistaOrigen2 = $x("//*[@id='addlistaOrigen1']");
    public SelenideElement selectTipoProducto = $x("//*[@id='solicitud.ideGenerica2']");
    public SelenideElement optionAlbaniaRepublica = $x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div/div/div[7]/div[2]/div/div[1]/div[2]/select/option[2]");
    public SelenideElement AddlistaOrigen = $x("//*[@id='addlistaOrigen2']");
    public SelenideElement selectPaisProcedencia = $x("//*[@id='solicitud.paisProcedenciaSemarnat.clave']");

    //Destino dentro del pais
    public SelenideElement optionVeracruz = $x("//option[@value='VER']");
    public SelenideElement inputAddlistaOrigen = $x("//*[@id='addlistaOrigen3']");
    public SelenideElement TodoTerritorio = $x("//*[@id='isTodoTerritorio']");
    public SelenideElement optionFraccionesNicas = $x("//option[@value='0']");
    public SelenideElement AgregarMercancias = $x("//input[@name='agregarAduana']");
    public SelenideElement FraccionArancelaria = $x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
    public SelenideElement inputCantidadUmc = $x("//*[@id='cantidadUMC']");
    public SelenideElement selectMercanciaGenero = $x("//*[@id='mercanciaGrid.genero']");
    public SelenideElement selectMercanciaEspecie = $x("//*[@id='mercanciaGrid.especie']");
    public SelenideElement NombreComun = $x("//*[@id='mercanciaGrid.nombreComun.clave']");
    public SelenideElement AgregarDetalleMercancias = $x("//input[@name='agregarDetalle']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btnAgregarMercancia']");
    public SelenideElement selectDescripcionProducto = $x("//*[@id=\"solicitud.descripcionProducto.idDescripcionProducto\"]");
    public SelenideElement optionKilogramo = $x("/html/body/main/div/div[4]/div[1]/form/div[2]/div[2]/div/div/div[17]/div[3]/div/select/option[2]");
    public SelenideElement inputDeclaracion = $x("//*[@id='declaracion[0]']");

    //Pestaña Pago de Derecho
    public SelenideElement PagoDerechos = $x("//label[@for='captura.tab.pagoDerechos']");
    public SelenideElement BancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");

    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    public SelenideElement pasarDocs = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnPasarFirma = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");

    //Funcionario
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolioFun = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement opinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement anexarInfoDigitalizada = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div/div/table[2]/tbody/tr[1]/td[2]/input");
    public SelenideElement archivoAnexar = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement enviarArchivo = $x("//*[@id=\"btnCargaArchivo\"]");
    public SelenideElement destinadoPara = $x("//*[@id=\"tramite.dictamen.usoAutorizadoDictamen\"]");
    public SelenideElement observaciones = $x("//*[@id=\"observacion\"]");
    public SelenideElement plazo = $x("//*[@id=\"tramite.dictamen.plazoVigencia\"]");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[3]");
    public SelenideElement darVoBo = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement firmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[1]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
    public SelenideElement objetoImportacion = $x("//*[@id=\"objetoImportacion\"]");
    public SelenideElement restricciones = $x("//*[@id=\"tramite.dictamen.restriccionesDictamen[0].restriccionTipoTramite.idRestriccionTipoTramite\"]");
    public SelenideElement componentes = $x("//*[@id=\"descripcionDetalladaMercancia\"]");
    public SelenideElement clasificacionToxicologica = $x("//*[@id=\"tramite.dictamen.clasificacionToxicologica.idClasificacionToxicologicaTipoTramite\"]");
    public SelenideElement usoEspecificoMercancia = $x("//*[@id=\"descripcionUsoAutorizado\"]");
    public SelenideElement siglasDictaminador = $x("//*[@id=\"siglasDictaminador\"]");
    public SelenideElement deseaEstablecerFecha = $x("//*[@id=\"blnGenerico1\"]");
    public SelenideElement requisitosTodos = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[4]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/a/input");
    public SelenideElement parrafosTodos = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[4]/table/tbody/tr[6]/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/a/input");

}
