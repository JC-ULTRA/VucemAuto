package COFEPRIS.Tramite260513;

import COFEPRIS.Tramite260513.MainPage260513;
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

public class MainPage260513Test {


        MainPage260513 mainPage260513 = new MainPage260513();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260513  = new TramitesFirmasLG(
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
        public void Proceso260513() throws IOException {
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
                loginFirmSoli.login(tramite260513);
                mainPage260513.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260513.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260513.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260513.SoliNew.click();//sleep(1000);
                mainPage260513.Cofepris.click();//sleep(1000);
                mainPage260513.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260513.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260513.elementoTramite260513.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260513.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260513.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260513.btnEstablecimiento.click();
                mainPage260513.buttonAceptar.click();
                mainPage260513.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260513.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260513.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260513.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260513.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260513.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260513.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260513.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260513.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260513.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260513.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260513.btnAgregarScian.click();
                mainPage260513.selectComboScian.sendKeys("321215");
                mainPage260513.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260513.listAduanasEntrada.sendKeys("AEROPUERTO INT. DE LA CD DE MEXICO");
                mainPage260513.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260513.btnAgregarMercancia.click();
                mainPage260513.NombreComercial.sendKeys("QA Nombre comercial");
                mainPage260513.NombreComun.sendKeys("QA Nombre comun");
                mainPage260513.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico");
                mainPage260513.UsoEspecifico.sendKeys("Uso especifico de la mercancía");
                mainPage260513.selectEstadoFisico.selectOption("Líquido");
                mainPage260513.inputFraccionArancelaria.sendKeys("29121201");
                mainPage260513.inputCantidadUmt.sendKeys("20010");
                mainPage260513.inputCantidadUmc.sendKeys("25");
                mainPage260513.selectMercanciaGridUnidadMedida.selectOption("Litros");
                mainPage260513.NumCAS.sendKeys("235231");
                mainPage260513.PorcentajeConcentracion.sendKeys("22");
                //Pais origen
                mainPage260513.btnDesplegarInfoPaisOrigen.click();
                mainPage260513.listaPaisOrigen.selectOption("CANADA");
                mainPage260513.btnAgregarPaisOrigen.click();
                //Pais Procedencia
                mainPage260513.btnDesplegarInfoPaisProcedencia.click();
                mainPage260513.listaPaisesProcedencia.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260513.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260513.selectClasificacionToxi.selectOption("I EXTREMADAMENTE TOXICO");
                mainPage260513.selectObjetoImportacion.selectOption("Aplicación");
                //Agregar la información de la mercancia
                mainPage260513.btnAgregarMercanciaTotalInfo.click();

                //Manifiesto y declaraciones
                mainPage260513.checkCumploRequisitosYNormativas.click();
                mainPage260513.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260513.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260513.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260513.Scrol.scrollTo().shouldBe(visible);
                mainPage260513.tabTercerosRelacionados.click();

                //PAGO DERECHOS
                mainPage260513.Scrol.scrollTo().shouldBe(visible);
                mainPage260513.tabPagoDerechos.click();
                mainPage260513.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260513.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260513.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260513.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260513.FechaPago, fechaHoy);
                mainPage260513.ImportePago.sendKeys("100");
                mainPage260513.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260513.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();
                mainPage260513.btnAdjuntar2.click();
                mainPage260513.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260513.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260513.btnContinuarPaso3.click();

                //Firma
                loginFirmSoli.firma(tramite260513);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260513.folio.getText();

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

