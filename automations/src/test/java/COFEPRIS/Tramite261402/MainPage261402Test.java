package COFEPRIS.Tramite261402;

import COFEPRIS.Tramite261402.MainPage261402;
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

public class MainPage261402Test {


        MainPage261402 mainPage261402 = new MainPage261402();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();
        TramitesFirmasLG tramite261402  = new TramitesFirmasLG(
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
        public void Proceso261402() throws IOException {
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
                loginFirmSoli.login(tramite261402);
                mainPage261402.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage261402.btnacep.click();sleep(1000);

                //Búsqueda de trámite Subsecuente
                mainPage261402.Tramites.sendKeys("Solicitudes subsecuentes");
                mainPage261402.SoliSub.click();
                mainPage261402.FolioTramite.sendKeys(FolioTramiteN);
                mainPage261402.btnBuscarFolio.click();
                SelenideElement filaFolioDeseado = mainPage261402.filaFolioGrid.findBy(text(FolioTramiteN));
                filaFolioDeseado.doubleClick();

                //Solicitar Modificación y Prórroga
                mainPage261402.btnSolModificar.click(); sleep(2000);

                //Paso 1 CAPTURAR SOLICITUD
                mainPage261402.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de la Solicitud
                mainPage261402.DatosSolicitud.click();
                //Tipo de operación
                mainPage261402.Justificacion.setValue("QA justificación modificación");

                //Propietario
                mainPage261402.gridPropietario1.click();
                mainPage261402.btnModificarPropietario.click();
                mainPage261402.radbtnExtranjeroTerceros.click();
                mainPage261402.radPersonaMoral.click();
                mainPage261402.inputTercerosDenominacionRazon.setValue("Denominación/Razón QA");
                //Datos personales
                mainPage261402.listTercerosPais.selectOption("CANADA");
                mainPage261402.CodigoPostaltxt.setValue("7550000");
                mainPage261402.TercerosEstadotxt.setValue("Ontario");
                mainPage261402.inputTercerosCalle.setValue("Imperial St");
                mainPage261402.inputTercerosNumExterior.setValue("50");
                mainPage261402.inputTercerosNumInterior.setValue("2");
                mainPage261402.inputTerceroLada.setValue("416");
                mainPage261402.inputTercerosTelefono.setValue("416-485-111");
                mainPage261402.inputTercerosCorreoElec.setValue("PropietarioQAModi@hotmail.com");
                mainPage261402.buttonGuardarDatosTercero.click();

                //Datos del establecimiento
                mainPage261402.btnEstablecimiento.click();
                mainPage261402.buttonAceptar.click();
                mainPage261402.inputSolicitudEstablecimientoRazonSocial.setValue("RazonTest Modificación");
                mainPage261402.CorreoEstablecimiento.setValue("TestModificacion@gmail.com");
                //Domicilio del establecimiento
                mainPage261402.inputSolicitudEstablecimientoDomicilioCodigo.setValue("755");
                mainPage261402.selectSolicitudEstablecimientoDomicilioEntidad.selectOption("SINALOA");
                mainPage261402.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.setValue("Mazatlan");
                mainPage261402.inputSolicitudEstablecimientoDomicilioLocalidad.setValue("Zona dorada Modificación");
                mainPage261402.getInputSolicitudEstablecimientoDomicilioColonia.setValue("Colonia modificaicón");
                mainPage261402.inputSolicitudEstablecimientoDomicilioCalle.setValue("Av. Gaviotas Modificación");
                mainPage261402.inputSolicitudEstablecimientoDomicilioLada.setValue("416");
                mainPage261402.inputSolicitudEstablecimientoDomicilioTelefono.setValue("4160775145");sleep(1000);

                //Agregar SCIAN
                mainPage261402.btnAgregarScian.click();
                mainPage261402.selectComboScian.selectOption("352100");
                mainPage261402.btnAgregar2Scian.click();

                //Representante Legal
                mainPage261402.NumLicenciaSanitaria.setValue("18129");
                mainPage261402.btnAgregarLicSani.click(); sleep(1000);

                //Regimen destino
                mainPage261402.RegimenDestinoMerca.selectOption("Temporales");
                mainPage261402.AduanaEntrada.selectOption("CD. JUAREZ");

                //Agregar/Modificar Mercancía
                mainPage261402.gridMercancia1.click();
                mainPage261402.btnModificarMercancia.click();
                mainPage261402.NombreEspecifico.setValue("Nombre especifico modificación");
                mainPage261402.selectTipoProductoMerca.selectOption("Células");
                mainPage261402.CantidadUMTPro.setValue("100");
                mainPage261402.CantidadVol.setValue("1560");
                mainPage261402.UnidadMedida.selectOption("Ampolleta");
                mainPage261402.PresFarmaEnv.setValue("QA modificación presentación");

                //Condiciones de almacenamiento1
                mainPage261402.EnvprimarioAl.setValue("Ampolleta");
                mainPage261402.EnvSecundariAl.setValue("Cajas de Ampolleta");

                //Condiciones de transporte
                mainPage261402.EnvprimarioCT.setValue("Refrigerado");
                mainPage261402.EnvSecundariTC.setValue("Cajas compactas");

                //Pais de origen
                mainPage261402.btnDesplegarInfoPaisOrigen.click();
                mainPage261402.btnDesplegarInfoPaisOrigen.scrollTo();
                mainPage261402.btnRestarPaisOrigenTodos.click();
                mainPage261402.listaPaisOrigen.selectOption("CANADA");
                mainPage261402.inputAdd.click();

                //Pais de origen
                mainPage261402.btnDesplegarInfoPaisProcedencia.click();
                mainPage261402.btnDesplegarInfoPaisProcedencia.scrollTo();
                mainPage261402.btnRestarPaisProcedenciaTodos.click();
                mainPage261402.listaPaisProcedencia.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261402.inputAdd2.click();

                //Uso especifico
                mainPage261402.selectUsoEspesifico.selectOption("Internación al territorio nacional de células, tejidos, productos de seres humanos y suero, destinado a diagnóstico.");
                //Guardar modificación
                mainPage261402.btnModificarInfoMercancia.click();

                //Datos o anexcos
                mainPage261402.radNoHacerPublicoInformacion.click();

                //Representante legal
                mainPage261402.RepresentanteRFC.sendKeys("ALL0409235E6");
                mainPage261402.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage261402.Scrol.scrollTo().shouldBe(visible);
                mainPage261402.tabTercerosRelacionados.click();

                //Modificación Información procedencia
                mainPage261402.gridProcedencia1.click();
                mainPage261402.btnModificarProcedencia.click();

                //Información procedencia
                mainPage261402.radPersonaMoral.click();
                mainPage261402.inputTercerosDenominacionRazon.setValue("Denominación modificación QA");
                mainPage261402.listTercerosPais.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage261402.TercerosEstadotxt.setValue("California");
                mainPage261402.CodigoPostaltxt.setValue("95270");
                mainPage261402.inputTercerosCalle.setValue("Garfield");
                mainPage261402.inputTercerosNumExterior.setValue("10");
                mainPage261402.inputTercerosNumInterior.setValue("5");
                mainPage261402.inputTerceroLada.setValue("1");
                mainPage261402.inputTercerosTelefono.setValue("9168136670");
                mainPage261402.inputTercerosCorreoElec.setValue("TestProcedenciaMod@hotmail.com");
                mainPage261402.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage261402.Scrol.scrollTo().shouldBe(visible);
                mainPage261402.tabPagoDerechos.click();
                mainPage261402.ClaveReferencia.setValue("13940255");sleep(1000);
                mainPage261402.CadenaDependencia.setValue("011126GGEC122R3");
                mainPage261402.listBanco.selectOption("BANAMEX");sleep(1000);
                mainPage261402.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage261402.FechaPago, fechaHoy);
                mainPage261402.ImportePago.setValue("1200");
                mainPage261402.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage261402.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage261402.btnAdjuntar2.click();
                mainPage261402.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));sleep(1000);
                mainPage261402.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage261402.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite261402);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage261402.folio.getText();

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

