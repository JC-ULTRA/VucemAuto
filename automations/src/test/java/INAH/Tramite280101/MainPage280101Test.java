package INAH.Tramite280101;

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
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage280101Test {
    MainPage280101 mainPage280101 = new MainPage280101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite280101  = new TramitesFirmasLG(
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
    public void Proceso280101() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen280101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion280101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion280101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen280101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion280101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion280101");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite280101);
            mainPage280101.selecRol.sendKeys("Persona Moral");
            mainPage280101.btnacep.click();
            mainPage280101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage280101.SoliNew.click();
            mainPage280101.INAH.click();
            mainPage280101.linkCertificadosLicenciasPermisos.click();
            mainPage280101.linkPermisoExportaciTemporalDefinitiva.click();
            mainPage280101.linkInahPermisoExportaciTemporal.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage280101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage280101.labelSolicitud.click();
            mainPage280101.selectSolicitudAduanasSalidaClave.sendKeys("AEROPUERTO INT");
            mainPage280101.textareaSolicitudDescripcionClobGenerica.sendKeys("PRUEBA");
            mainPage280101.inputCantAutoriBienesCult.sendKeys("1");
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage280101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage280101.labelMonumentosBienesMueblesHist.click();
            mainPage280101.inputAgregarMercancia.click();
            mainPage280101.inputDescripcionMercancia.sendKeys("PRUEBA");
            mainPage280101.selectGenerica.sendKeys("XVI");
            mainPage280101.inputDescripcionIdentificacion.sendKeys("PRUEBA");
            mainPage280101.selectGenerica2.sendKeys("DOCUMENTOS");
            mainPage280101.inputCantidadPresentacion.sendKeys("10");
            mainPage280101.inputComponente.sendKeys("10");
            mainPage280101.inputImporteTotalComponente.sendKeys("10");
            mainPage280101.selectFraccionTipoTramiteGubernamental.sendKeys("DIBUJOS");
            mainPage280101.textareaDescripcionUsoMercancia.sendKeys("PRUEBA");
            mainPage280101.inputAgregarParte.click();
            mainPage280101.selectElementoAnadido.sendKeys("BASE");
            mainPage280101.textareaDescripcionPresentacion.sendKeys("TEST");
            mainPage280101.inputAlto.sendKeys("10");
            mainPage280101.inputAncho.sendKeys("10");
            mainPage280101.inputProfundidad.sendKeys("10");
            mainPage280101.inputGuardarParte.click();
            mainPage280101.inputGuardarParte2.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage280101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage280101.labelDestino.click();
            mainPage280101.selectSolicitudDomicilioPaisClave.sendKeys("MEXICO");
            mainPage280101.inputCodigoPostal.sendKeys("13940");
            mainPage280101.inputInformacionExtra.sendKeys("TEST");
            mainPage280101.inputDescripcionMunicipio.sendKeys("CORRAL");
            mainPage280101.inputDescUbicacion.sendKeys("CENTRO");
            mainPage280101.inputColonia.sendKeys("CENTRO");
            mainPage280101.inputNumeroExterior.sendKeys("10");
            mainPage280101.inputNumeroInterior.sendKeys("10");
            mainPage280101.inputCalle.sendKeys("CONOCIDA");
            mainPage280101.inputGuardarSolicitud.click();
            mainPage280101.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage280101.btnAnexar.click();sleep(8000);
            Selenide.sleep(4000);
            mainPage280101.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage280101.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite280101);
            Selenide.sleep(2000);
            String folioText = mainPage280101.folio.getText();sleep(5000);
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