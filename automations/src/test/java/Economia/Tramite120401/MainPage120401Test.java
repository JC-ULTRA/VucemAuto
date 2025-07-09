package Economia.Tramite120401;

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
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120401Test {
    MainPage120401 mainPage120401 = new MainPage120401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite120401 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
    );
    TramitesFirmasLG tramite120401Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso120401() {
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

        // Crear checkboxes
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen120401");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion120401");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion120401");

        // Deshabilitar los siguientes inicialmente
        autorizacionCheckBox.setEnabled(false);
        confirmacionCheckBox.setEnabled(false);

        // Listener para Dictamen → habilita Autorización
        dictamenCheckBox.addItemListener(e -> {
            boolean selected = dictamenCheckBox.isSelected();
            autorizacionCheckBox.setEnabled(selected);
            if (!selected) {
                autorizacionCheckBox.setSelected(false);
                confirmacionCheckBox.setSelected(false);
                confirmacionCheckBox.setEnabled(false);
            }
        });

        // Listener para Autorización → habilita Confirmación
        autorizacionCheckBox.addItemListener(e -> {
            boolean selected = autorizacionCheckBox.isSelected();
            confirmacionCheckBox.setEnabled(selected);
            if (!selected) {
                confirmacionCheckBox.setSelected(false);
            }
        });

        // Panel vertical para presentación
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.add(new JLabel("Seleccione los métodos a ejecutar:"));
//        panel.add(dictamenCheckBox);
//        panel.add(autorizacionCheckBox);
//        panel.add(confirmacionCheckBox);

        // Mostrar diálogo
//        int option = JOptionPane.showConfirmDialog(null, panel, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Validar opción
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen120401");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion120401");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion120401");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            loginFirmSoli.login(tramite120401Fun);
            mainPage120401.selecRol.sendKeys("Persona Fisica");
            mainPage120401.btnacep.click();
            mainPage120401.Tramites.click();
            mainPage120401.SoliNew.click();
            mainPage120401.economia.click();
            mainPage120401.linkCuposimpExp.click();
            mainPage120401.linkAsignacionDirectaCupo.click();
            mainPage120401.linkAsiDirCupPerFis.click();
            try {
                Thread.sleep(2000);
                mainPage120401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage120401.labelAsignacion.click();
            mainPage120401.inputEntidadFederativa.sendKeys("DURANGO");
            mainPage120401.inputRepresentacionFed.sendKeys("DURANGO");
            mainPage120401.inputRegimenAduanero.sendKeys("Importación");
            mainPage120401.btnBuscarCupos.click();
            mainPage120401.inputCuposDisponibles.doubleClick();
            mainPage120401.inputCantidadSoicitada.sendKeys("5000");
            mainPage120401.InputGuardarSolicitud.click();
            mainPage120401.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage120401.btmAnexar.click();sleep(5000);
            Selenide.sleep(2000);
            mainPage120401.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage120401.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite120401Fun);
            String folioText = mainPage120401.folio.getText();
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

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

}