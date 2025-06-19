package COFEPRIS.Tramite260704;

import COFEPRIS.Tramite260704.MainPage260704;
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

public class MainPage260704Test {
    MainPage260704 mainPage260704 = new MainPage260704();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260704 = new TramitesFirmasLG(
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
    public void Proceso260704() {
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
            loginFirmSoli.login(tramite260704);
            mainPage260704.selecRol.sendKeys("Persona Moral");
            mainPage260704.btnacep.click();
            mainPage260704.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260704.SoliSub.click();
            mainPage260704.inputIdFolio.sendKeys("0402600100420254006000010");
            mainPage260704.inputBuscarButton.click();
            sleep(1000);
            mainPage260704.SolicitudTramite.doubleClick();
            mainPage260704.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260704.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260704.labelDatosSolicitud.click();
            mainPage260704.inputModif.click();
            mainPage260704.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            //mainPage260704.inputRazonSocial.setValue("TSD931210493");
            mainPage260704.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage260704.inputEmail.setValue("contacto@empresa.com");
            mainPage260704.inputCodigoPostal.setValue("01000");
            mainPage260704.inputEstado.sendKeys("COLIMA");
            mainPage260704.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260704.inputLocalidad.setValue("Colonia Industrial");
            mainPage260704.inputColonia.setValue("Ampliación San Ángel");
            mainPage260704.inputCalle.setValue("Av. Revolución");
            mainPage260704.inputLada.setValue("52");
            mainPage260704.inputTelefono.setValue("12345678");
            mainPage260704.inputRegimen.sendKeys("Temporles");
            mainPage260704.inputAduana.sendKeys("ALTAMIRA");
            mainPage260704.checkBoxMercancia.click();
            mainPage260704.btnModificar.click();
            mainPage260704.selectClasificacionProducto.sendKeys("BEBIDAS NO ALCOHOLICAS");
            mainPage260704.selectSubClasificacionProducto.sendKeys("AGUA PURIFICADA");
            mainPage260704.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260704.inputDenominacionDistintiva.setValue("Distintiva123");
            //mainPage260704.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260704.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260704.inputEspecifique.setValue("PRUEBA");
            //mainPage260704.selectFormaFarmaceutica.sendKeys("Emulsión");
            //mainPage260704.selectEstadoFisico.sendKeys("Liquido");
            //mainPage260704.inputFraccionArancelaria.setValue("13021999");
            mainPage260704.inputCantidadUMT.setValue("100");
            mainPage260704.inputCantidadUMC.setValue("10");
            mainPage260704.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            //mainPage260704.textareaPresentacion.setValue("Ampolleta");
            //mainPage260704.inputNumeroRegistroSanitario.sendKeys("1234");
            mainPage260704.buttonAbrirPanelPaisesOrigen.click();
            mainPage260704.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260704.inputAgregarSeleccion.click();
            mainPage260704.inputAbrirPanelPaisesProcedencia.click();
            mainPage260704.PaisProcedencia.sendKeys("ANGOLA");
//            mainPage260704.inputClaveLotes.setValue("1346");
//            executeJavaScript("arguments[0].value = '01/05/2025';", mainPage260704.inputFechaElaboracion);sleep(100);
//            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260704.inputFechaCaducidad);sleep(100);
            mainPage260704.btnModificarMercancia.click();
//            mainPage260704.inputRFC.setValue("MAVL621207C95");
//            mainPage260704.btnBuscarRFC.click();

            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260704.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260704.labelTerceros.click();
            mainPage260704.checkBoxFabricante.click();
            mainPage260704.btnModificarFabricante.click();
            mainPage260704.checkBoxMoral.click();
//            mainPage260704.inputTerceroRFC.setValue("TSD931210493");
//            mainPage260704.btnBuscarEmpresa.click();
            mainPage260704.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage260704.inputPais.sendKeys("CANADA");
            mainPage260704.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260704.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260704.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260704.inputCodigoPostalFabricante.setValue("28010");
//            mainPage260704.terceroColoniaEquiv.setValue("ANTORCHA");
            mainPage260704.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260704.terceroNumExterior.setValue("13471118");
            mainPage260704.terceroNumInterior.setValue("4A");
            mainPage260704.inputTerceroLada.setValue("52");
            mainPage260704.terceroTelefono.setValue("5533335");
            mainPage260704.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260704.btnGuardarDatosTerceros.click();
            mainPage260704.checkBoxDestinatario.click();
            mainPage260704.btnModificarDestinatario.click();
            //mainPage260704.checkBoxMoral.click();
//            mainPage260704.inputTerceroRFC.setValue("TSD931210493");
//            mainPage260704.btnBuscarEmpresa.click();
            mainPage260704.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage260704.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260704.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260704.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260704.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260704.inputCodigoPostalFabricante.setValue("28010");
//            mainPage260704.terceroColoniaEquiv.setValue("ANTORCHA");
            mainPage260704.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260704.terceroNumExterior.setValue("13471118");
            mainPage260704.terceroNumInterior.setValue("4A");
            mainPage260704.inputTerceroLada.setValue("52");
            mainPage260704.terceroTelefono.setValue("5533335");
            mainPage260704.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260704.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260704.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260704.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260704.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260704.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260704.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260704.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260704.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260704.inputCalendar);
            sleep(100);
            mainPage260704.inputSolicitudPagoImp.sendKeys("5000");
            mainPage260704.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260704.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260704.btnAnexar.click();sleep(4000);
            sleep(4000);
            mainPage260704.btnCerrar.click();
            sleep(100);
            mainPage260704.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260704);
            String folioText = mainPage260704.folio.getText();
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