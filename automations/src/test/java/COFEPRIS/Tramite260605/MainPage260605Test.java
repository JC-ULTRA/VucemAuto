package COFEPRIS.Tramite260605;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260605Test {
    MainPage260605 mainPage260605 = new MainPage260605();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite260605  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }


    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso260605() throws IOException {
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


        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite260605);
            mainPage260605.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage260605.btnacep.click();sleep(1000);

            //Busqueda de tramite
            mainPage260605.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
            mainPage260605.SoliNew.click();//sleep(1000);
            mainPage260605.Cofepris.click();//sleep(1000);
            mainPage260605.CertificadosLicenciasPermisos.click();//sleep(1000);
            mainPage260605.labelAvisoSanitario.click();//sleep(1000);
            mainPage260605.labelAvisoModificacionAduana.click();sleep(1000);

            //PASO 1 CAPTURAR SOLICITUD
            mainPage260605.Scrol.scrollTo().shouldBe(visible);
            //Pestaña Datos de solicitud
            mainPage260605.DatosSolicitud.click();
            //Datos del establecimiento
            mainPage260605.inputNumeroPermiso.sendKeys("0402600501220244006000007");
mainPage260605.btmCargarAduanas.click();
mainPage260605.inputAduanasDisponibles.sendKeys("CANCUN");
mainPage260605.btnAgregarSeleccion.click();
            mainPage260605.inputAduanasDisponibles.sendKeys("AGUA PRIETA");
            mainPage260605.btnAgregarSeleccion.click();
            mainPage260605.inputAduanaSeleccionadas.sendKeys("TOLUCA");
            mainPage260605.btnRestarSeleccion.click();
            mainPage260605.inputJustificacion.sendKeys("TEST");
            mainPage260605.inputRFCLegal.sendKeys("MAVL621207C95");
mainPage260605.btnBuscarRFC.click();

            mainPage260605.inputGuardarSolicitud.click();
            mainPage260605.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260605.btnAnexar.click();sleep(8000);

            Selenide.sleep(4000);
            mainPage260605.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260605.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260605);
            Selenide.sleep(2000);
//            String folioText = mainPage260605.folio.getText();sleep(5000);
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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