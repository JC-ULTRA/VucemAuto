package COFEPRIS.Tramite260903;

import COFEPRIS.Tramite260903.MainPage260903;
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

public class MainPage260903Test {
    MainPage260903 mainPage260903 = new MainPage260903();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite260903  = new TramitesFirmasLG(
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
    public void Proceso260903() {
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
            loginFirmSoli.login(tramite260903);
            mainPage260903.selecRol.sendKeys("Persona Moral");
            mainPage260903.btnacep.click();
            mainPage260903.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260903.soliSubsecuente.click();
            mainPage260903.folioTramite.sendKeys(FolioRubro);
            mainPage260903.btnBuscarFolio.click();sleep(1000);
            mainPage260903.tablaFolios.doubleClick();
            mainPage260903.btnModificar.click();
            /// Datos de la Solicitud
            mainPage260903.datosSolicitud.click();
            mainPage260903.tipoModificacion.click();
            mainPage260903.justificacionModificacion.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage260903.mercanciaAModificar.click();
            mainPage260903.modificarMercancia.click();
            mainPage260903.clasificacionMod.sendKeys("BIOLOGICOS");
            mainPage260903.especificarClasificacionMod.sendKeys("I. Toxoides");
            mainPage260903.denominacionEspecifica.sendKeys(" Pruebas");
            mainPage260903.nombreCientifico.doubleClick();
            mainPage260903.nombreCientifico.setValue("Nombre Cientifico");
            mainPage260903.tipoProducto.sendKeys("Materia prima");
            mainPage260903.estadoFisico.sendKeys("Solido");
            mainPage260903.fraccionArancelaria.doubleClick();
            mainPage260903.fraccionArancelaria.setValue("30039014");
            mainPage260903.umtCantidad.sendKeys("0");
            mainPage260903.umcCantidad.sendKeys("0");
            mainPage260903.umcTipo.sendKeys("Bolsa");
            mainPage260903.paisOrigenMod.click();
            mainPage260903.quitarPaisO.click();
            mainPage260903.selecPaisO.click();
            mainPage260903.agregarPaisO.click();
            mainPage260903.paisProcedenciaMod.click();
            mainPage260903.quitarPaisProc.click();
            mainPage260903.selecPaisProc.click();
            mainPage260903.agregarPaisProc.click();
            mainPage260903.usoEspecifico.click();
            mainPage260903.usoAgregarTodos.click();
            mainPage260903.formaFarmaceutica.sendKeys("POLVO");
            mainPage260903.numRegistroSanitario.sendKeys("123456");
            mainPage260903.marcasDistintivas.sendKeys("POLVO PRUEBA");
            mainPage260903.presentacionFarmaceutica.sendKeys("EMPAQUE PRUEBAS");
            mainPage260903.btnAgregarDetalle.click();
            mainPage260903.btnModificarMercancia.click();
            mainPage260903.rfcRepresentante.setValue("LEQI8101314S7");
            mainPage260903.buscarRfc.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage260903.tercerosRelacionados.click();
            mainPage260903.selecFabricante.click();
            mainPage260903.modFabricante.click();
            mainPage260903.codigoPostalMod.sendKeys("3");
            mainPage260903.calleMod.setValue("CALLE DE PRUEBA");
            mainPage260903.guardarMod.click();
            mainPage260903.selecDestinatarioFinal.click();
            mainPage260903.modDestinatario.click();
            mainPage260903.codigoPostalMod.sendKeys("3");
            mainPage260903.calleMod.setValue("CALLE PRUEBA");
            mainPage260903.guardarMod.click();
            mainPage260903.selecProveedor.click();
            mainPage260903.modProveedor.click();
            mainPage260903.calleMod.setValue("CALLE PRUEBA");
            mainPage260903.guardarMod.click();
            mainPage260903.selecFacturador.click();
            mainPage260903.modFacturador.click();
            mainPage260903.calleMod.setValue("CALLE PRUEBA");
            mainPage260903.guardarMod.click();
            /// Pago de Derechos
            scrollDecremento();
            mainPage260903.pagoDerechos.click();
            mainPage260903.claveReferencia.sendKeys("81228649");
            mainPage260903.cadenaDepenedencia.sendKeys("123456");
            mainPage260903.banco.sendKeys("BANAMEX");
            mainPage260903.llavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260903.fechaPago, fechaHoy);sleep(1000);
            mainPage260903.importePago.sendKeys("1000");

            mainPage260903.btnGuardarSoli.click();
            mainPage260903.btnContinuar.click();
            mainPage260903.btnAdjuntarDoc.click();
            mainPage260903.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260903.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260903.btnAdjuntar.click();sleep(1000);
            mainPage260903.btnCerrar.click();
            mainPage260903.btnSiguiente.click();
            loginFirmSoli.firma(tramite260903);

            // Obtener el texto del folio desde mainPage260903
            String folioText = mainPage260903.folio.getText();
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
        for (int i = 0; i < 3; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
}
