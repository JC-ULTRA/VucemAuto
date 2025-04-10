package HACIENDA.Tramite33302;

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
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33302Test  {
    HACIENDA.Tramite33302.MainPage33302 mainPage33302 = new HACIENDA.Tramite33302.MainPage33302();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite33302  = new TramitesFirmasLG(
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
    public void Proceso33302() {
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
        JCheckBox usoYGoceCheckBox = new JCheckBox("Aviso Uso y Goce");
        JCheckBox fusionEscisionCheckBox = new JCheckBox("Aviso Fusión o Escisión");
        JCheckBox solventarObservacionesCheckBox = new JCheckBox("Aviso Para Solventar Observaciones");
        JCheckBox incidentesSeguridadCheckBox = new JCheckBox("Aviso Incidentes de Seguridad");
        JCheckBox circunstanciasCheckBox = new JCheckBox("Aviso de Circunstancias");
        JCheckBox adicionRevocacionCheckBox = new JCheckBox("Aviso de Adición o Revocación");
        JCheckBox registroSECIITCheckBox = new JCheckBox("Aviso Registro SECIIT");
        JCheckBox pagoDerechosCheckBox = new JCheckBox("Aviso Pago Derechos");
        JCheckBox altaBajaTercerosCheckBox = new JCheckBox("Avisos Alta o Baja Terceros");
        JCheckBox bajaCertificacionAltaTercerizacionCheckBox = new JCheckBox("Aviso Baja Tercero Certificación / Alta Tercero Tercerización");

// Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
        avisoPanel.add(usoYGoceCheckBox);
        avisoPanel.add(fusionEscisionCheckBox);
        avisoPanel.add(solventarObservacionesCheckBox);
        avisoPanel.add(incidentesSeguridadCheckBox);
        avisoPanel.add(circunstanciasCheckBox);
        avisoPanel.add(adicionRevocacionCheckBox);
        avisoPanel.add(registroSECIITCheckBox);
        avisoPanel.add(pagoDerechosCheckBox);
        avisoPanel.add(altaBajaTercerosCheckBox);
        avisoPanel.add(bajaCertificacionAltaTercerizacionCheckBox);

/////////////////////////////////////////////////////////////////////////////////////////////////////////-
// Lógica para habilitar o deshabilitar checkboxes según el `FolioRubro`

// Activar/desactivar checkboxes basados en condiciones específicas
        usoYGoceCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        fusionEscisionCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        solventarObservacionesCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        incidentesSeguridadCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        circunstanciasCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        adicionRevocacionCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
        registroSECIITCheckBox.setEnabled(FolioRubro.startsWith("25003026008"));
        pagoDerechosCheckBox.setEnabled(false);
        altaBajaTercerosCheckBox.setEnabled(FolioRubro.startsWith("25003026017"));
        bajaCertificacionAltaTercerizacionCheckBox.setEnabled(FolioRubro.startsWith("25003026017"));

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
        if (usoYGoceCheckBox.isSelected()) avisosSeleccionados.add(usoYGoceCheckBox.getText());
        if (fusionEscisionCheckBox.isSelected()) avisosSeleccionados.add(fusionEscisionCheckBox.getText());
        if (solventarObservacionesCheckBox.isSelected()) avisosSeleccionados.add(solventarObservacionesCheckBox.getText());
        if (incidentesSeguridadCheckBox.isSelected()) avisosSeleccionados.add(incidentesSeguridadCheckBox.getText());
        if (circunstanciasCheckBox.isSelected()) avisosSeleccionados.add(circunstanciasCheckBox.getText());
        if (adicionRevocacionCheckBox.isSelected()) avisosSeleccionados.add(adicionRevocacionCheckBox.getText());
        if (registroSECIITCheckBox.isSelected()) avisosSeleccionados.add(registroSECIITCheckBox.getText());
        if (pagoDerechosCheckBox.isSelected()) avisosSeleccionados.add(pagoDerechosCheckBox.getText());
        if (altaBajaTercerosCheckBox.isSelected()) avisosSeleccionados.add(altaBajaTercerosCheckBox.getText());
        if (bajaCertificacionAltaTercerizacionCheckBox.isSelected()) avisosSeleccionados.add(bajaCertificacionAltaTercerizacionCheckBox.getText());

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
            loginFirmSoli.login(tramite33302);
            mainPage33302.selecRol.sendKeys("Persona Moral");
            mainPage33302.btnacep.click();
            mainPage33302.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage33302.soliSubsecuente.click();
            mainPage33302.folioTramite.sendKeys(FolioRubro);
            mainPage33302.btnBuscarFolio.click();sleep(1000);
            mainPage33302.tablaFolios.doubleClick();
            mainPage33302.btnModificar.click();
            mainPage33302.tipoAvisos.click();
            // Ejecutar procesos según selección
            for (String aviso : avisosSeleccionados) {
                switch (aviso) {
                    case "Aviso Uso y Goce":
                        ejecutarAvisoUsoGoce();
                        break;
                    case "Aviso Fusión o Escisión":
                        ejecutarAvisoFusionEscision();
                        break;
                    case "Aviso Para Solventar Observaciones":
                        ejecutarAvisoObservaciones();
                        break;
                    case "Aviso Incidentes de Seguridad":
                        ejecutarAvisoSeguridad();
                        break;
                    case "Aviso de Circunstancias":
                        ejecutarAvisoCircunstancias();
                        break;
                    case "Aviso de Adición o Revocación":
                        ejecutarAvisoAdicionRevocacio();
                        break;
                    case "Aviso Registro SECIIT":
                        ejecutarAvisoSeciit();
                        break;
                    case "Avisos Alta o Baja Terceros":
                        ejecutarAvisoAltaTercerizacion();
                        break;
                    case "Aviso Baja Tercero Certificación / Alta Tercero Tercerización":
                        ejecutarAvisoBajaTercerizacion();
                        break;
                    case "Aviso Pago Derechos":
                        ejecutarAvisoPago();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                        break;
                }
                scrollDecremento();scrollDecremento();
                mainPage33302.tipoAvisos.click();
            }

            mainPage33302.manifiestoAvisos.click();
            mainPage33302.btnGuardarSoli.click();
            mainPage33302.btnContinuar.click();
            verificarSeleccion(usoYGoceCheckBox, fusionEscisionCheckBox, solventarObservacionesCheckBox, circunstanciasCheckBox, incidentesSeguridadCheckBox, registroSECIITCheckBox);

            mainPage33302.btnSiguiente.click();
            loginFirmSoli.firma(tramite33302);

            // Obtener el texto del folio desde mainPage33302
            String folioText = mainPage33302.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    private void verificarSeleccion(JCheckBox usoYGoceCheckBox, JCheckBox fusionEscisionCheckBox, JCheckBox registroSECIITCheckBox,
                                    JCheckBox solventarObservacionesCheckBox, JCheckBox circunstanciasCheckBox, JCheckBox incidentesSeguridadCheckBox) {

        int totalDocumentos = 0;

        // Calculamos el valor total según los checkboxes seleccionados
        if (usoYGoceCheckBox.isSelected()) totalDocumentos += 1;
        if (fusionEscisionCheckBox.isSelected()) totalDocumentos += 1;
        if (solventarObservacionesCheckBox.isSelected()) totalDocumentos += 1;
        if (circunstanciasCheckBox.isSelected()) totalDocumentos += 2;
        if (incidentesSeguridadCheckBox.isSelected()) totalDocumentos += 1;
        if (registroSECIITCheckBox.isSelected()) totalDocumentos += 6;

        // Evaluamos el total de documentos y ejecutamos las acciones correspondientes
        switch (totalDocumentos) {
            case 6:
                ejecutarCodigoAdjuntar6();
                break;
            case 5:
                ejecutarCodigoAdjuntar5();
                break;
            case 4:
                ejecutarCodigoAdjuntar4();
                break;
            case 3:
                ejecutarCodigoAdjuntar3();
                break;
            case 2:
                ejecutarCodigoAdjuntar2();
                break;
            case 1:
                ejecutarCodigoAdjuntar();
                break;
        }
    }

    private void ejecutarCodigoAdjuntar() {
        mainPage33302.btnAdjuntar1Doc.click();
        mainPage33302.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(1000);
        mainPage33302.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar2() {
        mainPage33302.btnAdjuntar2Doc.click();
        mainPage33302.segArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.segArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(1000);
        mainPage33302.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar3() {
        mainPage33302.btnAdjuntar3Doc.click();
        mainPage33302.archivo31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo33.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(3000);
        mainPage33302.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar4() {
        mainPage33302.btnAdjuntar4Doc.click();
        mainPage33302.archivo41.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo42.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo43.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo44.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(4000);
        mainPage33302.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar5() {
        mainPage33302.btnAdjuntar5Doc.click();
        mainPage33302.archivo51.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo52.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo53.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo54.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo55.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(5000);
        mainPage33302.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar6() {
        mainPage33302.btnAdjuntar6Doc.click();
        mainPage33302.archivo61.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo62.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo63.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo64.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo65.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.archivo66.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage33302.btnAdjuntar.click(); sleep(6000);
        mainPage33302.btnCerrar.click();
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
        mainPage33302.avisoUsoGoce.click();
        mainPage33302.usoGoce.click();
        mainPage33302.domicilio.sendKeys("CAMINO VIEJO 1353 MIGUEL HIDALGO");
        mainPage33302.codigoPostal.sendKeys("81210");
        mainPage33302.entidadFederativa.sendKeys("SINALOA");
        mainPage33302.municipio.sendKeys("AHOME");
        mainPage33302.documentoUsoGoce.sendKeys("Donación");
        mainPage33302.fechaInicioUsoGoce.click();
        mainPage33302.selecFecha.click();
        mainPage33302.fechaFin.click();
        mainPage33302.selecFechaFin.click();
        mainPage33302.rfcPartes.sendKeys("AAL0409235E6");
        mainPage33302.buscarRfcPartes.click();
        mainPage33302.caracterDePartes.sendKeys("MORAL");
        mainPage33302.btnAgregarPartes.click();sleep(1000);
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
        mainPage33302.observacionesPartes.sendKeys("PRUEBAS");
        mainPage33302.mismoDomicilio.click();
        mainPage33302.domicilioNuevo.sendKeys("CAMINO VIEJO 1350 MIGUEL HIDALGO");
        mainPage33302.codigoPostalNuevo.sendKeys("81210");
        mainPage33302.estadoNuevo.sendKeys("SINALOA");
        mainPage33302.municipioNuevo.sendKeys("AHOME");
        mainPage33302.documentoNuevo.sendKeys("Escritura pública");
        mainPage33302.fechaInicioNueva.click();
        mainPage33302.selecFechaNuevo.click();
        mainPage33302.fechaFinNuevo.click();
        mainPage33302.selecFechaFinNuevo.click();
        mainPage33302.rfcPartesNuevo.sendKeys("LEQI8101314S7");sleep(500);
        mainPage33302.buscarRfcPartesNuevo.doubleClick();
        mainPage33302.caracterDePartesNuevas.sendKeys("FISICA");
        mainPage33302.btnAgregarPartesNuevo.click();sleep(1000);
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
        mainPage33302.observacionesPartesNuevo.sendKeys("PRUEBAS");
    }

    private void ejecutarAvisoFusionEscision() {
        mainPage33302.avisoFusionEscision.click();
        mainPage33302.fusionEscision.click();
        mainPage33302.fusion1.click();
        mainPage33302.fusionEmpresa.click();
        mainPage33302.certificacionSi.click();
        mainPage33302.rfcFusion.sendKeys("AAL0409235E6");
        mainPage33302.busquedaRfcFusion.click();
        mainPage33302.fechaFusion.click();
        mainPage33302.selecFechaFusion.click();
        mainPage33302.folioFusion.sendKeys("12345");
        mainPage33302.agregarEmpresaFusionada.click();
        mainPage33302.certificacionFusionSi.click();
        mainPage33302.rfcFusionada.sendKeys("AAL0409235E6");
        mainPage33302.buscarRfcFusionada.click();
        mainPage33302.btnAgregarFusionada.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoObservaciones() {
        mainPage33302.avisoObservaciones.click();
        mainPage33302.observaciones.click();
        mainPage33302.agregarObservaciones.click();
        mainPage33302.entidadObservaciones.sendKeys("SINALOA");
        mainPage33302.selecDomicilioObservacion.click();
        mainPage33302.aceptarDomicilioObservacion.click();
        mainPage33302.selecDomicilioModificarOb.click();
        mainPage33302.modificarDomicilioOb.click();
        mainPage33302.tipoDomicilio.sendKeys("Planta productiva");
        mainPage33302.numActaVisita.sendKeys("1");
        mainPage33302.fechaVisita.click();
        mainPage33302.selecFechaVisita.click();
        mainPage33302.subestandaresVisita.sendKeys("PRUEBAS");
        mainPage33302.btnAceptarObservaciones.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoSeguridad() {
        mainPage33302.avisoSeguridad.click();
        mainPage33302.seguridad.click();
        mainPage33302.agregarDomiciliosIncidencias.click();
        mainPage33302.entidadFederativaIncidencias.sendKeys("SINALOA");
        mainPage33302.selecPlantaAgregar.click();
        mainPage33302.btnAgregarDomicilio.click();
        mainPage33302.selecPlantaModificarIncidencias.click();
        mainPage33302.modificarPlantaIncidencias.click();
        mainPage33302.tipoInstalacionIncidencias.sendKeys("Planta productiva");
        mainPage33302.cambiosSubestandares.sendKeys("PRUEBAS");
        mainPage33302.btnAceptarModificacionIncidencis.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);


    }

    private void ejecutarAvisoCircunstancias() {
        mainPage33302.avisoCircunstancias.click();
        mainPage33302.circunstancias.click();
        mainPage33302.agregarDomiciliosCircunstancias.click();
        mainPage33302.entidadFederativaCircunstancias.sendKeys("SINALOA");
        mainPage33302.selecPlantaAgregarCircunstancias.click();
        mainPage33302.btnAgregarPlantaCircunstancias.click();
        mainPage33302.selecPlantaModificar.click();
        mainPage33302.modificarPlantaCircunstancias.click();
        mainPage33302.tipoPlantaCircunstancias.sendKeys("Planta productiva");
        mainPage33302.folioAltaInstalacion.sendKeys("123");
        mainPage33302.fechaCircunstancias.click();
        mainPage33302.selecFechaCircunstancias.click();
        mainPage33302.cambioEstandaresCircunstancias.sendKeys("PRUEBAS");
        mainPage33302.btnAceptarModificacionCircunstancias.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoAdicionRevocacio() {
        mainPage33302.avisoAdicionRevocacion.click();
        mainPage33302.adicionRevocacion.click();
        mainPage33302.selecTransportistaModificar.click();
        mainPage33302.modificarTransportista.click();
        mainPage33302.estatusTransportista.sendKeys("Ratificado");
        mainPage33302.btnModificarTransportista.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
        mainPage33302.agregarTransportista.click();
        mainPage33302.rfcNuevoTransportista.sendKeys("TSD931210493");
        mainPage33302.btnBuscarRfcTransportista.click();
        mainPage33302.btnAgregarTransportista.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoSeciit() {
        mainPage33302.avisoSeciit.click();
        scrollDecremento();
        mainPage33302.seciit.click();
        mainPage33302.modifFusionEscisionSeciit.click();
        mainPage33302.modifSistemaControl.click();
        mainPage33302.modifProvedores.click();
        mainPage33302.modifSistemaPropios.click();
        mainPage33302.modifOtro.click();
        mainPage33302.descripcionOtros.sendKeys("PRUEBAS");

    }

    private void ejecutarAvisoAltaTercerizacion() {
        mainPage33302.avisoAltaTercerizacion.click();
        scrollDecremento();
        mainPage33302.altaTercerizacion.click();
        mainPage33302.agregarTerceroAlta.click();
        mainPage33302.rfcTerceroAlta.sendKeys("MAVL621207C95");;
        mainPage33302.btnBuscarRfcTerceroAlta.click();
        mainPage33302.tipoRegistroTerceroAlta.sendKeys("ALTA");
        mainPage33302.btnGuardarTerceroAlta.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }

    private void ejecutarAvisoBajaTercerizacion() {
        mainPage33302.avisoBajaTercerizacion.click();
        scrollDecremento();
        mainPage33302.bajaTercerizacion.click();
        mainPage33302.agregarTerceroBaja.click();
        mainPage33302.rfcTerceroBaja.sendKeys("LEQI8101314S7");;
        mainPage33302.btnBuscarRfcTerceroBaja.click();
        mainPage33302.tipoRegistroTerceroBaja.sendKeys("BAJA");
        mainPage33302.btnGuardarTerceroBaja.click();sleep(1000);
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
                "clickEnPosicion(756.9000015258789, 349.79374504089355);");
        sleep(1000);
    }



    private void ejecutarAvisoPago() {
        scrollDecremento();

    }

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

    public void clickAceptarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
    }

    public void clickSocioButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Socio")).shouldBe(visible).shouldHave(text("Socio")).doubleClick();
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
