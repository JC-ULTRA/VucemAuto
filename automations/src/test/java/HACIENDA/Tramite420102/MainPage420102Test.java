package HACIENDA.Tramite420102;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage420102Test {
    MainPage420102 mainPage420102 = new MainPage420102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite420102 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite420102fun = new TramitesFirmasLG(
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(80000, TimeUnit.SECONDS);
        Configuration.timeout = 80000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso420102() {
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

//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen420102");
//        JCheckBox verificaCheckBox = new JCheckBox("Procesoverifica420102");
//        JCheckBox autorizaCheckBox = new JCheckBox("Procesoautoriza420102");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmar420102");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificaCheckBox, autorizaCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }
//
//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen420102");
//        if (verificaCheckBox.isSelected()) selectedMethods.add("Procesoverifica420102");
//        if (autorizaCheckBox.isSelected()) selectedMethods.add("Procesoautoriza420102");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar420102");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            loginFirmSoli.login(tramite420102);
            mainPage420102.selecRol.sendKeys("Persona Moral");
            mainPage420102.btnacep.click();
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();
            $(withText("Solicitudes nuevas")).click();
            $("[alt='Administración General de Aduanas']").click();
            $(withText("Aviso Único")).click();
            $(withText("Registro de Proveedores")).click();
            $(withText("Concluir relación Industria Automotriz - Proveedor")).click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage420102.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            $(withText("Concluir Relacion")).click();
            mainPage420102.inputRFC.sendKeys("TSD931210493");
            mainPage420102.btnBuscar.click();
            mainPage420102.radioContibuyente.click();
            mainPage420102.InputGuardarSolicitud.click();sleep(3000);
            mainPage420102.btnAceptar.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite420102);
            String folioText = mainPage420102.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
            guardarFolioEnArchivo(folioNumber);

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
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados420102.txt";

        // Formato de fecha y hora: 2025-07-02 18:45:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(timestamp + " - " + folioNumber);
            writer.newLine();
            System.out.println("Folio guardado correctamente: " + folioNumber);
        } catch (IOException e) {
            System.err.println("Error al guardar el folio: " + e.getMessage());
        }
    }
}