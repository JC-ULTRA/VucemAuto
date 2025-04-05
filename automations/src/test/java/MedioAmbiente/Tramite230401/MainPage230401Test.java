package MedioAmbiente.Tramite230401;
import DBYFOLIO.ObtenerFolio;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;
import java.io.IOException;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage230401Test {
    MainPage230401 mainPage230401 = new MainPage230401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite230401  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso230401() throws IOException {
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



        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {

            ////////////Generar llave de pago/////////////////////
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite230401); sleep(1000);
            mainPage230401.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage230401.btnacep.click(); sleep(1000);
            mainPage230401.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage230401.SoliNew.click(); sleep(1000);
            mainPage230401.abreMedioamb.click();sleep(1000);
            mainPage230401.abrirMenu.click();sleep(1000);
            mainPage230401.abrirAutorizacion.click();sleep(1000);
            mainPage230401.abrirTramite.click();sleep(1000);

            mainPage230401.DatosSoli.click();sleep(500);
            mainPage230401.selecValor.sendKeys("Plaguicida");sleep(500);
            mainPage230401.noCOFEPRIS.sendKeys("0402600500220244006000005");sleep(1000);
            mainPage230401.fracAranc.sendKeys("29089101");sleep(1000);
            mainPage230401.noCAS.sendKeys("88-85-7, 2-(sec-Buti)-4,6-dinitrofenol (DINOSEB)");sleep(1000);
            mainPage230401.btnAgregar.click();sleep(1000);
            mainPage230401.nombMerca.sendKeys("QA");sleep(1000);
            mainPage230401.cantMerca.sendKeys("1");sleep(1000);
            mainPage230401.unidMedida.sendKeys("Kilogramo");sleep(1000);

            // Desplazar la página hacia arriba
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("window.scrollTo(0, 0);");
            sleep(1000);

            mainPage230401.pagoDerechos.click();sleep(1000);
            mainPage230401.selecBanco.sendKeys("BANAMEX");sleep(1000);
            mainPage230401.llaveBanco.sendKeys(llavePago); ;sleep(1000);
            mainPage230401.fechaPago.sendKeys("05/03/2025");sleep(1000);
            mainPage230401.btnCont.click();sleep(1000);
            mainPage230401.btnContaDigi.click();sleep(1000);
            mainPage230401.btnAdjuntar.click();sleep(1000);
            mainPage230401.Archivo1.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage230401.Archivo2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage230401.Archivo3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage230401.Archivo4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage230401.Archivo5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage230401.Adjuntar.click();sleep(3000);
//            mainPage230401.brnCerrar.click();sleep(1000);
            $(byText("Cerrar")).shouldBe(visible).shouldHave(text("Cerrar")).click();

            mainPage230401.btnContinuarFirma.click();sleep(1000);

            loginFirmSoli.firma(tramite230401); sleep(1000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage230401.folio.getText();

//            Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);


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

        }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }

    }
}