package Economia.Tramite80303;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite80303.MainPage80303;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage80303Test {
    MainPage80303 mainPage80303 = new MainPage80303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite80303  = new TramitesFirmasLG(
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
    public void Proceso80303() {
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
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 16;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

        loginFirmSoli.login(tramite80303);
        mainPage80303.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
        mainPage80303.btnacep.click();
        mainPage80303.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
        mainPage80303.SoliNew.click();
        mainPage80303.economia.click();
        mainPage80303.immex.click();
        mainPage80303.ModificacionPrograma.click();
        mainPage80303.elementoTramite80303.click();

        //lista de programas
        mainPage80303.listaPrograma1.doubleClick();

        //Tab modificacion
        mainPage80303.Scrol.scrollTo();
        mainPage80303.tabModificacion.click();
        mainPage80303.btnModificarBajaPlanta1.click();
        mainPage80303.btnContinuarPaso1.click();

        //Paso2
        mainPage80303.btnContinuarPaso2.click();

        //Paso 3
        mainPage80303.btnAdjuntarDoc.click();sleep(1000);

        //Sub Paso 3
        mainPage80303.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage80303.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage80303.btnAdjuntar2.click();
        mainPage80303.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
        mainPage80303.btnCerrar3.click();sleep(1000);

        //Paso 3 (Continuacion)
        mainPage80303.btnContinuar3.click();sleep(1000);

        //Firma
        loginFirmSoli.firma(tramite80303);sleep(4000);

        // Obtener el texto del folio desde mainPageB8
        String folioText = mainPage80303.folio.getText();

        // Llamar al metodo para obtener el folio
        String folioNumber = obtenerFolio.obtenerFolio(folioText);

    }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}