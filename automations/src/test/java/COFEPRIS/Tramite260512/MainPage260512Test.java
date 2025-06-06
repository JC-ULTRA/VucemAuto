package COFEPRIS.Tramite260512;

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

public class MainPage260512Test {
    MainPage260512 mainPage260512 = new MainPage260512();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260512  = new TramitesFirmasLG(
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
    public void Proceso260512() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260512");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260512");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260512");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260512");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260512");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260512");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260512);
            mainPage260512.selecRol.sendKeys("Persona Moral");
            mainPage260512.btnacep.click();
            mainPage260512.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260512.SoliNew.click();
            mainPage260512.Cofepris.click();
            mainPage260512.linkCertificadosLicenciasPermisos.click();
            mainPage260512.linkPermisoImportPlagNutriVegTox.click();
            mainPage260512.linkPermisoImportacionSustanciasToxicas.click();
            //DATOS SSOLICITANTE
            mainPage260512.labelDatosSolicitud.click();
            mainPage260512.inputEstablecimiento.click();
            mainPage260512.buttonAceptar.click();
            mainPage260512.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260512.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260512.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260512.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260512.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260512.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260512.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260512.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260512.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260512.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260512.inputScianAgregar.click();
            mainPage260512.comboSCIAN.selectOption("434230"); //148
            mainPage260512.inputAgregar.click();
            //mainPage260512.inputAvisoFuncionamiento.click();
            mainPage260512.inputLicenciaSanitaria.sendKeys("46456456");
            mainPage260512.inputAduanEntradaDispo.sendKeys("CIUDAD ACUÑA");
            mainPage260512.inputAgregarAduanaEntrada.click();
            //mainPage260512.solicitudRegimen.sendKeys("Definitivos");
            //mainPage260512.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260512.inputAgregarAduana.click();
            mainPage260512.inputNombreComercial.sendKeys("QA");
            mainPage260512.inputNombrecomun.sendKeys("QA");
            mainPage260512.inputNombreCientifico.sendKeys("QA");
            mainPage260512.inputUsoEspecifico.sendKeys("QA");
            //mainPage260512.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            //mainPage260512.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260512.selectFormaFarmaceutica.selectOptionContainingText("Polvo");
            mainPage260512.selectEstadoFisico.selectOptionContainingText("Gaseoso");
            mainPage260512.inputFraccionArancelaria.sendKeys("29121201");
            mainPage260512.inputCantidadUMT.sendKeys("100");
            mainPage260512.inputCantidadUMC.sendKeys("10");
            mainPage260512.selectUnidadMedidaComercial.sendKeys("Bulto");
            mainPage260512.inputCas.sendKeys("4566");
            mainPage260512.inputPorcentajeConcen.sendKeys("45");
            mainPage260512.buttonAbrirPanelPaisesOrigen.click();
            mainPage260512.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260512.inputAgregarSeleccion.click();
            mainPage260512.inputAbrirPanelPaisesProcedencia.click();
            mainPage260512.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260512.inpiutAgregarPais.click();
            mainPage260512.inputClasifToxi.sendKeys("I EXTREMADAMENTE TOXICO");
            mainPage260512.inputObjetoImport.sendKeys("Formulación");
            //mainPage260512.UsoEspecifico.sendKeys("VENTA O COMERCIALIZACIÓN");
            //mainPage260512.botonAgregarSeleccion.click();
            mainPage260512.inputAgregarMercancia.click();
            mainPage260512.inputDeclaracion.click();
            mainPage260512.inputInformacionConfidencialNo.click();
            mainPage260512.inputRepresentanteLegalRFC.sendKeys("ZURA6808202RA");
            mainPage260512.inputConsultarIDC.click();
            //PAGO DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260512.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260512.labelPagoDerechos.click();
            mainPage260512.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260512.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260512.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260512.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260512.inputCalendar);sleep(100);
            mainPage260512.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260512.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260512.inputGuarda.click();
            mainPage260512.inputAdjuntar.click();
            mainPage260512.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260512.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260512.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260512.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260512.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260512.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260512.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260512.btnAnexar.click();sleep(20000);
            mainPage260512.btnCerrar.click();
            mainPage260512.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260512);
            String folioText = mainPage260512.folio.getText();sleep(5000);
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