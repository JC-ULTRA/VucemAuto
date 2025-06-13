package PROFEPA.Tramite250103;

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

public class MainPage250103Test {
    MainPage250103 mainPage250103 = new MainPage250103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite250103  = new TramitesFirmasLG(
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
    public void Proceso250103() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen250103");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion250103");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion250103");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen250103");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion250103");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion250103");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite250103);
            mainPage250103.selecRol.sendKeys("Persona Moral");
            mainPage250103.btnacep.click();
            mainPage250103.Tramites.sendKeys("Solicitudes nuevas");
            mainPage250103.SoliNew.click();
            mainPage250103.PROFEPA.click();
            mainPage250103.linkCertificadosLicenciasPermisos.click();
            mainPage250103.linkRegistroVerificaci.click();
            mainPage250103.linkTarimasEmbalajesMaderaSoporteMercancia.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage250103.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage250103.labelTipoMovimiento.click();
            mainPage250103.selectSolicitudAduanasAduanaClave.sendKeys("COLOMBIA");
            mainPage250103.selectSolicitudUnidadAdministrativaRepresentacion.sendKeys("COLOMBIA");
            mainPage250103.selectSolicitudEntidadesEntidadClave.sendKeys("NUEVO LEON");
            mainPage250103.inputGuardarSolicitudParcial.click();
            mainPage250103.labelDestinatarioAgenteAduanal.click();
            mainPage250103.inputCapturarDestinatario.click();
            mainPage250103.inputDenominacionDestinatario.sendKeys("PROTEO TOYS");
            //mainPage250103.selectPaisNacionalDestinatario.sendKeys("");
            mainPage250103.selectEntidadFederativa.sendKeys("CIUDAD DE MÉXICO");
            mainPage250103.inputCodigoPostalDestinatario.sendKeys("06934");
            mainPage250103.textareaCalleDestinatario.sendKeys("CONOCIDA");
            mainPage250103.inputRegistroDestinatario.click();
            Selenide.sleep(500);
            mainPage250103.inputAceptarEmergente.click();
            mainPage250103.inputAgregarRequisito.click();
            mainPage250103.inputNombreAgente.sendKeys("RICHARD");
            mainPage250103.inputApellidoPaternoAgente.sendKeys("RICSON");
            Selenide.sleep(500);
            mainPage250103.inputApellidoMaternoAgente.sendKeys("RIVERO");
            mainPage250103.inputPatente.sendKeys("1234");
            mainPage250103.inputAgregarAgente.click();
            mainPage250103.labelMercancSinCfi.click();
            mainPage250103.inputAgregarDescripcion.click();
            mainPage250103.selectDescripcionProducto.sendKeys("CAJAS DE MADERA ALAMBRADAS NUEVAS TRATADAS Y MARCADAS EN BASE A LA ISPM 15");
            mainPage250103.selectFraccionArancelariaClave.sendKeys("44151001");
            mainPage250103.inputCantidad.sendKeys("10");
            mainPage250103.selectUnidadMedidaClave.sendKeys("Pieza");
            mainPage250103.selectGenero.sendKeys("Alnus");
            mainPage250103.selectEspecie.sendKeys("ninguno");
            mainPage250103.selectVidaSilvestre.sendKeys("ninguno");
            mainPage250103.selectPaisesDetalleMercanciaPais.sendKeys("BRASIL");
            mainPage250103.selectPaisesDetalleMercanciaPais2.sendKeys("ALEMANIA");
            mainPage250103.inputAgregarMercancia.click();
            mainPage250103.inputAgregarAgente2.click();
            mainPage250103.inputGuardarSeccionMercancias.click();
            mainPage250103.labelRequisitos.click();
            mainPage250103.selectMedioTransporte.sendKeys("Carretero");
            mainPage250103.inputAgregarRequisito2.click();
            mainPage250103.inputNumIdentificacion.sendKeys("1234");
            mainPage250103.inputNumEconomico.sendKeys("2345");
            mainPage250103.inputPlaca.sendKeys("3465");
            mainPage250103.inputAgregarTransporte.click();
            mainPage250103.inputAgregarRequisito3.click();
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Comprobante");
            mainPage250103.inputNumero.sendKeys("1369");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            Selenide.sleep(500);sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Certificado");sleep(500);
            mainPage250103.inputNumero.sendKeys("1369");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Factura");sleep(500);
            mainPage250103.inputNumero.sendKeys("1369");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputCalendarFrom);sleep(100);sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.inputAgregarRequisito3.click();sleep(500);
            mainPage250103.selectRegistroRequisitoCaption.sendKeys("Otros");sleep(500);
            mainPage250103.inputTxtNumero.sendKeys("1369");sleep(500);
            mainPage250103.inputAgregarAgente3.click();sleep(500);
            mainPage250103.labelPagoDerechos.click();sleep(500);
            mainPage250103.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");sleep(500);
            Random random = new Random();
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage250103.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage250103.inputSolicitudPagoLlave2);sleep(100);
            mainPage250103.inputGuardarPago.click();
            mainPage250103.inputDatosRevisadosCorrectos.click();
            mainPage250103.inputGuardarSolicitud.click();
            mainPage250103.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage250103.btnAnexar.click();sleep(8000);

            Selenide.sleep(4000);
            mainPage250103.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage250103.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite250103);
            Selenide.sleep(2000);
//            String folioText = mainPage250103.folio.getText();sleep(5000);
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