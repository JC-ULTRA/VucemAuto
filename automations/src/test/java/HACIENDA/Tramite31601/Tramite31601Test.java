package HACIENDA.Tramite31601;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Tramite31601Test {
    MainPage31601 mainPage31601 = new MainPage31601();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();

    TramitesFirmasLG tramite31601 = new TramitesFirmasLG(
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
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        ChromeOptions options = new ChromeOptions();

        // Configura las opciones para Chrome: incognito y permitir orígenes remotos
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");  // Abre el navegador en modo incognito

        // Asignar las capacidades de navegador
        Configuration.browserCapabilities = options;
    }

    @Test
    public void Proceso31601() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen31602");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion31602");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion31602");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamenB8");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacionB8");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucionB8");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite31601);
            mainPage31601.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage31601.btnacep.click(); sleep(1000);
            mainPage31601.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage31601.SoliNew.click(); sleep(1000);
            mainPage31601.hacienda.click(); sleep(1000);
            mainPage31601.registroComercioExterior.click(); sleep(1000);
            mainPage31601.solicitudRegistroEsquemaIntegralCertificacion.click(); sleep(1000);
            mainPage31601.tramite31601.click(); sleep(1000);
            mainPage31601.datosComunes.click(); sleep(1000);
            mainPage31601.preOperativNo.click(); sleep(1000);
            mainPage31601.recintoFiscalEstrateg.click(); sleep(1000);
            mainPage31601.sectorProductivo.sendKeys("Fabricación de equipo ferroviario"); sleep(1000);
            mainPage31601.opc1SI.click(); sleep(1000);
            mainPage31601.opc2SI.click(); sleep(1000);
            mainPage31601.opc3SI.click(); sleep(1000);
            mainPage31601.nEpleados.sendKeys("10"); sleep(1000);
            mainPage31601.bimestres.sendKeys("Mayo-Junio"); sleep(1000);
            mainPage31601.opc4No.click(); sleep(1000);
            mainPage31601.opc5No.click(); sleep(1000);
            mainPage31601.opc6No.click(); sleep(1000);
            mainPage31601.opc7si.click(); sleep(1000);
            mainPage31601.opc8No.click(); sleep(1000);
            mainPage31601.opc9Si.click(); sleep(1000);
            mainPage31601.opc10No.click(); sleep(1000);
            mainPage31601.opc11Autorizacion.sendKeys("42025 - Autorización Programa Nueva Industrial"); sleep(1000);
            mainPage31601.btnAgregar.click(); sleep(1000);
            mainPage31601.entidadFederativa.sendKeys("SINALOA"); sleep(1000);
            mainPage31601.checkInstalaciones.click(); sleep(1000);
            mainPage31601.btnAceptarInstalaciones.click(); sleep(1000);

            mainPage31601.clienteProveedorExtranjero.setValue("C:\\Users\\miste\\OneDrive\\Escritorio\\alt\\carga_proveedoresExtranjerosIC (1).xls"); sleep(1000);
            mainPage31601.clienteProveedorExtranjeroAnexar.click(); sleep(1500);
            clickOkButton(); sleep(1000);

            mainPage31601.proveedoresNacionales.setValue("C:\\Users\\miste\\OneDrive\\Escritorio\\alt\\carga_proveedoresNacionesIC (1).xls"); sleep(1000);
            mainPage31601.proveedoresNacionalesAnexar.click(); sleep(1500);
            //otra forma para pasar las emergentes
            $$(byText("Ok")).get(1).click();  // Hace clic en el primer elemento con el texto "Ok"
            mainPage31601.querellaNo.click(); sleep(1000);
            mainPage31601.controlInventarioSi.click(); sleep(1000);
            mainPage31601.nombreSistemaDatosIdentificacion.sendKeys("Nombrejhgjk"); sleep(1000);
            mainPage31601.lugarRadicacion.sendKeys("gwegw"); sleep(1000);
            mainPage31601.anexi24Check.click(); sleep(1000);
            mainPage31601.btnAgregarControlInventario.click(); sleep(1500);
            $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click(); sleep(1500);
            mainPage31601.opc12Si.click(); sleep(1500);
            mainPage31601.opc13No.click(); sleep(1500);
            mainPage31601.opc14No.click(); sleep(1500);
            mainPage31601.opc15No.click(); sleep(1500);
            mainPage31601.btnAgregarMiembroEmpresa.click(); sleep(1000);
            mainPage31601.enCaracterDe.sendKeys("Administrador único"); sleep(1000);
            mainPage31601.obligadoTributarMexNo.click(); sleep(1000);
//            mainPage31601.TipPersonaEmpresa.click();sleep(1000);
            mainPage31601.TipPersonaEmpresa.sendKeys("Moral"); sleep(1500);
            mainPage31601.TipPersonaEmpresa.click(); sleep(1500);
            mainPage31601.nombreEmpresa.sendKeys("egwgwegwg"); sleep(1000);
            mainPage31601.nacionalidad.sendKeys("ANTARTIDA"); sleep(1000);
            mainPage31601.btnAceptalEmpresa.click(); sleep(1500);
            // Simular click en pantalla
            mainPage31601.btnAceptalEmpresa2.click();
            sleep(1000);
            mainPage31601.manif1Check.click(); sleep(1000);
            mainPage31601.manif2Check.click(); sleep(1000);

            //Terceros
            mainPage31601.tercerosRelacionados.click();sleep(1000);
            mainPage31601.rfc.sendKeys("LEQI8101314S7");sleep(1000);
            mainPage31601.btnBuscar.click();sleep(1000);
            mainPage31601.btnAceptarRFC.click();

            mainPage31601.btnAgregarTerceroR.click();sleep(1000);
            mainPage31601.rfcTerceroR2.sendKeys("LEQI8101314S7");sleep(1000);
            mainPage31601.btnBuscar2.click();sleep(1000);
            mainPage31601.inputCargo.sendKeys("ascva");sleep(1000);
            mainPage31601.btnAceptar3.click();sleep(1000);

            mainPage31601.datosRegimen.click();sleep(1000);
            mainPage31601.check1No.click();sleep(1000);
            mainPage31601.check2Si.click();sleep(1000);

            mainPage31601.ivaEIepsA.click();sleep(1000);
            mainPage31601.checkSi.click();sleep(1000);
            mainPage31601.checkNo.click();sleep(1000);
            mainPage31601.tipoInversion.sendKeys("Bienes Muebles");sleep(1000);
            mainPage31601.ValorPesos.sendKeys("100");sleep(1000);
            mainPage31601.descripcionGeneral.sendKeys("Sillas");sleep(1000);
            mainPage31601.btnAgregarTerritorioNacional.click();sleep(1000);
            mainPage31601.btnAceptarTerritorio.click();
            mainPage31601.CheckNo.click();sleep(1000);
            mainPage31601.CheckSi.click();sleep(1000);

            mainPage31601.nOperacion.sendKeys("1");sleep(1000);
            mainPage31601.banco.sendKeys("BANAMEX");sleep(1000);
            mainPage31601.llavePago.sendKeys(llavePago);sleep(1000);
            mainPage31601.fechaPago.click();sleep(1000);
            mainPage31601.fechaNum.click();sleep(1000);
            mainPage31601.btnContinuar.click();sleep(1000);
            mainPage31601.btnContinuarDigi.click();sleep(1000);

            mainPage31601.btnAdjuntar.click();sleep(1000);

//            recursosPruebas.Recursos31601();
//            mainPage31601.adjuntarTodos.click();sleep(15000); //Tiempo aprox en cargar los archivos
//            mainPage31601.btnCerrar.click();sleep(1000);
//
//            mainPage31601.btnSiguienteFirmar.click();sleep(1000);
//
//            loginFirmSoli.firma(tramite31601);sleep(5000);


//            // Obtener el texto del folio desde mainPageB8
//            String folioText = mainPage6001.folio.getText();
//
////            Llamar al método para obtener el folio
//            String folioNumber = mainPage31601.getFolio.getText();
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

    public void clickOkButton() {
        // Localiza el botón "Ok" por el texto dentro del <span> y realiza el click
        $(byText("Ok")).shouldBe(visible).shouldHave(text("Ok")).click();
    }

}

