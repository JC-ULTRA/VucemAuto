package HACIENDA.Tramite630104;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite630104.MainPage630104;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage630104Test {

    MainPage630104 mainPage630104 = new MainPage630104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite630104  = new TramitesFirmasLG(
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
    public void Proceso630104() throws IOException {
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

            // Obtener la fecha de (hoy) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite630104);
            mainPage630104.selecRol.sendKeys("Persona Moral");
            mainPage630104.btnacep.click();

            //Búsqueda de tramite
            mainPage630104.Tramites.click();
            mainPage630104.SoliNew.click();
            mainPage630104.Hacienda.click();
            mainPage630104.ImportacionMercanciaSinPedimento.click();
            mainPage630104.Autorizacion.click();
            mainPage630104.elementoTramite630104.click();

            //Paso 1 CAPTURAR SOLICITUD
            mainPage630104.Scrol.scrollTo();
            //Datos generales Original
            mainPage630104.tabDatosSolicitud.click();
            //Datos de la solicitud
            mainPage630104.selectAduanaIngreso.selectOption("470 - AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage630104.selectSeccionAduanera.selectOption("472 - CTO. POSTAL MECANIZADO, POR VIA POSTAL Y POR TRAFICO AEREO, AEROPUERTO INT. BENITO JUAREZ DE LA CD. DE MEXICO.");
            //Fecha de importación
            executeJavaScript("arguments[0].value = arguments[1];", mainPage630104.fechaEstimadaIngreso, fechaHoy);
            //Tipo propietario
            mainPage630104.selectPropietario.selectOption("No");
            //No propietario
            mainPage630104.selectTipoPropietario.selectOption("Persona Moral Extranjero");
            //Propietario Moral extranjero
            mainPage630104.PropietarioDenominacion.sendKeys("QA denominación extranjero");
            mainPage630104.PropietarioCalle.sendKeys("Calle QA Kansai");
            mainPage630104.PropietarioNumExterior.sendKeys("15");
            mainPage630104.PropietarioNumInterior.sendKeys("2");
            mainPage630104.selectPropietarioPais.selectOption("JAPON");
            mainPage630104.PropietarioLocalidad.sendKeys("Osaka");
            mainPage630104.PropietarioCorreoElec.sendKeys("vucem2.5Japon@hotmail.com");
            mainPage630104.PropietarioTelefono.sendKeys("811087907");
            mainPage630104.PropiedadCodPostal.sendKeys("8058");

            //Datos del nombre o denominación social del representante en México o centro de operaciones
            mainPage630104.selectConsultarRFC.selectOption("No");
            //No Consultar
            mainPage630104.selectTipoRepresentante.selectOption("Persona Física Nacional");
            //Persona física
            mainPage630104.RepresentanteRFC.sendKeys("LEQI8101314S7");
            mainPage630104.RepresentanteCURP.sendKeys("LEQI810131HDGSXG05");
            mainPage630104.RepresentanteNombre.sendKeys("MISAEL");
            mainPage630104.RepresentanteApellidoPaterno.sendKeys("RUIZ");
            mainPage630104.RepresentanteApellidoMaterno.sendKeys("BARRAGAN");

            mainPage630104.RepresentanteDenominacion.sendKeys("Denominación QA");
            mainPage630104.RepresentanteCalle.sendKeys("Las flores");
            mainPage630104.RepresentanteNumExt.sendKeys("400");
            mainPage630104.RepresentanteNumInt.sendKeys("2");
            mainPage630104.selectRepresentanteEntidad.selectOption("CIUDAD DE MÉXICO");
            mainPage630104.selectRepresentanteMunicipio.selectOption("COYOACAN");
            mainPage630104.selectRepresentanteLocalidad.selectOption("PUEBLO DE SANTA URSULA COAPA - CP 04650");
            mainPage630104.selectRepresentanteColonia.selectOption("AJUSCO - CP 04369");
            mainPage630104.DatoRepresentanteCorreo.sendKeys("Representante@gmail.com");
            mainPage630104.DatoRepresentanteTelefono.sendKeys("55");
            mainPage630104.DatoRepresentanteCodigoPostal.sendKeys("04000");

            //Datos de la mercancía que se importará al país temporalmente
            mainPage630104.DescripcionMercancia.sendKeys("QA información Descripción");
            mainPage630104.MotivacionMercancia.sendKeys("QA información Motivo"); sleep(1000);
            mainPage630104.DescripcionMercancia.scrollTo();
            mainPage630104.NombreMercancia.sendKeys("QA información Nombre Cientifico");
            mainPage630104.ObservacionesMercancia.sendKeys("QA información Observación");
            mainPage630104.ListaMercancia.sendKeys("QA información Lista");

            //Manifiesto
            mainPage630104.checkManifiesto.click();

            //Continuar Paso 1
            mainPage630104.btnContinuarPaso1.click();

            //Paso 2 Firma solicitud
            loginFirmSoli.firma(tramite630104);sleep(29000);

            // Obtener el texto del folio
            String folioText = mainPage630104.folio.getText();
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
