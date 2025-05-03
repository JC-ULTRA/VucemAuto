package COFEPRIS.Tramite260502;

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

public class MainPage260502Test {
    MainPage260502 mainPage260502 = new MainPage260502();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260502  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
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
    public void Proceso260502() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260502");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260502");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260502");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260502");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260502");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260502");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260502);
            mainPage260502.selecRol.sendKeys("Persona Moral");
            mainPage260502.btnacep.click();
            mainPage260502.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260502.SoliNew.click();
            mainPage260502.Cofepris.click();
            mainPage260502.linkCertificadosLicenciasPermisos.click();
            mainPage260502.linkPermisoImportPlagNutriVegTox.click();
            mainPage260502.linkMuestraExportacionPlaguicidas.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260502.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260502.labelDatosSolicitud.click();

            mainPage260502.inputEstablecimiento.click();sleep(1000);
            mainPage260502.buttonAceptar.click();
            mainPage260502.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260502.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260502.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260502.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260502.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260502.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260502.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260502.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260502.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260502.getInputSolicitudEstablecimientoLada.sendKeys("52");
            mainPage260502.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260502.inputScianAgregar.click();
            mainPage260502.comboSCIAN.selectOption("311311"); //148
            mainPage260502.inputAgregar.click();
            //mainPage260502.inputAvisoFuncionamiento.click();
            //mainPage260502.inputLicenciaSanitaria.sendKeys("5645464353");
            mainPage260502.inputAduanEntradaDispo.sendKeys("CIUDAD ACUÑA");
            mainPage260502.inputAgregarAduanaEntrada.click();
            mainPage260502.inputAgregarAduana.click();
            mainPage260502.inputNombreComercial.sendKeys("PRUEBAS");
            mainPage260502.inputNombrecomun.sendKeys("PRUEBAS QA");
            mainPage260502.inputNombreCientifico.sendKeys("PRUEBUS QUAS");
            mainPage260502.inputUsoEspecifico.sendKeys("QA");
            mainPage260502.inputFraccionArancelaria.sendKeys("29242999");
            mainPage260502.inputCantidadUMT.sendKeys("100");
            mainPage260502.inputCantidadUMC.sendKeys("10");
            mainPage260502.selectUnidadMedidaComercial.sendKeys("Bulto");
            mainPage260502.inputPorcentajeConcen.sendKeys("45");
            //mainPage260502.numRegistroSanitario.sendKeys("45437456");
            mainPage260502.buttonAbrirPanelPaisesOrigen.click();
            mainPage260502.selecPaisOrigen.click();
            mainPage260502.btnAgregarPaisOrigen.click();
            mainPage260502.inputAbrirPaisElaboraProducto.click();
            mainPage260502.selectPaisElaboraProducto.click();
            mainPage260502.inputAgregarPaisElaboraProducto.click();
            mainPage260502.abrirPaisProveedor.click();
            mainPage260502.selecPaisProveedor.click();
            mainPage260502.btnAgregarPaisProveedor.click();
            mainPage260502.inputAbrirPanelPaisesProcedencia.click();
            mainPage260502.selecPaisProcedencia.click();
            mainPage260502.agregarPaisProcedencia.click();
            mainPage260502.inputClasifToxi.sendKeys("1");
            mainPage260502.inputObjetoImport.sendKeys("Experimentación");
            //mainPage260502.abrirPaisUltimoEmbarque.click();
            //mainPage260502.selecPaisUltimoEmbarque.click();
            //mainPage260502.btnAgregarUltimoEmbarque.click();
            mainPage260502.inputAgregarMercancia.click();
            mainPage260502.manifiesto.click();
            mainPage260502.inputInformacionConfidencialNo.click();
            mainPage260502.inputRepresentanteLegalRFC.sendKeys("ZURA6808202RA");
            mainPage260502.inputConsultarIDC.click();
            /// TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260502.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260502.tercerosRelacionados.click();
            mainPage260502.btnAgregarFabricante.click();
            mainPage260502.terceroNacional.click();
            mainPage260502.terceroMoral.click();
            mainPage260502.terceroRFC.sendKeys("AFC000526BJ2");
            mainPage260502.btnBuscarTercero.click();
            mainPage260502.guardarTercero.click();
            mainPage260502.btnAgregarFormulador.click();
            mainPage260502.terceroNacional.click();
            mainPage260502.terceroMoral.click();
            mainPage260502.terceroRFC.sendKeys("TSD931210493");
            mainPage260502.btnBuscarTercero.click();
            mainPage260502.guardarTercero.click();
            mainPage260502.btnAgregarProveedor.click();
            mainPage260502.terceroNacional.click();
            mainPage260502.terceroMoral.click();
            mainPage260502.terceroRFC.sendKeys("TSD931210493");
            mainPage260502.btnBuscarTercero.click();
            mainPage260502.guardarTercero.click();
            //PAGO DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260502.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260502.labelPagoDerechos.click();
            mainPage260502.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260502.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260502.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260502.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260502.inputCalendar);sleep(100);
            mainPage260502.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260502.inputGuardarSolicitud.click();

            //GUARDAR
            mainPage260502.inputGuarda.click();
            mainPage260502.inputAdjuntar.click();
            mainPage260502.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260502.btnAnexar.click();sleep(7000);
            mainPage260502.btnCerrar.click();sleep(5000);
            mainPage260502.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260502);
            String folioText = mainPage260502.folio.getText();
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