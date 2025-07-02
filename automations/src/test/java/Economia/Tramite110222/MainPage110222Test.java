package Economia.Tramite110222;

import DBYFOLIO.ObtenerFolio;
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
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110222Test {
    MainPage110222 mainPage110222 = new MainPage110222();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110222  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }


    @Test
    public void Proceso110222() throws IOException {
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

            // Ingreso y Rol
            loginSoli.login(tramite110222); sleep(1000);
            mainPage110222.selecRol.selectOption("Persona Moral");
            mainPage110222.btnacep.click(); sleep(1000);

            //Selección tramite
            mainPage110222.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110222.SoliNew.click(); sleep(1000);
            mainPage110222.Economia.click(); sleep(1000);
            mainPage110222.CertOrigen.click(); sleep(1000);
            mainPage110222.ValidacionCertificado.click(); sleep(1000);
            mainPage110222.elementoTramite110222.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage110222.Scrol.scrollTo();
            //Pestaña Certificado de origen
            mainPage110222.tabCertificadoOrigen.click();
            //Validación inicial del certificado de circulación de mercancías
            mainPage110222.checkTercerOperador.click();
            //Datos tercer operador
            mainPage110222.TercerOperadorNombre.sendKeys("Alicia");
            mainPage110222.TercerOperadorApellidoP.sendKeys("Perez");
            mainPage110222.TercerOperadorApellidoM.sendKeys("Duran");
            mainPage110222.TercerOperadorNumeroFiscal.sendKeys("AFC000526BJ2");
            //Domicilio del tercer operador
            mainPage110222.TercerOperadorCalle.sendKeys("Yojuin");
            mainPage110222.TercerOperadorNumLetra.sendKeys("23");
            mainPage110222.TercerOperadorCiudad.sendKeys("Tokyo");
            mainPage110222.selectTercerOperadorPais.selectOption("JAPON");
            mainPage110222.TercerOperadorCorreo.sendKeys("OperadorQA@gmail.com");
            mainPage110222.TercerOperadorTelefono.sendKeys("3456590223");
            mainPage110222.TercerOperadorFax.sendKeys("3456283223");

            //Tratado y país bloque
            mainPage110222.selectTratadoAcuerdo.selectOption("Acuerdo Alianza del Pacífico");
            mainPage110222.selectPaisBloque.sendKeys("PERU (REPUBLICA DEL)");
            mainPage110222.btnBuscarmercancias.click(); sleep(1000);

            //Grid Mercancias disponibles
            mainPage110222.gridMercanciaDisponible1.doubleClick();
            //Agregar datos Mercancia
            mainPage110222.Cantidad.sendKeys("199");
            mainPage110222.selectUMC.sendKeys("Kilogramo");
            mainPage110222.ValorMercancia.sendKeys("6000");
            mainPage110222.ComplementoDescripcion.sendKeys("QA Descripción");
            Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110222.fechaFactura, fechaHoy);sleep(1000);
            mainPage110222.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110222.selectTipoFactura.selectOption("Electrónica");
            mainPage110222.NumSerie.sendKeys("23844");
            mainPage110222.btnAgregarDatosMercancia.click();
            mainPage110222.btnAceptarNotficacionAgrMercancia.click();

            //Pestaña Histórico productores
            mainPage110222.tabHistoricoProductores.click();
            //Histórico productores
            mainPage110222.checkDatosProductorNoConfidencial.click();
            mainPage110222.checkExpImpNoMismaPersona.click();
            //Grid Productores por exportador
            mainPage110222.fila1Productor.click();
            mainPage110222.btnSeleccionarAgrProductor.click();

            //grid Mercancías seleccionadas
            mainPage110222.fila1ProductorSeleccionado.scrollTo();
            mainPage110222.fila1MercanciasSeleccionada.click();
            mainPage110222.btnAsignarProductor.click();
            //Asignación productor a mercancía
            mainPage110222.NumRegistroFederal.sendKeys("&CJ060729FG5");
            mainPage110222.btnAsignar.click();

            //Pestaña de destinatario
            mainPage110222.Scrol.scrollTo();
            mainPage110222.tabDestinatario.click();
            //Datos del destinatario
            mainPage110222.NombreDestinatario.sendKeys("Alejandro Lopez Rodriguez");
            mainPage110222.RFCDestinatario.sendKeys("ALL0409235E6");
            //Domicilio del destinatario
            mainPage110222.CalleDestinatario.sendKeys("Calle QA");
            mainPage110222.NumeroLetraDestinatario.sendKeys("900");
            mainPage110222.CiudadDestinatario.sendKeys("Ciudad QA");
            mainPage110222.TelefonoDestinatario.sendKeys("0829860830");
            mainPage110222.FaxDestinatario.sendKeys("0820011448");
            mainPage110222.CorreoDestinatario.sendKeys("qacorreoDestinatario@gmail.com");
            //Detalles del representante legal del exportador
            mainPage110222.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110222.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            mainPage110222.EmpresaRepresentante.sendKeys("Empresa QA representante");
            mainPage110222.CargoRepresentante.sendKeys("Jefe departamento QA");
            mainPage110222.NumRegistroFiscalRepresentante.sendKeys("LEQI8101314S7");
            mainPage110222.CorreoRepresentante.sendKeys("representanteQA@gmail.com");
            mainPage110222.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110222.FaxRpresentante.sendKeys("5548795678");

            //Pestaña Datos del certificado
            mainPage110222.Scrol.scrollTo();
            mainPage110222.tabDatosCertificado.click();
            //Datos del certificado
            mainPage110222.Observaciones.sendKeys("Observaciones QA");
            //Representación Federal
            mainPage110222.selectEstado.selectOption("SINALOA");
            mainPage110222.selectRrepreFederal.selectOption("CULIACAN");

            //Continuar paso 1
            mainPage110222.btnContinuarPaso1.click();

            //Paso 2 FIRMAR SOLICITUD
            loginSoli.firma(tramite110222);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110222.folio.getText();

            // Llamar al metodo para obtener el folio
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

