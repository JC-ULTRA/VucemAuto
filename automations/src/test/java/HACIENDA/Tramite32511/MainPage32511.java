package HACIENDA.Tramite32511;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage32511 {
    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id=\"subenlaces\"]/ul/li[5]/a");
    public SelenideElement SoliNew = $x("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement hacienda = $x("//img[contains(@alt, 'General')]");
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");
    public SelenideElement AgaceRegComExt = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/a");
    public SelenideElement EnvioAvisos = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/a");
    public SelenideElement Tramite32511 = $x("/html/body/main/div/div[3]/div/div[8]/ul/li/ul/li[6]/ul/li[11]/a");
    public SelenideElement TipoAviso = $x("//*[@id=\"ui-id-2\"]");
    public SelenideElement Deport = $x("//*[@id=\"tipoCompetenciasDep\"]");
    public SelenideElement Automov = $x("//*[@id=\"tipoCompetenciaAuto\"]");
    public SelenideElement ImportMercancia = $x("//*[@id=\"archivoMercanciaM\"]");
    public SelenideElement btnCargarArchivo = $x("//*[@id=\"adjuntarMercancia\"]");
    public SelenideElement FechaEvento = $x("//*[@id=\"fechaInicioEvento\"]");
    public SelenideElement Calle = $x("//*[@id=\"calle\"]");
    public SelenideElement NumExt = $x("//*[@id=\"numeroExterior\"]");
    public SelenideElement NumInt = $x("//*[@id=\"numeroInterior\"]");
    public SelenideElement CodPost = $x("//*[@id=\"codigoPostal\"]");
    public SelenideElement EntidadFed = $x("//*[@id=\"solicitud.direccionStOrigen.entidadFederativa.clave\"]");
    public SelenideElement AlcaldiaMun = $x("//*[@id=\"solicitud.direccionStOrigen.delegacionMunicipio.clave\"]");
    public SelenideElement Col = $x("//*[@id=\"solicitud.direccionStOrigen.colonia.clave\"]");
    public SelenideElement FechaFinEvent = $x("//*[@id=\"fechaFinEvento\"]");
    public SelenideElement Competencia = $x("//*[@id=\"descEvento\"]");
    public SelenideElement Calle2 = $x("//*[@id=\"calleDes\"]");
    public SelenideElement NnumExt2 = $x("//*[@id=\"numeroExteriorDes\"]");
    public SelenideElement NumInt2 = $x("//*[@id=\"numeroInteriorDes\"]");
    public SelenideElement CP2 = $x("//*[@id=\"codigoPostalDes\"]");
    public SelenideElement EntFed2 = $x("//*[@id=\"solicitud.direccionProcesoDestruccion.entidadFederativa.clave\"]");
    public SelenideElement AlcMun2 = $x("//*[@id=\"solicitud.direccionProcesoDestruccion.delegacionMunicipio.clave\"]");
    public SelenideElement Col2 = $x("//*[@id=\"solicitud.direccionProcesoDestruccion.colonia.clave\"]");
    public SelenideElement CargaDestruc = $x("//*[@id=\"archivoDestruccion\"]");
    public SelenideElement btnCargarDestruc = $x("//*[@id=\"adjuntarDestruccion\"]");
    public SelenideElement FechaDestrucMerc = $x("//*[@id=\"fechaInicioUsoMerc\"]");
    public SelenideElement HoraDestruc = $x("//*[@id=\"hora\"]");
    public SelenideElement btnContinuar2 = $x("//*[@id=\"guardarSolicitud\"]");

    public SelenideElement btnContinuarDigi = $x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntarDoc = $x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[7]/td[2]/div/input[2]");
    public SelenideElement CargaArch1 = $x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement CargaArch2 = $x("");
    public SelenideElement CargaArch3 = $x("");
    public SelenideElement CargaArch4 = $x("");
    public SelenideElement Calle2 = $x("");

}
