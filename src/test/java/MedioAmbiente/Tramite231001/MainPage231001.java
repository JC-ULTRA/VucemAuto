package MedioAmbiente.Tramite231001;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage231001 {
    public SelenideElement cerS = $x("//*[@id='certificate']");
    public SelenideElement keyS = $x("//*[@id='privateKey']");
    public SelenideElement pass = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngres = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement SEMARNAT = $x("/html/body/main/div/div[3]/div/form/a[4]/img");
    public SelenideElement CertLicPerm = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement Semart721 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/a");
    public SelenideElement Tramite231001 = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[6]/ul/li[1]/a");
    public SelenideElement DatosSoli = $x("/html/body/main/div/div[4]/div/div[5]/form/div[2]/ul/li[2]/a");
    public SelenideElement NumRegAmb = $x("//*[@id=\"numeroRegistroAmbiental\"]");
    public SelenideElement Giro = $x("//*[@id=\"descripcionGenerica1\"]");
    public SelenideElement NumIMMEX = $x("//*[@id=\"solicitud.numeroProgramaImmex\"]");
    public SelenideElement BTNAgregarAdmResMat = $x("//*[@id=\"btn-agregar-mercancia\"]");
    public SelenideElement NombreMateriaImport = $x("//*[@id=\"descripcionMercancia\"]");
    public SelenideElement Cantidad = $x("/html/body/main/div/div[4]/div[2]/form/div[4]/div[2]/div/div/input");
    public SelenideElement UnidadMedida = $x("/html/body/main/div/div[4]/div[2]/form/div[5]/div[2]/select");
    public SelenideElement Capitulo = $x("/html/body/main/div/div[4]/div[2]/form/div[6]/div/div/select");
    public SelenideElement Partida = $x("//*[@id=\"partidaFraccion\"]");
    public SelenideElement SubPartida = $x("//*[@id=\"subPartidaFraccion\"]");
    public SelenideElement FraccArancel = $x("//*[@id=\"fraccion\"]");
    public SelenideElement BTNGuardar = $x("/html/body/main/div/div[4]/div[2]/form/div[11]/div/input[1]");
    public SelenideElement AduanaEntrada = $x("//*[@id=\"aduanas\"]");
    public SelenideElement TBNContinuar = $x("//*[@id=\"guardarSolicitud\"]");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //solo para el logueo la firma es diferente
    public SelenideElement cers = $x("//*[@id='certificate']");
    public SelenideElement keys = $x("//*[@id='privateKey']");
    public SelenideElement passS = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresS = $x("//*[@id='btnSubmit']");



}
