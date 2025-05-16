package HACIENDA.Tramite33303;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33303Test {
    MainPage33303 mainPage33303 = new MainPage33303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

        TramitesFirmasLG tramite33303  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\spi090212e4a.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\SPI090212E4A.key"
    );

    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000; // tiempo de espera
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso33303() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
// Solicitar el folio al usuario
       // String FolioRubro2 = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

        //folio para primeros Avisos
//        String FolioRubro = "2500302601320259912000001";

        //para aviso de pago de derechos
//        String FolioRubro = "2500301800320259911000003";

//        //para hacer los de agente aduanal
//        String FolioRubro = "2500301800320259911000006";

        String FolioRubro = JOptionPane.showInputDialog(null, "Ingresa un folio de 25 dígitos:");

// Validar que el usuario haya ingresado un folio válido de 25 dígitos
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////-
// Crear checkboxes para los nuevos tipos de aviso
        JCheckBox avisoCambioSituacionFiscal = new JCheckBox("Aviso cuando cambie la situación, respecto del documento con el que se haya acreditado el legal uso y goce del inmueble o inmuebles en donde se lleven a cabo los procesos productivos o la prestación del servicio, según se trate, referente a la vigencia, las partes y el domicilio.");
        JCheckBox avisoFusionEscisiondeEmpresas = new JCheckBox("Aviso de fusión o escisión de empresas que cuenten con el Registro en el Esquema de Certificación de Empresas, cuando resulte una nueva sociedad, extinguiéndose una o más empresas con Registro en el Esquema de Certificación de Empresas vigente");
        JCheckBox solventarObservaciones = new JCheckBox("Aviso para solventar las observaciones respecto a los estándares mínimos de seguridad, que deriven de cualquier inspección de supervisión de cumplimiento.");
        JCheckBox avisoRelacionadoIncidentesSeguridad = new JCheckBox("Aviso relacionado a incidentes de seguridad. (creación de vista gráfica captura, consultas funcionario y solicitante, documentos , para los avisos de SCC y OEA)");
        JCheckBox realicenModificacion = new JCheckBox("Aviso cuando se realicen modificaciones a lo establecido en el E4 \"Perfil del Agente Aduanal\"; E5 \"Perfil de Auto Transportista Terrestre\"; E6 \"Perfil de Mensajería y Paquetería\"; E7 \"Perfil de Recinto Fiscalizado\"; E9 \"Perfil del Transportista Ferroviario....");
        JCheckBox parquesIndustriales = new JCheckBox("Aviso de adición de Parques Industriales, cuando las instalaciones pertenezcan al misma RFC de la persona moral con Registro en el Esquema de Certificación de Empresas en la modalidad de Socio Comercial Certificado, rubro Parque Industrial.");
        JCheckBox modificacionMandatarios = new JCheckBox("Aviso adición o modificación de mandatarios, aduana de adscripción o adicionales y/o sociedades a las que pertenece, bajo la patente aduanal con la que se haya obtenido su registro en la modalidad de Socio Comercial Certificado.");
        JCheckBox pagoDerechos = new JCheckBox("resentación de pago de derechos anual, 7.2.1 primer párrafo fracción 10, para el 2do. Año de la renovación");


// Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));

        avisoPanel.add(avisoCambioSituacionFiscal);
        avisoPanel.add(avisoFusionEscisiondeEmpresas);
        avisoPanel.add(solventarObservaciones);
        avisoPanel.add(avisoRelacionadoIncidentesSeguridad);
        avisoPanel.add(realicenModificacion);
        avisoPanel.add(parquesIndustriales);
        avisoPanel.add(modificacionMandatarios);
        avisoPanel.add(pagoDerechos);

/////////////////////////////////////////////////////////////////////////////////////////////////////////-
// Lógica para habilitar o deshabilitar checkboxes según el `FolioRubro`
// Activar/desactivar checkboxes basados en condiciones específicas
        avisoCambioSituacionFiscal.setEnabled(true);
        avisoFusionEscisiondeEmpresas.setEnabled(true);
        solventarObservaciones.setEnabled(true);
        avisoRelacionadoIncidentesSeguridad.setEnabled(true);
        realicenModificacion.setEnabled(true);
        parquesIndustriales.setEnabled(true);
        modificacionMandatarios.setEnabled(true);
        pagoDerechos.setEnabled(true);

// Mostrar diálogo con los checkboxes
        int avisoOption = JOptionPane.showConfirmDialog(
                null,
                avisoPanel,
                "Seleccione los tipos de aviso a ejecutar:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (avisoOption != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Cancelar si el usuario no acepta
        }

// Recoger las selecciones realizadas por el usuario
        List<String> avisosSeleccionados = new ArrayList<>();
        if (avisoCambioSituacionFiscal.isSelected()) avisosSeleccionados.add(avisoCambioSituacionFiscal.getText());
        if (avisoFusionEscisiondeEmpresas.isSelected()) avisosSeleccionados.add(avisoFusionEscisiondeEmpresas.getText());
        if (solventarObservaciones.isSelected()) avisosSeleccionados.add(solventarObservaciones.getText());
        if (avisoRelacionadoIncidentesSeguridad.isSelected()) avisosSeleccionados.add(avisoRelacionadoIncidentesSeguridad.getText());
        if (realicenModificacion.isSelected()) avisosSeleccionados.add(realicenModificacion.getText());
        if (parquesIndustriales.isSelected()) avisosSeleccionados.add(parquesIndustriales.getText());
        if (modificacionMandatarios.isSelected()) avisosSeleccionados.add(modificacionMandatarios.getText());
        if (pagoDerechos.isSelected()) avisosSeleccionados.add(pagoDerechos.getText());

// Validar que al menos un aviso haya sido seleccionado
        if (avisosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
            return;
        }

// Confirmación y manejo de selecciones
//        JOptionPane.showMessageDialog(null, "Procesos ejecutados para: " + String.join(", ", avisosSeleccionados));

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login2(tramite33303);
            mainPage33303.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage33303.soliSubsecuente.click();
            mainPage33303.folioTramite.sendKeys(FolioRubro);
            mainPage33303.btnBuscarFolio.click();sleep(1000);
            mainPage33303.tablaFolios.doubleClick();
            mainPage33303.btnModificar.click();
            mainPage33303.tipoAvisos.click();

            // Ejecutar procesos según selección
            for (String aviso : avisosSeleccionados) {
                switch (aviso) {
                    case "Aviso cuando cambie la situación, respecto del documento con el que se haya acreditado el legal uso y goce del inmueble o inmuebles en donde se lleven a cabo los procesos productivos o la prestación del servicio, según se trate, referente a la vigencia, las partes y el domicilio.":
                        ejecutarAvisoUsoGoce();
                        break;
                    case "Aviso de fusión o escisión de empresas que cuenten con el Registro en el Esquema de Certificación de Empresas, cuando resulte una nueva sociedad, extinguiéndose una o más empresas con Registro en el Esquema de Certificación de Empresas vigente":
                        ejecutarAvisoFusionEscision();
                        break;
                    case "Aviso para solventar las observaciones respecto a los estándares mínimos de seguridad, que deriven de cualquier inspección de supervisión de cumplimiento.":
                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso relacionado a incidentes de seguridad. (creación de vista gráfica captura, consultas funcionario y solicitante, documentos , para los avisos de SCC y OEA)":
                        ejecutarAvisoSeguridad();
                        break;
                    case "Aviso cuando se realicen modificaciones a lo establecido en el E4 \"Perfil del Agente Aduanal\"; E5 \"Perfil de Auto Transportista Terrestre\"; E6 \"Perfil de Mensajería y Paquetería\"; E7 \"Perfil de Recinto Fiscalizado\"; E9 \"Perfil del Transportista Ferroviario\";...":
                        ejecutarAvisoCuandoHayModificacion();
                        break;
                    case "Aviso de adición de Parques Industriales, cuando las instalaciones pertenezcan al misma RFC de la persona moral con Registro en el Esquema de Certificación de Empresas en la modalidad de Socio Comercial Certificado, rubro Parque Industrial.":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso adición o modificación de mandatarios, aduana de adscripción o adicionales y/o sociedades a las que pertenece, bajo la patente aduanal con la que se haya obtenido su registro en la modalidad de Socio Comercial Certificado.":
                        ejecutarAvisoAdiciónModificación();
                        break;
                    case "resentación de pago de derechos anual, 7.2.1 primer párrafo fracción 10, para el 2do. Año de la renovación":
                        ejecutarAvisoPagoDeDerecho();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                        break;
                }
                scrollDecremento();
                scrollDecremento();
                mainPage33303.tipoAvisos.click();
            }

            mainPage33303.manifiestoAcepto.click();
            mainPage33303.btnGuardarSoli.click();
            mainPage33303.btnContinuar.click();
////            verificarSeleccion(aduanalCheckBox, fusionEscisionCheckBox, articulo99CheckBox);
//
            mainPage33303.btnSiguiente.click();
//            loginFirmSoli.firma2(tramite33303);

            // Obtener el texto del folio desde mainPage33303
            String folioText = mainPage33303.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

//    private void verificarSeleccion(JCheckBox aduanalCheckBox, JCheckBox fusionEscisionCheckBox, JCheckBox articulo99CheckBox) {
//        boolean aduanalSelected = aduanalCheckBox.isSelected();
//        boolean fusionSelected = fusionEscisionCheckBox.isSelected();
//        boolean articulo99Selected = articulo99CheckBox.isSelected();
//
//        // Verifica si alguno está seleccionado
//        if (aduanalSelected && articulo99Selected) {
//            ejecutarCodigoAdjuntar2();
//        } else if (aduanalSelected || fusionSelected || articulo99Selected) {
//            ejecutarCodigoAdjuntar();
//        } else {
//            System.out.println("No Hay Archivos Por Cargar");
//        }
//    }
//
//    private void ejecutarCodigoAdjuntar() {
//        mainPage33303.btnAdjuntarDoc.click();
//        mainPage33303.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//        mainPage33303.btnAdjuntar.click(); sleep(1000);
//        mainPage33303.btnCerrar.click();
//    }
//
//    private void ejecutarCodigoAdjuntar2() {
//        mainPage33303.btnAdjuntar2Doc.click();
//        mainPage33303.segArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//        mainPage33303.segArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
//        mainPage33303.btnAdjuntar.click(); sleep(1000);
//        mainPage33303.btnCerrar.click();
//    }

    private void ejecutarAvisoUsoGoce() {
        mainPage33303.avisoUsoGoce.click();
        mainPage33303.usoGoce.click();
        mainPage33303.domicilio.sendKeys("CAMINO VIEJO 1353 MIGUEL HIDALGO");
        mainPage33303.codigoPostal.sendKeys("81210");
        mainPage33303.entidadFederativa.sendKeys("SINALOA");
        mainPage33303.municipio.sendKeys("AHOME");
        mainPage33303.documentoUsoGoce.sendKeys("Donación");
        Selenide.executeJavaScript("arguments[0].value = '10/04/2025';", mainPage33303.fechaInicioUsoGoce); sleep(1000);
        Selenide.executeJavaScript("arguments[0].value = '10/04/2025';", mainPage33303.fechaFin); sleep(1000);
        mainPage33303.rfcPartes.sendKeys("AAL0409235E6");
        mainPage33303.buscarRfcPartes.click();
        mainPage33303.caracterDePartes.sendKeys("jefe");
        mainPage33303.btnAgregar.click();
        clickAceptarButton();
        mainPage33303.observacionesPartes.sendKeys("QA");
        mainPage33303.mismoDomicilio.click();
        mainPage33303.domicilioNuevo.sendKeys("Calle1");
        mainPage33303.codigoPostalNuevo.sendKeys("95281");
        mainPage33303.estadoNuevo.sendKeys("DURANGO");
        mainPage33303.municipioNuevo.sendKeys("LERDO");
        mainPage33303.documentoNuevo.sendKeys("Donación");
        Selenide.executeJavaScript("arguments[0].value = '10/04/2025';", mainPage33303.fechaInicioNueva); sleep(1000);
        Selenide.executeJavaScript("arguments[0].value = '18/04/2025';", mainPage33303.fechaFinNuevo); sleep(1000);
        mainPage33303.rfcPartesNuevo.sendKeys("MAVL621207C95");sleep(1000);
        mainPage33303.buscarRfcPartesNuevo.click();sleep(1000);
        mainPage33303.caracterDePartesNuevas.sendKeys("empleado");sleep(1000);
        mainPage33303.btnAgregarNuevo.click();sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("function clickEnPosicion(x, y) {" +
                "const evento = new MouseEvent('click', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true," +
                "clientX: x," +
                "clientY: y" +
                "});" +
                "const elemento = document.elementFromPoint(x, y);" +
                "if (elemento) {" +
                "elemento.dispatchEvent(evento);" +
                "}" +
                "}" +
                "clickEnPosicion(948.90625, 350.5546875);");
        sleep(1000);
        scrollIncremento();sleep(1000);
        scrollIncremento();sleep(1000);

        mainPage33303.observacionesPartesNuevo.sendKeys("obs");sleep(1000);

    }
    private void ejecutarAvisoFusionEscision() {
        mainPage33303.avisoFusionEscision.click();
        mainPage33303.fusionEscision.click();
        mainPage33303.fusion1.click();
        mainPage33303.fusionEmpresa.click();
        mainPage33303.certificacionSi.click();
        mainPage33303.rfcFusion.sendKeys("AAL0409235E6");
        mainPage33303.busquedaRfcFusion.click();
        Selenide.executeJavaScript("arguments[0].value = '10/04/2025';", mainPage33303.fechaFusion); sleep(1000);
        mainPage33303.folioFusion.sendKeys("12345");
        mainPage33303.agregarEmpresaFusionada.click();
        mainPage33303.certificacionFusionSi.click();
        mainPage33303.rfcFusionada.sendKeys("AAL0409235E6");
        mainPage33303.buscarRfcFusionada.click();
        mainPage33303.btnAgregarFusionada.click();sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("function clickEnPosicion(x, y) {" +
                "const evento = new MouseEvent('click', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true," +
                "clientX: x," +
                "clientY: y" +
                "});" +
                "const elemento = document.elementFromPoint(x, y);" +
                "if (elemento) {" +
                "elemento.dispatchEvent(evento);" +
                "}" +
                "}" +
                "clickEnPosicion(948.90625, 350.5546875);");
        sleep(1000);
    }
    private void ejecutarAvisoObservaciones() {
        mainPage33303.avisoObservaciones.click();
        mainPage33303.observaciones.click();
        mainPage33303.agregarObservaciones.click();
        mainPage33303.entidadObservaciones.sendKeys("SINALOA");
        mainPage33303.selecDomicilioObservacion.click();
        mainPage33303.aceptarDomicilioObservacion.click();
        mainPage33303.selecDomicilioModificarOb.click();
        mainPage33303.modificarDomicilioOb.click();
        mainPage33303.tipoDomicilio.sendKeys("Planta productiva");
        mainPage33303.numActaVisita.sendKeys("1");
        Selenide.executeJavaScript("arguments[0].value = '10/04/2025';", mainPage33303.fechaVisita); sleep(1000);
        mainPage33303.subestandaresVisita.sendKeys("PRUEBAS");
        mainPage33303.btnAceptarObservaciones.click();sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("function clickEnPosicion(x, y) {" +
                "const evento = new MouseEvent('click', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true," +
                "clientX: x," +
                "clientY: y" +
                "});" +
                "const elemento = document.elementFromPoint(x, y);" +
                "if (elemento) {" +
                "elemento.dispatchEvent(evento);" +
                "}" +
                "}" +
                "clickEnPosicion(948.90625, 350.5546875);");
        sleep(1000);
    }
    private void ejecutarAvisoSeguridad() {
        mainPage33303.avisoSeguridad.click();
        mainPage33303.seguridad.click();
        mainPage33303.agregarDomiciliosIncidencias.click();
        mainPage33303.entidadFederativaIncidencias.sendKeys("SINALOA");
        mainPage33303.selecPlantaAgregar.click();
        mainPage33303.btnAgregarDomicilio.click();
        mainPage33303.selecPlantaModificarIncidencias.click();
        mainPage33303.modificarPlantaIncidencias.click();
        mainPage33303.tipoInstalacionIncidencias.sendKeys("Planta productiva");
        mainPage33303.cambiosSubestandares.sendKeys("PRUEBAS");
        mainPage33303.btnAceptarModificacionIncidencis.click();sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("function clickEnPosicion(x, y) {" +
                "const evento = new MouseEvent('click', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true," +
                "clientX: x," +
                "clientY: y" +
                "});" +
                "const elemento = document.elementFromPoint(x, y);" +
                "if (elemento) {" +
                "elemento.dispatchEvent(evento);" +
                "}" +
                "}" +
                "clickEnPosicion(948.90625, 350.5546875);");
        sleep(1000);
    }
    private void ejecutarAvisoCuandoHayModificacion() {
        mainPage33303.avisoModificación.click();
        mainPage33303.circunstancias.click();
        mainPage33303.agregarDomiciliosCircunstancias.click();
        mainPage33303.entidadFederativaCircunstancias.sendKeys("SINALOA");
        mainPage33303.selecPlantaAgregarCircunstancias.click();
        mainPage33303.btnAgregarPlantaCircunstancias.click();
        mainPage33303.selecPlantaModificar.click();
        mainPage33303.modificarPlantaCircunstancias.click();
        mainPage33303.tipoPlantaCircunstancias.sendKeys("Planta productiva");
        mainPage33303.folioAltaInstalacion.sendKeys("123");
        mainPage33303.fechaCircunstancias.click();
        mainPage33303.selecFechaCircunstancias.click();
        mainPage33303.cambioEstandaresCircunstancias.sendKeys("PRUEBAS");
        mainPage33303.btnAceptarModificacionCircunstancias.click();sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("function clickEnPosicion(x, y) {" +
                "const evento = new MouseEvent('click', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true," +
                "clientX: x," +
                "clientY: y" +
                "});" +
                "const elemento = document.elementFromPoint(x, y);" +
                "if (elemento) {" +
                "elemento.dispatchEvent(evento);" +
                "}" +
                "}" +
                "clickEnPosicion(948.90625, 350.5546875);");
        sleep(1000);
    }
    private void ejecutarAvisoAdiciónModificación() {
        mainPage33303.avisoAdicionModificacion.click();
        mainPage33303.AvisoAdiciónModificaciónMandatarios.click();
        mainPage33303.aduanaAdscrita.click();
        mainPage33303.aduanaSe.click();
        mainPage33303.btnAgregarAduana.click();
        mainPage33303.btnAgregarPatente.click();
        mainPage33303.rfcBusqueda.sendKeys("LEQI8101314S7");
        mainPage33303.btnBuscarRFC.click();
        mainPage33303.AduanaAds2.sendKeys("ACAPULCO, GUERRERO.");
        mainPage33303.tipoMov.sendKeys("Adición");
        mainPage33303.btnAceptarAduana.click();
        mainPage33303.btnok1.click();


        mainPage33303.btnAfrefarMandatarioAgenteAduanal.click();
        mainPage33303.rfcBusqueda2.sendKeys("LEQI8101314S7");
        mainPage33303.btnBuscarRFC2.click();
        mainPage33303.tipoMov2.sendKeys("Adición");
        mainPage33303.btnAceptarAduana2.click();
        mainPage33303.btnok2.click();




    }
    private void ejecutarAvisoPagoDeDerecho(){
        mainPage33303.avisoAltaPagoDeDerecho.click();
        scrollDecremento();
        mainPage33303.Noperacion.sendKeys("37263543");
        mainPage33303.bancoDerecho.sendKeys("BANCO AZTECA");
        mainPage33303.llaveDePagoDeDerecho.sendKeys(llavePago);
        Selenide.executeJavaScript("arguments[0].value = '11/04/2025';", mainPage33303.fechaDePago); sleep(1000);
    }

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }
    public void clickAceptarButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }
    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 1; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 3; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }

}
