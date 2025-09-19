package MedioAmbiente.Tramite230202;

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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage230202Test {
    MainPage230202 mainPage230202 = new MainPage230202();
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
    public void Proceso230202() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen230202");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerificarDictamen230202");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion230202");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion230202");


        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox,verificarCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen230202");
        if (verificarCheckBox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen230202");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion230202");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion230202");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramiteM);
            mainPage230202.selecRol.sendKeys("Persona Moral");
            mainPage230202.btnacep.click();
            mainPage230202.Tramites.sendKeys("Solicitudes nuevas");
            $(withText("Solicitudes nuevas")).click();
            $("[alt='Secretaría del Medio Ambiente y Recursos Naturales']").click();
            $x("//a[contains(text(),'Certificados, Licencias y Permisos')]//span[text()='[+]']").click();
            $x("//a[contains(text(),'SEMARNAT-03-046 Certificado Fitosanitario de Exportación o Reexportación')]//span[text()='[+]']").click();
            mainPage230202.linkCerFitREE.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230202.labelDatosSolicitud.click();
            mainPage230202.inputCertificado.sendKeys("");
            mainPage230202.selectAduanas.sendKeys("ACAPULCO");
            mainPage230202.selectPaisOrigen.click();
            mainPage230202.inputAddlistaOrigen2.click();
            mainPage230202.optionCiudadXico.click();
            mainPage230202.inputAddlistaOrigen.click();
            mainPage230202.selectSolicitudDescripcionProducto.sendKeys("ADORNOS DE MADERA USADOS");
            mainPage230202.inputAgregarMercancias.click();
            mainPage230202.selectMercanciaGridFraccionArancelaria.sendKeys("44209099");
            mainPage230202.inputCantidadUmc.sendKeys("123456");
            mainPage230202.selectMercanciaGridGenero.sendKeys("Acacia");
            mainPage230202.selectMercanciaGridEspecie.sendKeys("Caven");
            mainPage230202.selectMercanciaGridNombreComun.sendKeys("Acacia");
            mainPage230202.inputAgregarMercancias2.click();
            mainPage230202.inputAgregarMercancia.click();
            mainPage230202.selectSolicitudCantidadUmc.sendKeys("Kilogramo");
            mainPage230202.inputEntrada.sendKeys("PRUEBAS");
            //mainPage230202.inputDescripcionGenerica.sendKeys("PRUEBA");
            mainPage230202.selectSolicitudTransporteIdeMedio.sendKeys("Terrestre");
            mainPage230202.inputDescripcionTipoContenedor.sendKeys("52345");
            mainPage230202.inputCodigoPostalDom.sendKeys("06900");
            mainPage230202.selectUbicacionMercanciaDomicilioEntidad.sendKeys("AGUASCALIENTES");
            mainPage230202.inputCalleDom.sendKeys("PRUEBAS");
            mainPage230202.inputDescripcionColoniaDom.sendKeys("Prueba");
            mainPage230202.inputNumeroExteriorDom.sendKeys("123");
            mainPage230202.inputNumInteriorDom.sendKeys("321");
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230202.labelTerceros.click();
            mainPage230202.inputBotonAgregarDestinatario.click();
            mainPage230202.inputPmoral.click();
            mainPage230202.inputRazonSocial.sendKeys("PROTEO TOYS");
            mainPage230202.inputCodigoPostal.sendKeys("06900");
            mainPage230202.selectPaisSinMexico.sendKeys("ANGUILA");
            mainPage230202.inputCiudad.sendKeys("CONOCIDA");
            mainPage230202.textareaDomicilio.sendKeys("CONOCIDO");
            mainPage230202.inputButtonGuardar.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230202.labelPagoDerechos.click();
            mainPage230202.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage230202.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage230202.inputCalendar);sleep(100);
            mainPage230202.InputGuardarSolicitud.click();
            mainPage230202.btnContinuar.click();sleep(2000);
            
            
            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage230202.btnAnexar.click();
            mainPage230202.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
            mainPage230202.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage230202.inputSiguienteButton.click();sleep(3000);

            //FIRMAR SOLICITUD
            metodos.scrollIncremento(1);
            loginFirmSoli.firma(tramiteM);
            Selenide.sleep(2000);
            String folioText = mainPage230202.folio.getText();sleep(2000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            for (String methodName : selectedMethods) {
                switch (methodName) {
                    case "ProcesoDictamen230202":
                        ProcesoDictamen(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    case "ProcesoVerificarDictamen230202":
                        ProcesoVerificarDictamen(folioNumber);
                        break;
                    case "ProcesoAutorizacion230202":
                        ProcesoAutorizacion(folioNumber);
                        break;
                    case "ProcesoConfirmarNotificaciónResolucion230202":
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
        mainPage230202.iniciofun.click();
        mainPage230202.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);
        mainPage230202.inputBuscarTareasFuncionario.click();sleep(6500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        mainPage230202.generaDict.click();
        mainPage230202.btmContinuarDict.click();
        if (sentidoDict.equals("Autorizado")) {
            $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        } else if (sentidoDict.equals("Rechazado")) {
            $("input[name='sentidoDictamen'][value='SEDI.RZ']").click();
        }
        mainPage230202.antecedentesDict.sendKeys("PRUEBAS QA");
        $("input[type='submit'][value='Guardar y Firmar']").click(); sleep(1000);

        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoVerificarDictamen (String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage230202.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage230202.inputBuscarTareasFuncionario.click();sleep(2000);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick(); sleep(3000);
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(4000);
    }

    public void ProcesoAutorizacion(String folioNumber) {

        mainPage230202.iniciofun.click();
        mainPage230202.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage230202.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion(String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            loginFirmSoli.login(tramiteM); sleep(1000);
            mainPage230202.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage230202.btnacep.click();
            mainPage230202.inputNumFolio.sendKeys(folioNumber);sleep(1500);
            $("input[type='button'][value='Buscar']").click();
            metodos.scrollIncremento(1);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).shouldBe(visible).doubleClick();
            mainPage230202.btnFirmarNotificacion.click();sleep(1000);
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