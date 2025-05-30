package COFEPRIS.Tramite260208;


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

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260208Test {
    MainPage260208 mainPage260208 = new MainPage260208();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260208  = new TramitesFirmasLG(
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
    public void Proceso260208() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260208");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260208");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260208");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260208");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260208");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260208");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260208);
            mainPage260208.selecRol.sendKeys("Persona Moral");
            mainPage260208.btnacep.click();
            mainPage260208.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260208.SoliNew.click();
            mainPage260208.Cofepris.click();
            mainPage260208.linkCertificadosLicenciasPermisos.click();
            mainPage260208.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260208.linkPermisoSanImpMedDesUsoPersonal.click();
            //DATOS SSOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260208.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260208.labelDatosSolicitud.click();
            mainPage260208.inputEstablecimiento.click();
            Selenide.sleep(2000);
            metodos.presionarEscYSpace();
            //mainPage260208.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260208.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260208.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260208.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260208.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260208.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260208.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260208.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260208.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260208.inputSolicitudLada.sendKeys("52");
            mainPage260208.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("55555555");
            mainPage260208.inputScianAgregar.click();
            mainPage260208.comboSCIAN.selectOption("614071");
            mainPage260208.inputAgregar.click();
            mainPage260208.inputAvisoFuncionamiento.click();
            mainPage260208.solicitudRegimen.sendKeys("Definitivos");
            mainPage260208.aduanaEntrada.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");sleep(500);
            mainPage260208.inputAduanaAIFA.click();
            Selenide.executeJavaScript("arguments[0].name = 'aduanaAIFA';",mainPage260208.aduanaEntrada);
            mainPage260208.inputAgregarAduana.click();
            mainPage260208.selectClasificacionProducto.sendKeys("MEDICAMENTOS/ FARMACO");
            mainPage260208.selectSubClasificacionProducto.sendKeys("I) Alopáticos");
            mainPage260208.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260208.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260208.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260208.selectTipoProductoTipoTramite.sendKeys("Advitivo");
            mainPage260208.selectFormaFarmaceutica.selectOptionContainingText("Tabletas");
            mainPage260208.selectEstadoFisico.selectOptionContainingText("Granulado o polvo");
            mainPage260208.inputFraccionArancelaria.sendKeys("30049036");
            mainPage260208.inputCantidadUMT.sendKeys("100");
            mainPage260208.inputCantidadUMC.sendKeys("10");
            mainPage260208.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260208.textareaPresentacion.sendKeys("Aguja");
//            mainPage260208.inputNumeroRegistroSanitario.sendKeys("62345");
//            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260208.inputFechaCaducidad);sleep(100);
            mainPage260208.buttonAbrirPanelPaisesOrigen.click();
            mainPage260208.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260208.inputAgregarSeleccion.click();
            mainPage260208.inputAbrirPanelPaisesProcedencia.click();
            mainPage260208.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260208.inputAgregarSeleccion2.click();
            mainPage260208.botonAbrirPanelUsosEspecificos.click();
            mainPage260208.UsoEspecifico.sendKeys("Uso o consumo personal");
            mainPage260208.botonAgregarSeleccion.click();
            mainPage260208.inputAgregarMercancia.click();
            mainPage260208.inputDeclaracion.click();
            mainPage260208.inputInformacionConfidencialSi.click();
//            mainPage260208.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
//            mainPage260208.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260208.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260208.labelTerceroRElacionado.click();
            //Fabricante
            mainPage260208.inputAgregarFabricante.click();
            mainPage260208.inputNacionalidadextranjera.click();
            mainPage260208.inputPErsonaMoral.click();
            mainPage260208.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            mainPage260208.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260208.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260208.terceroCodigoPostal.sendKeys("00000");
            mainPage260208.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260208.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260208.terceroNumExterior.sendKeys("123");
            mainPage260208.terceroNumInterior.sendKeys("4B");
            mainPage260208.inputLada.sendKeys("52");
            mainPage260208.terceroTelefono.sendKeys("5555555555");
            mainPage260208.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260208.btnGuardarDatosTerceros.click();
            //Destinatario
            mainPage260208.inputAgregarDestinatario.click();
            mainPage260208.inputTipoPeronaMoral.click();
            mainPage260208.inputTerceroRFC2.sendKeys("AST850530NI3");
            mainPage260208.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260208.terceroEstado2.sendKeys("MÉXICO");
            mainPage260208.terceroMunicipio2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260208.terceroLocalidad2.sendKeys("ECATEPEC DE MORELOS");
            mainPage260208.terceroCodigoPostal2.sendKeys("55120");
            mainPage260208.terceroColonia2.sendKeys("10 DE ABRIL");
            mainPage260208.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260208.terceroNumExterior2.sendKeys("123");
            mainPage260208.terceroNumInterior2.sendKeys("4B");
            mainPage260208.inputLada.sendKeys("52");
            mainPage260208.terceroTelefono2.sendKeys("5555555555");
            mainPage260208.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260208.btnGuardarDatosTercero2.click();
            //Proveedor
            mainPage260208.inputAgregarProveedor.click();
            mainPage260208.inputTipoPeronaMoral.click();
            mainPage260208.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260208.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260208.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260208.terceroCodigoPostal.sendKeys("00000");
            mainPage260208.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260208.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260208.terceroNumExterior.sendKeys("123");
            mainPage260208.terceroNumInterior.sendKeys("4B");
            mainPage260208.inputLada.sendKeys("52");
            mainPage260208.terceroTelefono.sendKeys("5555555555");
            mainPage260208.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260208.btnGuardarDatosTerceros.click();
            //Facturador
            mainPage260208.inputAgregarFacturador.click();
            mainPage260208.inputTipoPeronaMoral.click();
            mainPage260208.inputTerceroRazonSocial2.sendKeys("PRUEBAS SA DE CV");
            mainPage260208.inputPais.sendKeys("CHINA (REPUBLICA POPULAR)");
            mainPage260208.terceroEstadoLocalidad.sendKeys("PRUEBA");
            mainPage260208.terceroCodigoPostal.sendKeys("00000");
            mainPage260208.terceroColoniaEquiv.sendKeys("10 DE ABRIL");
            mainPage260208.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260208.terceroNumExterior.sendKeys("123");
            mainPage260208.terceroNumInterior.sendKeys("4B");
            mainPage260208.inputLada.sendKeys("52");
            mainPage260208.terceroTelefono.sendKeys("55555555");
            mainPage260208.terceroCorreo.sendKeys("contacto@fabricante.com");
            mainPage260208.btnGuardarDatosTerceros.click();
            //PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260208.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //PAGO DE DERECHOS
            mainPage260208.labelPagoDerechos.click();
            mainPage260208.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage260208.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(cveReferencia));
            mainPage260208.inputSolicitudPagoCadenaDependencia.sendKeys("846272654");
            mainPage260208.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random aleatorio = new Random();
            int nFacturaR = 10_000_000 + aleatorio.nextInt(90_000_000);
            mainPage260208.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            //mainPage260208.inputSolicitudPagoLlave.sendKeys("3456452543");
            executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260208.inputCalendar);sleep(100);
            mainPage260208.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260208.InputGuardarSolicitud.click();
            mainPage260208.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage260208.btmAnexar.click();sleep(4000);
            Selenide.sleep(8000);
            mainPage260208.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage260208.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260208);
            String folioText = mainPage260208.folio.getText();sleep(5000);
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