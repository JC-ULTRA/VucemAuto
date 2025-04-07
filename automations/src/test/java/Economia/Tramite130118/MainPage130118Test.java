package Economia.Tramite130118;
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
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPage130118Test {
    MainPage130118 mainPage130118 = new MainPage130118();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite130118  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso130118() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen130118");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion130118");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion130118");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen130118");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion130118");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion130118");



        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite130118);
            mainPage130118.selecRol.sendKeys("Persona Moral");
            mainPage130118.btnacep.click();
            mainPage130118.Tramites.sendKeys("Solicitudes nuevas");
            mainPage130118.SoliNew.click();
            mainPage130118.Econom.click();
            mainPage130118.linkPermisosImportaciExportaci.click();
            mainPage130118.linkImportaci.click();
            mainPage130118.linkAvisoAutomTicoImportaci.click();

            mainPage130118.labelDatosSolicitud.click();
            //Datos del trámite a realizar
            mainPage130118.selectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage130118.selectSolicitudClaveClasificacionRegimen.sendKeys("De importacíon");
            sleep(100);
            //Descripción de la mercancía * :
            mainPage130118.textareaValue.setValue("Prueba QA");
            //Descripción de la mercancía * :
            mainPage130118.selectFraccionArancelaria.sendKeys("72071101 - De seccion transversal cuadrada o rectangular, cuya anchura sea inferior al doble del espesor.");
            mainPage130118.selectSubdivision.sendKeys("00 - De sección transversal cuadrada o rectangular, cuya anchura sea inferior al doble del espesor.");
            mainPage130118.selectUnidadTarifariaCombo.sendKeys("kilogramo");
            mainPage130118.inputSolicitudMercanciaCantidadTarifaria.setValue("12");
            //Valor factura USD
            mainPage130118.inputSolicitudMercanciaValorFactura.setValue("23453");
            //País origen del acero/País origen de la mercancía * :
            mainPage130118.selectSolicitudMercanciaPaisOrigen.sendKeys("ARMENIA (REPUBLICA DEMOCRATICA Y POPULAR DE)");
            //País exportador * :
            mainPage130118.selectSolicitudMercanciaPaisDestino.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
            //Número de certificado de molino o de calidad *
            mainPage130118.inputSolicitudMercanciaLote.setValue("12212121");
            //Fecha de expedición de certificado de molino o de calidad
            mainPage130118.inputFecSalida.shouldBe(visible).click();
            $(byText("2")).shouldBe(visible).click();
            sleep(200);
            mainPage130118.textareaValueObs.setValue("Prueba QA");
            //Datos del productor
            //Nombre del molino
            mainPage130118.selectMolinoSeleccion.sendKeys("SE00006 - ARCELORMITTAL BREMEN STEEL PLANT (ARCELORMITTAL BREMEN GMBH)");
            //Domicilio
            mainPage130118.textareaSolicitudProductorDomicilioDescripcion.setValue("andadero28");
            //Representación federal
            //ESTADO
            mainPage130118.selectSolicitudEntidadFederativaClave.sendKeys("SINALOA");
            mainPage130118.selectRepresentacionFederal.sendKeys("CULIACAN");
            mainPage130118.inputGuardarSolicitud.click();
            mainPage130118.inputContinuar.click();
            mainPage130118.inputAdjuntarDocumentos.click();
            mainPage130118.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage130118.inputAnexar.click();sleep(3000);
            mainPage130118.inputCerrar.click();sleep(2000);
            mainPage130118.inputSiguienteButton.click(); sleep(1000);
            sleep(1);
            //firmas
            loginFirmSoli.firma(tramite130118);

            // Obtener el texto del folio desde mainPage130118
            String folioText = mainPage130118.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

//           ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

////             Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen130118")) {
//                ProcesoDictamen130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion130118")) {
//                ProcesoAutorizacion130118(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion130118")) {
//                ProcesoConfirmarNotificaciónResolucion130118(folioNumber);
//            }

        }, repeticiones);

    }
    //Proceso Dictamen
//    public void ProcesoDictamen130118(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun130118();
//        //Busqueda de Folio
//        mainPage130118.Inicio.click();
//        mainPage130118.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
//        mainPage130118.inputBuscarTareasFuncionario.click();
//        mainPage130118.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPage130118.GenerarDic.click();
//        mainPage130118.SentidoDictamen.click();
//        mainPage130118.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        sleep(2000);
//        mainPage130118.inputMostrarFirma.click();
//        //Firma Funcionario
//        firmaFun.firmarFun130118();
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
//
//    //Proceso Autorización
//    public void ProcesoAutorizacion130118(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun130118();
//        // Búsqueda de Folio
//        mainPage130118.InicioA.click();
//        mainPage130118.FolioA.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//        mainPage130118.inputBuscarTareasFuncionarioA.click();
//        mainPage130118.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPage130118.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFun130118();
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
//    public void ProcesoConfirmarNotificaciónResolucion130118(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
////        loginFirmSoli.loginSolicitante130118();
//        mainPage130118.selecRol2.sendKeys("Persona Moral");
//        mainPage130118.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage130118.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPage130118.inputNumFolio.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//            mainPage130118.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage130118.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage130118.inputAcuse.click();
//        //Firma Funcionario
//        firmaSoli.firmarsolicitante130118();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPage130118.notification.getText());
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }



    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}


