package COFEPRIS.Tramite260210;

import COFEPRIS.Tramite260210.MainPage260210;
import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260210Test {
    MainPage260210 mainPage260210 = new MainPage260210();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite260210 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260210Fun = new TramitesFirmasLG(
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
    public void Proceso260210() throws IOException {
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
            loginFirmSoli.login(tramite260210);
            mainPage260210.selecRol.sendKeys("Persona Moral");
            sleep(1000);
            mainPage260210.btnacep.click();
            sleep(1000);

            //Busqueda de tramite
            mainPage260210.Tramites.sendKeys("Solicitudes nuevas");//sleep(1000);
            mainPage260210.SoliNew.click();//sleep(1000);
            mainPage260210.Cofepris.click();//sleep(1000);
            mainPage260210.CertificadosLicenciasPermisos.click();//sleep(1000);
            mainPage260210.PermisoSanitarioImportaciInsumosSalud.click();//sleep(1000);
            mainPage260210.Tramite260210.click();
            sleep(1000);

            //Datos de solicitud
            mainPage260210.LogoVuc.scrollTo().shouldBe(visible);
            mainPage260210.DatosSolicitud.click();

            mainPage260210.btnEstablecimiento.click();
            mainPage260210.buttonAceptar.click();

            mainPage260210.ResponsableSanitarioRFC.sendKeys("AAL0409235E6");
            mainPage260210.inputSolicitudEstablecimientoRazonSocial.sendKeys("RazonTest");
            mainPage260210.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("Test@gmail.com");

            mainPage260210.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("607059");
            mainPage260210.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260210.inputSolicitudEstablecimientoDomicilioMunicipioAlcadia.sendKeys("Santa ursula");
            mainPage260210.inputSolicitudEstablecimientoDomicilioLocalidad.sendKeys("Localidad Test");
            mainPage260210.getInputSolicitudEstablecimientoDomicilioColonia.sendKeys("Colonia Ursula");
            mainPage260210.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Calle QA");
            mainPage260210.inputSolicitudEstablecimientoDomicilioLada.sendKeys("55");
            mainPage260210.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5091222233");
            sleep(1000);

            mainPage260210.btnAgregarScian.click();
            mainPage260210.selectComboScian.sendKeys("3111239");
            mainPage260210.btnAgregar2Scian.click();
            sleep(1000);
            mainPage260210.checkAvisoFuncionamiento.click();
            mainPage260210.selectSolicitudRegimenClave.sendKeys("Definitivos");
            mainPage260210.selectAduanasEntrada.selectOption("VERACRUZ");

            mainPage260210.btnAgregarAduana.click();
            sleep(1000);
            mainPage260210.selectMercanciaGridClasificacionProducto.sendKeys("MEDICAMENTOS/FARMACO");
            mainPage260210.selectMercanciaGridEspecificaClasProd.sendKeys("II) Homeopáticos");
            mainPage260210.inputDenominacionEspecifica.sendKeys("Denominacion Especifica Test");
            mainPage260210.inputDenominacionDistintiva.sendKeys("Denominacion Distintiva test");
            mainPage260210.inputDenominacionNombreCientif.sendKeys("Hemorivados Test Nombre Cientifico");
            mainPage260210.selectMercanciaGridTipoProducto.sendKeys("Producto terminado");
            mainPage260210.comboFormaFarmaceutica.sendKeys("Capsulas");
            mainPage260210.comboEstadoFisico.sendKeys("Solido");
            mainPage260210.inputFraccionArancelaria.sendKeys("30039013");
            mainPage260210.inputCantidadUmt.sendKeys("100");
            mainPage260210.inputCantidadUmc.sendKeys("100");
            mainPage260210.selectMercanciaGridUnidadMedida.sendKeys("Kilogramo");
            mainPage260210.PresentacionFarmaTipoEnvase.sendKeys("QA");

            mainPage260210.btnDesplegarInfoPaisOrigen.click();
            mainPage260210.btnDesplegarInfoPaisOrigen.scrollTo().shouldBe(visible);
            mainPage260210.optionAntartida.click();
            mainPage260210.inputAdd.click();

            mainPage260210.btnDesplegarInfoPaisProcedencia.click();
            mainPage260210.btnDesplegarInfoPaisProcedencia.scrollTo().shouldBe(visible);
            mainPage260210.MenuPaisesProcedencia.selectOptionByValue("ATA");
            mainPage260210.inputAdd2.click();

            mainPage260210.btnDesplegarInfoUsoEspecifico.click();
            mainPage260210.btnDesplegarInfoUsoEspecifico.scrollTo().shouldBe(visible);
            mainPage260210.MenuUsoEspecifico.selectOption("ANÁLISIS O PRUEBAS DE LABORATORIO");
            mainPage260210.inputAdd3.click();
            sleep(1000);

            mainPage260210.btnAgregarMercanciaTotalInfo.click();

            mainPage260210.checkCumploRequisitosYNormativas.click();
            mainPage260210.radNoHacerPublicoInformacion.click();
            mainPage260210.RepresentanteRFC.sendKeys("MAVL621207C95");
            mainPage260210.btnBuscarRepresentante.click();

            mainPage260210.pestañaPaso1.scrollTo().shouldBe(visible);
            mainPage260210.tabTercerosRelacionados.click();
            mainPage260210.btnAgregarFabricante.click();
            mainPage260210.radNacionalTerceros.click();
            mainPage260210.radPersonaMoral.click();
            mainPage260210.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA");
            mainPage260210.FabricanteRFC.sendKeys("AAL0409235E6");

            mainPage260210.selectTercerosEstado.sendKeys("CIUDAD DE MÉXICO");
            mainPage260210.selectTercerosMunicipio.sendKeys("GUSTAVO A MADERO");
            mainPage260210.selectTercerosLocalidad.selectOption("UNIDAD HABITACIONAL EL COYOL 2");
            mainPage260210.selectTercerosCodPostal.selectOptionByValue("07000");
            mainPage260210.selectTercerosColonia.sendKeys("15 DE AGOSTO");
            mainPage260210.inputTercerosCalle.sendKeys("Calle QA");
            mainPage260210.inputTercerosNumExterior.sendKeys("10");
            mainPage260210.inputTercerosNumInterior.sendKeys("5");
            mainPage260210.inputTerceroLada.sendKeys("55");
            mainPage260210.inputTercerosTelefono.sendKeys("551-087-907");
            mainPage260210.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
            mainPage260210.buttonGuardarDatosTercero.click();

            mainPage260210.btnAgregarDestinatario.click();
            mainPage260210.radPersonaMoral.click();
            mainPage260210.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA Destinatario");
            mainPage260210.FabricanteRFC.sendKeys("AAL0409235E6");

            mainPage260210.selectTercerosEstado.sendKeys("DURANGO");
            mainPage260210.selectTercerosMunicipio.sendKeys("DURANGO");
            mainPage260210.selectTercerosLocalidad.sendKeys("15 DE MAYO");
            mainPage260210.selectTercerosCodPostal.selectOptionByValue("34001");
            mainPage260210.selectTercerosColonia.sendKeys("12 DE DICIEMBRE");
            mainPage260210.inputTercerosCalle.sendKeys("Calle Durango QA");
            mainPage260210.inputTercerosNumExterior.sendKeys("10");
            mainPage260210.inputTercerosNumInterior.sendKeys("5");
            mainPage260210.inputTerceroLada.sendKeys("618");
            mainPage260210.inputTercerosTelefono.sendKeys("618-813-6670");
            mainPage260210.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
            mainPage260210.buttonGuardarDatosTercero.click();

            mainPage260210.btnAgregarProveedor.click();
            mainPage260210.radPersonaMoral.click();
            mainPage260210.inputTercerosDenominacionRazon.sendKeys("Denominación/Razón QA PROVEDOR");

            mainPage260210.listTercerosPais.selectOptionByValue("CAN");
            mainPage260210.TercerosEstadotxt.sendKeys("DURANGO");
            mainPage260210.CodigoPostaltxt.sendKeys("34001");
            mainPage260210.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
            mainPage260210.inputTercerosCalle.sendKeys("Calle Durango QA");
            mainPage260210.inputTercerosNumExterior.sendKeys("10");
            mainPage260210.inputTercerosNumInterior.sendKeys("5");
            mainPage260210.inputTerceroLada.sendKeys("618");
            mainPage260210.inputTercerosTelefono.sendKeys("618-813-6670");
            mainPage260210.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
            mainPage260210.buttonGuardarDatosTercero.click();

            mainPage260210.btnAgregarFacturador.click();
            mainPage260210.radPersonaMoral.click();
            mainPage260210.inputTercerosDenominacionRazon.sendKeys("QA FACTURADOR");

            mainPage260210.listTercerosPais.selectOptionByValue("CAN");
            mainPage260210.TercerosEstadotxt.sendKeys("DURANGO");
            mainPage260210.CodigoPostaltxt.sendKeys("34001");
            mainPage260210.TercerosColoniatxt.sendKeys("12 DE DICIEMBRE");
            mainPage260210.inputTercerosCalle.sendKeys("Calle Durango QA");
            mainPage260210.inputTercerosNumExterior.sendKeys("10");
            mainPage260210.inputTercerosNumInterior.sendKeys("5");
            mainPage260210.inputTerceroLada.sendKeys("618");
            mainPage260210.inputTercerosTelefono.sendKeys("618-813-6670");
            mainPage260210.inputTercerosCorreoElec.sendKeys("vucem2.5@hotmail.com");
            mainPage260210.buttonGuardarDatosTercero.click();

            //PAGO DERECHOS
            mainPage260210.pestañaPaso1.scrollTo().shouldBe(visible);
            mainPage260210.tabPagoDerechos.click();
            mainPage260210.ClaveReferencia.sendKeys("284000255");
            sleep(1000);
            mainPage260210.CadenaDependencia.sendKeys("0111514EC10303");
            mainPage260210.listBanco.sendKeys("BANCA MIFEL");
            sleep(1000);
            mainPage260210.inpLLavePago.sendKeys(llavePago);
            sleep(1000);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage260210.FechaPago);
            sleep(1000);
            mainPage260210.ImportePago.sendKeys("100");
            mainPage260210.btnContinuarDatosCompletos.click();
            sleep(1000);
            mainPage260210.btnContinuarPaso2.click();

            metodos.cargarDocumentos();
            mainPage260210.btnAdjuntar2.click();sleep(7000);
            mainPage260210.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(180));sleep(1000);
            mainPage260210.btnCerrar3.click();
            sleep(1000);
            mainPage260210.btnContinuar3.click();
            sleep(1000);
            loginFirmSoli.firma(tramite260210);
            sleep(4000);
            String folioText = mainPage260210.folio.getText();
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            if (selectedMethods.contains("ProcesoDictamen")) {
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

    public void ProcesoGenerarDictamen(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        loginFirmSoli.loginFun(tramite260210Fun);
        sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260210.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260210.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();
        sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260210.destinadoPara.sendKeys("Acondicionamiento");
        mainPage260210.restricciones.sendKeys(" PREVIO ASEGURAMIENTO Y MUESTREO (PRESERVATIVOS)");
        mainPage260210.observaciones.sendKeys("EL CORRECTO EMPLEO DEL PRODUCTO A IMPORTAR ES RESPONSABILAD DE QUIEN LO USA");
        mainPage260210.plazo.sendKeys("180");
        mainPage260210.siglasDictaminador.sendKeys("MAVL");
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260210.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260210Fun);
        sleep(5000);
    }

    public void ProcesoVerificarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260210.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260210.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260210.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260210Fun);
        sleep(5000);
    }

    public void ProcesoAutorizarDictamen(String folioNumber) {
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260210.numfolio.sendKeys(folioNumber);
        sleep(5000);
        mainPage260210.btnBuscarFolio.doubleClick();
        sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260210.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260210Fun);
        sleep(5000);
    }

    public void ProcesoConfirmarNotificacion(String folioNumber) {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260210);
        mainPage260210.selecRol.sendKeys("Persona Moral");
        mainPage260210.btnacep.click();
        mainPage260210.inicioFolio.sendKeys(folioNumber);
        sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260210.btnContinuarConfirmacion.click();
        sleep(1000);
        loginFirmSoli.firma(tramite260210);
        sleep(1000);
        sleep(4000);
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

