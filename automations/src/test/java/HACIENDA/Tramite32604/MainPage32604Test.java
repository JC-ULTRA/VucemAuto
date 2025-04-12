package HACIENDA.Tramite32604;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
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

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage32604Test {
        MainPage32604 mainPage32604 = new MainPage32604();
        LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
        ObtenerFolio obtenerFolio = new ObtenerFolio();
        //VARIABLES
        String FunRFC = "MAVL621207C95";
        String SoliRFC = "AAL0409235E6";

        TramitesFirmasLG tramite32604  = new TramitesFirmasLG(
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
        public void Proceso32604() {
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
            JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen32604");
            JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion32604");
            JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion32604");

            Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
            int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

            // Si el usuario selecciona Cancelar, termina el metodo
            if (option != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
                return;
            }

            // Recopilar los métodos seleccionados
            List<String> selectedMethods = new ArrayList<>();
            if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen32604");
            if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion32604");
            if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion32604");

            // Ejecutar el proceso con las repeticiones y los métodos seleccionados
            ejecutarProcesoNRunnable(() -> {
//            // Ingreso y selección de trámite
                loginFirmSoli.login(tramite32604);
                mainPage32604.selecRol.sendKeys("Persona Moral");
                mainPage32604.btnacep.click();
                mainPage32604.Tramites.sendKeys("Solicitudes nuevas");
                mainPage32604.SoliNew.click();
                mainPage32604.Hacienda.click();
                mainPage32604.linkResgistroComercioExterior.click();
                mainPage32604.linkSolicitudRegistroEIC.click();
                mainPage32604.linkComercializadoraeImportacion.click();sleep(500);
                // Usar Actions para desplazar hacia el elemento (scroll)
                // Agregar un retraso de 3 segundos antes de hacer el scroll (3000 ms = 3 segundos)
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage32604.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage32604.labelSubMenu.click();
                mainPage32604.labelSubMenu2.click();
                //DATOS COMUNES
                mainPage32604.labelDatosComunes.click();
                mainPage32604.selectCatalogoSolicitud.sendKeys("Fabricación de artículos de oficina");
                mainPage32604.radioNo190.click();
                clickAceptarButton();
                mainPage32604.radioSi191.click();
                mainPage32604.radioNo237.click();
                mainPage32604.radioNo238.click();
                mainPage32604.radioSi239.click();
                mainPage32604.radioNo240.click();
                mainPage32604.btnAgregarDomicilios.click();
                mainPage32604.entidadFederativaIDC.sendKeys("SINALOA");
                mainPage32604.jqg_gridDomiciliosModal_5.click(); //Realizar cambio
                mainPage32604.inputAceptarDomicilios.click();sleep(1000);
                mainPage32604.checkDomicilios.click();
                mainPage32604.btnModificarDomicilios.click();sleep(500);
                mainPage32604.siInstalacion.click();
                mainPage32604.inputTipoInstalacion.sendKeys("Planta Productiva");sleep(500);
                mainPage32604.siProcesoProd.click();sleep(500);
                mainPage32604.siAcreditaIn.click();sleep(500);
                mainPage32604.inputAceptarDomicilios2.click();sleep(500);
                mainPage32604.spanAceptar2.click();
                mainPage32604.si243.click();
                mainPage32604.no244.click();
                mainPage32604.archivoInput.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
                mainPage32604.archivoNacionalesInput.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIVAIC.xls");
                mainPage32604.no248RadioButton.click();
                mainPage32604.siInventarioRadioButton.click();
                mainPage32604.nombreInventarioInput.sendKeys("QA");sleep(500);
                mainPage32604.lugarRInventarioInput.sendKeys("QA");sleep(500);
                mainPage32604.btnAgregarInventario.click();sleep(500);
                mainPage32604.spanAceptar.click();
                mainPage32604.si251.click();sleep(500);
                //GRID MIEMBRO DE LA EMPRESA
                mainPage32604.agregarSocio.click();
                mainPage32604.caracterDe.sendKeys("Administrador único");
                mainPage32604.inputSocioTributarMexico.click();
                mainPage32604.selectSocioTipoPersona.sendKeys("Moral");
                mainPage32604.selectSocioTipoPersona.click();
                mainPage32604.inputSocioNombreEmpresa.sendKeys("QA");
                mainPage32604.nacionalidad.sendKeys("BAHREIN");
                mainPage32604.btnSocioAgregarModal.click();sleep(500);
                mainPage32604.aceptarButton.click();sleep(1000);
                mainPage32604.agregarSocio.click();
                mainPage32604.caracterDe.sendKeys("Accionista");
                mainPage32604.inputSocioTributarMexico.click();
                mainPage32604.selectSocioTipoPersona.sendKeys("Física");
                mainPage32604.selectSocioTipoPersona.click();
                mainPage32604.inputSocioNombre.sendKeys("QA");
                mainPage32604.inputSocioApPaterno.sendKeys("QA");
                mainPage32604.inputSocioApMaterno.sendKeys("QA");
                mainPage32604.nacionalidad.sendKeys("BAHAMAS");
                mainPage32604.btnSocioAgregarModal.click();sleep(500);
                mainPage32604.aceptarButton2.click();sleep(1000);
                mainPage32604.agregarSocio.click();
                mainPage32604.caracterDe.sendKeys("Socio");
                mainPage32604.inputSocioTributarMexico.click();
                mainPage32604.selectSocioTipoPersona.sendKeys("Física");
                mainPage32604.selectSocioTipoPersona.click();
                mainPage32604.inputSocioNombre.sendKeys("QA");
                mainPage32604.inputSocioApPaterno.sendKeys("QA");
                mainPage32604.inputSocioApMaterno.sendKeys("QA");
                mainPage32604.nacionalidad.sendKeys("AZERBAIJAN");
                mainPage32604.btnSocioAgregarModal.click();sleep(500);
                mainPage32604.aceptarButton3.click();sleep(1000);
                mainPage32604.si510.click();sleep(1000);
                mainPage32604.aceptarButton4.click();sleep(500);
                mainPage32604.acepto253.click();sleep(500);
                //TERCEROS RELACIONADOS
                mainPage32604.tercerosRelacionadosLabel.click();
                mainPage32604.rfcTerceroInput.sendKeys("LEQI8101314S7");
                mainPage32604.buscarButton.click();sleep(1000);
                mainPage32604.aceptarButton1.click();sleep(500);
                mainPage32604.btnAgregarEnlaceOperativo.click();
                mainPage32604.rfcInput.sendKeys("LEQI8101314S7");
                mainPage32604.buscarEnlaceOperativoButton.click();
                mainPage32604.btnAceptarEnlace.click();
                //MODALIDAD COMERCIALIZADORA E IMPORTADORA
                mainPage32604.modalidadComercializadoraLabel.click();
                mainPage32604.imageCalendar.click();
                mainPage32604.fechaPagoComer.doubleClick();
                mainPage32604.btncerrar.click();
                mainPage32604.montoComer.sendKeys("38797");
                mainPage32604.operacionBan.sendKeys("1234");
                mainPage32604.llavePagoComer.sendKeys("9876542");
                mainPage32604.agregarTransportista.click();
                mainPage32604.inputTransportistaCertificacion.sendKeys("LEQI8101314S7");sleep(500);
                mainPage32604.inputBuscarEmpresa.click();sleep(1000);
                mainPage32604.inputGuardarTransportista.click();sleep(500);
                mainPage32604.spanAceptar1.click();sleep(1000);
                mainPage32604.inputImmex.click();
                mainPage32604.inputAduanas.click();
                mainPage32604.inputGuardarSolicitud.click();
                //REQUISITOS NECESARIOS
                mainPage32604.inputSiguiente.click();
                //ANEXAR REQUISITOS
                mainPage32604.inputAdjuntarDocumentos.click();
                mainPage32604.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(500);
                mainPage32604.buttonAnexar.click();sleep(8000);
                mainPage32604.spanCerrar.click();sleep(500);
                mainPage32604.inputSiguienteButton.click();sleep(500);
                //FIRMAR SOLICITUD
                //loginFirmSoli.firma(tramite32513);
            }, repeticiones);
        }
    public void clickAceptarButton() {
        // Localiza el botón "Aceptar" por el texto dentro del <span> y realiza el click
        $(byText("Aceptar")).shouldBe(visible).shouldHave(text("Aceptar")).click();
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

