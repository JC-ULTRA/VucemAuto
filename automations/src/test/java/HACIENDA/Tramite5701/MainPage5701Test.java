package HACIENDA.Tramite5701;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

//import static com.codeborne.selenide.Condition.visible;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage5701Test {
    MainPage5701 mainPage5701 = new MainPage5701();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite5701 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
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

//         Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen5701");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion5701");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion5701");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
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
//            desactivarPago();
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
            //Especifique los días que se utilizarán dentro del periodo*:
            mainPage5701.labelFechasDentroDelPeriodo.click();
            sleep(2000);
            String[] diasSeleccionados = {
//                    "Jueves,19/12/2024",
//                    "Viernes,20/12/2024",
//                    "Sábado,21/12/2024",
//                    "Domingo,22/12/2024",
                    "Lunes,20/01/2025"
            };
            for (String dia : diasSeleccionados) {
                $$(byText(dia)).filter(visible).first().click(); // Encuentra y selecciona el día visible
                mainPage5701.inputBotonAgregarFechas.click(); // Hace clic en "Agregar"
                sleep(1000); // Pausa breve entre interacciones
            }
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
            mainPage5701.buttonAceptar.click();
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
//            loginFirmSoli.firma(tramite5701);
//            // Obtener el texto del folio desde mainPageB8
//            String folioText = mainPage5701.folio.getText();
//            // Llamar al metodo para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen5701")) {
//                ProcesoDictamen5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion5701")) {
//                ProcesoAutorizacion5701(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion5701")) {
//                ProcesoConfirmarNotificaciónResolucion5701(folioNumber);
//            }

        }, repeticiones);

    }
    //Proceso Dictamen
//    public void ProcesoDictamen5701(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun5701();
//        //Busqueda de Folio
//        mainPage5701.Inicio.click();
//        mainPage5701.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
//        mainPage5701.inputBuscarTareasFuncionario.click();
//        mainPage5701.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPage5701.GenerarDic.click();
//        mainPage5701.SentidoDictamen.click();
//        mainPage5701.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        sleep(2000);
//        mainPage5701.inputMostrarFirma.click();
//        //Firma Funcionario
////        firmaFun.firmarFun5701();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(1000);
//            String folioNumber2 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber2, FunRFC);
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//    }

//    //Proceso Autorización
//    public void ProcesoAutorizacion5701(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun5701();
//        // Búsqueda de Folio
//        mainPage5701.InicioA.click();
//        mainPage5701.FolioA.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//        mainPage5701.inputBuscarTareasFuncionarioA.click();
//        mainPage5701.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPage5701.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFun5701();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber3 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber3, SoliRFC);
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//
//    }
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
//    public void desactivarPago() {
//        String url = "jdbc:oracle:thin:@//172.31.240.63:1521/vucprod1";
//        String user = "vucem_app_p01";
//        String password = "Mfk22nvW6na71DgBXi5R";
//
//        String query = "UPDATE vuc_pago_sea SET BLN_ACTIVO = 0 WHERE linea_de_captura = '032000Q0GHM128445291'";
//
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement(query)) {
//
//            // Ejecuta el query
//            int filasActualizadas = statement.executeUpdate();
//
//            // Comprueba si la actualización fue exitosa
//            if (filasActualizadas > 0) {
//                System.out.println("El registro ha sido actualizado correctamente.");
//            } else {
//                System.out.println("No se encontró el registro con la línea de captura proporcionada.");
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error al ejecutar el query: " + e.getMessage());
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

}

