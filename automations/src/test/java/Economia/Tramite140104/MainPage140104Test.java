package Economia.Tramite140104;

import DBYFOLIO.ObtenerFolio;

import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage140104Test {
    MainPage140104 mainPage140104 = new MainPage140104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite140104  = new TramitesFirmasLG(
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
    public void Proceso140104() throws IOException {
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

            //Generar Factura aleatoria
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 7;
            String FacturaGenerada = uuid.replace("-", "").substring(0, longitudDeseada);


            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite140104);
            mainPage140104.selecRol.sendKeys("Persona Moral");
            mainPage140104.btnacep.click();
            mainPage140104.Tramites.sendKeys("Solicitudes nuevas");
            mainPage140104.SoliNew.click();
            mainPage140104.Economia.click();
            mainPage140104.CancelModifDesistReact.click();
            mainPage140104.PeticionParte.click();
            mainPage140104.elementoTramite140104.click();

            // Paso 1
            // Sección Cancelación de permisos previamente autorizados
            mainPage140104.TituloPrincipal.scrollTo();
            mainPage140104.tabCancelacionPermisosPrevAutorizado.click();
            mainPage140104.btnAccederBusquedaFolio.click();

            // Solicitar el folio al usuario
            String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 15 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioRubro == null  || FolioRubro.length() != 15) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

            mainPage140104.FolioResolucion.sendKeys(FolioRubro);
            mainPage140104.FolioResolucion.scrollTo();
            mainPage140104.btnBuscarFolioIngresado.click();
            mainPage140104.btnAgregarFolio.click();
            mainPage140104.ResolucionElemento1.click();
            mainPage140104.MotivoCancelacion.sendKeys("Cancelación QA");
            mainPage140104.btnContinuarAgregarSol.click();

            //Paso 2
            mainPage140104.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage140104.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage140104.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage140104.btnAdjuntar2.click();sleep(2000);
            mainPage140104.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage140104.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage140104.btnContinuar3.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite140104);

            // Obtener el texto del folio desde mainPageB8

            String folioText = mainPage140104.folio.getText();

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

