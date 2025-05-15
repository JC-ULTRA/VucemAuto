package HACIENDA.Tramite33304;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite33304.MainPage33304;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage33304Test {


    MainPage33304 mainPage33304 = new MainPage33304();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite33304 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
        // Validar que el usuario haya ingresado un folio válido de 25 dígitos
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }
        // Confirmar el folio ingresado
        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

        // Crear checkboxes para los nuevos tipos de aviso
        JCheckBox usoYGoceCheckBox = new JCheckBox("Aviso Uso y Goce");
        JCheckBox fusionEscisionCheckBox = new JCheckBox("Aviso Fusión o Escisión");
        JCheckBox adicionRevocacionCheckBox = new JCheckBox("Aviso de Adición o Revocación");
        JCheckBox pagoDerechosCheckBox = new JCheckBox("Aviso Pago Derechos");

        // Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
        avisoPanel.add(usoYGoceCheckBox);
        avisoPanel.add(fusionEscisionCheckBox);
        avisoPanel.add(adicionRevocacionCheckBox);
        avisoPanel.add(pagoDerechosCheckBox);

        // Lógica para habilitar o deshabilitar checkboxes según el FolioRubro

        // Activar/desactivar checkboxes basados en condiciones específicas
        usoYGoceCheckBox.setEnabled(FolioRubro.startsWith("2500301") || FolioRubro.startsWith("2500302"));
        fusionEscisionCheckBox.setEnabled(FolioRubro.startsWith("2500301") || FolioRubro.startsWith("2500302"));
        adicionRevocacionCheckBox.setEnabled(FolioRubro.startsWith("2500301") || FolioRubro.startsWith("2500302"));
        pagoDerechosCheckBox.setEnabled(FolioRubro.startsWith("2500301"));

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
        if (adicionRevocacionCheckBox.isSelected()) avisosSeleccionados.add(adicionRevocacionCheckBox.getText());
        if (pagoDerechosCheckBox.isSelected()) avisosSeleccionados.add(pagoDerechosCheckBox.getText());

        // Validar que al menos un aviso haya sido seleccionado
        if (avisosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún aviso. La operación será cancelada.");
            return;
        }

        // Confirmación y manejo de selecciones
        JOptionPane.showMessageDialog(null, "Procesos ejecutados para: " + String.join(", ", avisosSeleccionados));


        ///////////////////////
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
            mainPage33304.folioTramite.sendKeys(FolioRubro);
            mainPage33304.btnBuscarFolio.click();
            sleep(1000);
            mainPage33304.tablaFolios.doubleClick();
            mainPage33304.btnAvisoModificacionCeI.click();
            int totalDocumentosAdjuntar = 0;
            // Ejecutar procesos según selección
            for (String aviso : avisosSeleccionados) {
                switch (aviso) {
                    case "Aviso Uso y Goce":
                        ejecutarAvisoUsoGoce();

                        break;
                    case "Aviso Fusión o Escisión":
                        ejecutarAvisoFusionEscision();

                        break;
                    case "Aviso de Adición o Revocación":
                        ejecutarAvisoAdicionRevocacio();
                        break;
                    case "Aviso Pago Derechos":
                        ejecutarAvisoPago();

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                        break;
                }
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage33304.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage33304.labelTipoAviso.click();
            }

            mainPage33304.checkProtestaFacultades.click();
            mainPage33304.btnGuardarSolicitud.click();
            mainPage33304.inputSiguiente.click();sleep(1000);
            mainPage33304.inputAdjuntarDocumentos.click();sleep(1000);
            subirDocumentos("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage33304.spanAdjuntar.click();
            sleep(4000);
            mainPage33304.spanCerrar.click();
            sleep(500);
            mainPage33304.inputSiguienteButton.click();
            sleep(500);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite33304);
            String folioText = mainPage33304.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }
    //AVISO GOCE INMUEBLE
    private void ejecutarAvisoUsoGoce() {
        mainPage33304.checkVariacion.click();
        try
        {
            Thread.sleep(2000); // Pausa de 3 segundos
            // Hacer scroll hasta el elemento
            mainPage33304.Scrol.scrollIntoView(true);
        } catch(
                InterruptedException e)
        {
            e.printStackTrace();
        }
        mainPage33304.labelAvisoModGoceInmueble.click();
        mainPage33304.inputDireccionInmueble.sendKeys("CONOCIDA");
        mainPage33304.inputCodigoPostal.sendKeys("07923");
        mainPage33304.inputEntidadFederativa.sendKeys("BAJA CALIFORNIA SUR");
        mainPage33304.inputMunicipio.sendKeys("COMONDU");
        mainPage33304.inputDoctoAcredita.sendKeys("Contrato de compra");
        Selenide.executeJavaScript("arguments[0].value = '09/05/2025';",mainPage33304.inputFechaInicioVigencia);
        sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '09/06/2025';",mainPage33304.inputFechaFinVigencia);
        sleep(100);
        mainPage33304.inputRFC.sendKeys("AAL0409235E6");
        mainPage33304.btnBuscarRFC.click();
        mainPage33304.inputCaracter.sendKeys("PRUEBA");
        mainPage33304.btnAgregarParteC.click();
        Selenide.sleep(500);
        presionarEscYSpace();
        mainPage33304.inputObservaciones.sendKeys("PRUEBA");
        mainPage33304.inputMismoRegistro.click();
        mainPage33304.inputDoctoAcreditaUsoGoce.sendKeys("Contrato de Usufructo");
        mainPage33304.inputModificacionVigencias.click();
        Selenide.executeJavaScript("arguments[0].value = '09/05/2025';",mainPage33304.inputFechaInicialAnterior);
        sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '09/06/2025';",mainPage33304.inputFechaFinalAnterior);
        sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '01/06/2025';",mainPage33304.inputFechaInicialActual);
        sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '01/07/2025';",mainPage33304.inputFechaFinalActual);
        sleep(100);
        mainPage33304.inputModificacionPartes.click();
        mainPage33304.inputRFCPartes.sendKeys("AAL0409235E6");
        mainPage33304.btnBuscarPersona.click();
        mainPage33304.inputCaracterParteMod.sendKeys("PRUEBA");
        mainPage33304.btnAgregarParte.click();
        Selenide.sleep(500);
        presionarEscYSpace();
        mainPage33304.inputObservacionesM.sendKeys("PRUEBAS");
    }
    //FUSION ESCISION
    private void ejecutarAvisoFusionEscision() {
        mainPage33304.checkAvisoFusionEscision.click();
        try {
            Thread.sleep(2000); // Pausa de 3 segundos
            // Hacer scroll hasta el elemento
            mainPage33304.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage33304.labelAvisoFusionEscision.click();
        mainPage33304.inputFusion1.click();
        mainPage33304.inputFusion.click();
        mainPage33304.inputRegistroEIC.click();
        mainPage33304.inputRFCFusionEIC.sendKeys("AAL0409235E6");
        mainPage33304.btnAceptarDomicilios.click();
        Selenide.executeJavaScript("arguments[0].value = '01/07/2025';", mainPage33304.inputFechaFusion);
        sleep(100);
        mainPage33304.inputFolioFusion.sendKeys("234");
        mainPage33304.inputAgregarPersona.click();
        mainPage33304.inputCertificacionModal.click();
        mainPage33304.inputBuscaRFC.sendKeys("AAL0409235E6");
        mainPage33304.inputRazonSocialFusion.sendKeys("PRUEBAS");
        mainPage33304.btnAceptarFusion.click();
        Selenide.sleep(500);
        presionarEscYSpace();
    }

    private void ejecutarAvisoAdicionRevocacio() {
        //AVISO ADICION RENOVACION
        mainPage33304.checkAvisoAdicionRevocacion.click();
        mainPage33304.labelAvisoAdicionRevocacion.click();
        mainPage33304.inputAgregarTransportista.click();
        mainPage33304.inputRFCAdicionRevocacion.sendKeys("AAL0409235E6");
        mainPage33304.inputBuscarEmpresa.click();
        mainPage33304.btnGuardarTransportista.click();
        Selenide.sleep(500);
        presionarEscYSpace();
    }
    private void ejecutarAvisoPago() {
        //AVISO PAGO DERECHOS
        mainPage33304.checkPresentacionPago.click();
        try {
            Thread.sleep(2000); // Pausa de 3 segundos
            // Hacer scroll hasta el elemento
            mainPage33304.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage33304.labelPagoDerechos.click();
        Random aleatoria = new Random();
        int nReferenciaR = 10_000_000 + aleatoria.nextInt(90_000_000);
        mainPage33304.inputReferenciaBancaria.setValue(String.valueOf(nReferenciaR));
        mainPage33304.inputBanco.sendKeys("HSBC");
        Random random = new Random();
        int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
        mainPage33304.inputLlavePago.setValue(String.valueOf(nFacturaR));
        Selenide.executeJavaScript("arguments[0].value = '10/05/2025';", mainPage33304.inputFechaPago);
        sleep(100);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }
    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }

}