package HACIENDA.Tramite202;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite202.MainPage202;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage202Test {
    MainPage202 mainPage202 = new MainPage202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    TramitesFirmasLG tramite202fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key");

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
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso202() throws IOException {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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

        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite ingreso y rol
            loginFirmSoli.login(tramite202); sleep(1000);
            mainPage202.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage202.btnacep.click(); sleep(1000);
            mainPage202.Tramites.sendKeys("Solicitudes nuevas");
            mainPage202.SoliNew.click();sleep(1000);

            //Búsqueda Tramite
            mainPage202.Hacienda.click();
            mainPage202.AutorizacionesPrestadorServicio.click();
            mainPage202.elementoTramite202.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage202.Scrol.scrollTo();
            //Pestaña Maniobras Mercancías
            mainPage202.tabManiobrasMerca.click();
            //Datos del trámite
            mainPage202.checkDeclaracion.click();
            mainPage202.selectAduana.selectOption("AGUA PRIETA");
            mainPage202.btnSiguientePaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage202.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage202.btnAnexar.click();
            mainPage202.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage202.btnCerrar.click();
            mainPage202.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite202);

            //LLamar Metodo para obtener folio
            String folioText = mainPage202.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
            sleep(4000);

            Dictamen202(folioNumber);
            VerificarDictamen202(folioNumber);
            AutorizarDictamen202(folioNumber);
            ProcesoConfirmarNotificaciónResolucion202(folioNumber);

        }, repeticiones);
    }

    public void Dictamen202(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        iniDriver();
        loginFirmSoli.loginFun(tramite202fun);
        mainPage202.Inicio.click();
        mainPage202.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage202.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(1000);
        $("[value = '?mostrarDictamen=']").click();sleep(1000);
        $("[value = 'Continuar']").click();sleep(1000);
        $("[value = 'SEDI.AC']").click();sleep(1000);
        $("[name = 'tramite.dictamen.justificacion']").sendKeys("Test");sleep(500);
        $("[name = 'aniosPlazoDictamen']").sendKeys("2");sleep(500);
        $("[name = 'cveMesSeleccion']").sendKeys("1");sleep(500);
        $("[name = 'diasPlazoDictamen']").sendKeys("12");sleep(500);
        $("[name = 'mostrarReporte']").click();sleep(500);
        $("[name = 'textoLibre0']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre1']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre2']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre3']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre4']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre5']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre6']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre7']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre8']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre9']").sendKeys("Test");sleep(500);
        $("[name = 'textoLibre10']").sendKeys("Test");sleep(500);
        metodos.scrollDecremento(5);
        $("[name = 'mostrarFirma']").click();sleep(500);
        loginFirmSoli.firma(tramite202fun); sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void VerificarDictamen202(String folioNumber) {
        //Busqueda de Folio
        mainPage202.Inicio.click();
        mainPage202.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage202.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(1000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite202fun); sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void AutorizarDictamen202(String folioNumber) {
        //Busqueda de Folio
        mainPage202.Inicio.click();
        mainPage202.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage202.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50500);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite202fun);
        sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion202(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        iniDriver();
        loginFirmSoli.login(tramite202);
        mainPage202.selecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage202.btnacep.click();sleep(1000);
        $$(By.cssSelector("a[id='Inicio']")).findBy(text("Inicio")).click();sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'buscarTareasSolicitante']").click();sleep(1000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(1000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite202);
        sleep(4000);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            iniDriver();
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}





