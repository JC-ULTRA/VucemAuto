package Economia.Tramite110214;

import DBYFOLIO.ObtenerFolio;
import Economia.Tramite110214.MainPage110214;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage110214Test {
    MainPage110214 mainPage110214 = new MainPage110214();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite110214  = new TramitesFirmasLG(
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
    public void Proceso110214() throws IOException {
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


        //Elegir Renovacion Modalidad IVA e IEPS
        JRadioButton PeriodoRadio = new JRadioButton("Periodo");
        JRadioButton SolaImportacionRadio = new JRadioButton("Una sola importación");


        ButtonGroup groupOpciones = new ButtonGroup();
        groupOpciones.add(PeriodoRadio);
        groupOpciones.add(SolaImportacionRadio);
/*
        JCheckBox DatosNoConfidencialesProductor = new JCheckBox("¿Los datos del productor son confidenciales?");
        JCheckBox ExportadorProductorNoMismaPersona= new JCheckBox("¿Exportador y Productor son la misma persona?");

        groupOpciones.add(DatosNoConfidencialesProductor);
        groupOpciones.add(ExportadorProductorNoMismaPersona);
*/
        Object[] params = {"Seleccione la opcion deseada:", PeriodoRadio, SolaImportacionRadio};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Validación inicial de circulacuón de mercancías", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }


        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {

            //Generar Factura aleatoria
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 7;
            String FacturaGenerada = uuid.replace("-", "").substring(0, longitudDeseada);

            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);


            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite110214); sleep(1000);
            mainPage110214.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage110214.btnacep.click(); sleep(1000);
            mainPage110214.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage110214.SoliNew.click(); sleep(1000);
            mainPage110214.Economia.click(); sleep(1000);
            mainPage110214.CertOrigen.click(); sleep(1000);
            mainPage110214.ValidacionCertificado.click(); sleep(1000);
            mainPage110214.elementoTramite110214.click(); sleep(1000);

            // Seccion Certificado origen
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110214.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110214.tabCertificadoOrigen.click();
            //Seleccion de radio botones
            if (PeriodoRadio.isSelected()) {
                mainPage110214.radbtnPeriodo.click(); sleep(1000);
            }
            if (SolaImportacionRadio.isSelected()) {
                mainPage110214.radbtnUnaImpresion.click(); sleep(1000);
            }
            //Datos Generales
            mainPage110214.TratadoAcuerdo.sendKeys("Tratado de Libre Comercio México-Uruguay");
            mainPage110214.PaisBloque.selectOption("URUGUAY (REPUBLICA ORIENTAL DEL)");
            mainPage110214.btnBuscarmercancia.click();
            mainPage110214.filaMercanciaDisponible.doubleClick();

            //Agregar datos Mercancia
            mainPage110214.Cantidad.sendKeys("80");
            mainPage110214.selectUMC.sendKeys("Kilogramo");
            mainPage110214.ValorMercancia.sendKeys("8000");
            mainPage110214.ComplementoDescripcion.sendKeys("QA Descripcion");
            mainPage110214.NumeroSerieMerc.sendKeys("109090");
            //Campos que se muestra del flujo Sola Importanción
            if (SolaImportacionRadio.isSelected()) {
                Selenide.executeJavaScript("arguments[0].value = arguments[1];", mainPage110214.fechaFactura, fechaHoy);sleep(1000);
                mainPage110214.NumeroFactura.sendKeys(FacturaGenerada);
                //mainPage110214.selectTipoFactura.shouldBe(enabled, Duration.ofSeconds(3)).selectOptionByValue("TIPFAC.M");
                mainPage110214.selectTipoFactura.sendKeys("Manual");
            }
            mainPage110214.btnAgregarDatosMercancia.click();
            mainPage110214.btnAceptarNotficacionAgrMercancia.click();

            //Seccion Historico Productores
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110214.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110214.tabHistoricoProductores.click();
            mainPage110214.checkDatosProductorNoConfidencial.click();
            mainPage110214.checkExpImpNoMismaPersona.click();
            //Grid Productores por exportador
            mainPage110214.fila1Productor.click();
            mainPage110214.btnSeleccionarAgrProductor.click();
            mainPage110214.fila1ProductorSeleccionado.click();
            mainPage110214.fila1MercanciasSeleccionada.click();
            mainPage110214.fila1ProductorSeleccionado.scrollTo().shouldBe(visible);
            mainPage110214.btnAsignarProductor.click();

            //Sección Destinatario
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage110214.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainPage110214.tabDestinatario.click();
            //Datos del destinatario
            mainPage110214.RFCDestinatario.sendKeys("GOFM951102208");
            mainPage110214.RazonSocialDestinatario.sendKeys("Razón social QA");
            //Domicilio del destinatario
            mainPage110214.CiudadDestinatario.sendKeys("Uruguay");
            mainPage110214.CalleDestinatario.sendKeys("Calle QA");
            mainPage110214.NumeroLetraDestinatario.sendKeys("290");
            //mainPage110214.LadaDestinatario.sendKeys("598");
            mainPage110214.TelefonoDestinatario.sendKeys("5989860830");
            //mainPage110214.FaxDestinatario.sendKeys("5980011448");
            mainPage110214.CorreoDestinatario.sendKeys("qacorreoUruguay@gmail.com");
            //Detalles del representante legal del exportador
            mainPage110214.LugarRepresentante.sendKeys("Ciudad de México");
            mainPage110214.NombreRepresentante.sendKeys("Fernando Gutierrez Lopez QA");
            mainPage110214.EmpresaRepresentante.sendKeys("Empresa QA representante");
            mainPage110214.CargoRepresentante.sendKeys("Jefe departamento QA");
            mainPage110214.TelefonoRepresentante.sendKeys("5561037069");
            mainPage110214.CorreoRepresentante.sendKeys("representanteQA@gmail.com");

            //Sección Datos certificado
            mainPage110214.Paso1Textoreferencia.scrollTo().shouldBe(visible);
            mainPage110214.tabDatosCertificado.click();
            mainPage110214.Observaciones.sendKeys("QA Observaciones");
            mainPage110214.selectIdioma.sendKeys("Español");
            //Representación federal
            mainPage110214.selectEstado.sendKeys("SINALOA");
            mainPage110214.btnContinuar.click();

            //Metodo Firma
            loginFirmSoli.firma(tramite110214);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage110214.folio.getText();

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

