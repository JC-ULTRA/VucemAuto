package COFEPRIS.Tramite260204;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import COFEPRIS.Tramite260204.MainPage260204;
import Metodos.Metodos;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260204Test {
        Metodos metodos = new Metodos();
        MainPage260204 mainPage260204 = new MainPage260204();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
    String FunRFC = "MAVL621207C95";
        TramitesFirmasLG tramite260204  = new TramitesFirmasLG(
                "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
                "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
        );
    TramitesFirmasLG tramite260204Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");


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
            metodos.cargarDocumentos();
            mainPage260204.btnAdjuntar2.click();
            mainPage260204.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260204.btnCerrar3.doubleClick();sleep(1000);
            mainPage260204.btnContinuar3.click();sleep(1000);
            loginFirmSoli.firma(tramite260204);sleep(4000);
            String folioText = mainPage260204.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")){
                try {
                    setUpAll();
                    ProcesoGenerarDictamen(folioNumber);
                    ProcesoVerificarDictamen(folioNumber);
                    System.out.println("ProcesoDictamen completado. Pasando a Autorización...");

                    if (selectedMethods.contains("ProcesoAutorizacion")) {
                        ProcesoAutorizarDictamen(folioNumber);
                        System.out.println("ProcesoAutorizacion completado. Pasando a Confirmación...");

                        if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion")) {
                            ProcesoConfirmarNotificacion(folioNumber);
                            System.out.println("ProcesoConfirmarNotificaciónResolucion completado.");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("❌ ERROR: Falló un proceso en la secuencia. Deteniendo pasos subsiguientes para el folio " + folioNumber);
                    e.printStackTrace();
                }
            }
        }, repeticiones);
    }


    public void ProcesoGenerarDictamen(String folioNumber){
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite260204Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260204.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260204.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260204.destinadoPara.sendKeys("Acondicionamiento");
        mainPage260204.restricciones.sendKeys(" PREVIO ASEGURAMIENTO Y MUESTREO (PRESERVATIVOS)");
        mainPage260204.observaciones.sendKeys("EL CORRECTO EMPLEO DEL PRODUCTO A IMPORTAR ES RESPONSABILAD DE QUIEN LO USA");
        mainPage260204.plazo.sendKeys("180");
        mainPage260204.siglasDictaminador.sendKeys("MAVL");
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260204.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260204Fun);sleep(5000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260204.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260204.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260204.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260204Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260204.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260204.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260204.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260204Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260204);
        mainPage260204.selecRol.sendKeys("Persona Moral");
        mainPage260204.btnacep.click();
        mainPage260204.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260204.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260204);sleep(1000);sleep(4000);
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

