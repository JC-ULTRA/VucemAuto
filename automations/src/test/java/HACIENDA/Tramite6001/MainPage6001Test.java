package HACIENDA.Tramite6001;
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

public class MainPage6001Test {
    MainPage6001 mainPage6001 = new MainPage6001();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite6001 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Procesob1() {

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

            loginFirmSoli.login(tramite6001);
            mainPage6001.selecRol.sendKeys("Persona Física");
            mainPage6001.btnacep.click();
            mainPage6001.Tramites.sendKeys("Solicitudes nuevas");
            mainPage6001.SoliNew.click();
            mainPage6001.hacienda.click();
            mainPage6001.Cuentas.click();
            mainPage6001.CuentasBancarias.click();

            //Captura de la solicitud
            mainPage6001.tdDespachosAduanalesAlcantara.click();
            mainPage6001.inputAltacuenta.click();
            mainPage6001.inputTitularCuenta.sendKeys("Prueba QA");
            mainPage6001.inputGlowingBorder.sendKeys("AAL0409235E6");
            mainPage6001.inputNumeroCuenta.sendKeys("837293728");
            mainPage6001.selectInstitucion.sendKeys("HSBC");
            mainPage6001.selectEntidades.sendKeys("SINALOA");
            mainPage6001.inputSucursal.sendKeys("2025");
            mainPage6001.inputNumeroPlaza.sendKeys("CENTRO");
            mainPage6001.inputGuardarCuenta.click();
            mainPage6001.inputGuardarSolicitud.click();

//            loginFirmSoli.firma(tramite6001);


//            try {
//                System.out.println("Entrando al timer");
//                Thread.sleep(15000);
//                mainPage6001.btnCerrar.click();
//                System.out.println("Saliendo del timer");
//                mainPage6001.btnContPreFirm.click();
//                loginFirmSoli.firma(tramite6001);
//            } catch (InterruptedException e) {
//                System.out.println("no entro");
//                throw new RuntimeException(e);
//            }
//            // Obtener el texto del folio desde MainPageB1
            String folioText = mainPage6001.folio.getText();
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
