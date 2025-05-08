package COFEPRIS.Tramite260104;
import COFEPRIS.Tramite260104.MainPage260104;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
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
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260104Test {
    MainPage260104 mainPage260104 = new MainPage260104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260104  = new TramitesFirmasLG(
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
    public void Proceso260104() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260104");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260104");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260104");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260104");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260104");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260104");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260104);
            mainPage260104.selecRol.sendKeys("Persona Moral");
            mainPage260104.btnacep.click();
            mainPage260104.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260104.SoliNew.click();
            mainPage260104.Cofepris.click();
            mainPage260104.linkCertificadosLicenciasPermisos.click();
            mainPage260104.linkPermisoSanitarioImportaciProductos.click();
            mainPage260104.linkPermisoSanImpProTabaco.click();
            //DATOS SOLICITANTE
            mainPage260104.labelDatosSolicitud.click();
            mainPage260104.inputEstablecimiento.click();
            mainPage260104.divAceptar.click();
            mainPage260104.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260104.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("12345");sleep(500);
            mainPage260104.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("MORELOS");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Zacatepec");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Galeana");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Vicente Guerrero");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle Ejemplo 123");sleep(500);
            mainPage260104.inputSolicitudEstablecimientoLada.sendKeys("52");
            mainPage260104.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5551234567");sleep(500);
            mainPage260104.inputScianAgregar.click();sleep(500);
            mainPage260104.selectComboScian.sendKeys("614061");sleep(500);
            mainPage260104.inputAgregar.click();sleep(500);
            mainPage260104.inputAvisoFuncionamiento.click();sleep(500);
            //mainPage260104.inputNumeroLicencia.sendKeys("434534");sleep(500);
            //mainPage260104.inputSolicitudTienePrioridad.click();sleep(500);
            mainPage260104.selectSolicitudRegimenClave.sendKeys("Depósito Fiscal");sleep(500);
            mainPage260104.selectSolicitudRegimenClave2.sendKeys("DOS BOCAS");sleep(500);
            mainPage260104.selectAduanas.click();sleep(500);
            mainPage260104.selectMercanciaGridClasificacionProducto.sendKeys("TABACO ");sleep(500);
            mainPage260104.selectMercanciaGridClasificacionProducto2.sendKeys("Puritos");sleep(500);
            mainPage260104.inputDenominacionEspecifica.sendKeys("Prueba");sleep(500);
            mainPage260104.inputDenominacionEspecifica2.sendKeys("PROTEUS");sleep(500);
            mainPage260104.inputTipoTramiteMercancia.sendKeys("Otro");sleep(500);
            mainPage260104.inputEspecifique.sendKeys("YERVREY");
            mainPage260104.inputFraccionArancelaria.sendKeys("24022001");sleep(500);
            mainPage260104.inputCantidadUmt.sendKeys("10");sleep(500);
            mainPage260104.inputCantidadUmc.sendKeys("10");sleep(500);
            mainPage260104.inputDetalleUmc.sendKeys("B.U.I");sleep(500);
            mainPage260104.buttonResolution.click();sleep(500);
            mainPage260104.optionAnguila.click();sleep(500);
            mainPage260104.inputAdd.click();sleep(500);
            mainPage260104.buttonResolution3.click();sleep(500);
            mainPage260104.optionAndorraPrincipado.click();sleep(500);
            mainPage260104.inputAdd2.click();sleep(500);
            mainPage260104.inputClaveLotes.sendKeys("12345");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '29/04/2025';", mainPage260104.inputFechaElaboracion);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '29/06/2025';", mainPage260104.inputFechaCaducidad);sleep(100);
            mainPage260104.inputAgregarNumeroLote.click();sleep(500);
            mainPage260104.buttonResolution4.click();sleep(500);
            mainPage260104.optionMaquila.click();sleep(500);
            mainPage260104.inputAdd3.click();sleep(500);
            mainPage260104.inputAgregarMercancia.click();sleep(500);
            mainPage260104.inputDeclaracion.click();sleep(500);
            mainPage260104.inputInformacionConfidencial.click();sleep(500);
            mainPage260104.inputResultadoIdc.sendKeys("MAVL621207C95");sleep(500);
            mainPage260104.inputConsultarIdc.click();sleep(500);
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260104.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260104.labelTerceros.click();
            //DESTINATARIO FINAL
            mainPage260104.inputAgregarDestinatario.click();sleep(500);
            mainPage260104.inputTercerosTipoPersonaMoral.sendKeys("Persona Moral");sleep(500);
            mainPage260104.inputTerceros.sendKeys("RFC123456789");sleep(500);
            mainPage260104.inputTercerosSocial.sendKeys("PRUEBAS SA DE CV");sleep(500);
            mainPage260104.selectTercerosEstado.sendKeys("MORELOS");sleep(500);
            mainPage260104.selectTercerosMunicipio.sendKeys("ZACATEPEC DE HIDALGO");sleep(1000);
            mainPage260104.selectTercerosLocalidad.sendKeys("GALEANA");sleep(1000);
            $("option[value='62780']").click();
            mainPage260104.selectTercerosColonia.sendKeys("VICENTE GUERRERO");sleep(500);
            mainPage260104.inputTercerosCalle.sendKeys("Calle Conocida");sleep(500);
            mainPage260104.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260104.inputTercerosNumInterior.sendKeys("A");sleep(500);
            mainPage260104.inputTercerosLada.sendKeys("52");
            mainPage260104.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260104.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260104.buttonGuardarDatosTercero.click();sleep(500);
            //FABRICANTE
            mainPage260104.inputAgregarTerceroTipersFab.click();
            //mainPage260104.inputTercerosNacionalidadMexicana.click();
            mainPage260104.inputTercerosTipoPersonaFisica.click();
            mainPage260104.inputTercerosNombre.sendKeys("NAME");
            mainPage260104.inputTercerosApellidoPaterno.sendKeys("LASTNAME");
            mainPage260104.inputTercerosApellidoMaterno.sendKeys("MATERNAL LAST NAME");
            mainPage260104.selectTercerosPais.sendKeys("ALEMANIA");
            mainPage260104.inputTercerosEstado.sendKeys("PRUEBA QA");
            mainPage260104.inputTercerosCodigoPostal.sendKeys("06900");
            mainPage260104.inputTercerosCalle.sendKeys("PRUEBAS");
            mainPage260104.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260104.inputTercerosNumInterior.sendKeys("1");sleep(500);
            mainPage260104.inputTercerosLada.sendKeys("52");
            mainPage260104.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260104.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260104.buttonGuardarDatosTercero.click();sleep(500);

            //PAGO DE DERECHOS
            mainPage260104.labelPagoDerechos.click();
            mainPage260104.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260104.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260104.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260104.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260104.inputSolicitudPagoLlave.sendKeys("3456452543");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260104.inputCalendar);sleep(100);
            mainPage260104.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260104.inputGuardarSolicitud.click();
            mainPage260104.inputGuarda.click();
            mainPage260104.inputAdjuntar.click();
            mainPage260104.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260104.btnAnexar.click();sleep(5000);
            mainPage260104.btnCerrar.click();sleep(10000);
            mainPage260104.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260104);
            String folioText = mainPage260104.folio.getText();sleep(5000);
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