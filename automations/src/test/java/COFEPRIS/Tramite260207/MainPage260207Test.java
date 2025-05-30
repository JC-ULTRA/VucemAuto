package COFEPRIS.Tramite260207;

import COFEPRIS.Tramite260207.MainPage260207;
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

public class MainPage260207Test {
    MainPage260207 mainPage260207 = new MainPage260207();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260207  = new TramitesFirmasLG(
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
    public void Proceso260207() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260207");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260207");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260207");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260207");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260207");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260207");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260207);
            mainPage260207.selecRol.sendKeys("Persona Moral");
            mainPage260207.btnacep.click();
            mainPage260207.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260207.SoliNew.click();
            mainPage260207.Cofepris.click();
            mainPage260207.linkCertificadosLicenciasPermisos.click();
            mainPage260207.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260207.linkPermisoSanImpMedDesTraEsp.click();
            //DATOS SSOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260207.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260207.labelDatosSolicitud.click();
            mainPage260207.inputEstablecimiento.click();
            Selenide.sleep(2000);
            metodos.presionarEscYSpace();
            mainPage260207.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260207.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260207.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260207.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260207.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260207.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260207.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260207.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260207.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260207.inputSolicitudLada.sendKeys("52");
            mainPage260207.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260207.inputScianAgregar.click();
            mainPage260207.comboSCIAN.selectOption("311239");
            mainPage260207.inputAgregar.click();
            mainPage260207.inputAvisoFuncionamiento.click();
            mainPage260207.solicitudRegimen.sendKeys("Definitivos");
            mainPage260207.aduanaEntrada.selectOption("ADUANA DE PANTACO");
            mainPage260207.inputAgregarAduana.click();
            mainPage260207.selectClasificacionProducto.sendKeys("MEDICAMENTOS/ FARMACO");
            mainPage260207.selectSubClasificacionProducto.sendKeys("I) Alopáticos");
            mainPage260207.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260207.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260207.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260207.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            mainPage260207.selectFormaFarmaceutica.selectOptionContainingText("Tabletas");
            mainPage260207.selectEstadoFisico.selectOptionContainingText("Solido");
            mainPage260207.inputFraccionArancelaria.sendKeys("30019099");
            mainPage260207.inputCantidadUMT.sendKeys("100");
            mainPage260207.inputCantidadUMC.sendKeys("10");
            mainPage260207.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260207.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260207.inputNumeroRegistroSanitario.sendKeys("62345");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260207.inputFechaCaducidad);sleep(100);
            mainPage260207.buttonAbrirPanelPaisesOrigen.click();
            mainPage260207.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260207.inputAgregarSeleccion.click();
            mainPage260207.inputAbrirPanelPaisesProcedencia.click();
            mainPage260207.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260207.inputAgregarSeleccion2.click();
            mainPage260207.botonAbrirPanelUsosEspecificos.click();
            mainPage260207.UsoEspecifico.sendKeys("USO MÉDICO");
            mainPage260207.botonAgregarSeleccion.click();
            mainPage260207.inputAgregarMercancia.click();
            mainPage260207.inputDeclaracion.click();
            mainPage260207.inputInformacionConfidencialSi.click();
            mainPage260207.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260207.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260207.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260207.labelTerceroRElacionado.click();
            //Fabricante
//            mainPage260207.inputAgregarFabricante.click();
//            mainPage260207.inputNacionalidadextranjera.click();
//            mainPage260207.inputPErsonaMoral.click();
//            mainPage260207.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
//            mainPage260207.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260207.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260207.terceroCodigoPostal.sendKeys("00000");
//            mainPage260207.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260207.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260207.terceroNumExterior.sendKeys("123");
//            mainPage260207.terceroNumInterior.sendKeys("4B");
//            mainPage260207.inputLada.sendKeys("52");
//            mainPage260207.terceroTelefono.sendKeys("5555555555");
//            mainPage260207.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260207.btnGuardarDatosTerceros.click();
            //Destinatario
            mainPage260207.inputAgregarDestinatario.click();
            mainPage260207.inputTipoPeronaMoral.click();
            mainPage260207.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260207.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260207.terceroEstado2.sendKeys("MÉXICO");
            mainPage260207.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260207.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260207.terceroCodigoPostal2.sendKeys("55120");
            mainPage260207.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260207.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260207.terceroNumExterior2.sendKeys("123");
            mainPage260207.terceroNumInterior2.sendKeys("4B");
            mainPage260207.inputLada.sendKeys("52");
            mainPage260207.terceroTelefono2.sendKeys("5555555555");
            mainPage260207.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260207.btnGuardarDatosTercero2.click();
//            //Proveedor
//            mainPage260207.inputAgregarProveedor.click();
//            mainPage260207.inputTipoPeronaMoral.click();
//            mainPage260207.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260207.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260207.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260207.terceroCodigoPostal.sendKeys("00000");
//            mainPage260207.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260207.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260207.terceroNumExterior.sendKeys("123");
//            mainPage260207.terceroNumInterior.sendKeys("4B");
//            mainPage260207.inputLada.sendKeys("52");
//            mainPage260207.terceroTelefono.sendKeys("5555555555");
//            mainPage260207.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260207.btnGuardarDatosTerceros.click();
//            //Facturador
//            mainPage260207.inputAgregarFacturador.click();
//            mainPage260207.inputTipoPeronaMoral.click();
//            mainPage260207.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
//            mainPage260207.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
//            mainPage260207.terceroEstadoLocalidad.sendKeys("PRUEBA");
//            mainPage260207.terceroCodigoPostal.sendKeys("00000");
//            mainPage260207.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
//            mainPage260207.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
//            mainPage260207.terceroNumExterior.sendKeys("123");
//            mainPage260207.terceroNumInterior.sendKeys("4B");
//            mainPage260207.inputLada.sendKeys("52");
//            mainPage260207.terceroTelefono.sendKeys("5555555555");
//            mainPage260207.terceroCorreo.sendKeys("contacto@fabricante.com");
//            mainPage260207.btnGuardarDatosTerceros.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260207.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PAGO DE DERECHOS
            mainPage260207.labelPagoDerechos.click();
            mainPage260207.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260207.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260207.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260207.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260207.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260207.inputSolicitudPagoLlave.sendKeys("3456452543");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260207.inputCalendar);sleep(100);
            mainPage260207.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260207.InputGuardarSolicitud.click();
            mainPage260207.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260207.btmAnexar.click();sleep(4000);
            Selenide.sleep(8000);
            mainPage260207.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260207.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260207);
            String folioText = mainPage260207.folio.getText();sleep(5000);
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