package Economia.Tramite110202;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110202.MainPage110202;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110202Test {
    MainPage110202 mainPage110202 = new MainPage110202();
    LoginFirmSoli loginSoli = new LoginFirmSoli();


    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite110202  = new TramitesFirmasLG(
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
    public void Proceso110202() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen110202");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion110202");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion110202");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen110202");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion110202");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion110202");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//             Ingreso y selección de trámite
            loginSoli.login(tramite110202); sleep(1000);
            mainPage110202.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110202.btnacep.click(); sleep(1000);
            mainPage110202.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110202.SoliNew.click(); sleep(1000);
            mainPage110202.Economia.click(); sleep(1000);
            mainPage110202.CertificadoOrigen.click(); sleep(1000);
            mainPage110202.ValidacionCertificadosOrigen.click(); sleep(1000);
            mainPage110202.Tramite110202.click(); sleep(1000);
            //CERTIFICADO DE ORIGEN
            mainPage110202.labelCertificadoOrigen.click();
            mainPage110202.selectSolicitudTratadoAcuerdoSeleccionado.sendKeys("Tratado de Libre Comercio México-Unión Europea");
            mainPage110202.selectSolicitudClavePaisSeleccionado.sendKeys("AUSTRIA");
            mainPage110202.inputBotonBuscarMercancias.click();
            mainPage110202.MercanciaDisponible.doubleClick();
            mainPage110202.inputMarca.sendKeys("MARCA-X");
            mainPage110202.inputCantidad.sendKeys("20");
            mainPage110202.selectDatosMercanciaUnidadMedida.sendKeys("Barril");
            mainPage110202.inputValorMercancia.sendKeys("15000.00");
            mainPage110202.textareaComplementoDescripcion.sendKeys("Descripción específica del producto");
            mainPage110202.inputMasaBruta.sendKeys("75");
            mainPage110202.selectDatosMercanciaUnidadMedida2.sendKeys("Barril");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage110202.inputFechaFactura);sleep(100);
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage110202.inputNumeroFactura.setValue(java.lang.String.valueOf(nFacturaR));
            mainPage110202.selectDatosMercanciaTipoFactura.sendKeys("Electrónica");
            mainPage110202.inputAgregarMercancia.click();
            mainPage110202.buttonAceptar.click();
            //DESTINATARIO
            mainPage110202.labelDestinatario.click();
            mainPage110202.inputSolicitudDestinatarioNombre.sendKeys("Juan");
            mainPage110202.inputSolicitudDestinatarioApellidoPaterno.sendKeys("Pérez");
            mainPage110202.inputSolicitudDestinatarioApellidoMaterno.sendKeys("Gómez");
            mainPage110202.inputSolicitudDestinatario.sendKeys("AAL0409235E6");
            mainPage110202.inputSolicitudDestinatarioDomicilioCiudad.sendKeys("Ciudad de México");
            mainPage110202.inputSolicitudDestinatarioDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage110202.inputSolicitudDestinatarioDomicilioNumero.sendKeys("123");
            mainPage110202.inputSolicitudDestinatarioDomicilioTelefono.sendKeys("5555555555");
            mainPage110202.inputSolicitudDestinatarioDomicilioFax.sendKeys("5555550000");
            mainPage110202.inputSolicitudDestinatarioCorreoElectronico.sendKeys("juan.perez@example.com");
            mainPage110202.selectSolicitudDestinatarioPaisOrigen.sendKeys("AUSTRIA");
            mainPage110202.selectSolicitudCertificadoOrigenMedio.sendKeys("Aéreo");
            mainPage110202.inputGuardarSolicitud.click();

            //DATOS CERTIFICADO
            mainPage110202.labelDatosCertificado.click();
            mainPage110202.textareaSolicitudCertificadoOrigenObservaciones.sendKeys("Sin observaciones adicionales.");
            mainPage110202.textareaSolicitudCertificadoOrigenPrecisa.sendKeys("El producto cumple con las condiciones de origen.");
            mainPage110202.textareaSolicitudCertificadoOrigenPresenta.sendKeys("Se presenta factura y documentación complementaria.");
            mainPage110202.selectSolicitudCertificadoOrigenLenguaje.sendKeys("ES");
            mainPage110202.selectSolicitudEntidadFederativaClave.sendKeys("CDMX");
            mainPage110202.selectRepresentacionFederal.sendKeys("REP001");
            mainPage110202.inputGuardarSolicitud2.click();
            //Facturacion
            loginSoli.firma(tramite110202);



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
