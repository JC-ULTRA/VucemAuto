package Economia.Tramite140105;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130118.MainPage130118Test;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140105Test {
    MainPage140105 mainPage140105 = new MainPage140105();
    MainPage130118Test mainPage130118Test = new MainPage130118Test();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite140105  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso140105() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen140105");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion140105");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion140105");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen140105");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion140105");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion140105");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            mainPage130118Test.tramitePrincipal();
            String folioTextCancelar = mainPage140105.folio.getText();
            String folioCancelar = obtenerFolio.obtenerFolio(folioTextCancelar);
            setUpAll();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite140105);
            mainPage140105.selecRol.sendKeys("Persona Moral");
            mainPage140105.btnacep.click();
            mainPage140105.Tramites.sendKeys("Solicitudes nuevas");
            mainPage140105.SoliNew.click();
            mainPage140105.Econom.click();
            mainPage140105.linkCancelDesistReactiv.click();
            mainPage140105.linkModifCancelDesistPeticion.click();
            mainPage140105.linkDesistSolPermPetInteresado.click(); sleep(500);
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage140105.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //CANCELACIÓN DE SOLICITUDES
            mainPage140105.labelCancelacinoSolicitud.click();
            mainPage140105.inputBusquedaFolio.click();
            mainPage140105.inputNumFolioTramite.sendKeys(folioCancelar);
            mainPage140105.inputValidaFolioResolucionCancelacion.click();
            mainPage140105.inputAgregarRegistro.click();
            mainPage140105.textareaMotivoCancelacion.sendKeys("PRUEBA QA");
            mainPage140105.inputGuardaSolicitud.click();
            mainPage140105.inputContinuar.click();
            metodos.cargarDocumentos();
            mainPage140105.btnAdjuntar.click();
            mainPage140105.btnCerrar.click();
            //Firmas
            mainPage140105.inputSiguienteButton.click();
            loginFirmSoli.firma(tramite140105);

            // Obtener el texto del folio desde mainPage140105
            String folioText = mainPage140105.folio.getText();

            // Llamar al mtodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);



        }, repeticiones);

    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            setUpAll();
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase

        }
    }

}