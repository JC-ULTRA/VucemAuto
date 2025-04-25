package HACIENDA.Tramite32301;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32301.MainPage32301;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32301Test {
    MainPage32301 mainPage32301 = new MainPage32301();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32301  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;

        // Configuraciones de Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=1.25"); // Escala 150%
        Configuration.browserCapabilities = options;

        open();
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080)); // Resolución personalizada
        getWebDriver().manage().window().maximize(); // Maximizar la ventana
        Configuration.timeout = 120000; // Tiempo de espera
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
    public void Proceso32301() {
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
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }

        // Confirmar el folio ingresado
        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Crear checkboxes para métodos adicionales
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Crear checkboxes para los tipos de aviso
        JCheckBox[] opcionesAvisoCheckbox = {
                new JCheckBox("Aviso Clientes y Proveedores Extranjeros"), new JCheckBox("Aviso Proveedores Nacionales"), new JCheckBox("Aviso Modificacion Socios"),
                new JCheckBox("Aviso Por Modificación de Uso y Goce del Inmueble"), new JCheckBox("Aviso Fusion Escision"), new JCheckBox("Aviso de Adición de Fracciones")
        };

        // Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            avisoPanel.add(checkbox);
        }

        // Añadir un ItemListener para permitir solo una selección a la vez
        ItemListener listener = e -> {
            JCheckBox source = (JCheckBox) e.getSource();
            if (source.isSelected()) {
                for (JCheckBox checkbox : opcionesAvisoCheckbox) {
                    if (checkbox != source) {
                        checkbox.setSelected(false); // Desactivar los demás
                    }
                }
            }
        };

        // Añadir el listener a cada checkbox
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            checkbox.addItemListener(listener);
        }

        // Mostrar diálogo con los checkboxes
        int avisoOption = JOptionPane.showConfirmDialog(
                null,
                avisoPanel,
                "Seleccione un tipo de aviso a ejecutar:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (avisoOption != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Cancelar si el usuario no acepta
        }

        // Recoger la selección realizada por el usuario
        String avisoSeleccionado = null;
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            if (checkbox.isSelected()) {
                avisoSeleccionado = checkbox.getText();
                break;
            }
        }

        if (avisoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
        } else {
            JOptionPane.showMessageDialog(null, "Aviso seleccionado: " + avisoSeleccionado);
        }

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32301);
            mainPage32301.selecRol.sendKeys("Persona Moral");
            mainPage32301.btnacep.click();
            mainPage32301.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage32301.soliSubsecuente.click();
            mainPage32301.folioTramite.sendKeys(FolioRubro);
            mainPage32301.btnBuscarFolio.click();sleep(1000);
            mainPage32301.tablaFolios.doubleClick();
            mainPage32301.avisoModificacion.click();
            // Ejecutar los métodos seleccionados
            for (JCheckBox checkbox : opcionesAvisoCheckbox) {
                mainPage32301.tipoAviso.click();
                if (checkbox.isSelected()) {
                    String aviso = checkbox.getText(); // Obtiene el texto del checkbox seleccionado
                    switch (aviso) {
                        case "Aviso Clientes y Proveedores Extranjeros":
                            ejecutarAvisoExtranjeros();
                            break;
                        case "Aviso Proveedores Nacionales":
                            ejecutarAvisoNacionales();
                            break;
                        case "Aviso Modificación Socios":
                            ejecutarAvisoSocios();
                            break;
                        case "Aviso Por Modificación de Uso y Goce del Inmueble":
                            ejecutarAvisoUsoyGoce();
                            break;
                        case "Aviso Fusion Escision":
                            ejecutarAvisoFusionEscision();
                            break;
                        case "Aviso de Adición de Fracciones":
                            ejecutarAvisoFracciones();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                            break;
                    }
                }
            }
            scrollDecremento();
            mainPage32301.tipoAviso.click();
            mainPage32301.casillaAcepto.click();
            mainPage32301.btnGuardarSoli.click();
            mainPage32301.btnContinuar.click();

            // Verificar si uno de los dos checkboxes relevantes está seleccionado
            boolean avisoFusionSelected = opcionesAvisoCheckbox[4].isSelected(); // Aviso Fusion Escision
            boolean avisoUsoSelected = opcionesAvisoCheckbox[3].isSelected(); // Aviso Por Modificación de Uso y Goce del Inmueble

            // Realizar acción si alguno de los dos está seleccionado
            if (avisoFusionSelected || avisoUsoSelected) {
                ejecutarCodigoAdjuntar();
            }
            mainPage32301.btnSiguiente.click();
            loginFirmSoli.firma(tramite32301);

            // Obtener el texto del folio desde mainPage32301
            String folioText = mainPage32301.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    private void verificarSeleccionArchivos(List<String> avisosSeleccionados){
        boolean avisoFusionSelected = avisosSeleccionados.contains("Aviso Fusion Escision");
        boolean avisoUsoSelected = avisosSeleccionados.contains("Aviso Por Modificación de Uso y Goce del Inmueble");

        if (avisoFusionSelected && avisoUsoSelected){
            ejecutarCodigoAdjuntar2();
        } else if (avisoUsoSelected || avisoFusionSelected) {
            ejecutarCodigoAdjuntar();
        } else {
            System.out.println("No Hay Archivos Por Cargar");
        }
    }

    private void ejecutarCodigoAdjuntar() {
        mainPage32301.btnAdjuntar1Doc.click();
        mainPage32301.archivoUnico.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.btnAdjuntar.click();
        mainPage32301.btnCerrar.click();
    }

    private void ejecutarCodigoAdjuntar2() {
        mainPage32301.btnAdjuntarDoc.click();
        mainPage32301.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32301.btnAdjuntar.click();sleep(3000);
        mainPage32301.btnCerrar.click();
    }

    private void ejecutarAvisoExtranjeros() {
        mainPage32301.clientesExtranjeros.click();
        scrollDecremento();
        /// Provedores extranjeros
        mainPage32301.modificacionExtranjeros.click();
        mainPage32301.archivoExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjeros_aviso.xlsx");
        mainPage32301.btnCargarExtranjeros.click();sleep(1000);
        clickOkButton();
    }

    private void ejecutarAvisoNacionales() {
        mainPage32301.clientesNacionales.click();
        /// Provedores nacionales
        mainPage32301.modificacionNacionales.click();
        mainPage32301.archivoNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionales_A_aviso.xlsx");
        mainPage32301.btnCargarNacionales.click();sleep(1500);
        mainPage32301.btnOK.click();
    }

    private void ejecutarAvisoSocios() {
        mainPage32301.avisoSocios.click();
        /// Socios
        mainPage32301.modificacionSocios.click();
        mainPage32301.btnAgregarMiembro.click();
        mainPage32301.tipoSocio.sendKeys("SOCIO");
        mainPage32301.tributarMexicoNo.click();
        mainPage32301.nacionalidad.sendKeys("argelia");
        mainPage32301.tipoPersona.sendKeys("moral");
        mainPage32301.nombreEmpresa.sendKeys("PRUEBAS");
        mainPage32301.btnAgregarSocio.click();sleep(1000);
        clickAceptarButton();
        mainPage32301.btnAgregarMiembro.click();
        mainPage32301.tipoSocio.sendKeys("SOCIO");
        mainPage32301.tributarMexicoNo.click();
        mainPage32301.nacionalidad.sendKeys("argelia");
        mainPage32301.tipoPersona.sendKeys("moral");
        mainPage32301.nombreEmpresa.sendKeys("PRUEBAS2");
        mainPage32301.btnAgregarSocio.click();sleep(1000);
        mainPage32301.btnAceptar.click();
        mainPage32301.selecTodos.click();
        mainPage32301.btnRatificar.click();sleep(1000);
        mainPage32301.btnAceptarRatificar.click();
        sleep(1000);
    }

    private void ejecutarAvisoUsoyGoce() {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        mainPage32301.avisoInmuebles.click();
        /// Inmuebles
        scrollDecremento();
        mainPage32301.inmuebles.click();
        mainPage32301.domicilioNuevo.click();sleep(1000);
        mainPage32301.btnAceptarDomicilioNuevo.click();
        mainPage32301.btnAgregarDomicilioNuevo.click();sleep(1000);
        mainPage32301.domicilioInmueble.sendKeys("CAMINO VIEJO, MIGUEL HIDALGO, 1353");
        mainPage32301.codigoPostalInmueble.sendKeys("81210");
        mainPage32301.entidadInmueble.sendKeys("SINALOA");
        mainPage32301.municipioInmueble.sendKeys("CULIACAN");
        mainPage32301.documentoUsoGoce.sendKeys("DONACION");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32301.fechaInicioInmueble, fechaHoy);sleep(1000);
        mainPage32301.fechaFinInmueble.click();
        mainPage32301.selecFechaFin.click();
        mainPage32301.rfcPartes.sendKeys("AAL0409235E6");
        mainPage32301.btnBuscarPersonaM.click();sleep(1000);
        mainPage32301.caracterDe.sendKeys("PERSONA MORAL");
        mainPage32301.agregarPersonaM.click();
        mainPage32301.btnAceptarPersonaM.click();
        mainPage32301.observacionesInmueble.sendKeys("PRUEBA");
        mainPage32301.agregarNuevoDomicilio.click();sleep(1000);
        mainPage32301.btnAceptarNuevoDomicilio.click();
    }
    private void ejecutarAvisoFusionEscision() {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        mainPage32301.avisoFusionEscision.click();
        /// Fusion Escesion
        scrollDecremento();scrollDecremento();
        mainPage32301.fusionEscesion.click();
        mainPage32301.aviso1.click();
        mainPage32301.escesion.click();
        mainPage32301.certificacionNo.click();
        mainPage32301.rfcEmpresa.sendKeys("GARR880923F55");
        mainPage32301.razonSocial.sendKeys("PRUEBA");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32301.fechaFusEsc, fechaHoy);sleep(1000);
        mainPage32301.folioFusEsc.sendKeys("QA");
        mainPage32301.btnAgregarPersonaFusEsc.click();
        mainPage32301.certificacionSi.click();
        mainPage32301.rfcPersona.sendKeys("AAL0409235E6");
        mainPage32301.btnBuscarPersona.click();
        mainPage32301.btnAceptarPersona.click();sleep(1000);
        mainPage32301.clickAceptar.click();
    }
    private void ejecutarAvisoFracciones() {
        mainPage32301.avisoFracciones.click();
        /// Fracciones
        mainPage32301.fracciones.click();
        mainPage32301.cargaManual.click();
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("12345");
        mainPage32301.actividadRelacionada.sendKeys("PROCESO");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBAS");
        mainPage32301.fraccionActual.sendKeys("01023101");
        mainPage32301.unidadMedida.sendKeys("Voltios");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();sleep(1000);
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("54321");
        mainPage32301.actividadRelacionada.sendKeys("AMBOS");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBAS");
        mainPage32301.fraccionActual.sendKeys("01041001");
        mainPage32301.unidadMedida.sendKeys("Voltios");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();sleep(1000);
        mainPage32301.manifiestoFracciones.click();
        /// Procesos
        scrollDecremento();
        mainPage32301.procesos.click();
        mainPage32301.archivoProcesos.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Procesos todas aduanas paises corregido paises.xls");
        mainPage32301.cargarArchivo.click();sleep(3000);
        mainPage32301.aceptarCarga.click();
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

    public void clickAceptarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }

    public void clickAgregarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Agregar")).shouldBe(visible).shouldHave(text("Agregar")).doubleClick();
    }

    public void scrollIncremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 4; i++){
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
