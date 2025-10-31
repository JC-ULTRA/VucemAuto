package Economia.Tramite130112;

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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage130112Test {
    MainPage130112 mainPage130112 = new MainPage130112();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite130112  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130112Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130112");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130112");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130112");

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
            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
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
    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130112Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage130112.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130112.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage130112.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage130112.deConformidadDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite130112Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage130112.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage130112.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite130112Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite130112);
        mainPage130112.selecRol.sendKeys("Persona Moral");
        mainPage130112.btnacep.click();
        mainPage130112.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage130112.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite130112);sleep(1000);sleep(4000);
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