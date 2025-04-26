package COFEPRIS.Tramite260910;

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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260910Test {
    MainPage260910 mainPage260910 = new MainPage260910();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    ObtenerFolio obtenerFolio = new ObtenerFolio();
    // VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260910 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver() {
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
    public void Proceso260910() {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// -
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// opción
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// de
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones",
                JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será
        // null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
        }

        // Convertir el valor ingresado a entero, manejando posibles excepciones si el
        // usuario no ingresa un número válido
        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            // Si el valor ingresado no es un número válido, asigna un valor por defecto
            // (por ejemplo, 1)
            repeticiones = 1;
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////// -

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260910);
            mainPage260910.selecRol.sendKeys("Persona Moral");
            mainPage260910.btnacep.click();
            mainPage260910.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage260910.SoliSub.click();
            mainPage260910.inputIdFolio.sendKeys("0402600201020254006000005");
            mainPage260910.inputBuscarButton.click();
            sleep(1000);
            mainPage260910.SolicitudTramite.doubleClick();
            mainPage260910.inputSolicitarModificacion.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260910.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // DATOS SOLICITUD
            mainPage260910.labelDatosSolicitud.click();
            mainPage260910.inputModif.click();
            mainPage260910.textareaJustificacionId.sendKeys("SE REALIZAN PRUEBAS");

            // LLENADO
            // LLenado de datos
            //mainPage260910.btnEstablecimiento.click();
            //mainPage260910.buttonAceptar.click();
            mainPage260910.ResponsableSanitarioRFC.setValue("AAL0409235E6");
            mainPage260910.inputSolicitudEstablecimientoRazonSocial.setValue("ModifRazonTest");
            mainPage260910.inputSolicitudEstablecimientoCorreoElectronico.setValue("OtroTest@gmail.com");

            // Domicilio del establecimiento
            mainPage260910.inputSolicitudEstablecimientoDomicilioCodigo.setValue("607034");
            mainPage260910.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("DURANGO");
            mainPage260910.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("MODIF");
            mainPage260910.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad modif Test");
            mainPage260910.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Colonia Modificada");
            mainPage260910.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle Modif QA");
            mainPage260910.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
            mainPage260910.inputSolicitudEstablecimientoDomicilioTelefono.setValue("5091222244");
            sleep(1000);

            // Agregar SCIAN
            mainPage260910.btnAgregarScian.click();
            mainPage260910.selectComboScian.sendKeys("3614011");
            mainPage260910.btnAgregar2Scian.click();
            sleep(1000);
            //

            mainPage260910.checkAvisoFuncionamiento.click();
            mainPage260910.inputNumeroLicencia.sendKeys("73458334");
            mainPage260910.selectSolicitudRegimenClave.sendKeys("Temporales");
            mainPage260910.selectAduanasEntrada.selectOption("TUXPAN, VER.");



            // Agregar Mercancia
            mainPage260910.selectaduana.click();
            mainPage260910.btnModificarAduana.click();

            mainPage260910.selectMercanciaGridClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
            mainPage260910.selectMercanciaGridEspecificaClasProd.sendKeys("III) Agentes de diagnóstico.");
            mainPage260910.inputDenominacionEspecifica.setValue("Denominacion Modificación Test");
            mainPage260910.inputDenominacionDistintiva.setValue("Denominacion Modificación test");
            mainPage260910.inputDenominacionNombreCientif.setValue("Modificación Test Nombre Cientifico");
            mainPage260910.selectMercanciaGridTipoProducto.sendKeys("Producto a granel");
            mainPage260910.comboFormaFarmaceutica.sendKeys("Solución");
            mainPage260910.comboEstadoFisico.sendKeys("Gas");
            // mainPage260204.Especifique.sendKeys("Liquido Especificado");
            mainPage260910.inputFraccionArancelaria.setValue("29372299");
            mainPage260910.inputCantidadUmt.setValue("50");
            mainPage260910.inputCantidadUmc.setValue("50");
            mainPage260910.selectMercanciaGridUnidadMedida.sendKeys("Jeringa");
            mainPage260910.PresentacionFarmaTipoEnvase.setValue("ModificacionQA");
            mainPage260910.NumRegistroSanitario.sendKeys("13579");

            // Pais de origen
            mainPage260910.btnDesplegarInfoPaisOrigen.click();
            mainPage260910.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
            mainPage260910.optionAntartida.click();
            mainPage260910.inputAdd.click();

            // Pais de procedencia
            mainPage260910.btnDesplegarInfoPaisProcedencia.click();
            mainPage260910.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
            mainPage260910.MenuPaisesProcedencia.selectOptionByValue("AND");
            mainPage260910.inputAdd2.click();

            // Uso especifico
//            mainPage260910.btnDesplegarInfoUsoEspecifico.click();
//            mainPage260910.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
//            mainPage260910.MenuUsoEspecifico.selectOption("ANÁLISIS O PRUEBAS DE LABORATORIO");
//            mainPage260910.inputAdd3.click();

            // Agregar la mercancia
            mainPage260910.btnAgregarMercanciaTotalInfo.click();

            // manifiesto y declaraciones
            //mainPage260910.checkCumploRequisitosYNormativas.click();
            //mainPage260910.radNoHacerPublicoInformacion.click();
            // Repesentante legal
            mainPage260910.RepresentanteRFC.sendKeys("LEQI8101314S7");
            mainPage260910.btnBuscarRepresentante.click();

            // TERCEROS RELACIONADOS
            mainPage260910.pestañaPaso1.scrollTo().shouldBe(visible);
            mainPage260910.tabTercerosRelacionados.click();
            mainPage260910.inputModifFabricante.click();
            mainPage260910.btnModificaFabricante.click();

            // Agregar Fabricante
            // DatosGenerales

            //mainPage260910.btnAgregarFabricante.click();
            //mainPage260910.radNacionalTerceros.click();
            //mainPage260910.radPersonaMoral.click();
            mainPage260910.FabricanteRFC.setValue("AAL981209G67");
            mainPage260910.inputTercerosDenominacionRazon.setValue("Denominación/Razón Modificación QA");

            // Datos personales
            /*
             * mainPage260910.inputTercerosNombre.sendKeys("ALICIA ALEJANDRA QA");
             * mainPage260910.inputTercerosApellidoPaterno.sendKeys("LOPEZ QA");
             * mainPage260910.inputTercerosApellidoMaterno.sendKeys("ORTEGA QA");
             */
            mainPage260910.selectTercerosEstado.sendKeys("COLIMA");
            mainPage260910.selectTercerosMunicipio.sendKeys("MANZANILLO");
            mainPage260910.selectTercerosLocalidad.selectOption("AGUA BLANCA");
            mainPage260910.selectTercerosCodPostal.selectOptionByValue("28207");
            mainPage260910.selectTercerosColonia.sendKeys("AZUL MARINO");
            mainPage260910.inputTercerosCalle.setValue("Calle Modificada QA");
            mainPage260910.inputTercerosNumExterior.setValue("11");
            mainPage260910.inputTercerosNumInterior.setValue("6");
            mainPage260910.inputTerceroLada.sendKeys("55");
            mainPage260910.inputTercerosTelefono.setValue("551345907");
            mainPage260910.inputTercerosCorreoElec.setValue("MOdificacion.5@hotmail.com");
            mainPage260910.buttonGuardarDatosTercero.click();

            // Agregar Destinatario (Destino Final)
            mainPage260910.inputDestinatario.click();
            mainPage260910.btnModificarDestinatario.click();

            //mainPage260910.radPersonaMoral.click();
            mainPage260910.FabricanteRFC.setValue("AAL981209G67");
            mainPage260910.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Modificación Destinatario");
            // Datos personales
            /*
             * mainPage260910.inputTercerosNombre.sendKeys("MISAEL");
             * mainPage260910.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
             * mainPage260910.inputTercerosApellidoMaterno.sendKeys("RUIZ");
             */
            mainPage260910.selectTercerosEstado.sendKeys("HIDALGO");
            mainPage260910.selectTercerosMunicipio.sendKeys("APAN");
            mainPage260910.selectTercerosLocalidad.sendKeys("APAN");
            mainPage260910.selectTercerosCodPostal.selectOptionByValue("43905");
            mainPage260910.selectTercerosColonia.sendKeys("CENTRO");
            mainPage260910.inputTercerosCalle.setValue("Calle Modificación Durango QA");
            mainPage260910.inputTercerosNumExterior.setValue("1");
            mainPage260910.inputTercerosNumInterior.setValue("6");
            mainPage260910.inputTerceroLada.setValue("618");
            mainPage260910.inputTercerosTelefono.setValue("61855556670");
            mainPage260910.inputTercerosCorreoElec.setValue("vucemModif2.5@hotmail.com");
            mainPage260910.buttonGuardarDatosTercero.click();

            // Agregar Proveedor
            mainPage260910.inputProveedor.click();
            mainPage260910.btnModificaProveedor.click();
            //mainPage260910.radPersonaMoral.click();
            mainPage260910.inputTercerosDenominacionRazon.setValue("Denominación/Razón Modificación QA PROVEDOR");
            // Datos personales
            /*
             * mainPage260910.inputTercerosNombre.sendKeys("KAZEHANA");
             * mainPage260910.inputTercerosApellidoPaterno.sendKeys("NAKANA");
             * mainPage260910.inputTercerosApellidoMaterno.sendKeys("SORIA");
             */

            mainPage260910.listTercerosPais.selectOptionByValue("DEU");
            mainPage260910.TercerosEstadotxt.setValue("Bergisch Gladbach");
            mainPage260910.CodigoPostaltxt.setValue("34002");
            mainPage260910.TercerosColoniatxt.setValue("12 DE DICIEMBRE");
            mainPage260910.inputTercerosCalle.setValue("Calle Prueba QA");
            mainPage260910.inputTercerosNumExterior.setValue("1");
            mainPage260910.inputTercerosNumInterior.setValue("50");
            mainPage260910.inputTerceroLada.setValue("618");
            mainPage260910.inputTercerosTelefono.setValue("6183336670");
            mainPage260910.inputTercerosCorreoElec.setValue("Modificvucem2.5@hotmail.com");
            mainPage260910.buttonGuardarDatosTercero.click();

            // Agregar facturador
            mainPage260910.inputFacturador.click();
            mainPage260910.btnModificaFacturador.click();
            // mainPage260204.radPersonaFisica.click();
            //mainPage260910.radPersonaMoral.click();
            mainPage260910.inputTercerosDenominacionRazon.setValue("QA Modif FACTURADOR");
            // Datos personales
            /*
             * mainPage260910.inputTercerosNombre.sendKeys("MISAEL");
             * mainPage260910.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
             * mainPage260910.inputTercerosApellidoMaterno.sendKeys("RUIZ");
             */
            mainPage260910.listTercerosPais.selectOptionByValue("MEX");
            mainPage260910.TercerosEstadotxt.setValue("set");
            mainPage260910.CodigoPostaltxt.setValue("34001");
            mainPage260910.TercerosColoniatxt.setValue("12 DE DICIEMBRE");
            mainPage260910.inputTercerosCalle.setValue("Calle Durango QA");
            mainPage260910.inputTercerosNumExterior.setValue("10");
            mainPage260910.inputTercerosNumInterior.setValue("5");
            mainPage260910.inputTerceroLada.setValue("618");
            mainPage260910.inputTercerosTelefono.setValue("6184566670");
            mainPage260910.inputTercerosCorreoElec.setValue("vucem7772.5@hotmail.com");
            mainPage260910.buttonGuardarDatosTercero.click();
            // PAGO DE DERECHOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260910.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260910.labelPagoDerechos.click();

            mainPage260910.inputSolicitudPagoLlave.click();
            Random random = new Random();
            int nFacturaR = 10_000_000 + random.nextInt(90_000_000);
            mainPage260910.inputSolicitudPagoClaveReferencia.setValue(String.valueOf(nFacturaR));
            // mainPage260910.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260910.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260910.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            int inputSolicitudPagoLlave = 10_000_000 + random.nextInt(90_000_000);
            mainPage260910.inputSolicitudPagoLlave.setValue(String.valueOf(nFacturaR));
            // mainPage260910.inputSolicitudPagoLlave.sendKeys("3456456243");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260910.inputCalendar);
            sleep(100);
            mainPage260910.inputSolicitudPagoImp.sendKeys("2000");
            mainPage260910.inputGuardarSolicitud.click();

            // GUARDAR
            mainPage260910.inputGuarda.click();
            sleep(1000);
            mainPage260910.inputAdjuntar.click();
            mainPage260910.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260910.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260910.btnAnexar.click();
            sleep(2000);
            mainPage260910.btnCerrar.click();sleep(2000);
            sleep(500);
            mainPage260910.inputSiguiente.click();sleep(2000);
            sleep(500);
            // FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260910);
            sleep(500);
            String folioText = mainPage260910.folio.getText();
            sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
        }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run(); // Ejecuta el proceso de la clase
        }
    }
}