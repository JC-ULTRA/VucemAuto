package HACIENDA.Tramite32609;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32609 {

    //public SelenideElement nombreElemento = $x("");
    //Elementos para Login y selección Rol
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");

    //Elementos para acceder al tramite
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Hacienda = Selenide.$x("//*[@id=\"workingArea\"]/form/a[1]/img");
    public SelenideElement menuAGACERegistroCE = Selenide.$x("/html/body/main/div/div[3]/div/div[8]/ul/li/a/span");
    public SelenideElement submenuSREIC = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/a/span");
    public SelenideElement elemTramite32609 = $x("//*[@id=\"servicios\"]/ul/li/ul/li[7]/ul/li[6]/a");

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
    public SelenideElement btnAceptarSubcontratados = $x("/html/body/div[13]/div[3]/div/button");

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
    public SelenideElement btnAceptarInstalaciones = $x("/html/body/div[7]/div[2]/table/tbody/tr[4]/td/input[1]");
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
    public SelenideElement btnAceptarModificacion = $x("/html/body/div[15]/div[3]/div/button");
    public SelenideElement btnHacerModificacion = $x("/html/body/div[14]/div[2]/table/tbody/tr[15]/td/input[1]");

    //Seccion Radio botones2
    public SelenideElement radSiArticulo17K = $x("//*[@id=\"si243\"]");
    public SelenideElement radNoSuspesionPadron = $x("//*[@id=\"no244\"]");

    //Clientes y Proveedores en el Extranjero
    public SelenideElement ProvedoresExtranjeros = $x("//*[@id=\"archivo\"]");
    public SelenideElement btnAgregarProvedoresExtranjeros = $x("//*[@id=\"uploadFileExtranjeros\"]");
    public SelenideElement btnOkProvedoresExtranjeros = $x("/html/body/div[16]/div[3]/div/button");
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

    //Agregar miembro de la empresa
    public SelenideElement btnAgregarMiembro = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement socioCaracterDe = $x("//*[@id=\"socio.caracterDe\"]");






}
