package SEDENA.Tramite240108;

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

public class MainPage240108Test {
    MainPage240108 mainPage240108 = new MainPage240108();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite240108  = new TramitesFirmasLG(
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
    public void Proceso240108() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen240108");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion240108");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion240108");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen240108");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion240108");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion240108");

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite240108);
            mainPage240108.selecRol.sendKeys("Persona Moral");
            mainPage240108.btnacep.click();
            mainPage240108.Tramites.sendKeys("Solicitudes nuevas");
            mainPage240108.SoliNew.click();
            mainPage240108.SEDENA.click();
            mainPage240108.linkCerLicPer.click();
            mainPage240108.linkPermisoAduanalSEDENA.click();
            mainPage240108.linkPerOrdImpArtPir.click();
            //DATOS SOLICITANTE
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240108.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240108.labelDatosSolicitud.click();
            mainPage240108.inputOrigenLista.sendKeys("ALTAMIRA");
            mainPage240108.inputAddOrigenLista.click();
            mainPage240108.inputPermisoGeneral.sendKeys("PRUEBAS");
            mainPage240108.inputUsoFinalMercancia.sendKeys("PRUEBA");
            mainPage240108.btnAgregarMercancia.click();
            mainPage240108.inputDescripcionMercancia.sendKeys("PRUEBAS");
            mainPage240108.inputFraccionArancelariaMercancia.sendKeys("28291999");
            mainPage240108.inputCantidadUMTMercancia.sendKeys("10");
            mainPage240108.inputValorComercialMercancia.sendKeys("1234");
            mainPage240108.selectUMCMercancia.sendKeys("Caja");
            mainPage240108.inputTipoMonedaMercancia.sendKeys("Mexican Peso");
            mainPage240108.inputPaisOrigenMercancia.sendKeys("ANTARTIDA");
            mainPage240108.btnAgregarPaisSeleccion.click();
            mainPage240108.btnAgregarMercancia2.click();
            mainPage240108.inputSemestre2.click();
            mainPage240108.inputAnoCurso.click();
            //mainPage240108.inputManifiesto.click();
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage240108.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage240108.labelTercerosRelacionados.click();
            mainPage240108.btnAgregarDestinatario.click();
            mainPage240108.inputNacional.click();
            mainPage240108.inputFisica.click();
            mainPage240108.inputTerceroRFC.sendKeys("LEQI8101314S7");
            mainPage240108.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240108.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240108.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240108.inputTercerosEstado2.sendKeys("COLIMA");
            mainPage240108.inputTercerosMunicipio.sendKeys("COLIMA");
            mainPage240108.inputTercerosLocalidad.sendKeys("COLIMA");
            mainPage240108.inputTercerosCP2.sendKeys("28006");
            mainPage240108.inputTercerosColonia.sendKeys("AYUNTAMIENTO");
            mainPage240108.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240108.inputTercerosNumeroExt.sendKeys("1234");
            mainPage240108.inputTercerosNumeroInt.sendKeys("321");
            mainPage240108.inputTercerosLada.sendKeys("52");
            mainPage240108.inputTercerosTelefono.sendKeys("234565432");
            mainPage240108.inputTercerosCorreoElec.sendKeys("pruebas@test.com");
            mainPage240108.btnGuardarTerceros.click();
            mainPage240108.btnAgregarProveedor.click();
            mainPage240108.inputFisica.click();
            mainPage240108.inputTercerosNombre.sendKeys("PROTEO");
            mainPage240108.inputTercerosApellidoPaterno.sendKeys("RIVAS");
            mainPage240108.inputTercerosApellidoMaterno.sendKeys("CHACON");
            mainPage240108.inputTercerosPais.sendKeys("ARGENTINA");
            mainPage240108.inputTercerosEstado.sendKeys("CONOCIDO");
            mainPage240108.inputTercerosCP.sendKeys("23456");
            mainPage240108.inputTercerosCalle.sendKeys("PRUEBA");
            mainPage240108.inputTercerosNumeroExt.sendKeys("23456");
            mainPage240108.inputTercerosNumeroInt.sendKeys("23456");
            mainPage240108.inputTercerosLada.sendKeys("52");
            mainPage240108.inputTercerosTelefono.sendKeys("23456257");
            mainPage240108.inputTercerosCorreoElec.sendKeys("prueba@test.com");
            mainPage240108.btnGuardarTerceros.click();

            mainPage240108.labelPagoDerechos.click();
            Random random = new Random();
            int cveReferencia = 10_000_000 + random.nextInt(90_000_000);
            mainPage240108.inputClaveReferencia.setValue(String.valueOf(cveReferencia));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder factura = new StringBuilder();
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240108.inputCadenaDependencia.setValue(factura.toString());
            mainPage240108.selectSolicitudPagoBancoClave.sendKeys("BANAMEX");
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder otro = new StringBuilder();
            Random serial = new Random();
            for (int i = 0; i < 5; i++) {
                factura.append(caracteres.charAt(random.nextInt(caracteres.length())));
            }
            mainPage240108.inputSolicitudPagoLlave.setValue(factura.toString());
            Selenide.executeJavaScript("arguments[0].value = '08/04/2025';",mainPage240108.inputCalendar);sleep(100);
            mainPage240108.inputImportePago.sendKeys("5000");
            mainPage240108.InputGuardarSolicitud.click();
            mainPage240108.btnContinuar.click();sleep(5000);
            Selenide.sleep(5000);
            metodos.cargarDocumentos();
            mainPage240108.btmAnexar.click();sleep(7000);
            Selenide.sleep(8000);
            mainPage240108.btnCerrar.click();
            Selenide.sleep(2000);
            mainPage240108.inputSiguiente.click();sleep(3000);
            //FIRMAR SOLICITUD
            loginFirmSoli.firma(tramite240108);
            Selenide.sleep(2000);
            String folioText = mainPage240108.folio.getText();sleep(5000);
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