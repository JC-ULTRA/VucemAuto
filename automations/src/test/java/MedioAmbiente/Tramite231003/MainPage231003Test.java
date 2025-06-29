package MedioAmbiente.Tramite231003;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage231003Test {
    MainPage231003 mainPage231003 = new MainPage231003();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    Metodos metodos = new Metodos();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite231003  = new TramitesFirmasLG(
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
    }

    @Test
    public void Proceso231003() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return; // Termina el metodo si se selecciona cancelar
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

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen231003");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion231003");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion231003");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen231003");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion231003");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion231003");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite231003);
            mainPage231003.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage231003.btnacep.click(); sleep(1000);
            mainPage231003.Tramites.click(); sleep(1000);
            mainPage231003.SoliNew.click(); sleep(1000);
            mainPage231003.SEMARNAT.click(); sleep(1000);
            mainPage231003.CertLicPerm.click(); sleep(1000);
            mainPage231003.Semart721.click(); sleep(1000);
            mainPage231003.labelAvisoReciclaje.click(); sleep(1000);
            mainPage231003.DatosSoli.click(); sleep(1000);
            //mainPage231003.retornoPrimeraVez.click();
            mainPage231003.numRegistroAmbiental.sendKeys("8646516546512");
            mainPage231003.giroImportador.sendKeys("PRUEBAS QA ULTARASIST");
            mainPage231003.numIMMEX.sendKeys("0200800100120252540000001");
            mainPage231003.btnAgregarResiduoRetorno.click();
            mainPage231003.residuoMateriaPrima.click();
            mainPage231003.numBitacora.sendKeys("E5/00000003/10/2022");
            mainPage231003.btnBuscarBitacora.click();sleep(1000);
            mainPage231003.nombreMateriaPrima.click();
            mainPage231003.nombreMateriaPrima.sendKeys("Plastico");sleep(1000);
            metodos.scrollIncremento(1);
            mainPage231003.btnArgregarMateriaPrima.click();
            mainPage231003.fraccionArancelaria.sendKeys("25241003");
            mainPage231003.nico.sendKeys("00");;
            mainPage231003.nombreResiduoPeligroso.sendKeys("tratamiento peligroso");
            mainPage231003.cantidad.sendKeys("10");
            mainPage231003.unidadMedida.sendKeys("Tonelada");
            mainPage231003.tipoClave.click();
            mainPage231003.claveResiduo.sendKeys("E1044");
            mainPage231003.creti.sendKeys("Corrosivo");
            mainPage231003.estadoFisico.sendKeys("Semisolido");
            //mainPage231003.numManifiesto.sendKeys("982167732");
            mainPage231003.tipoContenedor.sendKeys("Bidón");
            mainPage231003.capacidad.sendKeys("10");
            mainPage231003.btnAgregarMercancia.click();sleep(1000);

            mainPage231003.transportista.sendKeys("Transportista Pruebas");
            mainPage231003.numAutorizacionSemarnat.sendKeys("66513757");
            mainPage231003.requiereOtraEmpreza.click();
            mainPage231003.empresaRetorno.sendKeys("Empresa de prueba");
            mainPage231003.representanteRetorno.sendKeys("DIEGO DIAZ DIAZ");
            mainPage231003.telefonoRetorno.sendKeys("0123456789");
            mainPage231003.correoRetorno.sendKeys("pruebas@pruebas.qa");
            mainPage231003.precausionesRegistro.sendKeys("Elemento corrosivo manejese con cuidado");
//
//            mainPage231003.aduanaSalida.sendKeys("ADUANA DE PATANCO");
//            mainPage231003.nombreDestintario.sendKeys("DESTINATARIO PRUEBAS");
//            mainPage231003.paisDestino.sendKeys("ANGUILA");
//            mainPage231003.domicilioDestino.sendKeys("DOMICILIO DESTINO");
//            mainPage231003.codigoPostalDestino.sendKeys("00000");
            mainPage231003.btnGuardarSoli.click();


            loginFirmSoli.firma(tramite231003);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage231003.folio.getText();

//            Llamar al método para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);
//
//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoDictamen6001")) {
//                ProcesoDictamenB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoAutorizacion6001")) {
//                ProcesoAutorizacionB8(folioNumber);
//            }
//            if (selectedMethods.contains("ProcesoConfirmarNotificaciónResolucion6001")) {
//                ProcesoConfirmarNotificaciónResolucionB8(folioNumber);
//            }
//
        }, repeticiones);
    }


    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

}