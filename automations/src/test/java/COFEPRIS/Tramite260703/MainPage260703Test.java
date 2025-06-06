package COFEPRIS.Tramite260703;

import COFEPRIS.Tramite260703.MainPage260703;
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

public class MainPage260703Test {
    MainPage260703 mainPage260703 = new MainPage260703();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260703 = new TramitesFirmasLG(
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
    public void Proceso260703() {
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
            loginFirmSoli.login(tramite260703);
            mainPage260703.selecRol.sendKeys("Persona Moral");
            mainPage260703.btnacep.click();
            mainPage260703.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260703.SoliSub.click();
            mainPage260703.inputIdFolio.sendKeys("0402600100320254003000001");
            mainPage260703.inputBuscarButton.click();
            sleep(1000);
            mainPage260703.SolicitudTramite.doubleClick();
            mainPage260703.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260703.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260703.labelDatosSolicitud.click();
            mainPage260703.inputModif.click();
            mainPage260703.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            //mainPage260703.inputRazonSocial.setValue("TSD931210493");
            mainPage260703.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage260703.inputEmail.setValue("contacto@empresa.com");
            mainPage260703.inputCodigoPostal.setValue("01000");
            mainPage260703.inputEstado.sendKeys("COLIMA");
            mainPage260703.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260703.inputLocalidad.setValue("Colonia Industrial");
            mainPage260703.inputColonia.setValue("Ampliación San Ángel");
            mainPage260703.inputCalle.setValue("Av. Revolución");
            mainPage260703.inputLada.setValue("52");
            mainPage260703.inputTelefono.setValue("12345678");
            mainPage260703.inputRegimen.sendKeys("Temporles");
            mainPage260703.inputAduana.sendKeys("ALTAMIRA");
            mainPage260703.checkBoxMercancia.click();
            mainPage260703.btnModificar.click();
            mainPage260703.selectClasificacionProducto.sendKeys("BEBIDAS NO ALCOHOLICAS");
            mainPage260703.selectSubClasificacionProducto.sendKeys("AGUA PURIFICADA");
            mainPage260703.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260703.inputDenominacionDistintiva.setValue("Distintiva123");
            //mainPage260703.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260703.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260703.inputEspecifique.setValue("PRUEBA");
            //mainPage260703.selectFormaFarmaceutica.sendKeys("Emulsión");
            //mainPage260703.selectEstadoFisico.sendKeys("Liquido");
            //mainPage260703.inputFraccionArancelaria.setValue("13021999");
            mainPage260703.inputCantidadUMT.setValue("100");
            mainPage260703.inputCantidadUMC.setValue("10");
            mainPage260703.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            //mainPage260703.textareaPresentacion.setValue("Ampolleta");
            //mainPage260703.inputNumeroRegistroSanitario.sendKeys("1234");
            mainPage260703.buttonAbrirPanelPaisesOrigen.click();
            mainPage260703.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260703.inputAgregarSeleccion.click();
            mainPage260703.inputAbrirPanelPaisesProcedencia.click();
            mainPage260703.PaisProcedencia.sendKeys("ANGOLA");
            mainPage260703.inputClaveLotes.setValue("1346");
            executeJavaScript("arguments[0].value = '01/05/2025';", mainPage260703.inputFechaElaboracion);sleep(100);
            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage260703.inputFechaCaducidad);sleep(100);
            mainPage260703.btnModificarMercancia.click();
            mainPage260703.inputRFC.setValue("MAVL621207C95");
            mainPage260703.btnBuscarRFC.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260703.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260703.labelTerceros.click();
            mainPage260703.checkBoxFabricante.click();
            mainPage260703.btnModificarFabricante.click();
            mainPage260703.checkBoxMoral.click();
            mainPage260703.inputTerceroRFC.setValue("TSD931210493");
            mainPage260703.btnBuscarEmpresa.click();
//            mainPage260703.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
//            mainPage260703.inputPais.sendKeys("CANADA");
//            mainPage260703.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260703.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260703.inputTerceroLocalidad.sendKeys("COLIMA");
//            mainPage260703.inputCodigoPostalFabricante.setValue("28010");
//            mainPage260703.terceroColoniaEquiv.setValue("ANTORCHA");
//            mainPage260703.terceroCalle.setValue("Lázaro Cárdenas");
//            mainPage260703.terceroNumExterior.setValue("13471118");
//            mainPage260703.terceroNumInterior.setValue("4A");
//            mainPage260703.inputTerceroLada.setValue("52");
//            mainPage260703.terceroTelefono.setValue("5533335");
//            mainPage260703.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260703.btnGuardarDatosTerceros.click();
            mainPage260703.checkBoxDestinatario.click();
            mainPage260703.btnModificarDestinatario.click();
            //mainPage260703.checkBoxMoral.click();
            mainPage260703.inputTerceroRFC.setValue("TSD931210493");
            mainPage260703.btnBuscarEmpresa.click();
//            mainPage260703.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
//            //mainPage260703.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260703.terceroEstadoLocalidad.sendKeys("COLIMA");
//            mainPage260703.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260703.inputTerceroLocalidad.sendKeys("COLIMA");
//            mainPage260703.terceroCodigoPostal.sendKeys("28010");
//            mainPage260703.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
//            mainPage260703.terceroCalle.setValue("Lázaro Cárdenas");
//            mainPage260703.terceroNumExterior.setValue("13471118");
//            mainPage260703.terceroNumInterior.setValue("4A");
//            mainPage260703.inputTerceroLada.setValue("52");
//            mainPage260703.terceroTelefono.setValue("5533335");
//            mainPage260703.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260703.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260703.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260703.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260703.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260703.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260703.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260703.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260703.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260703.inputCalendar);
            sleep(100);
            mainPage260703.inputSolicitudPagoImp.sendKeys("5000");
            mainPage260703.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260703.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage260703.btnAnexar.click();sleep(4000);
            sleep(4000);
            mainPage260703.btnCerrar.click();
            sleep(100);
            mainPage260703.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260703);
            String folioText = mainPage260703.folio.getText();
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