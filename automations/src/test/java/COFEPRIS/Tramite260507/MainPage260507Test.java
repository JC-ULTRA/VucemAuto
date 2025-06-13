package COFEPRIS.Tramite260507;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260507Test {
    MainPage260507 mainPage260507 = new MainPage260507();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite260507  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }


    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso260507() throws IOException {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el método si se selecciona cancelar
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


        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite260507);
            mainPage260507.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage260507.btnacep.click();sleep(1000);

            //Busqueda de tramite
            mainPage260507.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
            mainPage260507.SoliNew.click();//sleep(1000);
            mainPage260507.Cofepris.click();//sleep(1000);
            mainPage260507.CertificadosLicenciasPermisos.click();//sleep(1000);
            mainPage260507.PermisoImportacionToxicosPeligro.click();//sleep(1000);
            mainPage260507.elementoPlagisidasDependencias.click();sleep(1000);

            //PASO 1 CAPTURAR SOLICITUD
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            //Pestaña Datos de solicitud
            mainPage260507.DatosSolicitud.click();
            //Datos del establecimiento
            mainPage260507.btnEstablecimiento.click();
            mainPage260507.buttonAceptar.click();
            mainPage260507.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
            mainPage260507.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
            mainPage260507.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
            //Domicilio del establecimiento
            mainPage260507.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
            mainPage260507.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260507.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
            mainPage260507.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
            mainPage260507.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
            mainPage260507.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
            mainPage260507.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
            mainPage260507.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

            //Agregar SCIAN
            mainPage260507.btnAgregarScian.click();
            mainPage260507.selectComboScian.sendKeys("311239");
            mainPage260507.btnAgregar2Scian.click();sleep(1000);

            //Aduanas de entrada
            mainPage260507.listAduanasEntrada.sendKeys("CIUDAD HIDALGO");
            mainPage260507.btnAgregarAduanaentrada.click();

            //Agregar Mercancia
            mainPage260507.btnAgregarMercancia.click();
            //Identificación del producto
            mainPage260507.NombreComercial.sendKeys("QA Nombre comercial");
            mainPage260507.NombreComun.sendKeys("QA Nombre comun");
            mainPage260507.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
            mainPage260507.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
            mainPage260507.inputFraccionArancelaria.sendKeys("29173902");
            mainPage260507.inputCantidadUmt.sendKeys("19210");
            mainPage260507.inputCantidadUmc.sendKeys("403");
            mainPage260507.selectUMC.selectOption("Gramos");
            mainPage260507.PorcentajeConcentracion.sendKeys("15");
            // mainPage260507.NumRegistroSanitario.sendKeys("693402");
            //País donde se produce o fabrica el ingrediente activo
            mainPage260507.btnDesplegarInfoPaisFabricante.click();
            mainPage260507.listaPaisFabricante.selectOption("CANADA");
            mainPage260507.btnAgregarPaisFabricante.click();
            //País donde se elabora el producto
            mainPage260507.btnDesplegarInfoPaisElabora.click();
            mainPage260507.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
            mainPage260507.btnAgregarPaisElabora.click();
            //País proveedor (Origen)
            mainPage260507.btnDesplegarInfoPaisProveedor.click();
            mainPage260507.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
            mainPage260507.btnAgregarPaisProveedor.click();
            //País de procedencia/ País del último puerto de embarque
            mainPage260507.btnDesplegarInfoPaisProcedencia.click();
            mainPage260507.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
            mainPage260507.btnAgregarPaisProcedencia.click();
            //Clasificación Toxicológica e importación
            mainPage260507.selectClasificacionToxi.selectOption("5");
            mainPage260507.selectObjetoImportacion.selectOption("Distribución");
            //Agregar la información de la mercancia
            mainPage260507.btnAgregarMercanciaTotalInfo.click();

            //Manifiesto y declaraciones
            mainPage260507.checkCumploRequisitosYNormativas.click();
            mainPage260507.radNoHacerPublicoInformacion.click();
            //Repesentante legal
            mainPage260507.RepresentanteRFC.sendKeys("ZURA6808202RA");
            mainPage260507.btnBuscarRepresentante.click();


            //TERCEROS RELACIONADOS
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            mainPage260507.tabTercerosRelacionados.click();

            //Agregar Fabricante
            //DatosGenerales
            mainPage260507.btnAgregarFabricante.click();
            mainPage260507.radExtranjeroTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
            //Datos personales
            mainPage260507.listTercerosPais.selectOption("CANADA");
            mainPage260507.CodigoPostaltxt.sendKeys("7550000");
            mainPage260507.TercerosEstadotxt.sendKeys("Ontario");
            mainPage260507.inputTercerosCalle.sendKeys("Imperial St");
            mainPage260507.inputTercerosNumExterior.sendKeys("50");
            mainPage260507.inputTercerosNumInterior.sendKeys("2");
            mainPage260507.inputTerceroLada.sendKeys("416");
            mainPage260507.inputTercerosTelefono.sendKeys("416-485-111");
            mainPage260507.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
            mainPage260507.buttonGuardarDatosTercero.click();

            //Agregar Formulador
            //DatosGenerales
            mainPage260507.btnAgregarFormulador.click();
            mainPage260507.radNacionalTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.TercerosRFC.sendKeys("AAL0409235E6");
            mainPage260507.btnBuscarTerceroRFC.click();
            mainPage260507.buttonGuardarDatosTercero.click();

            //Agregar Proveedor
            mainPage260507.btnAgregarProveedor.click();
            mainPage260507.radExtranjeroTerceros.click();
            mainPage260507.radPersonaMoral.click();
            mainPage260507.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
            mainPage260507.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
            mainPage260507.CodigoPostaltxt.sendKeys("7550000");
            mainPage260507.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
            mainPage260507.inputTercerosCalle.sendKeys("Manzano QA");
            mainPage260507.inputTercerosNumExterior.sendKeys("70");
            mainPage260507.inputTercerosNumInterior.sendKeys("2");
            mainPage260507.inputTerceroLada.sendKeys("2");
            mainPage260507.inputTercerosTelefono.sendKeys("212-100-000");
            mainPage260507.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
            mainPage260507.buttonGuardarDatosTercero.click();

            //PAGO DERECHOS
            mainPage260507.Scrol.scrollTo().shouldBe(visible);
            mainPage260507.tabPagoDerechos.click();
            mainPage260507.ClaveReferencia.sendKeys("284000255");sleep(1000);
            mainPage260507.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage260507.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage260507.inpLLavePago.sendKeys(llavePago);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage260507.FechaPago, fechaHoy);
            mainPage260507.ImportePago.sendKeys("100");
            mainPage260507.btnContinuarDatosCompletos.click();

            //Paso2 REQUISITOS NECESARIOS
            mainPage260507.btnContinuarPaso2.click();

            //Paso 3
            metodos.cargarDocumentos();
            mainPage260507.btnAdjuntar2.click();
            mainPage260507.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
            Selenide.sleep(3000);
            mainPage260507.btnCerrar3.click();
            Selenide.sleep(1000);
            //Paso 3 (Continuacion)
            mainPage260507.btnContinuar3.click();

            //Firma
            loginFirmSoli.firma(tramite260507);sleep(3000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage260507.folio.getText();

            // Llamar al metodo para obtener el folio
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