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
import java.util.*;

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

    TramitesFirmasLG tramite130120F  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
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

// Mostrar opciones para Persona Moral o Física
        JRadioButton moralButton = new JRadioButton("Persona Moral");
        JRadioButton fisicaButton = new JRadioButton("Persona Física");
        ButtonGroup group = new ButtonGroup();
        group.add(moralButton);
        group.add(fisicaButton);
        Object[] options = {"Seleccione el tipo de persona:", moralButton, fisicaButton};
        int seleccionTipo = JOptionPane.showConfirmDialog(null, options, "Tipo de Persona", JOptionPane.OK_CANCEL_OPTION);

// Validar la selección del usuario
        if (seleccionTipo != JOptionPane.OK_OPTION || (!moralButton.isSelected() && !fisicaButton.isSelected())) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opción válida. Operación cancelada.");
            return;
        }
// Determinar la hoja del Excel según la selección
        String hojaExcel = moralButton.isSelected() ? "F-001.E01.CP02" : "F-001.E01.CP01";

// Leer datos desde la hoja seleccionada
        Map<String, String> datosExcel;
        try {
            datosExcel = lectorExcel.leerDatos(rutaExcel, hojaExcel);
            if (datosExcel == null || datosExcel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró la hoja '" + hojaExcel + "' o está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Mapa de nombres legibles de campos
            Map<String, String> nombresCamposM = new HashMap<>();
            //Nombres persona moral
            nombresCamposM.put("A1", "Tipo Persona");
            nombresCamposM.put("A2", "Tipo Trámite");
            nombresCamposM.put("A3", "Régimen al que se destinará la mercancía * :");
            nombresCamposM.put("A4", "Clasificación de régimen * :");
            nombresCamposM.put("A5", "Descripción de la mercancía * :");
            nombresCamposM.put("A6", "Marca(s) comercial(es) y modelo(s) * :");
            nombresCamposM.put("A7", "Tipo de aduana de entrada * :");
            nombresCamposM.put("A8", "Fracción arancelaria * :");
            nombresCamposM.put("A9", "NICO * :");
            nombresCamposM.put("A10", "Unidad de medida de la tarifa(UMT) * :");
            nombresCamposM.put("A11", "Numero de factura * :");
            nombresCamposM.put("A12", "Fecha de factura * :");
            nombresCamposM.put("A13", "Unidad de medida de comercialización(UMC) * :");
            nombresCamposM.put("A14", "Cantidad UMC * :");
            nombresCamposM.put("A15", "Factor de conversión * :");
            nombresCamposM.put("A16", "Valor de la factura de la mercancía a importar en términos de la Moneda de Comercialización * :");
            nombresCamposM.put("A17", "Moneda de comercialización * :");
            nombresCamposM.put("A18", "País exportador * :");
            nombresCamposM.put("A19", "País origen * :");
            nombresCamposM.put("A20", "Valor total de la factura en términos de la Moneda de Comercialización * :");
            nombresCamposM.put("A21", "Número de documento * :");
            nombresCamposM.put("A22", "Fecha del documento * :");
            nombresCamposM.put("A23", "Descripción de la mercancía * :");
            nombresCamposM.put("A24", "Código arancelario * :");
            nombresCamposM.put("A25", "Cantidad en la unidad de medida señalada en el documento de exportación * :");
            nombresCamposM.put("A26", "Valor en USD de la mercancía a importar * :");
            nombresCamposM.put("A27", "Precio unitario en USD * :");
            nombresCamposM.put("A28", "Domicilio * productor:");
            nombresCamposM.put("A29", "Denominación o razón social * :");
            nombresCamposM.put("A30", "Domicilio * export:");
            nombresCamposM.put("A31", "Observaciones :");
            nombresCamposM.put("A32", "Entidad federativa * :");
            nombresCamposM.put("A33", "Representación federal");

            Map<String, String> nombresCamposF = new HashMap<>();
            //Nombres persona fisica
            nombresCamposF.put("B1", "Tipo Persona");
            nombresCamposF.put("B2", "Tipo Trámite");
            nombresCamposF.put("B3", "Régimen al que se destinará la mercancía * :");
            nombresCamposF.put("B4", "Clasificación de régimen * :");
            nombresCamposF.put("B5", "Descripción de la mercancía * :");
            nombresCamposF.put("B6", "Marca(s) comercial(es) y modelo(s) * :");
            nombresCamposF.put("B7", "Tipo de aduana de entrada * :");
            nombresCamposF.put("B8", "Fracción arancelaria * :");
            nombresCamposF.put("B9", "NICO * :");
            nombresCamposF.put("B10", "Unidad de medida de la tarifa(UMT) * :");
            nombresCamposF.put("B11", "Numero de factura * :");
            nombresCamposF.put("B12", "Fecha de factura * :");
            nombresCamposF.put("B13", "Unidad de medida de comercialización(UMC) * :");
            nombresCamposF.put("B14", "Cantidad UMC * :");
            nombresCamposF.put("B15", "Factor de conversión * :");
            nombresCamposF.put("B16", "Valor de la factura de la mercancía a importar en términos de la Moneda de Comercialización * :");
            nombresCamposF.put("B17", "Moneda de comercialización * :");
            nombresCamposF.put("B18", "País exportador * :");
            nombresCamposF.put("B19", "País origen * :");
            nombresCamposF.put("B20", "Valor total de la factura en términos de la Moneda de Comercialización * :");
            nombresCamposF.put("B21", "Número de documento * :");
            nombresCamposF.put("B22", "Fecha del documento * :");
            nombresCamposF.put("B23", "Descripción de la mercancía * :");
            nombresCamposF.put("B24", "Código arancelario * :");
            nombresCamposF.put("B25", "Cantidad en la unidad de medida señalada en el documento de exportación * :");
            nombresCamposF.put("B26", "Valor en USD de la mercancía a importar * :");
            nombresCamposF.put("B27", "Precio unitario en USD * :");
            nombresCamposF.put("B28", "Domicilio * productor:");
            nombresCamposF.put("B29", "Denominación o razón social * :");
            nombresCamposF.put("B30", "Domicilio * export:");
            nombresCamposF.put("B31", "Observaciones :");
            nombresCamposF.put("B32", "Entidad federativa * :");
            nombresCamposF.put("B33", "Representación federal");

            // Validar campos requeridos según el tipo de hoja
            List<String> camposRequeridos;
            if (moralButton.isSelected()) {
                camposRequeridos = new ArrayList<>(nombresCamposM.keySet());//VALIDA PERSONA MORAL
            } else {
                camposRequeridos = new ArrayList<>(nombresCamposF.keySet());//VALIDA PERSONA FISICA
            }

            // Validar campos requeridos y mostrar nombres legibles si faltan
            List<String> camposFaltantes = new ArrayList<>();
            for (String clave : camposRequeridos) {
                if (!datosExcel.containsKey(clave) || datosExcel.get(clave).trim().isEmpty()) {
                    camposFaltantes.add(nombresCamposM.getOrDefault(clave, clave));
                    camposFaltantes.add(nombresCamposF.getOrDefault(clave, clave));
                }
            }

            if (!camposFaltantes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan los siguientes campos:\n- " + String.join("\n- ", camposFaltantes),
                        "Campos requeridos faltantes", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo Excel:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
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
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
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

// Ingreso y selección de trámite según tipo de persona
            if (moralButton.isSelected()) {
                ProcesoRegistro130120Moral(datosExcel);
            } else {
                ProcesoRegistro130120Fisica(datosExcel);
            }

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

    // Proceso de Registro para Persona Moral, FÍsica
    public void ProcesoRegistro130120Moral(Map<String, String> datosExcel) {
        loginFirmSoli.login(tramite130120);
        mainPage130120.SelecRol.sendKeys(datosExcel.get("A1"));
        mainPage130120.Btnacep.click();
        mainPage130120.tramites.sendKeys(datosExcel.get("A2"));
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
        mainPage130120.selectSolicitudRegimenClave.sendKeys(datosExcel.get("A3"));
        mainPage130120.selectClasificacionRegimen.sendKeys(datosExcel.get("A4"));
        mainPage130120.textareaSolicitudMercanciaDescripcion.sendKeys(datosExcel.get("A5"));
        mainPage130120.inputSolicitudMercanciaMarca.sendKeys(datosExcel.get("A6"));
        mainPage130120.inputSolicitudAduana.sendKeys(datosExcel.get("A7"));
        mainPage130120.fracArancel.sendKeys(datosExcel.get("A8"));
        mainPage130120.inputNico.sendKeys(datosExcel.get("A9"));
        mainPage130120.inputUnidadMedidaTarifaUMT.sendKeys(datosExcel.get("A10"));
        mainPage130120.inputSolicitudMercanciaNumeroFactura.sendKeys(datosExcel.get("A11"));
        mainPage130120.inputFechaFactura.pressEnter().sendKeys(datosExcel.get("A12"));
        mainPage130120.inputUnidadmedidaComercializaciónUMC.pressEnter().sendKeys(datosExcel.get("A13"));
        mainPage130120.inputSolicitudMercanciaCantidadComercial.sendKeys(datosExcel.get("A14"));
        mainPage130120.inputSolicitudMercanciaCapacidad.sendKeys(datosExcel.get("A15"));
        mainPage130120.inputSolicitudMercanciaValorFactura.sendKeys(datosExcel.get("A16"));
        mainPage130120.inputMonedaComer.sendKeys(datosExcel.get("A17"));
        mainPage130120.inputPaisExp.sendKeys(datosExcel.get("A18"));
        mainPage130120.inputPaisOri.sendKeys(datosExcel.get("A19"));
        mainPage130120.inputSolicitudMercanciaValorTotal.sendKeys(datosExcel.get("A20"));
        mainPage130120.inputSolicitudNumDocumento.sendKeys(datosExcel.get("A21"));
        mainPage130120.inputFechaGenerica.pressEnter().sendKeys(datosExcel.get("A22"));
        mainPage130120.textareaSolicitudDatosGenericosDescripcion.sendKeys(datosExcel.get("A23"));
        mainPage130120.inputSolicitudCodigoAran.sendKeys(datosExcel.get("A24"));
        mainPage130120.inputSolicitudCantidadUnidadMedida.sendKeys(datosExcel.get("A25"));
        mainPage130120.inputSolicitudValorUSD.sendKeys(datosExcel.get("A26"));
        mainPage130120.inputSolicitudPrecioUnitario.sendKeys(datosExcel.get("A27"));
        mainPage130120.inputNinguno.click();
        mainPage130120.textareaSolicitudDomicilio.sendKeys(datosExcel.get("A28"));
        mainPage130120.inputMoral.click();
        mainPage130120.inputSolicitudExpRazonSocial.sendKeys(datosExcel.get("A29"));
        mainPage130120.textareaSolicitudExportadorDomicilioDes.sendKeys(datosExcel.get("A30"));
        mainPage130120.textareaSolicitudObservaciones.sendKeys(datosExcel.get("A31"));
        mainPage130120.inputEntidadFederativa.sendKeys(datosExcel.get("A32"));
        mainPage130120.inputRepresentaciónFederal.sendKeys(datosExcel.get("A33"));
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
    }
    public void ProcesoRegistro130120Fisica(Map<String, String> datosExcel) {
        loginFirmSoli.login(tramite130120F);
        mainPage130120.SelecRol.sendKeys(datosExcel.get("B1"));
        mainPage130120.Btnacep.click();
        mainPage130120.tramites.sendKeys(datosExcel.get("B2"));
        mainPage130120.SoliNew.click();
        mainPage130120.Economia.click();
        mainPage130120.PermisosF.click();
        mainPage130120.ImportacionF.click();
        mainPage130120.Tramite130120F.click();
        try {
            Thread.sleep(3000);
            mainPage130120.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage130120.DatosSolicitud.click();
        mainPage130120.selectSolicitudRegimenClave.sendKeys(datosExcel.get("B3"));
        mainPage130120.selectClasificacionRegimen.sendKeys(datosExcel.get("B4"));
        mainPage130120.textareaSolicitudMercanciaDescripcion.sendKeys(datosExcel.get("B5"));
        mainPage130120.inputSolicitudMercanciaMarca.sendKeys(datosExcel.get("B6"));
        mainPage130120.inputSolicitudAduana.sendKeys(datosExcel.get("B7"));
        mainPage130120.fracArancel.sendKeys(datosExcel.get("B8"));
        mainPage130120.inputNico.sendKeys(datosExcel.get("B9"));
        mainPage130120.inputUnidadMedidaTarifaUMT.sendKeys(datosExcel.get("B10"));
        mainPage130120.inputSolicitudMercanciaNumeroFactura.sendKeys(datosExcel.get("B11"));
        mainPage130120.inputFechaFactura.pressEnter().sendKeys(datosExcel.get("B12"));
        mainPage130120.inputUnidadmedidaComercializaciónUMC.pressEnter().sendKeys(datosExcel.get("B13"));
        mainPage130120.inputSolicitudMercanciaCantidadComercial.sendKeys(datosExcel.get("B14"));
        mainPage130120.inputSolicitudMercanciaCapacidad.sendKeys(datosExcel.get("B15"));
        mainPage130120.inputSolicitudMercanciaValorFactura.sendKeys(datosExcel.get("B16"));
        mainPage130120.inputMonedaComer.sendKeys(datosExcel.get("B17"));
        mainPage130120.inputPaisExp.sendKeys(datosExcel.get("B18"));
        mainPage130120.inputPaisOri.sendKeys(datosExcel.get("B19"));
        mainPage130120.inputSolicitudMercanciaValorTotal.sendKeys(datosExcel.get("B20"));
        mainPage130120.inputSolicitudNumDocumento.sendKeys(datosExcel.get("B21"));
        mainPage130120.inputFechaGenerica.pressEnter().sendKeys(datosExcel.get("B22"));
        mainPage130120.textareaSolicitudDatosGenericosDescripcion.sendKeys(datosExcel.get("B23"));
        mainPage130120.inputSolicitudCodigoAran.sendKeys(datosExcel.get("B24"));
        mainPage130120.inputSolicitudCantidadUnidadMedida.sendKeys(datosExcel.get("B25"));
        mainPage130120.inputSolicitudValorUSD.sendKeys(datosExcel.get("B26"));
        mainPage130120.inputSolicitudPrecioUnitario.sendKeys(datosExcel.get("B27"));
        mainPage130120.inputNinguno.click();
        mainPage130120.textareaSolicitudDomicilio.sendKeys(datosExcel.get("B28"));
        mainPage130120.inputMoral.click();
        mainPage130120.inputSolicitudExpRazonSocial.sendKeys(datosExcel.get("B29"));
        mainPage130120.textareaSolicitudExportadorDomicilioDes.sendKeys(datosExcel.get("B30"));
        mainPage130120.textareaSolicitudObservaciones.sendKeys(datosExcel.get("B31"));
        mainPage130120.inputEntidadFederativa.sendKeys(datosExcel.get("B32"));
        mainPage130120.inputRepresentaciónFederal.sendKeys(datosExcel.get("B33"));
        mainPage130120.inputGuardarSolicitud.click();
        mainPage130120.inputContinuar.click();
        mainPage130120.inputAdjuntarDocumentos.click();
        mainPage130120.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage130120.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage130120.inputAnexar.click(); sleep(3500);
        mainPage130120.inputCerrar.click();
        setLoginTimeout(3000);
        mainPage130120.inputSiguienteButton.click();
        loginFirmSoli.firma(tramite130120F);
    }

    //Proceso Dictamen, autorizar y Confitmar Notificación Resolución.
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
    // Metodo para guardar el folio en un archivo
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
    // Metodo para validar campos requeridos en el Excel
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