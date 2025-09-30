package HACIENDA.Tramite11101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite11101.MainPage11101;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage11101Test {

    MainPage11101 mainPage11101 = new MainPage11101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite11101  = new TramitesFirmasLG(
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
    }

    @Test
    public void Proceso11101() {
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
//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen11101");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion11101");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion11101");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }
//
//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen11101");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion11101");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion11101");
//


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados

        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite11101);
            mainPage11101.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage11101.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes subsecuentes")).click();sleep(1000);
            String Folio = obtenerNumFolioTramite("10301", "ESTSOL.AU");
            $("[name='parametrosSolicitud.numFolio']").sendKeys(Folio);sleep(1000);
            $("[value='Buscar']").click();sleep(1000);
            $$x("//td[@aria-describedby='solicitud_tramite']").findBy(exactText(Folio)).doubleClick();sleep(1000);
            $("[value='Aviso de modificación']").click();sleep(1000);
            $$("button").findBy(Condition.exactText("Aceptar")).click();
            $("[for='captura.tab.exencionImpuestos']").click();sleep(1000);
            $("[id='jqg_mercanciasExcencionImpuestos_3']").click();sleep(1000);
            $("[name='modificarMercancias']").click();sleep(1000);
            $("[name='mercancia.cantidadComercial']").sendKeys("12");sleep(1000);
            $("[id='unidadMedidaComercial']").sendKeys("Caja");sleep(1000);
            $("[id='valorEnDolares']").clear();
            $("[id='valorEnDolares']").sendKeys("12");sleep(1000);
            $("[id='detalleMercancia']").sendKeys("Test");sleep(1000);
            $("[id='btnModificarMercancia']").click();sleep(1000);
            $$("button").findBy(Condition.exactText("Aceptar")).click();
            $("[id='guardarSolicitud']").click();sleep(1000);
            metodos.scrollIncremento(3);
            $("[value='Continuar']").click();sleep(1000);
            loginFirmSoli.firma(tramite11101);
            // Obtener el texto del folio desde mainPage11101
            String folioText = mainPage11101.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
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

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
