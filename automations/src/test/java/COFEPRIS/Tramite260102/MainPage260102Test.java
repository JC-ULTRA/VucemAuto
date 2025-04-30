package COFEPRIS.Tramite260102;

import COFEPRIS.Tramite260102.MainPage260102;
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
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260102Test {
    MainPage260102 mainPage260102 = new MainPage260102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260102  = new TramitesFirmasLG(
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
    public void Proceso260102() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260102");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260102");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260102");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260102");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260102");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260102");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260102);
            mainPage260102.selecRol.sendKeys("Persona Moral");
            mainPage260102.btnacep.click();
            mainPage260102.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260102.SoliNew.click();
            mainPage260102.Cofepris.click();
            mainPage260102.linkCertificadosLicenciasPermisos.click();
            mainPage260102.linkPermisoSanitarioImportaciProductos.click();
            mainPage260102.linkPermisoSanImpProMueConPer.click();
            //DATOS SOLICITANTE
            mainPage260102.labelDatosSolicitud.click();
            mainPage260102.inputEstablecimiento.click();
            mainPage260102.divAceptar.click();
            mainPage260102.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260102.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("12345");sleep(500);
            mainPage260102.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("MORELOS");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Zacatepec");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Galeana");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Vicente Guerrero");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle Ejemplo 123");sleep(500);
            mainPage260102.inputSolicitudEstablecimientoLada.sendKeys("52");
            mainPage260102.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5551234567");sleep(500);
            mainPage260102.inputScianAgregar.click();sleep(500);
            mainPage260102.selectComboScian.sendKeys("311321");sleep(500);
            mainPage260102.inputAgregar.click();sleep(500);
            mainPage260102.inputAgregar2.click();sleep(500);
            //mainPage260102.inputNumeroLicencia.sendKeys("434534");sleep(500);
            //mainPage260102.inputSolicitudTienePrioridad.click();sleep(500);
            mainPage260102.selectSolicitudRegimenClave.sendKeys("Depósito Fiscal");sleep(500);
            mainPage260102.selectSolicitudRegimenClave2.sendKeys("CIUDAD HIDALGO");sleep(500);
            mainPage260102.selectAduanas.click();sleep(500);
            mainPage260102.selectMercanciaGridClasificacionProducto.sendKeys("BEBIDAS ALCOHOLICAS ");sleep(500);
            mainPage260102.selectMercanciaGridClasificacionProducto2.sendKeys("No aplica");sleep(500);
            mainPage260102.inputDenominacionEspecifica.sendKeys("Prueba");sleep(500);
            mainPage260102.inputDenominacionEspecifica2.sendKeys("Prueba");sleep(500);
            mainPage260102.inputTipoTramiteMercancia.sendKeys("Aditivo");sleep(500);
            mainPage260102.inputFraccionArancelaria.sendKeys("21069001");sleep(500);
            mainPage260102.inputCantidadUmt.sendKeys("10");sleep(500);
            mainPage260102.inputCantidadUmc.sendKeys("10");sleep(500);
            mainPage260102.inputDetalleUmc.sendKeys("Kilogramo");sleep(500);
            mainPage260102.buttonResolution.click();sleep(500);
            mainPage260102.optionAnguila.click();sleep(500);
            mainPage260102.inputAdd.click();sleep(500);
            mainPage260102.buttonResolution3.click();sleep(500);
            mainPage260102.optionAndorraPrincipado.click();sleep(500);
            mainPage260102.inputAdd2.click();sleep(500);
            mainPage260102.inputClaveLotes.sendKeys("12345");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '29/04/2025';", mainPage260102.inputFechaElaboracion);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '29/06/2025';", mainPage260102.inputFechaCaducidad);sleep(100);
            mainPage260102.inputAgregarNumeroLote.click();sleep(500);
            mainPage260102.buttonResolution4.click();sleep(500);
            mainPage260102.optionDonaciones.click();sleep(500);
            mainPage260102.inputAdd3.click();sleep(500);
            mainPage260102.inputAgregarMercancia.click();sleep(500);
            mainPage260102.inputDeclaracion.click();sleep(500);
            mainPage260102.inputInformacionConfidencial.click();sleep(500);
            mainPage260102.inputResultadoIdc.sendKeys("MAVL621207C95");sleep(500);
            mainPage260102.inputConsultarIdc.click();sleep(500);
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260102.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260102.labelTerceros.click();
            //DESTINATARIO FINAL
            mainPage260102.inputAgregarDestinatario.click();sleep(500);
            mainPage260102.inputTercerosTipoPersonaMoral.sendKeys("Persona Moral");sleep(500);
            mainPage260102.inputTerceros.sendKeys("RFC123456789");sleep(500);
            mainPage260102.inputTercerosSocial.sendKeys("PRUEBAS SA DE CV");sleep(500);
            mainPage260102.selectTercerosEstado.sendKeys("MORELOS");sleep(500);
            mainPage260102.selectTercerosMunicipio.sendKeys("ZACATEPEC DE HIDALGO");sleep(1000);
            mainPage260102.selectTercerosLocalidad.sendKeys("GALEANA");sleep(1000);
            $("option[value='62780']").click();
            mainPage260102.selectTercerosColonia.sendKeys("VICENTE GUERRERO");sleep(500);
            mainPage260102.inputTercerosCalle.sendKeys("Calle Conocida");sleep(500);
            mainPage260102.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260102.inputTercerosNumInterior.sendKeys("A");sleep(500);
            mainPage260102.inputTercerosLada.sendKeys("52");
            mainPage260102.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260102.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260102.buttonGuardarDatosTercero.click();sleep(500);
            //FABRICANTE
            mainPage260102.inputAgregarTerceroTipersFab.click();
            //mainPage260102.inputTercerosNacionalidadMexicana.click();
            mainPage260102.inputTercerosTipoPersonaFisica.click();
            mainPage260102.inputTerceros2.sendKeys("AAL0409235E6");
            
            mainPage260102.btnBuscarEmpresa.click();
            mainPage260102.buttonGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            mainPage260102.labelPagoDerechos.click();
            mainPage260102.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260102.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260102.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260102.inputSolicitudPagoLlave.sendKeys("3456456243");
            mainPage260102.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260102.inputCalendar);sleep(100);

            mainPage260102.inputGuardarSolicitud.click();
            mainPage260102.inputGuarda.click();
            mainPage260102.inputAdjuntar.click();

            mainPage260102.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc8.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc9.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc10.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.selectDoc11.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260102.btnAnexar.click();
            mainPage260102.btnCerrar.click();
            mainPage260102.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260102);
            String folioText = mainPage260102.folio.getText();sleep(5000);
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
