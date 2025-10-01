package HACIENDA.Tramite319;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage319Test {
    MainPage319 mainPage319 = new MainPage319();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite319  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key"
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
    public void Proceso319() {
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
//        //Crear checkboxes para seleccionar los métodos
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen319");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion319");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion319");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }
//
//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen319");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion319");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion319");
//


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados

        ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite319);
            mainPage319.selecRol.sendKeys("Persona Física");sleep(1000);
            mainPage319.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Administración General de Aduanas']").click();sleep(1000);
            $(withText("Registros de Comercio Exterior")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Operaciones de Comercio Exterior")).click();sleep(1000);
            $$(By.cssSelector("a[role='presentation']")).findBy(text("Operaciones de Comercio Exterior")).click();sleep(1000);
            $("[name='solicitud.numeroRegistro']").sendKeys("Histórica");sleep(1000);
            $("[name='Agregar']").click();sleep(1000);
            $("[name='historico.periodo']").sendKeys("2014 a la fecha");sleep(1000);
            $("[id='periodoInicio']").sendKeys(generarFechaAleatoriaMesAnio());sleep(1000);
            $("[id='periodoFin']").sendKeys(obtenerMesAnterior());sleep(1000);
            $("[name='botonAgregar']").click();sleep(1000);
            $$("button").findBy(Condition.exactText("Aceptar")).click();
            $("[id='guardarSolicitud']").click();sleep(1000);
            loginFirmSoli.firma(tramite319);
            String folioText = mainPage319.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

        }, repeticiones);
    }

    //Genera fecha aleatoria en formato MMyyyy del mes anterior al actual
    public static String obtenerMesAnterior() {
        LocalDate fecha = LocalDate.now().minusMonths(1); // Restar un mes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyyyy");
        return fecha.format(formatter);
    }

    //Genera fecha aleatoria en formato MMyyyy de los últimos 6 años, excluyendo el mes actual
    public static String generarFechaAleatoriaMesAnio() {
        LocalDate hoy = LocalDate.now();
        LocalDate haceSeisAnios = hoy.minusYears(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyyyy");

        String resultado;
        int mesActual = hoy.getMonthValue();

        do {
            long inicio = haceSeisAnios.toEpochDay();
            long fin = hoy.toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(inicio, fin + 1);

            LocalDate fechaAleatoria = LocalDate.ofEpochDay(randomDay);
            resultado = fechaAleatoria.format(formatter);

        } while (Integer.parseInt(resultado.substring(0, 2)) == mesActual);
        // Repite si el mes coincide con el actual

        return resultado;
    }

    //Metodo que ejecuta n veces una clase que implementa Runnable
    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            iniDriver();
            proceso.run();  // Ejecuta el proceso de la clase
        }
    }

}
