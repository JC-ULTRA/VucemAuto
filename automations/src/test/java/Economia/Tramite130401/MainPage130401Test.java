package Economia.Tramite130401;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130401.MainPage130401;
import Metodos.Metodos;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130401Test {
    MainPage130401 mainPage130401 = new MainPage130401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130401  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }


    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso130401() {
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
        /*
        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130401");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130401");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130401");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130401");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130401");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130401");

        */

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de permiso:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() > 15 ) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);


            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130401);
            mainPage130401.selecRol.sendKeys("Persona Moral");
            mainPage130401.btnacep.click();
            mainPage130401.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130401.SoliNew.click();
            mainPage130401.Economia.click();
            mainPage130401.Permisos.click();
            mainPage130401.ModificacionMercancia.click();
            mainPage130401.elementoTramite130401.click();

            //Búsqueda de folio
            mainPage130401.folioPermiso.sendKeys(FolioTramiteN);
            mainPage130401.btnBuscarFolio.click();sleep(1000);

            //Paso 1 CAPTURAR SOLICITUD
            //Pestaña Modificación Descripción Mercancía
            mainPage130401.Scrol.scrollTo();
            mainPage130401.tabModDescripMercancia.click();
            //Modificación de la descripción de la mercancía
            mainPage130401.ModificarDescripcionSigue.setValue("Modificación Descripción que sigue QA");
            //Partidas de la mercancía
            mainPage130401.gridParMercancia1.click();
            mainPage130401.btnModParMercancia.click();
            //Modificación de descripción mercancía Partida
            mainPage130401.DescripcionSol.setValue("QA descripción descripción mercancía");
            mainPage130401.btnModificarInfoMercancia.click();

            //Continuar Paso 1
            mainPage130401.btnContinuarPaso1.click();

            //Paso2
            mainPage130401.btnContinuarPaso2.click();

            //Paso 3
            metodos.cargarDocumentos();
            mainPage130401.btnAdjuntar2.click();
            mainPage130401.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30)); sleep(1000);
            mainPage130401.btnCerrar3.click();

            //Paso 3 (Continuacion)
            mainPage130401.btnContinuarPaso3.click();

            //Firma
            loginFirmSoli.firma(tramite130401);sleep(3000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage130401.folio.getText();

            // Llamar al metodo para obtener el folio
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
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 2; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }

}
