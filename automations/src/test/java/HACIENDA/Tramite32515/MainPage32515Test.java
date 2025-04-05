package HACIENDA.Tramite32515;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32515.MainPage32515;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import net.bytebuddy.implementation.InvokeDynamic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32515Test {
    MainPage32515 mainPage32515 = new MainPage32515();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32515  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
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
    public void Proceso32515() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamenB8");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacionB8");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucionB8");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32515);
            mainPage32515.selecRol.sendKeys("Persona Moral");
            mainPage32515.btnacep.click();
            mainPage32515.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32515.SoliNew.click();
            mainPage32515.hacienda.click();
            mainPage32515.registrosComercioExt.click();
            mainPage32515.envioAvisos.click();
            mainPage32515.avisoSeguroGlobalT.click();
            mainPage32515.tipoAviso.click();
            /// Informacion General
            mainPage32515.ingresosAcumulables.sendKeys("10000");
            mainPage32515.capitalSocial.sendKeys("1000");
            mainPage32515.rfcRepresentante.sendKeys("MAVL621207C95");
            mainPage32515.nombreRepresentante.sendKeys("EUROFOODS");
            mainPage32515.apellidoPRepresentante.sendKeys("GONZALEZ");
            mainPage32515.apellidoMRepresentante.sendKeys("PINAL");
            mainPage32515.telefonoRepresentante.sendKeys("5566778899");
            mainPage32515.correoRepresentante.sendKeys("abcd@efg.qa");

            mainPage32515.fechaInicioVigenciaS.click();
            mainPage32515.selecFechaIS.click();
            mainPage32515.fechaFinVigenciaS.click();
            mainPage32515.selecFechaFS.click();
            mainPage32515.numPolizaS.sendKeys("99090909");
            mainPage32515.costoTotalS.sendKeys("7000");
            mainPage32515.valorMercanciasS.sendKeys("10000");sleep(500);
            mainPage32515.factorAplicableS.sendKeys("111.1111111111");

            mainPage32515.rfcAseguradora.sendKeys("LEQI8101314S7");
            mainPage32515.razonAseguradora.sendKeys("ASEGURADORAS");
            mainPage32515.estadoAseguradora.sendKeys("CHIHUAHUA");sleep(500);
            mainPage32515.municipioAseguradora.sendKeys("BOCOYNA");sleep(500);
            mainPage32515.coloniaAseguradora.sendKeys("BARRIO CHAPULTEPEC");
            mainPage32515.localidadAseguradora.sendKeys("CENTRO");
            mainPage32515.calleAseguradora.sendKeys("RARAJIPA");
            mainPage32515.numExtAseguradora.sendKeys("418");
            mainPage32515.numIntAseguradora.sendKeys("1");
            mainPage32515.codigoPostalAseguradora.sendKeys("33200");

            mainPage32515.btnGuardarSoli.click();
            mainPage32515.btnContinuar.click();
            mainPage32515.btnAdjuntarDoc.click();
            mainPage32515.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32515.btnAdjuntar.click();sleep(5500);
            mainPage32515.btnCerrar.click();
            mainPage32515.btnSiguiente.click();

            loginFirmSoli.firma(tramite32515);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32515.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
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

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}
