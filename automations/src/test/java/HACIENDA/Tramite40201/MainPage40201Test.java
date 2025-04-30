package HACIENDA.Tramite40201;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite40201.MainPage40201;
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
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage40201Test {
    MainPage40201 mainPage40201 = new MainPage40201();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite40201  = new TramitesFirmasLG(
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
    public void Proceso40201() {
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
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite40201);
            mainPage40201.selecRol.sendKeys("Persona Moral");
            mainPage40201.btnacep.click();
            mainPage40201.Tramites.sendKeys("Solicitudes nuevas");
            mainPage40201.SoliNew.click();
            mainPage40201.hacienda.click();
            mainPage40201.registroCAAT.click();
            mainPage40201.CAATMaritima.click();
            mainPage40201.tramite40201.click();
            /// Asignar CAAT Maritimo
            mainPage40201.asignarCAAT.click();
            mainPage40201.personaFisicaNacional.click();
            mainPage40201.agregarPersonaFisicaN.click();sleep(1000);
            mainPage40201.rfcPrsonaFisicaN.sendKeys("LODD561211LQ5");
            mainPage40201.btnBuscarRfcPersonaFisicaN.click();sleep(1000);
            mainPage40201.btnGuardarPersonaFisicaN.click();
            mainPage40201.personaMoralNacional.click();
            mainPage40201.agregarPersonaMoralN.click();
            mainPage40201.rfcPersonaMoralN.sendKeys("LOG020606TJ3");
            mainPage40201.btnBuscarRfcPersonaMoralN.click();sleep(1000);
            mainPage40201.nombreDirector.sendKeys("DIEGO");
            mainPage40201.apellidoPaternoDirector.sendKeys("DIAZ");
            mainPage40201.apellidoMaternoDirector.sendKeys("DIAZ");
            mainPage40201.btnGuardarPersonaMoralN.click();
            mainPage40201.personaFisicaExtranjera.click();
            mainPage40201.agregarPersonaFisicaE.click();
            mainPage40201.numeroSeguridadSocial.sendKeys("912834028");
            mainPage40201.nombrePersonaFisicaE.sendKeys("LIAM");
            mainPage40201.primerApellidoPersonaFisicaE.sendKeys("SMITH");
            mainPage40201.segundoApellidoPersonaFisicaE.sendKeys("BROWN");
            mainPage40201.correoPersonaFisicaE.sendKeys("PRUEBAS@PRUEBAS.QA");
            mainPage40201.paisPersonaFisicaE.sendKeys("CANADA");
            mainPage40201.codigoPostalPersonaFisicaE.sendKeys("12345");
            mainPage40201.ciudadPersonaFisicaE.sendKeys("CARAQUET");
            mainPage40201.estadoPersonaFisicaE.sendKeys("NEW BRUNSWICK");
            mainPage40201.callePersonaFiscaE.sendKeys("BOULEVARD ST. PIERRE");
            mainPage40201.numeroExterior.sendKeys("12");
            mainPage40201.numeroInterior.sendKeys("1");
            mainPage40201.btnGuardarPersonaFisicaE.click();
            mainPage40201.personaMoralExtranjera.click();
            mainPage40201.agregarPersonaMoralExtranjera.click();
            mainPage40201.razonSocialPersonaMoralE.sendKeys("EMPRESA MARITIMA EXTRANJERA");
            mainPage40201.correoPersonaMoralE.sendKeys("PRUEBAS@PRUEBAS.QA");
            mainPage40201.paisPersonaMoralE.sendKeys("CANADA");
            mainPage40201.codigoPostalPersonaMoralE.sendKeys("12345");
            mainPage40201.ciudadPersonaMoralE.sendKeys("CARAQUET");
            mainPage40201.estadoPersonaMoralE.sendKeys("NEW BRUNSWICK");
            mainPage40201.callePersonaMoralE.sendKeys("BOULEVARD ST. PIERRE");
            mainPage40201.numeroExteriorPersonaMoralE.sendKeys("12");
            mainPage40201.numeroInteriorPersonaMoralE.sendKeys("1");
            mainPage40201.nombreDirectorPersonaME.sendKeys("LIAM");
            mainPage40201.apellidoDirectorPPersonaME.sendKeys("BROWN");
            mainPage40201.apellidoDirectorMPersonaME.sendKeys("SMITH");
            mainPage40201.btnGuardarPersonaMoralE.click();
            /// Guardar y Firmar
            mainPage40201.btnGuardarSoli.click();
            loginFirmSoli.firma(tramite40201);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage40201.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
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
