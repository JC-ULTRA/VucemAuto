package COFEPRIS.Tramite260402;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260402Test {
    MainPage260402 mainPage260402 = new MainPage260402();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite260402 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    // Variable para almacenar el tipo de trámite seleccionado
    @BeforeAll
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
    public void Proceso260402(){

        // Solicitar el número de repeticiones
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

        // Ejecutar el proceso repetidamente
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite260402); sleep(1000);

            ///Ruta del Tramite
            ejecutarRutaTramite();

            ///Datos de la Solicitud
            ejecutarPestDatSoli();

            ///Terceros Relacionados
            ejecutarPestTercRelacionados();

            ///Pago de Derechos
            ejecutarPestPagoDerecho();

            ///Documentos Requeridos
            ejecutarPestDocRequeridos();

            mainPage260402.btnConFirm.click();

//            ///Firma
//            loginSoli.firma(tramite260402);
//
////          Obtener el texto del folio
//            String folioText = mainPage260402.folio.getText();
//
////          Llamar al método para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }
    public void ejecutarRutaTramite() {
        mainPage260402.selecRol.sendKeys("Persona Moral"); sleep(1000);
        mainPage260402.btnacep.click(); sleep(1000);
        mainPage260402.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
        mainPage260402.SoliNew.click(); sleep(1000);
        mainPage260402.Cofepris.click(); sleep(1000);
        mainPage260402.CertiLicPer.click(); sleep(1000);
        mainPage260402.PermisosInterSalidaProdHumano.click(); sleep(1000);
        mainPage260402.Tramite260402.click();
    }

    public void ejecutarPestDatSoli() {
        //llave de pago
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 16;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
        ///Propietario
        mainPage260402.PestDatSoli.click();
        mainPage260402.btnAgregarPropietario.click(); sleep(1000);
        mainPage260402.CheckNacional.click(); sleep(1000);
        mainPage260402.CheckPerFisica.click(); sleep(1000);
        mainPage260402.rfcPropietario.sendKeys("MAVL621207C95"); sleep(1000);
        mainPage260402.btnBuscarRFC.click(); sleep(1000);
        mainPage260402.btnGuardarPropietario.click(); sleep(1000);

        ///Datos del establecimiento
        mainPage260402.DenomiSocial.sendKeys("INTEGRADORA DE URBANIZACIONES SIGNUM, S DE RL DE CV "); sleep(1000);
        mainPage260402.Correo.sendKeys("Ultrasist@pruebas.com"); sleep(1000);
        mainPage260402.CP.sendKeys("95270"); sleep(1000);
        mainPage260402.Estado.sendKeys("VERACRUZ"); sleep(1000);
        mainPage260402.MunAlcald.sendKeys("ALVARADO"); sleep(1000);
        mainPage260402.Localidad.sendKeys("ALVARADO"); sleep(1000);
        mainPage260402.Colonia.sendKeys("CENTRO"); sleep(1000);
        mainPage260402.CalleEs.sendKeys("HERMENEGUILDO GALEANA"); sleep(1000);
        mainPage260402.Lada.sendKeys("52"); sleep(1000);
        mainPage260402.Telefono.sendKeys("2979725632"); sleep(1000);

        ///SCIAN
        mainPage260402.btnAgregarSCIAN.click(); sleep(1000);
        mainPage260402.ClaveSCIAN.sendKeys("614011"); sleep(1000);
        mainPage260402.btnAgregarSCIANOK.click(); sleep(1000);

        ///Formulario
        mainPage260402.rfcResponsable.sendKeys("LEQI8101314S7"); sleep(1000);
        mainPage260402.nombreResponsable.sendKeys("MISAEL BARRAGAN BARRAGAN"); sleep(1000);
        mainPage260402.nLicSani.sendKeys(llavePago); sleep(1000);
        mainPage260402.btnAgregarLicSani.click(); sleep(1000);
        mainPage260402.regiDestMerca.sendKeys("Definitivos"); sleep(1000);
        mainPage260402.AduanaEntrada.sendKeys("ALTAMIRA"); sleep(1000);
        mainPage260402.btnAgregarProducto.click(); sleep(1000);
        mainPage260402.nombreEspecifico.sendKeys("NombreEs."); sleep(1000);
        mainPage260402.fracArancel.sendKeys("30019099."); sleep(1000);
        mainPage260402.tipoProductoMerca.sendKeys("OTROS."); sleep(1000);
        mainPage260402.cantidadUMTPro.sendKeys("12"); sleep(1000);
        mainPage260402.cantidadVol.sendKeys("12"); sleep(1000);
        mainPage260402.unIdadMedida.sendKeys("Bote."); sleep(1000);
        mainPage260402.PresFarmaEnv.sendKeys("Prueba QA"); sleep(1000);
        mainPage260402.EnvprimarioAl.sendKeys("Botella."); sleep(1000);
        mainPage260402.EnvSecundariAl.sendKeys("Cajas"); sleep(1000);
        mainPage260402.EnvprimarioCT.sendKeys("Botella"); sleep(1000);
        mainPage260402.EnvSecundariTC.sendKeys("Caja."); sleep(1000);
        mainPage260402.PaisOrgClick1.click(); sleep(1000);
        mainPage260402.PaisOrgAntartida2.click(); sleep(1000);
        mainPage260402.PaisOrgClick3.click(); sleep(1000);
        mainPage260402.PaisOrgClick4.click(); sleep(1000);
        mainPage260402.PaisOrgAntartida5.click(); sleep(1000);
        mainPage260402.PaisOrgANGUILA6.click(); sleep(1000);
        mainPage260402.usEspesific.sendKeys("Internación al territorio nacional de células, tejidos, productos de seres humanos y suero, destinado a diagnóstico."); sleep(1000);
        mainPage260402.btnAgregarUsEspecifico.click(); sleep(1000);

        ///Manifiesto y Representante Legal
        mainPage260402.CheckManifiesto.click(); sleep(1000);
        mainPage260402.CheckSI.click(); sleep(1000);
        mainPage260402.RFCRepreLegal.sendKeys("MAVL621207C95"); sleep(1000);
        mainPage260402.btnBuscarRfcRepreLegal.click(); sleep(1000);
    }

    public void ejecutarPestTercRelacionados() {
        ///Terceros Relacionados
        executeJavaScript("window.scrollTo(0, 0);");
          mainPage260402.PestTerceros.click();
          mainPage260402.btnAgregarTerceros.click();
          mainPage260402.TipPerMoral.click();
          mainPage260402.rSocial.sendKeys("Nombre Empresa");
          mainPage260402.paisDomic.sendKeys("ANTARTIDA");
          mainPage260402.estadoDomic.sendKeys("VERACRUZ");
          mainPage260402.CPEquivalente.sendKeys("95275");
          mainPage260402.CalleDom.sendKeys("Calle 01");
          mainPage260402.numExt.sendKeys("01");
          mainPage260402.numInt.sendKeys("02");
          mainPage260402.LadaDomc.sendKeys("52");
          mainPage260402.TelefonoDomc.sendKeys("2435243345");
          mainPage260402.CoccreoDomc.sendKeys("UltraQA@Test.com.mx");
          mainPage260402.btnGuardarDom.click();
    }

    public void ejecutarPestPagoDerecho() {
        ///Terceros Relacionados, Fecha del dia
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = hoy.format(formatter);
        String uuid = UUID.randomUUID().toString();
        int longitudDeseada = 16;
        String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
        executeJavaScript("window.scrollTo(0, 0);");
          mainPage260402.PestPagoDerecho.click();
          mainPage260402.ClaveReferen.sendKeys("Clave de Referencia");
          mainPage260402.CadenaDepend.sendKeys("Cadena de Dependencia");
          mainPage260402.Banco.sendKeys("BANCA MIFEL");
          mainPage260402.LlavePago.sendKeys(llavePago);
          executeJavaScript("arguments[0].value = arguments[1];", mainPage260402.FechaPago, fechaHoy);sleep(1000);
//          mainPage260402.FechaPago.setValue(fechaHoy);
          mainPage260402.Import.setValue("100");
          mainPage260402.btnContinuarDoc.click();
    }

    public void ejecutarPestDocRequeridos() {
        ///Terceros Relacionados
        executeJavaScript("window.scrollTo(0, 0);");
        mainPage260402.CheckSelecDoc.click();
        mainPage260402.btnEliminarDoc.click();
    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }
    }

}
