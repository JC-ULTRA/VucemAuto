package Economia.Tramite110218;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110218.MainPage110218;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110218Test {
    MainPage110218 mainPage110218 = new MainPage110218();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110218  = new TramitesFirmasLG(
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void Proceso110218() throws IOException {
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


///Tramite Aviso 110218
        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {
            ///Login
            loginSoli.login(tramite110218); sleep(1000);
            ///RutaAlTramite
            ejecutarRutaAlTramite();
            sleep(2000);
            ///Consulta
            ejecutarConsulta(); sleep(2000);
            ///Validacion Certificado
            ejecutarValidacion();

            ///Firma
            loginSoli.firma(tramite110218);
            // Obtener el texto del folio desde mainPage110218
            String folioText = mainPage110218.folio.getText();
            // Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    public void ejecutarRutaAlTramite(){
        mainPage110218.selecRol.sendKeys("Persona Moral");
        mainPage110218.btnacep.click();
        mainPage110218.Tramites.sendKeys("Solicitudes nuevas");
        mainPage110218.SoliNew.click();
        mainPage110218.Economia.click();
        mainPage110218.CertificadoOrigen.click();
        mainPage110218.ValidacionCertificadosOrigen.click();
        mainPage110218.motivosTecnicosJapon.click();

    }
    public void ejecutarConsulta(){
        mainPage110218.porTratatdoAcuerdo.click();
        mainPage110218.tratadoAcuerdo.sendKeys("Acuerdo México-Japón");
        mainPage110218.paisBloque.sendKeys("JAPON");
        mainPage110218.btnBuscar.click();sleep(1000);
        mainPage110218.radio1.click();sleep(1000);
        mainPage110218.btnConsultar.click();
    }
    public void ejecutarValidacion(){
        mainPage110218.tratados.click();
        mainPage110218.destinatario.click();sleep(1000);
        mainPage110218.nombreDestinatario.sendKeys("QA");
        mainPage110218.primerApellidoDestinatario.sendKeys("QA");
        mainPage110218.segundoApellidoDestinatario.sendKeys("QA");
        mainPage110218.numeroRegistroFiscal.setValue("12867612783");
        mainPage110218.calleDestinatario.setValue("Calle prueba");
        mainPage110218.numeroDestinatario.setValue("123");
        mainPage110218.ciudadDestinatario.setValue("Ciudad de México");
        mainPage110218.correoDestinatario.setValue("pruebas@pruebas.qa");
        mainPage110218.telefonoDestinatario.setValue("5555555555");
        mainPage110218.faxDestinatario.setValue("12345678");
        metodos.scrollDecremento(3);
        mainPage110218.transporte.click();
        mainPage110218.puertoEmbarque.setValue("Veracruz");
        mainPage110218.puertoDesembarque.setValue("Altamira");
        mainPage110218.puertoTransito.setValue("Dos Bocas");
        mainPage110218.nombreEmbarcacion.setValue("Embarcación Prueba");
        mainPage110218.numeroVuelo.setValue("123456");
        metodos.scrollDecremento(3);
        mainPage110218.representanteLegal.click();
        mainPage110218.nombreRepresentante.setValue("DIEGO DIAZ DIAZ");
        mainPage110218.cargoRepresentante.setValue("Representante Legal");
        mainPage110218.telefonoRepresentante.setValue("5555555555");
        mainPage110218.faxRepresentante.setValue("12345678");
        mainPage110218.correoRepresentante.setValue("pruebas@pruebas.qa");
        metodos.scrollDecremento(3);
        mainPage110218.datosCertificado.click();
        mainPage110218.lugarDatos.setValue("Ciudad de México");
        mainPage110218.observaciones.setValue("Observaciones de prueba  validacion");
        mainPage110218.seleccionaMercancia.click();
        mainPage110218.btnModificaMercancia.click();
        mainPage110218.complementoDescripcion.setValue("454002245");
        mainPage110218.marcaMercancia.sendKeys("Marca de prueba");
        mainPage110218.valorMercancia.setValue("1000.0000");
        mainPage110218.unidadMedidaComercializacion.sendKeys("Caja");
        mainPage110218.numeroFactura.setValue("1234567890");
        mainPage110218.tipoFactura.sendKeys("Manual");
        mainPage110218.btnHacerModificacion.click();
        mainPage110218.btnGuardarSoli.click();sleep(1000);
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
