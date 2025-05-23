package HACIENDA.Tramite31101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite31101.MainPage31101;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage31101Test {
    MainPage31101 mainPage31101 = new MainPage31101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite31101 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aac720713bq0.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAC720713BQ0_1012271736.key"
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso31101() {
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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            //Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            LocalDate FinVigencia = LocalDate.now().plusMonths(1);
            String fechaFinVigencia = FinVigencia.format(formatter);

            // Ingreso y selección de trámite

            loginFirmSoli.login(tramite31101); sleep(1000);
           // mainPage31101.selecRol.sendKeys("Persona Moral");
           // mainPage31101.btnacep.click();
            mainPage31101.Tramites.click();
            mainPage31101.SoliNew.click();
            mainPage31101.Hacienda.click();
            mainPage31101.RegisCE.click();
            mainPage31101.ElementoScrolRef.scrollTo();
            mainPage31101.GarantiasIVAeIEPS.click();
            mainPage31101.elementoTramite31101.click();

            //Tab Aviso
            try {
                Thread.sleep(1000); // Pausa de 2 segundos
                // Hacer scroll hasta el elemento
                mainPage31101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Tab Datos generales de la solicitud
            mainPage31101.tabDatosSolicitud.click();
            mainPage31101.radbtnCartaCredito.click();
            mainPage31101.radbtnPolizaRevolvente.click();
            mainPage31101.radbtnSectorProductivo.click();
            mainPage31101.selectConcepto.selectOption("Autopartes");
            mainPage31101.checkManifiesto.click();
            mainPage31101.radbtnSiFiscalAduanera.click();
            mainPage31101.radbtnSiObligacionFiscalSAT.click();
            mainPage31101.radbtnSiIMSS.click();

            mainPage31101.SubcontratistaRFC.sendKeys("AAL0409235E6");
            mainPage31101.SubcontratistabtnAgregar.click();

            mainPage31101.radbtnNoArticulo69CFF.click();
            mainPage31101.radbtnNoArticulo69BCFF.click();
            mainPage31101.radbtnNoArticulo69BBis.click();
            mainPage31101.radbtnSiCertificadosVigentes.click();
            mainPage31101.radbtnSiArticulo17K.click();
            mainPage31101.radbtnNoSuspensionPadron.click();
            mainPage31101.radbtnNoQuerellaSAT.click();
/*
            //Clientes y provedores en el Extranjero
            mainPage31101.btnSelectArchivoClientesProv.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\PROVEEDOR_EXT_31101.xls");
            mainPage31101.btnCargarArchivoClientesProv.click(); sleep(1000);

            //Proovedores Nacionales
            mainPage31101.btnSelectArchivoProvedorNacional.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\PROVEEDOR_NAC_31101.xls");
            mainPage31101.btnCargarArchivoProvedorNacionals.click(); sleep(1000);
            mainPage31101.radbtnNoQuerellaDenuncia.click();
*/
            //Control de inventarios
            mainPage31101.radbtnSiArticulo59.click();
            mainPage31101.radbtnSiAnexo24.click();
            mainPage31101.NombreSistema.sendKeys("QA Nombre sistema");
            mainPage31101.LugarRadicacion.sendKeys("QA Radicacion");
            mainPage31101.radbtnSiArticulo28III.click();
            mainPage31101.radbtnSiArticulo28IV.click();

            //MIembros de la empresa
            mainPage31101.radbtnSiObligacionesFiscales.click();
            mainPage31101.radbtnNoOpinionPositiva.click();
            //Agregar Miembro
            mainPage31101.btnAgregarMiembro.click();
            mainPage31101.selectCaracter.selectOption("Administrador único");
            mainPage31101.radbtnSiObligadoTributar.click();
            mainPage31101.selectNacionalidad.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
            mainPage31101.MiembroRFC.sendKeys("leqi8101314s7");
            mainPage31101.btnBuscarMiembro.click();
            mainPage31101.btnAgregarInfoMiembro.click();
            mainPage31101.btnAceptarNotifMiembro.click();

            mainPage31101.radbtnSiRegistroEsquemaCertificado.click();
/*
            mainPage31101.radbtnNoArticulo69B.click();
            mainPage31101.radbtnNoCredito12Meses.click();
            mainPage31101.radbtnSiInversionNacional.click();
            mainPage31101.selectTipoInversion.selectOption("Bienes Muebles");
            mainPage31101.ValorPesos.sendKeys("10000");
            mainPage31101.DescripcionGeneral.sendKeys("Descripcion QA");
            mainPage31101.btnAgregarInfoInversion.click();

 */
            mainPage31101.radbtnSiPrvCertificacionIVAeIEPS.click();
            mainPage31101.radbtnSiCumplimientoAnexo30.click();

            //Regimen Aduanero
            mainPage31101.checkElaboracionRecintoFiscal.click();

            mainPage31101.radbtnSiAutorizacionReciento.click();
            executeJavaScript("arguments[0].value = arguments[1];", mainPage31101.fechaFinVigenciaRecinto, fechaFinVigencia);sleep(1000);
            mainPage31101.NumeroOficioAutorizacionRecinto.sendKeys("6031469410");
            mainPage31101.radbtnNoSujetoCancelacionRecinto.click();

/*
            //Infrastructura
            mainPage31101.radbtnSiCuentaConInfrastructura.click();
            mainPage31101.radbtnNoResolucionImprocedencia.click();
            mainPage31101.radbtnSiCapacidadFinanciera.click();
            mainPage31101.btnSeleccionarArchivoImportacion.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Fracciones_31101.xls");
            mainPage31101.btnCargarArchivoImportacion.click();sleep(1000);
            mainPage31101.radbtnNoImportacion50Porciento.click();
            mainPage31101.ValorAduanaTotal.sendKeys("450289");

            //Columna B
            mainPage31101.ValorComercialRetorno.sendKeys("1");
            mainPage31101.ValorComercialTransferencia.sendKeys("470");
            mainPage31101.ValorComercialDesperdicio.sendKeys("10");
            mainPage31101.ValorComercialConstancia.sendKeys("600");

            //Columna C
            mainPage31101.ValorAduanaRetorno.sendKeys("2");
            mainPage31101.ValorAduanaTransferencia.sendKeys("200");
            mainPage31101.ValorAduanaDesperdicio.sendKeys("15");
            mainPage31101.ValorAduanaConstancia.sendKeys("90");

            //Columna D
            mainPage31101.PorcentajeImportacionRetorno.sendKeys("3");
            mainPage31101.PorcentajeImportacionTransferencia.sendKeys("12");
            mainPage31101.PorcentajeImportacionDesperdicio.sendKeys("5");
            mainPage31101.PorcentajeImportacionConstancia.sendKeys("4");

            */
            try {
                Thread.sleep(2000); // Pausa de 2 segundos
                // Hacer scroll hasta el elemento
                mainPage31101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //TAb Datos por garantia
            mainPage31101.tabDatosGarantia.click();
            mainPage31101.selectNombreInstitucion.selectOption("BANCA AFIRME SA");
            mainPage31101.NumFolio.sendKeys("250109");
            executeJavaScript("arguments[0].value = arguments[1];", mainPage31101.fechaExpedicion, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage31101.fechaInicioVigencia, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage31101.fechaFinVigencia, fechaFinVigencia);
            mainPage31101.ImporteNacional.sendKeys("80000");

            mainPage31101.btnContinuar.click();

            //Paso2
            mainPage31101.btnContinuarPaso2.click();

            //Paso 3
            mainPage31101.btnAdjuntarDoc.click();sleep(1000);

            //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
            //Sub Paso 3
            mainPage31101.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31101.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31101.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31101.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31101.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31101.btnAdjuntar2.click();
            mainPage31101.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(2000);
            mainPage31101.btnCerrar3.click();

            //Paso 3 (Continuacion)
            mainPage31101.btnContinuar3.click();

            //Paso 4 Firma
            loginFirmSoli.firma(tramite31101);

            // Obtener el texto del folio
            String folioText = mainPage31101.folio.getText();
            //Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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
}
