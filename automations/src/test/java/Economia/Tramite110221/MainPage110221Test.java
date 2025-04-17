package Economia.Tramite110221;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110221Test {
    MainPage110221 mainPage110221 = new MainPage110221();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110221  = new TramitesFirmasLG(
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
    public void Proceso110221() throws IOException {
        // Opciones a mostrar
        String[] opciones = {"CleckPeriodo", "Check1Import"};

        // Mostrar el JOptionPane
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿A cuál elemento quieres hacer clic?",
                "Selecciona un elemento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
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
            ///Login
            loginSoli.login(tramite110221); sleep(1000);

            ///RutaAlTramite
            ejecutarRutaAlTramite();

            ///Certificado de Origen Captura
            ejecutarCertificadoOrigenCaptura(seleccion);

            ///Histórico Productores
            ejecutarHistoricoProductores();

            ///Destinatario
            ejecutarDestinatario();

            ///Certificado
            ejecutarCertificado();

//            ///Firma
//            loginSoli.firma(tramite110221);
//            // Obtener el texto del folio desde mainPageB8
//            String folioText = mainPage110221.folio.getText();
//            // Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage110221.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage110221.btnacep.click(); sleep(1000);
        mainPage110221.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage110221.SoliNew.click(); sleep(1000);
        mainPage110221.Economia.click(); sleep(1000);
        mainPage110221.CertificadoOrigen.click(); sleep(1000);
        mainPage110221.ValidacionCertificadosOrigen.click(); sleep(1000);
        mainPage110221.Tramite110221.click(); sleep(1000);

    }

    public void ejecutarCertificadoOrigenCaptura(String seleccion){
        mainPage110221.PestCertificadOrigen.click(); sleep(1000);
        // Verificar la selección y mostrar mensaje
        if ("CleckPeriodo".equals(seleccion)) {
            EjecutarPeriodo(seleccion);
        } else if ("Check1Import".equals(seleccion)) {
            EjecutarImportacion(seleccion);
        } else {
            System.out.println("No se seleccionó ningún elemento.");
        }
    }
    public void EjecutarImportacion(String seleccion){
        ///genera numero de 8 digitos aleatorio para el numero de factura ya que no puede ser el mismo
        Random random = new Random();
        int nFacturaR = 10_000_000 + random.nextInt(90_000_000);

        // Obtener la fecha de hoy formateada
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);

        mainPage110221.Check1Import.click();sleep(1000);sleep(1000);
        mainPage110221.TradadoAcuerdo.sendKeys("TRATADO DE LIBRE COMERCIO MÉXICO-PANAMÁ"); sleep(1000);
        mainPage110221.PaisBloque.sendKeys("PANAMA (REPUBLICA DE)"); sleep(1000);
        mainPage110221.btnBuscarMerca.click(); sleep(1000);
        mainPage110221.CargarTramiteEjemplo.doubleClick(); sleep(1000);
        mainPage110221.Cantidad.sendKeys("2223");sleep(1000);
        mainPage110221.UMC.sendKeys("Caja");sleep(1000);
        mainPage110221.ComplementoDescripcion.sendKeys("454002245");sleep(1000);
        mainPage110221.ValorMercanciaDoll.sendKeys("2111");sleep(1000);
        mainPage110221.NSerie.sendKeys("21110000");sleep(1000);
        Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110221.FechaFactura, fechaHoy);sleep(1000);
        sleep(1000);
        mainPage110221.NFactura.setValue(String.valueOf(nFacturaR));sleep(1000);
        mainPage110221.TipoFactura.sendKeys("Manual");sleep(1000);
        mainPage110221.btnAgregarMerca.click(); sleep(1000);
        $$("button").findBy(Condition.text("Aceptar")).click();sleep(1000);
    }
    public void EjecutarPeriodo(String seleccion){
        ///genera numero de 8 digitos aleatorio para el numero de factura ya que no puede ser el mismo
        Random random = new Random();
        int nFacturaR = 10_000_000 + random.nextInt(90_000_000);

        // Obtener la fecha de hoy formateada
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);

        mainPage110221.CleckPeriodo2.click();sleep(1000);
        mainPage110221.TradadoAcuerdo2.sendKeys("TRATADO DE LIBRE COMERCIO MÉXICO-PANAMÁ"); sleep(1000);
        mainPage110221.PaisBloque2.sendKeys("PANAMA (REPUBLICA DE)"); sleep(1000);
        mainPage110221.btnBuscarMerca2.click(); sleep(1000);
        mainPage110221.CargarTramiteEjemplo2.doubleClick(); sleep(1000);
        mainPage110221.Cantidad2.sendKeys("2223");sleep(1000);
        mainPage110221.UMC2.sendKeys("Caja");sleep(1000);
        mainPage110221.ComplementoDescripcion2.sendKeys("454002245");sleep(1000);
        mainPage110221.ValorMercanciaDoll2.sendKeys("2111");sleep(1000);
        mainPage110221.NSerie2.sendKeys("21110000");sleep(1000);
        Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110221.FechaFactura2, fechaHoy);sleep(1000);
        mainPage110221.NFactura2.setValue(String.valueOf(nFacturaR));sleep(1000);
        mainPage110221.TipoFactura2.sendKeys("Manual");sleep(1000);
        mainPage110221.btnAgregarMerca2.click(); sleep(1000);
        $$("button").findBy(Condition.text("Aceptar")).click();sleep(1000);
    }

    public void ejecutarHistoricoProductores(){
        mainPage110221.HproductoresPest.click(); sleep(1000);
        mainPage110221.CheckProductorConfidenciales.click(); sleep(1000);
        mainPage110221.CheckProductorMismaPersona.click(); sleep(4000);
        mainPage110221.CheckInfoProdExport.click(); sleep(1000);
        mainPage110221.btnSeleccionar.click(); sleep(2000);
        executeJavaScript("window.scrollTo(0, 0);");
    }

    public void ejecutarDestinatario(){
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage110221.NombreDesti.sendKeys("EUROFOODS DE MEXICO");
        mainPage110221.NRFiscalDesi.sendKeys("12323424");
        mainPage110221.CalleDesti.sendKeys("Calle1");
        mainPage110221.NumeroLetraDesti.sendKeys("22");
        mainPage110221.PaisDesti.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");
        mainPage110221.CiudadDestin.sendKeys("MEXICO");
        mainPage110221.CorreoDesti.sendKeys("PruebaQA@Ultrasist.com.mx");
        mainPage110221.LadaDesti.sendKeys("55");
        mainPage110221.TelDesti.sendKeys("3652435423");

        mainPage110221.NombreExport.sendKeys("EUROFOODS DE MEXICO");
        mainPage110221.LugarExport.sendKeys("MEXICO");
        mainPage110221.CalleExport.sendKeys("Calle1");
        mainPage110221.NuneroLetraExport.sendKeys("22");
        mainPage110221.PaisExport.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");
        mainPage110221.CiudadExport.sendKeys("MEXICO");
        mainPage110221.CargoExport.sendKeys("JEFE");
        mainPage110221.EmpresaExport.sendKeys("EMPRESA");
        mainPage110221.NRegistroExport.sendKeys("12323424");
        mainPage110221.LadaExport.sendKeys("55");
        mainPage110221.TelefonoExport.sendKeys("3652435423");
        mainPage110221.FaxExport.sendKeys("365243542323");
        mainPage110221.CorreoExport.sendKeys("PruebaQA@Ultrasist.com.mx");
    }

    public void ejecutarCertificado(){
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage110221.DatosCertificado.click(); sleep(1000);
        mainPage110221.Obs.sendKeys("QA"); sleep(1000);
        mainPage110221.EntidadFederativa.sendKeys("SINALOA"); sleep(1000);
        mainPage110221.btnContinuarCertifi.click(); sleep(1000);
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
