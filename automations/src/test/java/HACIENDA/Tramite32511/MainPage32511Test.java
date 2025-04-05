package HACIENDA.Tramite32511;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage32511Test {
    MainPage32511 mainPage32511 = new MainPage32511();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32511 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32511() {
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

//         Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32511");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32511");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32511");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen5701");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion5701");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion5701");



        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
//            desactivarPago();
            loginFirmSoli.login(tramite32511);
            mainPage32511.selecRol.sendKeys("Persona Moral");
            mainPage32511.btnacep.click();
            mainPage32511.Tramites.click();
            mainPage32511.SoliNew.click();
            mainPage32511.hacienda.click();
            mainPage32511.AgaceRegComExt.click();
            mainPage32511.EnvioAvisos.click();
            mainPage32511.Tramite32511.click();

            mainPage32511.TipoAviso.click();
            mainPage32511.Deport.click();
            mainPage32511.ImportMercancia.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\plantilla_Mercancias_32511.xlsx");
            mainPage32511.btnCargarArchivo.click();

            mainPage32511.FechaEvento.sendKeys("04/04/2025");
            mainPage32511.Calle.sendKeys("calle");
            mainPage32511.NumExt.sendKeys("02");
            mainPage32511.NumInt.sendKeys("23");
            mainPage32511.CodPost.sendKeys("95281");
            mainPage32511.EntidadFed.sendKeys("SINALOA");
            mainPage32511.AlcaldiaMun.sendKeys("SINALOA");
            mainPage32511.Col.sendKeys("CENTRO - CP 81900");
            mainPage32511.FechaFinEvent.sendKeys("01/02/2025");
            mainPage32511.Competencia.setValue("06/04/2025");

            mainPage32511.Calle2.sendKeys("calle2");
            mainPage32511.NnumExt2.sendKeys("12");
            mainPage32511.NumInt2.sendKeys("34");
            mainPage32511.CP2.sendKeys("95281");
            mainPage32511.EntFed2.sendKeys("SINALOA");
            mainPage32511.AlcMun2.sendKeys("SINALOA");
            mainPage32511.Col2.sendKeys("CENTRO - CP 81900");
            mainPage32511.CargaDestruc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\plantilla_Destruccion_93_32511.xlsx");
            mainPage32511.btnCargarDestruc.click();
            mainPage32511.FechaDestrucMerc.setValue("06/04/2025");
            mainPage32511.HoraDestruc.sendKeys("02:23");
            mainPage32511.btnContinuar2.click();





//            loginFirmSoli.firma(tramite5701);
//            // Obtener el texto del folio desde mainPageB8
//            String folioText = mainPage5701.folio.getText();
//            // Llamar al metodo para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen5701")) {
//                ProcesoDictamen5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion5701")) {
//                ProcesoAutorizacion5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion5701")) {
//                ProcesoConfirmarNotificaciónResolucion5701(folioNumber);
//            }

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
