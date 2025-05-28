package COFEPRIS.Tramite260303;

import COFEPRIS.Tramite260303.MainPage260303;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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

public class MainPage260303Test {


        MainPage260303 mainPage260303 = new MainPage260303();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        TramitesFirmasLG tramite260204  = new TramitesFirmasLG(
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
        public void Proceso260303() throws IOException {
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
                loginFirmSoli.login(tramite260204);
                mainPage260303.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260303.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260303.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260303.SoliNew.click();//sleep(1000);
                mainPage260303.Cofepris.click();//sleep(1000);
                mainPage260303.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260303.PermisoSanitarioImporExporEstupefacientes.click();//sleep(1000);
                mainPage260303.Tramite260303.click();sleep(1000);

                //Datos de solicitud
                mainPage260303.Scrol.scrollTo().shouldBe(visible);
                mainPage260303.DatosSolicitud.click();
                mainPage260303.btnEstablecimiento.click();
                mainPage260303.buttonAceptar.click();

                //LLenado de datos
                mainPage260303.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");

                //Domicilio del establecimiento
                mainPage260303.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260303.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260303.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260303.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260303.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260303.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260303.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                mainPage260303.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260303.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260303.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260303.btnAgregarScian.click();
                mainPage260303.selectComboScian.sendKeys("311239");
                mainPage260303.btnAgregar2Scian.click();
                //

                mainPage260303.checkAvisoFuncionamiento.click();
                //mainPage260303.selectSolicitudRegimenClave.sendKeys("Definitivos");

                //Agregar Mercancia
                mainPage260303.btnAgregarAduana.click();
                mainPage260303.selectMercanciaGridClasificacionProducto.sendKeys("PSICOTROPICOS");
                mainPage260303.MercanciaEspecificaClasProd.sendKeys("fármacos con efectos en la mente");
                mainPage260303.DenominacionComunInternacional.sendKeys("DCI Test");
                mainPage260303.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260303.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");

                //Forma Farmaceutica
                mainPage260303.btnDesplegarFormaFarmaceutica.click();
                mainPage260303.listaFormaFarmaceutica.sendKeys("TABLETAS");
                mainPage260303.btnAgregarFormaFarmaceutica.click();

                //Información General Mercancía
                mainPage260303.inputFraccionArancelaria.sendKeys("13021909");
                mainPage260303.inputCantidadUmt.sendKeys("100");
                mainPage260303.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
                mainPage260303.selectMercanciaGridUnidadMedida.scrollIntoView(true);
                mainPage260303.NumeroCAS.sendKeys("456456");
                mainPage260303.CantidadLotes.sendKeys("1600");
                mainPage260303.KgGPorLote.sendKeys("6");

                //Pais de origen
                mainPage260303.btnDesplegarInfoPaisOrigen.click();
                mainPage260303.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260303.listaPaisOrigen.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260303.inputAdd.click();

                //Pais de procedencia
                mainPage260303.selectPaisProcedencia.selectOption("FINLANDIA (REPUBLICA DE)");

                //Uso especifico
                mainPage260303.btnDesplegarInfoUsoEspecifico.click();
                mainPage260303.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260303.listaUsoEspecifico.selectOption("DISTRIBUCIÓN");
                mainPage260303.inputAdd3.click();
                mainPage260303.DetalleUsoEspecifico.sendKeys("Distribución para Uso Medico QA");
                mainPage260303.inputCantidadUmc.sendKeys("45490");
                mainPage260303.NumPiezasFabricar.sendKeys("5000");
                mainPage260303.DescripcionNumPiezasFabricar.sendKeys("Test Descripción Numero piezas");
                mainPage260303.NumRegistroSanitario.sendKeys("5645464102");
                mainPage260303.Presentacion.sendKeys("Tabletas");
                mainPage260303.btnAgregarDetalle.sendKeys("Tabletas 100mg QA");
                mainPage260303.btnAgregarInfoMercancia.click();
                //Agregar la información de la mercancía
                mainPage260303.selectAduanas.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");

                //manifiesto y declaraciones
                mainPage260303.checkCumploRequisitosYNormativas.click();
                mainPage260303.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260303.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260303.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260303.Scrol.scrollTo().shouldBe(visible);
                mainPage260303.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260303.btnAgregarFabricante.click();
                mainPage260303.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos Domicilio
                mainPage260303.selectPaisTerceros.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260303.TercerosEstadotxt.sendKeys("Bremen");
                mainPage260303.CodigoPostaltxt.sendKeys("07000");
                mainPage260303.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260303.inputTercerosNumExterior.sendKeys("10");
                mainPage260303.inputTercerosNumInterior.sendKeys("5");
                mainPage260303.inputTerceroLada.sendKeys("55");
                mainPage260303.inputTercerosTelefono.sendKeys("551-087-907");
                mainPage260303.inputTercerosCorreoElec.sendKeys("vucem2.5test@hotmail.com");
                mainPage260303.buttonGuardarDatosTercero.click();

                //Agregar facturador
                //Datos generales
                mainPage260303.btnAgregarFacturador.click();
                mainPage260303.inputTercerosDenominacionRazon.sendKeys("QA FACTURADOR");
                //Datos Domicilio
                mainPage260303.listTercerosPais.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage260303.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260303.CodigoPostaltxt.sendKeys("34001");
                mainPage260303.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260303.inputTercerosNumExterior.sendKeys("10");
                mainPage260303.inputTercerosNumInterior.sendKeys("5");
                mainPage260303.inputTerceroLada.sendKeys("618");
                mainPage260303.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260303.inputTercerosCorreoElec.sendKeys("TestFacturador@hotmail.com");
                mainPage260303.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                //Datos generales
                mainPage260303.btnAgregarProveedor.click();
                mainPage260303.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos Domicilio
                mainPage260303.selectPaisTerceros.selectOption("FINLANDIA (REPUBLICA DE)");
                mainPage260303.TercerosEstadotxt.sendKeys("Laponia");
                mainPage260303.CodigoPostaltxt.sendKeys("95270");
                mainPage260303.inputTercerosCalle.sendKeys("Jokkatie");
                mainPage260303.inputTercerosNumExterior.sendKeys("10");
                mainPage260303.inputTercerosNumInterior.sendKeys("5");
                mainPage260303.inputTerceroLada.sendKeys("358");
                mainPage260303.inputTercerosTelefono.sendKeys("358-813-6670");
                mainPage260303.inputTercerosCorreoElec.sendKeys("TestProveedor@hotmail.com");
                mainPage260303.buttonGuardarDatosTercero.click();

                //Certificado Analítico
                //Datos Generales
                mainPage260303.btnAgregarCertificado.click();
                mainPage260303.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA certificado");
                //Datos Domicilio
                mainPage260303.selectPaisTerceros.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260303.TercerosEstadotxt.sendKeys("California");
                mainPage260303.CodigoPostaltxt.sendKeys("95270");
                mainPage260303.inputTercerosCalle.sendKeys("Garfield");
                mainPage260303.inputTercerosNumExterior.sendKeys("10");
                mainPage260303.inputTercerosNumInterior.sendKeys("5");
                mainPage260303.inputTerceroLada.sendKeys("1");
                mainPage260303.inputTercerosTelefono.sendKeys("916-813-6670");
                mainPage260303.inputTercerosCorreoElec.sendKeys("Testcertificado@hotmail.com");
                mainPage260303.buttonGuardarDatosTercero.click();

                //Otros



                //PAGO DERECHOS
                mainPage260303.Scrol.scrollTo().shouldBe(visible);
                mainPage260303.tabPagoDerechos.click();
                mainPage260303.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260303.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260303.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260303.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260303.FechaPago, fechaHoy);
                mainPage260303.ImportePago.sendKeys("100");
                mainPage260303.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage260303.btnContinuarPaso2.click();

                //Paso 3
                mainPage260303.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260303.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260303.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260303.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260303.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260303.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260303.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");

                mainPage260303.btnAdjuntar2.click();
                mainPage260303.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260303.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260303.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260303.folio.getText();

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

