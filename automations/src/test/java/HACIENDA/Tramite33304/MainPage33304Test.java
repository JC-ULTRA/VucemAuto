package HACIENDA.Tramite33304;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite33304.MainPage33304;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33304Test {
    MainPage33304 mainPage33304 = new MainPage33304();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite33304  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso33304() {
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
//        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
//
//        // Validar que el usuario haya ingresado un folio válido de 25 dígitos
//        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
//            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
//            return; // Cancelar la operación
//        }
//
//        // Confirmar el folio ingresado
//        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);
//
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//        // Crear checkboxes para los nuevos tipos de aviso
//        JCheckBox usoYGoceCheckBox = new JCheckBox("Aviso Uso y Goce");
//        JCheckBox fusionEscisionCheckBox = new JCheckBox("Aviso Fusión o Escisión");
//        JCheckBox solventarObservacionesCheckBox = new JCheckBox("Aviso Para Solventar Observaciones");
//        JCheckBox incidentesSeguridadCheckBox = new JCheckBox("Aviso Incidentes de Seguridad");
//        JCheckBox circunstanciasCheckBox = new JCheckBox("Aviso de Circunstancias");
//        JCheckBox adicionRevocacionCheckBox = new JCheckBox("Aviso de Adición o Revocación");
//        JCheckBox registroSECIITCheckBox = new JCheckBox("Aviso Registro SECIIT");
//        JCheckBox pagoDerechosCheckBox = new JCheckBox("Aviso Pago Derechos");
//        JCheckBox altaBajaTercerosCheckBox = new JCheckBox("Avisos Alta o Baja Terceros");
//        JCheckBox bajaCertificacionAltaTercerizacionCheckBox = new JCheckBox("Aviso Baja Tercero Certificación / Alta Tercero Tercerización");
//
//        // Crear un panel para mostrar los checkboxes
//        JPanel avisoPanel = new JPanel();
//        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
//        avisoPanel.add(usoYGoceCheckBox);
//        avisoPanel.add(fusionEscisionCheckBox);
//        avisoPanel.add(solventarObservacionesCheckBox);
//        avisoPanel.add(incidentesSeguridadCheckBox);
//        avisoPanel.add(circunstanciasCheckBox);
//        avisoPanel.add(adicionRevocacionCheckBox);
//        avisoPanel.add(registroSECIITCheckBox);
//        avisoPanel.add(pagoDerechosCheckBox);
//        avisoPanel.add(altaBajaTercerosCheckBox);
//        avisoPanel.add(bajaCertificacionAltaTercerizacionCheckBox);
//
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//        // Lógica para habilitar o deshabilitar checkboxes según el FolioRubro
//
//        // Activar/desactivar checkboxes basados en condiciones específicas
//        usoYGoceCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        fusionEscisionCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        solventarObservacionesCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        incidentesSeguridadCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        circunstanciasCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        adicionRevocacionCheckBox.setEnabled(FolioRubro.startsWith("25003026"));
//        registroSECIITCheckBox.setEnabled(FolioRubro.startsWith("25003026008"));
//        pagoDerechosCheckBox.setEnabled(FolioRubro.startsWith("2500301"));
//        altaBajaTercerosCheckBox.setEnabled(FolioRubro.startsWith("25003026017"));
//        bajaCertificacionAltaTercerizacionCheckBox.setEnabled(FolioRubro.startsWith("25003026017"));
//
//        // Mostrar diálogo con los checkboxes
//        int avisoOption = JOptionPane.showConfirmDialog(
//                null,
//                avisoPanel,
//                "Seleccione los tipos de aviso a ejecutar:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
//        );
//        if (avisoOption != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return; // Cancelar si el usuario no acepta
//        }
//
//        // Recoger las selecciones realizadas por el usuario
//        List<String> avisosSeleccionados = new ArrayList<>();
//        if (usoYGoceCheckBox.isSelected()) avisosSeleccionados.add(usoYGoceCheckBox.getText());
//        if (fusionEscisionCheckBox.isSelected()) avisosSeleccionados.add(fusionEscisionCheckBox.getText());
//        if (solventarObservacionesCheckBox.isSelected()) avisosSeleccionados.add(solventarObservacionesCheckBox.getText());
//        if (incidentesSeguridadCheckBox.isSelected()) avisosSeleccionados.add(incidentesSeguridadCheckBox.getText());
//        if (circunstanciasCheckBox.isSelected()) avisosSeleccionados.add(circunstanciasCheckBox.getText());
//        if (adicionRevocacionCheckBox.isSelected()) avisosSeleccionados.add(adicionRevocacionCheckBox.getText());
//        if (registroSECIITCheckBox.isSelected()) avisosSeleccionados.add(registroSECIITCheckBox.getText());
//        if (pagoDerechosCheckBox.isSelected()) avisosSeleccionados.add(pagoDerechosCheckBox.getText());
//        if (altaBajaTercerosCheckBox.isSelected()) avisosSeleccionados.add(altaBajaTercerosCheckBox.getText());
//        if (bajaCertificacionAltaTercerizacionCheckBox.isSelected()) avisosSeleccionados.add(bajaCertificacionAltaTercerizacionCheckBox.getText());
//
//        // Validar que al menos un aviso haya sido seleccionado
//        if (avisosSeleccionados.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
//            return;
//        }
//
//        // Confirmación y manejo de selecciones
//        JOptionPane.showMessageDialog(null, "Procesos ejecutados para: " + String.join(", ", avisosSeleccionados));

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite33304);
            mainPage33304.selecRol.sendKeys("Persona Moral");
            mainPage33304.btnacep.click();
            mainPage33304.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage33304.soliSubsecuente.click();
            mainPage33304.folioTramite.sendKeys("FolioRubro");
            mainPage33304.btnBuscarFolio.click();sleep(1000);
            mainPage33304.tablaFolios.doubleClick();
            mainPage33304.btnAvisoModificacionCeI.click();
            //ACUSES Y RESOLUCIONES
            mainPage33304.checkVariacion.click();
            mainPage33304.checkAvisoFusionEscision.click();
            //AVISO GOCE INMUEBLE
            mainPage33304.labelAvisoModGoceInmueble.click();
            mainPage33304.inputDireccionInmueble.sendKeys("CONOCIDA");
            mainPage33304.inputCodigoPostal.sendKeys("07923");
            mainPage33304.inputEntidadFederativa.sendKeys("BAJA CALIFORNIA SUR");
            mainPage33304.inputMunicipio.sendKeys("COMONDU");
            mainPage33304.inputDoctoAcredita.sendKeys("Contrato de compra");
            Selenide.executeJavaScript("arguments[0].value = '09/05/2025';", mainPage33304.inputFechaInicioVigencia);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '09/06/2025';", mainPage33304.inputFechaFinVigencia);sleep(100);
            mainPage33304.inputRFC.sendKeys("AAL0409235E6");
            mainPage33304.btnBuscarRFC.click();
            mainPage33304.btnAgregarParteC.click();
            mainPage33304.inputObservaciones.sendKeys("PRUEBA");
            mainPage33304.inputMismoRegistro.click();
            mainPage33304.inputDoctoAcreditaUsoGoce.sendKeys("Contrato de Usufructo");
            mainPage33304.inputModificacionVigencias.click();
            Selenide.executeJavaScript("arguments[0].value = '09/05/2025';", mainPage33304.inputFechaInicialAnterior);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '09/06/2025';", mainPage33304.inputFechaFinalAnterior);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '01/06/2025';", mainPage33304.inputFechaInicialActual);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '01/07/2025';", mainPage33304.inputFechaFinalActual);sleep(100);
mainPage33304.inputModificacionPartes.click();
mainPage33304.inputRFCPartes.sendKeys("AAL0409235E6");
mainPage33304.btnBuscarPersona.click();
mainPage33304.btnAgregarParte.click();
mainPage33304.inputObservacionesM.sendKeys("PRUEBAS");
//FUSION ESCISION
            mainPage33304.labelAvisoFusionEscision.click();
            mainPage33304.inputFusion1.click();
            mainPage33304.inputFusion.click();
            mainPage33304.inputRegistroEIC.click();
            mainPage33304.inputRFCFusionEIC.sendKeys("AAL0409235E6");
            mainPage33304.btnAceptarDomicilios.click();


            mainPage33304.inputGuardarSolicitud.click();
            //REQUISITOS NECESARIOS
            mainPage33304.inputSiguiente.click();
            //ANEXAR REQUISITOS
            mainPage33304.inputAdjuntarDocumentos.click();
            mainPage33304.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage33304.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage33304.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage33304.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage33304.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
            mainPage33304.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage33304.inputDocumentosFile7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage33304.inputDocumentosFile8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage33304.inputDocumentosFile9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage33304.inputDocumentosFile10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf"); sleep(500);
            mainPage33304.spanAdjuntar.click();sleep(40000);
            mainPage33304.spanCerrar.click();sleep(500);
//            mainPage33304.Adjuntar.click();
            mainPage33304.inputSiguienteButton.click();sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite33304);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage33304.folio.getText();

            // Llamar al metodo para obtener el folio
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
}