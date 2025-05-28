package INBAL.Tramite270101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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

public class MainPage270101Test {
    MainPage270101 mainPage270101 = new MainPage270101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite270101  = new TramitesFirmasLG(
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
    public void Proceso270101() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen270101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion270101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion270101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen270101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion270101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion270101");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite270101);
            mainPage270101.selecRol.sendKeys("Persona Moral");
            mainPage270101.btnacep.click();
            mainPage270101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage270101.SoliNew.click();
            mainPage270101.inbal.click();
            mainPage270101.linkCertificadosLicenciasPermisos.click();
            mainPage270101.linkINBA03003.click();
            mainPage270101.linkPerExpTemObrPlaDecArtHisComINBAL.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage270101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage270101.labelDatosSolicitud.click();
            mainPage270101.btnAgregarObra.click();
            mainPage270101.InputAutor.sendKeys("Diego Rivera");
            mainPage270101.InputTitulo.sendKeys("CATZILLA");
            mainPage270101.InputTecnica.sendKeys("RESINA Y ACRÍLICOS");
            mainPage270101.InputAlto.sendKeys("17");
            mainPage270101.InputAncho.sendKeys("6");
            mainPage270101.InputProfundidad.sendKeys("6");
            mainPage270101.InputDiametro.sendKeys("15");
            mainPage270101.InputVariables.sendKeys("RESINAS Y VINIL");
            mainPage270101.InputAnoCreacion.sendKeys("2025");
            mainPage270101.InputAvaluo.sendKeys("50000");
            mainPage270101.InputMoneda.sendKeys("US Dollar");
            mainPage270101.InputPropietario.sendKeys("TOYCON");
            mainPage270101.InputFraccionArancelaria.sendKeys("37069001");
            mainPage270101.btnGuardar.click();
            mainPage270101.inputMotivo.sendKeys("Donación");
            mainPage270101.InputPais.sendKeys("MEXICO");
            mainPage270101.InputCiudadDestino.sendKeys("CDMX");
            mainPage270101.InputMedioTransporte.sendKeys("Aéreo");
            mainPage270101.inputEmpresaTransportista.sendKeys("PROJET");
            mainPage270101.InputUbicacionFinal.sendKeys("Museo");
            mainPage270101.inputPeriodo.sendKeys("9 a 12 meses");
            mainPage270101.inputAduanaEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage270101.InputDeclaracion.click();
            mainPage270101.InputGuardarSolicitud.click();
            mainPage270101.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage270101.btmAnexar.click();
            mainPage270101.btnCerrar.click();sleep(2000);
            mainPage270101.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite270101);
            String folioText = mainPage270101.folio.getText();sleep(5000);
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