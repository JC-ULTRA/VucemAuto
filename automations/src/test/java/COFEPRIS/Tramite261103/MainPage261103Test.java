package COFEPRIS.Tramite261103;
import Metodos.Metodos;
import COFEPRIS.Tramite261103.MainPage261103;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
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

public class MainPage261103Test {


        MainPage261103 mainPage261103 = new MainPage261103();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();
        TramitesFirmasLG tramite261103  = new TramitesFirmasLG(
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
        public void Proceso261103() throws IOException {
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

                // Solicitar el folio al usuario
                String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
                // Validar que el usuario haya ingresado un folio válido de 25 dígitos
                if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                    return; // Cancelar la operación
                }
                // Confirmar el folio ingresado
                JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);


                // Obtener la fecha de (hoy+Meses) formateada
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaHoy = LocalDate.now().format(formatter);

                //llave de pago
                String uuid = UUID.randomUUID().toString();
                int longitudDeseada = 16;
                String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite261103);
                mainPage261103.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage261103.btnacep.click();sleep(1000);

                //Búsqueda de trámite Subsecuente
                mainPage261103.Tramites.sendKeys("Solicitudes subsecuentes");
                mainPage261103.SoliSub.click();
                mainPage261103.FolioTramite.sendKeys(FolioTramiteN);
                mainPage261103.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage261103.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage261103.btnSolModificar.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                mainPage261103.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de la Solicitud
                mainPage261103.DatosSolicitud.click();
                //Tipo de operación
                mainPage261103.radbtnModificar.click();
                mainPage261103.Justificacion.setValue("QA justificación modificación");

                //Datos del establecimiento
                mainPage261103.btnEstablecimiento.click();
                mainPage261103.buttonAceptar.click();
                mainPage261103.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificación");
                //Domicilio del establecimiento
                mainPage261103.inputSolicitudEstablecimientoDomicilioCodigo.setValue("669");
                mainPage261103.selectSolicitudEstablecimientoDomicilioEntidad.selectOption("SINALOA");
                mainPage261103.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("Mazatlan");
                mainPage261103.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Localidad TestModificación");
                mainPage261103.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Zona Dorada");
                mainPage261103.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle QA Modificación");
                mainPage261103.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestModificacion@gmail.com");

                mainPage261103.ResponsableSanitarioRFC.setValue("AAL0409235E6");
                mainPage261103.inputSolicitudEstablecimientoDomicilioLada.setValue("55");
                mainPage261103.inputSolicitudEstablecimientoDomicilioTelefono.setValue("5590265133");sleep(1000);

                //Agregar SCIAN
                mainPage261103.btnAgregarScian.click();
                mainPage261103.selectComboScian.selectOption("352100");
                mainPage261103.btnAgregar2Scian.click();

                //
                mainPage261103.checkCumploRequisitosYNormativas.click();

                //Agregar Mercancia
                mainPage261103.gridMercancia1.click();
                mainPage261103.btnModificarMercancia.click();
                mainPage261103.selectMercanciaGridClasificacionProducto.selectOption("ESTUPEFACIENTES");
                mainPage261103.MercanciaEspecificaClasProd.setValue("fármacos con efectos en la mente modificación");
                mainPage261103.DenominacionComunInternacional.setValue("DCI Test modificación");
                mainPage261103.inputDenominacionDistintiva.setValue("Denominacion Distintiva test modificación");
                mainPage261103.selectMercanciaGridTipoProducto.selectOption("Producto terminado");

                //Forma Farmaceutica
                mainPage261103.btnDesplegarFormaFarmaceutica.click();
                mainPage261103.btnRestarTodosFormaFarmaceutica.click();
                mainPage261103.listaFormaFarmaceutica.sendKeys("GRAGEA");
                mainPage261103.btnAgregarFormaFarmaceutica.click();

                //Información General Mercancía
                mainPage261103.inputCantidadUmt.setValue("200");
                mainPage261103.selectMercanciaGridUnidadMedida.selectOption("Gramo");
                mainPage261103.selectMercanciaGridUnidadMedida.scrollIntoView(true);
                mainPage261103.NumeroCAS.setValue("728391");
                mainPage261103.CantidadLotes.setValue("1100");
                mainPage261103.KgGPorLote.setValue("2");

                //Pais de origen
                mainPage261103.btnDesplegarInfoPaisOrigen.click();
                mainPage261103.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage261103.btnRestarPaisOrigenTodos.click();
                mainPage261103.listaPaisOrigen.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage261103.inputAdd.click();

                //Pais de procedencia
                mainPage261103.selectPaisProcedencia.selectOption("CANADA");

                //Uso especifico
                mainPage261103.btnDesplegarInfoUsoEspecifico.click();
                mainPage261103.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage261103.btnrestarTodosUso.click();
                mainPage261103.listaUsoEspecifico.selectOption("ELABORACIÓN");
                mainPage261103.inputAdd3.click();
                mainPage261103.DetalleUsoEspecifico.setValue("Distribución/elaboración para Uso Medico QA Modificación");
                mainPage261103.inputCantidadUmc.setValue("80090");
                mainPage261103.NumPiezasFabricar.setValue("1000");
                mainPage261103.DescripcionNumPiezasFabricar.setValue("Test Descripción Numero piezas Modificación");
                mainPage261103.NumRegistroSanitario.setValue("30215462202");
                mainPage261103.Presentacion.setValue("Grajeas 200mg QA");
                mainPage261103.btnAgregarDetalle.click();
                mainPage261103.btnModificarInfoMercancia.click();sleep(1000);
                //Agregar la información de la mercancía
                mainPage261103.selectAduanas.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");

                //manifiesto y declaraciones
                mainPage261103.checkCumploRequisitosYNormativas.click();
                mainPage261103.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage261103.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage261103.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage261103.Scrol.scrollTo().shouldBe(visible);
                mainPage261103.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage261103.gridFabricante1.click();
                mainPage261103.btnModificarFabricante.click();
                mainPage261103.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Modificación");
                //Datos Domicilio
                mainPage261103.selectPaisTerceros.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage261103.TercerosEstadotxt.setValue("Sinaloa");
                mainPage261103.CodigoPostaltxt.setValue("81910");
                mainPage261103.inputTercerosCalle.setValue("El Fuerte");
                mainPage261103.inputTercerosNumExterior.setValue("5");
                mainPage261103.inputTercerosNumInterior.setValue("4");
                mainPage261103.inputTerceroLada.setValue("667");
                mainPage261103.inputTercerosTelefono.setValue("667505211");
                mainPage261103.inputTercerosCorreoElec.setValue("vucem2.5FabricanteMOD@hotmail.com");
                mainPage261103.buttonGuardarDatosTercero.click();

                //Agregar facturador
                //Datos generales
                mainPage261103.gridFacturador1.click();
                mainPage261103.btnModificarFacturador.click();
                mainPage261103.inputTercerosDenominacionRazon.setValue("QA FACTURADOR");
                //Datos Domicilio
                mainPage261103.listTercerosPais.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261103.TercerosEstadotxt.setValue("California");
                mainPage261103.CodigoPostaltxt.setValue("95270");
                mainPage261103.inputTercerosCalle.setValue("Garfield");
                mainPage261103.inputTercerosNumExterior.setValue("10");
                mainPage261103.inputTercerosNumInterior.setValue("5");
                mainPage261103.inputTerceroLada.setValue("1");
                mainPage261103.inputTercerosTelefono.setValue("916-813-6670");
                mainPage261103.inputTercerosCorreoElec.setValue("Testcertificado@hotmail.com");
                mainPage261103.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                //Datos generales
                mainPage261103.gridProveedor1.click();
                mainPage261103.btnModificarProveedor.click();
                mainPage261103.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA");
                //Datos Domicilio
                mainPage261103.selectPaisTerceros.selectOption("CANADA");
                mainPage261103.TercerosEstadotxt.setValue("Ontario");
                mainPage261103.CodigoPostaltxt.setValue("7550000");
                mainPage261103.inputTercerosCalle.setValue("Imperial");
                mainPage261103.inputTercerosNumExterior.setValue("St");
                mainPage261103.inputTercerosNumInterior.setValue("50");
                mainPage261103.inputTerceroLada.setValue("416");
                mainPage261103.inputTercerosTelefono.setValue("416-485-111");
                mainPage261103.inputTercerosCorreoElec.setValue("vucem2.5ProveedorMOD@hotmail.com");
                mainPage261103.buttonGuardarDatosTercero.click();

                //Certificado Analítico
                //Datos Generales
                mainPage261103.gridCertificado1.click();
                mainPage261103.btnModificarCertificado.click();
                mainPage261103.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA certificado");
                //Datos Domicilio
                mainPage261103.selectPaisTerceros.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261103.TercerosEstadotxt.setValue("Colorado");
                mainPage261103.CodigoPostaltxt.setValue("80014");
                mainPage261103.inputTercerosCalle.setValue("Acoma St");
                mainPage261103.inputTercerosNumExterior.setValue("200");
                mainPage261103.inputTercerosNumInterior.setValue("3");
                mainPage261103.inputTerceroLada.setValue("303");
                mainPage261103.inputTercerosTelefono.setValue("3032037790");
                mainPage261103.inputTercerosCorreoElec.setValue("TestcertificadoModificacion@hotmail.com");
                mainPage261103.buttonGuardarDatosTercero.click();

                //Otros



                //PAGO DERECHOS
                mainPage261103.Scrol.scrollTo().shouldBe(visible);
                mainPage261103.tabPagoDerechos.click();
                mainPage261103.ClaveReferencia.setValue("70400255");sleep(1000);
                mainPage261103.CadenaDependencia.setValue("011126GGEC10303");
                mainPage261103.listBanco.selectOption("BANAMEX");sleep(1000);
                mainPage261103.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage261103.FechaPago, fechaHoy);
                mainPage261103.ImportePago.setValue("1200");
                mainPage261103.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage261103.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage261103.btnAdjuntar2.click();
                mainPage261103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
                mainPage261103.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage261103.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite261103);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage261103.folio.getText();

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

