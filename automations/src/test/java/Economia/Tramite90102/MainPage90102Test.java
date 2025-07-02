package Economia.Tramite90102;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.awt.Component;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage90102Test {

    MainPage90102 mainPage90102 = new MainPage90102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite90102 = new TramitesFirmasLG(
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
    public void Proceso90102() {

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

            //Ingreso y Rol
            loginFirmSoli.login(tramite90102);
            mainPage90102.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
            mainPage90102.btnacep.click();
            //Búsqueda de tramite
            mainPage90102.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
            mainPage90102.SoliNew.click();
            mainPage90102.economia.click();
            mainPage90102.Prosec.click();
            mainPage90102.ProgramaNuevo.click();
            mainPage90102.elementoTramite90102.click();

            //Lista de productores indirectos
            mainPage90102.gridPrograma1.doubleClick();

            //Paso 1 CAPTURAR SOLICITUD
            //Consulta de domicilios
            mainPage90102.domiciliosPlantas.click();
            mainPage90102.estadoPlantas.sendKeys(new CharSequence[]{"SINALOA"});
            mainPage90102.mostrarDomicilios.click();
            mainPage90102.seleccionaPlanta.click();
            mainPage90102.agregarPlanta.click();
            mainPage90102.actividadProductiva.selectOption("AGRICULTURA"); sleep(1000);

            //Pestaña Sectores y mercancías
            mainPage90102.Scrol.scrollTo();
            mainPage90102.sectoresMercancias.click();
            //Datos de la solicitud
            mainPage90102.sector.selectOption("V-De la Industria del Calzado");
            mainPage90102.agregarSector.click();
            mainPage90102.selecSector.click();
            //Mercancías a producir
            mainPage90102.fraccionArancelaria.sendKeys(new CharSequence[]{"64061009"});
            mainPage90102.agregarFraccion.click();
            //Continuar paso 1
            mainPage90102.continuarSoli.click();sleep(1000);


            //Paso 2 REQUERIMIENTOS NECESARIOS
            mainPage90102.continuarArchivos.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage90102.btnAnexar.click();
            mainPage90102.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage90102.btnCerrar.click();
            mainPage90102.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite90102);
            String folioText = mainPage90102.folio.getText();
            ObtenerFolio var10000 = obtenerFolio;
            String folioNumber = ObtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }


    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }

    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{Condition.visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }

}

