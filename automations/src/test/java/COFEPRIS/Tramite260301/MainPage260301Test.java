package COFEPRIS.Tramite260301;

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

public class MainPage260301Test {
    MainPage260301 mainPage260301 = new MainPage260301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260301  = new TramitesFirmasLG(
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
    public void Proceso260301() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260301");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260301");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260301");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260301");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260301");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260301");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260301);
            mainPage260301.selecRol.sendKeys("Persona Moral");
            mainPage260301.btnacep.click();
            mainPage260301.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260301.SoliNew.click();
            mainPage260301.Cofepris.click();
            mainPage260301.linkCertificadosLicenciasPermisos.click();
            mainPage260301.linkPermisoSanImpExpEstPsi.click();
            mainPage260301.linkPermisoImpMatPriEstPsi.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260301.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260301.labelDatosSolicitud.click();
            mainPage260301.inputEstablecimiento.click();
            mainPage260301.divAceptar.click();
            mainPage260301.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260301.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("12345");sleep(500);
            mainPage260301.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("MORELOS");sleep(500);
            mainPage260301.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Zacatepec");sleep(500);
            mainPage260301.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Galeana");sleep(500);
            mainPage260301.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Vicente Guerrero");sleep(500);
            mainPage260301.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle Ejemplo 123");sleep(500);
            mainPage260301.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");sleep(500);
            mainPage260301.InputSolicitudEstablecimientoRFC.sendKeys("MAVL621207C95");
            mainPage260301.InputSolicitudEstablecimientoLada.sendKeys("52");
            mainPage260301.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5551234567");sleep(500);
            mainPage260301.inputScianAgregar.click();sleep(500);
            mainPage260301.selectComboScian.sendKeys("311321");sleep(500);
            mainPage260301.inputAgregar.click();sleep(500);
            mainPage260301.inputAvisoFuncionamiento.click();sleep(500);
            mainPage260301.selectAduanas.click();sleep(500);
            mainPage260301.selectMercanciaGridClasificacionProducto.sendKeys("PSICOTROPICOS");sleep(500);
            mainPage260301.selectMercanciaGridClasificacionProducto2.sendKeys("TRAMITE PRUEBA");sleep(500);
            mainPage260301.inputDenominacionEspecifica.sendKeys("Prueba");sleep(500);
            mainPage260301.inputDenominacionEspecifica2.sendKeys("Prueba");sleep(500);
            mainPage260301.inputTipoTramiteMercancia.sendKeys("Producto a granel");sleep(500);
            mainPage260301.inputTipoTramiteEstadoTramite.sendKeys("Líquido");
            mainPage260301.inputFormaFarmaceutica.click();
            mainPage260301.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260301.btnAgregarFormaFarmaceutica.click();
            mainPage260301.inputFraccionArancelaria.sendKeys("13021199");sleep(500);
            mainPage260301.inputCantidadUmt.sendKeys("10");sleep(500);
            mainPage260301.inputCantidadUmc.sendKeys("5");sleep(500);
            mainPage260301.inputDetalleUmc.sendKeys("Gramo Neto");sleep(500);
            mainPage260301.inputNumeroCAS.sendKeys("5523245343");
            mainPage260301.inputCantidadLotes.sendKeys("10");
            mainPage260301.inputKGLotes.sendKeys("10");
            mainPage260301.inputPaisOrigen.click();
            mainPage260301.selectPaisOrigen.click();
            mainPage260301.btnAgregarSeleccion.click();
            mainPage260301.inputPaisProcedencia.sendKeys("ARABIA SAUDITA (REINO DE)");
            mainPage260301.inputUsoEspecifico.click();
            mainPage260301.selectUsoEspecifico.click();
            mainPage260301.inputAgregarUsoEspecifico.click();
            mainPage260301.inputDetallaUsoEspecifico.sendKeys("PARA USO DE PRUEBAS");
            mainPage260301.inputPiezaFabricar.sendKeys("10");
            mainPage260301.inputDetalle.sendKeys("PARA PRUEBAS QA");
            mainPage260301.inputRegistroSanitario.sendKeys("43534534");
            mainPage260301.inputPresentacion.sendKeys("PRUEBAS PRUEBAS QA");
            mainPage260301.btnAgregarDetalle.click();
            mainPage260301.inputAgregarMercancia.click();sleep(500);
            mainPage260301.inputAduanas.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260301.inputDeclaracion.click();
            mainPage260301.inputNoConfidencial.click();
            mainPage260301.inputResultadoIdc.sendKeys("MAVL621207C95");sleep(500);
            mainPage260301.inputConsultarIdc.click();sleep(500);
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260301.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260301.labelTerceros.click();
            mainPage260301.inputAgregarTerceroTipersFab.click();
            mainPage260301.inputDenominacion.sendKeys("PRUEBAS");
            mainPage260301.inputPais.sendKeys("ARGELIA");
            mainPage260301.inputEstado.sendKeys("CDMX");
            mainPage260301.selectTercerosCodPostal.sendKeys("06900");
            mainPage260301.inputTercerosCalle.sendKeys("Calle Conocida");sleep(500);
            mainPage260301.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260301.inputTercerosNumInterior.sendKeys("A");sleep(500);
            mainPage260301.inputTercerosLada.sendKeys("52");
            mainPage260301.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260301.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260301.buttonGuardarDatosTercero.click();sleep(500);

            mainPage260301.btnAgregarFacturador.click();sleep(500);
            mainPage260301.inputTercerosTipoPersonaMoral.sendKeys("Persona Moral");sleep(500);
            mainPage260301.inputTerceros.sendKeys("RFC123456789");sleep(500);
            mainPage260301.inputTercerosSocial.sendKeys("PRUEBAS SA DE CV");sleep(500);
            mainPage260301.selectTercerosEstado.sendKeys("MORELOS");sleep(500);
            mainPage260301.selectTercerosMunicipio.sendKeys("ZACATEPEC DE HIDALGO");sleep(1000);
            mainPage260301.selectTercerosLocalidad.sendKeys("GALEANA");sleep(1000);
            $("option[value='62780']").click();
            mainPage260301.selectTercerosColonia.sendKeys("VICENTE GUERRERO");sleep(500);



            //GUARDAR
            mainPage260301.inputGuarda.click();
            mainPage260301.inputAdjuntar.click();
            mainPage260301.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260301.btnAnexar.click();sleep(20000);
            mainPage260301.btnCerrar.click();
            mainPage260301.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260301);
            String folioText = mainPage260301.folio.getText();sleep(5000);
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