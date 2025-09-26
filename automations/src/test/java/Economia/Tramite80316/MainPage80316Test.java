package Economia.Tramite80316;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage80316Test {
    MainPage80316 mainPage80316 = new MainPage80316();
    Metodos metodos = new Metodos();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    TramitesFirmasLG tramite80316  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\afc000526bj2.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AFC000526BJ2_1012280944.key"
    );
    TramitesFirmasLG tramite80316Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;
        open(); // Esto usará las capabilities ya configuradas
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    }
    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso80316() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            loginFirmSoli.loginFun(tramite80316Fun);sleep(3000);
            $(By.cssSelector("img[src*='icoOtrasTareas.png']")).click();
            $x("//a[contains(text(),'Otras tareas') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
            $x("//a[contains(text(),'Modificar Programa') and ./span[contains(text(),'[+]')]]").shouldBe(visible).click();
            $x("(//a[contains(text(),'IMMEX') and ./span[contains(text(),'[+]')]])[2]").shouldBe(visible).click();
            $(By.linkText("Modificar Cambio de sector")).shouldBe(visible).click();
            $x("//a[@class='sbSelector' and contains(text(), 'Seleccionar')]").click();
            $x("//ul[@class='sbOptions']//a[text()='Moral']").shouldBe(visible).click();
            mainPage80316.rfc.sendKeys("AAL0409235E6");
            mainPage80316.btnSiguiente.click();
            mainPage80316.folioImmex.doubleClick();
            mainPage80316.modificacionTab.click();
            seleccionarOpcionAleatoriaDiferente();
            mainPage80316.btnGuardarSoli.click();
            mainPage80316.nombreOir.sendKeys("EUROFOODS DE MÉXICO");
            mainPage80316.apellidoPaternoOir.sendKeys("Gonzalez");
            mainPage80316.apellidoMaternoOir.sendKeys("Pinal");
            mainPage80316.correoElectronicoOir.sendKeys("Ultrasist@pruebas.com");
            mainPage80316.calleOir.sendKeys("Calle 12");
            mainPage80316.numeroExteriorOir.sendKeys("12");
            mainPage80316.numeroInteriorOir.sendKeys("12");
            mainPage80316.codigoPostalOir.sendKeys("34307");
            mainPage80316.entidadFederativaOir.sendKeys("Durango");
            mainPage80316.municipioOir.sendKeys("Durango");
            mainPage80316.coloniaOir.sendKeys("28 DE SEPTIEMBRE - CP 34307");
            mainPage80316.telefonoOir.sendKeys("2979725632"); sleep(1000);
            mainPage80316.btnGuardarDatosOir.click(); sleep(1000);
            $("[name='guardarRecibirNotificaciones'][type='submit']").shouldBe(visible).click();
            $("[type='button'][value='Siguiente']").shouldBe(visible).click();
            metodos.cargarDocumentos();
            $x("//span[@class='ui-button-text' and text()='Adjuntar']").shouldBe(visible).click(); sleep(4500);
            $("#btnCerrar").shouldBe(visible).click();
            mainPage80316.btnSiguienteFirmar.click();
            loginFirmSoli.firmaFun(tramite80316Fun);sleep(3200);
            String folioText = mainPage80316.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2500);

        }, repeticiones);

    }
    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void seleccionarOpcionAleatoriaDiferente() {
        // 1. Obtener el valor actual y asegurarte de que el elemento es visible
        String valorActual = $("#actividadAnterior").shouldBe(Condition.visible).getValue();

        // 2. Hacer clic en el selector para abrir la lista desplegable
        $x("//a[@class='sbSelector']").click();

        // 3. Obtener todas las opciones
        ElementsCollection opciones = $$x("//ul[@class='sbOptions']/li/a");

        // 4. Crear una lista para almacenar las opciones válidas
        List<SelenideElement> opcionesValidas = new ArrayList<>();

        // 5. Iterar sobre todas las opciones para filtrar las que no coinciden
        for (SelenideElement opcion : opciones) {
            String textoOpcion = opcion.text();
            if (!"Seleccione un valor".equals(textoOpcion) && !valorActual.equals(textoOpcion)) {
                opcionesValidas.add(opcion);
            }
        }

        // Si no hay opciones válidas, se lanza una excepción o se maneja el caso
        if (opcionesValidas.isEmpty()) {
            throw new IllegalStateException("No se encontraron opciones válidas para seleccionar.");
        }

        // 6. Seleccionar una opción aleatoria de la lista filtrada
        Random rand = new Random();
        int indiceAleatorio = rand.nextInt(opcionesValidas.size());
        SelenideElement opcionSeleccionada = opcionesValidas.get(indiceAleatorio);

        // 7. Hacer clic en la opción seleccionada
        opcionSeleccionada.click();
    }

}
