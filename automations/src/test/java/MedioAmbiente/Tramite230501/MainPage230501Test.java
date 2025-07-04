package MedioAmbiente.Tramite230501;

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

public class MainPage230501Test {
    MainPage230501 mainPage230501 = new MainPage230501();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite230501  = new TramitesFirmasLG(
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
    public void Proceso230501() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen230501");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion230501");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion230501");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen230501");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion230501");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion230501");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite230501);
            mainPage230501.selecRol.sendKeys("Persona Moral");
            mainPage230501.btnacep.click();
            mainPage230501.Tramites.sendKeys("Solicitudes nuevas");
            mainPage230501.SoliNew.click();
            mainPage230501.SEMARNAT.click();
            mainPage230501.linkCertificadosLicenciasPermisos.click();
            mainPage230501.linkSEMARNAT.click();
            mainPage230501.linkAutExpMatPel.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230501.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230501.labelDatosSolicitud.click();
            mainPage230501.inputDeclaracion.click();
            mainPage230501.inputfraccion.sendKeys("29312001");
//            mainPage230501.checkMaterial.click();
//            mainPage230501.inputCompuestoMercurio.sendKeys("Sulfuro de Mercurio");
            mainPage230501.inputNumCAS.sendKeys("4342-36-3");
//            mainPage230501.inputConstanciaCISEN.sendKeys("1234");
            mainPage230501.btnAgregarCAS.click();
            mainPage230501.inputNombreComun.sendKeys("TEST");
            mainPage230501.inputNombreComercial.sendKeys("PROTEO");
            mainPage230501.inputEstadoFisicoMental.sendKeys("Solido");
            mainPage230501.inputCantidad.sendKeys("5000");
            mainPage230501.inputUnidadMedida.sendKeys("Litro");
            mainPage230501.inputLicenciaSanitaria.sendKeys("12348765");
            mainPage230501.inputUsoEspecificoExportacion.sendKeys("Test");
            Selenide.executeJavaScript("arguments[0].value = '18/06/2025';",mainPage230501.inputFechaPrevista);sleep(100);
//            mainPage230501.inputDestinoFinal.sendKeys("ALEMANIA");
            mainPage230501.btnAgregarMercancias.click();
            mainPage230501.inputComponenteMaterial.sendKeys("1234");
            mainPage230501.inputPorcentajeConcentracion.sendKeys("25");
            mainPage230501.inputAgregarModalComponente.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230501.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230501.labelTercerosRelacionados.click();
            mainPage230501.inputAgregarDestinatario.click();
            mainPage230501.inputTipoPeronaMoral.click();
            //mainPage230501.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage230501.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage230501.terceroEstado.sendKeys("ALEMANIA");
            mainPage230501.terceroCodigoPostal.sendKeys("06278");
            mainPage230501.terceroLocalidad.sendKeys("CUAUHTEMOC");
            mainPage230501.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage230501.terceroNumExterior.sendKeys("123");
            mainPage230501.terceroNumInterior.sendKeys("4B");
            mainPage230501.terceroLada.sendKeys("4B");
            mainPage230501.terceroTelefono.sendKeys("5555555555");
            mainPage230501.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage230501.btnGuardarDatosTercero.click();

            mainPage230501.btAgregarRepresentante.click();
            mainPage230501.inputTipoPeronaMoral.click();
            mainPage230501.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage230501.terceroEstado.sendKeys("ALEMANIA");
            mainPage230501.terceroCodigoPostal.sendKeys("06278");
            mainPage230501.terceroLocalidad.sendKeys("CUAUHTEMOC");
            mainPage230501.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage230501.terceroNumExterior.sendKeys("123");
            mainPage230501.terceroNumInterior.sendKeys("4B");
            mainPage230501.terceroLada.sendKeys("4B");
            mainPage230501.terceroTelefono.sendKeys("5555555555");
            mainPage230501.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage230501.btnGuardarDatosTercero.click();

            mainPage230501.btnAgregarUsuario.click();
            mainPage230501.inputTipoPeronaMoral.click();
            mainPage230501.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage230501.terceroEstado.sendKeys("ALEMANIA");
            mainPage230501.terceroCodigoPostal.sendKeys("06278");
            mainPage230501.terceroLocalidad.sendKeys("CUAUHTEMOC");
            mainPage230501.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage230501.terceroNumExterior.sendKeys("123");
            mainPage230501.terceroNumInterior.sendKeys("4B");
            mainPage230501.terceroLada.sendKeys("4B");
            mainPage230501.terceroTelefono.sendKeys("5555555555");
            mainPage230501.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage230501.tercerosUso.sendKeys("Producción");
mainPage230501.terceroDescripcionUso.sendKeys("TEST");
mainPage230501.btnAgregarUsoFinal.click();
            mainPage230501.btnGuardarDatosTercero.click();
//PAGO
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230501.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230501.labelPagoDerechos.click();
            mainPage230501.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage230501.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/06/2025';",mainPage230501.inputSolicitudPagoLlave2);sleep(100);
            mainPage230501.inputGuardarSolicitud.click();
            mainPage230501.inputGuarda.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage230501.btnAnexar.click();sleep(8000);
            Selenide.sleep(4000);
            mainPage230501.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage230501.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite230501);
            Selenide.sleep(2000);
            String folioText = mainPage230501.folio.getText();sleep(5000);
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