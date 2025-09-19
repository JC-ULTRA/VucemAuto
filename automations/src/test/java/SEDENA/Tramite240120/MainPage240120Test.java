package SEDENA.Tramite240120;

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
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240120Test {
    MainPage240120 mainPage240120 = new MainPage240120();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramiteM = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    TramitesFirmasLG tramiteFun = new TramitesFirmasLG(
            "C:\\Vucem3.0\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\Vucem3.0\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );

    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        Configuration.timeout = 15000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        //Configuration.holdBrowserOpen = true;
    }
    
    
    @Test
    public void Proceso240120() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240120");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerificarDictamen240120");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion240120");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion240120");


        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox,verificarCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240120");
        if (verificarCheckBox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen240120");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion240120");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion240120");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramiteM);
            mainPage240120.selecRol.sendKeys("Persona Moral");
            mainPage240120.btnacep.click();
            mainPage240120.Tramites.sendKeys("Solicitudes nuevas");
            $(withText("Solicitudes nuevas")).click();
            $("[alt='Secretaría de la Defensa Nacional']").click();
            $x("//a[contains(text(),'Certificados, Licencias y Permisos')]//span[text()='[+]']").click();
            $x("//a[contains(text(),'Permiso Aduanal SEDENA')]//span[text()='[+]']").click();
            mainPage240120.linkPermisoExtExpArtPir.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240120.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240120.labelDatosSolicitud.click();
            mainPage240120.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240120.inputAddOrigenLista.click();
            mainPage240120.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240120.btnAgregarMercancia.click();
            mainPage240120.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240120.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240120.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240120.inputValorComercialMercancia.sendKeys("1234");
            mainPage240120.selectUMCMercancia.sendKeys("Caja");
            mainPage240120.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240120.inputPaisOrigenMercancia.sendKeys("ANTARTIDA");
            mainPage240120.btnAgregarPaisSeleccion.click();
            mainPage240120.btnAgregarMercancia2.click();
            mainPage240120.labelTercerosRelacionados.click();
            mainPage240120.btnAgregarDestinatario.click();
            mainPage240120.inputFisica.click();
            mainPage240120.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240120.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240120.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240120.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240120.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240120.inputTercerosCP.sendKeys("23456");
            mainPage240120.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240120.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240120.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240120.inputTercerosLada.sendKeys("52");
            mainPage240120.inputTercerosTelefono.sendKeys("23456257");
            mainPage240120.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240120.btnGuardarTerceros.click();
            mainPage240120.btnAgregarProveedor.click();
            mainPage240120.inputNacional.click();
            mainPage240120.inputFisica.click();
            mainPage240120.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240120.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240120.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240120.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            mainPage240120.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240120.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240120.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240120.inputTercerosCP2.sendKeys("28006");
            mainPage240120.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240120.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240120.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240120.inputTercerosNumeroInt.sendKeys("321");
            mainPage240120.inputTercerosLada.sendKeys("52");
            mainPage240120.inputTercerosTelefono.sendKeys("234565432");
            mainPage240120.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240120.btnGuardarTerceros.click();
            mainPage240120.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240120.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240120.inputCadenaDependencia.setValue(factura.toString());
            mainPage240120.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240120.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240120.inputCalendar);sleep(100);
            mainPage240120.inputImportePago.sendKeys("5000");
            mainPage240120.InputGuardarSolicitud.click();
            mainPage240120.btnContinuar.click();sleep(5000);
            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage240120.btnAnexar.click();
            mainPage240120.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage240120.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage240120.inputSiguienteButton.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramiteM);
            Selenide.sleep(2000);
            String folioText = mainPage240120.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);



            for (String methodName : selectedMethods) {
                switch (methodName) {
                    case "ProcesoDictamen240120":
                        ProcesoDictamen(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    case "ProcesoVerificarDictamen240120":
                        ProcesoVerificarDictamen(folioNumber);
                        break;
                    case "ProcesoAutorizacion240120":
                        ProcesoAutorizacion(folioNumber);
                        break;
                    case "ProcesoConfirmarNotificaciónResolucion240120":
                        ProcesoConfirmarNotificaciónResolucion(folioNumber, "Moral");
                        break;
                }
            }
        }, repeticiones);
    }


    public void ProcesoDictamen(String folioNumber, String sentidoDict) {

        //WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        // Obtener la fecha de (hoy+Meses) formateada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicioVigenciaGenerado = LocalDate.now().format(formatter);
        String fechaFinVigenciaGenerado = LocalDate.now().plusDays(15).format(formatter);

        loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        // Búsqueda de Folio
        mainPage240120.iniciofun.click();
        mainPage240120.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);
        mainPage240120.inputBuscarTareasFuncionario.click();sleep(6500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        mainPage240120.generaDict.click();
        mainPage240120.btmContinuarDict.click();
        if (sentidoDict.equals("Autorizado")) {
            $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        } else if (sentidoDict.equals("Rechazado")) {
            $("input[name='sentidoDictamen'][value='SEDI.RZ']").click();
        }
        mainPage240120.antecedentesDict.sendKeys("PRUEBAS QA");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage240120.fechaFinVigencia,fechaFinVigenciaGenerado);
        $("input[type='submit'][value='Guardar y Firmar']").click(); sleep(1000);

        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoVerificarDictamen (String folioNumber) {

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage240120.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage240120.inputBuscarTareasFuncionario.click();sleep(2000);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick(); sleep(3000);
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(4000);
    }

    public void ProcesoAutorizacion(String folioNumber) {

        mainPage240120.iniciofun.click();
        mainPage240120.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage240120.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion(String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            loginFirmSoli.login(tramiteM); sleep(1000);
            mainPage240120.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage240120.btnacep.click();
            mainPage240120.inputNumFolio.sendKeys(folioNumber);sleep(1500);
            $("input[type='button'][value='Buscar']").click();
            metodos.scrollIncremento(1);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).shouldBe(visible).doubleClick();
            mainPage240120.btnFirmarNotificacion.click();sleep(1000);
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }

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