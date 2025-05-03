package COFEPRIS.Tramite260205;

import COFEPRIS.Tramite260205.MainPage260205;
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

public class MainPage260205Test {


        MainPage260205 mainPage260205 = new MainPage260205();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        TramitesFirmasLG tramite260205  = new TramitesFirmasLG(
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
        public void Proceso260205() throws IOException {
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

                //llave de pago
                String uuid = UUID.randomUUID().toString();
                int longitudDeseada = 16;
                String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);


                // Obtener la fecha de hoy formateada
                LocalDate hoy = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaHoy = hoy.format(formatter);

                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260205);
                mainPage260205.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260205.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260205.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260205.SoliNew.click();//sleep(1000);
                mainPage260205.Cofepris.click();//sleep(1000);
                mainPage260205.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260205.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260205.elementoTramite260205.click();sleep(10000);

                //Datos de solicitud
                mainPage260205.Scrol.scrollTo();
                mainPage260205.DatosSolicitud.click();

                mainPage260205.btnEstablecimiento.click();
                mainPage260205.buttonAceptar.click();

                //LLenado de datos
                mainPage260205.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260205.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260205.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260205.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260205.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
                mainPage260205.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");
                mainPage260205.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");
                mainPage260205.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");
                mainPage260205.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");
                mainPage260205.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");
                mainPage260205.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260205.btnAgregarScian.click();
                mainPage260205.selectComboScian.sendKeys("311321");
                mainPage260205.btnAgregar2Scian.click();sleep(1000);
                //

                mainPage260205.checkAvisoFuncionamiento.click();
                mainPage260205.selectSolicitudRegimenClave.sendKeys("Definitivos");
                mainPage260205.selectAduanasEntrada.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");

                //Agregar Mercancia
                mainPage260205.btnAgregarAduana.click();
                mainPage260205.selectMercanciaGridClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");
                mainPage260205.selectMercanciaGridEspecificaClasProd.sendKeys("I) Equipo o instrumental médico.");
                mainPage260205.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
                mainPage260205.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260205.inputDenominacionNombreCientif.sendKeys("Test Nombre Cientifico");
                mainPage260205.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
                mainPage260205.comboFormaFarmaceutica.sendKeys("Gragea");
                mainPage260205.comboEstadoFisico.sendKeys("Solido");
                //mainPage260205.Especifique.sendKeys("Liquido Especificado");
                mainPage260205.inputFraccionArancelaria.sendKeys("30039013");
                mainPage260205.inputCantidadUmt.sendKeys("100");
                mainPage260205.inputCantidadUmc.sendKeys("100");
                mainPage260205.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
                mainPage260205.PresentacionFarmaTipoEnvase.sendKeys("QA");

                //Pais de origen
                mainPage260205.btnDesplegarInfoPaisOrigen.click();
                mainPage260205.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260205.selectPaisorigen.selectOption("ANDORRA (PRINCIPADO DE)");
                mainPage260205.inputAdd.click();

                //Pais de procedencia
                mainPage260205.btnDesplegarInfoPaisProcedencia.click();
                mainPage260205.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260205.selectPaisesProcedencia.selectOption("ANGUILA");
                mainPage260205.inputAdd2.click();

                //Uso especifico
                mainPage260205.btnDesplegarInfoUsoEspecifico.click();
                mainPage260205.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260205.MenuUsoEspecifico.selectOption("INVESTIGACIÓN CIENTÍFICA");
                mainPage260205.inputAdd3.click();

                //Agregar la mercancia
                mainPage260205.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260205.checkCumploRequisitosYNormativas.click();
                mainPage260205.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260205.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260205.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                mainPage260205.Scrol.scrollTo().shouldBe(visible);
                mainPage260205.tabTercerosRelacionados.click();

                //Agregar Fabricante
                // Datos Generales
                mainPage260205.btnAgregarFabricante.click();
                mainPage260205.radNacionalTerceros.click();
                mainPage260205.radPersonaMoral.click();
                mainPage260205.TercerosRFC.sendKeys("AAL0409235E6");
                mainPage260205.DenominacionRazonTerceros.sendKeys("Razon QA");
                //Datos personales
                mainPage260205.selectTercerosEstado.sendKeys("VERACRUZ");
                mainPage260205.selectTercerosMunicipio.sendKeys("ALVARADO");
                mainPage260205.selectTercerosLocalidad.sendKeys("ALVARADO");
                mainPage260205.selectTercerosCodPostal.selectOptionByValue("95263");
                mainPage260205.selectTercerosColonia.sendKeys("CENTRO");
                mainPage260205.inputTercerosCalle.sendKeys("Calle Veracruz QA");
                mainPage260205.inputTercerosNumExterior.sendKeys("10");
                mainPage260205.inputTercerosNumInterior.sendKeys("5");
                mainPage260205.inputTerceroLada.sendKeys("44");
                mainPage260205.inputTercerosTelefono.sendKeys("5534344123");
                mainPage260205.inputTercerosCorreoElec.sendKeys("FabricanteQA2.5@hotmail.com");
                mainPage260205.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260205.btnAgregarDestinatario.click();
                mainPage260205.radPersonaFisica.click();
                mainPage260205.TercerosRFC.sendKeys("MAVL621207C95");
                //Datos personales
                mainPage260205.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260205.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260205.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260205.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260205.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260205.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260205.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260205.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260205.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260205.inputTercerosNumExterior.sendKeys("10");
                mainPage260205.inputTercerosNumInterior.sendKeys("5");
                mainPage260205.inputTerceroLada.sendKeys("618");
                mainPage260205.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260205.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260205.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260205.btnAgregarProveedor.click();
                mainPage260205.radPersonaFisica.click();
                //Datos personales
                mainPage260205.inputTercerosNombre.sendKeys("Luis");
                mainPage260205.inputTercerosApellidoPaterno.sendKeys("Hernández");
                mainPage260205.inputTercerosApellidoMaterno.sendKeys("Gonzales");
                mainPage260205.listTercerosPais.selectOption("ANGUILA");
                mainPage260205.TercerosEstadotxt.sendKeys("Anguila");
                mainPage260205.CodigoPostaltxt.sendKeys("23234");
                mainPage260205.TercerosColoniatxt.sendKeys("Centrico");
                mainPage260205.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260205.inputTercerosNumExterior.sendKeys("70");
                mainPage260205.inputTercerosNumInterior.sendKeys("5");
                mainPage260205.inputTerceroLada.sendKeys("33");
                mainPage260205.inputTercerosTelefono.sendKeys("3434565432");
                mainPage260205.inputTercerosCorreoElec.sendKeys("TestProveedor@hotmail.com");
                mainPage260205.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260205.btnAgregarFacturador.click();
                mainPage260205.radPersonaMoral.click();
                mainPage260205.DenominacionRazonTerceros.sendKeys("Fabricas Laboratoristas");
                //Datos personales
                mainPage260205.listTercerosPais.selectOption("ARGENTINA (REPUBLICA)");
                mainPage260205.TercerosEstadotxt.sendKeys("Buenos Aires");
                mainPage260205.CodigoPostaltxt.sendKeys("34543");
                mainPage260205.TercerosColoniatxt.sendKeys("Boca");
                mainPage260205.inputTercerosCalle.sendKeys("Calle  QA");
                mainPage260205.inputTercerosNumExterior.sendKeys("10");
                mainPage260205.inputTercerosNumInterior.sendKeys("5");
                mainPage260205.inputTerceroLada.sendKeys("23");
                mainPage260205.inputTercerosTelefono.sendKeys("2435678564");
                mainPage260205.inputTercerosCorreoElec.sendKeys("PruebasFacturador@hotmail.com");
                mainPage260205.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260205.Scrol.scrollTo().shouldBe(visible);
                mainPage260205.tabPagoDerechos.click();
                mainPage260205.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260205.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260205.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260205.inpLLavePago.sendKeys(llavePago);sleep(1000);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260205.fechaPago, fechaHoy);sleep(1000);
                mainPage260205.ImportePago.sendKeys("100");
                mainPage260205.btnContinuarDatosCompletos.click();

                sleep(1000);
                //Paso2
                mainPage260205.btnContinuarPaso2.click();

                //Paso 3
                mainPage260205.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260205.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260205.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260205.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260205.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260205.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260205.btnAdjuntar2.click();sleep(7000);
                mainPage260205.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
                mainPage260205.btnCerrar3.click();sleep(1000);

                //Paso 3 (Continuacion)
                //mainPage260205.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260205.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260205.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260205.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260205.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260205.listDocumento6Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                mainPage260205.btnContinuar3.click();sleep(1000);

                //Firma
                loginFirmSoli.firma(tramite260205);sleep(4000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260205.folio.getText();

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

