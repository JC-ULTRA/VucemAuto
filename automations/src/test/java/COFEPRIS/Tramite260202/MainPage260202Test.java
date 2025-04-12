package COFEPRIS.Tramite260202;


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
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260202Test {
    MainPage260202 mainPage260202 = new MainPage260202();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260202  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
    }

    @Test
    public void Proceso260202() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260202");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260202");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260202");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260202");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260202");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260202");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260202);
            mainPage260202.selecRol.sendKeys("Persona Moral");
            mainPage260202.btnacep.click();
            mainPage260202.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260202.SoliNew.click();
            mainPage260202.Cofepris.click();
            mainPage260202.linkCertificadosLicenciasPermisos.click();
            mainPage260202.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260202.linkPermisoImportacionMateriasPrimas.click();
            //DATOS SSOLICITANTE
            mainPage260202.labelDatosSolicitud.click();
            mainPage260202.inputEstablecimiento.click();
            mainPage260202.buttonAceptar.click();
            mainPage260202.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260202.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260202.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260202.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260202.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260202.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260202.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260202.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260202.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260202.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260202.inputScianAgregar.click();
            mainPage260202.comboSCIAN.selectOption("434230");
            mainPage260202.inputAgregar.click();
            mainPage260202.inputAvisoFuncionamiento.click();
            mainPage260202.solicitudRegimen.sendKeys("Definitivos");
            mainPage260202.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260202.inputAgregarAduana.click();
            mainPage260202.selectClasificacionProducto.sendKeys("MEDICAMENTOS/ FARMACO");
            mainPage260202.selectSubClasificacionProducto.sendKeys("I) Alopáticos");
            mainPage260202.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260202.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260202.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260202.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            mainPage260202.selectFormaFarmaceutica.selectOptionContainingText("Polvo");
            mainPage260202.selectEstadoFisico.selectOptionContainingText("Solido");
            mainPage260202.inputFraccionArancelaria.sendKeys("29372299");
            mainPage260202.inputCantidadUMT.sendKeys("100");
            mainPage260202.inputCantidadUMC.sendKeys("10");
            mainPage260202.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260202.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260202.buttonAbrirPanelPaisesOrigen.click();
            mainPage260202.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260202.inputAgregarSeleccion.click();
            mainPage260202.inputAbrirPanelPaisesProcedencia.click();
            mainPage260202.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260202.inputAgregarSeleccion2.click();
            mainPage260202.botonAbrirPanelUsosEspecificos.click();
            mainPage260202.UsoEspecifico.sendKeys("VENTA O COMERCIALIZACIÓN");
            mainPage260202.botonAgregarSeleccion.click();
            mainPage260202.inputAgregarMercancia.click();
            mainPage260202.inputDeclaracion.click();
            mainPage260202.inputInformacionConfidencialNo.click();
            mainPage260202.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260202.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260202.labelTerceroRElacionado.click();
            mainPage260202.inputAgregarFabricante.click();
            mainPage260202.inputNacionalidadextranjera.click();
            mainPage260202.inputPErsonaMoral.click();
            mainPage260202.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260202.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260202.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260202.terceroCodigoPostal.sendKeys("00000");
            mainPage260202.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260202.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260202.terceroNumExterior.sendKeys("123");
            mainPage260202.terceroNumInterior.sendKeys("4B");
            mainPage260202.terceroTelefono.sendKeys("5555555555");
            mainPage260202.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260202.btnGuardarDatosTerceros.click();
            mainPage260202.inputAgregarDestinatario.click();
            mainPage260202.inputTipoPeronaMoral.click();
            mainPage260202.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260202.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260202.terceroEstado2.sendKeys("MÉXICO");
            mainPage260202.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260202.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260202.terceroCodigoPostal2.sendKeys("55120");
            mainPage260202.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260202.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260202.terceroNumExterior2.sendKeys("123");
            mainPage260202.terceroNumInterior2.sendKeys("4B");
            mainPage260202.terceroTelefono2.sendKeys("5555555555");
            mainPage260202.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260202.btnGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260202.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260202.labelPagoDerechos.click();
            mainPage260202.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260202.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260202.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260202.inputSolicitudPagoLlave.sendKeys("3456456243");
            mainPage260202.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260202.inputCalendar);sleep(100);
            mainPage260202.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260202.inputGuarda.click();
            mainPage260202.inputAdjuntar.click();
            mainPage260202.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.selectDoc7.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260202.btnAnexar.click();sleep(20000);
            mainPage260202.btnCerrar.click();
            mainPage260202.inputSiguiente.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260101);

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