package COFEPRIS.Tramite260918;

import COFEPRIS.Tramite260918.MainPage260918;
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

public class MainPage260918Test {
    MainPage260918 mainPage260918 = new MainPage260918();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite260918  = new TramitesFirmasLG(
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
    public void Proceso260918() {
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
            loginFirmSoli.login(tramite260918);
            mainPage260918.selecRol.sendKeys("Persona Moral");
            mainPage260918.btnacep.click();
            mainPage260918.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260918.soliSubsecuente.click();
            mainPage260918.folioTramite.sendKeys(FolioRubro);
            mainPage260918.btnBuscarFolio.click();sleep(1000);
            mainPage260918.tablaFolios.doubleClick();
            mainPage260918.btnModificar.click();
            /// Datos de la Solicitud
            mainPage260918.datosSolicitud.click();
            mainPage260918.tipoModificacion.click();
            mainPage260918.justificacionModificacion.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage260918.mercanciaAModificar.click();
            mainPage260918.modificarMercancia.click();
            mainPage260918.clasificacionMod.sendKeys("BIOLOGICOS");
            mainPage260918.especificarClasificacionMod.sendKeys("I. Toxoides");
            mainPage260918.denominacionEspecifica.sendKeys(" Pruebas");
            mainPage260918.denominacionDistintiva.sendKeys(" Pruebas");
            mainPage260918.nombreCientifico.setValue("Nombre Cientifico");
            mainPage260918.tipoProducto.sendKeys("Materia prima");
            mainPage260918.estadoFisico.sendKeys("Solido");
            mainPage260918.fraccionArancelaria.doubleClick();
            mainPage260918.fraccionArancelaria.sendKeys("30039014");
            mainPage260918.umtCantidad.sendKeys("0");
            mainPage260918.umcCantidad.sendKeys("0");
            mainPage260918.umcTipo.sendKeys("Bolsa");
            mainPage260918.presentacion.setValue("Bolsas Prueba");
            mainPage260918.paisOrigenMod.click();
            mainPage260918.quitarPaisO.click();
            mainPage260918.selecPaisO.click();
            mainPage260918.agregarPaisO.click();
            mainPage260918.paisProcedenciaMod.click();
            mainPage260918.quitarPaisProc.click();
            mainPage260918.selecPaisProc.click();
            mainPage260918.agregarPaisProc.click();
            mainPage260918.usoEspecifico.click();
            mainPage260918.btnModificarMercancia.click();
            mainPage260918.rfcRepresentante.sendKeys("LEQI8101314S7");
            mainPage260918.buscarRfc.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage260918.tercerosRelacionados.click();
            mainPage260918.agregarFabricante.click();
            mainPage260918.terceroNacional.click();
            mainPage260918.terceroMoral.click();
            mainPage260918.terceroRfc.setValue("AFC000526BJ2");
            mainPage260918.terceroRSocial.sendKeys("FABRICANTE PRUEBA");
            mainPage260918.terceroEstado.sendKeys("CHIHUAHUA");
            mainPage260918.terceroMunicipio.sendKeys("ALLENDE");
            mainPage260918.terceroLocalidad.sendKeys("AGUA FRIA");
            mainPage260918.terceroCodigoPostal.sendKeys("33921");
            mainPage260918.terceroColonia.sendKeys("LA LOMA");
            mainPage260918.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260918.terceroNumExterior.sendKeys("25");
            mainPage260918.terceroNumInterior.sendKeys("1");
            mainPage260918.terceroLada.sendKeys("614");
            mainPage260918.terceroNumero.sendKeys("1234567");
            mainPage260918.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260918.guardarTercero.click();
            mainPage260918.agregarDestinatario.click();
            mainPage260918.terceroMoral.click();
            mainPage260918.terceroRfc.setValue("AFC000526BJ2");
            mainPage260918.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260918.terceroEstado.sendKeys("CHIHUAHUA");
            mainPage260918.terceroMunicipio.sendKeys("ALLENDE");
            mainPage260918.terceroLocalidad.sendKeys("AGUA FRIA");
            mainPage260918.terceroCodigoPostal.sendKeys("33921");
            mainPage260918.terceroColonia.sendKeys("LA LOMA");
            mainPage260918.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260918.terceroNumExterior.sendKeys("25");
            mainPage260918.terceroNumInterior.sendKeys("1");
            mainPage260918.terceroLada.sendKeys("614");
            mainPage260918.terceroNumero.sendKeys("1234567");
            mainPage260918.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260918.guardarTercero.click();
            mainPage260918.agregarProveedores.click();
            mainPage260918.terceroMoral.click();
            mainPage260918.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260918.paisTerceros.sendKeys("MEXICO");
            mainPage260918.terceroEstadoTxt.sendKeys("CHIHUAHUA");
            mainPage260918.terceroCodigoPostalTxt.sendKeys("33921");
            mainPage260918.terceroColoniaTxt.sendKeys("LA LOMA");
            mainPage260918.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260918.terceroNumExterior.sendKeys("25");
            mainPage260918.terceroNumInterior.sendKeys("1");
            mainPage260918.terceroLada.sendKeys("614");
            mainPage260918.terceroNumero.sendKeys("1234567");
            mainPage260918.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260918.guardarTercero.click();
            mainPage260918.agregarFacturador.click();
            mainPage260918.terceroMoral.click();
            mainPage260918.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260918.paisTerceros.sendKeys("MEXICO");
            mainPage260918.terceroEstadoTxt.sendKeys("CHIHUAHUA");
            mainPage260918.terceroCodigoPostalTxt.sendKeys("33921");
            mainPage260918.terceroColoniaTxt.sendKeys("LA LOMA");
            mainPage260918.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260918.terceroNumExterior.sendKeys("25");
            mainPage260918.terceroNumInterior.sendKeys("1");
            mainPage260918.terceroLada.sendKeys("614");
            mainPage260918.terceroNumero.sendKeys("1234567");
            mainPage260918.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260918.guardarTercero.click();
            /// Pago de Derechos
            scrollDecremento();
            mainPage260918.pagoDerechos.click();
            mainPage260918.claveReferencia.sendKeys("81228649");
            mainPage260918.cadenaDepenedencia.sendKeys("123456");
            mainPage260918.banco.sendKeys("BANAMEX");
            mainPage260918.llavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260918.fechaPago, fechaHoy);sleep(1000);
            mainPage260918.importePago.sendKeys("1000");

            mainPage260918.btnGuardarSoli.click();
            mainPage260918.btnContinuar.click();
            mainPage260918.btnAdjuntarDoc.click();
            mainPage260918.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260918.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260918.btnAdjuntar.click();sleep(1000);
            mainPage260918.btnCerrar.click();
            mainPage260918.btnSiguiente.click();
            loginFirmSoli.firma(tramite260918);

            // Obtener el texto del folio desde mainPage260918
            String folioText = mainPage260918.folio.getText();
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
