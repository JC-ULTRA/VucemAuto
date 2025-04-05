package Economia.Tramite80102;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.awt.Component;
import java.time.Duration;
import java.util.UUID;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPage80102Test {
    MainPage80102 mainPage80102 = new MainPage80102();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite80102 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Selenide.open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 120000L;
        WebDriverRunner.getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10L));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        options.addArguments(new String[]{"--incognito"});
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso80102() {
        String repeticionesStr = JOptionPane.showInputDialog((Component)null, "Ingrese el número de repeticiones:", "Repeticiones", 3);
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
        } else {
            int repeticiones;
            try {
                repeticiones = Integer.parseInt(repeticionesStr);
            } catch (NumberFormatException var8) {
                repeticiones = 1;
                JOptionPane.showMessageDialog((Component)null, "Valor no válido, se utilizará 1 repetición por defecto.");
            }

            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");
            Object[] params = new Object[]{"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
            int option = JOptionPane.showConfirmDialog((Component)null, params, "Opciones de Métodos", 2);
            if (option != 0) {
                JOptionPane.showMessageDialog((Component)null, "Operación cancelada por el usuario.");
            } else {
                ejecutarProcesoNRunnable(() -> {
                    String uuid = UUID.randomUUID().toString();
                    int longitudDeseada = 16;
                    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
                    loginFirmSoli.login(tramite80102);
                    mainPage80102.selecRol.sendKeys(new CharSequence[]{"Persona Moral"});
                    mainPage80102.btnacep.click();
                    mainPage80102.Tramites.sendKeys(new CharSequence[]{"Solicitudes nuevas"});
                    mainPage80102.SoliNew.click();
                    mainPage80102.economia.click();
                    mainPage80102.immex.click();
                    mainPage80102.autorizarPrograma.click();
                    mainPage80102.nuevoServicio.click();
                    Selenide.sleep(65000L);
                    JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage80102.complementos.click();
                    mainPage80102.preoperativoOk.click();
                    mainPage80102.paginaWeb.sendKeys(new CharSequence[]{"QASQWQ"});
                    mainPage80102.localizacion.sendKeys(new CharSequence[]{"tyuqusha"});
                    mainPage80102.manifiestoImmex.click();
                    mainPage80102.nombreExpedi.sendKeys(new CharSequence[]{"audhunwqhi"});
                    mainPage80102.numNotaria.sendKeys(new CharSequence[]{"120"});
                    mainPage80102.estado.sendKeys(new CharSequence[]{"CHIAPAS"});
                    mainPage80102.numActa.sendKeys(new CharSequence[]{"123"});
                    mainPage80102.fechaEmision.click();
                    mainPage80102.fechaSelec.click();
                    mainPage80102.rfcRepresentante.sendKeys(new CharSequence[]{"LEQI8101314S7"});
                    mainPage80102.nombreRepre.click();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage80102.servicios.click();
                    Selenide.sleep(1000L);
                    mainPage80102.servicioImmex.sendKeys(new CharSequence[]{"SOFTWARE EMPAQUETADO"});
                    mainPage80102.agregarServicio.click();
                    mainPage80102.slecServicio.click();
                    mainPage80102.taxIDExtranjera.sendKeys(new CharSequence[]{"ABC123456XYZ"});
                    mainPage80102.nombreEmpresaext.sendKeys(new CharSequence[]{"QAgtuyh"});
                    mainPage80102.paisEmpresa.sendKeys(new CharSequence[]{"ANGOLA"});
                    mainPage80102.direccionEmpresa.sendKeys(new CharSequence[]{"Qbaxybw"});
                    mainPage80102.agregarEmpresaext.click();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage80102.anexo1.click();
                    mainPage80102.fraccExport.sendKeys(new CharSequence[]{"03035999"});
                    mainPage80102.descripcionExport.sendKeys(new CharSequence[]{"prueba"});
                    mainPage80102.agregarExport.click();
                    mainPage80102.selecFrac.click();
                    mainPage80102.complementarFrac.click();
                    mainPage80102.categoriaFrac.sendKeys(new CharSequence[]{"Producto terminado"});
                    mainPage80102.valorMoneda.sendKeys(new CharSequence[]{"1"});
                    mainPage80102.valorMoneda2.sendKeys(new CharSequence[]{"20"});
                    mainPage80102.produccionMensual.sendKeys(new CharSequence[]{"1"});
                    mainPage80102.produccionAnual.sendKeys(new CharSequence[]{"24"});
                    Selenide.sleep(500L);
                    mainPage80102.btnAgregar.click();
                    mainPage80102.btnAcepta.click();
                    mainPage80102.selecFrac.click();
                    mainPage80102.complementarCliente.click();
                    mainPage80102.paisCliente.sendKeys(new CharSequence[]{"Angola"});
                    mainPage80102.rfcCliente.sendKeys(new CharSequence[]{"QWYIE2918921"});
                    mainPage80102.razonCliente.sendKeys(new CharSequence[]{"prueba"});
                    mainPage80102.btnAgregarProv.click();
                    mainPage80102.aceptOperacion.click();
                    mainPage80102.btnRegresar.click();
                    mainPage80102.selecFrac.click();
                    mainPage80102.proyectoImmex.click();
                    mainPage80102.tipoDocumento.sendKeys(new CharSequence[]{"Contrato de servicio"});
                    mainPage80102.fechaFirma.click();
                    mainPage80102.selFechaFirm.click();
                    mainPage80102.vigenciaFirma.click();
                    mainPage80102.selVigencia.click();
                    mainPage80102.rfcFirmante.sendKeys(new CharSequence[]{"LEQI8101314S7"});
                    mainPage80102.razonFirmante.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.agregaFirmante.click();
                    mainPage80102.aceptaPE.click();
                    mainPage80102.btnRegresarPE.click();
                    mainPage80102.fraccImportacion.sendKeys(new CharSequence[]{"96011001"});
                    mainPage80102.descImportacion.sendKeys(new CharSequence[]{"PRUEBAS"});
                    mainPage80102.agregaFraccionImp.click();
                    mainPage80102.selecImportacion.click();
                    mainPage80102.completarImportacion.click();
                    mainPage80102.categoriaImp.sendKeys(new CharSequence[]{"Producto terminado"});
                    mainPage80102.valormonedaImp.sendKeys(new CharSequence[]{"1"});
                    mainPage80102.valormonedaImp2.sendKeys(new CharSequence[]{"24"});
                    mainPage80102.volumenImp.sendKeys(new CharSequence[]{"2"});
                    mainPage80102.volumenImpA.sendKeys(new CharSequence[]{"48"});
                    mainPage80102.agregarImport.click();
                    Selenide.sleep(1000L);
                    mainPage80102.aceptarImportaciuon.click();
                    mainPage80102.selecImportacion.click();
                    mainPage80102.provedorImport.click();
                    mainPage80102.paisImport.sendKeys(new CharSequence[]{"ANGUILA"});
                    mainPage80102.rfcImport.sendKeys(new CharSequence[]{"WYQTY16162YWA"});
                    mainPage80102.razonImport.sendKeys(new CharSequence[]{"PRUEBAS"});
                    mainPage80102.agregaProvedorImp.click();
                    Selenide.sleep(1000L);
                    mainPage80102.aceptarProvedorI.click();
                    mainPage80102.regresarProvedorI.click();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage80102.federatariosYplant.click();
                    mainPage80102.nombreNotario.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.apellidoPat.sendKeys(new CharSequence[]{"QWEDAS"});
                    mainPage80102.apellidoMat.sendKeys(new CharSequence[]{"OIWUQIHD"});
                    mainPage80102.numAct.sendKeys(new CharSequence[]{"012"});
                    mainPage80102.fechaActa.click();
                    mainPage80102.selecFecha.click();
                    mainPage80102.numNotaria2.sendKeys(new CharSequence[]{"12"});
                    mainPage80102.estadoNotaria.sendKeys(new CharSequence[]{"SINALOA"});
                    Selenide.sleep(1000L);
                    mainPage80102.municipioNotaria.sendKeys(new CharSequence[]{"CULIACAN"});
                    mainPage80102.agregarNotario.click();
                    mainPage80102.estadoPlanta.sendKeys(new CharSequence[]{"SIANALOA"});
                    mainPage80102.buscarPlanta.click();
                    mainPage80102.selecPlanta.click();
                    mainPage80102.agregarPlanta.click();
                    mainPage80102.actividadProductiva.sendKeys(new CharSequence[]{"AGRICULTURA"});
                    mainPage80102.checkPlanta.click();
                    mainPage80102.completarPlanta.click();
                    mainPage80102.amparo.sendKeys(new CharSequence[]{"NO"});
                    mainPage80102.tipoDocumentoP.sendKeys(new CharSequence[]{"Contrato compra venta"});
                    mainPage80102.fechaFirmaP.click();
                    mainPage80102.selecFechaP.click();
                    mainPage80102.vigenciaP.click();
                    mainPage80102.selecVigenciaP.click();
                    mainPage80102.agregaComplemento.click();
                    Selenide.sleep(1500L);
                    mainPage80102.btnAceptaComp.click();
                    mainPage80102.rfcFirmanteP.sendKeys(new CharSequence[]{"LEQI8101314S7"});
                    mainPage80102.tipoFirmante.sendKeys(new CharSequence[]{"Firmante principal"});
                    mainPage80102.btnAgregaFirmante.click();
                    Selenide.sleep(1000L);
                    mainPage80102.btnRegresarAPlantas.click();
                    mainPage80102.montosInversion.click();
                    mainPage80102.tipoMonto.sendKeys(new CharSequence[]{"Equipo"});
                    mainPage80102.cantidadTipo.sendKeys(new CharSequence[]{"1"});
                    mainPage80102.descripcionTipo.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.valorMonto.sendKeys(new CharSequence[]{"10"});
                    mainPage80102.agregarMonto.click();
                    Selenide.sleep(1000L);
                    mainPage80102.aceptarMonto.click();
                    mainPage80102.regresarMonto.click();
                    mainPage80102.empleadosPlanta.click();
                    mainPage80102.totalEmpleados.sendKeys(new CharSequence[]{"10"});
                    mainPage80102.empleadosDirectos.click();
                    mainPage80102.numEmpleadosD.sendKeys(new CharSequence[]{"10"});
                    mainPage80102.cedulasEmpleados.sendKeys(new CharSequence[]{"NO"});
                    mainPage80102.fechasCedulas.click();
                    mainPage80102.selecFechaImss.click();
                    mainPage80102.agregarEmpleadosD.click();
                    Selenide.sleep(1000L);
                    mainPage80102.aceptarEmpleados.click();
                    mainPage80102.regresarEmpleados.click();
                    mainPage80102.capacidadInstalada.click();
                    mainPage80102.servicio.sendKeys(new CharSequence[]{"SOFTWARE EMPAQUETADO"});
                    mainPage80102.fraccionArancel.sendKeys(new CharSequence[]{"0303599"});
                    mainPage80102.turnos.sendKeys(new CharSequence[]{"2"});
                    mainPage80102.horasPorTurno.sendKeys(new CharSequence[]{"6"});
                    mainPage80102.cantEmpleados.sendKeys(new CharSequence[]{"5"});
                    mainPage80102.maquinaria.sendKeys(new CharSequence[]{"2"});
                    mainPage80102.descripcionMaquinaria.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.capacidadMensual.sendKeys(new CharSequence[]{"1"});
                    mainPage80102.capacidadAnual.sendKeys(new CharSequence[]{"12"});
                    mainPage80102.capacidadEfectiva.sendKeys(new CharSequence[]{"20"});
                    mainPage80102.agregarCapacidad.click();
                    Selenide.sleep(1000L);
                    mainPage80102.aceptarCapacidad.click();
                    mainPage80102.regresarCapacidad.click();
                    js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                    Selenide.sleep(1000L);
                    mainPage80102.anexo2y3.click();
                    mainPage80102.fraccionAnexo2.sendKeys(new CharSequence[]{"03044801"});
                    mainPage80102.descAnexo2.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.agregaAnexo2.click();
                    mainPage80102.fraccionAnexo3.sendKeys(new CharSequence[]{"95079099"});
                    mainPage80102.descAnexo3.sendKeys(new CharSequence[]{"PRUEBA"});
                    mainPage80102.agregaAnexo3.click();
                    mainPage80102.continuarSoli.click();
                    Selenide.sleep(1000L);
                    mainPage80102.continuarArchivos.click();
                    mainPage80102.cargarArchivos.click();
                    mainPage80102.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                    Selenide.sleep(500L);
                    mainPage80102.adjuntarArchivos.click();
                    Selenide.sleep(12000L);
                    mainPage80102.cerrarArchivos.click();
                    mainPage80102.continuarFirma.click();
                    loginFirmSoli.firma(tramite80102);
                    String folioText = mainPage80102.folio.getText();
                    ObtenerFolio var10000 = obtenerFolio;
                    String folioNumber = ObtenerFolio.obtenerFolio(folioText);
                }, repeticiones);
            }
        }
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for(int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }

    public void clickOkButton() {
        Selenide.$(Selectors.byText("Ok")).shouldBe(new WebElementCondition[]{Condition.visible}).shouldHave(new WebElementCondition[]{Condition.text("Ok")}).click();
    }
}