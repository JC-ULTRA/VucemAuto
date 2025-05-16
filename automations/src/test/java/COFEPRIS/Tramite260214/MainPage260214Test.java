package COFEPRIS.Tramite260214;

import COFEPRIS.Tramite260214.MainPage260214;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

public class MainPage260214Test {


        MainPage260214 mainPage260214 = new MainPage260214();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
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
        public void Proceso260214() throws IOException {
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
                mainPage260214.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260214.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260214.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260214.SoliNew.click();//sleep(1000);
                mainPage260214.Cofepris.click();//sleep(1000);
                mainPage260214.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260214.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260214.Tramite260214.click();sleep(1000);

                //Datos de solicitud
                mainPage260214.Scrol.scrollTo().shouldBe(visible);
                mainPage260214.DatosSolicitud.click();

                mainPage260214.btnEstablecimiento.click();
                mainPage260214.buttonAceptar.click();

                //LLenado de datos
                mainPage260214.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260214.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260214.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260214.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260214.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
                mainPage260214.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
                mainPage260214.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
                mainPage260214.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
                mainPage260214.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
                mainPage260214.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
                mainPage260214.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260214.btnAgregarScian.click();
                mainPage260214.selectComboScian.sendKeys("311311");
                mainPage260214.btnAgregar2Scian.click();sleep(1000);
                //

                mainPage260214.checkAvisoFuncionamiento.click();
                mainPage260214.selectSolicitudRegimenClave.sendKeys("Definitivos");
                mainPage260214.selectAduanasEntrada.selectOption("VERACRUZ");

                //Agregar Mercancia
                mainPage260214.btnAgregarAduana.click();
                mainPage260214.selectMercanciaGridClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
                mainPage260214.selectMercanciaGridEspecificaClasProd.sendKeys("II) Prótesis, órtesis y ayudas funcionales.");
                mainPage260214.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
                mainPage260214.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260214.inputDenominacionNombreCientif.sendKeys("Hemorivados Test Nombre Cientifico");
                mainPage260214.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
                mainPage260214.selectEstadoFisico.sendKeys("Granulado o polvo");
                //mainPage260204.Especifique.sendKeys("Liquido Especificado");
                mainPage260214.inputFraccionArancelaria.sendKeys("30039013");
                mainPage260214.inputCantidadUmt.sendKeys("100");
                mainPage260214.inputCantidadUmc.sendKeys("100");
                mainPage260214.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
                mainPage260214.PresentacionFarmaTipoEnvase.sendKeys("QA");

                //Pais de origen
                mainPage260214.btnDesplegarInfoPaisOrigen.click();
                mainPage260214.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260214.listaPaisOrigen.selectOption("AFGANISTAN (EMIRATO ISLAMICO DE)");
                mainPage260214.inputAdd.click();

                //Pais de procedencia
                mainPage260214.btnDesplegarInfoPaisProcedencia.click();
                mainPage260214.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260214.listaPaisesProcedencia.selectOption("ALEMANIA (REPUBLICA FEDERAL DE)");
                mainPage260214.inputAdd2.click();

                //Uso especifico
                mainPage260214.btnDesplegarInfoUsoEspecifico.click();
                mainPage260214.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260214.listaUsoEspecifico.selectOption("USO MÉDICO");
                mainPage260214.inputAdd3.click();

                //Agregar la mercancia
                mainPage260214.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260214.checkCumploRequisitosYNormativas.click();
                mainPage260214.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260214.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260214.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260214.Scrol.scrollTo().shouldBe(visible);
                mainPage260214.tabTercerosRelacionados.click();
                //Agregar Fabricante
                //DatosGenerales
                mainPage260214.btnAgregarFabricante.click();
                mainPage260214.radNacionalTerceros.click();
                mainPage260214.radPersonaMoral.click();
                mainPage260214.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
                mainPage260214.FabricanteRFC.sendKeys("AAL0409235E6");

                //Datos personales
                mainPage260214.selectTercerosEstado.sendKeys("CIUDAD DE MÉXICO");
                mainPage260214.selectTercerosMunicipio.sendKeys("GUSTAVO A MADERO");
                mainPage260214.selectTercerosLocalidad.selectOption("UNIDAD HABITACIONAL EL COYOL 2");
                mainPage260214.selectTercerosCodPostal.selectOptionByValue("07000");
                mainPage260214.selectTercerosColonia.sendKeys("15 DE AGOSTO");
                mainPage260214.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260214.inputTercerosNumExterior.sendKeys("10");
                mainPage260214.inputTercerosNumInterior.sendKeys("5");
                mainPage260214.inputTerceroLada.sendKeys("55");
                mainPage260214.inputTercerosTelefono.sendKeys("551-087-907");
                mainPage260214.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260214.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260214.btnAgregarDestinatario.click();
                mainPage260214.radPersonaMoral.click();
                mainPage260214.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA Destinatario");
                mainPage260214.FabricanteRFC.sendKeys("AAL0409235E6");
                //Datos personales
                mainPage260214.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260214.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260214.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260214.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260214.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260214.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260214.inputTercerosNumExterior.sendKeys("10");
                mainPage260214.inputTercerosNumInterior.sendKeys("5");
                mainPage260214.inputTerceroLada.sendKeys("618");
                mainPage260214.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260214.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260214.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260214.btnAgregarProveedor.click();
                mainPage260214.radPersonaMoral.click();
                mainPage260214.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");
                mainPage260214.listTercerosPais.selectOptionByValue("CAN");
                mainPage260214.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260214.CodigoPostaltxt.sendKeys("34001");
                mainPage260214.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260214.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260214.inputTercerosNumExterior.sendKeys("10");
                mainPage260214.inputTercerosNumInterior.sendKeys("5");
                mainPage260214.inputTerceroLada.sendKeys("618");
                mainPage260214.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260214.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260214.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260214.btnAgregarFacturador.click();
                //mainPage260204.radPersonaFisica.click();
                mainPage260214.radPersonaMoral.click();
                mainPage260214.inputTercerosDenominacionRazon.sendKeys("QA FACTURADOR");
                mainPage260214.listTercerosPais.selectOptionByValue("CAN");
                mainPage260214.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260214.CodigoPostaltxt.sendKeys("34001");
                mainPage260214.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260214.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260214.inputTercerosNumExterior.sendKeys("10");
                mainPage260214.inputTercerosNumInterior.sendKeys("5");
                mainPage260214.inputTerceroLada.sendKeys("618");
                mainPage260214.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260214.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260214.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260214.Scrol.scrollTo().shouldBe(visible);
                mainPage260214.tabPagoDerechos.click();
                mainPage260214.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260214.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260214.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260214.inpLLavePago.sendKeys(llavePago);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260214.FechaPago, fechaHoy);
                mainPage260214.ImportePago.sendKeys("100");
                mainPage260214.btnContinuarDatosCompletos.click();

                //Paso2
                mainPage260214.btnContinuarPaso2.click();

                //Paso 3
                mainPage260214.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260214.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260214.btnSelecArchivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");

                mainPage260214.btnAdjuntar2.click();
                mainPage260214.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260214.btnCerrar3.click();

                //Paso 3 (Continuacion)
                mainPage260214.btnContinuar3.click();

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260214.folio.getText();

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

