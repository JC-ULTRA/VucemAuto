package SENER.Tramite130108;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
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

public class MainPage130108Test {
    MainPage130108 mainPage130108 = new MainPage130108();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130108  = new TramitesFirmasLG(
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
    public void Proceso130108() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130108");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130108");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130108");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130108");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130108");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130108");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130108);
            mainPage130108.selecRol.sendKeys("Persona Moral");
            mainPage130108.btnacep.click();
            mainPage130108.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130108.SoliNew.click();
            mainPage130108.Sener.click();
            mainPage130108.linkPermisoImportExport.click();
            mainPage130108.linkImportacion.click();
            mainPage130108.linkSolImpPetro.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage130108.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130108.labelDatosSolicitud.click();
            mainPage130108.selectRegimenClave.sendKeys("Definitivos");
            mainPage130108.selectClasificacionRegimen.sendKeys("De importación");
            mainPage130108.inputCortoPlazo.click();
            mainPage130108.TextareaDescripcionMercancia.sendKeys("PRUEBA QA");
            mainPage130108.inputCveFraccionArancelaria.sendKeys("27101299");
            mainPage130108.inputNICO.sendKeys("01");
            mainPage130108.inputCantidadMercancia.sendKeys("1");
            mainPage130108.inputValorFactura.sendKeys("1");
            mainPage130108.inputCantidad.sendKeys("1");
            mainPage130108.inputDescripcion.sendKeys("PRUEBA QA");
            mainPage130108.inputValorPArtida.sendKeys("1");
            mainPage130108.btnAgregarPartida.click();sleep(500);
            mainPage130108.btnPaises.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("CHL");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("COL");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.inputPaisOrigen.sendKeys("PER");sleep(1000);
            mainPage130108.btnAgregar.click();sleep(1000);
            mainPage130108.textareaUsoEspecifico.sendKeys("PRUEBAS QA");
            mainPage130108.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130108.textareaObservaciones.sendKeys("PRUEBAS QA");
            mainPage130108.inputDeclaracion.click();
            mainPage130108.btnGuarda.click();sleep(1000);
            mainPage130108.btnContinuar.click();sleep(1000);
            //GUARDAR
//            mainPage130108.inputGuarda.click();sleep(1000);
//            mainPage130108.inputAdjuntar.click();
//            mainPage130108.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage130108.btnAnexar.click();sleep(20000);
//            mainPage130108.btnCerrar.click();
            mainPage130108.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130108);
            String folioText = mainPage130108.folio.getText();sleep(5000);
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
