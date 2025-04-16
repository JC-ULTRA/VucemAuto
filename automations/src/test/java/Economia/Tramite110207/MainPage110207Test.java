package Economia.Tramite110207;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110207.MainPage110207;
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

public class MainPage110207Test {
    MainPage110207 mainPage110207 = new MainPage110207();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110207  = new TramitesFirmasLG(
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
    public void Proceso110207() throws IOException {
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


            loginFirmSoli.login(tramite110207); sleep(1000);
            mainPage110207.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110207.btnacep.click(); sleep(1000);
            mainPage110207.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110207.SoliNew.click(); sleep(1000);
            mainPage110207.Economia.click(); sleep(1000);
            mainPage110207.CertOrigen.click(); sleep(1000);
            mainPage110207.ValidacionCertificado.click(); sleep(1000);
            mainPage110207.elementoTramite110207.click(); sleep(1000);

            //Datos de la mercancia
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            mainPage110207.TituloPrincipal.scrollTo().shouldBe(visible);
            mainPage110207.tabCertificadoOrigen.click();

            mainPage110207.TratadoAcuerdo.sendKeys("Sistema Generalizado de Preferencias");
            mainPage110207.PaisBloque.sendKeys("JAPON");
            mainPage110207.btnBuscarmercancia.click();
            mainPage110207.filaMercanciaDisponible.doubleClick();
            //mainPage110207.TituloPrincipal.scrollTo().shouldBe(visible);

            //Agregar datos Mercancia
            mainPage110207.MarcaMercancia.sendKeys("Marca QA");
            mainPage110207.Cantidad.sendKeys("24");
            mainPage110207.selectUMC.sendKeys("Kilogramo");
            mainPage110207.ValorMercancia.sendKeys("1000");
            mainPage110207.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage110207.fechaFactura);
            mainPage110207.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110207.selectTipoFactura.sendKeys("Manual");
            mainPage110207.btnAgregarDatosMercancia.click();
            mainPage110207.btnAceptarNotficacionAgrMercancia.click();

            //Tab Destinatario
            mainPage110207.tabDestinatario.click();
            //Datos del destinatario
            mainPage110207.RFCDestinatario.sendKeys("QALA971201177");
            mainPage110207.RazonSocialDestinatario.sendKeys("Razon social QA");
            //Domicilio del destinatario
            mainPage110207.CiudadDestinatario.sendKeys("Osaka");
            mainPage110207.CalleDestinatario.sendKeys("Calle QA");
            mainPage110207.NumeroLetraDestinatario.sendKeys("549");
            mainPage110207.LadaDestinatario.sendKeys("06");
            mainPage110207.TelefonoDestinatario.sendKeys("0639000019");
            mainPage110207.FaxDestinatario.sendKeys("0639018010");
            mainPage110207.CorreoDestinatario.sendKeys("qacorreo@gmail.com");
            mainPage110207.selectPaisDestino.selectOption("JAPON");
            //Detalles del transporte
            mainPage110207.selectMedioTransporte.sendKeys("Aéreo");
            mainPage110207.RutaCompleta.sendKeys("Ruta QA translado");
            mainPage110207.PuertoEmbarque.sendKeys("Tokio");
            mainPage110207.PuertoDesembarque.sendKeys("Osaka");


            //Datos certificado
            mainPage110207.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110207.tabDatosCertificado.click();
            mainPage110207.Observaciones.sendKeys("QA Observaciones");
            mainPage110207.selectIdioma.sendKeys("English");
            //Representación federal
            mainPage110207.selectEstado.sendKeys("SINALOA");
            mainPage110207.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110207);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110207.folio.getText();

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

