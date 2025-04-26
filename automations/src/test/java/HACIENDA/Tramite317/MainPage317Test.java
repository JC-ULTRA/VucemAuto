package HACIENDA.Tramite317;

import HACIENDA.Tramite317.MainPage317;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage317Test {
    MainPage317 mainPage317 = new MainPage317();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite317  = new TramitesFirmasLG(
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
    public void Proceso317() {
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

        /*
        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen317");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion317");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion317");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen317");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion317");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion317");
         */

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }else if (!(FolioTramiteN.startsWith("25003016001") || FolioTramiteN.startsWith("25003016002")|| FolioTramiteN.startsWith("25003016003")))
            {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no pertenece a un Rubro A,AA,AAA. La operación será cancelada.");
                return;
            }

            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite317);
            mainPage317.selecRol.sendKeys("Persona Moral");
            mainPage317.btnacep.click();

            //Búsqueda de tramite Subsecuente
            mainPage317.Tramites.sendKeys("Solicitudes nuevas");
            mainPage317.SoliSub.click();
            mainPage317.FolioTramite.sendKeys(FolioTramiteN);
            mainPage317.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage317.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Solicitar modificación y Prórroga
            //mainPage317.btnSolicitarRenovacion.click();
            mainPage317.tabAvisoRenovacion.click();

            if (FolioTramiteN.startsWith("25003016001")) {
                mainPage317.radbtnRubroA.click(); sleep(1000);
            }
            if (FolioTramiteN.startsWith("25003016002")) {
                mainPage317.radbtnRubroAA.click(); sleep(1000);
            }
            if (FolioTramiteN.startsWith("25003016003")) {
                mainPage317.radbtnRubroAAA.click(); sleep(1000);
            }

            mainPage317.radbtnBajoProtest.click(); sleep(1000);
            mainPage317.radbtnConEnvio.click(); sleep(1000);
            mainPage317.radbtnCircunstanc.click(); sleep(1000);

            //Pago de derechos
            mainPage317.NumOperac.sendKeys("TestNumOperac1");sleep(1000);
            mainPage317.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage317.inpLLavePago.sendKeys(llavePago);sleep(1000);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage317.FechaPago); sleep(1000);
            mainPage317.btnContinuar.click(); sleep(1000);

            //Paso 2
            mainPage317.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage317.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage317.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage317.btnAdjuntar2.click();sleep(2000);
            mainPage317.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage317.btnCerrar3.click();sleep(1000);
            mainPage317.btnContinuarPaso3.click();

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite317);

            // Obtener el texto del folio desde mainPage130103
            String folioText = mainPage317.folio.getText();

            // Llamar al mtodo para obtener el folio
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
