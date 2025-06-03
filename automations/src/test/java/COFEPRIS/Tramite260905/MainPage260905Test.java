package COFEPRIS.Tramite260905;

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

public class MainPage260905Test {
    MainPage260905 mainPage260905 = new MainPage260905();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260905 = new TramitesFirmasLG(
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
    public void Proceso260905() {
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
            loginFirmSoli.login(tramite260905);
            mainPage260905.selecRol.sendKeys("Persona Moral");
            mainPage260905.btnacep.click();
            mainPage260905.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260905.SoliSub.click();
            mainPage260905.inputIdFolio.sendKeys("0402600200520254006000006");
            mainPage260905.inputBuscarButton.click();
            sleep(1000);
            mainPage260905.SolicitudTramite.doubleClick();
            mainPage260905.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260905.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260905.labelDatosSolicitud.click();
            mainPage260905.inputModif.click();
            mainPage260905.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260905.inputRazonSocial.setValue("TSD931210493");
            mainPage260905.inputRazonSocial.setValue("EMPRESA S.A. DE C.V.");
            mainPage260905.inputEmail.setValue("contacto@empresa.com");
            mainPage260905.inputCodigoPostal.setValue("01000");
            mainPage260905.inputEstado.sendKeys("COLIMA");
            mainPage260905.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260905.inputLocalidad.setValue("Colonia Industrial");
            mainPage260905.inputColonia.setValue("Ampliación San Ángel");
            mainPage260905.inputCalle.setValue("Av. Revolución");
            mainPage260905.inputLada.setValue("55");
            mainPage260905.inputTelefono.setValue("12345678");
            mainPage260905.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260905.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260905.checkBoxMercancia.click();
            mainPage260905.btnModificar.click();
            mainPage260905.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260905.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260905.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260905.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260905.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260905.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260905.inputEspecifique.setValue("PRUEBA");
            //mainPage260905.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260905.selectEstadoFisico.sendKeys("Liquido");
            mainPage260905.inputFraccionArancelaria.setValue("13021999");
            mainPage260905.inputCantidadUMT.setValue("100");
            mainPage260905.inputCantidadUMC.setValue("10");
            mainPage260905.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260905.textareaPresentacion.setValue("Ampolleta");
            //mainPage260905.inputNumeroRegistroSanitario.sendKeys("1234");
            //executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260905.inputFechaCaducidad);sleep(100);
            mainPage260905.buttonAbrirPanelPaisesOrigen.click();
            mainPage260905.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260905.inputAgregarSeleccion.click();
            mainPage260905.inputAbrirPanelPaisesProcedencia.click();
            mainPage260905.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260905.btnModificarMercancia.click();
            mainPage260905.inputRFC.setValue("MAVL621207C95");
            mainPage260905.btnBuscarRFC.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260905.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260905.labelTerceros.click();
//            mainPage260905.checkBoxFabricante.click();
//            mainPage260905.btnModificarFabricante.click();
//            mainPage260905.inputTerceroRFC.setValue("TSD931210493");
//            mainPage260905.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
//            //mainPage260905.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260905.terceroEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260905.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260905.inputTerceroLocalidad.sendKeys("COLIMA");
//            mainPage260905.terceroCodigoPostal.sendKeys("28010");
//            mainPage260905.terceroColoniaEquiv.sendKeys("ANTORCHA");
//            mainPage260905.terceroCalle.setValue("Lázaro Cárdenas");
//            mainPage260905.terceroNumExterior.setValue("13471118");
//            mainPage260905.terceroNumInterior.setValue("4A");
//            mainPage260905.inputTerceroLada.setValue("52");
//            mainPage260905.terceroTelefono.setValue("5533335");
//            mainPage260905.terceroCorreo.setValue("contactar@fabricante.com");
//            mainPage260905.btnGuardarDatosTerceros.click();
            mainPage260905.checkBoxDestinatario.click();
            mainPage260905.btnModificarDestinatario.click();
            mainPage260905.checkBoxMoral.click();
            mainPage260905.inputTerceroRFC.setValue("TSD931210493");
            mainPage260905.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260905.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260905.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260905.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260905.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260905.terceroCodigoPostal.sendKeys("28010");
            mainPage260905.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260905.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260905.terceroNumExterior.setValue("13471118");
            mainPage260905.terceroNumInterior.setValue("4A");
            mainPage260905.inputTerceroLada.setValue("52");
            mainPage260905.terceroTelefono.setValue("5533335");
            mainPage260905.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260905.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260905.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260905.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260905.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260905.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260905.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260905.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260905.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260905.inputCalendar);
            sleep(100);
            mainPage260905.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260905.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260905.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260905.btnAnexar.click();
            sleep(2000);
            mainPage260905.btnCerrar.click();
            sleep(100);
            mainPage260905.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260905);
            String folioText = mainPage260905.folio.getText();
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