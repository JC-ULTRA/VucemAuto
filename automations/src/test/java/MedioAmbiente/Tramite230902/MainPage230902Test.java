package MedioAmbiente.Tramite230902;

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
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage230902Test {
    MainPage230902 mainPage230902 = new MainPage230902();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite230902  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite230902Fun  = new TramitesFirmasLG(
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
    public void Proceso230902() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen230902");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion230902");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion230902");

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

        Runnable mercanciaComun = () -> {
            mainPage230902.selectFraccionAran.sendKeys("01022999");
            mainPage230902.textDescripcion.sendKeys("PRUEBA QA");
            mainPage230902.textRendimiento.sendKeys("PRUEBA QA");
            mainPage230902.selectClasificacionTaxo.sendKeys("Plantas");
            mainPage230902.selectNombreCientifico.sendKeys("Barkeria skinneri");
            mainPage230902.selectNombreComun.sendKeys("ORQUIDEA");
            mainPage230902.inputMarca.sendKeys("MARCA QA");
            mainPage230902.inputCantidad.sendKeys("12345");
            mainPage230902.selectUDM.sendKeys("Pieza");
            mainPage230902.selectPaisOrigen.sendKeys("ARGENTINA");
            mainPage230902.selectPaisProcedencia.sendKeys("ANGUILA");
            mainPage230902.inputAgregarMercancia.click();
            mainPage230902.selectMovimientoDisponible.sendKeys("COMERCIAL (T)");
            mainPage230902.btnAgregarSeleccion.click();

        };
        Runnable mercanciaComun2 = () -> {
            mainPage230902.btnAgregarMercancia.click();
            mainPage230902.selectFraccionAran.sendKeys("01029099");
            mainPage230902.textDescripcion.sendKeys("PRUEBA QA");
            mainPage230902.textRendimiento.sendKeys("PRUEBA QA");
            mainPage230902.selectClasificacionTaxo.sendKeys("Plantas");
            mainPage230902.selectNombreCientifico.sendKeys("Barkeria skinneri");
            mainPage230902.selectNombreComun.sendKeys("ORQUIDEA");
            mainPage230902.inputMarca.sendKeys("MARCA QA");
            mainPage230902.inputCantidad.sendKeys("12345");
            mainPage230902.selectUDM.sendKeys("Pieza");
            mainPage230902.inputAgregarMercancia.click();
            mainPage230902.selectMovimientoDisponible.sendKeys("COMERCIAL (T)");
        };
        Runnable procesoComun = () -> {
            //TERCEROS
            mainPage230902.inputEntidadFederativa.sendKeys("MICHOACÁN DE OCAMPO");
            //PAGO DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230902.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230902.labelPagoDerechos.click();
            mainPage230902.selectBanco.sendKeys("BANAMEX");
            //mainPage230902.inputLlavePago.sendKeys("123ASD123");
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage230902.inputLlavePago.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230902.inputFechaPago);sleep(100);
        };

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            //Ingreso y selección de trámite
            loginFirmSoli.login(tramite230902);
            mainPage230902.selecRol.sendKeys("Persona Moral");
            mainPage230902.btnacep.click();
            mainPage230902.Tramites.sendKeys("Solicitudes nuevas");
            mainPage230902.SoliNew.click();
            mainPage230902.MedioAmbiente.click();
            mainPage230902.linkCertificadosLicenciasPermisos.click();
            mainPage230902.linkSEMARNAT08009.click();
            mainPage230902.linkPermisoCITES.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230902.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage230902.labelDatosSolicitud.click();
//            // Mostrar submenú para tipo movimiento
//// Mostrar submenú para tipo movimiento
//            JCheckBox movimiento = new JCheckBox("Importación");
//            JCheckBox movimiento2 = new JCheckBox("Exportación");
//            JCheckBox movimiento3 = new JCheckBox("Diversas Importaciones");
//            JCheckBox movimiento4 = new JCheckBox("Reexportación");
//
//            Object[] opcionesInput1 = {
//                    "Seleccione el tipo de movimiento:",
//                    movimiento, movimiento2, movimiento3, movimiento4
//            };
//
//            int seleccionCampos = JOptionPane.showConfirmDialog(
//                    null,
//                    opcionesInput1,
//                    "TIPO MOVIMIENTO",
//                    JOptionPane.OK_CANCEL_OPTION
//            );

//            if (seleccionCampos == JOptionPane.OK_OPTION) {
//                if (movimiento.isSelected()) {
                    mainPage230902.selectTipoMovimiento.selectOptionByValue("01");
                    mainPage230902.inputTipoRegimen.sendKeys("Temporales");
                    mainPage230902.selectListaOrigen.sendKeys("COATZACOALCOS, VER.");
                    mainPage230902.inputAgregarLista.click();
                    mainPage230902.btnAgregarMercancia.click();
                    mercanciaComun.run();
                    //TERCEROS
                    try {
                        Thread.sleep(2000); // Pausa de 3 segundos
                        // Hacer scroll hasta el elemento
                        mainPage230902.Scrol.scrollIntoView(true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mainPage230902.labelTerceros.click();
                    mainPage230902.inputEntidadFederativa.sendKeys("MICHOACÁN DE OCAMPO");
                    //PAGO DERECHOS
                    try {
                        Thread.sleep(2000); // Pausa de 3 segundos
                        // Hacer scroll hasta el elemento
                        mainPage230902.Scrol.scrollIntoView(true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mainPage230902.labelPagoDerechos.click();
                    mainPage230902.selectBanco.sendKeys("BANAMEX");
                    //mainPage230902.inputLlavePago.sendKeys("123ASD123");
                    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    StringBuilder factura = new StringBuilder();
                    Random random = new Random();

                    for (int i = 0; i < 10; i++) {
                        factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
                    }
                    mainPage230902.inputLlavePago.setValue(factura.toString());
                    Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230902.inputFechaPago);sleep(100);

//                }
//
//                if (movimiento2.isSelected()) {
//                    mainPage230902.selectTipoMovimiento.selectOptionByValue("02");
//                    mainPage230902.inputTipoRegimen.sendKeys("Temporales");
//                    mainPage230902.selectListaOrigen2.sendKeys("COATZACOALCOS, VER.");
//                    mainPage230902.inputAgregarLista2.click();
//                    mercanciaComun2.run();
//                    mainPage230902.btnAgregarSeleccion.click();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230902.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230902.labelTerceros.click();
//                    mainPage230902.inputEntidadFederativa.sendKeys("ANTARTIDA");
//                    procesoComun.run();
//                }
//
//                if (movimiento3.isSelected()) {
//                    mainPage230902.selectTipoMovimiento.selectOptionByValue("03");
//                    mainPage230902.inputTipoRegimen.sendKeys("Definitvos");
//                    mainPage230902.selectListaOrigen.sendKeys("COATZACOALCOS, VER.");
//                    mainPage230902.inputAgregarLista.click();
//                    mainPage230902.btnAgregarMercancia.click();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230902.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mercanciaComun.run();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230902.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230902.labelTerceros.click();
//                    mainPage230902.inputEntidadFederativa.sendKeys("MICHOACÁN DE OCAMPO");
//                    procesoComun.run();
//                }
//
//                if (movimiento4.isSelected()) {
//                    mainPage230902.selectTipoMovimiento.selectOptionByValue("04");
//                    mainPage230902.inputTipoRegimen.sendKeys("Definitvos");
//                    mainPage230902.selectListaOrigen2.sendKeys("COATZACOALCOS, VER.");
//                    mainPage230902.inputAgregarLista2.click();
//                    mainPage230902.btnAgregarMercancia.click();
//                    mainPage230902.selectFraccionAran.sendKeys("01029099");
//                    mainPage230902.textDescripcion.sendKeys("PRUEBA QA");
//                    mainPage230902.textRendimiento.sendKeys("PRUEBA QA");
//                    mainPage230902.selectClasificacionTaxo.sendKeys("Plantas");
//                    mainPage230902.selectNombreCientifico.sendKeys("Barkeria skinneri");
//                    mainPage230902.selectNombreComun.sendKeys("ORQUIDEA");
//                    mainPage230902.inputMarca.sendKeys("MARCA QA");
//                    mainPage230902.inputCantidad.sendKeys("12345");
//                    mainPage230902.selectUDM.sendKeys("Pieza");
//                    mainPage230902.selectPaisOrigen.sendKeys("ARGENTINA");
//                    mainPage230902.selectPaisProcedencia.sendKeys("ANGUILA");
//                    mainPage230902.inputAgregarMercancia.click();
//                    mainPage230902.selectMovimientoDisponible.sendKeys("COMERCIAL (T)");
//                    mainPage230902.btnAgregarSeleccion.click();
//                    try {
//                        Thread.sleep(2000); // Pausa de 3 segundos
//                        // Hacer scroll hasta el elemento
//                        mainPage230902.Scrol.scrollIntoView(true);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mainPage230902.labelTerceros.click();
//                    mainPage230902.inputEntidadFederativa.sendKeys("ANTARTIDA");
//                    procesoComun.run();
//                }
//            }

            mainPage230902.inputGuardarSolicitud.click();
            mainPage230902.inputContinuar.click();
            metodos.cargarDocumentos();
            mainPage230902.inputAdjuntar.click();sleep(1000);
            mainPage230902.inputCerrar.click();sleep(100);
            mainPage230902.btnContinuar.click();sleep(1000);

            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite230902);
            String folioText = mainPage230902.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")){
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
    public void ProcesoGenerarDictamen(String folioNumber){
        Random random = new Random();
        long rango = 900000000L;
        long min = 100000000L;
        long randomNum = random.nextLong(rango) + min;
        String nueveDigitos = String.valueOf(randomNum);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite230902Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage230902.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage230902.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage230902.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage230902.condicionesDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        mainPage230902.selectMercanciaDict.click();
        mainPage230902.btnModificarMercanciaDict.click();
        mainPage230902.numPermisoOrigen.sendKeys("1");
        mainPage230902.numCertificadoOrigen.sendKeys("1");
        mainPage230902.fechaPermisoOrigen.sendKeys("01/10/2025");
        asignarPrimerDiaDelMes();
        mainPage230902.apendiceCodigoProcedencia.sendKeys("I W");
        mainPage230902.marcas.sendKeys("Relación de Marcas");
        mainPage230902.btnGuardarMercancia.click();
        $("#origenlistaOrigen3").shouldBe(Condition.visible).selectOptionByValue("626");
        mainPage230902.btnAgregarFinalidad.click();
        mainPage230902.numCites.sendKeys(nueveDigitos);
        asignarFechasPeriodoCompleto();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite230902Fun);sleep(5000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage230902.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage230902.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite230902Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage230902.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage230902.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite230902Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite230902);
        mainPage230902.selecRol.sendKeys("Persona Moral");
        mainPage230902.btnacep.click();
        mainPage230902.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage230902.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite230902);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public void asignarFechasPeriodoCompleto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();

        String fechaInicio = hoy.plusDays(5).format(formatter);
        String fechaFin = hoy.plusDays(12).format(formatter);

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();

        SelenideElement campoInicio = $("#fechaInicioPeriodo").shouldBe(visible);
        WebElement inputInicio = campoInicio.toWebElement();

        js.executeScript("arguments[0].value = arguments[1];", inputInicio, fechaInicio);

        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", inputInicio);
        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }))", inputInicio);

        SelenideElement campoFin = $("#fechoFinPeriodo").shouldBe(visible);
        WebElement inputFin = campoFin.toWebElement();

        js.executeScript("arguments[0].value = arguments[1];", inputFin, fechaFin);

        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", inputFin);
        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }))", inputFin);
    }
    public void asignarPrimerDiaDelMes() {
        LocalDate primerDiaDelMes = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaAAsignar = primerDiaDelMes.format(formatter);

        SelenideElement campo = $("#fechaCertificadoProcedenciaCites").shouldBe(visible);
        WebElement input = campo.toWebElement();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].value = arguments[1];", input, fechaAAsignar);

        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", input);
        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }))", input);
    }
}
