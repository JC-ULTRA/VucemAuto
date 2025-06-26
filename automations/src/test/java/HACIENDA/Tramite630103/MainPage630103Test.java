package HACIENDA.Tramite630103;
import Metodos.Metodos;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite630103.MainPage630103;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage630103Test {

    MainPage630103 mainPage630103 = new MainPage630103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos ();

    TramitesFirmasLG tramite630103  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
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
    public void Proceso630103() throws IOException {
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

            // Obtener la fecha de (hoy) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite630103);
            mainPage630103.selecRol.sendKeys("Persona Moral");
            mainPage630103.btnacep.click();

            //Búsqueda de tramite
            mainPage630103.Tramites.click();
            mainPage630103.SoliNew.click();
            mainPage630103.Hacienda.click();
            mainPage630103.ImportacionMercanciaSinPedimento.click();
            mainPage630103.Autorizacion.click();
            mainPage630103.elementoTramite630103.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage630103.Scrol.scrollTo();
            //Datos generales Original
            mainPage630103.tabDatosSolicitud.click();
            //Datos de la solicitud
            mainPage630103.selectAduanaIngreso.selectOption("470 - AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage630103.selectSeccionAduanera.selectOption("472 - CTO. POSTAL MECANIZADO, POR VIA POSTAL Y POR TRAFICO AEREO, AEROPUERTO INT. BENITO JUAREZ DE LA CD. DE MEXICO.");
            //Fecha de importación
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630103.fechaEstimadaIngreso, fechaHoy);
            //Tipo propietario
            mainPage630103.selectPropietario.selectOption("No");
            //No propietario
            mainPage630103.selectTipoPropietario.selectOption("Persona Moral Extranjero");
            //Propietario Moral extranjero
            mainPage630103.PropietarioDenominacion.sendKeys("QA denominación extranjero");
            mainPage630103.PropietarioCalle.sendKeys("Calle QA Nagoya");
            mainPage630103.PropietarioNumExterior.sendKeys("67");
            mainPage630103.PropietarioNumInterior.sendKeys("5");
            mainPage630103.selectPropietarioPais.selectOption("JAPON");
            mainPage630103.PropietarioLocalidad.sendKeys("Tokio");
            mainPage630103.PropietarioCorreoElec.sendKeys("Extranjero.Japon@hotmail.com");
            mainPage630103.PropietarioTelefono.sendKeys("811347954");
            mainPage630103.PropiedadCodPostal.sendKeys("0014");

            //Datos de la mercancía que se importará al país temporalmente
            mainPage630103.DescripcionMercancia.sendKeys("QA información Descripción");
            mainPage630103.MotivacionMercancia.sendKeys("QA información Motivo"); sleep(1000);
            mainPage630103.DescripcionMercancia.scrollTo();
            mainPage630103.ListaMercancia.sendKeys("QA información Lista");

            //Manifiesto
            mainPage630103.checkManifiesto.click();

            //Continuar Paso 1
            mainPage630103.btnContinuarPaso1.click();

            //PASO 2 REQUISITOS NECESARIOS
            mainPage630103.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage630103.btnAdjuntar2.click();
            mainPage630103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60)); sleep(1000);
            mainPage630103.btnCerrar3.click();
            mainPage630103.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite630103);sleep(3000);

            // Obtener el texto del folio
            String folioText = mainPage630103.folio.getText();
            //Llamar al metodo para obtener el folio
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
