package HACIENDA.TramiteB9;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import static com.codeborne.selenide.Selenide.open;

public class MainPageB9Test {
    MainPageB9 mainPageB9 = new MainPageB9();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramiteB9 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Procesob1() {

//        todo lo que se repetira debe de estar dentro de estas clases
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones",
                JOptionPane.QUESTION_MESSAGE);
        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        ejecutarProcesoNRunnable(() -> {

              loginFirmSoli.login(tramiteB9);
            mainPageB9.selecRol.sendKeys("Persona Moral");
            mainPageB9.btnacep.click();
            mainPageB9.Tramites.sendKeys("Solicitudes nuevas");
            mainPageB9.SoliNew.click();
            mainPageB9.hacienda.click();
            mainPageB9.linkAvisosAgaSat.click();
            mainPageB9.B9.click();

            //Pestaña Tipo Aviso
            mainPageB9.linkTipoAviso.click();
            mainPageB9.NumAutorizacion.sendKeys("123456789");
            mainPageB9.MedioTransporte.sendKeys("Ferrobiario");
            mainPageB9.inputEmbarcacion.sendKeys("Prueba QA");
            //Domicilio del que transfiere la mercancía
            mainPageB9.selectDireccionOrigenEntidad.sendKeys("VERACRUZ");
            mainPageB9.selectDireccionOrigenDelegacion.sendKeys("ALVARADO");
            mainPageB9.selectDireccionOrigenColonia.sendKeys("ALVARADO CENTRO - CP 95270");
            mainPageB9.inputDireccionOrigenCalle.sendKeys("PRUEBAS QA");
            mainPageB9.inputDireccionOrigenNumeroExt.sendKeys("2024");
            mainPageB9.inputDireccionOrigenNumeroInt.sendKeys("123QA");
            mainPageB9.inputDireccionOrigenCP.sendKeys("95270");
            mainPageB9.inputDireccionOrigenNumAuto.sendKeys("123456789987654321");
            mainPageB9.ReferenciaUbicacion.sendKeys("Calle Prueba QA Automatización");
            //Domicilio del que Recibe la mercancía
            mainPageB9.selectDireccionDestinoEntidad.sendKeys("JALISCO");
            mainPageB9.selectDireccionDestinoDelegacion.sendKeys("ACATIC");
            mainPageB9.selectDireccionDestinoColonia.sendKeys("ACATIC - CP 45471");
            mainPageB9.inputDireccionDestinoCalle.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
            mainPageB9.inputDireccionDestinoNumExt.sendKeys("2025");
            mainPageB9.inputDireccionDestinoNumInt.sendKeys("1234 QA");
            mainPageB9.inputDireccionDestinoCP.sendKeys("45471");
            mainPageB9.inputDireccionDestinoNumAuto.sendKeys("9876543210123456789");
            mainPageB9.Observaciones.sendKeys("Pruebas QA Automatización");
            //Bloque Mercancías
            mainPageB9.inputAgregar.click();
            mainPageB9.inputConsecutivo.sendKeys("1");
            mainPageB9.textareaDescripcion.sendKeys("Pruebas QA");
            mainPageB9.inputCantidad.sendKeys("100");
            mainPageB9.selectUnidadMedida.sendKeys("Pieza");
            mainPageB9.inputValor.sendKeys("100");
            mainPageB9.inputCodigoProducto.sendKeys("2024");
            mainPageB9.inputFraccion.sendKeys("1234567890");
            //Btn Agregar
            mainPageB9.inputAgregar2.click();
            //Btn Continuar a Firma
            mainPageB9.inputGuardarSolicitud.click();
            loginFirmSoli.firma(tramiteB9);

            // Obtener el texto del folio desde MainPageB9
            String folioText = mainPageB9.folio.getText();
            //Llamar al metodo para obtener el folio
            obtenerFolio.obtenerFolio(folioText);
//        todo lo que se repetira debe de estar dentro de estas clases
        }, repeticiones);



    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

}
//Prueba final