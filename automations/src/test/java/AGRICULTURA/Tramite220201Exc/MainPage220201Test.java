import Firmas.TramitesFirmasLG;

//package AGRICULTURA.Tramite220201Exc;
//
//import DBYFOLIO.ObtenerFolio;
//import Firmas.FirmaSoli;
//import Firmas.LoginFirmSoli;
//import com.codeborne.selenide.Browsers;
//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import javax.swing.*;
//import java.io.File;
//import java.io.IOException;
//
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.Selenide.sleep;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
//public class MainPage220201Test {
//
//    MainPage220201 mainPage220201 = new MainPage220201();
//    LoginFirmSoli loginSoli = new LoginFirmSoli();
//    FirmaSoli firmaSoli = new FirmaSoli();
//    ObtenerFolio obtenerFolio = new ObtenerFolio();
//TramitesFirmasLG tramite220201EX  = new TramitesFirmasLG(
//        "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
//        "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
//);
//
//
//    @BeforeAll
//    public static void initDriver() {
//        Configuration.browser = Browsers.CHROME;   //FIREFOX;
//        open();
//        getWebDriver().manage().window().maximize();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//    }
//
//    @Test
//    public void Procesob8() throws IOException {
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//        // Solicitar el número de repeticiones al usuario a través de un JOptionPane con opción de Cancelar
//        String repeticionesStr = JOptionPane.showInputDialog(null, "Ingrese el número de repeticiones:", "Repeticiones", JOptionPane.QUESTION_MESSAGE);
//
//        // Si el usuario cancela o cierra el cuadro de diálogo, repeticionesStr será null
//        if (repeticionesStr == null) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return; // Termina el método si se selecciona cancelar
//        }
//
//        // Convertir el valor ingresado a entero, manejando posibles excepciones si el usuario no ingresa un número válido
//        int repeticiones;
//        try {
//            repeticiones = Integer.parseInt(repeticionesStr);
//        } catch (NumberFormatException e) {
//            // Si el valor ingresado no es un número válido, asigna un valor por defecto (por ejemplo, 1)
//            repeticiones = 1;
//            JOptionPane.showMessageDialog(null, "Valor no válido, se utilizará 1 repetición por defecto.");
//        }
//        /////////////////////////////////////////////////////////////////////////////////////////////////////////-
//
//        // Abrir un JFileChooser para seleccionar el archivo Excel
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Seleccionar archivo Excel");
//        int userSelection = fileChooser.showOpenDialog(null);
//
//        // Si el usuario selecciona un archivo
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            String excelFilePath = file.getAbsolutePath();
//
//            // Leer los valores desde el archivo Excel
//            String Rol = ExcelReader220201.getRolFromExcel(excelFilePath);
//            String TipSoli = ExcelReader220201.getTipSoliFromExcel(excelFilePath);
//            String AduanaIngreso = ExcelReader220201.getAduanaIngresoFromExcel(excelFilePath);
//            String OficInspec = ExcelReader220201.getOficInspecFromExcel(excelFilePath);
//            String PuntoInspec = ExcelReader220201.getPuntoInspecFromExcel(excelFilePath);
//            String CveUcon = ExcelReader220201.getCveUconFromExcel(excelFilePath);
//            String EstTif = ExcelReader220201.getEstTifFromExcel(excelFilePath);
//            String NomMedVet = ExcelReader220201.getNomMedVetFromExcel(excelFilePath);
//            String NumGuia = ExcelReader220201.getNumGuiaFromExcel(excelFilePath);
//            String Regi = ExcelReader220201.getRegiFromExcel(excelFilePath);
//
//
//        // Ejecutar el proceso con las repeticiones
//            ejecutarProcesoNRunnable(() -> {
//                // Ingreso y selección de trámite
//                 loginFirmSoli.login(tramite220201EX); sleep(1000);
//                mainPage220201.selecRol.sendKeys(Rol); sleep(1000);
//                mainPage220201.btnacep.click(); sleep(1000);
//                mainPage220201.Tramites.sendKeys(TipSoli); sleep(1000);
//                mainPage220201.SoliNew.click(); sleep(1000);
//                mainPage220201.Agricultura.click();
//                mainPage220201.certysol.click();
//                mainPage220201.certImport.click();
//                mainPage220201.Selecttramite220201.click(); sleep(1000);
//                mainPage220201.tramite220201.click();
//                mainPage220201.selectSolicitudClaveAduana.sendKeys(AduanaIngreso);
//                mainPage220201.SolicitudOfiInspecAgrop.sendKeys(OficInspec);
//                mainPage220201.puntoInspec.sendKeys(PuntoInspec);
//                mainPage220201.ClaveUcon.sendKeys(CveUcon);
//                mainPage220201.selectEstabTif.sendKeys(EstTif);
//                mainPage220201.NombreMedVet.sendKeys(NomMedVet);
//                mainPage220201.NumGui.sendKeys(NumGuia);
//                mainPage220201.Regimen.sendKeys(Regi);
//
//
//
//
//
//loginFirmSoli.firma(tramite220201EX); sleep(1000);
//
//
//            }, repeticiones);
//        } else {
//            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
//        }
//    }
//
//    // Metodo que ejecuta n veces una clase que implementa Runnable
//    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.println("Ejecución del Proceso: " + (i + 1));
//            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//            proceso.run();  // Ejecuta el proceso de la clase
//        }
//    }
//}
