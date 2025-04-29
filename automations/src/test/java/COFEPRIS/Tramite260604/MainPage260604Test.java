package COFEPRIS.Tramite260604;

import COFEPRIS.Tramite260604.MainPage260604;
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

public class MainPage260604Test {


        MainPage260604 mainPage260604 = new MainPage260604();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        TramitesFirmasLG tramite260604  = new TramitesFirmasLG(
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
        public void Proceso260604() throws IOException {
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

                // Obtener la fecha de hoy formateada Más 10 días
                LocalDate hoy = LocalDate.now();
                LocalDate hoyMasDiez = hoy.plusDays(10);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaHoyMasDiez = hoyMasDiez.format(formatter);

                //Loging y Seleccion Rol
                loginFirmSoli.login(tramite260604);
                mainPage260604.selecRol.sendKeys("Persona Moral"); sleep(1000);
                mainPage260604.btnacep.click();sleep(1000);

                //Busqueda de tramite
                mainPage260604.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
                mainPage260604.SoliNew.click();//sleep(1000);
                mainPage260604.Cofepris.click();//sleep(1000);
                mainPage260604.CertificadosLicenciasPermisos.click();//sleep(1000);
                mainPage260604.AvisoSanitario.click();//sleep(1000);
                mainPage260604.Tramite260604.click();

                //Datos de solicitud
                mainPage260604.Scrol.scrollTo();
                mainPage260604.DatosSolicitud.click();
                mainPage260604.btnEstablecimiento.click();
                mainPage260604.buttonAceptar.click();

                //LLenado de datos
                mainPage260604.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
                mainPage260604.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

                //Domicilio del establecimiento
                mainPage260604.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
                mainPage260604.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("AGUASCALIENTES");
                mainPage260604.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("El Llano");
                mainPage260604.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Llano Localidad Test");
                mainPage260604.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia");
                mainPage260604.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Ignacio Zaragoza");
                mainPage260604.inputSolicitudEstablecimientoDomicilioLada.sendKeys("449");
                mainPage260604.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");sleep(1000);

                //Agregar SCIAN
                mainPage260604.btnAgregarScian.click();
                mainPage260604.selectComboScian.sendKeys("311311");
                mainPage260604.btnAgregar2Scian.click();sleep(1000);

                //Continuacion Datos generales
                mainPage260604.checkAvisoFuncionamiento.click();
                mainPage260604.selectAduanasEntrada.sendKeys("CIUDAD ACUÑA");

                //Agregar Mercancia
                mainPage260604.btnAgregarMercancia.click();
                mainPage260604.selectMercanciaClasificacionProducto.sendKeys("PRECURSORES QUIMICOS");
                mainPage260604.selectMercanciaEspecificaClasProd.sendKeys("No Aplica");
                mainPage260604.MarcaDenominacionDistintiva.sendKeys("Marca QA");
                mainPage260604.selectMercanciaTipoProducto.sendKeys("Envase/material de empaque");
                mainPage260604.DenominacionGenericaDCI.sendKeys("Denominacion QA DCI");
                mainPage260604.selectEstadoFisico.sendKeys("Solido");
                mainPage260604.inputFraccionArancelaria.sendKeys("28047004");
                mainPage260604.inputCantidadUmc.sendKeys("10");
                mainPage260604.selectMercanciaGridUnidadMedida.sendKeys("Gramo");
                mainPage260604.PorcentajeConcentracion.sendKeys("10");
                mainPage260604.ValorComercial.sendKeys("10");
                executeJavaScript("arguments[0].value = '" + fechaHoyMasDiez + "';", mainPage260604.fechaImporExpor); sleep(1000);
                mainPage260604.PresentacionTipoEnvase.sendKeys("QA presentación");
                mainPage260604.selectPaisDestino.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
                mainPage260604.selectPaisOrigen.sendKeys("AUSTRALIA (COMUNIDAD DE)");
                //Uso especifico
                mainPage260604.btnDesplegarInfoUsoEspecifico.click();
                mainPage260604.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
                mainPage260604.selectUsoEspecifico.selectOption("DONACIONES");
                mainPage260604.inputAdd3.click();
                //Agregar la mercancia
                mainPage260604.btnAgregarMercanciaTotalInfo.click();

                //manifiesto y declaraciones
                mainPage260604.radNoHacerPublicoInformacion.click();
                //Repesentante legal
                mainPage260604.RepresentanteRFC.sendKeys("MAVL621207C95");
                mainPage260604.btnBuscarRepresentante.click();

                //TERCEROS RELACIONADOS
                //Datos Generales
                mainPage260604.Scrol.scrollTo().shouldBe(visible);
                mainPage260604.tabTercerosRelacionados.click();

                //Agregar facturador
                mainPage260604.btnAgregarFacturador.click();
                mainPage260604.radPersonaFisica.click();
                //Datos personales
                mainPage260604.inputTercerosNombre.sendKeys("MISAEL");
                mainPage260604.inputTercerosApellidoPaterno.sendKeys("BARRAGAN");
                mainPage260604.inputTercerosApellidoMaterno.sendKeys("RUIZ");
                mainPage260604.TercerosEstadotxt.sendKeys("DURANGO");
                mainPage260604.CodigoPostaltxt.sendKeys("34001");
                mainPage260604.inputTercerosCalle.sendKeys("Calle Durango QA");
                mainPage260604.inputTercerosNumExterior.sendKeys("10");
                mainPage260604.inputTercerosNumInterior.sendKeys("5");
                mainPage260604.inputTerceroLada.sendKeys("618");
                mainPage260604.inputTercerosTelefono.sendKeys("618-813-6670");
                mainPage260604.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
                mainPage260604.buttonGuardarDatosTercero.click();
                sleep(1000);
                mainPage260604.btnGuardar.click();
                //Paso2
                mainPage260604.btnContinuarPaso2.click();

                //Paso 3
                mainPage260604.btnAdjuntarDoc.click();sleep(1000);

                //Sub Paso 3
                mainPage260604.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
                mainPage260604.btnAdjuntar2.click();sleep(1000);
                mainPage260604.btnCerrar3.click();sleep(1000);

                //Paso 3 (Continuacion)
                //mainPage260604.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
                mainPage260604.btnContinuar3.click();sleep(1000);

                //Firma
                loginFirmSoli.firma(tramite260604);sleep(4000);

                // Obtener el texto del folio
                String folioText = mainPage260604.folio.getText();

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

