package COFEPRIS.Tramite260907;

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

public class MainPage260907Test {
    MainPage260907 mainPage260907 = new MainPage260907();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260907 = new TramitesFirmasLG(
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
    public void Proceso260907() {
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
            loginFirmSoli.login(tramite260907);
            mainPage260907.selecRol.sendKeys("Persona Moral");
            mainPage260907.btnacep.click();
            mainPage260907.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260907.SoliSub.click();
            mainPage260907.inputIdFolio.sendKeys("0402600200720254006000004");
            mainPage260907.inputBuscarButton.click();
            sleep(1000);
            mainPage260907.SolicitudTramite.doubleClick();
            mainPage260907.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260907.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260907.labelDatosSolicitud.click();
            mainPage260907.inputModif.click();
            mainPage260907.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260907.inputRazonSocial.setValue("TSD931210493");
            mainPage260907.inputRazonSocial.setValue("EMPRESA S.A. DE C.V.");
            mainPage260907.inputEmail.setValue("contacto@empresa.com");
            mainPage260907.inputCodigoPostal.setValue("01000");
            mainPage260907.inputEstado.sendKeys("COLIMA");
            mainPage260907.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260907.inputLocalidad.setValue("Colonia Industrial");
            mainPage260907.inputColonia.setValue("Ampliación San Ángel");
            mainPage260907.inputCalle.setValue("Av. Revolución");
            mainPage260907.inputLada.setValue("55");
            mainPage260907.inputTelefono.setValue("12345678");
            mainPage260907.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260907.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260907.checkBoxMercancia.click();
            mainPage260907.btnModificar.click();
            mainPage260907.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260907.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260907.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260907.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260907.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260907.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260907.inputEspecifique.setValue("PRUEBA");
            //mainPage260907.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260907.selectEstadoFisico.sendKeys("Liquido");
            mainPage260907.inputFraccionArancelaria.setValue("13021999");
            mainPage260907.inputCantidadUMT.setValue("100");
            mainPage260907.inputCantidadUMC.setValue("10");
            mainPage260907.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260907.textareaPresentacion.setValue("Ampolleta");
            mainPage260907.inputNumeroRegistroSanitario.sendKeys("1234");
            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260907.inputFechaCaducidad);sleep(100);
            mainPage260907.buttonAbrirPanelPaisesOrigen.click();
            mainPage260907.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260907.inputAgregarSeleccion.click();
            mainPage260907.inputAbrirPanelPaisesProcedencia.click();
            mainPage260907.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260907.btnModificarMercancia.click();
            mainPage260907.inputRFC.setValue("MAVL621207C95");
            mainPage260907.btnBuscarRFC.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260907.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260907.labelTerceros.click();
//            mainPage260907.checkBoxFabricante.click();
//            mainPage260907.btnModificarFabricante.click();
//            mainPage260907.inputTerceroRFC.setValue("TSD931210493");
//            mainPage260907.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
//            //mainPage260907.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260907.terceroEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260907.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260907.inputTerceroLocalidad.sendKeys("COLIMA");
//            mainPage260907.terceroCodigoPostal.sendKeys("28010");
//            mainPage260907.terceroColoniaEquiv.sendKeys("ANTORCHA");
//            mainPage260907.terceroCalle.setValue("Lázaro Cárdenas");
//            mainPage260907.terceroNumExterior.setValue("13471118");
//            mainPage260907.terceroNumInterior.setValue("4A");
//            mainPage260907.inputTerceroLada.setValue("52");
//            mainPage260907.terceroTelefono.setValue("5533335");
//            mainPage260907.terceroCorreo.setValue("contactar@fabricante.com");
//            mainPage260907.btnGuardarDatosTerceros.click();
            mainPage260907.checkBoxDestinatario.click();
            mainPage260907.btnModificarDestinatario.click();
            mainPage260907.inputTerceroRFC.setValue("TSD931210493");
            mainPage260907.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260907.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260907.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260907.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260907.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260907.terceroCodigoPostal.sendKeys("28010");
            mainPage260907.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260907.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260907.terceroNumExterior.setValue("13471118");
            mainPage260907.terceroNumInterior.setValue("4A");
            mainPage260907.inputTerceroLada.setValue("52");
            mainPage260907.terceroTelefono.setValue("5533335");
            mainPage260907.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260907.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260907.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260907.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260907.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260907.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260907.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260907.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260907.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260907.inputCalendar);
            sleep(100);
            mainPage260907.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260907.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260907.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260907.btnAnexar.click();
            sleep(2000);
            mainPage260907.btnCerrar.click();
            sleep(100);
            mainPage260907.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260907);
            String folioText = mainPage260907.folio.getText();
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