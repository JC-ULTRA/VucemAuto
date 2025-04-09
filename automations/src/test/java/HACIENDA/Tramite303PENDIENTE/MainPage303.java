package HACIENDA.Tramite303PENDIENTE;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage303 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x(" /html/body/main/div/div[3]/div/form/a[1]");
    public SelenideElement linkResgistroComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement linkRegistroDelDespachoMercanc = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[1]/a");
//DESPACHO DE MERCANCIA
    public SelenideElement labelDespachoMercanc = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement inputPregunta = $x("//*[@id='idSiPregunta1']");
    public SelenideElement inputPregunta2 = $x("//*[@id='idNoPregunta1']");
    public SelenideElement inputPregunta3 = $x("//*[@id='idSiPregunta2']");
    public SelenideElement inputPregunta4 = $x("//*[@id='idNoPregunta2']");
    public SelenideElement inputPregunta5 = $x("//*[@id='idSiPregunta5']");
    public SelenideElement inputPregunta6 = $x("//*[@id='idNoPregunta5']");
    public SelenideElement inputPregunta7 = $x("//*[@id='idSiPregunta3']");
    public SelenideElement inputPregunta8 = $x("//*[@id='idNoPregunta3']");
    public SelenideElement inputPregunta9 = $x("//*[@id='idSiPregunta4']");
    public SelenideElement inputPregunta10 = $x("//*[@id='idNoPregunta4']");
    public SelenideElement inputPregunta11 = $x("//*[@id='idSiPregunta6']");
    public SelenideElement inputPregunta12 = $x("//*[@id='idNoPregunta6']");
    public SelenideElement inputConProgramaImmex = $x("//*[@id='conProgramaImmex']");
    public SelenideElement inputSinProgramaImmex = $x("//*[@id='sinProgramaImmex']");
    public SelenideElement selectSolicitudResolucion = $x("//*[@id='solicitud.resolucionSolicitud.resolucion.idResolucion']");
    public SelenideElement selectComboAgenteApoderado = $x("//*[@id='comboAgenteApoderado']");
    public SelenideElement inputAgregarAgente = $x("//*[@id='agregarAgente']");
    public SelenideElement inputNumPatenteModal = $x("//*[@id='idNumPatenteModal']");
    public SelenideElement inputCheckObligFisc = $x("//*[@id='checkObligFisc']");
    public SelenideElement inputCheckAutPantente = $x("//*[@id='checkAutPantente']");
    public SelenideElement inputBtncargarPatente = $x("//*[@id='btncargarPatente']");
    public SelenideElement inputAgregarAgente2 = $x("//*[@id='btnAgregarAgente']");
    //DATOS TRASPORTISTA
    public SelenideElement inputAgregarTransportista = $x("//*[@id='agregarTransportista']");
    public SelenideElement inputTransportista = $x("//*[@id='rfcTransportista']");
    public SelenideElement inputBuscar = $x("//input[contains(@onclick, 'buscarTransportistaNacionalIDC();')]");
    public SelenideElement inputRegistroTransportista = $x("//*[@id='registroTransportistaBtn']");
    public SelenideElement inputPregSusp = $x("//*[@id='idSiPregSusp']");
    public SelenideElement inputPregSusp2 = $x("//*[@id='idNoPregSusp']");
    public SelenideElement inputInventario = $x("//*[@id='siInventario']");
    public SelenideElement inputInventario2 = $x("//*[@id='noInventario']");
    public SelenideElement inputNombreInventario = $x("//*[@id='nombre.inventario']");
    public SelenideElement inputLugarInventario = $x("//*[@id='lugarR.inventario']");
    public SelenideElement inputAnexoInventario = $x("//*[@id='anexo.inventario']");
    public SelenideElement inputAgregarInventario = $x("//*[@id='btnAgregar.inventario']");
    public SelenideElement buttonAceptar = $x("/html/body/div[18]/div[3]/div/button");
    //public SelenideElement aceptado = $x("/html/body/div[19]/div[3]/div/button");
    public SelenideElement inputContabilidad = $x("//*[@id='siContabilidad']");
    public SelenideElement inputContabilidad2 = $x("//*[@id=\"noContabilidad\"]");
    public SelenideElement inputInfoContable = $x("//*[@id='siInfoContable']");
    public SelenideElement inputInfoContable2 = $x("//*[@id='noInfoContable']");
    public SelenideElement inputQuerella = $x("//*[@id='siQuerella']");
    public SelenideElement inputQuerella2 = $x("//*[@id='noQuerella']");
    public SelenideElement inputListaDeclaraciones = $x("//input[@name=\"mapDeclaracionSolicitud['3070'].acepto\"]");
    public SelenideElement inputListaDeclaraciones2 = $x("//input[@name=\"mapDeclaracionSolicitud['3061'].acepto\"]");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    //TERCEROS RELACIONADOS
    public SelenideElement inputTerceroRelacionado = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a");
    public SelenideElement inputTercero = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement inputBuscar2 = $x("//input[contains(@onclick, 'buscarTerceroNacionalIDC();')]");
    public SelenideElement buttonAceptar2 = $x("/html/body/div[19]/div[3]/div/button");
    public SelenideElement inputAgregarEnlaceOperativo = $x("//*[@id='btnAgregarEnlaceOperativo']");
    public SelenideElement input = $x("//*[@id='rfc']");
    public SelenideElement inputBuscarEnlaceOperativo = $x("//*[@id='buscarEnlaceOperativo']");
    public SelenideElement inputTerceroEnlaceOperativoPuesto = $x("//*[@id='terceroEnlaceOperativo.puesto']");
    public SelenideElement inputAceptarEnlace = $x("//*[@id='btnAceptarEnlace']");
    //PAGO DE DERECHOS
    public SelenideElement labelPagoDerechos = $x("//label[@for='captura.tab.pagoDerechos']");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputCalendar = $x("//*[@id='calendarTo']");
    //CONTINUAR
    public SelenideElement inputSolicitud = $x("//*[@id=\"guardarSolicitud\"]"); //FINAL
    //CARGAR ARCHIVOS
    public SelenideElement inputContinuar = $x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[contains(@style, '0px;')]");
    public SelenideElement selectDoc = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc2 = $x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement selectDoc3 = $x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement inputGuardarButton = $x("//*[@id='guardarButton']");
    // lorem
    public SelenideElement inputSiguienteButton = $x("//*[@id='siguienteButton']");


}
