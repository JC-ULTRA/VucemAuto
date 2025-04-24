package Economia.Tramite110205;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110204.MainPage110204;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110205Test {
    MainPage110205 mainPage110205 = new MainPage110205();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110205  = new TramitesFirmasLG(
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
    public void Proceso110205() throws IOException {
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

            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            loginFirmSoli.login(tramite110205); sleep(1000);
            mainPage110205.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110205.btnacep.click(); sleep(1000);
            mainPage110205.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110205.SoliNew.click(); sleep(1000);
            mainPage110205.Economia.click(); sleep(1000);
            mainPage110205.CertOrigen.click(); sleep(1000);
            mainPage110205.ValidacionCertificado.click(); sleep(1000);
            mainPage110205.elementoTramite110205.click(); sleep(1000);


            // Seccion Certificado origen
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110205.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110205.tabCertificadoOrigen.click();

            mainPage110205.TratadoAcuerdo.sendKeys("Acuerdo Mexico-Perú");
            mainPage110205.PaisBloque.selectOption("PERU (REPUBLICA DEL)");
            mainPage110205.btnBuscarmercancia.click();
            mainPage110205.filaMercanciaDisponible.doubleClick();

            //Agregar datos Mercancia
            mainPage110205.Cantidad.sendKeys("90");
            mainPage110205.selectUMC.sendKeys("Kilogramo");
            mainPage110205.ValorMercancia.sendKeys("4500");
            mainPage110205.ComplementoDescripcion.sendKeys("QA Descripcion");
            Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110205.fechaFactura, fechaHoy);sleep(1000);
            mainPage110205.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110205.selectTipoFactura.sendKeys("Manual");
            mainPage110205.btnAgregarDatosMercancia.click();
            mainPage110205.btnAceptarNotficacionAgrMercancia.click();

            //Seccion Historico Productores
            //mainPage110205.TituloPrincipal.scrollTo().shouldBe(visible);
            mainPage110205.tabHistoricoProductores.click();
            mainPage110205.checkDatosProductorNoConfidencial.click();
            mainPage110205.checkExpImpNoMismaPersona.click();
            //Grid Productores por exportador
            mainPage110205.fila1Productor.click();
            mainPage110205.btnSeleccionarAgrProductor.click();
            mainPage110205.fila1ProductorSeleccionado.click();
            mainPage110205.fila1MercanciasSeleccionada.click();
            mainPage110205.fila1ProductorSeleccionado.scrollTo().shouldBe(visible);
            mainPage110205.btnAsignarProductor.click();
            //Sección Destinatario
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110205.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110205.tabDestinatario.click();
            //Datos del destinatario
            mainPage110205.RFCDestinatario.sendKeys("AAIJ891102208");
            mainPage110205.RazonSocialDestinatario.sendKeys("Razón social QA");
            //Domicilio del destinatario
            mainPage110205.CiudadDestinatario.sendKeys("Perú");
            mainPage110205.CalleDestinatario.sendKeys("Calle QA");
            mainPage110205.NumeroLetraDestinatario.sendKeys("700");
            mainPage110205.TelefonoDestinatario.sendKeys("5187669840");
            mainPage110205.CorreoDestinatario.sendKeys("qacorreoUruguay@gmail.com");
            //Detalles del representante legal del exportador
            mainPage110205.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110205.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            mainPage110205.EmpresaRepresentante.sendKeys("Empresa QA representante");
            mainPage110205.CargoRepresentante.sendKeys("Jefe departamento QA");
            mainPage110205.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110205.CorreoRepresentante.sendKeys("representanteQA@gmail.com");

            //Datos certificado
            mainPage110205.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110205.tabDatosCertificado.click();
            mainPage110205.Observaciones.sendKeys("QA Observaciones");
            mainPage110205.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110205.selectEstado.sendKeys("SINALOA");

            mainPage110205.btnContinuar.click();

            //Firmado
            loginFirmSoli.firma(tramite110205);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110205.folio.getText();

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

