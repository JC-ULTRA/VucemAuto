package PROFEPA.Tramite250101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage250101Test {
    MainPage250101 mainPage250101 = new MainPage250101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite250101  = new TramitesFirmasLG(
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
    public void Proceso250101() {
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen250101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion250101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion250101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen250101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion250101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion250101");
        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite250101);
            mainPage250101.selecRol.sendKeys("Persona Moral");
            mainPage250101.btnacep.click();
            mainPage250101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage250101.SoliNew.click();
            mainPage250101.PROFEPA.click();
            mainPage250101.linkCertificadosLicenciasPermisos.click();
            mainPage250101.linkRegistroVerificaci.click();
            mainPage250101.linkProfepaSiiFloraFauna.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage250101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage250101.labelTipoMovimiento.click();
            mainPage250101.selectSolicitudAduanasAduanaClave.sendKeys("COLOMBIA");
            mainPage250101.selectSolicitudUnidadAdministrativaRepresentacion.sendKeys("COLOMBIA");
            mainPage250101.selectSolicitudEntidadesEntidadClave.sendKeys("NUEVO LEON");
            mainPage250101.inputGuardarSolicitudParcial.click();
            mainPage250101.labelDestinatarioAgenteAduanal.click();
            mainPage250101.inputCapturarDestinatario.click();
            mainPage250101.inputDenominacionDestinatario.sendKeys("PROTEO TOYS");
            mainPage250101.selectEntidadFederativa.sendKeys("CIUDAD DE MÉXICO");
            mainPage250101.inputCodigoPostalDestinatario.sendKeys("06934");
            mainPage250101.textareaCalleDestinatario.sendKeys("CONOCIDA");
            mainPage250101.inputRegistroDestinatario.click();
            Selenide.sleep(500);
            metodos.presionarEscYSpace();
            mainPage250101.inputAgregarRequisito.click();
            mainPage250101.inputNombreAgente.sendKeys("RICHARD");
            mainPage250101.inputApellidoPaternoAgente.sendKeys("RICSON");
            mainPage250101.inputApellidoMaternoAgente.sendKeys("RIVERO");
            mainPage250101.inputPatente.sendKeys("1234");
            mainPage250101.inputAgregarAgente.click();
            mainPage250101.labelMercancSinCfi.click();
            mainPage250101.inputAgregarDescripcion.click();
            mainPage250101.selectDescripcionProducto.sendKeys("ASERRIN");
            mainPage250101.selectFraccionArancelariaClave.sendKeys("44013999");
            mainPage250101.inputCantidad.sendKeys("10");
            mainPage250101.selectUnidadMedidaClave.sendKeys("Gramo");
            mainPage250101.selectGenero.sendKeys("Alnus");
            mainPage250101.selectEspecie.sendKeys("ninguno");
            mainPage250101.selectVidaSilvestre.sendKeys("ninguno");
            mainPage250101.selectPaisesDetalleMercanciaPais.sendKeys("BRASIL");
            mainPage250101.selectPaisesDetalleMercanciaPais2.sendKeys("ALEMANIA");
            mainPage250101.inputAgregarMercancia.click();
            mainPage250101.inputAgregarAgente2.click();
            mainPage250101.inputGuardarSeccionMercancias.click();
            mainPage250101.labelRequisitos.click();
            mainPage250101.selectMedioTransporte.sendKeys("Carretero");
            mainPage250101.inputAgregarRequisito2.click();
            mainPage250101.inputNumIdentificacion.sendKeys("1234");
            mainPage250101.inputNumEconomico.sendKeys("2345");
            mainPage250101.inputPlaca.sendKeys("3465");
            mainPage250101.inputAgregarTransporte.click();
            mainPage250101.inputAgregarRequisito3.click();
            mainPage250101.selectRegistroRequisitoCaption.sendKeys("Comprobante");
            mainPage250101.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250101.inputCalendarFrom);sleep(100);
            mainPage250101.inputAgregarAgente3.click();
            mainPage250101.inputAgregarRequisito3.click();
            mainPage250101.selectRegistroRequisitoCaption.sendKeys("Certificado");
            mainPage250101.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250101.inputCalendarFrom);sleep(100);
            mainPage250101.inputAgregarAgente3.click();
            mainPage250101.inputAgregarRequisito3.click();
            mainPage250101.selectRegistroRequisitoCaption.sendKeys("Factura");
            mainPage250101.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250101.inputCalendarFrom);sleep(100);
            mainPage250101.inputAgregarAgente3.click();
            mainPage250101.inputAgregarRequisito3.click();
            mainPage250101.selectRegistroRequisitoCaption.sendKeys("Otros");
            mainPage250101.inputTxtNumero.sendKeys("1369");
            mainPage250101.inputAgregarAgente3.click();
            mainPage250101.labelPagoDerechos.click();
            mainPage250101.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage250101.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250101.inputSolicitudPagoLlave2);sleep(100);
            mainPage250101.inputGuardarPago.click();
            mainPage250101.inputDatosRevisadosCorrectos.click();
            //FIRMA
            mainPage250101.inputGuardarSolicitud.click();
            mainPage250101.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage250101.btnAnexar.click();sleep(8000);
            Selenide.sleep(4000);
            mainPage250101.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage250101.inputSiguiente.click();sleep(3000);
            loginFirmSoli.firma(tramite250101);
            Selenide.sleep(2000);
            String folioText = mainPage250101.folio.getText();sleep(5000);
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