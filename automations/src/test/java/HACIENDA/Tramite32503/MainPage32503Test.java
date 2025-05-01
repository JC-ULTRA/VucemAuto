package HACIENDA.Tramite32503;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32503.MainPage32503;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32503Test {
    MainPage32503 mainPage32503 = new MainPage32503();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32503 = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32503() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
//            desactivarPago();

            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            loginFirmSoli.login(tramite32503);
            mainPage32503.selecRol.sendKeys("Persona Moral");
            mainPage32503.btnacep.click();
            mainPage32503.Tramites.click();
            mainPage32503.SoliNew.click();
            mainPage32503.Hacienda.click();
            mainPage32503.RegisCE.click();
            mainPage32503.EnvioAviso.click();
            mainPage32503.Tramite32503.click();

            //Tab Aviso
            mainPage32503.tabAviso.click();
            //Datos de la empresa IMMEX que transfiere y presenta el aviso
            mainPage32503.NumeroIMMEX.sendKeys("52685");
            mainPage32503.AñoIMMEX.sendKeys("2025");
            //Datos del aviso
            mainPage32503.radbtnInicial.click();
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32503.fechaTranslado, fechaHoy);
            //Datos del domicilio de la planta o bodega de origen de las mercancías
            mainPage32503.NombreComercial.sendKeys("Carpinteria Gonalez");
            mainPage32503.selectEntidadFederativa.sendKeys("DURANGO");
            mainPage32503.selectAlcaldiaMunicipio.sendKeys("DURANGO");
            mainPage32503.selectColonia.sendKeys("20 DE NOVIEMBRE - CP 34");
            mainPage32503.Calletxt.sendKeys("Juarez QA");
            mainPage32503.NumeroExterior.sendKeys("12");
            mainPage32503.NumeroInterior.sendKeys("5");
            mainPage32503.CodigoPostal.sendKeys("34234");
            //TipoCarga
            mainPage32503.radbtnManual.click();
            //
            mainPage32503.btnAgregarDatos.click();sleep(1000);
            mainPage32503.DatosPersonaRFC.sendKeys("AAL0409235E6");
            mainPage32503.NombreComercialPlantaDest.sendKeys("Nombre QA");
            mainPage32503.EntidadFederativaPlantaDestDest.sendKeys("COLIMA");
            mainPage32503.AlcaldiaMunicipioPlantaDest.sendKeys("COMALA");
            mainPage32503.ColoniaPlantaDest.sendKeys("LOMAS DEL PEDREGAL - CP 28450");
            mainPage32503.CallePlantaDestinotxt.sendKeys("Calle QA");
            mainPage32503.NumeroExteriorPlantaDest.sendKeys("25");
            mainPage32503.NumeroInteriorPlantaDest.sendKeys("10");
            mainPage32503.CodigoPostalPlantaDest.sendKeys("56098");

            //Agregar Datos de la mercancia que se trasladará
            mainPage32503.btnAgregarDatosMercancia.click();sleep(1000);
            mainPage32503.FraccionArancelaria.sendKeys("01022901 - Vacas lecheras.");
            mainPage32503.NICO.sendKeys("50");
            mainPage32503.Cantidad.sendKeys("100");
            mainPage32503.UnidadMedida.sendKeys("Litro");
            mainPage32503.ValorUSD.sendKeys("1000");
            mainPage32503.DescripcionMercancia.sendKeys("QA Descripcion");
            mainPage32503.Proceso.sendKeys("Translado");
            mainPage32503.NumPedimientoExportacion.sendKeys("800911");
            mainPage32503.NumPedimientoImportacion.sendKeys("509066");
            mainPage32503.btAgregarDatosMercancia2.click();
            mainPage32503.btnAceptarNotificacion1.click();
            mainPage32503.btnAgregar2.click();
            mainPage32503.btnAceptarNotificacion2.click();
            mainPage32503.btnContinuar.click();
            //Paso 2
            mainPage32503.btnContinuarPaso2.click();

            //Paso3
            mainPage32503.btnAdjuntarDoc.click();

            //SubPaso 3
            mainPage32503.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32503.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32503.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32503.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32503.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32503.btnAdjuntar2.click();
            mainPage32503.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage32503.btnCerrar3.click();sleep(1000);
            //Paso 3 Continuar
            mainPage32503.btnContinuar3.click();

            //Paso 4 Firma
            loginFirmSoli.firma(tramite32503);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32503.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen5701")) {
//                ProcesoDictamen5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion5701")) {
//                ProcesoAutorizacion5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion5701")) {
//                ProcesoConfirmarNotificaciónResolucion5701(folioNumber);
//            }

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
