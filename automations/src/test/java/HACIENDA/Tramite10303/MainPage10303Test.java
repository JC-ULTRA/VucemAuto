package HACIENDA.Tramite10303;

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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.sql.DriverManager.setLoginTimeout;

public class MainPage10303Test {
    MainPage10303 mainPage10303 = new MainPage10303();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();

    TramitesFirmasLG tramite10303 = new TramitesFirmasLG(
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
    public void Proceso10303() throws IOException {
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
            loginFirmSoli.login(tramite10303); sleep(1000);
            mainPage10303.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage10303.btnacep.click(); sleep(1000);
            mainPage10303.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage10303.SoliNew.click(); sleep(1000);
            mainPage10303.Hacienda.click();
            mainPage10303.AutorizacionesImportadorExportador.click();
            mainPage10303.ExenciImpuestosComercioExterior.click();
            mainPage10303.TramiteDonaciMercancia.click();

            // Usar Actions para desplazar hacia el elemento (scroll)
            // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
            try {
                Thread.sleep(1000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage10303.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Pestaña registro de donación
            mainPage10303.RegistroDonaci.click();
            mainPage10303.DonanteExtranjero.click();
            mainPage10303.DonantePropietario.click();
            mainPage10303.MercanciaEstado.click();
            mainPage10303.MercanciaNoComer.click();
            mainPage10303.ManifiestoVerdad.click();
            mainPage10303.selectAduana.sendKeys("ACAPULCO, PUERTO Y AEROPUERTO");
            mainPage10303.Alimentacion.click();
            mainPage10303.BasicoEducacion.click();
            mainPage10303.BasicoProteccionCivil.click();
            mainPage10303.BasicoSalud.click();
            mainPage10303.BasicoVestido.click();
            mainPage10303.BasicoVivienda.click();
            mainPage10303.AgregarMercancias.click();
            mainPage10303.selectDestino.sendKeys("Municipios");
            mainPage10303.PosibleFraccion.sendKeys("87033302");
            mainPage10303.OpcionPermisoNo.click();
            mainPage10303.JustificacionMerca.sendKeys("PRUEBAS QA ULTRASIST");
            mainPage10303.DescripcionMercanciaOtro.sendKeys("ULTRASIST PRUEBAS QAS");
            mainPage10303.selectTipoMercancia.sendKeys("Generl");
            mainPage10303.CantidadUMC.sendKeys("100");
            mainPage10303.CantidadUMT.sendKeys("100");
            mainPage10303.UMC.sendKeys("Caja");
            mainPage10303.UMT.sendKeys("Caja");
            mainPage10303.selectPaisProcedenciaOtro.sendKeys("ANGUILA");
            mainPage10303.selectCondicionMercanciaOtro.sendKeys("Nuevo");
            mainPage10303.AgregarMerc.click();
            mainPage10303.buttonAceptar.click();

            mainPage10303.DatosdeDonanteExt.click();
            mainPage10303.NomDonExt.sendKeys("PAULI ULTRASIST");
            mainPage10303.CalleDonExt.sendKeys("CALLE PRUEBAS 1");
            mainPage10303.NumExteriorDonante.sendKeys("2025");
            mainPage10303.NumInteriorDonante.sendKeys("1");
            mainPage10303.selectPaisDonante.sendKeys("ANGUILA");
            mainPage10303.CodigoPostalDonante.sendKeys("20012");
            mainPage10303.EstadoDonante.sendKeys("VERACRUZ");
            mainPage10303.RegionDonante.sendKeys("ALVARADO");
            mainPage10303.CorreoElectronicoDonante.sendKeys("prueba@ultrasist.com.mx");
            mainPage10303.TelefonoDonante.sendKeys("2983764765");
            mainPage10303.selectDocumentoResidencia.sendKeys("Pasaporte válido en el país de residencia y vigente");

            //Datos del donatario
            mainPage10303.DatosDonatario.click();
            mainPage10303.inputDonatario.sendKeys("AAL0409235E6");

            //Datos del representante legal del donatario
            mainPage10303.DatosRepreLegalDonatario.click();
            mainPage10303.inputRepLegalDonatario.sendKeys("AAL0409235E6");

            //Datos del representante legal para recibir la donación
            mainPage10303.DatosRepreLegRecDonaciones.click();
            mainPage10303.inputRepLegalAutorizado.sendKeys("AAL0409235E6");

            //Datos de la persona autorizada para oír y recibir notificaciones
            mainPage10303.DatosPersOirNoti.click();
            mainPage10303.inputPersonaAutorizada.sendKeys("AAL0409235E6");

            //Continuar paso 2
            mainPage10303.ContinuarSolicitud.click();
            mainPage10303.ReqOpcionales.click();
            mainPage10303.inputDeleteButton.click();

            //Continuar paso 3
            mainPage10303.inputContinuarPaso3.click();
            mainPage10303.AdjuntarDocumentos.click();
            mainPage10303.inputDocumentosFile.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile1.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile2.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile3.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile4.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile5.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile6.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});
            mainPage10303.inputDocumentosFile7.sendKeys(new CharSequence[]{"C:\\VucemAuto\\RepoN\\src\\test\\resources\\Lorem_ipsum.pdf"});

            mainPage10303.inputAnexar.click();
            sleep(20000);
            mainPage10303.inputCerrar.click();
            setLoginTimeout(10000);
            mainPage10303.inputSiguienteButton.click();

            loginFirmSoli.firma(tramite10303);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage10303.folio.getText();

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