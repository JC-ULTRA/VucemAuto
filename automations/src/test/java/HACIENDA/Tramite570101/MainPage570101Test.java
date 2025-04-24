package HACIENDA.Tramite570101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite570101.MainPage570101;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage570101Test {

    MainPage570101 mainPage570101 = new MainPage570101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite570101  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
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
    public void Proceso570101() throws IOException {
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


            // Solicitar el folio al usuario
            String FolioTramiteN = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioTramiteN == null || FolioTramiteN.length() != 25  || !FolioTramiteN.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioTramiteN);

            // Ingreso y selección Rol
            loginFirmSoli.login(tramite570101);
            mainPage570101.selecRol.sendKeys("Persona Moral");
            mainPage570101.btnacep.click();

            //Búsqueda de tramite
            mainPage570101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage570101.SoliSub.click();
            mainPage570101.FolioTramite.sendKeys(FolioTramiteN);
            mainPage570101.btnBuscarFolio.click();
            SelenideElement filaFolioDeseado = mainPage570101.filaFolioGrid.findBy(text(FolioTramiteN));
            filaFolioDeseado.doubleClick();

            //Datos generales Original
            mainPage570101.tabDatosGeneralesOriginal.click();
            //Persona Responsable despacho
            mainPage570101.checkPersonaDespacho.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage570101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage570101.btnSolicitarCancelacion.click();

            //Paso1
            //Datos de la solicitud
            mainPage570101.tabDatosSolicitud.click();
            mainPage570101.comboTipoCancelacion.sendKeys("Total");
            mainPage570101.MotivoCancelacion.sendKeys("QA");
            mainPage570101.btnGuardarFirmar.click();
            //Notificacion
            mainPage570101.btnSiCancelarFolio.click();

            //Paso 2 Firma solicitud
            loginFirmSoli.firma(tramite570101);sleep(29000);

            // Obtener el texto del folio
            String folioText = mainPage570101.folio.getText();
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
