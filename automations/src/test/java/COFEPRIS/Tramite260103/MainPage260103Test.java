package COFEPRIS.Tramite260103;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260103Test {
    MainPage260103 mainPage260103 = new MainPage260103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260103  = new TramitesFirmasLG(
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
    public void Proceso260103() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260103");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260103");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260103");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260103");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260103");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260103");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260103);
            mainPage260103.selecRol.sendKeys("Persona Moral");
            mainPage260103.btnacep.click();
            mainPage260103.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260103.SoliNew.click();
            mainPage260103.Cofepris.click();
            mainPage260103.linkCertificadosLicenciasPermisos.click();
            mainPage260103.linkPermisoSanitarioImportaciProductos.click();
            mainPage260103.linkPermisoSanImpRetProductos.click();
            //DATOS SOLICITANTE
            mainPage260103.labelDatosSolicitud.click();
            mainPage260103.inputEstablecimiento.click();sleep(2000);
            metodos.presionarEscYSpace();
            mainPage260103.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260103.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("12345");sleep(500);
            mainPage260103.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("MORELOS");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Zacatepec");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Galeana");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Vicente Guerrero");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle Ejemplo 123");sleep(500);
            mainPage260103.inputSolicitudEstablecimientoLada.sendKeys("52");
            mainPage260103.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5551234567");sleep(500);
            mainPage260103.inputScianAgregar.click();sleep(500);
            mainPage260103.selectComboScian.sendKeys("614079");sleep(500);
            mainPage260103.inputAgregar.click();sleep(500);
            mainPage260103.inputAvisoFuncionamiento.click();sleep(500);
            //mainPage260103.inputNumeroLicencia.sendKeys("434534");sleep(500);
            //mainPage260103.inputSolicitudTienePrioridad.click();sleep(500);
            mainPage260103.selectSolicitudRegimenClave.sendKeys("Definitivos");sleep(500);
            mainPage260103.selectSolicitudRegimenClave2.sendKeys("DOS BOCAS");sleep(500);
            mainPage260103.selectAduanas.click();sleep(500);
            mainPage260103.selectMercanciaGridClasificacionProducto.sendKeys("ALIMENTOS ");sleep(500);
            mainPage260103.selectMercanciaGridClasificacionProducto2.sendKeys("Lácteos");sleep(500);
            mainPage260103.inputDenominacionEspecifica.sendKeys("Prueba");sleep(500);
            mainPage260103.inputDenominacionEspecifica2.sendKeys("PROTEUS");sleep(500);
            mainPage260103.inputTipoTramiteMercancia.sendKeys("Otro");sleep(500);
            mainPage260103.inputEspecifique.sendKeys("YERVREY");
            mainPage260103.inputFraccionArancelaria.sendKeys("21069001");sleep(500);
            mainPage260103.inputCantidadUmt.sendKeys("10");sleep(500);
            mainPage260103.inputCantidadUmc.sendKeys("10");sleep(500);
            mainPage260103.inputDetalleUmc.sendKeys("Kilogramo");sleep(500);
            mainPage260103.buttonResolution.click();sleep(500);
            mainPage260103.optionAnguila.click();sleep(500);
            mainPage260103.inputAdd.click();sleep(500);
            mainPage260103.buttonResolution3.click();sleep(500);
            mainPage260103.optionAndorraPrincipado.click();sleep(500);
            mainPage260103.inputAdd2.click();sleep(500);
            mainPage260103.inputClaveLotes.sendKeys("12345");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '29/04/2025';", mainPage260103.inputFechaElaboracion);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '29/06/2025';", mainPage260103.inputFechaCaducidad);sleep(100);
            mainPage260103.inputAgregarNumeroLote.click();sleep(500);
            mainPage260103.buttonResolution4.click();sleep(500);
            mainPage260103.optionMaquila.click();sleep(500);
            mainPage260103.inputAdd3.click();sleep(500);
            mainPage260103.inputAgregarMercancia.click();sleep(500);
            mainPage260103.inputDeclaracion.click();sleep(500);
            mainPage260103.inputInformacionConfidencial.click();sleep(500);
            mainPage260103.inputResultadoIdc.sendKeys("MAVL621207C95");sleep(500);
            mainPage260103.inputConsultarIdc.click();sleep(500);
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260103.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260103.labelTerceros.click();
            //DESTINATARIO FINAL
            mainPage260103.inputAgregarDestinatario.click();sleep(500);
            mainPage260103.inputTercerosTipoPersonaMoral.sendKeys("Persona Moral");sleep(500);
            mainPage260103.inputTerceros.sendKeys("RFC123456789");sleep(500);
            mainPage260103.inputTercerosSocial.sendKeys("PRUEBAS SA DE CV");sleep(500);
            mainPage260103.selectTercerosEstado.sendKeys("MORELOS");sleep(500);
            mainPage260103.selectTercerosMunicipio.sendKeys("ZACATEPEC DE HIDALGO");sleep(1000);
            mainPage260103.selectTercerosLocalidad.sendKeys("GALEANA");sleep(1000);
            $("option[value='62780']").click();
            mainPage260103.selectTercerosColonia.sendKeys("VICENTE GUERRERO");sleep(500);
            mainPage260103.inputTercerosCalle.sendKeys("Calle Conocida");sleep(500);
            mainPage260103.inputTercerosNumExterior.sendKeys("123");sleep(500);
            mainPage260103.inputTercerosNumInterior.sendKeys("A");sleep(500);
            mainPage260103.inputTercerosLada.sendKeys("52");
            mainPage260103.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
            mainPage260103.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260103.buttonGuardarDatosTercero.click();sleep(500);
            //FABRICANTE
            mainPage260103.inputAgregarTerceroTipersFab.click();
            //mainPage260103.inputTercerosNacionalidadMexicana.click();
            mainPage260103.inputTercerosTipoPersonaFisica.click();
            mainPage260103.inputTercerosRFC.sendKeys("MAVL621207C95");
            mainPage260103.btnBuscarEmpresa.click();
//            mainPage260103.inputTercerosNombre.sendKeys("NAME");
//            mainPage260103.inputTercerosApellidoPaterno.sendKeys("LASTNAME");
//            mainPage260103.inputTercerosApellidoMaterno.sendKeys("MATERNAL LAST NAME");
//            mainPage260103.selectTercerosPais.sendKeys("ALEMANIA");
//            mainPage260103.inputTercerosEstado.sendKeys("PRUEBA QA");
//            mainPage260103.inputTercerosCodigoPostal.sendKeys("06900");
//            mainPage260103.inputTercerosCalle.sendKeys("PRUEBAS");
//            mainPage260103.inputTercerosNumExterior.sendKeys("123");sleep(500);
//            mainPage260103.inputTercerosNumInterior.sendKeys("1");sleep(500);
//            mainPage260103.inputTercerosLada.sendKeys("52");
//            mainPage260103.inputTercerosTelefono.sendKeys("5551234567");sleep(500);
//            mainPage260103.inputTercerosCorreoElec.sendKeys("correo@dominio.com");sleep(500);
            mainPage260103.buttonGuardarDatosTercero.click();sleep(500);
            //PAGO DE DERECHOS
            mainPage260103.labelPagoDerechos.click();
            mainPage260103.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260103.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260103.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260103.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260103.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260103.inputSolicitudPagoLlave.sendKeys("3456452543");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260103.inputCalendar);sleep(100);
            mainPage260103.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260103.InputGuardarSolicitud.click();
            mainPage260103.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage260103.btmAnexar.click();sleep(7000);
            Selenide.sleep(2000);
            mainPage260103.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260103.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260103);
            String folioText = mainPage260103.folio.getText();sleep(5000);
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