package MedioAmbiente.Tramite231002;

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

public class MainPage231002Test {
    MainPage231002 mainPage231002 = new MainPage231002();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite231002 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite231002F  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );
    TramitesFirmasLG tramite231002Afc  = new TramitesFirmasLG(
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
    public void Proceso231002() {
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
            loginFirmSoli.login(tramite231002);
            mainPage231002.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage231002.btnacep.click(); sleep(1000);
            mainPage231002.Tramites.click(); sleep(1000);
            mainPage231002.SoliNew.click(); sleep(1000);
            mainPage231002.SEMARNAT.click(); sleep(1000);
            mainPage231002.CertLicPerm.click(); sleep(1000);
            mainPage231002.Semart721.click(); sleep(1000);
            mainPage231002.Tramite231002.click(); sleep(1000);
            mainPage231002.DatosSoli.click(); sleep(1000);
            mainPage231002.retornoPrimeraVez.click();
            mainPage231002.numRegistroAmbiental.sendKeys("8646516546512");
            mainPage231002.giroImportador.sendKeys("PRUEBAS QA ULTARASIST");
            mainPage231002.numIMMEX.sendKeys("0200800100120252540000001");
            mainPage231002.btnAgregarResiduoRetorno.click();
            mainPage231002.residuoMateriaPrima.click();
            mainPage231002.numBitacora.sendKeys("E5/00000003/10/2022");
            mainPage231002.btnBuscarBitacora.click();sleep(1000);
            mainPage231002.nombreMateriaPrima.click();
            mainPage231002.nombreMateriaPrima.sendKeys("Plastico");sleep(1000);
            metodos.scrollIncremento(1);
            mainPage231002.btnArgregarMateriaPrima.click();
            mainPage231002.fraccionArancelaria.sendKeys("25241003");
            mainPage231002.nico.sendKeys("00");;
            mainPage231002.nombreResiduoPeligroso.sendKeys("tratamiento peligroso");
            mainPage231002.cantidad.sendKeys("10");
            mainPage231002.unidadMedida.sendKeys("Tonelada");
            mainPage231002.tipoClave.click();
            mainPage231002.claveResiduo.sendKeys("E1044");
            mainPage231002.creti.sendKeys("Corrosivo");
            mainPage231002.estadoFisico.sendKeys("Semisolido");
            mainPage231002.numManifiesto.sendKeys("982167732");
            mainPage231002.tipoContenedor.sendKeys("Bidón");
            mainPage231002.capacidad.sendKeys("10");
            mainPage231002.btnAgregarMercancia.click();sleep(1000);
            mainPage231002.transportista.sendKeys("Transportista Pruebas");
            mainPage231002.numAutorizacionSemarnat.sendKeys("66513757");
            mainPage231002.requiereOtraEmpreza.click();
            mainPage231002.empresaRetorno.sendKeys("Empresa de prueba");
            mainPage231002.representanteRetorno.sendKeys("DIEGO DIAZ DIAZ");
            mainPage231002.telefonoRetorno.sendKeys("0123456789");
            mainPage231002.correoRetorno.sendKeys("pruebas@pruebas.qa");
            mainPage231002.aduanaSalida.sendKeys("ADUANA DE PATANCO");
            mainPage231002.precausionesRegistro.sendKeys("Elemento corrosivo manejese con cuidado");
            mainPage231002.nombreDestintario.sendKeys("DESTINATARIO PRUEBAS");
            mainPage231002.paisDestino.sendKeys("ANGUILA");
            mainPage231002.domicilioDestino.sendKeys("DOMICILIO DESTINO");
            mainPage231002.codigoPostalDestino.sendKeys("00000");
            mainPage231002.btnGuardarSoli.click();
            loginFirmSoli.firma(tramite231002);sleep(4000);
            String folioText = mainPage231002.folio.getText();
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
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados231002.txt";

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