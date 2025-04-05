package MedioAmbiente.Tramite230101;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.io.IOException;
import java.util.UUID;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage230101Test {

    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
    MainPage230101 mainPage230101 = new MainPage230101();
    LoginFirmSoli loginSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite230101  = new TramitesFirmasLG(
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
    public void Proceso230101() throws IOException {
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

            loginSoli.login(tramite230101); sleep(1000);
            mainPage230101.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage230101.btnacep.click(); sleep(1000);
            mainPage230101.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage230101.SoliNew.click(); sleep(1000);
            mainPage230101.MedioAmbiente.click(); sleep(1000);
            mainPage230101.CertLicenciasPermisos.click(); sleep(1000);
            mainPage230101.RequisitosFito.click(); sleep(1000);
            mainPage230101.CertFitoImport.click(); sleep(1000);

                        //Datos de la mercancia
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainPage230101.DatosSolicitud.click(); sleep(1000);
            mainPage230101.TipoRegimen.click(); sleep(1000);
            mainPage230101.optionAcapulcoAeropuerto.click(); sleep(1000);
            mainPage230101.AddlistaOrigen1.click(); sleep(1000);
            mainPage230101.optionAeropuertoIntMexico.click(); sleep(1000);
            mainPage230101.AddlistaOrigen2.click(); sleep(1000);
            mainPage230101.selectTipoProducto.sendKeys("Maderable.");
            mainPage230101.optionAlbaniaRepublica.click(); sleep(1000);
            mainPage230101.AddlistaOrigen.click(); sleep(1000);
            mainPage230101.selectPaisProcedencia.sendKeys("ARGENTINA (REPUBLICA)");

            //Destino dentro del pais
            mainPage230101.optionVeracruz.click(); sleep(1000);
            mainPage230101.inputAddlistaOrigen.click(); sleep(1000);
            mainPage230101.TodoTerritorio.click();
            mainPage230101.optionFraccionesNicas.click(); sleep(1000);
            mainPage230101.AgregarMercancias.click(); sleep(1000);
            mainPage230101.FraccionArancelaria.sendKeys("46021101");
            mainPage230101.inputCantidadUmc.sendKeys("100");
            mainPage230101.selectMercanciaGenero.sendKeys("Agave");
            mainPage230101.selectMercanciaEspecie.sendKeys("montana");
            mainPage230101.NombreComun.sendKeys("Maguey verde");
            mainPage230101.AgregarDetalleMercancias.click();
            mainPage230101.inputAgregarMercancia.click();
            mainPage230101.selectDescripcionProducto.sendKeys("ESTERILLAS, ESTERAS Y CAÑIZOS, DE MATERIA VEGETAL, NUEVOS SIN RECUBRIMIENTO");
            mainPage230101.optionKilogramo.click();
            mainPage230101.inputDeclaracion.click();

            //Pestaña Pago de Derechos
            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(3000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage230101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage230101.PagoDerechos.click(); sleep(1000);
            mainPage230101.BancoClave.sendKeys("HSBC");
            mainPage230101.inputPagoLlave.sendKeys(llavePago);
            mainPage230101.inputCalendar.sendKeys("06/03/2025");
            mainPage230101.inputGuardarSolicitud.click(); sleep(1000);


            loginSoli.firma(tramite230101);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage230101.folio.getText();

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
