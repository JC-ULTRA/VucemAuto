package Economia.Tramite120101;

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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120101Test {
    MainPage120101 mainPage120101 = new MainPage120101();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite120101 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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

        /// Selección del tipo de trámite
        String[] opciones = {"Hilo", "Tela", "Bienes", "Prendas"};
        tipoTramite = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de trámite:",
                "Tipo de Trámite",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Ejecutar el proceso repetidamente
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite120101); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaAlTramite();

            ///Consultar Cupo
            ejecutarConsultarCupo();

            ///Insumos
            ejecutarInsumos();

            ///Proceso Productivo: Según su selección
            ejecutarProcesoProductivo();

//            ///Firma
//            loginSoli.firma(tramite120101);
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
        mainPage120101.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage120101.btnacep.click(); sleep(1000);
        mainPage120101.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage120101.SoliNew.click(); sleep(1000);
        mainPage120101.Economia.click(); sleep(1000);
        mainPage120101.CertificadoOrigen.click(); sleep(1000);
        mainPage120101.ValidacionCertificadosOrigen.click(); sleep(1000);
        mainPage120101.Tramite120101.click(); sleep(1000);
    }

    ///Consultar Cupo
    public void ejecutarConsultarCupo() {
        mainPage120101.ConsultCupoPest.click();
        mainPage120101.ClasifRegimen.sendKeys("Exportación"); sleep(1000);
        mainPage120101.PaisDestOrg.sendKeys("ESTADOS UNIDOS DE AMERICA"); sleep(1000);
        mainPage120101.FreaccionArancel.sendKeys("9404902000"); sleep(1000);
        mainPage120101.btnBuscarTPL.click(); sleep(1000);
        mainPage120101.CargaRegistro.doubleClick(); sleep(1000);
        mainPage120101.Estado.sendKeys("SINALOA"); sleep(1000);
        mainPage120101.RepreFede.sendKeys("CENTRAL CDMX"); sleep(1000);
        mainPage120101.Descrip.sendKeys("Prueba UAT"); sleep(1000);
        mainPage120101.btnContinuarCupo.click(); sleep(1000);
    }

    ///Insumos
    public void ejecutarInsumos() {
        mainPage120101.InsumosPest.click();
        mainPage120101.btnAgregarInsumo.click();
        mainPage120101.DescripInsumo.sendKeys("Pruebas QA");
        mainPage120101.InsumoFraccArancel.sendKeys("9404902000");
        mainPage120101.DescripFraccArancel.sendKeys("Prenda de algodón");
        mainPage120101.PaisDeOrigen.sendKeys("ANGUILA");
        mainPage120101.btnAgregarInsumo2.click();
    }

    ///Proceso Productivo: Según su selección
    public void ejecutarProcesoProductivo() {
        mainPage120101.ProcesoProductivoPest.click();sleep(1500);
        if (tipoTramite.equalsIgnoreCase("Hilo")) {
            mainPage120101.CheckHilo.click();sleep(1500);
            mainPage120101.PaisOrgFibra.sendKeys("ANGUILA");sleep(1500);
            mainPage120101.PaisRealizoHilado.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(1500);

        } else if (tipoTramite.equalsIgnoreCase("Tela")) {
            mainPage120101.CheckTela.click();sleep(1500);
            mainPage120101.PaisRealizoHilado2.sendKeys("ANGUILA");sleep(1500);
            mainPage120101.PaisRealizoTejido.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(1500);

        } else if (tipoTramite.equalsIgnoreCase("Bienes")) {
            mainPage120101.CheckBienes.click();sleep(1500);
            mainPage120101.PaisRealizoHilado3.sendKeys("ANGUILA");sleep(1500);
            mainPage120101.PaisRealizoTejidoForma.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(1500);

        } else if (tipoTramite.equalsIgnoreCase("Prendas")) {
            mainPage120101.CheckPrendas.click();sleep(1500);
            mainPage120101.PaisRealizoHilado4.sendKeys("ANGUILA");sleep(1500);
            mainPage120101.PaisRealizoTejido4.sendKeys("ANGUILA");sleep(1500);
            mainPage120101.PaisRealizoCorte.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(1500);
            mainPage120101.PaisRealizoEnsamble.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(1500);

        } else {
            System.out.println("Tipo de trámite no reconocido.");
        }
        mainPage120101.btnContinuarFirma.click();
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }
}
