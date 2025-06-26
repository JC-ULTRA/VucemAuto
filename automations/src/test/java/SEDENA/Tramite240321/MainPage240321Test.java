package SEDENA.Tramite240321;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240321Test {
    MainPage240321 mainPage240321 = new MainPage240321();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240321 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso240321() {
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
        ejecutarProcesoNRunnable(() -> {
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite240321);
            mainPage240321.selecRol.sendKeys("Persona Moral");
            mainPage240321.btnacep.click();
            mainPage240321.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage240321.SoliSub.click();
            mainPage240321.inputIdFolio.sendKeys("0602400102120254011000004");
            mainPage240321.inputBuscarButton.click();
            sleep(1000);
            mainPage240321.SolicitudTramite.doubleClick();
            mainPage240321.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240321.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage240321.labelDatosSolicitud.click();
            mainPage240321.inputJustificacion.sendKeys("RE-TESTING");
            mainPage240321.inputSelectOrigen.sendKeys("ALTAMIRA");
            mainPage240321.inputRestarOrigen.click();
            mainPage240321.inputOrigenLista.sendKeys("DOS BOCAS");
            mainPage240321.inputAddOrigenLista.click();
            mainPage240321.inputPermisoGeneral.setValue("PRUEBAS MODIFICACION");
            mainPage240321.inputUsoFinalMercancia.setValue("PRUEBA MODIFICACION");
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240321.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240321.labelTercerosRelacionados.click();
            mainPage240321.chekboxDestinatario.click();
            mainPage240321.btnModificarDestinatario.click();
            //mainPage240321.inputNacional.click();
            //mainPage240321.inputFisica.click();
            mainPage240321.inputTercerosNombre.setValue("REGINO");
            mainPage240321.inputTercerosApellidoPaterno.setValue("RENEGADO");
            mainPage240321.inputTercerosApellidoMaterno.setValue("REYES");
            mainPage240321.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240321.terceroEstadoLocalidad.setValue("PRUEBA");
            mainPage240321.terceroCodigoPostal.setValue("00000");
            mainPage240321.terceroCalle.setValue("Eje Central Lázaro Cárdenas");
            mainPage240321.terceroNumExterior.setValue("123");
            mainPage240321.terceroNumInterior.setValue("4B");
            mainPage240321.inputLada.setValue("52");
            mainPage240321.terceroTelefono.setValue("5555555555");
            mainPage240321.terceroCorreo.setValue("contacto@fabricante.com");
            mainPage240321.btnGuardarTerceros.click();
            mainPage240321.chekboxProveedor.click();
            mainPage240321.btnModificarProveedor.click();
            //mainPage240321.inputFisica.click();
            mainPage240321.inputTerceroRFC.setValue("MAVL621207C95");
            mainPage240321.inputTercerosNombre.setValue("REGINO");
            mainPage240321.inputTercerosApellidoPaterno.setValue("RENEGADO");
            mainPage240321.inputTercerosApellidoMaterno.setValue("REYES");
            mainPage240321.inputTercerosEstado2.sendKeys("GUERRERO");
            mainPage240321.inputTercerosMunicipio.sendKeys("AZOYU");
            mainPage240321.inputTercerosLocalidad.sendKeys("BANCO DE ORO");
            mainPage240321.inputTercerosCP2.sendKeys("41909");
            mainPage240321.inputTercerosColonia.sendKeys("CENTRO");
            mainPage240321.inputTercerosCalle.setValue("CONOCIDA");
            mainPage240321.inputTercerosNumeroExt.setValue("98765");
            mainPage240321.inputTercerosNumeroInt.setValue("345");
            mainPage240321.inputTercerosLada.setValue("55");
            mainPage240321.inputTercerosTelefono.setValue("76341298");
            mainPage240321.inputTercerosCorreoElec.setValue("modificacion_pruebas@test.com");
            mainPage240321.btnGuardarTerceros.click();

            mainPage240321.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240321.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240321.inputCadenaDependencia.setValue(factura.toString());
            mainPage240321.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240321.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240321.inputCalendar);sleep(100);
            mainPage240321.inputImportePago.sendKeys("5000");

            mainPage240321.InputGuardarSolicitud.click();
            mainPage240321.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240321.btmAnexar.click();sleep(8000);
            Selenide.sleep(4000);
            mainPage240321.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage240321.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240321);
            Selenide.sleep(2000);
            String folioText = mainPage240321.folio.getText();sleep(5000);
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