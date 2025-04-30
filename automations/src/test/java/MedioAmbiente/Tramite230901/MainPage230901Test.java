//package MedioAmbiente.Tramite230901;
//
//import DBYFOLIO.ObtenerFolio;
//import Firmas.LoginFirmSoli;
//import Firmas.TramitesFirmasLG;
//import com.codeborne.selenide.Browsers;
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.Selenide.sleep;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
//public class MainPage230901Test {
//    MainPage230901 mainPage230901 = new MainPage230901();
//    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
//
//    ObtenerFolio obtenerFolio = new ObtenerFolio();
//    //VARIABLES
//    String FunRFC = "MAVL621207C95";
//    String SoliRFC = "AAL0409235E6";
//
//    TramitesFirmasLG tramite230901  = new TramitesFirmasLG(
//            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
//            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
//    );
//
//    @BeforeAll
//    public static void setUpAll() {
//        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        iniDriver();
//    }
//
//    public static void iniDriver(){
//        Configuration.browser = Browsers.CHROME;
//        open();
//        getWebDriver().manage().window().maximize();
//        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//    }
//
//    @BeforeEach
//    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//    }
//
//    @Test
//    public void Proceso230901() {
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
//        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);
//
//        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
//        if (repeticionesStr == null) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return; // Termina el metodo si se selecciona cancelar
//        }
//
//        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
//        int repeticiones;
//        try {
//            repeticiones = Integer.parseInt(repeticionesStr);
//        } catch (NumberFormatException e) {
//            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
//            repeticiones = 1;
//            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
//        }
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//
//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen230901");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion230901");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion230901");
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
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen230901");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion230901");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion230901");
//
//        Runnable mercanciaComun = () -> {
//            mainPage230901.selectFraccionAran.sendKeys("01022999");
//            mainPage230901.textDescripcion.sendKeys("PRUEBA QA");
//            mainPage230901.textRendimiento.sendKeys("PRUEBA QA");
//            mainPage230901.selectClasificacionTaxo.sendKeys("Plantas");
//            mainPage230901.selectNombreCientifico.sendKeys("Euphorbia");
//            mainPage230901.selectNombreComun.sendKeys("Lechetreznas");
//            mainPage230901.inputMarca.sendKeys("MARCA QA");
//            mainPage230901.inputCantidad.sendKeys("12345");
//            mainPage230901.selectUDM.sendKeys("Pieza");
//            mainPage230901.selectPaisOrigen.sendKeys("ARGENTINA");
//            mainPage230901.selectPaisProcedencia.sendKeys("ANGUILA");
//            mainPage230901.inputAgregarMercancia.click();
//            mainPage230901.selectMovimientoDisponible.sendKeys("COMERCIAL (T)");
//            mainPage230901.btnAgregarSeleccion.click();
//
//        };
//        Runnable mercanciaComun2 = () -> {
//            mainPage230901.btnAgregarMercancia.click();
//            mainPage230901.selectFraccionAran.sendKeys("01029099");
//            mainPage230901.textDescripcion.sendKeys("PRUEBA QA");
//            mainPage230901.textRendimiento.sendKeys("PRUEBA QA");
//            mainPage230901.selectClasificacionTaxo.sendKeys("Plantas");
//            mainPage230901.selectNombreCientifico.sendKeys("Euphorbia");
//            mainPage230901.selectNombreComun.sendKeys("Lechetreznas");
//            mainPage230901.inputMarca.sendKeys("MARCA QA");
//            mainPage230901.inputCantidad.sendKeys("12345");
//            mainPage230901.selectUDM.sendKeys("Pieza");
//            mainPage230901.inputAgregarMercancia.click();
//            mainPage230901.selectMovimientoDisponible.sendKeys("COMERCIAL (T)");
//        };
//        Runnable procesoComun = () -> {
//            //TERCEROS
//            mainPage230901.inputEntidadFederativa.sendKeys("MICHOACÁN DE OCAMPO");
//            //PAGO DERECHOS
//            try {
//                Thread.sleep(2000); // Pausa de 3 segundos
//                // Hacer scroll hasta el elemento
//                mainPage230901.Scrol.scrollIntoView(true);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            mainPage230901.labelPagoDerechos.click();
//            mainPage230901.selectBanco.sendKeys("BANAMEX");
//            //mainPage230901.inputLlavePago.sendKeys("123ASD123");
//            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//            StringBuilder factura = new StringBuilder();
//            Random random = new Random();
//
//            for (int i = 0; i < 10; i++) {
//                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
//            }
//            mainPage230901.inputLlavePago.setValue(factura.toString());
//            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230901.inputFechaPago);sleep(100);
//        };
//
//        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
//        ejecutarProcesoNRunnable(() -> {
//            //Ingreso y selección de trámite
//            loginFirmSoli.login(tramite230901);
//            mainPage230901.selecRol.sendKeys("Persona Moral");
//            mainPage230901.btnacep.click();
//            mainPage230901.Tramites.sendKeys("Solicitudes nuevas");
//            mainPage230901.SoliNew.click();
//            mainPage230901.MedioAmbiente.click();
//            mainPage230901.linkCertificadosLicenciasPermisos.click();
//            mainPage230901.linkSEMARNAT08009.click();
//            mainPage230901.linkAutImpExpReeEjeParDerVidSal.click();
//
//            try {
//                Thread.sleep(2000); // Pausa de 3 segundos
//                // Hacer scroll hasta el elemento
//                mainPage230901.Scrol.scrollIntoView(true);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //DATOS SOLICITUD
//            mainPage230901.labelDatosSolicitud.click();
//            // Mostrar submenú para tipo movimiento
//// Mostrar submenú para tipo movimiento
//            JCheckBox movimiento = new JCheckBox("Importación");
//            JCheckBox movimiento2 = new JCheckBox("Exportación");
//            JCheckBox movimiento3 = new JCheckBox("Reexportación");
//
//            Object[] opcionesInput1 = {
//                    "Seleccione el tipo de movimiento:",
//                    movimiento, movimiento2, movimiento3
//            };
//
//            int seleccionCampos = JOptionPane.showConfirmDialog(
//                    null,
//                    opcionesInput1,
//                    "TIPO MOVIMIENTO",
//                    JOptionPane.OK_CANCEL_OPTION
//            );
//
//            if (seleccionCampos == JOptionPane.OK_OPTION) {
//                if (movimiento.isSelected()) {
//                    mainPage230901.selectTipoMovimiento.selectOptionByValue("01");
//                    mainPage230901.inputTipoRegimen.sendKeys("Temporales");
//                    mainPage230901.selectListaOrigen.sendKeys("COATZACOALCOS, VER.");
//                    mainPage230901.inputAgregarLista.click();
//                    mainPage230901.btnAgregarMercancia.click();
//                    mercanciaComun.run();
//                    //TERCEROS
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230901.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230901.labelTerceros.click();
//                    mainPage230901.inputEntidadFederativa.sendKeys("MORELOS");
//                    //PAGO DERECHOS
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230901.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230901.labelPagoDerechos.click();
//                    mainPage230901.selectBanco.sendKeys("BANAMEX");
//                    //mainPage230901.inputLlavePago.sendKeys("123ASD123");
//                    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//                    StringBuilder factura = new StringBuilder();
//                    Random random = new Random();
//
//                    for (int i = 0; i < 10; i++) {
//                        factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
//                    }
//                    mainPage230901.inputLlavePago.setValue(factura.toString());
//                    Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230901.inputFechaPago);sleep(100);
//
//                }
//
//                if (movimiento2.isSelected()) {
//                    mainPage230901.selectTipoMovimiento.selectOptionByValue("02");
//                    mainPage230901.inputTipoRegimen.sendKeys("Temporales");
//                    mainPage230901.selectListaOrigen2.sendKeys("COATZACOALCOS, VER.");
//                    mainPage230901.inputAgregarLista2.click();
//                    mercanciaComun2.run();
//                    mainPage230901.btnAgregarSeleccion.click();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230901.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230901.labelTerceros.click();
//                    mainPage230901.inputEntidadFederativa.sendKeys("ANTARTIDA");
//                    procesoComun.run();
//                }
//
//                if (movimiento3.isSelected()) {
//                    mainPage230901.selectTipoMovimiento.selectOptionByValue("04");
//                    mainPage230901.inputTipoRegimen.sendKeys("Definitvos");
//                    mainPage230901.selectListaOrigen2.sendKeys("AGUASCALIENTES, AGS.");
//                    mainPage230901.inputAgregarLista2.click();
//                    mainPage230901.btnAgregarMercancia.click();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230901.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mercanciaComun.run();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230901.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230901.labelTerceros.click();
//                    mainPage230901.inputEntidadFederativa.sendKeys("ANTILLAS NEERLANDESAS (TERRITORIO HOLANDES DE ULTRAMAR)");
//                }
//                //PAGO DERECHOS
//                try {
//                    Thread.sleep(2000); // Pausa de 3 segundos
//                    // Hacer scroll hasta el elemento
//                    mainPage230901.Scrol.scrollIntoView(true);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                mainPage230901.labelPagoDerechos.click();
//                mainPage230901.selectBanco.sendKeys("BANAMEX");
//                //mainPage230901.inputLlavePago.sendKeys("123ASD123");
//                String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//                StringBuilder factura = new StringBuilder();
//                Random random = new Random();
//
//                for (int i = 0; i < 10; i++) {
//                    factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
//                }
//                mainPage230901.inputLlavePago.setValue(factura.toString());
//                Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230901.inputFechaPago);sleep(100);
//
//
//            }
//
//            mainPage230901.inputGuardarSolicitud.click();
//            mainPage230901.inputContinuar.click();
//            mainPage230901.inputAdjuntarDocumentos.click();
//            mainPage230901.inputDocumento.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage230901.inputDocumento2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage230901.inputDocumento3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage230901.inputDocumento4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//            mainPage230901.inputAdjuntar.click();sleep(1000);
//            mainPage230901.inputCerrar.click();sleep(200);
//            mainPage230901.btnContinuar.click();sleep(1000);
//
//            //FIRMAR SOLICITUD
//            loginFirmSoli.firma(tramite230901);
//
//            // Obtener el texto del folio desde mainPage230901
//            String folioText = mainPage230901.folio.getText();sleep(5000);
//            // Llamar al mtodo para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//
//        }, repeticiones);
//    }
//
//    //Metodo que ejecuta n veces una clase que implementa Runnable
//    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.println("Ejecución del Proceso: " + (i + 1));
//            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//            proceso.run();  // Ejecuta el proceso de la clase
//        }
//    }
//}
