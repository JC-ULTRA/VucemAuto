package COFEPRIS.Tramite260603;


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

public class MainPage260603Test {
    MainPage260603 mainPage260603 = new MainPage260603();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260603  = new TramitesFirmasLG(
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
    public void Proceso260603() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260603");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260603");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260603");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260603");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260603");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260603");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260603);
            mainPage260603.selecRol.sendKeys("Persona Moral");
            mainPage260603.btnacep.click();
            mainPage260603.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260603.SoliNew.click();
            mainPage260603.Cofepris.click();
            mainPage260603.linkCertificadosLicenciasPermisos.click();
            mainPage260603.linkAvisoSanitario.click();
            mainPage260603.linkAvisoImportPrecurQuim.click();
            //DATOS SOLICITUD
            mainPage260603.labelDatosSolicitud.click();
            mainPage260603.inputEstablecimiento.click();
            mainPage260603.btnAceptar.click();
            mainPage260603.inputRazonSocial.sendKeys("AAL0409235E6");
            mainPage260603.inputCorreoElectronico.sendKeys("PRUEBA@test.com");
            mainPage260603.inputCodigoPostal.sendKeys("01234");
            mainPage260603.selectEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260603.inputMunicipio.sendKeys("Benito Juárez");
            mainPage260603.inputLocalidad.sendKeys("Cerca del parque");
            mainPage260603.inputColonia.sendKeys("Del Valle");
            mainPage260603.inputCalle.sendKeys("Insurgentes Sur");
            mainPage260603.inputLada.sendKeys("52");
            mainPage260603.inputTelefono.sendKeys("5555555555");
            mainPage260603.inputScianAgregar.click();
            mainPage260603.comboSCIAN.selectOption("614041");
            mainPage260603.inputAgregar.click();
            mainPage260603.inputAvisoFuncionamiento.click();
            //mainPage260603.solicitudRegimen.sendKeys("Definitivos");
            mainPage260603.aduanaEntrada.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage260603.inputAgregarAduana.click();

//AQUI PARA
            mainPage260603.selectClasificacionProducto.sendKeys("PRECURSORES QUIMICOS");
            mainPage260603.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260603.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260603.inputNombreCientifico.sendKeys("PRUEBAS PRUEBUS");
            mainPage260603.selectTipoProductoTipoTramite.sendKeys("Producto a granel");
            mainPage260603.selectEstadoFisico.sendKeys("Liquido");
            mainPage260603.inputFraccionArancelaria.sendKeys("29333299");
            mainPage260603.inputCantidadUMC.sendKeys("1234");
            mainPage260603.inputUMC.sendKeys("JUEGO");
            mainPage260603.inputPorcentaje.sendKeys("25");
            mainPage260603.inputValorComercial.sendKeys("123");
            Selenide.executeJavaScript("arguments[0].value = '10/05/2025';", mainPage260603.inputFechaImportExport);sleep(100);
mainPage260603.inputPresentacion.sendKeys("PARA PRUEBA");
mainPage260603.inputPaisPRocedencia.sendKeys("DEU");
mainPage260603.inputPaisOrigen.sendKeys("MEX");

            mainPage260603.botonAbrirPanelUsosEspecificos.click();
            mainPage260603.UsoEspecifico.sendKeys("FABRICACIÓN");
            mainPage260603.botonAgregarSeleccion.click();
            mainPage260603.inputAgregarMercancia.click();
            mainPage260603.btnGuardarDatosTercero3.click();

            mainPage260603.inputInformacionConfidencialNo.click();
            mainPage260603.inputRepresentanteLegalRFC.sendKeys("MAVL621207C95");
            mainPage260603.inputConsultarIDC.click();
            //FACTURADOR
            mainPage260603.inputAgregarFacturador.click();
            mainPage260603.inputTipoPeronaFisica4.click();
            mainPage260603.inputTerceroNombre4.sendKeys("HARRY");
            mainPage260603.inputTerceroApePAter4.sendKeys("POTTER");
            mainPage260603.inputTerceroApeMAter4.sendKeys("HERNANDEZ");
            mainPage260603.inputPais4.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
            mainPage260603.terceroEstadoLocalidad4.sendKeys("AMSTERDAM");
            mainPage260603.terceroCodigoPostal4.sendKeys("00000");
            mainPage260603.terceroColoniaEquiv4.sendKeys("10 DE ABRIL");
            mainPage260603.terceroCalle4.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260603.terceroNumExterior4.sendKeys("123");
            mainPage260603.terceroNumInterior4.sendKeys("4B");
            mainPage260603.terceroTelefono4.sendKeys("5555555555");
            mainPage260603.terceroCorreo4.sendKeys("contacto@fabricante.com");
            mainPage260603.btnGuardarDatosTercero4.click();


            
            
            //GUARDAR
            mainPage260603.inputGuarda.click();sleep(1000);
            mainPage260603.inputAdjuntar.click();
            mainPage260603.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260603.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260603.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260603.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260603.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260603.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260603.btnAnexar.click();sleep(20000);
            mainPage260603.btnCerrar.click();
            mainPage260603.inputSiguiente.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260603);

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
