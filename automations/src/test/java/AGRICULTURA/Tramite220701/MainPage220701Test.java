package AGRICULTURA.Tramite220701;

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

public class MainPage220701Test {
    MainPage220701 mainPage220701 = new MainPage220701();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite220701 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    // Variable para almacenar el tipo de trámite seleccionado
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
    public void Proceso220701() throws IOException {

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

        // Solicitar el folio
        String FolioBusquedaS = JOptionPane.showInputDialog(null, "Ingrese el Folio a Consultar:", "FolioBusqueda", JOptionPane.QUESTION_MESSAGE);

        // Ejecutar el proceso repetidamente
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite220701); sleep(1000);

            ///Subsecuente
            ejecutarTramiteSubsecuentes(FolioBusquedaS);

            ///Justificación y carga
            ejecutarJustificYCarga();
//            mainPage220701.btnContinuarFirma.click();

//            ///Firma
//            loginSoli.firma(tramite220701);
//
////          Obtener el texto del folio
//            String folioText = mainPage120101.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }
    ///Ruta del Tramite Subsecuente
    public void ejecutarTramiteSubsecuentes(String FolioBusquedaS) {
        mainPage220701.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage220701.btnacep.click(); sleep(1000);
        mainPage220701.Tramites.sendKeys("Solicitudes subsecuentes"); sleep(1000);
        mainPage220701.SoliSub.click(); sleep(1000);
        mainPage220701.FolioBusqueda.sendKeys(FolioBusquedaS); sleep(1000);
        mainPage220701.btnBuscarFolioSub.click(); sleep(1000);
    }

    public void ejecutarJustificYCarga() {
        mainPage220701.TramiteSeleccionar.doubleClick(); sleep(1000);
        mainPage220701.ProrrogaDelTramite.click(); sleep(1000);
        mainPage220701.PestDatosSoli.click(); sleep(1000);
        mainPage220701.Justific.sendKeys("Pruebas QA"); sleep(1000);
        mainPage220701.btnContiRequerimiento.click(); sleep(1000);
        mainPage220701.btnContiCarga.click(); sleep(1000);
        mainPage220701.btnAdjuntarDocs.click(); sleep(1000);
        mainPage220701.Doc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage220701.btnAnex.click(); sleep(1000);
        mainPage220701.btnCerrarMod.click(); sleep(1000);
        mainPage220701.btnContFirm.click(); sleep(1000);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }

}
