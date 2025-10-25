package COFEPRIS.Tramite260211;

import COFEPRIS.Tramite260211.MainPage260211;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260211Test {
    MainPage260211 mainPage260211 = new MainPage260211();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260211 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260211Fun = new TramitesFirmasLG(
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
    public void Proceso260211() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260211");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260211");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260211");

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
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite260211);
            mainPage260211.selecRol.sendKeys("Persona Moral");
            mainPage260211.btnacep.click();
            mainPage260211.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260211.SoliNew.click();
            mainPage260211.Cofepris.click();
            mainPage260211.linkCertificadosLicenciasPermisos.click();
            mainPage260211.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260211.linkPermisoFuentesRadiacion.click();
            //DATOS SOLICITUD
            mainPage260211.labelDatosSolicitud.click();
            mainPage260211.inputEstablecimiento.click();
            mainPage260211.btnAceptar.click();
            mainPage260211.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260211.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260211.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260211.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260211.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260211.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260211.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260211.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260211.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260211.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260211.inputScianAgregar.click();
            mainPage260211.comboSCIAN.selectOption("614074");
            mainPage260211.inputAgregar.click();
            mainPage260211.inputAvisoFuncionamiento.click();
            mainPage260211.solicitudRegimen.sendKeys("Definitivos");
            mainPage260211.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260211.inputAgregarAduana.click();
            mainPage260211.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260211.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260211.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260211.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260211.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260211.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260211.selectFormaFarmaceutica.sendKeys("");
            mainPage260211.selectEstadoFisico.sendKeys("Granulado o polvo");
            mainPage260211.inputFraccionArancelaria.sendKeys("33061001");
            mainPage260211.inputCantidadUMT.sendKeys("100");
            mainPage260211.inputCantidadUMC.sendKeys("10");
            mainPage260211.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260211.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260211.inputRgistroSanitario.sendKeys("1234535");
            Selenide.executeJavaScript("arguments[0].value = '20/04/2025';", mainPage260211.inputCaducidad);
            sleep(100);
            mainPage260211.buttonAbrirPanelPaisesOrigen.click();
            mainPage260211.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260211.inputAgregarSeleccion.click();
            mainPage260211.inputAbrirPanelPaisesProcedencia.click();
            mainPage260211.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260211.inputAgregarSeleccion2.click();
            mainPage260211.botonAbrirPanelUsosEspecificos.click();
            mainPage260211.UsoEspecifico.sendKeys("VENTA O COMERCIALIZACIÓN");
            mainPage260211.botonAgregarSeleccion.click();
            mainPage260211.inputAgregarMercancia.click();
            mainPage260211.inputDeclaracion.click();
            mainPage260211.inputInformacionConfidencialNo.click();
            mainPage260211.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260211.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260211.labelTerceroRElacionado.click();
            mainPage260211.inputAgregarFabricante.click();
            mainPage260211.inputNacionalidadextranjera.click();
            mainPage260211.inputPErsonaMoral.click();
            mainPage260211.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260211.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260211.terceroEstadoLocalidad.sendKeys("LUXEMBURGO");
            mainPage260211.terceroCodigoPostal.sendKeys("00000");
            mainPage260211.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260211.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260211.terceroNumExterior.sendKeys("123");
            mainPage260211.terceroNumInterior.sendKeys("4B");
            mainPage260211.terceroTelefono.sendKeys("5555555555");
            mainPage260211.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260211.btnGuardarDatosTerceros.click();
            mainPage260211.inputAgregarDestinatario.click();
            mainPage260211.inputTipoPeronaMoral.click();
            mainPage260211.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260211.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260211.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260211.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260211.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260211.terceroCodigoPostal2.sendKeys("06278");
            mainPage260211.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260211.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260211.terceroNumExterior2.sendKeys("123");
            mainPage260211.terceroNumInterior2.sendKeys("4B");
            mainPage260211.terceroTelefono2.sendKeys("5555555555");
            mainPage260211.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260211.btnGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260211.labelPagoDerechos.click();
            mainPage260211.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260211.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260211.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260211.inputSolicitudPagoLlave.sendKeys(llavePago);
            mainPage260211.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260211.inputCalendar);
            sleep(100);
            mainPage260211.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260211.inputGuarda.click();sleep(1000);
            metodos.cargarDocumentos();
            mainPage260211.btnAnexar.click();sleep(3000);
            mainPage260211.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260211.btnCerrar.click();
            mainPage260211.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260211);sleep(4000);
            String folioText = mainPage260211.folio.getText();
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
        loginFirmSoli.loginFun(tramite260211Fun);
        sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260211.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260211.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();
        sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260211.destinadoPara.sendKeys("Acondicionamiento");
        mainPage260211.restricciones.sendKeys(" PREVIO ASEGURAMIENTO Y MUESTREO (PRESERVATIVOS)");
        mainPage260211.observaciones.sendKeys("EL CORRECTO EMPLEO DEL PRODUCTO A IMPORTAR ES RESPONSABILAD DE QUIEN LO USA");
        mainPage260211.plazo.sendKeys("180");
        mainPage260211.siglasDictaminador.sendKeys("MAVL");
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260211.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260211Fun);
        sleep(5000);
    }

    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260211.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260211.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260211.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260211Fun);
        sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260211.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260211.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260211.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260211Fun);
        sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260211);
        mainPage260211.selecRol.sendKeys("Persona Moral");
        mainPage260211.btnacep.click();
        mainPage260211.inicioFolio.sendKeys(folioNumber);
        sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260211.btnContinuarConfirmacion.click();
        sleep(1000);
        loginFirmSoli.firma(tramite260211);
        sleep(1000);
        sleep(4000);
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