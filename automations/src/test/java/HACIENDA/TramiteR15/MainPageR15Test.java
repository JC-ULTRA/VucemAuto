package HACIENDA.TramiteR15;
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
import static com.codeborne.selenide.Selenide.*;

public class MainPageR15Test {
    MainPageR15 mainPageR15 = new MainPageR15();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    TramitesFirmasLG tramiteR15 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void ProcesoR15()  {
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
            loginFirmSoli.login(tramiteR15);
            mainPageR15.selecRol.sendKeys("Persona Moral");
            mainPageR15.btnacep.click();
            mainPageR15.Tramites.sendKeys("Solicitudes nuevas");
            mainPageR15.SoliNew.click();
            mainPageR15.hacienda.click();
            mainPageR15.linkAvisosAgaSat.click();
            mainPageR15.R15.click();
            mainPageR15.linkDetalle.click();
            mainPageR15.ejercicio.click();
            mainPageR15.declaracion.click();
            mainPageR15.periodo.click();
            mainPageR15.obligaciones.click();
            mainPageR15.aduana.click();
            mainPageR15.superficie.sendKeys("100");
            mainPageR15.capacidad.sendKeys("201");
            mainPageR15.rfc.sendKeys("MAVL621207C95");
            mainPageR15.autorizacion.sendKeys("1234");
            mainPageR15.constancia.sendKeys("12345");
            mainPageR15.recintoDictamen.click();
            mainPageR15.ingresoBrutoDeterminacion.click();
            mainPageR15.tipoMovimiento.click();
            mainPageR15.toneladas.sendKeys("1");
            mainPageR15.ingresoPor.click();
            mainPageR15.ingresoBruto.sendKeys("1000");
            mainPageR15.aceptarDeterminacion.click();
            mainPageR15.datosCorrectos.click();
            mainPageR15.ingresoServiciosDistintos.click();
            mainPageR15.tipoMovimiento2.click();
            mainPageR15.servicio.click();
            mainPageR15.importe.sendKeys("100");
            mainPageR15.aceptarServicioDistinto.click();
            mainPageR15.datosCorrectos2.click(); // Luego, haz clic en el botón
            mainPageR15.pagoSaldoCompensar.sendKeys("100");
            mainPageR15.aplicarSaldoCompensar.sendKeys("10");
            mainPageR15.pagoSaldoPendiente.sendKeys("10");
            mainPageR15.aplicarSaldoPendienteAduana.sendKeys("10");
            mainPageR15.SaldoPendienteFideicomiso.sendKeys("10");
            mainPageR15.aplicarSaldoPendienteFideicomiso.sendKeys("10");
            mainPageR15.continuar.click();
            loginFirmSoli.firma(tramiteR15);
            // Obtener el texto del folio desde MainPageR15
            String folioText = mainPageR15.folio.getText();
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