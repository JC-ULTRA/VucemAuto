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

        // Mostrar diálogo con los checkboxes
        int avisoOption = JOptionPane.showConfirmDialog(
                null,
                avisoPanel, "Seleccione los tipos de aviso a ejecutar:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
        );

        if (avisoOption != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Cancelar si el usuario no acepta
        }

        // Recoger las selecciones realizadas por el usuario
        List<String> avisosSeleccionados = new ArrayList<>();
        for (JCheckBox checkbox : opcionesAvisoCheckbox) {
            if (checkbox.isSelected()) {
                avisosSeleccionados.add(checkbox.getText());
            }
        }

        // Validar que al menos un aviso haya sido seleccionado
        if (avisosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
            return;
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
            for (String aviso : avisosSeleccionados) {
                switch (aviso) {
                    case "Aviso Clientes y Proveedores Extranjeros":
                        ejecutarAvisoExtranjeros();
                        break;
                    case "Aviso Proveedores Nacionales":
                        ejecutarAvisoNacionales();
                        break;
                    case "Aviso Modificacion Socios":
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
                scrollDecremento();sleep(1000);
                mainPage32301.tipoAviso.click();
            }
            mainPage32301.casillaAcepto.click();
            mainPage32301.btnGuardarSoli.click();
            mainPage32301.btnContinuar.click();

            verificarSeleccionArchivos(avisosSeleccionados);
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
                "clickEnPosicion(755.9000015258789, 349.79374504089355);");
        sleep(1000);
        mainPage32301.selecTodos.click();
//        mainPage32301.nuevoNom.click();
        mainPage32301.btnRatificar.click();sleep(1000);
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
                "clickEnPosicion(755.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoUsoyGoce() {
        mainPage32301.avisoInmuebles.click();
        /// Inmuebles
        scrollDecremento();
        mainPage32301.inmuebles.click();
        mainPage32301.domicilioInmueble.sendKeys("CAMINO VIEJO, MIGUEL HIDALGO, 1353");
        mainPage32301.codigoPostalInmueble.sendKeys("81210");
        mainPage32301.entidadInmueble.sendKeys("SINALOA");
        mainPage32301.municipioInmueble.sendKeys("CULIACAN");
        mainPage32301.documentoUsoGoce.sendKeys("DONACION");
        mainPage32301.fechaInicioInmueble.click();
        mainPage32301.selecFecha.click();
        mainPage32301.fechaFinInmueble.click();
        mainPage32301.selecFechaFin.click();
        mainPage32301.rfcPartes.sendKeys("AAL0409235E6");   ///Solosirve en la primera automatizacion del tramite
        mainPage32301.btnBuscarPersonaM.click();sleep(1000); ///Solosirve en la primera automatizacion del tramite
        mainPage32301.caracterDe.sendKeys("PERSONA MORAL"); ///Solosirve en la primera automatizacion del tramite
        mainPage32301.agregarPersonaM.click();                          ///Solosirve en la primera automatizacion del tramite
        mainPage32301.btnAceptarPersonaM.click();                       ///Solosirve en la primera automatizacion del tramite
        mainPage32301.observacionesInmueble.sendKeys("PRUEBA");
        mainPage32301.mismoDomicilioSi.click();
        mainPage32301.documentoUsoGoce2.sendKeys("Donación");
        mainPage32301.modificacionVigenciasNo.click();
        mainPage32301.modificacionPartesSi.click();
        mainPage32301.rfcPartesM.sendKeys("AAL0409235E6");
        mainPage32301.btnBuscarPartesM.click();
        mainPage32301.caracterDePartesM.sendKeys("PERSONA MORAL");
        mainPage32301.btnAgregarParteM.click();
        mainPage32301.clickAceptar.click();
        mainPage32301.observaciones2.sendKeys("PRUEBA");
    }
    private void ejecutarAvisoFusionEscision() {
        mainPage32301.avisoFusionEscision.click();
        /// Fusion Escesion
        scrollDecremento();scrollDecremento();
        mainPage32301.fusionEscesion.click();
        mainPage32301.aviso1.click();
        mainPage32301.escesion.click();
        mainPage32301.certificacionNo.click();
        mainPage32301.rfcEmpresa.sendKeys("GARR880923F55");
        mainPage32301.razonSocial.sendKeys("PRUEBA");
        mainPage32301.fechaFusEsc.click();
        mainPage32301.selecFechaFusEsc.click();
        mainPage32301.folioFusEsc.sendKeys("QA");
        mainPage32301.btnAgregarPersonaFusEsc.click();
        mainPage32301.certificacionSi.click();
        mainPage32301.rfcPersona.sendKeys("AAL0409235E6");
        mainPage32301.btnBuscarPersona.click();
        mainPage32301.btnAceptarPersona.click();sleep(1000);
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
                "clickEnPosicion(755.9000015258789, 349.79374504089355);");
        sleep(1000);
    }
    private void ejecutarAvisoFracciones() {
        mainPage32301.avisoFracciones.click();
        /// Fracciones
        mainPage32301.fracciones.click();
        mainPage32301.cargaManual.click();
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("00111111");
        mainPage32301.actividadRelacionada.sendKeys("AMBOS");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBAS");
        mainPage32301.fraccionActual.sendKeys("30012004");
        mainPage32301.unidadMedida.sendKeys("LITRO");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();sleep(1000);
        mainPage32301.btnAgregarFrraccion.click();
        mainPage32301.fraccionDeclarada.sendKeys("32974389");
        mainPage32301.actividadRelacionada.sendKeys("PROCESO");
        mainPage32301.descripcionMercancia.sendKeys("PRUEBA 3");
        mainPage32301.fraccionActual.sendKeys("01069099");
        mainPage32301.unidadMedida.sendKeys("LITRO");
        mainPage32301.nico.sendKeys("00");
        mainPage32301.btnAgregarTodosPaises.click();sleep(1000);
        mainPage32301.btnGuardarCargaManual.click();
        mainPage32301.manifiestoFracciones.click();
        /// Procesos
        scrollDecremento();
        mainPage32301.procesos.click();
        mainPage32301.archivoProcesos.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Procesos todas aduanas paises corregido paises.xls");
        mainPage32301.cargarArchivo.click();sleep(3000);
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
                "clickEnPosicion(755.9000015258789, 349.79374504089355);");
        sleep(1000);
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
