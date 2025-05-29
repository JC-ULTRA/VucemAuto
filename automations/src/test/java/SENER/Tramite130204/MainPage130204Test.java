package SENER.Tramite130204;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SENER.Tramite130204.MainPage130204;
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
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130204Test {
    MainPage130204 mainPage130204 = new MainPage130204();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130204  = new TramitesFirmasLG(
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
    public void Proceso130204() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130204");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130204");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130204");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130204");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130204");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130204");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130204);
            mainPage130204.selecRol.sendKeys("Persona Moral");
            mainPage130204.btnacep.click();
            mainPage130204.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130204.SoliNew.click();
            mainPage130204.Sener.click();
            mainPage130204.linkPermisoImportExport.click();
            mainPage130204.linkExportacion.click();
            mainPage130204.linkSolExpHidro.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage130204.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130204.labelDatosSolicitud.click();
            mainPage130204.selectRegimenClave.sendKeys("Definitivos");
            mainPage130204.selectClasificacionRegimen.sendKeys("De Exportación");
            //mainPage130204.inputCortoPlazo.click();
            mainPage130204.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
            mainPage130204.inputCveFraccionArancelaria.sendKeys("27112101");
            mainPage130204.inputNICO.sendKeys("00");
            mainPage130204.inputCantidadMercancia.sendKeys("50000");
            mainPage130204.inputValorFactura.sendKeys("100000");
            mainPage130204.inputCantidad.sendKeys("50000");
            mainPage130204.inputDescripcion.sendKeys("PRUEBA QA");
            mainPage130204.inputValorPArtida.sendKeys("100000");
            mainPage130204.btnAgregarPartida.click();sleep(500);
            mainPage130204.btnPaises.click();sleep(1000);
            mainPage130204.inputPaisOrigen.sendKeys("AND");sleep(1000);
            mainPage130204.btnAgregar.click();sleep(1000);
            mainPage130204.inputPaisOrigen.sendKeys("JPN");sleep(1000);
            mainPage130204.btnAgregar.click();sleep(1000);
            //mainPage130204.inputPaisOrigen.sendKeys("PER");sleep(1000);
            //mainPage130204.btnAgregar.click();sleep(1000);
            mainPage130204.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
            mainPage130204.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130204.textareaObservaciones.sendKeys("PRUEBAS QA");
            mainPage130204.inputDeclaracion.click();
            mainPage130204.btnGuarda.click();sleep(1000);
            mainPage130204.btnContinuar.click();sleep(1000);
            //mainPage130204.inputGuarda.click();
            metodos.cargarDocumentos();
            mainPage130204.btnAnexar.click();sleep(28000);
            Selenide.sleep(3000);
            mainPage130204.btnCerrar.click();
            //GUARDAR
            mainPage130204.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130204);
            String folioText = mainPage130204.folio.getText();sleep(5000);
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