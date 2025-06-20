package COFEPRIS.Tramite261401;

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

public class MainPage261401Test {
    MainPage261401 mainPage261401 = new MainPage261401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite261401 = new TramitesFirmasLG(
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
    public void Proceso261401() {
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
            loginFirmSoli.login(tramite261401);
            mainPage261401.selecRol.sendKeys("Persona Moral");
            mainPage261401.btnacep.click();
            mainPage261401.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage261401.SoliSub.click();
            mainPage261401.inputIdFolio.sendKeys("0402600400120254006000009");
            mainPage261401.inputBuscarButton.click();
            sleep(1000);
            mainPage261401.SolicitudTramite.doubleClick();
            mainPage261401.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage261401.labelDatosSolicitud.click();
            Selenide.sleep(100);
//            mainPage261401.inputModif.click();sleep(1000);
//            Selenide.sleep(100);
            mainPage261401.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            //mainPage261401.inputRazonSocial.setValue("TSD931210493");
            mainPage261401.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage261401.inputEmail.setValue("contacto@empresa.com");
            mainPage261401.inputCodigoPostal.setValue("01000");
            mainPage261401.inputEstado.sendKeys("COLIMA");
            mainPage261401.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage261401.inputLocalidad.setValue("Colonia Industrial");
            mainPage261401.inputColonia.setValue("Ampliación San Ángel");
            mainPage261401.inputCalle.setValue("Av. Revolución");
            mainPage261401.inputLada.setValue("52");
            mainPage261401.inputTelefono.setValue("12345678");
            mainPage261401.inputRegimen.sendKeys("Temporles");
            mainPage261401.inputAduanaSalida.sendKeys("ALTAMIRA");
            mainPage261401.checkBoxMercancia.click();
            mainPage261401.btnModificar.click();

//            mainPage261401.selectClasificacionProducto.sendKeys("BIOLOGICOS");
//            mainPage261401.selectSubClasificacionProducto.sendKeys("I. Toxoides, vacunas y preparaciones bacterianas de uso parenteral");
            mainPage261401.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage261401.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage261401.inputFraccionArancelaria.setValue("30021299");
            mainPage261401.inputCantidadUMT.setValue("100");
            mainPage261401.inputCantidadUMC.setValue("10");
            mainPage261401.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage261401.textareaPresentacion.setValue("MODIFICACION");
            mainPage261401.inputEnvasePrimario.setValue("TEST");
            mainPage261401.inputEnvaseSecundario.setValue("NUEVO");

//            mainPage261401.inputDenominacionDistintiva.setValue("Distintiva123");
//            mainPage261401.inputDenominacionComunInternacional.setValue("DCI-TEST");
//            mainPage261401.inputEspecifique.setValue("PRUEBA");
            //mainPage261401.selectFormaFarmaceutica.sendKeys("Emulsión");
            //mainPage261401.selectEstadoFisico.sendKeys("Liquido");
            //mainPage261401.textareaPresentacion.setValue("Ampolleta");
            //mainPage261401.inputNumeroRegistroSanitario.sendKeys("1234");
            mainPage261401.buttonAbrirPanelPaisesOrigen.click();
            mainPage261401.PaisOrigen.sendKeys("BUTAN");
            mainPage261401.inputAgregarSeleccion.click();
mainPage261401.inputUsoEspecifico.sendKeys("Diagnóstico");
//            mainPage261401.inputAbrirPanelPaisesProcedencia.click();
//            mainPage261401.PaisProcedencia.sendKeys("ANGOLA");
//            mainPage261401.inputClaveLotes.setValue("1346");
//            executeJavaScript("arguments[0].value = '01/05/2025';", mainPage261401.inputFechaElaboracion);sleep(100);
//            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage261401.inputFechaCaducidad);sleep(100);
            mainPage261401.btnModificarMercancia.click();
//            mainPage261401.inputRFC.setValue("MAVL621207C95");
//            mainPage261401.btnBuscarRFC.click();

            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage261401.labelTerceros.click();
            mainPage261401.checkBoxDestinatario.click();
            mainPage261401.btnModificarDestinatario.click();
            //mainPage261401.checkBoxMoral.click();
//            mainPage261401.inputTerceroRFC.setValue("TSD931210493");
//            mainPage261401.btnBuscarEmpresa.click();
            mainPage261401.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage261401.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage261401.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage261401.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage261401.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage261401.inputCodigoPostalFabricante.setValue("28010");
//            mainPage261401.terceroColoniaEquiv.setValue("ANTORCHA");
            mainPage261401.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage261401.terceroNumExterior.setValue("13471118");
            mainPage261401.terceroNumInterior.setValue("4A");
            mainPage261401.inputTerceroLada.setValue("52");
            mainPage261401.terceroTelefono.setValue("5533335");
            mainPage261401.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage261401.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage261401.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage261401.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage261401.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage261401.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage261401.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage261401.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage261401.inputCalendar);
            sleep(100);
            mainPage261401.inputSolicitudPagoImp.sendKeys("5000");
            mainPage261401.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage261401.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage261401.btnAnexar.click();sleep(4000);
            sleep(4000);
            mainPage261401.btnCerrar.click();
            sleep(100);
            mainPage261401.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite261401);
            String folioText = mainPage261401.folio.getText();
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