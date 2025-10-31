package COFEPRIS.Tramite260919;

import COFEPRIS.Tramite260919.MainPage260919;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260919Test {
    MainPage260919 mainPage260919 = new MainPage260919();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0402600901920254006000003";
    TramitesFirmasLG tramite260919 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260919F = new TramitesFirmasLG(
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
    public void Proceso260919() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260919");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica260919");
        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen260919");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion260919");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox, autorizarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260919");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica260919");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen260919");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion260919");

        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        ejecutarProcesoNRunnable(() -> {
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite260919);
            mainPage260919.selecRol.sendKeys("Persona Moral");
            mainPage260919.btnacep.click();
            mainPage260919.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260919.SoliSub.click();
            String Folio = obtenerNumFolioTramite("260219", "ESTSOL.AU");
            mainPage260919.inputIdFolio.sendKeys(Folio);
            mainPage260919.inputBuscarButton.click();
            sleep(1000);
            mainPage260919.SolicitudTramite.doubleClick();
            mainPage260919.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage260919.labelDatosSolicitud.click();
            mainPage260919.inputModif.click();
            mainPage260919.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            mainPage260919.inputRazonSocial.setValue("EMPRESA S.A. DE C.V.");
            mainPage260919.inputEmail.setValue("contacto@empresa.com");
            mainPage260919.inputCodigoPostal.setValue("01000");
            mainPage260919.inputEstado.sendKeys("COLIMA");
            mainPage260919.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage260919.inputLocalidad.setValue("Colonia Industrial");
            mainPage260919.inputColonia.setValue("Ampliación San Ángel");
            mainPage260919.inputCalle.setValue("Av. Revolución");
            mainPage260919.inputLada.setValue("55");
            mainPage260919.inputTelefono.setValue("12345678");
            mainPage260919.inputRegimen.sendKeys("Temporles"); // Ejemplo: Régimen general de personas morales
            mainPage260919.inputAduana.sendKeys("ADUANA DE PANTACO");
            mainPage260919.checkBoxMercancia.click();
            mainPage260919.btnModificar.click();
            /// ///
            mainPage260919.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260919.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260919.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage260919.inputDenominacionDistintiva.setValue("Distintiva123");
            mainPage260919.inputDenominacionComunInternacional.setValue("DCI-TEST");
            mainPage260919.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260919.inputEspecifique.setValue("PRUEBA");
            //mainPage260919.selectFormaFarmaceutica.sendKeys("Emulsión");
            mainPage260919.selectEstadoFisico.sendKeys("Liquido");
            mainPage260919.inputFraccionArancelaria.setValue("13021999");
            mainPage260919.inputCantidadUMT.setValue("100");
            mainPage260919.inputCantidadUMC.setValue("10");
            mainPage260919.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260919.textareaPresentacion.setValue("Ampolleta");
            mainPage260919.inputNumeroRegistroSanitario.setValue("1234");
            executeJavaScript("arguments[0].value = '08/06/2025';", mainPage260919.inputFechaCaducidad);sleep(100);
            mainPage260919.buttonAbrirPanelPaisesOrigen.click();
            mainPage260919.PaisOrigen.sendKeys("ARGENTINA");
            mainPage260919.inputAgregarSeleccion.click();
            mainPage260919.inputAbrirPanelPaisesProcedencia.click();
            mainPage260919.PaisProcedencia.sendKeys("ANGOLA");
            $("input[name='modificar'][value='Modificar']").click();
            /// ///
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260919.labelTerceros.click();
            mainPage260919.checkBoxFabricante.click();
            mainPage260919.btnModificarFabricante.click();
            mainPage260919.inputMoral.click();
            mainPage260919.inputTerceroRazonSocial.setValue("MODIFPRUEBAS SA DE CV");
            mainPage260919.inputPais.sendKeys("COREA");
            mainPage260919.terceroEstado.sendKeys("COLIMA");
//            mainPage260919.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage260919.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260919.terceroCP.sendKeys("28010");
            mainPage260919.terceroColoniaModif.sendKeys("ANTORCHA");
            mainPage260919.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260919.terceroNumExterior.setValue("13471118");
            mainPage260919.terceroNumInterior.setValue("4A");
            mainPage260919.inputTerceroLada.setValue("52");
            mainPage260919.terceroTelefono.setValue("5533335");
            mainPage260919.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260919.btnGuardarDatosTerceros.click();
            //DESTINATARIO
            mainPage260919.checkBoxDestinatario.click();
            mainPage260919.btnModificarDestinatario.click();
            mainPage260919.inputMoral.click();
            mainPage260919.inputTerceroRFC.setValue("TSD931210493");
            mainPage260919.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            //mainPage260919.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260919.terceroEstadoLocalidad.sendKeys("COLIMA");
            mainPage260919.inputTerceroMunicipio.sendKeys("COLIMA");
            mainPage260919.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage260919.terceroCodigoPostal.sendKeys("28010");
            mainPage260919.inputCodigoPostalEquivalente.sendKeys("ANTORCHA");
            mainPage260919.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage260919.terceroNumExterior.setValue("13471118");
            mainPage260919.terceroNumInterior.setValue("4A");
            mainPage260919.inputTerceroLada.setValue("52");
            mainPage260919.terceroTelefono.setValue("5533335");
            mainPage260919.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage260919.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260919.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260919.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260919.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260919.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260919.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260919.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260919.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260919.inputCalendar, fechaHoy);sleep(100);
            mainPage260919.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260919.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260919.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage260919.btnAnexar.click();sleep(2000);
            mainPage260919.btnCerrar.click();sleep(100);
            mainPage260919.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260919);
            Selenide.sleep(2000);
            String folioText = mainPage260919.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen260919")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica260919")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen260919")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ConfirmarNotificacion260919")) {
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
        loginFirmSoli.loginFun(tramite260919F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage260919.iniciofun.click();
        mainPage260919.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260919.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
//        mainPage260919.inputDictamenAceptado.click();
//        mainPage260919.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
//        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage260919.inputFechaFinVig);sleep(100);
        mainPage260919.inputAsignador.sendKeys("GONZALEZ PINAL EUROFOODS DE MEXICO  LUIS AMBROSIO MARTINEZ VALENZUELA");
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite260919F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage260919.iniciofun.click();sleep(3000);
        mainPage260919.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260919.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[type='submit'][value='Dar Vo. Bo.']").click();
        loginFirmSoli.firmaFun(tramite260919F);sleep(8000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage260919.iniciofun.click();sleep(3000);
        mainPage260919.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260919.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite260919F);sleep(8000);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite260919);sleep(3000);
        mainPage260919.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage260919.Btnacep.click();
        mainPage260919.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite260919);sleep(1000);sleep(4000);
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
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados260919.txt";

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