package COFEPRIS.Tramite260913;

import COFEPRIS.Tramite260913.MainPage260913;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260913Test {
    MainPage260913 mainPage260913 = new MainPage260913();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260913 = new TramitesFirmasLG(
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
    public void Proceso260913() {
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
            loginFirmSoli.login(tramite260913);
            mainPage260913.selecRol.sendKeys("Persona Moral");
            mainPage260913.btnacep.click();
            mainPage260913.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260913.SoliSub.click();
            mainPage260913.inputIdFolio.sendKeys("0402600201320254006000004");
            mainPage260913.inputBuscarButton.click();
            sleep(1000);
            mainPage260913.SolicitudTramite.doubleClick();
            mainPage260913.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260913.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260913.labelDatosSolicitud.click();
            mainPage260913.inputModif.click();
            mainPage260913.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260913.inputRazonSocial.setValue("EMPRESA S.A. DE C.V.");
            mainPage260913.inputEmail.setValue("contacto@empresa.com");
            mainPage260913.inputCodigoPostal.setValue("01000");
            mainPage260913.inputEstado.sendKeys("COLIMA");
            mainPage260913.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260913.inputLocalidad.setValue("Colonia Industrial");
            mainPage260913.inputColonia.setValue("Ampliación San Ángel");
            mainPage260913.inputCalle.setValue("Av. Revolución");
            mainPage260913.inputLada.setValue("55");
            mainPage260913.inputTelefono.setValue("12345678");
            mainPage260913.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260913.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260913.checkBoxMercancia.click();
            mainPage260913.btnModificar.click();
            /// ///
            mainPage260913.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260913.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260913.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260913.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260913.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260913.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260913.inputEspecifique.setValue("PRUEBA");
            //mainPage260913.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260913.selectEstadoFisico.sendKeys("Liquido");
            mainPage260913.inputFraccionArancelaria.setValue("13021999");
            mainPage260913.inputCantidadUMT.setValue("100");
            mainPage260913.inputCantidadUMC.setValue("10");
            mainPage260913.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260913.textareaPresentacion.setValue("Ampolleta");
            //mainPage260913.inputNumeroRegistroSanitario.sendKeys("62345");
            //executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260913.inputFechaCaducidad);sleep(100);
            mainPage260913.buttonAbrirPanelPaisesOrigen.click();
            mainPage260913.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260913.inputAgregarSeleccion.click();
            mainPage260913.inputAbrirPanelPaisesProcedencia.click();
            mainPage260913.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260913.btnModificarMercancia.click();

            /// ///
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260913.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260913.labelTerceros.click();
            mainPage260913.checkBoxFabricante.click();
            mainPage260913.btnModificarFabricante.click();
            mainPage260913.inputTerceroRFC.setValue("TSD931210493");
            mainPage260913.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260913.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260913.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260913.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260913.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260913.terceroCodigoPostal.sendKeys("28010");
            mainPage260913.terceroColoniaEquiv.sendKeys("ANTORCHA");
            mainPage260913.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260913.terceroNumExterior.setValue("13471118");
            mainPage260913.terceroNumInterior.setValue("4A");
            mainPage260913.inputTerceroLada.setValue("52");
            mainPage260913.terceroTelefono.setValue("5533335");
            mainPage260913.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260913.btnGuardarDatosTerceros.click();
            mainPage260913.checkBoxDestinatario.click();
            mainPage260913.btnModificarDestinatario.click();
            mainPage260913.inputTerceroRFC.setValue("TSD931210493");
            mainPage260913.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260913.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260913.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260913.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260913.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260913.terceroCodigoPostal.sendKeys("28010");
            mainPage260913.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260913.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260913.terceroNumExterior.setValue("13471118");
            mainPage260913.terceroNumInterior.setValue("4A");
            mainPage260913.inputTerceroLada.setValue("52");
            mainPage260913.terceroTelefono.setValue("5533335");
            mainPage260913.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260913.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260913.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260913.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260913.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260913.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260913.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260913.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260913.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260913.inputCalendar);
            sleep(100);
            mainPage260913.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260913.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260913.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260913.btnAnexar.click();
            sleep(2000);
            mainPage260913.btnCerrar.click();
            sleep(100);
            mainPage260913.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260913);
            String folioText = mainPage260913.folio.getText();
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