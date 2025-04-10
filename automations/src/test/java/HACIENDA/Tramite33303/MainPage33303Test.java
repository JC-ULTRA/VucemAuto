package HACIENDA.Tramite33303;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33303Test {
    MainPage33303 mainPage33303 = new MainPage33303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite33303  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


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
        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

// Validar que el usuario haya ingresado un folio válido de 25 dígitos
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }

// Confirmar el folio ingresado
        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

/////////////////////////////////////////////////////////////////////////////////////////////////////////-
// Crear checkboxes para los nuevos tipos de aviso
        JCheckBox avisoCambioSituacionFiscal = new JCheckBox("Aviso cuando cambie la situación, respecto del documento con el que se haya acreditado el legal uso y goce del inmueble o inmuebles en donde se lleven a cabo los procesos productivos o la prestación del servicio, según se trate, referente a la vigencia, las partes y el domicilio.");
        JCheckBox avisoFusionEscisiondeEmpresas = new JCheckBox("Aviso de fusión o escisión de empresas que cuenten con el Registro en el Esquema de Certificación de Empresas, cuando resulte una nueva sociedad, extinguiéndose una o más empresas con Registro en el Esquema de Certificación de Empresas vigente");
        JCheckBox solventarObservaciones = new JCheckBox("Aviso para solventar las observaciones respecto a los estándares mínimos de seguridad, que deriven de cualquier inspección de supervisión de cumplimiento.");
        JCheckBox avisoRelacionadoIncidentesSeguridad = new JCheckBox("Aviso relacionado a incidentes de seguridad. (creación de vista gráfica captura, consultas funcionario y solicitante, documentos , para los avisos de SCC y OEA)");
        JCheckBox realicenModificacion = new JCheckBox("Aviso cuando se realicen modificaciones a lo establecido en el E4 \"Perfil del Agente Aduanal\"; E5 \"Perfil de Auto Transportista Terrestre\"; E6 \"Perfil de Mensajería y Paquetería\"; E7 \"Perfil de Recinto Fiscalizado\"; E9 \"Perfil del Transportista Ferroviario\"; E10 \"Perfil de Parques Industriales\"; E11 Perfil de \"Almacén General de Depósito\" , contenidos en el Anexo 1, por cada instalación que corresponda.");
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

//        pagoDerechos.setEnabled(FolioRubro.startsWith("false"));


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

// Validar que al menos un aviso haya sido seleccionado
        if (avisosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
            return;
        }

// Confirmación y manejo de selecciones
        JOptionPane.showMessageDialog(null, "Procesos ejecutados para: " + String.join(", ", avisosSeleccionados));

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite33303);
            mainPage33303.selecRol.sendKeys("Persona Moral");
            mainPage33303.btnacep.click();
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
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso para solventar las observaciones respecto a los estándares mínimos de seguridad, que deriven de cualquier inspección de supervisión de cumplimiento.":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso relacionado a incidentes de seguridad. (creación de vista gráfica captura, consultas funcionario y solicitante, documentos , para los avisos de SCC y OEA)":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso cuando se realicen modificaciones a lo establecido en el E4 \"Perfil del Agente Aduanal\"; E5 \"Perfil de Auto Transportista Terrestre\"; E6 \"Perfil de Mensajería y Paquetería\"; E7 \"Perfil de Recinto Fiscalizado\"; E9 \"Perfil del Transportista Ferroviario\"; E10 \"Perfil de Parques Industriales\"; E11 Perfil de \"Almacén General de Depósito\" , contenidos en el Anexo 1, por cada instalación que corresponda.":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso de adición de Parques Industriales, cuando las instalaciones pertenezcan al misma RFC de la persona moral con Registro en el Esquema de Certificación de Empresas en la modalidad de Socio Comercial Certificado, rubro Parque Industrial.":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso adición o modificación de mandatarios, aduana de adscripción o adicionales y/o sociedades a las que pertenece, bajo la patente aduanal con la que se haya obtenido su registro en la modalidad de Socio Comercial Certificado.":
//                        ejecutarAvisoObservaciones();
                        break;
                    case "resentación de pago de derechos anual, 7.2.1 primer párrafo fracción 10, para el 2do. Año de la renovación":
//                        ejecutarAvisoObservaciones();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                        break;
                }
                scrollDecremento();
                mainPage33303.tipoAvisos.click();
            }

//            mainPage33303.btnGuardarSoli.click();
//            mainPage33303.btnContinuar.click();
////            verificarSeleccion(aduanalCheckBox, fusionEscisionCheckBox, articulo99CheckBox);
//
//            mainPage33303.btnSiguiente.click();
//            loginFirmSoli.firma(tramite33303);

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
    private void ejecutarAvisoUsoGoce() {
        scrollDecremento();
        mainPage33303.avisoUsoGoce.click();
        mainPage33303.usoGoce.click();
        mainPage33303.domicilio.sendKeys("CAMINO VIEJO 1353 MIGUEL HIDALGO");
        mainPage33303.codigoPostal.sendKeys("81210");
        mainPage33303.entidadFederativa.sendKeys("SINALOA");
        mainPage33303.municipio.sendKeys("AHOME");
        mainPage33303.documentoUsoGoce.sendKeys("Donación");
        mainPage33303.fechaInicioUsoGoce.click();
        mainPage33303.selecFecha.click();
        mainPage33303.fechaFin.click();
        mainPage33303.selecFechaFin.click();
        mainPage33303.rfcPartes.sendKeys("AAL0409235E6");
        mainPage33303.buscarRfcPartes.click();
        mainPage33303.caracterDePartes.sendKeys("jefe");
        mainPage33303.btnAgregar.click();
        clickAceptarButton();
        mainPage33303.observacionesPartes.sendKeys("QA");

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
//2500302601120259912000001