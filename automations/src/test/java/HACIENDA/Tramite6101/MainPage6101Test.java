package HACIENDA.Tramite6101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite6101.MainPage6101;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage6101Test {
    MainPage6101 mainPage6101 = new MainPage6101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite6101 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso6101() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de (hoy) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            // Ingreso selección de rol
            loginFirmSoli.login(tramite6101);
            mainPage6101.selecRol.sendKeys("Persona Fisica");
            mainPage6101.btnacep.click();
            //Búsqueda del trámite
            mainPage6101.Tramites.click();
            mainPage6101.SoliNew.click();
            mainPage6101.hacienda.click();
            mainPage6101.JuntasTecnicasArancelarias.click();
            mainPage6101.SolJuntasTecnicasConsultivas.click();

            //Paso 1 CAPTURAR SOLICITUD
            //Pestaña certificaciones
            mainPage6101.Scrol.scrollTo();
            mainPage6101.tabSolicitud.click();
            //Datos de la solicitud
            mainPage6101.selectAduana.selectOption("010 - ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage6101.selectJuntaDerivada.selectOption("RGCE 3.7.5 FRACCION I");
            //Datos de la mercancia
            mainPage6101.NombreComercialMercancia.sendKeys("Pruebas QA Certificación");
            mainPage6101.DescripcionMercancia.sendKeys("Descripción QA");
            //Fracciones considerables propuestas
            mainPage6101.FraccionI.sendKeys("61032301");
            mainPage6101.FraccionII.sendKeys("61032301");
            mainPage6101.FraccionIII.sendKeys("61032301");
            //Manifiesto
            mainPage6101.checkManifiestoProtesta.click();

            //Continuar Paso 1
            mainPage6101.btnContinuarPaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage6101.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage6101.btnAdjuntar2.click();
            mainPage6101.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(90)); sleep(1000);
            mainPage6101.btnCerrar3.click();
            mainPage6101.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite6101);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage6101.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);

    }
    //Proceso Dictamen
//    public void ProcesoDictamen6101(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun6101();
//        //Busqueda de Folio
//        mainPage6101.Inicio.click();
//        mainPage6101.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
//        mainPage6101.inputBuscarTareasFuncionario.click();
//        mainPage6101.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPage6101.GenerarDic.click();
//        mainPage6101.SentidoDictamen.click();
//        mainPage6101.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        sleep(2000);
//        mainPage6101.inputMostrarFirma.click();
//        //Firma Funcionario
////        firmaFun.firmarFun6101();
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
//    public void ProcesoAutorizacion6101(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun6101();
//        // Búsqueda de Folio
//        mainPage6101.InicioA.click();
//        mainPage6101.FolioA.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//        mainPage6101.inputBuscarTareasFuncionarioA.click();
//        mainPage6101.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPage6101.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFun6101();
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
//    public void ProcesoConfirmarNotificaciónResolucion6101(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
//        loginFirmSoli.loginSolicitante6101();
//        mainPage6101.selecRol2.sendKeys("Persona Moral");
//        mainPage6101.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage6101.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPage6101.inputNumFolio.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//            mainPage6101.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage6101.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage6101.inputAcuse.click();
//        //Firma Funcionario
////        firmaSoli.firmarsolicitante6101();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPage6101.notification.getText());
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

}

