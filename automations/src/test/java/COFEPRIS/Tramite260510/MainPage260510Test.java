package COFEPRIS.Tramite260510;

import COFEPRIS.Tramite260510.MainPage260510;
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

public class MainPage260510Test {


        MainPage260510 mainPage260510 = new MainPage260510();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260510  = new TramitesFirmasLG(
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
        public void Proceso260510() throws IOException {
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
                loginFirmSoli.login(tramite260510);
                mainPage260510.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260510.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260510.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260510.SoliNew.click();//sleep(1000);
                mainPage260510.Cofepris.click();//sleep(1000);
                mainPage260510.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260510.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260510.elementoTramite260510.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260510.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260510.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260510.btnEstablecimiento.click();
                mainPage260510.buttonAceptar.click();
                mainPage260510.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260510.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260510.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260510.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260510.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260510.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260510.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260510.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260510.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260510.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260510.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260510.btnAgregarScian.click();
                mainPage260510.selectComboScian.sendKeys("311701");
                mainPage260510.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260510.listAduanasEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
                mainPage260510.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260510.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260510.NombreComercial.sendKeys("QA Nombre comercial Nutriente vegetal");
                mainPage260510.NombreComun.sendKeys("QA Nombre comun Nutriente Vegetal");
                mainPage260510.inputDenominacionNombreCientif.sendKeys("QA Nombre Científico Veg");
                mainPage260510.inputFraccionArancelaria.sendKeys("29319099");
                mainPage260510.inputCantidadUmt.sendKeys("160");
                mainPage260510.inputCantidadUmc.sendKeys("100");
                mainPage260510.selectUMC.selectOption("Gramos");
                mainPage260510.PorcentajeConcentracion.sendKeys("10");
                //País donde se produce o fabrica el ingrediente activo
                mainPage260510.btnDesplegarInfoPaisFabricante.click();
                mainPage260510.listaPaisFabricante.selectOption("CANADA");
                mainPage260510.btnAgregarPaisFabricante.click();
                //País donde se elabora el producto
                mainPage260510.btnDesplegarInfoPaisElabora.click();
                mainPage260510.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260510.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260510.btnDesplegarInfoPaisProveedor.click();
                mainPage260510.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260510.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260510.btnDesplegarInfoPaisProcedencia.click();
                mainPage260510.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260510.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260510.selectClasificacionToxi.selectOption("II ALTAMENTE TOXICO");
                mainPage260510.selectObjetoImportacion.selectOption("Experimentación");
                //Agregar la información de la mercancia
                mainPage260510.btnAgregarMercanciaTotalInfo.click();

                //Garantías ofrecidas
                mainPage260510.GarantiasOfrecidas.sendKeys("Garantías QA Analíticos");

                //Manifiesto y declaraciones
                mainPage260510.checkCumploRequisitosYNormativas.click();
                mainPage260510.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260510.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260510.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260510.Scrol.scrollTo().shouldBe(visible);
                mainPage260510.tabTercerosRelacionados.click();

                //Agregar Proveedor
                mainPage260510.btnAgregarProveedor.click();
                mainPage260510.radExtranjeroTerceros.click();
                mainPage260510.radPersonaMoral.click();
                mainPage260510.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260510.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260510.CodigoPostaltxt.sendKeys("7550000");
                mainPage260510.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260510.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260510.inputTercerosNumExterior.sendKeys("70");
                mainPage260510.inputTercerosNumInterior.sendKeys("2");
                mainPage260510.inputTerceroLada.sendKeys("2");
                mainPage260510.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260510.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260510.buttonGuardarDatosTercero.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260510.btnAgregarFabricante.click();
                mainPage260510.radExtranjeroTerceros.click();
                mainPage260510.radPersonaMoral.click();
                mainPage260510.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260510.listTercerosPais.selectOption("CANADA");
                mainPage260510.CodigoPostaltxt.sendKeys("7550000");
                mainPage260510.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260510.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260510.inputTercerosNumExterior.sendKeys("50");
                mainPage260510.inputTercerosNumInterior.sendKeys("2");
                mainPage260510.inputTerceroLada.sendKeys("416");
                mainPage260510.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260510.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260510.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260510.btnAgregarFormulador.click();
                mainPage260510.radNacionalTerceros.click();
                mainPage260510.radPersonaMoral.click();
                mainPage260510.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260510.btnBuscarTerceroRFC.click();
                mainPage260510.buttonGuardarDatosTercero.click();


                //PAGO DERECHOS
                mainPage260510.Scrol.scrollTo().shouldBe(visible);
                mainPage260510.tabPagoDerechos.click();
                mainPage260510.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260510.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260510.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260510.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260510.FechaPago, fechaHoy);
                mainPage260510.ImportePago.sendKeys("100");
                mainPage260510.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260510.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260510.btnAdjuntar2.click();
                mainPage260510.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260510.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260510.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260510);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260510.folio.getText();

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

