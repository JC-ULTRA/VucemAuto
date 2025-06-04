package COFEPRIS.Tramite260508;

import COFEPRIS.Tramite260508.MainPage260508;
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

public class MainPage260508Test {


        MainPage260508 mainPage260508 = new MainPage260508();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260508  = new TramitesFirmasLG(
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
        public void Proceso260508() throws IOException {
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
                loginFirmSoli.login(tramite260508);
                mainPage260508.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260508.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260508.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260508.SoliNew.click();//sleep(1000);
                mainPage260508.Cofepris.click();//sleep(1000);
                mainPage260508.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260508.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260508.elementoTramite260508.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260508.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260508.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260508.btnEstablecimiento.click();
                mainPage260508.buttonAceptar.click();
                mainPage260508.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260508.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260508.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260508.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260508.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260508.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260508.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260508.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260508.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260508.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260508.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260508.btnAgregarScian.click();
                mainPage260508.selectComboScian.sendKeys("614079");
                mainPage260508.btnAgregar2Scian.click();sleep(1000);

                //Aviso Funcionamiento
                mainPage260508.checkAvisoFuncionamiento.click();
                mainPage260508.inputNumeroLicencia.sendKeys("4645456");

                //Aduanas de entrada
                mainPage260508.listAduanasEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
                mainPage260508.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260508.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260508.NombreComercial.sendKeys("QA Nombre comercial");
                mainPage260508.NombreComun.sendKeys("QA Nombre comun");
                mainPage260508.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
                mainPage260508.inputFraccionArancelaria.sendKeys("28401999");
                mainPage260508.inputCantidadUmt.sendKeys("19210");
                mainPage260508.inputCantidadUmc.sendKeys("403");
                mainPage260508.selectUMC.selectOption("Gramos");
                mainPage260508.PorcentajeConcentracion.sendKeys("15");
                mainPage260508.NumRegistroSanitario.sendKeys("693402");
                //País donde se produce o fabrica el ingrediente activo
                mainPage260508.btnDesplegarInfoPaisFabricante.click();
                mainPage260508.listaPaisFabricante.selectOption("CANADA");
                mainPage260508.btnAgregarPaisFabricante.click();
                //País donde se elabora el producto
                mainPage260508.btnDesplegarInfoPaisElabora.click();
                mainPage260508.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260508.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260508.btnDesplegarInfoPaisProveedor.click();
                mainPage260508.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260508.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260508.btnDesplegarInfoPaisProcedencia.click();
                mainPage260508.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260508.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260508.selectClasificacionToxi.selectOption("I EXTREMADAMENTE TOXICO");
                mainPage260508.selectObjetoImportacion.selectOption("Formulación");
                //Agregar la información de la mercancia
                mainPage260508.btnAgregarMercanciaTotalInfo.click();

                //Garantías ofrecidas
                mainPage260508.GarantiasOfrecidas.sendKeys("Garantias QA");

                //Manifiesto y declaraciones
                mainPage260508.checkCumploRequisitosYNormativas.click();
                mainPage260508.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260508.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260508.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260508.Scrol.scrollTo().shouldBe(visible);
                mainPage260508.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260508.btnAgregarFabricante.click();
                mainPage260508.radExtranjeroTerceros.click();
                mainPage260508.radPersonaMoral.click();
                mainPage260508.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260508.listTercerosPais.selectOption("CANADA");
                mainPage260508.CodigoPostaltxt.sendKeys("7550000");
                mainPage260508.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260508.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260508.inputTercerosNumExterior.sendKeys("50");
                mainPage260508.inputTercerosNumInterior.sendKeys("2");
                mainPage260508.inputTerceroLada.sendKeys("416");
                mainPage260508.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260508.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260508.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260508.btnAgregarFormulador.click();
                mainPage260508.radNacionalTerceros.click();
                mainPage260508.radPersonaMoral.click();
                mainPage260508.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260508.btnBuscarTerceroRFC.click();
                mainPage260508.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260508.btnAgregarProveedor.click();
                mainPage260508.radExtranjeroTerceros.click();
                mainPage260508.radPersonaMoral.click();
                mainPage260508.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260508.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260508.CodigoPostaltxt.sendKeys("7550000");
                mainPage260508.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260508.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260508.inputTercerosNumExterior.sendKeys("70");
                mainPage260508.inputTercerosNumInterior.sendKeys("2");
                mainPage260508.inputTerceroLada.sendKeys("2");
                mainPage260508.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260508.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260508.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260508.Scrol.scrollTo().shouldBe(visible);
                mainPage260508.tabPagoDerechos.click();
                mainPage260508.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260508.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260508.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260508.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260508.FechaPago, fechaHoy);
                mainPage260508.ImportePago.sendKeys("100");
                mainPage260508.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260508.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260508.btnAdjuntar2.click();
                mainPage260508.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260508.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260508.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260508);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260508.folio.getText();

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

