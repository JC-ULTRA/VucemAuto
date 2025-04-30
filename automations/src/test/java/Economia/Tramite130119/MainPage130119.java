package Economia.Tramite130119;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130120.MainPage130120;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.sql.DriverManager.setLoginTimeout;

public class MainPage130119 {
    public SelenideElement cerS = Selenide.$x("//*[@id='certificate']");
    public SelenideElement keyS = Selenide.$x("//*[@id='privateKey']");
    public SelenideElement pass = Selenide.$x("//*[@id='privateKeyPassword']");

    public SelenideElement btnIngresFs = Selenide.$x("//button[@onclick='ejecutarProcesoFirma(1)']");
    public SelenideElement SelecRol = Selenide.$x("//*[@id='claveRol']");
    public SelenideElement Btnacep = Selenide.$x("//button[@name='ingresar']");
    public SelenideElement tramites = Selenide.$x("//*[@id='Trámites']");
    public SelenideElement SoliNew = Selenide.$x("/html/body/main/div/div[2]/div[1]/div[1]/div/nav/div/div[2]/ul/li[5]/ul/li[3]/a");
    public SelenideElement Economia = Selenide.$x("//img[contains(@alt, 'Economía')]");
    public SelenideElement Permisos = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/a");
    public SelenideElement Importacion = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/a");
    public SelenideElement Tramite130119 = Selenide.$x("/html/body/main/div/div[3]/div/div[6]/ul/li[6]/ul/li[1]/ul/li[17]/a");
    //Scroll
    public SelenideElement Scrol = Selenide.$x("//*[@id=\"logoHeader\"]");
    public SelenideElement DatosSolicitud = Selenide.$x("//*[@id='ui-id-2']");
    public SelenideElement selectSolicitudRegimenClave = Selenide.$x("//*[@id='solicitud.regimen.clave']");
    public SelenideElement selectClasificacionRegimen = Selenide.$x("//*[@id='solicitud.claveClasificacionRegimen']");
    public SelenideElement textareaSolicitudMercanciaDescripcion = Selenide.$x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[3]/div/div/textarea");
    public SelenideElement fraccionArancelaria = $x("//*[@id=\"cveFraccionArancelaria\"]");
    public SelenideElement cantidad = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[4]/div[3]/div/input");
    public SelenideElement valorFacturaUSD = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[5]/div[1]/div/input");
    public SelenideElement paisOrigen = $x("//*[@id=\"solicitud.mercancia.paisOrigen.clave\"]");
    public SelenideElement paisExportador = $x("//*[@id=\"solicitud.mercancia.paisDestino.clave\"]");
    public SelenideElement numeroFactura = $x("//*[@id=\"solicitud.mercancia.numeroFactura\"]");
    public SelenideElement fechaFactura = $x("//*[@id=\"fecSalida\"]");
    public SelenideElement observaciones = $x("//*[@id=\"tabs-2\"]/div[7]/div/div/textarea");
    public SelenideElement estado = $x("//*[@id=\"solicitud.entidadFederativa.entidad.clave\"]");
    public SelenideElement representacionFederal = $x("/html/body/main/div/div[4]/div/form/div[2]/div/div[2]/div[9]/div[2]/div/select");

    public SelenideElement inputGuardarSolicitud = Selenide.$x("//*[@id='guardarSolicitud']");
    public SelenideElement inputContinuar = Selenide.$x("//input[@value='Continuar']");
    public SelenideElement inputAdjuntarDocumentos = Selenide.$x("/html/body/main/div/div[4]/div/form[1]/table/tbody/tr[4]/td[2]/div/input[2]");
    public SelenideElement inputDocumentosFile = Selenide.$x("/html/body/main/div/div[4]/div[2]/div/form[2]/table/tbody/tr[1]/td[4]/input");
    public SelenideElement inputAnexar = Selenide.$x("//*[@id='btnAnexar']");
    public SelenideElement inputCerrar = Selenide.$x("//*[@id='btnCerrar']");
    public SelenideElement inputSiguienteButton = Selenide.$x("//*[@id='siguienteButton']");
    public SelenideElement btnFirmar = $x("//*[@id='btnSubmit']");

    public SelenideElement folio = $x("/html/body/main/div/div[4]/div/div[4]/div/div/ul/li");

    //Solo Firma Funcionario
    public SelenideElement cerfF = $x("//*[@id='certificate']");
    public SelenideElement keyfF = $x("//*[@id='privateKey']");
    public SelenideElement passfF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement btnFirmarfF = $x("//*[@id='btnSubmit']");


    //Dictaminación
    //solo para el logueo la firma es diferente
    public SelenideElement cerF = $x("//*[@id='certificate']");
    public SelenideElement keyF = $x("//*[@id='privateKey']");
    public SelenideElement passF = $x("//*[@id='privateKeyPassword']");
    public SelenideElement getBtnIngresF = $x("//*[@id='btnSubmit']");

    //INICIO
    public SelenideElement Inicio = $x("//img[@alt='       Inicio']");
    public SelenideElement Folio = $x("//*[@id='idNumFolio']");
    public SelenideElement inputBuscarTareasFuncionario = $x("//*[@id='buscarTareasFuncionario']");
    public SelenideElement tdEvaluarSolicitud = $x("//td[@title='Evaluar Solicitud']");

    //Continuar Generar Dictamen
    public SelenideElement GenerarDic = $x("//input[@type='submit']");
    //Sentido AC
    public SelenideElement SentidoDictamen = $x("//input[@value='SEDI.AC']");
    //Justificación Dic
    public SelenideElement JustificacionDic = $x("//*[@id='justificacionDictamen']");
    public SelenideElement AntecendentesTextoDictamen = $x("//*[@id='textoDictamen']");
    //Guardar y Firmar
    public SelenideElement inputMostrarFirma = $x("//input[@value='Firmar']");


}
