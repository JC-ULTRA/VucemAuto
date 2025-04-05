package HACIENDA.TramiteB20;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPageB20Test {
    MainPageB20 mainPageB20 = new MainPageB20();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    TramitesFirmasLG tramiteB20 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @Test
    public void ProcesoB20()  {

//        todo lo que se repetira debe de estar dentro de estas clases
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones",
                JOptionPane.QUESTION_MESSAGE);
        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        ejecutarProcesoNRunnable(() -> {
            loginFirmSoli.login(tramiteB20);
            mainPageB20.selecRol.sendKeys("Persona Moral");
            mainPageB20.btnacep.click();
            mainPageB20.Tramites.sendKeys("Solicitudes nuevas");
            mainPageB20.SoliNew.click();
            mainPageB20.hacienda.click();
            mainPageB20.linkAvisosAgaSat.click();
            mainPageB20.B20.click();
            mainPageB20.linkDetalle.click();
            mainPageB20.oficio.sendKeys("12345");
            mainPageB20.fechaoficio1.click();
            mainPageB20.fechaoficio2.click();
            mainPageB20.aduana.click();
            mainPageB20.seccionaduanera.click();
            mainPageB20.claveautorización.click();
            mainPageB20.superficie.sendKeys("200");
            mainPageB20.capacidad.sendKeys("201");
            mainPageB20.almacenaje.sendKeys("203");
            mainPageB20.espacioUsado.click();
            mainPageB20.manifiesto1.click();
            mainPageB20.continuar.click();
            loginFirmSoli.firma(tramiteB20);

            // Obtener el texto del folio desde MainPageB1
            String folioText = mainPageB20.folio.getText();
            // Llamar al metodo para obtener el folio
            obtenerFolio.obtenerFolio(folioText);

//        todo lo que se repetira debe de estar dentro de estas clases
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