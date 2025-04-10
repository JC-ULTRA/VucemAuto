package AGRICULTURA.Tramite220503;

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
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220503Test {
    MainPage220503 mainPage220503 = new MainPage220503();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite220503  = new TramitesFirmasLG(
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
    public void Proceso220503() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen220503");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion220503");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion220503");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen220503");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion220503");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion220503");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite220503);
            mainPage220503.selecRol.sendKeys("Persona Moral");
            mainPage220503.btnacep.click();
            mainPage220503.Tramites.sendKeys("Solicitudes nuevas");
            mainPage220503.SoliNew.click();
            mainPage220503.Agricultura.click();
            mainPage220503.LinkCertificadosSolicitudRequisitos.click();
            mainPage220503.LinkCertificadoImportInspeccionFisica.click();
            mainPage220503.LinkCertificadoSanidadAcuicolaInspeccionFisica.click();
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage220503.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage220503.LabelDatosSolicitud.click();
            mainPage220503.selectSolicitudNumAutorizacion.selectOptionByValue("83022012025000012");
            Selenide.executeJavaScript("arguments[0].value = '05/04/2025';", mainPage220503.inputSolicitudFechaInspeccion);sleep(100);
            mainPage220503.selectHoraInspeccion.sendKeys("10:00");
            mainPage220503.inputPuntoInspeccion.click();
            mainPage220503.inputNombreInsp.sendKeys("JUAN");
            mainPage220503.inputApePater.sendKeys("PÉREZ");
            mainPage220503.inputApeMater.sendKeys("GARCÍA");
            mainPage220503.inputSolicitudNumeroTotalCarros.sendKeys("2");
            mainPage220503.selectSolicitudTransporteIdeMedio.sendKeys("Marítimo");
            mainPage220503.inputIdentificacionTransporte.sendKeys("ABC-1234");
            mainPage220503.inputSolicitudFerros.click();
            mainPage220503.inpuCheck.click();
            mainPage220503.btnSaldoMercancia.click();
            mainPage220503.inputCantidadUMT.sendKeys("12");
            mainPage220503.inputModificar.click();
            //mainPage220503.btnAceptar.click();
            mainPage220503.inputTotalGuia.sendKeys("1");
            mainPage220503.inputGuardarSolicitud.click();
            mainPage220503.inputAgregarNuevo.click();
            mainPage220503.inputContinuar.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite220503);
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
