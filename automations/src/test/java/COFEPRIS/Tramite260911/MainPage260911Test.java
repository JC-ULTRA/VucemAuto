package COFEPRIS.Tramite260911;

import COFEPRIS.Tramite260211.MainPage260211Test;
import COFEPRIS.Tramite260911.MainPage260911;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260911Test {
    MainPage260911 mainPage260911 = new MainPage260911();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    MainPage260211Test mainPage260211Test = new MainPage260211Test();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260911 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260911Fun = new TramitesFirmasLG(
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
    public void Proceso260911() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260911");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260911");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260911");

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
            String folioRetornado = mainPage260211Test.retornoFolio();
            setUpAll();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite260911);
            mainPage260911.selecRol.sendKeys("Persona Moral");
            mainPage260911.btnacep.click();
            mainPage260911.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260911.SoliSub.click();
            mainPage260911.inputIdFolio.sendKeys(folioRetornado);
            mainPage260911.inputBuscarButton.click();sleep(1000);
            mainPage260911.SolicitudTramite.doubleClick();
            $("#MYPButton").shouldBe(Condition.visible).click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260911.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260911.labelDatosSolicitud.click();
            mainPage260911.inputModif.click();
            mainPage260911.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");


            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260911.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260911.labelPagoDerechos.click();
            mainPage260911.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260911.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260911.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260911.inputSolicitudPagoLlave.sendKeys(llavePago);
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260911.inputCalendar);sleep(100);
            mainPage260911.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260911.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260911.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage260911.btnAnexar.click();sleep(2000);
            mainPage260911.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260911.btnCerrar.click();sleep(100);
            mainPage260911.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260911);
            // Obtener el texto del folio desde mainPage260911
            String folioText = mainPage260911.folio.getText();
            // Llamar al mtodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")) {
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    ProcesoVerificarDictamen(folioNumber);
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
    public void ProcesoGenerarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite260911Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260911.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260911.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite260911Fun);sleep(5000);
    }

    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260911.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260911.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite260911Fun);sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260911.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260911.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite260911Fun);sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260911);
        mainPage260911.selecRol.sendKeys("Persona Moral");
        mainPage260911.btnacep.click();
        mainPage260911.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260911.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260911);sleep(4000);
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