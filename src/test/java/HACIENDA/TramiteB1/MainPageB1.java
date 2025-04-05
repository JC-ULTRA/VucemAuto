package HACIENDA.TramiteB1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;
public class MainPageB1 {
    //Firma y Path del Trámite
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id=\"subenlaces\"]/ul/li[5]/a");
    public SelenideElement SoliNew = $x("//*[@id=\"subenlaces\"]/ul/li[5]/ul/li[2]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement linkAvisosAgaSat = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[19]/a");
    public SelenideElement B1 = $x("//a[contains(@onclick, 'onpen')]");

    //Compensación que aplica por
    public SelenideElement linkDetalle = $x("//*[@id='ui-id-2']");
    public SelenideElement selectSolicitudIdeGenerica = $x("//*[@id='solicitud.ideGenerica1']");

    //Datos del pedimento original
    public SelenideElement fechaPagoPedimento1 = $x("//*[@id='fechaInicioVigencia']");
    public SelenideElement patente1 = $x("//*[@id='patente']");
    public SelenideElement aduana1 = $x("//*[@id='solicitud.claveAduana']");
    public SelenideElement documento1 = $x("//*[@id='documento']");
    public SelenideElement impuestoGI1 = $x("//*[@id='impuestoGeneralImportacion']");
    public SelenideElement dta1 = $x("//*[@id='dta']");
    public SelenideElement cuotaComp1 = $x("//*[@id='cuotaCompensatoria']");
    public SelenideElement claveComer1 = $x("//*[@id='operacionAmparo']");

    //Datos del pedimento de rectificación o desistimiento
    public SelenideElement fechaPagoPedimento2 = $x("//*[@id='fechaInicioVigencia1']");
    public SelenideElement patente2 = $x("//*[@id='patente1']");
    public SelenideElement aduana2 = $x("//*[@id='solicitud.actividadEnDestino']");
    public SelenideElement documento2 = $x("//*[@id='documento2']");
    public SelenideElement impuestoGI2 = $x("//*[@id='impuestoGeneralImportacion2']");
    public SelenideElement dta2 = $x("//*[@id='dtaDesistimiento']");
    public SelenideElement cuotaComp2 = $x("//*[@id='cuotaCompensatoria2']");
    public SelenideElement chaveComer2 = $x("//*[@id='tratadoLibreComercio']");

    //Importes suceptibles de compensación
    public SelenideElement fechaPagoPedimento3 = $x("//*[@id='fechaInicioVigencia2']");
    public SelenideElement patente3 = $x("//*[@id='patente2']");
    public SelenideElement aduana3 = $x("//*[@id='solicitud.ideGenerica3']");
    public SelenideElement documento3 = $x("//*[@id='documentoCompensacion']");
    public SelenideElement noComp = $x("//*[@id='noCompensacion']");

    //Importe compensado I G I
    public SelenideElement historico1 = $x("//*[@id='historicoCompensadoIGI']");
    public SelenideElement actualizado1 = $x("//*[@id='actualizadoCompensadoIGI']");

    //Importe compensado
    public SelenideElement cuotaComp3 = $x("//*[@id='cuotaCompensatoriaIC']");

    //Importe compensado D T A
    public SelenideElement historico2 = $x("//*[@id='historicoCompensadoDTA']");
    public SelenideElement actualizado2 = $x("//*[@id='actualizadoCompensadoDTA']");
    public SelenideElement igi = $x("//*[@id='igiPendiente']");
    public SelenideElement dta3 = $x("//*[@id='dtaPendiente']");
    public SelenideElement cuotaComp4 = $x("//*[@id='cuotaCompensatoriaSPC']");
    public SelenideElement btnCont = $x("//*[@id='guardarSolicitud']");

    //Requisitos obligatorios
    public SelenideElement btnContCarDoc = $x("//input[@value='Continuar']");
    public SelenideElement btnAdjDoc = $x("//input[contains(@style, '0px;')]");
    public SelenideElement doc1 = $x("//input[@name='documentos[0].file']");
    public SelenideElement doc2 = $x("//input[@name='documentos[1].file']");
    public SelenideElement doc3 = $x("//input[@name='documentos[2].file']");
    public SelenideElement doc4 = $x("//input[@name='documentos[3].file']");
    public SelenideElement doc5 = $x("//input[@name='documentos[4].file']");
    public SelenideElement btnAdjuntar = $x("//*[@id='btnAnexar']");
    public SelenideElement btnCerrar = $x("//*[@id='btnCerrar']");
    public SelenideElement btnContPreFirm = $x("//*[@id='siguienteButton']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");











    
    

    
    
    
    
    
    

}
