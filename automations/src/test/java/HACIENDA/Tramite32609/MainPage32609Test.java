package HACIENDA.Tramite32609;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32609.MainPage32609;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32609Test {

    MainPage32609 mainPage32609 = new MainPage32609();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    TramitesFirmasLG tramite32608  = new TramitesFirmasLG(
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
    public void Proceso32609() throws IOException {
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


        /*

        // Solicitar el folio al usuario
        String FolioRubro = JOptionPane.showInputDialog(null, "Ingrese el número de folio de 25 dígitos:", "Número de Folio", JOptionPane.QUESTION_MESSAGE);

        // Validar que el usuario haya ingresado un folio válido de 25 dígitos
        if (FolioRubro == null || FolioRubro.length() != 25  || !FolioRubro.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El número de folio ingresado no es válido. La operación será cancelada.");
            return; // Cancelar la operación
        }

        // Confirmar el folio ingresado
        JOptionPane.showMessageDialog(null, "Folio válido ingresado: " + FolioRubro);
*/


        ejecutarProcesoNRunnable(() -> {

            //Loging y Seleccion Rol
            loginFirmSoli.login(tramite32608);
            mainPage32609.selecRol.sendKeys("Persona Moral"); sleep(1000);
            mainPage32609.btnacep.click();sleep(1000);

            //Busqueda de tramite
            mainPage32609.Tramites.sendKeys("Solicitudes nuevas");sleep(1000);
            mainPage32609.SoliNew.click();sleep(1000);
            mainPage32609.Hacienda.click();sleep(1000);
            mainPage32609.menuAGACERegistroCE.click();sleep(1000);
            mainPage32609.submenuSREIC.click();sleep(1000);
            mainPage32609.elemTramite32609.click();sleep(1000);

            //Llenado de datos
            //Datos comunes
            mainPage32609.tabDatosComunes.click();sleep(1000);
            mainPage32609.listSectorProduct.sendKeys("Fabricación de artículos de oficina");sleep(1000);
            mainPage32609.listServicio.sendKeys("Servicios de agencias aduanales");//sleep(1000);
            mainPage32609.radSicumplimientoObligaciones.click();//sleep(1000);
            mainPage32609.radSiAutorizarSatOpinion.click();//sleep(1000);
            mainPage32609.radSiEmpleadosIMSS.click();//sleep(1000);
            // LLenado para campos IMSS
            mainPage32609.NumEmpleadosPropios.sendKeys("10");
            mainPage32609.listBimestreEmpleadosPropios.sendKeys("Enero-Febrero");
            //
            mainPage32609.radSiISRTrabajadores.click(); //sleep(1000);
            mainPage32609.radSiPagoObrero.click(); //sleep(1000);
            mainPage32609.radSiSubcontraServEspecial.click(); //sleep(1000);

            //Agregar Empleado
            mainPage32609.agregarSubcontratado.click();//sleep(1000);
            mainPage32609.rfcSubcontratado.sendKeys("MAVL621207C95"); //sleep(1000);
            mainPage32609.btnBuscarRfcSubcontratado.click();sleep(1000);//sleep(1000);
            mainPage32609.numEmpleadosSubcontratados.sendKeys("10"); //sleep(10000);
            mainPage32609.bimestreEmpleadosSubcontratados.sendKeys("Enero-Febrero");sleep(1000);
            mainPage32609.btnAñadirSubcontratados.click();sleep(1000);
            mainPage32609.btnAceptarSubcontratados.click();sleep(1000);

            //

            mainPage32609.radSiRegistroPadron.click();sleep(1000);
            mainPage32609.radNoArticulo69.click();sleep(1000);
            mainPage32609.radNoArticulo69BCFF.click();sleep(1000);
            mainPage32609.radNoArticulo69BBis.click();sleep(1000);
            mainPage32609.radSiSellosVigentes.click();sleep(1000);
            mainPage32609.radNoInfracArt17HBis.click();sleep(1000);


            //Seccion Lista 2 y Tabla
            mainPage32609.listDomicilioRegistrado.sendKeys("82024 - Autoriazión Programa Nuevo Servicio");
            //Agregar Instalacion
            mainPage32609.btnAgregarInstalaciones.click();sleep(1000);
            mainPage32609.listEntidadInstalacion.sendKeys("AGUASCALIENTES"); sleep(1000);
            mainPage32609.seleccionarInstalacion.click(); sleep(1000);
            mainPage32609.btnAceptarInstalaciones.click();sleep(1000);

            //Begin Flujo Modificar Instalación
            mainPage32609.selecInstalacionAModificar.click();sleep(1000);
            mainPage32609.btnmodificarInstalacion.click();sleep(1000);
            mainPage32609.radSiInstalacionPrincipal.click();sleep(1000);
            mainPage32609.listTipoInstalacion.sendKeys("Planta Productiva");
            mainPage32609.radSiProcesoProductivo.click();sleep(1000);
            mainPage32609.radSiUsoGoceInmueble.click();sleep(1000);
            mainPage32609.radNoPerfilEmpresa.click();sleep(1000);
            mainPage32609.radSiComercioExterior.click();sleep(1000);
            mainPage32609.radSiReconocimientoMutuo.click();sleep(1000);
            mainPage32609.btnAceptarModificacion.click();sleep(1000);
            //End Flujo

            mainPage32609.radSiArticulo17K.click();sleep(1000);
            mainPage32609.radNoSuspesionPadron.click();sleep(1000);

            //CLientes y Proveedores en el Extranjero
            mainPage32609.ProvedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32609.btnAgregarProvedoresExtranjeros.click();sleep(1000);

            //Proveedores
            mainPage32609.ProvedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32609.btnAgregarProvedoresNacionales.click();sleep(1000);
            mainPage32609.btnOkProvedoresNacionales.click();sleep(1000);


            //Querella
            mainPage32609.radNoQuerella.click();sleep(1000);

            //Control Inventarios
            mainPage32609.radSiInventarios.click();sleep(1000);
            mainPage32609.NombreInventarios.sendKeys("TestIdentificación");sleep(1000);
            mainPage32609.LugarInventarios.sendKeys("TestLugar");sleep(1000);
            mainPage32609.checkAnexo24Inventarios.click();sleep(1000);








            //Selenide.executeJavaScript("window.scrollTo(0, 0);", new Object[0]);


            //*[@id="docs"]/tbody/tr[8]/td[2]/div/input[2]
            /*
            //Sub Paso 3
            mainPage32608.btnSelecArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnSelecArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnSelecArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnSelecArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnSelecArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnAdjuntar2.click();sleep(7000);
            mainPage32608.btnCerrar3.click();sleep(1000);


            //Paso 3 (Continuacion)
            mainPage32608.listDocumento1Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.listDocumento2Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.listDocumento3Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.listDocumento4Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.listDocumento5Grid.sendKeys("Lorem_ipsum.pdf");sleep(1000);
            mainPage32608.btnContinuar3.click();sleep(1000);
*/
            //Firma
           // loginFirmSoli.firma(tramite32609);sleep(4000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32609.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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
//
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

    public void desactivarPago() {
        String url = "jdbc:oracle:thin:@10.181.233.245:1521/vucprod1";
        String user = "vucem_app_p01";
        String password = "Mfk22nvW6na71DgBXi5R";
        String query = "UPDATE vuc_pago_sea SET BLN_ACTIVO = 0 WHERE linea_de_captura = '032000Q0GHM128445291'";

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("El registro ha sido actualizado correctamente.");
            } else {
                System.out.println("No se encontró el registro con la línea de captura proporcionada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el query: " + e.getMessage());
        }

    }




}