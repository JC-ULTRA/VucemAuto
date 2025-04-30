package Economia.Tramite130217;

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

public class MainPage130217Test {
    MainPage130217 mainPage130217 = new MainPage130217();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130217  = new TramitesFirmasLG(
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
    public void Proceso130217() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130217");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130217");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130217");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130217");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130217");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130217");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130217);
            mainPage130217.SelecRol.sendKeys(new CharSequence[]{"Persona Moral"});
            mainPage130217.Btnacep.click();
            mainPage130217.tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
            mainPage130217.SoliNew.click();
            mainPage130217.Economia.click();
            mainPage130217.linkPermisos.click();
            mainPage130217.linkExportacion.click();
            mainPage130217.linkPermisoPreConExpo.click();
            //DATOS SOLICITUD
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130217.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130217.LabelDatosSolicitud.click();
            mainPage130217.SelectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage130217.SelectSolicitudClaveClasificacionRegimen.sendKeys("De exportación");

            //DATOS DE LA MERCANCÍA
            mainPage130217.radbtnProductoNuevo.click();
            mainPage130217.textareaDescripcionMercancia.sendKeys("Prueba");
            mainPage130217.SelectFraccionArancelaria.sendKeys("28199099");
            mainPage130217.inputCantidadTarifaria.sendKeys("100");
            mainPage130217.inputValorFacturaUSD.sendKeys("100");

            //PARTIDAS MERCANCÍA
            mainPage130217.inputCantidad.sendKeys("100");
            mainPage130217.inputValor.sendKeys("100");
            mainPage130217.textareaDescripcion.sendKeys("QA descripción");
            mainPage130217.btnAgregarMercancia.click();sleep(500);
            mainPage130217.inputBloque.sendKeys("T-MEC");sleep(500);
            mainPage130217.inputPaisOrigen.selectOption("ESTADOS UNIDOS DE AMERICA");sleep(500);
            mainPage130217.inputAgregarPais.click();
            mainPage130217.textareaUsoEspecifico.sendKeys("PRUEBA");
            mainPage130217.textareaJustificacion.sendKeys("PRUEBA QA");
            mainPage130217.textareaObservaciones.sendKeys("PRUEBA QA QA");
            mainPage130217.selectEntidadFederativa.sendKeys("SINALOA");
            mainPage130217.selesctRepresentacioFederal.sendKeys("CULIACAN");
            mainPage130217.inputGuardaSolicitud.click();
            mainPage130217.btnContinuar.click();
            mainPage130217.btnAdjuntar.click();
            mainPage130217.inputDocument0.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130217.inputDocument1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130217.inputAdjuntarDocumentos.click();
            mainPage130217.btnCerrar.click();
            mainPage130217.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite130217);
            String folioText = mainPage130217.folio.getText();
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