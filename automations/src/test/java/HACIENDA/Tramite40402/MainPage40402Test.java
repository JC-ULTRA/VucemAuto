package HACIENDA.Tramite40402;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite40402.MainPage40402;
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
import java.util.Random;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage40402Test {
    Random random = new Random();
    MainPage40402 mainPage40402 = new MainPage40402();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite40402  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
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
    public void Proceso40402() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Generar números
            int codigo = 100 + random.nextInt(900);
            long nssExtranjero = 100000000L + (long) (random.nextDouble() * 900000000L);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite40402);
            mainPage40402.selecRol.sendKeys("Persona Moral");
            mainPage40402.btnacep.click();
            mainPage40402.Tramites.sendKeys("Solicitudes nuevas");
            mainPage40402.SoliNew.click();
            mainPage40402.hacienda.click();
            mainPage40402.registroCAAT.click();
            mainPage40402.CAATAereo.click();
            mainPage40402.tramite40402.click();
            /// Datos del Tramite
            mainPage40402.datosTramite.click();
            mainPage40402.tipoCAATAereo.sendKeys("Empresa de Mensajería Aérea");
            mainPage40402.codigoTransportacionAerea.sendKeys("IATA");
            mainPage40402.numCodigo.sendKeys(String.valueOf(codigo));
            ///  Asignar Persona
            mainPage40402.asignarPersona.click();
            mainPage40402.personaFisica.click();
            mainPage40402.agregarPersonaFisica.click();
            mainPage40402.nombrePersonaFisica.sendKeys("LIAM");
            mainPage40402.apellidoPaternoPersonaFisica.sendKeys("BROWN");
            mainPage40402.apellidoMaternoPersonaFisica.sendKeys("SMITH");
            mainPage40402.numeroSeguroSocialPersonaFisica.sendKeys(String.valueOf(nssExtranjero));
            mainPage40402.correoElectronicoPersonaFisica.sendKeys("PRUEBAS@PRUEBAS.QA");
            mainPage40402.paisPersonaFisica.sendKeys("CANADA");
            mainPage40402.codigoPostalPersonaFisica.sendKeys("12345");
            mainPage40402.estadoPersonaFisica.sendKeys("CARAQUET");
            mainPage40402.ciudadPersonaFisica.sendKeys("NEW BRUNSWICK");
            mainPage40402.callePersonaFisica.sendKeys("BOULEVARD ST. PIERRE");
            mainPage40402.numeroExteriorPersonaFisica.sendKeys("12");
            mainPage40402.numeroInteriorPersonaFisica.sendKeys("1");
            mainPage40402.guardarPersonaFisica.click();sleep(1000);
            mainPage40402.btnAceptarPersonaFisica.click();
            /// Guardar y Firmar
            mainPage40402.btnGuardarSoli.click();sleep(1000);
            mainPage40402.btnAceptarResponsabilidad.click();
            loginFirmSoli.firma(tramite40402);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage40402.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }
    public void clickAceptarButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(200);
        }
    }
}
