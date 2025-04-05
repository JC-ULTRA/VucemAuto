package Economia.Tramite80101;
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
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.sql.DriverManager.setLoginTimeout;


public class MainPage80101Test {

    MainPage80101 mainPage80101 = new MainPage80101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite80101 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    @BeforeAll
//    public static void setUpAll() {
//        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }


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
    }

    @Test
    public void Proceso80101() {
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox opinionCheckBox = new JCheckBox("ProcesoGenerarOpinion80101");
        JCheckBox registrarOpinionCheckBoxCheckBox = new JCheckBox("ProcesoRegistrarOpinoon80101");

        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen80101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion80101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion80101");

        Object[] params = {"Seleccione los métodos a ejecutar:", opinionCheckBox, registrarOpinionCheckBoxCheckBox, dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoGenerarOpinion80101");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoRegistrarOpinion80101");

        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen80101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion80101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion80101");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite80101);
            mainPage80101.selecRol.sendKeys("Persona Moral");
            mainPage80101.btnacep.click();
            mainPage80101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage80101.SoliNew.click();
            mainPage80101.economia.click();
            mainPage80101.immex.click();
            mainPage80101.AutoProgramNuevo.click();
//            getImplicitWaitTimeout(60000);
            mainPage80101.AutoNuevoIndustrial.click();
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage80101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage80101.Complementos.click();

            //proceso del tramite y //Programa Pre operativo y Datos generales
            mainPage80101.checkImmex.click();
            mainPage80101.paginaWeb.sendKeys("www.Vucem.com.mx");
            mainPage80101.localizacion.sendKeys("texto de prueba");

            //Obligaciones fiscales y Datos federatario(s) Constitución y modificaciones de la sociedad
            mainPage80101.OpinionSiSat.click();
//            mainPage80101.FechaExpedicionSat.sendKeys("24/05/2024");
            mainPage80101.ManifiestoImmex.click();
            mainPage80101.nombFedExpDoc.sendKeys("Nombre del que expide el Documento");
            mainPage80101.numNotaria.sendKeys("34");
            mainPage80101.estado.sendKeys("Mexico");
            mainPage80101.NumeroActa.sendKeys("54");
            mainPage80101.FechaEmisionActa.click();
            mainPage80101.feEmisionActa.click();
            mainPage80101.RFCRepresentLeg.sendKeys("MAVL621207C95");

            //Datos generales socios accionistas
            mainPage80101.NacionalidadExtranSiSocio.sendKeys("Estados Unidos");
            mainPage80101.PersonaMoralSiSocio.click();
            mainPage80101.taxIDSocio.sendKeys("34");
            mainPage80101.RazonSocialSocio.sendKeys("Nombre del Socio");
            mainPage80101.paisSocio.sendKeys("Mexico");
            mainPage80101.CPSocio.sendKeys("95824");
            mainPage80101.estadoSocio.sendKeys("Mexico");
            mainPage80101.CorreoSocio.sendKeys("VucemUser@Vucem.com");
            mainPage80101.btnAgregarSocio.click();

            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage80101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Anexo I
            mainPage80101.AnexoI.click();

            //Fracción Exportación
            mainPage80101.FraccionExportacion.sendKeys("34031101");
            mainPage80101.DescFraccionExpo2.sendKeys("PRUEBA QA FRACCIÓN");
            mainPage80101.inputAgregarFraccion.click();
            mainPage80101.inputSeleccionarFimportacion2.click();

            //Complementar Fracción
            mainPage80101.inputAgregarDatosFraccion.click();
            mainPage80101.selectCategoriaFraccion.sendKeys("Materia prima");
            mainPage80101.inputFraccionValorMoneda.sendKeys("10");
            mainPage80101.inputFraccionValorMoneda2.sendKeys("10");
            mainPage80101.inputFraccionValorProd.sendKeys("10");
            mainPage80101.inputFraccionValorProd2.sendKeys("10");
            mainPage80101.inputAgregarFraccion2.click();
            getImplicitWaitTimeout(3000);
            mainPage80101.buttonAceptar.click();
            mainPage80101.inputSeleccionarFimportacion3.click();

            //Agregar proveedor
            mainPage80101.inputAgregarProveedor.click();
            mainPage80101.selectPaisDestino.sendKeys("ANTARTIDAD");
            mainPage80101.inputCliente.sendKeys("MAVL621207C95");
            mainPage80101.divCamposObligatorios.sendKeys("PRUEBAS QA");
            mainPage80101.inputAgregaarProveedor.click();

            getImplicitWaitTimeout(10000);
            mainPage80101.buttonAceptar7.click();
            mainPage80101.inputCancelarProveedor.click();
            
            //Fracción Importación
            mainPage80101.inputFraccionImportacion.sendKeys("34031101");
            mainPage80101.textareaDescFraccionImpo.sendKeys("PRUEBA QA FRACCIÓN");
            mainPage80101.inputAgregarFraccion3.click();
            mainPage80101.SeleccionarFimportacion.click();

            //Complementar Fracción
            mainPage80101.inputAgregarDatosFraccion2.click();
            mainPage80101.selectCategoriaFraccion2.sendKeys("Materia prima");
            mainPage80101.inputFraccionValorMoneda3.sendKeys("10");
            mainPage80101.inputFraccionValorMoneda4.sendKeys("10");
            mainPage80101.inputFraccionValorProd3.sendKeys("10");
            mainPage80101.inputFraccionValorProd4.sendKeys("10");
            mainPage80101.inputAgregarFraccion4.click();
            mainPage80101.buttonAceptar2.click();

            mainPage80101.inputSeleccionarFimportacion.click();

            //Agregar proveedor
            mainPage80101.inputAgregarProveedorImp.click();
            mainPage80101.selectPaisOrigen.sendKeys("ANGUILA");
            mainPage80101.inputProveedor.sendKeys("MAVL621207C95");
            mainPage80101.inputRazonProveedor.sendKeys("PRUEBA QA PROVEEDOR");
            mainPage80101.inputAgregaarProveedor2.click();
            getImplicitWaitTimeout(5000);
            mainPage80101.buttonAceptar8.click();
            mainPage80101.inputCancelarProveedor2.click();

            //Datos del Federatario
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage80101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage80101.FederatariosPlantas.click();
            mainPage80101.inputNombreNotario.sendKeys("Prueba");
            mainPage80101.inputApellidoPaterno.sendKeys("QA");
            mainPage80101.inputApellidoMaterno.sendKeys("QA");
            mainPage80101.inputNumeroActa.sendKeys("2025");
            mainPage80101.inputFechaActaNotario.click();
            mainPage80101.fecha.click();

            mainPage80101.inputNumeroNotaria.sendKeys("123456789");
            mainPage80101.selectEntidadFederativa.sendKeys("SINALOA");
            mainPage80101.selectMunicipioDelegacion.sendKeys("AHOME");
            mainPage80101.inputAgregar.click();

            //Plantas Operaciones IMMEX
            mainPage80101.selectEntidadFederativaPlantasImmex.sendKeys("SINALOA");
            mainPage80101.inputBuscarPlantasImmex.click();
            mainPage80101.seleccionaPlanta.click();
            mainPage80101.inputSeleccionarPlantas.click();
            mainPage80101.seleccionaPlantas.click();
            mainPage80101.inputAgregarComplemento.click();
            mainPage80101.amparoPrograma.sendKeys("SI");
            mainPage80101.selectTipoDocumento.sendKeys("Contrato de arrendamiento");
            mainPage80101.inputFechaFirmaCompl.click();
            mainPage80101.fecha2.click();
            mainPage80101.inputFechaFinVigenciaCompl.click();
            mainPage80101.fecha3.click();
            mainPage80101.inputAgregarComplemento2.click();
            mainPage80101.buttonAceptar3.click();
            mainPage80101.inputFirmante.sendKeys("MAVL621207C95");
            mainPage80101.selectTipoFirmante.sendKeys("Firmante principal");
            mainPage80101.inputAgregarFirmante.click();
            sleep(10000);
            mainPage80101.inputRegresarComplemento.click();

            //Montos

            mainPage80101.inputAgregarMontos.click();
            mainPage80101.selectMontoTipo.sendKeys("Equipo");
            mainPage80101.inputMontoCantidad.sendKeys("12345");
            mainPage80101.textareaMontoDescripcion.sendKeys("PRUEBAS");
            mainPage80101.inputMontoMoneda.sendKeys("1234");
            mainPage80101.inputAgregarMonto.click();
            mainPage80101.buttonAceptar4.click();
            mainPage80101.inputCancelarMonto.click();

            //Empleados
            mainPage80101.inputAgregarEmpleados.click();
            mainPage80101.inputEmpleadosTotal.sendKeys("1");
            mainPage80101.inputRadioDirectos.click();
            mainPage80101.inputEmpleadosDirectos.sendKeys("1");
            mainPage80101.selectEmpleadosCedula.sendKeys("SI");
            mainPage80101.inputFechaCedulaImms.click();
            mainPage80101.fecha4.click();
            mainPage80101.inputAgregarEmpleado.click();
            mainPage80101.buttonAceptar5.click();
            mainPage80101.inputCancelarEmpleado.click();

            //Capacidad instalada
            mainPage80101.inputAgregarCapacidad.click();
            mainPage80101.selectCapacidadFraccion.sendKeys("34031101");
            mainPage80101.inputCapacidadTurnos.sendKeys("10");
            mainPage80101.inputCapacidadHoras.sendKeys("8");
            mainPage80101.inputCapacidadEmpleados.sendKeys("10");
            mainPage80101.inputCapacidadMaquinaria.sendKeys("10");
            mainPage80101.textareaCapacidadDescMaquinaria.sendKeys("PRUEBA");
            mainPage80101.inputCapacidadMensual.sendKeys("10");
            mainPage80101.inputCapacidadAnual.sendKeys("2");
            mainPage80101.inputCapacidadEfectiva.sendKeys("10");
            mainPage80101.inputAgregarCapacidad2.click();
            mainPage80101.buttonAceptar6.click();
            mainPage80101.inputCancelarCapacidad.click();
            mainPage80101.selectFederalesImmex.sendKeys("CULIACAN");
            mainPage80101.selectActividadProductiva.sendKeys("FABRICACION DE EQUIPO DE GENERACION ELECTRICA Y APARATOS Y ACCESORIOS ELECTRICOS");
            mainPage80101.continuar.click();

            mainPage80101.continuar2.click();

            mainPage80101.inputAdjuntarDocumentos.click();
            mainPage80101.inputDocumentosFile.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile1.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile2.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile3.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile4.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile5.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile6.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile7.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile8.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile9.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage80101.inputDocumentosFile10.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});

            mainPage80101.inputAnexar.click();
            sleep(90000);
            mainPage80101.inputCerrar.click();
            setLoginTimeout(10000);
            mainPage80101.inputSiguienteButton.click();
            loginFirmSoli.firma(tramite80101);


            // Obtener el texto del folio desde mainPage80101
            String folioText = mainPage80101.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoGenerarOpinion80101")) {
//                ProcesoGenerarOpinion80101(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoRegistrarOpinion80101")) {
//                ProcesoRegistrarOpinion80101(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoDictamen80101")) {
//                ProcesoDictamen80101(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion80101")) {
//                ProcesoAutorizacion80101(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion80101")) {
//                ProcesoConfirmarNotificaciónResolucion80101(folioNumber);
//            }

        }, repeticiones);

    }

//    //Proceso Generar opinion
//    public void ProcesoGenerarOpinion80101(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun80101();
//        //Busqueda de Folio
//        mainPage80101.Inicio.click();
//        mainPage80101.Folio.sendKeys(folioNumber);
//        mainPage80101.inputBuscarTareasFuncionario.click();
//        mainPage80101.tdEvaluarSolicitud.doubleClick();
//        //Solicitar Opinión
//        mainPage80101.solicitarOpinion.click();
//        mainPage80101.ContinuarOpinion.click();
//        sleep(5000);
//        mainPage80101.FechaVisitaOpinion.click();
//        mainPage80101.fechaOpinion.click();
//        mainPage80101.guardarFirmar.click();
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
//    //Registrar opinion
//    public void ProcesoRegistrarOpinion80101(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        //evitar timer de selenium en webdriver
//        // Ingreso y Selección de trámite
//        loginFun.loginFun80101();
//        // Búsqueda de Folio
//        mainPage80101.InicioA.click();
//        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//        mainPage80101.FolioA.sendKeys(folioNumber);
//        mainPage80101.inputBuscarTareasFuncionarioA.click();
//        mainPage80101.RegistrarOpinion.doubleClick();
//        //        sleep(110000);
//        // Registrar Opinión
//        mainPage80101.inputOpinionAceptada.click();
//        mainPage80101.textareaDescripcionOpinion.sendKeys("PRUEBAS QA");
//        mainPage80101.inputConsultarInformacion.click();
//        mainPage80101.inputArchivoAdjuntar.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
//        mainPage80101.inputCargaArchivo.click();
//        mainPage80101.inputEviar.click();
//        // Firma Funcionario
//        firmaFun.firmarFun80101();
//
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber3 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber3, FunRFC);
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
//    //Proceso Dictamen
//    public void ProcesoDictamen80101(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun80101();
//        //Busqueda de Folio
//        mainPage80101.InicioD.click();
//        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//        mainPage80101.FolioD.sendKeys(folioNumber);
//        mainPage80101.inputBuscarTareasFuncionarioD.click();
//        mainPage80101.tdEvaluarSolicitudD.doubleClick();
//        sleep(5000);
//
//        //Generar Dictamen
//        mainPage80101.inputMostrar.click();
//        mainPage80101.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        mainPage80101.inputMostrarFirma.click();
//        //Firma Funcionario
//        firmaFun.firmarFun80101();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber4 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber4, FunRFC);
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
//    public void ProcesoAutorizacion80101(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFun80101();
//        // Búsqueda de Folio
//        mainPage80101.InicioAu.click();
//        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//        mainPage80101.FolioAu.sendKeys(folioNumber);
//        mainPage80101.inputBuscarTareasFuncionarioAu.click();
//        mainPage80101.tdAutorizarDictamen.doubleClick();
//        sleep(5000);
//
//        // Generar Dictamen
//        mainPage80101.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFun80101();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber5 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber5, SoliRFC);
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
//    public void ProcesoConfirmarNotificaciónResolucion80101(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
////        loginFirmSoli.loginSolicitante80101();
//        mainPage80101.selecRol2.sendKeys("Persona Moral");
//        mainPage80101.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage80101.linkInicio.click();
//        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(5000);
//            mainPage80101.inputNumFolio.sendKeys(folioNumber);
//            mainPage80101.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage80101.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage80101.inputAcuse.click();
//        //Firma Funcionario
//        firmaSoli.firmarsolicitante80101();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPage80101.notification.getText());
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//    }

    private void getImplicitWaitTimeout(int i) {
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase

            Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
            open();
            getWebDriver().manage().window().maximize();
            //evitar timer de selenium en webdriver
            getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

        }
    }
}
