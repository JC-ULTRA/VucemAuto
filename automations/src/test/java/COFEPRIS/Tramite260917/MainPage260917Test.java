package COFEPRIS.Tramite260917;

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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260917Test {
    MainPage260917 mainPage260917 = new MainPage260917();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260917 = new TramitesFirmasLG(
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
    public void Proceso260917() {
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
            loginFirmSoli.login(tramite260917);
            mainPage260917.selecRol.sendKeys("Persona Moral");
            mainPage260917.btnacep.click();
            mainPage260917.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260917.SoliSub.click();
            mainPage260917.inputIdFolio.sendKeys("0402600201720254006000005");
            mainPage260917.inputBuscarButton.click();
            sleep(1000);
            mainPage260917.SolicitudTramite.doubleClick();
            mainPage260917.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260917.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260917.labelDatosSolicitud.click();
            Selenide.sleep(100);
            mainPage260917.inputModif.click();sleep(1000);
            Selenide.sleep(100);
            mainPage260917.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            //mainPage260917.inputRazonSocial.setValue("TSD931210493");
            mainPage260917.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage260917.inputEmail.setValue("contacto@empresa.com");
            mainPage260917.inputCodigoPostal.setValue("01000");
            mainPage260917.inputEstado.sendKeys("COLIMA");
            mainPage260917.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260917.inputLocalidad.setValue("Colonia Industrial");
            mainPage260917.inputColonia.setValue("Ampliación San Ángel");
            mainPage260917.inputCalle.setValue("Av. Revolución");
            mainPage260917.inputLada.setValue("52");
            mainPage260917.inputTelefono.setValue("12345678");
            mainPage260917.inputRegimen.sendKeys("Temporles");
            mainPage260917.inputAduana.sendKeys("ALTAMIRA");
            mainPage260917.checkBoxMercancia.click();
            mainPage260917.btnModificar.click();
            mainPage260917.selectClasificacionProducto.sendKeys("BIOLOGICOS");
            mainPage260917.selectSubClasificacionProducto.sendKeys("I. Toxoides, vacunas y preparaciones bacterianas de uso parenteral");
            mainPage260917.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260917.inputDenominacionDistintiva.setValue("Distintiva123");
            //mainPage260917.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260917.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260917.inputEspecifique.setValue("PRUEBA");
            //mainPage260917.selectFormaFarmaceutica.sendKeys("Emulsión");
            //mainPage260917.selectEstadoFisico.sendKeys("Liquido");
            //mainPage260917.inputFraccionArancelaria.setValue("13021999");
            mainPage260917.inputCantidadUMT.setValue("100");
            mainPage260917.inputCantidadUMC.setValue("10");
            mainPage260917.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            //mainPage260917.textareaPresentacion.setValue("Ampolleta");
            //mainPage260917.inputNumeroRegistroSanitario.sendKeys("1234");
            mainPage260917.buttonAbrirPanelPaisesOrigen.click();
            mainPage260917.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260917.inputAgregarSeleccion.click();
            mainPage260917.inputAbrirPanelPaisesProcedencia.click();
            mainPage260917.PaisProcedencia.sendKeys("ANGOLA");
//            mainPage260917.inputClaveLotes.setValue("1346");
//            executeJavaScript("arguments[0].value = '01/05/2025';", mainPage260917.inputFechaElaboracion);sleep(100);
//            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260917.inputFechaCaducidad);sleep(100);
            mainPage260917.btnModificarMercancia.click();
//            mainPage260917.inputRFC.setValue("MAVL621207C95");
//            mainPage260917.btnBuscarRFC.click();

            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260917.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260917.labelTerceros.click();
            mainPage260917.checkBoxFabricante.click();
            mainPage260917.btnModificarFabricante.click();
            mainPage260917.checkBoxMoral.click();
            mainPage260917.inputTerceroRFC.setValue("TSD931210493");
//            mainPage260917.btnBuscarEmpresa.click();
            mainPage260917.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
//            mainPage260917.inputPais.sendKeys("CANADA");
            mainPage260917.inputEstadoLocalidad.sendKeys("COLIMA");
            mainPage260917.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260917.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260917.inputCodigoPostalFabricante.sendKeys("28010");
            mainPage260917.terceroColoniaEquiv.sendKeys("ANTORCHA");
            mainPage260917.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260917.terceroNumExterior.setValue("13471118");
            mainPage260917.terceroNumInterior.setValue("4A");
            mainPage260917.inputTerceroLada.setValue("52");
            mainPage260917.terceroTelefono.setValue("5533335");
            mainPage260917.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260917.btnGuardarDatosTerceros.click();
            mainPage260917.checkBoxDestinatario.click();
            mainPage260917.btnModificarDestinatario.click();
            //mainPage260917.checkBoxMoral.click();
            mainPage260917.inputTerceroRFC.setValue("TQD931210493");
//            mainPage260917.btnBuscarEmpresa.click();
            mainPage260917.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage260917.inputEstadoLocalidad.sendKeys("COLIMA");
            mainPage260917.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260917.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260917.inputCodigoPostalFabricante.sendKeys("28010");
            mainPage260917.terceroColoniaEquiv.sendKeys("ANTORCHA");
            mainPage260917.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260917.terceroNumExterior.setValue("13471118");
            mainPage260917.terceroNumInterior.setValue("4A");
            mainPage260917.inputTerceroLada.setValue("52");
            mainPage260917.terceroTelefono.setValue("5533335");
            mainPage260917.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260917.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260917.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260917.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260917.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260917.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260917.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260917.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260917.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260917.inputCalendar);
            sleep(100);
            mainPage260917.inputSolicitudPagoImp.sendKeys("5000");
            mainPage260917.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260917.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260917.btnAnexar.click();sleep(4000);
            sleep(4000);
            mainPage260917.btnCerrar.click();
            sleep(100);
            mainPage260917.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260917);
            String folioText = mainPage260917.folio.getText();
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