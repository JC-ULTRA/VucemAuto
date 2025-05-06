package COFEPRIS.Tramite260101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260101Test {
    MainPage260101 mainPage260101 = new MainPage260101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260101  = new TramitesFirmasLG(
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
    public void Proceso260101() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260101");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260101);
            mainPage260101.selecRol.sendKeys("Persona Moral");
            mainPage260101.btnacep.click();
            mainPage260101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260101.SoliNew.click();
            mainPage260101.Cofepris.click();
            mainPage260101.linkCertificadosLicenciasPermisos.click();
            mainPage260101.linkPermisoSanitarioImportaciProductos.click();
            mainPage260101.linkPermisoSanitarioPrevioImportaci.click();
            //DATOS SSOLICITANTE
            mainPage260101.labelDatosSolicitud.click();
            mainPage260101.inputEstablecimiento.click();
            mainPage260101.divAceptar.click();
            mainPage260101.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260101.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("12345");sleep(500);
            mainPage260101.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("MORELOS");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Zacatepec");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Galeana");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Vicente Guerrero");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle Ejemplo 123");sleep(500);
            mainPage260101.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5551234567");sleep(500);
            mainPage260101.inputScianAgregar.click();sleep(500);
            mainPage260101.selectComboScian.sendKeys("311321");sleep(500);
            mainPage260101.inputAgregar.click();sleep(500);
            mainPage260101.inputAgregar2.click();sleep(500);
            mainPage260101.inputNumeroLicencia.sendKeys("434534");sleep(500);
            mainPage260101.inputSolicitudTienePrioridad.click();sleep(500);
            mainPage260101.selectSolicitudRegimenClave.sendKeys("Definitivos");sleep(500);
            mainPage260101.selectSolicitudRegimenClave2.sendKeys("VERACRUZ");sleep(500);
            mainPage260101.selectAduanas.click();sleep(500);
            mainPage260101.selectMercanciaGridClasificacionProducto.sendKeys("ALIMENTOS");sleep(500);
            mainPage260101.selectMercanciaGridClasificacionProducto2.sendKeys("Pastas, granos y semillas");sleep(500);
            mainPage260101.inputDenominacionEspecifica.sendKeys("Prueba");sleep(500);
            mainPage260101.inputDenominacionEspecifica2.sendKeys("Prueba");sleep(500);
            mainPage260101.inputTipoTramiteMercancia.sendKeys("Producto terminado");sleep(500);
            mainPage260101.inputFraccionArancelaria.sendKeys("04059001");sleep(500);
            mainPage260101.inputCantidadUmt.sendKeys("10");sleep(500);
            mainPage260101.inputCantidadUmc.sendKeys("5");sleep(500);
            mainPage260101.inputDetalleUmc.sendKeys("Botellas");sleep(500);
            mainPage260101.buttonResolution.click();sleep(500);
            mainPage260101.optionAnguila.click();sleep(500);
            mainPage260101.inputAdd.click();sleep(500);
            mainPage260101.buttonResolution3.click();sleep(500);
            mainPage260101.optionAndorraPrincipado.click();sleep(500);
            mainPage260101.inputAdd2.click();sleep(500);
            mainPage260101.inputClaveLotes.sendKeys("12345");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '05/04/2025';", mainPage260101.inputFechaElaboracion);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '12/04/2025';", mainPage260101.inputFechaCaducidad);sleep(100);
            mainPage260101.inputAgregarNumeroLote.click();sleep(500);
            mainPage260101.buttonResolution4.click();sleep(500);
            mainPage260101.optionDonaciones.click();sleep(500);
            mainPage260101.inputAdd3.click();sleep(500);
            mainPage260101.inputAgregarMercancia.click();sleep(500);
            mainPage260101.inputDeclaracion.click();sleep(500);
            mainPage260101.inputInformacionConfidencial.click();sleep(500);
            mainPage260101.inputResultadoIdc.sendKeys("MAVL621207C95");sleep(500);
            mainPage260101.inputConsultarIdc.click();sleep(500);
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260101.labelTerceros.click();
            mainPage260101.inputAgregarDestinatario.click();sleep(500);
            mainPage260101.inputTercerosTipoPersonaMoral.sendKeys("Persona Moral");sleep(500);
            mainPage260101.inputTerceros.sendKeys("RFC123456789");sleep(500);
            mainPage260101.inputTercerosSocial.sendKeys("PRUEBAS SA DE CV");sleep(500);
            mainPage260101.selectTercerosEstado.sendKeys("MORELOS");sleep(500);
            mainPage260101.selectTercerosMunicipio.sendKeys("ZACATEPEC DE HIDALGO");sleep(1000);
            mainPage260101.selectTercerosLocalidad.sendKeys("GALEANA");sleep(1000);
            $("option[value='62780']").click();
            mainPage260101.selectTercerosColonia.sendKeys("VICENTE GUERRERO");sleep(500);
            mainPage260101.inputTercerosCalle.sendKeys("Calle Conocida");sleep(500);
            mainPage260101.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260101.inputTercerosNumInterior.sendKeys("A");sleep(500);
            mainPage260101.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260101.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260101.buttonGuardarDatosTercero.click();sleep(500);

            mainPage260101.inputAgregarTerceroTipersFab.click();
            mainPage260101.inputTercerosNacionalidadMexicana.click();
            mainPage260101.inputTercerosTipoPersonaMoral2.click();
            mainPage260101.inputTerceros2.sendKeys("AAL0409235E6");
            mainPage260101.btnBuscarEmpresa.click();
            mainPage260101.buttonGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            mainPage260101.labelPagoDerechos.click();
            mainPage260101.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260101.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260101.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260101.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            mainPage260101.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260101.inputCalendar);sleep(100);

            mainPage260101.inputGuardarSolicitud.click();
            mainPage260101.inputGuarda.click();
            mainPage260101.inputAdjuntar.click();

            mainPage260101.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc8.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc9.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc10.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.selectDoc11.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260101.btnAnexar.click();
            mainPage260101.btnCerrar.click();
            mainPage260101.inputSiguiente.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260101);
            //String folioText = mainPage260101.folio.getText();sleep(5000);
            //String folioNumber = obtenerFolio.obtenerFolio(folioText);
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