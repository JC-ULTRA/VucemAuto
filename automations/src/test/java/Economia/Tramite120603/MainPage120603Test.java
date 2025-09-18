package Economia.Tramite120603;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite120603.MainPage120603;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120603Test {
    MainPage120603 mainPage120603 = new MainPage120603();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite120603 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130303() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
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
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite120603);
            mainPage120603.selecRol.sendKeys("Persona Moral");
            mainPage120603.btnacep.click();
            mainPage120603.Tramites.sendKeys("Solicitudes nuevas");
            mainPage120603.SoliNew.click();
            mainPage120603.Econom.click();
            mainPage120603.CupoExIm.click();
            mainPage120603.RegistroEmpresComerIndustFront.click();
            mainPage120603.Tramite120603.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage120603.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage120603.PestDatEmpres.click();
            mainPage120603.Estado.sendKeys("QUINTANA ROO");sleep(5000);
            mainPage120603.CargarDatosDomicilio.doubleClick();
            mainPage120603.TipoEmpresa.sendKeys("OTROS SERVICIOS");sleep(5000);
            mainPage120603.Especifique.sendKeys("OTROS SERVICIOS");sleep(5000);
            mainPage120603.Clasif.sendKeys("1112");sleep(5000);
            mainPage120603.ClickFuera.click();
            mainPage120603.ClickSi.click();sleep(5000);
            mainPage120603.RFC.sendKeys("MAVL621207C95");sleep(5000);
            mainPage120603.CheckSi.click();
            mainPage120603.btnAgregar.click();
            mainPage120603.btnContinuar.click();
            sleep(8000);
            //firmas
            loginFirmSoli.firma(tramite120603);
            // Obtener el texto del folio desde mainPage130118
            String folioText = mainPage120603.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//           ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

////             Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen130118")) {
//                ProcesoDictamen130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion130118")) {
//                ProcesoAutorizacion130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion130118")) {
//                ProcesoConfirmarNotificaciónResolucion130118(folioNumber);
//            }

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