package INBAL.Tramite270201;

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

public class Tramite270201Test {
    MainPage270201 mainPage270201 = new MainPage270201();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite270201  = new TramitesFirmasLG(
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
    public void Proceso270201() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen270201");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion270201");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion270201");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen270201");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion270201");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion270201");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite270201);
            mainPage270201.selecRol.sendKeys("Persona Moral");
            mainPage270201.btnacep.click();
            mainPage270201.Tramites.sendKeys("Solicitudes nuevas");
            mainPage270201.SoliNew.click();
            mainPage270201.inbal.click();
            mainPage270201.linkCertificadosLicenciasPermisos.click();
            mainPage270201.linkInba04001.click();
            mainPage270201.linkAviImpExpObrArtSigXXyXXI.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage270201.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage270201.labelDatosSolicitud.click();
            mainPage270201.inputTipoOperacion.sendKeys("Importación");
            mainPage270201.inputTipoMovimiento.sendKeys("Definitivo");
            mainPage270201.btnAgregarObra.click();
            mainPage270201.InputAutor.sendKeys("PROTEO");
            mainPage270201.InputTitulo.sendKeys("CATZILLA");
            mainPage270201.InputTecnica.sendKeys("RESINA Y ACRÍLICOS");
            mainPage270201.InputAlto.sendKeys("17");
            mainPage270201.InputAncho.sendKeys("6");
            mainPage270201.InputProfundidad.sendKeys("6");
            mainPage270201.InputDiametro.sendKeys("15");
            mainPage270201.InputVariables.sendKeys("RESINAS Y VINIL");
            mainPage270201.InputAnoCreacion.sendKeys("2025");
            mainPage270201.InputAvaluo.sendKeys("50000");
            mainPage270201.InputMoneda.sendKeys("US Dollar");
            mainPage270201.InputPropietario.sendKeys("TOYCON");
            mainPage270201.InputFraccionArancelaria.sendKeys("49011001");
            mainPage270201.btnGuardar.click();
            mainPage270201.inputMotivo.sendKeys("Exposición");
            mainPage270201.inputNombre.sendKeys("@PROTEUS_TOYS");
            mainPage270201.InputPais.sendKeys("MEXICO");
            mainPage270201.InputCiudadDestino.sendKeys("CDMX");
            mainPage270201.InputMedioTransporte.sendKeys("Terrestre");
            mainPage270201.InputAduanaEntrada.sendKeys("ALTAMIRA");
            mainPage270201.InputDeclaracion.click();
            mainPage270201.InputGuardarSolicitud.click();
            mainPage270201.btnContinuar.click();
            mainPage270201.btnAdjuntarDocument.click();
            mainPage270201.inputDocument.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage270201.btmAnexar.click();
            mainPage270201.btnCerrar.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite270201);
            String folioText = mainPage270201.folio.getText();sleep(5000);
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