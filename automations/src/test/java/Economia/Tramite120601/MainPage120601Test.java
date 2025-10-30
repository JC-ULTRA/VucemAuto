package Economia.Tramite120601;


import COFEPRIS.Tramite260215.MainPage260215Test;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage120601Test {
    MainPage120601 mainPage120601 = new MainPage120601();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();
    String FunRFC = "MAVL621207C95";
    TramitesFirmasLG tramite120601  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\leqi8101314s7.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\LEQI8101314S7_1012231707.key"
    );
    TramitesFirmasLG tramite120601Fun  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
    );


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = Browsers.CHROME; //FIREFOX;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--remote-allow-origins=*").addArguments("--force-device-scale-factor=1.25");
        open();
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 200000; // tiempo de espera
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso120601() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
        // Solicitar el número de repeticiones al usuario
        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);

        if (repeticionesStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        int repeticiones;
        try {
            repeticiones = Integer.parseInt(repeticionesStr);
        } catch (NumberFormatException e) {
            repeticiones = 1; // Valor por defecto
            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////-

        //Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen120601");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion120601");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion120601");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion");

        // Ejecutar el proceso con el folio válido
        ejecutarProcesoNRunnable(() -> {
            setUpAll();
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            /// Fecha del dia
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);
            // Llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite120601);
            mainPage120601.selecRol.sendKeys("Persona Moral");
            mainPage120601.btnacep.click();
            mainPage120601.Tramites.sendKeys("Solicitudes nuevas");
            mainPage120601.SoliNew.click();
            mainPage120601.Econom.click();
            mainPage120601.CupoExIm.click();
            mainPage120601.RegistroEmpresComerIndustFront.click();
            mainPage120601.Tramite120601.click();sleep(2000);
            metodos.scrollDecremento(1);
            mainPage120601.PestDatEmpres.click();
            mainPage120601.Estado.sendKeys("CHIHUAHUA");sleep(1000);
            $$("button.btn.btn-primary").findBy(text("Aceptar")).click();
            mainPage120601.CargarDatosDomicilio.doubleClick();
            mainPage120601.TipoEmpresa.sendKeys("OTROS SERVICIOS");sleep(1000);
            mainPage120601.Especifique.sendKeys("OTROS SERVICIOS");sleep(1000);
            mainPage120601.Clasif.sendKeys("1112");sleep(1000);
            mainPage120601.ClickFuera.click();
            mainPage120601.btnContinuar.click();
            String folioTextTemp = mainPage120601.folio.getText();
            String folioTemp = obtenerFolio.obtenerFolioTemp(folioTextTemp);
            $("input.btn.btn-primary[value='Continuar']").click();
            metodos.cargarDocumentos();
            mainPage120601.btnAdjuntar.click();sleep(10000);
            mainPage120601.btnCerrar.click();
            //firmas
            mainPage120601.btnPasarFirma.click();
            loginFirmSoli.firma(tramite120601);
            // Obtener el texto del folio desde mainPage130118
            String folioText = mainPage120601.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//        try {
//        ProcesoRequerimiento(folioNumber);
//        try {
//            ProcesoConfirmar(folioNumber, "Moral");
//            try {
//                ProcesoAtenderRequerimiento(folioNumber, "Moral");
//                try {
//                    ProcesoVisita(folioNumber);
//                    try {
//                        ProcesoRegistrarOpinion(folioNumber);
//                        try {
//                            ProcesoDictamen(folioNumber);
//                            try {
//                                ProcesoObservarDictamen(folioNumber);
//                                try {
//                                    ProcesoDictamen(folioNumber);
//                                    try {
//                                        ProcesoAutorizarDictamen(folioNumber);
//                                        try {
//                                            ProcesoConfirmar(folioNumber, "Moral");
//                                            T = 10;
//                                        } catch (Throwable e) {
//                                            T = 9;
//                                            e.printStackTrace();
//                                        }
//                                    } catch (Throwable e) {
//                                        T = 8;
//                                        e.printStackTrace();
//                                    }
//                                } catch (Throwable e) {
//                                    T = 7;
//                                    e.printStackTrace();
//                                }
//                            } catch (Throwable e) {
//                                T = 6;
//                                e.printStackTrace();
//                            }
//                        } catch (Throwable e) {
//                            T = 5;
//                            e.printStackTrace();
//                        }
//                    } catch (Throwable e) {
//                        T = 4;
//                        e.printStackTrace();
//                    }
//                } catch (Throwable e) {
//                    T = 3;
//                    e.printStackTrace();
//                }
//            } catch (Throwable e) {
//                T = 2;
//                e.printStackTrace();
//            }
//        } catch (Throwable e) {
//            T = 1;
//            e.printStackTrace();
//        }
//    } catch (Throwable e) {
//        T = 0;
//        e.printStackTrace();
//    }

        }, repeticiones);
    }
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

}
