package COFEPRIS.Tramite260901;

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
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260901Test {
    MainPage260901 mainPage260901 = new MainPage260901();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260901 = new TramitesFirmasLG(
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
    public void Proceso260901() {
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
            loginFirmSoli.login(tramite260901);
            mainPage260901.selecRol.sendKeys("Persona Moral");
            mainPage260901.btnacep.click();
            mainPage260901.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260901.SoliSub.click();
            mainPage260901.inputIdFolio.sendKeys("0402600200120254006000005");
            mainPage260901.inputBuscarButton.click();
            sleep(1000);
            mainPage260901.SolicitudTramite.doubleClick();
            mainPage260901.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260901.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260901.labelDatosSolicitud.click();
            mainPage260901.inputModif.click();
            mainPage260901.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260901.inputRazonSocial.setValue("TSD931210493");
            mainPage260901.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage260901.inputEmail.setValue("contacto@empresa.com");
            mainPage260901.inputCodigoPostal.setValue("01000");
            mainPage260901.inputEstado.sendKeys("COLIMA");
            mainPage260901.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260901.inputLocalidad.setValue("Colonia Industrial");
            mainPage260901.inputColonia.setValue("Ampliación San Ángel");
            mainPage260901.inputCalle.setValue("Av. Revolución");
            mainPage260901.inputLada.setValue("52");
            mainPage260901.inputTelefono.setValue("12345678");
            mainPage260901.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260901.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260901.checkBoxMercancia.click();
            mainPage260901.btnModificar.click();
            mainPage260901.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260901.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260901.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260901.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260901.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260901.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260901.inputEspecifique.setValue("PRUEBA");
            //mainPage260901.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260901.selectEstadoFisico.sendKeys("Liquido");
            mainPage260901.inputFraccionArancelaria.setValue("13021999");
            mainPage260901.inputCantidadUMT.setValue("100");
            mainPage260901.inputCantidadUMC.setValue("10");
            mainPage260901.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260901.textareaPresentacion.setValue("Ampolleta");
            mainPage260901.inputNumeroRegistroSanitario.sendKeys("1234");
            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260901.inputFechaCaducidad);sleep(100);
            mainPage260901.buttonAbrirPanelPaisesOrigen.click();
            mainPage260901.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260901.inputAgregarSeleccion.click();
            mainPage260901.inputAbrirPanelPaisesProcedencia.click();
            mainPage260901.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260901.btnModificarMercancia.click();
            mainPage260901.inputRFC.setValue("MAVL621207C95");
            mainPage260901.btnBuscarRFC.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260901.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260901.labelTerceros.click();
            mainPage260901.checkBoxFabricante.click();
            mainPage260901.btnModificarFabricante.click();
            //mainPage260901.inputTerceroRFC.setValue("TSD931210493");
            mainPage260901.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage260901.inputPais.sendKeys("CANADA");
            mainPage260901.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260901.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260901.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260901.inputCodigoPostalFabricante.setValue("28010");
            mainPage260901.terceroColoniaEquiv.setValue("ANTORCHA");
            mainPage260901.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260901.terceroNumExterior.setValue("13471118");
            mainPage260901.terceroNumInterior.setValue("4A");
            mainPage260901.inputTerceroLada.setValue("52");
            mainPage260901.terceroTelefono.setValue("5533335");
            mainPage260901.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260901.btnGuardarDatosTerceros.click();
            mainPage260901.checkBoxDestinatario.click();
            mainPage260901.btnModificarDestinatario.click();
            mainPage260901.checkBoxMoral.click();
            mainPage260901.inputTerceroRFC.setValue("TSD931210493");
            mainPage260901.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260901.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260901.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260901.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260901.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260901.terceroCodigoPostal.sendKeys("28010");
            mainPage260901.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260901.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260901.terceroNumExterior.setValue("13471118");
            mainPage260901.terceroNumInterior.setValue("4A");
            mainPage260901.inputTerceroLada.setValue("52");
            mainPage260901.terceroTelefono.setValue("5533335");
            mainPage260901.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260901.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260901.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260901.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260901.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260901.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260901.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260901.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260901.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260901.inputCalendar);
            sleep(100);
            mainPage260901.inputSolicitudPagoImp.sendKeys("5000");
            mainPage260901.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260901.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260901.btnAnexar.click();
            sleep(2000);
            mainPage260901.btnCerrar.click();
            sleep(100);
            mainPage260901.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260901);
            String folioText = mainPage260901.folio.getText();
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