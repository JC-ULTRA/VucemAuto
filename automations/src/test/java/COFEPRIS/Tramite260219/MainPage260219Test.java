package COFEPRIS.Tramite260219;

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

public class MainPage260219Test {
    MainPage260219 mainPage260219 = new MainPage260219();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260219  = new TramitesFirmasLG(
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
    public void Proceso260219() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260219");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260219");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260219");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260219");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260219");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260219");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260219);
            mainPage260219.selecRol.sendKeys("Persona Moral");
            mainPage260219.btnacep.click();
            mainPage260219.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260219.SoliNew.click();
            mainPage260219.Cofepris.click();
            mainPage260219.linkCertificadosLicenciasPermisos.click();
            mainPage260219.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260219.linkPermisoSanImpRemediosHerbolarios.click();
            //DATOS SSOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260219.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260219.labelDatosSolicitud.click();
            mainPage260219.inputEstablecimiento.click();
            Selenide.sleep(2000);
            metodos.presionarEscYSpace();
            mainPage260219.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260219.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260219.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260219.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260219.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260219.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260219.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260219.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260219.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260219.inputSolicitudLada.sendKeys("52");
            mainPage260219.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("55555555");
            mainPage260219.inputScianAgregar.click();
            mainPage260219.comboSCIAN.selectOption("614031");
            mainPage260219.inputAgregar.click();
            mainPage260219.inputAvisoFuncionamiento.click();
            mainPage260219.solicitudRegimen.sendKeys("Definitivos");
            mainPage260219.aduanaEntrada.selectOption("COLOMBIA");sleep(500);
            //mainPage260219.inputAduanaAIFA.click();
            //Selenide.executeJavaScript("arguments[0].name = 'aduanaAIFA';",mainPage260219.aduanaEntrada);
            mainPage260219.inputAgregarAduana.click();
            mainPage260219.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260219.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260219.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260219.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260219.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260219.selectTipoProductoTipoTramite.sendKeys("Otro");
            mainPage260219.inputEspecifique.sendKeys("PRUEBA");
            mainPage260219.selectFormaFarmaceutica.selectOptionContainingText("Emulsión");
            mainPage260219.selectEstadoFisico.selectOptionContainingText("Liquido");
            mainPage260219.inputFraccionArancelaria.sendKeys("13021999");
            mainPage260219.inputCantidadUMT.sendKeys("100");
            mainPage260219.inputCantidadUMC.sendKeys("10");
            mainPage260219.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260219.textareaPresentacion.sendKeys("Ampolleta");
            mainPage260219.inputNumeroRegistroSanitario.sendKeys("62345");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260219.inputFechaCaducidad);sleep(100);
            mainPage260219.buttonAbrirPanelPaisesOrigen.click();
            mainPage260219.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260219.inputAgregarSeleccion.click();
            mainPage260219.inputAbrirPanelPaisesProcedencia.click();
            mainPage260219.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260219.inputAgregarSeleccion2.click();
            mainPage260219.botonAbrirPanelUsosEspecificos.click();
            mainPage260219.UsoEspecifico.sendKeys("Muestra");
            mainPage260219.botonAgregarSeleccion.click();
            mainPage260219.inputAgregarMercancia.click();
            mainPage260219.inputDeclaracion.click();
            mainPage260219.inputInformacionConfidencialNo.click();
            mainPage260219.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260219.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260219.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260219.labelTerceroRElacionado.click();
            //Fabricante
            mainPage260219.inputAgregarFabricante.click();
            mainPage260219.inputNacionalidadextranjera.click();
            mainPage260219.inputPErsonaMoral.click();
            mainPage260219.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260219.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260219.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260219.terceroCodigoPostal.sendKeys("00000");
            mainPage260219.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260219.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260219.terceroNumExterior.sendKeys("123");
            mainPage260219.terceroNumInterior.sendKeys("4B");
            mainPage260219.inputLada.sendKeys("52");
            mainPage260219.terceroTelefono.sendKeys("5555555555");
            mainPage260219.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260219.btnGuardarDatosTerceros.click();
            //Destinatario
            mainPage260219.inputAgregarDestinatario.click();
            mainPage260219.inputTipoPeronaMoral.click();
            mainPage260219.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260219.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260219.terceroEstado2.sendKeys("MÉXICO");
            mainPage260219.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260219.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260219.terceroCodigoPostal2.sendKeys("55120");
            mainPage260219.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260219.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260219.terceroNumExterior2.sendKeys("123");
            mainPage260219.terceroNumInterior2.sendKeys("4B");
            mainPage260219.inputLada.sendKeys("52");
            mainPage260219.terceroTelefono2.sendKeys("5555555555");
            mainPage260219.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260219.btnGuardarDatosTercero2.click();
            //Proveedor
            mainPage260219.inputAgregarProveedor.click();
            mainPage260219.inputTipoPeronaMoral.click();
            mainPage260219.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260219.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260219.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260219.terceroCodigoPostal.sendKeys("00000");
            mainPage260219.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260219.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260219.terceroNumExterior.sendKeys("123");
            mainPage260219.terceroNumInterior.sendKeys("4B");
            mainPage260219.inputLada.sendKeys("52");
            mainPage260219.terceroTelefono.sendKeys("5555555555");
            mainPage260219.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260219.btnGuardarDatosTerceros.click();
            //Facturador
            mainPage260219.inputAgregarFacturador.click();
            mainPage260219.inputTipoPeronaMoral.click();
            mainPage260219.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260219.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260219.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260219.terceroCodigoPostal.sendKeys("00000");
            mainPage260219.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260219.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260219.terceroNumExterior.sendKeys("123");
            mainPage260219.terceroNumInterior.sendKeys("4B");
            mainPage260219.inputLada.sendKeys("52");
            mainPage260219.terceroTelefono.sendKeys("55555555");
            mainPage260219.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260219.btnGuardarDatosTerceros.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260219.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PAGO DE DERECHOS
            mainPage260219.labelPagoDerechos.click();
            mainPage260219.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260219.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260219.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260219.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260219.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260219.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260219.inputCalendar);sleep(100);
            mainPage260219.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260219.InputGuardarSolicitud.click();
            mainPage260219.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260219.btmAnexar.click();sleep(4000);
            Selenide.sleep(8000);
            mainPage260219.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260219.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260219);
            String folioText = mainPage260219.folio.getText();sleep(5000);
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