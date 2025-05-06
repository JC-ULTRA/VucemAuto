package Economia.Tramite110210;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://wwwqa.ventanillaunica.gob.mx/vucem/Ingreso.html
public class MainPage110210 {
    //Tramite Aviso 110210
    public SelenideElement folio = $x("//*[@id=\"notification\"]/div/ul/li");//*[@id="notification"]/div/ul/li
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");

    public SelenideElement selecRol = $x("//*[@id='claveRol']");
    public SelenideElement btnacep = $x("//button[@name='ingresar']");
    public SelenideElement Tramites = $x("//*[@id='Trámites']");
    public SelenideElement SoliNew = $x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = $x("//img[contains(@alt, 'Economía')]");

    //Elementos para encontrar tramite
    public SelenideElement CertOrigen = $x("/html/body/main/div/div[3]/div/div[6]/ul/li[4]/a");
    public SelenideElement ValidacionCertificado = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/a/span");
    public SelenideElement elementoTramite110210 = $x("//*[@id=\"servicios\"]/ul/li[4]/ul/li[2]/ul/li[10]/a");

    //Certificado
    public SelenideElement tabDuplicadoCertificadoOrigen = $x("//*[@id=\"ui-id-2\"]");

    //Buscar certificado de origen
    public SelenideElement NumeroCertificadoOrigen= $x("//*[@id=\"datosMercancia.numeroCertificado\"]");
    public SelenideElement selectPaisBloque= $x("//*[@id=\"solicitud.clavePaisSeleccionado\"]");
    public SelenideElement selectTratoAcuerdo = $x("//*[@id=\"solicitud.idTratadoAcuerdoSeleccionado\"]");
    public SelenideElement btnBtnbuscarCertificadoNumero = $x("//*[@id=\"buscarCertificadosPorNumero\"]");
    public SelenideElement btnbuscarCertificadoPais = $x("//*[@id=\"buscarListaCertificados\"]");
    //Tabla de certificados
    public SelenideElement tablaNumCertificadoFila1 = $x("//*[@id=\"3\"]/td[1]");
    public SelenideElement btnContinuarPaso1 = $x("//*[@id=\"guardarSolicitud\"]");
}

