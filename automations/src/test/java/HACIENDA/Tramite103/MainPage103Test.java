package HACIENDA.Tramite103;

import Metodos.Metodos;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage103Test {
    MainPage103 mainPage103 = new MainPage103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite103  = new TramitesFirmasLG(
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
    public void Proceso103() throws IOException {
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

            loginFirmSoli.login(tramite103); sleep(1000);
            mainPage103.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage103.btnacep.click(); sleep(1000);
            mainPage103.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage103.SoliNew.click(); sleep(1000);
            mainPage103.Hacienda.click();
            mainPage103.AutorizacionesImporExpor.click();
            mainPage103.ExcencionImpuestosMercaDonada.click();
            mainPage103.elementoTramite103.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage103.Scrol.scrollTo();
            //Pestaña Exención impuestos
            mainPage103.tabDatosInmueble.click();
            //Manifiesto
            mainPage103.checkManifiestoMercancia.click();
            //Aduana
            mainPage103.selectAduana.selectOption("AEROPUERTO INTERNACIONAL FELIPE ÁNGELES");
            mainPage103.checkOrganismoPublico.click();

            //Agregar Mercancía
            mainPage103.selectFinDestinoMercancia.selectOption("Investigación");
            mainPage103.btnAgregarMercancia.click();
            //Datos mercancía
            mainPage103.TipoMercancia.sendKeys("Mercancía motores");
            mainPage103.UsoEspecifico.sendKeys("Industría autos");
            mainPage103.selectCondicion.selectOption("Usado");
            mainPage103.Cantidad.sendKeys("1000");
            mainPage103.UnidadMedida.sendKeys("Pieza");
            mainPage103.checkVehiculo.click();
            mainPage103.Marca.sendKeys("QA Marca motor");
            mainPage103.selectAno.selectOption("2023");
            mainPage103.Modelo.sendKeys("Motores de combustión interna");
            mainPage103.NumSerie.sendKeys("12394");
            mainPage103.btnAgregarInfMercancia.click();
            mainPage103.btnAceptarMercancia.click();

            //Datos del donante extranjero
            mainPage103.NombreDonante.sendKeys("Ekaterina Belova Belyaeva");
            mainPage103.checkPersonaFisicaDonante.click();
            mainPage103.selectPaisDonante.selectOption("RUSIA (FEDERACION RUSA)");
            mainPage103.CodigoPostalDonante.sendKeys("101000");
            mainPage103.EstadoDonante.sendKeys("Moscú");
            mainPage103.CalleDonante.sendKeys("PRUEBA Estocolmo");
            mainPage103.NumExteriorDonante.sendKeys("1");
            mainPage103.NumInteriorDonante.sendKeys("9");
            mainPage103.ColoniaDonante.sendKeys("Colonia QA");
            mainPage103.CorreoDonante.sendKeys("merc@hotmail.com");
            mainPage103.TelefonoDonante.sendKeys("7238440157");
            // Continuar paso 1
            mainPage103.btnContinuarPaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage103.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage103.btnAnexar.click();
            mainPage103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30)); sleep(1000);
            mainPage103.btnCerrar.click();
            mainPage103.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite103);sleep(3000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage103.folio.getText();

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