package AGRICULTURA.Tramite220103;

import AGRICULTURA.Tramite220103.MainPage220103;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage220103Test {

    MainPage220103 mainPage220103 = new MainPage220103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite220103  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso220103() throws IOException {
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



        // Ejecutar el proceso con las repeticiones
            ejecutarProcesoNRunnable(() -> {
                // Ingreso
                loginFirmSoli.login(tramite220103);
                mainPage220103.selecRol.sendKeys("Persona Moral");
                mainPage220103.btnacep.click(); sleep(1000);
                //Búsqueda de tramite
                mainPage220103.Tramites.sendKeys("Solicitudes nuevas");
                mainPage220103.SoliNew.click();
                mainPage220103.Agricultura.click();
                mainPage220103.certysol.click();
                mainPage220103.RequsitoImpor.click();
                mainPage220103.elementoTramite220103.click();

                //Paso 1 CAPTURAR SOLICITUD
                mainPage220103.Scrol.scrollTo();
                //Pestaña Datos Solicitud
                mainPage220103.tabDatosSolicitud.click();
                //Datos del trámite
                mainPage220103.selectAduanaIngreso.selectOption("AGUASCALIENTES, AGS.");
                mainPage220103.selectMedioTransporte.selectOption("Marítimo");
                mainPage220103.IdTransporte.sendKeys("AH234IU");

                //Agregar Mercancía
                mainPage220103.btnAgregarMercancia.click();
                //Datos Mercancía
                mainPage220103.Descripcion.sendKeys("QA descripción");
                mainPage220103.FraccionArancelaria.sendKeys("");
                mainPage220103.CantidadUMT.sendKeys("10");
                mainPage220103.CantidadUMC.sendKeys("100");
                mainPage220103.selectUMC.selectOption("Kilogramo");
                mainPage220103.NombreComun.sendKeys("Nombre QA");
                mainPage220103.NombreCientifico.sendKeys("Nombre científico QA");
                mainPage220103.FaseDesarrollo.sendKeys("Fase 2 QA");

                mainPage220103.selectUso.selectOption("Otro");
                mainPage220103.selectOrigen.selectOption("Silvestre");
                mainPage220103.selectPaisOrigen.selectOption("CANADA");
                mainPage220103.selectPaisProcedencia.selectOption("ESTADOS UNIDOS DE AMERICA");
                mainPage220103.btnGuardarMercancia.click();

                //Pestaña Instalación Procedencia
                mainPage220103.Scrol.click();
                mainPage220103.tabInstalacionProcedencia.click();
                //Datos de instalación de procedencia
                mainPage220103.NumEstablecimiento.sendKeys("1034");
                mainPage220103.CoordenadasGeograficas.sendKeys("19233.1/2923.0");

                //Pestaña Terceros relacionados
                mainPage220103.Scrol.scrollTo();
                mainPage220103.tabTercerosRelacionados.click();
                //Destinatario
                mainPage220103.btnAgregarDestinatario.click();
                mainPage220103.radbtnPersonaFisica.click();
                mainPage220103.TercerosNombre.sendKeys("Adriana");
                mainPage220103.TercerosApellidoPaterno.sendKeys("Castillo");
                mainPage220103.TercerosApellidoMaterno.sendKeys("Delgado");
                mainPage220103.TercerosCodigoPostal.sendKeys("60705");
                mainPage220103.selectTercerosEstado.selectOption("CIUDAD DE MÉXICO");
                mainPage220103.selectTercerosMunicipio.selectOption("TLALPAN");
                mainPage220103.selectTercerosColonia.selectOption("SIX FLAGS (REINO AVENTURA) - CP 14219");
                mainPage220103.inputTercerosCalle.sendKeys("Calle QA");
                mainPage220103.inputTercerosNumExterior.sendKeys("200");
                mainPage220103.inputTercerosNumInterior.sendKeys("1");
                mainPage220103.inputTerceroLada.sendKeys("55");
                mainPage220103.inputTercerosTelefono.sendKeys("5573829560");
                mainPage220103.inputTercerosCorreoElec.sendKeys("DestinatarioTest@gmail.com");
                mainPage220103.buttonGuardarDatosTercero.click();

                //Instalación de procedencia
                mainPage220103.btnAgregarInstalacionProcedencia.click();
                mainPage220103.radbtnPersonaMoral.click();
                mainPage220103.TercerosDenominacionRazon.sendKeys("Canada Quality Test");
                mainPage220103.selectTercerosPais.selectOption("CANADA");
                mainPage220103.Domicilio.sendKeys("Ontario Imperial St 231");
                mainPage220103.inputTerceroLada.sendKeys("416");
                mainPage220103.inputTercerosTelefono.sendKeys("416485111");
                mainPage220103.inputTercerosCorreoElec.sendKeys("vucem2.InstalacionQA@hotmail.com");
                mainPage220103.buttonGuardarDatosTercero.click();

                //Continuar paso 1
                mainPage220103.btnContinuarPaso1.click();


                //PASO 2 REQUISITOS NECESARIOS
                mainPage220103.btnContinuarPaso2.click();
/*
                //Paso 3 ANEXAR REQUISITOS
                metodos.cargarDocumentos();
                mainPage220103.btnAdjuntar2.click();
                mainPage220103.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(60));
                mainPage220103.btnCerrar3.click();
                mainPage220103.btnContinuarPaso3.click();
*/

                //PASO 4 FIRMAR SOLICITUD
                loginFirmSoli.firma(tramite220103);sleep(3000);

                // Obtener el texto del folio desde mainPageB8
                String folioText = mainPage220103.folio.getText();

                // Llamar al metodo para obtener el folio
                String folioNumber = obtenerFolio.obtenerFolio(folioText);


            }, repeticiones);
    }

    // Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }
}
