package AGRICULTURA.Tramite220203;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

    public class MainPage220203 {
        public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
        public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
        public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
        public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
        public SelenideElement btnFirmar = Selenide.$x("//*[@id='btnSubmit']");
        public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[3]/div/div/ul/li");
        public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
        public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
        public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
        public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
        public SelenideElement agricultura = Selenide.$x("/html/body/main/div/div[3]/div/form/a[10]/img");
        public SelenideElement certificadosSolicitud = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
        public SelenideElement certificadoImportacion = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/a");
        public SelenideElement SENASICA03012C = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[2]/ul/li[3]/a");
        public SelenideElement datosSolicitud = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[2]/a/label");
        public SelenideElement aduanaIngreso = Selenide.$x("//*[@id='solicitud.claveAduana']");
        public SelenideElement oficinaInspeccion = Selenide.$x("//*[@id='solicitud.oficinaInspeccionAgropecuaria.clave']");
        public SelenideElement puntoInspeccion = Selenide.$x("//*[@id='solicitud.unidadAdministrativaRepresentacionFederal.clave']");
        public SelenideElement numGuia = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[6]/div[1]/div[2]/input");
        public SelenideElement regimen = Selenide.$x("//*[@id='solicitud.regimen.clave']");
        public SelenideElement agregarMercancia = Selenide.$x("//*[@id='btnAgregarMercancias']");
        public SelenideElement tipoRequisito = Selenide.$x("//*[@id='mercanciaGrid.idTipoRequisito']");
        public SelenideElement requisito = Selenide.$x("//*[@id='requisitos']");
        public SelenideElement numCertificado = Selenide.$x("//*[@id='numeroCertificado']");
        public SelenideElement fracArancelaria = Selenide.$x("//*[@id='mercanciaGrid.fraccionArancelaria.clave']");
        public SelenideElement NICO = Selenide.$x("//*[@id='idFraccionNico']");
        public SelenideElement descripcion = Selenide.$x("//*[@id='mostrarDescripcionFraccionUsuario']");
        public SelenideElement cantUMT = Selenide.$x("//*[@id='cantidadUMT']");
        public SelenideElement cantUMC = Selenide.$x("//*[@id='cantidadUMC']");
        public SelenideElement tipoUMC = Selenide.$x("//*[@id='mercanciaGrid.unidadMedidaComercial.clave']");
        public SelenideElement tipoUso = Selenide.$x("//*[@id='mercanciaGrid.idUso']");
        public SelenideElement numLote = Selenide.$x("//*[@id='numeroLote']");
        public SelenideElement faseDesarrollo = Selenide.$x("//*[@id='faseDesarrollo']");
        public SelenideElement especie = Selenide.$x("//*[@id='descripcionEspecie']");
        public SelenideElement paisOrigen = Selenide.$x("//*[@id='mercanciaGrid.clavesPaisesOrigen']");
        public SelenideElement paisProcedencia = Selenide.$x("//*[@id='mercanciaGrid.clavesPaisesProcedencia']");
        public SelenideElement nombreCientifico = Selenide.$x("//*[@id='nombreCientificoDetalle220203']");
        public SelenideElement btnAgregarDetalle = Selenide.$x("//*[@id='btnAgregarMercanciasDetalle']");
        public SelenideElement btnAgregarMercancia = Selenide.$x("//*[@id='btnAgregarMercancia']");
        public SelenideElement datosMovilizacionN = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[3]/a/label");
        public SelenideElement medioTransporte = Selenide.$x("//*[@id='solicitud.transporte.ideMedioTransporte']");
        public SelenideElement identificacionTransporte = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[3]/div[1]/div[2]/div[2]/input");
        public SelenideElement puntoVerificacion = Selenide.$x("//*[@id='solicitud.transporte.puntoVerificacion.idPuntoVerificacion']");
        public SelenideElement nombreTransportista = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/div/div[3]/div[3]/div/div[2]/input");
        public SelenideElement tercerosRelacionados = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[4]/a/label");
        public SelenideElement agregarExportador = Selenide.$x("//*[@id='agregarTercero_TIPERS_EXP']");
        public SelenideElement paisTercero = Selenide.$x("//*[@id='terceros_selectPais']");
        public SelenideElement domicilioTercero = Selenide.$x("//*[@id='terceros_domicilioExtranjero']");
        public SelenideElement agregarDestinatario = Selenide.$x("//*[@id='agregarTercero_TIPERS_DES']");
        public SelenideElement personaMoral = Selenide.$x("//*[@id='terceros_tipoPersonaMoral']");
        public SelenideElement razonTercero = Selenide.$x("//*[@id='terceros_rSocial']");
        public SelenideElement cpTercero = Selenide.$x("//*[@id='terceros_codPostal']");
        public SelenideElement estadoTercero = Selenide.$x("//*[@id='terceros_selectEstado']");
        public SelenideElement municipioTerceros = Selenide.$x("//*[@id='terceros_selectMunicipio']");
        public SelenideElement coloniaTercero = Selenide.$x("//*[@id='terceros_selectColonia']");
        public SelenideElement calleTercero = Selenide.$x("//*[@id='terceros_calle']");
        public SelenideElement numExt = Selenide.$x("//*[@id='terceros_numExterior']");
        public SelenideElement numInt = Selenide.$x("//*[@id='terceros_numInterior']");
        public SelenideElement ladaTercero = Selenide.$x("//*[@id='terceros_lada']");
        public SelenideElement telefonoTercero = Selenide.$x("//*[@id='terceros_telefono']");
        public SelenideElement correoTercero = Selenide.$x("//*[@id='terceros_correoElec']");
        public SelenideElement guardarTercero = Selenide.$x("//*[@id='btnGuardarFrmDatosTercero']");
        public SelenideElement pagoDerechos = Selenide.$x("/html/body/main/div[1]/div[4]/div[1]/form/div[3]/ul/li[5]/a/label");
        public SelenideElement banco = Selenide.$x("//*[@id='solicitud.pago.banco.clave']");
        public SelenideElement llaveBanco = Selenide.$x("//*[@id='solicitud.pago.llaveDePago']");
        public SelenideElement fechaPago = Selenide.$x("//*[@id='calendarTo']");
        public SelenideElement btnGuardarSoli = Selenide.$x("//*[@id='guardarSolicitud']");
        public SelenideElement btnSiguiente = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
}
