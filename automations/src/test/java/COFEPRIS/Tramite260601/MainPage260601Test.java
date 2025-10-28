package COFEPRIS.Tramite260601;

import COFEPRIS.Tramite260601.MainPage260601;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260601Test {
    MainPage260601 mainPage260601 = new MainPage260601();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260601 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260601Fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
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
    public void Proceso260601() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260601");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260601");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260601");

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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260601);
            mainPage260601.selecRol.sendKeys("Persona Moral");
            mainPage260601.btnacep.click();
            mainPage260601.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260601.SoliNew.click();
            mainPage260601.Cofepris.click();
            mainPage260601.linkCertificadosLicenciasPermisos.click();
            mainPage260601.linkAvisoSanitario.click();
            mainPage260601.linkAvisoSanitarioImportaProd.click();
            //DATOS SOLICITUD
            mainPage260601.labelDatosSolicitud.click();
            mainPage260601.inputEstablecimiento.click();
            mainPage260601.btnAceptar.click();
            mainPage260601.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260601.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260601.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260601.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260601.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260601.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260601.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260601.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260601.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260601.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260601.inputScianAgregar.click();
            mainPage260601.comboSCIAN.selectOption("614041");
            mainPage260601.inputAgregar.click();
            mainPage260601.inputAvisoFuncionamiento.click();
            mainPage260601.solicitudRegimen.sendKeys("Definitivos");
            mainPage260601.aduanaEntrada.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage260601.inputAgregarAduana.click();
            mainPage260601.selectClasificacionProducto.sendKeys("JUGUETES");
            mainPage260601.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260601.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260601.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260601.selectTipoProductoTipoTramite.sendKeys("Producto a granel");
            mainPage260601.inputFraccionArancelaria.sendKeys("96092099");
            mainPage260601.inputModelo.sendKeys("PRUEBA");
            mainPage260601.inputDescProd.sendKeys("PRUEBA");
            mainPage260601.buttonAbrirPanelPaisesOrigen.click();
            mainPage260601.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260601.inputAgregarSeleccion.click();
            mainPage260601.inputAbrirPanelPaisesProcedencia.click();
            mainPage260601.PaisProcedencia.selectOptionContainingText("ARABIA SAUDITA (REINO DE)");
            mainPage260601.inputAgregarSeleccion2.click();
            mainPage260601.botonAbrirPanelUsosEspecificos.click();
            mainPage260601.UsoEspecifico.sendKeys("FABRICACIÓN");
            mainPage260601.botonAgregarSeleccion.click();
            mainPage260601.inputAgregarMercancia.click();
            mainPage260601.inputDeclaracion.click();
            mainPage260601.inputInformacionConfidencialNo.click();
            mainPage260601.inputRepresentanteLegalRFC.sendKeys("MAVL621207C95");
            mainPage260601.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000);
                mainPage260601.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260601.labelTerceroRElacionado.click();
            //PROVEEDOR
            mainPage260601.inputAgregarProveedor.click();
            mainPage260601.inputNacionalidadextranjera.click();
            mainPage260601.inputTipoPeronaMoral.click();
            mainPage260601.inputTerceroRazonSocial.sendKeys("PEDRO PRUEBAS");
            mainPage260601.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260601.terceroEstadoLocalidad.sendKeys("LUXEMBURGO");
            mainPage260601.terceroCodigoPostal.sendKeys("00000");
            mainPage260601.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260601.terceroNumExterior.sendKeys("123");
            mainPage260601.terceroNumInterior.sendKeys("4B");
            mainPage260601.terceroTelefono.sendKeys("5555555555");
            mainPage260601.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260601.btnGuardarDatosTercero.click();
            //FABRICANTE
            mainPage260601.inputAgregarFabricante.click();
            mainPage260601.inputNacionalidadMexicana2.click();
            mainPage260601.inputPErsonaMoral2.click();
            mainPage260601.inputTerceroRFC2.sendKeys("AFC000526BJ2");
            mainPage260601.inputBuscarEmpresa2.click();
            mainPage260601.btnGuardarDatosTercero2.click();
            mainPage260601.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260601.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage260601.btnAnexar.click();sleep(20000);
            mainPage260601.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260601.btnCerrar.click();
            mainPage260601.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260601);
            String folioText = mainPage260601.folio.getText();sleep(5000);
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
    public void ProcesoGenerarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite260601Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260601.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260601.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260601.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260601Fun);sleep(5000);
    }

    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260601.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260601.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260601.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260601Fun);sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260601.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260601.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260601.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260601Fun);sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260601);
        mainPage260601.selecRol.sendKeys("Persona Moral");
        mainPage260601.btnacep.click();
        mainPage260601.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260601.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260601);sleep(4000);
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
