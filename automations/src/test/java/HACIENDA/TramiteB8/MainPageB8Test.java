package HACIENDA.TramiteB8;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.*;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageB8Test {
    MainPageB8 mainPageB8 = new MainPageB8();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramiteB8 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
    public void Procesob8() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamenB8");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacionB8");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucionB8");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamenB8");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacionB8");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucionB8");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramiteB8);
            mainPageB8.selecRol.sendKeys("Persona Moral");
            mainPageB8.btnacep.click();
            mainPageB8.Tramites.sendKeys("Solicitudes nuevas");
            mainPageB8.SoliNew.click();
            mainPageB8.hacienda.click();
            mainPageB8.linkAvisosAgaSat.click();
            mainPageB8.B8.click();
            mainPageB8.tipoAviso.click();

            // Aduana
            mainPageB8.aduana.sendKeys("060 - CD. DEL CARMEN");
            mainPageB8.seccionAduanera.sendKeys("061 - campeche, camp.");
            mainPageB8.fechaSalida.pressEnter().sendKeys("31/10/2024");

            // Tipo de Transporte
            mainPageB8.tipTransp.sendKeys("Terrestre");
            mainPageB8.LAPC.sendKeys("Cualquier cosas");

            // Descripción de la mercancía
            mainPageB8.nombreMerc.sendKeys("Nombre de merc");
            mainPageB8.marca.sendKeys("Marca");
            mainPageB8.modelo.sendKeys("Modelo");
            mainPageB8.nSerie.sendKeys("1111111111111111111111111");
            mainPageB8.cantidadUMC.sendKeys("12");
            mainPageB8.selectUMC.sendKeys("Botella");
            mainPageB8.paisOrig.sendKeys("BELICE");
            mainPageB8.obs.sendKeys("Observ");
            mainPageB8.checkAcepto.click();
            mainPageB8.btnCont1.click();

            loginFirmSoli.firma(tramiteB8);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPageB8.folio.getText();

            // Llamar al mtodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamenB8")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacionB8")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucionB8")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }

        }, repeticiones);

    }

//    //Proceso Dictamen
//    public void ProcesoDictamenB8(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFunB8();
//        //Busqueda de Folio
//        mainPageB8.Inicio.click();
//        mainPageB8.Folio.sendKeys(folioNumber);
//        mainPageB8.inputBuscarTareasFuncionario.click();
//        mainPageB8.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPageB8.GenerarDic.click();
//        mainPageB8.SentidoDictamen.click();
//        mainPageB8.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        mainPageB8.inputMostrarFirma.click();
//
//        //Firma Funcionario
//        firmaFun.firmarFunB8();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
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
//    public void ProcesoAutorizacionB8(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFunB8();
//        // Búsqueda de Folio
//        mainPageB8.InicioA.click();
//        mainPageB8.FolioA.sendKeys(folioNumber);
//        mainPageB8.inputBuscarTareasFuncionarioA.click();
//        mainPageB8.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPageB8.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFunB8();
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
//    public void ProcesoConfirmarNotificaciónResolucionB8(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
////        loginFirmSoli.loginSolicitanteB8();
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

}

