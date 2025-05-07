package Economia.Tramite130109;

import DBYFOLIO.ConDBReasigSolFun;
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

public class MainPage130109Test {
    MainPage130109 mainPage130109 = new MainPage130109();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130109  = new TramitesFirmasLG(
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
    public void Proceso130109() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130109");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130109");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130109");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130109");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130109");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130109");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130109);
            mainPage130109.selecRol.sendKeys("Persona Moral");
            mainPage130109.btnacep.click();
            mainPage130109.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130109.SoliNew.click();
            mainPage130109.Econom.click();
            mainPage130109.linkPermisosImportaciExportaci.click();
            mainPage130109.linkImportaci.click();
            mainPage130109.linkImpNeuRecPruLab.click(); sleep(500);
              try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130109.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS TRAMITE
            mainPage130109.labelDatosSolicitud.click();
            mainPage130109.SelectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage130109.SelectSolicitudClaveClasificacionRegimen.sendKeys("De importación");
            sleep(100);
            //DATOS DE LA MERCANCÍA
            mainPage130109.inputUsado.click();
            mainPage130109.textareaDescripcionMercancia.sendKeys("Prueba");
            mainPage130109.SelectFraccionArancelaria.sendKeys("40122099");
            mainPage130109.inputCantidadTarifaria.sendKeys("1");
            mainPage130109.inputValorFacturaUSD.sendKeys("1");
            mainPage130109.selectUnidadTarifaria.sendKeys("Pieza");
            //PARTIDAS MERCANCÍA
            mainPage130109.inputCantidad.sendKeys("1");
            mainPage130109.inputTotalUSDPartida.sendKeys("1");
            mainPage130109.textareaDescripcion.sendKeys("Prueba texto");
            mainPage130109.btnAgregar.click();
            //PAÍS PROCEDENCIA
            mainPage130109.bloqueAutocomplete.sendKeys("T-MEC");
            mainPage130109.paisBloqueOrigenSearch.click();
            mainPage130109.selectPaisBloqueOrigen.click();
            mainPage130109.textareaUsoEspecifico.sendKeys("Prueba");
            mainPage130109.textareaJustificacionImportacionExportacion.sendKeys("prueba");
            mainPage130109.textareaObservaciones.sendKeys("textareaObservaciones");
            //REPRESENTACIÓN FEDERAL
            mainPage130109.selectEntidadFederativaClave.sendKeys("SINALOA");
            mainPage130109.selectRepresentacionFederal.sendKeys("CENTRAL CDMX");
            mainPage130109.inputGuardarSolicitud.click();
            mainPage130109.btnContinuar.click();
            mainPage130109.btnAdjuntarDoc.click();
            mainPage130109.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");Selenide.sleep(100);
            mainPage130109.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");Selenide.sleep(100);
            mainPage130109.btnAdjuntar.click();Selenide.sleep(3000);
            mainPage130109.btnCerrar.click();sleep(3500);
            mainPage130109.btnSiguiente.click();
            //Firmas
            loginFirmSoli.firma(tramite130109);
            String folioText = mainPage130109.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);



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