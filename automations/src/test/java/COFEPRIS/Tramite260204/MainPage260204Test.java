package COFEPRIS.Tramite260204;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import COFEPRIS.Tramite260204.MainPage260204;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260204Test {


        MainPage260204 mainPage260204 = new MainPage260204();
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
        public void Proceso260204() throws IOException {
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


                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260204);
                mainPage260204.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260204.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260204.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260204.SoliNew.click();//sleep(1000);
                mainPage260204.Cofepris.click();//sleep(1000);
                mainPage260204.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260204.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260204.Tramite260204.click();sleep(10000);

                //Datos de solicitud
                mainPage260204.LogoVuc.scrollTo().shouldBe(visible);
                mainPage260204.DatosSolicitud.click();

                mainPage260204.btnEstablecimiento.click();
                mainPage260204.buttonAceptar.click();

                //LLenado de datos
                mainPage260204.ResponsableSanitarioRFC.sendKeys("VLIO230414MC5");
                mainPage260204.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260204.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260204.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260204.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
                mainPage260204.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");
                mainPage260204.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");
                mainPage260204.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");
                mainPage260204.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");
                mainPage260204.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");
                mainPage260204.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260204.btnAgregarScian.click();
                mainPage260204.selectComboScian.sendKeys("3111239");
                mainPage260204.btnAgregar2Scian.click();sleep(1000);
                //

                mainPage260204.checkAvisoFuncionamiento.click();
                mainPage260204.selectSolicitudRegimenClave.sendKeys("Temporales");
                mainPage260204.selectAduanasEntrada.sendKeys("LA PAZ");

                //Agregar Mercancia
                mainPage260204.btnAgregarAduana.click();
                mainPage260204.selectMercanciaGridClasificacionProducto.sendKeys("MEDICAMENTOS/FARMACO");
                mainPage260204.selectMercanciaGridEspecificaClasProd.sendKeys("I) Aloáticos");
                mainPage260204.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
                mainPage260204.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
                mainPage260204.inputDenominacionNombreCientif.sendKeys("Hemorivados Test Nombre Cientifico");
                mainPage260204.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
                mainPage260204.comboFormaFarmaceutica.sendKeys("Tabletas");
                mainPage260204.comboEstadoFisico.sendKeys("Solido");
                //mainPage260204.Especifique.sendKeys("Liquido Especificado");
                mainPage260204.inputFraccionArancelaria.sendKeys("30049099");
                mainPage260204.inputCantidadUmt.sendKeys("100");
                mainPage260204.inputCantidadUmc.sendKeys("100");
                mainPage260204.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
                mainPage260204.PresentacionFarmaTipoEnvase.sendKeys("QA");

                //Pais de origen
                mainPage260204.btnDesplegarInfoPaisOrigen.click();
                mainPage260204.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260204.optionAntartida.click();
                mainPage260204.inputAdd.click();

                //Pais de procedencia
                mainPage260204.btnDesplegarInfoPaisProcedencia.click();
                mainPage260204.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
                mainPage260204.MenuPaisesProcedencia.selectOptionByValue("CYM");
                mainPage260204.inputAdd2.click();

                //Uso especifico
                mainPage260204.btnDesplegarInfoUsoEspecifico.click();
                mainPage260204.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260204.MenuUsoEspecifico.selectOptionByValue("94");
                mainPage260204.inputAdd3.click();

                //Agregar la mercancia
                mainPage260204.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260204.checkCumploRequisitosYNormativas.click();
                mainPage260204.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260204.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260204.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                //Datos Generales
                mainPage260204.pestañaPaso1.scrollTo().shouldBe(visible);
                mainPage260204.tabTercerosRelacionados.click();
                mainPage260204.btnAgregarFabricante.click();
                mainPage260204.radNacionalTerceros.click();
                mainPage260204.radPersonaFisica.click();
                mainPage260204.FabricanteRFC.sendKeys("LEQI8101314S7");

                //Datos personales
                mainPage260204.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260204.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260204.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260204.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260204.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260204.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260204.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260204.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260204.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260204.inputTercerosNumExterior.sendKeys("10");
                mainPage260204.inputTercerosNumInterior.sendKeys("5");
                mainPage260204.inputTerceroLada.sendKeys("618");
                mainPage260204.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260204.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260204.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260204.btnAgregarDestinatario.click();
                mainPage260204.radPersonaFisica.click();
                mainPage260204.FabricanteRFC.sendKeys("LEQI8101314S7");
                //Datos personales
                mainPage260204.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260204.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260204.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260204.selectTercerosEstado.sendKeys("DURANGO");
                mainPage260204.selectTercerosMunicipio.sendKeys("DURANGO");
                mainPage260204.selectTercerosLocalidad.sendKeys("15 DE MAYO");
                mainPage260204.selectTercerosCodPostal.selectOptionByValue("34001");
                mainPage260204.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
                mainPage260204.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260204.inputTercerosNumExterior.sendKeys("10");
                mainPage260204.inputTercerosNumInterior.sendKeys("5");
                mainPage260204.inputTerceroLada.sendKeys("618");
                mainPage260204.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260204.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260204.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260204.btnAgregarProveedor.click();
                mainPage260204.radPersonaFisica.click();
                //Datos personales
                mainPage260204.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260204.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260204.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260204.listTercerosPais.selectOptionByValue("CAN");
                mainPage260204.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260204.CodigoPostaltxt.sendKeys("34001");
                mainPage260204.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260204.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260204.inputTercerosNumExterior.sendKeys("10");
                mainPage260204.inputTercerosNumInterior.sendKeys("5");
                mainPage260204.inputTerceroLada.sendKeys("618");
                mainPage260204.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260204.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260204.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260204.btnAgregarFacturador.click();
                mainPage260204.radPersonaFisica.click();
                //Datos personales
                mainPage260204.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260204.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260204.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260204.listTercerosPais.selectOptionByValue("CAN");
                mainPage260204.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260204.CodigoPostaltxt.sendKeys("34001");
                mainPage260204.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260204.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260204.inputTercerosNumExterior.sendKeys("10");
                mainPage260204.inputTercerosNumInterior.sendKeys("5");
                mainPage260204.inputTerceroLada.sendKeys("618");
                mainPage260204.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260204.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260204.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260204.pestañaPaso1.scrollTo().shouldBe(visible);
                mainPage260204.tabPagoDerechos.click();
                mainPage260204.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260204.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260204.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260204.inpLLavePago.sendKeys(llavePago);sleep(1000);
                Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage260204.FechaPago); sleep(1000);
                mainPage260204.ImportePago.sendKeys("100");
                mainPage260204.btnContinuarDatosCompletos.click();

                sleep(1000);
                //Paso2
                mainPage260204.btnContinuarPaso2.click();

                //Paso 3
                mainPage260204.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260204.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260204.btnAdjuntar2.click();sleep(7000);
                mainPage260204.btnCerrar3.click();sleep(1000);

                //Paso 3 (Continuacion)
                //mainPage260204.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260204.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260204.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260204.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260204.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260204.listDocumento6Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                mainPage260204.btnContinuar3.click();sleep(1000);

                //Firma
                loginFirmSoli.firma(tramite260204);sleep(4000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage260204.folio.getText();

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

