package Economia.Tramite110217;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import MedioAmbiente.Tramite231001.MainPage231001;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110217Test {
    MainPage110217 mainPage110217 = new MainPage110217();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110217  = new TramitesFirmasLG(
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
    }

    @Test
    public void Proceso110217() throws IOException {
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


///Tramite Aviso 110217
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
//             Ingreso y selección de trámite
            loginSoli.login(tramite110217); sleep(1000);
            mainPage110217.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110217.btnacep.click(); sleep(1000);
            mainPage110217.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110217.SoliNew.click(); sleep(1000);
            mainPage110217.Economia.click(); sleep(1000);
            mainPage110217.CertificadoOrigen.click(); sleep(1000);
            mainPage110217.ValidacionCertificadosOrigen.click(); sleep(1000);
            mainPage110217.Tramite110217.click(); sleep(1000);

            ///Certificado de Origen Captura
            mainPage110217.PestCertificadOrigen.click(); sleep(1000);
            mainPage110217.TradadoAcuerdo.sendKeys("Acuerdo México-Japón"); sleep(1000);
            mainPage110217.PaisBloque.sendKeys("JAPON"); sleep(1000);
            mainPage110217.btnBuscarMerca.click(); sleep(1000);
            mainPage110217.CargarTramiteEjemplo.doubleClick(); sleep(1000);
            mainPage110217.Cantidad.sendKeys("2223.0000");
            mainPage110217.UMC.sendKeys("Caja");
            mainPage110217.ValorMercanciaDoll.sendKeys("2111.0000");
            mainPage110217.ComplementoDescripcion.sendKeys("454002245");
            Selenide.executeJavaScript("arguments[0].value = '14/04/2025';", mainPage110217.FechaFactura); sleep(1000);
            mainPage110217.NFactura.sendKeys("524855");
            mainPage110217.TipoFactura.sendKeys("Manual");
            mainPage110217.btnAgregarMerca.click(); sleep(1000);
            $$("button").findBy(Condition.text("Aceptar")).click();

            ///Histórico Productores
            mainPage110217.HproductoresPest.click(); sleep(1000);
            mainPage110217.CheckProductorConfidenciales.click(); sleep(1000);
            mainPage110217.CheckProductorMismaPersona.click(); sleep(1000);
            mainPage110217.CheckInfoProdExport.click(); sleep(1000);
            mainPage110217.btnSeleccionar.click(); sleep(1000);

            ///Destinatario
            mainPage110217.Destinatario.click(); sleep(1000);
            mainPage110217.NombreDesti.sendKeys("EUROFOODS DE MEXICO"); sleep(1000);
            mainPage110217.PrimerApellido.sendKeys("GONZALEZ"); sleep(1000);
            mainPage110217.SegundoApellido.sendKeys("PINAL"); sleep(1000);
            mainPage110217.RFC.sendKeys("AAL0409235E6"); sleep(1000);
            mainPage110217.CiudadDesti.sendKeys("ALVARADO"); sleep(1000);
            mainPage110217.CalleDesti.sendKeys("Tamaulipas"); sleep(1000);
            mainPage110217.NumeoLetraDesti.sendKeys("13"); sleep(1000);
            mainPage110217.LadaDesti.sendKeys("22"); sleep(1000);
            mainPage110217.TelefonoDesti.sendKeys("2979725632"); sleep(1000);
            mainPage110217.FaxDesti.sendKeys("15616548"); sleep(1000);
            mainPage110217.CorreoDesti.sendKeys("Ultrasist@pruebas.com"); sleep(1000);

            mainPage110217.LugarExport.sendKeys("Tamaulipas 15 cl: centro "); sleep(1000);
            mainPage110217.NombreRepreExport.sendKeys("Jose Alberto martinez juarez"); sleep(1000);
            mainPage110217.EmpresaExport.sendKeys("INTEGRADORA DE URBANIZACIONES SIGNUM, S DE RL DE CV"); sleep(1000);
            mainPage110217.CargoExport.sendKeys("QA"); sleep(1000);
            mainPage110217.LadaExport.sendKeys("22"); sleep(1000);
            mainPage110217.TelefonoExport.sendKeys("2979725632"); sleep(1000);
            mainPage110217.FaxExport.sendKeys("234222"); sleep(1000);
            mainPage110217.CorreoExport.sendKeys("Ultrasist@pruebas.com"); sleep(1000);

            mainPage110217.PuertoEmbarqueTrans.sendKeys("Veracruz"); sleep(1000);
            mainPage110217.PuertoDesembarqueTrans.sendKeys("mexico"); sleep(1000);
            mainPage110217.PuertoTransitoTrans.sendKeys("veracruz norte"); sleep(1000);
            mainPage110217.NombreEmbarcacionTrans.sendKeys("puerto boca"); sleep(1000);
            mainPage110217.NumeroVueloTrans.sendKeys("01154"); sleep(1000);
            mainPage110217.DatosCertificado.click(); sleep(1000);

            ///Certificado
            mainPage110217.Obs.sendKeys("QA"); sleep(1000);
            mainPage110217.Idioma.sendKeys("Español"); sleep(1000);
            mainPage110217.EntidadFederativa.sendKeys("SINALOA"); sleep(1000);
            mainPage110217.btnContinuarCertifi.click(); sleep(1000);

            loginSoli.firma(tramite110217);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110217.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
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

