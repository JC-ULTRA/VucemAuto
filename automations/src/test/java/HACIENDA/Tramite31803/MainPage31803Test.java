package HACIENDA.Tramite31803;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite31803.MainPage31803;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage31803Test {

    MainPage31803 mainPage31803 = new MainPage31803();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite31803  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }


    @Test
    public void Proceso31803() throws IOException {
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

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }

            //Loging y selección Rol
            loginFirmSoli.login(tramite31803);
            mainPage31803.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage31803.btnacep.click(); sleep(1000);

            //Tramite subsecuente
            mainPage31803.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage31803.SoliSub.click(); sleep(1000);
            //Búsqueda de folio
            mainPage31803.FolioTramite.setValue(FolioTramiteN);sleep(1000);
            mainPage31803.btnBuscar.click();sleep(1000);
            SelenideElement filaFolioDeseado = mainPage31803.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Pantalla azul (Solicitar renovación)
            mainPage31803.btnSolRenovacion.click();sleep(1000);

            //Pestaña Tipo de Aviso
            try {
                Thread.sleep(1000); // Pausa de 1 segundos
                // Hacer scroll hasta el elemento
                mainPage31803.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage31803.tabSolicitud.click();

            //Pago de derechos
            mainPage31803.NumOperacion.sendKeys("105963828");sleep(1000);
            mainPage31803.selectBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage31803.LLavePago.sendKeys(llavePago);sleep(1000);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage31803.fechaPago, fechaHoy);
            mainPage31803.checkManifiesto.click();
            mainPage31803.checkProtesta.click();
            mainPage31803.btnContinuarPaso1.click();

            //Paso2
            mainPage31803.btnContinuarPaso2.click();

            //Paso3
            mainPage31803.btnAdjuntarDoc.click();

            //Sub Paso 3 Adjuntar Documentos
            mainPage31803.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31803.btnSelectArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31803.btnAdjuntar2.click();
            mainPage31803.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage31803.btnCerrar3.click();sleep(1000);
            mainPage31803.btnContinuar3.click(); sleep(1000);

            //PAso 4 Firma
            loginFirmSoli.firma(tramite31803);

            // Obtener el texto del folio
            String folioText = mainPage31803.folio.getText();
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
