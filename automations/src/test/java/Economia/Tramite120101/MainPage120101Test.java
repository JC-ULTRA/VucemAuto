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
    TramitesFirmasLG tramite120101  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
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


///Tramite Aviso 120101
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite120101); sleep(1000);

            ///RutaAlTramite
            ejecutarRutaAlTramite();

            ///Consulta de Cupo
            ejecutarConsultarCupo();

//
//            ///Firma
//            loginSoli.firma(tramite120101);
//
//            // Obtener el texto del folio desde mainPageB8
//            String folioText = mainPage120101.folio.getText();
//
//            // Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage120101.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage120101.btnacep.click(); sleep(1000);
        mainPage120101.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage120101.SoliNew.click(); sleep(1000);
        mainPage120101.Economia.click(); sleep(1000);
        mainPage120101.CertificadoOrigen.click(); sleep(1000);
        mainPage120101.ValidacionCertificadosOrigen.click(); sleep(1000);
        mainPage120101.Tramite120101.click(); sleep(1000);

    }
    public void ejecutarConsultarCupo(){
        mainPage120101.ConsultCupoPest.click();
        mainPage120101.ClasifRegimen.sendKeys("Exportación"); sleep(1000);
        mainPage120101.PaisDestOrg.sendKeys("ESTADOS UNIDOS DE AMERICA"); sleep(1000);
        mainPage120101.FreaccionArancel.sendKeys("6203315020"); sleep(1000);
        mainPage120101.btnBuscarTPL.click(); sleep(1000);
        mainPage120101.CargaRegistro.doubleClick(); sleep(1000);
        mainPage120101.Estado.sendKeys("SINALOA"); sleep(1000);
        mainPage120101.RepreFede.sendKeys("CENTRAL CDMX"); sleep(1000);
        mainPage120101.Descrip.sendKeys("Prueba UAT"); sleep(1000);
        mainPage120101.btnContinuarCupo.click(); sleep(1000);

    }


    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}

