package HACIENDA.Tramite303;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage303Test {
    MainPage303 mainPage303 = new MainPage303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite303  = new TramitesFirmasLG(
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
    public void Proceso303() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen303");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion303");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion303");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen303");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion303");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion303");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite303);
            mainPage303.selecRol.sendKeys("Persona Moral");
            mainPage303.btnacep.click();
            mainPage303.Tramites.sendKeys("Solicitudes nuevas");
            mainPage303.SoliNew.click();
            mainPage303.Hacienda.click();
            mainPage303.linkResgistroComercioExterior.click();
            mainPage303.linkRegistroDelDespachoMercanc.click();
            mainPage303.labelDespachoMercanc.click();
            mainPage303.inputPregunta.click();
            //mainPage303.inputPregunta2.click();
            mainPage303.inputPregunta3.click();
            //mainPage303.inputPregunta4.click();
            //mainPage303.inputPregunta5.click();
            mainPage303.inputPregunta6.click();
            mainPage303.inputPregunta7.click();
            //mainPage303.inputPregunta8.click();
            //mainPage303.inputPregunta9.click();
            mainPage303.inputPregunta10.click();
            mainPage303.inputPregunta11.click();
            //mainPage303.inputPregunta12.click();
            mainPage303.inputConProgramaImmex.click();
            //mainPage303.inputSinProgramaImmex.click();
            mainPage303.selectSolicitudResolucion.sendKeys("5-2025"); // puedes cambiar el texto
            mainPage303.selectComboAgenteApoderado.sendKeys("Agente Aduanal");
            mainPage303.inputAgregarAgente.click();
            mainPage303.inputNumPatenteModal.sendKeys("1001");
            mainPage303.inputCheckObligFisc.click();
            mainPage303.inputCheckAutPantente.click();
            mainPage303.inputBtncargarPatente.click();
            mainPage303.inputAgregarAgente2.click();
            //DATOS
            mainPage303.inputAgregarTransportista.click();
            mainPage303.inputTransportista.sendKeys("MAVL621207C95");
            mainPage303.inputBuscar.click();
            mainPage303.inputRegistroTransportista.click();
            //mainPage303.inputPregSusp.click();
            mainPage303.inputPregSusp2.click();
            mainPage303.inputInventario.click();
            //mainPage303.inputInventario2.click();
            mainPage303.inputNombreInventario.sendKeys("PRUEBA");
            mainPage303.inputLugarInventario.sendKeys("México");
            mainPage303.inputAnexoInventario.click();
            mainPage303.inputAgregarInventario.click();
            mainPage303.buttonAceptar.click();
            //mainPage303.aceptado.click();
            //mainPage303.inputContabilidad.click();
            mainPage303.inputContabilidad2.click();
            mainPage303.inputInfoContable.click();
            //mainPage303.inputInfoContable2.click();
            //mainPage303.inputQuerella.click();
            mainPage303.inputQuerella2.click();
            mainPage303.inputListaDeclaraciones.click();
            mainPage303.inputListaDeclaraciones2.click();
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage303.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TERCEROS
            mainPage303.inputTerceroRelacionado.click();
            mainPage303.inputTercero.sendKeys("LEQI8101314S7");
            mainPage303.inputBuscar2.click();
            mainPage303.buttonAceptar2.click();
            mainPage303.inputAgregarEnlaceOperativo.click();
            mainPage303.input.sendKeys("LEQI8101314S7");
            mainPage303.inputBuscarEnlaceOperativo.click();
            mainPage303.inputTerceroEnlaceOperativoPuesto.sendKeys("QA");
            mainPage303.inputAceptarEnlace.click();
            // PAGO DE DERECHOS
            mainPage303.labelPagoDerechos.click();
            mainPage303.selectSolicitudPagoBancoClave.sendKeys("BANBAJIO");
            mainPage303.inputSolicitudPagoLlave.sendKeys(llavePago);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage303.inputCalendar); sleep(1000);
            // CONTINUAR
            mainPage303.inputSolicitud.click();
            // CARGAR ARCHIVOS
            mainPage303.inputContinuar.click();
            mainPage303.inputAdjuntarDocumentos.click();
            mainPage303.selectDoc.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage303.selectDoc2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage303.selectDoc3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage303.btnAdjuntar.click();sleep(4000);
            mainPage303.btnCerrar.click();
            // SIGUIENTE
            mainPage303.inputSiguienteButton.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite303);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage303.folio.getText();
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