package Economia.Tramite110204;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110204.MainPage110204;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110204Test {
    MainPage110204 mainPage110204 = new MainPage110204();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    TramitesFirmasLG tramite110204  = new TramitesFirmasLG(
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
    public void Proceso110204() throws IOException {
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
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 7;
            String FacturaGenerada = uuid.replace("-", "").substring(0, longitudDeseada);
            loginFirmSoli.login(tramite110204); sleep(1000);
            mainPage110204.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage110204.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Secretaría de Economía']").click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Certificados de Origen")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Validación de Certificados de Origen")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Validar inicialmente el certificado de origen para la exportación de mercancías a los países miembros de la ALADI")).click();sleep(15000);

            //Datos de la mercancia
            metodos.scrollDecremento(2);
            mainPage110204.tabCertificadoOrigen.click();
            mainPage110204.TratadoAcuerdo.sendKeys("Acuerdo de Complementación Económica No. 6 México-Argentina");
            mainPage110204.PaisBloque.sendKeys("argentina (REPUBLICA)");
            mainPage110204.btnBuscarmercancia.click();
            mainPage110204.filaMercanciaDisponible.doubleClick();


            //Agregar datos Mercancia
            mainPage110204.Cantidad.sendKeys("24");
            mainPage110204.selectUMC.sendKeys("Kilogramo");
            mainPage110204.ValorMercancia.sendKeys("1000");
            mainPage110204.ComplementoDescripcion.sendKeys("QA Descripcion");

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage110204.fechaFactura, fechaHoy);

            mainPage110204.NumeroFactura.sendKeys(FacturaGenerada);
            mainPage110204.selectTipoFactura.sendKeys("Manual");
            mainPage110204.btnAgregarDatosMercancia.click();
            mainPage110204.btnAceptarNotficacionAgrMercancia.click();

            //Datos certificado
            mainPage110204.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110204.tabDatosCertificado.click();
            mainPage110204.Observaciones.sendKeys("QA Observaciones");
            mainPage110204.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110204.selectEstado.sendKeys("SINALOA");

            mainPage110204.btnContinuar.click();
            loginFirmSoli.firma(tramite110204);sleep(3000);
            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110204.folio.getText();
            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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

