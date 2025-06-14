package MedioAmbiente.Tramite231003;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage231003 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement SEMARNAT = $x("/html/body/main/div/div[3]/div/form/a[4]/img");
    public SelenideElement CertLicPerm = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement Semart721 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/a");
    public SelenideElement labelAvisoReciclaje = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/ul/li[3]/a");
    public SelenideElement DatosSoli = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement retornoPrimeraVez = $x("//*[@id=\"avisoPrimera\"]");
    public SelenideElement retornoSubsecuente = $x("//*[@id=\"avisoSubsecuente\"]");
    public SelenideElement numRegistroAmbiental = $x("//*[@id=\"numeroRegistroAmbiental\"]");
    public SelenideElement giroImportador = $x("//*[@id=\"descripcionGenerica1\"]");
    public SelenideElement numIMMEX = $x("//*[@id=\"solicitud.numeroProgramaImmex\"]");
    public SelenideElement btnAgregarResiduoRetorno = $x("//*[@id=\"btn-agregar-residuoRetorno\"]");
    public SelenideElement residuoMateriaPrima = $x("//*[@id=\"tipoMateria\"]");
    public SelenideElement numBitacora = $x("//*[@id=\"numeroBitacora\"]");
    public SelenideElement btnBuscarBitacora = $x("/html/body/main/div/div[4]/div[2]/form/div[6]/div[2]/div/input");
    public SelenideElement nombreMateriaPrima = $x("//*[@id=\"idMercancia\"]");
    public SelenideElement btnArgregarMateriaPrima = $x("//*[@id=\"btn-agregar-mercancia\"]");
    public SelenideElement fraccionArancelaria = $x("//*[@id=\"fraccionNico\"]");
    public SelenideElement nico = $x("//*[@id=\"cveNico\"]");
    public SelenideElement nombreResiduoPeligroso = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement cantidad = $x("//*[@id=\"generica2\"]");
    public SelenideElement unidadMedida = $x("//*[@id=\"unidadMedidaComercial.clave\"]");
    public SelenideElement tipoClave = $x("//*[@id=\"clasifClave\"]");
    public SelenideElement claveResiduo = $x("//*[@id=\"residuoClave\"]");
    public SelenideElement tipoNombre = $x("//*[@id=\"clasifNombre\"]");
    public SelenideElement nombre = $x("//*[@id=\"residuoNombre\"]");
    public SelenideElement tipoDescripcion = $x("//*[@id=\"clasifDescrip\"]");
    public SelenideElement descripcion = $x("//*[@id=\"residuoDescripcion\"]");
    public SelenideElement creti = $x("//*[@id=\"atributos[0].valorDeLaEnumeracion\"]");
    public SelenideElement estadoFisico = $x("//*[@id=\"estadoFisico\"]");
    public SelenideElement numManifiesto = $x("//*[@id=\"numeroOficioCasoEspecial\"]");
    public SelenideElement tipoContenedor = $x("//*[@id=\"catalogos[1].catalogoD.clave\"]");
    public SelenideElement capacidad = $x("//*[@id=\"descripcionOtrasEspecificaciones\"]");
    public SelenideElement btnAgregarMercancia = $x("//*[@id=\"btn-agregar-modal\"]");

    public SelenideElement transportista = $x("//*[@id=\"empresaTransportista\"]");
    public SelenideElement numAutorizacionSemarnat = $x("//*[@id=\"numAutorizacion\"]");
    public SelenideElement requiereOtraEmpreza = $x("//*[@id=\"siEmpresa\"]");
    public SelenideElement empresaRetorno = $x("//*[@id=\"empresaServicioRetorno\"]");
    public SelenideElement representanteRetorno = $x("//*[@id=\"nomRepresentante\"]");
    public SelenideElement telefonoRetorno = $x("//*[@id=\"caracterEmpresa\"]");
    public SelenideElement correoRetorno = $x("//*[@id=\"correoElectronico\"]");
    public SelenideElement precausionesRegistro = $x("//*[@id=\"valueTA\"]");
    public SelenideElement inputSiReciclaje = $x("//*[@id=\"siLugarRecicla\"]");
    public SelenideElement inputNoReciclaje = $x("//*[@id=\"noLugarRecicla\"]");
    public SelenideElement inputLugar = $x("//*[@id=\"descripcionGenerica2\"]");
    public SelenideElement inputNumAutorizacion = $x("//*[@id=\"descripcionGenerica3\"]");
    public SelenideElement aduanaSalida = $x("//*[@id=\"solicitud.aduanasSalida[0].clave\"]");

    public SelenideElement nombreDestintario = $x("//*[@id=\"destinoRazonsocial\"]");
    public SelenideElement paisDestino = $x("//*[@id=\"solicitud.destinatario.domicilio.pais.clave\"]");
    public SelenideElement domicilioDestino = $x("//*[@id=\"destinoDomicilio\"]");
    public SelenideElement codigoPostalDestino = $x("//*[@id=\"destinoCodigo\"]");
    public SelenideElement btnGuardarSoli = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
}