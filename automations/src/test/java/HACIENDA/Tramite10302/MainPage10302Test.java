package HACIENDA.Tramite10302;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite10302.MainPage10302;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage10302Test {

    MainPage10302 mainPage10302 = new MainPage10302();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite10302  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );


    @BeforeAll
    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;
        open();
        getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso10302() throws IOException {
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

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite10302);
            mainPage10302.selecRol.sendKeys("Persona Moral");
            mainPage10302.btnacep.click();

            //Búsqueda de tramite
            mainPage10302.Tramites.sendKeys("Solicitudes nuevas");
            mainPage10302.SoliNew.click();
            mainPage10302.Hacienda.click();
            mainPage10302.AutorizacionExpImp.click();
            mainPage10302.ExencionImpuestos.click();
            mainPage10302.elementoTramite10302.click();

            //PASO 1
            //Tab Datos
            mainPage10302.Scrol.scrollTo();
            mainPage10302.tabDatosTramite.click();
            mainPage10302.selectAduanaIngresoMercancia.selectOption("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage10302.checkOrganizmoPublico.click();

            //Mercancia
            mainPage10302.FinMercancia.sendKeys("QA fin de mercancia");
            //Agregar Mercancia
            mainPage10302.btnAgregarMercancia.click();
            mainPage10302.TipoMercancia.sendKeys("Mercancia QA Tipo");
            mainPage10302.Cantidad.sendKeys("20");
            mainPage10302.UnidadMedida.selectOption("Caja");
            mainPage10302.MarcaEquipoMaquinaria.sendKeys("Marca QA Equipo Maquinaria");
            mainPage10302.selectAñoImportacion.selectOption("1964");
            mainPage10302.Modelo.sendKeys("Modelo QA");
            mainPage10302.NumeroSerie.sendKeys("124234232");
            mainPage10302.btnAgregarInfoMercancia.click();
            mainPage10302.btnAceptarNotifMercancia.click();

            //Datos del donante
            mainPage10302.DonanteRFC.sendKeys("AFC000526BJ2");
            mainPage10302.NumeroImmex.setValue("6/2025"); sleep(1000);
            mainPage10302.NumeroImmex.setValue("6/2025").pressTab();
            mainPage10302.btnContinuarPaso1.click();

            //Paso2
            mainPage10302.btnContinuarPaso2.click();

            //Paso 3
            mainPage10302.btnAdjuntarDoc.click();sleep(1000);

            //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
            //Sub Paso 3
            mainPage10302.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage10302.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage10302.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage10302.btnAdjuntar2.click();
            mainPage10302.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage10302.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            //mainPage10302.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage10302.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            //mainPage10302.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage10302.btnContinuar3.click();sleep(1000);


            //Paso 2 Firma solicitud
            loginFirmSoli.firma(tramite10302);

            // Obtener el texto del folio
            String folioText = mainPage10302.folio.getText();
            //Llamar al metodo para obtener el folio
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
