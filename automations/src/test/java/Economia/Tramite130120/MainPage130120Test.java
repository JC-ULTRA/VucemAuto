
package Economia.Tramite130120;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.LectorExcel;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.sql.DriverManager.setLoginTimeout;
public class MainPage130120Test {
    MainPage130120 mainPage130120 = new MainPage130120();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    LectorExcel lectorExcel = new LectorExcel();

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
//    public static void setUpAll() {
//        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }

    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130120() {
        // Cargar datos desde el archivo Excel
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione el archivo Excel con la información");
// Filtrar solo archivos .xlsx
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;}
        File excelFile = fileChooser.getSelectedFile();
        String rutaExcel = excelFile.getAbsolutePath();
// Validar que el archivo exista y tenga extensión .xlsx
        if (!excelFile.exists() || !rutaExcel.toLowerCase().endsWith(".xlsx")) {
            JOptionPane.showMessageDialog(null, "Archivo inválido o no es un archivo Excel (.xlsx).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
// Intentar leer la hoja "Hoja1"
        Map<String, String> datosExcel;
        try {datosExcel = lectorExcel.leerDatos(rutaExcel, "Hoja1");
            if (datosExcel == null || datosExcel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró la hoja 'Hoja1' o está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo Excel:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validar campos requeridos
        List<String> camposRequeridos = List.of(
                "SelecRol", "tramites", "selectSolicitudRegimenClave", "selectClasificacionRegimen",
                "textareaSolicitudMercanciaDescripcion", "inputSolicitudMercanciaMarca", "inputSolicitudAduana",
                "fracArancel", "inputNico", "inputUnidadMedidaTarifaUMT", "optionUnidadMedida", "inputSolicitudMercanciaNumeroFactura", "inputFechaFactura",
                "inputUnidadmedidaComercializaciónUMC", "inputSolicitudMercanciaCantidadComercial", "inputMonedaComer", "inputSolicitudMercanciaCapacidad",
                "inputSolicitudMercanciaValorFactura", "inputSolicitudMercanciaValorTotal",
                "inputSolicitudNumDocumento", "inputFechaGenerica", "textareaSolicitudDatosGenericosDescripcion",
                "inputSolicitudCodigoAran", "inputSolicitudCantidadUnidadMedida", "inputSolicitudValorUSD",
                "inputSolicitudPrecioUnitario", "textareaSolicitudDomicilio", "inputSolicitudExpRazonSocial",
                "textareaSolicitudExportadorDomicilioDes", "textareaSolicitudObservaciones", "inputPaisExp", "inputPaisOri",
                "inputRepresentaciónFederal", "inputEntidadFederativa"
        );
// Validar
        if (!validarCamposExcel(datosExcel, camposRequeridos)) {
            return; // Detener ejecución si hay campos faltantes
        }

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
        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130120");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130120");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130120");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
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
            mainPage130120.SelecRol.sendKeys(datosExcel.get("SelecRol"));
            mainPage130120.Btnacep.click();
            mainPage130120.tramites.sendKeys(datosExcel.get("tramites"));
            mainPage130120.SoliNew.click();
            mainPage130120.Economia.click();
            mainPage130120.Permisos.click();
            mainPage130120.Importacion.click();
            mainPage130120.Tramite130120.click();

            try {
                Thread.sleep(3000);
                mainPage130120.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage130120.DatosSolicitud.click();
            mainPage130120.selectSolicitudRegimenClave.sendKeys(datosExcel.get("selectSolicitudRegimenClave"));
            mainPage130120.selectClasificacionRegimen.sendKeys(datosExcel.get("selectClasificacionRegimen"));
            mainPage130120.textareaSolicitudMercanciaDescripcion.sendKeys(datosExcel.get("textareaSolicitudMercanciaDescripcion"));
            mainPage130120.inputSolicitudMercanciaMarca.sendKeys(datosExcel.get("inputSolicitudMercanciaMarca"));
            mainPage130120.inputSolicitudAduana.sendKeys(datosExcel.get("inputSolicitudAduana"));
            mainPage130120.fracArancel.sendKeys(datosExcel.get("fracArancel"));
            mainPage130120.inputNico.sendKeys(datosExcel.get("inputNico"));
            mainPage130120.inputUnidadMedidaTarifaUMT.sendKeys(datosExcel.get("inputUnidadMedidaTarifaUMT"));
            mainPage130120.optionUnidadMedida.sendKeys(datosExcel.get("optionUnidadMedida"));
            mainPage130120.inputSolicitudMercanciaNumeroFactura.sendKeys(datosExcel.get("inputSolicitudMercanciaNumeroFactura"));
            mainPage130120.inputFechaFactura.pressEnter().sendKeys(datosExcel.get("inputFechaFactura"));
            mainPage130120.inputUnidadmedidaComercializaciónUMC.pressEnter().sendKeys(datosExcel.get("inputUnidadmedidaComercializaciónUMC"));
            mainPage130120.inputSolicitudMercanciaCantidadComercial.sendKeys(datosExcel.get("inputSolicitudMercanciaCantidadComercial"));
            mainPage130120.inputSolicitudMercanciaCapacidad.sendKeys(datosExcel.get("inputSolicitudMercanciaCapacidad"));
            mainPage130120.inputSolicitudMercanciaValorFactura.sendKeys(datosExcel.get("inputSolicitudMercanciaValorFactura"));
            mainPage130120.inputMonedaComer.sendKeys(datosExcel.get("inputMonedaComer"));
            mainPage130120.inputPaisExp.sendKeys(datosExcel.get("inputPaisExp"));
            mainPage130120.inputPaisOri.sendKeys(datosExcel.get("inputPaisOri"));
            mainPage130120.inputSolicitudMercanciaValorTotal.sendKeys(datosExcel.get("inputSolicitudMercanciaValorTotal"));
            mainPage130120.inputSolicitudNumDocumento.sendKeys(datosExcel.get("inputSolicitudNumDocumento"));
            mainPage130120.inputFechaGenerica.pressEnter().sendKeys(datosExcel.get("inputFechaGenerica"));
            mainPage130120.textareaSolicitudDatosGenericosDescripcion.sendKeys(datosExcel.get("textareaSolicitudDatosGenericosDescripcion"));
            mainPage130120.inputSolicitudCodigoAran.sendKeys(datosExcel.get("inputSolicitudCodigoAran"));
            mainPage130120.inputSolicitudCantidadUnidadMedida.sendKeys(datosExcel.get("inputSolicitudCantidadUnidadMedida"));
            mainPage130120.inputSolicitudValorUSD.sendKeys(datosExcel.get("inputSolicitudValorUSD"));
            mainPage130120.inputSolicitudPrecioUnitario.sendKeys(datosExcel.get("inputSolicitudPrecioUnitario"));
            mainPage130120.inputNinguno.click();
            mainPage130120.textareaSolicitudDomicilio.sendKeys(datosExcel.get("textareaSolicitudDomicilio"));
            mainPage130120.inputMoral.click();
            mainPage130120.inputSolicitudExpRazonSocial.sendKeys(datosExcel.get("inputSolicitudExpRazonSocial"));
            mainPage130120.textareaSolicitudExportadorDomicilioDes.sendKeys(datosExcel.get("textareaSolicitudExportadorDomicilioDes"));
            mainPage130120.textareaSolicitudObservaciones.sendKeys(datosExcel.get("textareaSolicitudObservaciones"));
            mainPage130120.inputEntidadFederativa.sendKeys(datosExcel.get("inputEntidadFederativa"));
            mainPage130120.inputRepresentaciónFederal.sendKeys(datosExcel.get("inputRepresentaciónFederal"));
            mainPage130120.inputGuardarSolicitud.click();
            mainPage130120.inputContinuar.click();
            mainPage130120.inputAdjuntarDocumentos.click();
            mainPage130120.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130120.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130120.inputAnexar.click(); sleep(3500);
            mainPage130120.inputCerrar.click();
            setLoginTimeout(3000);
            mainPage130120.inputSiguienteButton.click();
            loginFirmSoli.firma(tramite130120);
            sleep(1000);
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

    public boolean validarCamposExcel(Map<String, String> datos, List<String> camposRequeridos) {
        List<String> faltantes = new ArrayList<>();
        for (String campo : camposRequeridos) {
            if (!datos.containsKey(campo) || datos.get(campo) == null || datos.get(campo).isEmpty()) {
                faltantes.add(campo);
            }
        }
        if (!faltantes.isEmpty()) {
            String mensaje = "Faltan los siguientes campos en el Excel:\n" + String.join("\n", faltantes);
            JOptionPane.showMessageDialog(null, mensaje, "Campos faltantes", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}