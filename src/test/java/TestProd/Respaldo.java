//package TestProd;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.*;
//import Firmas.*;
//import com.codeborne.selenide.Browsers;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import com.codeborne.selenide.Configuration;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
//
//public class MainPageProdTest {
//    MainPageProd mainpageprod = new MainPageProd();
//    FirmaProdNet firmaProdNet = new FirmaProdNet();
//
//    @BeforeAll
//    public static void initDriver() {
//        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
//        open();
//        getWebDriver().manage().window().maximize();
//    }
//
//    public static void setUpAll() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @BeforeEach
//    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    public void TestProd() throws InterruptedException {
//        int repeticiones = 1;
////         Crear checkboxes para seleccionar los métodos
//        JCheckBox LoginS = new JCheckBox("LoginS");
//        JCheckBox TareasPendientes = new JCheckBox("TareasPendientes-Requiere LoginS");
//        JCheckBox ConsultaSubSecuentes = new JCheckBox("ConsultaSubSecuentes-Requiere LoginS");
//        JLabel Linea = new JLabel("--------------------------------------------------------------");
//        JCheckBox ConsultaEstadoTramFun = new JCheckBox("ConsultaEstadoTramFun");
//
////        LoginS.setSelected(true);  // LoginS activo por defecto
//        Object[] params = {"Seleccione los métodos a ejecutar:", LoginS, TareasPendientes, ConsultaSubSecuentes, Linea, ConsultaEstadoTramFun};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            closeBrowser();
//            return;
//        }
//
//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (LoginS.isSelected()) selectedMethods.add("LoginS");
//        if (TareasPendientes.isSelected()) selectedMethods.add("TareasPendientes");
//        if (ConsultaSubSecuentes.isSelected()) selectedMethods.add("ConsultaSubSecuentes");
//        if (ConsultaEstadoTramFun.isSelected()) selectedMethods.add("ConsultaEstadoTramFun");
//
//        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
//        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
////            Ejecutar métodos seleccionados
//            if (selectedMethods.contains("LoginS")) {
//                LoginS();
//            }
//            if (selectedMethods.contains("TareasPendientes")) {
//                TareasPendientes();
//            }
//            if (selectedMethods.contains("ConsultaSubSecuentes")) {
//                ConsultaSubSecuentes();
//            }
//            if (selectedMethods.contains("ConsultaEstadoTramFun")) {
//                ConsultaEstadoTramFun();
//            }
//
//        }, repeticiones);
//
//        // Preguntar si quiere ejecutar otro proceso
//        int otroProceso = JOptionPane.showConfirmDialog(null, "EL PROCESO TERMINO SI VAS A MANIPULAR LA VENTANA, MINIMIZAR." +
//                "¿Quieres ejecutar otro proceso?", "Continuar", JOptionPane.YES_NO_OPTION);
//
//        // Si elige "Sí", se reinicia el proceso, pero primero cerramos todo y luego volvemos al menú
//        if (otroProceso == JOptionPane.YES_OPTION) {
//            // Cerrar el navegador y cualquier ventana abierta
//            closeBrowser(); // Método para cerrar el navegador
//            initDriver(); //metodo para maximizar ventana
//            // Llamamos a TestProd nuevamente después de cerrar el navegador
//            TestProd();  // Esto reinicia el proceso (recursivamente)
//        } else {
//            // Si elige "No", cerramos todo y salimos
//            closeBrowser(); // Método para cerrar el navegador (si estás utilizando Selenium o Selenide)
//            // Salir de la aplicación
//            System.exit(0);  // Cierra la aplicación y todo el flujo
//        }
//    }
//
//    // Método para cerrar el navegador (usando Selenium o Selenide)
//    public void closeBrowser() {
//        WebDriver driver = getWebDriver();
//        if (driver != null) {
//            driver.quit();  // Cierra el navegador
//        }
//    }
//
//    //Proceso LoginS
//    public void LoginS() {
//        //se asigna el LoginS a ocupar
//        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginS=%22;");
//        //LoginS persona física
//        firmaProdNet.FirmProdS();sleep(300);
//    }
//
//    //Proceso TareasPendientes
//    public void TareasPendientes() {
//        mainpageprod.selecRol.sendKeys("Persona Física");sleep(300);
//        mainpageprod.btnacep.click();sleep(300);
//        mainpageprod.refreshInicio.click();sleep(300);
//    }
//
//    //Proceso ConsultaSubsecuente
//    public void ConsultaSubSecuentes() {
//        // Solicitamos un valor mediante un cuadro de diálogo
//        String folio = "0100400100220241005009389";//JOptionPane.showInputDialog("Ingresa el folio a consultar.:");sleep(300);
//        mainpageprod.selecRol.sendKeys("Persona Física");sleep(300);
//        mainpageprod.btnacep.click();sleep(300);
//        mainpageprod.Tramites.click();sleep(300);
//        mainpageprod.SubSec.click();sleep(300);
//        mainpageprod.folioConsultar.sendKeys(folio);sleep(300);
//        mainpageprod.btnBuscar.click();sleep(300);
//        mainpageprod.tramiteSub.doubleClick();sleep(300);
//    }
//
//    //Proceso ConsultaEstadoTramFun
//    public void ConsultaEstadoTramFun() {
//        // Se asigna el LoginS a ocupar
//        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        // LoginF persona física
//        firmaProdNet.FirmProdF();sleep(300);
//
//        String folioET = null; boolean folioValido = false;
//
//        // Preguntar por el folio hasta que sea válido
//        while (!folioValido) {
//            // Preguntar al usuario si quiere ingresar el folio manual o automático
//            String[] options = {"Manual", "Automático"};
//            int seleccion = JOptionPane.showOptionDialog(
//                    null,  // El componente padre
//                    "¿Cómo deseas ingresar el folio?",  // Mensaje
//                    "Seleccionar método de ingreso",  // Título de la ventana
//                    JOptionPane.DEFAULT_OPTION,  // Opción por defecto
//                    JOptionPane.INFORMATION_MESSAGE,  // Tipo de mensaje
//                    null,  // Icono
//                    options,  // Opciones
//                    options[0]  // Opción predeterminada (Manual)
//            );
//
//            // Si elige "Manual"
//            if (seleccion == 0) {
//                folioET = "0201300101820259901009230"; //JOptionPane.showInputDialog("Ingresa el folio a consultar:");
//                // Si el usuario cancela el input (presiona 'Cancelar'), folioET será null
//                if (folioET == null || folioET.isEmpty()) {
//                    int reintentar = JOptionPane.showConfirmDialog(
//                            null,
//                            "No ingresaste un folio. ¿Quieres intentarlo de nuevo?",
//                            "Reintentar",
//                            JOptionPane.YES_NO_OPTION
//                    );
//                    // Si decide no reintentar, se sale del bucle
//                    if (reintentar == JOptionPane.NO_OPTION) {
//                        return;
//                    }
//                } else {
//                    folioValido = true;  // Si el folio es válido, se sale del bucle
//                }
//            }
//            // Si elige "Automático"
//            else if (seleccion == 1) {
//                boolean estatusValido = false;
//                // Preguntar si el folio es "Iniciado", "Finalizado" o "Regresar"
//                while (!estatusValido) {
//                    String[] estatusOptions = {"Iniciado", "Finalizado", "Regresar"};
//                    int estatusSeleccion = JOptionPane.showOptionDialog(
//                            null,  // El componente padre
//                            "¿Qué tipo de folio deseas?",  // Mensaje
//                            "Seleccionar estatus de folio",  // Título de la ventana
//                            JOptionPane.DEFAULT_OPTION,  // Opción por defecto
//                            JOptionPane.INFORMATION_MESSAGE,  // Tipo de mensaje
//                            null,  // Icono
//                            estatusOptions,  // Opciones
//                            estatusOptions[0]  // Opción predeterminada (Iniciado)
//                    );
//
//                    // Si elige "Iniciado"
//                    if (estatusSeleccion == 0) {
//                        folioET = ConexionBD.consultaEstatusInicial();
//                        if (folioET == null || folioET.isEmpty()) {
//                            JOptionPane.showMessageDialog(null, "No se obtuvo un folio automático válido.");
//                            continue;  // Si no hay folio válido, vuelve a preguntar
//                        } else {
//                            folioValido = true;  // Si el folio automático es válido, se sale del bucle
//                            estatusValido = true;  // Salir del bucle de selección de estatus
//                        }
//                    }
//                    // Si elige "Terminado"
//                    else if (estatusSeleccion == 1) {
//                        folioET = ConexionBD.consultaEstatusTerminal();
//                        if (folioET == null || folioET.isEmpty()) {
//                            JOptionPane.showMessageDialog(null, "No se obtuvo un folio automático válido.");
//                            continue;  // Si no hay folio válido, vuelve a preguntar
//                        } else {
//                            folioValido = true;  // Si el folio automático es válido, se sale del bucle
//                            estatusValido = true;  // Salir del bucle de selección de estatus
//                        }
//                    }
//                    // Si elige "Regresar", regresa al paso anterior (selección Manual o Automático)
//                    else if (estatusSeleccion == 2) {
//                        folioValido = false;  // Vuelve a preguntar si quiere ingresar el folio manual o automático
//                        break;  // Sale del bucle de selección de estatus y vuelve a preguntar la entrada del folio
//                    }
//                }
//            }
//        }
//
//        // Procedemos con la consulta usando el folioET obtenido
//        mainpageprod.Consultas.click(); sleep(300);
//        mainpageprod.DespConsultas.click(); sleep(300);
//        mainpageprod.ConsultEstTram.click(); sleep(300);
//        mainpageprod.FolioConsultar.sendKeys(folioET); sleep(300);
//        mainpageprod.btnBuscarFolio.click(); sleep(1200);
//    }
//
//    //Metodo que ejecuta n veces una clase que implementa Runnable
//    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.println("Ejecución del Proceso: " + (i + 1));
//            proceso.run();  // Ejecuta el proceso de la clase
//        }
//
//    }
//}
//


//para que se ejecute 10 veces
//        package TestProd;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.*;
//import Firmas.*;
//import TestProd.MainPageProd;
//import com.codeborne.selenide.Browsers;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import com.codeborne.selenide.Configuration;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
//
//public class MainPageProdTest {
//    MainPageProd mainpageprod = new MainPageProd();
//    FirmaProdNet firmaProdNet = new FirmaProdNet();
//
//    @BeforeAll
//    public static void initDriver() {
//        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
//        open();
//        getWebDriver().manage().window().maximize();
//    }
//
//    public static void setUpAll() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @BeforeEach
//    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    public void TestProd() throws InterruptedException {
//        int repeticiones = 10; // Número de repeticiones para ejecutar los métodos
//
//        // Ejecutar los procesos en el orden especificado y repetidos 10 veces
//        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
//            LoginS();            // Ejecución de LoginS
//            ConsultaSubSecuentes(); // Ejecución de ConsultaSubSecuentes
//            ConsultaEstadoTramFun(); // Ejecución de ConsultaEstadoTramFun
//        }, repeticiones); // Ejecutar 10 veces
//
//        // No es necesario preguntar al usuario si desea ejecutar otro proceso,
//        // el proceso ya se ejecuta 10 veces y termina aquí
//        closeBrowser();  // Cerrar el navegador después de las 10 repeticiones
//        System.exit(0);  // Salir de la aplicación
//    }
//
//    // Método para cerrar el navegador (usando Selenium o Selenide)
//    public void closeBrowser() {
//        WebDriver driver = getWebDriver();
//        if (driver != null) {
//            driver.quit();  // Cierra el navegador
//        }
//    }
//
//    // Proceso LoginS
//    public void LoginS() {
//        //se asigna el LoginS a ocupar
//        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginS=%22;");
//        //LoginS persona física
//        firmaProdNet.FirmProdS();sleep(300);
//    }
//
//    // Proceso ConsultaSubSecuentes
//    public void ConsultaSubSecuentes() {
//        // Solicitamos un valor mediante un cuadro de diálogo
//        String folio = "0100400100220241005009389";//JOptionPane.showInputDialog("Ingresa el folio a consultar.:");sleep(300);
//        mainpageprod.selecRol.sendKeys("Persona Física");sleep(300);
//        mainpageprod.btnacep.click();sleep(300);
//        mainpageprod.Tramites.click();sleep(300);
//        mainpageprod.SubSec.click();sleep(300);
//        mainpageprod.folioConsultar.sendKeys(folio);sleep(300);
//        mainpageprod.btnBuscar.click();sleep(300);
//        mainpageprod.tramiteSub.doubleClick();sleep(300);
//    }
//
//    // Proceso ConsultaEstadoTramFun
//    public void ConsultaEstadoTramFun() {
//        // Se asigna el LoginS a ocupar
//        open("https://www.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        // LoginF persona física
//        firmaProdNet.FirmProdF();
//        sleep(300);
//
//        String folioET = null;
//        boolean folioValido = false;
//
//        // Preguntar por el folio directamente
//        while (!folioValido) {
//            folioET = "0201300101820259901009230"; //JOptionPane.showInputDialog("Ingresa el folio a consultar:");
//
//            // Si el usuario cancela el input (presiona 'Cancelar') o no ingresa nada
//            if (folioET == null || folioET.isEmpty()) {
//                int reintentar = JOptionPane.showConfirmDialog(
//                        null,
//                        "No ingresaste un folio. ¿Quieres intentarlo de nuevo?",
//                        "Reintentar",
//                        JOptionPane.YES_NO_OPTION
//                );
//                // Si decide no reintentar, se sale del bucle
//                if (reintentar == JOptionPane.NO_OPTION) {
//                    return;
//                }
//            } else {
//                folioValido = true;  // Si el folio es válido, se sale del bucle
//            }
//        }
//
//        // Procedemos con la consulta usando el folioET obtenido
//        mainpageprod.Consultas.click(); sleep(300);
//        mainpageprod.DespConsultas.click(); sleep(300);
//        mainpageprod.ConsultEstTram.click(); sleep(300);
//        mainpageprod.FolioConsultar.sendKeys(folioET); sleep(300);
//        mainpageprod.btnBuscarFolio.click(); sleep(1200);
//    }
//
//    // Metodo que ejecuta n veces una clase que implementa Runnable
//    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.println("Ejecución del Proceso: " + (i + 1));
//            proceso.run();  // Ejecuta el proceso de la clase
//        }
//    }
//}

//
//
//
