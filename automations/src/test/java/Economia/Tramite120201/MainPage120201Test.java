package Economia.Tramite120201;

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

public class MainPage120201Test {
    MainPage120201 mainPage120201 = new MainPage120201();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite120201 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
            loginSoli.login(tramite120201); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaAlTramite();

            ///Consultar Cupo
            ejecutarExpedicionCertifCupoPM();

            mainPage120201.btnContinuarFirma.click();

//            ///Firma
//            loginSoli.firma(tramite120201);
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
        mainPage120201.selecRol.sendKeys("Persona Física"); sleep(1000);
        mainPage120201.btnacep.click(); sleep(1000);
        mainPage120201.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage120201.SoliNew.click(); sleep(1000);
        mainPage120201.Economia.click(); sleep(1000);
        mainPage120201.CuposImportExport.click(); sleep(1000);
        mainPage120201.ExpediCertificCupo.click(); sleep(1000);
        mainPage120201.Tramite120201.click(); sleep(1000);
    }

    ///Expedición Certificado Cupo Persona Moral
    public void ejecutarExpedicionCertifCupoPM() {
        mainPage120201.PestAsigDirecta.click();sleep(1000);
        mainPage120201.AnioOficioAsig.sendKeys("2025");sleep(1000);
        mainPage120201.NumOficioAsig.sendKeys("3");sleep(1000);
        mainPage120201.btnBuscarOficioAsig.click();sleep(1000);
        mainPage120201.Monto.sendKeys("100");sleep(1000);
        mainPage120201.btnAgregarMonto.click();sleep(1000);
    }


    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }
}
