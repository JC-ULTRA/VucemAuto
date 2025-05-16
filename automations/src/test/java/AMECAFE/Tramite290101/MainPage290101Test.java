package AMECAFE.Tramite290101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage290101Test {
    MainPage290101 mainPage290101 = new MainPage290101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AFC000526BJ2";

    TramitesFirmasLG tramite290101  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
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
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso290101() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen290101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion290101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion290101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen290101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion290101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion290101");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite290101);
//            mainPage290101.selecRol.sendKeys("Persona Moral");
//            mainPage290101.btnacep.click();
            mainPage290101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage290101.SoliNew.click();
            mainPage290101.AMECAFE.click();
            mainPage290101.CerificadosLicenciaPermisos.click();
            mainPage290101.RegistroNacionalExportadoresCafe.click();
            mainPage290101.Tramite290101.click();
            //DATOS SOLICITUD
            mainPage290101.labelDatosSolicitud.click();
            mainPage290101.inputProductorCafe.click();
            Random random = new Random();
            int nu6Digitos = 100000 + random.nextInt(900000); // de 100000 a 999999
            mainPage290101.inputClavePatron.setValue(String.valueOf(nu6Digitos));
            mainPage290101.btnAgregarRegion.click();
            mainPage290101.inputEstado.sendKeys("CHIAPAS");
            mainPage290101.inputCafeCompra.sendKeys("Bola");
            mainPage290101.inputRegion.sendKeys("PRUEBA");
            mainPage290101.inputTipoCafe.sendKeys("ROBUSTA");
            mainPage290101.inputVolumnen.sendKeys("234");
            mainPage290101.btnGuardar.click();
            mainPage290101.btnAgregarBeneficios.click();
            mainPage290101.inputNombreBeneficio.sendKeys("PROTEUS");
            mainPage290101.inputPropiaAlquilada.sendKeys("Propia");
            mainPage290101.inputCalle.sendKeys("PRUEBA");
            mainPage290101.inputNumExterior.sendKeys("123");
            mainPage290101.inputNumInterior.sendKeys("1");
            mainPage290101.inputColonia.sendKeys("PRUEBA");
            mainPage290101.inputEntidadEstado.sendKeys("CIUDAD DE MEXICO");
            mainPage290101.inputCodigoPostal.sendKeys("12345");
            mainPage290101.inputCapacidadAlmacenaje.sendKeys("23");
            mainPage290101.inputVolumenAlmacenaje.sendKeys("23");
            mainPage290101.btnGuardarB.click();
            mainPage290101.btnAgregarBodega.click();
            mainPage290101.inputNombreBeneficio.sendKeys("PROTEO");
            mainPage290101.inputPropiaAlguiladaB.sendKeys("Alquilada");
            mainPage290101.inputCalle.sendKeys("PRUEBA");
            mainPage290101.inputNumExterior.sendKeys("123");
            mainPage290101.inputNumInterior.sendKeys("1");
            mainPage290101.inputColonia.sendKeys("PRUEBA");
            mainPage290101.inputEntidadEstadoBodegas.sendKeys("CIUDAD DE MEXICO");
            mainPage290101.inputCodigoPostal.sendKeys("12345");
            mainPage290101.inputCapacidadAlmacenaje.sendKeys("123");
            mainPage290101.btnGuardarBodega.click();
            mainPage290101.btnAgregarCafeExp.click();
            mainPage290101.inputMarcaComercial.sendKeys("PROTEUS_TOYS");
            mainPage290101.inputClasificacionTipo.sendKeys("Café Chiapas");
            mainPage290101.inputVolumen.sendKeys("123");
mainPage290101.btnGuardarCafe.click();
mainPage290101.Observaciones.sendKeys("MUY BUENO");
mainPage290101.checkAutorizacion.click();
mainPage290101.checkDeclaracionVerdad.click();
            mainPage290101.inputGuardarSolicitud.click();
            mainPage290101.inputGuarda.click();sleep(1000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite290101);
            String folioText = mainPage290101.folio.getText();
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
    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }
    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }

}