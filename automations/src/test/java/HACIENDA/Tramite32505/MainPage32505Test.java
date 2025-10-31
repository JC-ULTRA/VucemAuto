package HACIENDA.Tramite32505;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32505.MainPage32505;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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

public class MainPage32505Test {
    MainPage32505 mainPage32505 = new MainPage32505();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite32505 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\pcs900731mc5.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\PCS900731MC5_1012231345.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }


    @Test
    public void Proceso32505() {
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

            loginFirmSoli.login(tramite32505);
//            mainPage32505.selecRol.sendKeys("Persona Moral");
//            mainPage32505.btnacep.click();
            mainPage32505.Tramites.click();
            mainPage32505.SoliNew.click();
            mainPage32505.Hacienda.click();
            mainPage32505.RegisCE.click();
            mainPage32505.RegisCE.scrollTo();
            $x("//a[contains(normalize-space(.), 'Envío de Avisos')]").shouldBe(Condition.visible).click();
            $x("//a[contains(text(), 'Aviso mensual sobre importación y venta de vehículos usados')]").shouldBe(Condition.visible).click();
            //Tab Aviso
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32505.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32505.tabAviso.click();

            //Datos del periodo de aviso
            mainPage32505.MesAviso.selectOption("Enero");
            mainPage32505.AñoAviso.selectOption("2025");
            mainPage32505.articulo8.click();

            //Tipo de carga
            mainPage32505.radbtnManualCarga.click();
            mainPage32505.btnAgregarAviso.click();

            //Seccion Agregar datos de aviso
            mainPage32505.radbtnVenta.click();
            mainPage32505.radbtnNoFolioImportacion.click();
            mainPage32505.NumeroSerieNiv.sendKeys("4658544946");
            mainPage32505.selectAñoModelo.selectOption("2023");
            mainPage32505.MarcaVehiculo.sendKeys("KIA");
            mainPage32505.ModeloVehiculo.sendKeys("RIO");
            mainPage32505.TipoVarianteVersion.sendKeys("FORTE");
            mainPage32505.selectNoCilindros.selectOption("4");
            mainPage32505.selectNoPuertas.selectOption("4");
            mainPage32505.selectTipoCombustible.selectOption("Gasolina");
            mainPage32505.NoTituloPropiedad.sendKeys("4565468");
            mainPage32505.NombreTituloPersona.sendKeys("Alberto gonzales Nanda");
            mainPage32505.selectPaisEmitioTitulo.selectOption("ANGUILA");
            mainPage32505.EstadoEmisionTitulo.sendKeys("Anguila");
            mainPage32505.NoPlacasPaisProcedencia.sendKeys("KIA123");
            mainPage32505.selectFormaAdquisicionVehiculo.selectOption("Subasta");
            mainPage32505.NoDocumentoExpor.sendKeys("562548");

            //Datos Importacion
            mainPage32505.selectAduanaImportacion.selectOption("CD. DEL CARMEN");
            mainPage32505.PatenteImportacion.sendKeys("1252");
            mainPage32505.PedimientoImportacion.sendKeys("0452558");
            mainPage32505.KilometrajeImportacion.sendKeys("40000");
            mainPage32505.ValorAduana.sendKeys("859525");
            mainPage32505.FormaPagoIGI.sendKeys("Efectivo");
            mainPage32505.MontoPagadoIGI.setValue("500");
            mainPage32505.MontoDTA.sendKeys("6530");
            mainPage32505.MontoIVA.sendKeys("18");
            mainPage32505.ValorDolares.sendKeys("300000");
            mainPage32505.FolioImportacionCFDI.sendKeys("54651161651231685");

            //Datos nacionales
            mainPage32505.FolioCFDIVenta.sendKeys("65456561561651");
            mainPage32505.ValorVentaSinIVA.sendKeys("65165200");
            mainPage32505.btnGuardarAviso.click();
            mainPage32505.btnAceptarNotifAgrAviso.click();
            mainPage32505.checkTodosLosAviso.scrollTo();
            mainPage32505.btnContinuar.click();

            //Paso 2 Firma
            loginFirmSoli.firma(tramite32505);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32505.folio.getText();
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
