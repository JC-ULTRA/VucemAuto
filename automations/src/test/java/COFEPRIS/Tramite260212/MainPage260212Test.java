package COFEPRIS.Tramite260212;

import COFEPRIS.Tramite260212.MainPage260212;
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
public class MainPage260212Test {
    MainPage260212 mainPage260212 = new MainPage260212();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260212  = new TramitesFirmasLG(
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
    public void Proceso260212() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260212");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260212");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260212");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260212");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260212");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260212");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260212);
            mainPage260212.selecRol.sendKeys("Persona Moral");
            mainPage260212.btnacep.click();
            mainPage260212.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260212.SoliNew.click();
            mainPage260212.Cofepris.click();
            mainPage260212.linkCertificadosLicenciasPermisos.click();
            mainPage260212.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260212.linkDispositivosMedicosMaquila.click();

            mainPage260212.labelDatosSolicitud.click();
            mainPage260212.inputEstablecimiento.click();
            mainPage260212.btnAceptar.click();
            mainPage260212.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260212.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260212.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260212.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260212.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260212.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260212.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260212.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260212.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260212.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260212.inputScianAgregar.click();
            mainPage260212.comboSCIAN.selectOption("311239");


            mainPage260212.inputAgregar.click();
            mainPage260212.inputAvisoFuncionamiento.click();
            mainPage260212.solicitudRegimen.sendKeys("Definitivos");
            mainPage260212.aduanaEntrada.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage260212.inputAgregarAduana.click();
            mainPage260212.selectClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260212.selectSubClasificacionProducto.sendKeys("I) Equipo o instrumental médico.");
            mainPage260212.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260212.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260212.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260212.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260212.selectFormaFarmaceutica.sendKeys("");
            mainPage260212.selectEstadoFisico.sendKeys("Solido");
            mainPage260212.inputFraccionArancelaria.sendKeys("30039013");
            mainPage260212.inputCantidadUMT.sendKeys("100");
            mainPage260212.inputCantidadUMC.sendKeys("10");
            mainPage260212.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260212.textareaPresentacion.sendKeys("Presentación CAJA CHICA");
            //mainPage260212.inputRgistroSanitario.sendKeys("1234535");
            //Selenide.executeJavaScript("arguments[0].value = '20/04/2025';", mainPage260212.inputCaducidad);sleep(100);
            mainPage260212.buttonAbrirPanelPaisesOrigen.click();
            mainPage260212.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260212.inputAgregarSeleccion.click();
            mainPage260212.inputAbrirPanelPaisesProcedencia.click();
            mainPage260212.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260212.inputAgregarSeleccion2.click();
            mainPage260212.botonAbrirPanelUsosEspecificos.click();
            mainPage260212.UsoEspecifico.sendKeys("Maquila");
            mainPage260212.botonAgregarSeleccion.click();
            mainPage260212.inputAgregarMercancia.click();
            mainPage260212.inputDeclaracion.click();
            mainPage260212.inputInformacionConfidencialSi.click();
            mainPage260212.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            mainPage260212.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS


            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260212.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260212.labelTerceroRElacionado.click();
            //FABRICANTE
            mainPage260212.inputAgregarFabricante.click();
            mainPage260212.inputNacionalidadMexicana.click();
            mainPage260212.inputPErsonaMoral.click();
            mainPage260212.inputTerceroRFC.sendKeys("AAL0409235E6");
            mainPage260212.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            //mainPage260212.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260212.terceroEstado.sendKeys("CIUDAD DE MÉXICO");
            mainPage260212.terceroMunicipio.sendKeys("XOCHIMILCO");
            mainPage260212.terceroLocalidad.sendKeys("EL CEDRAL");
            mainPage260212.terceroCodigoPostal.sendKeys("16000");
            mainPage260212.terceroColonia.sendKeys("ACOCA");
            mainPage260212.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260212.terceroNumExterior.sendKeys("123");
            mainPage260212.terceroNumInterior.sendKeys("4B");
            mainPage260212.terceroTelefono.sendKeys("5555555555");
            mainPage260212.terceroCorreo.sendKeys("contacto@fabricante.com");
            //DESTINATARIO
            mainPage260212.btnGuardarDatosTerceros.click();
            mainPage260212.inputAgregarDestinatario.click();
            mainPage260212.inputTipoPeronaMoral.click();
            mainPage260212.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260212.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260212.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260212.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260212.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260212.terceroCodigoPostal2.sendKeys("06278");
            mainPage260212.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260212.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260212.terceroNumExterior2.sendKeys("123");
            mainPage260212.terceroNumInterior2.sendKeys("4B");
            mainPage260212.terceroTelefono2.sendKeys("5555555555");
            mainPage260212.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260212.btnGuardarDatosTercero2.click();
            //PROVEEDOR
            mainPage260212.inputAgregarProveedor.click();
            mainPage260212.inputTipoPeronaFisica.click();
            mainPage260212.inputTerceroNombre3.sendKeys("PEDRO");
            mainPage260212.inputTerceroApePAter3.sendKeys("PARAMO");
            mainPage260212.inputTerceroApeMAter3.sendKeys("PEREZ");
            mainPage260212.inputPais3.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260212.terceroEstadoLocalidad3.sendKeys("LUXEMBURGO");
            mainPage260212.terceroCodigoPostal3.sendKeys("00000");
            mainPage260212.terceroColoniaEquiv3.sendKeys("10 DE ABRIL");
            mainPage260212.terceroCalle3.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260212.terceroNumExterior3.sendKeys("123");
            mainPage260212.terceroNumInterior3.sendKeys("4B");
            mainPage260212.terceroTelefono3.sendKeys("5555555555");
            mainPage260212.terceroCorreo3.sendKeys("contacto@fabricante.com");
            mainPage260212.btnGuardarDatosTercero3.click();
            //FACTURADOR
            mainPage260212.inputAgregarFacturador.click();
            mainPage260212.inputTipoPeronaFisica4.click();
            mainPage260212.inputTerceroNombre4.sendKeys("HARRY");
            mainPage260212.inputTerceroApePAter4.sendKeys("POTTER");
            mainPage260212.inputTerceroApeMAter4.sendKeys("HERNANDEZ");
            mainPage260212.inputPais4.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
            mainPage260212.terceroEstadoLocalidad4.sendKeys("AMSTERDAM");
            mainPage260212.terceroCodigoPostal4.sendKeys("00000");
            mainPage260212.terceroColoniaEquiv4.sendKeys("10 DE ABRIL");
            mainPage260212.terceroCalle4.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260212.terceroNumExterior4.sendKeys("123");
            mainPage260212.terceroNumInterior4.sendKeys("4B");
            mainPage260212.terceroTelefono4.sendKeys("5555555555");
            mainPage260212.terceroCorreo4.sendKeys("contacto@fabricante.com");
            mainPage260212.btnGuardarDatosTercero4.click();

            //PAGO DE DERECHOS
//            try {
//                Thread.sleep(2000); // Pausa de 3 segundos
//                // Hacer scroll hasta el elemento
//                mainPage260212.Scrol.scrollIntoView(true);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            mainPage260212.labelPagoDerechos.click();
            mainPage260212.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260212.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260212.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260212.inputSolicitudPagoLlave.sendKeys("3456456243");
            mainPage260212.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260212.inputCalendar);sleep(100);
            mainPage260212.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260212.inputGuarda.click();sleep(1000);
            mainPage260212.inputAdjuntar.click();
            mainPage260212.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260212.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260212.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260212.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260212.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260212.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260212.btnAnexar.click();sleep(20000);
            mainPage260212.btnCerrar.click();
            mainPage260212.inputSiguiente.click();
            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260212);
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
