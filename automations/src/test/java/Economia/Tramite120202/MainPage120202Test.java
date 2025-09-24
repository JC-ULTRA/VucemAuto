package Economia.Tramite120202;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120202Test {
    MainPage120202 mainPage120202 = new MainPage120202();
    Metodos metodos = new Metodos();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite120202 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );
    TramitesFirmasLG tramite120202Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    // Variable para almacenar el tipo de trámite seleccionado
    private String tipoTramite = "";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;

        // Configuraciones de Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=1.25"); // Escala 150%
        Configuration.browserCapabilities = options;
        open();
        getWebDriver().manage().window().maximize(); // Maximizar la ventana
        Configuration.timeout = 120000; // Tiempo de espera
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
    public void Proceso120101() throws IOException {

        if (tipoTramite == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Solicitar el número de repeticiones
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

        // Ejecutar el proceso repetidamente
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginFirmSoli.login(tramite120202); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaAlTramite();

            ///Consultar Cupo
            ejecutarExpedicionCertifCupoPM();

            mainPage120202.btnContinuarFirma.click();

//            ///Firma
            loginFirmSoli.firma(tramite120202);
////          Obtener el texto del folio
            String folioText = mainPage120202.folio.getText();
////          Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }
    ///Ruta del Tramite
    public void ejecutarRutaAlTramite() {
        mainPage120202.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage120202.SoliNew.click(); sleep(1000);
        mainPage120202.Economia.click(); sleep(1000);
        mainPage120202.CuposImportExport.click(); sleep(1000);
        mainPage120202.ExpediCertificCupo.click(); sleep(1000);
        mainPage120202.Tramite120202.click(); sleep(1000);
    }

    ///Expedición Certificado Cupo Persona Moral
    public void ejecutarExpedicionCertifCupoPM() {
        metodos.scrollDecremento(1);
        mainPage120202.PestAsigDirecta.click();sleep(1000);
        mainPage120202.AnioOficioAsig.sendKeys("2025");sleep(1000);
        mainPage120202.NumOficioAsig.sendKeys("2");sleep(1000);
        mainPage120202.btnBuscarOficioAsig.click();sleep(1000);
        mainPage120202.Monto.sendKeys("1");sleep(1000);
        mainPage120202.btnAgregarMonto.click();sleep(1000);
    }

    public String GenerarCertificadoACancelar(){
        loginFirmSoli.login(tramite120202); sleep(1000);
        mainPage120202.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage120202.SoliNew.click(); sleep(1000);
        mainPage120202.Economia.click(); sleep(1000);
        mainPage120202.CuposImportExport.click(); sleep(1000);
        mainPage120202.ExpediCertificCupo.click(); sleep(1000);
        mainPage120202.Tramite120202.click(); sleep(1000);
        metodos.scrollDecremento(1);
        mainPage120202.PestAsigDirecta.click();sleep(1000);
        mainPage120202.AnioOficioAsig.sendKeys("2025");sleep(1000);
        mainPage120202.NumOficioAsig.sendKeys("2");sleep(1000);
        mainPage120202.btnBuscarOficioAsig.click();sleep(1000);
        mainPage120202.Monto.sendKeys("1");sleep(1000);
        mainPage120202.btnAgregarMonto.click();sleep(1000);
        mainPage120202.btnContinuarFirma.click();
        loginFirmSoli.firma(tramite120202);
        Wait().withTimeout(Duration.ofSeconds(40)).until(d -> d.getTitle().contains("Acuse de recibo"));
        String folioText = mainPage120202.folio.shouldBe(visible).getText();
        String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2500);
        setUpAll();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120202Fun);
        $(By.cssSelector("img[src*='icoOtrasTareas.png']")).click();sleep(2000);
        $x("//a[contains(text(),'Otras tareas') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
        $x("//a[contains(text(),'CUPOS') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
        $(By.linkText("Generar Certificado de cupo")).shouldBe(visible).click();
        mainPage120202.consultaFolio.click();
        mainPage120202.numFolioCert.sendKeys(folioNumber);
        mainPage120202.btnBuscarFolioConsilta.click();
        mainPage120202.folioTabla.doubleClick();
        mainPage120202.btnGenerar.click();
        mainPage120202.btnEntregado.click();
        String certificado = mainPage120202.celdaCertificado.text();

        return certificado;
    }
    public void ProcesoEntregarCupo(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120202Fun);
        $(By.cssSelector("img[src*='icoOtrasTareas.png']")).click();
        mainPage120202.otrasTareas.click();
        mainPage120202.CUPOS.click();
        mainPage120202.generarCertificado.click();
        mainPage120202.consultaFolio.click();
        mainPage120202.numFolioCert.sendKeys(folioNumber);
        mainPage120202.btnBuscarFolioConsilta.click();
        mainPage120202.folioTabla.doubleClick();
        mainPage120202.btnGenerar.click();
        mainPage120202.btnEntregado.click();
        String certificado = mainPage120202.celdaCertificado.text();
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }

}
