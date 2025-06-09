package SEDENA.Tramite240107;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240107.MainPage240107;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240107Test {
    MainPage240107 mainPage240107 = new MainPage240107();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240107  = new TramitesFirmasLG(
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
    public void Proceso240107() {
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

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240107);
            mainPage240107.selecRol.sendKeys("Persona Moral");
            mainPage240107.btnacep.click();
            mainPage240107.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240107.SoliNew.click();
            mainPage240107.SEDENA.click();
            mainPage240107.linkCerLicPer.click();
            mainPage240107.linkPermisoAduanalSEDENA.click();
            mainPage240107.elementoTramite240107.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240107.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240107.labelDatosSolicitud.click();
            mainPage240107.inputOrigenLista.sendKeys("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage240107.inputAddOrigenLista.click();
            mainPage240107.inputUsoFinalMercancia.sendKeys("PRUEBA Sustancias Químicas");
            mainPage240107.PermisoGeneral.sendKeys("Permiso QA 3932");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage240107.fechaEntrada, fechaHoy);

            //Agregar mercancia
            mainPage240107.btnAgregarMercancia.click();
            //Datos mercancía
            mainPage240107.inputDescripcionMercancia.sendKeys("PRUEBAS QA Aviso Sustancias");
            mainPage240107.inputFraccionArancelariaMercancia.sendKeys("28291103");
            mainPage240107.inputCantidadUMTMercancia.sendKeys("15");
            mainPage240107.inputValorComercialMercancia.sendKeys("54321");
            mainPage240107.selectUMCMercancia.sendKeys("Caja");
            mainPage240107.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240107.btnAgregarMercancia2.click();

            //Periodo
            mainPage240107.btnRad2TercerPeriodo.click();
            mainPage240107.checkAñoCurso.click();

            //Manifiesto
            mainPage240107.checkManifiesto.click();

            //Pestaña de terceros
            mainPage240107.Scrol.scrollTo();
            mainPage240107.labelTercerosRelacionados.click();
            //Destinatario (destino final)
            mainPage240107.btnAgregarDestinatario.click();
            mainPage240107.inputExtranjera.click();
            mainPage240107.inputFisica.click();;
            mainPage240107.inputTercerosNombre.sendKeys("Sergio");
            mainPage240107.inputTercerosApellidoPaterno.sendKeys("Maradona");
            mainPage240107.inputTercerosApellidoMaterno.sendKeys("Chacon");
            //Domicilio
            mainPage240107.selectPais.sendKeys("ESTADOS UNIDOS DE AMERICA");
            mainPage240107.inputTercerosEstado.sendKeys("California");
            mainPage240107.inputTercerosCP.sendKeys("95603");
            mainPage240107.inputTercerosCalle.sendKeys("Manzanita");
            mainPage240107.inputTercerosNumeroExt.sendKeys("234");
            mainPage240107.inputTercerosNumeroInt.sendKeys("2");
            mainPage240107.inputTercerosLada.sendKeys("1");
            mainPage240107.inputTercerosTelefono.sendKeys("1916372834");
            mainPage240107.inputTercerosCorreoElec.sendKeys("pruebaDestino@test.com");
            mainPage240107.btnGuardarTerceros.click();

            //Proveedor
            mainPage240107.btnAgregarProveedor.click();
            mainPage240107.inputFisica.click();
            mainPage240107.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240107.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240107.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            //Domicilio
            mainPage240107.selectPais.selectOption("COLOMBIA (REPUBLICA DE)");
            mainPage240107.EstadoProveedor.sendKeys("COLIMA");
            mainPage240107.inputTercerosCP.sendKeys("28006");
            mainPage240107.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240107.inputTercerosNumeroExt.sendKeys("79");
            mainPage240107.inputTercerosNumeroInt.sendKeys("1");
            mainPage240107.inputTercerosLada.sendKeys("57");
            mainPage240107.inputTercerosTelefono.sendKeys("5764565432");
            mainPage240107.inputTercerosCorreoElec.sendKeys("pruebasProveedor@test.com");
            //Guardar terceros
            mainPage240107.btnGuardarTerceros.click();
            mainPage240107.InputGuardarSolicitud.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage240107.btnContinuar.click();sleep(1000);

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage240107.btmAnexar.click();sleep(1000);
            mainPage240107.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            mainPage240107.btnCerrar.click();
            Selenide.sleep(1000);
            mainPage240107.inputSiguiente.click();sleep(1000);

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240107);
            Selenide.sleep(2000);
            String folioText = mainPage240107.folio.getText();sleep(5000);
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