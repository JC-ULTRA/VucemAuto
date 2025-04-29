package COFEPRIS.Tramite260218;

import COFEPRIS.Tramite260218.MainPage260218;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260218Test {
    MainPage260218 mainPage260218 = new MainPage260218();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260218  = new TramitesFirmasLG(
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
    public void Proceso260218() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260218");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260218");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260218");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260218");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260218");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260218");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260218);
            mainPage260218.selecRol.sendKeys("Persona Moral");
            mainPage260218.btnacep.click();
            mainPage260218.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260218.SoliNew.click();
            mainPage260218.Cofepris.click();
            mainPage260218.linkCertificadosLicenciasPermisos.click();
            mainPage260218.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260218.linkPerSanImpDisMedDesPruLab.click();
            //DATOS SOLICITUD
            mainPage260218.labelDatosSolicitud.click();
            mainPage260218.inputEstablecimiento.click();
            mainPage260218.btnAceptar.click();
            mainPage260218.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260218.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260218.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260218.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260218.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260218.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260218.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260218.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260218.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260218.inputLada.sendKeys("52");
            mainPage260218.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260218.inputScianAgregar.click();
            mainPage260218.comboSCIAN.selectOption("311239");
            mainPage260218.inputAgregar.click();
            mainPage260218.inputAvisoFuncionamiento.click();
            mainPage260218.solicitudRegimen.sendKeys("Definitivos");
            mainPage260218.aduanaEntrada.selectOption("CIUDAD HIDALGO");
            mainPage260218.inputAgregarAduana.click();
            mainPage260218.selectClasificacionProducto.sendKeys("REMEDIOS HERBOLARIOS ");
            mainPage260218.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260218.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260218.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260218.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260218.selectTipoProductoTipoTramite.sendKeys("Producto a granel");
            mainPage260218.selectEstadoFisico.sendKeys("Liquido");
            mainPage260218.inputFraccionArancelaria.sendKeys("30039013");
            mainPage260218.inputCantidadUMT.sendKeys("100");
            mainPage260218.inputCantidadUMC.sendKeys("10");
            mainPage260218.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260218.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260218.buttonAbrirPanelPaisesOrigen.click();
            mainPage260218.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260218.inputAgregarSeleccion.click();
            mainPage260218.inputAbrirPanelPaisesProcedencia.click();
            mainPage260218.PaisProcedencia.selectOptionContainingText("ARABIA SAUDITA (REINO DE)");
            mainPage260218.inputAgregarSeleccion2.click();
            mainPage260218.botonAbrirPanelUsosEspecificos.click();
            mainPage260218.UsoEspecifico.sendKeys("DEMOASTRACIÓN");
            mainPage260218.botonAgregarSeleccion.click();
            mainPage260218.inputAgregarMercancia.click();
            mainPage260218.inputDeclaracion.click();
            mainPage260218.inputInformacionConfidencialNo.click();
            mainPage260218.inputRepresentanteLegalRFC.sendKeys("MAVL621207C95");
            mainPage260218.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260218.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260218.labelTerceroRElacionado.click();
            //DESTINATARIO
            mainPage260218.inputAgregarDestinatario.click();
            mainPage260218.inputTipoPeronaMoral.click();
            mainPage260218.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260218.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260218.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260218.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260218.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260218.terceroCodigoPostal2.sendKeys("06278");
            mainPage260218.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260218.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260218.terceroNumExterior2.sendKeys("123");
            mainPage260218.terceroNumInterior2.sendKeys("4B");
            mainPage260218.tercerosLada.sendKeys("55");
            mainPage260218.terceroTelefono2.sendKeys("5555555555");
            mainPage260218.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260218.btnGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            mainPage260218.labelPagoDerechos.click();
            mainPage260218.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260218.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260218.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260218.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260218.inputCalendar);sleep(100);
            mainPage260218.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260218.inputGuardarSolicitud.click();

//GUARDAR
            mainPage260218.inputGuarda.click();sleep(1000);
            mainPage260218.inputAdjuntar.click();
            mainPage260218.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260218.btnAnexar.click();sleep(20000);
            mainPage260218.btnCerrar.click();
            mainPage260218.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260218);
            String folioText = mainPage260218.folio.getText();
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
