package HACIENDA.Tramite301;

import DBYFOLIO.ConDBReasigSolFun;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage301Test {
    MainPage301 mainPage301 = new MainPage301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite301  = new TramitesFirmasLG(
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
    public void Procesob301() {
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
        JCheckBox ProcesoRegistroRecepcionMuestras = new JCheckBox("ProcesoRegistroRecepcionMuestras");
        JCheckBox ProcesoREvaluarSolicitudGenDictamen = new JCheckBox("ProcesoREvaluarSolicitudGenDictamen");


        Object[] params = {"Seleccione los métodos a ejecutar:", ProcesoRegistroRecepcionMuestras, ProcesoREvaluarSolicitudGenDictamen};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

//         Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (ProcesoRegistroRecepcionMuestras.isSelected()) selectedMethods.add("ProcesoRegistroRecepcionMuestras");
        if (ProcesoREvaluarSolicitudGenDictamen.isSelected()) selectedMethods.add("ProcesoREvaluarSolicitudGenDictamen");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            //renovar metodo de pago para usarlo en el tramite
            desactivarPago();
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite301);
            mainPage301.selecRol.sendKeys("Persona Moral");
            mainPage301.btnacep.click();
            mainPage301.Tramites.sendKeys("Solicitudes nuevas");
            mainPage301.SoliNew.click();
            mainPage301.hacienda.click();
            mainPage301.linkAvisosAgaSat.click();
            mainPage301.t301.click();
            mainPage301.tipoAviso.click();
            mainPage301.btnIni.click();
            mainPage301.optionNo.sendKeys("No");
            mainPage301.fAranc.sendKeys("01012903");
            mainPage301.nico.sendKeys("00");
            mainPage301.name.sendKeys("Nombre Químico");
            mainPage301.nameComer.sendKeys("Nombre Laboratorio");
            mainPage301.CAS.sendKeys("12");
            mainPage301.estadoF.sendKeys("Gaseoso");
            mainPage301.estado.sendKeys("Buen Estado");
            // Ejecuta un JavaScript para hacer scroll hacia el inicio de la página
            executeJavaScript("window.scrollTo(0, 0);");
            mainPage301.pagoDer.click();
            mainPage301.lineaPago.sendKeys("032000Q0GHM128445291");
            mainPage301.btnAgregar.click();
            mainPage301.btnConti.click();
            mainPage301.checkDoc.click();
            mainPage301.elimiDoc.click();
            mainPage301.btnConti2.click();
            mainPage301.btnAdjuntar.click();
            mainPage301.doc1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage301.doc2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage301.doc3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage301.btnUpDocs.click();
            sleep(10000);
            mainPage301.btnCerrar.shouldBe(visible).click();
            mainPage301.btnConti3.click();
            loginFirmSoli.firma(tramite301);

            // Obtener el texto del folio desde mainPage301
            String folioText = mainPage301.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoRegistroRecepcionMuestras")) {
//                ProcesoRegistroRecepcionMuestras(folioNumber);
//            }
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoREvaluarSolicitudGenDictamen")) {
//                ProcesoREvaluarSolicitudGenDictamen(folioNumber);
//            }
       

        }, repeticiones);

    }
    
    //Proceso ProcesoRegistroRecepcionMuestras
//    public void ProcesoRegistroRecepcionMuestras(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun301();
//        // Búsqueda de Folio
//        mainPage301.InicioA.click();
//        mainPage301.FolioA.sendKeys(folioNumber);
//        mainPage301.inputBuscarTareasFuncionarioA.click();
//        mainPage301.tdRecepcionMuestras.doubleClick();
//        mainPage301.estRecep.sendKeys("Recibida");
//        mainPage301.btnSig.click();
//        firmaFun.firmarFun301();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber1 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber1, FunRFC);
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
//    //Proceso ProcesoREvaluarSolicitudGenDictamen
//    public void ProcesoREvaluarSolicitudGenDictamen(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun301();
//        // Búsqueda de Folio
//        mainPage301.InicioB.click();
//        mainPage301.FolioB.sendKeys(folioNumber);
//        mainPage301.inputBuscarTareasFuncionarioB.click();
//        mainPage301.tamite.doubleClick();
//        mainPage301.genDict.click();
//        mainPage301.btnConti4.click();
//        mainPage301.checkAcep.click();
//        mainPage301.justDict.sendKeys("Esta es la justificación de la prueba");
//        mainPage301.aniosPlazo.sendKeys("2");
//        mainPage301.btnConti5.click();
//        mainPage301.oficioTex.sendKeys("Esta es un texto prueba");
//        mainPage301.asuntoTex.sendKeys("Esta es un texto prueba");
//        mainPage301.tex1.sendKeys("Esta es un texto prueba");
//        mainPage301.tex2.sendKeys("Esta es un texto prueba");
//        mainPage301.tex3.sendKeys("Esta es un texto prueba");
//        mainPage301.tex4.sendKeys("Esta es un texto prueba");
//        mainPage301.tex5.sendKeys("Esta es un texto prueba");
//
//        mainPage301.tex6.sendKeys("Esta es un texto prueba");
//        mainPage301.tex7.sendKeys("Esta es un texto prueba");
//        mainPage301.tex8.sendKeys("Esta es un texto prueba");
//        mainPage301.tex9.sendKeys("Esta es un texto prueba");
//        mainPage301.tex10.sendKeys("Esta es un texto prueba");
//        mainPage301.textAtentamente.sendKeys("El Funcionario");
//
//        // Ejecuta un JavaScript para hacer scroll hacia el inicio de la página
//        executeJavaScript("window.scrollTo(0, 0);");
//
//        mainPage301.btnGuarFirm.click();
//
//        firmaFun.firmarFun301();
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
//
//    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void desactivarPago() {
        String url = "jdbc:oracle:thin:@//172.31.240.63:1521/vucprod1";
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

}

