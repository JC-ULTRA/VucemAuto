package AGRICULTURA.Tramite220203v2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import Firmas.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.logevents.SelenideLogger;
import DBYFOLIO.ObtenerFolio;
import io.qameta.allure.selenide.AllureSelenide;

public class MainPage220203Test {
    MainPage220203 mainPage220203 = new MainPage220203();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite220203v2  = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
    );

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso220203() {
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

        // Crear checkboxes para seleccionar los métodos
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen220203");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion220203");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion220203");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen220203");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion220203");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion220203");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            realizarLoginYSeleccionDeTramite();

            // Obtener el texto del folio desde MainPageB1
            String folioText = mainPage220203.folio.getText();
            // Llamar al metodo para obtener el folio
            obtenerFolio.obtenerFolio(folioText);


        }, repeticiones);



    }


    public void ejecutarProcesoNRunnable(Runnable proceso, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Ejecución del Proceso: " + (i + 1));
            open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
            proceso.run(); // Ejecuta el proceso de la clase
        }
    }

    private void realizarLoginYSeleccionDeTramite() {
        loginFirmSoli.login(tramite220203v2);
        seleccionarRol("Persona Moral");
        seleccionarTramite("Solicitudes nuevas");
        capturaTramite();
        sleep(5000);
        llenarDatosSolicitud();
        agregarMercancia();
        movilizacion();
        agregarTerceroExportador();
        agregarTerceroDestinatario();
        pagoDerechos();
        loginFirmSoli.firma(tramite220203v2);

    }

    private void seleccionarRol(String rol) {
        mainPage220203.selecRol.sendKeys(rol);
        mainPage220203.btnacep.click();
    }

    private void seleccionarTramite(String tramite) {
        mainPage220203.Tramites.sendKeys(tramite);
        mainPage220203.SoliNew.click();
        mainPage220203.agricultura.click();
    }

    private void capturaTramite() {
        mainPage220203.linkCertificadosSolicitudRequisitos2.click();
        mainPage220203.linkCertificadoParaImportaciSolicitud.click();
        mainPage220203.linkSenasicaSolicitudParaExpedici.click();
    }

    private void llenarDatosSolicitud(){
        sleep(3000);
        mainPage220203.datosSolicitud.click();
        mainPage220203.selectAduana.click();
        mainPage220203.seleccionAduana.click();
        mainPage220203.selectOficina.click();
        mainPage220203.seleccionOficina.click();
        mainPage220203.selectPuntoInspeccion.click();
        mainPage220203.seleccionPunto.click();
        mainPage220203.regimen.click();
        mainPage220203.seleccionRegimen.click();
    }

    private void agregarMercancia(){
        mainPage220203.agregarMercancia.click();
        mainPage220203.tipoRequisito.click();
        mainPage220203.seleccionTipoRequisito.click();
        mainPage220203.requisito.setValue("54");
        mainPage220203.numCertInternacional.setValue("34");
        mainPage220203.selectFraccion.click();
        mainPage220203.seleccionFraccion.click();
        mainPage220203.nico.click();
        mainPage220203.seleccionNico.click();
        mainPage220203.descripccion.setValue("De reptiles");
        mainPage220203.cantidadUmt.setValue("12.00");
        mainPage220203.cantidadUmc.setValue("43.00");
        mainPage220203.selectUmc.click();
        mainPage220203.seleccionUmc.click();
        mainPage220203.uso.click();
        mainPage220203.selectUso.click();
        mainPage220203.numeroLote.setValue("4");
        mainPage220203.especie.setValue("Reptil");
        mainPage220203.paisOrigen.click();
        mainPage220203.seleccionPaisOrigen.click();
        mainPage220203.paisProcedencia.click();
        mainPage220203.seleccionPaisProcedencia.click();
        sleep(3000);
        mainPage220203.guardarMercancia.click();
    }

    private void movilizacion(){
        mainPage220203.datosMovilizacion.click();
        mainPage220203.selectTransporte.click();
        mainPage220203.seleccionTransporte.click();
        mainPage220203.selectPuntoVerificacion.click();
        mainPage220203.seleccionPuntoVerficacion.click();
        mainPage220203.nombreEmpresa.setValue("Mar y Tierra");
        sleep(3000);
        mainPage220203.guardarTransporte.click();
    }

    private void agregarTerceroExportador(){
        mainPage220203.terceros.click();
        mainPage220203.agregarExportador.click();
        mainPage220203.tipoPersona.click();
        mainPage220203.nombre.setValue("Camila");
        mainPage220203.aPaterno.setValue("Lopez");
        mainPage220203.aMaterno.setValue("Juarez");
        mainPage220203.selectPais.click();
        mainPage220203.seleccionPais.click();
        mainPage220203.domicilio.setValue("15 de septiembre no. 43 colonia mijares cp22227");
        sleep(2000);
        mainPage220203.guardarExportador.click();
    }

    private void agregarTerceroDestinatario(){
        mainPage220203.agregarDestinatario.click();
        mainPage220203.checkTipoPersona.click();
        mainPage220203.razonSocial.setValue("Social");
        mainPage220203.selectEstado.click();
        mainPage220203.seleccionEstado.click();
        mainPage220203.selectMunicipio.click();
        mainPage220203.seleccionMunicipio.click();
        mainPage220203.selectColonia.click();
        mainPage220203.seleccionColonia.click();
        mainPage220203.calle.setValue("colima");
        mainPage220203.numeroExterior.setValue("sn");
        sleep(3000);
        mainPage220203.guardarDestinatario.click();
    }

    private void pagoDerechos(){
        mainPage220203.pagoDerechos.click();
        mainPage220203.checkExentoPago.click();
        mainPage220203.selectBanco.click();
        mainPage220203.seleccionBanco.click();
        mainPage220203.llavePago.setValue("2345676");
        mainPage220203.seleccionFecha.click();
        mainPage220203.selectDia.click();
        sleep(3000);
        mainPage220203.guardarSolicitud.click();
    }

}

