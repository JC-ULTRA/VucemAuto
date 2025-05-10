package HACIENDA.Tramite32612;

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

public class MainPage32612Test {

    MainPage32612 mainPage32612 = new MainPage32612();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite32612 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
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
    public void Proceso32612() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32612");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32612");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32612");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32612");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32612");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32612");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite32612);
            mainPage32612.selecRol.sendKeys("Persona Moral");
            mainPage32612.btnacep.click();
            mainPage32612.Tramites.sendKeys("Solicitudes nuevas");
            mainPage32612.SoliNew.click();
            mainPage32612.hacienda.click();
            mainPage32612.registrosComercioExt.click();
            mainPage32612.solicitudRegistro.click();
            mainPage32612.rubroAgenteAduanal.click();
            mainPage32612.datosComunes.click();
            mainPage32612.servicio.sendKeys("Reparación, re-trabajo o mantenimiento de mercancías");
            mainPage32612.cumplimientoObligacionesSi.click();sleep(400);
            mainPage32612.autorizoSATSi.click();
            mainPage32612.empleadosPropiosSi.click();
            mainPage32612.numEmpleadosPropios.sendKeys("1");
            mainPage32612.bimestreEmpleadosPropios.sendKeys("Julio - Agosto");
            mainPage32612.isrNo.click();
            mainPage32612.btnAceptarISR.click();
            mainPage32612.pagoCuotasObreroPatronalesNo.click();
            mainPage32612.btnAceptarCuotasPatronales.click();
            mainPage32612.subcontratacionNo.click();
            //mainPage32612.agregarSubcontratado.click();
            //executeJavaScript("arguments[0].value = 'MAVL621207C95';",
            //mainPage32612.rfcSubcontratado.setValue("MAVL621207C95"); sleep(2000);
            //mainPage32612.subContr.click();
//            mainPage32612.btnBuscarRfcSub.click();
//            mainPage32612.numEmpleadosSubcontratados.sendKeys("1");
//            mainPage32612.bimestreEmpleadosSubcontratados.sendKeys("Julio - Agosto");
//            mainPage32612.añadirSubcontratados.click();
//            mainPage32612.btnAceptarSubcontratados.click();
            //mainPage32612.registroPadronSi.click();
            mainPage32612.listadoEmpresasNo.click();
            mainPage32612.articulo64BCFFNo.click();
            //mainPage32612.btnAceptar.click();
            Selenide.executeJavaScript("arguments[0].click();", mainPage32612.articulo64BBisSi);
            //mainPage32612.btnAceptar2.click();
            mainPage32612.sellosVigentes.click();
            mainPage32612.articulo17HBis.click();
//            mainPage32612.inputIMMEX.sendKeys("82024");
//            mainPage32612.AgregarInstalaciones.click();
//            mainPage32612.entidadInstalacion.sendKeys("MÉXICO");
//            mainPage32612.seleccionarInstalacion.click();
//            mainPage32612.btnAgregarInstalaciones.click();
//            mainPage32612.selecInstalacionAModificar.click();
//            mainPage32612.modificarInstalacion.click();
//            mainPage32612.instalacionPrincipal.click();
//            mainPage32612.tipoInstalacion.sendKeys("Planta Productiva");
//            mainPage32612.procesoProductivoSi.click();
//            mainPage32612.usoGoceInmuebleSi.click();
//            //mainPage32612.comercioExteriorSi.click();
//            //mainPage32612.reconocimientoMutuoSi.click();
//            mainPage32612.perfilRecintoNo.click();
//            mainPage32612.btnHacerModificacion.click();
//            mainPage32612.btnAceptarModificacion.click();
            mainPage32612.articulo17KSi.click();
            //mainPage32612.input244.click();
//            mainPage32612.suspesionPadronNo.click();
//            mainPage32612.clientesProveedoresExt.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
//            mainPage32612.anexarClientesProveedoresExt.click();
//            mainPage32612.okClientesProveedoresExt.click();
//            mainPage32612.clientesNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
//            mainPage32612.anexarClientesNacionales.click();
            mainPage32612.querellaNo.click();
            mainPage32612.ingresoMensual.click();
//            mainPage32612.manifiesto.click();
//            mainPage32612.inventariosSi.click();
//            mainPage32612.nombreInventarios.sendKeys("PRUEBAS");
//            mainPage32612.lugarInventarios.sendKeys("PRUEBAS QA");
//            mainPage32612.anexo24InventariosOk.click();
//            mainPage32612.btnAgregarInventario.click();
//            mainPage32612.aceptarInventario.click();
//            mainPage32612.rmfSi.click();
//            mainPage32612.agregarSocio.click();
//            mainPage32612.caracterSocio.sendKeys("administrador unico");
//            mainPage32612.tributarEnMexicoNo.click();
//            mainPage32612.tipoPersona.sendKeys("Fisica");
//            mainPage32612.tipoPersona.click();
//            mainPage32612.nacionalidadSocio.sendKeys("ANGUILA");
//            mainPage32612.nombreSocio.sendKeys("PRUEBAS");
//            mainPage32612.apellidoPatSocio.sendKeys("QA");
//            mainPage32612.apellidoMaSocio.sendKeys("QAS");
//            mainPage32612.btnAgregarSocio.click();sleep(1000);
//            mainPage32612.btnAceptarSocio.click();
//            mainPage32612.agregarSocio.click();
//            mainPage32612.caracterSocio.sendKeys("Accionista");
//            mainPage32612.tributarEnMexicoNo.click();
//            mainPage32612.tipoPersona.sendKeys("Fisica");
//            mainPage32612.tipoPersona.click();
//            mainPage32612.nombreSocio.sendKeys("AMELIE");
//            mainPage32612.apellidoPatSocio.sendKeys("QA");
//            mainPage32612.apellidoMaSocio.sendKeys("QAS");
//            Selenide.executeJavaScript("arguments[0].value = 'MEX';", mainPage32612.nacionalidadSocio2); sleep(1000);
//            mainPage32612.btnAgregarSocio.click();sleep(1000);
//            mainPage32612.btnAceptarSocio2.click();
//            mainPage32612.agregarSocio.click();
//            mainPage32612.caracterSocio.sendKeys("Accionista");
//            mainPage32612.tributarEnMexicoNo.click();
//            mainPage32612.tipoPersona.sendKeys("Fisica");
//            mainPage32612.tipoPersona.click();
//            mainPage32612.nacionalidadSocio.sendKeys("MEXICO");
//            mainPage32612.nombreSocio.sendKeys("PROTEUS");
//            mainPage32612.apellidoPatSocio.sendKeys("QA");
//            mainPage32612.apellidoMaSocio.sendKeys("QAS");
//            mainPage32612.btnAgregarSocio.click();sleep(1000);
//            mainPage32612.btnAceptarSocio3.click();
            mainPage32612.sociosAccionistasNo.click();
            mainPage32612.manifiesto1.click();
            mainPage32612.manifiesto2.click();
            /// Terceros Relacionados
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage32612.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage32612.tercerosRelacionados.click();
            mainPage32612.rfcRepresentanteLegal.sendKeys("MAVL621207C95");
            mainPage32612.btnBuscarRfcRepresentanteL.click();sleep(1000);
            mainPage32612.btnAceptarRepresentanteL.click();
            mainPage32612.btnAgregarEnlaceOperativo.click();
            mainPage32612.rfcEnlaceO.sendKeys("MAVL621207C95");
            mainPage32612.btnBuscarEnlaceO.click();
            mainPage32612.cargoEnlaceO.sendKeys("PRUEBA");
            mainPage32612.btnAñadirEnlaceO.click();
            /// Importador y/o Exportador
            //scrollDecremento();
            mainPage32612.recintoFiscalizado.click();
            mainPage32612.dosExperienciaSi.click();
            Selenide.executeJavaScript("arguments[0].value = '03/05/2023';", mainPage32612.fechaPrestacionServicio); sleep(1000);
            mainPage32612.autorizacionRecintoFSi.click();
            Selenide.executeJavaScript("arguments[0].value = '07/05/2023';", mainPage32612.fechaFinVigencia); sleep(1000);
            mainPage32612.numeroOficioAuto.sendKeys("1235864");
            mainPage32612.input3003Si.click();
            mainPage32612.aceptar3003.click();
            mainPage32612.input3052Si.click();
            mainPage32612.inputReconocimientoMutuoSi.click();

            mainPage32612.inputRFCSi.click();
            mainPage32612.inputRazonSocialSi.click();
            mainPage32612.inputDireccionFiscalSi.click();
            mainPage32612.inputPaginaElectronicaNo.click();
            mainPage32612.inputCorreoElectronicoNo.click();
            mainPage32612.inputTelefonoNo.click();
            mainPage32612.inputPublica.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage32612.inputNumOperacion.setValue(String.valueOf(nFacturaR));
            mainPage32612.inputBanco.sendKeys("BANAMEX");
            Random variant = new Random();
            int nLlaveP = 10_000_000 + variant.nextInt(90_000_000);
            mainPage32612.inputLlavePago.setValue(String.valueOf(nLlaveP));
            Selenide.executeJavaScript("arguments[0].value = '01/05/2025';", mainPage32612.inputFechaPago);sleep(100);
            /// CTPAT
//            mainPage32612.CTPAT.click();
//            mainPage32612.autorizoCBPSi.click();
//            mainPage32612.materiaSeguridadSi.click();
//            mainPage32612.cancelacionNo.click();
            mainPage32612.btnGuardarSoli.click();
            mainPage32612.btnContinuar.click();
            mainPage32612.btnAdjuntarDoc.click();
            mainPage32612.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32612.btnAdjuntar.click();sleep(3500);
            mainPage32612.btnCerrar.click();
            mainPage32612.btnSiguiente.click();
            loginFirmSoli.firma(tramite32612);
            String folioText = mainPage32612.folio.getText();
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

