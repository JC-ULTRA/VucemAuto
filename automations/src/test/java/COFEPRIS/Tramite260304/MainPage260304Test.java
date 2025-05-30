package COFEPRIS.Tramite260304;

import COFEPRIS.Tramite260304.MainPage260304;
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

public class MainPage260304Test {


        MainPage260304 mainPage260304 = new MainPage260304();
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
        public void Proceso260304() throws IOException {
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
                mainPage260304.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260304.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260304.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260304.SoliNew.click();//sleep(1000);
                mainPage260304.Cofepris.click();//sleep(1000);
                mainPage260304.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260304.PermisoSanitarioImporExporEstupefacientes.click();//sleep(1000);
                mainPage260304.elementoTramite260304.click();sleep(1000);

                //Paso 1 CAPTURAR SOLICITUD
                mainPage260304.Scrol.scrollTo().shouldBe(visible);
                //Pestaña Datos de la solicitud
                mainPage260304.DatosSolicitud.click();
                //Datos del establecimiento
                mainPage260304.btnEstablecimiento.click();
                mainPage260304.buttonAceptar.click();
                mainPage260304.inputSolicitudEstablecimientoRazonSocial.sendKeys("ULTRASIST QA");
                //Domicilio del establecimiento
                mainPage260304.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260304.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260304.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260304.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260304.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260304.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260304.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test5@gmail.com");
                mainPage260304.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260304.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260304.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260304.btnAgregarScian.click();
                mainPage260304.selectComboScian.sendKeys("923131");
                mainPage260304.btnAgregar2Scian.click();

                //Aviso de funcionamiento
                mainPage260304.checkAvisoFuncionamiento.click();
               // mainPage260304.selectSolicitudRegimenClave.sendKeys("Definitivos");

                //Agregar Mercancia
                mainPage260304.btnAgregarMercancia.click();
                mainPage260304.selectMercanciaGridClasificacionProducto.sendKeys("ESTUPEFACIENTES");
                mainPage260304.MercanciaEspecificaClasProd.sendKeys("fármacos con efectos en la mente");
                mainPage260304.DenominacionComunInternacional.sendKeys("DCI Test");
                mainPage260304.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260304.selectMercanciaGridTipoProducto.sendKeys("Materia prima");

                //Forma Farmaceutica
                mainPage260304.btnDesplegarFormaFarmaceutica.click();
                mainPage260304.listaFormaFarmaceutica.sendKeys("CAPSULAS");
                mainPage260304.btnAgregarFormaFarmaceutica.click();

                //Información General Mercancía
                mainPage260304.inputFraccionArancelaria.sendKeys("28369101");
                mainPage260304.inputCantidadUmt.sendKeys("240");

                mainPage260304.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
                //mainPage260304.selectMercanciaGridUnidadMedida.scrollIntoView(true);
                mainPage260304.NumeroCAS.sendKeys("432044");
                mainPage260304.CantidadLotes.sendKeys("105");
                //Pais Destino
                mainPage260304.selectPaisDestino.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                //Uso especifico
                mainPage260304.btnDesplegarInfoUsoEspecifico.click();
                mainPage260304.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260304.listaUsoEspecifico.selectOption("ELABORACIÓN");
                mainPage260304.btnAgregarUsoEspecifico.click();
                mainPage260304.DetalleUsoEspecifico.sendKeys("Detalle Uso QA");
                mainPage260304.inputCantidadUmc.sendKeys("10098");
                mainPage260304.NumRegistroSanitario.sendKeys("124850");
                mainPage260304.Presentacion.sendKeys("Caja");
                mainPage260304.btnAgregarDetalle.click();
                //Agregar la información de la mercancía
                mainPage260304.btnAgregarInfoMercancia.click(); sleep(1000);

                //Agregar aduana
                metodos.scrollDecremento(1);
                mainPage260304.selectAduanas.selectOption("AEROPUERTO INT. DE LA CD DE MEXICO");

                //manifiesto y declaraciones
                mainPage260304.checkCumploRequisitosYNormativas.click();
                mainPage260304.radNoHacerPublicoInformacion.click();

                //Repesentante legal
                mainPage260304.RepresentanteRFC.sendKeys("ZURC721023D12");
                mainPage260304.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260304.Scrol.scrollTo().shouldBe(visible);
                mainPage260304.tabTercerosRelacionados.click();

                //Agregar Destinatario (Destino Final)
                //DatosGenerales
                mainPage260304.btnAgregarDestinatario.click();
                mainPage260304.radbtnPersonaMoral.click();
                mainPage260304.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");

                //Datos Domicilio
                mainPage260304.selectPaisTerceros.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260304.TercerosEstadotxt.sendKeys("Bremen");
                mainPage260304.CodigoPostaltxt.sendKeys("07000");
                mainPage260304.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260304.inputTercerosNumExterior.sendKeys("10");
                mainPage260304.inputTercerosNumInterior.sendKeys("5");
                mainPage260304.inputTerceroLada.sendKeys("55");
                mainPage260304.inputTercerosTelefono.sendKeys("551-087-907");
                mainPage260304.inputTercerosCorreoElec.sendKeys("vucem2.5test@hotmail.com");
                mainPage260304.buttonGuardarDatosTercero.click();

                //Agregar Otros
                //Datos generales
                mainPage260304.btAgregarOtros.click();
                mainPage260304.TerceroNombreDescripcion.sendKeys("QA Otros descripción Nombre");
                mainPage260304.radbtnNacionalTerceros.click();
                mainPage260304.radbtnPersonaMoral.click();
                mainPage260304.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260304.btnBuscarTercerosRFC.click();
                mainPage260304.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260304.Scrol.scrollTo().shouldBe(visible);
                mainPage260304.tabPagoDerechos.click();
                mainPage260304.ClaveReferencia.sendKeys("1847903255");sleep(1000);
                mainPage260304.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260304.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260304.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260304.FechaPago, fechaHoy);
                mainPage260304.ImportePago.sendKeys("100");
                mainPage260304.btnContinuarDatosCompletos.click();

                //Paso 2 REQUISITOS NECESARIOS
                mainPage260304.btnContinuarPaso2.click();

                //Paso 3 ANEXAR REQUISITOS
                metodos.cargarDocumentos();
                mainPage260304.btnAdjuntar2.click();
                mainPage260304.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260304.btnCerrar3.click();
                mainPage260304.btnContinuar3.click();

                //Paso 4 FIRMAR SOLICITUD
                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260304.folio.getText();

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

