package SEDENA.Tramite240117;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage240117Test {
    MainPage240117 mainPage240117 = new MainPage240117();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240117  = new TramitesFirmasLG(
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
    public void Proceso240117() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240117");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion240117");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion240117");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240117");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion240117");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion240117");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240117);
            mainPage240117.selecRol.sendKeys("Persona Moral");
            mainPage240117.btnacep.click();
            mainPage240117.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240117.SoliNew.click();
            mainPage240117.SEDENA.click();
            mainPage240117.linkCerLicPer.click();
            mainPage240117.linkPermisoAduanalSEDENA.click();
            mainPage240117.linkPerOrdExpSusQui.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240117.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240117.labelDatosSolicitud.click();
            mainPage240117.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240117.inputAddOrigenLista.click();
            mainPage240117.inputPermisoGeneral.sendKeys("PRUEBAS");
            mainPage240117.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240117.btnAgregarMercancia.click();
            mainPage240117.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240117.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240117.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240117.inputValorComercialMercancia.sendKeys("1234");
            mainPage240117.selectUMCMercancia.sendKeys("Caja");
            mainPage240117.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
//            mainPage240117.inputPaisOrigenMercancia.sendKeys("ANTARTIDA");
//            mainPage240117.btnAgregarPaisSeleccion.click();
            mainPage240117.btnAgregarMercancia2.click();
            mainPage240117.inputSemestre2.click();
            mainPage240117.inputAnoCurso.click();
            mainPage240117.inputManifiesto.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240117.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240117.labelTercerosRelacionados.click();
            mainPage240117.btnAgregarDestinatario.click();
            mainPage240117.inputFisica.click();
            mainPage240117.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240117.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240117.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240117.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240117.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240117.inputTercerosCP.sendKeys("23456");
            mainPage240117.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240117.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240117.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240117.inputTercerosLada.sendKeys("52");
            mainPage240117.inputTercerosTelefono.sendKeys("23456257");
            mainPage240117.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240117.btnGuardarTerceros.click();
            mainPage240117.btnAgregarProveedor.click();
            mainPage240117.inputNacional.click();
            mainPage240117.inputFisica.click();
            mainPage240117.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240117.inputTercerosNombre.sendKeys("RICARDO");
            mainPage240117.inputTercerosApellidoPaterno.sendKeys("REYES");
            mainPage240117.inputTercerosApellidoMaterno.sendKeys("RAMIREZ");
            mainPage240117.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240117.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240117.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240117.inputTercerosCP2.sendKeys("28006");
            mainPage240117.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240117.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240117.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240117.inputTercerosNumeroInt.sendKeys("321");
            mainPage240117.inputTercerosLada.sendKeys("52");
            mainPage240117.inputTercerosTelefono.sendKeys("234565432");
            mainPage240117.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240117.btnGuardarTerceros.click();

            mainPage240117.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240117.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240117.inputCadenaDependencia.setValue(factura.toString());
            mainPage240117.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240117.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240117.inputCalendar);sleep(100);
            mainPage240117.inputImportePago.sendKeys("5000");
            mainPage240117.InputGuardarSolicitud.click();
            mainPage240117.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240117.btmAnexar.click();sleep(7000);
            Selenide.sleep(8000);
            mainPage240117.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage240117.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240117);
            Selenide.sleep(2000);
            String folioText = mainPage240117.folio.getText();sleep(5000);
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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