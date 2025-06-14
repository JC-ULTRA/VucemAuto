package HACIENDA.Tramite630307;
import Metodos.Metodos;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite630307.MainPage630307;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage630307Test {

    MainPage630307 mainPage630307 = new MainPage630307();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos= new Metodos();

    TramitesFirmasLG tramite630307  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }


    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso630307() throws IOException {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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



        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {


            //Generar folio al azar
            String folioGenerado = "";
            Random random = new Random();

            for (int i = 0; i < 25; i++) {
                folioGenerado += random.nextInt(10); // agrega un dígito aleatorio (0 a 9)
            }


            // Obtener la fecha de (hoy) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
            //Fecha 5 días posteriores a fecha actual
            String fechaVencimiento= LocalDate.now().plusDays(5).format(formatter);
            String fechaLimiteRetorno = LocalDate.now().plusDays(30).format(formatter);

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite630307);
            mainPage630307.selecRol.sendKeys("Persona Moral");
            mainPage630307.btnacep.click();

            //Búsqueda de tramite
            mainPage630307.Tramites.click();
            mainPage630307.SoliNew.click();
            mainPage630307.Hacienda.click();
            mainPage630307.ImportacionMercanciaSinPedimento.click();
            mainPage630307.Retorno.click();
            mainPage630307.elementoTramite630307.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage630307.Scrol.scrollTo();
            //Datos generales Original
            mainPage630307.tabDatosSolicitud.click();
            //Datos de la solicitud
            mainPage630307.selectAduanaRetorno.selectOption("300 - REYNOSA");
            mainPage630307.selectSeccionAduanaRetorno.selectOption("302 - LAS FLORES, RIO BRAVO, TAMAULIPAS.");
            //executeJavaScript("arguments[0].value = arguments[1];", mainPage630307.fechaEstimadaLimiteRetorno, fechaLimiteRetorno);
            mainPage630307.selectCuentaProrroga.selectOption("No");

            //Selección No cuenta prorroga
            //Información general de la autorización (formato en papel)
            mainPage630307.FolioAutorizacionImpPapel.sendKeys(folioGenerado);
            mainPage630307.selectAduanaIngreso.selectOption("470 - AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage630307.selectSeccionAduanera.selectOption("472 - CTO. POSTAL MECANIZADO, POR VIA POSTAL Y POR TRAFICO AEREO, AEROPUERTO INT. BENITO JUAREZ DE LA CD. DE MEXICO.");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630307.fechaIngreso, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630307.fechaVencimiento, fechaVencimiento);

            //Tipo propietario
            mainPage630307.selectPropietario.selectOption("No");
            //No propietario
            mainPage630307.selectTipoPropietario.selectOption("Persona Moral Extranjero");
            //Propietario Moral extranjero
            mainPage630307.PropietarioDenominacion.sendKeys("QA denominación extranjero");
            mainPage630307.PropietarioCalle.sendKeys("Calle QA Kansai");
            mainPage630307.PropietarioNumExterior.sendKeys("15");
            mainPage630307.PropietarioNumInterior.sendKeys("2");
            mainPage630307.selectPropietarioPais.selectOption("JAPON");
            mainPage630307.PropietarioLocalidad.sendKeys("Osaka");
            mainPage630307.PropietarioCorreoElec.sendKeys("vucem2.5Japon@hotmail.com");
            mainPage630307.PropietarioTelefono.sendKeys("811087907");
            mainPage630307.PropiedadCodPostal.sendKeys("8058");

            //Datos de la mercancía que se importará al país temporalmente
            mainPage630307.MarcaMercancia.sendKeys("MARCA QA");
            mainPage630307.ModeloMercancia.sendKeys("MODELO QA");
            mainPage630307.NumSerieMercancia.sendKeys("Num Serie QA");
            mainPage630307.NumMotorMercancia.sendKeys("Num Motor QA");
            mainPage630307.DescripcionMercancia.sendKeys("QA información Descripción");
            mainPage630307.MotivacionMercancia.sendKeys("QA información Motivo"); sleep(1000);
            mainPage630307.DescripcionMercancia.scrollTo();

            //Manifiesto
            mainPage630307.checkManifiesto.click();
            //Continuar Paso 1
            mainPage630307.btnContinuarPaso1.click();

            //Paso2
            mainPage630307.btnContinuarPaso2.click();

            //Paso 3
            metodos.cargarDocumentos();
            mainPage630307.btnAdjuntar2.click();
            mainPage630307.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage630307.btnCerrar3.click();

            //Paso 3 (Continuacion)
            mainPage630307.btnContinuar3.click();

            //Paso 4 Firma solicitud
            loginFirmSoli.firma(tramite630307);sleep(29000);

            // Obtener el texto del folio
            String folioText = mainPage630307.folio.getText();
            //Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);


        }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
