package Economia.Tramite80202;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.webdriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.Selenide.webdriver;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import com.codeborne.selenide.WebDriverConditions;

public class MainPage80202Test {
    MainPage80202 mainPage80202 = new MainPage80202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AFC000526BJ2";

    TramitesFirmasLG tramite80202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\tsd931210493.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\TSD931210493_1012231144.key"
    );
    TramitesFirmasLG tramite80202Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;
        open(); // Esto usará las capabilities ya configuradas
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(210, TimeUnit.SECONDS);
    }
    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso80202() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          // Ingreso y Rol
            loginFirmSoli.login(tramite80202);
//            mainPage80202.selecRol.sendKeys("Persona Moral");
//            mainPage80202.btnacep.click();
            //Búsqueda Trámite
            $("#Trámites").shouldBe(Condition.visible).click();// Asegura que el elemento está cargado y visible.click();
            $x("//a[text()='Solicitudes nuevas']").shouldBe(Condition.visible).click();
            $("img[alt='Secretaría de Economía']").shouldBe(Condition.visible).click();
            $x("//a[text()='IMMEX']").shouldBe(Condition.visible).click();
            $x("//a[text()='Ampliación']").shouldBe(Condition.visible).click();
            $("a[onclick*='80202']").shouldBe(Condition.visible).click();

            mainPage80202.gridPrograma1.doubleClick();
            webdriver().shouldHave(WebDriverConditions.url("https://wwwqa.ventanillaunica.gob.mx/ventanilla-se-HA/se/immex/solicitudImmex.action"));

            metodos.scrollDecremento(1);
            mainPage80202.tabAnexoI.click();
            mainPage80202.fraccionArancelaria.sendKeys("72162101");
            $("input[type='button'][value='Agregar']").shouldBe(Condition.visible).click();
            mainPage80202.cantidadAnual.sendKeys("10000");
            mainPage80202.capacidadInstaladaPeriodo.sendKeys("10000");
            mainPage80202.cantidadPeriodo.sendKeys("3000");
            mainPage80202.btnGuardarFraccionImportacion.click();sleep(1300);
            $x("//button[text()='Aceptar']").shouldBe(Condition.visible).click();
            mainPage80202.seleccionarFraccion.click();
            mainPage80202.mostrarDetalleMercancia.click();
            mainPage80202.Nico.selectOption("01");
            mainPage80202.btnAgregarNico.click();
            metodos.scrollIncremento(1);
            $("input[onclick*='agregarDetalleFraccionImpo']").shouldBe(Condition.visible).click();sleep(1300);
            mainPage80202.btnAceptarFracc.click();
            mainPage80202.seleccionarFraccion.click();
            mainPage80202.fraccionArancelariaExportacion.sendKeys("47071001");
            mainPage80202.descripcionProducto.sendKeys("PRUEBAS QA");
            mainPage80202.btnAgregarFraccExp.click();
            mainPage80202.seleccionarFraccionExp.click();
            mainPage80202.mostrarDetalleMercanciaExp.click();
            mainPage80202.nicoExp.selectOption("00");
            mainPage80202.btnAgregarNicoExp.click();
            metodos.scrollIncremento(1);
            mainPage80202.btnGuardarDetalleExp.click(); sleep(1300);
            mainPage80202.btnAceptarFracExp.click(); sleep(1000);

            mainPage80202.btnContinuarPaso1.click();
            mainPage80202.btnContinuarPaso2.click();

            metodos.cargarDocumentos();
            mainPage80202.btnAnexar.click();sleep(10000);
            mainPage80202.btnCerrar.click();
            mainPage80202.btnContinuarPaso3.click();

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite80202);
            String folioText = mainPage80202.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    ProcesoSolicitarOpinion(folioNumber);
                    ProcesoRegistrarOpinion(folioNumber);
                    ProcesoGenerarDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                    if (selectedMethods.contains("ProcesoAutorizacion")) {
                        ProcesoAutorizarDictamen(folioNumber);
                        System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                            System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }

        }, repeticiones);
    }
    public void ProcesoSolicitarOpinion(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite80202Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage80202.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage80202.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarOpinion=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        String siguienteDiaHabil = calcularSiguienteDiaHabil();
        String idCampoFecha = "fechaVisitaSE";
        executeJavaScript(
                "document.getElementById(arguments[0]).value = arguments[1]; " +
                        "document.getElementById(arguments[0]).dispatchEvent(new Event('change'));",
                idCampoFecha,
                siguienteDiaHabil
        );
        $("#btnGuardar").shouldBe(visible).click();
    }
    public void ProcesoRegistrarOpinion(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage80202.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage80202.btnBuscarFolio.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", " Registrar Opinion")).doubleClick();
        mainPage80202.sentidoOpinion.click();
        mainPage80202.opinion.sendKeys("AUTORIZAR PRUEBAS QA ULTRASIST");
        mainPage80202.anexarInfoDigitalizada.click();sleep(1500);
        mainPage80202.archivoAnexar.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage80202.enviarArchivo.click();sleep(3000);
        $("#btnGuardar").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite80202Fun); sleep(5000);
    }
    public void ProcesoGenerarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage80202.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage80202.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage80202.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage80202.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite80202Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage80202.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage80202.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage80202.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite80202Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite80202);
//        mainPage80202.selecRol.sendKeys("Persona Moral");
//        mainPage80202.btnacep.click();
        mainPage80202.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage80202.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite80202);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public String calcularSiguienteDiaHabil() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.now().plusDays(1); // Empezar mañana
        while (fecha.getDayOfWeek() == SATURDAY || fecha.getDayOfWeek() == SUNDAY) {
            fecha = fecha.plusDays(1);
        }
        return fecha.format(formatter);
    }

    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados80210.txt";

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
