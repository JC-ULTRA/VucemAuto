package Economia.Tramite120403;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120403Test {
    MainPage120403 mainPage120403 = new MainPage120403();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite120403  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
    public void Proceso240411() {
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
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite120403);
            mainPage120403.selecRol.sendKeys("Persona Moral");
            mainPage120403.btnacep.click();
            mainPage120403.Tramites.sendKeys("Solicitudes nuevas");
            mainPage120403.SoliNew.click();
            mainPage120403.economia.click();
            mainPage120403.labelCuposImpExp.click();sleep(500);
            mainPage120403.labelAsignacionDirecta.click();
            mainPage120403.labelAmpliacionPerFis.click();
            try {
                Thread.sleep(2000);
                mainPage120403.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage120403.labelAsignacion.click();
            mainPage120403.checkApliacionMonto.click();
            mainPage120403.selectAnoOficioAsignacion.sendKeys("2025");
            mainPage120403.inpuNumeroAsignacion.sendKeys("3");
            mainPage120403.btnBuscar.click();
            mainPage120403.inputMontoAmpliar.sendKeys("10");
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            //NO CUENTA CON SALDO POR LO QUE QUEDA INCONCLUSA
            mainPage120403.btnGuardarSolicitud.click();

            mainPage120403.btnContinuar.click();
            metodos.cargarDocumentos();
            // mainPage120403.btmAnexar.click();sleep(4000);
            Selenide.sleep(4000);
            mainPage120403.btnCerrar.click();
            Selenide.sleep(2000);
            // mainPage120403.inputSiguiente.click();sleep(3000);
            loginFirmSoli.firma(tramite120403);
            String folioText = mainPage120403.folio.getText();
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

}