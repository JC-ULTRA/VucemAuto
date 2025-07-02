package SEDENA.Tramite240305;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240305.MainPage240305;
import com.codeborne.selenide.*;
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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240305Test {
    MainPage240305 mainPage240305 = new MainPage240305();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240305  = new TramitesFirmasLG(
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
    public void Proceso240305() {
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

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);

//
            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite240305);
            mainPage240305.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage240305.btnacep.click();sleep(1000);

            //Búsqueda de tramite Subsecuente
            mainPage240305.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage240305.SoliSub.click();
            mainPage240305.FolioTramite.sendKeys(FolioTramiteN);
            mainPage240305.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage240305.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Solicitar Modificación y Prórroga
            mainPage240305.btnSolModificar.click();

            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240305.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240305.labelDatosSolicitud.click();
            mainPage240305.Justificacion.setValue("QA");
            mainPage240305.btnRestarOrigenTodos.click();
            mainPage240305.inputOrigenLista.selectOption("OJINAGA");
            mainPage240305.inputAddOrigenLista.click();
            mainPage240305.PermisoGeneral.setValue("Permiso QA Modificación");
            mainPage240305.inputUsoFinalMercancia.setValue("PRUEBA Uso Modificación");

            //Pestaña de terceros
            mainPage240305.Scrol.scrollTo();
            mainPage240305.labelTercerosRelacionados.click();
            //Destinatario (destino final)
            mainPage240305.gridDestinatario1.click();
            mainPage240305.btnModificarDestinatario.click();
            mainPage240305.inputExtranjera.click();
            mainPage240305.inputFisica.click();;
            mainPage240305.inputTercerosNombre.setValue("Ekaterina");
            mainPage240305.inputTercerosApellidoPaterno.setValue("Belova");
            mainPage240305.inputTercerosApellidoMaterno.setValue("Belyaeva");
            //Domicilio
            mainPage240305.selectPais.selectOption("RUSIA (FEDERACION RUSA)");
            mainPage240305.inputTercerosEstado.setValue("Moscú");
            mainPage240305.inputTercerosCP.setValue("101000");
            mainPage240305.inputTercerosCalle.setValue("PRUEBA Estocolmo");
            mainPage240305.inputTercerosNumeroExt.setValue("234");
            mainPage240305.inputTercerosNumeroInt.setValue("1");
            mainPage240305.inputTercerosLada.setValue("7");
            mainPage240305.inputTercerosTelefono.setValue("7238440157");
            mainPage240305.inputTercerosCorreoElec.setValue("pruebaCorreoModificacion@test.com");
            mainPage240305.btnGuardarTerceros.click();

            //Proveedor
            mainPage240305.gridProveedor1.click();
            mainPage240305.btnModificarProveedor.click();
            mainPage240305.inputFisica.click();
            mainPage240305.inputTercerosNombre.setValue("Kelly");
            mainPage240305.inputTercerosApellidoPaterno.setValue("Ortiz");
            mainPage240305.inputTercerosApellidoMaterno.setValue("Nelson");
            //Domicilio
            mainPage240305.selectPais.selectOption("ESTADOS UNIDOS DE AMERICA");
            mainPage240305.EstadoProveedor.setValue("San Diego");
            mainPage240305.inputTercerosCP.setValue("91911");
            mainPage240305.inputTercerosCalle.setValue("PRUEBA San Diego Calle");
            mainPage240305.inputTercerosNumeroExt.setValue("44");
            mainPage240305.inputTercerosNumeroInt.setValue("3");
            mainPage240305.inputTercerosLada.setValue("610");
            mainPage240305.inputTercerosTelefono.setValue("6193565432");
            mainPage240305.inputTercerosCorreoElec.setValue("pruebasModificacion@test.com");
            //Guardar terceros
            mainPage240305.btnGuardarTerceros.click();

            //Pestaña Pago de Derechos
            mainPage240305.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240305.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240305.inputCadenaDependencia.setValue(factura.toString());
            mainPage240305.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240305.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240305.inputCalendar);sleep(100);
            mainPage240305.inputImportePago.sendKeys("5000");
            mainPage240305.InputGuardarSolicitud.click();
            mainPage240305.btnContinuar.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage240305.btmAnexar.click();sleep(1000);
            mainPage240305.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            mainPage240305.btnCerrar.click();
            Selenide.sleep(1000);
            mainPage240305.inputSiguiente.click();sleep(1000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240305);
            Selenide.sleep(2000);
            String folioText = mainPage240305.folio.getText();sleep(5000);
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