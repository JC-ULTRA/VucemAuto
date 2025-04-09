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
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
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
            loginFirmSoli.login(tramite33303);
            mainPage33303.selecRol.sendKeys("Persona Moral");
            mainPage33303.btnacep.click();
            mainPage33303.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage33303.soliSubsecuente.click();
            mainPage33303.folioTramite.sendKeys(FolioRubro);
            mainPage33303.btnBuscarFolio.click();sleep(1000);
            mainPage33303.tablaFolios.doubleClick();
//            mainPage33303.btnModificar.click();
//            mainPage33303.tipoAvisos.click();
//
//            // Ejecutar procesos según selección
//            for (String aviso : avisosSeleccionados) {
//                switch (aviso) {
//                    case "Aviso Uso y Goce":
//                        ejecutarAvisoUsoGoce();
//                        break;
//                    case "Aviso Para Solventar Observaciones":
//                        ejecutarAvisoObservaciones();
//                        break;
//                    case "Aviso Incidentes de Seguridad":
//                        ejecutarAvisoSeguridad();
//                        break;
//                    case "Aviso de Circunstancias":
//                        ejecutarAvisoCircunstancias();
//                        break;
//                    case "Aviso de Adición o Revocación":1
//                        ejecutarAvisoAdicionRevocacio();
//                        break;
//                    case "Aviso Registro SECIIT":
//                        ejecutarAvisoSeciit();
//                        break;
//                    case "Aviso Pago Derechos":
//                        ejecutarAvisoPago();
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
//                        break;
//                }
//                scrollDecremento();
//                mainPage33303.tipoAvisos.click();
//            }
//
//            mainPage33303.btnGuardarSoli.click();
//            mainPage33303.btnContinuar.click();
////            verificarSeleccion(aduanalCheckBox, fusionEscisionCheckBox, articulo99CheckBox);
//
//            mainPage33303.btnSiguiente.click();
//            loginFirmSoli.firma(tramite33302);
//
//            // Obtener el texto del folio desde mainPage33303
//            String folioText = mainPage33303.folio.getText();
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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
