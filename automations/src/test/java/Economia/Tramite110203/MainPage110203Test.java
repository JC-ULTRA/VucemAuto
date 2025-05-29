package Economia.Tramite110203;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110203.MainPage110203;
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

public class MainPage110203Test {
    MainPage110203 mainPage110203 = new MainPage110203();
    LoginFirmSoli loginSoli = new LoginFirmSoli();


    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite110203  = new TramitesFirmasLG(
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
    public void Proceso110203() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          Ingreso y selección de trámite
            loginSoli.login(tramite110203);
            mainPage110203.selecRol.sendKeys("Persona Moral");
            mainPage110203.btnacep.click();
            mainPage110203.Tramites.sendKeys("Solicitudes nuevas");
            mainPage110203.SoliNew.click();
            mainPage110203.Economia.click();
            mainPage110203.CertificadoOrigen.click();
            mainPage110203.ValidacionCertificadosOrigen.click();
            mainPage110203.Tramite110203.click();

            //Búsqueda de certificado
            mainPage110203.radbtnPorAcuerdoBloque.click();
            mainPage110203.selectTratadoAcuerdo.selectOption("Tratado de Libre Comercio México-Unión Europea");
            mainPage110203.selectPaisBloque.selectOption("SUECIA (REINO DE)");
            mainPage110203.btnBuscar.click();
            mainPage110203.gridCertificadoFila1.click();
            mainPage110203.btnConsultar.click();

            //Pestaña DESTINATARIO
            //Datos del destinatario
            mainPage110203.Scrol.scrollTo();
            mainPage110203.tabDestinatario.click();
            mainPage110203.inputDestinatarioNombre.setValue("Karen Modificacion");
            mainPage110203.inputDestinatarioApellidoPaterno.setValue("Castillo Modificacion");
            mainPage110203.inputDestinatarioApellidoMaterno.setValue("Gómez Modificacion");
            mainPage110203.inputDestinatarioRFC.setValue("AAL0409235E");
           // mainPage110203.inputDestinatarioRazonSocial.sendKeys("Razón Social QA Modificación");
            //Domicilio del destinatario
            mainPage110203.inputDestinatarioDomicilioCalle.setValue("Insurgentes Sur Modificacion");
            mainPage110203.inputDestinatarioDomicilioNumero.setValue("123");
            mainPage110203.inputDestinatarioCorreoElectronico.setValue("Karen.modificacion@example.com");
            mainPage110203.inputDestinatarioDomicilioFax.setValue("5527390102");
            mainPage110203.inputDestinatarioDomicilioTelefono.setValue("5528495063");

            //Pestaña TRANSPORTE
            mainPage110203.Scrol.scrollTo();
            mainPage110203.tabTransporte.click();
            mainPage110203.selectMedioTransporte.selectOption("Aéreo");

            //Pestaña DATOS CERTIFICADO
            //Datos del Certificado
            mainPage110203.Scrol.scrollTo();
            mainPage110203.tabDatosCetificado.click();
            mainPage110203.textareaCertificadoOrigenObservaciones.setValue("Sin observaciones adicionales. Modificación");
            mainPage110203.textareaCertificadoOrigenPrecisa.setValue("El producto cumple con las condiciones de origen. Modificación");
            mainPage110203.textareaCertificadoOrigenPresenta.setValue("Se presenta factura y documentación complementaria. Modificación");
            //Mercancias seleccionadas
            mainPage110203.gridMercanciaFila1.click();
            mainPage110203.btnModificarMercancia.click();
            //Modificación mercancia
            mainPage110203.ComplementoDescripcion.setValue("test modificación");
            mainPage110203.Marca.setValue("QA");
            mainPage110203.ValorMercancia.setValue("15");
            mainPage110203.selectUMC.selectOption("Botella");
            mainPage110203.MasaBruta.setValue("200");
            mainPage110203.selectUnidadMasaBruta.selectOption("Botella");
            mainPage110203.NumFactura.setValue("38394");
            mainPage110203.selectTipoFactura.selectOption("Electrónica");
            mainPage110203.btnModificarMercancia2.click();

            mainPage110203.btnContinuarPaso1.click();

            //Paso 2 Firma
            loginSoli.firma(tramite110203);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110203.folio.getText();

            // Llamar al metodo para obtener el folio
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
