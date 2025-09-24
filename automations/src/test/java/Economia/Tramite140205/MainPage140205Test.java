package Economia.Tramite140205;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite120202.MainPage120202Test;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140205Test {
    MainPage120202Test mainPage120202Test = new MainPage120202Test();
    MainPage140205 mainPage140205 = new MainPage140205();
    Metodos metodos = new Metodos();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite140205  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );
    TramitesFirmasLG tramite140205Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;

        // Configuraciones de Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=1.25"); // Escala 150%
        Configuration.browserCapabilities = options;
        open();
        getWebDriver().manage().window().maximize(); // Maximizar la ventana
        Configuration.timeout = 120000; // Tiempo de espera
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
    public void Proceso140205() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String CertificadoCancelar = mainPage120202Test.GenerarCertificadoACancelar();
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
            loginFirmSoli.loginFun(tramite140205Fun);
            $(By.cssSelector("img[src*='icoOtrasTareas.png']")).click();
            $x("//a[contains(text(),'Otras tareas') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
            $x("//a[contains(text(),'CUPOS') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
            $x("//a[contains(text(),'Cancelación') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
            $(By.linkText("Certificados de CUPO por Facultad")).shouldBe(visible).click();
            mainPage140205.rfcEmpresa.sendKeys("AFC000526BJ2");
            $("[name='buscarEmpresa'][type='submit']").shouldBe(visible).click();
            mainPage140205.cancelacionTab.click();
            mainPage140205.regimenAduanero.sendKeys("Exportación");
            mainPage140205.mecanismoAsignacion.sendKeys("Asignación directa");
            $("[name='buscarCuposDisponibles'][type='submit']").shouldBe(visible).click();
            mainPage140205.cupoTabla.doubleClick();
            $x("//td[@title='" + CertificadoCancelar + "']").shouldBe(visible).click();
            $("[name='seleccionarCertidicadoCancelar'][type='button']").shouldBe(visible).click();
            mainPage140205.motivoCancelacion.sendKeys("PRUEBAS QA ULTRASIST");
            metodos.scrollDecremento(5);
            mainPage140205.btnGuardarSoli.click();
            loginFirmSoli.firmaFun(tramite140205Fun);sleep(3200);
            String folioText = mainPage140205.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2500);

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
}
