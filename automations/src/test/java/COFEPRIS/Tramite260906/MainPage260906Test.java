package COFEPRIS.Tramite260906;

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

public class MainPage260906Test {
    MainPage260906 mainPage260906 = new MainPage260906();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite260906  = new TramitesFirmasLG(
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
    public void Proceso260906() {
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
            loginFirmSoli.login(tramite260906);
            mainPage260906.selecRol.sendKeys("Persona Moral");
            mainPage260906.btnacep.click();
            mainPage260906.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260906.soliSubsecuente.click();
            mainPage260906.folioTramite.sendKeys(FolioRubro);
            mainPage260906.btnBuscarFolio.click();sleep(1000);
            mainPage260906.tablaFolios.doubleClick();
            mainPage260906.btnModificar.click();
            /// Datos de la Solicitud
            mainPage260906.datosSolicitud.click();
            mainPage260906.tipoModificacion.click();
            mainPage260906.justificacionModificacion.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage260906.mercanciaAModificar.click();
            mainPage260906.modificarMercancia.click();
            mainPage260906.clasificacionMod.sendKeys("BIOLOGICOS");
            mainPage260906.especificarClasificacionMod.sendKeys("I. Toxoides");
            mainPage260906.denominacionEspecifica.sendKeys(" Pruebas");
            mainPage260906.denominacionDistintiva.sendKeys(" Pruebas");
            mainPage260906.nombreCientifico.setValue("Nombre Cientifico");
            mainPage260906.tipoProducto.sendKeys("Materia prima");
            mainPage260906.estadoFisico.sendKeys("Solido");
            mainPage260906.fraccionArancelaria.doubleClick();
            mainPage260906.fraccionArancelaria.sendKeys("30039014");
            mainPage260906.umtCantidad.sendKeys("0");
            mainPage260906.umcCantidad.sendKeys("0");
            mainPage260906.umcTipo.sendKeys("Bolsa");
            mainPage260906.presentacion.setValue("Bolsas Prueba");
            mainPage260906.paisOrigenMod.click();
            mainPage260906.quitarPaisO.click();
            mainPage260906.selecPaisO.click();
            mainPage260906.agregarPaisO.click();
            mainPage260906.paisProcedenciaMod.click();
            mainPage260906.quitarPaisProc.click();
            mainPage260906.selecPaisProc.click();
            mainPage260906.agregarPaisProc.click();
            mainPage260906.usoEspecifico.click();
            mainPage260906.btnModificarMercancia.click();
            mainPage260906.rfcRepresentante.sendKeys("LEQI8101314S7");
            mainPage260906.buscarRfc.click();
            /// Terceros Relacionados
            scrollDecremento();scrollDecremento();
            mainPage260906.tercerosRelacionados.click();
            mainPage260906.agregarFabricante.click();
            mainPage260906.terceroNacional.click();
            mainPage260906.terceroMoral.click();
            mainPage260906.terceroRfc.setValue("AFC000526BJ2");
            mainPage260906.terceroRSocial.sendKeys("FABRICANTE PRUEBA");
            mainPage260906.terceroEstado.sendKeys("CHIHUAHUA");
            mainPage260906.terceroMunicipio.sendKeys("ALLENDE");
            mainPage260906.terceroLocalidad.sendKeys("AGUA FRIA");
            mainPage260906.terceroCodigoPostal.sendKeys("33921");
            mainPage260906.terceroColonia.sendKeys("LA LOMA");
            mainPage260906.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260906.terceroNumExterior.sendKeys("25");
            mainPage260906.terceroNumInterior.sendKeys("1");
            mainPage260906.terceroLada.sendKeys("614");
            mainPage260906.terceroNumero.sendKeys("1234567");
            mainPage260906.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260906.guardarTercero.click();
            mainPage260906.agregarDestinatario.click();
            mainPage260906.terceroMoral.click();
            mainPage260906.terceroRfc.setValue("AFC000526BJ2");
            mainPage260906.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260906.terceroEstado.sendKeys("CHIHUAHUA");
            mainPage260906.terceroMunicipio.sendKeys("ALLENDE");
            mainPage260906.terceroLocalidad.sendKeys("AGUA FRIA");
            mainPage260906.terceroCodigoPostal.sendKeys("33921");
            mainPage260906.terceroColonia.sendKeys("LA LOMA");
            mainPage260906.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260906.terceroNumExterior.sendKeys("25");
            mainPage260906.terceroNumInterior.sendKeys("1");
            mainPage260906.terceroLada.sendKeys("614");
            mainPage260906.terceroNumero.sendKeys("1234567");
            mainPage260906.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260906.guardarTercero.click();
            mainPage260906.agregarProveedores.click();
            mainPage260906.terceroMoral.click();
            mainPage260906.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260906.paisTerceros.sendKeys("MEXICO");
            mainPage260906.terceroEstadoTxt.sendKeys("CHIHUAHUA");
            mainPage260906.terceroCodigoPostalTxt.sendKeys("33921");
            mainPage260906.terceroColoniaTxt.sendKeys("LA LOMA");
            mainPage260906.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260906.terceroNumExterior.sendKeys("25");
            mainPage260906.terceroNumInterior.sendKeys("1");
            mainPage260906.terceroLada.sendKeys("614");
            mainPage260906.terceroNumero.sendKeys("1234567");
            mainPage260906.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260906.guardarTercero.click();
            mainPage260906.agregarFacturador.click();
            mainPage260906.terceroMoral.click();
            mainPage260906.terceroRSocial.sendKeys("DESTINATARIO PRUEBA");
            mainPage260906.paisTerceros.sendKeys("MEXICO");
            mainPage260906.terceroEstadoTxt.sendKeys("CHIHUAHUA");
            mainPage260906.terceroCodigoPostalTxt.sendKeys("33921");
            mainPage260906.terceroColoniaTxt.sendKeys("LA LOMA");
            mainPage260906.terceroCalle.sendKeys("CALLE PRUEBA");
            mainPage260906.terceroNumExterior.sendKeys("25");
            mainPage260906.terceroNumInterior.sendKeys("1");
            mainPage260906.terceroLada.sendKeys("614");
            mainPage260906.terceroNumero.sendKeys("1234567");
            mainPage260906.terceroCorreo.sendKeys("pruebas@pruebas.qa");
            mainPage260906.guardarTercero.click();
            /// Pago de Derechos
            scrollDecremento();
            mainPage260906.pagoDerechos.click();
            mainPage260906.claveReferencia.sendKeys("81228649");
            mainPage260906.cadenaDepenedencia.sendKeys("123456");
            mainPage260906.banco.sendKeys("BANAMEX");
            mainPage260906.llavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260906.fechaPago, fechaHoy);sleep(1000);
            mainPage260906.importePago.sendKeys("1000");

            mainPage260906.btnGuardarSoli.click();
            mainPage260906.btnContinuar.click();
            mainPage260906.btnAdjuntarDoc.click();
            mainPage260906.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260906.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260906.btnAdjuntar.click();sleep(1000);
            mainPage260906.btnCerrar.click();
            mainPage260906.btnSiguiente.click();
            loginFirmSoli.firma(tramite260906);

            // Obtener el texto del folio desde mainPage260906
            String folioText = mainPage260906.folio.getText();
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
