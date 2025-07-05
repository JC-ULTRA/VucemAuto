package HACIENDA.Tramite5701;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import DBYFOLIO.ConDBReasigSolFun;
import javax.swing.*;

//import static com.codeborne.selenide.Condition.visible;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage5701Test {
    MainPage5701 mainPage5701 = new MainPage5701();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite5701 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
    );
    TramitesFirmasLG tramite5701Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        SelenideLogger.addListener("allure", new AllureSelenide());
        initDriver();
    }

    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();
        initDriver();
        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso5701() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen5701");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion5701");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion5701");

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
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen5701");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion5701");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion5701");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            // Ingreso y selección de trámite
            desactivarPago();
            loginFirmSoli.login(tramite5701);
            mainPage5701.selecRol.sendKeys("Persona Fisica");
            mainPage5701.btnacep.click();
            mainPage5701.Tramites.click();
            mainPage5701.SoliNew.click();
            mainPage5701.hacienda.click();
            mainPage5701.linkServiciosExtraordinarios.click();
            mainPage5701.linkRegistroSolicitudServiciosExtraordinarios.click();
            sleep(100);
            mainPage5701.labelDatosSolicitud.click();
            sleep(1000);
            mainPage5701.selectTipoServicio.sendKeys("Mensual");
            sleep(1000);
            mainPage5701.inputServiciosDtoImportadorExportador.setValue("LEQI8101314S7");

            mainPage5701.inputFechaInicio.shouldBe(visible).click();
            $(byText("15")).shouldBe(visible).click();
            sleep(2000);
            mainPage5701.inputHoraInicial.setValue("0600");
            sleep(2000);
            mainPage5701.inputFechaFinal.shouldBe(visible).click();
            $(byText("20")).shouldBe(visible).click();
            sleep(2000);
            mainPage5701.inputHoraFinal.setValue("2300");
            sleep(2000);
//            //Especifique los días que se utilizarán dentro del periodo*:
//            mainPage5701.labelFechasDentroDelPeriodo.click();
//            sleep(2000);
//            String[] diasSeleccionados = {
//                    "Jueves,19/12/2024",
//                    "Viernes,20/12/2024",
//                    "Sábado,21/12/2024",
//                    "Domingo,22/12/2024",
//                    "Martes,15/04/2025"
//            };
//            for (String dia : diasSeleccionados) {
//                $$(byText(dia)).filter(visible).first().click(); // Encuentra y selecciona el día visible
//                mainPage5701.inputBotonAgregarFechas.click(); // Hace clic en "Agregar"
//                sleep(1000); // Pausa breve entre interacciones
//            }
            mainPage5701.agregarTodos.click();
            //Datos del despacho para el servicio extraordinario
            mainPage5701.selectAduanaDespacho.sendKeys("470 - AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage5701.selectSeccionDespacho.sendKeys("471 - SATELITE, PARA IMPORTACION Y EXPORTACION POR VIA AEREA, AEROPUERTO INTERNACIONAL BENITO JUAREZ DE LA CIUDAD DE MEXICO");
            mainPage5701.selectTipoOperacion.sendKeys("Exportacion");

            //Mercancía
            mainPage5701.selectServiciosDtoMercanciaPais.sendKeys("ANTARTIDA");
            sleep(2000);
            mainPage5701.selectServiciosDtoMercanciaPais3.sendKeys("ANTARTIDA");
            sleep(2000);
            mainPage5701.textareaDescripcionGenerica.setValue("Prueba QA");
            sleep(2000);
            mainPage5701.textareaJustificacion.setValue("Prueba QA");
            sleep(2000);

            //Personas responsables del despacho (máximo 5)
            mainPage5701.inputGafeteRespoDespacho.setValue("0000040923");
            sleep(2000);
            mainPage5701.inputBuscar.click();
            mainPage5701.buttonCerrar2.click();
            mainPage5701.inputNombreRespoDespacho.setValue("Pauli");
            sleep(2000);
            mainPage5701.inputPaternoRespoDespacho.setValue("QA");
            sleep(2000);
            mainPage5701.inputMaternoRespoDespacho.setValue("QA");
            sleep(2000);
            mainPage5701.inputAgregar2.click();
            mainPage5701.buttonCerrar3.click();
            //PAGOS
            mainPage5701.inputLineaCapturaModal.setValue("032000Q0GHM128445291");
            sleep(2000);
            mainPage5701.inputMontoModal.setValue("5000");
            sleep(2000);
            mainPage5701.inputAgregarPago.click();
            sleep(2000);
            mainPage5701.buttonAceptarNotificacion.click();
            //mainPage5701.buttonAceptar.click();
            sleep(2000);
            mainPage5701.inputGridPagoSea.click();
            sleep(2000);
            mainPage5701.inputGuardarSolicitud.click();
            sleep(200);

            //PASO 2 REQUISITOS NECESARIOS
            //Requisitos opcionales
            mainPage5701.inputContinuar.click();

            //Cargar archivos
            mainPage5701.inputAdjuntarDocumentos.click();
            sleep(20);
            mainPage5701.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage5701.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage5701.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage5701.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage5701.inputAnexar.click();
            sleep(2000);
            mainPage5701.inputCerrar.click();
            mainPage5701.inputsiguiente.click();
            loginFirmSoli.firma(tramite5701);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage5701.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            Ejecutar métodos seleccionados
            if (selectedMethods.contains("ProcesoDictamen5701")) {
                ProcesoDictamen5701(folioNumber);
                ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
            }
            if (selectedMethods.contains("ProcesoAutorizacion5701")) {
                ProcesoAutorizacion5701(folioNumber);
            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion5701")) {
//                ProcesoConfirmarNotificaciónResolucion5701(folioNumber);
//            }
            guardarFolioEnArchivo(folioNumber);
        }, repeticiones);

    }
    //Proceso Dictamen
    public void ProcesoDictamen5701(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite5701Fun);
        // Búsqueda de Folio
        mainPage5701.iniciofun.click();
        mainPage5701.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage5701.btnBuscarFolio.click();sleep(4500);
        mainPage5701.tablatarea.doubleClick();
        mainPage5701.generaDict.click();
        mainPage5701.btmContinuarDict.click();
        mainPage5701.sentidoAceptado.click();
        mainPage5701.justificacionDict.sendKeys("PRUEBAS QA");
        mainPage5701.btnFirmarDict.click();
        loginFirmSoli.firmaFun(tramite5701Fun);sleep(1000); sleep(4000);
    }

//    //Proceso Autorización
    public void ProcesoAutorizacion5701(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        // Búsqueda de Folio
        mainPage5701.iniciofun.click();
        mainPage5701.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage5701.btnBuscarFolio.click();sleep(4500);
        mainPage5701.tablatarea.doubleClick();
        mainPage5701.btnAutorizar.click();
        loginFirmSoli.firmaFun(tramite5701Fun);sleep(4000);
    }
//
//    //Proceso Confirmar Notificación Resolución
//    public void ProcesoConfirmarNotificaciónResolucion5701(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
//        loginFirmSoli.loginSolicitante5701();
//        mainPage5701.selecRol2.sendKeys("Persona Moral");
//        mainPage5701.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage5701.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPage5701.inputNumFolio.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//            mainPage5701.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage5701.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage5701.inputAcuse.click();
//        //Firma Funcionario
////        firmaSoli.firmarsolicitante5701();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPage5701.notification.getText());
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//    }
//
    public void desactivarPago() {
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";

        String query = "UPDATE vuc_pago_sea SET BLN_ACTIVO = 0 WHERE linea_de_captura = '032000Q0GHM128445291'";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Ejecuta el query
            int filasActualizadas = statement.executeUpdate();

            // Comprueba si la actualización fue exitosa
            if (filasActualizadas > 0) {
                System.out.println("El registro ha sido actualizado correctamente.");
            } else {
                System.out.println("No se encontró el registro con la línea de captura proporcionada.");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar el query: " + e.getMessage());
        }
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados5701.txt";

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

