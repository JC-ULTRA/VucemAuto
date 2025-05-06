package COFEPRIS.Tramite260401;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260401Test {
    private static final Logger log = LoggerFactory.getLogger(MainPage260401Test.class);
    MainPage260401 mainPage260401 = new MainPage260401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite260401 = new TramitesFirmasLG(
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
    public void Proceso260401() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260401");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260401");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260401");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260401");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260401");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260401");

        ejecutarProcesoNRunnable(() -> {
        loginFirmSoli.login(tramite260401);
        mainPage260401.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage260401.btnacep.click(); sleep(1000);
        mainPage260401.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage260401.SoliNew.click(); sleep(1000);
        mainPage260401.Cofepris.click(); sleep(1000);
        mainPage260401.CertiLicPer.click(); sleep(1000);
        mainPage260401.PermisosInterSalidaProdHumano.click(); sleep(1000);
        mainPage260401.Tramite260401.click(); sleep(1000);
        //DATOS SOLICITUD
        mainPage260401.labelDatosSolicitud.click(); sleep(1000);
        mainPage260401.btnAgregarPropietario.click(); sleep(1000);
        mainPage260401.CheckNacional.click(); sleep(1000);
        mainPage260401.CheckPerFisica.click(); sleep(1000);
        mainPage260401.rfcPropietario.sendKeys("MAVL621207C95"); sleep(1000);
        mainPage260401.btnBuscarRFC.click(); sleep(1000);
        mainPage260401.btnGuardarPropietario.click(); sleep(1000);
        ///Datos del establecimiento
        mainPage260401.DenomiSocial.sendKeys("INTEGRADORA DE URBANIZACIONES SIGNUM, S DE RL DE CV "); sleep(1000);
        mainPage260401.Correo.sendKeys("Ultrasist@pruebas.com"); sleep(1000);
        mainPage260401.CP.sendKeys("95270"); sleep(1000);
        mainPage260401.Estado.sendKeys("VERACRUZ"); sleep(1000);
        mainPage260401.MunAlcald.sendKeys("ALVARADO"); sleep(1000);
        mainPage260401.Localidad.sendKeys("ALVARADO"); sleep(1000);
        mainPage260401.Colonia.sendKeys("CENTRO"); sleep(1000);
        mainPage260401.CalleEs.sendKeys("HERMENEGUILDO GALEANA"); sleep(1000);
        mainPage260401.Lada.sendKeys("52"); sleep(1000);
        mainPage260401.Telefono.sendKeys("2979725632"); sleep(1000);
        ///SCIAN
        mainPage260401.btnAgregarSCIAN.click(); sleep(1000);
        mainPage260401.ClaveSCIAN.sendKeys("311342"); sleep(1000);
        mainPage260401.btnAgregarSCIANOK.click(); sleep(1000);
        ///Formulario
        mainPage260401.rfcResponsable.sendKeys("LEQI8101314S7"); sleep(1000);
        mainPage260401.nombreResponsable.sendKeys("MISAEL BARRAGAN BARRAGAN"); sleep(1000);
        //mainPage260401.nLicSani.sendKeys(llavePago); sleep(1000);
        mainPage260401.btnAgregarLicSani.click(); sleep(1000);
        mainPage260401.regiDestMerca.sendKeys("Definitivos"); sleep(1000);
        mainPage260401.AduanaEntrada.sendKeys("ACAPULCO, PUERTO Y AEROPUERTO"); sleep(1000);
        mainPage260401.btnAgregarProducto.click(); sleep(1000);
        mainPage260401.nombreEspecifico.sendKeys("NombreEs."); sleep(1000);
        mainPage260401.tipoProductoMerca.sendKeys("Células."); sleep(1000);
        mainPage260401.fracArancel.sendKeys("30021299."); sleep(1000);
        mainPage260401.cantidadUMTPro.sendKeys("12"); sleep(1000);
        mainPage260401.cantidadVol.sendKeys("12"); sleep(1000);
        mainPage260401.unIdadMedida.sendKeys("Botellas"); sleep(1000);
        mainPage260401.PresFarmaEnv.sendKeys("Presentación farmacéutica o tipo de"); sleep(1000);
        mainPage260401.EnvprimarioAl.sendKeys("Botella"); sleep(1000);
        mainPage260401.EnvSecundariAl.sendKeys("Cajas"); sleep(1000);
        mainPage260401.EnvprimarioCT.sendKeys("Botella"); sleep(1000);
        mainPage260401.EnvSecundariTC.sendKeys("Caja"); sleep(1000);
        mainPage260401.PaisOrgClick1.click(); sleep(1000);
        mainPage260401.PaisOrgAntartida2.click(); sleep(1000);
        mainPage260401.PaisOrgClick3.click(); sleep(1000);
        mainPage260401.usEspesific.sendKeys("Internación al territorio nacional de córneas destinados a tratamiento con fines terapéuticos."); sleep(1000);
        mainPage260401.btnAgregarUsEspecifico.click(); sleep(1000);
        ///Manifiesto y Representante Legal
        mainPage260401.CheckManifiesto.click(); sleep(1000);
        mainPage260401.CheckNo.click(); sleep(1000);
        mainPage260401.RFCRepreLegal.sendKeys("MAVL621207C95"); sleep(1000);
        mainPage260401.btnBuscarRfcRepreLegal.click(); sleep(1000);
//TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        mainPage260401.labelTercerosRelacionados.click();
mainPage260401.inputAgregarTercero.click();
        mainPage260401.inputPersonaMoral.click();
        mainPage260401.inputTerceroRazonSocial.sendKeys("PRUEBITAS SC");
mainPage260401.inputPais.sendKeys("ALEMANIA");
mainPage260401.terceroEstadoLocalidad.sendKeys("QUERETARO");
mainPage260401.terceroCodigoPostal.sendKeys("01234");
mainPage260401.terceroCalle.sendKeys("CONOCIDA POR TODOS");
mainPage260401.terceroNumExterior.sendKeys("2");
mainPage260401.terceroNumInterior.sendKeys("102");
mainPage260401.terceroLada.sendKeys("52");
mainPage260401.terceroTelefono.sendKeys("1234567890");
mainPage260401.terceroCorreo.sendKeys("prueba@ultrasist.com");
mainPage260401.btnGuardarDatosTerceros.click();
//PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260401.labelPagoDerechos.click();
            mainPage260401.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260401.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260401.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260401.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260401.inputSolicitudPagoLlave.sendKeys("3456452543");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260401.inputCalendar);sleep(100);
            mainPage260401.inputSolicitudPagoImp.sendKeys("2000");


            mainPage260401.inputGuardarSolicitud.click();
            mainPage260401.inputGuarda.click();
            mainPage260401.inputAdjuntar.click();

            mainPage260401.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.selectDoc8.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260401.btnAnexar.click();sleep(8000);
            mainPage260401.btnCerrar.click();sleep(4000);
            mainPage260401.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260401);
            String folioText = mainPage260401.folio.getText();sleep(5000);
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