package Economia.Tramite110211;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110211.MainPage110211;
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

public class MainPage110211Test {
    MainPage110211 mainPage110211 = new MainPage110211();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110211  = new TramitesFirmasLG(
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
    public void Proceso110211() throws IOException {
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


            loginFirmSoli.login(tramite110211); sleep(1000);
            mainPage110211.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110211.btnacep.click(); sleep(1000);
            mainPage110211.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110211.SoliNew.click(); sleep(1000);
            mainPage110211.Economia.click(); sleep(1000);
            mainPage110211.CertOrigen.click(); sleep(1000);
            mainPage110211.ValidacionCertificado.click(); sleep(1000);
            mainPage110211.elementoTramite110211.click(); sleep(1000);

            //Datos de la mercancia
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110211.tabCertificadoOrigen.click();

            mainPage110211.TratadoAcuerdo.sendKeys("Articulos Mexicanos");
            mainPage110211.PaisBloque.selectOption("ARGENTINA (REPUBLICA)");
            mainPage110211.btnBuscarmercancia.click();
            mainPage110211.filaMercanciaDisponible.doubleClick();
            //mainPage110211.TituloPrincipal.scrollTo().shouldBe(visible);

            //Agregar datos Mercancia
            mainPage110211.Cantidad.sendKeys("30");
            mainPage110211.selectUMC.sendKeys("Kilogramo");
            mainPage110211.ValorMercancia.sendKeys("1000");
            mainPage110211.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage110211.fechaFactura);
            mainPage110211.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110211.selectTipoFactura.sendKeys("Manual");
            mainPage110211.btnAgregarDatosMercancia.click();
            mainPage110211.btnAceptarNotficacionAgrMercancia.click();

            //Tab Destinatario
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110211.tabDestinatario.click();
            //Datos del destinatario
            mainPage110211.RFCDestinatario.sendKeys("PELO932007200");
            mainPage110211.RazonSocialDestinatario.sendKeys("Razón social QA");
            //Domicilio del destinatario
            mainPage110211.CiudadDestinatario.sendKeys("Buenos Aires");
            mainPage110211.CalleDestinatario.sendKeys("Calle QA");
            mainPage110211.NumeroLetraDestinatario.sendKeys("200");
            mainPage110211.LadaDestinatario.sendKeys("54");
            mainPage110211.TelefonoDestinatario.sendKeys("5431000029");
            mainPage110211.FaxDestinatario.sendKeys("5439018010");
            mainPage110211.CorreoDestinatario.sendKeys("qacorreo@gmail.com");

            //Detalles del transporte
            mainPage110211.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110211.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            mainPage110211.CargoRepresentante.sendKeys("Jefe departamento QA");
            mainPage110211.LadaRepresentante.sendKeys("55");
            mainPage110211.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110211.FaxRepresentante.sendKeys("5599112233");
            mainPage110211.CorreoRepresentante.sendKeys("representanteQA@gmail.com");


            //Datos certificado
            mainPage110211.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110211.tabDatosCertificado.click();
            mainPage110211.Observaciones.sendKeys("QA Observaciones");
            mainPage110211.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110211.selectEstado.sendKeys("SINALOA");
            mainPage110211.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110211);

            // Obtener el texto del folio desde mainPageB8

            String folioText = mainPage110211.folio.getText();

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

