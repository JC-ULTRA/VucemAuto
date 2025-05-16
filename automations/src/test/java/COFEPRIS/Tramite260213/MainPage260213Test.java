package COFEPRIS.Tramite260213;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260213Test {
    MainPage260213 mainPage260213 = new MainPage260213();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260213  = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso260213() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260213");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260213");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260213");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260213");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260213");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260213");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260213);
            mainPage260213.selecRol.sendKeys("Persona Moral");
            mainPage260213.btnacep.click();
            mainPage260213.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260213.SoliNew.click();
            mainPage260213.Cofepris.click();
            mainPage260213.linkCertificadosLicenciasPermisos.click();
            mainPage260213.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260213.linkDispositivosMedicosPersonal.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260213.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260213.labelDatosSolicitud.click();
            mainPage260213.inputEstablecimiento.click();
            Selenide.sleep(1000);
            presionarEscYSpace();
//            mainPage260213.btnAceptar.click();
            //mainPage260213.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260213.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260213.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260213.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260213.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260213.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260213.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260213.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260213.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260213.inputSolicitudEstablecimientoDomicilioLada.sendKeys("52");
            mainPage260213.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260213.inputScianAgregar.click();
            mainPage260213.comboSCIAN.selectOption("311321");


            mainPage260213.inputAgregar.click();
            mainPage260213.inputAvisoFuncionamiento.click();
            mainPage260213.solicitudRegimen.sendKeys("Definitivos");
            mainPage260213.aduanaEntrada.selectOption("AEROPUERTO INTERNACIONAL FELIPE ÁNGELES");
            mainPage260213.inputAgregarAduana.click();
            mainPage260213.selectClasificacionProducto.sendKeys("REMEDIOS HERBOLARIOS ");
            mainPage260213.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260213.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260213.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260213.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260213.selectTipoProductoTipoTramite.sendKeys("Materia prima");
            //mainPage260213.selectFormaFarmaceutica.sendKeys("");
            mainPage260213.selectEstadoFisico.sendKeys("Liquido");
            mainPage260213.inputFraccionArancelaria.sendKeys("30039013");
            mainPage260213.inputCantidadUMT.sendKeys("100");
            mainPage260213.inputCantidadUMC.sendKeys("10");
            mainPage260213.selectUnidadMedidaComercial.sendKeys("Bote");
            mainPage260213.textareaPresentacion.sendKeys("Presentación CAJA CHICA");
            //mainPage260213.inputRgistroSanitario.sendKeys("1234535");
            //Selenide.executeJavaScript("arguments[0].value = '20/04/2025';", mainPage260213.inputCaducidad);sleep(100);
            mainPage260213.buttonAbrirPanelPaisesOrigen.click();
            mainPage260213.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260213.inputAgregarSeleccion.click();
            mainPage260213.inputAbrirPanelPaisesProcedencia.click();
            mainPage260213.PaisProcedencia.selectOptionContainingText("ARGENTINA (REPUBLICA)");
            mainPage260213.inputAgregarSeleccion2.click();
            mainPage260213.botonAbrirPanelUsosEspecificos.click();
            mainPage260213.UsoEspecifico.sendKeys("USO O CONSUMO PERSONAL");
            mainPage260213.botonAgregarSeleccion.click();
            mainPage260213.inputAgregarMercancia.click();
            mainPage260213.inputDeclaracion.click();
            mainPage260213.inputInformacionConfidencialSi.click();
            //mainPage260213.inputRepresentanteLegalRFC.sendKeys("HEUE780514BVA");
            //mainPage260213.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260213.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260213.labelTerceroRElacionado.click();
            //FABRICANTE
            mainPage260213.inputAgregarFabricante.click();
            mainPage260213.inputNacionalidadMexicana.click();
            mainPage260213.inputPErsonaMoral.click();
            mainPage260213.inputTerceroRFC.sendKeys("AAL0409235E6");
            mainPage260213.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            //mainPage260213.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260213.terceroEstado.sendKeys("CIUDAD DE MÉXICO");
            mainPage260213.terceroMunicipio.sendKeys("XOCHIMILCO");
            mainPage260213.terceroLocalidad.sendKeys("EL CEDRAL");
            mainPage260213.terceroCodigoPostal.sendKeys("16000");
            mainPage260213.terceroColonia.sendKeys("ACOCA");
            mainPage260213.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260213.terceroNumExterior.sendKeys("123");
            mainPage260213.terceroNumInterior.sendKeys("4B");
            mainPage260213.terceroLada.sendKeys("52");
            mainPage260213.terceroTelefono.sendKeys("5555555555");
            mainPage260213.terceroCorreo.sendKeys("contacto@fabricante.com");
            //DESTINATARIO
            mainPage260213.btnGuardarDatosTerceros.click();
            mainPage260213.inputAgregarDestinatario.click();
            mainPage260213.inputTipoPeronaMoral.click();
            mainPage260213.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260213.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260213.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260213.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260213.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260213.terceroCodigoPostal2.sendKeys("06278");
            mainPage260213.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260213.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260213.terceroNumExterior2.sendKeys("123");
            mainPage260213.terceroNumInterior2.sendKeys("4B");
            mainPage260213.terceroLada.sendKeys("52");
            mainPage260213.terceroTelefono2.sendKeys("5555555555");
            mainPage260213.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260213.btnGuardarDatosTercero2.click();
            //PROVEEDOR
            mainPage260213.inputAgregarProveedor.click();
            mainPage260213.inputTipoPeronaFisica.click();
            mainPage260213.inputTerceroNombre3.sendKeys("PEDRO");
            mainPage260213.inputTerceroApePAter3.sendKeys("PARAMO");
            mainPage260213.inputTerceroApeMAter3.sendKeys("PEREZ");
            mainPage260213.inputPais3.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260213.terceroEstadoLocalidad3.sendKeys("LUXEMBURGO");
            mainPage260213.terceroCodigoPostal3.sendKeys("00000");
            mainPage260213.terceroColoniaEquiv3.sendKeys("10 DE ABRIL");
            mainPage260213.terceroCalle3.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260213.terceroNumExterior3.sendKeys("123");
            mainPage260213.terceroNumInterior3.sendKeys("4B");
            mainPage260213.terceroLada.sendKeys("52");
            mainPage260213.terceroTelefono3.sendKeys("5555555555");
            mainPage260213.terceroCorreo3.sendKeys("contacto@fabricante.com");
            mainPage260213.btnGuardarDatosTercero3.click();
            //FACTURADOR
            mainPage260213.inputAgregarFacturador.click();
            mainPage260213.inputTipoPeronaFisica4.click();
            mainPage260213.inputTerceroNombre4.sendKeys("HARRY");
            mainPage260213.inputTerceroApePAter4.sendKeys("POTTER");
            mainPage260213.inputTerceroApeMAter4.sendKeys("HERNANDEZ");
            mainPage260213.inputPais4.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
            mainPage260213.terceroEstadoLocalidad4.sendKeys("AMSTERDAM");
            mainPage260213.terceroCodigoPostal4.sendKeys("00000");
            mainPage260213.terceroColoniaEquiv4.sendKeys("10 DE ABRIL");
            mainPage260213.terceroCalle4.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260213.terceroNumExterior4.sendKeys("123");
            mainPage260213.terceroNumInterior4.sendKeys("4B");
            mainPage260213.terceroLada.sendKeys("52");
            mainPage260213.terceroTelefono4.sendKeys("5555555555");
            mainPage260213.terceroCorreo4.sendKeys("contacto@fabricante.com");
            mainPage260213.btnGuardarDatosTercero4.click();

            //PAGO DE DERECHOS
            mainPage260213.labelPagoDerechos.click();
            mainPage260213.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260213.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260213.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            Random random = new Random();
            int inputSolicitudPagoLlave = 10_000_000 + random.nextInt(90_000_000);
            mainPage260213.inputSolicitudPagoLlave.setValue(String.valueOf(inputSolicitudPagoLlave));
            mainPage260213.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260213.inputCalendar);sleep(100);
            //GUARDAR
            mainPage260213.inputGuardarSolicitud.click();
            mainPage260213.inputGuarda.click();sleep(1000);
            mainPage260213.inputAdjuntar.click();sleep(1000);
            subirDocumentos("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260213.btnAnexar.click();sleep(20000);
            mainPage260213.btnCerrar.click();
            mainPage260213.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260213);
            String folioText = mainPage260213.folio.getText();
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
    public void subirDocumentos(String rutaArchivo) {
        ElementsCollection inputs = $$x("//input[starts-with(@name, 'documentos') and substring(@name, string-length(@name) - 4) = '.file']");

        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }
    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }

}