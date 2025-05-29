package Economia.Tramite130203;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130203.MainPage130203;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130203Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage130203Test.class);
    MainPage130203 mainPage130203 = new MainPage130203();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AFC000526BJ2";

    TramitesFirmasLG tramite130203  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\&cj060729fg5.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\&cj060729fg5_1110111713.key"
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
    public void Proceso130203() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130203");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130203");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130203");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130203");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130203");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130203");
*/
        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          // Ingreso y Rol
            loginFirmSoli.login2(tramite130203);
            //mainPage130203.selecRol.sendKeys("Persona Moral");
            //mainPage130203.btnacep.click();
            //Búsqueda Tramite
            mainPage130203.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130203.SoliNew.click();
            mainPage130203.economia.click();
            mainPage130203.direccionGeneralNormas.click();
            mainPage130203.exportacion.click();
            mainPage130203.elementoTramite130203.click();
            
            //Paso 1 CAPTURAR SOLICITUD
            mainPage130203.Scrol.scrollTo();
            //Pestaña de la Solicitud
            mainPage130203.tabDatosSolicitud.click();
            //Datos del trámite a realizar
            mainPage130203.tabDatosSolicitud.click();


            //PASO 1 CAPTURAR SOLICITUD
            try {
                Thread.sleep(1000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130203.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Pestaña Datos de la solicitud
            mainPage130203.tabDatosSolicitud.click();
            //Datos del trámite a realizar
            mainPage130203.selectRegimen.sendKeys("Definitivos");
            mainPage130203.selectClasificacion.sendKeys(" De exportación");
            //Datos de la mercancía
            mainPage130203.radbtnProductoNuevo.click();
            mainPage130203.inputDescripcion.sendKeys("PRUEBAS");
            mainPage130203.selectFraccionArancelaria.sendKeys("71022101");
            mainPage130203.inputCantidad.sendKeys("5000");
            mainPage130203.inputValorFactura.sendKeys("2000");
            mainPage130203.selectUMT.sendKeys("Gramo");
            //Partidas de la mercancía
            mainPage130203.inputCantidadPartida.sendKeys("5000");
            mainPage130203.inputValorPartida.sendKeys("2000");
            mainPage130203.inputDescripcionPartida.sendKeys("PRUEBAS Descripción");
            mainPage130203.btnAgregarPartida.click();
            //País Destino
            mainPage130203.selectBloquePais.selectOption("T-MEC");
            mainPage130203.listaPaisDestino.selectOption("CANADA");
            mainPage130203.btnAgregarPais.click();
            mainPage130203.textareaUsoEspecifico.sendKeys("Uso PRUEBA");
            mainPage130203.textareaJustificacion.sendKeys("Justificación y beneficio PRUEBA");
            mainPage130203.NumPermisoImport.sendKeys("9901C116018101");
            mainPage130203.textareaObservaciones.sendKeys("Observación PRUEBAS");
            //Representación federal
            mainPage130203.selectEntidad.selectOption("CIUDAD DE MÉXICO");
            mainPage130203.selectRepresentacionFederal.selectOption("OFICINA CENTRAL");

            //Pestaña certificado Kimberley
            try {
                Thread.sleep(1000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130203.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Capturar certificado Kimberley
            //Pestaña Certificado Kimberley
            mainPage130203.tabCertificadoKimberley.click();
            mainPage130203.NumCertificadoKimberley.sendKeys("12587");
            mainPage130203.selectPaisEmisorCertificadoKimberley.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
            mainPage130203.checkMixedPais.click();
            //mainPage130203.selectPaisOrigenKim.selectOption("");
            //Datos del exportador
            mainPage130203.DireccionExportador.sendKeys("Dirección exportado123");
            //Datos del importador
            mainPage130203.NombreImportador.sendKeys("Nombre importado");
            mainPage130203.DireccionImportador.sendKeys("Dirección importador");
            //Daros de la remesa
            mainPage130203.NumLetrasLotes.sendKeys("Número en letra de los lotes");
            mainPage130203.NumLetrasLotesIngles.sendKeys("Número en letra de los lotes en ingle");
            mainPage130203.NumFactura.sendKeys("125574fac");
            //Datos de los diamantes
            mainPage130203.CantidadQuilates.sendKeys("45289");
            mainPage130203.ValorDiamantes.sendKeys("6000");
            mainPage130203.btnContinuarPaso1.click();

            //Paso 2 Requisitos Necesarios
            mainPage130203.btnContinuarPaso2.click();

            //Paso 3 Anexar Requisitos
            metodos.cargarDocumentos();
            mainPage130203.btnAnexar.click();
            mainPage130203.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage130203.btnCerrar.click();
            mainPage130203.btnContinuarPaso3.click();

            //Paso 4 Firmar Solicitud
            //FIRMAR SOLICITUD
            loginFirmSoli.firma2(tramite130203);

            //LLamar Metodo para obtener folio
            String folioText = mainPage130203.folio.getText();
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