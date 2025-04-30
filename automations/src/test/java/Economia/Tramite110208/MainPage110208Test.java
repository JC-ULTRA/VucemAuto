package Economia.Tramite110208;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110208.MainPage110208;
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

public class MainPage110208Test {
    MainPage110208 mainPage110208 = new MainPage110208();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110208  = new TramitesFirmasLG(
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
    public void Proceso110208() throws IOException {
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


            loginFirmSoli.login(tramite110208); sleep(1000);
            mainPage110208.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110208.btnacep.click(); sleep(1000);
            mainPage110208.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110208.SoliNew.click(); sleep(1000);
            mainPage110208.Economia.click(); sleep(1000);
            mainPage110208.CertOrigen.click(); sleep(1000);
            mainPage110208.ValidacionCertificado.click(); sleep(1000);
            mainPage110208.elementoTramite110208.click(); sleep(1000);

            //Datos de la mercancia
            mainPage110208.Scrol.scrollTo();
            mainPage110208.tabCertificadoOrigen.click();

            mainPage110208.TratadoAcuerdo.sendKeys("Sistema Generalizado de Preferencias");
            mainPage110208.PaisBloque.sendKeys("JAPON");
            mainPage110208.btnBuscarmercancia.click();
            mainPage110208.filaMercanciaDisponible.doubleClick();

            //Agregar datos Mercancia
            mainPage110208.MarcaMercancia.sendKeys("Marca QA");
            mainPage110208.Cantidad.sendKeys("24");
            mainPage110208.selectUMC.sendKeys("Kilogramo");
            mainPage110208.ValorMercancia.sendKeys("1000");
            mainPage110208.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage110208.fechaFactura);
            mainPage110208.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110208.selectTipoFactura.sendKeys("Manual");
            mainPage110208.btnAgregarDatosMercancia.click();
            mainPage110208.btnAceptarNotficacionAgrMercancia.click();

            //Tab Destinatario
            mainPage110208.tabDestinatario.click();
            //Datos del destinatario
            mainPage110208.RFCDestinatario.sendKeys("QALA971201177");
            mainPage110208.RazonSocialDestinatario.sendKeys("Razon social QA");
            //Domicilio del destinatario
            mainPage110208.CiudadDestinatario.sendKeys("Osaka");
            mainPage110208.CalleDestinatario.sendKeys("Calle QA");
            mainPage110208.NumeroLetraDestinatario.sendKeys("549");
            mainPage110208.LadaDestinatario.sendKeys("06");
            mainPage110208.TelefonoDestinatario.sendKeys("0639000019");
            mainPage110208.FaxDestinatario.sendKeys("0639018010");
            mainPage110208.CorreoDestinatario.sendKeys("qacorreo@gmail.com");
            mainPage110208.selectPaisDestino.selectOption("JAPON");
            //Detalles del transporte
            mainPage110208.selectMedioTransporte.sendKeys("Aéreo");
            mainPage110208.RutaCompleta.sendKeys("Ruta QA translado");
            mainPage110208.PuertoEmbarque.sendKeys("Tokio");
            mainPage110208.PuertoDesembarque.sendKeys("Osaka");

            //Datos certificado
            mainPage110208.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110208.tabDatosCertificado.click();
            mainPage110208.Observaciones.sendKeys("QA Observaciones");
            mainPage110208.selectIdioma.sendKeys("English");
            //Representación federal
            mainPage110208.selectEstado.sendKeys("SINALOA");
            mainPage110208.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110208);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110208.folio.getText();

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

