package HACIENDA.Tramite32616;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32616Test {

    MainPage32616 mainPage32616 = new MainPage32616();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32616 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32616() {
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }

//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32616");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32616");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32616");

//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }

        List<String> selectedMethods = new ArrayList<>();

        ejecutarProcesoNRunnable(() -> {

            ejecutarRutaTramite();

            ejecutarDatosComunes();

            ejecutarTercerosRelacionados();

            ejecutarMensajeriaPaqueteria();

            ejecutarPerfilMensajeriaPaqueteria();

            loginFirmSoli.firma(tramite32616);

            //          Obtener el texto del folio
            String folioText = mainPage32616.folio.getText();

//          Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaTramite() {
        loginFirmSoli.login(tramite32616);
        mainPage32616.selecRol.sendKeys("Persona Moral");
        mainPage32616.btnacep.click();
        mainPage32616.Tramites.sendKeys("Solicitudes nuevas");
        mainPage32616.SoliNew.click();
        mainPage32616.hacienda.click();
        mainPage32616.registrosComercioExt.click();
        mainPage32616.solicitudRegistro.click();
        mainPage32616.Tramite32616.click();
    }

    public void ejecutarDatosComunes() {
        mainPage32616.datosComunes.click(); sleep(500);
        mainPage32616.sectorProductivo.sendKeys("Automotriz terminal"); sleep(500);
        mainPage32616.cumplimientoObligacionesSi.click(); sleep(500);
        mainPage32616.autorizoSATSi.click(); sleep(500);
        mainPage32616.empleadosPropiosSi.click(); sleep(500);
        mainPage32616.numEmpleadosPropios.sendKeys("20"); sleep(500);
        mainPage32616.bimestreEmpleadosPropios.sendKeys("Mayo - Junio"); sleep(500);
        mainPage32616.isrSi.click(); sleep(500);
        mainPage32616.pagoCuotasObreroPatronalesSi.click(); sleep(500);
        mainPage32616.subcontratacionSi.click(); sleep(500);
        mainPage32616.agregarSubcontratado.click(); sleep(500);
        mainPage32616.rfcSubcontratado.setValue("MAVL621207C95"); sleep(2000);
        mainPage32616.click.click(); sleep(500);
        mainPage32616.btnBuscarRfcSub.click(); sleep(500);
        mainPage32616.NumEmpleado.sendKeys("10"); sleep(500);
        mainPage32616.Periodo.sendKeys("Julio-Agosto"); sleep(500);
        mainPage32616.btnAcept.click(); sleep(500);
        mainPage32616.btnAcept2.click(); sleep(500);
        mainPage32616.Check1.click(); sleep(500);
        mainPage32616.Check2.click(); sleep(500);
        mainPage32616.Check3.click(); sleep(500);
        mainPage32616.Check4.click(); sleep(500);
        mainPage32616.Check5.click(); sleep(500);
        mainPage32616.Check6.click(); sleep(500);
        mainPage32616.Immex.sendKeys("82024 - Autorización Programa Nuevo Servicio"); sleep(500);
        mainPage32616.btnAgregarInstal.click(); sleep(500);
        mainPage32616.Entidad.sendKeys("SINALOA"); sleep(500);
        mainPage32616.checkEntidad.click(); sleep(500);
        mainPage32616.btnAceptEntidad.click(); sleep(500);

        mainPage32616.CheckSelec.click(); sleep(500);
        mainPage32616.btnModif.click(); sleep(500);
        mainPage32616.CheckSi.click(); sleep(500);
        mainPage32616.TipoInstalacion.sendKeys("Planta Productiva");
        mainPage32616.CheckNo1.click(); sleep(500);
        mainPage32616.CheckNo2.click(); sleep(500);
        mainPage32616.CheckNo3.click(); sleep(500);
        mainPage32616.btnAceptModif1.click(); sleep(500);
        mainPage32616.btnAceptModif2.click(); sleep(500);

        mainPage32616.Check7.click(); sleep(500);
        mainPage32616.Check8.click(); sleep(500);

        mainPage32616.CargaExtranjero.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls"); sleep(500);
        mainPage32616.CargaExtAcept.click(); sleep(5000);
        presionarEscYSpace();

        mainPage32616.CargaNacional.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls"); sleep(500);
        mainPage32616.CargaNacAcept.click(); sleep(5000);
        presionarEscYSpace();

        mainPage32616.Querella.click(); sleep(500);
        mainPage32616.ControlInvent.click(); sleep(500);
        mainPage32616.NombreCInvent.sendKeys("Nombre Control Inventarial"); sleep(500);
        mainPage32616.LugarCInvent.sendKeys("Lugar Control Inventarial"); sleep(500);
        mainPage32616.btnAgregarControlInvent.click(); sleep(500);
        mainPage32616.btnAceptControlInvent.click(); sleep(500);

        mainPage32616.CheckInvt.click(); sleep(500);
        mainPage32616.btnAgregarMiembroEmpresa.click(); sleep(500);
        mainPage32616.Caracter.sendKeys("Administrador único"); sleep(500);
        mainPage32616.Obligado.click(); sleep(500);
        mainPage32616.RFCMiembroEmpresa.sendKeys("MAVL621207C95"); sleep(500);
        mainPage32616.btnBuscarEmpresa.click(); sleep(500);
        mainPage32616.Nacionalidad.sendKeys("ANGUILA"); sleep(500);
        mainPage32616.btnAceptarMiembroEmpresa.click(); sleep(500);
        mainPage32616.btnAceptMiemEmpres.click(); sleep(500);
        mainPage32616.Manifiesto1.click(); sleep(500);
        mainPage32616.Manifiesto2.click(); sleep(500);
        mainPage32616.Manifiesto3.click(); sleep(500);
    }

    public void ejecutarTercerosRelacionados() {
        mainPage32616.PestTercerosR.click(); sleep(500);
        mainPage32616.RFCTerceros.sendKeys("MAVL621207C95");
        mainPage32616.btnBuscarRFCTerceros.click(); sleep(500);
        mainPage32616.btnAceptRFCTerceros.click(); sleep(500);

        mainPage32616.btnAgregarEnOp.click(); sleep(500);
        mainPage32616.RFCenop.sendKeys("MAVL621207C95");
        mainPage32616.btnBuscarEnop.click(); sleep(500);
        mainPage32616.cargo1.sendKeys("jefe");
        mainPage32616.btnAgreEnop.click(); sleep(500);

        mainPage32616.btnAgregarEnOp.click(); sleep(500);
        mainPage32616.RFCenop.doubleClick();
        mainPage32616.RFCenop.sendKeys("LEQI8101314S7");
        mainPage32616.btnBuscarEnop.click(); sleep(500);
        mainPage32616.cargo1.sendKeys("suplente");
        mainPage32616.CheckSuplente.click(); sleep(500);
        mainPage32616.btnAgreEnop.click(); sleep(500);
    }

    public void ejecutarMensajeriaPaqueteria() {
        /// Fecha del dia
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        // Llave de pago
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 8;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada).toUpperCase();;

        mainPage32616.MesnajeriayPaqueteria.click(); sleep(500);
        mainPage32616.CheckSoli1.click(); sleep(500);
        mainPage32616.CheckSoli2.click(); sleep(500);
        mainPage32616.Si1.click(); sleep(500);
        mainPage32616.Si2.click(); sleep(500);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32616.FechaVig, fechaHoy);sleep(500);
        mainPage32616.nAutoriza.sendKeys("01"); sleep(500);
        mainPage32616.Si3.click(); sleep(500);
        mainPage32616.Si4.click(); sleep(500);
        mainPage32616.SiAutorizo.click(); sleep(500);
        mainPage32616.Si5.click(); sleep(500);
        mainPage32616.Si6.click(); sleep(500);
        mainPage32616.Si7.click(); sleep(500);
        mainPage32616.No1.click(); sleep(500);
        mainPage32616.No2.click(); sleep(500);
        mainPage32616.No3.click(); sleep(500);
        mainPage32616.Public.click(); sleep(500);
        mainPage32616.nOperacion.sendKeys("36453654"); sleep(500);
        mainPage32616.Banco.sendKeys("BANCO AZTECA"); sleep(500);
        mainPage32616.llavePago.sendKeys(llavePago); sleep(500);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32616.fechaPago, fechaHoy);sleep(500);
    }

    public void ejecutarPerfilMensajeriaPaqueteria() {

        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);

         mainPage32616.perfilMensajeria.click();
         mainPage32616.DomicInstalacion.sendKeys("OK");

         mainPage32616.aOpe.sendKeys("2");
         mainPage32616.prodPre.sendKeys("2");
         mainPage32616.exp.sendKeys("2");
         mainPage32616.imp.sendKeys("2");
         mainPage32616.nTotalInst.sendKeys("2");
         mainPage32616.m2.sendKeys("2");

         mainPage32616.nombre1.sendKeys("nombre1");
         mainPage32616.cat1.sendKeys("cat1");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32616.Vig1, fechaHoy);sleep(500);

        mainPage32616.nombre2.sendKeys("nombre2");
        mainPage32616.cat2.sendKeys("cat2");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32616.Vig2, fechaHoy);sleep(500);

        mainPage32616.nombre3.sendKeys("nombre3");
        mainPage32616.cat3.sendKeys("cat3");
        executeJavaScript("arguments[0].value = arguments[1];", mainPage32616.Vig3, fechaHoy);sleep(500);

        mainPage32616.Pest1.click();
        mainPage32616.pest1M1.sendKeys("OK");
        mainPage32616.pest1M2.sendKeys("OK");
        mainPage32616.pest1M3.sendKeys("OK");
        mainPage32616.pest1M4.sendKeys("OK");
        mainPage32616.pest1M5.sendKeys("OK");
        mainPage32616.pest1M6.sendKeys("OK");
        mainPage32616.pest1Check1.click();
        mainPage32616.pest1Check2.click();
        mainPage32616.pest1M7.sendKeys("OK");
        mainPage32616.pest1M8.sendKeys("OK");
        mainPage32616.pest1M9.sendKeys("OK");
        mainPage32616.pest1M10.sendKeys("OK");
        mainPage32616.pest1Check3.click();
        mainPage32616.pest1M11.sendKeys("OK");
        mainPage32616.pest1M12.sendKeys("OK");
        mainPage32616.pest1M13.sendKeys("OK");
        mainPage32616.pest1M14.sendKeys("OK");
        mainPage32616.pest1M15.sendKeys("OK");
        mainPage32616.pest1Check4.click();

        mainPage32616.pest2.click();
        mainPage32616.pest2M1.sendKeys("OK");
        mainPage32616.pest2M2.sendKeys("OK");
        mainPage32616.pest2M3.sendKeys("OK");
        mainPage32616.pest2M4.sendKeys("OK");
        mainPage32616.pest2M5.sendKeys("OK");
        mainPage32616.pest2M6.sendKeys("OK");
        mainPage32616.pest2M7.sendKeys("OK");
        mainPage32616.pest2M8.sendKeys("OK");
        mainPage32616.pest2M9.sendKeys("OK");
        mainPage32616.pest2M10.sendKeys("OK");
        mainPage32616.pest2M11.sendKeys("OK");
        mainPage32616.pest2M12.sendKeys("OK");
        mainPage32616.pest2M13.sendKeys("OK");
        mainPage32616.pest2M14.sendKeys("OK");
        mainPage32616.pest2M15.sendKeys("OK");
        mainPage32616.pest2M16.sendKeys("OK");
        mainPage32616.pest2M17.sendKeys("OK");
        mainPage32616.pest2M18.sendKeys("OK");
        mainPage32616.pest2M19.sendKeys("OK");
        mainPage32616.pest2M20.sendKeys("OK");
        mainPage32616.pest2M21.sendKeys("OK");
        mainPage32616.pest2Check1.click();
        mainPage32616.pest2M22.sendKeys("OK");
        mainPage32616.pest2M23.sendKeys("OK");
        mainPage32616.pest2Check2.click();
        mainPage32616.pest2M24.sendKeys("OK");
        mainPage32616.pest2M25.sendKeys("OK");
        mainPage32616.pest2M26.sendKeys("OK");
        mainPage32616.pest2M27.sendKeys("OK");
        mainPage32616.pest2M28.sendKeys("OK");
        mainPage32616.pest2M29.sendKeys("OK");
        mainPage32616.pest2M30.sendKeys("OK");
        mainPage32616.pest2M31.sendKeys("OK");
        mainPage32616.pest2M32.sendKeys("OK");
        mainPage32616.pest2Check3.click();
        mainPage32616.pest2Check4.click();
        mainPage32616.pest2M33.sendKeys("OK");
        mainPage32616.pest2M34.sendKeys("OK");
        mainPage32616.pest2M35.sendKeys("OK");
        mainPage32616.pest2M36.sendKeys("OK");
        mainPage32616.pest2M37.sendKeys("OK");
        mainPage32616.pest2M38.sendKeys("OK");
        mainPage32616.pest2M39.sendKeys("OK");
        mainPage32616.pest2M40.sendKeys("OK");
        mainPage32616.pest2M41.sendKeys("OK");
        mainPage32616.pest2M42.sendKeys("OK");
        mainPage32616.pest2M43.sendKeys("OK");
        mainPage32616.pest2Check5.click();
        mainPage32616.pest2M44.sendKeys("OK");
        mainPage32616.pest2M45.sendKeys("OK");
        mainPage32616.pest2M46.sendKeys("OK");
        mainPage32616.pest2M47.sendKeys("OK");
        mainPage32616.pest2Check6.click();
        mainPage32616.pest2M48.sendKeys("OK");

        mainPage32616.pest3.click();
        mainPage32616.pest3M1.sendKeys("OK");
        mainPage32616.pest3M2.sendKeys("20");
        mainPage32616.pest3M3.sendKeys("OK");
        mainPage32616.pest3M4.sendKeys("OK");
        mainPage32616.pest3M5.sendKeys("OK");
        mainPage32616.pest3M6.sendKeys("OK");
        mainPage32616.pest3M7.sendKeys("OK");
        mainPage32616.pest3M8.sendKeys("OK");
        mainPage32616.pest3M9.sendKeys("OK");
        mainPage32616.pest3M10.sendKeys("OK");
        mainPage32616.pest3M11.sendKeys("OK");
        mainPage32616.pest3M12.sendKeys("OK");
        mainPage32616.pest3M13.sendKeys("OK");
        mainPage32616.pest3Check1.click();
        mainPage32616.pest3M14.sendKeys("OK");
        mainPage32616.pest3M15.sendKeys("OK");
        mainPage32616.pest3M16.sendKeys("OK");
        mainPage32616.pest3M17.sendKeys("OK");
        mainPage32616.pest3M18.sendKeys("OK");
        mainPage32616.pest3M19.sendKeys("OK");
        mainPage32616.pest3M20.sendKeys("OK");

        mainPage32616.pest4.click();
        mainPage32616.pest4M1.sendKeys("OK");
        mainPage32616.pest4M2.sendKeys("OK");
        mainPage32616.pest4M3.sendKeys("OK");
        mainPage32616.pest4M4.sendKeys("OK");
        mainPage32616.pest4M5.sendKeys("OK");
        mainPage32616.pest4M6.sendKeys("OK");
        mainPage32616.pest4M7.sendKeys("OK");
        mainPage32616.pest4M8.sendKeys("OK");
        mainPage32616.pest4M9.sendKeys("OK");
        mainPage32616.pest4M10.sendKeys("OK");
        mainPage32616.pest4M11.sendKeys("OK");
        mainPage32616.pest4M12.sendKeys("OK");
        mainPage32616.pest4Check1.click();

        mainPage32616.pest5.click();
        mainPage32616.pest5M1.sendKeys("OK");
        mainPage32616.pest5M2.sendKeys("OK");
        mainPage32616.pest5Check1.click();
        mainPage32616.pest5M3.sendKeys("OK");
        mainPage32616.pest5M4.sendKeys("OK");
        mainPage32616.pest5M5.sendKeys("OK");
        mainPage32616.pest5M6.sendKeys("OK");
        mainPage32616.pest5M7.sendKeys("OK");
        mainPage32616.pest5M8.sendKeys("OK");
        mainPage32616.pest5M9.sendKeys("OK");
        mainPage32616.pest5M10.sendKeys("OK");
        mainPage32616.pest5M11.sendKeys("OK");
        mainPage32616.pest5M12.sendKeys("OK");
        mainPage32616.pest5M13.sendKeys("OK");

        mainPage32616.pest6.click();
        mainPage32616.pest6M1.sendKeys("OK");
        mainPage32616.pest6M2.sendKeys("OK");
        mainPage32616.pest6M3.sendKeys("OK");
        mainPage32616.pest6M4.sendKeys("OK");
        mainPage32616.pest6M5.sendKeys("OK");

        mainPage32616.pest7.click();
        mainPage32616.pest7M1.sendKeys("OK");
        mainPage32616.pest7M2.sendKeys("OK");
        mainPage32616.pest7Check1.click();
        mainPage32616.pest7Check2.click();
        mainPage32616.pest7M3.sendKeys("OK");
        mainPage32616.pest7M4.sendKeys("OK");
        mainPage32616.pest7M5.sendKeys("OK");

        mainPage32616.pest8.click();
        mainPage32616.pest8M1.sendKeys("OK");
        mainPage32616.pest8M2.sendKeys("OK");
        mainPage32616.pest8M3.sendKeys("OK");
        mainPage32616.pest8M4.sendKeys("OK");
        mainPage32616.pest8M5.sendKeys("OK");
        mainPage32616.pest8M6.sendKeys("OK");
        mainPage32616.pest8Check1.click();
        mainPage32616.pest8M7.sendKeys("OK");
        mainPage32616.pest8M8.sendKeys("OK");
        mainPage32616.pest8M9.sendKeys("OK");
        mainPage32616.pest8M10.sendKeys("OK");
        mainPage32616.pest8M11.sendKeys("OK");
        mainPage32616.pest8M12.sendKeys("OK");
        mainPage32616.pest8Check2.click();

        mainPage32616.pest9.click();
        mainPage32616.pest9M1.sendKeys("OK");
        mainPage32616.pest9M2.sendKeys("OK");
        mainPage32616.pest9M3.sendKeys("OK");
        mainPage32616.pest9M4.sendKeys("OK");
        mainPage32616.pest9M5.sendKeys("OK");
        mainPage32616.pest9M6.sendKeys("OK");
        mainPage32616.pest9M7.sendKeys("OK");
        mainPage32616.pest9M8.sendKeys("OK");
        mainPage32616.pest9M9.sendKeys("OK");
        mainPage32616.pest9M10.sendKeys("OK");
        mainPage32616.pest9M11.sendKeys("OK");
        mainPage32616.pest9M12.sendKeys("OK");
        mainPage32616.pest9M13.sendKeys("OK");
        mainPage32616.pest9M14.sendKeys("OK");
        mainPage32616.pest9M15.sendKeys("OK");
        mainPage32616.pest9M16.sendKeys("OK");
        mainPage32616.pest9M17.sendKeys("OK");
        mainPage32616.pest9M18.sendKeys("OK");
        mainPage32616.pest9M19.sendKeys("OK");
        mainPage32616.pest9M20.sendKeys("OK");
        mainPage32616.pest9M21.sendKeys("OK");

        mainPage32616.pest10.click();
        mainPage32616.pest10M1.sendKeys("OK");
        mainPage32616.pest10M2.sendKeys("OK");
        mainPage32616.pest10M3.sendKeys("OK");
        mainPage32616.pest10M4.sendKeys("OK");
        mainPage32616.pest10M5.sendKeys("OK");
        mainPage32616.pest10M6.sendKeys("OK");
        mainPage32616.pest10M7.sendKeys("OK");
        mainPage32616.pest10M8.sendKeys("OK");
        mainPage32616.pest10M9.sendKeys("OK");
        mainPage32616.pest10M10.sendKeys("OK");
        mainPage32616.pest10M11.sendKeys("OK");

        mainPage32616.pest11.click();
        mainPage32616.pest11M1.sendKeys("OK");
        mainPage32616.pest11M2.sendKeys("OK");
        mainPage32616.pest11M3.sendKeys("OK");
        mainPage32616.pest11M4.sendKeys("OK");
        mainPage32616.pest11M5.sendKeys("OK");
        mainPage32616.pest11M6.sendKeys("OK");
        mainPage32616.pest11M7.sendKeys("OK");
        sleep(1000);

        mainPage32616.btnContiReq.click(); sleep(500);

        ///CargaDocumReq
        mainPage32616.btnSig.click(); sleep(500);
        mainPage32616.btnAdjunt.click(); sleep(500);
        mainPage32616.doc1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc21.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc22.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc23.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc24.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc25.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc26.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc27.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc28.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc29.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc30.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc31.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc32.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc33.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc34.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc35.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc36.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc37.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc38.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc39.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc40.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc41.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc42.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc43.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc44.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc45.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc46.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc47.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc48.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc49.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc50.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.doc51.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        mainPage32616.btnCargarDigi.click(); sleep(60000);
        mainPage32616.btnCerrarDigi.click(); sleep(500);
        mainPage32616.btnContiFirm.click(); sleep(500);
    }

    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }
}
