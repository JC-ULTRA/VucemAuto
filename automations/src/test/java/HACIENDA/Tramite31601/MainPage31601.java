package HACIENDA.Tramite31601;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage31601 {
    //Tramite Aviso 31601 Generar Oficio
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement registroComercioExterior = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement solicitudRegistroEsquemaIntegralCertificacion = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[3]/a");
    public SelenideElement tramite31601 = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[3]/ul/li[1]/a");
    public SelenideElement datosComunes = $x("//*[@id=\"tabs\"]/ul/li[2]/a");
    public SelenideElement preOperativNo = $x("//*[@id=\"preOperativoANo\"]");
    public SelenideElement recintoFiscalEstrateg = $x("//*[@id=\"regimen_3\"]");
    public SelenideElement sectorProductivo = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[0].catalogo\"]");
    public SelenideElement servicio = $x("//*[@id=\"solicitud.listaCatalogoSolicitud[1].catalogo\"]");
    public SelenideElement opc1SI = $x("//*[@id=\"si190\"]");
    public SelenideElement opc2SI = $x("//*[@id=\"si191\"]");
    public SelenideElement opc3SI = $x("//*[@id=\"emPropiosSi\"]");
    public SelenideElement nEpleados = $x("//*[@id=\"empPropios\"]");
    public SelenideElement bimestres = $x("//*[@id=\"solicitud.empleadosPropios.bimestre\"]");
    public SelenideElement opc4No = $x("//*[@id=\"no2011\"]");
    public SelenideElement opc5No = $x("//*[@id=\"no237A\"]");
    public SelenideElement opc6No = $x("//*[@id=\"no238A\"]");
    public SelenideElement opc7si = $x("//*[@id=\"si239\"]");
    public SelenideElement opc8No = $x("//*[@id=\"no240A\"]");
    public SelenideElement opc9Si = $x("//*[@id=\"si243\"]");
    public SelenideElement opc10No = $x("//*[@id=\"no244A\"]");
    public SelenideElement opc11Autorizacion = $x("//*[@id=\"IMMEX\"]");
    public SelenideElement btnAgregar = $x("//*[@id=\"btnAgregarDomicilios\"]");
    public SelenideElement entidadFederativa = $x("//*[@id=\"entidadFederativaIDC\"]");
    public SelenideElement checkInstalaciones = $x("//*[@id=\"cb_gridDomiciliosModal\"]");
    public SelenideElement btnAceptarInstalaciones = $x("/html/body/div[9]/div[2]/table/tbody/tr[4]/td/input[1]");
    public SelenideElement clienteProveedorExtranjero = $x("//*[@id=\"archivo\"]");
    public SelenideElement clienteProveedorExtranjeroAnexar = $x("//*[@id=\"uploadNewFileExtranjeros\"]");
    public SelenideElement proveedoresNacionales = $x("//*[@id=\"archivoNacionales\"]");
    public SelenideElement proveedoresNacionalesAnexar = $x("//*[@id=\"uploadFileExtranjerosN\"]");
    public SelenideElement querellaNo = $x("//*[@id=\"no705\"]");
    public SelenideElement controlInventarioSi = $x("//*[@id=\"siInventario\"]");
    public SelenideElement nombreSistemaDatosIdentificacion = $x("//*[@id=\"nombre.inventario\"]");
    public SelenideElement lugarRadicacion = $x("//*[@id=\"lugarR.inventario\"]");
    public SelenideElement anexi24Check = $x("//*[@id=\"anexo.inventario\"]");
    public SelenideElement btnAgregarControlInventario = $x("//*[@id=\"btnAgregar.inventario\"]");

    public SelenideElement opc12Si = $x("//*[@id=\"si251\"]");
    public SelenideElement opc13No = $x("//*[@id=\"no706\"]");
    public SelenideElement opc14No = $x("//*[@id=\"no707\"]");
    public SelenideElement opc15No = $x("//*[@id=\"no708\"]");
    public SelenideElement btnAgregarMiembroEmpresa = $x("//*[@id=\"agregarSocio\"]");
    public SelenideElement enCaracterDe = $x("//*[@id=\"socio.caracterDe\"]");
    public SelenideElement obligadoTributarMexNo = $x("/html/body/div[14]/div[2]/form/table/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/input");
    public SelenideElement TipPersonaEmpresa = $x("//*[@id=\"socio.tipoPersona\"]");
    public SelenideElement nombreEmpresa = $x("//*[@id=\"socio.nombreEmpresa\"]");
    public SelenideElement nacionalidad = $x("//*[@id=\"socio.nacionalidad\"]");
    public SelenideElement btnAceptalEmpresa = $x("//*[@id=\"btnSocioAgregarModal\"]");
    public SelenideElement btnAceptalEmpresa2 = $x("/html/body/div[19]/div[3]/div/button");

    public SelenideElement manif1Check = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[2]/div[2]/table[12]/tbody/tr[1]/td/input");
    public SelenideElement manif2Check = $x("//*[@id=\"acepto253\"]");

    //Terceros Relacionados
    public SelenideElement tercerosRelacionados = $x("//*[@id=\"tabs\"]/ul/li[3]/a");
    public SelenideElement rfc = $x("//*[@id=\"rfcTercero\"]");
    public SelenideElement btnBuscar = $x("//*[@id=\"buscar\"]");
    public SelenideElement btnAceptarRFC = $x("/html/body/div[20]/div[3]/div/button");
    //public SelenideElement btnAceptarRFC = $x("/html/body/div[16]/div[3]/div/button");
    public SelenideElement telefonoTerceroR = $x("//*[@id=\"terceroRepresentanteLegal.telefono\"]");
    public SelenideElement btnAgregarTerceroR = $x("//*[@id=\"btnAgregarEnlaceOperativo\"]");
    public SelenideElement rfcTerceroR2 = $x("//*[@id=\"rfc\"]");
    public SelenideElement btnBuscar2 = $x("//*[@id=\"buscarEnlaceOperativo\"]");
    public SelenideElement inputCargo = $x("//*[@id=\"terceroEnlaceOperativo.puesto\"]");
    public SelenideElement btnAceptar3 = $x("//*[@id=\"btnAceptarEnlace\"]");
    public SelenideElement checkSuplenteOpcional = $x("//*[@id=\"terceroEnlaceOperativo.suplente\"]");

    //Datos por Regimen
    public SelenideElement datosRegimen = $x("//*[@id=\"datPorReg\"]/a");
    public SelenideElement check1No = $x("//*[@id=\"no88A\"]");
    public SelenideElement check2Si = $x("//*[@id=\"si89\"]");

    //IVA e IEPS A
    public SelenideElement ivaEIepsA = $x("//*[@id=\"tabs\"]/ul/li[5]/a");
    public SelenideElement checkSi = $x("//*[@id=\"si3026a\"]");
    public SelenideElement checkNo = $x("//*[@id=\"no72A\"]");
    public SelenideElement tipoInversion = $x("//*[@id=\'tipo.inversionA\']");
    public SelenideElement ValorPesos = $x("//*[@id=\'cantidad.inversionA\']");
    public SelenideElement descripcionGeneral = $x("//*[@id=\'desc.inversionA\']");
    public SelenideElement btnAgregarTerritorioNacional = $x("//*[@id=\'btnAgregarInversion\']");
    public SelenideElement btnAceptarTerritorio = $x("/html/body/div[21]/div[3]/div/button");
    public SelenideElement CheckNo = $x("//*[@id=\"no702\"]");
    public SelenideElement CheckSi = $x("//*[@id=\"si703\"]");

    //pago
    public SelenideElement nOperacion = $x("//*[@id=\"solicitud.pago.referenciaBancaria\"]");
    public SelenideElement banco = $x("//*[@id=\"solicitud.pago.banco.clave\"]");
    public SelenideElement llavePago = $x("//*[@id=\"solicitud.pago.llaveDePago\"]");
    public SelenideElement fechaPago = $x("//*[@id=\"calendarTo\"]");
    public SelenideElement fechaNum = $x("/html/body/div[2]/table/tbody/tr[2]/td[3]/a");
    public SelenideElement btnContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement btnContinuarDigi = $x("//*[@id=\"workingArea\"]/form/table/tbody/tr/td/input[2]");
    public SelenideElement btnAdjuntar = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[3]/tbody/tr[15]/td[2]/input");
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
    public SelenideElement archivo12 = $x("/html/body/div[7]/div[2]/div/form[13]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement adjuntarTodos = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\'btnCerrar\']");
    public SelenideElement btnSiguienteFirmar = $x("//*[@id=\'siguienteButton\']");
    public SelenideElement cer = $x("//*[@id=\'certificate\']");
    public SelenideElement key = $x("//*[@id=\'privateKey\']");
    public SelenideElement passw = $x("//*[@id=\'privateKeyPassword\']");
    public SelenideElement btnFirmar = $x("//*[@id=\'btnSubmit\']");
    public SelenideElement getFolio = $x("//*[@id=\"notification\"]/div/ul/li");
}
