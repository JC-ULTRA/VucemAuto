package COFEPRIS.Tramite260203;

import COFEPRIS.Tramite260203.MainPage260203;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260203Test {


        MainPage260203 mainPage260203 = new MainPage260203();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        TramitesFirmasLG tramite260203  = new TramitesFirmasLG(
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
        public void Proceso260203() throws IOException {
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
                loginFirmSoli.login(tramite260203);
                mainPage260203.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260203.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260203.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260203.SoliNew.click();//sleep(1000);
                mainPage260203.Cofepris.click();//sleep(1000);
                mainPage260203.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260203.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
                mainPage260203.Tramite260203.click();sleep(10000);

                //Datos de solicitud
                mainPage260203.Scrol.scrollTo();
                mainPage260203.DatosSolicitud.click();

                mainPage260203.btnEstablecimiento.click();
                mainPage260203.buttonAceptar.click();

                //LLenado de datos
                mainPage260203.ResponsableSanitarioRFC.sendKeys("VLIO230414MC5");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");sleep(5000);

                //Domicilio del establecimiento
                mainPage260203.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");sleep(5000);
                mainPage260203.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");sleep(5000);
                mainPage260203.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");sleep(5000);
                mainPage260203.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);sleep(5000);

                //Agregar SCIAN
                mainPage260203.btnAgregarScian.click();
                mainPage260203.selectComboScian.sendKeys("3111239");
                mainPage260203.btnAgregar2Scian.click();sleep(1000);
                //

                mainPage260203.checkAvisoFuncionamiento.click();
                mainPage260203.selectSolicitudRegimenClave.sendKeys("Temporales");
                mainPage260203.selectAduanasEntrada.sendKeys("LA PAZ");

                //Agregar Mercancia
                mainPage260203.btnAgregarAduana.click();
                mainPage260203.selectMercanciaClasificacionProducto.sendKeys("DISPOSITIVOS MEDICOS");sleep(5000);
                mainPage260203.selectMercanciaEspecificaClasProd.sendKeys("III) Agentes de diagnóstico.");sleep(5000);
                mainPage260203.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
                mainPage260203.inputDenominacionNombreCientif.sendKeys("Denominación Test Nombre Cientifico");sleep(5000);
                mainPage260203.selectMercanciaTipoProducto.sendKeys("Materia Prima");sleep(5000);
                mainPage260203.selectFormaFarmaceutica.sendKeys("Capsulas");sleep(5000);
                mainPage260203.selectEstadoFisico.sendKeys("Solido");sleep(5000);
                mainPage260203.inputFraccionArancelaria.sendKeys("30042002");sleep(5000);
                mainPage260203.inputCantidadUmt.sendKeys("10");sleep(5000);
                mainPage260203.inputCantidadUmc.sendKeys("10");sleep(5000);
                mainPage260203.selectMercanciaGridUnidadMedida.sendKeys("Botellas");sleep(5000);

                //Pais de origen
                mainPage260203.btnDesplegarInfoPaisOrigen.click();
                mainPage260203.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
                mainPage260203.selectPaisOrigen.selectOption("SWAZILANDIA (REINO DE)");
                mainPage260203.inputAdd.click();

                //Pais de procedencia
                mainPage260203.btnDesplegarInfoPaisProcedencia.click();
                mainPage260203.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);sleep(5000);
                mainPage260203.selectPaisProcedencia.selectOption("CANADA");sleep(5000);
                mainPage260203.selectPaisProcedencia.selectOption("CHILE (REPUBLICA DE)");sleep(5000);
                mainPage260203.inputAdd2.click();

                //Uso especifico
                mainPage260203.btnDesplegarInfoUsoEspecifico.click();sleep(5000);
                mainPage260203.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);sleep(5000);
                mainPage260203.selectUsoEspecifico.selectOption("ANÁLISIS O PRUEBAS DE LABORATORIO");sleep(5000);
                mainPage260203.inputAdd3.click();

                //Infromación General 2 Mercancia

                mainPage260203.selectFromaFarmaceutica.selectOption("Capsulas");sleep(5000);
                mainPage260203.MarcasDistintivas.sendKeys("Marcas QA");sleep(5000);
                mainPage260203.PresentacionFarmaceuticaTipoEnvase.sendKeys("Presentación QA");sleep(5000);
                mainPage260203.btnAgregarDetalleMercancia.click();

                //Agregar la mercancia
                mainPage260203.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260203.checkCumploRequisitosYNormativas.click();
                mainPage260203.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260203.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260203.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                //Datos Generales
                mainPage260203.Scrol.scrollTo().shouldBe(visible);sleep(5000);
                mainPage260203.tabTercerosRelacionados.click();sleep(5000);

                //Agregar Fabricante
                mainPage260203.btnAgregarFabricante.click();sleep(5000);
                mainPage260203.radNacionalTerceros.click();sleep(5000);
                mainPage260203.radPersonaFisica.click();sleep(5000);
                mainPage260203.FabricanteRFC.sendKeys("LEQI8101314S7");sleep(5000);
                //Datos personales
                mainPage260203.inputTercerosNombre.sendKeys("MISAEL");sleep(5000);
                mainPage260203.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");sleep(5000);
                mainPage260203.inputTercerosApellidoMaterno.sendKeys("RUIZ");sleep(5000);
                mainPage260203.selectTercerosEstado.sendKeys("DURANGO");sleep(5000);
                mainPage260203.selectTercerosMunicipio.sendKeys("DURANGO");sleep(5000);
                mainPage260203.selectTercerosLocalidad.sendKeys("15 DE MAYO");sleep(5000);
                mainPage260203.selectTercerosCodPostal.selectOptionByValue("34001");sleep(5000);
                mainPage260203.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");sleep(5000);
                mainPage260203.inputTercerosCalle.sendKeys("Calle Durango QA");sleep(5000);
                mainPage260203.inputTercerosNumExterior.sendKeys("10");sleep(5000);
                mainPage260203.inputTercerosNumInterior.sendKeys("5");sleep(5000);
                mainPage260203.inputTerceroLada.sendKeys("618");sleep(5000);
                mainPage260203.inputTercerosTelefono.sendKeys("618-813-6670");sleep(5000);
                mainPage260203.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");sleep(5000);
                mainPage260203.buttonGuardarDatosTercero.click();

                //Agregar Destinatario (Destino Final)
                mainPage260203.btnAgregarDestinatario.click();
                mainPage260203.radPersonaFisica.click();
                mainPage260203.FabricanteRFC.sendKeys("LEQI8101314S7");
                //Datos personales
                mainPage260203.inputTercerosNombre.sendKeys("MISAEL");sleep(5000);
                mainPage260203.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");sleep(5000);
                mainPage260203.inputTercerosApellidoMaterno.sendKeys("RUIZ");sleep(5000);
                mainPage260203.selectTercerosEstado.sendKeys("DURANGO");sleep(5000);
                mainPage260203.selectTercerosMunicipio.sendKeys("DURANGO");sleep(5000);
                mainPage260203.selectTercerosLocalidad.sendKeys("15 DE MAYO");sleep(5000);
                mainPage260203.selectTercerosCodPostal.selectOptionByValue("34001");sleep(5000);
                mainPage260203.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");sleep(5000);
                mainPage260203.inputTercerosCalle.sendKeys("Calle Durango QA");sleep(5000);
                mainPage260203.inputTercerosNumExterior.sendKeys("10");sleep(5000);
                mainPage260203.inputTercerosNumInterior.sendKeys("5");sleep(5000);
                mainPage260203.inputTerceroLada.sendKeys("618");sleep(5000);
                mainPage260203.inputTercerosTelefono.sendKeys("618-813-6670");sleep(5000);
                mainPage260203.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");sleep(5000);
                mainPage260203.buttonGuardarDatosTercero.click();


                //Agregar Proveedor
                mainPage260203.btnAgregarProveedor.click();
                mainPage260203.radPersonaFisica.click();
                //Datos personales
                mainPage260203.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260203.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260203.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260203.listTercerosPais.selectOptionByValue("CAN");
                mainPage260203.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260203.CodigoPostaltxt.sendKeys("34001");
                mainPage260203.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
                mainPage260203.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260203.inputTercerosNumExterior.sendKeys("10");
                mainPage260203.inputTercerosNumInterior.sendKeys("5");
                mainPage260203.inputTerceroLada.sendKeys("618");
                mainPage260203.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260203.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260203.buttonGuardarDatosTercero.click();

                //Agregar facturador
                mainPage260203.btnAgregarFacturador.click();
                mainPage260203.radPersonaFisica.click();
                //Datos personales
                mainPage260203.inputTercerosNombre.sendKeys("MISAEL");sleep(5000);
                mainPage260203.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");sleep(5000);
                mainPage260203.inputTercerosApellidoMaterno.sendKeys("RUIZ");sleep(5000);
                mainPage260203.listTercerosPais.selectOptionByValue("CAN");sleep(5000);
                mainPage260203.TercerosEstadotxt.sendKeys("DURANGO");sleep(5000);
                mainPage260203.CodigoPostaltxt.sendKeys("34001");sleep(5000);
                mainPage260203.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");sleep(5000);
                mainPage260203.inputTercerosCalle.sendKeys("Calle Durango QA");sleep(5000);
                mainPage260203.inputTercerosNumExterior.sendKeys("10");sleep(5000);
                mainPage260203.inputTercerosNumInterior.sendKeys("5");sleep(5000);
                mainPage260203.inputTerceroLada.sendKeys("618");sleep(5000);
                mainPage260203.inputTercerosTelefono.sendKeys("618-813-6670");sleep(5000);
                mainPage260203.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");sleep(5000);
                mainPage260203.buttonGuardarDatosTercero.click();

                //PAGO DERECHOS
                mainPage260203.pestañaPaso1.scrollTo().shouldBe(visible);
                mainPage260203.tabPagoDerechos.click();
                mainPage260203.ClaveReferencia.sendKeys("284000255");sleep(1000);
                mainPage260203.CadenaDependencia.sendKeys("0111514EC10303");
                mainPage260203.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
                mainPage260203.inpLLavePago.sendKeys(llavePago);sleep(5000);
                Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage260203.FechaPago); sleep(1000);
                mainPage260203.ImportePago.sendKeys("100");
                mainPage260203.btnContinuarDatosCompletos.click();

                sleep(1000);
                //Paso2
                mainPage260203.btnContinuarPaso2.click();

                //Paso 3
                mainPage260203.btnAdjuntarDoc.click();sleep(1000);

                //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
                //Sub Paso 3
                mainPage260203.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260203.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260203.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260203.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260203.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260203.btnSelecArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260203.btnSelecArchivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
                mainPage260203.btnAdjuntar2.click();sleep(7000);
                mainPage260203.btnCerrar3.click();sleep(1000);

                //Paso 3 (Continuacion)
                //mainPage260203.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.listDocumento6Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                //mainPage260203.btnContinuar3.click();sleep(1000);

                //Firma
                //loginFirmSoli.firma(tramite260203);sleep(4000);

                // Obtener el texto del folio desde mainPageB8
                //String folioText = mainPage260203.folio.getText();

                // Llamar al metodo para obtener el folio
                //String folioNumber = obtenerFolio.obtenerFolio(folioText);

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

