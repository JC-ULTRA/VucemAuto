package AGRICULTURA.Tramite220201;
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
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220201Test {
    MainPage220201 mainPage220201 = new MainPage220201();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite220201  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite220201fun  = new TramitesFirmasLG(
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
    public void Proceso220201() throws IOException {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen220201");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion220201");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion220201");

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
                tramitePrincipal();
                String folioText = mainPage220201.folio.getText();
                String folioNumber = obtenerFolio.obtenerFolio(folioText);
                if (selectedMethods.contains("ProcesoDictamen")){
                    try {
                        setUpAll();
                        ProcesoGenerarDictamen(folioNumber);
//                    ProcesoVerificarDictamen(folioNumber);
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
    
    public void tramitePrincipal(){
        loginSoli.login(tramite220201);
        mainPage220201.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage220201.btnacep.click(); sleep(1000);
        mainPage220201.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage220201.SoliNew.click(); sleep(1000);
        mainPage220201.Agricultura.click();
        mainPage220201.certysol.click();
        mainPage220201.certImport.click();
        mainPage220201.SelectTramite220201.click();
        try {
            Thread.sleep(2000); // Pausa de 3 segundos
            // Hacer scroll hasta el elemento
            mainPage220201.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage220201.labelDatosSolicitud.click();
        mainPage220201.selectSolicitudClaveAduana.sendKeys("AEROPUERTO INTERNAL. CD. DE MEXICO, D.F.");
        mainPage220201.SolicitudOfiInspecAgrop.sendKeys("AICM  Sala E Internacional Cd. de México");
        mainPage220201.puntoInspec.sendKeys("AICM  Sala E Internacional Cd. de México Oficina Sala de llegadas Sala E1 Terminal 1 (Centro Sudamérica y Caribe)");
        mainPage220201.ClaveUcon.sendKeys("");
        mainPage220201.selectEstabTif.sendKeys("");
        mainPage220201.NombreMedVet.sendKeys("");
        mainPage220201.NumGui.sendKeys("223232");
        mainPage220201.Regimen.sendKeys("Definitivos");
        Selenide.sleep(1000);
        mainPage220201.inputProductosSubproductos.click();
        mainPage220201.bntAgregarMercanciaP.click();
        mainPage220201.selectTipoRequisito.sendKeys("Inspección Ocular");
        mainPage220201.inputRequisito.sendKeys("QA");
        mainPage220201.inputCertificadoInternacional.sendKeys("21234");
        mainPage220201.selectFraccionArancelaria.sendKeys("1013001");
        Selenide.sleep(1000);
        mainPage220201.selectNICO.sendKeys("00");
        mainPage220201.inputDescripcion.sendKeys("QA");
        mainPage220201.inputCantidadUMT.sendKeys("345");
        mainPage220201.inputCantidadUMC.sendKeys("345");
        mainPage220201.selectUMC.sendKeys("Gramo Neto");
        mainPage220201.selectEspecie.sendKeys("Acuática");
        mainPage220201.selectUso.sendKeys("Animal");
        mainPage220201.selectPaisOrigen.sendKeys("AFGANISTAN (EMIRATO ISLAMICO DE)");
        mainPage220201.selectPaisProcedencia.sendKeys("BELICE");
        mainPage220201.selectPresentacion.sendKeys("Pallets");
        mainPage220201.inputCantidadPresentacion.sendKeys("1234");
        mainPage220201.inputTipoPresentacion.sendKeys("Caja");
        mainPage220201.inputNumeroLote.sendKeys("12345");
        mainPage220201.inputRangoFechaSi.click();
        Selenide.executeJavaScript("arguments[0].value = '03/06/25';",mainPage220201.inputFechaElaboracionDe);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '30/06/25';", mainPage220201.inputFechaElaboracionHa);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '03/06/25';", mainPage220201.inputFechaProduccionDe);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '30/06/25';", mainPage220201.inputFechaProduccionHa);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '03/06/25';", mainPage220201.inputFechaCaducidadDe);sleep(100);
        Selenide.executeJavaScript("arguments[0].value = '30/06/25';", mainPage220201.inputFechaCaducidadHa);sleep(100);
        mainPage220201.btnAgregarDetalle.click();
        mainPage220201.checkDetalle.click();
        mainPage220201.btnAgregar.click();
        mainPage220201.labelDatosMovilizacionNacional.click();
        mainPage220201.inputCoordenadasGeograficas.sendKeys("X");
        mainPage220201.selectMedioTransporte.sendKeys("Aéreo");
        mainPage220201.inputIdentificacionTrasnporte.sendKeys("435345");
        mainPage220201.selectPuntoVerificacionFed.sendKeys("REGIÓN NORTE, LA CONCHA, SIN.");
        mainPage220201.inputNombreEmpresaTrasnportista.sendKeys("Prueba");
        try {
            Thread.sleep(2000); // Pausa de 3 segundos
            // Hacer scroll hasta el elemento
            mainPage220201.Scrol.scrollIntoView(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage220201.labelTercerosRelacionados.click();
        mainPage220201.btnAgregarExportador.click();
        mainPage220201.inputMoralAT.click();
        mainPage220201.inputAgregarRazonSocial.sendKeys("Prueba");
        mainPage220201.selectPaisTF.sendKeys("MEXICO (ESTADOS UNIDOS MEXICAN)");
        mainPage220201.inputDomicilioTF.sendKeys("TEST");
        mainPage220201.inputLadaTF.sendKeys("55");
        mainPage220201.inputTelefonoTF.sendKeys("55122334");
        mainPage220201.inputCorreoTF.sendKeys("Ultrasist@pruebas.com");
        mainPage220201.btnAgregarTerceros.click();
        mainPage220201.btnAgregarDestinatario.click();
        mainPage220201.inputMoralAT.click();
        mainPage220201.inputAgregarRazonSocial.sendKeys("Prueba");
        mainPage220201.inputCodigoPostalTF.sendKeys("95270");
        mainPage220201.selectEstadoTF.sendKeys("VERACRUZ");
        mainPage220201.selectMunicipioTF.sendKeys("ALVARADO");
        mainPage220201.selectColoniaTF.sendKeys("ADOLFO RUIZ CORTINEA");
        mainPage220201.inputCalleTF.sendKeys("Calle2");
        mainPage220201.inputNumExterior.sendKeys("123");
        mainPage220201.inputNumInterior.sendKeys("12");
        mainPage220201.inputLadaTF.sendKeys("55");
        mainPage220201.inputTelefonoTF.sendKeys("55122334");
        mainPage220201.inputCorreoTF.sendKeys("Ultrasist@pruebas.com");
        mainPage220201.btnAgregarTerceros.click();
        mainPage220201.labelPagoDerechos.click();
        mainPage220201.inputExentoPagoSi.click();
        mainPage220201.inputJustificacion.sendKeys("Mascotas");

        mainPage220201.InputGuardarSolicitud.click();
        mainPage220201.btnContinuar.click();
        loginSoli.firma(tramite220201);
    }
    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginSoli.loginFun(tramite220201fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage220201.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage220201.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("[name='mostrarSiguiente']").shouldBe(visible).click();
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage220201.justificacionDictamen.sendKeys("PRUEBAS QA ULTRASIST");
        metodos.scrollDecremento(1);
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginSoli.firmaFun(tramite220201fun);sleep(5000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage220201.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage220201.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginSoli.firmaFun(tramite220201fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage220201.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage220201.btnBuscarFolioFun.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        $("[name='mostrarFirma']").shouldBe(visible).click();
        loginSoli.firmaFun(tramite220201fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginSoli.login(tramite220201);
        mainPage220201.selecRol.sendKeys("Persona Moral");
        mainPage220201.btnacep.click();
        mainPage220201.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage220201.btnContinuarConfirmacion.click();sleep(1000);
        loginSoli.firma(tramite220201);sleep(1000);sleep(4000);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public String RetornoFolio(){
        tramitePrincipal();
        String folioText = mainPage220201.folio.getText();
        String folioNumber = obtenerFolio.obtenerFolio(folioText);
        try {
            setUpAll();
            ProcesoGenerarDictamen(folioNumber);
            System.out.println("ProcesoDictamen completado. Pasando a Autorización...");
            try {
                ProcesoAutorizarDictamen(folioNumber);
                System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");
                try {
                    ProcesoConfirmarNotificacion(folioNumber);
                    System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
            e.printStackTrace();
        }
        closeWebDriver();
        return folioNumber;
    }
}
