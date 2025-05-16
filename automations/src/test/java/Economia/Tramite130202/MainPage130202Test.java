package Economia.Tramite130202;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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
import Metodos.Metodos;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130202Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage130202Test.class);
    MainPage130202 mainPage130202 = new MainPage130202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AFC000526BJ2";

    TramitesFirmasLG tramite130202  = new TramitesFirmasLG(
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
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso130202() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130202");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130202");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130202");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130202");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130202");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130202");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130202);
            mainPage130202.selecRol.sendKeys("Persona Moral");
            mainPage130202.btnacep.click();
            mainPage130202.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130202.SoliNew.click();
            mainPage130202.economia.click();
            mainPage130202.direccionGeneralNormas.click();
            mainPage130202.exportacion.click();
            mainPage130202.exportacionMineralesHierro.click();
            mainPage130202.labelDatosSolicitud.click();
            mainPage130202.inputRegimen.sendKeys("Definitivos");
            mainPage130202.inputClasificacion.sendKeys(" De exportación");
            mainPage130202.inputDescripcion.sendKeys("PRUEBAS");
            mainPage130202.inputFraccionArancelaria.sendKeys("26011201");
            mainPage130202.inputCantidad.sendKeys("22");
            mainPage130202.inputValorFactura.sendKeys("33");
            mainPage130202.inputUMT.sendKeys("Kilogramo");
            mainPage130202.inputCantidadPartida.sendKeys("22");
            mainPage130202.inputValorPartida.sendKeys("1.5");
            mainPage130202.inputDescripcionPartida.sendKeys("PRUEBAS");
            mainPage130202.btnAgregarPartida.click();
            mainPage130202.inputBloquePaisDestino.sendKeys("T-MEC");
            mainPage130202.inputPaisDedstino.sendKeys("ESTADOS UNIDOS DE AMERICA");
            mainPage130202.btnAgregarBloque.click();
            mainPage130202.textareaUsoEspecifico.sendKeys("PRUEBA");
            mainPage130202.textareaJustificacion.sendKeys("PRUEBA");
            mainPage130202.textareaObservaciones.sendKeys("PRUEBAS");
            mainPage130202.inputEntidad.sendKeys("CIUDAD DE MEXICO");
            mainPage130202.inputRepresentacionFederal.sendKeys("CENTRAL CDMX");
            mainPage130202.inputGuardarSolicitud.click();
            mainPage130202.inputGuarda.click();sleep(1000);
            mainPage130202.inputAdjuntar.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage130202.btnAnexar.click();sleep(20000);
            mainPage130202.btnCerrar.click();
            mainPage130202.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130202);
            String folioText = mainPage130202.folio.getText();
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
    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
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