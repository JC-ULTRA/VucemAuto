package HACIENDA.Tramite32608;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import HACIENDA.Tramite32608.MainPage32608;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage32608Test {

    MainPage32608 mainPage32608 = new MainPage32608();
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
    public void Proceso32608() throws IOException {
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


        ejecutarProcesoNRunnable(() -> {

            // Obtener la fecha de hoy formateada
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = hoy.format(formatter);

            desactivarPago();
            loginFirmSoli.login(tramite32608);
            mainPage32608.selecRol.sendKeys("Persona Moral");
            Selenide.sleep(1000);
            mainPage32608.btnacep.click();
            Selenide.sleep(1000);
            mainPage32608.Tramites.sendKeys("Solicitudes nuevas");
            Selenide.sleep(1000);
            mainPage32608.SoliNew.click();
            Selenide.sleep(1000);
            mainPage32608.Hacienda.click();
            Selenide.sleep(1000);
            mainPage32608.menuAGACERegistroCE.click();sleep(1000);
            mainPage32608.submenuSREIC.click();
            Selenide.sleep(1000);
            mainPage32608.elemTramite32608.click();
            Selenide.sleep(1000);
            Selenide.executeJavaScript("window.scrollTo(0, 0);", new Object[0]);

            //Llenado de datos
            //Datos comunes
            mainPage32608.tabDatosComunes.click();sleep(1000);
            mainPage32608.listSectorProduct.sendKeys("Fabricación de artículos de oficina");sleep(1000);
            mainPage32608.listServicio.sendKeys("Servicios de agencias aduanales");//sleep(1000);
            mainPage32608.radSicumplimientoObligaciones.click();//sleep(1000);
            mainPage32608.radSiAutorizarSatOpinion.click();//sleep(1000);
            mainPage32608.radSiEmpleadosIMSS.click();//sleep(1000);
            // Inicio LLenado para campos IMSS
            mainPage32608.NumEmpleadosPropios.sendKeys("10");
            mainPage32608.listBimestreEmpleadosPropios.sendKeys("Enero-Febrero");
            //Fin Llenado IMSS
            mainPage32608.radSiISRTrabajadores.click(); //sleep(1000);
            mainPage32608.radSiPagoObrero.click(); //sleep(1000);
            mainPage32608.radSiSubcontraServEspecial.click(); //sleep(1000);

            //Inicio Agregar Empleado
            mainPage32608.agregarSubcontratado.click();//sleep(1000);
            mainPage32608.rfcSubcontratado.sendKeys("MAVL621207C95"); //sleep(1000);
            mainPage32608.btnBuscarRfcSubcontratado.click();
            mainPage32608.numEmpleadosSubcontratados.sendKeys("10"); //sleep(10000);
            mainPage32608.bimestreEmpleadosSubcontratados.sendKeys("Enero-Febrero");sleep(1000);
            mainPage32608.btnAñadirSubcontratados.click();
            mainPage32608.btnAceptarSubcontratados.click();
            //FIn Agregar Empleado
            mainPage32608.radSiRegistroPadron.click();
            mainPage32608.radNoArticulo69.click();
            mainPage32608.radNoArticulo69BCFF.click();
            mainPage32608.radNoArticulo69BBis.click();
            mainPage32608.radSiSellosVigentes.click();
            mainPage32608.radNoInfracArt17HBis.click();

            //Seccion Lista 2 y Tabla
            mainPage32608.listDomicilioRegistrado.sendKeys("802024- Autorización Programa Nuevo Servicio");
            //Agregar Instalacion
            mainPage32608.btnAgregarInstalaciones.click();
            mainPage32608.listEntidadInstalacion.sendKeys("AGUASCALIENTES");
            mainPage32608.seleccionarInstalacion.click();
            mainPage32608.btnAceptarInstalaciones.click();

            //Begin Flujo Modificar Instalación
            mainPage32608.selecInstalacionAModificar.click();
            mainPage32608.btnmodificarInstalacion.click();
            mainPage32608.radSiInstalacionPrincipal.click();
            mainPage32608.listTipoInstalacion.sendKeys("Planta Productiva");
            mainPage32608.radSiProcesoProductivo.click();
            mainPage32608.radSiUsoGoceInmueble.click();
            mainPage32608.radNoPerfilEmpresa.click();
            mainPage32608.radSiComercioExterior.click();
            mainPage32608.radSiReconocimientoMutuo.click();
            mainPage32608.btnAceptarModificacion.click();
            mainPage32608.btnAceptarodNotificacionMod.click();
            //End Flujo

            mainPage32608.radSiArticulo17K.click();sleep(1000);
            mainPage32608.radNoSuspesionPadron.click();sleep(1000);

            //CLientes y Proveedores en el Extranjero
            mainPage32608.ProvedoresExtranjeros.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage32608.btnAgregarProvedoresExtranjeros.click();sleep(1000);
            mainPage32608.btnOKClientProvNotificacion.click();
            //Proveedores
            mainPage32608.ProvedoresNacionales.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIC (1).xls");
            mainPage32608.btnAgregarProvedoresNacionales.click();sleep(1000);
            mainPage32608.btnOkProvedoresNacionales.click();sleep(1000);

            //Querella
            mainPage32608.radNoQuerella.click();sleep(1000);

            //Control Inventarios
            mainPage32608.radSiInventarios.click();sleep(1000);
            mainPage32608.NombreInventarios.sendKeys("TestIdentificación");
            mainPage32608.LugarInventarios.sendKeys("TestLugar");
            mainPage32608.checkAnexo24Inventarios.click();
            mainPage32608.btnAgregarInventario.click();
            mainPage32608.btnAceptarInventariosNtf.click();
            mainPage32608.radSiRMF.click();

            //Agregar miembro de la empresa
            mainPage32608.inputAgregarSocio.click();
            mainPage32608.selectSocioCaracter.sendKeys("Administrador único");
            mainPage32608.inputSocioTributarMexico.click();
            mainPage32608.inputSocioBusqueda.sendKeys("LEQI8101314S7");
            mainPage32608.inputBuscar2.click();
            mainPage32608.selectSocioNacionalidad.sendKeys("AZERBAIJAN (REPUBLICA AZERBAIJANI)");
            mainPage32608.inputSocioAgregarModal.click();
            mainPage32608.btnAceptarMiembroNtf.click();
            mainPage32608.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage32608.inputAcepto.click();
            mainPage32608.inputAcepto2.click();

            //terceros relacionados
            //TERCERO RELACIONADO
            mainPage32608.labelTercerosRelacionados.click();
            mainPage32608.inputTercero.sendKeys("LEQI8101314S7");sleep(500);
            mainPage32608.inputBuscar3.click();sleep(500);
            mainPage32608.spanAceptar8.click();
            mainPage32608.inputAgregarEnlaceOperativo.click();
            mainPage32608.input.sendKeys("LEQI8101314S7");
            mainPage32608.inputBuscarEnlaceOperativo.click();
            mainPage32608.inputAceptarEnlace.click();
            mainPage32608.inputAgregarEnlaceOperativo.click();
            mainPage32608.input.sendKeys("FOGI720331SIA");
            mainPage32608.inputBuscarEnlaceOperativo.click();
            mainPage32608.inputTerceroEnlaceOperativoSuplente.click();
            mainPage32608.inputAceptarEnlace.click();

            //SECIIT
            mainPage32608.tabSECIIT.click();
            mainPage32608.radbtnSiOperacionesExteriores.click();
            //Pago de derecho
            Selenide.executeJavaScript("arguments[0].value = '01/04/2023';", mainPage32608.fechaInicioOperacionesExt);
            Selenide.executeJavaScript("arguments[0].value = '01/04/2025';", mainPage32608.fechaPagoDerecho);
            mainPage32608.MontoDerecho.sendKeys("38797");
            mainPage32608.NumeroOperacionBancaria.sendKeys("31456fll");
            mainPage32608.LLavePago.sendKeys("5446epp");

            //Ventana Agregar transportista
            mainPage32608.inputAgregarTransportista.click();
            mainPage32608.inputTransportistaCertificacion.sendKeys("AAL0409235E6");
            mainPage32608.inputBuscarEmpresa.click();
            mainPage32608.inputGuardarTransportista.click();
            mainPage32608.btnAceptarTransportistaNtf.click();
            mainPage32608.radbtnSiProgramaIMMEX.click();
            mainPage32608.NumeroImmex.sendKeys("2434");
            mainPage32608.ModalidadImmex.sendKeys("Industrial");
            mainPage32608.radbtnSiRegistroEsquemaCer.click();
            //LLenado Articulo 100A
            mainPage32608.radbtnSiArticulo100A.click();
            mainPage32608.AutorizacionPrevista100A.sendKeys("o");
            Selenide.executeJavaScript("arguments[0].value = '09/04/2025';", mainPage32608.fechaRegistro100A);
            mainPage32608.NumeroAutorizacion.sendKeys("64533");
            mainPage32608.radbtnSiAnexo24.click();
            //Seleccione y acredite al menos uno de los siguientes supuestos
            mainPage32608.checkMilTrabajadores.click();
            mainPage32608.NumTrabajadores.sendKeys("2000");
            mainPage32608.checkActivosfijos.click();
            mainPage32608.ValorMaquinariaEquipo.sendKeys("3000000000");
            mainPage32608.checkCotizarMercados.click();
            mainPage32608.radbtnSiSistemaRastreo.click();
            mainPage32608.radbtnSiSistemaControl.click();
            mainPage32608.radbtnSiAutorizo.click();
            mainPage32608.radbtnInfoPrivada.click();

            //CTPAT
            Selenide.executeJavaScript("window.scrollTo(0, 0);", new Object[0]);
            mainPage32608.tabCTPAT.click();
            mainPage32608.radbtnSiAutorizaCTPAT.click();
            mainPage32608.radbtnSicertificacionCTPAT.click();
            mainPage32608.radbtnNoFechaCancelacionSuspencion.click();
            mainPage32608.btnSiguientePaso1.click();

            //Paso 2
            mainPage32608.btnContinuarPaso2.click();

            //Paso 3 Agregar documentos
            mainPage32608.btnAdjuntarDoc.click();sleep(1000);

            //Sub Paso 3
            mainPage32608.btnSelectArchivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnSelectArchivo17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage32608.btnAdjuntar2.click();sleep(2000);
            mainPage32608.MensajeCarga.shouldNotBe(Condition.visible, Duration.ofSeconds(30));
            mainPage32608.btnCerrar3.click();sleep(1000);

            //Paso 3 (Continuacion)
            mainPage32608.btnContinuar3.click();

            //Firma
            loginFirmSoli.firma(tramite32608);sleep(4000);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage32608.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);

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