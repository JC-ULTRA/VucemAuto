package HACIENDA.Tramite32512;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite40102.MainPage40102;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32512Test {

    MainPage32512 mainPage32512 = new MainPage32512();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32512  = new TramitesFirmasLG(
            "C:\\Users\\ErickALD\\Desktop\\Aqua\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\Users\\ErickALD\\Desktop\\Aqua\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
    public void Proceso32512() throws IOException {
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

            File archivoDest = new File("C:\\Users\\ErickALD\\Downloads\\plantilla_aviso_destruccion.xls");
            // Ingreso y selección de trámite

            //mainPage32512.CondiMateriaMerc.sendKeys("");

            loginFirmSoli.login(tramite32512); sleep(1000);
            mainPage32512.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage32512.btnacep.click(); sleep(1000);
            mainPage32512.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage32512.SoliNew.click(); sleep(1000);
            mainPage32512.Hacienda.click(); sleep(1000);

            mainPage32512.RegisCE.click();sleep(1000);
            mainPage32512.EnvioAviso.click();sleep(1000);
            mainPage32512.Tramite32512.click();sleep(1000);

            //Pestaña Tipo de Aviso
            mainPage32512.TabTipAviso.click(); sleep(1000);

            //Datos del lugar donde se encuentra la mercancía
            mainPage32512.CondiMateriaMerc.sendKeys("Entero");
            mainPage32512.ComboEntidFederati.sendKeys("Aguascalientes");sleep(1000);
            mainPage32512.ComboMuncAlcaldia.sendKeys("Aguascalientes");sleep(1000);
            mainPage32512.ComboColonia.sendKeys("Agua Clara - CP 20263");sleep(1000);
            mainPage32512.Calle.sendKeys("TestCalle");sleep(1000);
            mainPage32512.NumLetraExterior.sendKeys("TestNumExterior");sleep(1000);
            mainPage32512.NumLetraInterior.sendKeys("TestNumInterior");sleep(1000);
            mainPage32512.CPostal.sendKeys("10000");sleep(1000);

            //Lugar, fecha y hora donde se llevará a cabo la destrucción de la mercancía
            mainPage32512.ComboEntidFederativ2.sendKeys("Aguascalientes");sleep(1000);
            mainPage32512.ComboMuncAlcaldia2.sendKeys("Aguascalientes");sleep(1000);
            mainPage32512.ComboColonia2.sendKeys("Agua Clara - CP 20263");sleep(1000);
            mainPage32512.Calle2.sendKeys("TestCalle2");sleep(1000);
            mainPage32512.NumLetraExterior2.sendKeys("TestNumExterior2");sleep(1000);
            mainPage32512.NumLetraInterior2.sendKeys("TestNumInterior2");sleep(1000);
            mainPage32512.CPostal2.sendKeys("10001");sleep(1000);

            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32512.FechaDestrucMerc);
            sleep(1000);
            //mainPage32512.FechaDestrucMerc.sendKeys("01/04/2025"); sleep(1000);

            mainPage32512.HoraDestruc.sendKeys("10:00"); sleep(1000);
            mainPage32512.btnSelectArch.uploadFile(archivoDest);sleep(1000);

            //Datos de la mercancía que se destruirá y proceso de destrucción
            mainPage32512.btnCargarArch.click(); sleep(1000);
            mainPage32512.btnAceptNoti.click(); sleep(1000);
            mainPage32512.btnCont.click(); sleep(1000);


            //Paso 2 Requisitos necesarios
            mainPage32512.btnContPaso2.click(); sleep(1000);

            //Paso 3
            mainPage32512.btnContPaso3.click(); sleep(1000);

            //Paso 4
            loginFirmSoli.firma(tramite32512);sleep(29000);
            //mainPage32512.btnFirmarDes.shouldBe(Condition.disappear, Duration.ofSeconds(90));

            // Obtener el texto del folio desde mainPageB8

            //Prueba de manejo tiempo
            /*try {
                // Espera hasta que el folio esté presente y visible
                mainPage32512.folio.shouldBe(Condition.exist, Duration.ofSeconds(90));
                mainPage32512.folio.shouldBe(Condition.visible, Duration.ofSeconds(90));

                // Obtener el texto del folio
                String folioText = mainPage32512.folio.getText();
                //Llamar al metodo para obtener el folio
                String folioNumber = obtenerFolio.obtenerFolio(folioText);
            } catch (Exception e) {
                System.out.println("El folio no se pudo encontrar después de 90 segundos.");
                // Maneja el error según sea necesario
            }*/

            // Obtener el texto del folio
            String folioText = mainPage32512.folio.getText();
            //Llamar al metodo para obtener el folio
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
