package Economia.Tramite130111;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130111Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage130111Test.class);
    MainPage130111 mainPage130111 = new MainPage130111();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130111  = new TramitesFirmasLG(
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
    public void Proceso130111() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130111");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130111");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130111");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130111");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130111");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130111");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130111);
            mainPage130111.selecRol.sendKeys("Persona Moral");
            mainPage130111.btnacep.click();
            mainPage130111.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130111.SoliNew.click();
            mainPage130111.economia.click();
            mainPage130111.direccionGeneralNormas.click();
            mainPage130111.importacion.click();
            mainPage130111.importacionVehAdaPerFisActEmpPerMor.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130111.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130111.labelDatosSolicitud.click();
            mainPage130111.inputRegimen.sendKeys("Definitivos");
            mainPage130111.inputClasificacion.sendKeys(" De importación");
            mainPage130111.inputProducto.click();
            mainPage130111.inputDescripcion.sendKeys("PRUEBAS");
            mainPage130111.inputFraccionArancelaria.sendKeys("87023005");
            mainPage130111.inputCantidad.sendKeys("1");
            mainPage130111.inputValorFactura.sendKeys("1");
            mainPage130111.inputUMT.sendKeys("Gramo");
            mainPage130111.inputCantidadPartida.sendKeys("1");
            mainPage130111.inputValorPartida.sendKeys("1");
            //mainPage130111.inputFraccionArancelariaTIGIE.sendKeys("30019099");
            //mainPage130111.getInputFraccionArancelariaTIGIE2.sendKeys("30019099");
            mainPage130111.inputDescripcionPartida.sendKeys("PRUEBAS");
            mainPage130111.btnAgregarPartida.click();
            mainPage130111.inputBloquePaisDestino.click();sleep(1000);
            mainPage130111.inputPaisDedstino.sendKeys("ESTADOS UNIDOS DE AMERICA");sleep(1000);
            mainPage130111.btnAgregarBloque.click();sleep(1000);
            mainPage130111.textareaUsoEspecifico.sendKeys("PRUEBA");
            mainPage130111.textareaJustificacion.sendKeys("PRUEBA");
            mainPage130111.textareaObservaciones.sendKeys("PRUEBAS");
            mainPage130111.inputEntidad.sendKeys("SINALOA");
            mainPage130111.inputRepresentacionFederal.sendKeys("CULIACAN");

            mainPage130111.inputGuardarSolicitud.click();
            mainPage130111.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage130111.btnAnexar.click();sleep(2000);
            mainPage130111.btnCerrar.click();
            mainPage130111.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130111);
            String folioText = mainPage130111.folio.getText();
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

    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }
}