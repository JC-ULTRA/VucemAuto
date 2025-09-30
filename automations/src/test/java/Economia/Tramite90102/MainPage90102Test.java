package Economia.Tramite90102;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage90102Test {

    MainPage90102 mainPage90102 = new MainPage90102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramiteM = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\tsd931210493.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\TSD931210493_1012231144.key");

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
        Configuration.timeout = 35000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso90102() {

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
        JCheckBox requerimientoCheckBox = new JCheckBox("ProcesoSolicitarRequerimiento90102");
        JCheckBox autorizarRequerimientoCheckBox = new JCheckBox("ProcesoAutorizarRequerimiento90102");
        JCheckBox confirmarRequerimientoCheckBox = new JCheckBox("ProcesoConfirmarRequerimiento90102");
        JCheckBox atenderRequerimientoCheckBox = new JCheckBox("ProcesoAtenderRequerimiento90102");
        JCheckBox generarOpinionCheckBox = new JCheckBox("ProcesoGenerarOpinion90102");
        JCheckBox registrarOpinionCheckBox = new JCheckBox("ProcesoRegistrarOpinion90102");
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen90102");
        //JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerificarDictamen90102");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion90102");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion90102");


        Object[] params = {"Seleccione los métodos a ejecutar:",requerimientoCheckBox, autorizarRequerimientoCheckBox,
                confirmarRequerimientoCheckBox, atenderRequerimientoCheckBox, generarOpinionCheckBox,
                registrarOpinionCheckBox, dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();

        if (requerimientoCheckBox.isSelected()) selectedMethods.add("ProcesoRequerimiento90102");
        if (autorizarRequerimientoCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizarRequerimiento90102");
        if (confirmarRequerimientoCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarRequerimiento90102");
        if (atenderRequerimientoCheckBox.isSelected()) selectedMethods.add("ProcesoAtenderRequerimiento90102");
        if (generarOpinionCheckBox.isSelected()) selectedMethods.add("ProcesoGenerarOpinion90102");
        if (registrarOpinionCheckBox.isSelected()) selectedMethods.add("ProcesoRegistrarOpinion90102");
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen90102");
        //if (verificarCheckBox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen90102");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion90102");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion90102");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados

        ejecutarProcesoNRunnable(() -> {
/*
            //ProcesoRequerimiento ( "0200900100220252235000001");
            //ProcesoAutorizarRequerimiento ( "0200900100220252235000001");
            //ConfirmarNotificacionRequerimiento ( "0200900100220252235000001",  "Moral");
            //ProcesoAtenderRequerimiento ( "0200900100220252235000001",  "Moral");
            ProcesoDictamen ("0200900100220252235000001", "Autorizado");
            ProcesoVerificarDictamen("0200900100220252235000001");
            ProcesoAutorizacion("0200900100220252235000001");
            */

            BajaProgramasRFC( "TICPSE.PROSEC" , "TSD931210493", "MOVPSE.AT");

            //Ingreso y Rol
            loginFirmSoli.login(tramiteM);
            //mainPage90102.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
            //mainPage90102.btnacep.click();
            //Búsqueda de tramite
            mainPage90102.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
            $(withText("Solicitudes nuevas")).click();
            $("[alt='Secretaría de Economía']").click();
            $x("//a[contains(text(),'PROSEC')]//span[text()='[+]']").click();
            mainPage90102.linkAutorizacionProgramaNuevo.click();
            mainPage90102.linkAutorizacionProductorIndirecto.click();
            //mainPage90102.elementoTramite90102.click();

            //Lista de productores indirectos
            metodos.scrollIncremento(1);
            mainPage90102.gridPrograma1.doubleClick();

            //Paso 1 CAPTURAR SOLICITUD
            //Consulta de domicilios
            mainPage90102.domiciliosPlantas.click();
            mainPage90102.estadoPlantas.sendKeys(new CharSequence[]{"QUERÉTARO"});
            mainPage90102.mostrarDomicilios.click();
            mainPage90102.seleccionaPlanta.click();
            mainPage90102.agregarPlanta.click();
            mainPage90102.actividadProductiva.selectOption("AGRICULTURA"); sleep(1000);

            //Pestaña Sectores y mercancías
            mainPage90102.Scrol.scrollTo();
            mainPage90102.sectoresMercancias.click();
            //Datos de la solicitud
            mainPage90102.sector.selectOption("V-De la Industria del Calzado");
            mainPage90102.agregarSector.click();
            mainPage90102.selecSector.click();
            //Mercancías a producir
            mainPage90102.fraccionArancelaria.sendKeys(new CharSequence[]{"64061009"});
            mainPage90102.agregarFraccion.click();
            //Continuar paso 1
            mainPage90102.continuarSoli.click();sleep(1000);


            //Paso 2 REQUERIMIENTOS NECESARIOS
            mainPage90102.continuarArchivos.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage90102.btnAnexar.click();
            mainPage90102.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage90102.btnCerrar.click();
            mainPage90102.inputSiguienteButton.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramiteM);
            String folioText = mainPage90102.folio.getText();
            ObtenerFolio var10000 = obtenerFolio;
            String folioNumber = ObtenerFolio.obtenerFolio(folioText);

            for (String methodName : selectedMethods) {
                switch (methodName) {

                    case "ProcesoRequerimiento90102":
                        ProcesoRequerimiento(folioNumber); // O 'Rechazado'
                        break;
                    case "ProcesoAutorizarRequerimiento90102":
                        ProcesoAutorizarRequerimiento(folioNumber); // O 'Rechazado'
                        break;
                    case "ProcesoConfirmarRequerimiento90102":
                        ConfirmarNotificacionRequerimiento(folioNumber, "Moral"); // O 'Rechazado'
                        break;
                    case "ProcesoAtenderRequerimiento90102":
                        ProcesoAtenderRequerimiento(folioNumber, "Moral"); // O 'Rechazado'
                        break;
                    case "ProcesoGenerarOpinion90102":
                        ProcesoGenerarOpinion(folioNumber); // O 'Rechazado'
                        break;
                    case "ProcesoRegistrarOpinion90102":
                        ProcesoRegistrarOpinion(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    case "ProcesoDictamen90102":
                        ProcesoDictamen(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    case "ProcesoAutorizacion90102":
                        ProcesoAutorizacion(folioNumber);
                        break;
                    case "ProcesoConfirmarNotificaciónResolucion90102":
                        ProcesoConfirmarNotificaciónResolucion(folioNumber, "Moral");
                        break;
                }

            }
        }, repeticiones);
    }

    public void ProcesoRequerimiento (String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramiteFun);sleep(3000);
        mainPage90102.iniciofun.click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(3000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(5500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(4000);
        $("input[name='opcion'][value='?mostrarRequerimiento=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        mainPage90102.justificaRequerimiento.sendKeys("PRUEBAS QA");
        //mainPage90102.selecDocumentos.selectOption("Documentos");
        mainPage90102.tabSeleccionarDocumentos.click();
        //$("a.sbSelector").click();
        //$$("div.sbHolder ul.sbOptions li.evenCombo a").findBy(text("Dictamen de Verificación o inspección")).click();
        //mainPage90102.btnAgregarNuevoDocumento.click();
        mainPage90102.gridDocumento1.click();
        $("input[type='button'][value='Guardar y Firmar']").click(); sleep(1000);
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000);sleep(4000);
    }

    public void ProcesoAutorizarRequerimiento (String folioNumber) {
        //open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000);sleep(4000);
    }

    public void ConfirmarNotificacionRequerimiento (String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramiteM); sleep(1000);
            //mainPage90102.selecRol.sendKeys("Persona Moral");sleep(1000);
            //mainPage90102.btnacep.click();
        }

        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).doubleClick();
        $("input[name='mostrarFirma'][value='Firmar']").click(); sleep(1000);

        if (usuario.equals("Moral")) {
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }
    }

    public void ProcesoAtenderRequerimiento (String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramiteM); sleep(1000);
            //mainPage90102.selecRol.sendKeys("Persona Moral");sleep(1000);
            //mainPage90102.btnacep.click();
        }

        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Continuar']").click(); sleep(1000);
        //$("input[name='guardarDatos'][value='Siguiente']").click(); sleep(1000);
        metodos.cargarDocumentos();
        mainPage90102.btnAnexar.click();
        mainPage90102.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
        mainPage90102.btnCerrar.click();
        mainPage90102.continuarSoli.click();

        if (usuario.equals("Moral")) {
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }
    }

    public void ProcesoGenerarOpinion (String folioNumber){

        // Obtener la fecha de (hoy+Meses) formateada
        LocalDate fecha = LocalDate.now();
        fecha = fecha.plusDays(2);
        while (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
            fecha = fecha.plusDays(1);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaVisitaRegistro = fecha.format(formatter);

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        mainPage90102.iniciofun.click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[name='opcion'][value='?mostrarOpinion=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage90102.fechaVisita, fechaVisitaRegistro);
        $("input[name='guardar'][value='Guardar']").doubleClick();

    }

    public void ProcesoRegistrarOpinion (String folioNumber, String sentidoDict){

        // Obtener la fecha de (hoy+Meses) formateada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaVisitaRegistro = LocalDate.now().plusDays(2).format(formatter);
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");

        mainPage90102.iniciofun.click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(3000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        //$("input[name='opcion'][value='?mostrarOpinion=']").click();
        if (sentidoDict.equals("Autorizado")) {
            $("input[name='opinion'][value='SEOP.AC']").click();
        } else if (sentidoDict.equals("Rechazado")) {
            $("input[name='opinion'][value='SEOP.RZ']").click();
        }

        mainPage90102.Opinion.sendKeys("QA Opinion");
        mainPage90102.btnAnexarInformacionOpinion.click();
        String rutaArchivo = "C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf";
        File archivo = new File(rutaArchivo);
        $("input[name='archivo'][type='file']").uploadFile(archivo);
        mainPage90102.btnEnviarDocumentoOpinion.click();
        // mainPage90102.btnCerrarAnexarInformacion.click();
        mainPage90102.btnGuardarEnviarOpinion.click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000);sleep(4000);
        sleep(2000);

    }

    public void ProcesoDictamen(String folioNumber, String sentidoDict) {

        //WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        // Obtener la fecha de (hoy+Meses) formateada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicioVigenciaGenerado = LocalDate.now().format(formatter);
        String fechaFinVigenciaGenerado = LocalDate.now().plusDays(15).format(formatter);

       // loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        // Búsqueda de Folio
        mainPage90102.iniciofun.click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(3000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        mainPage90102.generaDict.click();
        mainPage90102.btmContinuarDict.click();
        mainPage90102.justificacionDictamen.sendKeys("PRUEBAS QA");
        //executeJavaScript("arguments[0].value = arguments[1];", mainPage90102.fechaFinVigencia,fechaFinVigenciaGenerado);
        $("input[type='submit'][value='Firmar']").click(); sleep(1000);

        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoVerificarDictamen (String folioNumber) {

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(2000);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick(); sleep(3000);
        $("input[type='submit'][value='Firmar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(4000);
    }

    public void ProcesoAutorizacion(String folioNumber) {

        mainPage90102.iniciofun.click();
        mainPage90102.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage90102.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Autorizar dictamen']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion(String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramiteM); sleep(1000);
            //mainPage90102.selecRol.sendKeys("Persona Moral");sleep(1000);
            //mainPage90102.btnacep.click();
            mainPage90102.inputNumFolio.sendKeys(folioNumber);sleep(1500);
            $("input[type='button'][value='Buscar']").click();
            metodos.scrollIncremento(1);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).shouldBe(visible).doubleClick();
            mainPage90102.btnFirmarNotificacion.click();sleep(1000);
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }

    }

    //Metodo para traer el folio mas actual según el id tipo trámite y el estatus en que lo quieres,
    //Ejemplo: id tipo trámite 130121 y estatus ESTSOL.AU para generar un subsecuente.
    public void BajaProgramasRFC(String tipoConfPrograma ,String RFC, String estatusPrograma) {

        // 1. CONSTRUIR LA SENTENCIA SQL PARA CONSULTA
        String sql =
                "SELECT pa.NUM_FOLIO_PROGRAMA_SE , pa.RFC " +
                        "FROM VUC_PROGRAMA_AUTORIZADO_SE pa " +
                        "WHERE pa.IDE_TIPO_CONF_PROGRAMA_SE = ? " + // IDs de Trámite (dinámico)
                        "  AND pa.RFC = ? " +
                        "  AND pa.IDE_MOVIMIENTO_PROG_SE = ? " + // RFC Capturista (parámetro)
                        "ORDER BY pa.ID_PROGRAMA_AUTORIZADO_SE DESC";

        // 2.CONSTRUIR EL UPDATE
        String sqlUpdate = "UPDATE VUC_PROGRAMA_AUTORIZADO_SE pa SET IDE_MOVIMIENTO_PROG_SE = ? WHERE pa.IDE_TIPO_CONF_PROGRAMA_SE = ?  AND pa.RFC = ? AND pa.IDE_MOVIMIENTO_PROG_SE = ? ";


        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                "vucem_app_p01",
                "Mfk22nvW6na71DgBXi5R");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tipoConfPrograma); // Tipo de programa
            ps.setString(2, RFC); // Capturista
            ps.setString(3, estatusPrograma); //Estatus del programa

            try (ResultSet rs = ps.executeQuery()) {

                //Declarar variables para mostrar valores de la consulta
                int index = 0;
                String numFolio = null;
                String rfcPrograma = null;

                while  (rs.next()) {

                    numFolio = rs.getString("NUM_FOLIO_PROGRAMA_SE");
                    rfcPrograma = rs.getString("RFC");

                    // --- INICIO: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                    System.out.println("FOLIO " + (index + 1) + ": " + numFolio + " (Capturista: " + rfcPrograma + ")");
                    index++;
                    System.out.println("------------------------------------");
                    // --- FIN: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                }
                System.out.println("TOTAL DE PROGRAMAS ENCONTRADOS: " + index);
                System.out.println("------------------------------------");

                if (index > 0) {

                    try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {

                        psUpdate.setString(1, "MOVPSE.C");
                        psUpdate.setString(2, tipoConfPrograma);
                        psUpdate.setString(3, RFC);
                        psUpdate.setString(4, estatusPrograma);

                        // Ejecuta la actualización
                        int filasAfectadas = psUpdate.executeUpdate();

                        System.out.println("------------------------------------");
                        System.out.println("UPDATE VUC_PROGRAMA_AUTORIZADO_SE:");
                        //System.out.println("Folio actualizado: " + numFolioTramite);
                        //System.out.println("Nueva FEC_FIN_VIGENCIA: " + nuevaFechaFinVigencia);
                        System.out.println("Filas afectadas: " + filasAfectadas);
                        System.out.println("------------------------------------");
                    }
                } else {
                    System.out.println("ADVERTENCIA: No se encontró ningún programa autorizado.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }

    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{Condition.visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }

}

