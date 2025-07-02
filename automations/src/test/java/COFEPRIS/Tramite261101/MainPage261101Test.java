package COFEPRIS.Tramite261101;

import COFEPRIS.Tramite261101.MainPage261101;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
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

public class MainPage261101Test {


        MainPage261101 mainPage261101 = new MainPage261101();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();
        TramitesFirmasLG tramite261101  = new TramitesFirmasLG(
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
        public void Proceso261101() throws IOException {
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
                loginFirmSoli.login(tramite261101);
                mainPage261101.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage261101.btnacep.click();sleep(1000);

                //Búsqueda de trámite Subsecuente
                mainPage261101.Tramites.sendKeys("Solicitudes subsecuentes");
                mainPage261101.SoliSub.click();
                mainPage261101.FolioTramite.sendKeys(FolioTramiteN);
                mainPage261101.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage261101.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage261101.btnSolModificar.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                mainPage261101.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de la Solicitud
                mainPage261101.DatosSolicitud.click();
                //Tipo de operación
                mainPage261101.radbtnModificar.click();
                mainPage261101.Justificacion.setValue("QA justificación modificación");

                //Datos del establecimiento
                mainPage261101.btnEstablecimiento.click();
                mainPage261101.buttonAceptar.click();
                mainPage261101.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificación");
                //Domicilio del establecimiento
                mainPage261101.inputSolicitudEstablecimientoDomicilioCodigo.setValue("669");
                mainPage261101.selectSolicitudEstablecimientoDomicilioEntidad.selectOption("SINALOA");
                mainPage261101.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("Mazatlan");
                mainPage261101.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Localidad TestModificación");
                mainPage261101.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Zona Dorada");
                mainPage261101.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle QA Modificación");
                mainPage261101.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestModificacion@gmail.com");


                //Agregar SCIAN
                mainPage261101.btnAgregarScian.click();
                mainPage261101.selectComboScian.selectOption("352100");
                mainPage261101.btnAgregar2Scian.click();

                //Agregar Mercancia
                mainPage261101.gridMercancia1.click();
                mainPage261101.btnModificarMercancia.click();
                mainPage261101.selectMercanciaGridClasificacionProducto.selectOption("ESTUPEFACIENTES");
                mainPage261101.MercanciaEspecificaClasProd.setValue("fármacos con efectos en la mente modificación");
                mainPage261101.DenominacionComunInternacional.setValue("DCI Test modificación");
                mainPage261101.inputDenominacionDistintiva.setValue("Denominacion Distintiva test modificación");
                mainPage261101.selectMercanciaGridTipoProducto.selectOption("Materia prima");
                mainPage261101.selectEstadoFisicoProducto.selectOption("Sólido");

                //Forma Farmaceutica
                mainPage261101.btnDesplegarFormaFarmaceutica.click();
                mainPage261101.btnRestarTodosFormaFarmaceutica.click();
                mainPage261101.listaFormaFarmaceutica.sendKeys("GRANULADO");
                mainPage261101.btnAgregarFormaFarmaceutica.click();

                //Fracción arancelaría
                mainPage261101.inputFraccionArancelaria.setValue("29329301");


                //Información General Mercancía
                mainPage261101.inputCantidadUmt.setValue("200");
                mainPage261101.selectMercanciaGridUnidadMedida.selectOption("Gramo");
                mainPage261101.selectMercanciaGridUnidadMedida.scrollIntoView(true);
                mainPage261101.NumeroCAS.setValue("728391");
                mainPage261101.CantidadLotes.setValue("1100");
                mainPage261101.KgGPorLote.setValue("2");

                //Pais de origen
                mainPage261101.btnDesplegarInfoPaisOrigen.click();
                mainPage261101.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage261101.btnRestarPaisOrigenTodos.click();
                mainPage261101.listaPaisOrigen.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage261101.inputAdd.click();

                //Pais de procedencia
                mainPage261101.selectPaisProcedencia.selectOption("CANADA");

                //Uso especifico
                mainPage261101.btnDesplegarInfoUsoEspecifico.click();
                mainPage261101.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage261101.btnrestarTodosUso.click();
                mainPage261101.listaUsoEspecifico.selectOption("ELABORACIÓN");
                mainPage261101.inputAdd3.click();
                mainPage261101.DetalleUsoEspecifico.setValue("Distribución/elaboración Materia prima QA Modificación");
                mainPage261101.inputCantidadUmc.setValue("80090");
                mainPage261101.NumPiezasFabricar.setValue("1000");
                mainPage261101.DescripcionNumPiezasFabricar.setValue("Test Descripción Numero piezas Modificación");
                mainPage261101.NumRegistroSanitario.setValue("30215462202");
                mainPage261101.Presentacion.setValue("Grajeas 200mg QA");
                mainPage261101.btnAgregarDetalle.click();
                mainPage261101.btnModificarInfoMercancia.click();sleep(1000);
                //Agregar la información de la mercancía
                mainPage261101.selectAduanas.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");

                //manifiesto y declaraciones
                mainPage261101.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage261101.RepresentanteRFC.sendKeys("ALL0409235E6");
                mainPage261101.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage261101.Scrol.scrollTo().shouldBe(visible);
                mainPage261101.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage261101.gridFabricante1.click();
                mainPage261101.btnModificarFabricante.click();
                mainPage261101.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Modificación");
                //Datos Domicilio
                mainPage261101.selectPaisTerceros.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage261101.TercerosEstadotxt.setValue("Sinaloa");
                mainPage261101.CodigoPostaltxt.setValue("81910");
                mainPage261101.inputTercerosCalle.setValue("El Fuerte");
                mainPage261101.inputTercerosNumExterior.setValue("5");
                mainPage261101.inputTercerosNumInterior.setValue("4");
                mainPage261101.inputTerceroLada.setValue("667");
                mainPage261101.inputTercerosTelefono.setValue("667505211");
                mainPage261101.inputTercerosCorreoElec.setValue("vucem2.5FabricanteMOD@hotmail.com");
                mainPage261101.buttonGuardarDatosTercero.click();

                //Agregar facturador
                //Datos generales
                mainPage261101.gridFacturador1.click();
                mainPage261101.btnModificarFacturador.click();
                mainPage261101.inputTercerosDenominacionRazon.setValue("QA FACTURADOR");
                //Datos Domicilio
                mainPage261101.listTercerosPais.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261101.TercerosEstadotxt.setValue("California");
                mainPage261101.CodigoPostaltxt.setValue("95270");
                mainPage261101.inputTercerosCalle.setValue("Garfield");
                mainPage261101.inputTercerosNumExterior.setValue("10");
                mainPage261101.inputTercerosNumInterior.setValue("5");
                mainPage261101.inputTerceroLada.setValue("1");
                mainPage261101.inputTercerosTelefono.setValue("916-813-6670");
                mainPage261101.inputTercerosCorreoElec.setValue("Testcertificado@hotmail.com");
                mainPage261101.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                //Datos generales
                //mainPage261101.gridProveedor1.click();
                //mainPage261101.btnModificarProveedor.click();
                mainPage261101.btnAgregarProveedor.click();
                mainPage261101.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA");
                //Datos Domicilio
                mainPage261101.selectPaisTerceros.selectOption("CANADA");
                mainPage261101.TercerosEstadotxt.setValue("Ontario");
                mainPage261101.CodigoPostaltxt.setValue("7550000");
                mainPage261101.inputTercerosCalle.setValue("Imperial");
                mainPage261101.inputTercerosNumExterior.setValue("St");
                mainPage261101.inputTercerosNumInterior.setValue("50");
                mainPage261101.inputTerceroLada.setValue("416");
                mainPage261101.inputTercerosTelefono.setValue("416-485-111");
                mainPage261101.inputTercerosCorreoElec.setValue("vucem2.5ProveedorMOD@hotmail.com");
                mainPage261101.buttonGuardarDatosTercero.click();

                //Certificado Analítico
                //Datos Generales
                //mainPage261101.gridCertificado1.click();
                //mainPage261101.btnModificarCertificado.click();
                mainPage261101.btnAgregarCertificado.click();
                mainPage261101.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA certificado");
                //Datos Domicilio
                mainPage261101.selectPaisTerceros.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261101.TercerosEstadotxt.setValue("Colorado");
                mainPage261101.CodigoPostaltxt.setValue("80014");
                mainPage261101.inputTercerosCalle.setValue("Acoma St");
                mainPage261101.inputTercerosNumExterior.setValue("200");
                mainPage261101.inputTercerosNumInterior.setValue("3");
                mainPage261101.inputTerceroLada.setValue("303");
                mainPage261101.inputTercerosTelefono.setValue("3032037790");
                mainPage261101.inputTercerosCorreoElec.setValue("TestcertificadoModificacion@hotmail.com");
                mainPage261101.buttonGuardarDatosTercero.click();

                //Otros


                //PAGO DERECHOS
                mainPage261101.Scrol.scrollTo().shouldBe(visible);
                mainPage261101.tabPagoDerechos.click();
                mainPage261101.ClaveReferencia.setValue("87435223");sleep(1000);
                mainPage261101.CadenaDependencia.setValue("54112ATREC10303");
                mainPage261101.listBanco.selectOption("BANAMEX");sleep(1000);
                mainPage261101.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage261101.FechaPago, fechaHoy);
                mainPage261101.ImportePago.setValue("1200");
                mainPage261101.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage261101.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage261101.btnAdjuntar2.click();
                mainPage261101.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
                mainPage261101.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage261101.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite261101);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage261101.folio.getText();

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

