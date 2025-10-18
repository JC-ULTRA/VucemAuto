package COFEPRIS.Tramite260215;

import COFEPRIS.Tramite260215.MainPage260215;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage260215Test {
    MainPage260215 mainPage260215 = new MainPage260215();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite260215  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );
    TramitesFirmasLG tramite260215Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        iniDriver();
    }

    public static void iniDriver(){
        Configuration.browser = Browsers.CHROME;
        open();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso260215() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen260215");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion260215");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion260215");

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

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite260215);
            mainPage260215.selecRol.sendKeys("Persona Moral");
            mainPage260215.btnacep.click();
            mainPage260215.Tramites.sendKeys("Solicitudes nuevas");
            mainPage260215.SoliNew.click();
            mainPage260215.Cofepris.click();
            mainPage260215.linkCertificadosLicenciasPermisos.click();
            mainPage260215.linkPermisoSanitarioImportacionInsumoSalud.click();
            mainPage260215.linkInvestigacionHumanos.click();
            //DATOS SOLICITUD
            mainPage260215.labelDatosSolicitud.click();
            mainPage260215.inputEstablecimiento.click();
            mainPage260215.btnAceptar.click();
            mainPage260215.inputSolicitudEstablecimientoResponsableSanitario.sendKeys("AAL0409235E6");
            mainPage260215.inputSolicitudEstablecimientoRazonSocial.sendKeys("PRUEBA SA DE CV");
            mainPage260215.inputSolicitudEstablecimientoCorreoElectronico.sendKeys("correo@ejemplo.com");
            mainPage260215.inputSolicitudEstablecimientoDomicilioCodigo.sendKeys("01234");
            mainPage260215.selectSolicitudEstablecimientoDomicilioEntidad.sendKeys("CIUDAD DE MÉXICO");
            mainPage260215.inputSolicitudEstablecimientoDomicilioDescripcion.sendKeys("Benito Juárez");
            mainPage260215.inputSolicitudEstablecimientoDomicilioInformacion.sendKeys("Cerca del parque");
            mainPage260215.inputSolicitudEstablecimientoDomicilioDescripcion2.sendKeys("Del Valle");
            mainPage260215.inputSolicitudEstablecimientoDomicilioCalle.sendKeys("Insurgentes Sur");
            mainPage260215.inputSolicitudEstablecimientoDomicilioTelefono.sendKeys("5555555555");
            mainPage260215.inputScianAgregar.click();
            mainPage260215.comboSCIAN.selectOption("311239");
            mainPage260215.inputAgregar.click();
            mainPage260215.inputAvisoFuncionamiento.click();
            mainPage260215.solicitudRegimen.sendKeys("Definitivos");
            mainPage260215.aduanaEntrada.selectOption("CIUDAD HIDALGO");
            mainPage260215.inputAgregarAduana.click();
            mainPage260215.selectClasificacionProducto.sendKeys("REMEDIOS HERBOLARIOS ");
            mainPage260215.selectSubClasificacionProducto.sendKeys("No aplica");
            mainPage260215.inputDenominacionEspecifica.sendKeys("Denominación específica de prueba");
            mainPage260215.inputDenominacionDistintiva.sendKeys("Distintiva123");
            mainPage260215.inputDenominacionComunInternacional.sendKeys("DCI-TEST");
            mainPage260215.selectTipoProductoTipoTramite.sendKeys("Producto a granel");
            mainPage260215.selectEstadoFisico.sendKeys("Liquido");
            mainPage260215.inputFraccionArancelaria.sendKeys("30039013");
            mainPage260215.inputCantidadUMT.sendKeys("100");
            mainPage260215.inputCantidadUMC.sendKeys("10");
            mainPage260215.selectUnidadMedidaComercial.sendKeys("Kilogramos");
            mainPage260215.textareaPresentacion.sendKeys("Presentación del producto");
            mainPage260215.buttonAbrirPanelPaisesOrigen.click();
            mainPage260215.PaisOrigen.selectOptionContainingText("ANGOLA (REPUBLICA DE)");
            mainPage260215.inputAgregarSeleccion.click();
            mainPage260215.inputAbrirPanelPaisesProcedencia.click();
            mainPage260215.PaisProcedencia.selectOptionContainingText("ARABIA SAUDITA (REINO DE)");
            mainPage260215.inputAgregarSeleccion2.click();
            mainPage260215.botonAbrirPanelUsosEspecificos.click();
            mainPage260215.UsoEspecifico.sendKeys("INVESTIGACIÓN CIENTÍFICA");
            mainPage260215.botonAgregarSeleccion.click();
            mainPage260215.inputAgregarMercancia.click();
            mainPage260215.inputDeclaracion.click();
            mainPage260215.inputInformacionConfidencialNo.click();
            mainPage260215.inputRepresentanteLegalRFC.sendKeys("MAVL621207C95");
            mainPage260215.inputConsultarIDC.click();
            //TERCEROS RELACIONADOS
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage260215.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage260215.labelTerceroRElacionado.click();
            //FABRICANTE
            mainPage260215.inputAgregarFabricante.click();
            mainPage260215.inputNacionalidadMexicana.click();
            mainPage260215.inputPErsonaMoral.click();
            mainPage260215.inputTerceroRFC.sendKeys("AAL0409235E6");
            mainPage260215.inputTerceroRazonSocial.sendKeys("PRUEBAS SA DE CV");
            //mainPage260215.inputPais.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260215.terceroEstado.sendKeys("CIUDAD DE MÉXICO");
            mainPage260215.terceroMunicipio.sendKeys("XOCHIMILCO");
            mainPage260215.terceroLocalidad.sendKeys("EL CEDRAL");
            mainPage260215.terceroCodigoPostal.sendKeys("16000");
            mainPage260215.terceroColonia.sendKeys("ACOCA");
            mainPage260215.terceroCalle.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260215.terceroNumExterior.sendKeys("123");
            mainPage260215.terceroNumInterior.sendKeys("4B");
            mainPage260215.terceroTelefono.sendKeys("5555555555");
            mainPage260215.terceroCorreo.sendKeys("contacto@fabricante.com");
            //DESTINATARIO
            mainPage260215.btnGuardarDatosTerceros.click();
            mainPage260215.inputAgregarDestinatario.click();
            mainPage260215.inputTipoPeronaMoral.click();
            mainPage260215.inputTerceroRFC2.sendKeys("AAL0409235E6");
            mainPage260215.inputTerceroRazonSocial2.sendKeys("AGRICOLA ALPE, S DE RL DE CV");
            mainPage260215.terceroEstado2.sendKeys("CIUDAD DE MÉXICO");
            mainPage260215.terceroMunicipio2.sendKeys("CUAUHTEMOC");
            mainPage260215.terceroLocalidad2.sendKeys("CUAUHTEMOC");
            mainPage260215.terceroCodigoPostal2.sendKeys("06278");
            mainPage260215.terceroColonia2.sendKeys("BUENAVISTA");
            mainPage260215.terceroCalle2.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260215.terceroNumExterior2.sendKeys("123");
            mainPage260215.terceroNumInterior2.sendKeys("4B");
            mainPage260215.terceroTelefono2.sendKeys("5555555555");
            mainPage260215.terceroCorreo2.sendKeys("contacto@fabricante.com");
            mainPage260215.btnGuardarDatosTercero2.click();
            //PROVEEDOR
            mainPage260215.inputAgregarProveedor.click();
            mainPage260215.inputTipoPeronaFisica.click();
            mainPage260215.inputTerceroNombre3.sendKeys("PEDRO");
            mainPage260215.inputTerceroApePAter3.sendKeys("PARAMO");
            mainPage260215.inputTerceroApeMAter3.sendKeys("PEREZ");
            mainPage260215.inputPais3.sendKeys("LUXEMBURGO (GRAN DUCADO DE)");
            mainPage260215.terceroEstadoLocalidad3.sendKeys("LUXEMBURGO");
            mainPage260215.terceroCodigoPostal3.sendKeys("00000");
            mainPage260215.terceroColoniaEquiv3.sendKeys("10 DE ABRIL");
            mainPage260215.terceroCalle3.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260215.terceroNumExterior3.sendKeys("123");
            mainPage260215.terceroNumInterior3.sendKeys("4B");
            mainPage260215.terceroTelefono3.sendKeys("5555555555");
            mainPage260215.terceroCorreo3.sendKeys("contacto@fabricante.com");
            mainPage260215.btnGuardarDatosTercero3.click();
            //FACTURADOR
            mainPage260215.inputAgregarFacturador.click();
            mainPage260215.inputTipoPersonaMoral4.click();
            mainPage260215.inputTerceroRazonSocial4.sendKeys("PRUEBA AUTOMATIZADA");
            mainPage260215.inputPais4.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");
            mainPage260215.terceroEstadoLocalidad4.sendKeys("AMSTERDAM");
            mainPage260215.terceroCodigoPostal4.sendKeys("00000");
            mainPage260215.terceroColoniaEquiv4.sendKeys("10 DE ABRIL");
            mainPage260215.terceroCalle4.sendKeys("Eje Central Lázaro Cárdenas");
            mainPage260215.terceroNumExterior4.sendKeys("123");
            mainPage260215.terceroNumInterior4.sendKeys("4B");
            mainPage260215.terceroTelefono4.sendKeys("5555555555");
            mainPage260215.terceroCorreo4.sendKeys("contacto@fabricante.com");
            mainPage260215.btnGuardarDatosTercero4.click();


            //PAGO DE DERECHOS
            mainPage260215.labelPagoDerechos.click();
            mainPage260215.inputSolicitudPagoClaveReferencia.sendKeys("85434563");
            mainPage260215.inputSolicitudPagoCadenaDependencia.sendKeys("uaiusjjsdga");
            mainPage260215.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            mainPage260215.inputSolicitudPagoLlave.sendKeys(llavePago);
            mainPage260215.inputSolicitudPagoImp.sendKeys("2000");
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage260215.inputCalendar);sleep(100);
            mainPage260215.inputGuardarSolicitud.click();
            //GUARDAR
            mainPage260215.inputGuarda.click();sleep(1000);
            mainPage260215.inputAdjuntar.click();
            mainPage260215.selectDoc.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260215.selectDoc2.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260215.selectDoc3.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260215.selectDoc4.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260215.selectDoc5.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            //mainPage260215.selectDoc6.sendKeys("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage260215.btnAnexar.click();sleep(20000);
            mainPage260215.btnCerrar.click();
            mainPage260215.inputSiguiente.click();
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite260215);
            String folioText = mainPage260215.folio.getText();sleep(5000);
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
        loginFirmSoli.loginFun(tramite260215Fun);sleep(5000);
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        mainPage260215.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260215.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Evaluar Solicitud")).doubleClick();
        $("input[name='opcion'][value='?mostrarDictamen=']").click();
        $("input[name='mostrar'][value='Continuar']").click();sleep(2000);
        $("input[name='sentidoDictamen'][value='SEDI.AC']").click();
        mainPage260215.destinadoPara.sendKeys("Acondicionamiento");
        mainPage260215.restricciones.sendKeys(" PREVIO ASEGURAMIENTO Y MUESTREO (PRESERVATIVOS)");
        mainPage260215.observaciones.sendKeys("EL CORRECTO EMPLEO DEL PRODUCTO A IMPORTAR ES RESPONSABILAD DE QUIEN LO USA");
        mainPage260215.plazo.sendKeys("180");
        mainPage260215.siglasDictaminador.sendKeys("MAVL");
        $("#tramite\\.dictamen\\.numeroGenerico1").selectOption(1);
        mainPage260215.firmarDictamen.click();
        loginFirmSoli.firmaFun(tramite260215Fun);sleep(5000);
    }
    public void ProcesoVerificarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260215.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260215.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Verificar Dictamen")).doubleClick();
        mainPage260215.darVoBo.click();
        loginFirmSoli.firmaFun(tramite260215Fun);sleep(5000);
    }
    public void ProcesoAutorizarDictamen(String folioNumber){
        $(By.cssSelector("img[src*='icoInicio.png']")).click();
        ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
        mainPage260215.numfolio.sendKeys(folioNumber);sleep(5000);
        mainPage260215.btnBuscarFolio.doubleClick();sleep(10500);
        $$("td[role='gridcell']").findBy(attribute("title", "Autorizar Dictamen")).doubleClick();
        mainPage260215.firmarAutorizacion.click();
        loginFirmSoli.firmaFun(tramite260215Fun);sleep(5000);
    }
    public void ProcesoConfirmarNotificacion(String folioNumber){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite260215);
        mainPage260215.selecRol.sendKeys("Persona Moral");
        mainPage260215.btnacep.click();
        mainPage260215.inicioFolio.sendKeys(folioNumber);sleep(2500);
        $("input[type='button'][value='Buscar']").click();
        metodos.scrollIncremento(1);
        $$(By.cssSelector("td[role='gridcell']")).findBy(Condition.text(folioNumber)).doubleClick();
        mainPage260215.btnContinuarConfirmacion.click();sleep(1000);
        loginFirmSoli.firma(tramite260215);sleep(1000);sleep(4000);
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
