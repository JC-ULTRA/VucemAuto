package Economia.Tramite130120;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage130120 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");

    public SelenideElement btnIngresFs = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = Selenide.$x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Permisos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement Importacion = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement Tramite130120 = Selenide.$x("//a[contains(@onclick, 'nicio')]");
    //Scroll
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement DatosSolicitud = Selenide.$x("//*[@id='ui-id-2']");
    public SelenideElement selectSolicitudRegimenClave = Selenide.$x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectClasificacionRegimen = Selenide.$x("//*[@id='solicitud.claveClasificacionRegimen']");
    public SelenideElement textareaSolicitudMercanciaDescripcion = Selenide.$x("//*[@id='solicitud.mercancia.descripcion']");
    public SelenideElement inputSolicitudMercanciaMarca = Selenide.$x("//*[@id='solicitud.mercancia.marca']");
    public SelenideElement inputSolicitudAduana = Selenide.$x("//*[@id='solicitud.mercancia.tipoAduana.clave']");
    public SelenideElement optionLasDem = Selenide.$x("//option[@value='51099099']");
    public SelenideElement optionLosDem = Selenide.$x("//option[@value='5109909900']");
    public SelenideElement optionUnidadMedida = Selenide.$x("//*[@id='solicitud.mercancia.unidadMedidaTarifaria.clave']");
    public SelenideElement inputSolicitudMercanciaNumeroFactura = Selenide.$x("//*[@id='solicitud.mercancia.numeroFactura']");
    public SelenideElement inputFechaFactura = Selenide.$x("//*[@id='fechaFactura']");
    public SelenideElement optionAbsorcion = Selenide.$x("//option[@value='63_R21']");
    public SelenideElement inputSolicitudMercanciaCantidadComercial = Selenide.$x("//*[@id='solicitud.mercancia.cantidadComercial']");
    public SelenideElement inputSolicitudMercanciaCapacidad = Selenide.$x("//*[@id='solicitud.mercancia.capacidad']");
    public SelenideElement inputSolicitudMercanciaValorFactura = Selenide.$x("//*[@id='solicitud.mercancia.valorFactura']");
    public SelenideElement optionDinar = Selenide.$x("//option[@value='KWD']");
    public SelenideElement optionPaisExp = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[2]/div[15]/div[1]/select/option[4]");
    public SelenideElement optionPaisOri = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div[2]/div[2]/div[15]/div[2]/select/option[2]");
    public SelenideElement inputSolicitudMercanciaValorTotal = Selenide.$x("//*[@id='solicitud.mercancia.valorTotalFacturaDolares']");
    public SelenideElement inputSolicitudNumDocumento = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.descripcionGenerica1']");
    public SelenideElement inputFechaGenerica = Selenide.$x("//*[@id='fechaGenerica1']");
    public SelenideElement textareaSolicitudDatosGenericosDescripcion = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.descripcionGenerica2']");
    public SelenideElement inputSolicitudCodigoAran = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.descripcionGenerica3']");
    public SelenideElement inputSolicitudCantidadUnidadMedida = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.numGenerico1']");
    public SelenideElement inputSolicitudValorUSD = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.numGenerico2']");
    public SelenideElement inputSolicitudPrecioUnitario = Selenide.$x("//*[@id='solicitud.datosGenericosSolicitud.numGenerico3']");
    public SelenideElement inputNinguno = Selenide.$x("//*[@id='tNinguno']");
    public SelenideElement textareaSolicitudDomicilio = Selenide.$x("//*[@id='solicitud.productor.domicilio.descripcionUbicacion']");
    public SelenideElement inputMoral = Selenide.$x("//*[@id='pMoralE']");
    public SelenideElement inputSolicitudExpRazonSocial = Selenide.$x("//*[@id='solicitud.exportador.razonSocial']");
    public SelenideElement textareaSolicitudExportadorDomicilioDes = Selenide.$x("//*[@id='solicitud.exportador.domicilio.descripcionUbicacion']");
    public SelenideElement textareaSolicitudObservaciones = Selenide.$x("//*[@id='solicitud.observaciones']");
    public SelenideElement optionSin = Selenide.$x("//option[@value='SIN']");
    public SelenideElement optionCuliacan = Selenide.$x("//option[@value='2540']");
    public SelenideElement inputGuardarSolicitud = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement inputContinuar = Selenide.$x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = Selenide.$x("//input[contains(@style, '0px;')]");
    public SelenideElement inputDocumentosFile = Selenide.$x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile2 = Selenide.$x("//input[@name='documentos[1].file']");
    public SelenideElement inputAnexar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = Selenide.$x("//*[@id='siguienteButton']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");

    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Solo Firma Funcionario
    public SelenideElement cerfF = $x("//*[@id='certificate']");
    public SelenideElement keyfF = $x("//*[@id='privateKey']");
    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");


    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //INICIO
    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    public SelenideElement AntecendentesTextoDictamen = $x("//*[@id='textoDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");

    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement sentidoAceptado = $x("//*[@id=\"sentidoDictamen\"]");
    public SelenideElement antecedentesDict = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement btnFirmarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[1]");
    public SelenideElement btnAutorizar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/input[2]");


}
