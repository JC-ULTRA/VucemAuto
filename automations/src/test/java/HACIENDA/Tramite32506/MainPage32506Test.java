package HACIENDA.Tramite32506;

import DBYFOLIO.ConDBReasigSolFun;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32506Test {
    MainPage32506 mainPage32506 = new MainPage32506();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32506  = new TramitesFirmasLG(
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
    public void Proceso32506() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32506");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32506");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32506");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32506");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32506");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32506");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            loginFirmSoli.login(tramite32506);
            mainPage32506.selecRol.sendKeys("Persona Moral");
            mainPage32506.btnacep.click();
            mainPage32506.Tramites.click();
            mainPage32506.SoliNew.click();
            mainPage32506.Hacienda.click();
            mainPage32506.RegisCE.click();
            mainPage32506.EnvioAviso.click();
            mainPage32506.Tramite32506.click();
            //AVISO
            mainPage32506.labelAviso.click();sleep(500);
            mainPage32506.NumeroIMMEX.sendKeys("52685");sleep(500);
            mainPage32506.AñoIMMEX.sendKeys("2025");sleep(500);
            mainPage32506.inputNoHabitual.click();sleep(500);
            //mainPage32506.btnAceptar.click();sleep(500);
            //mainPage32506.inputJustificacion.sendKeys("PARA PRUEBAS");
            //mainPage32506.inputPeriodicidad.sendKeys("CADA QUE SE REALICE OTRA PRUEBA");
            mainPage32506.inputNombreComercial.sendKeys("PRUEBUS");sleep(500);
            mainPage32506.selectEntidadFederativa.sendKeys("DURANGO");sleep(500);
            mainPage32506.selectAlcaldiaMunicipio.sendKeys("DURANGO");sleep(500);
            mainPage32506.selectColonia.sendKeys("20 DE NOVIEMBRE - CP 34");sleep(500);
            mainPage32506.inputCalle.sendKeys("CONOCIDA");sleep(500);
            mainPage32506.NumeroExterior.sendKeys("12");sleep(500);
            mainPage32506.NumeroInterior.sendKeys("5");sleep(500);
            mainPage32506.CodigoPostal.sendKeys("34234");sleep(500);
            mainPage32506.inputManual.click();sleep(500);
            mainPage32506.inputAgregar.click();sleep(500);
            mainPage32506.NombreComercial.sendKeys("Carpinteria Gonalez");sleep(500);
            mainPage32506.inputEntidadFederal.sendKeys("CHIAPAS");sleep(500);
            mainPage32506.inputMunicipio.sendKeys("BENEMERITO DE LAS AMERICAS");sleep(500);
            mainPage32506.inputColonia.sendKeys("CENTRO - CP 29955");sleep(500);
            mainPage32506.inputCalle1.sendKeys("CONOCIDA");sleep(500);
            mainPage32506.inputNumExterior.sendKeys("132");sleep(500);
            mainPage32506.inputNumInterior.sendKeys("1");sleep(500);
            mainPage32506.inputCodigoPostal.sendKeys("03456");sleep(500);
            mainPage32506.inputHoraRegistro.sendKeys("13:24");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '30/05/2025';", mainPage32506.inputFechaRegistro); sleep(1000);
            mainPage32506.btnAgregarProceso.click();sleep(500);
            mainPage32506.inputDescripcionProceso.sendKeys("POR PRUEBAS");sleep(500);
            mainPage32506.inputAgregarDesperdicio.sendKeys("PRUEBAS QA");sleep(500);
            mainPage32506.inputDescripcion.sendKeys("PRUEBA");sleep(500);
            mainPage32506.inputCantidadDesp.sendKeys("14");sleep(500);
            mainPage32506.inputUMD.sendKeys("Caja");sleep(500);
            mainPage32506.inputPorcentaje.sendKeys("24");sleep(500);
            mainPage32506.inputDescripcionMercancia.sendKeys("PRUEBA");sleep(500);
            mainPage32506.inputDeclaratoria.click();sleep(500);
            mainPage32506.inputHechos.sendKeys("PRUEBAS");sleep(500);
            mainPage32506.btnAgrgarPedimento.click();sleep(500);
            mainPage32506.inputNumPatente.sendKeys("12345");sleep(500);
            mainPage32506.inputNumPedimento.sendKeys("1243");sleep(500);
            mainPage32506.inputAduana.sendKeys("AEROPUERTO INTERNACIONAL FELIPE ÁNGELES");sleep(500);
            mainPage32506.inputFraccionArancelaria.sendKeys("01023999");sleep(500);
            mainPage32506.inputNICO.sendKeys("00");sleep(500);
            mainPage32506.inputCantidad.sendKeys("35");sleep(500);
            mainPage32506.inputUMP.sendKeys("Caja");sleep(500);
            mainPage32506.inputBotonAgregar.click();sleep(500);
            mainPage32506.btnAceptar2.click();sleep(500);
            mainPage32506.btnAgregarM3.click();sleep(500);
            mainPage32506.btnAceptar3.click();sleep(500);
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32506.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32506.btnAgregarM2.click();sleep(500);
            mainPage32506.btnAceptar4.click();sleep(500);
            mainPage32506.btnAgregarM1.click();sleep(500);
            mainPage32506.btnAceptar5.click();sleep(500);

            mainPage32506.inputGuardarSolicitud.click();sleep(500);
            mainPage32506.btnContinuar.click();sleep(500);
            mainPage32506.btnAdjuntarDoc.click();sleep(500);
            mainPage32506.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32506.btnAdjuntar.click();sleep(9000);
            mainPage32506.btnCerrar.click();
            mainPage32506.btnSiguiente.click();sleep(500);
            //Firmas
            loginFirmSoli.firma(tramite32506);sleep(500);
            String folioText = mainPage32506.folio.getText();sleep(2000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
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