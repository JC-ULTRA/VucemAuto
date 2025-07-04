
package Economia.Tramite130120;
import DBYFOLIO.ConDBReasigSolFun;
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

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.sql.DriverManager.setLoginTimeout;

public class MainPage130120Test {
    MainPage130120 mainPage130120 = new MainPage130120();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130120  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite130120fun  = new TramitesFirmasLG(
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

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso130120() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130120");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130120");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130120");

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
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130120");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130120");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130120");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130120);
            mainPage130120.SelecRol.sendKeys(new CharSequence[]{"Persona Moral"});
            mainPage130120.Btnacep.click();
            mainPage130120.tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
            mainPage130120.SoliNew.click();
            mainPage130120.Economia.click();
            mainPage130120.Permisos.click();
            mainPage130120.Importacion.click();
            mainPage130120.Tramite130120.click();
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage130120.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130120.DatosSolicitud.click();




            mainPage130120.selectSolicitudRegimenClave.sendKeys(new CharSequence[]{"Definitivos"});
            mainPage130120.selectClasificacionRegimen.sendKeys(new CharSequence[]{"De importación"});
            mainPage130120.textareaSolicitudMercanciaDescripcion.sendKeys(new CharSequence[]{"PRUEBAS QA"});
            mainPage130120.inputSolicitudMercanciaMarca.sendKeys(new CharSequence[]{"QA MERCANCIA"});
            mainPage130120.inputSolicitudAduana.sendKeys(new CharSequence[]{"Terrestre"});
            mainPage130120.optionLasDem.click();
            mainPage130120.optionLosDem.click();
            mainPage130120.optionUnidadMedida.sendKeys(new CharSequence[]{"Amperios"});
            mainPage130120.inputSolicitudMercanciaNumeroFactura.sendKeys(new CharSequence[]{"123456654"});
            mainPage130120.inputFechaFactura.pressEnter().sendKeys(new CharSequence[]{"22/10/2024"});
            mainPage130120.optionAbsorcion.click();
            mainPage130120.inputSolicitudMercanciaCantidadComercial.sendKeys(new CharSequence[]{"100"});
            mainPage130120.inputSolicitudMercanciaCapacidad.sendKeys(new CharSequence[]{"10"});
            mainPage130120.inputSolicitudMercanciaValorFactura.sendKeys(new CharSequence[]{"100"});
            mainPage130120.optionDinar.click();
            mainPage130120.optionPaisExp.click();
            mainPage130120.optionPaisOri.click();
            mainPage130120.inputSolicitudMercanciaValorTotal.sendKeys(new CharSequence[]{"100"});
            mainPage130120.inputSolicitudNumDocumento.sendKeys(new CharSequence[]{"123456"});
            mainPage130120.inputFechaGenerica.pressEnter().sendKeys(new CharSequence[]{"22/10/2024"});
            mainPage130120.textareaSolicitudDatosGenericosDescripcion.sendKeys(new CharSequence[]{"PRUEBAS QA"});
            mainPage130120.inputSolicitudCodigoAran.sendKeys(new CharSequence[]{"1234"});
            mainPage130120.inputSolicitudCantidadUnidadMedida.sendKeys(new CharSequence[]{"100"});
            mainPage130120.inputSolicitudValorUSD.sendKeys(new CharSequence[]{"100"});
            mainPage130120.inputSolicitudPrecioUnitario.sendKeys(new CharSequence[]{"100"});
            mainPage130120.inputNinguno.click();
            mainPage130120.textareaSolicitudDomicilio.sendKeys(new CharSequence[]{"PRUEBA QA CDMX"});
            mainPage130120.inputMoral.click();
            mainPage130120.inputSolicitudExpRazonSocial.sendKeys(new CharSequence[]{"ULTRASIST"});
            mainPage130120.textareaSolicitudExportadorDomicilioDes.sendKeys(new CharSequence[]{"PRUEBA QA CDMX"});
            mainPage130120.textareaSolicitudObservaciones.sendKeys(new CharSequence[]{"PRUEBA QAS"});
            mainPage130120.optionSin.click();
            mainPage130120.optionCuliacan.click();
            mainPage130120.inputGuardarSolicitud.click();
            mainPage130120.inputContinuar.click();
            mainPage130120.inputAdjuntarDocumentos.click();
            mainPage130120.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130120.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130120.inputAnexar.click();sleep(3500);
            mainPage130120.inputCerrar.click();
            setLoginTimeout(3000);
            mainPage130120.inputSiguienteButton.click();
            loginFirmSoli.firma(tramite130120);

            // Obtener el texto del folio desde mainPage130120
            String folioText = mainPage130120.folio.getText();

            // Llamar al mtodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

            // Ejecutar métodos seleccionados
            if (selectedMethods.contains("ProcesoDictamen130120")) {
                ProcesoDictamen130120(folioNumber);
            }
            if (selectedMethods.contains("ProcesoAutorizacion130120")) {
                ProcesoAutorizacion130120(folioNumber);
            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucionB8")) {
//                ProcesoConfirmarNotificaciónResolucion130120(folioNumber);
//            }
            guardarFolioEnArchivo(folioNumber);

        }, repeticiones);

    }

    //Proceso Dictamen
    public void ProcesoDictamen130120(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite130120fun);
        // Búsqueda de Folio
        mainPage130120.iniciofun.click();
        mainPage130120.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage130120.btnBuscarFolio.click();sleep(4500);
        mainPage130120.tablatarea.doubleClick();
        mainPage130120.generaDict.click();
        mainPage130120.btmContinuarDict.click();
        mainPage130120.sentidoAceptado.click();
        mainPage130120.antecedentesDict.sendKeys("PRUEBAS QA");
        mainPage130120.btnFirmarDict.click();
        loginFirmSoli.firmaFun(tramite130120fun);sleep(1000); sleep(4000);
    }

    public void ProcesoAutorizacion130120(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        // Búsqueda de Folio
        mainPage130120.iniciofun.click();
        mainPage130120.numfolio.sendKeys(folioNumber);sleep(1000);
        mainPage130120.btnBuscarFolio.click();sleep(4500);
        mainPage130120.tablatarea.doubleClick();
        mainPage130120.btnAutorizar.click();
        loginFirmSoli.firmaFun(tramite130120fun);sleep(4000);
    }

//    //Proceso Confirmar Notificación Resolución
//    public void ProcesoConfirmarNotificaciónResolucionB8(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
//        loginFirmSoli.loginSolicitanteB8();
//        mainPageB8.selecRol2.sendKeys("Persona Moral");
//        mainPageB8.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPageB8.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPageB8.inputNumFolio.sendKeys(folioNumber);
//            mainPageB8.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPageB8.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPageB8.inputAcuse.click();
//        //Firma Funcionario
//        firmaSoli.firmarsolicitanteB8();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPageB8.notification.getText());
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase

        }
    }
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados.txt";

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