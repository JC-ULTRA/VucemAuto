package COFEPRIS.Tramite260919;

import COFEPRIS.Tramite260919.MainPage260919;
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

public class MainPage260919Test {
    MainPage260919 mainPage260919 = new MainPage260919();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260919 = new TramitesFirmasLG(
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
    public void Proceso260919() {
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
            loginFirmSoli.login(tramite260919);
            mainPage260919.selecRol.sendKeys("Persona Moral");
            mainPage260919.btnacep.click();
            mainPage260919.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260919.SoliSub.click();
            mainPage260919.inputIdFolio.sendKeys("0402600201920254006000004");
            mainPage260919.inputBuscarButton.click();
            sleep(1000);
            mainPage260919.SolicitudTramite.doubleClick();
            mainPage260919.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260919.labelDatosSolicitud.click();
            mainPage260919.inputModif.click();
            mainPage260919.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260919.inputRazonSocial.setValue("EMPRESA S.A. DE C.V.");
            mainPage260919.inputEmail.setValue("contacto@empresa.com");
            mainPage260919.inputCodigoPostal.setValue("01000");
            mainPage260919.inputEstado.sendKeys("COLIMA");
            mainPage260919.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260919.inputLocalidad.setValue("Colonia Industrial");
            mainPage260919.inputColonia.setValue("Ampliación San Ángel");
            mainPage260919.inputCalle.setValue("Av. Revolución");
            mainPage260919.inputLada.setValue("55");
            mainPage260919.inputTelefono.setValue("12345678");
            mainPage260919.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260919.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260919.checkBoxMercancia.click();
            mainPage260919.btnModificar.click();
            /// ///
            mainPage260919.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260919.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260919.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260919.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260919.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260919.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260919.inputEspecifique.setValue("PRUEBA");
            //mainPage260919.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260919.selectEstadoFisico.sendKeys("Liquido");
            mainPage260919.inputFraccionArancelaria.setValue("13021999");
            mainPage260919.inputCantidadUMT.setValue("100");
            mainPage260919.inputCantidadUMC.setValue("10");
            mainPage260919.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260919.textareaPresentacion.setValue("Ampolleta");
            mainPage260919.inputNumeroRegistroSanitario.setValue("1234");
            executeJavaScript("arguments[0].value = '08/06/2025';", mainPage260919.inputFechaCaducidad);sleep(100);
            mainPage260919.buttonAbrirPanelPaisesOrigen.click();
            mainPage260919.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260919.inputAgregarSeleccion.click();
            mainPage260919.inputAbrirPanelPaisesProcedencia.click();
            mainPage260919.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260919.btnModificarMercancia.click();

            /// ///
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260919.labelTerceros.click();
            mainPage260919.checkBoxFabricante.click();
            mainPage260919.btnModificarFabricante.click();
            //mainPage260919.inputTerceroRFC.setValue("ASD931210493");
            mainPage260919.inputTerceroRazonSocial.setValue("MODIFPRUEBAS SA DE CV");
            mainPage260919.inputPais.sendKeys("COREA");
            mainPage260919.terceroEstado.sendKeys("COLIMA");
//            mainPage260919.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260919.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260919.terceroCP.sendKeys("28010");
            mainPage260919.terceroColoniaModif.sendKeys("ANTORCHA");
            mainPage260919.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260919.terceroNumExterior.setValue("13471118");
            mainPage260919.terceroNumInterior.setValue("4A");
            mainPage260919.inputTerceroLada.setValue("52");
            mainPage260919.terceroTelefono.setValue("5533335");
            mainPage260919.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260919.btnGuardarDatosTerceros.click();
            //DESTINATARIO
            mainPage260919.checkBoxDestinatario.click();
            mainPage260919.btnModificarDestinatario.click();
            mainPage260919.inputTerceroRFC.setValue("TSD931210493");
            mainPage260919.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260919.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260919.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260919.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260919.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260919.terceroCodigoPostal.sendKeys("28010");
            mainPage260919.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260919.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260919.terceroNumExterior.setValue("13471118");
            mainPage260919.terceroNumInterior.setValue("4A");
            mainPage260919.inputTerceroLada.setValue("52");
            mainPage260919.terceroTelefono.setValue("5533335");
            mainPage260919.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260919.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260919.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260919.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260919.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260919.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260919.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260919.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260919.inputCalendar);
            sleep(100);
            mainPage260919.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260919.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260919.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260919.btnAnexar.click();
            sleep(2000);
            mainPage260919.btnCerrar.click();
            sleep(100);
            mainPage260919.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260919);
            String folioText = mainPage260919.folio.getText();
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