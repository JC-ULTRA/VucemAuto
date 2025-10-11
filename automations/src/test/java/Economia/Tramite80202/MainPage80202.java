package Economia.Tramite80202;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage80202 {
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    //Ingreso y Rol
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");

    //Búsqueda de tramite
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement economia = $x("/html/body/main/div/div[3]/div/form/a[2]/img");
    public SelenideElement IMMEX = $x("//*[@id=\"servicios\"]/ul/li[1]/a/span");
    public SelenideElement ModificacionPrograma = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/a/span");
    public SelenideElement elementoTramite130203 = $x("//*[@id=\"servicios\"]/ul/li[1]/ul/li[3]/ul/li[8]/a");

    //Lista de programas
    public SelenideElement gridPrograma1 = $x("//*[@id=\"3\"]");

    //Pestaña Modificación
    public SelenideElement tabAnexoI = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/ul/li[2]/a");

    public SelenideElement fraccionArancelaria = $x("//*[@id=\"fraccionImportacion\"]");
    public SelenideElement cantidadAnual = $x("//*[@id=\"cantidadAnual\"]");
    public SelenideElement capacidadInstaladaPeriodo = $x("//*[@id=\"cantidadPeriodo\"]");
    public SelenideElement cantidadPeriodo = $x("//*[@id=\"cantidadAutorizada\"]");
    public SelenideElement btnGuardarFraccionImportacion = $x("/html/body/main/div/div[4]/div[2]/div[7]/div[2]/div/input[1]");
    public SelenideElement btnAceptarFracc = $x("/html/body/div[9]/div[3]/div/button");
    public SelenideElement seleccionarFraccion = $x("//*[@id=\"1\"]/td[1]/input");
    public SelenideElement mostrarDetalleMercancia = $x("//*[@id=\"boton.btnDetalleFraccion\"]");
    public SelenideElement Nico = $x("//*[@id=\"idFraccionNico\"]");
    public SelenideElement btnAgregarNico = $x("/html/body/main/div/div[4]/div[2]/div[7]/div/input");
    public SelenideElement btnGuardarDetalle = $x("/html/body/main/div/div[4]/div[2]/div[10]/div[2]/div/input[1]");
    public SelenideElement fraccionArancelariaExportacion = $x("//*[@id=\"fraccionExportacionSen\"]");
    public SelenideElement descripcionProducto = $x("//*[@id=\"descripcionExportacionSen\"]");
    public SelenideElement btnAgregarFraccExp = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[3]/div/div/input[2]");
    public SelenideElement seleccionarFraccionExp = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[4]/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input");
    public SelenideElement mostrarDetalleMercanciaExp = $x("/html/body/main/div/div[4]/div/form[1]/div[2]/div/div[2]/div[4]/div[5]/div/div/input");
    public SelenideElement btnAceptarFracExp = $x("/html/body/div[10]/div[3]/div/button");
    public SelenideElement nicoExp = $x("//*[@id=\"idFraccionNicoExpo\"]");
    public SelenideElement btnAgregarNicoExp = $x("/html/body/main/div/div[4]/div[2]/div[4]/div/input");
    public SelenideElement btnGuardarDetalleExp = $x("/html/body/main/div/div[4]/div[2]/div[7]/div[2]/div/input[1]");
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");


    //Paso 2 Requisitos Necesarios
    public SelenideElement btnContinuarPaso2 = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");

    //Paso 3 Anexar Requisitos
    public SelenideElement btnAnexar = $x("//*[@id=\"btnAnexar\"]");
    public SelenideElement btnCerrar = $x("//*[@id=\"btnCerrar\"]");
    public SelenideElement btnContinuarPaso3 = $x("//*[@id=\"siguienteButton\"]");

    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement justificacionObservacion = $x("//*[@id=\"justificacionId\"]");
    public SelenideElement btnGuardarJust = $x("//*[@id=\"btnAgregar\"]");
    public SelenideElement btnEnviar = $x("//*[@id=\"btnGuardar\"]");
    public SelenideElement sentidoOpinion = $x("//*[@id=\"idAceptada\"]");
    public SelenideElement opinion = $x("//*[@id=\"idDescripcionOpinion\"]");
    public SelenideElement anexarInfoDigitalizada = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div/div/table[2]/tbody/tr[1]/td[2]/input");
    public SelenideElement archivoAnexar = $x("//*[@id=\"archivoAdjuntar\"]");
    public SelenideElement enviarArchivo = $x("//*[@id=\"btnCargaArchivo\"]");
    public SelenideElement justificacionDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/fieldset[1]/table/tbody/tr[4]/td/textarea");
    public SelenideElement antecedentesDictamen = $x("//*[@id=\"textoDictamen\"]");
    public SelenideElement firmarDictamen = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr/td/input[2]");
    public SelenideElement firmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}
