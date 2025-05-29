package HACIENDA.Tramite32508;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32508.MainPage32508;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
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
import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32508Test {
    Metodos metodos = new Metodos();
    MainPage32508 mainPage32508 = new MainPage32508();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32508  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
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
    public void Proceso32508() {
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamenB8");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacionB8");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucionB8");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32508);
            mainPage32508.selecRol.sendKeys("Persona Moral");
            mainPage32508.btnacep.click();
            mainPage32508.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32508.SoliNew.click();
            mainPage32508.hacienda.click();
            mainPage32508.registrosComercioExt.click();
            mainPage32508.envioAvisos.click();
            mainPage32508.aprovechamientoRecintosFiscalizado.click();

            mainPage32508.aviso.click();
            mainPage32508.claveRecinto.sendKeys("202773015");
            mainPage32508.disminucion.click();
            mainPage32508.rfcCpi.sendKeys("MAVL621207C95");
            mainPage32508.numeroInscripcion.sendKeys("786");sleep(1000);
            mainPage32508.añoPeriodoReportado.sendKeys("2024");
            mainPage32508.mesPeriodoReportado.sendKeys("Febrero");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32508.fechaElaboracionDictamen, fechaHoy);sleep(1000);
            mainPage32508.pagoAprovechamiento.click();
            mainPage32508.aprovechamiento.click();
            mainPage32508.saldoPendienteDisminuirAnterior.sendKeys("1000");
            mainPage32508.aprovechamientoCargo.sendKeys("1000");
            mainPage32508.disminucionAplicada.sendKeys("1000");
            mainPage32508.saldoPendienteDisminuir.sendKeys("1000");
            mainPage32508.cantidadPagada.sendKeys("1000");
            mainPage32508.llavedePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage32508.fechaPago, fechaHoy);sleep(1000);

            mainPage32508.archivoDisminucion.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Plantilla_disminucion.xls");
            mainPage32508.cargarArchivoDisminucion.click();sleep(1000);
            mainPage32508.btnAceptarCarga.click();

            mainPage32508.btnGuardarSoli.click();
            mainPage32508.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage32508.btnAdjuntar.click();sleep(3000);
            mainPage32508.btnCerrar.click();
            mainPage32508.btnSiguiente.click();

            loginFirmSoli.firma(tramite32508);



            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32508.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
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
