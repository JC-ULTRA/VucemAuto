package COFEPRIS.Tramite260206;

import COFEPRIS.Tramite260206.MainPage260206;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260206Test {


        MainPage260206 mainPage260206 = new MainPage260206();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        TramitesFirmasLG tramite260206  = new TramitesFirmasLG(
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
        public void Proceso260206() throws IOException {
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
                loginFirmSoli.login(tramite260206);
                mainPage260206.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260206.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260206.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260206.SoliNew.click();//sleep(1000);
                mainPage260206.Cofepris.click();//sleep(1000);
                mainPage260206.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260206.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260206.Tramite260206.click();sleep(10000);

                //Datos de solicitud
                mainPage260206.Scrol.scrollTo().shouldBe(visible);
                mainPage260206.DatosSolicitud.click();

                mainPage260206.btnEstablecimiento.click();
                mainPage260206.buttonAceptar.click();

                //LLenado de datos
                mainPage260206.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
                mainPage260206.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260206.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260206.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("95270");
                mainPage260206.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
                mainPage260206.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");
                mainPage260206.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");
                mainPage260206.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");
                mainPage260206.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");
                mainPage260206.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");
                mainPage260206.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260206.btnAgregarScian.click();
                mainPage260206.selectComboScian.sendKeys("311321");
                mainPage260206.btnAgregar2Scian.click();sleep(1000);

               // mainPage260206.checkAvisoFuncionamiento.click();
                mainPage260206.inputNumeroLicencia.sendKeys("7896451235");
                mainPage260206.selectSolicitudRegimenClave.sendKeys("Definitivos");
                mainPage260206.selectAduanasEntrada.sendKeys("CD. DEL CARMEN");

                //Agregar Mercancia
                mainPage260206.btnAgregarAduana.click();
                mainPage260206.selectMercanciaGridClasificacionProducto.sendKeys("MEDICAMENTOS/FARMACO");
                mainPage260206.selectMercanciaGridEspecificaClasProd.sendKeys("IV) Vitamínico");
                mainPage260206.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test Suerox");
                mainPage260206.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test Suerox");
                mainPage260206.inputDenominacionNombreCientif.sendKeys("Acido Test Nombre Cientifico");
                mainPage260206.selectTipoProducto.sendKeys("Producto terminado");
                mainPage260206.comboEstadoFisico.sendKeys("Liquido");
                mainPage260206.inputFraccionArancelaria.sendKeys("30039013");
                mainPage260206.inputCantidadUmt.sendKeys("23");
                mainPage260206.inputCantidadUmc.sendKeys("12");
                mainPage260206.selectMercanciaGridUnidadMedida.sendKeys("Botella");
                mainPage260206.PresentacionFarmaTipoEnvase.sendKeys("QA Botella 600ml");

                //Pais de origen
                mainPage260206.btnDesplegarInfoPaisOrigen.click();
                mainPage260206.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260206.selectPaisOrigen.selectOption("REPUBLICA POPULAR DEL CONGO");
                mainPage260206.inputAdd.click();

                //Pais de procedencia
                mainPage260206.btnDesplegarInfoPaisProcedencia.click();
                mainPage260206.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260206.selectPaisProcedencia.selectOption("AUSTRALIA (COMUNIDAD DE)");
                mainPage260206.inputAdd2.click();

                //Uso especifico
                mainPage260206.btnDesplegarInfoUsoEspecifico.click();
                mainPage260206.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260206.selectUsoEspecifico.selectOption("MAQUILA");
                mainPage260206.inputAdd3.click();

                //Agregar la mercancia
                mainPage260206.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260206.checkCumploRequisitosYNormativas.click();
                mainPage260206.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260206.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260206.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                //Datos Generales
                mainPage260206.Scrol.scrollTo().shouldBe(visible);
                mainPage260206.tabTercerosRelacionados.click();
                mainPage260206.btnAgregarFabricante.click();
                mainPage260206.radNacionalTerceros.click();
                mainPage260206.radbtnPersonaMoral.click();
                mainPage260206.TerceroRFC.sendKeys("AAL0409235E6");
                mainPage260206.DenominacionRazonTercero.sendKeys("INTEGRADORA DE URBANIZACIONES SIGNUM, S DE RL DE CV");

                //Datos personales
                mainPage260206.selectTercerosEstado.sendKeys("MORELOS");
                mainPage260206.selectTercerosMunicipio.sendKeys("OCUITUCO");
                mainPage260206.selectTercerosLocalidad.sendKeys("OCOXALTEPEC");
                mainPage260206.selectTercerosCodPostal.selectOptionByValue("62862");
                mainPage260206.selectTercerosColonia.sendKeys("OTRA NO ESPECIFICADA EN EL CATALOGO");
                mainPage260206.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260206.inputTercerosNumExterior.sendKeys("21");
                mainPage260206.inputTercerosNumInterior.sendKeys("5");
                mainPage260206.inputTerceroLada.sendKeys("55");
                mainPage260206.inputTercerosTelefono.sendKeys("55-2345346587");
                mainPage260206.inputTercerosCorreoElec.sendKeys("vucem2.pruebas@hotmail.com");
                mainPage260206.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260206.btnAgregarDestinatario.click();
                mainPage260206.radPersonaFisica.click();
                mainPage260206.TerceroRFC.sendKeys("MAVL621207C95");
                //Datos personales
                mainPage260206.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260206.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260206.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260206.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260206.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260206.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260206.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260206.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260206.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260206.inputTercerosNumExterior.sendKeys("10");
                mainPage260206.inputTercerosNumInterior.sendKeys("5");
                mainPage260206.inputTerceroLada.sendKeys("618");
                mainPage260206.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260206.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260206.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260206.btnAgregarProveedor.click();
                mainPage260206.radPersonaFisica.click();
                //Datos personales
                mainPage260206.inputTercerosNombre.sendKeys("Luis");
                mainPage260206.inputTercerosApellidoPaterno.sendKeys("Hernández");
                mainPage260206.inputTercerosApellidoMaterno.sendKeys("Gonzales");
                mainPage260206.listTercerosPais.selectOption("ANGUILA");
                mainPage260206.TercerosEstadotxt.sendKeys("Anguila");
                mainPage260206.CodigoPostaltxt.sendKeys("23234");
                mainPage260206.TercerosColoniatxt.sendKeys("Centrico");
                mainPage260206.inputTercerosCalle.sendKeys("Calle QA");
                mainPage260206.inputTercerosNumExterior.sendKeys("70");
                mainPage260206.inputTercerosNumInterior.sendKeys("5");
                mainPage260206.inputTerceroLada.sendKeys("33");
                mainPage260206.inputTercerosTelefono.sendKeys("3434565432");
                mainPage260206.inputTercerosCorreoElec.sendKeys("TestProveedor@hotmail.com");
                mainPage260206.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260206.btnAgregarFacturador.click();
                mainPage260206.radbtnPersonaMoral.click();
                //Datos personales
                mainPage260206.DenominacionRazonTercero.sendKeys("Fabricas Laboratoristas");
                mainPage260206.listTercerosPais.selectOption("ARGENTINA (REPUBLICA)");
                mainPage260206.TercerosEstadotxt.sendKeys("Buenos Aires");
                mainPage260206.CodigoPostaltxt.sendKeys("34543");
                mainPage260206.TercerosColoniatxt.sendKeys("Boca");
                mainPage260206.inputTercerosCalle.sendKeys("Calle  QA");
                mainPage260206.inputTercerosNumExterior.sendKeys("10");
                mainPage260206.inputTercerosNumInterior.sendKeys("5");
                mainPage260206.inputTerceroLada.sendKeys("23");
                mainPage260206.inputTercerosTelefono.sendKeys("2435678564");
                mainPage260206.inputTercerosCorreoElec.sendKeys("PruebasFacturador@hotmail.com");
                mainPage260206.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260206.Scrol.scrollTo().shouldBe(visible);
                mainPage260206.tabPagoDerechos.click();
                mainPage260206.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260206.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260206.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260206.inpLLavePago.sendKeys(llavePago);sleep(1000);
                executeJavaScript("arguments[0].value = arguments[1];", mainPage260206.fechaPago, fechaHoy);sleep(1000);
                mainPage260206.ImportePago.sendKeys("100");
                mainPage260206.btnContinuarDatosCompletos.click();

                sleep(1000);
                //Paso2
                mainPage260206.btnContinuarPaso2.click();

                //Paso 3
                mainPage260206.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260206.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260206.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260206.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260206.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260206.btnAdjuntar2.click();sleep(7000);
                mainPage260206.btnCerrar3.click();sleep(1000);

                //Paso 3 (Continuacion)
                //mainPage260206.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260206.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260206.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260206.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260206.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260206.listDocumento6Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                mainPage260206.btnContinuar3.click();sleep(1000);

                //Firma
                loginFirmSoli.firma(tramite260206);sleep(4000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260206.folio.getText();

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

