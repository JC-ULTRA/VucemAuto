package COFEPRIS.Tramite261401;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage261401Test {
    MainPage261401 mainPage261401 = new MainPage261401();
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
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        Configuration.timeout = 900; // Tiempo de espe
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso261401() {
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



        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen261401");
        JCheckBox verificarCheckBox = new JCheckBox("ProcesoVerificarDictamen261401");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion261401");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion261401");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox,verificarCheckBox,  autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen261401");
        if (verificarCheckBox.isSelected()) selectedMethods.add("ProcesoVerificarDictamen261401");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion261401");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion261401");
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        ejecutarProcesoNRunnable(() -> {

            String numFolioPadre = obtenerNumFolioTramite("260401", "AAL0409235E6" ,"ESTTR.CN","ESTSOL.AU", "261401");

            if (numFolioPadre != null) {
                // Caso 1: Se encontró un folio. Continuar con la modificación
                System.out.println("Continuando con la modificación del folio: " + numFolioPadre);
            } else {
                // Caso 2: No se encontró ningún folio disponible.
                System.out.println("Proceso de restablecer una modificación en proceso");
                numFolioPadre = obtenerNumFolioTramiteModificacion("261401", "AAL0409235E6");
                if(numFolioPadre != null){
                    System.out.println("Continuando con la actualización: " + numFolioPadre);
                } else {
                    return;}

            }

//          Ingreso y selección de trámite
            loginFirmSoli.login(tramiteM);
            mainPage261401.selecRol.sendKeys("Persona Moral");
            mainPage261401.btnacep.click();
            sleep(1000);
            mainPage261401.Tramites.click();
            $(withText("Solicitudes subsecuentes")).click();
            mainPage261401.inputIdFolio.sendKeys(numFolioPadre);
            mainPage261401.inputBuscarButton.click(); sleep(2000);
            sleep(1000);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(numFolioPadre)).shouldBe(visible).doubleClick();
            //mainPage261401.SolicitudTramite.doubleClick();
            mainPage261401.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage261401.labelDatosSolicitud.click();
            Selenide.sleep(100);
//            mainPage261401.inputModif.click();sleep(1000);
//            Selenide.sleep(100);
            mainPage261401.textareaJustificacionId.sendKeys("TRABAJO DE PRUEBAS");
            //mainPage261401.inputRazonSocial.setValue("TSD931210493");
            mainPage261401.inputDenominación.setValue("EMPRESA S.A. DE C.V.");
            mainPage261401.inputEmail.setValue("contacto@empresa.com");
            mainPage261401.inputCodigoPostal.setValue("01000");
            mainPage261401.inputEstado.sendKeys("COLIMA");
            mainPage261401.inputMunicipoAlcaldia.setValue("Álvaro Obregón");
            mainPage261401.inputLocalidad.setValue("Colonia Industrial");
            mainPage261401.inputColonia.setValue("Ampliación San Ángel");
            mainPage261401.inputCalle.setValue("Av. Revolución");
            mainPage261401.inputLada.setValue("52");
            mainPage261401.inputTelefono.setValue("12345678");
            mainPage261401.inputRegimen.sendKeys("Temporles");
            mainPage261401.inputAduanaSalida.sendKeys("ALTAMIRA");
            mainPage261401.checkBoxMercancia.click();
            mainPage261401.btnModificar.click();

//            mainPage261401.selectClasificacionProducto.sendKeys("BIOLOGICOS");
//            mainPage261401.selectSubClasificacionProducto.sendKeys("I. Toxoides, vacunas y preparaciones bacterianas de uso parenteral");
            mainPage261401.inputDenominacionEspecifica.setValue("Denominación específica de prueba");
            mainPage261401.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage261401.inputFraccionArancelaria.setValue("30021299");
            mainPage261401.inputCantidadUMT.setValue("100");
            mainPage261401.inputCantidadUMC.setValue("10");
            mainPage261401.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage261401.textareaPresentacion.setValue("MODIFICACION");
            mainPage261401.inputEnvasePrimario.setValue("TEST");
            mainPage261401.inputEnvaseSecundario.setValue("NUEVO");

//            mainPage261401.inputDenominacionDistintiva.setValue("Distintiva123");
//            mainPage261401.inputDenominacionComunInternacional.setValue("DCI-TEST");
//            mainPage261401.inputEspecifique.setValue("PRUEBA");
            //mainPage261401.selectFormaFarmaceutica.sendKeys("Emulsión");
            //mainPage261401.selectEstadoFisico.sendKeys("Liquido");
            //mainPage261401.textareaPresentacion.setValue("Ampolleta");
            //mainPage261401.inputNumeroRegistroSanitario.sendKeys("1234");
            mainPage261401.buttonAbrirPanelPaisesOrigen.click();
            mainPage261401.PaisOrigen.sendKeys("BUTAN");
            mainPage261401.inputAgregarSeleccion.click();
mainPage261401.inputUsoEspecifico.sendKeys("Diagnóstico");
//            mainPage261401.inputAbrirPanelPaisesProcedencia.click();
//            mainPage261401.PaisProcedencia.sendKeys("ANGOLA");
//            mainPage261401.inputClaveLotes.setValue("1346");
//            executeJavaScript("arguments[0].value = '01/05/2025';", mainPage261401.inputFechaElaboracion);sleep(100);
//            executeJavaScript("arguments[0].value = '09/05/2025';", mainPage261401.inputFechaCaducidad);sleep(100);
            mainPage261401.btnModificarMercancia.click();
//            mainPage261401.inputRFC.setValue("MAVL621207C95");
//            mainPage261401.btnBuscarRFC.click();

            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage261401.labelTerceros.click();
            mainPage261401.checkBoxDestinatario.click();
            mainPage261401.btnModificarDestinatario.click();
            mainPage261401.checkBoxMoral.click();
//            mainPage261401.inputTerceroRFC.setValue("TSD931210493");
//            mainPage261401.btnBuscarEmpresa.click();
            metodos.scrollDecremento(1);
            mainPage261401.inputTerceroRazonSocial.setValue("PRUEBAS SA DE CV");
            mainPage261401.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage261401.inputEstadoLocalidad.sendKeys("COLIMA");
//            mainPage261401.inputTerceroMunicipio.sendKeys("COLIMA");
//            mainPage261401.inputTerceroLocalidad.sendKeys("COLIMA");
            mainPage261401.inputCodigoPostalFabricante.setValue("28010");
//            mainPage261401.terceroColoniaEquiv.setValue("ANTORCHA");
            mainPage261401.terceroCalle.setValue("Lázaro Cárdenas");
            mainPage261401.terceroNumExterior.setValue("13471118");
            mainPage261401.terceroNumInterior.setValue("4A");
            mainPage261401.inputTerceroLada.setValue("52");
            mainPage261401.terceroTelefono.setValue("5533335");
            mainPage261401.terceroCorreo.setValue("contactar@fabricante.com");
            mainPage261401.btnGuardarDatosTerceros.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage261401.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage261401.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage261401.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage261401.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage261401.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage261401.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage261401.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage261401.inputCalendar);
            sleep(100);
            mainPage261401.inputSolicitudPagoImp.sendKeys("5000");
            mainPage261401.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage261401.inputGuarda.click();
            sleep(1000);
            metodos.cargarDocumentos();
            mainPage261401.btnAnexar.click();sleep(2000);
            mainPage261401.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(120));sleep(1000);
            mainPage261401.btnCerrar.click();
            sleep(100);
            mainPage261401.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramiteM);

            String folioText = mainPage261401.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

            for (String methodName : selectedMethods) {
                switch (methodName) {
                    case "ProcesoDictamen261401":
                        ProcesoDictamen(folioNumber, "Autorizado"); // O 'Rechazado'
                        break;
                    case "ProcesoVerificarDictamen261401":
                        ProcesoVerificarDictamen(folioNumber);
                        break;
                    case "ProcesoAutorizacion261401":
                        ProcesoAutorizacion(folioNumber);
                        break;
                    case "ProcesoConfirmarNotificaciónResolucion261401":
                        ProcesoConfirmarNotificaciónResolucion(folioNumber, "Moral");
                        break;
                }

            }

        }, repeticiones);
    }


    public void ProcesoDictamen(String folioNumber, String sentidoDict) {

        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        // Obtener la fecha de (hoy+Meses) formateada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicioVigenciaGenerado = LocalDate.now().format(formatter);
        String fechaFinVigenciaGenerado = LocalDate.now().plusDays(15).format(formatter);

        loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        // Búsqueda de Folio
        mainPage261401.iniciofun.click();
        mainPage261401.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(2000);
        mainPage261401.inputBuscarTareasFuncionario.click();sleep(6500);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();sleep(4000);
        mainPage261401.generaDict.click();
        mainPage261401.btmContinuarDict.click();
        if (sentidoDict.equals("Autorizado")) {
            $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        } else if (sentidoDict.equals("Rechazado")) {
            $("input[name='sentidoDictamen'][value='SEDI.RZ']").click();
        }
        mainPage261401.RestriccionesDictamen.sendKeys("QA");
        mainPage261401.DestinoPara.sendKeys("QA Destino");
        mainPage261401.SiglasDictaminador.sendKeys("MAVL621207C95");
        mainPage261401.selectAsignarAutorizador.selectOptionByValue("MAVL621207C95");
        //executeJavaScript("arguments[0].value = arguments[1];", mainPage261401.fechaVigencia,fechaInicioVigenciaGenerado);
        $("input[type='submit'][value='Guardar y Firmar']").click(); sleep(1000);
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }


    public void ProcesoVerificarDictamen (String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        sleep(3000);
        //loginFirmSoli.loginFun(tramiteFun);sleep(5000);
        $(By.cssSelector("img[src*='icoInicio.png']")).shouldBe(visible).click();
        mainPage261401.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage261401.inputBuscarTareasFuncionario.click();sleep(2000);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick(); sleep(3000);
        $("input[type='submit'][value='Dar Vo. Bo.']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(4000);
    }


    public void ProcesoAutorizacion(String folioNumber) {

        mainPage261401.iniciofun.click();
        mainPage261401.numfolio.sendKeys(folioNumber);sleep(1500);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);sleep(4000);
        mainPage261401.inputBuscarTareasFuncionario.click();sleep(4500);
        $x("//td[@role='gridcell' and contains(text(), '" + folioNumber + "')]").shouldBe(visible).doubleClick();
        $("input[type='submit'][value='Autorizar']").click();
        loginFirmSoli.firmaFun(tramiteFun);sleep(1000); sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion(String folioNumber, String usuario) {

        if (usuario.equals("Moral")) {
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            loginFirmSoli.login(tramiteM); sleep(1000);
            mainPage261401.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage261401.btnacep.click(); sleep(1000);
            mainPage261401.inputNumFolio.sendKeys(folioNumber);sleep(1500);
            $("input[type='button'][value='Buscar']").click();
            metodos.scrollIncremento(1);
            $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.partialText(folioNumber)).shouldBe(visible).doubleClick();
            mainPage261401.btnFirmarNotificacion.click();sleep(1000);
            loginFirmSoli.firma(tramiteM);sleep(1000);sleep(4000);
        }

    }

    //Metodo para traer el folio mas actual según el id tipo trámite y el estatus en que lo quieres,
    public String obtenerNumFolioTramite(String idTipoTramite,String RFC, String ideEstTramite, String ideEstSolicitud, String idTipoTramiteHijo) {

        LocalDate fechaInicioBusqueda = LocalDate.now().plusDays(1);
        LocalDate fechaFinBusqueda = LocalDate.now().plusYears(1);
        String numFolioTramite = null;

        // Convertimos a java.sql.Date para el PreparedStatement
        java.sql.Date sqlFechaInicio = java.sql.Date.valueOf(fechaInicioBusqueda);
        java.sql.Date sqlFechaFin = java.sql.Date.valueOf(fechaFinBusqueda);
/*
        // 2. CONSTRUIR LA SENTENCIA SQL
        String sql =
                "SELECT vt_padre.NUM_FOLIO_TRAMITE, vs_padre.ID_TIPO_TRAMITE " +
                        "FROM VUC_SOLICITUD vs_padre " +
                        "INNER JOIN VUC_TRAMITE vt_padre ON vs_padre.ID_SOLICITUD = vt_padre.ID_SOLICITUD " +
                        "JOIN VUC_RESOLUCION vr_padre ON vt_padre.NUM_FOLIO_TRAMITE = vr_padre.NUM_FOLIO_TRAMITE  " +
                        "WHERE vs_padre.ID_TIPO_TRAMITE = ? " + // IDs de Trámite (dinámico)
                        "  AND vs_padre.NUM_FOLIO_TRAMITE_ORIGINAL IS NULL " +
                        "  AND vs_padre.CVE_USUARIO_CAPTURISTA = ? " + // RFC Capturista (parámetro)
                        "  AND vt_padre.IDE_EST_TRAMITE = ? " + // Estado de Trámite (parámetro)
                        "  AND vs_padre.IDE_EST_SOLICITUD = ? " + // Estado de Solicitud (parámetro)
                        "  AND vr_padre.FEC_FIN_VIGENCIA BETWEEN ? AND ? " + // <--- NUEVOS PLACEHOLDERS PARA LAS FECHAS
                        "  AND NOT EXISTS ( " +
                        "      SELECT 1 " +
                        "      FROM VUC_SOLICITUD vs_hijo " +
                        "      WHERE vs_hijo.NUM_FOLIO_TRAMITE_ORIGINAL = vt_padre.NUM_FOLIO_TRAMITE " + // Correlación al padre actual
                        "        AND vs_hijo.ID_TIPO_TRAMITE = ? " + // 7. ID de Trámite Hijo (parámetro para el tipo de modificación '261401')
                        "  ) " +
                        "ORDER BY vs_padre.FEC_CREACION DESC";
*/

        String sql =
                "SELECT vt_padre.NUM_FOLIO_TRAMITE, vs_padre.ID_TIPO_TRAMITE " + // Solo necesitamos el folio
                        "FROM VUC_SOLICITUD vs_padre " +
                        "INNER JOIN VUC_TRAMITE vt_padre ON vs_padre.ID_SOLICITUD = vt_padre.ID_SOLICITUD " +
                        "JOIN VUC_RESOLUCION vr_padre ON vt_padre.NUM_FOLIO_TRAMITE = vr_padre.NUM_FOLIO_TRAMITE  " +
                        "WHERE vs_padre.ID_TIPO_TRAMITE = ? " + // 1. ID Trámite Padre
                        "  AND vs_padre.NUM_FOLIO_TRAMITE_ORIGINAL IS NULL " +
                        "  AND vs_padre.CVE_USUARIO_CAPTURISTA = ? " + // 2. RFC
                        "  AND vt_padre.IDE_EST_TRAMITE = ? " + // 3. Estado Trámite Padre
                        "  AND vs_padre.IDE_EST_SOLICITUD = ? " + // 4. Estado Solicitud Padre
                        "  AND vr_padre.FEC_FIN_VIGENCIA BETWEEN ? AND ? " + // 5 y 6. Fechas
                        " AND NOT EXISTS ( " +
                        "      SELECT 1 " +
                        "      FROM VUC_SOLICITUD vs_hijo " +
                        "      INNER JOIN VUC_TRAMITE vt_hijo ON vs_hijo.ID_SOLICITUD = vt_hijo.ID_SOLICITUD " +
                        "      WHERE " +
                        "            vs_hijo.NUM_FOLIO_TRAMITE_ORIGINAL = vt_padre.NUM_FOLIO_TRAMITE " +
                        "        AND vs_hijo.ID_TIPO_TRAMITE = ? " + // 7. ID Trámite Hijo
                        "        AND ( " +
                        "               vs_hijo.IDE_EST_SOLICITUD IN ('ESTSOL.AU', 'ESTSOL.RC') " + // Exclusión Solicitud
                        "            OR " +
                        "               vt_hijo.IDE_EST_TRAMITE NOT ('ESTTR.IN', 'ESTTR.CN', 'ESTTR.ED','ESTTR.RS') " + // Exclusión Trámite
                        "            ) " +
                        "  ) " +
                        "ORDER BY vs_padre.FEC_CREACION DESC ";


        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                "vucem_app_p01",
                "Mfk22nvW6na71DgBXi5R");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int index = 1;

            // 1. ASIGNAR PARÁMETROS FIJO
            ps.setString(index++, idTipoTramite); // CVE_USUARIO_CAPTURISTA
            ps.setString(index++, RFC); // CVE_USUARIO_CAPTURISTA
            ps.setString(index++, ideEstTramite); // IDE_EST_TRAMITE
            ps.setString(index++, ideEstSolicitud);

            // 2. ASIGNAR EL RANGO DE FECHAS (Calculado previamente) y tramite hijo
            ps.setDate(index++, sqlFechaInicio); // FEC_FIN_VIGENCIA (Fecha de inicio del rango: Mañana)
            ps.setDate(index++, sqlFechaFin); // FEC_FIN_VIGENCIA (Fecha de fin del rango: Dentro de 30 días)
            ps.setString(index++, idTipoTramiteHijo);


            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    numFolioTramite = rs.getString("NUM_FOLIO_TRAMITE");
                    // --- INICIO: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                    String tipoTramite = rs.getString("ID_TIPO_TRAMITE");
                    System.out.println("------------------------------------");
                    System.out.println("FOLIO ENCONTRADO: " + numFolioTramite);
                    System.out.println("TIPO DE TRÁMITE: " + tipoTramite);
                    System.out.println("------------------------------------");
                    // --- FIN: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                } else {

                    System.out.println(" NO SE ENCONTRÓ ningún folio padre disponible para el usuario (" + RFC + ") que NO tenga una modificación en progreso o autorizado (" + idTipoTramiteHijo + ").");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFolioTramite;
    }

    public String obtenerNumFolioTramiteModificacion(String idTipoTramite,String RFC) {

        LocalDate fechaInicioBusqueda = LocalDate.now().plusDays(1);
        LocalDate fechaFinVigencia = LocalDate.now().plusWeeks(2);
        String numFolioTramiteHijo = null;
        String numFolioPadre = null;
        String numSolicitudHijo = null;

        // Convertimos a java.sql.Date para el PreparedStatement
        //java.sql.Date sqlFechaInicio = java.sql.Date.valueOf(fechaInicioBusqueda);
        java.sql.Date sqlFechaFinVigenciaPadre = java.sql.Date.valueOf(fechaFinVigencia);

        String sql =
                "SELECT vt.NUM_FOLIO_TRAMITE, vs.ID_SOLICITUD, vs.NUM_FOLIO_TRAMITE_ORIGINAL, vs.ID_TIPO_TRAMITE " +
                        "FROM VUC_TRAMITE vt " +
                        "INNER JOIN VUC_SOLICITUD vs ON vt.ID_SOLICITUD = vs.ID_SOLICITUD " +
                        "WHERE " +
                        "    vs.IDE_EST_SOLICITUD = 'ESTSOL.RC' " +
                        "    AND vt.IDE_EST_TRAMITE = 'ESTTR.IN' " +
                        "    AND vs.NUM_FOLIO_TRAMITE_ORIGINAL IS NOT NULL " +
                        //"  AND vr_padre.FEC_FIN_VIGENCIA BETWEEN ? AND ? " +
                        "    AND vs.ID_TIPO_TRAMITE = ? " + //
                        "  AND vs.CVE_USUARIO_CAPTURISTA = ? " +
                        "ORDER BY vs.FEC_CREACION DESC ";


        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1",
                "vucem_app_p01",
                "Mfk22nvW6na71DgBXi5R");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false); // Iniciar transacción para doble UPDATE

            // 1. ASIGNAR PARÁMETROS FIJO
            ps.setString(1, idTipoTramite); // CVE_USUARIO_CAPTURISTA
            ps.setString(2, RFC); // CVE_USUARIO_CAPTURISTA


            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    numFolioTramiteHijo = rs.getString("NUM_FOLIO_TRAMITE");
                    numSolicitudHijo = rs.getString("ID_SOLICITUD");
                    numFolioPadre = rs.getString("NUM_FOLIO_TRAMITE_ORIGINAL");
                    String tipoTramite = rs.getString("ID_TIPO_TRAMITE");

                    // --- INICIO: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                    System.out.println("------------------------------------");
                    System.out.println("FOLIO HIJO ENCONTRADO: " + numFolioTramiteHijo);
                    System.out.println("FOLIO PADRE ENCONTRADO: " + numFolioPadre);
                    System.out.println("ID_SOLICITUD: " + numSolicitudHijo);
                    System.out.println("TIPO DE TRÁMITE: " + tipoTramite);
                    System.out.println("------------------------------------");
                    // --- FIN: CÓDIGO AÑADIDO PARA DESPLEGAR ---
                } else {

                    System.out.println(" NO SE ENCONTRÓ ningún folio hijo disponible para el usuario (" + RFC + ") ");
                    System.out.println("------------------------------------");
                }

            }

            // --- 2. EJECUTAR LIMPIEZA SI SE ENCONTRÓ UN BLOQUEO ---
            if (numFolioPadre != null) {
                System.out.println("⚠️ Tramite hijo encontrado. Ejecutando tres UPDATE para configurar la modificación");

                // UPDATE 1: VUC_TRAMITE (Cambio a 'ESTTR.DS')
                String sqlUpdateTramite = "UPDATE VUC_TRAMITE SET IDE_EST_TRAMITE = 'ESTTR.DS' WHERE NUM_FOLIO_TRAMITE = ?";
                // UPDATE 2: VUC_SOLICITUD (Cambio a 'ESTSOL.EL')
                String sqlUpdateSolicitud = "UPDATE VUC_SOLICITUD SET IDE_EST_SOLICITUD = 'ESTSOL.EL' WHERE ID_SOLICITUD = ?";
                // UPDATE 3: VUC_RESOLUCION (Padre)
                String sqlUpdateResolucion = "UPDATE VUC_RESOLUCION SET FEC_FIN_VIGENCIA = ? WHERE NUM_FOLIO_TRAMITE = ?";


                try (PreparedStatement psUpdateTramite = conn.prepareStatement(sqlUpdateTramite);
                     PreparedStatement psUpdateSolicitud = conn.prepareStatement(sqlUpdateSolicitud);
                     PreparedStatement psUpdateResolucion = conn.prepareStatement(sqlUpdateResolucion)) {

                    // Ejecutar UPDATE 1 y capturar filas actualizadas
                    psUpdateTramite.setString(1, numFolioTramiteHijo);
                    int filasTramite = psUpdateTramite.executeUpdate();
                    System.out.println("✅ VUC_TRAMITE actualizado. Filas afectadas: " + filasTramite);

                    // Ejecutar UPDATE 2 y capturar filas actualizadas
                    psUpdateSolicitud.setString(1, numSolicitudHijo);
                    int filasSolicitud = psUpdateSolicitud.executeUpdate();
                    System.out.println("✅ VUC_SOLICITUD actualizado. Filas afectadas: " + filasSolicitud);
                    System.out.println("------------------------------------");

                    // 🚨 UPDATE 3 (Padre - VUC_RESOLUCION)
                    psUpdateResolucion.setDate(1, sqlFechaFinVigenciaPadre);
                    psUpdateResolucion.setString(2, numFolioPadre);
                    int filasVigencia = psUpdateResolucion.executeUpdate();
                    System.out.println("✅ 3/3 VUC_RESOLUCION (Padre) vigencia extendida al " + sqlFechaFinVigenciaPadre + ". Filas: " + filasVigencia);
                }

                conn.commit(); // Confirmar los cambios

                System.out.println("✅ Limpieza del hijo completada. Folio padre listo para usar.");

            } else {
                System.out.println(" NO SE ENCONTRÓ ningún folio hijo disponible para configurar.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return numFolioPadre;
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