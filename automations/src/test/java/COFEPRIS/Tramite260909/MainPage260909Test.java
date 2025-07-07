package COFEPRIS.Tramite260909;

import COFEPRIS.Tramite260909.MainPage260909;
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

public class MainPage260909Test {


        MainPage260909 mainPage260909 = new MainPage260909();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

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
        public void Proceso260909() throws IOException {
            /////////////////////////////////////////////////////////////////////////////////////////////////////////-
            // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
            String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

            // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
            if (repeticionesStr == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
                return; // Termina el metodo si se selecciona cancelar
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

                //Desactivar pago
                //desactivarPago();
                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260204);
                mainPage260909.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260909.btnacep.click();sleep(1000);

                //Búsqueda de tramite Subsecuente
                mainPage260909.Tramites.sendKeys("Solicitudes nuevas");
                mainPage260909.SoliSub.click();
                mainPage260909.FolioTramite.sendKeys(FolioTramiteN);
                mainPage260909.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage260909.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage260909.btnSolModificaryProrroga.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                //Datos de solicitud
                mainPage260909.Scrol.scrollTo();
                mainPage260909.DatosSolicitud.click();
                //Seleccione el tipo de operación que desea realizar
                mainPage260909.radbtnModificar.click();
                mainPage260909.JustificacionMod.shouldBe(visible).sendKeys("QA Justificación Modificación");

                //LLenado de datos
                //mainPage260909.ResponsableSanitarioRFC.setValue("AAL0409235E6");
                mainPage260909.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificación");
                mainPage260909.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestM@gmail.com");

                //Domicilio del establecimiento
                mainPage260909.inputSolicitudEstablecimientoDomicilioCodigo.setValue("607059");
                mainPage260909.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260909.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("Santa ursula");
                mainPage260909.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Localidad Test");
                mainPage260909.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Colonia Ursula");
                mainPage260909.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle QA");
                mainPage260909.inputSolicitudEstablecimientoDomicilioLada.setValue("55");
                mainPage260909.inputSolicitudEstablecimientoDomicilioTelefono.setValue("5091222233");sleep(1000);

                //Agregar S.C.I.A.N.
                mainPage260909.btnAgregarScian.click();
                mainPage260909.selectComboScian.selectOption("311341");
                mainPage260909.btnAgregar2Scian.click();

                //Aviso
                mainPage260909.checkAvisoFuncionamiento.click();
                mainPage260909.inputNumeroLicencia.sendKeys("4956495");
                mainPage260909.selectSolicitudRegimenClave.sendKeys("Temporales");
                mainPage260909.selectAduanasEntrada.selectOption("VERACRUZ");

                //Modificar Mercancía
                mainPage260909.gridMercancia1.click();
                mainPage260909.btnModificarMercancia.click();
                mainPage260909.selectMercanciaGridClasificacionProducto.sendKeys("REMEDIOS HERBOLARIOS ");
                mainPage260909.selectMercanciaGridEspecificaClasProd.sendKeys("No aplica");
                mainPage260909.inputDenominacionEspecifica.setValue("Denominación Especifica Test Modificación");
                mainPage260909.inputDenominacionDistintiva.setValue("Denominación Distintiva test Modificación");
                mainPage260909.inputDenominacionNombreCientif.setValue("Herbolarios Test Nombre Científico Modificación");
                mainPage260909.selectMercanciaGridTipoProducto.sendKeys("Producto a Granel");
                mainPage260909.selectFormaFarmaceutica.selectOption("Ungüento");
                mainPage260909.selectEstadoFisico.sendKeys("Lodoso");
                //mainPage260909.inputFraccionArancelaria.setValue("30049036");//30039013
                mainPage260909.inputCantidadUmt.setValue("600");
                mainPage260909.inputCantidadUmc.setValue("8600");
                mainPage260909.selectMercanciaGridUnidadMedida.sendKeys("Envase");
                mainPage260909.PresentacionFarmaTipoEnvase.setValue("QA Envase Modificación");
                mainPage260909.NumRegistroSanitario.setValue("47583");

                //Pais de origen
                mainPage260909.btnDesplegarInfoPaisOrigen.click();
                mainPage260909.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260909.btnRestarPaisOrigenTodos.click();
                mainPage260909.listaPaisOrigen.selectOption("RUSIA (FEDERACION RUSA)");
                mainPage260909.inputAdd.click();

                //Pais de procedencia
                mainPage260909.btnDesplegarInfoPaisProcedencia.click();
                mainPage260909.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260909.btnRestarPaisProveedorTodos.click();
                mainPage260909.listaPaisesProcedencia.selectOption("SUIZA (CONFEDERACION)");
                mainPage260909.inputAdd2.click();

                //Agregar información de la mercancía
                mainPage260909.btnModificarTotalInfo.click();

                //Manifiestos y declaraciones
                mainPage260909.radNoHacerPublicoInformacion.click();

                //Representante Legal
                mainPage260909.RepresentanteRFC.setValue("AFC000526BJ2");
                mainPage260909.btnBuscarRepresentante.click();
                mainPage260909.NombreRepresentante.setValue("Karla");
                mainPage260909.PrimerApellidoRepresentante.setValue("Hernandez");
                mainPage260909.SegundoApellidoRepresentante.setValue("Martinez");

                //TERCEROS RELACIONADOS
                mainPage260909.Scrol.scrollTo().shouldBe(visible);
                mainPage260909.tabTercerosRelacionados.click();

                //Agregar/Modificar Fabricante
                mainPage260909.btnAgregarFabricante.click();
                mainPage260909.radbtnExtranjero.click();
                mainPage260909.radPersonaFisica.click();;
                mainPage260909.inputTercerosNombre.setValue("Ekaterina");
                mainPage260909.inputTercerosApellidoPaterno.setValue("Belova");
                mainPage260909.inputTercerosApellidoMaterno.setValue("Belyaeva");
                //Domicilio
                mainPage260909.listTercerosPais.selectOption("RUSIA (FEDERACION RUSA)");
                mainPage260909.TercerosEstadotxt.setValue("Moscú");
                mainPage260909.CodigoPostaltxt.setValue("101000");
                mainPage260909.TercerosColoniatxt.setValue("PRUEBA Estocolmo");
                mainPage260909.inputTercerosCalle.setValue("234");
                mainPage260909.inputTercerosNumExterior.setValue("1");
                mainPage260909.inputTercerosNumInterior.setValue("9");
                mainPage260909.inputTerceroLada.setValue("7");
                mainPage260909.inputTercerosTelefono.setValue("7238440157");
                mainPage260909.inputTercerosCorreoElec.setValue("pruebaCorreoElec@test.com");
                mainPage260909.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260909.gridDestinatario1.click();
                mainPage260909.btnModificarDestinatario.click();
                mainPage260909.radPersonaMoral.click();
                mainPage260909.FabricanteRFC.setValue("AAL0409235E6");
                mainPage260909.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Destinatario Modificación");

                //Datos personales
                mainPage260909.selectTercerosEstado.sendKeys("CIUDAD DE MÉXICO");
                mainPage260909.selectTercerosMunicipio.sendKeys("GUSTAVO A MADERO");
                mainPage260909.selectTercerosLocalidad.selectOption("UNIDAD HABITACIONAL EL COYOL 2");
                mainPage260909.selectTercerosCodPostal.selectOptionByValue("07000");
                mainPage260909.selectTercerosColonia.sendKeys("15 DE AGOSTO");
                mainPage260909.inputTercerosCalle.setValue("Calle QA Modificación");
                mainPage260909.inputTercerosNumExterior.setValue("10");
                mainPage260909.inputTercerosNumInterior.setValue("5");
                mainPage260909.inputTerceroLada.setValue("55");
                mainPage260909.inputTercerosTelefono.setValue("551-087-907");
                mainPage260909.inputTercerosCorreoElec.setValue("vucem2.5Modif@hotmail.com");
                mainPage260909.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260909.btnAgregarProveedor.click();
                mainPage260909.radPersonaMoral.click();
                mainPage260909.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA PROVEDOR MOdificación");
                mainPage260909.listTercerosPais.selectOption("SUIZA (CONFEDERACION)");
                mainPage260909.TercerosEstadotxt.setValue("Kloten");
                mainPage260909.CodigoPostaltxt.setValue("8058");
                mainPage260909.TercerosColoniatxt.setValue("Colonia QA");
                mainPage260909.inputTercerosCalle.setValue("Calle Lerchenweg");
                mainPage260909.inputTercerosNumExterior.setValue("50");
                mainPage260909.inputTercerosNumInterior.setValue("5");
                mainPage260909.inputTerceroLada.setValue("41");
                mainPage260909.inputTercerosTelefono.setValue("551-087-907");
                mainPage260909.inputTercerosCorreoElec.setValue("vucem2.5TestM@hotmail.com");
                mainPage260909.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260909.btnAgregarFacturador.click();
                mainPage260909.radPersonaMoral.click();
                mainPage260909.inputTercerosDenominacionRazon.setValue("QA FACTURADOR MOdificación");
                mainPage260909.listTercerosPais.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage260909.TercerosEstadotxt.setValue("DURANGO");
                mainPage260909.CodigoPostaltxt.setValue("34001");
                mainPage260909.TercerosColoniatxt.setValue("12 DE DICIEMBRE");
                mainPage260909.inputTercerosCalle.setValue("Calle Durango QA");
                mainPage260909.inputTercerosNumExterior.setValue("10");
                mainPage260909.inputTercerosNumInterior.setValue("5");
                mainPage260909.inputTerceroLada.setValue("618");
                mainPage260909.inputTercerosTelefono.setValue("618-813-6670");
                mainPage260909.inputTercerosCorreoElec.setValue("vucem2.5@hotmail.com");
                mainPage260909.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260909.Scrol.scrollTo().shouldBe(visible);
                mainPage260909.tabPagoDerechos.click();
                mainPage260909.ClaveReferencia.setValue("38493482");sleep(1000);
                mainPage260909.CadenaDependencia.setValue("01123714EC10303");
                mainPage260909.listBanco.selectOption("BANCA MIFEL");sleep(1000);
                mainPage260909.inpLLavePago.setValue(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260909.FechaPago, fechaHoy);
                mainPage260909.ImportePago.setValue("100");
                mainPage260909.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage260909.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260909.btnAdjuntar2.click();
                mainPage260909.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30)); sleep(1000);
                mainPage260909.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260909.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260909.folio.getText();

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

