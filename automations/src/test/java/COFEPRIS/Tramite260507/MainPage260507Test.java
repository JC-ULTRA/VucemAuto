package COFEPRIS.Tramite260507;

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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260507Test {
    MainPage260507 mainPage260507 = new MainPage260507();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";
    String folioNumber = "0402600901920254006000003";
    TramitesFirmasLG tramite260507 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260507F = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(180000, TimeUnit.SECONDS);
        Configuration.timeout = 180000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso260507() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260507");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerifica260507");
        JCheckBox autorizarCheckBox = new JCheckBox("AutorizarDictamen260507");
        JCheckBox confirmarCheckBox = new JCheckBox("ConfirmarNotificacion260507");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, verificarCheckBox, autorizarCheckBox,confirmarCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }
        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260507");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoVerifica260507");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("AutorizarDictamen260507");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ConfirmarNotificacion260507");

        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite260507);
            mainPage260507.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage260507.btnacep.click();sleep(1000);

            //Busqueda de tramite
            mainPage260507.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
            mainPage260507.SoliNew.click();//sleep(1000);
            mainPage260507.Cofepris.click();//sleep(1000);
            mainPage260507.CertificadosLicenciasPermisos.click();//sleep(1000);
            mainPage260507.PermisoImportacionToxicosPeligro.click();//sleep(1000);
            mainPage260507.elementoPlagisidasDependencias.click();sleep(1000);

            //PASO 1 CAPTURAR SOLICITUD
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            //Pestaña Datos de solicitud
            mainPage260507.DatosSolicitud.click();
            //Datos del establecimiento
            mainPage260507.btnEstablecimiento.click();
            mainPage260507.buttonAceptar.click();
            mainPage260507.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
            mainPage260507.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
            mainPage260507.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
            //Domicilio del establecimiento
            mainPage260507.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
            mainPage260507.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260507.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
            mainPage260507.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
            mainPage260507.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
            mainPage260507.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
            mainPage260507.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
            mainPage260507.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

            //Agregar SCIAN
            mainPage260507.btnAgregarScian.click();
            mainPage260507.selectComboScian.sendKeys("311239");
            mainPage260507.btnAgregar2Scian.click();sleep(1000);

            //Aduanas de entrada
            mainPage260507.listAduanasEntrada.sendKeys("CIUDAD HIDALGO");
            mainPage260507.btnAgregarAduanaentrada.click();

            //Agregar Mercancia
            mainPage260507.btnAgregarMercancia.click();
            //Identificación del producto
            mainPage260507.NombreComercial.sendKeys("QA Nombre comercial");
            mainPage260507.NombreComun.sendKeys("QA Nombre comun");
            mainPage260507.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
            mainPage260507.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
            mainPage260507.inputFraccionArancelaria.sendKeys("29173902");
            mainPage260507.inputCantidadUmt.sendKeys("19210");
            mainPage260507.inputCantidadUmc.sendKeys("403");
            mainPage260507.selectUMC.selectOption("Gramos");
            mainPage260507.PorcentajeConcentracion.sendKeys("15");
            // mainPage260507.NumRegistroSanitario.sendKeys("693402");
            //País donde se produce o fabrica el ingrediente activo
            mainPage260507.btnDesplegarInfoPaisFabricante.click();
            mainPage260507.listaPaisFabricante.selectOption("CANADA");
            mainPage260507.btnAgregarPaisFabricante.click();
            //País donde se elabora el producto
            mainPage260507.btnDesplegarInfoPaisElabora.click();
            mainPage260507.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
            mainPage260507.btnAgregarPaisElabora.click();
            //País proveedor (Origen)
            mainPage260507.btnDesplegarInfoPaisProveedor.click();
            mainPage260507.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
            mainPage260507.btnAgregarPaisProveedor.click();
            //País de procedencia/ País del último puerto de embarque
            mainPage260507.btnDesplegarInfoPaisProcedencia.click();
            mainPage260507.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
            mainPage260507.btnAgregarPaisProcedencia.click();
            //Clasificación Toxicológica e importación
            mainPage260507.selectClasificacionToxi.selectOption("5");
            mainPage260507.selectObjetoImportacion.selectOption("Distribución");
            //Agregar la información de la mercancia
            mainPage260507.btnAgregarMercanciaTotalInfo.click();

            //Manifiesto y declaraciones
            mainPage260507.checkCumploRequisitosYNormativas.click();
            mainPage260507.radNoHacerPublicoInformacion.click();
            //Repesentante legal
            mainPage260507.RepresentanteRFC.sendKeys("ZURA6808202RA");
            mainPage260507.btnBuscarRepresentante.click();


            //TERCEROS RELACIONADOS
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            mainPage260507.tabTercerosRelacionados.click();

            //Agregar Fabricante
            //DatosGenerales
            mainPage260507.btnAgregarFabricante.click();
            mainPage260507.radExtranjeroTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
            //Datos personales
            mainPage260507.listTercerosPais.selectOption("CANADA");
            mainPage260507.CodigoPostaltxt.sendKeys("7550000");
            mainPage260507.TercerosEstadotxt.sendKeys("Ontario");
            mainPage260507.inputTercerosCalle.sendKeys("Imperial St");
            mainPage260507.inputTercerosNumExterior.sendKeys("50");
            mainPage260507.inputTercerosNumInterior.sendKeys("2");
            mainPage260507.inputTerceroLada.sendKeys("416");
            mainPage260507.inputTercerosTelefono.sendKeys("416-485-111");
            mainPage260507.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
            mainPage260507.buttonGuardarDatosTercero.click();

            //Agregar Formulador
            //DatosGenerales
            mainPage260507.btnAgregarFormulador.click();
            mainPage260507.radNacionalTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.TercerosRFC.sendKeys("AAL0409235E6");
            mainPage260507.btnBuscarTerceroRFC.click();
            mainPage260507.buttonGuardarDatosTercero.click();

            //Agregar Proveedor
            mainPage260507.btnAgregarProveedor.click();
            mainPage260507.radExtranjeroTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
            mainPage260507.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
            mainPage260507.CodigoPostaltxt.sendKeys("7550000");
            mainPage260507.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
            mainPage260507.inputTercerosCalle.sendKeys("Manzano QA");
            mainPage260507.inputTercerosNumExterior.sendKeys("70");
            mainPage260507.inputTercerosNumInterior.sendKeys("2");
            mainPage260507.inputTerceroLada.sendKeys("2");
            mainPage260507.inputTercerosTelefono.sendKeys("212-100-000");
            mainPage260507.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
            mainPage260507.buttonGuardarDatosTercero.click();

            //PAGO DERECHOS
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            mainPage260507.tabPagoDerechos.click();
            mainPage260507.ClaveReferencia.sendKeys("284000255");sleep(1000);
            mainPage260507.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage260507.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage260507.inpLLavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260507.FechaPago, fechaHoy);
            mainPage260507.ImportePago.sendKeys("100");
            mainPage260507.btnContinuarDatosCompletos.click();

            //Paso2 REQUISITOS NECESARIOS
            mainPage260507.btnContinuarPaso2.click();

            //Paso 3
            metodos.cargarDocumentos();
            mainPage260507.btnAnexar.click();sleep(2000);
            mainPage260507.btnCerrar.click();sleep(100);
            mainPage260507.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260507);
            Selenide.sleep(2000);
            String folioText = mainPage260507.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(2000);
            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);

            if (selectedMethods.contains("ProcesoDictamen260507")) {
                setUpAll();
                EvaluarSolicitud(folioNumber);
            }
            if (selectedMethods.contains("ProcesoVerifica260507")) {
                VerificaDictamen(folioNumber);
            }
            if (selectedMethods.contains("AutorizarDictamen260507")) {
                AutorizarDictamen(folioNumber);
            }
            if (selectedMethods.contains("ConfirmarNotificacion260507")) {
                ConfirmarNotificacion(folioNumber);
            }guardarFolioEnArchivo(folioNumber);
        }, repeticiones);
    }

    public void EvaluarSolicitud(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        loginFirmSoli.loginFun(tramite260507F);sleep(4000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage260507.iniciofun.click();
        mainPage260507.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260507.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrar'][value='Continuar']").click();sleep(4000);
        mainPage260507.inputDictamenAceptado.click();
        mainPage260507.justificacionRequerimiento.setValue("PRUEBAS QA");sleep(2000);
        mainPage260507.inputRestriccion.sendKeys("IMPORTACIÓN SIN RESTRICCIÓN");
        mainPage260507.inputSiglas.sendKeys("RAK");
//        Selenide.executeJavaScript("arguments[0].value = '10/04/2026';",mainPage260507.inputFechaFinVig);sleep(100);
        mainPage260507.inputAutorizador.sendKeys("GONZALEZ PINAL EUROFOODS DE MEXICO  LUIS AMBROSIO MARTINEZ VALENZUELA");
        $("input[name='mostrarFirma'][value='Guardar y Firmar']").click();sleep(5000);
        loginFirmSoli.firmaFun(tramite260507F);sleep(2000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
    }

    public void VerificaDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;sleep(2000);
        String rfcEmpleado = "MAVL621207C95";sleep(2000);
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage260507.iniciofun.click();sleep(3000);
        mainPage260507.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260507.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[type='submit'][value='Dar Vo. Bo.']").click();
        loginFirmSoli.firmaFun(tramite260507F);sleep(8000);
    }

    public void AutorizarDictamen(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        String folioGenerado = folioNumber;
        String rfcEmpleado = "MAVL621207C95";
        ConDBReasigSolFun.processFolio(folioGenerado, rfcEmpleado);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(5000);
        mainPage260507.iniciofun.click();sleep(3000);
        mainPage260507.numfolio.sendKeys(folioNumber);sleep(1500);
        mainPage260507.btnBuscarFolio.click();sleep(4500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(5000);
        $("input[name='mostrarFirma'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramite260507F);sleep(8000);
    }

    public void ConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();sleep(2000);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");sleep(5000);
        loginFirmSoli.login(tramite260507);sleep(3000);
        mainPage260507.SelecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage260507.Btnacep.click();
        mainPage260507.inicioFolio.sendKeys(folioNumber);sleep(15000);
        $("input[type='button'][value='Buscar']").doubleClick();sleep(3000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(3000);
        $("input[name='mostrarFirma'][value='Continuar']").click();sleep(3000);
        loginFirmSoli.firma(tramite260507);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
    public String obtenerNumFolioTramite(String idTipoTramite, String ideEstSolicitud) {
        String numFolioTramite = null;

        String sql =
                "SELECT NUM_FOLIO_TRAMITE " +
                        "FROM VUC_TRAMITE vt " +
                        "WHERE ID_SOLICITUD = (" +
                        "    SELECT ID_SOLICITUD " +
                        "    FROM (" +
                        "        SELECT * " +
                        "        FROM VUC_SOLICITUD vs " +
                        "        WHERE ID_TIPO_TRAMITE = ? " +
                        "          AND IDE_EST_SOLICITUD = ? " +
                        "        ORDER BY FEC_CREACION DESC" +
                        "    ) " +
                        "    WHERE ROWNUM = 1" +
                        ")";

        // Conexión incluida en el método
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                "vucem_app_p01",
                "Mfk22nvW6na71DgBXi5R");                                 // <-- tu contraseña
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Seteamos los parámetros dinámicos
            ps.setString(1, idTipoTramite);
            ps.setString(2, ideEstSolicitud);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    numFolioTramite = rs.getString("NUM_FOLIO_TRAMITE");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFolioTramite;
    }
    public void guardarFolioEnArchivo(String folioNumber) {
        String rutaArchivo = "C:\\VucemAuto\\automations\\folios_generados260507.txt";

        // Formato de fecha y hora: 2025-07-02 18:45:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(timestamp + " - " + folioNumber);
            writer.newLine();
            System.out.println("Folio guardado correctamente: " + folioNumber);
        } catch (IOException e) {
            System.err.println("Error al guardar el folio: " + e.getMessage());
        }
    }
}