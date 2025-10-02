package MedioAmbiente.Tramite231001;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage231001Test {
    MainPage231001 mainPage231001 = new MainPage231001();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite231001 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite231001F  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );
    TramitesFirmasLG tramite231001Afc  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
    public void Proceso231001() {
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
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite231001);
            mainPage231001.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage231001.btnacep.click(); sleep(1000);
            mainPage231001.Tramites.click(); sleep(1000);
            mainPage231001.SoliNew.click(); sleep(1000);
            mainPage231001.SEMARNAT.click(); sleep(1000);
            mainPage231001.CertLicPerm.click(); sleep(1000);
            mainPage231001.Semart721.click(); sleep(1000);
            mainPage231001.Tramite231001.click(); sleep(1000);
            mainPage231001.DatosSoli.click(); sleep(1000);
            mainPage231001.NumRegAmb.sendKeys("25414"); sleep(1000);
            mainPage231001.Giro.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis p"); sleep(1000);
            mainPage231001.NumIMMEX.sendKeys("0200800100220242540000006"); sleep(1000);
            mainPage231001.BTNAgregarAdmResMat.click(); sleep(1000);
            mainPage231001.NombreMateriaImport.sendKeys("Nombre de la Materia P´rima"); sleep(1000);
            mainPage231001.Cantidad.sendKeys("12"); sleep(1000);
            mainPage231001.UnidadMedida.sendKeys("Tonelada"); sleep(1000);
            mainPage231001.Capitulo.sendKeys("10 - Cereales"); sleep(1000);
            mainPage231001.Partida.sendKeys("05 - Maíz."); sleep(1000);
            mainPage231001.SubPartida.sendKeys("10 - Para siembra."); sleep(1000);
            mainPage231001.FraccArancel.sendKeys("10051001 - Para siembra."); sleep(1000);
            mainPage231001.BTNGuardar.click(); sleep(1000);
            mainPage231001.AduanaEntrada.sendKeys("CD. DEL CARMEN"); sleep(1000);
            mainPage231001.TBNContinuar.click(); sleep(1000);
            loginFirmSoli.firma(tramite231001);sleep(4000);
            String folioText = mainPage231001.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
            guardarFolioEnArchivo(folioNumber);
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

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados231001.txt";

        // Formato de fecha y hora: 2025-07-02 18:45:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(timestamp + " - " + folioNumber);
            writer.newLine();
            System.out.println("Folio guardado correctamente: " + folioNumber);
        } catch (IOException e) {
            System.err.println("Error al guardar el folio: " + e.getMessage());
        }
    }
}