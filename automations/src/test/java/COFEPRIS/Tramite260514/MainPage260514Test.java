package COFEPRIS.Tramite260514;

import COFEPRIS.Tramite260514.MainPage260514;
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

public class MainPage260514Test {


        MainPage260514 mainPage260514 = new MainPage260514();
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
        public void Proceso260514() throws IOException {
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
                mainPage260514.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260514.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260514.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260514.SoliNew.click();//sleep(1000);
                mainPage260514.Cofepris.click();//sleep(1000);
                mainPage260514.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260514.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260514.elementoTramite260514.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260514.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260514.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260514.btnEstablecimiento.click();
                mainPage260514.buttonAceptar.click();
                mainPage260514.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260514.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260514.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260514.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260514.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260514.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260514.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260514.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260514.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260514.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260514.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260514.btnAgregarScian.click();
                mainPage260514.selectComboScian.sendKeys("565");
                mainPage260514.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260514.listAduanasEntrada.sendKeys("ADUANA DE PANTACO");
                mainPage260514.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260514.btnAgregarMercancia.click();
                mainPage260514.NombreComercial.sendKeys("QA Nombre comercial");
                mainPage260514.NombreComun.sendKeys("QA Nombre comun");
                mainPage260514.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
                mainPage260514.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
                mainPage260514.selectEstadoFisico.selectOption("Líquido");
                mainPage260514.inputFraccionArancelaria.sendKeys("29121201");
                mainPage260514.inputCantidadUmt.sendKeys("20010");
                mainPage260514.inputCantidadUmc.sendKeys("25");
                mainPage260514.selectMercanciaGridUnidadMedida.selectOption("Litros");
                mainPage260514.NumCAS.sendKeys("23131");
                mainPage260514.PorcentajeConcentracion.sendKeys("22");
                //Pais origen
                mainPage260514.btnDesplegarInfoPaisOrigen.click();
                mainPage260514.listaPaisOrigen.selectOption("CANADA");
                mainPage260514.inputAdd.click();
                //Pais Procedencia
                mainPage260514.btnDesplegarInfoPaisProcedencia.click();
                mainPage260514.listaPaisesProcedencia.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260514.inputAdd2.click();
                //Clasificación Toxicológica e importación
                mainPage260514.selectClasificacionToxi.selectOption("II ALTAMENTE TOXICO");
                mainPage260514.selectObjetoImportacion.selectOption("Aplicación");
                //Agregar la información de la mercancia
                mainPage260514.btnAgregarMercanciaTotalInfo.click();

                //Manifiesto y declaraciones
                mainPage260514.checkCumploRequisitosYNormativas.click();
                mainPage260514.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260514.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260514.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260514.Scrol.scrollTo().shouldBe(visible);
                mainPage260514.tabTercerosRelacionados.click();

                //PAGO DERECHOS
                mainPage260514.Scrol.scrollTo().shouldBe(visible);
                mainPage260514.tabPagoDerechos.click();
                mainPage260514.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260514.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260514.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260514.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260514.FechaPago, fechaHoy);
                mainPage260514.ImportePago.sendKeys("100");
                mainPage260514.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260514.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260514.btnAdjuntar2.click();
                mainPage260514.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260514.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260514.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260514.folio.getText();

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

