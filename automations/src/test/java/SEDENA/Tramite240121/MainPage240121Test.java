package SEDENA.Tramite240121;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240121Test {
    MainPage240121 mainPage240121 = new MainPage240121();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0402600901920254006000003";
    TramitesFirmasLG tramite240121 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite240121F = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
    public void Proceso240121() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240121");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica240121");
        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen240121");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion240121");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox, autorizarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240121");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica240121");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen240121");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion240121");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240121);
            mainPage240121.selecRol.sendKeys("Persona Moral");
            mainPage240121.btnacep.click();
            mainPage240121.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240121.SoliNew.click();
            mainPage240121.SEDENA.click();
            mainPage240121.linkCerLicPer.click();
            mainPage240121.linkPermisoAduanalSEDENA.click();
            mainPage240121.linkPermisoOrdExpMatExplosivo.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240121.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240121.labelDatosSolicitud.click();
            mainPage240121.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240121.inputAddOrigenLista.click();
            mainPage240121.inputPermisoGeneral.sendKeys("PRUEBAS");
            mainPage240121.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240121.btnAgregarMercancia.click();
            mainPage240121.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240121.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240121.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240121.inputValorComercialMercancia.sendKeys("1234");
            mainPage240121.selectUMCMercancia.sendKeys("Caja");
            mainPage240121.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240121.btnAgregarMercancia2.click();
            mainPage240121.inputSemestre2.click();
            mainPage240121.inputAnoCurso.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240121.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240121.labelTercerosRelacionados.click();
            mainPage240121.btnAgregarDestinatario.click();
            mainPage240121.inputFisica.click();
            mainPage240121.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240121.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240121.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240121.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240121.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240121.inputTercerosCP.sendKeys("23456");
            mainPage240121.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240121.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240121.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240121.inputTercerosLada.sendKeys("52");
            mainPage240121.inputTercerosTelefono.sendKeys("23456257");
            mainPage240121.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240121.btnGuardarTerceros.click();
            mainPage240121.btnAgregarProveedor.click();
            mainPage240121.inputNacional.click();
            mainPage240121.inputFisica.click();
            mainPage240121.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240121.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240121.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240121.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            mainPage240121.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240121.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240121.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240121.inputTercerosCP2.sendKeys("28006");
            mainPage240121.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240121.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240121.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240121.inputTercerosNumeroInt.sendKeys("321");
            mainPage240121.inputTercerosLada.sendKeys("52");
            mainPage240121.inputTercerosTelefono.sendKeys("234565432");
            mainPage240121.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240121.btnGuardarTerceros.click();

            mainPage240121.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240121.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240121.inputCadenaDependencia.setValue(factura.toString());
            mainPage240121.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240121.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240121.inputCalendar);sleep(100);
            mainPage240121.inputImportePago.sendKeys("5000");
            mainPage240121.InputGuardarSolicitud.click();
            mainPage240121.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240121.btmAnexar.click();sleep(8000);Selenide.sleep(4000);
            mainPage240121.btnCerrar.click();Selenide.sleep(2000);
            mainPage240121.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240121);Selenide.sleep(2000);Selenide.sleep(2000);
            String folioText = mainPage240121.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen240121")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica240121")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen240121")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ConfirmarNotificacion240121")) {
                ConfirmarNotificacion(folioNumber);
            }guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite240121F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage240121.iniciofun.click();
        mainPage240121.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240121.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage240121.inputDictamenAceptado.click();
        mainPage240121.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        Selenide.executeJavaScript("arguments[0].value = '05/02/2026';",mainPage240121.inputInicioFechaVigencia);sleep(100);
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite240121F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240121.iniciofun.click();sleep(3000);
        mainPage240121.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240121.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramite240121F);sleep(8000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage240121.iniciofun.click();sleep(3000);
        mainPage240121.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage240121.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite240121F);sleep(8000);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite240121);sleep(3000);
        mainPage240121.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage240121.Btnacep.click();
        mainPage240121.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite240121);sleep(1000);sleep(4000);
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados240121.txt";

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
}