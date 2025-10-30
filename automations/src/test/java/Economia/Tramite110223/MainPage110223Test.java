package Economia.Tramite110223;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110223Test {
    MainPage110223 mainPage110223 = new MainPage110223();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110223  = new TramitesFirmasLG(
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
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso110223() throws IOException {
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

///Tramite Aviso 110223
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite110223); sleep(1000);

            ///RutaAlTramite
            ejecutarRutaAlTramite();

            ///Certificado de Origen Captura
            ejecutarCertificadoOrigenCaptura();

            ///Destinatario
            ejecutarDestinatario();

            ///Certificado
            ejecutarCertificado();

            ///Firma
            loginSoli.firma(tramite110223);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110223.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage110223.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage110223.btnacep.click(); sleep(1000);
        $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
        $(withText("Solicitudes nuevas")).click();sleep(1000);
        $("[alt='Secretaría de Economía']").click();sleep(1000);
        $$(By.cssSelector("a[href='#']")).findBy(text("Certificados de Origen")).click();sleep(1000);
        $$(By.cssSelector("a[href='#']")).findBy(text("Validación de Certificados de Origen")).click();sleep(1000);
        $$(By.cssSelector("a[href='#']")).findBy(text("Validar a  posteriori el certificado para el Acuerdo Alianza del Pacífico")).click();sleep(15000);
    }

    public void ejecutarCertificadoOrigenCaptura(){
        ///genera numero de 8 digitos aleatorio para el numero de factura ya que no puede ser el mismo
        Random random = new Random();
        int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
        mainPage110223.PestCertificadOrigen.click(); sleep(1000);
        mainPage110223.TradadoAcuerdo.sendKeys("Acuerdo Alianza del Pacífico"); sleep(1000);
        mainPage110223.PaisBloque.sendKeys("PERU (REPUBLICA DEL)"); sleep(1000);
        mainPage110223.btnBuscarMerca.click(); sleep(1000);
        mainPage110223.CargarTramiteEjemplo.doubleClick(); sleep(1000);
        mainPage110223.Cantidad.sendKeys("2223.0000");
        mainPage110223.UMC.sendKeys("Caja");
        mainPage110223.ValorMercanciaDoll.sendKeys("2111.0000");
        mainPage110223.ComplementoDescripcion.sendKeys("454002245");
        Selenide.executeJavaScript("arguments[0].value = '14/04/2025';", mainPage110223.FechaFactura); sleep(1000);
        mainPage110223.NFactura.setValue(String.valueOf(nFacturaR));
        mainPage110223.TipoFactura.sendKeys("Manual");
        mainPage110223.NSerie.setValue(String.valueOf(nFacturaR));
        mainPage110223.btnAgregarMerca.click(); sleep(1000);
        $$("button").findBy(Condition.text("Aceptar")).click();
    }

    public void ejecutarDestinatario(){
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage110223.Destinatario.click(); sleep(1000);
        mainPage110223.NombreDesti.sendKeys("EUROFOODS DE MEXICO"); sleep(1000);
        mainPage110223.NRegisFiscal.sendKeys("234223242"); sleep(1000);
        mainPage110223.CalleDesti.sendKeys("Tamaulipas"); sleep(1000);
        mainPage110223.NumeoLetraDesti.sendKeys("13"); sleep(1000);
        mainPage110223.CiudadDesti.sendKeys("ALVARADO"); sleep(1000);
        mainPage110223.CorreoDesti.sendKeys("Ultrasist@pruebas.com"); sleep(1000);
        mainPage110223.TelefonoDesti.sendKeys("2979725632"); sleep(1000);
        mainPage110223.FaxDesti.sendKeys("15616548"); sleep(1000);
        mainPage110223.LugarExport.sendKeys("Tamaulipas 15 cl: centro "); sleep(1000);
        mainPage110223.NombreRepreExport.sendKeys("Jose Alberto martinez juarez"); sleep(1000);
        mainPage110223.EmpresaExport.sendKeys("INTEGRADORA DE URBANIZACIONES SIGNUM, S DE RL DE CV"); sleep(1000);
        mainPage110223.CargoExport.sendKeys("QA"); sleep(1000);
        mainPage110223.NumRegFiscalExport.sendKeys("223232222"); sleep(1000);
        mainPage110223.CorreoExport.sendKeys("Ultrasist@pruebas.com"); sleep(1000);
        mainPage110223.TelefonoExport.sendKeys("2979725632"); sleep(1000);
        mainPage110223.FaxExport.sendKeys("234222"); sleep(1000);
    }

    public void ejecutarCertificado(){
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage110223.DatosCertificado.click(); sleep(1000);
        mainPage110223.Obs.sendKeys("QA"); sleep(1000);
        mainPage110223.EntidadFederativa.sendKeys("SINALOA"); sleep(1000);
        mainPage110223.btnContinuarCertifi.click(); sleep(1000);
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
