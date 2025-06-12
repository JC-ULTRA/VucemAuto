package COFEPRIS.Tramite260914;

import COFEPRIS.Tramite260914.MainPage260914;
import Metodos.Metodos;
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

public class MainPage260914Test {


        MainPage260914 mainPage260914 = new MainPage260914();
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
        public void Proceso260914() throws IOException {
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
                loginFirmSoli.login(tramite260204);
                mainPage260914.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260914.btnacep.click();sleep(1000);

                //Búsqueda de tramite Subsecuente
                mainPage260914.Tramites.sendKeys("Solicitudes nuevas");
                mainPage260914.SoliSub.click();
                mainPage260914.FolioTramite.sendKeys(FolioTramiteN);
                mainPage260914.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage260914.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage260914.btnSolModificaryProrroga.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                //Datos de solicitud
                mainPage260914.Scrol.scrollTo();
                mainPage260914.DatosSolicitud.click();
                //Seleccione el tipo de operación que desea realizar
                mainPage260914.radbtnModificar.click();
                mainPage260914.JustificacionMod.click();
                mainPage260914.JustificacionDatos.setValue("QA Justificación Modificación");

                //LLenado de datos
                mainPage260914.ResponsableSanitarioRFC.setValue("AAL0409235E6");
                mainPage260914.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificación");
                mainPage260914.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestM@gmail.com");

                //Domicilio del establecimiento
                mainPage260914.inputSolicitudEstablecimientoDomicilioCodigo.setValue("607059");
                mainPage260914.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260914.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("Santa ursula");
                mainPage260914.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Localidad Test");
                mainPage260914.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Colonia Ursula");
                mainPage260914.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle QA");
                mainPage260914.inputSolicitudEstablecimientoDomicilioLada.setValue("55");
                mainPage260914.inputSolicitudEstablecimientoDomicilioTelefono.setValue("5091222233");sleep(1000);

                //Aviso
                mainPage260914.selectSolicitudRegimenClave.sendKeys("Definitivos");
                mainPage260914.selectAduanasEntrada.selectOption("VERACRUZ");

                //Modificar Mercancía
                mainPage260914.gridMercancia1.click();
                mainPage260914.btnModificarMercancia.click();
                mainPage260914.selectMercanciaGridClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
                mainPage260914.selectMercanciaGridEspecificaClasProd.sendKeys("I) Equipo o instrumental médico.");
                mainPage260914.inputDenominacionEspecifica.setValue("Denominacion Especifica Test Modificación");
                mainPage260914.inputDenominacionDistintiva.setValue("Denominacion Distintiva test Modificación");
                mainPage260914.inputDenominacionNombreCientif.setValue("Hemorivados Test Nombre Cientifico Modificación");
                mainPage260914.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
                mainPage260914.selectEstadoFisico.sendKeys("Solido");
                //mainPage260204.Especifique.sendKeys("Liquido Especificado");
                mainPage260914.inputFraccionArancelaria.setValue("30039013");
                mainPage260914.inputCantidadUmt.setValue("600");
                mainPage260914.inputCantidadUmc.setValue("8600");
                mainPage260914.selectMercanciaGridUnidadMedida.sendKeys("Caja");
                mainPage260914.PresentacionFarmaTipoEnvase.setValue("QA Envase Modificación");

                //Pais de origen
                mainPage260914.btnDesplegarInfoPaisOrigen.click();
                mainPage260914.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260914.btnRestarPaisOrigenTodos.click();
                mainPage260914.listaPaisOrigen.selectOption("RUSIA (FEDERACION RUSA)");
                mainPage260914.inputAdd.click();

                //Pais de procedencia
                mainPage260914.btnDesplegarInfoPaisProcedencia.click();
                mainPage260914.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260914.btnRestarPaisProveedorTodos.click();
                mainPage260914.listaPaisesProcedencia.selectOption("SUIZA (CONFEDERACION)");
                mainPage260914.inputAdd2.click();

                //Agregar información de la mercancía
                mainPage260914.btnModificarTotalInfo.click();

                //TERCEROS RELACIONADOS
                mainPage260914.Scrol.scrollTo().shouldBe(visible);
                mainPage260914.tabTercerosRelacionados.click();
                //Agregar Fabricante
                mainPage260914.gridFabricante1.click();
                mainPage260914.btnModificarFabricante.click();
                mainPage260914.radbtnExtranjero.click();
                mainPage260914.radPersonaFisica.click();;
                mainPage260914.inputTercerosNombre.setValue("Ekaterina");
                mainPage260914.inputTercerosApellidoPaterno.setValue("Belova");
                mainPage260914.inputTercerosApellidoMaterno.setValue("Belyaeva");
                //Domicilio
                mainPage260914.listTercerosPais.selectOption("RUSIA (FEDERACION RUSA)");
                mainPage260914.TercerosEstadotxt.setValue("Moscú");
                mainPage260914.CodigoPostaltxt.setValue("101000");
                mainPage260914.TercerosColoniatxt.setValue("PRUEBA Estocolmo");
                mainPage260914.inputTercerosCalle.setValue("234");
                mainPage260914.inputTercerosNumExterior.setValue("1");
                mainPage260914.inputTercerosNumInterior.setValue("9");
                mainPage260914.inputTerceroLada.setValue("7");
                mainPage260914.inputTercerosTelefono.setValue("7238440157");
                mainPage260914.inputTercerosCorreoElec.setValue("pruebaCorreoElec@test.com");
                mainPage260914.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260914.gridDestinatario1.click();
                mainPage260914.btnModificarDestinatario.click();
                mainPage260914.radPersonaMoral.click();
                mainPage260914.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Destinatario Modificación");
                mainPage260914.FabricanteRFC.setValue("AAL0409235E6");
                //Datos personales
                mainPage260914.selectTercerosEstado.sendKeys("CIUDAD DE MÉXICO");
                mainPage260914.selectTercerosMunicipio.sendKeys("GUSTAVO A MADERO");
                mainPage260914.selectTercerosLocalidad.selectOption("UNIDAD HABITACIONAL EL COYOL 2");
                mainPage260914.selectTercerosCodPostal.selectOptionByValue("07000");
                mainPage260914.selectTercerosColonia.sendKeys("15 DE AGOSTO");
                mainPage260914.inputTercerosCalle.setValue("Calle QA Modificación");
                mainPage260914.inputTercerosNumExterior.setValue("10");
                mainPage260914.inputTercerosNumInterior.setValue("5");
                mainPage260914.inputTerceroLada.setValue("55");
                mainPage260914.inputTercerosTelefono.setValue("551-087-907");
                mainPage260914.inputTercerosCorreoElec.setValue("vucem2.5Modif@hotmail.com");
                mainPage260914.buttonGuardarDatosTercero.click();

                //Agregar Proveedor
                mainPage260914.gridProveedor1.click();
                mainPage260914.btnModificarProveedor.click();
                mainPage260914.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA PROVEDOR MOdificación");
                mainPage260914.listTercerosPais.selectOption("SUIZA (CONFEDERACION)");
                mainPage260914.TercerosEstadotxt.setValue("Kloten");
                mainPage260914.CodigoPostaltxt.setValue("8058");
                mainPage260914.TercerosColoniatxt.setValue("Colonia QA");
                mainPage260914.inputTercerosCalle.setValue("Calle Lerchenweg");
                mainPage260914.inputTercerosNumExterior.setValue("50");
                mainPage260914.inputTercerosNumInterior.setValue("5");
                mainPage260914.inputTerceroLada.setValue("41");
                mainPage260914.inputTercerosTelefono.setValue("551-087-907");
                mainPage260914.inputTercerosCorreoElec.setValue("vucem2.5TestM@hotmail.com");
                mainPage260914.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260914.gridFacturador1.click();
                mainPage260914.btnModificarFacturador.click();
                mainPage260914.radPersonaMoral.click();
                mainPage260914.inputTercerosDenominacionRazon.setValue("QA FACTURADOR MOdificación");
                mainPage260914.listTercerosPais.selectOption("MEXICO (ESTADOS UNIDOS MEXICANOS)");
                mainPage260914.TercerosEstadotxt.setValue("DURANGO");
                mainPage260914.CodigoPostaltxt.setValue("34001");
                mainPage260914.TercerosColoniatxt.setValue("12 DE DICIEMBRE");
                mainPage260914.inputTercerosCalle.setValue("Calle Durango QA");
                mainPage260914.inputTercerosNumExterior.setValue("10");
                mainPage260914.inputTercerosNumInterior.setValue("5");
                mainPage260914.inputTerceroLada.setValue("618");
                mainPage260914.inputTercerosTelefono.setValue("618-813-6670");
                mainPage260914.inputTercerosCorreoElec.setValue("vucem2.5@hotmail.com");
                mainPage260914.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260914.Scrol.scrollTo().shouldBe(visible);
                mainPage260914.tabPagoDerechos.click();
                mainPage260914.ClaveReferencia.setValue("284000255");sleep(1000);
                mainPage260914.CadenaDependencia.setValue("0111514EC10303");
                mainPage260914.listBanco.selectOption("BANCA MIFEL");sleep(1000);
                mainPage260914.inpLLavePago.setValue(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260914.FechaPago, fechaHoy);
                mainPage260914.ImportePago.setValue("100");
                mainPage260914.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage260914.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260914.btnAdjuntar2.click();
                mainPage260914.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30)); sleep(1000);
                mainPage260914.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260914.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260914.folio.getText();

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

