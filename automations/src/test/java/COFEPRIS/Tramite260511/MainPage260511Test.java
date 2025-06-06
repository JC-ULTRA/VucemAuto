package COFEPRIS.Tramite260511;

import COFEPRIS.Tramite260511.MainPage260511;
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

public class MainPage260511Test {


        MainPage260511 mainPage260511 = new MainPage260511();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260511  = new TramitesFirmasLG(
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
        public void Proceso260511() throws IOException {
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


/*
                //Llave de pago
                String llavePago = metodos.generarLlavePago(16);

 */

                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260511);
                mainPage260511.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260511.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260511.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260511.SoliNew.click();//sleep(1000);
                mainPage260511.Cofepris.click();//sleep(1000);
                mainPage260511.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260511.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260511.elementoTramite260511.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260511.Scrol.scrollTo();
                //Pestaña Datos de solicitud
                mainPage260511.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260511.btnEstablecimiento.click();
                mainPage260511.buttonAceptar.click();
                mainPage260511.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260511.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260511.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260511.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260511.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260511.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260511.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260511.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260511.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260511.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260511.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260511.btnAgregarScian.click();
                mainPage260511.selectComboScian.sendKeys("325310");
                mainPage260511.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260511.listAduanasEntrada.sendKeys("CIUDAD HIDALGO");
                mainPage260511.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260511.btnAgregarMercancia.click();
                //Identificación del producto
                mainPage260511.NombreComercial.sendKeys("QA Nombre comercial Nutrientes");
                mainPage260511.NombreComun.sendKeys("QA Nombre común Nutrientes");
                mainPage260511.inputDenominacionNombreCientif.sendKeys("QA Nombre Científico Nutrientes");
                mainPage260511.UsoEspecifico.sendKeys("Uso especifico de la mercancía transformación");
                mainPage260511.inputFraccionArancelaria.sendKeys("29319099");
                mainPage260511.inputCantidadUmt.sendKeys("14910");
                mainPage260511.inputCantidadUmc.sendKeys("200");
                mainPage260511.selectUMC.selectOption("Gramos");
                mainPage260511.PorcentajeConcentracion.sendKeys("20");
               // mainPage260511.NumRegistroSanitario.sendKeys("693402");
                //País donde se elabora el producto
                mainPage260511.btnDesplegarInfoPaisElabora.click();
                mainPage260511.listaPaisElabora.selectOption("CANADA");
                mainPage260511.btnAgregarPaisElabora.click();
                //País proveedor (Origen)
                mainPage260511.btnDesplegarInfoPaisProveedor.click();
                mainPage260511.listaPaisProveedor.selectOption("CHILE (REPUBLICA DE)");
                mainPage260511.btnAgregarPaisProveedor.click();
                //País de procedencia/ País del último puerto de embarque
                mainPage260511.btnDesplegarInfoPaisProcedencia.click();
                mainPage260511.listaPaisProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260511.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260511.selectClasificacionToxi.selectOption("IV LIGERAMENTE TOXICO");
                mainPage260511.selectObjetoImportacion.selectOption("Formulación");
                //Agregar la información de la mercancia
                mainPage260511.btnAgregarMercanciaTotalInfo.click();

                //Garantías ofrecidas
                mainPage260511.GarantiasOfrecidas.sendKeys("Garantía QA Nutrientes/Fertilizantes");

                //Manifiesto y declaraciones
                mainPage260511.checkCumploRequisitosYNormativas.click();
                mainPage260511.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260511.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260511.btnBuscarRepresentante.click();


                //TERCEROS RELACIONADOS
                mainPage260511.Scrol.scrollTo();
                mainPage260511.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260511.btnAgregarFabricante.click();
                mainPage260511.radExtranjeroTerceros.click();
                mainPage260511.radPersonaMoral.click();
                mainPage260511.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260511.listTercerosPais.selectOption("CANADA");
                mainPage260511.CodigoPostaltxt.sendKeys("7550000");
                mainPage260511.TercerosEstadotxt.sendKeys("Ontario");
                mainPage260511.inputTercerosCalle.sendKeys("Imperial St");
                mainPage260511.inputTercerosNumExterior.sendKeys("50");
                mainPage260511.inputTercerosNumInterior.sendKeys("2");
                mainPage260511.inputTerceroLada.sendKeys("416");
                mainPage260511.inputTercerosTelefono.sendKeys("416-485-111");
                mainPage260511.inputTercerosCorreoElec.sendKeys("vucem2.5FabricanteQAQA@hotmail.com");
                mainPage260511.buttonGuardarDatosTercero.click();

                //Agregar Formulador
                //DatosGenerales
                mainPage260511.btnAgregarFormulador.click();
                mainPage260511.radNacionalTerceros.click();
                mainPage260511.radPersonaMoral.click();
                mainPage260511.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260511.btnBuscarTerceroRFC.click();
                mainPage260511.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260511.btnAgregarProveedor.click();
                mainPage260511.radExtranjeroTerceros.click();
                mainPage260511.radPersonaMoral.click();
                mainPage260511.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEEDOR");
                mainPage260511.listTercerosPais.selectOption("CHILE (REPUBLICA DE)");
                mainPage260511.CodigoPostaltxt.sendKeys("7550000");
                mainPage260511.TercerosEstadotxt.sendKeys("Región Metropolitana de Santiago");
                mainPage260511.inputTercerosCalle.sendKeys("Manzano QA");
                mainPage260511.inputTercerosNumExterior.sendKeys("70");
                mainPage260511.inputTercerosNumInterior.sendKeys("2");
                mainPage260511.inputTerceroLada.sendKeys("2");
                mainPage260511.inputTercerosTelefono.sendKeys("212-100-000");
                mainPage260511.inputTercerosCorreoElec.sendKeys("vucem2.5ProveedorQA@hotmail.com");
                mainPage260511.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260511.Scrol.scrollTo().shouldBe(visible);
                mainPage260511.tabPagoDerechos.click();
                mainPage260511.ClaveReferencia.sendKeys("134950255");sleep(1000);
                mainPage260511.CadenaDependencia.sendKeys("011093G14EC1703");
                mainPage260511.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260511.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260511.FechaPago, fechaHoy);
                mainPage260511.ImportePago.sendKeys("1000");
                mainPage260511.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260511.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260511.btnAdjuntar2.click();
                mainPage260511.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260511.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260511.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260511);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260511.folio.getText();

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

