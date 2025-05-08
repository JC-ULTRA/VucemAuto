package HACIENDA.Tramite32611;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32611 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresFs = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registrosComercioExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement solicitudRegistro = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/a");
    public SelenideElement rubroAutoTransportista = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[7]/ul/li[8]/a");


    /// datos comunes
    public SelenideElement datosComunes = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[2]/a/label");
    public SelenideElement sectorProductivo = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    public SelenideElement servicio = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[1].catalogo\"]");
    public SelenideElement cumplimientoObligacionesSi = $x("//*[@id=\"si190\"]");
    public SelenideElement autorizoSATSi = $x("//*[@id=\"si191\"]");
    public SelenideElement empleadosPropiosSi = $x("//*[@id=\"emPropiosSi\"]");
    public SelenideElement numEmpleadosPropios = $x("//*[@id=\"empPropios\"]");
    public SelenideElement bimestreEmpleadosPropios = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");
    public SelenideElement isrSi = $x("//*[@id=\"isrSi\"]");
    public SelenideElement pagoCuotasObreroPatronalesSi = $x("//*[@id=\"obreroPatronalesSi\"]");
    public SelenideElement subcontratacionSi = $x("//*[@id=\"si2011\"]");
    public SelenideElement agregarSubcontratado = $x("//*[@id=\"agregarSubcontratado\"]");
    public SelenideElement rfcSubcontratado = $x("//*[@id=\"subcontratado.rfcBusqueda\"]");
    public SelenideElement inputFuera = $x("/html/body/div[11]/div[2]/table/tbody/tr[1]/td/div/div[1]");
    public SelenideElement subContr = $x("//*[@id=\"subcontratado.rfc\"]");
    public SelenideElement btnBuscarRfcSub = $x("/html/body/div[11]/div[2]/table/tbody/tr[1]/td/div/div[1]/input[2]");

    public SelenideElement numEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.empleados\"]");
    public SelenideElement bimestreEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.bimestre\"]");
    public SelenideElement añadirSubcontratados = $x("//*[@id=\"subcontratadoAgregarModalEsquemaIC\"]");
    public SelenideElement btnAceptarSubcontratados = $x("/html/body/div[13]/div[3]/div/button");
    public SelenideElement registroPadronSi = $x("//*[@id=\"si236\"]");
    public SelenideElement listadoEmpresasNo = $x("//*[@id=\"no237\"]");
    public SelenideElement articulo64BCFFNo = $x("//*[@id=\"no238\"]");
    public SelenideElement articulo64BBisNo = $x("//*[@id=\"no462\"]");
    public SelenideElement sellosVigentes = $x("//*[@id=\"si239\"]");
    public SelenideElement articulo17HBis = $x("//*[@id=\"no240\"]");
    public SelenideElement AgregarInstalaciones = $x("//*[@id=\"btnAgregarDomicilios\"]");
    public SelenideElement entidadInstalacion = $x("//*[@id=\"entidadFederativaIDC\"]");
    public SelenideElement seleccionarInstalacion = $x("//*[@id=\"jqg_gridDomiciliosModal_3\"]");
    public SelenideElement btnAgregarInstalaciones = $x("/html/body/div[9]/div[2]/table/tbody/tr[4]/td/input[1]");
    public SelenideElement selecInstalacionAModificar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[4]/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement modificarInstalacion = $x("//*[@id=\"btnModificarDomicilios\"]");
    public SelenideElement instalacionPrincipal = $x("//*[@id=\"siInstalacion\"]");
    public SelenideElement tipoInstalacion = $x("//*[@id=\"domicilio.tipoInstalacion\"]");
    public SelenideElement procesoProductivoSi = $x("//*[@id=\"siProcesoProd\"]");
    public SelenideElement usoGoceInmuebleSi = $x("//*[@id=\"siAcreditaIn\"]");
    public SelenideElement comercioExteriorSi = $x("//*[@id=\"siOperacionesCExt\"]");
    public SelenideElement reconocimientoMutuoSi = $x("//*[@id=\"siInstalacionCtpat\"]");
    public SelenideElement perfilEmpresaNo = $x("//*[@id=\"noPerfilRFE\"]");
    public SelenideElement btnHacerModificacion = $x("/html/body/div[14]/div[2]/table/tbody/tr[15]/td/input[1]");
    public SelenideElement btnAceptarModificacion = $x("/html/body/div[15]/div[3]/div/button");
    public SelenideElement articulo17KSi = $x("//*[@id=\"si243\"]");
    public SelenideElement suspesionPadronNo = $x("//*[@id=\"no244\"]");
    public SelenideElement provedoresExtranjeros = $x("//*[@id=\"archivo\"]");
    public SelenideElement agregarProvedoresExtranjeros = $x("//*[@id=\"uploadFileExtranjeros\"]");
    public SelenideElement btnOkProvedoresExtranjeros = $x("/html/body/div[31]/div[3]/div/button/span");
    public SelenideElement provedoresNacionales = $x("//*[@id=\"archivoNacionales\"]");
    public SelenideElement agregarProvedoresNacionales = $x("//*[@id=\"uploadFileExtranjerosN\"]");
    public SelenideElement btnOkProvedoresNacionales = $x("/html/body/div[19]/div[3]/div/button");
    public SelenideElement querellaNo = $x("//*[@id=\"no248\"]");
    public SelenideElement inventariosSi = $x("//*[@id=\"siInventario\"]");
    public SelenideElement nombreInventarios = $x("//*[@id=\"nombre.inventario\"]");
    public SelenideElement lugarInventarios = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement anexo24InventariosOk = $x("//*[@id=\"anexo.inventario\"]");
    public SelenideElement btnAgregarInventario = $x("//*[@id=\"btnAgregar.inventario\"]");
    public SelenideElement btnAceptarInventario = $x("/html/body/div[19]/div[3]/div/button");
    public SelenideElement rmfSi = $x("//*[@id=\"si251\"]");
    public SelenideElement agregarSocio = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement caracterSocio = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement tributarEnMexicoNo = $x("//*[@id=\"socio.tributarMexicoFalse\"]");
    public SelenideElement tipoPersona = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement nacionalidadSocio = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement nombreEmpresaSocio = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement btnAgregarSocio = $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptarSocio = $x("/html/body/div[20]/div[3]/div/button");
    public SelenideElement sociosAccionistasNo = $x("//*[@id=\"no463\"]");
    public SelenideElement manifiesto1 = $x("//*[@id=\"acepto252\"]");
    public SelenideElement manifiesto2 = $x("//*[@id=\"acepto253\"]");
    /// TERCEROS RELACIONADOS
    public SelenideElement tercerosRelacionados = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[3]/a");
    public SelenideElement rfcRepresentanteLegal = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscarRfcRepresentanteL = $x("//*[@id=\"buscar\"]");
    public SelenideElement btnAceptarRepresentanteL = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement btnAgregarEnlaceOperativo = $x("//*[@id=\"btnAgregarEnlaceOperativo\"]");
    public SelenideElement rfcEnlaceO = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscarEnlaceO = $x("//*[@id=\"buscarEnlaceOperativo\"]");
    public SelenideElement cargoEnlaceO = $x("//*[@id=\"terceroEnlaceOperativo.puesto\"]");
    public SelenideElement btnAñadirEnlaceO = $x("//*[@id=\"btnAceptarEnlace\"]");
    /// IMPORTADOR Y/O EXPORTADOR
    public SelenideElement importadorYExportador = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[4]/a/label");
    public SelenideElement operacionesComercioExterior = $x("//*[@id=\"comExtNo\"]");
    public SelenideElement mismoGrupoNo = $x("//*[@id=\"grupEmpNo\"]");
    public SelenideElement fusionEscisionNo= $x("//*[@id=\"empFusNo\"]");
    public SelenideElement programaImmexSi = $x("//*[@id=\"empExtSi\"]");
    public SelenideElement fechaPago = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[4]/div[1]/table[3]/tbody/tr[2]/td[2]/img");
    public SelenideElement selecFechaPago = $x("/html/body/div[2]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement montoPago = $x("//*[@id=\"montoOEA\"]");
    public SelenideElement numOperacionBancaria = $x("//*[@id=\"operBancOEA\"]");
    public SelenideElement llaveDEPago = $x("//*[@id=\"llaveOEA\"]");
    public SelenideElement agregarTransportistas = $x("//*[@id=\"agregarTransportista\"]");
    public SelenideElement rfcTransportista = $x("//*[@id=\"trRfc\"]");
    public SelenideElement btnBuscarTransportista = $x("//*[@id=\"btnBuscarEmpresa\"]");
    public SelenideElement btnAgregarTransportista = $x("//*[@id=\"btnGuardarTransportista\"]");
    public SelenideElement btnAceptarTransportista = $x("/html/body/div[23]/div[3]/div/button");

    public SelenideElement Perfil = $x("//*[@id=\"perfilRFESi\"]");
    public SelenideElement RecintoFiscalizadoEstrategico = $x("//*[@id=\"autoRFESi\"]");
    public SelenideElement FechaFin = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[4]/div[2]/table[3]/tbody/tr[2]/td[2]/img");
    public SelenideElement SelectFechaFin = $x("/html/body/div[2]/table/tbody/tr[1]/td[2]/a");
    public SelenideElement NumFolioOficio = $x("//*[@id=\"rfeOficio\"]");
    public SelenideElement RegistroEsquema = $x("//*[@id=\"operaRFESi\"]");
    public SelenideElement Rubro = $x("//*[@id=\"rfeRubro\"]");
    public SelenideElement FecFicRubro = $x("//*[@id=\"fechaRegRFE\"]");
    public SelenideElement NumOfiAuto = $x("//*[@id=\"rfeOficioIva\"]");
    public SelenideElement SujetoProCance = $x("//*[@id=\"cancelRFENo\"]");

    public SelenideElement autorizoReconocimientoMutuo = $x("//*[@id=\"si4060Recinto\"]");
    public SelenideElement informacionPublica = $x("//*[@id=\"si1091Recinto\"]");

    /// CTPAT
    public SelenideElement CTPAT = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/ul/li[5]/a");
    public SelenideElement autorizoCBPSi = $x("//*[@id=\"si2089\"]");
    public SelenideElement materiaSeguridadSi = $x("//*[@id=\"si2090\"]");
    public SelenideElement cancelacionNo = $x("//*[@id=\"no2091\"]");

    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuar = $x("/html/body/div[1]/div[3]/div[3]/div/form/table/tbody/tr/td/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[3]/tbody/tr[14]/td[2]/input");
    public SelenideElement archivo1 = $x("/html/body/div[7]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = $x("/html/body/div[7]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = $x("/html/body/div[7]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = $x("/html/body/div[7]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = $x("/html/body/div[7]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo6 = $x("/html/body/div[7]/div[2]/div/form[7]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo7 = $x("/html/body/div[7]/div[2]/div/form[8]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo8 = $x("/html/body/div[7]/div[2]/div/form[9]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo9 = $x("/html/body/div[7]/div[2]/div/form[10]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo10 = $x("/html/body/div[7]/div[2]/div/form[11]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo11 = $x("/html/body/div[7]/div[2]/div/form[12]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnSiguiente = $x("//*[@id=\"siguienteButton\"]");
}
