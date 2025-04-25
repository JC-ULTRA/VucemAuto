package COFEPRIS.Tramite260701;

import COFEPRIS.Tramite260701.MainPage260701;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260701Test {
    MainPage260701 mainPage260701 = new MainPage260701();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260701  = new TramitesFirmasLG(
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
    public void Proceso260701() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260701");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260701");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260701");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen260701");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion260701");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion260701");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260701);
            mainPage260701.selecRol.sendKeys("Persona Moral");
            mainPage260701.btnacep.click();

            //Búsqueda de tramite Subsecuente
            mainPage260701.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260701.SoliSub.click();
            mainPage260701.FolioTramite.sendKeys(FolioTramiteN);
            mainPage260701.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage260701.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Solicitar modificación y Prórroga
            mainPage260701.btnModificacionProrroga.click();

            //LLenado de datos
            mainPage260701.tabDatosSolicitud.click();
            mainPage260701.radbtnModificacion.click();
            mainPage260701.JustificacionModificacion.sendKeys("Modificacion Justificación QA");
            mainPage260701.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificacion");
            mainPage260701.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestModificacion@gmail.com");

            //Domicilio del establecimiento
            mainPage260701.inputSolicitudEstablecimientoDomicilioCodigo.setValue("607059");
            mainPage260701.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
            mainPage260701.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("El Llano Modificacion");
            mainPage260701.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Llano Localidad Test Modificacion");
            mainPage260701.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Colonia Test Modificacion");
            mainPage260701.inputSolicitudEstablecimientoDomicilioCalle.setValue("Ignacio Zaragoza MOdificacion");
            mainPage260701.inputSolicitudEstablecimientoDomicilioTelefono.setValue("5091222233");sleep(1000);

            //Licencia y aviso de funcionamiento
            // mainPage260701.checkAvisoFuncionamiento.click();
            mainPage260701.inputNumeroLicencia.setValue("543245");

            //VICO/FRESCO/ENHIELADO y Regimen Destino Mercancia
            //mainPage260701.checkVivoFrescEnhielado.click();
            mainPage260701.selectSolicitudRegimenClave.sendKeys("Temporales");
            mainPage260701.selectAduanasEntrada.sendKeys("TIJUANA");

            //Modificacion de Mercancia
            mainPage260701.selectGridElemento1Mercancia.click();
            mainPage260701.btnModificarMercancia.click();
            mainPage260701.selectMercanciaGridClasificacionProducto.sendKeys("ALIMENTOS");sleep(500);
            mainPage260701.selectMercanciaGridClasificacionProducto2.sendKeys("Pastas, granos y semillas");sleep(500);
            mainPage260701.inputDenominacionEspecifica.setValue("Prueba Modificacion");sleep(500);
            mainPage260701.inputDenominacionEspecifica2.setValue("Prueba Marca Modificacion");sleep(500);
            mainPage260701.inputTipoTramiteMercancia.sendKeys("Producto terminado");sleep(500);
            mainPage260701.inputCantidadUmt.setValue("10");sleep(500);
            mainPage260701.inputCantidadUmc.setValue("5");sleep(500);
            mainPage260701.inputDetalleUmc.sendKeys("Botellas");sleep(500);
            //Clave Lote Modificar
            mainPage260701.checkGridClaveLote1.click();
            mainPage260701.btnModificarClaveLote.click();
            mainPage260701.inputClaveLotes.setValue("12845");sleep(500);
            Selenide.executeJavaScript("arguments[0].value = '05/04/2025';", mainPage260701.inputFechaElaboracion);sleep(100);
            Selenide.executeJavaScript("arguments[0].value = '12/04/2025';", mainPage260701.inputFechaCaducidad);sleep(100);
            mainPage260701.btnGuardarModificarClaveLote.click();
            mainPage260701.btnGuardarModificarMercancia.click();

            //Repesentante legal
            mainPage260701.RepresentanteRFC.setValue("MAVL621207C95");
            mainPage260701.btnBuscarRepresentante.click();

            //TERCEROS RELACIONADOS
            mainPage260701.Scrol.scrollTo();
            mainPage260701.tabTercerosRelacionados.click();
            //Modificacion destinatario
            mainPage260701.checkGridTerceroDestino1.click();
            mainPage260701.btnModificarTerceroDestinatario.click();
            mainPage260701.radbtnTipoPersonaMoral.click();
            mainPage260701.MoralFabricanteRFC.setValue("AAL0409235E6");
            mainPage260701.DenominacionFabricanteMoral.setValue("TOROS MODIFICACION");
            mainPage260701.selectTercerosEstado.sendKeys("DURANGO");
            mainPage260701.selectTercerosMunicipio.sendKeys("DURANGO");
            mainPage260701.selectTercerosLocalidad.sendKeys("15 DE MAYO");
            mainPage260701.selectTercerosCodPostal.selectOptionByValue("34001");
            mainPage260701.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
            mainPage260701.inputTercerosCalle.sendKeys("Calle Durango QA Modificacion");
            mainPage260701.inputTercerosNumExterior.sendKeys("10");
            mainPage260701.inputTercerosNumInterior.sendKeys("5");
            mainPage260701.inputTerceroLada.sendKeys("618");
            mainPage260701.inputTercerosTelefono.sendKeys("618-813-6670");
            mainPage260701.inputTercerosCorreoElec.sendKeys("ModificacionQA.5@hotmail.com");
            mainPage260701.btnGuardarTerceroDestinatario.click();

            //Modificacion fabricante
            mainPage260701.checkGridTerceroFabricante1.click();
            mainPage260701.btnModificarTerceroFabricante.click();
            mainPage260701.radbtnNacionalTerceros.click();
            mainPage260701.radbtnPersonaFisica.click();
            mainPage260701.FabricanteRFC.sendKeys("LEQI8101314S7");
            mainPage260701.btnBuscarFabricante.click();
            mainPage260701.btnGuardarModificarFabricante.click();

            //PAGO DERECHOS
            mainPage260701.Scrol.scrollTo();
            mainPage260701.tabPagoDerechos.click();
            mainPage260701.ClaveReferencia.sendKeys("284000255");sleep(1000);
            mainPage260701.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage260701.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage260701.inpLLavePago.sendKeys(llavePago);sleep(1000);
            Selenide.executeJavaScript("arguments[0].value = '24/04/2025';", mainPage260701.FechaPago); sleep(1000);
            mainPage260701.ImportePago.sendKeys("100");
            mainPage260701.btnContinuarDatosCompletos.click();

            //Paso 2
            mainPage260701.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage260701.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage260701.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260701.btnSelectArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260701.btnAdjuntar2.click();sleep(2000);
            mainPage260701.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage260701.btnCerrar3.click();sleep(1000);

            //FIRMAR SOLICITUD
            //loginFirmSoli.firma(tramite260701);

            // Obtener el texto del folio desde mainPage130103
            String folioText = mainPage260701.folio.getText();

            // Llamar al mtodo para obtener el folio
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
