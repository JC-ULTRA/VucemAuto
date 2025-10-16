package Economia.Tramite140103;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140103Test {
    MainPage140103 mainPage140103 = new MainPage140103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite140103  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso140103() throws IOException {
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

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite140103);
//            mainPage140103.selecRol.sendKeys("Persona Moral");
//            mainPage140103.btnacep.click();
            mainPage140103.Tramites.sendKeys("Solicitudes nuevas");
            mainPage140103.SoliNew.click();
            mainPage140103.Economia.click();
            mainPage140103.CancelModifDesistReact.click();
            mainPage140103.PeticionParte.click();
            mainPage140103.labelCanCerCupPetInt.click();
            try {
                Thread.sleep(2000);
                mainPage140103.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage140103.labeCancelacionAutorizacion.click();
            mainPage140103.selectRegimenAduanero.sendKeys("Exportación");
            mainPage140103.selectMecanismoAsignacion.sendKeys("Primero en tiempo primero en derecho");
            mainPage140103.btnBuscarCupo.click();
            metodos.scrollIncremento(1);
            $x("//td[@aria-describedby='gridSeleccionCupo_nombreProducto'][normalize-space(text())='Tejidos']").shouldBe(Condition.visible).doubleClick();
            $x("//table[@id='gridCertificadosDisponibles']/tbody/tr[2]//input[@type='checkbox']").shouldBe(Condition.visible).click();
            mainPage140103.agregarCupo.click();
            mainPage140103.montoCancelar.sendKeys("0.1");
            mainPage140103.agregarSaldo.click();
            mainPage140103.seleccionarCancelado.click();
            mainPage140103.devolverFacturas.click();
            mainPage140103.selectFactura.click();
            mainPage140103.cantidadDevolver.sendKeys("10");
            mainPage140103.devolverMontoFactura.click();
            mainPage140103.btnCerrarFactura.click();
            mainPage140103.InputGuardarSolicitud.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite140103);
            String folioText = mainPage140103.folio.getText();
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

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

}