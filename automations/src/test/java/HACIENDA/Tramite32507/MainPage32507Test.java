package HACIENDA.Tramite32507;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32507.MainPage32507;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32507Test {
    MainPage32507 mainPage32507 = new MainPage32507();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32507 = new TramitesFirmasLG(
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
    public void Proceso32507() {
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

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32507);
            mainPage32507.selecRol.sendKeys("Persona Moral");
            mainPage32507.btnacep.click();
            mainPage32507.Tramites.click();
            mainPage32507.SoliNew.click();
            mainPage32507.Hacienda.click();
            mainPage32507.RegisCE.click();
            mainPage32507.RegisCE.scrollTo();
            mainPage32507.EnvioAviso.click();
            mainPage32507.elementoTramite32507.click();

            //Tab Aviso
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32507.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PASO 1
            mainPage32507.tabAviso.click();

            //Datos de la empresa IMMEX que presenta la documentación complementaria del aviso
            mainPage32507.NumeroImmex.sendKeys("4");
            mainPage32507.AñoProgramaImmex.sendKeys("2025");

            //Datos de la ADACE que asistió a la destrucción
            mainPage32507.radbtnNoAcudioADACE.click();
            mainPage32507.selectActaADACE.selectOption("Centro");

            //Agregar Datos mercancia destruida
            mainPage32507.btnAgregarMercanciaDestruida.click();
            //Datos de la mercancia
            mainPage32507.IdTransaccion.sendKeys("87654345690");
            mainPage32507.Cantidad.sendKeys("90");
            mainPage32507.PesoKG.sendKeys("15");
            mainPage32507.selectUnidadMedida.selectOption("Kilogramo");
            mainPage32507.Descripcion.sendKeys("QA Descripción");
            mainPage32507.btnAgregarInfoMercancia.click();
            mainPage32507.btnContinuar.click();

            //Paso2
            mainPage32507.btnContinuarPaso2.click();

            //Paso 3
            mainPage32507.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage32507.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32507.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32507.btnAdjuntar2.click();
            mainPage32507.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage32507.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            //mainPage260205.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage260205.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32507.btnContinuar3.click();sleep(1000);

            //Paso 4 Firma
            loginFirmSoli.firma(tramite32507);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32507.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen5701")) {
//                ProcesoDictamen5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion5701")) {
//                ProcesoAutorizacion5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion5701")) {
//                ProcesoConfirmarNotificaciónResolucion5701(folioNumber);
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
