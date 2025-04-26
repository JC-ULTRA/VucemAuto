package Economia.Tramite130103;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130112.MainPage130112;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130103Test {
    MainPage130103 mainPage130103 = new MainPage130103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130103  = new TramitesFirmasLG(
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
    public void Proceso130103() {
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

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130103);
            mainPage130103.selecRol.sendKeys("Persona Moral");
            mainPage130103.btnacep.click();
            mainPage130103.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130103.SoliNew.click();
            mainPage130103.Econom.click();
            mainPage130103.linkPermisosImportaciExportaci.click();
            mainPage130103.linkImportaci.click();
            mainPage130103.elementoTramite130103.click(); sleep(500);
            // Hacer scroll hasta el elemento
            mainPage130103.Scrol.scrollIntoView(true);

            //Paso 1 (Datos de la solicitud)
            //DATOS TRAMITE
            mainPage130103.labelDatosSolicitud.click();
            mainPage130103.SelectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage130103.SelectSolicitudClaveClasificacionRegimen.sendKeys("De importación Para elaboración, transformación o reparación en programas de maquila o de exportación");

            //DATOS DE LA MERCANCÍA
            mainPage130103.radbtnProductoNuevo.click();
            mainPage130103.textareaDescripcionMercancia.sendKeys("Prueba");
            mainPage130103.SelectFraccionArancelaria.selectOptionByValue("98020019");
            mainPage130103.inputCantidadTarifaria.sendKeys("100");
            mainPage130103.inputValorFacturaUSD.sendKeys("100");
            mainPage130103.selectMercanciaUMT.sendKeys("Caja");

            //PARTIDAS MERCANCÍA
            mainPage130103.inputCantidad.sendKeys("100");
            mainPage130103.FraccionArancelariaTIGIE.sendKeys("87033302");
            mainPage130103.selectTipoFraccionTIGIE.selectOptionByValue("87033302");
            mainPage130103.textareaDescripcion.sendKeys("QA descripción");
            mainPage130103.inputTotalUSDPartida.sendKeys("100");
            mainPage130103.btnAgregarMercancia.click();

            //Uso específico de la mercancía
            mainPage130103.FraccionPROSEC.sendKeys("87033302");
            mainPage130103.DescripcionPROSEC.sendKeys("QA Prueba Descripción Prosec");
            mainPage130103.btnAgregarUsoEspecifico.click();

            //Criterio de dictamen de regla octava
            mainPage130103.SolicituOctavaClave.selectOptionByValue("1");

            //PAÍS PROCEDENCIA
            mainPage130103.bloqueAutocomplete.selectOption("T-MEC");
            mainPage130103.paisBloqueOrigenSearch.click();sleep(1000);
            mainPage130103.selectPaisBloqueOrigen.sendKeys("CANADA");
            mainPage130103.btnAgregarSeleccion.click();
            mainPage130103.texJustificacionBeneficio.sendKeys("QA justificacion");
            mainPage130103.textareaObservaciones.sendKeys("QA Observaciones");
            //REPRESENTACIÓN FEDERAL
            mainPage130103.selectEntidadFederativaClave.sendKeys("SINALOA");
            mainPage130103.selectRepresentacionFederal.sendKeys("CULIACAN");
            mainPage130103.btnContinuarGuardarSolicitud.click();

            //Paso 2
            mainPage130103.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage130103.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage130103.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130103.btnSelectArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130103.btnAdjuntar2.click();sleep(2000);
            mainPage130103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage130103.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage130103.btnContinuar3.click();
            //Firmas
            //loginFirmSoli.firma(tramite130103);

            // Obtener el texto del folio desde mainPage130103
            String folioText = mainPage130103.folio.getText();

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