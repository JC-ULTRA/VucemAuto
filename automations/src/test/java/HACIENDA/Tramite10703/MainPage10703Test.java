package HACIENDA.Tramite10703;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite10703.MainPage10703;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage10703Test {
    MainPage10703 mainPage10703 = new MainPage10703();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite10703  = new TramitesFirmasLG(
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
    public void Proceso10703() throws IOException {
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

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25 || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite10703); sleep(1000);
            mainPage10703.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage10703.btnacep.click(); sleep(1000);

            //Búsqueda de trámite Subsecuente
            mainPage10703.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage10703.SoliSub.click();
            mainPage10703.FolioTramite.sendKeys(FolioTramiteN);
            mainPage10703.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage10703.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Solicitar Modificación y Prórroga
            mainPage10703.btnSolModificar.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage10703.Scrol.scrollTo();
            //Pestaña Exención impuestos
            mainPage10703.tabDatosInmueble.click();
            //Aduana
            mainPage10703.selectAduana.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");

            // Continuar paso 1
            mainPage10703.btnContinuarPaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage10703.btnContinuarPaso2.click();

            /*
            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage10703.btnAnexar.click();
            mainPage10703.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30)); sleep(1000);
            mainPage10703.btnCerrar.click();
            mainPage10703.btnContinuarPaso3.click();
             */

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite10703);sleep(3000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage10703.folio.getText();

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