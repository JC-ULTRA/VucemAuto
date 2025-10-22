package Economia.Tramite130103;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Economia.Tramite130112.MainPage130112;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130103Test {
    MainPage130103 mainPage130103 = new MainPage130103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130103  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130103fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130103");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130103");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130103");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");

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
            mainPage130103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage130103.btnCerrar3.doubleClick();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage130103.btnContinuar3.click();
            //Firmas
            loginFirmSoli.firma(tramite130103);

            // Obtener el texto del folio desde mainPage130103
            String folioText = mainPage130103.folio.getText();

            // Llamar al mtodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    System.out.println("Iniciando ProcesoDictamen...");
                    ProcesoDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                    if (selectedMethods.contains("ProcesoAutorizacion")) {
                        ProcesoAutorizarDictamen(folioNumber);
                        System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                            System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }
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
    public void ProcesoDictamen(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130103fun);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        // Búsqueda de Folio
        mainPage130103.iniciofun.click();
        mainPage130103.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage130103.btnBuscarFolio.click();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage130103.JustificacionDictamen.sendKeys("PRUEBASQA ULTRASIST");
        mainPage130103.AntecedentesDictamen.sendKeys("PRUEBASQA ULTRASIST");
        mainPage130103.btnFirmarDictamen.click();
//        $("input[type='submit'][value='Firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite130103fun);sleep(1000); sleep(4000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130103.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130103.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite130103fun);sleep(4000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite130103);
        mainPage130103.selecRol.sendKeys("Persona Moral");
        mainPage130103.btnacep.click();
        mainPage130103.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage130103.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite130103);sleep(1000);sleep(4000);
    }
}