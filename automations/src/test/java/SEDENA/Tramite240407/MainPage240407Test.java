package SEDENA.Tramite240407;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240407.MainPage240407;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240407Test {
    MainPage240407 mainPage240407 = new MainPage240407();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240407  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite240407fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
    public void Proceso240407() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240407");
        JCheckBox VerificarCheckbox = new JCheckBox("ProcesoVerificarDictamen240407");
        JCheckBox AutorizarCheckBox = new JCheckBox("ProcesoAutorizarDictamen240407");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificacion240407");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, VerificarCheckbox, AutorizarCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (VerificarCheckbox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen");
        if (AutorizarCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizarDictamen");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificacion");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //Loging y Selección Rol
            loginFirmSoli.login(tramite240407);
            mainPage240407.selecRol.sendKeys("Persona Moral"); sleep(5000);
            mainPage240407.btnacep.click();sleep(5000);

            //Búsqueda de trámite Subsecuente
            mainPage240407.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage240407.SoliSub.click();
            String Folio = obtenerNumFolioTramite("240107", "ESTSOL.AU");
            mainPage240407.FolioTramite.sendKeys(Folio);
            mainPage240407.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage240407.filaFolioGrid.findBy(text(Folio));
            filaFolioDeseado.doubleClick();

            //Solicitar Modificación y Prórroga
            mainPage240407.btnSolProrroga.click();

            //Paso 1 CAPTURAR SOLICITUD
            //DATOS SOLICITANTE
            try {
                Thread.sleep(5000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240407.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240407.labelDatosSolicitud.click();
            mainPage240407.Justificacion.setValue("QA Prorroga");
            mainPage240407.InputGuardarSolicitud.click();

            //PAso 2 REQUISITOS NECESARIOS
            mainPage240407.btnContinuar.click();sleep(5000);

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage240407.btmAnexar.click();sleep(5000);
            mainPage240407.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            mainPage240407.btnCerrar.click();
            Selenide.sleep(5000);
            mainPage240407.inputSiguiente.click();sleep(5000);

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240407);
            Selenide.sleep(6000);
            String folioText = mainPage240407.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    System.out.println("Iniciando ProcesoDictamen...");
                    ProcesoDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a VerificarDictamen...");

                    if (selectedMethods.contains("ProcesoVerificarDictamen")) {
                        ProcesoVerificarDictamen(folioNumber);
                        System.out.println("ProcesoVerificarDictamen completado. Pasando a AutorizarDictamen...");

                        if (selectedMethods.contains("ProcesoAutorizarDictamen")) {
                            ProcesoAutorizarDictamen(folioNumber);
                            System.out.println("ProcesoAutorizarDictamen completado. Pasando a ConfirmarNotificacion...");

                            if (selectedMethods.contains("ProcesoConfirmarNotificacion")) {
                                ProcesoConfirmarNotificacion(folioNumber);
                                System.out.println("ProcesoConfirmarNotificacion completado.");
                            }
                        }
                    }

                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }
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
    public String obtenerNumFolioTramite(String idTipoTramite, String ideEstSolicitud) {
        String numFolioTramite = null;

        String sql =
                "SELECT NUM_FOLIO_TRAMITE " +
                        "FROM VUC_TRAMITE vt " +
                        "WHERE ID_SOLICITUD = (" +
                        "    SELECT ID_SOLICITUD " +
                        "    FROM (" +
                        "        SELECT * " +
                        "        FROM VUC_SOLICITUD vs " +
                        "        WHERE ID_TIPO_TRAMITE = ? " +
                        "          AND IDE_EST_SOLICITUD = ? " +
                        "        ORDER BY FEC_CREACION DESC" +
                        "    ) " +
                        "    WHERE ROWNUM = 1" +
                        ")";

        // Conexión incluida en el método
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                "vucem_app_p01",
                "Mfk22nvW6na71DgBXi5R");                                 // <-- tu contraseña
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Seteamos los parámetros dinámicos
            ps.setString(1, idTipoTramite);
            ps.setString(2, ideEstSolicitud);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    numFolioTramite = rs.getString("NUM_FOLIO_TRAMITE");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFolioTramite;
    }
    public void ProcesoDictamen(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite240407fun);

        // Búsqueda de Folio
        mainPage240407.iniciofun.click();
        mainPage240407.numfolio.sendKeys(folioNumber);sleep(6000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240407.btnBuscarTarea.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(7000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite240407fun);sleep(1000); sleep(6000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240407.numfolio.sendKeys(folioNumber);sleep(7000);
        mainPage240407.btnBuscarTarea.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite240407fun);sleep(6000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240407.numfolio.sendKeys(folioNumber);sleep(7000);
        mainPage240407.btnBuscarTarea.doubleClick();sleep(10000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite240407fun);sleep(6000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite240407);
        mainPage240407.selecRol.sendKeys("Persona Moral");
        mainPage240407.btnacep.click();
        mainPage240407.inicioFolio.sendKeys(folioNumber);sleep(7000);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firma(tramite240407);sleep(1000);sleep(6000);
    }
}