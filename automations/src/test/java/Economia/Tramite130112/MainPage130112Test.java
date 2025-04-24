package Economia.Tramite130112;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130112.MainPage130112;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130112Test {
    MainPage130112 mainPage130112 = new MainPage130112();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130112  = new TramitesFirmasLG(
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
    public void Proceso130112() {
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
            loginFirmSoli.login(tramite130112);
            mainPage130112.selecRol.sendKeys("Persona Moral");
            mainPage130112.btnacep.click();
            mainPage130112.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130112.SoliNew.click();
            mainPage130112.Econom.click();
            mainPage130112.linkPermisosImportaciExportaci.click();
            mainPage130112.linkImportaci.click();
            mainPage130112.elementoTramite130112.click(); sleep(500);
            // Hacer scroll hasta el elemento
            mainPage130112.Scrol.scrollIntoView(true);

            //Paso 1 (Datos de la solicitud)
            //DATOS TRAMITE
            mainPage130112.labelDatosSolicitud.click();
            mainPage130112.SelectSolicitudRegimenClave.sendKeys("Temporales");
            mainPage130112.SelectSolicitudClaveClasificacionRegimen.sendKeys("De importación Para elaboración, transformación o reparación en programas de maquila o de exportación");
            //DATOS DE LA MERCANCÍA
            mainPage130112.radbtnProductoNuevo.click();
            mainPage130112.textareaDescripcionMercancia.sendKeys("Prueba");
            mainPage130112.SelectFraccionArancelaria.selectOptionByValue("98020002");
            mainPage130112.inputCantidadTarifaria.sendKeys("100");
            mainPage130112.inputValorFacturaUSD.sendKeys("100");
            mainPage130112.selectMercanciaUMT.sendKeys("Kilogramo");
            //PARTIDAS MERCANCÍA
            mainPage130112.inputCantidad.sendKeys("100");
            mainPage130112.FraccionArancelariaTIGIE.sendKeys("63079099");
            mainPage130112.selectTipoFraccionTIGIE.sendKeys("63079099   Los demas.");
            mainPage130112.inputTotalUSDPartida.sendKeys("100");
            mainPage130112.textareaDescripcion.sendKeys("QA descripción");
            mainPage130112.btnAgregarMercancia.click();
            //PAÍS PROCEDENCIA
            mainPage130112.bloqueAutocomplete.selectOption("T-MEC");
            mainPage130112.paisBloqueOrigenSearch.click();sleep(1000);
            mainPage130112.btnAgregarTodos.click();sleep(1000);
            mainPage130112.textareaUsoEspecifico.sendKeys("QA Mercancia Uso especifico");
            mainPage130112.textareaJustificacionImportacionExportacion.sendKeys("QA justificacion");
            mainPage130112.textareaObservaciones.sendKeys("QA Observaciones");
            //REPRESENTACIÓN FEDERAL
            mainPage130112.selectEntidadFederativaClave.sendKeys("SINALOA");
            mainPage130112.selectRepresentacionFederal.sendKeys("CULIACAN");
            mainPage130112.btnContinuarGuardarSolicitud.click();

            //Paso 2
            mainPage130112.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage130112.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage130112.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130112.btnAdjuntar2.click();sleep(2000);
            mainPage130112.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage130112.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage130112.btnContinuar3.click();
            //Firmas
            loginFirmSoli.firma(tramite130112);

            // Obtener el texto del folio desde mainPage130112
            String folioText = mainPage130112.folio.getText();

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