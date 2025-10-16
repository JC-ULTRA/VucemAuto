package Economia.Tramite110201;

import DBYFOLIO.ObtenerFolio;
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
import static io.qameta.allure.internal.shadowed.jackson.databind.cfg.CoercionInputShape.String;

public class MainPage110201Test {
    MainPage110201 mainPage110201 = new MainPage110201();
    LoginFirmSoli loginSoli = new LoginFirmSoli();


    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite110201  = new TramitesFirmasLG(
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
    public void Proceso110201() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen110201");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion110201");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion110201");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen110201");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion110201");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion110201");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//             Ingreso y selección de trámite
            loginSoli.login(tramite110201); sleep(1000);
            mainPage110201.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110201.btnacep.click(); sleep(1000);
            mainPage110201.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110201.SoliNew.click(); sleep(1000);
            mainPage110201.Economia.click(); sleep(1000);
            mainPage110201.CertificadoOrigen.click(); sleep(1000);
            mainPage110201.ValidacionCertificadosOrigen.click(); sleep(1000);
            mainPage110201.Tramite110201.click(); sleep(1000);

            mainPage110201.labelCertificadoOrigen.click();
            mainPage110201.SolicitudTratdoAcuerdo.sendKeys("Tratado de Libre Comercio México-Unión Europea");
            mainPage110201.PaisSeleccionado.sendKeys("ALEMANIA (REPUBLICA FEDERAL DE)");
            mainPage110201.inputMostrarMercancias.click();
            mainPage110201.MercanciaDisponible.doubleClick();

            mainPage110201.inputIdMarca.sendKeys("NOMBRE DE LA MARCA");
            mainPage110201.inputIdCantidad.sendKeys("10");
            mainPage110201.inputUMC.sendKeys("Caja");
            mainPage110201.inputIdValorMercancia.sendKeys("8000.00");
            mainPage110201.inputIdDescripcion.sendKeys("Descripción detallada de la mercancía");
            mainPage110201.inputIdMasaBruta.sendKeys("50");
            mainPage110201.selectDatosMercanciaUnidadMedida.sendKeys("Caja");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage110201.inputIdFechaFactura);sleep(100);
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage110201.inputIdNumeroFactura.setValue(java.lang.String.valueOf(nFacturaR));
            mainPage110201.inputIdTipoFactura.sendKeys("Electrónica");
            mainPage110201.inputAgregarMercancia.click();
            mainPage110201.btnAceptar.click();

            mainPage110201.labelDestinatario.click();
            //mainPage110201.inputSolicitudDestinatarioNombre.sendKeys("Juan");
            //mainPage110201.inputSolicitudDestinatarioApellidoPaterno.sendKeys("Pérez");
            //mainPage110201.inputSolicitudDestinatarioApellidoMaterno.sendKeys("Gómez");
            mainPage110201.inputSolicitudDestinatarioRFC.sendKeys("AAL0409235E6");
            mainPage110201.inputSolicitudDestinatarioRazonSocial.sendKeys("Pruebas S.A. de C.V.");
            mainPage110201.inputSolicitudDestinatarioDomicilioCiudad.sendKeys("Ciudad de México");
            mainPage110201.inputSolicitudDestinatarioDomicilioCalle.sendKeys("Avenida Reforma");
            mainPage110201.inputSolicitudDestinatarioDomicilioNumero.sendKeys("123");
            mainPage110201.inputSolicitudDestinatarioDomicilioTelefono.sendKeys("5551234567");
            mainPage110201.inputSolicitudDestinatarioDomicilioFax.sendKeys("5557654321");
            mainPage110201.inputSolicitudDestinatarioCorreoElectronico.sendKeys("correo@empresa.com");
            mainPage110201.selectSolicitudDestinatarioPaisOrigen.sendKeys("ALEMANIA");
            mainPage110201.selectSolicitudCertificadoOrigenMedio.sendKeys("Marítimo");
            mainPage110201.inputGuardaSolicitud.click();

            mainPage110201.labelDatosCertificado.click();
            mainPage110201.textareaSolicitudCertificadoOrigenObservaciones.sendKeys("Estas son observaciones del certificado.");
            mainPage110201.textareaSolicitudCertificadoOrigenPrecisa.sendKeys("Este producto cumple con las condiciones.");
            mainPage110201.textareaSolicitudCertificadoOrigenPresenta.sendKeys("La documentación requerida ha sido presentada.");
            mainPage110201.selectSolicitudCertificadoOrigenLenguaje.sendKeys("ESPAÑOL");
            mainPage110201.selectSolicitudEntidadFederativaClave.sendKeys("SINALOA");
            mainPage110201.selectRepresentacionFederal.sendKeys("CENTRAL CDMX");
            mainPage110201.inputGuardarSolicitud.click();
            //Facturacion
            loginSoli.firma(tramite110201);
            String folioText = mainPage110201.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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

