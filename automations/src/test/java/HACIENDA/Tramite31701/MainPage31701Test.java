package HACIENDA.Tramite31701;

import DBYFOLIO.ObtenerFolio;
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
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage31701Test {

    MainPage31701 mainPage31701 = new MainPage31701();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite31701  = new TramitesFirmasLG(
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
    public void Proceso32512() throws IOException {
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
        JRadioButton RubroARadio = new JRadioButton("Rubro A");
        JRadioButton RubroAARadio = new JRadioButton("Rubro AA");
        JRadioButton RubroAAARadio = new JRadioButton("Rubro AAA");

        ButtonGroup groupRubro = new ButtonGroup();
        groupRubro.add(RubroARadio);
        groupRubro.add(RubroAARadio);
        groupRubro.add(RubroAAARadio);

        Object[] params = {"Seleccione el Rubro deseado:", RubroARadio, RubroAARadio, RubroAAARadio};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Rubro", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el método
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }


        // Ejecutar el proceso con las repeticiones
        ejecutarProcesoNRunnable(() -> {

            //llave de pago
            String uuid = UUID.randomUUID().toString();
            int longitudDeseada = 16;
            String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);

            //Loging y selección Rol
            loginFirmSoli.login(tramite31701); sleep(1000);
            mainPage31701.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage31701.btnacep.click(); sleep(1000);

            //INICIO FLUJO PRINCIPAL
            mainPage31701.Tramites.sendKeys("Solicitudes nuevas"); sleep(1000);
            mainPage31701.SoliSub.click(); sleep(1000);

            // Solicitar el folio al usuario
            String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

            // Validar que el usuario haya ingresado un folio válido de 25 dígitos
            if (FolioRubro == null  || FolioRubro.length() != 25 || !FolioRubro.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
                return; // Cancelar la operación
            }

            // Confirmar el folio ingresado
            JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);

            //Funcionalidad búsqueda de folio
            mainPage31701.FolioTramite.setValue(FolioRubro);sleep(1000);
            mainPage31701.btnBuscar.click();sleep(1000);
            mainPage31701.FolioGrid.click();
            mainPage31701.FolioGrid.doubleClick(); sleep(3000);

            //Pantalla azul
            mainPage31701.btnSolRenovacion.click();sleep(1000);

            //Pestaña Tipo de Aviso
            mainPage31701.tabAvisoRenovacion.click(); sleep(1000);

            //Paso1
            // Renovación Modalidad IVA e IEPS

           if (RubroARadio.isSelected()) {
                mainPage31701.rdbtnRubroA.click(); sleep(1000);
            }
            if (RubroAARadio.isSelected()) {
                mainPage31701.rdbtnRubroAA.click(); sleep(1000);
            }
            if (RubroAAARadio.isSelected()) {
                mainPage31701.rdbtnRubroAAA.click(); sleep(1000);
            }

            mainPage31701.rdbtnBajoProtest.click(); sleep(1000);
            mainPage31701.rdbtnConEnvio.click(); sleep(1000);
            mainPage31701.rdbtnCircunstanc.click(); sleep(1000);

            //Pago de derechos
            mainPage31701.NumOperac.sendKeys("TestNumOperac1");sleep(1000);
            mainPage31701.listBanco.sendKeys("BANCA MIFEL");sleep(1000);
            mainPage31701.inpLLavePago.sendKeys(llavePago);sleep(1000);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage31701.FechaPago); sleep(1000);
            mainPage31701.btnContinuar.click(); sleep(1000);

            //Paso2
            mainPage31701.btnContinuar2.click();sleep(1000);

            //Paso3
            mainPage31701.btnAdjuntarDoc.click(); sleep(1000);

            //Sub Paso 3 Adjuntar Documentos
            mainPage31701.btnSelecArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31701.btnAdjuntar2.click(); sleep(3000);
            mainPage31701.btnCerrar3.click();sleep(1000);
            mainPage31701.continuarSoli.click();
            loginFirmSoli.firma(tramite31701);
            /*
            //BEGIN FLUJO CONTINUACION (REQUIERE NUMERO SOLICITUD)

            //Flujo Alterno (Ya con datos)
            mainPage31701.SolicitudesMen.click(); sleep(1000);
            mainPage31701.IdSolicitud.sendKeys("202770810");
            mainPage31701.btnBuscarAlter.click(); sleep(1000);
            mainPage31701.IdSolGrid.click();
            mainPage31701.IdSolGrid.doubleClick(); sleep(3000);

            //Paso1
            mainPage31701.tabAvisoRenovacion.click(); sleep(1000);
            if (RubroARadio.isSelected()) {
                mainPage31701.rdbtnRubroA.click(); sleep(1000);
            }
            if (RubroAARadio.isSelected()) {
                mainPage31701.rdbtnRubroAA.click(); sleep(1000);
            }
            if (RubroAAARadio.isSelected()) {
                mainPage31701.rdbtnRubroAAA.click(); sleep(1000);
            }

            mainPage31701.btnContinuar.click(); sleep(1000);
            //Paso2
            mainPage31701.btnContinuar2.click();sleep(1000);
            //Paso3
            mainPage31701.comboDocumentoGrid.sendKeys("Lorem_ipsum.pdf"); sleep(1000);
            mainPage31701.btnContinuar3.click(); sleep(1000);

            //END FLUJO ALTERNO

           */
//            //Paso3 (Continuacion)
//            mainPage31701.comboDocumentoGrid.sendKeys("Lorem_ipsum.pdf"); sleep(1000);
//            mainPage31701.btnContinuar3.click(); sleep(1000);

            //END FLUJO PRINCIPAL ANTES DE FIRMAR


/*
            // Obtener el texto del folio desde mainPageB8

            //Prueba de manejo tiempo
            /*try {
                // Espera hasta que el folio esté presente y visible
                mainPage31701.folio.shouldBe(Condition.exist, Duration.ofSeconds(90));
                mainPage31701.folio.shouldBe(Condition.visible, Duration.ofSeconds(90));

                // Obtener el texto del folio
                String folioText = mainPage31701.folio.getText();
                //Llamar al metodo para obtener el folio
                String folioNumber = obtenerFolio.obtenerFolio(folioText);
            } catch (Exception e) {
                System.out.println("El folio no se pudo encontrar después de 90 segundos.");
                // Maneja el error según sea necesario
            }*/

            // Obtener el texto del folio
            String folioText = mainPage31701.folio.getText();
            //Llamar al metodo para obtener el folio
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
