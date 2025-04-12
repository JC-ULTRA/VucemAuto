package COFEPRIS.Tramite260211;

import COFEPRIS.Tramite260211.MainPage260211;
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

public class MainPage260211Test {
    MainPage260211 mainPage260211 = new MainPage260211();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260211  = new TramitesFirmasLG(
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
    public void Proceso260211() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260211");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260211");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260211");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260211");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260211");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260211");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//          Ingreso y selección de trámite
            loginFirmSoli.login(tramite260211);
            mainPage260211.selecRol.sendKeys("Persona Moral");
            mainPage260211.btnacep.click();
            mainPage260211.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260211.SoliNew.click();
            mainPage260211.Cofepris.click();
            mainPage260211.linkCertificadosLicenciasPermisos.click();
            mainPage260211.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260211.linkPermisoFuentesRadiacion.click();
            //DATOS SOLICITUD
            mainPage260211.labelDatosSolicitud.click();
            mainPage260211.inputEstablecimiento.click();
            mainPage260211.btnAceptar.click();
            mainPage260211.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260211.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260211.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260211.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260211.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260211.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260211.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260211.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260211.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260211.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260211.inputScianAgregar.click();
            mainPage260211.comboSCIAN.selectOption("614074");
            mainPage260211.inputAgregar.click();
            mainPage260211.inputAvisoFuncionamiento.click();
            mainPage260211.solicitudRegimen.sendKeys("Definitivos");
            mainPage260211.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260211.inputAgregarAduana.click();
            mainPage260211.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260211.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260211.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260211.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260211.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260211.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260211.selectFormaFarmaceutica.sendKeys("");
            mainPage260211.selectEstadoFisico.sendKeys("Granulado o polvo");
            mainPage260211.inputFraccionArancelaria.sendKeys("33061001");
            mainPage260211.inputCantidadUMT.sendKeys("100");
            mainPage260211.inputCantidadUMC.sendKeys("10");
            mainPage260211.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260211.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260211.inputRgistroSanitario.sendKeys("1234535");
            Selenide.executeJavaScript("arguments[0].value = '20/04/2025';", mainPage260211.inputCaducidad);sleep(100);
            mainPage260211.buttonAbrirPanelPaisesOrigen.click();
            mainPage260211.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260211.inputAgregarSeleccion.click();
            mainPage260211.inputAbrirPanelPaisesProcedencia.click();
            mainPage260211.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260211.inputAgregarSeleccion2.click();
            mainPage260211.botonAbrirPanelUsosEspecificos.click();
            mainPage260211.UsoEspecifico.sendKeys("VENTA O COMERCIALIZACIÓN");
            mainPage260211.botonAgregarSeleccion.click();
            mainPage260211.inputAgregarMercancia.click();
            mainPage260211.inputDeclaracion.click();
            mainPage260211.inputInformacionConfidencialNo.click();
            mainPage260211.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260211.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260211.labelTerceroRElacionado.click();
            mainPage260211.inputAgregarFabricante.click();
            mainPage260211.inputNacionalidadextranjera.click();
            mainPage260211.inputPErsonaMoral.click();
            mainPage260211.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260211.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260211.terceroEstadoLocalidad.sendKeys("LUXEMBURGO");
            mainPage260211.terceroCodigoPostal.sendKeys("00000");
            mainPage260211.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260211.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260211.terceroNumExterior.sendKeys("123");
            mainPage260211.terceroNumInterior.sendKeys("4B");
            mainPage260211.terceroTelefono.sendKeys("5555555555");
            mainPage260211.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260211.btnGuardarDatosTerceros.click();
            mainPage260211.inputAgregarDestinatario.click();
            mainPage260211.inputTipoPeronaMoral.click();
            mainPage260211.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260211.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260211.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260211.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260211.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260211.terceroCodigoPostal2.sendKeys("06278");
            mainPage260211.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260211.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260211.terceroNumExterior2.sendKeys("123");
            mainPage260211.terceroNumInterior2.sendKeys("4B");
            mainPage260211.terceroTelefono2.sendKeys("5555555555");
            mainPage260211.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260211.btnGuardarDatosTercero2.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260211.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260211.labelPagoDerechos.click();
            mainPage260211.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260211.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260211.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260211.inputSolicitudPagoLlave.sendKeys("3456456243");
            mainPage260211.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260211.inputCalendar);sleep(100);
            mainPage260211.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260211.inputGuarda.click();sleep(1000);
            mainPage260211.inputAdjuntar.click();
            mainPage260211.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260211.btnAnexar.click();sleep(20000);
            mainPage260211.btnCerrar.click();
            mainPage260211.inputSiguiente.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260211);

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