package HACIENDA.Tramite10301;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage10301 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement Tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = Selenide.$x("//img[contains(@alt, 'General')]");
    public SelenideElement autorizacionExpImp = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/a");
    public SelenideElement exencionImpuestos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/a");
    public SelenideElement inscripcionRecibir = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[1]/ul/li[1]/ul/li[2]/a");
    public SelenideElement btnAceptar = Selenide.$x("/html/body/div[7]/div[3]/div/button");
    public SelenideElement datosTramite = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[2]");
    public SelenideElement manifiesto0 = Selenide.$x("//*[@id='manifiesto0']");
    public SelenideElement claveAduana = Selenide.$x("//*[@id='cveAduana']");
    public SelenideElement addMercancia = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[1]/div[3]/div[3]/div/input[3]");
    public SelenideElement cultural = Selenide.$x("/html/body/main/div/div[4]/div[2]/form/div[4]/div/select/option[1]");
    public SelenideElement agregarMerc = Selenide.$x("/html/body/main/div/div[4]/div[2]/form/div[5]/div[1]/a/input");
    public SelenideElement tipoMerc = Selenide.$x("//*[@id='descripcionMerc']");
    public SelenideElement usoEspecifico = Selenide.$x("//*[@id='usoEspecifico']");
    public SelenideElement condicionMerc = Selenide.$x("//*[@id='condicionMercancia']");
    public SelenideElement btnAgregar = Selenide.$x("//*[@id='btnAgregarMercancia']");
    public SelenideElement aceptMerc = Selenide.$x("/html/body/div[9]/div[3]/div");
    public SelenideElement nombreDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[2]/div[2]/input");
    public SelenideElement calleDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[3]/div[2]/input");
    public SelenideElement numExtDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[4]/div[2]/input");
    public SelenideElement paisDonante = Selenide.$x("//*[@id='cvePaisId']");
    public SelenideElement cpDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[9]/div[2]/input");
    public SelenideElement estadoDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[10]/div[2]/input");
    public SelenideElement coloniaDonante = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[2]/div[11]/div[2]/input");
    public SelenideElement opcionNo = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div[2]/input[2]");
    public SelenideElement continuar = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement btnSig = Selenide.$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement archivo1 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo2 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[3]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo3 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[4]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo4 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[5]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement archivo5 = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[6]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement btnAdjuntar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement btnCerrar = Selenide.$x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement btnContinuarArchivos = Selenide.$x("//*[@id='siguienteButton']");
    public SelenideElement cer = Selenide.$x("//*[@id='certificate']");
    public SelenideElement key = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement btnFirmar = Selenide.$x("//*[@id='btnSubmit']");
    public SelenideElement folio = Selenide.$x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Pasar a la firma
    public SelenideElement tdConfirmarNotificaciResoluci = $x("//td[@aria-describedby='gridTareasSolicitante_actionName']");
    public SelenideElement inputAcuse = $x("//*[@id='acuse']");
    public SelenideElement notification = $x("//*[@id='notification']/div/ul/li");
    public SelenideElement iniciofun = $x("/html/body/div[1]/div[3]/div[1]/table/tbody/tr[2]/td/a/img");
    public SelenideElement numfolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement btnBuscarFolio = $x("//*[@id=\"buscarTareasFuncionario\"]");
    public SelenideElement tablatarea = $x("/html/body/div[1]/div[3]/div[3]/div/div[3]/div[3]/div[3]/div/table/tbody/tr[2]");
    public SelenideElement generaDict = $x("//*[@id=\"opcion\"]");
    public SelenideElement btmContinuarDict = $x("/html/body/div[1]/div[3]/div[3]/div/form/div[1]/input");
    public SelenideElement sentidoAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table/tbody/tr[2]/td[2]/input[1]");
    public SelenideElement justificacionRequerimiento = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr[4]/td/textarea");
    public SelenideElement inputDictamenAceptado = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/table[1]/tbody/tr[2]/td[2]/input[1]");
    //Autorización
    public SelenideElement btnFirmarAutorizacion = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[2]/input[2]");
    //Firmar
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement inicioFolio = $x("//*[@id=\"idNumFolio\"]");
    public SelenideElement fechIni = $x("//*[@id=\"idFechaInicioVigenciaDictamen\"]");
    public SelenideElement fechFin = $x("/html/body/div[1]/div[3]/div[3]/div/form[1]/div[3]/table/tbody/tr[2]/td[4]/input");
    public SelenideElement scrollEv = $x("/html/body/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[23]");
    public SelenideElement scrollEv2 = $x("/html/body/div[1]/div[3]/div[3]/div/table/tbody/tr[2]/td/div/div[3]/div[3]/div/table/tbody/tr[2]/td[23]/select/option[2]");
    public SelenideElement btnContinuarConfirmacion = $x("//*[@id=\"acuse\"]");
}


