package Economia.Tramite130106;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
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
import static com.codeborne.selenide.Selenide.*;

public class MainPage130106Test {
    MainPage130106 mainPage130106 = new MainPage130106();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130106  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130106() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130106");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130106");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130106");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130106");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130106");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130106");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
                    loginFirmSoli.login(tramite130106);
                    mainPage130106.selecRol.sendKeys("Persona Moral");
                    mainPage130106.btnacep.click();
                    mainPage130106.Tramites.sendKeys("Solicitudes nuevas");
                    mainPage130106.SoliNew.click();
                    mainPage130106.Econom.click();
                    mainPage130106.linkPermisosImportaciExportaci.click();
                    mainPage130106.linkImportaci.click();
                    mainPage130106.linkAvisoAutomTicoImportaci.click(); sleep(500);
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130106.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    mainPage130106.labelDatosSolicitud.click();
                    //DATOS TRAMITE
                    mainPage130106.SelectSolicitudRegimenClave.sendKeys("Definitivos");
                    mainPage130106.SelectSolicitudClaveClasificacionRegimen.sendKeys("De importación");
                    sleep(100);
                    //DATOS DE LA MERCANCÍA
                    mainPage130106.textareaDescripcionMercancia.sendKeys("Prueba");
                    mainPage130106.SelectFraccionArancelaria.sendKeys("87032102 - Usados, excepto lo comprendido en la fracción arancelaria 8703.21.01.");
                    mainPage130106.inputCantidadTarifaria.sendKeys("369");
                    mainPage130106.inputValorFacturaUSD.sendKeys("36");
                    mainPage130106.selectUnidadTarifaria.sendKeys("Pieza");
                    //PARTIDAS MERCANCÍA
                    mainPage130106.inputCantidad.sendKeys("15");
                    mainPage130106.inputTotalUSDPartida.sendKeys("369");
                    mainPage130106.textareaDescripcion.sendKeys("Prueba texto");
                    mainPage130106.btnAgregar.click();
                    //PAÍS PROCEDENCIA
                    mainPage130106.bloqueAutocomplete.sendKeys("T-MEC");
                    mainPage130106.paisBloqueOrigenSearch.click();
                    mainPage130106.btnAgregarTodos.click();
                    mainPage130106.textareaUsoEspecifico.sendKeys("Prueba");
                    mainPage130106.textareaJustificacionImportacionExportacion.sendKeys("prueba");
                    mainPage130106.textareaObservaciones.sendKeys("textareaObservaciones");
                    //REPRESENTACIÓN FEDERAL
                    mainPage130106.selectEntidadFederativaClave.sendKeys("SINALOA");
                    mainPage130106.selectRepresentacionFederal.sendKeys("CENTRAL CDMX");
                    mainPage130106.inputGuardarSolicitud.click();
                    //Manda error: "el solicitante debe contar con RECIF."
                    //Firmas
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
