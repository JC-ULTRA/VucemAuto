package HACIENDA.Tramit40101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite103.MainPage103;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage40101Test {

    MainPage40101 mainPage40101 = new MainPage40101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite40101  = new TramitesFirmasLG(
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
    public void Proceso40101() throws IOException {
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
            // Ingreso y selección de trámite

            loginFirmSoli.login(tramite40101); sleep(1000);
            mainPage40101.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage40101.btnacep.click(); sleep(1000);
            mainPage40101.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage40101.SoliNew.click(); sleep(1000);
            mainPage40101.Hacienda.click();

            mainPage40101.RegistroDelDigoAlfanum.click();
            mainPage40101.RegistroDelDigoAlfanum2.click();
            mainPage40101.Tramite40101.click();

            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage40101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Pestaña Director General
            mainPage40101.PestañaDirectorGeneral.click(); sleep(1000);
            mainPage40101.NombreDirectorGeneral.sendKeys("PRUEBAS QAS");
            mainPage40101.ApellidoPaternoDirectorGeneral.sendKeys("PRUEBA");
            mainPage40101.ApellidoMaternoDirectorGeneral.sendKeys("QAS");

            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage40101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Pestaña Choferes
            //Chofer nacional
            mainPage40101.PestañaChoferes.click(); sleep(1000);
//            mainPage40101.inputAgregar.click(); sleep(1000);
//            mainPage40101.Curp.sendKeys("MAVL621207HDGRLS06"); sleep(1000);
//            mainPage40101.RFCPersona.sendKeys("MAVL621207C95");
//            mainPage40101.BuscarChofer.click();
//            mainPage40101.Calle.sendKeys("CALLE");
//            mainPage40101.NumeroExterior.sendKeys("NUM EXTERIOR");
//            mainPage40101.NumeroInterior.sendKeys("NUM INTERIOR");
//            mainPage40101.selectEstado.sendKeys("VERACRUZ");
//            mainPage40101.selectMunicipio.sendKeys("ALVARADO");
//            mainPage40101.selectColonia.sendKeys("CENTRO - CP 95270");
//            mainPage40101.selectPaisOrigen.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");
//            mainPage40101.Ciudad.sendKeys("ALVARADO");
//            mainPage40101.Localidad.sendKeys("ALVARADO");
//            mainPage40101.CodigoPostal.sendKeys("95270");
//            mainPage40101.Correo.sendKeys("prueba@gmail.com");
//            mainPage40101.Telefono.sendKeys("2989872837");
//            mainPage40101.inputGuardarChofer.click();

            //Chofer extranjero
            mainPage40101.ChofExtranjero.click(); sleep(1000);
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage40101.ScrolBajo.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainPage40101.AgregarExtranjero.click();
            mainPage40101.NombreChe.sendKeys("PRUEBAS");
            mainPage40101.ApellidoPaternoChe.sendKeys("APELLIDO PATERNO");
            mainPage40101.ApellidoMaternoChe.sendKeys("APELLIDO MATERNO");
            mainPage40101.selectNacionalidadChe.sendKeys("ANGUILA");
            mainPage40101.NSS.sendKeys("123543234");
            mainPage40101.IdefiscalChe.sendKeys("654354323");
            mainPage40101.BuscarChoferExt.click(); sleep(1000);
            mainPage40101.btnAceptar.click(); sleep(1000);
            mainPage40101.selectPaisChe.sendKeys("ANGUILA");
            mainPage40101.CodigoPostalChe.sendKeys("02025");
            mainPage40101.Estado.sendKeys("VERACRUZ");
            mainPage40101.CalleChe.sendKeys("CALLE 1");
            mainPage40101.NumeroExteriorChe.sendKeys("12345");
            mainPage40101.NumeroInteriorChe.sendKeys("12");
            mainPage40101.selectPaisOrigenChe.sendKeys("ANGUILA");
            mainPage40101.CiudadChe.sendKeys("ALVARADO");
            mainPage40101.CorreoChe.sendKeys("prueba@gmail.com");
            mainPage40101.TelefonoChe.sendKeys("12345678");
            mainPage40101.GuardarChofer2.click(); sleep(1000);

            //Agregar vehiculo
            mainPage40101.Vehiculos.click(); sleep(1000);
            mainPage40101.AgregarVEH.click(); sleep(1000);
            mainPage40101.VinVeh.sendKeys("156765432SDF43217");
            mainPage40101.selectSolicitudVehiculoTipo.sendKeys("AUTOMÓVIL");
            mainPage40101.PlacasVeh.sendKeys("123SA1");
            mainPage40101.selectSolicitudVehiculoPaisEmisor.sendKeys("ANGUILA");
            mainPage40101.EstadoProvincia.sendKeys("VERACRUZ");
            mainPage40101.MarcaVeh.sendKeys("BMW");
            mainPage40101.ModeloVeh.sendKeys("M2");
            mainPage40101.selectAnioVehiculoVeh.sendKeys("2023");
            mainPage40101.TransponderVeh.sendKeys("2025");
            mainPage40101.selectSolicitudVehiculoColor.sendKeys("NEGRO");
            mainPage40101.NumeroEconomicoVeh.sendKeys("12345");
            mainPage40101.NumeroplacaVeh.sendKeys("123SA1");
            mainPage40101.EmisorplacaVeh.sendKeys("VERACRUZ");
            mainPage40101.selectSolicitudVehiculoPaisEmisor2.sendKeys("ANGUILA");
            mainPage40101.inputGuardarVehiculo.click(); sleep(1000);

            mainPage40101.inputGuardarSolicitudPaso2.click(); sleep(1000);


            loginFirmSoli.firma(tramite40101);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage40101.folio.getText();

            // Llamar al método para obtener el folio
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