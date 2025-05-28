package COFEPRIS.Tramite260216;

import COFEPRIS.Tramite260216.MainPage260216;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import Metodos.Metodos;

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

public class MainPage260216Test {


        MainPage260216 mainPage260216 = new MainPage260216();
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
        }

        @Test
        public void Proceso260216() throws IOException {
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
                mainPage260216.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260216.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260216.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260216.SoliNew.click();//sleep(1000);
                mainPage260216.Cofepris.click();//sleep(1000);
                mainPage260216.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260216.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260216.Tramite260216.click();sleep(1000);

                //Datos de solicitud
                mainPage260216.Scrol.scrollTo().shouldBe(visible);
                mainPage260216.DatosSolicitud.click();

                mainPage260216.btnEstablecimiento.click();
                mainPage260216.buttonAceptar.click();

                //LLenado de datos
                mainPage260216.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260216.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260216.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260216.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260216.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260216.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260216.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260216.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260216.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260216.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260216.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260216.btnAgregarScian.click();
                mainPage260216.selectComboScian.sendKeys("614031");
                mainPage260216.btnAgregar2Scian.click();sleep(1000);
                //

                mainPage260216.checkAvisoFuncionamiento.click();
                mainPage260216.selectSolicitudRegimenClave.sendKeys("Definitivos");
                mainPage260216.selectAduanasEntrada.selectOption("CD. DEL CARMEN");

                //Agregar Mercancia
                mainPage260216.btnAgregarAduana.click();
                mainPage260216.selectMercanciaGridClasificacionProducto.sendKeys("FUENTES DE RADIACION (DIAGNOSTICO)");
                mainPage260216.selectMercanciaGridEspecificaClasProd.sendKeys("Fluoroscopio");
                mainPage260216.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
                mainPage260216.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260216.inputDenominacionNombreCientif.sendKeys("Hemorivados Test Nombre Cientifico");
                mainPage260216.selectMercanciaGridTipoProducto.sendKeys("Producto a granel");
                mainPage260216.selectEstadoFisico.sendKeys("Semisolido");
                //mainPage260204.Especifique.sendKeys("Liquido Especificado");
                mainPage260216.inputFraccionArancelaria.sendKeys("13021999");
                mainPage260216.inputCantidadUmt.sendKeys("470");
                mainPage260216.inputCantidadUmc.sendKeys("430");
                mainPage260216.selectMercanciaGridUnidadMedida.sendKeys("Bote");
                mainPage260216.PresentacionFarmaTipoEnvase.sendKeys("QA");

                //Pais de origen
                mainPage260216.btnDesplegarInfoPaisOrigen.click();
                mainPage260216.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260216.listaPaisOrigen.selectOption("SUIZA (CONFEDERACION)");
                mainPage260216.inputAdd.click();

                //Pais de procedencia
                mainPage260216.btnDesplegarInfoPaisProcedencia.click();
                mainPage260216.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260216.listaPaisesProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260216.inputAdd2.click();

                //Uso especifico
                mainPage260216.btnDesplegarInfoUsoEspecifico.click();
                mainPage260216.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260216.listaUsoEspecifico.selectOption("DONACION");
                mainPage260216.inputAdd3.click();

                //Agregar la mercancia
                mainPage260216.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260216.checkCumploRequisitosYNormativas.click();
                mainPage260216.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260216.RepresentanteRFC.sendKeys("ZURA6808202RA");
                mainPage260216.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260216.Scrol.scrollTo().shouldBe(visible);
                mainPage260216.tabTercerosRelacionados.click();

                //Agregar Fabricante
                //DatosGenerales
                mainPage260216.btnAgregarFabricante.click();
                mainPage260216.radExtranjeroTerceros.click();
                mainPage260216.radPersonaMoral.click();
                mainPage260216.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                //Datos personales
                mainPage260216.listTercerosPais.selectOption("SUIZA (CONFEDERACION)");
                mainPage260216.TercerosEstadotxt.sendKeys("Kloten");
                mainPage260216.CodigoPostaltxt.sendKeys("8058");
                mainPage260216.TercerosColoniatxt.sendKeys("Colonia QA");
                mainPage260216.inputTercerosCalle.sendKeys("Calle Lerchenweg");
                mainPage260216.inputTercerosNumExterior.sendKeys("50");
                mainPage260216.inputTercerosNumInterior.sendKeys("5");
                mainPage260216.inputTerceroLada.sendKeys("41");
                mainPage260216.inputTercerosTelefono.sendKeys("551-087-907");
                mainPage260216.inputTercerosCorreoElec.sendKeys("vucem2.5Test@hotmail.com");
                mainPage260216.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260216.btnAgregarDestinatario.click();
                mainPage260216.radPersonaMoral.click();
                mainPage260216.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA Destinatario");
                mainPage260216.FabricanteRFC.sendKeys("AAL0409235E6");
                //Datos personales
                mainPage260216.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260216.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260216.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260216.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260216.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260216.inputTercerosCalle.sendKeys("Calle Carolina");
                mainPage260216.inputTercerosNumExterior.sendKeys("20");
                mainPage260216.inputTercerosNumInterior.sendKeys("1");
                mainPage260216.inputTerceroLada.sendKeys("618");
                mainPage260216.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260216.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260216.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260216.btnAgregarProveedor.click();
                mainPage260216.radPersonaMoral.click();
                mainPage260216.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260216.listTercerosPais.selectOption("SUIZA (CONFEDERACION)");
                mainPage260216.TercerosEstadotxt.sendKeys("Kloten");
                mainPage260216.CodigoPostaltxt.sendKeys("8058");
                mainPage260216.TercerosColoniatxt.sendKeys("Colonia QA");
                mainPage260216.inputTercerosCalle.sendKeys("Calle Lerchenweg");
                mainPage260216.inputTercerosNumExterior.sendKeys("50");
                mainPage260216.inputTercerosNumInterior.sendKeys("5");
                mainPage260216.inputTerceroLada.sendKeys("41");
                mainPage260216.inputTercerosTelefono.sendKeys("551-087-907");
                mainPage260216.inputTercerosCorreoElec.sendKeys("vucem2.5Test@hotmail.com");
                mainPage260216.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260216.btnAgregarFacturador.click();
                //mainPage260204.radPersonaFisica.click();
                mainPage260216.radPersonaMoral.click();
                mainPage260216.inputTercerosDenominacionRazon.sendKeys("QA FACTURADOR");
                mainPage260216.listTercerosPais.selectOptionByValue("MEX");
                mainPage260216.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260216.CodigoPostaltxt.sendKeys("34001");
                mainPage260216.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260216.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260216.inputTercerosNumExterior.sendKeys("10");
                mainPage260216.inputTercerosNumInterior.sendKeys("5");
                mainPage260216.inputTerceroLada.sendKeys("618");
                mainPage260216.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260216.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260216.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260216.Scrol.scrollTo().shouldBe(visible);
                mainPage260216.tabPagoDerechos.click();
                mainPage260216.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260216.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260216.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260216.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260216.FechaPago, fechaHoy);
                mainPage260216.ImportePago.sendKeys("100");
                mainPage260216.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage260216.btnContinuarPaso2.click();

                //Paso 3
                metodos.cargarDocumentos();

                //mainPage260216.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                /*
                mainPage260216.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260216.btnSelecArchivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
*/
                mainPage260216.btnAdjuntar2.click();
                mainPage260216.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260216.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260216.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260216.folio.getText();

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

