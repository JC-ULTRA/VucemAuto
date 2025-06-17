package Economia.Tramite110209;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110209.MainPage110209;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110209Test {
    MainPage110209 mainPage110209 = new MainPage110209();
    LoginFirmSoli loginSoli = new LoginFirmSoli();


    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite110209  = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso110209() {
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
            loginSoli.login(tramite110209);
            mainPage110209.selecRol.sendKeys("Persona Moral");
            mainPage110209.btnacep.click();

            //Búsqueda de tramite
            mainPage110209.Tramites.sendKeys("Solicitudes nuevas");
            mainPage110209.SoliNew.click();
            mainPage110209.Economia.click();
            mainPage110209.CertificadoOrigen.click();
            mainPage110209.ValidacionCertificadosOrigen.click();
            mainPage110209.Tramite110209.click();

            //Búsqueda de certificado por bloque
            mainPage110209.radbtnPorAcuerdoBloque.click();
            mainPage110209.selectTratadoAcuerdo.selectOption("Sistema Generalizado de Preferencias");
            mainPage110209.selectPaisBloque.selectOption("JAPON");
            mainPage110209.btnBuscar.click();
            mainPage110209.gridCertificadoFila1.click();
            mainPage110209.btnConsultar.click();

            //Sección datos a modificar
            /*
            //Paso 1 Capturar solicitud
            mainPage110209.Scrol.scrollTo();
            //Pestaña DESTINATARIO
            mainPage110209.tabDestinatario.click();
            //Datos del destinatario
            mainPage110209.inputDestinatarioNombre.setValue("Karen Modificacion");
            mainPage110209.inputDestinatarioApellidoPaterno.setValue("Castillo Modificacion");
            mainPage110209.inputDestinatarioApellidoMaterno.setValue("Gómez Modificacion");
            mainPage110209.inputDestinatarioRFC.setValue("AAL0409235E");
            // mainPage110209.inputDestinatarioRazonSocial.sendKeys("Razón Social QA Modificación");
            //Domicilio del destinatario
            mainPage110209.inputDestinatarioDomicilioCalle.setValue("Insurgentes Sur Modificacion");
            mainPage110209.inputDestinatarioDomicilioNumero.setValue("123");
            mainPage110209.inputDestinatarioCorreoElectronico.setValue("Karen.modificacion@example.com");
            mainPage110209.inputDestinatarioDomicilioFax.setValue("5527390102");
            mainPage110209.inputDestinatarioDomicilioTelefono.setValue("5528495063");

            //Pestaña TRANSPORTE
            mainPage110209.Scrol.scrollTo();
            mainPage110209.tabTransporte.click();
            mainPage110209.selectMedioTransporte.selectOption("Aéreo");

            //Pestaña DATOS CERTIFICADO
            //Datos del Certificado
            mainPage110209.Scrol.scrollTo();
            mainPage110209.tabDatosCetificado.click();
            mainPage110209.textareaCertificadoOrigenObservaciones.setValue("Sin observaciones adicionales. Modificación");

            //Mercancias seleccionadas
            mainPage110209.gridMercanciaFila1.click();
            mainPage110209.btnModificarMercancia.click();
            //Modificación mercancia
            mainPage110209.ComplementoDescripcion.setValue("test modificación");
            mainPage110209.Marca.setValue("QA");
            mainPage110209.ValorMercancia.setValue("15");
            mainPage110209.selectUMC.selectOption("Botella");
            mainPage110209.NumFactura.setValue("38394");
            mainPage110209.selectTipoFactura.selectOption("Electrónica");
            mainPage110209.btnModificarMercancia2.click();

            */
            mainPage110209.btnContinuarPaso1.click();

            //Paso 2 Firma
            //loginSoli.firma(tramite110209);

            // Obtener el texto del folio desde mainPageB8
            //String folioText = mainPage110209.folio.getText();

            // Llamar al metodo para obtener el folio
            //String folioNumber = obtenerFolio.obtenerFolio(folioText);



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
