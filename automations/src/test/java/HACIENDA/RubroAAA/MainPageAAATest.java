package HACIENDA.RubroAAA;

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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageAAATest {
    MainPageAAA mainPageAAA = new MainPageAAA();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramiteAAA  = new TramitesFirmasLG(
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
    public void ProcesoAAA() {
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
            loginFirmSoli.login(tramiteAAA);
            mainPageAAA.selecRol.sendKeys("Persona Moral");
            mainPageAAA.btnacep.click();
            mainPageAAA.Tramites.sendKeys("Solicitudes nuevas");
            mainPageAAA.SoliNew.click();
            mainPageAAA.hacienda.click();
            mainPageAAA.ComercioExterior.click();
            mainPageAAA.EsquenaIntegral.click();
            mainPageAAA.RubroAAA.click();

            //Pestaña de datos comunes
            mainPageAAA.DatosComunes.click();
            mainPageAAA.PreOperativoAaa.click();
            mainPageAAA.inputRegimen.click();
            mainPageAAA.inputRegimen2.click();
            mainPageAAA.inputRegimen3.click();
            mainPageAAA.inputRegimen4.click();
            mainPageAAA.selectSectorPro.sendKeys("Fabricación de artículos de oficina");
            mainPageAAA.SolicitudAcepto.click();
            mainPageAAA.SolicitudAcepto2.click();
            mainPageAAA.Propios.click();
            mainPageAAA.EmpPropios.sendKeys("11");
            mainPageAAA.selectEmpleadosPropiosBimestre.sendKeys("Noviembre-Diciembre");
            mainPageAAA.MapDeclaracionAcepto.click();
            mainPageAAA.AgregarSubcontratado.click();
            mainPageAAA.rfcSubcontratadoBusqueda.sendKeys("MAVL621207C95");
            mainPageAAA.inputBuscar.click();
            mainPageAAA.SubcontratadoEmpleados.sendKeys("11");
            mainPageAAA.selectSubcontratadoBimestre.sendKeys("Noviembre-Diciembre");
            mainPageAAA.AgregarModalEsquema.click();
            mainPageAAA.spanAceptar.click();
            mainPageAAA.MapDeclaracionSolicitudAcepto.click();
            mainPageAAA.MapDeclaracionSolicitudAcepto2.click();
            mainPageAAA.inputMapDeclaracionSolicitudAcepto.click();
            mainPageAAA.inputMapDeclaracionSolicitudAcepto2.click();
            mainPageAAA.inputMapDeclaracionSolicitudAcepto3.click();
            mainPageAAA.inputMapDeclaracionSolicitudAcepto4.click();
            mainPageAAA.selectImmex.sendKeys("142024 - Autorización Programa Nuevo Servicio");
            mainPageAAA.AgregarDomicilios.click();
            mainPageAAA.selectEntidadFederativaIdc.sendKeys("SINALOA");
            mainPageAAA.selectEntidadFederativaIdc.click();
            mainPageAAA.inputGridDomiciliosModal.click();
            mainPageAAA.inputDomiciliosModal2.click();
            mainPageAAA.inputGridDomicilios.click();
            mainPageAAA.inputModificarDomicilios.click();

            mainPageAAA.inputInstalacion.click();
            mainPageAAA.selectDomicilioTipoInstalacion.sendKeys("Planta Productiva");
            mainPageAAA.inputProcesoProd.click();
            mainPageAAA.inputAcredita.click();
            mainPageAAA.inputAceptarDomicilios.click();
            mainPageAAA.inputAceptarDomicilios2.click();
            mainPageAAA.MapDeclaracionSolicitudAcepto5.click();
            mainPageAAA.MapDeclaracionSolicitudAcepto6.click();

            //Carga Plantilla Proveedores Extranjero
            mainPageAAA.inputProvedoresExtranjeros.click();
            mainPageAAA.cargaDocExtranjeros.sendKeys("C:\\VucemAuto\\RepoN\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPageAAA.UploadNewFileExtranjeros.click();
            mainPageAAA.spanButtonText.click();
            //Carga Plantilla Proveedores Nacionales
            mainPageAAA.inputArchivoNacionalesIva.click();
            mainPageAAA.cargaDocNacionales.sendKeys("C:\\VucemAuto\\RepoN\\src\\test\\resources\\carga_proveedoresNacionesIVAIC.xls");
            mainPageAAA.UploadNewFileNacionales.click();
            mainPageAAA.spanButtonText2.click();

            // Aduana
//            mainPageB8.aduana.sendKeys("060 - CD. DEL CARMEN");
//            mainPageB8.seccionAduanera.sendKeys("061 - campeche, camp.");
//            mainPageB8.fechaSalida.pressEnter().sendKeys("31/10/2024");

            loginFirmSoli.firma(tramiteAAA);

            // Obtener el texto del folio desde mainPageB8
            //String folioText = mainPageAAA.folio.getText();

            // Llamar al mtodo para obtener el folio
            //String folioNumber = obtenerFolio.obtenerFolio(folioText);

            //ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamenB8")) {
//                //ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacionB8")) {
//               // ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucionB8")) {
//                //ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }

        }, repeticiones);

    }

    //Proceso Dictamen
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

}