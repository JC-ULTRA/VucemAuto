package COFEPRIS.Tramite260201;

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
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260201Test {
    MainPage260201 mainPage260201 = new MainPage260201();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260201  = new TramitesFirmasLG(
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
    public void Proceso260201() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260201");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260201");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260201");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260201");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260201");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260201");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260201);
            mainPage260201.selecRol.sendKeys("Persona Moral");
            mainPage260201.btnacep.click();
            mainPage260201.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260201.SoliNew.click();
            mainPage260201.Cofepris.click();
            mainPage260201.linkCertificadosLicenciasPermisos.click();
            mainPage260201.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260201.linkPermisoImpInsNoEstPsiRet.click();
            //DATOS SSOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260201.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260201.labelDatosSolicitud.click();
            mainPage260201.inputEstablecimiento.click();
            Selenide.sleep(2000);
            metodos.presionarEscYSpace();
            mainPage260201.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260201.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260201.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260201.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260201.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260201.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260201.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260201.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260201.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260201.inputSolicitudLada.sendKeys("52");
            mainPage260201.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260201.inputScianAgregar.click();
            mainPage260201.comboSCIAN.selectOption("614074");
            mainPage260201.inputAgregar.click();
            mainPage260201.inputNumeroLicenciaSanitaria.sendKeys("342");
            mainPage260201.solicitudRegimen.sendKeys("Definitivos");
            mainPage260201.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");
            mainPage260201.inputAgregarAduana.click();
            mainPage260201.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260201.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260201.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260201.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260201.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260201.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            mainPage260201.selectFormaFarmaceutica.selectOptionContainingText("Gel");
            mainPage260201.selectEstadoFisico.selectOptionContainingText("Liquido");
            mainPage260201.inputFraccionArancelaria.sendKeys("29372299");
            mainPage260201.inputCantidadUMT.sendKeys("100");
            mainPage260201.inputCantidadUMC.sendKeys("10");
            mainPage260201.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260201.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260201.inputNumeroRegistroSanitario.sendKeys("62345");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260201.inputFechaCaducidad);sleep(100);
            mainPage260201.buttonAbrirPanelPaisesOrigen.click();
            mainPage260201.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260201.inputAgregarSeleccion.click();
            mainPage260201.inputAbrirPanelPaisesProcedencia.click();
            mainPage260201.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260201.inputAgregarSeleccion2.click();
            mainPage260201.botonAbrirPanelUsosEspecificos.click();
            mainPage260201.UsoEspecifico.sendKeys("RETORNO");
            mainPage260201.botonAgregarSeleccion.click();
            mainPage260201.inputAgregarMercancia.click();
            mainPage260201.inputDeclaracion.click();
            mainPage260201.inputInformacionConfidencialSi.click();
            mainPage260201.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260201.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260201.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260201.labelTerceroRElacionado.click();
            //Fabricante
            mainPage260201.inputAgregarFabricante.click();
            mainPage260201.inputNacionalidadextranjera.click();
            mainPage260201.inputPErsonaMoral.click();
            mainPage260201.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260201.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260201.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260201.terceroCodigoPostal.sendKeys("00000");
            mainPage260201.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260201.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260201.terceroNumExterior.sendKeys("123");
            mainPage260201.terceroNumInterior.sendKeys("4B");
            mainPage260201.inputLada.sendKeys("52");
            mainPage260201.terceroTelefono.sendKeys("5555555555");
            mainPage260201.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260201.btnGuardarDatosTerceros.click();
            //Destinatario
            mainPage260201.inputAgregarDestinatario.click();
            mainPage260201.inputTipoPeronaMoral.click();
            mainPage260201.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260201.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260201.terceroEstado2.sendKeys("MÉXICO");
            mainPage260201.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260201.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260201.terceroCodigoPostal2.sendKeys("55120");
            mainPage260201.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260201.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260201.terceroNumExterior2.sendKeys("123");
            mainPage260201.terceroNumInterior2.sendKeys("4B");
            mainPage260201.inputLada.sendKeys("52");
            mainPage260201.terceroTelefono2.sendKeys("5555555555");
            mainPage260201.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260201.btnGuardarDatosTercero2.click();
//            //Proveedor
//            mainPage260201.inputAgregarProveedor.click();
//            mainPage260201.inputTipoPeronaMoral.click();
//            mainPage260201.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260201.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260201.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260201.terceroCodigoPostal.sendKeys("00000");
//            mainPage260201.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260201.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260201.terceroNumExterior.sendKeys("123");
//            mainPage260201.terceroNumInterior.sendKeys("4B");
//            mainPage260201.inputLada.sendKeys("52");
//            mainPage260201.terceroTelefono.sendKeys("5555555555");
//            mainPage260201.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260201.btnGuardarDatosTerceros.click();
//            //Facturador
//            mainPage260201.inputAgregarFacturador.click();
//            mainPage260201.inputTipoPeronaMoral.click();
//            mainPage260201.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260201.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260201.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260201.terceroCodigoPostal.sendKeys("00000");
//            mainPage260201.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260201.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260201.terceroNumExterior.sendKeys("123");
//            mainPage260201.terceroNumInterior.sendKeys("4B");
//            mainPage260201.inputLada.sendKeys("52");
//            mainPage260201.terceroTelefono.sendKeys("5555555555");
//            mainPage260201.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260201.btnGuardarDatosTerceros.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260201.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PAGO DE DERECHOS
            mainPage260201.labelPagoDerechos.click();
            mainPage260201.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260201.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260201.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260201.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260201.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260201.inputSolicitudPagoLlave.sendKeys("3456452543");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260201.inputCalendar);sleep(100);
            mainPage260201.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260201.InputGuardarSolicitud.click();
            mainPage260201.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260201.btmAnexar.click();sleep(8000);
            Selenide.sleep(2000);
            mainPage260201.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260201.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260201);
            String folioText = mainPage260201.folio.getText();sleep(5000);
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