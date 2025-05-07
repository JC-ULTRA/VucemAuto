package COFEPRIS.Tramite260217;

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

public class MainPage260217Test {
    MainPage260217 mainPage260217 = new MainPage260217();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260217  = new TramitesFirmasLG(
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
    public void Proceso260217() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260217");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260217");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260217");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260217");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260217");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260217");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260217);
            mainPage260217.selecRol.sendKeys("Persona Moral");
            mainPage260217.btnacep.click();
            mainPage260217.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260217.SoliNew.click();
            mainPage260217.Cofepris.click();
            mainPage260217.linkCertificadosLicenciasPermisos.click();
            mainPage260217.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260217.linkPerSanImpDisMedRegUsa.click();
            //DATOS SOLICITUD
            mainPage260217.labelDatosSolicitud.click();
            mainPage260217.inputEstablecimiento.click();
            mainPage260217.btnAceptar.click();
            mainPage260217.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260217.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260217.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260217.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260217.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260217.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260217.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260217.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260217.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260217.inputLada.sendKeys("52");
            mainPage260217.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260217.inputScianAgregar.click();
            mainPage260217.comboSCIAN.selectOption("311311");
            mainPage260217.inputAgregar.click();
            mainPage260217.inputLicenciaSanitaria.sendKeys("5645464353");
            mainPage260217.solicitudRegimen.sendKeys("Definitivos");
            mainPage260217.aduanaEntrada.selectOption("CIUDAD HIDALGO");
            mainPage260217.inputAgregarAduana.click();
            mainPage260217.selectClasificacionProducto.sendKeys("REMEDIOS HERBOLARIOS ");
            mainPage260217.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260217.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260217.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260217.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260217.selectTipoProductoTipoTramite.sendKeys("Producto a granel");
            mainPage260217.selectEstadoFisico.sendKeys("Semisolido");
            mainPage260217.inputFraccionArancelaria.sendKeys("30066001");
            mainPage260217.inputCantidadUMT.sendKeys("100");
            mainPage260217.inputCantidadUMC.sendKeys("10");
            mainPage260217.selectUnidadMedidaComercial.sendKeys("Ampolleta");
            mainPage260217.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260217.buttonAbrirPanelPaisesOrigen.click();
            mainPage260217.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260217.inputAgregarSeleccion.click();
            mainPage260217.inputAbrirPanelPaisesProcedencia.click();
            mainPage260217.PaisProcedencia.selectOptionContainingText("ARABIA SAUDITA (REINO DE)");
            mainPage260217.inputAgregarSeleccion2.click();
            mainPage260217.botonAbrirPanelUsosEspecificos.click();
            mainPage260217.UsoEspecifico.sendKeys("Uso médico");
            mainPage260217.botonAgregarSeleccion.click();
            mainPage260217.inputAgregarMercancia.click();
            mainPage260217.inputDeclaracion.click();
            mainPage260217.inputInformacionConfidencialNo.click();
            mainPage260217.inputRepresentanteLegalRFC.sendKeys("MAVL621207C95");
            mainPage260217.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260217.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DESTINATARIO
            mainPage260217.labelTerceroRelacionado.click();
            mainPage260217.inputAgregarDestinatario.click();
            mainPage260217.inputTipoPeronaMoral.click();
            mainPage260217.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260217.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260217.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260217.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260217.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260217.terceroCodigoPostal2.sendKeys("06278");
            mainPage260217.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260217.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260217.terceroNumExterior2.sendKeys("123");
            mainPage260217.terceroNumInterior2.sendKeys("4B");
            mainPage260217.tercerosLada.sendKeys("55");
            mainPage260217.terceroTelefono2.sendKeys("5555555555");
            mainPage260217.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260217.btnGuardarDatosTercero2.click();
            //FABRICANTE
            mainPage260217.inputAgregarFabricante.click();
            mainPage260217.inputNacionalidadMexicana.click();
            mainPage260217.inputTipoPeronaMoral.click();
            mainPage260217.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260217.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260217.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260217.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260217.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260217.terceroCodigoPostal2.sendKeys("06278");
            mainPage260217.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260217.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260217.terceroNumExterior2.sendKeys("123");
            mainPage260217.terceroNumInterior2.sendKeys("4B");
            mainPage260217.tercerosLada.sendKeys("55");
            mainPage260217.terceroTelefono2.sendKeys("5555555555");
            mainPage260217.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260217.btnGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            mainPage260217.labelPagoDerechos.click();
            mainPage260217.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260217.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260217.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260217.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260217.inputCalendar);sleep(100);
            mainPage260217.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260217.inputGuardarSolicitud.click();

//GUARDAR
            mainPage260217.inputGuarda.click();sleep(1000);
            mainPage260217.inputAdjuntar.click();
            mainPage260217.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260217.btnAnexar.click();sleep(20000);
            mainPage260217.btnCerrar.click();sleep(4500);
            mainPage260217.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260217);
            String folioText = mainPage260217.folio.getText();
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