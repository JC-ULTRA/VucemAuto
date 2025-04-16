package Economia.Tramite110219;
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
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110219Test {
    MainPage110219 mainPage110219 = new MainPage110219();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110219  = new TramitesFirmasLG(
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
    public void Proceso110219() throws IOException {
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


///Tramite Aviso 110219
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite110219); sleep(1000);

            ///RutaAlTramite
            ejecutarRutaAlTramite();

            ///Cancelación de certificado de origen
            ejecutarCanCertOrgPest();

            ///Certificado de OrigenPest
            ejecutarCertOrgPest();

            ///Firma
//            loginSoli.firma(tramite110219);
//
//            // Obtener el texto del folio desde mainPage110219
//            String folioText = mainPage110219.folio.getText();
//
//            // Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage110219.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage110219.btnacep.click(); sleep(1000);
        mainPage110219.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage110219.SoliNew.click(); sleep(1000);
        mainPage110219.Economia.click(); sleep(1000);
        mainPage110219.CertificadoOrigen.click(); sleep(1000);
        mainPage110219.ValidacionCertificadosOrigen.click(); sleep(1000);
        mainPage110219.CancelCertif.click(); sleep(1000);

    }
    public void ejecutarCanCertOrgPest(){
        mainPage110219.CancelCertiOrgPest.click();
        mainPage110219.PaisBloque.sendKeys("JAPON");
        mainPage110219.TratadoAcuerdo.sendKeys("Acuerdo México-Japón");
        mainPage110219.btnBuscarCerti.click();
        mainPage110219.Certific.doubleClick();
        executeJavaScript("window.scrollTo(0, 0);");
    }
    public void ejecutarCertOrgPest(){
        mainPage110219.CertOrigenPest.click();
        mainPage110219.MotivoCancel.sendKeys("Prueba QA");
        mainPage110219.btnContinuarFirm.click();

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
