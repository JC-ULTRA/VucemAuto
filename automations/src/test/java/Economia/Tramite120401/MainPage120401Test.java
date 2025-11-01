package Economia.Tramite120401;

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
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120401Test {
    MainPage120401 mainPage120401 = new MainPage120401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite120401 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\zure5401259d9.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\ZURE5401259D9_1012270848.key"
    );
    TramitesFirmasLG tramite120401fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
    public void Proceso120401() {
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

        // Crear checkboxes
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen120401");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion120401");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion120401");

        // Deshabilitar los siguientes inicialmente
        autorizacionCheckBox.setEnabled(false);
        confirmacionCheckBox.setEnabled(false);

        // Listener para Dictamen → habilita Autorización
        dictamenCheckBox.addItemListener(e -> {
            boolean selected = dictamenCheckBox.isSelected();
            autorizacionCheckBox.setEnabled(selected);
            if (!selected) {
                autorizacionCheckBox.setSelected(false);
                confirmacionCheckBox.setSelected(false);
                confirmacionCheckBox.setEnabled(false);
            }
        });

        // Listener para Autorización → habilita Confirmación
        autorizacionCheckBox.addItemListener(e -> {
            boolean selected = autorizacionCheckBox.isSelected();
            confirmacionCheckBox.setEnabled(selected);
            if (!selected) {
                confirmacionCheckBox.setSelected(false);
            }
        });

        // Panel vertical para presentación
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Seleccione los métodos a ejecutar:"));
        panel.add(dictamenCheckBox);
        panel.add(autorizacionCheckBox);
        panel.add(confirmacionCheckBox);

        // Mostrar diálogo
        int option = JOptionPane.showConfirmDialog(null, panel, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Validar opción
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
            loginFirmSoli.login(tramite120401);
            mainPage120401.selecRol.sendKeys("Persona Fisica");
            mainPage120401.btnacep.click();
            mainPage120401.Tramites.click();
            mainPage120401.SoliNew.click();
            mainPage120401.economia.click();
            mainPage120401.linkCuposimpExp.click();
            mainPage120401.linkAsignacionDirectaCupo.click();
            mainPage120401.linkAsiDirCupPerFis.click();
            try {
                Thread.sleep(2000);
                mainPage120401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage120401.labelAsignacion.click();
            mainPage120401.inputEntidadFederativa.sendKeys("DURANGO");
            mainPage120401.inputRepresentacionFed.sendKeys("DURANGO");
            mainPage120401.inputRegimenAduanero.sendKeys("Importación");
            mainPage120401.btnBuscarCupos.click();
            mainPage120401.inputCuposDisponibles.doubleClick();
            mainPage120401.inputCantidadSoicitada.sendKeys("5000");
            mainPage120401.InputGuardarSolicitud.click();
            mainPage120401.btnContinuar.click();
            metodos.cargarDocumentos();
            mainPage120401.btmAnexar.click();sleep(8000);
            mainPage120401.btnCerrar.click();sleep(2000);
            mainPage120401.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite120401);
            String folioText = mainPage120401.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                    if (selectedMethods.contains("ProcesoAutorizacion")) {
                        ProcesoAutorizarDictamen(folioNumber);
                        System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                            guardarFolioEnArchivo(folioNumber);
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
    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite120401fun);
        Selenide.sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage120401.numfolio.sendKeys(folioNumber);
        Selenide.sleep(5000);
        mainPage120401.btnBuscarFolioFun.doubleClick();
        Selenide.sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click(); sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage120401.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage120401.criterioDictamen.click();
        mainPage120401.cantidadDictaminada.setValue("5000");
        metodos.scrollDecremento(1);
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite120401fun);
        Selenide.sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage120401.numfolio.sendKeys(folioNumber);
        Selenide.sleep(5000);
        mainPage120401.btnBuscarFolioFun.doubleClick();
        Selenide.sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite120401fun);
        Selenide.sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite120401);
        mainPage120401.selecRol.sendKeys("Persona Moral");
        mainPage120401.btnacep.click();
        mainPage120401.inicioFolio.sendKeys(folioNumber);
        Selenide.sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage120401.btnContinuarConfirmacion.click();
        Selenide.sleep(1000);
        loginFirmSoli.firma(tramite120401);
        Selenide.sleep(1000);
        Selenide.sleep(4000);
    }


    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            setUpAll();
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados120401.txt";

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