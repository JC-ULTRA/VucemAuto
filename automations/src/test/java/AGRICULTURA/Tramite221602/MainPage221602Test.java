package AGRICULTURA.Tramite221602;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage221602Test {
    MainPage221602 mainPage221602 = new MainPage221602();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite221602  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso221602() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el folio al usuario
        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

        // Validar que el usuario haya ingresado un folio válido de 25 dígitos
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }

        // Confirmar el folio ingresado
        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            /// Fecha del dia
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite221602);
            mainPage221602.selecRol.sendKeys("Persona Moral");
            mainPage221602.btnacep.click();
            mainPage221602.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage221602.soliSubsecuente.click();
            mainPage221602.folioTramite.sendKeys(FolioRubro);
            mainPage221602.btnBuscarFolio.click();sleep(1000);
            mainPage221602.tablaFolios.doubleClick();
            mainPage221602.btnModificar.click();
            /// Datos de la Solicitud
            mainPage221602.datosSolicitud.click();
            mainPage221602.justificacionModificacion.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage221602.numeroGuia.sendKeys("12345771278");
            mainPage221602.numeroFerrocarril.sendKeys("123");
            mainPage221602.selecMercancia.click();
            mainPage221602.modificarMercancia.click();
            mainPage221602.fraccionArancelaria.sendKeys("63051001");sleep(1000);
            mainPage221602.nico.sendKeys("00");
            mainPage221602.descripcion.setValue("BOLSAS DE YUTE");
            mainPage221602.cantidadUmt.setValue("100");
            mainPage221602.cantidadUmc.setValue("10");
            mainPage221602.tipoUmc.sendKeys("Cientos");
            mainPage221602.usoMercancia.sendKeys("Consumo");
            mainPage221602.tipoProducto.sendKeys("Orgánico");
            mainPage221602.numeroLote.setValue("9821896921");
            mainPage221602.paisOrigen.sendKeys("Taiwan");
            mainPage221602.paisProcedencia.sendKeys("Taiwan");
            scrollIncremento();
            mainPage221602.selecNombreCientifico.click();sleep(1000);
            mainPage221602.agregarNombreCientifico.click();
            mainPage221602.btnModificarMercancia.click();
            /// Datos Para la Movilizacion Nacional
            scrollDecremento();scrollDecremento();
            mainPage221602.datosMovilizacion.click();
            mainPage221602.medioTransporte.sendKeys("Aéreo");
            mainPage221602.identificacionTransporte.sendKeys("8612");
            mainPage221602.puntoVerificacion.sendKeys("MULTIMODAL, HUIXTLA, CHIS.");
            /// Terceros Relacionados
            scrollDecremento();
            mainPage221602.tercerosRelacionados.click();
            mainPage221602.selecExportador.click();
            mainPage221602.modExportador.click();
            mainPage221602.personaFisica.click();
            mainPage221602.nombrePFisica.sendKeys("MISAEL");
            mainPage221602.apellido1PFisica.sendKeys("BARRAGAN");
            mainPage221602.apellido2PFisica.sendKeys("RUIZ");
            mainPage221602.guardarTercero.click();
            mainPage221602.selecDestinatario.click();
            mainPage221602.modDestinatario.click();
            mainPage221602.personaFisica.click();
            mainPage221602.nombrePFisica.sendKeys("MISAEL");
            mainPage221602.apellido1PFisica.sendKeys("BARRAGAN");
            mainPage221602.apellido2PFisica.sendKeys("RUIZ");
            mainPage221602.numInterior.sendKeys("1");
            mainPage221602.guardarTercero.click();
            /// Pago de Derechos
            scrollDecremento();
            mainPage221602.pagoDerechos.click();
            mainPage221602.banco.sendKeys("BANAMEX");
            mainPage221602.llavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage221602.fechaPago, fechaHoy);sleep(1000);
            mainPage221602.importePago.sendKeys("1000");

            mainPage221602.btnGuardarSoli.click();
            mainPage221602.btnContinuar.click();
            mainPage221602.btnAdjuntarDoc.click();
            mainPage221602.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage221602.btnAdjuntar.click();sleep(1000);
            mainPage221602.btnCerrar.click();
            mainPage221602.btnSiguiente.click();
            loginFirmSoli.firma(tramite221602);

            // Obtener el texto del folio desde mainPage221602
            String folioText = mainPage221602.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
}
