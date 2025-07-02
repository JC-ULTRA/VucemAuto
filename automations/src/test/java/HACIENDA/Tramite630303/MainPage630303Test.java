package HACIENDA.Tramite630303;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite630303.MainPage630303;
import Metodos.Metodos;
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

public class MainPage630303Test {

    MainPage630303 mainPage630303 = new MainPage630303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos= new Metodos();

    TramitesFirmasLG tramite630303  = new TramitesFirmasLG(
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
    public void Proceso630303() throws IOException {
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
            String folioAutorizacionGenerado = "";
            String folioProrrogaGenerado = "";
            Random random = new Random();

            for (int i = 0; i < 25; i++) {
                folioAutorizacionGenerado += random.nextInt(10); // agrega un dígito aleatorio (0 a 9)
                folioProrrogaGenerado += random.nextInt(10); // agrega un dígito aleatorio (0 a 9)
            }


            // Obtener la fecha de (hoy) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
            //Fecha 5 días posteriores a fecha actual
            String fechaVencimientoProrroga= LocalDate.now().plusDays(15).format(formatter);
            String fechaVencimientoAutorizacion= LocalDate.now().plusDays(5).format(formatter);
            String fechaInicioProrroga = fechaVencimientoAutorizacion;
            String fechaLimiteRetorno = LocalDate.now().plusDays(30).format(formatter);

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite630303);
            mainPage630303.selecRol.sendKeys("Persona Moral");
            mainPage630303.btnacep.click();

            //Búsqueda de tramite
            mainPage630303.Tramites.click();
            mainPage630303.SoliNew.click();
            mainPage630303.Hacienda.click();
            mainPage630303.ImportacionMercanciaSinPedimento.click();
            mainPage630303.Retorno.click();
            mainPage630303.elementoTramite630303.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage630303.Scrol.scrollTo();
            //Datos generales Original
            mainPage630303.tabDatosSolicitud.click();
            //Datos de la solicitud
            mainPage630303.selectAduanaIngreso.selectOption("470 - AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage630303.selectSeccionAduanera.selectOption("472 - CTO. POSTAL MECANIZADO, POR VIA POSTAL Y POR TRAFICO AEREO, AEROPUERTO INT. BENITO JUAREZ DE LA CD. DE MEXICO.");
            //executeJavaScript("arguments[0].value = arguments[1];", mainPage630303.fechaEstimadaLimiteRetorno, fechaLimiteRetorno);
            mainPage630303.selectCuentaProrroga.selectOption("Si");

            //Selección Si cuenta con prorroga
            mainPage630303.FolioProrroga.sendKeys(folioProrrogaGenerado);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630303.fechaInicioProrroga, fechaInicioProrroga);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630303.fechaVencimientoProrroga, fechaVencimientoProrroga);

            //Información general de la autorización (formato en papel)
            mainPage630303.FolioAutorizacionImpPapel.sendKeys(folioAutorizacionGenerado);
            mainPage630303.selectAduanaIngresoAutorizacion.selectOptionByValue("530");
            mainPage630303.selectSeccionAduaneraAutorizacion.selectOptionByValue("531");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630303.fechaIngreso, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630303.fechaVencimientoAutorizacionRetorno, fechaVencimientoAutorizacion);

            //Tipo propietario
            mainPage630303.selectPropietario.selectOption("No");
            //No propietario
            mainPage630303.selectTipoPropietario.selectOption("Persona Moral Extranjero");
            //Propietario Moral extranjero
            mainPage630303.PropietarioDenominacion.sendKeys("QA denominación extranjero");
            mainPage630303.PropietarioCalle.sendKeys("Calle QA Kansai");
            mainPage630303.PropietarioNumExterior.sendKeys("15");
            mainPage630303.PropietarioNumInterior.sendKeys("2");
            mainPage630303.selectPropietarioPais.selectOption("JAPON");
            mainPage630303.PropietarioLocalidad.sendKeys("Osaka");
            mainPage630303.PropietarioCorreoElec.sendKeys("vucem2.5Japon@hotmail.com");
            mainPage630303.PropietarioTelefono.sendKeys("811087907");
            mainPage630303.PropiedadCodPostal.sendKeys("8058");

            //Datos de la mercancía que se importará al país temporalmente
            mainPage630303.DescripcionMercancia.sendKeys("QA información Descripción");
            mainPage630303.MotivacionMercancia.sendKeys("QA información Motivo");
            mainPage630303.ListaMercancia.sendKeys("Lista QA");sleep(1000);
            mainPage630303.DescripcionMercancia.scrollTo();

            //Manifiesto
            mainPage630303.checkManifiesto.click();
            //Continuar Paso 1
            mainPage630303.btnContinuarPaso1.click();

            //Paso2
            mainPage630303.btnContinuarPaso2.click();

            //Paso 3
            metodos.cargarDocumentos();
            mainPage630303.btnAdjuntar2.click();
            mainPage630303.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage630303.btnCerrar3.click();

            //Paso 3 (Continuacion)
            mainPage630303.btnContinuar3.click();

            //Paso 4 Firma solicitud
            loginFirmSoli.firma(tramite630303);sleep(29000);

            // Obtener el texto del folio
            String folioText = mainPage630303.folio.getText();
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
