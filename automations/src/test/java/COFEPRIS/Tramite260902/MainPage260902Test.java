package COFEPRIS.Tramite260902;


import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260902Test {
    MainPage260902 mainPage260902 = new MainPage260902();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260902  = new TramitesFirmasLG(
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
    }

    @Test
    public void Proceso260902() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite260902);
            mainPage260902.selecRol.sendKeys("Persona Moral");
            mainPage260902.btnacep.click();
            mainPage260902.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260902.SoliSub.click();
            mainPage260902.inputIdFolio.sendKeys("0402600200220254006000005");
            mainPage260902.inputBuscarButton.click();sleep(1000);
            mainPage260902.SolicitudTramite.doubleClick();
            mainPage260902.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260902.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260902.labelDatosSolicitud.click();
            mainPage260902.inputModif.click();
            mainPage260902.textareaJustificacionId.sendKeys("SE REALIZAN PRUEBAS");
            //PAGO DE TERCEROS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260902.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260902.labelPagoDerechos.click();

            mainPage260902.inputSolicitudPagoLlave.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260902.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(nFacturaR));
            //mainPage260902.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260902.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260902.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            int inputSolicitudPagoLlave = 10_000_000 + random.nextInt(90_000_000);
            mainPage260902.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260902.inputSolicitudPagoLlave.sendKeys("3456456243");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260902.inputCalendar);sleep(100);
            mainPage260902.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260902.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260902.inputGuarda.click();sleep(1000);
            mainPage260902.inputAdjuntar.click();
            mainPage260902.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260902.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260902.btnAnexar.click();sleep(2000);
            mainPage260902.btnCerrar.click();sleep(500);
            mainPage260902.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260902);
            String folioText = mainPage260902.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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
