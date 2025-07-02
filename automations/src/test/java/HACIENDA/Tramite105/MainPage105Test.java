package HACIENDA.Tramite105;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite105.MainPage105;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage105Test {
    MainPage105 mainPage105 = new MainPage105();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite105  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso105() throws IOException {
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



        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite

            // Ingreso y Rol
            loginFirmSoli.login(tramite105); sleep(1000);
            mainPage105.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage105.btnacep.click(); sleep(1000);
            mainPage105.Tramites.sendKeys("Solicitudes nuevas");
            mainPage105.SoliNew.click();sleep(1000);

            //Búsqueda Tramite
            mainPage105.Hacienda.click();
            mainPage105.AutorizacionesImporExpor.click(); sleep(1000);
            metodos.scrollIncremento(1);
            mainPage105.elementoTramite105.click(); sleep(4000);

            //Paso 1 CAPTURAR SOLICITUD
            mainPage105.Scrol.scrollTo();
            //Pestaña Datos del trámite
            mainPage105.tabDatosTramite.click();
            //Datos del trámite
            mainPage105.checkImportacion.click();
            mainPage105.checkExportacion.click();
            mainPage105.checkDepositoGas.click();
            mainPage105.checkDepositoVehiculos.click();
            mainPage105.radbtnSiServiciosTerceros.click();
            mainPage105.radbtnSiActividadGas.click();
            mainPage105.radbtnSiTipoVehiculos.click();

            //Ubicación de las instalaciones solicitadas
            mainPage105.checkDomicilio.click();
            mainPage105.checkUbicacion.click();
            mainPage105.CodigoInstalacion.sendKeys("755");
            mainPage105.selectEntidadInstalacion.selectOption("SINALOA");
            mainPage105.selectMunicipioInstalacion.selectOption("MAZATLAN");
            mainPage105.LocalidadInstalacion.sendKeys("EL FUERTE");
            mainPage105.selectColoniaInstalacion.selectOption("ZONA DORADA - CP 82110");
            mainPage105.CalleInstalacion.sendKeys("Av. Gaviotas");
            mainPage105.NumExteriorInstalacion.sendKeys("20");
            mainPage105.NumInteriorInstalacion.sendKeys("5");
            mainPage105.UbicacionInstalacion.sendKeys("Ubicación Fuerte 100");

            //Aduanas
            mainPage105.selectAduana.selectOption("470 - AEROPUERTO INT. DE LA CD DE MEXICO");

            //Registro de fracciones arancelarias
            mainPage105.btnAgregarFraccion.click();
            //Fracciones arancelarias
            mainPage105.selectFraccion.selectOption("24041201");
            mainPage105.DescripcionMercancia.sendKeys("Descripción QA");
            mainPage105.btnAgregarInfoFraccion.click();
            mainPage105.btnAceptarFraccionNtf.click();

            //Servicios Terceros
            mainPage105.btnAgregarTerceros.click();
            mainPage105.radbtnMoralTercero.click();
            mainPage105.TerceroRFC.sendKeys("AAL0409235E6");
            mainPage105.btnBuscarTercero.click();sleep(1000);
            mainPage105.btnAgregarInfoTercero.click();
            mainPage105.btnAceptarTercerosNtf.click();

            //Pestaña datos del tramite 2
            mainPage105.Scrol.scrollTo();
            mainPage105.tabDatosTramite2.click();
            //Mercancías
            mainPage105.ProcedimientoCargaDescarga.sendKeys("Maquinaria pesada QA");
            mainPage105.SistemasMedicion.sendKeys("Métrico QA");
            mainPage105.MotivosNoDespachar.sendKeys("Mercancía defectuosa");

            //Agentes y apoderados aduanales
            mainPage105.selectTipoFigura.selectOption("Agente Aduanal");

            //Agregar Agentes y apoderados aduanales registrados
            mainPage105.btnAgregarAgente.click();
            //Agente aduanal
            mainPage105.NombreAgente.sendKeys("Karen");
            mainPage105.ApellidoPaternoAgente.sendKeys("Sabina");
            mainPage105.ApellidoMaternoAgente.sendKeys("Hernandez");
            mainPage105.NumPatenteAgente.sendKeys("1829");
            mainPage105.btnAgregarInfoAgente.click();
            mainPage105.btnAceptarAduanalNtf.click();

            //Continuar paso 1
            mainPage105.btnContinuarPaso1.click();

            //Paso 2 Requisitos Necesarios
            mainPage105.btnContinuarPaso2.click();

            //Paso 3 Anexar Requisitos
            metodos.cargarDocumentos();
            mainPage105.btnAnexar.click();
            mainPage105.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage105.btnCerrar.click();
            mainPage105.btnContinuarPaso3.click();

            //Paso 4 Firmar Solicitud
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite105);

            //LLamar Metodo para obtener folio
            String folioText = mainPage105.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);


        }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}