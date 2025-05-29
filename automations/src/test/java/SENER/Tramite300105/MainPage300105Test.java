package SENER.Tramite300105;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage300105Test {
    MainPage300105 mainPage300105 = new MainPage300105();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite300105  = new TramitesFirmasLG(
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
    public void Proceso300105() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen300105");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion300105");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion300105");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen300105");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion300105");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion300105");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite300105);
            mainPage300105.selecRol.sendKeys("Persona Moral");
            mainPage300105.btnacep.click();
            mainPage300105.Tramites.sendKeys("Solicitudes nuevas");
            mainPage300105.SoliNew.click();
            mainPage300105.Sener.click();
            mainPage300105.linkCertificadosLicenciasPermisos.click();
            mainPage300105.linkAutComExtFueRadIon.click();
            mainPage300105.linkAutImpExpRayosX.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage300105.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage300105.labelDatosSolicitud.click();
            mainPage300105.inputNumeroCertificado.sendKeys("1234");
            mainPage300105.inputTipoOperacion.sendKeys("Exportación");
            mainPage300105.inputFinalidad.sendKeys("Adquisición y transferencia");
            mainPage300105.inputExento.click();
            mainPage300105.inputNumeroAuto1.sendKeys("123");
            mainPage300105.inputNumeroAuto2.sendKeys("3456");
            mainPage300105.inputNumeroAuto3.sendKeys("2025");
            mainPage300105.btnAgregarRayosX.click();
            mainPage300105.inputNumeroEquipos.sendKeys("1");
            mainPage300105.inputMarca.sendKeys("PRUEBA");
            mainPage300105.inputModelo.sendKeys("PRUEBAS");
            mainPage300105.inputVoltajeRayos.sendKeys("10");
            mainPage300105.selectUnidadMedidaVoltaje.sendKeys("Voltios");sleep(1000);
            mainPage300105.inputCorrienteRayos.sendKeys("10");
            mainPage300105.selectUnidadMedidaCorriente.sendKeys("Amperios");sleep(1000);
            mainPage300105.selectFraccionArancelaria.sendKeys("90221901");
            mainPage300105.inputSerie.sendKeys("2633452");sleep(1000);
            mainPage300105.inputAgregarSerie.click();sleep(1000);
            metodos.presionarEscYSpace();
            mainPage300105.inputAgregarRayos.click();
            metodos.presionarEscYSpace();
            mainPage300105.textareaObservaciones2.sendKeys("PRUEBA QA");
            mainPage300105.selectAduanas.sendKeys("ACAPULCO");
            mainPage300105.inputAdd.click();
            try {
                Thread.sleep(2000);
                mainPage300105.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage300105.labelTercerosRelacionados.click();
            mainPage300105.inputAgregarDes.click();
            mainPage300105.inputDenominacionRazon.sendKeys("PROTEO");
            mainPage300105.textareaDomicilio.sendKeys("TEST");
            mainPage300105.selectPaisExtranjero.sendKeys("AFGANISTAN");
            mainPage300105.inputCorreo.sendKeys("sdrg@asgae.com.mx");
            mainPage300105.inputPaginaWeb.sendKeys("AFGANISTAN");
            mainPage300105.selectTipoMercancia.selectOptionByValue("1");
            mainPage300105.inputRelacionarMer.click();
            Selenide.sleep(1000);
            metodos.presionarEscYSpace();
            mainPage300105.inputAgregarTerceros.click();
            try {
                Thread.sleep(2000);
                mainPage300105.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage300105.labelPagoDerechos.click();
            mainPage300105.inputCveBanco.sendKeys("BANAMEX");
            Random random = new Random();
            int llavePago = 10_000_000 + random.nextInt(90_000_000);
            mainPage300105.inputLlavePago.setValue(String.valueOf(llavePago));
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage300105.inputFechaPago); sleep(1000);
            mainPage300105.InputGuardarSolicitud.click();
            mainPage300105.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage300105.btmAnexar.click();sleep(5000);
            Selenide.sleep(2000);
            mainPage300105.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage300105.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite300105);
            String folioText = mainPage300105.folio.getText();sleep(5000);
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