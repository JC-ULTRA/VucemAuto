package Economia.Tramite110210;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110210.MainPage110210;
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
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110210Test {
    MainPage110210 mainPage110210 = new MainPage110210();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110210  = new TramitesFirmasLG(
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
    public void Proceso110210() throws IOException {
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

            // Solicitar el certificado
            String CertificadoTramite = JOptionPane.showInputDialog(null, "Ingrese el número de certificado de 14 dígitos:", "Número de Certificado", JOptionPane.QUESTION_MESSAGE);
            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (CertificadoTramite == null || CertificadoTramite.length() != 14  || !CertificadoTramite.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de certificado ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }
            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Certificado válido ingresado: " + CertificadoTramite);

            // Ingreso y selección de trámite
            //Certificado Prueba 25402500192701

            loginFirmSoli.login(tramite110210); sleep(1000);
            mainPage110210.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110210.btnacep.click(); sleep(1000);
            mainPage110210.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110210.SoliNew.click(); sleep(1000);
            mainPage110210.Economia.click(); sleep(1000);
            mainPage110210.CertOrigen.click(); sleep(1000);
            mainPage110210.ValidacionCertificado.click(); sleep(1000);
            mainPage110210.elementoTramite110210.click(); sleep(1000);

            //Paso 1
            // DUPLICADO DE CERTIFICADO DE ORIGEN
            mainPage110210.Scrol.scrollTo();
            mainPage110210.tabDuplicadoCertificadoOrigen.click();

            //Búsqueda por certificado
            mainPage110210.NumeroCertificadoOrigen.sendKeys(CertificadoTramite);
            mainPage110210.btnBtnbuscarCertificadoNumero.click();
            mainPage110210.tablaNumCertificadoFila1.doubleClick();
            /*
            //Búsqueda por Pais y Tratado/Acuerdo
            mainPage110210.selectPaisBloque.selectOption("Union Europea");
            mainPage110210.selectTratoAcuerdo.selectOption("Tratado de Libre Comercio México-Unión Europea");
            mainPage110210.btnbuscarCertificadoPais.click();
            */
            mainPage110210.btnContinuarPaso1.click();

            //Paso 2
            //Metodo Firma
            loginFirmSoli.firma(tramite110210);

            // Obtener el texto del folio desde mainPageB8

            String folioText = mainPage110210.folio.getText();

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

