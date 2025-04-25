package HACIENDA.Tramite32608;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32608 {
 public SelenideElement cerS = $x("//*[@id='certificate']");
 public SelenideElement keyS = $x("//*[@id='privateKey']");
 public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
 public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
 public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
 public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
 public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
 public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
 public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
 public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
 public SelenideElement Hacienda = Selenide.$x("//*[@id=\"workingArea\"]/form/a[1]/img");

 // public SelenideElement tituloAgacetext = $x("//*[@id=\"workingArea\"]/h2[2]");
 //public SelenideElement menuAGACE = $x("//*[@id=\"servicios\"]/ul/li/a/span");
 //public SelenideElement menuRegistroEsquemaIntegralCE = Selenide.$x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
 //public SelenideElement elemTramite32608 = Selenide.$x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/ul/li[5]/a");
 public SelenideElement menuAGACERegistroCE = Selenide.$x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");//*[@id="servicios"]/ul/li/ul/li[7]/a/span
 public SelenideElement submenuSREIC = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/a/span");
 public SelenideElement elemTramite32608 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/ul/li[5]/a");//*[@id="servicios"]/ul/li/ul/li[7]/ul/li[5]/a

 //TRAMITE
 //Datos comunes
 //Seccion 1 Listas
 public SelenideElement tabDatosComunes = $x("//*[@id=\"tabs\"]/ul/li[2]/a/label");
 public SelenideElement listSectorProduct = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
 //Seccion Radio botones
 public SelenideElement listServicio = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[1].catalogo\"]");
 public SelenideElement radSicumplimientoObligaciones = $x("//*[@id=\"si190\"]");
 public SelenideElement radSiAutorizarSatOpinion = $x("//*[@id=\"si191\"]");
 public SelenideElement radSiEmpleadosIMSS = $x("//*[@id=\"emPropiosSi\"]");
 //Despliega para radio boton IMSS
 public SelenideElement NumEmpleadosPropios = $x("//*[@id=\"empPropios\"]");
 public SelenideElement listBimestreEmpleadosPropios = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");

 public SelenideElement radSiISRTrabajadores = $x("//*[@id=\"isrSi\"]");
 public SelenideElement radSiPagoObrero = $x("//*[@id=\"obreroPatronalesSi\"]");
 public SelenideElement radSiSubcontraServEspecial = $x("//*[@id=\"si2011\"]");

 //Revisar Subcotrato = Si
 public SelenideElement agregarSubcontratado = $x("//*[@id=\"agregarSubcontratado\"]");
 public SelenideElement rfcSubcontratado = $x("//*[@id=\"subcontratado.rfcBusqueda\"]");
 public SelenideElement btnBuscarRfcSubcontratado = $x("/html/body/div[9]/div[2]/table/tbody/tr[1]/td/div/div[1]/input[2]");
 public SelenideElement numEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.empleados\"]");
 public SelenideElement bimestreEmpleadosSubcontratados = $x("//*[@id=\"subcontratado.bimestre\"]");
 public SelenideElement btnAñadirSubcontratados = $x("/html/body/div[9]/div[2]/table/tbody/tr[2]/td/input[2]");
 public SelenideElement btnAceptarSubcontratados = $x("/html/body/div[13]/div[3]/div/button/span");
 //
 public SelenideElement radSiRegistroPadron = $x("//*[@id=\"si236\"]");
 public SelenideElement radNoArticulo69 = $x("//*[@id=\"no237\"]");
 public SelenideElement radNoArticulo69BCFF = $x("//*[@id=\"no238\"]");
 public SelenideElement radNoArticulo69BBis = $x("//*[@id=\"no462\"]");
 public SelenideElement radSiSellosVigentes = $x("//*[@id=\"si239\"]");
 public SelenideElement radNoInfracArt17HBis = $x("//*[@id=\"no240\"]");
 //Seccion Lista 2 y Tabla
 public SelenideElement listDomicilioRegistrado = $x("//*[@id=\"IMMEX\"]");
 public SelenideElement btnAgregarInstalaciones = $x("//*[@id=\"btnAgregarDomicilios\"]");
 public SelenideElement listEntidadInstalacion = $x("//*[@id=\"entidadFederativaIDC\"]");
 public SelenideElement seleccionarInstalacion = $x("//*[@id=\"jqg_gridDomiciliosModal_3\"]");
 public SelenideElement btnAceptarInstalaciones = $x("/html/body/div[10]/div[2]/table/tbody/tr[4]/td/input[1]");
 public SelenideElement selecInstalacionAModificar = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[4]/tbody/tr[8]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
 public SelenideElement btnmodificarInstalacion = $x("//*[@id=\"btnModificarDomicilios\"]");

 //Modificacion instalacion (Revisar)
 public SelenideElement radSiInstalacionPrincipal = $x("//*[@id=\"siInstalacion\"]");
 public SelenideElement listTipoInstalacion = $x("//*[@id=\"domicilio.tipoInstalacion\"]");
 public SelenideElement radSiProcesoProductivo = $x("//*[@id=\"siProcesoProd\"]");
 public SelenideElement radSiUsoGoceInmueble = $x("//*[@id=\"siAcreditaIn\"]");
 public SelenideElement radSiComercioExterior = $x("//*[@id=\"siOperacionesCExt\"]");
 public SelenideElement radSiReconocimientoMutuo = $x("//*[@id=\"siInstalacionCtpat\"]");
 public SelenideElement radNoPerfilEmpresa = $x("//*[@id=\"noPerfil\"]");
 public SelenideElement btnHacerModificacion = $x("/html/body/div[25]/div[2]/table/tbody/tr[15]/td/input[1]");
 public SelenideElement btnAceptarModificacion = $x("/html/body/div[14]/div[2]/table/tbody/tr[15]/td/input[1]");
 public SelenideElement btnAceptarodNotificacionMod= $x("/html/body/div[15]/div[3]/div/button/span"); //Seccion Radio botones2
 public SelenideElement radSiArticulo17K = $x("//*[@id=\"si243\"]");
 public SelenideElement radNoSuspesionPadron = $x("//*[@id=\"no244\"]");

 //Clientes y Proveedores en el Extranjero
 public SelenideElement ProvedoresExtranjeros = $x("//*[@id=\"archivo\"]");
 public SelenideElement btnAgregarProvedoresExtranjeros = $x("//*[@id=\"uploadFileExtranjeros\"]");
 public SelenideElement btnOKClientProvNotificacion= $x("/html/body/div[16]/div[3]/div/button/span");
 //Proveedores
 public SelenideElement ProvedoresNacionales = $x("//*[@id=\"archivoNacionales\"]");
 public SelenideElement btnAgregarProvedoresNacionales = $x("//*[@id=\"uploadFileExtranjerosN\"]");
 public SelenideElement btnOkProvedoresNacionales = $x("/html/body/div[19]/div[3]/div/button");

 //Querella
 public SelenideElement radNoQuerella = $x("//*[@id=\"no248\"]");

 //Control Inventarios
 public SelenideElement radSiInventarios = $x("//*[@id=\"siInventario\"]");
 public SelenideElement NombreInventarios = $x("//*[@id=\"nombre.inventario\"]");
 public SelenideElement LugarInventarios = $x("//*[@id=\"lugarR.inventario\"]");
 public SelenideElement checkAnexo24Inventarios = $x("//*[@id=\"anexo.inventario\"]");
 public SelenideElement btnAgregarInventario = $x("//*[@id=\"btnAgregar.inventario\"]");
 public SelenideElement radSiRMF = $x("//*[@id=\"si251\"]");
 public SelenideElement btnAceptarInventariosNtf=  $x("/html/body/div[19]/div[3]/div/button/span");
 //Agregar Miembro
 public SelenideElement inputAgregarSocio = $x("//*[@id='agregarSocio']");
 public SelenideElement selectSocioCaracter = $x("//*[@id='socio.caracterDe']");
 public SelenideElement selectSocioCaracter2 = $x("//*[@id='socio.caracterDe']");
 public SelenideElement inputSocioTributarMexico = $x("//*[@id='socio.tributarMexicoTrue']");
 public SelenideElement inputSocioBusqueda = $x("//*[@id='socio.rfcBusqueda']");
 public SelenideElement inputBuscar2 = $x("//input[@onclick='javaScript:buscarSocioRFC();']");
 public SelenideElement selectSocioNacionalidad = $x("//*[@id='socio.nacionalidad']");
 public SelenideElement inputSocioAgregarModal = $x("//*[@id='btnSocioAgregarModal']");
 public SelenideElement btnAceptarMiembroNtf = $x("/html/body/div[20]/div[3]/div/button/span");
 public SelenideElement inputMapDeclaracionSolicitudAcepto14 = $x("//*[@id='no463']");
 public SelenideElement inputAcepto = $x("//*[@id='acepto252']");
 public SelenideElement inputAcepto2 = $x("//*[@id='acepto253']");

 //Terceros relacionados
 public SelenideElement labelTercerosRelacionados = $x("//label[contains(@for, 'terceros')]");
 public SelenideElement inputTercero = $x("//*[@id='rfcTercero']");
 public SelenideElement inputBuscar3 = $x("//*[@id='buscar']");
 public SelenideElement spanAceptar8 = $x("/html/body/div[21]/div[3]/div/button/span");
 public SelenideElement inputAgregarEnlaceOperativo = $x("//*[@id='btnAgregarEnlaceOperativo']");
 public SelenideElement input = $x("//*[@id='rfc']");
 public SelenideElement inputBuscarEnlaceOperativo = $x("//*[@id='buscarEnlaceOperativo']");
 public SelenideElement inputTerceroEnlaceOperativoSuplente = $x("//*[@id='terceroEnlaceOperativo.suplente']");
 public SelenideElement inputAceptarEnlace = $x("//*[@id='btnAceptarEnlace']");

 //SECIIT
 public SelenideElement tabSECIIT = $x("//*[@id=\"tabs\"]/ul/li[4]/a");
 public SelenideElement radbtnSiOperacionesExteriores = $x("//*[@id=\"comExtSi\"]");
 public SelenideElement radbtnNoOperacionesExteriores = $x("//*[@id=\"comExtNo\"]");
 public SelenideElement fechaInicioOperacionesExt = $x("//*[@id=\"fechaIniOperaComExt\"]");
 //Pago de derecho
 public SelenideElement fechaPagoDerecho = $x("//*[@id=\"fechaPagoOEA\"]");
 public SelenideElement MontoDerecho = $x("//*[@id=\"montoOEA\"]");
 public SelenideElement NumeroOperacionBancaria = $x("//*[@id=\"operBancOEA\"]");
 public SelenideElement LLavePago = $x("//*[@id=\"llaveOEA\"]");
 //Inicio Ventana Agregar transportista
 public SelenideElement inputAgregarTransportista = $x("//*[@id='agregarTransportista']");
 public SelenideElement inputTransportistaCertificacion = $x("//*[@id='trRfc']");
 public SelenideElement inputBuscarEmpresa = $x("/html/body/div[22]/div[2]/table/tbody/tr[2]/td/input[2]");
 public SelenideElement inputGuardarTransportista = $x("/html/body/div[22]/div[2]/table/tbody/tr[11]/td/input[1]");
 public SelenideElement btnAceptarTransportistaNtf = $x("/html/body/div[23]/div[3]/div/button/span");
 //Fin Ventana Agregar transportista
 public SelenideElement radbtnSiProgramaIMMEX = $x("//*[@id=\"immexSeciitSi\"]");
 public SelenideElement NumeroImmex = $x("//*[@id=\"numeroSECIIT\"]");
 public SelenideElement ModalidadImmex = $x("//*[@id=\"modalidadSECIIT\"]");
 public SelenideElement radbtnSiRegistroEsquemaCer = $x("//*[@id=\"rubroSeciitSi\"]");
 public SelenideElement radbtnSiArticulo100A = $x("//*[@id=\"operaSeciitSi\"]");
 public SelenideElement AutorizacionPrevista100A = $x("//*[@id=\"seciitAutoPre\"]");
 public SelenideElement fechaRegistro100A = $x("//*[@id=\"fechaRegseciit\"]");
 public SelenideElement NumeroAutorizacion = $x("//*[@id=\"seciitOficio100\"]");
 //Seleccione y acredite al menos uno de los siguientes supuestos:
 public SelenideElement radbtnSiAnexo24= $x("//*[@id=\"apartadoSeciitSi\"]");
 public SelenideElement checkMilTrabajadores = $x("//*[@id=\"chk1\"]");
 public SelenideElement NumTrabajadores = $x("//*[@id=\"seciitNumEmpl\"]");
 public SelenideElement checkActivosfijos = $x("//*[@id=\"chk2\"]");
 public SelenideElement ValorMaquinariaEquipo = $x("//*[@id=\"seciitTotMaq\"]");
 public SelenideElement checkCotizarMercados = $x("//*[@id=\"chk3\"]");
 public SelenideElement radbtnSiSistemaRastreo = $x("//*[@id=\"transSeciitSi\"]");
 public SelenideElement radbtnSiSistemaControl = $x("//*[@id=\"controlSeciitSi\"]");
 public SelenideElement radbtnSiAutorizo = $x("//*[@id=\"si4040Seciit\"]");
 public SelenideElement radbtnInfoPrivada = $x("//*[@id=\"no1089Seciit\"]");

 //CTPAT
 public SelenideElement tabCTPAT = $x("//*[@id=\"ctpatTab\"]/a");
 public SelenideElement radbtnSiAutorizaCTPAT = $x("//*[@id=\"si2089\"]");
 public SelenideElement radbtnSicertificacionCTPAT = $x("//*[@id=\"si2090\"]");
 public SelenideElement radbtnNoFechaCancelacionSuspencion = $x("//*[@id=\"no2091\"]");
 public SelenideElement btnSiguientePaso1= $x("//*[@id=\"guardarSolicitud\"]");

 //Paso 2 Requisitos Necesarios
 public SelenideElement btnContinuarPaso2 = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");

 //Paso 3
 public SelenideElement listDocumento1 = $x("//*[@id=\"idDoc0\"]");
 public SelenideElement listDocumento2 = $x("//*[@id=\"idDoc1\"]");
 public SelenideElement listDocumento3 = $x("//*[@id=\"idDoc2\"]");
 public SelenideElement listDocumento4 = $x("//*[@id=\"idDoc3\"]");
 public SelenideElement listDocumento5 = $x("//*[@id=\"idDoc4\"]");
 public SelenideElement listDocumento6 = $x("//*[@id=\"idDoc5\"]");
 public SelenideElement listDocumento7 = $x("//*[@id=\"idDoc6\"]");
 public SelenideElement listDocumento8 = $x("//*[@id=\"idDoc7\"]");
 public SelenideElement listDocumento9 = $x("//*[@id=\"idDoc8\"]");
 public SelenideElement listDocumento10 = $x("//*[@id=\"idDoc9\"]");
 public SelenideElement listDocumento11 = $x("//*[@id=\"idDoc10\"]");
 public SelenideElement listDocumento12 = $x("//*[@id=\"idDoc11\"]");
 public SelenideElement listDocumento13 = $x("//*[@id=\"idDoc12\"]");
 public SelenideElement listDocumento14 = $x("//*[@id=\"idDoc13\"]");
 public SelenideElement listDocumento15 = $x("//*[@id=\"idDoc14\"]");
 public SelenideElement listDocumento16 = $x("//*[@id=\"idDoc15\"]");
 public SelenideElement listDocumento17 = $x("//*[@id=\"idDoc16\"]");
 public SelenideElement btnAdjuntarDoc = $x("//*[@id=\"docs\"]/tbody/tr[20]/td[2]/input");
 public SelenideElement btnContinuar3 = $x("//*[@id=\"siguienteButton\"]");
 public SelenideElement IconoVerDocumento = $x("//*[@id=\"docs\"]/tbody/tr[3]/td[3]/a/span");
 public SelenideElement btnGuardar = $x("//*[@id=\"guardarButton\"]");

 //Sub paso 3 Ventana Adjuntar Documentos
 public SelenideElement btnSelectArchivo1 = $x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo2 = $x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo3 = $x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo4 = $x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo5 = $x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo6 = $x("//*[@id=\"solicitud_5\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo7 = $x("//*[@id=\"solicitud_6\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo8 = $x("//*[@id=\"solicitud_7\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo9 = $x("//*[@id=\"solicitud_8\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo10 = $x("//*[@id=\"solicitud_9\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo11 = $x("//*[@id=\"solicitud_10\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo12 = $x("//*[@id=\"solicitud_11\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo13 = $x("//*[@id=\"solicitud_12\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo14 = $x("//*[@id=\"solicitud_13\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo15 = $x("//*[@id=\"solicitud_14\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo16 = $x("//*[@id=\"solicitud_15\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement btnSelectArchivo17 = $x("//*[@id=\"solicitud_16\"]/table/tbody/tr[1]/td[4]/input");
 public SelenideElement MensajeCarga = $x("//*[@id=\"divMsgModal\"]");
 public SelenideElement btnCerrar3 = $x("//*[@id=\"btnCerrar\"]/span");//*[@id="btnCerrar"]/span
 public SelenideElement btnAdjuntar2 = $x("//*[@id=\"btnAnexar\"]/span");

 // public SelenideElement nombreElemento = $x("");


}
