package COFEPRIS.Tramite260504;

import COFEPRIS.Tramite260504.MainPage260504;
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

public class MainPage260504Test {


        MainPage260504 mainPage260504 = new MainPage260504();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260504  = new TramitesFirmasLG(
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
        public void Proceso260504() throws IOException {
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
                loginFirmSoli.login(tramite260504);
                mainPage260504.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260504.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260504.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260504.SoliNew.click();//sleep(1000);
                mainPage260504.Cofepris.click();//sleep(1000);
                mainPage260504.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260504.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260504.elementoTramite260504.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260504.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260504.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260504.btnEstablecimiento.click();
                mainPage260504.buttonAceptar.click();
                mainPage260504.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260504.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260504.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260504.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260504.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260504.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260504.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260504.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260504.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260504.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260504.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260504.btnAgregarScian.click();
                mainPage260504.selectComboScian.sendKeys("0");
                mainPage260504.btnAgregar2Scian.click();sleep(1000);

                //Aviso de funcionamiento
                mainPage260504.checkAvisoFuncionamiento.click();
                mainPage260504.inputNumeroLicencia.sendKeys("227394");

                //Aduanas de entrada
                mainPage260504.listAduanasEntrada.sendKeys("CIUDAD HIDALGO");
                mainPage260504.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260504.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260504.NombreComercial.sendKeys("QA Nombre comercial");
                mainPage260504.NombreComun.sendKeys("QA Nombre comun");
                mainPage260504.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
                mainPage260504.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
                mainPage260504.inputFraccionArancelaria.sendKeys("29189901");
                mainPage260504.inputCantidadUmt.sendKeys("20010");
                mainPage260504.inputCantidadUmc.sendKeys("25");
                mainPage260504.selectUMC.selectOption("Bote");
                mainPage260504.PorcentajeConcentracion.sendKeys("435");
                mainPage260504.NumRegistroSanitario.sendKeys("693402");
                //País donde se produce o fabrica el ingrediente activo
                mainPage260504.btnDesplegarInfoPaisFabricante.click();
                mainPage260504.listaPaisFabricante.selectOption("CANADA");
                mainPage260504.btnAgregarPaisFabricante.click();
                //País donde se elabora el producto
                mainPage260504.btnDesplegarInfoPaisElabora.click();
                mainPage260504.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260504.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260504.btnDesplegarInfoPaisProveedor.click();
                mainPage260504.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260504.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260504.btnDesplegarInfoPaisProcedencia.click();
                mainPage260504.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260504.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260504.selectClasificacionToxi.selectOption("2");
                mainPage260504.selectObjetoImportacion.selectOption("Distribución");
                //Agregar la información de la mercancia
                mainPage260504.btnAgregarMercanciaTotalInfo.click();

                //Manifiesto y declaraciones
                mainPage260504.checkCumploRequisitosYNormativas.click();
                mainPage260504.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260504.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260504.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260504.Scrol.scrollTo().shouldBe(visible);
                mainPage260504.tabTercerosRelacionados.click();

                //Agregar Proveedor
                mainPage260504.btnAgregarProveedor.click();
                mainPage260504.radExtranjeroTerceros.click();
                mainPage260504.radPersonaMoral.click();
                mainPage260504.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260504.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260504.CodigoPostaltxt.sendKeys("7550000");
                mainPage260504.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260504.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260504.inputTercerosNumExterior.sendKeys("70");
                mainPage260504.inputTercerosNumInterior.sendKeys("2");
                mainPage260504.inputTerceroLada.sendKeys("2");
                mainPage260504.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260504.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260504.buttonGuardarDatosTercero.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260504.btnAgregarFabricante.click();
                mainPage260504.radExtranjeroTerceros.click();
                mainPage260504.radPersonaMoral.click();
                mainPage260504.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260504.listTercerosPais.selectOption("CANADA");
                mainPage260504.CodigoPostaltxt.sendKeys("7550000");
                mainPage260504.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260504.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260504.inputTercerosNumExterior.sendKeys("50");
                mainPage260504.inputTercerosNumInterior.sendKeys("2");
                mainPage260504.inputTerceroLada.sendKeys("416");
                mainPage260504.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260504.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260504.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260504.btnAgregarFormulador.click();
                mainPage260504.radNacionalTerceros.click();
                mainPage260504.radPersonaMoral.click();
                mainPage260504.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260504.btnBuscarTerceroRFC.click();
                mainPage260504.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260504.Scrol.scrollTo().shouldBe(visible);
                mainPage260504.tabPagoDerechos.click();
                mainPage260504.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260504.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260504.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260504.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260504.FechaPago, fechaHoy);
                mainPage260504.ImportePago.sendKeys("100");
                mainPage260504.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260504.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260504.btnAdjuntar2.click();
                mainPage260504.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260504.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260504.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260504);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260504.folio.getText();

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

