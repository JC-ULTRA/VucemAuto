package COFEPRIS.Tramite260503;

import COFEPRIS.Tramite260503.MainPage260503;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260503Test {
    MainPage260503 mainPage260503 = new MainPage260503();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260503  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso260503() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
        }

        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);


            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260503);
            mainPage260503.selecRol.sendKeys("Persona Moral");
            mainPage260503.btnacep.click();
            mainPage260503.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260503.SoliNew.click();
            mainPage260503.Cofepris.click();
            mainPage260503.linkCertificadosLicenciasPermisos.click();
            mainPage260503.linkPermisoImportPlagNutriVegTox.click();
            mainPage260503.elementoTramite260503.click();

            //DATOS SOLICITANTE
            mainPage260503.Scrol.scrollTo();
            mainPage260503.labelDatosSolicitud.click();

            //Datos de solicitud
            mainPage260503.Scrol.scrollTo();
            mainPage260503.DatosSolicitud.click();

            mainPage260503.btnEstablecimiento.click();
            mainPage260503.buttonAceptar.click();

            //LLenado de datos
            mainPage260503.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
            mainPage260503.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
            mainPage260503.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

            //Domicilio del establecimiento
            mainPage260503.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
            mainPage260503.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
            mainPage260503.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");
            mainPage260503.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");
            mainPage260503.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");
            mainPage260503.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");
            mainPage260503.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");
            mainPage260503.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

            //Agregar SCIAN
            mainPage260503.btnAgregarScian.click();
            mainPage260503.selectComboScian.sendKeys("311321");
            mainPage260503.btnAgregar2Scian.click();sleep(1000);

            //Aduana entrada
            mainPage260503.selectAduanaEntrada.selectOption("ALTAMIRA");
            mainPage260503.btnAgregarAduanaEntrada.click();
/*
            //CheckAviso
            mainPage260503.checkAvisoFuncionamiento.click();
            mainPage260503.selectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage260503.selectAduanasEntrada.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");
*/
            //Agregar Mercancia
            mainPage260503.btnAgregarAduana.click();
            mainPage260503.inputNombreComercial.sendKeys("PRUEBAS");
            mainPage260503.inputNombrecomun.sendKeys("PRUEBAS QA");
            mainPage260503.inputNombreCientifico.sendKeys("PRUEBAS QUA");
            mainPage260503.inputUsoEspecifico.sendKeys("QA");
            mainPage260503.inputFraccionArancelaria.sendKeys("38089199");
            mainPage260503.inputCantidadUmt.sendKeys("100");
            mainPage260503.inputCantidadUmc.sendKeys("100");
            mainPage260503.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
            mainPage260503.PorcentajeConcentracion.sendKeys("50");

            //País donde se produce o fabrica el ingrediente activo
            mainPage260503.btnDesplegarInfoPaisProductorActivo.click();
            mainPage260503.selectPaisProductorActivo.selectOption("AUSTRIA (REPUBLICA DE)");
            mainPage260503.btnAdd.click();
            //País donde se elabora el producto
            mainPage260503.btnDesplegarInfoPaisElaboraProducto.click();
            mainPage260503.selectPaisElaboraProducto.selectOption("BELGICA (REINO DE)");
            mainPage260503.btnAdd2.click();
            //Pais Proveedor
            mainPage260503.btnDesplegarInfoPaisProveedor.click();
            mainPage260503.selectPaisProveedor.selectOption("CANADA");
            mainPage260503.btnAdd3.click();
            //País de procedencia/País del último puerto de embarque
            mainPage260503.btnDesplegarInfoPaisEmbarque.click();
            mainPage260503.selectPaisEmbarque.selectOption("ESTADOS UNIDOS DE AMERICA");
            mainPage260503.btnAdd4.click();
            //Clasificacion Toxicológica y Objeto importación
            mainPage260503.selectClasficacionTox.selectOption("4");
            mainPage260503.selectObjetoImportacion.selectOption("Aplicación");
            //Agregar la mercancia
            mainPage260503.btnAgregarMercanciaTotalInfo.click();

            //manifiesto y declaraciones
            mainPage260503.checkCumploRequisitosYNormativas.click();
            mainPage260503.radNoHacerPublicoInformacion.click();
            //Repesentante legal
            mainPage260503.RepresentanteRFC.sendKeys("MAVL621207C95");
            mainPage260503.btnBuscarRepresentante.click();

            //TERCEROS RELACIONADOS
            mainPage260503.Scrol.scrollTo().shouldBe(visible);
            mainPage260503.tabTercerosRelacionados.click();

            //Agregar Fabricante
            // Datos Generales
            mainPage260503.btnAgregarFabricante.click();
            mainPage260503.radNacionalTerceros.click();
            mainPage260503.radPersonaMoral.click();
            mainPage260503.TercerosRFC.sendKeys("AAL0409235E6");
            mainPage260503.btnBuscartercero.click();
            mainPage260503.buttonGuardarDatosTercero.click();

            //Agregar Formulador
            mainPage260503.btnAgregarFormulador.click();
            mainPage260503.radNacionalTerceros.click();
            mainPage260503.radPersonaFisica.click();
            mainPage260503.TercerosRFC.sendKeys("LEQI8101314S7");
            mainPage260503.btnBuscartercero.click();
            //Datos personales
            mainPage260503.btnGuardarTercerosFormulador.click();

            //Agregar Proveedor
            mainPage260503.btnAgregarProveedor.click();
            mainPage260503.radNacionalTerceros.click();
            mainPage260503.radPersonaFisica.click();
            mainPage260503.TercerosRFC.sendKeys("RIIJ580624FS1");
            mainPage260503.btnBuscartercero.click();
            //Datos personales
            mainPage260503.btnGuardarTercerosProveedor.click();

            //PAGO DERECHOS
            mainPage260503.Scrol.scrollTo().shouldBe(visible);
            mainPage260503.tabPagoDerechos.click();
            mainPage260503.ClaveReferencia.sendKeys("284000255");sleep(1000);
            mainPage260503.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage260503.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage260503.inpLLavePago.sendKeys(llavePago);sleep(1000);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260503.fechaPago, fechaHoy);sleep(1000);
            mainPage260503.ImportePago.sendKeys("100");
            mainPage260503.btnContinuarDatosCompletos.click();

            sleep(1000);
            //Paso2
            mainPage260503.btnContinuarPaso2.click();

            //Paso 3
            mainPage260503.btnAdjuntarDoc.click();sleep(1000);

            //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
            //Sub Paso 3
            mainPage260503.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260503.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260503.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260503.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260503.btnAdjuntar2.click();sleep(7000);
            mainPage260503.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage260503.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            //mainPage260205.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento6Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage260503.btnContinuar3.click();sleep(1000);

            //Firma
            loginFirmSoli.firma(tramite260503);sleep(4000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage260503.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);;
        }, repeticiones);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 5; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}