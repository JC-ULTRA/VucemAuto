package Economia.Tramite120202;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120202Test {
    MainPage120202 mainPage120202 = new MainPage120202();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite120202 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );

    // Variable para almacenar el tipo de trámite seleccionado
    private String tipoTramite = "";

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
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
            loginSoli.login(tramite120202); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaAlTramite();

            ///Consultar Cupo
            ejecutarExpedicionCertifCupoPM();

            mainPage120202.btnContinuarFirma.click();

//            ///Firma
//            loginSoli.firma(tramite120202);
//
////          Obtener el texto del folio
//            String folioText = mainPage120101.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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
        mainPage120202.PestAsigDirecta.click();sleep(1000);
        mainPage120202.AnioOficioAsig.sendKeys("2025");sleep(1000);
        mainPage120202.NumOficioAsig.sendKeys("2");sleep(1000);
        mainPage120202.btnBuscarOficioAsig.click();sleep(1000);
        mainPage120202.Monto.sendKeys("100");sleep(1000);
        mainPage120202.btnAgregarMonto.click();sleep(1000);
    }


    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }

}
