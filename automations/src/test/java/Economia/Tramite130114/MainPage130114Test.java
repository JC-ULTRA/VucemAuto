package Economia.Tramite130114;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130114.MainPage130114;
import Economia.Tramite130114.MainPage130114Test;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130114Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage130114Test.class);
    MainPage130114 mainPage130114 = new MainPage130114();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130114  = new TramitesFirmasLG(
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
    public void Proceso130114() {
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130114");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130114");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130114");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130114");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130114");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130114");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130114);
            mainPage130114.selecRol.sendKeys("Persona Moral");
            mainPage130114.btnacep.click();
            mainPage130114.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130114.SoliNew.click();
            mainPage130114.economia.click();
            mainPage130114.direccionGeneralNormas.click();
            mainPage130114.importacion.click();
            mainPage130114.importacionDiamantesBruto.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130114.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130114.labelDatosSolicitud.click();
            mainPage130114.inputRegimen.sendKeys("Definitivos");
            mainPage130114.inputClasificacion.sendKeys(" De importación");
            mainPage130114.inputDescripcion.sendKeys("PRUEBAS");
            mainPage130114.inputFraccionArancelaria.sendKeys("71021001");
            mainPage130114.inputCantidad.sendKeys("10");
            mainPage130114.inputValorFactura.sendKeys("10");
            mainPage130114.inputUMT.sendKeys("Gramo");
            mainPage130114.inputCantidadPartida.sendKeys("10");
            mainPage130114.inputValorPartida.sendKeys("10");
            mainPage130114.inputDescripcionPartida.sendKeys("PRUEBAS");
            mainPage130114.btnAgregarPartida.click();
            mainPage130114.inputBloquePaisDestino.click();sleep(1000);
            mainPage130114.inputPaisDedstino.sendKeys("ESTADOS UNIDOS DE AMERICA");sleep(1000);
            mainPage130114.btnAgregarBloque.click();sleep(1000);
            mainPage130114.textareaUsoEspecifico.sendKeys("PRUEBA");
            mainPage130114.textareaJustificacion.sendKeys("PRUEBA");
            mainPage130114.textareaObservaciones.sendKeys("PRUEBAS");
            mainPage130114.inputEntidad.sendKeys("SINALOA");
            mainPage130114.inputRepresentacionFederal.sendKeys("CULIACAN");
            mainPage130114.inputGuardarSolicitud.click();
            mainPage130114.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage130114.btnAnexar.click();sleep(20000);
            mainPage130114.btnCerrar.click();
            mainPage130114.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130114);
            String folioText = mainPage130114.folio.getText();
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