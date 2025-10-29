package AMECAFE.Tramite290201;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage290201Test {
    MainPage290201 mainPage290201 = new MainPage290201();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite290201  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
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
    public void Proceso290201() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            //Lote aleatorio
            Random rand = new Random();
            String NumLoteValor = String.valueOf(rand.nextInt(1000));

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite290201);
            mainPage290201.selecRol.sendKeys("Persona Moral");
            mainPage290201.btnacep.click();
            //Búsqueda de tramite
            mainPage290201.Tramites.sendKeys("Solicitudes nuevas");
            mainPage290201.SoliNew.click();
            mainPage290201.AMECAFE.click();
            mainPage290201.CerificadosLicenciaPermisos.click();
            mainPage290201.CertificadoOrigen.click();
            mainPage290201.Tramite290201.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage290201.Scrol.scrollTo();
            //Pestaña Datos de la solicitud
            mainPage290201.labelDatosSolicitud.click();
            //Información del cáfe
            mainPage290201.selectFormaCafe.sendKeys("Café Chiapas (Tostado)");
            mainPage290201.selectTipos.sendKeys("ARÁBICA");
            mainPage290201.selectCalidad.sendKeys("ALTURA");
            mainPage290201.selectProcesos.sendKeys("CONVENCIONAL");
            //Destino
            mainPage290201.selectSolicitudClaveAduana.selectOption("TECATE");
            mainPage290201.selectSolicitudPaisProcedenciaClave.selectOption("JAPON");
            //Procedencia
            mainPage290201.selectSolicitudEntidadesEntidadClave.selectOption("OAXACA");
            //Ciclo cafetalero
            mainPage290201.selectSolicitudDescripcionGenerica.selectOption("2021/2022");


            //Lotes
            //Agregar lote
            mainPage290201.inputAgregarLote.click();
            //Datos del café
            mainPage290201.selectGenerica.selectOption("Contenedor");
            mainPage290201.selectAceptada.selectOption("Si");
            //Si: Café materia prima
            mainPage290201.CantidadUtilizadaElaborar.sendKeys("1000");
            mainPage290201.NumPedimento.sendKeys("3828");
            mainPage290201.selectPaisImportacion.selectOption("COLOMBIA (REPUBLICA DE)");
            mainPage290201.selectFraccion.selectOption("21013001");
            //Factura y Cantidad
            mainPage290201.inputCantidadUmc.sendKeys("2000");
            mainPage290201.selectUnidadMedidaComercialClave.selectOption("Kilogramo");
            mainPage290201.inputMercanciasImporteTotalComponente.sendKeys("50");
            mainPage290201.selectMonedaClave.selectOption("Mexican Peso");
            //Marcas
            mainPage290201.inputNumeroLote.sendKeys(NumLoteValor);
            mainPage290201.inputDescripcionMercancia.sendKeys("QA Otras Marcas");
            //Características Especiales
            mainPage290201.selectBooleanGenerico.selectOption("SI");
            mainPage290201.checkCafeEspecial.click();
            mainPage290201.checkNespresso.click();
            executeJavaScript("arguments[0].value = arguments[1];", mainPage290201.inputFechaSalida, fechaHoy);

            //Transbordo
            mainPage290201.selectCondicionAlmacenamientoSecundario.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
            mainPage290201.selectGenerica2.selectOption("VIA AEREA");
            mainPage290201.inputMarcasEmbarque.sendKeys("AE365");

            //Observaciones
            mainPage290201.textareaDescripcionTratamiento.sendKeys("Descripción QA");
            mainPage290201.inputAgregarLote2.click();

            //Pestaña Terceros relacionados
            mainPage290201.Scrol.scrollTo();
            mainPage290201.tabTercerosRelacionados.click();

            //Agregar destinatario
            mainPage290201.btnAgregarDestinatario.click();
            //Tipo de persona
            mainPage290201.radbtnPersonaMoral.click();
            //Tipo de persona moral
            mainPage290201.DenominacionTerceros.sendKeys("Denomiación QA");
            //Datos generales
            mainPage290201.TercerosDomicilio.sendKeys("162-1070 Takakadocho Hiroshima");
            mainPage290201.selectTercerosPais.selectOption("JAPON");
            mainPage290201.selectTercerosCodPostal.sendKeys("73001");
            mainPage290201.inputTercerosTelefono.sendKeys("1720351661");
            mainPage290201.inputTercerosCorreoElec.sendKeys("DestinatarioQA@gmail.com");
            mainPage290201.buttonGuardarDatosTercero.click();

            //Continuar paso 1
            mainPage290201.btnContinuarPaso1.click();

            //Paso 2 FIRMA SOLICITUD
            loginFirmSoli.firma(tramite290201);sleep(3000);
//            String folioText = mainPage290201.folio.getText();
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
}, repeticiones);
        }


//Metodo que ejecuta n veces una clase que implementa Runnable
public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
    for (int i = 0; i < n; i++) {
        System.out.println("Ejecución del Proceso: " + (i + 1));
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        proceso.run();  // Ejecuta el proceso de la clase
    }
}

public void clickOkButton() {
    // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
    $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
}
public void clickAceptarButton() {
    // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
    $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
}

public void scrollIncremento() {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    for (int i = 0; i < 1; i++){
        js.executeScript("window.scrollBy(0,500);");
        sleep(500);
    }
}
public void scrollDecremento() {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
    for (int i = 0; i < 10; i++){
        js.executeScript("window.scrollBy(0,-500);");
        sleep(200);
    }
}
}

