package HACIENDA.Tramite31801;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage31801Test {
    MainPage31801 mainPage31801 = new MainPage31801();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite31801 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32616() {
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

        String folioSub = JOptionPane.showInputDialog("Por favor, ingresa el folio:");

        ejecutarProcesoNRunnable(() -> {
            ejecutarRutaTramite(folioSub);

            ejecutarRenovacion();

            loginFirmSoli.firma(tramite31801);

////          Obtener el texto del folio
//            String folioText = mainPage31801.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaTramite(String folioSub) {
        loginFirmSoli.login(tramite31801);
        mainPage31801.selecRol.sendKeys("Persona Moral");
        mainPage31801.btnacep.click();
        mainPage31801.Tramites.sendKeys("Solicitudes nuevas");
        mainPage31801.SoliSub.click();
        mainPage31801.idFoli.sendKeys(folioSub);sleep(1000);
        mainPage31801.btnBuscarFolioSub.click();sleep(1000);
        mainPage31801.tramite31801.doubleClick(); sleep(6000);
        mainPage31801.soliRenov.click();
    }

    public void ejecutarRenovacion() {
        /// Fecha del dia
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        // Llave de pago
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 8;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada).toUpperCase();

        mainPage31801.pestRenova.click(); sleep(500);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage31801.fechaPagoR, fechaHoy);sleep(500);
        mainPage31801.montoMonedaNacionalR.sendKeys("121");
        mainPage31801.nOperR.sendKeys("21232343");
        mainPage31801.llavePagoR.sendKeys(llavePago);
        mainPage31801.manif1.click();
        mainPage31801.manif2.click();

        mainPage31801.btnContiR.click();
        mainPage31801.btnContCargaDocR.click();
        mainPage31801.btnAdjuntDocR.click();
        mainPage31801.dco1R.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage31801.btnOk.click();
        mainPage31801.btnCerrarR.click();
        mainPage31801.btnSiguienteFirma.click();
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }
}
