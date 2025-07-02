package Economia.Tramite80314;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite80314.MainPage80314;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage80314Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage80314Test.class);
    MainPage80314 mainPage80314 = new MainPage80314();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AFC000526BJ2";

    TramitesFirmasLG tramite80314  = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso80314() {
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
//          // Ingreso y Rol
            loginFirmSoli.login(tramite80314);
            mainPage80314.selecRol.sendKeys("Persona Moral");
            mainPage80314.btnacep.click();
            //Búsqueda Trámite
            mainPage80314.Tramites.sendKeys("Solicitudes nuevas");
            mainPage80314.SoliNew.click();
            mainPage80314.economia.click();
            mainPage80314.IMMEX.click();
            mainPage80314.ModificacionPrograma.click();
            mainPage80314.elementoTramite130203.click();

            //Lista de programas
            mainPage80314.gridPrograma1.doubleClick();
            
            //Paso 1 CAPTURAR SOLICITUD
            mainPage80314.Scrol.scrollTo();
            //Pestaña de modificación
            mainPage80314.tabModificacion.click();
            mainPage80314.comboActividadProductiva.click();
            mainPage80314.comboSeleccionGanaderia.click();
            mainPage80314.btnContinuarPaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage80314.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage80314.btnAnexar.click();
            mainPage80314.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60)); sleep(1000);
            mainPage80314.btnCerrar.click();
            mainPage80314.btnContinuarPaso3.click();

            //Paso 4 Firmar Solicitud
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite80314);

            //LLamar Metodo para obtener folio
            String folioText = mainPage80314.folio.getText();
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


}