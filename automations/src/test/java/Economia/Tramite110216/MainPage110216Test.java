package Economia.Tramite110216;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110216.MainPage110216;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110216Test {
    MainPage110216 mainPage110216 = new MainPage110216();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110216  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
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
    public void Proceso110216() throws IOException {
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

        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {

            //Generar Factura aleatoria
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 7;
            String FacturaGenerada = uuid.replace("-", "").substring(0, longitudDeseada);


            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);


            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite110216); sleep(1000);
            mainPage110216.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110216.btnacep.click(); sleep(1000);
            mainPage110216.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110216.SoliNew.click(); sleep(1000);
            mainPage110216.Economia.click(); sleep(1000);
            mainPage110216.CertOrigen.click(); sleep(1000);
            mainPage110216.ValidacionCertificado.click(); sleep(1000);
            mainPage110216.elementoTramite110216.click(); sleep(1000);

            // Seccion Certificado origen
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110216.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110216.tabCertificadoOrigen.click();

            mainPage110216.TratadoAcuerdo.sendKeys("Acuerdo México-Japón");
            mainPage110216.PaisBloque.selectOption("JAPON");
            mainPage110216.btnBuscarmercancia.click();
            mainPage110216.filaMercanciaDisponible.doubleClick();

            //Agregar datos Mercancia
            mainPage110216.Cantidad.sendKeys("80");
            mainPage110216.selectUMC.sendKeys("Kilogramo");
            mainPage110216.ValorMercancia.sendKeys("8000");
            mainPage110216.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110216.fechaFactura, fechaHoy);sleep(1000);
            mainPage110216.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110216.selectTipoFactura.shouldBe(enabled, Duration.ofSeconds(3)).sendKeys("Manual");
            mainPage110216.btnAgregarDatosMercancia.click();
            mainPage110216.btnAceptarNotficacionAgrMercancia.click();

            //Flujo Seccion Historico Productores
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110216.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110216.tabHistoricoProductores.click();
            mainPage110216.checkDatosProductorNoConfidencial.click();
            mainPage110216.checkExpImpNoMismaPersona.click();
            //Grid Productores por exportador
            mainPage110216.btnProductorNuevo.click();
            mainPage110216.rfcProductorNuevo.sendKeys("LEQI8101314S7");
            mainPage110216.btnAgregarProductor.click();

            //Flujo Seccion Destinatario
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110216.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110216.tabDestinatario.click();
            //Datos del destinatario
            mainPage110216.RFCDestinatario.sendKeys("GOFM951102208");
            mainPage110216.RazonSocialDestinatario.sendKeys("Razón social QA");
            //Domicilio del destinatario
            mainPage110216.CiudadDestinatario.sendKeys("Tokyo");
            mainPage110216.CalleDestinatario.sendKeys("Calle QA");
            mainPage110216.NumeroLetraDestinatario.sendKeys("900");
            mainPage110216.LadaDestinatario.sendKeys("082");
            mainPage110216.TelefonoDestinatario.sendKeys("0829860830");
            mainPage110216.FaxDestinatario.sendKeys("0820011448");
            mainPage110216.CorreoDestinatario.sendKeys("qacorreoTokyo@gmail.com");
            //Detalles del representante legal del exportador
            mainPage110216.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110216.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            //mainPage110216.EmpresaRepresentante.sendKeys("Empresa QA representante");
            mainPage110216.CargoRepresentante.sendKeys("Jefe departamento QA");
            //mainPage110216.LadaRepresentante.sendKeys("55");
            mainPage110216.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110216.FaxRpresentante.sendKeys("5548795678");
            mainPage110216.CorreoRepresentante.sendKeys("representanteQA@gmail.com");
            //Detalles del transporte
            mainPage110216.PuertoEmbarque.sendKeys("Mazatlan");
            mainPage110216.PuertoDesembarque.sendKeys("Tokio");
            mainPage110216.PuertoTransito.sendKeys("Los Cabos");
            mainPage110216.NombreEmbarcacion.sendKeys("Transporte QA México-Japon");
            mainPage110216.NumeroVuelo.sendKeys("600");

            //Flujo Sección Datos certificado
            mainPage110216.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110216.tabDatosCertificado.click();
            mainPage110216.Observaciones.sendKeys("QA Observaciones");
            mainPage110216.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110216.selectEstado.sendKeys("SINALOA");
            mainPage110216.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110216);

            // Obtener el texto del folio desde mainPageB8

            String folioText = mainPage110216.folio.getText();

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

