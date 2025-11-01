package Economia.Tramite110102;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110102Test {
    MainPage110102 mainPage110102 = new MainPage110102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite110102  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso110102() throws IOException {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite110102); sleep(1000);
            mainPage110102.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110102.btnacep.click(); sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Secretaría de Economía']").click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Certificados de Origen")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Registro de Productos Elegibles para Preferencias y Concesiones Arancelarias para la Obtención de Certificados de Origen")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Para la UE, la AELC, la ALADI, Alianza del Pacífico, SGP, TLC Panamá, Acuerdo Perú, Acuerdo Japón y TLC Uruguay; o para la obtención del carácter de exportador autorizado para la UE, la AELC o el Acuerdo Japón, para comercializador.")).click();sleep(1000);
            metodos.scrollDecremento(2);
            mainPage110102.DatosMercanc.click();
            mainPage110102.RegistroProductor.sendKeys("254023028909");
            mainPage110102.BuscarProductos.click();
            mainPage110102.EntidadFede.sendKeys("SINALOA");
            mainPage110102.RepresentacionFederal.sendKeys("CULIACAN");
            mainPage110102.DeclaracionesManifiestoDeclaracion.click();
            mainPage110102.inputContinuarSoli.click();
            loginFirmSoli.firma(tramite110102);sleep(3000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110102.folio.getText();

            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(3000);

            ConfirmarNotificacion(folioNumber);

        }, repeticiones);
    }

    // Proceso de Confirmar Notificación
    public void ConfirmarNotificacion(String folioNumber) {
        initDriver();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(2000);
        loginFirmSoli.login(tramite110102);sleep(3000);
        mainPage110102.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage110102.Btnacep.click();
        mainPage110102.inicioFolio.sendKeys(folioNumber);sleep(2000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(2000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(2000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(2000);
        loginFirmSoli.firma(tramite110102);sleep(1000);sleep(2000);
        System.out.println("Proceso de Confirmar Notificación completado para el folio: " + folioNumber);
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

