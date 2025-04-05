package Economia.Tramite120602;
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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPage120602Test {
    MainPage120602 mainPage120602 = new MainPage120602();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite120602  = new TramitesFirmasLG(
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
    public void Proceso120602() {
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
//
//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130118");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130118");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130118");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }
//
//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130118");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130118");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130118");



        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite120602);
            mainPage120602.selecRol.sendKeys("Persona Moral");
            mainPage120602.btnacep.click();
            mainPage120602.Tramites.sendKeys("Solicitudes nuevas");
            mainPage120602.SoliNew.click();
            mainPage120602.Econom.click();
            mainPage120602.CupoExIm.click();
            mainPage120602.RegistroEmpresComerIndustFront.click();
            mainPage120602.Tramite120602.click();
            mainPage120602.PestDatEmpres.click();
            mainPage120602.Estado.sendKeys("SONORA");sleep(5000);
            mainPage120602.CargarDatosDomicilio.doubleClick();
            mainPage120602.TipoEmpresa.sendKeys("OTROS SERVICIOS");sleep(5000);
            mainPage120602.Especifique.sendKeys("OTROS SERVICIOS");sleep(5000);
            mainPage120602.Clasif.sendKeys("1112");sleep(5000);
            mainPage120602.ClickFuera.click();
            mainPage120602.ClickSi.click();sleep(5000);
            mainPage120602.RFC.sendKeys("MAVL621207C95");sleep(5000);
            mainPage120602.CheckSi.click();
            mainPage120602.btnAgregar.click();
            mainPage120602.btnContinuar.click();
            sleep(8000);
          //firmas
            loginFirmSoli.firma(tramite120602);
            // Obtener el texto del folio desde mainPage130118
            String folioText = mainPage120602.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//           ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

////             Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen130118")) {
//                ProcesoDictamen130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion130118")) {
//                ProcesoAutorizacion130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion130118")) {
//                ProcesoConfirmarNotificaciónResolucion130118(folioNumber);
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


