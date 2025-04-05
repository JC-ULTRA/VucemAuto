package HACIENDA.Tramite32604;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32604 {
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
    public SelenideElement linkSolicitudRegistroEIC = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement linkComercializadoraeImportacion = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement labelSubMenu = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement labelSubMenu2 = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/ul/li[1]/a");
    //DATOS COMUNES
    public SelenideElement labelDatosComunes = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement selectCatalogoSolicitud = $x("//*[@id='solicitud.listaCatalogoSolicitud[0].catalogo']");
    public SelenideElement radioNo190 = $x("//*[@id='no190']");
    public SelenideElement radioSi191 = $x("//*[@id='si191']");
    public SelenideElement radioNo237 = $x("//*[@id='no237']");
    public SelenideElement radioNo238 = $x("//*[@id='no238']");
    public SelenideElement radioSi239 = $x("//*[@id='si239']");
    public SelenideElement radioNo240 = $x("//*[@id='no240']");
    public SelenideElement btnAgregarDomicilios = $x("//*[@id='btnAgregarDomicilios']");
    public SelenideElement entidadFederativaIDC = $x("//*[@id='entidadFederativaIDC']");
    public SelenideElement jqg_gridDomiciliosModal_5 = $x("//*[@id=\"jqg_gridDomiciliosModal_4\"]");
    public SelenideElement inputAceptarDomicilios = $x("//input[@onclick='javaScript:guardarDatosDomicilios()']");
    public SelenideElement checkDomicilios = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/div[1]/div[1]/table/tbody/tr[7]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement btnModificarDomicilios = $x("//*[@id=\"btnModificarDomicilios\"]");
    public SelenideElement siInstalacion = $x("//*[@id=\"siInstalacion\"]");
    public SelenideElement inputTipoInstalacion = $x("//*[@id=\"domicilio.tipoInstalacion\"]");
    public SelenideElement siProcesoProd = $x("//*[@id=\"siProcesoProd\"]");
    public SelenideElement siAcreditaIn = $x("//*[@id=\"siAcreditaIn\"]");
    public SelenideElement inputAceptarDomicilios2 = $x("//input[@onclick='javaScript:guardarModificacionDomicilio()']");
    public SelenideElement spanAceptar2 = $x("/html/body/div[13]/div[3]/div/button/span");
    public SelenideElement si243 = $x("//*[@id='si243']");
    public SelenideElement no244 = $x("//*[@id='no244']");
    public SelenideElement archivoInput = $x("//*[@id='archivo']");
    public SelenideElement archivoNacionalesInput = $x("//*[@id='archivoNacionales']");
    public SelenideElement no248RadioButton = $x("//*[@id='no248']");
    public SelenideElement siInventarioRadioButton = $x("//*[@id='siInventario']");
    public SelenideElement nombreInventarioInput = $x("//*[@id='nombre.inventario']");
    public SelenideElement lugarRInventarioInput = $x("//*[@id='lugarR.inventario']");
    public SelenideElement btnAgregarInventario = $x("//*[@id='btnAgregar.inventario']");
    public SelenideElement spanAceptar = $x("/html/body/div[14]/div[3]/div/button/span");
    public SelenideElement si251 = $x("//*[@id='si251']");
    public SelenideElement agregarSocio = $x("//*[@id='agregarSocio']");
    public SelenideElement caracterDe = $x("//*[@id='socio.caracterDe']");
    public SelenideElement inputSocioTributarMexico = $x("//*[@id='socio.tributarMexicoFalse']");
    public SelenideElement selectSocioTipoPersona = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement inputSocioNombreEmpresa = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement inputSocioNombre = $x("//*[@id=\"socio.nombre\"]");
    public SelenideElement inputSocioApPaterno = $x("//*[@id=\"socio.apPaterno\"]");
    public SelenideElement inputSocioApMaterno = $x("//*[@id=\"socio.apMaterno\"]");
    public SelenideElement nacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement btnSocioAgregarModal = $x("//*[@id='btnSocioAgregarModal']");
    public SelenideElement aceptarButton = $x("/html/body/div[15]/div[3]/div/button/span");
    public SelenideElement aceptarButton2 = $x("/html/body/div[16]/div[3]/div/button/span");
    public SelenideElement aceptarButton3 = $x("/html/body/div[17]/div[3]/div/button/span");
    public SelenideElement si510 = $x("//*[@id='si510']");
    public SelenideElement aceptarButton4 = $x("/html/body/div[18]/div[3]/div/button/span");
    public SelenideElement acepto253 = $x("//*[@id='acepto253']");
    //TERCEROS RESLACIONADOS
    public SelenideElement tercerosRelacionadosLabel = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement rfcTerceroInput = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[3]/table[1]/tbody/tr[3]/td[1]/div/input");
    public SelenideElement buscarButton = $x("//*[@id='buscar']");
    public SelenideElement aceptarButton1 = $x("/html/body/div[19]/div[3]/div/button/span");
    public SelenideElement btnAgregarEnlaceOperativo = $x("//*[@id='btnAgregarEnlaceOperativo']");
    public SelenideElement rfcInput = $x("//*[@id='rfc']");
    public SelenideElement buscarEnlaceOperativoButton = $x("//*[@id='buscarEnlaceOperativo']");
    public SelenideElement btnAceptarEnlace = $x ("//*[@id=\"btnAceptarEnlace\"]");
    //MODALIDAD COMERCIALIZADORA E IMPORTADORA
    public SelenideElement modalidadComercializadoraLabel = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement fechaPagoComer = $x("/html/body/div[2]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement btncerrar = $x("/html/body/div[2]/div[2]/button[2]");
    public SelenideElement montoComer = $x("//*[@id='montoComer']");
    public SelenideElement imageCalendar = $x("//img[@alt='Calendar']");
    public SelenideElement operacionBan = $x("//*[@id='operacionBan']");
    public SelenideElement llavePagoComer = $x("//*[@id='llavePagoComer']");
    public SelenideElement agregarTransportista = $x("//*[@id='agregarTransportista']");
    public SelenideElement inputTransportistaCertificacion = $x("//*[@id='trRfc']");
    public SelenideElement inputBuscarEmpresa = $x("//input[contains(@onclick, 'fc')]");
    public SelenideElement inputGuardarTransportista = $x("//*[@id='btnGuardarTransportista']");
    public SelenideElement spanAceptar1 = $x("/html/body/div[21]/div[3]/div/button/span");
    public SelenideElement inputImmex = $x("//*[@id='immexNo']");
    public SelenideElement inputAduanas = $x("//*[@id='aduanasSi']");
    public SelenideElement inputGuardarSolicitud = $x("//*[@id='guardarSolicitud']");
    //REQUISITOS NECESARIOS
    public SelenideElement inputSiguiente = $x("//input[@value='Siguiente']");
    //ANEXAR REQUISITOS
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@class='largemid']");
    public SelenideElement inputDocumentosFile = $x("//input[@name='documentos[0].file']");
    public SelenideElement inputDocumentosFile2 = $x("//input[@name='documentos[1].file']");
    public SelenideElement inputDocumentosFile3 = $x("//input[@name='documentos[2].file']");
    public SelenideElement inputDocumentosFile4 = $x("//input[@name='documentos[3].file']");
    public SelenideElement inputDocumentosFile5 = $x("//input[@name='documentos[4].file']");
    public SelenideElement inputDocumentosFile6 = $x("//input[@name='documentos[5].file']");
    public SelenideElement buttonAnexar = $x("//*[@id='btnAnexar']");
    public SelenideElement spanAdjuntar = $x("/html/body/div[7]/div[3]/div/button[1]/span");
    public SelenideElement spanCerrar = $x("/html/body/div[7]/div[3]/div/button[2]/span");
    public SelenideElement inputSiguienteButton = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[3]");

    //*[@id="certificate"]
    //*[@id="privateKey"]
    //*[@id="privateKeyPassword"]
    //*[@id="btnSubmit"]
}
