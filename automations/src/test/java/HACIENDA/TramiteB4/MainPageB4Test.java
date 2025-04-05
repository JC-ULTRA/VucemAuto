package HACIENDA.TramiteB4;

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

public class MainPageB4Test {
    MainPageB4 mainPageB4 = new MainPageB4();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramiteB4 = new TramitesFirmasLG(
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
    public void Procesob4() {

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
            //Firma y Path del Trámite
            loginFirmSoli.login(tramiteB4);
            mainPageB4.selecRol.sendKeys("Persona Moral");
            mainPageB4.btnacep.click();
            mainPageB4.Tramites.sendKeys("Solicitudes nuevas");
            mainPageB4.SoliNew.click();
            mainPageB4.hacienda.click();
            mainPageB4.linkAvisosAgaSat.click();
            mainPageB4.B4.click();
            mainPageB4.tipoAviso.click();

            //Aviso
            mainPageB4.nRegister.setValue("A222222222222222222222222");

            //Datos del Donante Exterior
            mainPageB4.nomDomRSocial.setValue("Esto es una prueba 1");
            mainPageB4.rcfFax.setValue("AAL0409235E6");
            mainPageB4.tel.setValue("2841028899");
            mainPageB4.mail.setValue("Prueba@gmail.com");

            //Domicilio Fiscal del Donante Extranjero
            mainPageB4.entidadFed.sendKeys("MÉXICO");
            mainPageB4.alcalMun.sendKeys("CHALCO");
            mainPageB4.colonia.sendKeys("CENTRO");
            mainPageB4.codPost.setValue("95270");
            mainPageB4.calle.setValue("calle de prueba calle 2");
            mainPageB4.numLetEx.setValue("A1");
            mainPageB4.numLetInt.setValue("B2");
            mainPageB4.entreCalle1.setValue("entre calle 1");
            mainPageB4.entreCalle2.setValue("entre calle 2");

            //Carga Plantilla
            mainPageB4.checkCarMas.click();
            mainPageB4.cargaDocMas.sendKeys("C:\\VucemAuto\\RepoN\\src\\test\\resources\\plantilla_Aviso_6904_B4.xlsx");
            mainPageB4.btnCarga.click();
            mainPageB4.btnConti1.click();
            mainPageB4.btnConti2.click();


            //Carga doc y firma
            mainPageB4.adjuntDoc.click();
            mainPageB4.doc1.sendKeys("C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPageB4.doc2.sendKeys("C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPageB4.btnADJ.click();
//            mainPageB4.btnCerrar.click();
//            mainPageB4.btnConti3.click();

            try {
                System.out.println("Entrando al timer");
                Thread.sleep(10000);
                mainPageB4.btnCerrar.click();
                System.out.println("Saliendo del timer");
                mainPageB4.btnConti3.click();
                loginFirmSoli.login(tramiteB4);
            } catch (InterruptedException e) {
                System.out.println("no entro");
                throw new RuntimeException(e);
            }
            // Obtener el texto del folio desde MainPageB4
            String folioText = mainPageB4.folio.getText();
            // Llamar al metodo para obtener el folio
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

