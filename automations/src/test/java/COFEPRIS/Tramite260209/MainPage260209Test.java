package COFEPRIS.Tramite260209;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260209Test {
    MainPage260209 mainPage260209 = new MainPage260209();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260209  = new TramitesFirmasLG(
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
    public void Proceso260209() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260209");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260209");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260209");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260209");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260209");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260209");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260209);
            mainPage260209.selecRol.sendKeys("Persona Moral");
            mainPage260209.btnacep.click();
            mainPage260209.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260209.SoliNew.click();
            mainPage260209.Cofepris.click();
            mainPage260209.linkCertificadosLicenciasPermisos.click();
            mainPage260209.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260209.linkPermisoSanImpMedDesDonacion.click();
            //DATOS SSOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260209.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260209.labelDatosSolicitud.click();
            mainPage260209.inputEstablecimiento.click();
            Selenide.sleep(2000);
            metodos.presionarEscYSpace();
            mainPage260209.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260209.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260209.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260209.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260209.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260209.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260209.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260209.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260209.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260209.inputSolicitudLada.sendKeys("52");
            mainPage260209.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("55555555");
            mainPage260209.inputScianAgregar.click();
            mainPage260209.comboSCIAN.selectOption("311239");
            mainPage260209.inputAgregar.click();
            mainPage260209.inputAvisoFuncionamiento.click();
            mainPage260209.solicitudRegimen.sendKeys("Definitivos");
            mainPage260209.aduanaEntrada.selectOption("ALTAMIRA");sleep(500);
            //mainPage260209.inputAduanaAIFA.click();
            Selenide.executeJavaScript("arguments[0].name = 'aduanaAIFA';",mainPage260209.aduanaEntrada);
            mainPage260209.inputAgregarAduana.click();
            mainPage260209.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260209.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260209.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260209.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260209.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260209.selectTipoProductoTipoTramite.sendKeys("Materia Prima");
            mainPage260209.selectFormaFarmaceutica.selectOptionContainingText("Gragea");
            mainPage260209.selectEstadoFisico.selectOptionContainingText("Solido");
            mainPage260209.inputFraccionArancelaria.sendKeys("30019099");
            mainPage260209.inputCantidadUMT.sendKeys("100");
            mainPage260209.inputCantidadUMC.sendKeys("10");
            mainPage260209.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260209.textareaPresentacion.sendKeys("Ampolleta");
            mainPage260209.inputNumeroRegistroSanitario.sendKeys("62345");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260209.inputFechaCaducidad);sleep(100);
            mainPage260209.buttonAbrirPanelPaisesOrigen.click();
            mainPage260209.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260209.inputAgregarSeleccion.click();
            mainPage260209.inputAbrirPanelPaisesProcedencia.click();
            mainPage260209.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260209.inputAgregarSeleccion2.click();
            mainPage260209.botonAbrirPanelUsosEspecificos.click();
            mainPage260209.UsoEspecifico.sendKeys("Donacion");
            mainPage260209.botonAgregarSeleccion.click();
            mainPage260209.inputAgregarMercancia.click();
            mainPage260209.inputDeclaracion.click();
            mainPage260209.inputInformacionConfidencialSi.click();
            mainPage260209.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260209.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260209.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260209.labelTerceroRElacionado.click();
//            //Fabricante
//            mainPage260209.inputAgregarFabricante.click();
//            mainPage260209.inputNacionalidadextranjera.click();
//            mainPage260209.inputPErsonaMoral.click();
//            mainPage260209.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
//            mainPage260209.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260209.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260209.terceroCodigoPostal.sendKeys("00000");
//            mainPage260209.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260209.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260209.terceroNumExterior.sendKeys("123");
//            mainPage260209.terceroNumInterior.sendKeys("4B");
//            mainPage260209.inputLada.sendKeys("52");
//            mainPage260209.terceroTelefono.sendKeys("5555555555");
//            mainPage260209.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260209.btnGuardarDatosTerceros.click();
            //Destinatario
            mainPage260209.inputAgregarDestinatario.click();
            mainPage260209.inputTipoPeronaMoral.click();
            mainPage260209.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260209.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260209.terceroEstado2.sendKeys("MÉXICO");
            mainPage260209.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260209.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260209.terceroCodigoPostal2.sendKeys("55120");
            mainPage260209.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260209.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260209.terceroNumExterior2.sendKeys("123");
            mainPage260209.terceroNumInterior2.sendKeys("4B");
            mainPage260209.inputLada.sendKeys("52");
            mainPage260209.terceroTelefono2.sendKeys("5555555555");
            mainPage260209.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260209.btnGuardarDatosTercero2.click();
//            //Proveedor
//            mainPage260209.inputAgregarProveedor.click();
//            mainPage260209.inputTipoPeronaMoral.click();
//            mainPage260209.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260209.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260209.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260209.terceroCodigoPostal.sendKeys("00000");
//            mainPage260209.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260209.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260209.terceroNumExterior.sendKeys("123");
//            mainPage260209.terceroNumInterior.sendKeys("4B");
//            mainPage260209.inputLada.sendKeys("52");
//            mainPage260209.terceroTelefono.sendKeys("5555555555");
//            mainPage260209.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260209.btnGuardarDatosTerceros.click();
//            //Facturador
//            mainPage260209.inputAgregarFacturador.click();
//            mainPage260209.inputTipoPeronaMoral.click();
//            mainPage260209.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260209.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260209.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260209.terceroCodigoPostal.sendKeys("00000");
//            mainPage260209.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260209.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260209.terceroNumExterior.sendKeys("123");
//            mainPage260209.terceroNumInterior.sendKeys("4B");
//            mainPage260209.inputLada.sendKeys("52");
//            mainPage260209.terceroTelefono.sendKeys("55555555");
//            mainPage260209.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260209.btnGuardarDatosTerceros.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260209.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PAGO DE DERECHOS
            mainPage260209.labelPagoDerechos.click();
            mainPage260209.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260209.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260209.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260209.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260209.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260209.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260209.inputCalendar);sleep(100);
            mainPage260209.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260209.InputGuardarSolicitud.click();
            mainPage260209.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260209.btmAnexar.click();sleep(4000);
            Selenide.sleep(8000);
            mainPage260209.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260209.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260209);
            String folioText = mainPage260209.folio.getText();sleep(5000);
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