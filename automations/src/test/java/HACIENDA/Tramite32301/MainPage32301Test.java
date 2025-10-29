package HACIENDA.Tramite32301;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32301.MainPage32301;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32301Test {
    MainPage32301 mainPage32301 = new MainPage32301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite32301  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite32301Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000;
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
    public void Proceso32301() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//        // Solicitar el folio al usuario
//        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
//
//        // Validar que el usuario haya ingresado un folio válido de 25 dígitos
//        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")){
//            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
//            return; // Cancelar la operación
//        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Crear checkboxes para los tipos de aviso
        JCheckBox[] opcionesAvisoCheckbox = {
                new JCheckBox("Aviso Clientes y Proveedores Extranjeros"), new JCheckBox("Aviso Proveedores Nacionales"), new JCheckBox("Aviso Modificación Socios"),
                new JCheckBox("Aviso Por Modificación de Uso y Goce del Inmueble"), new JCheckBox("Aviso Fusion Escision"), new JCheckBox("Aviso de Adición de Fracciones")
        };

        // Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            avisoPanel.add(checkbox);
        }

        // Añadir un ItemListener para permitir solo una selección a la vez
        ItemListener listener = e -> {
            JCheckBox source = (JCheckBox) e.getSource();
            if (source.isSelected()) {
                for (JCheckBox checkbox : opcionesAvisoCheckbox) {
                    if (checkbox != source) {
                        checkbox.setSelected(false); // Desactivar los demás
                    }
                }
            }
        };

        // Añadir el listener a cada checkbox
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            checkbox.addItemListener(listener);
        }

        // Mostrar diálogo con los checkboxes
        int avisoOption = JOptionPane.showConfirmDialog(
                null,
                avisoPanel,
                "Seleccione un tipo de aviso a ejecutar:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (avisoOption != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Cancelar si el usuario no acepta
        }

        // Recoger la selección realizada por el usuario
        String avisoSeleccionado = null;
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            if (checkbox.isSelected()) {
                avisoSeleccionado = checkbox.getText();
                break;
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////-

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32301");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            String FolioRubro = buscarFolioTramiteCompleto();
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32301);
            mainPage32301.selecRol.sendKeys("Persona Moral");
            mainPage32301.btnacep.click();
            mainPage32301.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage32301.soliSubsecuente.click();
            mainPage32301.folioTramite.sendKeys(FolioRubro);
            mainPage32301.btnBuscarFolio.click();sleep(1000);
            mainPage32301.tablaFolios.doubleClick();
            mainPage32301.avisoModificacion.click();
            // Ejecutar los métodos seleccionados
            for (JCheckBox checkbox : opcionesAvisoCheckbox) {
                mainPage32301.tipoAviso.click();
                if (checkbox.isSelected()) {
                    String aviso = checkbox.getText(); // Obtiene el texto del checkbox seleccionado
                    switch (aviso) {
                        case "Aviso Clientes y Proveedores Extranjeros":
                            ejecutarAvisoExtranjeros();
                            break;
                        case "Aviso Proveedores Nacionales":
                            ejecutarAvisoNacionales();
                            break;
                        case "Aviso Modificación Socios":
                            ejecutarAvisoSocios();
                            break;
                        case "Aviso Por Modificación de Uso y Goce del Inmueble":
                            ejecutarAvisoUsoyGoce();
                            break;
                        case "Aviso Fusion Escision":
                            ejecutarAvisoFusionEscision();
                            break;
                        case "Aviso de Adición de Fracciones":
                            ejecutarAvisoFracciones();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                            break;
                    }
                }
            }
            metodos.scrollDecremento(1);
            mainPage32301.tipoAviso.click();
            mainPage32301.casillaAcepto.click();
            mainPage32301.btnGuardarSoli.click();
            mainPage32301.btnContinuar.click();

            // Verificar si uno de los dos checkboxes relevantes está seleccionado
            boolean avisoFusionSelected = opcionesAvisoCheckbox[4].isSelected(); // Aviso Fusion Escision
            boolean avisoUsoSelected = opcionesAvisoCheckbox[3].isSelected(); // Aviso Por Modificación de Uso y Goce del Inmueble

            // Realizar acción si alguno de los dos está seleccionado
            if (avisoFusionSelected || avisoUsoSelected) {
                ejecutarCodigoAdjuntar();
            }
            mainPage32301.btnSiguiente.click();
            loginFirmSoli.firma(tramite32301);

            // Obtener el texto del folio desde mainPage32301
            String folioText = mainPage32301.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")) {
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Confirmación automática...");
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }

        }, repeticiones);
    }

    private void verificarSeleccionArchivos(List<String> avisosSeleccionados){
        boolean avisoFusionSelected = avisosSeleccionados.contains("Aviso Fusion Escision");
        boolean avisoUsoSelected = avisosSeleccionados.contains("Aviso Por Modificación de Uso y Goce del Inmueble");

        if (avisoFusionSelected && avisoUsoSelected){
            ejecutarCodigoAdjuntar2();
        } else if (avisoUsoSelected || avisoFusionSelected) {
            ejecutarCodigoAdjuntar();
        } else {
            System.out.println("No Hay Archivos Por Cargar");
        }
    }

    private void ejecutarCodigoAdjuntar() {
        mainPage32301.btnAdjuntar1Doc.click();
        mainPage32301.archivoUnico.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.btnAdjuntar.click();
        mainPage32301.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
        mainPage32301.btnCerrar.click();
    }

    private void ejecutarCodigoAdjuntar2() {
        mainPage32301.btnAdjuntarDoc.click();
        mainPage32301.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.btnAdjuntar.click();sleep(3000);
        mainPage32301.btnCerrar.click();
    }

    private void ejecutarAvisoExtranjeros() {
        mainPage32301.clientesExtranjeros.click();
        scrollDecremento();
        /// Provedores extranjeros
        mainPage32301.modificacionExtranjeros.click();
        mainPage32301.archivoExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjeros_aviso.xlsx");
        mainPage32301.btnCargarExtranjeros.click();sleep(1000);
        clickOkButton();
    }

    private void ejecutarAvisoNacionales() {
        mainPage32301.clientesNacionales.click();
        /// Provedores nacionales
        mainPage32301.modificacionNacionales.click();
        mainPage32301.archivoNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionales_A_aviso.xlsx");
        mainPage32301.btnCargarNacionales.click();sleep(1500);
        mainPage32301.btnOK.click();
    }

    private void ejecutarAvisoSocios() {
        mainPage32301.avisoSocios.click();
        /// Socios
        mainPage32301.modificacionSocios.click();
        mainPage32301.btnAgregarMiembro.click();
        mainPage32301.tipoSocio.sendKeys("SOCIO");
        mainPage32301.tributarMexicoNo.click();
        mainPage32301.nacionalidad.sendKeys("argelia");
        mainPage32301.tipoPersona.sendKeys("moral");
        mainPage32301.nombreEmpresa.sendKeys("PRUEBAS");
        mainPage32301.btnAgregarSocio.click();sleep(1000);
        clickAceptarButton();
        mainPage32301.btnAgregarMiembro.click();
        mainPage32301.tipoSocio.sendKeys("SOCIO");
        mainPage32301.tributarMexicoNo.click();
        mainPage32301.nacionalidad.sendKeys("argelia");
        mainPage32301.tipoPersona.sendKeys("moral");
        mainPage32301.nombreEmpresa.sendKeys("PRUEBAS2");
        mainPage32301.btnAgregarSocio.click();sleep(1000);
        mainPage32301.btnAceptar.click();
        mainPage32301.selecTodos.click();
        mainPage32301.btnRatificar.click();sleep(1000);
        mainPage32301.btnAceptarRatificar.click();
    }

    private void ejecutarAvisoUsoyGoce() {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        mainPage32301.avisoInmuebles.click();
        /// Inmuebles
        scrollDecremento();
        mainPage32301.inmuebles.click();
        mainPage32301.domicilioNuevo.click();sleep(1000);
        mainPage32301.btnAceptarDomicilioNuevo.click();
        mainPage32301.btnAgregarDomicilioNuevo.click();sleep(1000);sleep(2000);
        mainPage32301.domicilioInmueble.sendKeys("CAMINO VIEJO, MIGUEL HIDALGO, 1353");
        mainPage32301.codigoPostalInmueble.sendKeys("81210");
        mainPage32301.entidadInmueble.sendKeys("SINALOA");
        mainPage32301.municipioInmueble.sendKeys("CULIACAN");
        mainPage32301.documentoUsoGoce.sendKeys("DONACION");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32301.fechaInicioInmueble, fechaHoy);sleep(1000);
        mainPage32301.fechaFinInmueble.click();
        mainPage32301.selecFechaFin.click();
        mainPage32301.rfcPartes.sendKeys("ZCF030121RP0");
        mainPage32301.btnBuscarPersonaM.click();sleep(1000);
        mainPage32301.caracterDe.sendKeys("PERSONA MORAL");
        mainPage32301.agregarPersonaM.click();
        mainPage32301.btnAceptarPersonaM.click();
        mainPage32301.observacionesInmueble.sendKeys("PRUEBA");
        mainPage32301.agregarNuevoDomicilio.click();sleep(1000);
        mainPage32301.btnAceptarNuevoDomicilio.click();
    }
    private void ejecutarAvisoFusionEscision() {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        mainPage32301.avisoFusionEscision.click();
        /// Fusion Escesion
        scrollDecremento();scrollDecremento();
        mainPage32301.fusionEscesion.click();
        mainPage32301.aviso1.click();
        mainPage32301.escesion.click();
        mainPage32301.certificacionNo.click();
        mainPage32301.rfcEmpresa.sendKeys("GARR880923F55");
        mainPage32301.razonSocial.sendKeys("PRUEBA");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32301.fechaFusEsc, fechaHoy);sleep(1000);
        mainPage32301.folioFusEsc.sendKeys("QA");
        mainPage32301.btnAgregarPersonaFusEsc.click();
        mainPage32301.certificacionSi.click();
        mainPage32301.rfcPersona.sendKeys("AAL0409235E6");
        mainPage32301.btnBuscarPersona.click();
        mainPage32301.btnAceptarPersona.click();sleep(1000);
        mainPage32301.clickAceptar.click();
    }
    private void ejecutarAvisoFracciones() {
        mainPage32301.avisoFracciones.click();
        /// Fracciones
        mainPage32301.fracciones.click();
        mainPage32301.cargaManual.click();
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("12345");
        mainPage32301.actividadRelacionada.sendKeys("PROCESO");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBAS");
        mainPage32301.fraccionActual.sendKeys("01023101");
        mainPage32301.unidadMedida.sendKeys("Voltios");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();sleep(1000);
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("54321");
        mainPage32301.actividadRelacionada.sendKeys("AMBOS");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBAS");
        mainPage32301.fraccionActual.sendKeys("01041001");
        mainPage32301.unidadMedida.sendKeys("Voltios");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();sleep(1000);
        mainPage32301.manifiestoFracciones.click();
        /// Procesos
        scrollDecremento();
        mainPage32301.procesos.click();
        mainPage32301.archivoProcesos.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Procesos todas aduanas paises corregido paises.xls");
        mainPage32301.cargarArchivo.click();sleep(3000);
        mainPage32301.aceptarCarga.click();
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

    public void clickAceptarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }

    public void clickAgregarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Agregar")).shouldBe(visible).shouldHave(text("Agregar")).doubleClick();
    }

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 3; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }

    public void ProcesoGenerarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite32301Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage32301.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage32301.btnBuscarFolioFun.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite32301Fun);sleep(5000);
    }
    public String buscarFolioTramiteCompleto() {

        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";

        long idSolicitudInicial = -1;
        String numFolioTramite = null;
        long idSolicitudFinal = -1;
        String estadoSolicitudFinal = null;

        String query1 =
                "SELECT ID_SOLICITUD FROM VUC_SOLICITUD WHERE CVE_USUARIO_CAPTURISTA LIKE 'AAL%%' " +
                        "AND IDE_EST_SOLICITUD LIKE 'ESTSOL.AU%%' AND ID_TIPO_TRAMITE IN (31601, 31602, 31603) " +
                        "AND FEC_CREACION >= SYSDATE - 30 ORDER BY FEC_CREACION DESC";

        String query2 = "SELECT NUM_FOLIO_TRAMITE FROM VUC_TRAMITE WHERE ID_SOLICITUD = ?";

        String query3 = "SELECT ID_SOLICITUD, IDE_EST_SOLICITUD FROM VUC_SOLICITUD WHERE NUM_FOLIO_TRAMITE_ORIGINAL = ? AND IDE_EST_SOLICITUD LIKE 'ESTSOL.R%%'";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            try (Statement statement1 = connection.createStatement();
                 ResultSet rs1 = statement1.executeQuery(query1)) {
                if (rs1.next()) {
                    idSolicitudInicial = rs1.getLong("ID_SOLICITUD");
                    System.out.println("Paso 1: ID_SOLICITUD más reciente encontrada: " + idSolicitudInicial);
                } else {
                    System.out.println("Paso 1: No se encontraron ID_SOLICITUD. Retornando null.");
                    return null;
                }
            }

            try (PreparedStatement statement2 = connection.prepareStatement(query2)) {
                statement2.setLong(1, idSolicitudInicial);

                try (ResultSet rs2 = statement2.executeQuery()) {
                    if (rs2.next()) {
                        numFolioTramite = rs2.getString("NUM_FOLIO_TRAMITE");
                        System.out.println("Paso 2: NUM_FOLIO_TRAMITE encontrado: " + numFolioTramite);
                    } else {
                        System.out.println("Paso 2: No se encontró NUM_FOLIO_TRAMITE para ID: " + idSolicitudInicial + ". Retornando null.");
                        return null;
                    }
                }
            }

            try (PreparedStatement statement3 = connection.prepareStatement(query3)) {
                if (numFolioTramite == null) return null; // Verificación de seguridad

                statement3.setString(1, numFolioTramite);

                try (ResultSet rs3 = statement3.executeQuery()) {
                    if (rs3.next()) {
                        idSolicitudFinal = rs3.getLong("ID_SOLICITUD");
                        estadoSolicitudFinal = rs3.getString("IDE_EST_SOLICITUD");
                        System.out.printf("Paso 3: Verificación exitosa. Folio está en estado 'R%%' (%s).%n", estadoSolicitudFinal);

                        return numFolioTramite;
                    } else {
                        System.out.println("Paso 3: El folio encontrado NO está en estado 'ESTSOL.R%'. Retornando el folio de todos modos.");

                        return numFolioTramite;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión/SQL al ejecutar las consultas: " + e.getMessage());
            return null;
        }
    }
}
