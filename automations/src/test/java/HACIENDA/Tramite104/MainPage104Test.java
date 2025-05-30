package HACIENDA.Tramite104;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite104.MainPage104;
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

public class MainPage104Test {
    MainPage104 mainPage104 = new MainPage104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite104  = new TramitesFirmasLG(
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
    public void Proceso104() throws IOException {
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
            loginFirmSoli.login(tramite104); sleep(1000);
            mainPage104.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage104.btnacep.click(); sleep(1000);
            mainPage104.Tramites.sendKeys("Solicitudes nuevas");
            mainPage104.SoliNew.click();sleep(1000);

            //Búsqueda Tramite
            mainPage104.Hacienda.click();
            mainPage104.AutorizacionesImporExpor.click();
            mainPage104.elementoTramite104.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage104.Scrol.scrollTo();
            //Pestaña Datos del inmueble
            mainPage104.tabDatosInmueble.click();
            //Programa de fomento a la exportación
            mainPage104.selectTipoPrograma.selectOption("PROSEC");
            mainPage104.selectFolioAutorización.selectOption("2024-9419");
            //Datos de la planta para realizar los procesos de ensamble y fabricación
            mainPage104.btnAgregarPlanta.click();
            mainPage104.CallePlanta.sendKeys("Calle Revolución QA");
            mainPage104.NumExterior.sendKeys("16");
            mainPage104.NumInterior.sendKeys("5");
            mainPage104.selectEntidad.selectOption("VERACRUZ");
            mainPage104.selectMunicipio.selectOption("ALVARADO");
            mainPage104.selectColonia.selectOption("ALVARADO CENTRO - CP 95270");
            mainPage104.selectLocalidad.sendKeys("ALVARADO - CP 95250");
            mainPage104.CodigoPostal.sendKeys("03930");
            mainPage104.btnGuardarPlanta.click();
            mainPage104.btnSiguientePaso1.click();

            //Paso 2 Requisitos Necesarios
            mainPage104.btnContinuarPaso2.click();

            //Paso 3 Anexar Requisitos
            metodos.cargarDocumentos();
            mainPage104.btnAnexar.click();
            mainPage104.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage104.btnCerrar.click();
            mainPage104.btnContinuarPaso3.click();

            //Paso 4 Firmar Solicitud
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite104);

            //LLamar Metodo para obtener folio
            String folioText = mainPage104.folio.getText();
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