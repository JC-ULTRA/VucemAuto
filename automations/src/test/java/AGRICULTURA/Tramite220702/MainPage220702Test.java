package AGRICULTURA.Tramite220702;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220702Test {
    MainPage220702 mainPage220702 = new MainPage220702();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite220702 = new TramitesFirmasLG(
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
    public void Proceso220702() throws IOException {

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
            loginSoli.login(tramite220702); sleep(1000);

            ///Subsecuente
            ejecutarTramiteSubsecuentes(FolioBusquedaS);

            ///Justificación y carga
            ejecutarJustificYCarga();
//            mainPage220702.btnContinuarFirma.click();

//            ///Firma
//            loginSoli.firma(tramite220702);
//
////          Obtener el texto del folio
//            String folioText = mainPage220702.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }
    ///Ruta del Tramite Subsecuente
    public void ejecutarTramiteSubsecuentes(String FolioBusquedaS) {
        mainPage220702.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage220702.btnacep.click(); sleep(1000);
        mainPage220702.Tramites.sendKeys("Solicitudes subsecuentes"); sleep(1000);
        mainPage220702.SoliSub.click(); sleep(1000);
        mainPage220702.FolioBusqueda.sendKeys(FolioBusquedaS); sleep(1000);
        mainPage220702.btnBuscarFolioSub.click(); sleep(1000);
    }

    public void ejecutarJustificYCarga() {
        // Obtener la fecha de hoy formateada
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);

        //llave de pago
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 16;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

        mainPage220702.TramiteSeleccionar.doubleClick(); sleep(1000);
        mainPage220702.ProrrogaDelTramite.click(); sleep(1000);
        mainPage220702.PestDatosSoli.click(); sleep(1000);
        mainPage220702.Justific.sendKeys("Pruebas QA"); sleep(1000);
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage220702.PestLLavePago.click(); sleep(1000);
        mainPage220702.Banco.sendKeys("BANCA AFIRME"); sleep(1000);
        mainPage220702.LlavePago.sendKeys(llavePago); sleep(1000);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage220702.FechaPagoP, fechaHoy);sleep(1000);
        mainPage220702.btnContiRequerimiento.click(); sleep(1000);
        mainPage220702.btnContiCarga.click(); sleep(1000);
        mainPage220702.btnAdjuntarDocs.click(); sleep(1000);
        mainPage220702.Doc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(1000);
        mainPage220702.btnAnex.click(); sleep(1000);
        mainPage220702.btnCerrarMod.click(); sleep(1000);
        mainPage220702.btnContFirm.click(); sleep(1000);
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }

}
