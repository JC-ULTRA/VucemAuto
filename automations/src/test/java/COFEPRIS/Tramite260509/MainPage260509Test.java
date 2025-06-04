package COFEPRIS.Tramite260509;

import COFEPRIS.Tramite260509.MainPage260509;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260509Test {


        MainPage260509 mainPage260509 = new MainPage260509();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260509  = new TramitesFirmasLG(
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
        public void Proceso260509() throws IOException {
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
                loginFirmSoli.login(tramite260509);
                mainPage260509.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260509.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260509.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260509.SoliNew.click();//sleep(1000);
                mainPage260509.Cofepris.click();//sleep(1000);
                mainPage260509.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260509.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260509.elementoTramite260509.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260509.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260509.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260509.btnEstablecimiento.click();
                mainPage260509.buttonAceptar.click();
                mainPage260509.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260509.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260509.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260509.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260509.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260509.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260509.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260509.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260509.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260509.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260509.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260509.btnAgregarScian.click();
                mainPage260509.selectComboScian.sendKeys("320");
                mainPage260509.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260509.listAduanasEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
                mainPage260509.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260509.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260509.NombreComercial.sendKeys("QA Nombre comercial Nutriente vegetal");
                mainPage260509.NombreComun.sendKeys("QA Nombre comun Nutriente Vegetal");
                mainPage260509.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico Veg");
                mainPage260509.inputFraccionArancelaria.sendKeys("31010001");
                mainPage260509.inputCantidadUmt.sendKeys("19210");
                mainPage260509.inputCantidadUmc.sendKeys("403");
                mainPage260509.selectUMC.selectOption("Gramos");
                mainPage260509.PorcentajeConcentracion.sendKeys("15");
                //País donde se produce o fabrica el ingrediente activo
                mainPage260509.btnDesplegarInfoPaisFabricante.click();
                mainPage260509.listaPaisFabricante.selectOption("CANADA");
                mainPage260509.btnAgregarPaisFabricante.click();
                //País donde se elabora el producto
                mainPage260509.btnDesplegarInfoPaisElabora.click();
                mainPage260509.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260509.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260509.btnDesplegarInfoPaisProveedor.click();
                mainPage260509.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260509.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260509.btnDesplegarInfoPaisProcedencia.click();
                mainPage260509.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260509.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260509.selectClasificacionToxi.selectOption("II ALTAMENTE TOXICO");
                mainPage260509.selectObjetoImportacion.selectOption("Experimentación");
                //Agregar la información de la mercancia
                mainPage260509.btnAgregarMercanciaTotalInfo.click();

                //Garantías ofrecidas
                mainPage260509.GarantiasOfrecidas.sendKeys("Garantias QA");

                //Manifiesto y declaraciones
                mainPage260509.checkCumploRequisitosYNormativas.click();
                mainPage260509.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260509.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260509.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260509.Scrol.scrollTo().shouldBe(visible);
                mainPage260509.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260509.btnAgregarFabricante.click();
                mainPage260509.radExtranjeroTerceros.click();
                mainPage260509.radPersonaMoral.click();
                mainPage260509.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260509.listTercerosPais.selectOption("CANADA");
                mainPage260509.CodigoPostaltxt.sendKeys("7550000");
                mainPage260509.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260509.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260509.inputTercerosNumExterior.sendKeys("50");
                mainPage260509.inputTercerosNumInterior.sendKeys("2");
                mainPage260509.inputTerceroLada.sendKeys("416");
                mainPage260509.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260509.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260509.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260509.btnAgregarFormulador.click();
                mainPage260509.radNacionalTerceros.click();
                mainPage260509.radPersonaMoral.click();
                mainPage260509.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260509.btnBuscarTerceroRFC.click();
                mainPage260509.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260509.btnAgregarProveedor.click();
                mainPage260509.radExtranjeroTerceros.click();
                mainPage260509.radPersonaMoral.click();
                mainPage260509.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260509.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260509.CodigoPostaltxt.sendKeys("7550000");
                mainPage260509.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260509.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260509.inputTercerosNumExterior.sendKeys("70");
                mainPage260509.inputTercerosNumInterior.sendKeys("2");
                mainPage260509.inputTerceroLada.sendKeys("2");
                mainPage260509.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260509.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260509.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260509.Scrol.scrollTo().shouldBe(visible);
                mainPage260509.tabPagoDerechos.click();
                mainPage260509.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260509.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260509.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260509.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260509.FechaPago, fechaHoy);
                mainPage260509.ImportePago.sendKeys("100");
                mainPage260509.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260509.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260509.btnAdjuntar2.click();
                mainPage260509.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260509.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260509.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260509);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260509.folio.getText();

                // Llamar al metodo para obtener el folio
                String folioNumber = obtenerFolio.obtenerFolio(folioText);

//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
            }, repeticiones);
        }


        public void clickOkButton() {
            // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
            $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
        }

        //Metodo que ejecuta n veces una clase que implementa Runnable
        public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
            for (int i = 0; i < n; i++) {
                System.out.println("Ejecución del Proceso: " + (i + 1));
                open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
                proceso.run();  // Ejecuta el proceso de la clase
            }
        }

        public void desactivarPago() {
            String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
            String user = "vucem_app_p01";
            String password = "Mfk22nvW6na71DgBXi5R";
            String query = "UPDATE vuc_pago_sea SET BLN_ACTIVO = 0 WHERE linea_de_captura = '032000Q0GHM128445291'";

            try (
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PreparedStatement statement = connection.prepareStatement(query);
            ) {
                int filasActualizadas = statement.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("El registro ha sido actualizado correctamente.");
                } else {
                    System.out.println("No se encontró el registro con la línea de captura proporcionada.");
                }
            } catch (SQLException e) {
                System.err.println("Error al ejecutar el query: " + e.getMessage());
            }

        }




    }

