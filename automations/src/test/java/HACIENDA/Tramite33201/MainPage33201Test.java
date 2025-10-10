package HACIENDA.Tramite33201;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33201Test {
    MainPage33201 mainPage33201 = new MainPage33201();
    Metodos metodos = new Metodos();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite33201  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite33201Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = CHROME;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=1.25");
        Configuration.browserCapabilities = options;

        open();
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    }

    @Test
    public void Proceso33201() {

        String folioAProcesar = obtenerFolioParaAutomatizacion();

        if (folioAProcesar == null || folioAProcesar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún folio procesable en la base de datos.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Iniciando automatización con el Folio: " + folioAProcesar);

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        ejecutarProcesoWeb(folioAProcesar);
    }

    public void ejecutarProcesoWeb(String FolioRubro) {
        loginFirmSoli.login(tramite33201);
        mainPage33201.selecRol.sendKeys("Persona Moral");
        mainPage33201.btnacep.click();
        mainPage33201.Tramites.sendKeys("Solicitudes subsecuentes");
        mainPage33201.soliSubsecuente.click();

        mainPage33201.folioTramite.sendKeys(FolioRubro);

        mainPage33201.btnBuscarFolio.click();sleep(1000);
        mainPage33201.tablaFolios.doubleClick();
        mainPage33201.avisoAnexo.click();

        metodos.scrollDecremento(1);
        mainPage33201.solicitud.click();
        mainPage33201.checkbox1.click();sleep(1000);
        aceptarPopupInmexRobusto();
        mainPage33201.checkbox2.click();
        mainPage33201.checkbox3.click();
        mainPage33201.checkbox4.click();
        mainPage33201.certificacionSi.click();
        mainPage33201.immexSi.click();
        mainPage33201.importaciones80Si.click();
        mainPage33201.valorImportaciones.sendKeys("1000");
        mainPage33201.retotnosValorComercial.sendKeys("250");
        mainPage33201.retornosAduana.sendKeys("250");
        mainPage33201.retornosPorcentaje.sendKeys("25");
        mainPage33201.transferenciasValorComercial.sendKeys("250");
        mainPage33201.transferenciasAduana.sendKeys("250");
        mainPage33201.transferenciasPorcentaje.sendKeys("25");
        mainPage33201.desperdiciosValorComercial.sendKeys("250");
        mainPage33201.desperdiciosAduana.sendKeys("250");
        mainPage33201.desperdiciosPorcentaje.sendKeys("25");
        mainPage33201.constanciasValorComercial.sendKeys("250");
        mainPage33201.constanciasAduana.sendKeys("250");
        mainPage33201.constanciasPorcentajes.sendKeys("25");
        metodos.scrollIncremento(1);
        mainPage33201.cargaProveedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (3).xls");
        mainPage33201.btnCargarProveedoresN.click();sleep(1500);
        $x("//button[text()='Ok']").shouldBe(Condition.visible).click();
        mainPage33201.manifiestoOk.click();

        mainPage33201.btnGuardarSoli.click();
        mainPage33201.btnContinuar.click();
        metodos.cargarDocumentos();
        mainPage33201.btnAdjuntar.click();sleep(3500);
        mainPage33201.btnCerrar.click();
        mainPage33201.btnSiguiente.click();
        loginFirmSoli.firma(tramite33201);

        String folioText = mainPage33201.folio.getText();
        String folioNumber = obtenerFolio.obtenerFolio(folioText);
        System.out.println("Folio del nuevo trámite generado: " + folioNumber);
        setUpAll();
        int T = 0;
        try {
            ProcesoGenerarDictamen(folioNumber);
            T = 0;
            try {
                ProcesoAutorizarDictamen(folioNumber);
                T = 0;
                try {
                    ProcesoConfirmarNotificacion(folioNumber);
                    T = 1;
                } catch (Throwable e) {
                    T = 0;
                    e.printStackTrace();
                }
            } catch (Throwable e) {
                T = 0;
                e.printStackTrace();
            }
        } catch (Throwable e) {
            T = 0;
            e.printStackTrace();
        }
    }
    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite33201Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage33201.numfolio.sendKeys(folioNumber);sleep(2000);
        mainPage33201.btnBuscarFolio2.doubleClick();sleep(2500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage33201.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicio = LocalDate.now();
        String fechaIniString = fechaInicio.format(formatter);
        LocalDate fechaFin = fechaInicio.plusDays(30);
        String fechaFinString = fechaFin.format(formatter);
        String idIni = "fechaIniVig";
        executeJavaScript(
                "document.getElementById(arguments[0]).value = arguments[1]; " +
                        "document.getElementById(arguments[0]).dispatchEvent(new Event('change'));",
                idIni,
                fechaIniString
        );
        String idFin = "fechaFinVig";
        executeJavaScript(
                "document.getElementById(arguments[0]).value = arguments[1]; " +
                        "document.getElementById(arguments[0]).dispatchEvent(new Event('change'));",
                idFin,
                fechaFinString
        );

        $("input[type='submit'][value='Continuar']").shouldBe(Condition.visible).click();
        $("input[type='submit'][value='Guardar y firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite33201Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage33201.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage33201.btnBuscarFolio2.doubleClick();sleep(4000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("input[type='submit'][value='Autorizar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite33201Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite33201);
        mainPage33201.selecRol.sendKeys("Persona Moral");
        mainPage33201.btnacep.click();
        mainPage33201.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage33201.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite33201);sleep(1000);sleep(4000);
    }
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados33201.txt";

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

    public String obtenerFolioParaAutomatizacion() {
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";
        final String querySelectIds =
                "SELECT ID_SOLICITUD FROM ( " +
                        "    SELECT ID_SOLICITUD, FEC_CREACION " + // ⭐️ Asegúrate de seleccionar FEC_CREACION aquí
                        "    FROM VUC_SOLICITUD " +
                        "    WHERE CVE_USUARIO_CAPTURISTA = 'AAL0409235E6' " +
                        "      AND IDE_EST_SOLICITUD = 'ESTSOL.AU' " +
                        "      AND ID_TIPO_TRAMITE IN (31601, 31602, 31603) " +
                        "      AND FEC_CREACION >= (SYSDATE - 10) " +
                        "    ORDER BY FEC_CREACION DESC " +
                        ") " +
                        "WHERE ROWNUM <= 5";

        final String querySelectFolio = "SELECT NUM_FOLIO_TRAMITE FROM VUC_TRAMITE WHERE ID_SOLICITUD = ?";
        final String querySelectHijas = "SELECT ID_SOLICITUD, IDE_EST_SOLICITUD FROM VUC_SOLICITUD WHERE NUM_FOLIO_TRAMITE_ORIGINAL = ?";

        final String queryUpdateSolEL = "UPDATE VUC_SOLICITUD SET IDE_EST_SOLICITUD = 'ESTSOL.EL' WHERE ID_SOLICITUD = ?";
        final String queryUpdateTramiteDS = "UPDATE VUC_TRAMITE SET IDE_EST_TRAMITE = 'ESTTR.DS' WHERE ID_SOLICITUD = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmtSelectIds = connection.prepareStatement(querySelectIds);
             PreparedStatement stmtSelectFolio = connection.prepareStatement(querySelectFolio);
             PreparedStatement stmtSelectHijas = connection.prepareStatement(querySelectHijas);
             PreparedStatement stmtUpdateSolEL = connection.prepareStatement(queryUpdateSolEL);
             PreparedStatement stmtUpdateTramiteDS = connection.prepareStatement(queryUpdateTramiteDS))
        {

            List<Long> idsIniciales = new ArrayList<>();
            try (ResultSet rsIds = stmtSelectIds.executeQuery()) {
                while (rsIds.next()) {
                    idsIniciales.add(rsIds.getLong("ID_SOLICITUD"));
                }
            }

            if (idsIniciales.isEmpty()) {
                System.out.println("BD: No se encontraron ID_SOLICITUD iniciales para procesar.");
                return null;
            }

            for (long idInicial : idsIniciales) {
                String folioTramite = null;

                stmtSelectFolio.setLong(1, idInicial);
                try (ResultSet rsFolio = stmtSelectFolio.executeQuery()) {
                    if (rsFolio.next()) {
                        folioTramite = rsFolio.getString("NUM_FOLIO_TRAMITE");
                    } else {
                        System.out.println("BD: No se encontró folio para ID_SOLICITUD inicial: " + idInicial);
                        continue;
                    }
                }

                List<Long> idsParaUpdateEL = new ArrayList<>();
                List<Long> idsRCparaUpdateDS = new ArrayList<>();
                boolean auEncontrado = false;

                stmtSelectHijas.setString(1, folioTramite);
                try (ResultSet rsHijas = stmtSelectHijas.executeQuery()) {
                    while (rsHijas.next()) {
                        long idHija = rsHijas.getLong("ID_SOLICITUD");
                        String estadoHija = rsHijas.getString("IDE_EST_SOLICITUD");

                        if ("ESTSOL.AU".equalsIgnoreCase(estadoHija)) {
                            auEncontrado = true; // Condición de salto
                            break;
                        } else if ("ESTSOL.RC".equalsIgnoreCase(estadoHija) || "ESTSOL.RG".equalsIgnoreCase(estadoHija)) {
                            idsParaUpdateEL.add(idHija);
                            if ("ESTSOL.RC".equalsIgnoreCase(estadoHija)) {
                                idsRCparaUpdateDS.add(idHija);
                            }
                        }
                    }
                }

                if (auEncontrado) {
                    System.out.println("BD: Solicitud hija en ESTSOL.AU para folio " + folioTramite + ". Saltando al siguiente ID inicial.");
                    continue;
                }

                for (long id : idsParaUpdateEL) {
                    stmtUpdateSolEL.setLong(1, id);
                    stmtUpdateSolEL.executeUpdate();
                    System.out.println("BD: UPDATE VUC_SOLICITUD a EL para ID: " + id);
                }

                for (long id : idsRCparaUpdateDS) {
                    stmtUpdateTramiteDS.setLong(1, id);
                    stmtUpdateTramiteDS.executeUpdate();
                    System.out.println("BD: UPDATE VUC_TRAMITE a DS para ID (RC): " + id);
                }

                System.out.println("BD: Procesamiento exitoso. Folio a retornar: " + folioTramite);
                return folioTramite;

            }

        } catch (SQLException e) {
            System.err.println("❌ ERROR CRÍTICO en la conexión o procesamiento de BD.");
            System.err.println("   Mensaje de error: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("BD: Se intentaron procesar 5 solicitudes sin éxito (todas tenían hijas en ESTSOL.AU).");
        return null;
    }
    public void aceptarPopupInmexRobusto() {
        String dialogoXPath = "//div[contains(@class, 'ui-dialog') and .//div[contains(text(), 'Debe contar con IMMEX activo y vigente.')]]";

        if ($x(dialogoXPath).exists() && $x(dialogoXPath).isDisplayed()) {
            System.out.println("ADVERTENCIA: Se encontró el pop-up de IMMEX. Intentando hacer clic en Aceptar.");

            $x(dialogoXPath)
                    .find(".ui-dialog-buttonset button.btn-primary")
                    .shouldBe(Condition.visible)
                    .click();
            $x(dialogoXPath).shouldNotBe(Condition.visible);
        }
    }

}