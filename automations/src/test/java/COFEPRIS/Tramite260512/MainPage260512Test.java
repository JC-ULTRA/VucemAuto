package COFEPRIS.Tramite260512;

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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260512Test {
    MainPage260512 mainPage260512 = new MainPage260512();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260512 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260512Fun = new TramitesFirmasLG(
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
    public void Proceso260512() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260512");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260512");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260512");

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
            loginFirmSoli.login(tramite260512);
            mainPage260512.selecRol.sendKeys("Persona Moral");
            mainPage260512.btnacep.click();
            mainPage260512.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260512.SoliNew.click();
            mainPage260512.Cofepris.click();
            mainPage260512.linkCertificadosLicenciasPermisos.click();
            mainPage260512.linkPermisoImportPlagNutriVegTox.click();
            mainPage260512.linkPermisoImportacionSustanciasToxicas.click();
            //DATOS SSOLICITANTE
            mainPage260512.labelDatosSolicitud.click();
            mainPage260512.inputEstablecimiento.click();
            mainPage260512.buttonAceptar.click();
            mainPage260512.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260512.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260512.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260512.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260512.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260512.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260512.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260512.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260512.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260512.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260512.inputScianAgregar.click();
            mainPage260512.comboSCIAN.selectOption("434230"); //148
            mainPage260512.inputAgregar.click();
            //mainPage260512.inputAvisoFuncionamiento.click();
            mainPage260512.inputLicenciaSanitaria.sendKeys("46456456");
            mainPage260512.inputAduanEntradaDispo.sendKeys("CIUDAD ACUÑA");
            mainPage260512.inputAgregarAduanaEntrada.click();
            //mainPage260512.solicitudRegimen.sendKeys("Definitivos");
            //mainPage260512.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260512.inputAgregarAduana.click();
            mainPage260512.inputNombreComercial.sendKeys("QA");
            mainPage260512.inputNombrecomun.sendKeys("QA");
            mainPage260512.inputNombreCientifico.sendKeys("QA");
            mainPage260512.inputUsoEspecifico.sendKeys("QA");
            //mainPage260512.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            //mainPage260512.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260512.selectFormaFarmaceutica.selectOptionContainingText("Polvo");
            mainPage260512.selectEstadoFisico.selectOptionContainingText("Gaseoso");
            mainPage260512.inputFraccionArancelaria.sendKeys("29121201");
            mainPage260512.inputCantidadUMT.sendKeys("100");
            mainPage260512.inputCantidadUMC.sendKeys("10");
            mainPage260512.selectUnidadMedidaComercial.sendKeys("Bulto");
            mainPage260512.inputCas.sendKeys("4566");
            mainPage260512.inputPorcentajeConcen.sendKeys("45");
            mainPage260512.buttonAbrirPanelPaisesOrigen.click();
            mainPage260512.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260512.inputAgregarSeleccion.click();
            mainPage260512.inputAbrirPanelPaisesProcedencia.click();
            mainPage260512.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260512.inpiutAgregarPais.click();
            mainPage260512.inputClasifToxi.sendKeys("I EXTREMADAMENTE TOXICO");
            mainPage260512.inputObjetoImport.sendKeys("Formulación");
            //mainPage260512.UsoEspecifico.sendKeys("VENTA O COMERCIALIZACIÓN");
            //mainPage260512.botonAgregarSeleccion.click();
            mainPage260512.inputAgregarMercancia.click();
            mainPage260512.inputDeclaracion.click();
            mainPage260512.inputInformacionConfidencialNo.click();
            mainPage260512.inputRepresentanteLegalRFC.sendKeys("ZURA6808202RA");
            mainPage260512.inputConsultarIDC.click();
            //PAGO DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260512.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260512.labelPagoDerechos.click();
            mainPage260512.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260512.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260512.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260512.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260512.inputCalendar);sleep(100);
            mainPage260512.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260512.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260512.inputGuarda.click();
            metodos.cargarDocumentos();
            mainPage260512.btnAnexar.click();sleep(20000);
            mainPage260512.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260512.btnCerrar.click();
            mainPage260512.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260512);
            String folioText = mainPage260512.folio.getText();sleep(5000);
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
        loginFirmSoli.loginFun(tramite260512Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260512.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260512.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260512.objetoImportacion.sendKeys("PRUEBAS QA");
        mainPage260512.restricciones.sendKeys("ASEGURAMIENTO DESTINO");
        mainPage260512.componentes.sendKeys("Na");
        mainPage260512.clasificacionToxicologica.sendKeys("I");
        mainPage260512.usoEspecificoMercancia.sendKeys("PRUEBAS");
        mainPage260512.siglasDictaminador.sendKeys("MAVL");
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260512.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260512Fun);sleep(5000);
    }

    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260512.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260512.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260512.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260512Fun);sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260512.numfolio.sendKeys(folioNumber);sleep(2500);
        mainPage260512.btnBuscarFolio.doubleClick();sleep(4500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260512.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260512Fun);sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260512);
        mainPage260512.selecRol.sendKeys("Persona Moral");
        mainPage260512.btnacep.click();
        mainPage260512.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260512.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260512);sleep(4000);
    }


    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void scrollDecremento() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < 5; i++){
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
}