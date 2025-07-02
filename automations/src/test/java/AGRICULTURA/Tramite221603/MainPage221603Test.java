package AGRICULTURA.Tramite221603;

import AGRICULTURA.Tramite221603.MainPage221603;
import Metodos.Metodos;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Thread.sleep;

public class MainPage221603Test {
    MainPage221603 mainPage221603 = new MainPage221603();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite221603 = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso221603() {

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

            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25 || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);


            // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite221603);
            mainPage221603.selecRol.sendKeys("Persona Moral");
            Selenide.sleep(1000);
            mainPage221603.btnacep.click();
            Selenide.sleep(1000);

            //Búsqueda de trámite Subsecuente
            mainPage221603.Tramites.sendKeys("Solicitudes subsecuentes");
            mainPage221603.SoliSub.click();
            mainPage221603.FolioTramite.sendKeys(FolioTramiteN);
            mainPage221603.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage221603.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Solicitar Modificación y Prórroga
            mainPage221603.btnSolModificar.click();
            Selenide.sleep(2000);

            //Paso 1 CAPTURAR SOLICITUD
            mainPage221603.Scrol.scrollTo().shouldBe(visible);
            //Pestaña Datos de la Solicitud
            mainPage221603.DatosSolicitud.click();
            //Tipo de operación
            mainPage221603.Justificacion.setValue("QA justificación modificación");

            //Datos del trámite a realizar
            mainPage221603.numGuia.setValue("9376492");
            mainPage221603.regimen.selectOption("Temporales");

            //Agregar/Modificar Mercancía
            mainPage221603.gridMercancia1.click();
            mainPage221603.btnModificarMercancia.click();
            //Datos mercancía
            mainPage221603.requisito.setValue("2");
            mainPage221603.numCertificado.setValue("20");
            mainPage221603.fracArancelaria.selectOption("03061201");
            Selenide.sleep(1000);
            mainPage221603.NICO.selectOption("00");
            mainPage221603.descripcion.setValue("PRUEBAS MODIFICACIÓN");
            mainPage221603.cantUMT.setValue("5");
            mainPage221603.cantUMC.setValue("100");
            mainPage221603.tipoUMC.selectOption("Pieza");
            mainPage221603.tipoUso.selectOption("Otros");
            mainPage221603.numLote.setValue("23445");
            mainPage221603.faseDesarrollo.setValue("4");
            mainPage221603.especie.setValue("QA especie modificación");
            mainPage221603.paisOrigen.selectOption("UCRANIA");
            mainPage221603.paisProcedencia.selectOption("FINLANDIA (REPUBLICA DE)");
            //Detalle
            mainPage221603.nombreCientifico.setValue("Detalle nombre científico modificación");
            mainPage221603.btnAgregarDetalle.click();
            mainPage221603.btnModificacionInfoMercancia.click();

            //Pestaña Datos para movilización nacional
            mainPage221603.Scrol.click();
            mainPage221603.datosMovilizacionN.click();
            //Medio de transporte
            mainPage221603.medioTransporte.selectOption("Aéreo");
            mainPage221603.identificacionTransporte.setValue("QAM29304");
            mainPage221603.puntoVerificacion.selectOption("REGIÓN SUR, COSAMALOAPAN, VER.");
            mainPage221603.nombreTransportista.setValue("TRANSPORTES PRUEBA MODIFICACIÓN");

            //Pestaña Terceros relacionados
            mainPage221603.Scrol.scrollTo();
            mainPage221603.tercerosRelacionados.click();

            //Modificación Exportador
            mainPage221603.gridExportador1.click();
            mainPage221603.btnModificarExportador.click();
            //Tipo de persona exportador
            mainPage221603.personaMoral.click();
            //Datos personales
            mainPage221603.razonTercero.setValue("Razón social modficación");
            mainPage221603.paisTercero.selectOption("FINLANDIA (REPUBLICA DE)");
            mainPage221603.domicilioTercero.setValue("Torikatu 40, 39930 Karvia, Satakunta, Finland.");
            mainPage221603.ladaTercero.setValue("358");
            mainPage221603.telefonoTercero.setValue("5567208947");
            mainPage221603.correoTercero.setValue("exportadorFinlandQA@gmail.com");
            mainPage221603.guardarTercero.click();

            //Modificación Destinatario
            mainPage221603.gridDestinatario1.click();
            mainPage221603.btnModificarDestinatario.click();
            //Tipo de persona
            mainPage221603.personaMoral.click();
            //Datos personales
            mainPage221603.razonTercero.setValue("Modificación Denominación Destinatario");
            mainPage221603.cpTercero.setValue("95397");
            mainPage221603.estadoTercero.selectOption("VERACRUZ");
            mainPage221603.municipioTerceros.selectOption("COSAMALOAPAN DE CARPIO");
            mainPage221603.coloniaTercero.selectOption("LAS MARAVILLAS - CP 95397");
            mainPage221603.calleTercero.setValue("De la piedad");
            mainPage221603.numExt.setValue("30");
            mainPage221603.numInt.setValue("2");
            mainPage221603.ladaTercero.setValue("288");
            mainPage221603.telefonoTercero.setValue("5563745831");
            mainPage221603.correoTercero.setValue("DestinatarioMQA@gmail.com");
            mainPage221603.guardarTercero.click();

            //Pestaña Pago de derechos
            mainPage221603.Scrol.scrollTo();
            mainPage221603.pagoDerechos.click();
            //Pago de derechos
            mainPage221603.banco.sendKeys(new CharSequence[]{"BANAMEX"});
            mainPage221603.llaveBanco.sendKeys(new CharSequence[]{llavePago});
            mainPage221603.fechaPago.shouldBe(new WebElementCondition[]{Condition.visible}).click();
            executeJavaScript("arguments[0].value = arguments[1];", mainPage221603.fechaPago, fechaHoy);
            Selenide.sleep(200L);

            //Continuar Paso 1
            mainPage221603.btnContinuarPaso1.click();

            //PASO 2 REQUISITOS NECESARIOS
            mainPage221603.btnContinuarPaso2.click();

            //Paso 3 ANEXAR REQUISITOS
            metodos.cargarDocumentos();
            mainPage221603.btnAdjuntar2.click();
            mainPage221603.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60)); Selenide.sleep(1000);
            mainPage221603.btnCerrar3.click();
            mainPage221603.btnContinuarPaso3.click();

            //Paso 4 FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite221603);
            Selenide.sleep(3000);

            // Obtener el texto del folio
            String folioText = mainPage221603.folio.getText();
            //Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);


    }

    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            Selenide.open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();
        }

    }
}


