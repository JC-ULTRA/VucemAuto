package SEDENA.Tramite240105;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import SEDENA.Tramite240105.MainPage240105;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240105Test {
    MainPage240105 mainPage240105 = new MainPage240105();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240105  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite240105fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
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
    public void Proceso240105() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240105");
        JCheckBox VerificarCheckbox = new JCheckBox("ProcesoVerificarDictamen240105");
        JCheckBox AutorizarCheckBox = new JCheckBox("ProcesoAutorizarDictamen240105");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificacion240105");


        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, VerificarCheckbox, AutorizarCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (VerificarCheckbox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen");
        if (AutorizarCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizarDictamen");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificacion");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240105);
            mainPage240105.selecRol.sendKeys("Persona Moral");
            mainPage240105.btnacep.click();
            mainPage240105.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240105.SoliNew.click();
            mainPage240105.SEDENA.click();
            mainPage240105.linkCerLicPer.click();
            mainPage240105.linkPermisoAduanalSEDENA.click();
            mainPage240105.elementoTramite240105.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240105.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240105.labelDatosSolicitud.click();
            mainPage240105.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240105.inputAddOrigenLista.click();
            mainPage240105.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240105.PermisoGeneral.sendKeys("Permiso QA");

            //Agregar mercancia
            mainPage240105.btnAgregarMercancia.click();
            //Datos mercancía
            mainPage240105.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240105.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240105.inputCantidadUMTMercancia.sendKeys("20");
            mainPage240105.inputValorComercialMercancia.sendKeys("1574");
            mainPage240105.selectUMCMercancia.sendKeys("Caja");
            mainPage240105.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240105.btnAgregarMercancia2.click();

            //Periodo
            mainPage240105.btnRad2TercerPeriodo.click();
            mainPage240105.checkAñoCurso.click();

            //Pestaña de terceros
            mainPage240105.Scrol.scrollTo();
            mainPage240105.labelTercerosRelacionados.click();
            //Destinatario (destino final)
            mainPage240105.btnAgregarDestinatario.click();
            mainPage240105.inputExtranjera.click();
            mainPage240105.inputFisica.click();;
            mainPage240105.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240105.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240105.inputTercerosApellidoMaterno.sendKeys("CHACON");
            //Domicilio
            mainPage240105.selectPais.sendKeys("ARGENTINA (REPUBLICA)");
            mainPage240105.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240105.inputTercerosCP.sendKeys("23456");
            mainPage240105.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240105.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240105.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240105.inputTercerosLada.sendKeys("52");
            mainPage240105.inputTercerosTelefono.sendKeys("23456257");
            mainPage240105.inputTercerosCorreoElec.sendKeys("pruebaCorreo@test.com");
            mainPage240105.btnGuardarTerceros.click();

            //Proveedor
            mainPage240105.btnAgregarProveedor.click();
            mainPage240105.inputFisica.click();
            mainPage240105.inputTercerosNombre.sendKeys("Adriana");
            mainPage240105.inputTercerosApellidoPaterno.sendKeys("Ortiz");
            mainPage240105.inputTercerosApellidoMaterno.sendKeys("Castillo");
            //Domicilio
            mainPage240105.selectPais.selectOption("CANADA");
            mainPage240105.EstadoProveedor.sendKeys("COLIMA");
            mainPage240105.inputTercerosCP.sendKeys("28006");
            mainPage240105.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240105.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240105.inputTercerosNumeroInt.sendKeys("321");
            mainPage240105.inputTercerosLada.sendKeys("52");
            mainPage240105.inputTercerosTelefono.sendKeys("234565432");
            mainPage240105.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            //Guardar terceros
            mainPage240105.btnGuardarTerceros.click();

            //Pestaña Pago de Derechos
            mainPage240105.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240105.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240105.inputCadenaDependencia.setValue(factura.toString());
            mainPage240105.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240105.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240105.inputCalendar);sleep(100);
            mainPage240105.inputImportePago.sendKeys("5000");
            mainPage240105.InputGuardarSolicitud.click();
            mainPage240105.btnContinuar.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage240105.btmAnexar.click();sleep(1000);
            mainPage240105.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage240105.btnCerrar.click();
            Selenide.sleep(1000);
            mainPage240105.inputSiguiente.click();sleep(1000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240105);
            Selenide.sleep(2000);
            String folioText = mainPage240105.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    System.out.println("Iniciando ProcesoDictamen...");
                    ProcesoDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a VerificarDictamen...");

                    if (selectedMethods.contains("ProcesoVerificarDictamen")) {
                        ProcesoVerificarDictamen(folioNumber);
                        System.out.println("ProcesoVerificarDictamen completado. Pasando a AutorizarDictamen...");

                        if (selectedMethods.contains("ProcesoAutorizarDictamen")) {
                            ProcesoAutorizarDictamen(folioNumber);
                            System.out.println("ProcesoAutorizarDictamen completado. Pasando a ConfirmarNotificacion...");

                            if (selectedMethods.contains("ProcesoConfirmarNotificacion")) {
                                ProcesoConfirmarNotificacion(folioNumber);
                                System.out.println("ProcesoConfirmarNotificacion completado.");
                            }
                    }   }
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }
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
    public void ProcesoDictamen(String folioNumber) {
        //se asigna el login a ocupar
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite240105fun);

        // Búsqueda de Folio
        mainPage240105.iniciofun.click();
        mainPage240105.numfolio.sendKeys(folioNumber);sleep(6000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240105.btnBuscarFolio.click();sleep(20000);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").shouldBe(Condition.visible).click();
        loginFirmSoli.firmaFun(tramite240105fun);sleep(1000); sleep(6000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240105.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage240105.btnBuscarFolio.doubleClick();sleep(20000);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite240105fun);sleep(6000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage240105.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage240105.btnBuscarFolio.doubleClick();sleep(20000);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firmaFun(tramite240105fun);sleep(6000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite240105);
        mainPage240105.selecRol.sendKeys("Persona Moral");
        mainPage240105.btnacep.click();
        mainPage240105.inicioFolio.sendKeys(folioNumber);sleep(20000);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        $("[name='mostrarFirma'][type='submit']").shouldBe(visible).click();
        loginFirmSoli.firma(tramite240105);sleep(6000);sleep(6000);
    }
}