package HACIENDA.Tramite32611;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32611Test {
    MainPage32611 mainPage32611 = new MainPage32611();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32611 = new TramitesFirmasLG(
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
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso32611() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32611");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32611");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32611");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32611");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32611");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32611");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32611);
            mainPage32611.selecRol.sendKeys("Persona Moral");
            mainPage32611.btnacep.click();
            mainPage32611.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32611.SoliNew.click();
            mainPage32611.hacienda.click();
            mainPage32611.registrosComercioExt.click();
            mainPage32611.solicitudRegistro.click();
            mainPage32611.rubroAutoTransportista.click();
            mainPage32611.datosComunes.click();
            mainPage32611.sectorProductivo.sendKeys("Automotriz terminal");
            mainPage32611.cumplimientoObligacionesSi.click();
            sleep(400);
            mainPage32611.autorizoSATSi.click();
            mainPage32611.empleadosPropiosSi.click();
            mainPage32611.numEmpleadosPropios.sendKeys("20");
            mainPage32611.bimestreEmpleadosPropios.sendKeys("Mayo - Junio");
            mainPage32611.isrSi.click();
            mainPage32611.pagoCuotasObreroPatronalesSi.click();
            mainPage32611.subcontratacionSi.click();
            mainPage32611.agregarSubcontratado.click();
            //executeJavaScript("arguments[0].value = 'MAVL621207C95';",
            mainPage32611.rfcSubcontratado.setValue("MAVL621207C95"); sleep(2000);
            mainPage32611.subContr.click();
            mainPage32611.btnBuscarRfcSub.click();
            mainPage32611.numEmpleadosSubcontratados.sendKeys("10");
            mainPage32611.bimestreEmpleadosSubcontratados.sendKeys("Marzo - Abril");
            mainPage32611.añadirSubcontratados.click();
            mainPage32611.btnAceptarSubcontratados.click();
            mainPage32611.registroPadronSi.click();
            mainPage32611.listadoEmpresasNo.click();
            mainPage32611.articulo64BCFFNo.click();
            mainPage32611.articulo64BBisNo.click();
            mainPage32611.sellosVigentes.click();
            mainPage32611.articulo17HBis.click();
            mainPage32611.inputIMMEX.sendKeys("82024");
            mainPage32611.AgregarInstalaciones.click();
            mainPage32611.entidadInstalacion.sendKeys("MÉXICO");
            mainPage32611.seleccionarInstalacion.click();
            mainPage32611.btnAgregarInstalaciones.click();
            mainPage32611.selecInstalacionAModificar.click();
            mainPage32611.modificarInstalacion.click();
            mainPage32611.instalacionPrincipal.click();
            mainPage32611.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32611.procesoProductivoSi.click();
            mainPage32611.usoGoceInmuebleSi.click();
            mainPage32611.comercioExteriorSi.click();
            mainPage32611.reconocimientoMutuoSi.click();
            mainPage32611.perfilEmpresaNo.click();
            mainPage32611.btnHacerModificacion.click();
            mainPage32611.btnAceptarModificacion.click();
            mainPage32611.articulo17KSi.click();
            mainPage32611.suspesionPadronNo.click();
            mainPage32611.ingresoMensual.click();
            mainPage32611.agregarSocio.click();
            mainPage32611.caracterSocio.sendKeys("administrador unico");
            mainPage32611.tributarEnMexicoNo.click();
            mainPage32611.tipoPersona.sendKeys("Moral");
            mainPage32611.tipoPersona.click();
            mainPage32611.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32611.nombreEmpresaSocio.sendKeys("PRUEBAS");
            mainPage32611.btnAgregarSocio.click();
            sleep(1000);
            mainPage32611.btnAceptarSocio.click();
            mainPage32611.sociosAccionistasNo.click();
            mainPage32611.manifiesto1.click();
            mainPage32611.manifiesto2.click();
            /// Terceros Relacionados
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32611.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32611.tercerosRelacionados.click();
            mainPage32611.rfcRepresentanteLegal.sendKeys("GALE4909081Q7");
            mainPage32611.btnBuscarRfcRepresentanteL.click();
            sleep(1000);
            mainPage32611.btnAceptarRepresentanteL.click();
            mainPage32611.btnAgregarEnlaceOperativo.click();
            mainPage32611.rfcEnlaceO.sendKeys("MAVL621207C95");
            mainPage32611.btnBuscarEnlaceO.click();
            mainPage32611.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32611.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            //scrollDecremento();
            mainPage32611.autoTrasnportista.click();
            mainPage32611.dosExperienciaNo.click();
            mainPage32611.btnAceptar.click();
            mainPage32611.permisoVigenteNo.click();
            mainPage32611.btnAceptar2.click();
            mainPage32611.SitemaRastreoSi.click();
            mainPage32611.perfilAutoTerrestreSi.click();
            mainPage32611.inputAutorizoNo.click();
            mainPage32611.inputRFCNo.click();
            mainPage32611.inputRazonSocialNo.click();
            mainPage32611.inputDireccionFiscalNo.click();
            mainPage32611.inputPaginaElectronicaNo.click();
            mainPage32611.inputCorreoElectronicoNo.click();
            mainPage32611.inputTelefonoNo.click();
            mainPage32611.inputPublica.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage32611.inputNumOperacion.setValue(String.valueOf(nFacturaR));
            mainPage32611.inputBanco.sendKeys("BANAMEX");
            Random variant = new Random();
            int nLlaveP = 10_000_000 + variant.nextInt(90_000_000);
            mainPage32611.inputLlavePago.setValue(String.valueOf(nLlaveP));
            Selenide.executeJavaScript("arguments[0].value = '25/05/2025';", mainPage32611.inputFechaPago);sleep(100);
            /// CTPAT
            mainPage32611.CTPAT.click();
            mainPage32611.autorizoCBPSi.click();
            mainPage32611.materiaSeguridadSi.click();
            mainPage32611.cancelacionNo.click();
            mainPage32611.btnGuardarSoli.click();
            mainPage32611.btnContinuar.click();
            mainPage32611.btnAdjuntarDoc.click();
            mainPage32611.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.archivo14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32611.btnAdjuntar.click();
            sleep(3500);
            mainPage32611.btnCerrar.click();
            mainPage32611.btnSiguiente.click();
            loginFirmSoli.firma(tramite32611);
            String folioText = mainPage32611.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
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