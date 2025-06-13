package PROFEPA.Tramite250103;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage250103 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement PROFEPA = $x("//*[@id=\"workingArea\"]/form/a[6]/img");
    public SelenideElement linkCertificadosLicenciasPermisos = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement linkRegistroVerificaci = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li/a");
    public SelenideElement linkTarimasEmbalajesMaderaSoporteMercancia = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li/ul/li[3]/a");
    //SOLICITUD
    public SelenideElement labelTipoMovimiento = $x("//label[@for='captura.tab.tipoMovimiento']");
    //tipo movimiento
    public SelenideElement inputSolicitudCveClasImportacion = $x("//*[@id='01']");
    public SelenideElement inputSolicitudCveClasExportacion = $x("//*[@id='02']");
    public SelenideElement inputSolicitudCveClasReexportacion = $x("//*[@id='04']");
    //Lugar inspeccion Imp
    public SelenideElement selectSolicitudAduanasAduanaClave = $x("//*[@id='solicitud.aduanas[0].aduana.clave']");
    public SelenideElement selectSolicitudUnidadAdministrativaRepresentacion = $x("//*[@id='solicitud.unidadAdministrativaRepresentacionFederal.clave']");
    public SelenideElement selectSolicitudEntidadesEntidadClave = $x("//*[@id='solicitud.entidadesSolicitud[0].entidad.clave']");
    //guardado
    public SelenideElement inputGuardarSolicitudParcial = $x("//input[@name='guardarSolicitudParcial']");
    //DESTINATARIO & AGENTE ADUANAL
    public SelenideElement labelDestinatarioAgenteAduanal = $x("//label[@for='captura.tab.datos']");
    //Datos Destinatario
    public SelenideElement inputDestinatario = $x("//*[@id='cb_tbl_destinatario']");
    public SelenideElement inputEliminar = $x("//input[contains(@onclick, \"'btnEliminarDestinatario',\")]");
    public SelenideElement inputCapturarDestinatario = $x("//*[@id=\"capturarDestinatario\"]");
    public SelenideElement inputAgregarDestinatario = $x("//*[@id=\"agregarDestinatario\"]");
    //Destinatario
    public SelenideElement inputDenominacionDestinatario = $x("//*[@id='denominacionRSDestinatario']");
    public SelenideElement selectPaisNacionalDestinatario = $x("//*[@id='paisNacionalDestinatario1']");
    public SelenideElement selectEntidadFederativa = $x("//*[@id='entidadFederativa']");
    public SelenideElement inputCodigoPostalDestinatario = $x("//*[@id='codigoPostalDestinatario']");
    public SelenideElement textareaCalleDestinatario = $x("//*[@id='calleDestinatario']");
    public SelenideElement inputRegistroDestinatario = $x("//*[@id='registroDestinatarioBtn']");
    public SelenideElement inputAceptarEmergente = $x("/html/body/div[21]/div[3]/div/button/span");
    //Datos Agente Aduanal
    public SelenideElement inputGridComponenteAgenteAduanal = $x("//*[@id='cb_gridComponenteAgenteAduanal']");
    public SelenideElement inputAgregarRequisito = $x("//input[@onclick='javascript:nuevoAgenteAduanal();']");
    //Agente Aduanal
    public SelenideElement inputNombreAgente = $x("//*[@id='nombreAgente']");
    public SelenideElement inputApellidoPaternoAgente = $x("//*[@id='apellidoPaternoAgente']");
    public SelenideElement inputApellidoMaternoAgente = $x("//*[@id='apellidoMaternoAgente']");
    public SelenideElement inputPatente = $x("//*[@id='patente']");
    public SelenideElement inputAgregarAgente = $x("//input[@onclick='javascript:agregarAgente();']");
    //CERTIFICADOS
    public SelenideElement labelCertificados = $x("//label[@for='captura.tab.certificados']");
    //MERCANCIAS SIN CFI
    public SelenideElement labelMercancSinCfi = $x("//label[@for='captura.tab.mercancias']");
    public SelenideElement inputAgregarDescripcion = $x("//*[@id='btn-agregar-descripcion']");
    public SelenideElement selectDescripcionProducto = $x("//*[@id='descripcionProducto.idDescripcionProducto']");
    //Detalle
    public SelenideElement selectFraccionArancelariaClave = $x("//*[@id='fraccionArancelaria.clave']");
    public SelenideElement inputCantidad = $x("//*[@id='cantidad']");
    public SelenideElement selectUnidadMedidaClave = $x("//*[@id='unidadMedida.clave']");
    public SelenideElement selectGenero = $x("//*[@id='genero.genero']");
    public SelenideElement selectEspecie = $x("//*[@id='especie.idEspecie']");
    public SelenideElement selectVidaSilvestre = $x("//*[@id='vidaSilvestre.idVidaSilvestre']");
    public SelenideElement selectPaisesDetalleMercanciaPais = $x("//*[@id='paisesDetalleMercancia[0].pais.clave']");
    public SelenideElement selectPaisesDetalleMercanciaPais2 = $x("//*[@id='paisesDetalleMercancia[1].pais.clave']");
    public SelenideElement inputAgregarMercancia = $x("//*[@id='btn-agregar-mercancia']");
    public SelenideElement inputAgregarAgente2 = $x("/html/body/div[19]/div[3]/div/button[1]/span");
    public SelenideElement inputGuardarSeccionMercancias = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[4]/div[3]/input");
    //REQUISITOS
    public SelenideElement labelRequisitos = $x("//label[@for='captura.tab.requisitos']");
    //Datos transporte
    public SelenideElement selectMedioTransporte = $x("//*[@id='medioTransporte']");
    public SelenideElement inputAgregarRequisito2 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[5]/table[1]/tbody/tr[7]/td/div/input[1]");
    public SelenideElement inputNumIdentificacion = $x("//*[@id='numIdentificacion']");
    public SelenideElement inputNumEconomico = $x("//*[@id='numEconomico']");
    public SelenideElement inputPlaca = $x("//*[@id='placa']");
    public SelenideElement inputAgregarTransporte = $x("//*[@id='btnAgregarTransporte1']");
    //Requisitos
    public SelenideElement inputAgregarRequisito3 = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[5]/table[2]/tbody/tr[3]/td/div/input[1]");
    public SelenideElement selectRegistroRequisitoCaption = $x("//*[@id='registro.requisito.caption']");
    public SelenideElement inputNumero = $x("//*[@id='txt_numero']");
    public SelenideElement inputCalendarFrom = $x("//*[@id='calendarFrom']");
    public SelenideElement inputAgregarAgente3 = $x("/html/body/div[14]/div[2]/form/table[2]/tbody/tr/td/input[1]");
    public SelenideElement inputTxtNumero = $x("//*[@id='txt_numero']");
    //PAGO DERECHO
    public SelenideElement labelPagoDerechos = $x("//label[contains(@for, 'rofepa')]");
    public SelenideElement selectSolicitudPagoBancoClave = $x("//*[@id='solicitud.pago.banco.clave']");
    public SelenideElement inputSolicitudPagoLlave = $x("//*[@id='solicitud.pago.llaveDePago']");
    public SelenideElement inputSolicitudPagoLlave2 = $x("//*[@id='fechaPago']");
    public SelenideElement inputGuardarPago = $x("//*[@id='guardarPago']");
    public SelenideElement inputDatosRevisadosCorrectos = $x("//*[@id='datosRevisadosCorrectos']");
    //FIRMA

    public SelenideElement inputGuardarSolicitud = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement inputGuarda = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement inputAdjuntarDocumentos = $x("//input[@type='button' and @value='Adjuntar documentos']");
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement inputSiguiente = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr/td/input[3]");
}