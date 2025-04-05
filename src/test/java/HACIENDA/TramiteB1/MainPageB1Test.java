package HACIENDA.TramiteB1;

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

public class MainPageB1Test {
    MainPageB1 mainPageB1 = new MainPageB1();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramiteB1 = new TramitesFirmasLG(
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

        loginFirmSoli.login(tramiteB1);
        mainPageB1.selecRol.sendKeys("Persona Moral");
        mainPageB1.btnacep.click();
        mainPageB1.Tramites.sendKeys("Solicitudes nuevas");
        mainPageB1.SoliNew.click();
        mainPageB1.hacienda.click();
        mainPageB1.linkAvisosAgaSat.click();
        mainPageB1.B1.click();

        //Compensación que aplica por
        mainPageB1.linkDetalle.click();
        mainPageB1.selectSolicitudIdeGenerica.sendKeys("Cambio de facturas");

        //Datos del pedimento original
        mainPageB1.fechaPagoPedimento1.pressEnter().sendKeys("14/11/2024");
        mainPageB1.patente1.setValue("3904");
        mainPageB1.aduana1.sendKeys("800 - COLOMBIA");
        mainPageB1.documento1.sendKeys("3101655");
        mainPageB1.impuestoGI1.sendKeys("111111111111111");
        mainPageB1.dta1.sendKeys("111111111111111");
        mainPageB1.cuotaComp1.sendKeys("111111111111111");
        mainPageB1.claveComer1.sendKeys("A1");

        //Datos del pedimento de rectificación o desistimiento
        mainPageB1.fechaPagoPedimento2.pressEnter().sendKeys("16/11/2024");
        mainPageB1.patente2.setValue("3904");
        mainPageB1.aduana2.sendKeys("800 - COLOMBIA");
        mainPageB1.documento2.setValue("3101655");
        mainPageB1.impuestoGI2.setValue("111111111111111");
        mainPageB1.dta2.sendKeys("111111111111111");
        mainPageB1.cuotaComp2.sendKeys("111111111111111");
        mainPageB1.chaveComer2.sendKeys("B2");

        //Importes suceptibles de compensación
        mainPageB1.fechaPagoPedimento3.pressEnter().sendKeys("18/11/2024");
        mainPageB1.patente3.setValue("3904");
        mainPageB1.aduana3.sendKeys("800 - COLOMBIA");
        mainPageB1.documento3.sendKeys("3101655");
        mainPageB1.noComp.sendKeys("111111111111111");

        //Importe compensado I G I
        mainPageB1.historico1.setValue("111111111111111");
        mainPageB1.actualizado1.setValue("111111111111112");

        //Importe compensado
        mainPageB1.cuotaComp3.setValue("111111111111112");

        //Importe compensado D T A
        mainPageB1.historico2.setValue("111111111111112");
        mainPageB1.actualizado2.setValue("111111111111112");
        mainPageB1.igi.setValue("111111111111112");
        mainPageB1.dta3.setValue("111111111111112");
        mainPageB1.cuotaComp4.setValue("111111111111112");
        mainPageB1.btnCont.click();

        //Requisitos obligatorios
        mainPageB1.btnContCarDoc.click();
        mainPageB1.btnAdjDoc.click();
        mainPageB1.doc1.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPageB1.doc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPageB1.doc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPageB1.doc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPageB1.doc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPageB1.btnAdjuntar.click();
        try {
            System.out.println("Entrando al timer");
            Thread.sleep(15000);
            mainPageB1.btnCerrar.click();
            System.out.println("Saliendo del timer");
            mainPageB1.btnContPreFirm.click();
            loginFirmSoli.firma(tramiteB1);
        } catch (InterruptedException e) {
            System.out.println("no entro");
            throw new RuntimeException(e);
        }
            // Obtener el texto del folio desde MainPageB1
            String folioText = mainPageB1.folio.getText();
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
