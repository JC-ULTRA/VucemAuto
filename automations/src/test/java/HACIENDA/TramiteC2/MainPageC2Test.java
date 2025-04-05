package HACIENDA.TramiteC2;
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
import DBYFOLIO.ObtenerFolio;
import static com.codeborne.selenide.Selenide.open;

public class MainPageC2Test {
    MainPageC2 mainPageC2 = new MainPageC2();
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

    TramitesFirmasLG tramiteC2 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @Test
    public void ProcesoC2()  {
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
            loginFirmSoli.login(tramiteC2);
            mainPageC2.selecRol.sendKeys("Persona Moral");
            mainPageC2.btnacep.click();
            mainPageC2.Tramites.sendKeys("Solicitudes nuevas");
            mainPageC2.SoliNew.click();
            mainPageC2.hacienda.click();
            mainPageC2.linkAvisosAgaSat.click();
            mainPageC2.C2.click();
            mainPageC2.linkDetalle.click();
            mainPageC2.entidadfederativa.click();
            mainPageC2.municipio.click();
            mainPageC2.descripcionmercancia.sendKeys("Prueba QA");
            mainPageC2.cantidad.sendKeys("2");
            mainPageC2.peso.sendKeys("80");
            mainPageC2.volumen.sendKeys("200");
            mainPageC2.manifiesto1.click();
            mainPageC2.manifiesto2.click();
            mainPageC2.manifiesto3.click();
            mainPageC2.continuar.click();
            loginFirmSoli.firma(tramiteC2);
            // Obtener el texto del folio desde MainPageB1
            String folioText = mainPageC2.folio.getText();
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