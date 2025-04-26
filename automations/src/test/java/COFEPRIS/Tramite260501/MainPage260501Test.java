package COFEPRIS.Tramite260501;

import COFEPRIS.Tramite260501.MainPage260501;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260501Test {
    MainPage260501 mainPage260501 = new MainPage260501();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260501  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    public static void iniDriver(){
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
    public void Proceso260501() {
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260501");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260501");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260501");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260501");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260501");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260501");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260501);
            mainPage260501.selecRol.sendKeys("Persona Moral");
            mainPage260501.btnacep.click();
            mainPage260501.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260501.SoliNew.click();
            mainPage260501.Cofepris.click();
            mainPage260501.linkCertificadosLicenciasPermisos.click();
            mainPage260501.linkPermisoImportPlagNutriVegTox.click();
            mainPage260501.linkPermisoImportacionPlaguicidas.click();
            //DATOS SSOLICITANTE
            mainPage260501.labelDatosSolicitud.click();
            mainPage260501.inputEstablecimiento.click();sleep(1000);
            mainPage260501.buttonAceptar.click();
            mainPage260501.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260501.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260501.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260501.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260501.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260501.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260501.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260501.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260501.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260501.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260501.inputScianAgregar.click();
            mainPage260501.comboSCIAN.selectOption("311311"); //148
            mainPage260501.inputAgregar.click();
            //mainPage260501.inputAvisoFuncionamiento.click();
            mainPage260501.inputLicenciaSanitaria.sendKeys("5645464353");
            mainPage260501.inputAduanEntradaDispo.sendKeys("CIUDAD ACUÑA");
            mainPage260501.inputAgregarAduanaEntrada.click();
            mainPage260501.inputAgregarAduana.click();
            mainPage260501.inputNombreComercial.sendKeys("QA");
            mainPage260501.inputNombrecomun.sendKeys("QA");
            mainPage260501.inputNombreCientifico.sendKeys("QA");
            mainPage260501.inputUsoEspecifico.sendKeys("QA");
            mainPage260501.inputFraccionArancelaria.sendKeys("29215199");
            mainPage260501.inputCantidadUMT.sendKeys("100");
            mainPage260501.inputCantidadUMC.sendKeys("10");
            mainPage260501.selectUnidadMedidaComercial.sendKeys("Bulto");
            mainPage260501.inputPorcentajeConcen.sendKeys("45");
            mainPage260501.numRegistroSanitario.sendKeys("45437456");
            mainPage260501.buttonAbrirPanelPaisesOrigen.click();
            mainPage260501.selecPaisOrigen.click();
            mainPage260501.btnAgregarPaisOrigen.click();
            mainPage260501.inputAbrirPanelPaisesProcedencia.click();
            mainPage260501.selecPaisProcedencia.click();
            mainPage260501.agregarPaisProcedencia.click();
            mainPage260501.abrirPaisProveedor.click();
            mainPage260501.selecPaisProveedor.click();
            mainPage260501.btnAgregarPaisProveedor.click();
            mainPage260501.abrirPaisUltimoEmbarque.click();
            mainPage260501.selecPaisUltimoEmbarque.click();
            mainPage260501.btnAgregarUltimoEmbarque.click();
            mainPage260501.inputClasifToxi.sendKeys("1");
            mainPage260501.inputObjetoImport.sendKeys("Experimentación");
            mainPage260501.inputAgregarMercancia.click();
            mainPage260501.manifiesto.click();
            mainPage260501.inputInformacionConfidencialNo.click();
            mainPage260501.inputRepresentanteLegalRFC.sendKeys("ZURA6808202RA");
            mainPage260501.inputConsultarIDC.click();
            /// TERCEROS RELACIONADOS
            scrollDecremento();scrollDecremento();
            mainPage260501.tercerosRelacionados.click();
            mainPage260501.btnAgregarFabricante.click();
            mainPage260501.terceroNacional.click();
            mainPage260501.terceroMoral.click();
            mainPage260501.terceroRFC.sendKeys("AFC000526BJ2");
            mainPage260501.btnBuscarTercero.click();
            mainPage260501.guardarTercero.click();
            mainPage260501.btnAgregarFormulador.click();
            mainPage260501.terceroNacional.click();
            mainPage260501.terceroMoral.click();
            mainPage260501.terceroRFC.sendKeys("TSD931210493");
            mainPage260501.btnBuscarTercero.click();
            mainPage260501.guardarTercero.click();
            mainPage260501.btnAgregarProveedor.click();
            mainPage260501.terceroNacional.click();
            mainPage260501.terceroMoral.click();
            mainPage260501.terceroRFC.sendKeys("TSD931210493");
            mainPage260501.btnBuscarTercero.click();
            mainPage260501.guardarTercero.click();
            //PAGO DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260501.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260501.labelPagoDerechos.click();
            mainPage260501.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260501.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260501.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260501.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260501.inputCalendar);sleep(100);
            mainPage260501.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260501.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260501.inputGuarda.click();
            mainPage260501.inputAdjuntar.click();
            mainPage260501.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260501.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260501.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260501.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260501.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260501.btnAnexar.click();sleep(5000);
            mainPage260501.btnCerrar.click();
            mainPage260501.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260501);
            String folioText = mainPage260501.folio.getText();
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
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 5; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}
