package Economia.Tramite90202;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage90202Test {
    MainPage90202 mainPage90202 = new MainPage90202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    String script = """
    function obtenerFechaFutura() {
        var today = new Date();
        var daysToAdd = 7;
        var count = 0;
        
        while (count < daysToAdd) {
            today.setDate(today.getDate() + 1);
            if (today.getDay() !== 0 && today.getDay() !== 6) { // 0 = domingo, 6 = sábado
                count++;
            }
        }
        var dia = today.getDate().toString().padStart(2, '0');
        var mes = (today.getMonth() + 1).toString().padStart(2, '0');
        var anio = today.getFullYear();
        return dia + '/' + mes + '/' + anio;
    }
    return obtenerFechaFutura();
""";
    String script2 = """
    var select = arguments[0];
    var options = Array.from(select.options).filter(opt => opt.value !== '');
    var randomIndex = Math.floor(Math.random() * options.length);
    select.value = options[randomIndex].value;
    select.dispatchEvent(new Event('change')); // Disparar el evento onchange si lo necesita
""";

//    String folioNumber = "0200900200220252540000006";
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String fechaFutura = (String) Selenide.executeJavaScript(script);

    TramitesFirmasLG tramite90202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite90202fun = new TramitesFirmasLG(
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\Vucem3.1\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(180000, TimeUnit.SECONDS);
        Configuration.timeout = 180000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso90202() throws IOException {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen90202");
        JCheckBox verificaCheckBox = new JCheckBox("ProcesoOpinion90202");
        JCheckBox generaCheckBox = new JCheckBox("GenerarDictamen90202");
        JCheckBox autorizaCheckBox = new JCheckBox("AutorizarDictamen90202");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmar90202");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificaCheckBox, generaCheckBox, autorizaCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen90202");
        if (verificaCheckBox.isSelected()) selectedMethods.add("ProcesoOpinion90202");
        if (generaCheckBox.isSelected()) selectedMethods.add("GenerarDictamen90202");
        if (autorizaCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen90202");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmar90202");
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite

            loginFirmSoli.login(tramite90202); sleep(1000);
            mainPage90202.selecRol.sendKeys("Persona Moral");
            mainPage90202.btnacep.click();
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();
            $(withText("Solicitudes nuevas")).click();
            mainPage90202.Economia.click(); sleep(1000);
            $(withText("PROSEC")).click();
            mainPage90202.linkAmpliacion.click();
            mainPage90202.linkAmpliacionProductoIndirecto.click();sleep(1000);
            try {
                Thread.sleep(2000);
                mainPage90202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage90202.inpuFolioPrograma.doubleClick();
            $(withText("Domicilios de plantas")).click();
            mainPage90202.inputLicitacion.doubleClick();sleep(1000);
            $(withText("Sectores y mercancías")).click();
            Selenide.executeJavaScript(script2, mainPage90202.inputSectorProsecConfirmado);sleep(2000);
//            mainPage90202.inputSectorProsecConfirmado.sendKeys("IV-De la Industria del Juguete y Juegos de recreo");sleep(2000);
            $("input[name='agregar_sectores'][value='Agregar sector']").click();sleep(5000);
            mainPage90202.inputFraccionArancelaria.sendKeys("61130002");sleep(2000);
            mainPage90202.InputGuardarSolicitud.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite90202);sleep(4000);
            String folioText = mainPage90202.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(6000);


            if (selectedMethods.contains("ProcesoDictamen90202")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoOpinion90202")) {
                VerificaOpinion(folioNumber);
            }
            if (selectedMethods.contains("GenerarDictamen90202")) {
                GenerarDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen90202")){
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ProcesoConfirmar90202")) {
                ProcesoConfirmar(folioNumber);
            } guardarFolioEnArchivo(folioNumber);

        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        loginFirmSoli.loginFun(tramite90202fun);sleep(4000);
        mainPage90202.iniciofun.click();sleep(6000);
        mainPage90202.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage90202.btnBuscarFolio.click();sleep(5000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarOpinion=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        Selenide.executeJavaScript("arguments[0].value = '30/09/2025';", mainPage90202.inputFechaVisita);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '" + fechaFutura + "';", mainPage90202.inputFechaVisita);sleep(5000);
        $("input[name='guardar'][value='Guardar']").click();sleep(4000);
        $("input[name='guardar'][value='Guardar']").click();sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaOpinion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage90202.iniciofun.click();sleep(3000);
        mainPage90202.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage90202.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage90202.inputAceptada.click();
        mainPage90202.inputDescribirOpinion.sendKeys("TEST");
        mainPage90202.inputAgregarDoc.click();
        mainPage90202.inputDoc.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage90202.inputCargarArchivo.click();
        $("input[name='guardar'][value='Enviar']").click();sleep(4000);
        loginFirmSoli.firmaFun(tramite90202fun);sleep(8000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void GenerarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage90202.iniciofun.click();
        mainPage90202.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage90202.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage90202.btnFirmarAutorizacion.click();sleep(5000);
        mainPage90202.justificacionRequerimiento.sendKeys("TEST");
        $("input[name='mostrarFirma'][value='Firmar']").click();sleep(4000);
        loginFirmSoli.firmaFun(tramite90202fun);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage90202.iniciofun.click();
        mainPage90202.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage90202.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        mainPage90202.btnAutorizaDictamen.click();sleep(3000);
        loginFirmSoli.firmaFun(tramite90202fun);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void ProcesoConfirmar(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        String folioGenerado = folioNumber;
        String rfcEmpleado = "AAL0409235E6";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        loginFirmSoli.login(tramite90202);sleep(3000);
        mainPage90202.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage90202.Btnacep.click();
        mainPage90202.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Firmar']").click();sleep(3000);
        loginFirmSoli.firma(tramite90202);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados90202.txt";

        // Formato de fecha y hora: 2025-07-02 18:45:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(timestamp + " - " + folioNumber);
            writer.newLine();
            System.out.println("Folio guardado correctamente: " + folioNumber);
        } catch (IOException e) {
            System.err.println("Error al guardar el folio: " + e.getMessage());
        }
    }
}