package HACIENDA.Tramite32615;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32615Test {
    MainPage32615 mainPage32615 = new MainPage32615();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32615 = new TramitesFirmasLG(
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
    public void Proceso32615() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32615");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32615");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32615");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32615");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32615");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32615");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32615);
            mainPage32615.selecRol.sendKeys("Persona Moral");
            mainPage32615.btnacep.click();
            mainPage32615.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32615.SoliNew.click();
            mainPage32615.hacienda.click();
            mainPage32615.registrosComercioExt.click();
            mainPage32615.solicitudRegistro.click();
            mainPage32615.rubroRecintoFiscalizado.click();
            mainPage32615.datosComunes.click();
            mainPage32615.sectorProductivo.sendKeys("Bebidas y tabacos");
            mainPage32615.cumplimientoObligacionesSi.click();
            sleep(400);
            mainPage32615.autorizoSATSi.click();
            mainPage32615.empleadosPropiosSi.click();
            mainPage32615.numEmpleadosPropios.sendKeys("5156");
            mainPage32615.bimestreEmpleadosPropios.sendKeys("Mayo - Junio");
            mainPage32615.isrSi.click();
            mainPage32615.pagoCuotasObreroPatronalesSi.click();
            mainPage32615.subcontratacionNo.click();
            mainPage32615.listadoEmpresasNo.click();
            mainPage32615.articulo64BCFFNo.click();
            mainPage32615.articulo64BBisNo.click();
            mainPage32615.sellosVigentes.click();
            mainPage32615.articulo17HBis.click();
            mainPage32615.inputIMMEX.sendKeys("82024");
            mainPage32615.AgregarInstalaciones.click();
            mainPage32615.entidadInstalacion.sendKeys("MÉXICO");
            mainPage32615.seleccionarInstalacion.click();
            mainPage32615.btnAgregarInstalaciones.click();
            mainPage32615.selecInstalacionAModificar.click();
            mainPage32615.modificarInstalacion.click();
            mainPage32615.instalacionPrincipal.click();
            mainPage32615.tipoInstalacion.sendKeys("Planta Productiva");
            mainPage32615.procesoProductivoSi.click();
            mainPage32615.usoGoceInmuebleSi.click();
            mainPage32615.perfilRecintoNo.click();
            mainPage32615.btnHacerModificacion.click();
            mainPage32615.btnAceptarModificacion.click();
            mainPage32615.articulo17KSi.click();
            mainPage32615.input244.click();
            mainPage32615.suspesionPadronNo.click();
            mainPage32615.clientesProveedoresExt.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32615.anexarClientesProveedoresExt.click();
            mainPage32615.okClientesProveedoresExt.click();
            mainPage32615.clientesNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32615.anexarClientesNacionales.click();
            mainPage32615.okClientesNacionales.click();
            mainPage32615.querellaNo.click();
            mainPage32615.inventariosSi.click();
            mainPage32615.nombreInventarios.sendKeys("PRUEBAS");
            mainPage32615.lugarInventarios.sendKeys("PRUEBAS QA");
            mainPage32615.anexo24InventariosOk.click();
            mainPage32615.btnAgregarInventario.click();
            mainPage32615.aceptarInventario.click();
            mainPage32615.rmfSi.click();
            mainPage32615.agregarSocio.click();
            mainPage32615.caracterSocio.sendKeys("administrador unico");
            mainPage32615.tributarEnMexicoNo.click();
            mainPage32615.tipoPersona.sendKeys("Fisica");
            mainPage32615.tipoPersona.click();
            mainPage32615.nacionalidadSocio.sendKeys("ANGUILA");
            mainPage32615.nombreSocio.sendKeys("PRUEBAS");
            mainPage32615.apellidoPatSocio.sendKeys("QA");
            mainPage32615.apellidoMaSocio.sendKeys("QAS");
            mainPage32615.btnAgregarSocio.click();sleep(1000);
            mainPage32615.btnAceptarSocio.click();
            mainPage32615.agregarSocio.click();
            mainPage32615.caracterSocio.sendKeys("Accionista");
            mainPage32615.tributarEnMexicoNo.click();
            mainPage32615.tipoPersona.sendKeys("Fisica");
            mainPage32615.tipoPersona.click();
            mainPage32615.nombreSocio.sendKeys("AMELIE");
            mainPage32615.apellidoPatSocio.sendKeys("QA");
            mainPage32615.apellidoMaSocio.sendKeys("QAS");
            Selenide.executeJavaScript("arguments[0].value = 'MEX';", mainPage32615.nacionalidadSocio2); sleep(1000);
            mainPage32615.btnAgregarSocio.click();sleep(1000);
            mainPage32615.btnAceptarSocio2.click();
            mainPage32615.agregarSocio.click();
            mainPage32615.caracterSocio.sendKeys("Accionista");
            mainPage32615.tributarEnMexicoNo.click();
            mainPage32615.tipoPersona.sendKeys("Fisica");
            mainPage32615.tipoPersona.click();
            mainPage32615.nacionalidadSocio.sendKeys("MEXICO");
            mainPage32615.nombreSocio.sendKeys("PROTEUS");
            mainPage32615.apellidoPatSocio.sendKeys("QA");
            mainPage32615.apellidoMaSocio.sendKeys("QAS");
            mainPage32615.btnAgregarSocio.click();sleep(1000);
            mainPage32615.btnAceptarSocio3.click();
            mainPage32615.sociosAccionistasNo.click();
            mainPage32615.manifiesto1.click();
            mainPage32615.manifiesto2.click();
            /// Terceros Relacionados
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32615.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32615.tercerosRelacionados.click();
            mainPage32615.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32615.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32615.btnAceptarRepresentanteL.click();
            mainPage32615.btnAgregarEnlaceOperativo.click();
            mainPage32615.rfcEnlaceO.sendKeys("MAVL621207C95");
            mainPage32615.btnBuscarEnlaceO.click();
            mainPage32615.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32615.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            //scrollDecremento();
            mainPage32615.recintoFiscalizado.click();
            mainPage32615.dosExperienciaSi.click();
            Selenide.executeJavaScript("arguments[0].value = '03/05/2023';", mainPage32615.fechaPrestacionServicio); sleep(1000);
            mainPage32615.autorizacionRecintoFSi.click();
            Selenide.executeJavaScript("arguments[0].value = '07/05/2023';", mainPage32615.fechaFinVigencia); sleep(1000);
            mainPage32615.numeroOficioAuto.sendKeys("1235864");
            mainPage32615.input3003Si.click();
            mainPage32615.aceptar3003.click();
            mainPage32615.input3052Si.click();
            mainPage32615.inputReconocimientoMutuoSi.click();

            mainPage32615.inputRFCSi.click();
            mainPage32615.inputRazonSocialSi.click();
            mainPage32615.inputDireccionFiscalSi.click();
            mainPage32615.inputPaginaElectronicaNo.click();
            mainPage32615.inputCorreoElectronicoNo.click();
            mainPage32615.inputTelefonoNo.click();
            mainPage32615.inputPublica.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage32615.inputNumOperacion.setValue(String.valueOf(nFacturaR));
            mainPage32615.inputBanco.sendKeys("BANAMEX");
            Random variant = new Random();
            int nLlaveP = 10_000_000 + variant.nextInt(90_000_000);
            mainPage32615.inputLlavePago.setValue(String.valueOf(nLlaveP));
            Selenide.executeJavaScript("arguments[0].value = '01/05/2025';", mainPage32615.inputFechaPago);sleep(100);
            mainPage32615.btnGuardarSoli.click();
            mainPage32615.btnContinuar.click();
            mainPage32615.btnAdjuntarDoc.click();
            mainPage32615.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32615.btnAdjuntar.click();sleep(3500);
            mainPage32615.btnCerrar.click();
            mainPage32615.btnSiguiente.click();
            loginFirmSoli.firma(tramite32615);
            String folioText = mainPage32615.folio.getText();
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
//
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