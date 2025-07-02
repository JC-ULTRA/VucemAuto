package HACIENDA.Tramite202;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite202.MainPage202;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage202Test {
    MainPage202 mainPage202 = new MainPage202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso202() throws IOException {
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



        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite

            // Ingreso y Rol
            loginFirmSoli.login(tramite202); sleep(1000);
            mainPage202.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage202.btnacep.click(); sleep(1000);
            mainPage202.Tramites.sendKeys("Solicitudes nuevas");
            mainPage202.SoliNew.click();sleep(1000);

            //Búsqueda Tramite
            mainPage202.Hacienda.click();
            mainPage202.AutorizacionesPrestadorServicio.click();
            mainPage202.elementoTramite202.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage202.Scrol.scrollTo();
            //Pestaña Maniobras Mercancías
            mainPage202.tabManiobrasMerca.click();
            //Datos del trámite
            mainPage202.checkDeclaracion.click();
            mainPage202.selectAduana.selectOption("AGUA PRIETA");
            mainPage202.btnSiguientePaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage202.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage202.btnAnexar.click();
            mainPage202.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage202.btnCerrar.click();
            mainPage202.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite202);

            //LLamar Metodo para obtener folio
            String folioText = mainPage202.folio.getText();
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