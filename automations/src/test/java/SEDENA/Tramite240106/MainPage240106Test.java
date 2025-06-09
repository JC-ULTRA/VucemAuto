package SEDENA.Tramite240106;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240106.MainPage240106;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240106Test {
    MainPage240106 mainPage240106 = new MainPage240106();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240106  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso240106() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240106);
            mainPage240106.selecRol.sendKeys("Persona Moral");
            mainPage240106.btnacep.click();
            mainPage240106.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240106.SoliNew.click();
            mainPage240106.SEDENA.click();
            mainPage240106.linkCerLicPer.click();
            mainPage240106.linkPermisoAduanalSEDENA.click();
            mainPage240106.elementoTramite240106.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240106.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240106.labelDatosSolicitud.click();
            mainPage240106.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240106.inputAddOrigenLista.click();
            mainPage240106.inputUsoFinalMercancia.sendKeys("PRUEBA");

            //Agregar mercancía
            mainPage240106.btnAgregarMercancia.click();
            //Datos mercancía
            mainPage240106.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240106.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240106.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240106.inputValorComercialMercancia.sendKeys("1234");
            mainPage240106.selectUMCMercancia.sendKeys("Caja");
            mainPage240106.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240106.btnAgregarMercancia2.click();

            //Manifiesto
            mainPage240106.checkManifiesto.click();

            //Pestaña de terceros
            mainPage240106.Scrol.scrollTo();
            mainPage240106.labelTercerosRelacionados.click();
            //Destinatario (destino final)
            mainPage240106.btnAgregarDestinatario.click();
            mainPage240106.inputExtranjera.click();
            mainPage240106.inputFisica.click();;
            mainPage240106.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240106.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240106.inputTercerosApellidoMaterno.sendKeys("CHACON");
            //Domicilio
            mainPage240106.selectPais.sendKeys("ARGENTINA (REPUBLICA)");
            mainPage240106.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240106.inputTercerosCP.sendKeys("23456");
            mainPage240106.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240106.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240106.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240106.inputTercerosLada.sendKeys("52");
            mainPage240106.inputTercerosTelefono.sendKeys("23456257");
            mainPage240106.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240106.btnGuardarTerceros.click();

            //Proveedor
            mainPage240106.btnAgregarProveedor.click();
            mainPage240106.inputFisica.click();
            mainPage240106.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240106.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240106.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            //Domicilio
            mainPage240106.selectPais.selectOption("COLOMBIA (REPUBLICA DE)");
            mainPage240106.EstadoProveedor.sendKeys("COLIMA");
            mainPage240106.inputTercerosCP.sendKeys("28006");
            mainPage240106.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240106.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240106.inputTercerosNumeroInt.sendKeys("321");
            mainPage240106.inputTercerosLada.sendKeys("52");
            mainPage240106.inputTercerosTelefono.sendKeys("234565432");
            mainPage240106.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            //Guardar terceros
            mainPage240106.btnGuardarTerceros.click();

            //Pestaña Pago de Derechos
            mainPage240106.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240106.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240106.inputCadenaDependencia.setValue(factura.toString());
            mainPage240106.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240106.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240106.inputCalendar);sleep(100);
            mainPage240106.inputImportePago.sendKeys("5000");
            mainPage240106.InputGuardarSolicitud.click();
            mainPage240106.btnContinuar.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage240106.btmAnexar.click();sleep(1000);
            mainPage240106.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            mainPage240106.btnCerrar.click();
            Selenide.sleep(1000);
            mainPage240106.inputSiguiente.click();sleep(1000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240106);
            Selenide.sleep(2000);
            String folioText = mainPage240106.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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
}