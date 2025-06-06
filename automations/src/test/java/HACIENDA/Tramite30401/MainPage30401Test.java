package HACIENDA.Tramite30401;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite30401.MainPage30401;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage30401Test {
    MainPage30401 mainPage30401 = new MainPage30401();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite30401 = new TramitesFirmasLG(
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
    public void Proceso30401() {
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

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);


/*
            //Variable Llave de pago (Longitud)
            String llavePago =  metodos.generarLlavePago(16);
*/
            // Ingreso selección de rol
            loginFirmSoli.login(tramite30401);
            mainPage30401.selecRol.sendKeys("Persona Fisica");
            mainPage30401.btnacep.click();
            //Búsqueda del trámite
            mainPage30401.Tramites.click();
            mainPage30401.SoliNew.click();
            mainPage30401.hacienda.click();
            mainPage30401.RegistroComercioExt.click();
            mainPage30401.RegistroTransportistaTransito.click();
            mainPage30401.elementoTramite30401.click();

            //Paso 1 CAPTURAR SOLICITUD
            //Pestaña Empresas transportistas
            mainPage30401.Scrol.scrollTo();
            mainPage30401.tabEmpresasTransportistas.click();
            //Datos de la solicitud
            mainPage30401.selectTipoTransito.selectOption("Interno");
            //Aduanas
            mainPage30401.listaAduanasAutorizadas.selectOption("TIJUANA");
            mainPage30401.listaAduanasAutorizadas.selectOption("TECATE");
            mainPage30401.btnAgregarAduanaAutorizada.click();
            //Domicilio de la empresa para oír y recibir notificaciones
            mainPage30401.CalleEmpresa.sendKeys("Av QA Revolución");
            mainPage30401.NumExteriorEmpresa.sendKeys("10");
            mainPage30401.NumInteriorEmpresa.sendKeys("3");
            mainPage30401.selectEntindadFederativaEmpresa.selectOption("CIUDAD DE MÉXICO");
            mainPage30401.selectMunicipioEmpresa.selectOption("BENITO JUAREZ");
            mainPage30401.selectColoniaEmpresa.selectOption("ACTIPAN DEL VALLE");
            mainPage30401.LocalidadEmpresa.sendKeys("Localidad QA");
            mainPage30401.CodigoPostalEmpresa.sendKeys("06130");
            //Capital Social
            mainPage30401.CapitalPersonaMoral.sendKeys("3113241");
            //Permiso expedido por la Dirección General de Autotransporte Federal de la Secretaria de Comunicaciones y Transportes, para prestar el servicio de autotransporte federal de carga
            mainPage30401.NumPermiso.sendKeys("976567");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage30401.fechaPermiso, fechaHoy);
            mainPage30401.checkCapitalSocialMenos.click();
            mainPage30401.checkReponsableEmbarques.click();

            //Pestaña Vehículos
            mainPage30401.Scrol.scrollTo();
            mainPage30401.tabVehiculos.click();
            mainPage30401.btnAgregarVehiculo.click();
            mainPage30401.MarcaVehiculo.sendKeys("QA Marca");
            mainPage30401.ModeloVehiculo.sendKeys("QA Modelo");
            mainPage30401.NumIDVehicularSerie.sendKeys("56GQA2");
            mainPage30401.btnAgregarInfVehiculo.click();
            metodos.scrollIncremento(2);
            mainPage30401.btnAceptarVehiculoNft.click();

            //PAGO DERECHOS
            mainPage30401.Scrol.scrollTo().shouldBe(visible);
            mainPage30401.tabPagoDerechos.click();
            mainPage30401.ClaveReferencia.sendKeys("284000255");sleep(1000);
            mainPage30401.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage30401.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage30401.inpLLavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage30401.FechaPago, fechaHoy);
            mainPage30401.ImportePago.sendKeys("7000");
            mainPage30401.checkEsquemaElectronico.click();

            //Pestaña Consolidación de cargas
            mainPage30401.Scrol.scrollTo();
            mainPage30401.tabConsolidacionCargas.click();
            mainPage30401.checkSiPrestarServiciosCarga.click();
            //Registro de Agentes Aduanales
            mainPage30401.btnAgregarAgenteAduanal.click();
            mainPage30401.NombreAgente.sendKeys("Adriana QA");
            mainPage30401.PrimerApellidoAgente.sendKeys("Salazar QA");
            mainPage30401.SegundoApellidoAgente.sendKeys("Hernandez QA");
            mainPage30401.NumPatenteAgente.sendKeys("3849QA");
            mainPage30401.btnAgregarInfAgenteAduanal.click();
            mainPage30401.btnAceptarAgenteNft.click();

            //Relación de cajas y/o vehículos con los que se presentará el servicio de consolidación de carga
            mainPage30401.btnAgregarCOnsolidacion.click();
            //Registro de vehículos
            mainPage30401.MarcaVehiculo.sendKeys("Marca QA");
            mainPage30401.ModeloVehiculo.sendKeys("Modelo QA");
            mainPage30401.NumIDVehicularSerie.sendKeys("47QA98");
            mainPage30401.NumCajaVehiculo.sendKeys("10");
            //Domicilio para la verificación del vehículo
            mainPage30401.CalleVehiculo.sendKeys("Av Insurgentes QA");
            mainPage30401.NumExtVehiculo.sendKeys("21");
            mainPage30401.NumIntVehiculo.sendKeys("2");
            mainPage30401.selectEntidadFederativaVehiculo.selectOption("CIUDAD DE MÉXICO");
            mainPage30401.selectMunicipioVehiculo.selectOption("GUSTAVO A MADERO");
            mainPage30401.selectColoniaVehiculo.selectOption("15 DE AGOSTO");
            mainPage30401.LocalidadVehiculo.sendKeys("Localidad QA");
            mainPage30401.CodigoPostalVehiculo.sendKeys("07050");
            mainPage30401.selectAduanaVehiculo.selectOption("AEROPUERTO INTERNACIONAL FELIPE ÁNGELES");
            //Nombre de una persona de contacto en la circunscripción de la aduana
            mainPage30401.NombreContactoCircunscripcion.sendKeys("Alfonso QA");
            mainPage30401.PrimerApellidoContactoCircunscripcion.sendKeys("Ortiz QA");
            mainPage30401.SegundoApellidoContactoCircunscripcion.sendKeys("Palacios QA");
            mainPage30401.CorreoContactoCircunscripcion.sendKeys("testQA@gmail.com");
            mainPage30401.TelefonoContactoCircunscripcion.sendKeys("5562849385");
            //Agregar registro vehiculo
            mainPage30401.AgregarInfoConsolidacion.click();
            mainPage30401.btnAgregarInfVehiculoNft.click();

            //Manifiesto
            mainPage30401.radbtnSiProtestaConsolidacionCarga.click();
            //Continuar Paso 1
            mainPage30401.btnContinuarPaso1.click();

            //Paso 2 REQUISITOS NECESARIOS
            mainPage30401.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage30401.btnAdjuntar2.click();
            mainPage30401.MensajeCarga.shouldNotBe(visible, Duration.ofSeconds(90)); sleep(1000);
            mainPage30401.btnCerrar3.click();
            mainPage30401.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite30401);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage30401.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);

    }
    //Proceso Dictamen
//    public void ProcesoDictamen30401(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun30401();
//        //Busqueda de Folio
//        mainPage30401.Inicio.click();
//        mainPage30401.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
//        mainPage30401.inputBuscarTareasFuncionario.click();
//        mainPage30401.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPage30401.GenerarDic.click();
//        mainPage30401.SentidoDictamen.click();
//        mainPage30401.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        sleep(2000);
//        mainPage30401.inputMostrarFirma.click();
//        //Firma Funcionario
////        firmaFun.firmarFun30401();
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
//    public void ProcesoAutorizacion30401(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun30401();
//        // Búsqueda de Folio
//        mainPage30401.InicioA.click();
//        mainPage30401.FolioA.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//        mainPage30401.inputBuscarTareasFuncionarioA.click();
//        mainPage30401.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPage30401.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFun30401();
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
//    public void ProcesoConfirmarNotificaciónResolucion30401(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
//        loginFirmSoli.loginSolicitante30401();
//        mainPage30401.selecRol2.sendKeys("Persona Moral");
//        mainPage30401.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage30401.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPage30401.inputNumFolio.sendKeys(folioNumber);//se comento porque no tenemos acceso a la BD
//            mainPage30401.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage30401.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage30401.inputAcuse.click();
//        //Firma Funcionario
////        firmaSoli.firmarsolicitante30401();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPage30401.notification.getText());
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

