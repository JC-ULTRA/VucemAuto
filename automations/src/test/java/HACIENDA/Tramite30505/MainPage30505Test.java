package HACIENDA.Tramite30505;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite30505.MainPage30505;
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

public class MainPage30505Test {
    HACIENDA.Tramite30505.MainPage30505 mainPage30505 = new HACIENDA.Tramite30505.MainPage30505();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite30505  = new TramitesFirmasLG(
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
    public void Proceso30505() {
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
        if (FolioRubro == null || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")|| !FolioRubro.startsWith("25003003")) {
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
        JCheckBox fusionEscisionCheckBox = new JCheckBox("Aviso Fusión Escisión");
        JCheckBox aduanalCheckBox = new JCheckBox("Aviso Aduanal");
        JCheckBox articulo99CheckBox = new JCheckBox("Aviso Artículo 99");
        JCheckBox razonSocialCheckBox = new JCheckBox("Aviso Cambio Razón Social");
        // Crear un panel para mostrar los checkboxes
        JPanel avisoPanel = new JPanel();
        avisoPanel.setLayout(new BoxLayout(avisoPanel, BoxLayout.Y_AXIS));
        avisoPanel.add(fusionEscisionCheckBox);
        avisoPanel.add(aduanalCheckBox);
        avisoPanel.add(articulo99CheckBox);
        avisoPanel.add(razonSocialCheckBox);
        // Agregar lógica de validación dinámica
        fusionEscisionCheckBox.addActionListener(e -> {
            boolean fusionSelected = fusionEscisionCheckBox.isSelected();
            aduanalCheckBox.setEnabled(!fusionSelected);
            articulo99CheckBox.setEnabled(!fusionSelected);
            razonSocialCheckBox.setEnabled(!fusionSelected);
        });
        aduanalCheckBox.addActionListener(e -> {
            boolean otrosSeleccionados = aduanalCheckBox.isSelected() || articulo99CheckBox.isSelected() || razonSocialCheckBox.isSelected();
            fusionEscisionCheckBox.setEnabled(!otrosSeleccionados);
        });
        articulo99CheckBox.addActionListener(e -> {
            boolean otrosSeleccionados = aduanalCheckBox.isSelected() || articulo99CheckBox.isSelected() || razonSocialCheckBox.isSelected();
            fusionEscisionCheckBox.setEnabled(!otrosSeleccionados);
        });
        razonSocialCheckBox.addActionListener(e -> {
            boolean otrosSeleccionados = aduanalCheckBox.isSelected() || articulo99CheckBox.isSelected() || razonSocialCheckBox.isSelected();
            fusionEscisionCheckBox.setEnabled(!otrosSeleccionados);
        });
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
        if (fusionEscisionCheckBox.isSelected()) avisosSeleccionados.add(fusionEscisionCheckBox.getText());
        if (aduanalCheckBox.isSelected()) avisosSeleccionados.add(aduanalCheckBox.getText());
        if (articulo99CheckBox.isSelected()) avisosSeleccionados.add(articulo99CheckBox.getText());
        if (razonSocialCheckBox.isSelected()) avisosSeleccionados.add(razonSocialCheckBox.getText());
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
            loginFirmSoli.login(tramite30505);
            mainPage30505.selecRol.sendKeys("Persona Moral");
            mainPage30505.btnacep.click();
            mainPage30505.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage30505.soliSubsecuente.click();
            mainPage30505.folioTramite.sendKeys(FolioRubro);
            mainPage30505.btnBuscarFolio.click();sleep(1000);
            mainPage30505.tablaFolios.doubleClick();
            mainPage30505.btnModificar.click();
            // Ejecutar procesos según selección
            for (String aviso : avisosSeleccionados) {
                switch (aviso) {
                    case "Aviso Fusión Escisión":
                        ejecutarAvisoFusionEscision();
                        break;
                    case "Aviso Aduanal":
                        ejecutarAvisoAduanal();
                        break;
                    case "Aviso Artículo 99":
                        ejecutarAvisoArticulo99();
                        break;
                    case "Aviso Cambio Razón Social":
                        ejecutarAvisoRazon();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Aviso no válido seleccionado: " + aviso);
                        break;
                }
            }

            mainPage30505.btnGuardarSoli.click();
            mainPage30505.btnContinuar.click();
            verificarSeleccion(aduanalCheckBox, fusionEscisionCheckBox, articulo99CheckBox);

            mainPage30505.btnSiguiente.click();
            loginFirmSoli.firma(tramite30505);

            // Obtener el texto del folio desde mainPage30505
            String folioText = mainPage30505.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }
    private void verificarSeleccion(JCheckBox aduanalCheckBox, JCheckBox fusionEscisionCheckBox, JCheckBox articulo99CheckBox) {
        boolean aduanalSelected = aduanalCheckBox.isSelected();
        boolean fusionSelected = fusionEscisionCheckBox.isSelected();
        boolean articulo99Selected = articulo99CheckBox.isSelected();

        // Verifica si alguno está seleccionado
        if (aduanalSelected && articulo99Selected) {
            ejecutarCodigoAdjuntar2();
        } else if (aduanalSelected || fusionSelected || articulo99Selected) {
            ejecutarCodigoAdjuntar();
        } else {
            System.out.println("No Hay Archivos Por Cargar");
        }
    }

    private void ejecutarCodigoAdjuntar() {
        mainPage30505.btnAdjuntarDoc.click();
        mainPage30505.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage30505.btnAdjuntar.click(); sleep(1000);
        mainPage30505.btnCerrar.click();
    }
    private void ejecutarCodigoAdjuntar2() {
        mainPage30505.btnAdjuntar2Doc.click();
        mainPage30505.segArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage30505.segArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage30505.btnAdjuntar.click(); sleep(1000);
        mainPage30505.btnCerrar.click();
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

    private void ejecutarAvisoFusionEscision() {
        scrollDecremento();
        mainPage30505.tipoAvisos.click();
        mainPage30505.avisoFusionEscision.click();
        mainPage30505.fusionEsicion.click();sleep(1000);
        mainPage30505.opcion2.click();
        mainPage30505.escision.click();
        mainPage30505.certificacionSi.click();
        mainPage30505.rfcEmpresaEscidente.sendKeys("COR8002193KA");
        mainPage30505.btnBuscarRfcEmpresa.click();
        mainPage30505.fechaEscision.click();
        mainPage30505.selecFechaEscision.click();
        mainPage30505.folioEscision.sendKeys("12345");
        mainPage30505.agregarEmpresasEscindidas.click();
        mainPage30505.certificadoModalSi.click();
        mainPage30505.rfcModal.sendKeys("COR8002193KA");
        mainPage30505.btnBuscarRfcModal.click();
        mainPage30505.btnAceptarModal.click();
        clickAceptarButton();
    }

    private void ejecutarAvisoAduanal() {
        scrollDecremento();
        mainPage30505.tipoAvisos.click();
        mainPage30505.avisoAduanal.click();
        mainPage30505.aduanal.click();sleep(1000);
        mainPage30505.selectAgente.click();
        mainPage30505.modificarPatente.click();
        mainPage30505.tipoMovimientoPatente.sendKeys("Sin movimiento");
        mainPage30505.btnGuardarModificacionPatente.click();
//            mainPage30505.btnAgregarPatente.click();
//            mainPage30505.tipoAduanal.sendKeys("Agente Aduanal");
//            mainPage30505.numeroPatente.sendKeys("1003");
//            mainPage30505.check1.click();
//            mainPage30505.check2.click();
//            mainPage30505.btnBuscarPatente.click();
//            mainPage30505.btnGuardarAduanal.click();
        clickAceptarButton();
    }

    private void ejecutarAvisoArticulo99() {
        scrollDecremento();
        mainPage30505.tipoAvisos.click();
        mainPage30505.avisoArticulo99.click();
        mainPage30505.articulo99.click();sleep(1000);
        mainPage30505.ejercicioAnteriorSi.click();
        mainPage30505.montoContribuciones.sendKeys("1");
        mainPage30505.margenError.sendKeys("1");
        mainPage30505.cE.sendKeys("1");
        mainPage30505.cDV.sendKeys("1");
        mainPage30505.cO.sendKeys("1");
        mainPage30505.cDR.sendKeys("1");
        mainPage30505.cPO.sendKeys("1");
        mainPage30505.pCO.sendKeys("1");
        mainPage30505.desarrolloFormula.sendKeys("1");
        mainPage30505.mayoraMargenSi.click();
        mainPage30505.montoTotal.sendKeys("1");
        mainPage30505.observaciones.sendKeys("1");
    }

    private void ejecutarAvisoRazon() {
        scrollDecremento();
        mainPage30505.tipoAvisos.click();
        mainPage30505.avisoDenominacion.click();
        mainPage30505.denominacion.click();sleep(1000);
        mainPage30505.foliosDenominacion.sendKeys("Pruebas");
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
