package Economia.Tramite110212;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110212.MainPage110212;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110212Test {
    MainPage110212 mainPage110212 = new MainPage110212();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110212  = new TramitesFirmasLG(
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
    public void Proceso110212() throws IOException {
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
            // Ingreso y selección de trámite

            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 7;
            String FacturaGenerada = uuid.replace("-", "").substring(0, longitudDeseada);


            loginFirmSoli.login(tramite110212); sleep(1000);
            mainPage110212.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110212.btnacep.click(); sleep(1000);
            mainPage110212.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110212.SoliNew.click(); sleep(1000);
            mainPage110212.Economia.click(); sleep(1000);
            mainPage110212.CertOrigen.click(); sleep(1000);
            mainPage110212.ValidacionCertificado.click(); sleep(1000);
            mainPage110212.elementoTramite110212.click(); sleep(1000);

            //Datos de la mercancia
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            mainPage110212.TituloPrincipal.scrollTo().shouldBe(visible);
            mainPage110212.tabCertificadoOrigen.click();

            mainPage110212.TratadoAcuerdo.sendKeys("Articulos Mexicanos");
            mainPage110212.PaisBloque.selectOption("CHILE (REPUBLICA DE)");
            mainPage110212.btnBuscarmercancia.click();
            mainPage110212.filaMercanciaDisponible.doubleClick();
            //mainPage110212.TituloPrincipal.scrollTo().shouldBe(visible);

            //Agregar datos Mercancia
            mainPage110212.Cantidad.sendKeys("50");
            mainPage110212.selectUMC.sendKeys("Kilogramo");
            mainPage110212.ValorMercancia.sendKeys("5000");
            mainPage110212.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage110212.fechaFactura);
            mainPage110212.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110212.selectTipoFactura.sendKeys("Manual");
            mainPage110212.btnAgregarDatosMercancia.click();
            mainPage110212.btnAceptarNotficacionAgrMercancia.click();

            //Tab Destinatario
            mainPage110212.tabDestinatario.click();
            //Datos del destinatario
            mainPage110212.RFCDestinatario.sendKeys("LLPH932007200");
            mainPage110212.RazonSocialDestinatario.sendKeys("Razón social QA");
            //Domicilio del destinatario
            mainPage110212.CiudadDestinatario.sendKeys("Chile");
            mainPage110212.CalleDestinatario.sendKeys("Calle QA");
            mainPage110212.NumeroLetraDestinatario.sendKeys("160");
            mainPage110212.LadaDestinatario.sendKeys("56");
            mainPage110212.TelefonoDestinatario.sendKeys("5615670830");
            mainPage110212.FaxDestinatario.sendKeys("5680345676");
            mainPage110212.CorreoDestinatario.sendKeys("qacorreo@gmail.com");

            //Detalles del representante legal del exportador
            mainPage110212.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110212.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            mainPage110212.CargoRepresentante.sendKeys("Jefe departamento QA");
            mainPage110212.LadaRepresentante.sendKeys("55");
            mainPage110212.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110212.FaxRepresentante.sendKeys("5599112233");
            mainPage110212.CorreoRepresentante.sendKeys("representanteQA@gmail.com");

            //Datos certificado
            mainPage110212.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110212.tabDatosCertificado.click();
            mainPage110212.Observaciones.sendKeys("QA Observaciones");
            mainPage110212.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110212.selectEstado.sendKeys("SINALOA");
            mainPage110212.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110212);

            // Obtener el texto del folio desde mainPageB8

            String folioText = mainPage110212.folio.getText();

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

