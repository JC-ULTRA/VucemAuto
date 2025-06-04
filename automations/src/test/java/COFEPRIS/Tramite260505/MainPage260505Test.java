package COFEPRIS.Tramite260505;

import COFEPRIS.Tramite260505.MainPage260505;
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

public class MainPage260505Test {


        MainPage260505 mainPage260505 = new MainPage260505();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260505  = new TramitesFirmasLG(
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
        public void Proceso260505() throws IOException {
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
                loginFirmSoli.login(tramite260505);
                mainPage260505.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260505.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260505.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260505.SoliNew.click();//sleep(1000);
                mainPage260505.Cofepris.click();//sleep(1000);
                mainPage260505.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260505.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260505.elementoTramite260505.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260505.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260505.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260505.btnEstablecimiento.click();
                mainPage260505.buttonAceptar.click();
                mainPage260505.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260505.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260505.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260505.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260505.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260505.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260505.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260505.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260505.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260505.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260505.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260505.btnAgregarScian.click();
                mainPage260505.selectComboScian.sendKeys("31423");
                mainPage260505.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260505.listAduanasEntrada.sendKeys("CIUDAD HIDALGO");
                mainPage260505.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260505.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260505.NombreComercial.sendKeys("QA Nombre comercial");
                mainPage260505.NombreComun.sendKeys("QA Nombre comun");
                mainPage260505.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
                mainPage260505.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
                mainPage260505.inputFraccionArancelaria.sendKeys("28401999");
                mainPage260505.inputCantidadUmt.sendKeys("19210");
                mainPage260505.inputCantidadUmc.sendKeys("403");
                mainPage260505.selectUMC.selectOption("Gramos");
                mainPage260505.PorcentajeConcentracion.sendKeys("15");
               // mainPage260505.NumRegistroSanitario.sendKeys("693402");
                //País donde se produce o fabrica el ingrediente activo
                mainPage260505.btnDesplegarInfoPaisFabricante.click();
                mainPage260505.listaPaisFabricante.selectOption("CANADA");
                mainPage260505.btnAgregarPaisFabricante.click();
                //País donde se elabora el producto
                mainPage260505.btnDesplegarInfoPaisElabora.click();
                mainPage260505.listaPaisElabora.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260505.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260505.btnDesplegarInfoPaisProveedor.click();
                mainPage260505.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260505.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260505.btnDesplegarInfoPaisProcedencia.click();
                mainPage260505.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260505.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260505.selectClasificacionToxi.selectOption("2");
                mainPage260505.selectObjetoImportacion.selectOption("Distribución");
                //Agregar la información de la mercancia
                mainPage260505.btnAgregarMercanciaTotalInfo.click();

                //Manifiesto y declaraciones
                mainPage260505.checkCumploRequisitosYNormativas.click();
                mainPage260505.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260505.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260505.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260505.Scrol.scrollTo().shouldBe(visible);
                mainPage260505.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260505.btnAgregarFabricante.click();
                mainPage260505.radExtranjeroTerceros.click();
                mainPage260505.radPersonaMoral.click();
                mainPage260505.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260505.listTercerosPais.selectOption("CANADA");
                mainPage260505.CodigoPostaltxt.sendKeys("7550000");
                mainPage260505.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260505.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260505.inputTercerosNumExterior.sendKeys("50");
                mainPage260505.inputTercerosNumInterior.sendKeys("2");
                mainPage260505.inputTerceroLada.sendKeys("416");
                mainPage260505.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260505.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260505.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260505.btnAgregarFormulador.click();
                mainPage260505.radNacionalTerceros.click();
                mainPage260505.radPersonaMoral.click();
                mainPage260505.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260505.btnBuscarTerceroRFC.click();
                mainPage260505.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260505.btnAgregarProveedor.click();
                mainPage260505.radExtranjeroTerceros.click();
                mainPage260505.radPersonaMoral.click();
                mainPage260505.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260505.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260505.CodigoPostaltxt.sendKeys("7550000");
                mainPage260505.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260505.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260505.inputTercerosNumExterior.sendKeys("70");
                mainPage260505.inputTercerosNumInterior.sendKeys("2");
                mainPage260505.inputTerceroLada.sendKeys("2");
                mainPage260505.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260505.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260505.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260505.Scrol.scrollTo().shouldBe(visible);
                mainPage260505.tabPagoDerechos.click();
                mainPage260505.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260505.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260505.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260505.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260505.FechaPago, fechaHoy);
                mainPage260505.ImportePago.sendKeys("100");
                mainPage260505.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260505.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260505.btnAdjuntar2.click();
                mainPage260505.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260505.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260505.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260505);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260505.folio.getText();

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

