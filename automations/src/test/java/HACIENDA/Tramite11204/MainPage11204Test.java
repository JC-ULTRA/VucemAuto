package HACIENDA.Tramite11204;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage11204Test {
    MainPage11204 mainPage11204 = new MainPage11204();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite11204 = new TramitesFirmasLG(
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
    }

    @Test
    public void Proceso11204() throws IOException {
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

            loginFirmSoli.login(tramite11204); sleep(1000);
            mainPage11204.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage11204.btnacep.click(); sleep(1000);
            mainPage11204.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage11204.SoliNew.click(); sleep(1000);
            mainPage11204.Hacienda.click();
            mainPage11204.AutorizacionesImportadorExportador.click();
            mainPage11204.ConstanciaImportaciTemporalRetorno.click();

            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage11204.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainPage11204.Tramite11204.click();
            mainPage11204.Contenedor.click();
            mainPage11204.RadioContenedor.click();
            mainPage11204.selectAduana.sendKeys("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage11204.InicialesContenedor.sendKeys("QASW");
            mainPage11204.NumeroContenedor.sendKeys("23456543");
            mainPage11204.inputBuscar.click(); sleep(2000);
            mainPage11204.buttonModal.click(); sleep(2000);
            mainPage11204.selectContenedores.sendKeys("CONTENEDORES");
            mainPage11204.DigitoControl.sendKeys("1");
            mainPage11204.FechaIngrgeso.click();
            mainPage11204.selecFecha.click();
            mainPage11204.FechaVigencia.click();
            mainPage11204.selectFecVig.click();
            mainPage11204.inputAgregar.click(); sleep(2000);
            mainPage11204.GuardarSolicitud.click();
            mainPage11204.inputContinuar.click();
            mainPage11204.inputAdjuntarDocumentos.click();
            mainPage11204.inputDocumentosFile.setValue("C:\\Vucem3.0\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage11204.inputDocumentosFile1.setValue("C:\\Vucem3.0\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage11204.inputAnexar.click(); sleep(3000);
            mainPage11204.inputCerrar.click();
            mainPage11204.inputSiguienteButton.click();
            sleep(1000);

            loginFirmSoli.login(tramite11204);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage11204.folio.getText();

            // Llamar al método para obtener el folio
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
