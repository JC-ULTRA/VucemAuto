package COFEPRIS.Tramite260516;

import COFEPRIS.Tramite260516.MainPage260516;
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

public class MainPage260516Test {


        MainPage260516 mainPage260516 = new MainPage260516();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        Metodos metodos = new Metodos();

        TramitesFirmasLG tramite260516  = new TramitesFirmasLG(
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
        public void Proceso260516() throws IOException {
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
                loginFirmSoli.login(tramite260516);
                mainPage260516.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260516.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260516.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260516.SoliNew.click();//sleep(1000);
                mainPage260516.Cofepris.click();//sleep(1000);
                mainPage260516.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260516.PermisoImportacionToxicosPeligro.click();//sleep(1000);
                mainPage260516.elementoTramite260516.click();sleep(1000);

                //PASO 1 CAPTURAR SOLICITUD
                mainPage260516.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de solicitud
                mainPage260516.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260516.btnEstablecimiento.click();
                mainPage260516.buttonAceptar.click();
                mainPage260516.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260516.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260516.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");
                //Domicilio del establecimiento
                mainPage260516.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260516.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260516.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260516.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260516.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260516.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260516.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260516.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260516.btnAgregarScian.click();
                mainPage260516.selectComboScian.sendKeys("325415");
                mainPage260516.btnAgregar2Scian.click();sleep(1000);

                //Aduanas de entrada
                mainPage260516.listAduanasEntrada.sendKeys("CD. JUAREZ");
                mainPage260516.btnAgregarAduanaentrada.click();

                //Agregar Mercancia
                mainPage260516.btnAgregarMercancia.click();
                mainPage260516.NombreComercial.sendKeys("QA Nombre comercial Sustancias");
                mainPage260516.NombreComun.sendKeys("QA Nombre Común Sustancias");
                mainPage260516.inputDenominacionNombreCientif.sendKeys("QA Nombre Cientifico Sustancias");
                mainPage260516.UsoEspecifico.sendKeys("Uso para proceso de transformación");
                mainPage260516.selectEstadoFisico.selectOption("Sólido");
                mainPage260516.inputFraccionArancelaria.sendKeys("28254002");
                mainPage260516.inputCantidadUmt.sendKeys("20010");
                mainPage260516.inputCantidadUmc.sendKeys("20010");
                mainPage260516.selectMercanciaGridUnidadMedida.selectOption("Botellas");
                mainPage260516.NumCAS.sendKeys("1313-99-1");
                mainPage260516.PorcentajeConcentracion.sendKeys(">98%");
                //Pais origen
                mainPage260516.btnDesplegarInfoPaisOrigen.click();
                mainPage260516.listaPaisOrigen.selectOption("CANADA");
                mainPage260516.btnAgregarPaisOrigen.click();
                //Pais Procedencia
                mainPage260516.btnDesplegarInfoPaisProcedencia.click();
                mainPage260516.listaPaisesProcedencia.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage260516.btnAgregarPaisProcedencia.click();
                //Clasificación Toxicológica e importación
                mainPage260516.selectClasificacionToxi.selectOption("I EXTREMADAMENTE TOXICO");
                mainPage260516.selectObjetoImportacion.selectOption("Formulación");
                //Agregar la información de la mercancia
                mainPage260516.btnAgregarMercanciaTotalInfo.click();

                //Manifiesto y declaraciones
                mainPage260516.checkCumploRequisitosYNormativas.click();
                mainPage260516.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260516.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260516.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260516.Scrol.scrollTo().shouldBe(visible);
                mainPage260516.tabTercerosRelacionados.click();

                //PAGO DERECHOS
                mainPage260516.Scrol.scrollTo().shouldBe(visible);
                mainPage260516.tabPagoDerechos.click();
                mainPage260516.ClaveReferencia.sendKeys("2810432255");sleep(1000);
                mainPage260516.CadenaDependencia.sendKeys("01123454EC10303");
                mainPage260516.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260516.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260516.FechaPago, fechaHoy);
                mainPage260516.ImportePago.sendKeys("100");
                mainPage260516.btnContinuarDatosCompletos.click();

                //Paso2 REQUISITOS NECESARIOS
                mainPage260516.btnContinuarPaso2.click();

                //Paso 3 ANEXAR REQUISITOS
                metodos.cargarDocumentos();
                mainPage260516.btnAdjuntar2.click();
                mainPage260516.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage260516.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260516.btnContinuarPaso3.click();

                //Paso 4 FIRMAR SOLICITUD
                //Firma
                loginFirmSoli.firma(tramite260516);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260516.folio.getText();

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

