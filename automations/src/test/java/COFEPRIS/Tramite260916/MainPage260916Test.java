package COFEPRIS.Tramite260916;

import COFEPRIS.Tramite260916.MainPage260916;
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

public class MainPage260916Test {


        MainPage260916 mainPage260916 = new MainPage260916();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260916  = new TramitesFirmasLG(
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
        public void Proceso260916() throws IOException {
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

                // Obtener la fecha de (hoy) formateada
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaHoy = LocalDate.now().format(formatter);

                //llave de pago
                String uuid = UUID.randomUUID().toString();
                int longitudDeseada = 16;
                String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260916);
                mainPage260916.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260916.btnacep.click();sleep(1000);

                //Búsqueda de tramite Subsecuente
                mainPage260916.Tramites.sendKeys("Solicitudes nuevas");
                mainPage260916.SoliSub.click();
                mainPage260916.FolioTramite.sendKeys(FolioTramiteN);
                mainPage260916.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage260916.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage260916.btnSolModificaryProrroga.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                //Datos de solicitud
                mainPage260916.Scrol.scrollTo();
                mainPage260916.DatosSolicitud.click();
                //Seleccione el tipo de operación que desea realizar
                mainPage260916.radbtnModificar.click();
                mainPage260916.JustificacionMod.click();
                mainPage260916.JustificacionDatos.setValue("QA Justificación Modificación");
                //Datos del establecimiento
                mainPage260916.ResponsableSanitarioRFC.setValue("AFC000526BJ2");
                mainPage260916.inputSolicitudEstablecimientoRazonSocial.setValue("RazónTest Modificación");
                mainPage260916.inputSolicitudEstablecimientoCorreoElectronico.setValue("TestModificacion@gmail.com");
                //Domicilio del establecimiento
                mainPage260916.inputSolicitudEstablecimientoDomicilioCodigo.setValue("607059");
                mainPage260916.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("DURANGO");
                mainPage260916.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("DURANGO");
                mainPage260916.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("15 DE MAYO");
                mainPage260916.getInputSolicitudEstablecimientoDomicilioColonia.setValue("12 DE DICIEMBRE");
                mainPage260916.inputSolicitudEstablecimientoDomicilioCalle.setValue("Calle QA Modificación");
                mainPage260916.inputSolicitudEstablecimientoDomicilioLada.setValue("618");
                mainPage260916.inputSolicitudEstablecimientoDomicilioTelefono.setValue("6188136670");sleep(1000);

                mainPage260916.selectSolicitudRegimenClave.sendKeys("Temporales");
                mainPage260916.selectAduanasEntrada.selectOption("CD. JUAREZ");

                //Modificar Mercancia
                mainPage260916.gridMercancia1.click();
                mainPage260916.btnModificarMercancia.click();
                mainPage260916.selectMercanciaGridClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
                mainPage260916.selectMercanciaGridEspecificaClasProd.sendKeys("I) Equipo o instrumental médico.");
                mainPage260916.inputDenominacionEspecifica.setValue("Denominación Especifica Test Modificación");
                mainPage260916.inputDenominacionDistintiva.setValue("Denominación Distintiva test Modificación");
                mainPage260916.inputDenominacionNombreCientif.setValue("Dispositivos Test Nombre Cientifico");
                mainPage260916.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
                mainPage260916.selectEstadoFisico.sendKeys("Solido");
                //mainPage260204.Especifique.sendKeys("Liquido Especificado");
                mainPage260916.inputFraccionArancelaria.setValue("13021999");
                mainPage260916.inputCantidadUmt.setValue("100");
                mainPage260916.inputCantidadUmc.setValue("200");
                mainPage260916.selectMercanciaGridUnidadMedida.sendKeys("Caja");
                mainPage260916.PresentacionFarmaTipoEnvase.setValue("QA Modificación");

                //Pais de origen
                mainPage260916.btnDesplegarInfoPaisOrigen.click();
                mainPage260916.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260916.btnRestarPaisOrigenTodos.click();
                mainPage260916.listaPaisOrigen.selectOption("JAPON");
                mainPage260916.inputAdd.click();

                //Pais de procedencia
                mainPage260916.btnDesplegarInfoPaisProcedencia.click();
                mainPage260916.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260916.btnRestarPaisProveedorTodos.click();
                mainPage260916.listaPaisesProcedencia.selectOption("SUIZA (CONFEDERACION)");
                mainPage260916.inputAdd2.click();

                //Guardar modificación de la mercancia
                mainPage260916.btnGuardarModificarMercancia.click();

                //manifiesto y declaraciones
                mainPage260916.radNoHacerPublicoInformacion.click();

                //TERCEROS RELACIONADOS
                mainPage260916.Scrol.scrollTo().shouldBe(visible);
                mainPage260916.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260916.gridFabricante1.click();
                mainPage260916.btnModificarFabricante.click();
                mainPage260916.radExtranjeroTerceros.click();
                mainPage260916.radPersonaMoral.click();
                mainPage260916.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Modificación");
                //Datos personales
                mainPage260916.listTercerosPais.selectOption("JAPON");
                mainPage260916.TercerosEstadotxt.setValue("Kansai");
                mainPage260916.CodigoPostaltxt.setValue("8058");
                mainPage260916.TercerosColoniatxt.setValue("Osaka");
                mainPage260916.inputTercerosCalle.setValue("Calle QA Modificación");
                mainPage260916.inputTercerosNumExterior.setValue("10");
                mainPage260916.inputTercerosNumInterior.setValue("2");
                mainPage260916.inputTerceroLada.setValue("81");
                mainPage260916.inputTercerosTelefono.setValue("811-087-907");
                mainPage260916.inputTercerosCorreoElec.setValue("vucem2.5TestModificacion@hotmail.com");
                mainPage260916.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260916.gridDestinatario1.click();
                mainPage260916.btnModificarDestinatario.click();
                mainPage260916.radPersonaMoral.click();
                mainPage260916.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Destinatario Modificación");
                mainPage260916.FabricanteRFC.setValue("AAL0409235E6");
                //Datos personales
                mainPage260916.selectTercerosEstado.selectOption("CIUDAD DE MÉXICO");
                mainPage260916.selectTercerosMunicipio.sendKeys("COYOACAN");
                mainPage260916.selectTercerosLocalidad.sendKeys("PUEBLO DE SANTA URSULA COAPA");
                mainPage260916.selectTercerosCodPostal.selectOptionByValue("04000");
                mainPage260916.selectTercerosColonia.sendKeys("SANTA URSULA COAPA");
                mainPage260916.inputTercerosCalle.setValue("Calle Coapa QA Modificación");
                mainPage260916.inputTercerosNumExterior.setValue("10");
                mainPage260916.inputTercerosNumInterior.setValue("9");
                mainPage260916.inputTerceroLada.setValue("55");
                mainPage260916.inputTercerosTelefono.setValue("558-303-1170");
                mainPage260916.inputTercerosCorreoElec.setValue("vucem2.5Modificacion@hotmail.com");
                mainPage260916.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260916.gridProveedor1.click();
                mainPage260916.btnModificarProveedor.click();
                mainPage260916.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA Proveedor Modificación");
                mainPage260916.listTercerosPais.selectOption("SUIZA (CONFEDERACION)");
                mainPage260916.TercerosEstadotxt.setValue("Berna");
                mainPage260916.CodigoPostaltxt.setValue("3001");
                mainPage260916.TercerosColoniatxt.setValue("Colonia QA Modificación");
                mainPage260916.inputTercerosCalle.setValue("Calle Modificación");
                mainPage260916.inputTercerosNumExterior.setValue("150");
                mainPage260916.inputTercerosNumInterior.setValue("3");
                mainPage260916.inputTerceroLada.setValue("41");
                mainPage260916.inputTercerosTelefono.setValue("417-222-127");
                mainPage260916.inputTercerosCorreoElec.setValue("vucem2.5TestModificacion@hotmail.com");
                mainPage260916.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260916.gridFacturador1.click();
                mainPage260916.btnAgregarFacturador.click();
                //mainPage260204.radPersonaFisica.click();
                mainPage260916.radPersonaMoral.click();
                mainPage260916.inputTercerosDenominacionRazon.setValue("QA FACTURADOR Modificación");
                mainPage260916.listTercerosPais.selectOptionByValue("MEX");
                mainPage260916.TercerosEstadotxt.setValue("DURANGO");
                mainPage260916.CodigoPostaltxt.setValue("34002");
                mainPage260916.TercerosColoniatxt.setValue("15 DE DICIEMBRE");
                mainPage260916.inputTercerosCalle.setValue("Calle Durango QA Modificación");
                mainPage260916.inputTercerosNumExterior.setValue("560");
                mainPage260916.inputTercerosNumInterior.setValue("1");
                mainPage260916.inputTerceroLada.setValue("618");
                mainPage260916.inputTercerosTelefono.setValue("618-333-8970");
                mainPage260916.inputTercerosCorreoElec.setValue("vucem2.5Modificación@hotmail.com");
                mainPage260916.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260916.Scrol.scrollTo().shouldBe(visible);
                mainPage260916.tabPagoDerechos.click();
                mainPage260916.ClaveReferencia.setValue("12304302");sleep(1000);
                mainPage260916.CadenaDependencia.setValue("03GHJ1839201");
                mainPage260916.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260916.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260916.FechaPago, fechaHoy);
                mainPage260916.ImportePago.setValue("1500");
                mainPage260916.btnContinuarDatosCompletos.click();

                //Paso 2 REQUISITOS NECESARIOS
                mainPage260916.btnContinuarPaso2.click();

                //Paso 3 ANEXAR REQUISITOS
                metodos.cargarDocumentos();
                mainPage260916.btnAdjuntar2.click();
                mainPage260916.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260916.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260916.btnContinuar3.click();

                //PASO 4 FIRMAR SOLICITUD
                //Firma
                loginFirmSoli.firma(tramite260916);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260916.folio.getText();

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

