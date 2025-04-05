package TestProd;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Firmas.*;
import TestProd.MainPageProd;
import com.codeborne.selenide.Browsers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class MainPageProdTest {
    MainPageProd mainpageprod = new MainPageProd();
//    FirmaProdNet firmaProdNet = new FirmaProdNet();

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
    }

    public static void setUpAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void TestProd() throws InterruptedException {
        // Opción para elegir entre ejecución limitada o infinita
        String[] options = {"Ejecutar un número determinado de veces", "Ejecutar infinitamente"};
        int seleccion = JOptionPane.showOptionDialog(
                null,  // El componente padre
                "¿Cuántas veces deseas ejecutar el proceso?",  // Mensaje
                "Seleccionar opción",  // Título de la ventana
                JOptionPane.DEFAULT_OPTION,  // Opción por defecto
                JOptionPane.INFORMATION_MESSAGE,  // Tipo de mensaje
                null,  // Icono
                options,  // Opciones
                options[0]  // Opción predeterminada
        );

        // Opción 1: Pedir número de repeticiones
        if (seleccion == 0) {
            String input = JOptionPane.showInputDialog("¿Cuántas veces deseas ejecutar el proceso?");
            int repeticiones = 10; // Valor predeterminado
            try {
                repeticiones = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Se ejecutará 10 veces por defecto.");
            }

            // Ejecutar el proceso con las repeticiones dadas
            ejecutarProcesoNRunnable(() -> {
                // Ingreso y selección de trámite
                LoginS();            // Ejecución de LoginS
                ConsultaSubSecuentes(); // Ejecución de ConsultaSubSecuentes
                ConsultaEstadoTramFun(); // Ejecución de ConsultaEstadoTramFun
            }, repeticiones); // Ejecutar el proceso las veces que el usuario indicó
        }
        // Opción 2: Ejecutar infinitamente
        else if (seleccion == 1) {
            // Ejecutar el proceso infinitamente sin preguntar al usuario
            int contador = 0;
            while (true) {
                // Ejecutamos el proceso una vez
                ejecutarProcesoNRunnable(() -> {
                    // Ingreso y selección de trámite
                    LoginS();            // Ejecución de LoginS
                    ConsultaSubSecuentes(); // Ejecución de ConsultaSubSecuentes
                    ConsultaEstadoTramFun(); // Ejecución de ConsultaEstadoTramFun
                }, 1);

                // Mostrar el número de ejecuciones
                contador++;
                System.out.println("Ejecución número: " + contador);

                // Si llegamos a 50 ejecuciones, seguimos sin preguntar
                if (contador >= 50) {
                    continue;  // Sigue ejecutando sin preguntar más
                }
            }
        }

        // Cerrar el navegador después de la ejecución
        closeBrowser();
    }

    // Método para cerrar el navegador (usando Selenium o Selenide)
    public void closeBrowser() {
        WebDriver driver = getWebDriver();
        if (driver != null) {
            driver.quit();  // Cierra el navegador
        }
    }

    // Proceso LoginS
    public void LoginS() {
        //se asigna el LoginS a ocupar
        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginS=%22;");
        //LoginS persona física
//        firmaProdNet.FirmProdS();sleep(300);
    }

    // Proceso ConsultaSubSecuentes
    public void ConsultaSubSecuentes() {
        // Solicitamos un valor mediante un cuadro de diálogo
        String folio = "0100400100220241005009389";//JOptionPane.showInputDialog("Ingresa el folio a consultar.:");sleep(300);
        mainpageprod.selecRol.sendKeys("Persona Física");sleep(300);
        mainpageprod.btnacep.click();sleep(300);
        mainpageprod.Tramites.click();sleep(300);
        mainpageprod.SubSec.click();sleep(300);
        mainpageprod.folioConsultar.sendKeys(folio);sleep(300);
        mainpageprod.btnBuscar.click();sleep(300);
        mainpageprod.tramiteSub.doubleClick();sleep(300);
    }

    // Proceso ConsultaEstadoTramFun
    public void ConsultaEstadoTramFun() {
        // Se asigna el LoginS a ocupar
        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");

        // LoginF persona física
//        firmaProdNet.FirmProdF();
        sleep(300);

        String folioET = null;
        boolean folioValido = false;

        // Preguntar por el folio directamente
        while (!folioValido) {
            folioET = "0201300101820259901009230"; //JOptionPane.showInputDialog("Ingresa el folio a consultar:");

            // Si el usuario cancela el input (presiona 'Cancelar') o no ingresa nada
            if (folioET == null || folioET.isEmpty()) {
                int reintentar = JOptionPane.showConfirmDialog(
                        null,
                        "No ingresaste un folio. ¿Quieres intentarlo de nuevo?",
                        "Reintentar",
                        JOptionPane.YES_NO_OPTION
                );
                // Si decide no reintentar, se sale del bucle
                if (reintentar == JOptionPane.NO_OPTION) {
                    return;
                }
            } else {
                folioValido = true;  // Si el folio es válido, se sale del bucle
            }
        }

        // Procedemos con la consulta usando el folioET obtenido
        mainpageprod.Consultas.click(); sleep(300);
        mainpageprod.DespConsultas.click(); sleep(300);
        mainpageprod.ConsultEstTram.click(); sleep(300);
        mainpageprod.FolioConsultar.sendKeys(folioET); sleep(300);
        mainpageprod.btnBuscarFolio.click(); sleep(1200);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
