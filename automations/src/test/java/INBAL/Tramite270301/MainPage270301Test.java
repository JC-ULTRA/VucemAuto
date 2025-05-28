package INBAL.Tramite270301;

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

public class MainPage270301Test {
    MainPage270301 mainPage270301 = new MainPage270301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite270301  = new TramitesFirmasLG(
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
    public void Proceso270301() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen270301");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion270301");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion270301");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen270301");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion270301");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion270301");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite270301);
            mainPage270301.selecRol.sendKeys("Persona Moral");
            mainPage270301.btnacep.click();
            mainPage270301.Tramites.sendKeys("Solicitudes nuevas");
            mainPage270301.SoliNew.click();
            mainPage270301.inbal.click();
            mainPage270301.linkCertificadosLicenciasPermisos.click();
            mainPage270301.linkAvisoImpObrPlaArtDecMonArtHis.click();
            mainPage270301.AvisoImpObrPlaArtDecMonArtHis.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(2000);
                mainPage270301.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage270301.labelDatosSolicitud.click();
            //mainPage270301.inputTipoOperacion.sendKeys("Importación");
            mainPage270301.inputTipoMovimiento.sendKeys("Temporal");
            mainPage270301.btnAgregarObra.click();
            mainPage270301.InputAutor.sendKeys("Diego Rivera");
            mainPage270301.InputTitulo.sendKeys("CATZILLA");
            mainPage270301.InputTecnica.sendKeys("RESINA Y ACRÍLICOS");
            mainPage270301.InputAlto.sendKeys("17");
            mainPage270301.InputAncho.sendKeys("6");
            mainPage270301.InputProfundidad.sendKeys("6");
            mainPage270301.InputDiametro.sendKeys("15");
            mainPage270301.InputVariables.sendKeys("RESINAS Y VINIL");
            mainPage270301.InputAnoCreacion.sendKeys("2025");
            mainPage270301.InputAvaluo.sendKeys("50000");
            mainPage270301.InputMoneda.sendKeys("US Dollar");
            mainPage270301.InputPropietario.sendKeys("TOYCON");
            mainPage270301.InputFraccionArancelaria.sendKeys("37069001");
            mainPage270301.btnGuardar.click();
            mainPage270301.inputMotivo.sendKeys("Donación");
            mainPage270301.InputPais.sendKeys("MEXICO");
            mainPage270301.InputCiudadDestino.sendKeys("CDMX");
            mainPage270301.InputMedioTransporte.sendKeys("Aéreo");
            mainPage270301.inputEmpresaTransportista.sendKeys("PROJET");
            mainPage270301.InputUbicacionFinal.sendKeys("Museo");
            mainPage270301.inputPeriodo.sendKeys("9 a 12 meses");
            mainPage270301.inputAduanaEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage270301.InputDeclaracion.click();
            mainPage270301.InputGuardarSolicitud.click();
            mainPage270301.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage270301.btmAnexar.click();
            mainPage270301.btnCerrar.click();sleep(2000);
            mainPage270301.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite270301);
            String folioText = mainPage270301.folio.getText();sleep(5000);
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