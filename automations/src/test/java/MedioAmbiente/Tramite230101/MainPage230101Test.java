package MedioAmbiente.Tramite230101;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage230101Test {
    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
    MainPage230101 mainPage230101 = new MainPage230101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite230101 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite230101Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000;
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso230101() throws IOException {
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen230101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion230101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion230101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");


        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite

            loginFirmSoli.login(tramite230101); sleep(1000);
            mainPage230101.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage230101.btnacep.click(); sleep(1000);
            mainPage230101.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage230101.SoliNew.click(); sleep(1000);
            mainPage230101.MedioAmbiente.click(); sleep(1000);
            mainPage230101.CertLicenciasPermisos.click(); sleep(1000);
            mainPage230101.RequisitosFito.click(); sleep(1000);
            mainPage230101.CertFitoImport.click(); sleep(1000);

                        //Datos de la mercancia
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainPage230101.DatosSolicitud.click(); sleep(1000);
            mainPage230101.TipoRegimen.click(); sleep(1000);
            mainPage230101.optionAcapulcoAeropuerto.click(); sleep(1000);
            mainPage230101.AddlistaOrigen1.click(); sleep(1000);
            mainPage230101.optionAeropuertoIntMexico.click(); sleep(1000);
            mainPage230101.AddlistaOrigen2.click(); sleep(1000);
            mainPage230101.selectTipoProducto.sendKeys("Maderable.");
            mainPage230101.optionAlbaniaRepublica.click(); sleep(1000);
            mainPage230101.AddlistaOrigen.click(); sleep(1000);
            mainPage230101.selectPaisProcedencia.sendKeys("ARGENTINA (REPUBLICA)");

            //Destino dentro del pais
            mainPage230101.optionVeracruz.click(); sleep(1000);
            mainPage230101.inputAddlistaOrigen.click(); sleep(1000);
            mainPage230101.TodoTerritorio.click();
            mainPage230101.optionFraccionesNicas.click(); sleep(1000);
            mainPage230101.AgregarMercancias.click(); sleep(1000);
            mainPage230101.FraccionArancelaria.sendKeys("46021101");
            mainPage230101.inputCantidadUmc.sendKeys("100");
            mainPage230101.selectMercanciaGenero.sendKeys("Agave");
            mainPage230101.selectMercanciaEspecie.sendKeys("montana");
            mainPage230101.NombreComun.sendKeys("Maguey verde");
            mainPage230101.AgregarDetalleMercancias.click();
            mainPage230101.inputAgregarMercancia.click();sleep(1000);
            mainPage230101.selectDescripcionProducto.sendKeys("ESTERILLAS, ESTERAS Y CAÑIZOS, DE MATERIA VEGETAL, NUEVOS SIN RECUBRIMIENTO");
            mainPage230101.optionKilogramo.click();
            mainPage230101.inputDeclaracion.click();

            //Pestaña Pago de Derechos
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230101.PagoDerechos.click(); sleep(1000);
            mainPage230101.BancoClave.sendKeys("HSBC");
            mainPage230101.inputPagoLlave.sendKeys(llavePago);
            mainPage230101.inputCalendar.sendKeys("06/03/2025");
            mainPage230101.inputGuardarSolicitud.click(); sleep(1000);
            mainPage230101.pasarDocs.click();
            metodos.cargarDocumentos();
            mainPage230101.btnAdjuntar.click();
            mainPage230101.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));
            mainPage230101.btnCerrar.click();
            mainPage230101.btnPasarFirma.click();
            loginFirmSoli.firma(tramite230101);
            String folioText = mainPage230101.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")) {
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    ProcesoVerificarDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                    if (selectedMethods.contains("ProcesoAutorizacion")) {
                        ProcesoAutorizarDictamen(folioNumber);
                        System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                            System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }
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
    public void ProcesoGenerarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite230101Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage230101.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage230101.btnBuscarFolioFun.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage230101.requisitosTodos.click();sleep(1000);
        mainPage230101.parrafosTodos.click();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite230101Fun);sleep(5000);
    }
    
    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage230101.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage230101.btnBuscarFolioFun.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite230101Fun);sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage230101.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage230101.btnBuscarFolioFun.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite230101Fun);sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite230101);
        mainPage230101.selecRol.sendKeys("Persona Moral");
        mainPage230101.btnacep.click();
        mainPage230101.inicioFolio.sendKeys(folioNumber);sleep(3500);
        $("input[type='button'][value='Buscar']").click();sleep(3000);
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage230101.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite230101);sleep(4000);
    }
}
