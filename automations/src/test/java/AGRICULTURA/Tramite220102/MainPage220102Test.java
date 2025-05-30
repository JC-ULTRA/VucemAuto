package AGRICULTURA.Tramite220102;

import AGRICULTURA.Tramite220102.MainPage220102;
import Metodos.Metodos;
import DBYFOLIO.ObtenerFolio;
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
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220102Test {

    MainPage220102 mainPage220102 = new MainPage220102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite220102  = new TramitesFirmasLG(
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
    public void Proceso220102() throws IOException {
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
                // Ingreso
                loginFirmSoli.login(tramite220102);
                mainPage220102.selecRol.sendKeys("Persona Moral");
                mainPage220102.btnacep.click(); sleep(1000);
                //Búsqueda de tramite
                mainPage220102.Tramites.sendKeys("Solicitudes nuevas");
                mainPage220102.SoliNew.click();
                mainPage220102.Agricultura.click();
                mainPage220102.certysol.click();
                mainPage220102.RequsitoImpor.click();
                mainPage220102.elementoTramite220102.click();

                //Pestaña Datos Solicitud
                //Datos Mercancía
                mainPage220102.tabDatosSolicitud.click();
                mainPage220102.btnAgregarMercancia.click();
                mainPage220102.selectNombreComun.selectOption("Adelfilla");
                mainPage220102.selectNombreCientifico.selectOption("Buplerum fruticosum");
                mainPage220102.selectUso.selectOption("Otro");
                mainPage220102.selectPaisOrigen.selectOption("ARGENTINA (REPUBLICA)");
                mainPage220102.selectPaisProcedencia.selectOption("CHILE (REPUBLICA DE)");
                mainPage220102.selectTipoProducto.selectOption("Flor cortada");
                mainPage220102.FraccionArancelaria.sendKeys("84321001");
                mainPage220102.CantidadUMT.sendKeys("10");
                mainPage220102.CantidadUMC.sendKeys("100");
                mainPage220102.selectUMC.selectOption("Kilogramo");
                mainPage220102.Descripcion.sendKeys("QA Descripción");
                mainPage220102.btnGuardarMercancia.click();
                mainPage220102.btnContinuarPaso1.click();

                //PASO 2 REQUISITOS NECESARIOS
                mainPage220102.btnContinuarPaso2.click();

                //Paso 3 ANEXAR REQUISITOS
                metodos.cargarDocumentos();
                mainPage220102.btnAdjuntar2.click();
                mainPage220102.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage220102.btnCerrar3.click();
                mainPage220102.btnContinuarPaso3.click();


                //PASO 4 FIRMAR SOLICITUD
                loginFirmSoli.firma(tramite220102);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage220102.folio.getText();

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
