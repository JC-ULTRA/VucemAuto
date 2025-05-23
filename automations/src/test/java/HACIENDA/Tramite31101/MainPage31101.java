package HACIENDA.Tramite31101;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage31101 {
    //Tramite 31101
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Navegación para entrar al tramite
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement RegisCE = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement ElementoScrolRef = $x("//*[@id=\"servicios\"]/ul/li[20]/a/span");
    public SelenideElement GarantiasIVAeIEPS = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[2]/a/span");//*[@id="servicios"]/ul/li/ul/li[3]/a  //*[@id="servicios"]/ul/li/ul/li[5]/a/span
    public SelenideElement elementoTramite31101= $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[2]/ul/li/a");

    //PASO 1 Capturar solicitud
    //Tab Datos generales de la solicitud
    public SelenideElement tabDatosSolicitud = $x("//*[@id=\"ui-id-2\"]");
    //Tipo de garantia
    public SelenideElement radbtnFianza = $x("//*[@id=\"solicitud.ideGenerica1\"]");
    public SelenideElement radbtnCartaCredito = $x("//*[@id=\"esCarta\"]");
    //Modalidad de la garantía
    public SelenideElement radbtnPolizaRevolvente = $x("//*[@id=\"tipoPolizaRevolvente\"]");
    public SelenideElement radbtnPolizaIndividual = $x("//*[@id=\"tipoPolizaIndividual\"]");
    //Tipo Sector
    public SelenideElement radbtnSectorProductivo = $x("//*[@id=\"esProductivo\"]");
    public SelenideElement radbtnSectorservicio = $x("//*[@id=\"esServicio\"]");
    public SelenideElement selectConcepto = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    //Manifiesto bajo protesta
    public SelenideElement checkManifiesto = $x("//*[@id=\"manifiesto4\"]");
    //Requisitos
    public SelenideElement radbtnSiFiscalAduanera = $x("//*[@id=\"si3500\"]");
    public SelenideElement radbtnNoFiscalAduanera = $x("//*[@id=\"no3500\"]");
    public SelenideElement radbtnSiObligacionFiscalSAT = $x("//*[@id=\"si3501\"]");
    public SelenideElement radbtnNoObligacionFiscalSAT = $x("//*[@id=\"no3501\"]");
    public SelenideElement radbtnSiIMSS = $x("//*[@id=\"si3502\"]");
    public SelenideElement radbtnNoIMSS = $x("//*[@id=\"no3502\"]");
    public SelenideElement SubcontratistaRFC = $x("//*[@id=\"rfc\"]");
    public SelenideElement SubcontratistabtnAgregar = $x("//*[@id=\"btnBusqRfc\"]");

    public SelenideElement radbtnSiArticulo69CFF = $x("//*[@id=\"si3503\"]");
    public SelenideElement radbtnNoArticulo69CFF = $x("//*[@id=\"no3503\"]");
    public SelenideElement radbtnSiArticulo69BCFF = $x("//*[@id=\"si3504\"]");
    public SelenideElement radbtnNoArticulo69BCFF = $x("//*[@id=\"no3504\"]");
    public SelenideElement radbtnSiArticulo69BBis = $x("//*[@id=\"si3505\"]");
    public SelenideElement radbtnNoArticulo69BBis = $x("//*[@id=\"no3505\"]");
    public SelenideElement radbtnSiCertificadosVigentes = $x("//*[@id=\"si3506\"]");
    public SelenideElement radbtnNoCertificadosVigentes = $x("//*[@id=\"no3506\"]");
    public SelenideElement radbtnSiInfraccionArticulo17H = $x("//*[@id=\"si3507\"]");
    public SelenideElement radbtnNoInfraccionArticulo17H = $x("//*[@id=\"no3507\"]");
    public SelenideElement radbtnSiArticulo17K = $x("//*[@id=\"si3508\"]");
    public SelenideElement radbtnNoArticulo17K = $x("//*[@id=\"no3508\"]");
    public SelenideElement radbtnSiSuspensionPadron = $x("//*[@id=\"si3509\"]");
    public SelenideElement radbtnNoSuspensionPadron = $x("//*[@id=\"no3509\"]");

    //NEW
    public SelenideElement radbtnSiQuerellaSAT = $x("//*[@id=\"si3511\"]");
    public SelenideElement radbtnNoQuerellaSAT = $x("//*[@id=\"no3511\"]");

    //Clientes y provedores en el Extranjero
    public SelenideElement btnSelectArchivoClientesProv = $x("//*[@id=\"archivoAdjuntarProveedoresExtranjeros\"]");//*[@id="archivoAdjuntarProveedoresExtranjeros"]
    public SelenideElement btnCargarArchivoClientesProv = $x("//*[@id=\"btnArchivoProveedoresExtranjeros\"]");

    //Proovedores Nacionales
    public SelenideElement btnSelectArchivoProvedorNacional = $x("//*[@id=\"archivoAdjuntarProveedoresNacionales\"]");
    public SelenideElement btnCargarArchivoProvedorNacionals = $x("//*[@id=\"btnArchivoProveedoresNacionales\"]");
    public SelenideElement radbtnSiQuerellaDenuncia = $x("//*[@id=\"si3511\"]");
    public SelenideElement radbtnNoQuerellaDenuncia = $x("//*[@id=\"no3511\"]");

    //Control de inventarios
    public SelenideElement radbtnSiArticulo59 = $x("//*[@id=\"si3512\"]");
    public SelenideElement radbtnNoArticulo59 = $x("//*[@id=\"no3512\"]");
    public SelenideElement radbtnSiAnexo24 = $x("//*[@id=\"si3513\"]");
    public SelenideElement radbtnNoAnexo24 = $x("//*[@id=\"no3513\"]");
    public SelenideElement NombreSistema = $x("//*[@id=\"camposTextArea.textoGenerico1\"]");
    public SelenideElement LugarRadicacion = $x("//*[@id=\"camposTextArea.textoGenerico2\"]");
    public SelenideElement radbtnSiArticulo28III = $x("//*[@id=\"si3514\"]");
    public SelenideElement radbtnNoArticulo28III = $x("//*[@id=\"no3514\"]");
    public SelenideElement radbtnSiArticulo28IV = $x("//*[@id=\"si3515\"]");
    public SelenideElement radbtnNoArticulo28IV = $x("//*[@id=\"no3515\"]");

    //Miembros de la empresa
    public SelenideElement radbtnSiObligacionesFiscales = $x("//*[@id=\"si3516\"]");
    public SelenideElement radbtnNoObligacionesFiscales = $x("//*[@id=\"no3516\"]");
    public SelenideElement radbtnSiOpinionPositiva = $x("//*[@id=\"si3616\"]");
    public SelenideElement radbtnNoOpinionPositiva = $x("//*[@id=\"no3616\"]");
    //Agregar Miembro
    public SelenideElement btnAgregarMiembro = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement selectCaracter = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement radbtnSiObligadoTributar = $x("//*[@id=\"socio.tributarMexicoTrue\"]");
    public SelenideElement radbtnNoObligadoTributar = $x("//*[@id=\"socio.tributarMexicoFalse\"]");
    public SelenideElement selectNacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement selectTipoPersona = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement MiembroRFC = $x("//*[@id=\"socio.rfcBusqueda\"]");
    public SelenideElement btnBuscarMiembro = $x("//*[@id=\"buscarRFC\"]");
    public SelenideElement RazonSocial = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement NombreMiembro =$x("//*[@id=\"socio.nombre\"]");
    public SelenideElement ApellidoPaternoMiembro = $x("//*[@id=\"socio.apPaterno\"]");
    public SelenideElement ApellidoMaternoMiembro = $x("//*[@id=\"socio.apMaterno\"]");
    public SelenideElement btnAgregarInfoMiembro= $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptarNotifMiembro = $x("/html/body/div[10]/div[3]/div/button");
    //Continuar Informacion Miembro
    public SelenideElement radbtnSiRegistroEsquemaCertificado = $x("//*[@id=\"si3517\"]");
    public SelenideElement radbtnNoRegistroEsquemaCertificado = $x("//*[@id=\"no3517\"]");
    public SelenideElement radbtnSiArticulo69B = $x("//*[@id=\"si3518\"]");
    public SelenideElement radbtnNoArticulo69B = $x("//*[@id=\"no3518\"]");
    public SelenideElement radbtnSiCredito12Meses = $x("//*[@id=\"si3519\"]");
    public SelenideElement radbtnNoCredito12Meses = $x("//*[@id=\"no3519\"]");
    public SelenideElement radbtnSiInversionNacional = $x("//*[@id=\"si3520\"]");
    public SelenideElement radbtnNoInversionNacional = $x("//*[@id=\"no3520\"]");
    public SelenideElement selectTipoInversion = $x("//*[@id=\"tipoInversion\"]");
    public SelenideElement ValorPesos = $x("//*[@id=\"cantidadInversion\"]");
    public SelenideElement DescripcionGeneral = $x("//*[@id=\"descInversion\"]");
    public SelenideElement btnAgregarInfoInversion = $x("//*[@id=\"btnTipoDeInversionAgregar\"]");
    public SelenideElement radbtnSiPrvCertificacionIVAeIEPS = $x("//*[@id=\"si3521\"]");
    public SelenideElement radbtnNoPrvCertificacionIVAeIEPS = $x("//*[@id=\"no3521\"]");
    public SelenideElement radbtnSiCumplimientoAnexo30 = $x("//*[@id=\"si3522\"]");
    public SelenideElement radbtnNoCumplimientoAnexo30 = $x("//*[@id=\"no3522\"]");

    //Regimen Aduanero
    public SelenideElement checkImportacionTemporal = $x("//*[@id=\"regimen_0\"]");
    public SelenideElement checkDepositoFiscal = $x("//*[@id=\"regimen_1\"]");
    public SelenideElement checkElaboracionRecintoFiscal = $x("//*[@id=\"regimen_2\"]");
    public SelenideElement checkRecientoEstrategico = $x("//*[@id=\"regimen_3\"]");
    //Agregar Instalacion
    public SelenideElement selectNumModalidadIMMEX = $x("//*[@id=\"IMMEX\"]");
    public SelenideElement btnAgregarInstalacion = $x("//*[@id=\"btnAgregarDomicilios\"]");
    public SelenideElement selectEntindadInstalacion = $x("//*[@id=\"entidadFederativaIDC\"]");
    public SelenideElement checkInstalacionFila1 = $x("//*[@id=\"jqg_gridDomiciliosModal_3\"]");
    public SelenideElement btnAceptarInfoInstalacion = $x("/html/body/main/div/div[4]/div[3]/div/div[4]/div/div/input[2]");
    //IMMEX
    public SelenideElement NumeroIMMEX = $x("//*[@id=\"camposTexto.textoGenerico1\"]");
    public SelenideElement ModalidadIMMEX = $x("//*[@id=\"camposTexto.textoGenerico2\"]");
    public SelenideElement radbtnSiAmparoIMMEX = $x("//*[@id=\"si3523\"]");
    public SelenideElement radbtnNoAmparoIMMEX = $x("//*[@id=\"no3523\"]");
    public SelenideElement radbtnSiAutorizacionRegimen = $x("//*[@id=\"si3524\"]");
    public SelenideElement radbtnNoAutorizacionRegimen = $x("//*[@id=\"no3524\"]");
    public SelenideElement fechaFinVigenciaRegimen = $x("/html/body/main/div/div[4]/div[1]/form/div[3]/div/div[2]/div/div[16]/div/div[2]/div[3]/div[1]/div/div/input[1]");
    public SelenideElement NumeroOficioAutorizacionRegimen = $x("/html/body/main/div/div[4]/div[1]/form/div[3]/div/div[2]/div/div[16]/div/div[2]/div[3]/div[2]/input");
    public SelenideElement radbtnSiSujetoCancelacion = $x("//*[@id=\"si3525\"]");
    public SelenideElement radbtnNoSujetoCancelacion = $x("//*[@id=\"no3525\"]");
    public SelenideElement radbtnSiAutorizacionReciento = $x("//*[@id=\"si3526\"]");
    public SelenideElement radbtnNoAutorizacionReciento = $x("//*[@id=\"no3526\"]");
    public SelenideElement fechaFinVigenciaRecinto = $x("//*[@id=\"fechaFinVigenciaRecinto\"]");
    public SelenideElement NumeroOficioAutorizacionRecinto = $x("//*[@id=\"camposTexto.textoGenerico6\"]");
    public SelenideElement radbtnSiSujetoCancelacionRecinto = $x("//*[@id=\"si3527\"]");
    public SelenideElement radbtnNoSujetoCancelacionRecinto = $x("//*[@id=\"no3527\"]");

    //Infrastructura
    public SelenideElement radbtnSiCuentaConInfrastructura = $x("//*[@id=\"si3528\"]");
    public SelenideElement radbtnNoCuentaConInfrastructura = $x("//*[@id=\"no3528\"]");

    public SelenideElement radbtnSiResolucionImprocedencia = $x("//*[@id=\"si3529\"]");
    public SelenideElement radbtnNoResolucionImprocedencia = $x("//*[@id=\"no3529\"]");
    public SelenideElement Porcentaje = $x("//*[@id=\"camposTexto.textoGenerico7\"]");
    public SelenideElement Monto = $x("//*[@id=\"camposTexto.textoGenerico8\"]");
    public SelenideElement radbtnSiCapacidadFinanciera = $x("//*[@id=\"si3530\"]");
    public SelenideElement radbtnNoCapacidadFinanciera = $x("//*[@id=\"no3530\"]");
    public SelenideElement btnSeleccionarArchivoImportacion = $x("//*[@id=\"archivoAdjuntarImportacionTemporal\"]");
    public SelenideElement btnCargarArchivoImportacion = $x("//*[@id=\"btnArchivoImportacionTemporal\"]");
    public SelenideElement radbtnSiImportacion50Porciento = $x("//*[@id=\"si3531\"]");
    public SelenideElement radbtnNoImportacion50Porciento = $x("//*[@id=\"no3531\"]");

    public SelenideElement ValorAduanaTotal = $x("//*[@id=\"camposTexto.textoGenerico9\"]");

    //Columna B
    public SelenideElement ValorComercialRetorno = $x("//*[@id=\"camposTexto.textoGenerico10\"]");
    public SelenideElement ValorComercialTransferencia = $x("//*[@id=\"camposTexto.textoGenerico13\"]");
    public SelenideElement ValorComercialDesperdicio = $x("//*[@id=\"camposTexto.textoGenerico16\"]");
    public SelenideElement ValorComercialConstancia = $x("//*[@id=\"camposTexto.textoGenerico19\"]");
    //Columna C
    public SelenideElement ValorAduanaRetorno = $x("//*[@id=\"camposTexto.textoGenerico11\"]");
    public SelenideElement ValorAduanaTransferencia = $x("//*[@id=\"camposTexto.textoGenerico14\"]");
    public SelenideElement ValorAduanaDesperdicio = $x("//*[@id=\"camposTexto.textoGenerico17\"]");
    public SelenideElement ValorAduanaConstancia = $x("//*[@id=\"camposTexto.textoGenerico20\"]");
    //Columna D
    public SelenideElement PorcentajeImportacionRetorno = $x("//*[@id=\"camposTexto.textoGenerico12\"]");
    public SelenideElement PorcentajeImportacionTransferencia = $x("//*[@id=\"camposTexto.textoGenerico15\"]");
    public SelenideElement PorcentajeImportacionDesperdicio = $x("//*[@id=\"camposTexto.textoGenerico18\"]");
    public SelenideElement PorcentajeImportacionConstancia = $x("//*[@id=\"camposTexto.textoGenerico21\"]");

    //DATOS POR GARANTIA
    public SelenideElement tabDatosGarantia = $x("//*[@id=\"ui-id-3\"]/label");
    public SelenideElement selectNombreInstitucion = $x("//*[@id=\"solicitud.cartaCredito.cveGenerica1\"]");
    public SelenideElement NumFolio = $x("//*[@id=\"numGenericoCarta\"]");
    public SelenideElement fechaExpedicion = $x("//*[@id=\"fechaGenerica1Carta\"]");
    public SelenideElement fechaInicioVigencia = $x("//*[@id=\"fecInicioVigenciaCarta\"]");
    public SelenideElement fechaFinVigencia = $x("//*[@id=\"fecFinVigenciaCarta\"]");
    public SelenideElement ImporteNacional = $x("//*[@id=\"importeGenerico1Carta\"]");
    //Botón Continuar Paso 1
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");

    //PASO2 REQUISITOS NECESARIOS
    public SelenideElement btnContinuarPaso2= $x("//*[@id=\"workingArea\"]/form/div[4]/div/div/input[2]");

    //Paso 3
    public SelenideElement listDocumento1Grid = $x("//*[@id=\"idDoc0\"]");
    public SelenideElement listDocumento2Grid = $x("//*[@id=\"idDoc1\"]");
    public SelenideElement listDocumento3Grid = $x("//*[@id=\"idDoc2\"]");
    public SelenideElement listDocumento4Grid = $x("//*[@id=\"idDoc3\"]");
    public SelenideElement listDocumento5Grid = $x("//*[@id=\"idDoc4\"]");

    public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
    public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
    public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

    //Sub paso 3 Pantalla Adjuntar Documentos
    public SelenideElement btnSelecArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnSelecArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
    public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]");

}
