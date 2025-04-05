package MedioAmbiente.Tramite230401;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage230401 {

    //Tramite SEMARNAT 230401
    public SelenideElement cers = $x("//*[@id='certificate']");
    public SelenideElement keys = $x("//*[@id='privateKey']");
    public SelenideElement passS = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnIngresar = $x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");
    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");


    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");

    public SelenideElement abreMedioamb = $x("/html/body/main/div/div[3]/div/form/a[4]/img");

    public SelenideElement abrirMenu = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/a");
    public SelenideElement abrirAutorizacion = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/a");
    public SelenideElement abrirTramite = $x("/html/body/main/div/div[3]/div/div[6]/ul/li/ul/li[3]/ul/li/a");

    public SelenideElement DatosSoli = $x("//label[@for='solicitud.titulo']");
    public SelenideElement selecValor = $x("//*[@id='solicitud.tipoProducto2304']");
    public SelenideElement noCOFEPRIS = $x("//*[@id=\'solicitud.permisoCOFEPRIS\']");
    public SelenideElement fracAranc =$x("//*[@id=\'fraccionCofepris.clave\']");
    public SelenideElement noCAS =$x("//*[@id=\'detalleMercanciaGrid.numeroLoteDetalle\']");
    public SelenideElement btnAgregar = $x("//*[@id=\'btnAgregarMercancias\']");
    public SelenideElement nombMerca = $x("/html/body/main/div/div[4]/div/form/div[2]/div[3]/div[9]/div[1]/input");
    public SelenideElement cantMerca = $x("//*[@id=\'cantidad\']");
    public SelenideElement unidMedida = $x("//*[@id=\'solicitud.mercancia.unidadMedidaComercial.clave\']");

    public SelenideElement pagoDerechos = $x("/html/body/main/div/div[4]/div/form/div[2]/ul/li[3]/a/label");
    public SelenideElement selecBanco = $x("//*[@id=\'solicitud.pago.banco.clave\']");
    public SelenideElement llaveBanco = $x("//*[@id=\'solicitud.pago.llaveDePago\']");
    public SelenideElement fechaPago = $x("//*[@id=\'calendarTo\']");
    public SelenideElement btnCont =$x("//*[@id=\'guardarSolicitud\']");
    public SelenideElement btnContaDigi =$x("/html/body/main/div/div[4]/div/form/div[4]/div/div/input[2]");
    public SelenideElement btnAdjuntar =$x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[8]/td[2]/div/input[2]");
    public SelenideElement Archivo1 =$x("//*[@id=\"solicitud_0\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement Archivo2 =$x("//*[@id=\"solicitud_1\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement Archivo3 =$x("//*[@id=\"solicitud_2\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement Archivo4 =$x("//*[@id=\"solicitud_3\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement Archivo5 =$x("//*[@id=\"solicitud_4\"]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement Adjuntar =$x("//*[@id=\"btnAnexar\"]");
    public SelenideElement brnCerrar =$x("/html/body/main/div/div[4]/div[2]/form/div[3]/div/input");
    public SelenideElement btnContinuarFirma =$x("//*[@id=\"siguienteButton\"]");


    //solo para el logueo la firma es diferente
    public SelenideElement cersF = $x("//*[@id='certificate']");
    public SelenideElement keysF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");


}
