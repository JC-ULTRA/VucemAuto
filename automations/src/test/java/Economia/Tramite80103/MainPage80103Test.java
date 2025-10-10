package Economia.Tramite80103;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.*;
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
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage80103Test {
    MainPage80103 mainPage80103 = new MainPage80103();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite80103 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");
    
    TramitesFirmasLG tramite80103fun = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\mavl621207c95.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredFunc\\MAVL621207C95_1012241424.key");


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
    public void Proceso80103() {
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
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen80103");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion80103");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion80103");
//
//        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }

//        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen80103");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion80103");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion80103");
//

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite80103);
            mainPage80103.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage80103.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Secretaría de Economía']").click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("IMMEX")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Autorización Programa Nuevo")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Autorización Programa Nuevo Albergue ")).click();sleep(15000);
            metodos.scrollDecremento(2);

            //Complementos
            $("[for='captura.tab.complementos']").click();sleep(1000);
            $("[name='solicitud.descripcionSistemasMedicion']").sendKeys("PruebasTest.com.mx");sleep(1000);
            $("[name='solicitud.descripcionLugarEmbarque']").sendKeys("Prueba");sleep(1000);
            $("[id='manifiestoImmex']").click();sleep(1000);
            $("[id='descripcionGenerica1']").sendKeys("Test");sleep(1000);
            $("[id='descripcionGenerica2']").sendKeys("12345432");sleep(1000);
            $("[id='solicitud.establecimientoTIF']").sendKeys("SINALOA");sleep(1000);
            $("[id='numeroDeActa']").sendKeys("123232");sleep(1000);

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaManana = LocalDate.now().plusDays(1).format(formatter2);
           // Obtener la fecha de (hoy+Meses) formateada
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaHoy = LocalDate.now().format(formatter);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaEmiActa, fechaHoy);
            $("[id='rfcRepresentante']").sendKeys("MAVL621207C95");sleep(1000);
//            $("[id='taxIDSocioM']").sendKeys("12345654");sleep(1000);
//            $("[id='razonSocialSocio']").sendKeys("TestQaAutomat");sleep(1000);
//            $("[id='cpSocioM']").sendKeys("95270");sleep(1000);
//            $("[id='correoSocioM']").sendKeys("Ultrasist@pruebas.com");sleep(1000);
//            $("[id='entidadFederativaSocioM']").sendKeys("ANTARTIDA");sleep(1000);
//            $("[id='estadoSocioM']").sendKeys("VERACRUZ");sleep(1000);
//            mainPage80103.btnAgregar.click();sleep(2000);

            //Anexo1
            metodos.scrollDecremento(3);
            $("[for='captura.tab.anexoI']").click();sleep(1000);
            mainPage80103.fraccExport.sendKeys(new CharSequence[]{"03035999"});
            mainPage80103.descripcionExport.sendKeys(new CharSequence[]{"prueba"});
            mainPage80103.agregarExport.click();
            mainPage80103.selecFrac.click();
            mainPage80103.complementarFrac.click();
            mainPage80103.categoriaFrac.sendKeys(new CharSequence[]{"Producto terminado"});
            mainPage80103.valorMoneda.sendKeys(new CharSequence[]{"1"});
            mainPage80103.valorMoneda2.sendKeys(new CharSequence[]{"20"});
            mainPage80103.produccionMensual.sendKeys(new CharSequence[]{"1"});
            mainPage80103.produccionAnual.sendKeys(new CharSequence[]{"24"});
            Selenide.sleep(500L);
            mainPage80103.btnAgregar.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80103.selecFrac.click();
            mainPage80103.complementarCliente.click();
            mainPage80103.paisCliente.sendKeys(new CharSequence[]{"Angola"});
            mainPage80103.rfcCliente.sendKeys(new CharSequence[]{"QWYIE2918921"});
            mainPage80103.razonCliente.sendKeys(new CharSequence[]{"prueba"});
            mainPage80103.btnAgregarProv.click();
            mainPage80103.aceptOperacion.click();
            mainPage80103.btnRegresar.click();
            mainPage80103.selecFrac.click();
            mainPage80103.proyectoImmex.click();
            mainPage80103.tipoDocumento.sendKeys(new CharSequence[]{"Contrato de servicio"});

            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaFirma, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.vigenciaFirma, fechaManana);

            mainPage80103.rfcFirmante.sendKeys(new CharSequence[]{"LEQI8101314S7"});
            mainPage80103.razonFirmante.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80103.agregaFirmante.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80103.btnRegresarPE.click();
            mainPage80103.fraccImportacion.sendKeys(new CharSequence[]{"96011001"});
            mainPage80103.descImportacion.sendKeys(new CharSequence[]{"PRUEBAS"});
            mainPage80103.agregaFraccionImp.click();
            mainPage80103.selecImportacion.click();
            mainPage80103.completarImportacion.click();
            mainPage80103.categoriaImp.sendKeys(new CharSequence[]{"Producto terminado"});
            mainPage80103.valormonedaImp.sendKeys(new CharSequence[]{"1"});
            mainPage80103.valormonedaImp2.sendKeys(new CharSequence[]{"24"});
            mainPage80103.volumenImp.sendKeys(new CharSequence[]{"2"});
            mainPage80103.volumenImpA.sendKeys(new CharSequence[]{"48"});
            mainPage80103.agregarImport.click();
            Selenide.sleep(1000L);
            mainPage80103.aceptarImportaciuon.click();
            mainPage80103.selecImportacion.click();
            mainPage80103.provedorImport.click();
            mainPage80103.paisImport.sendKeys(new CharSequence[]{"ANGUILA"});
            mainPage80103.rfcImport.sendKeys(new CharSequence[]{"WYQTY16162YWA"});
            mainPage80103.razonImport.sendKeys(new CharSequence[]{"PRUEBAS"});
            mainPage80103.agregaProvedorImp.click();
            Selenide.sleep(1000L);
            mainPage80103.aceptarProvedorI.click();
            mainPage80103.regresarProvedorI.click();
            Selenide.sleep(1000L);

            metodos.scrollDecremento(4);
            //Federatarios y Plantas
            $("[for='captura.tab.notarios']").click();sleep(1000);

            $("[id='nombreNotario']").sendKeys("EUROFOODS DE MEXICO");sleep(1000);
            $("[id='apellidoPaterno']").sendKeys("GONZALEZ");sleep(1000);
            $("[id='apellidoMaterno']").sendKeys("PINAL");sleep(1000);
            $("[id='numeroActa']").sendKeys("123456");sleep(1000);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaActa2, fechaHoy);
            $("[id='numeroNotaria']").sendKeys("23456");sleep(1000);
            $("[id='entidadFederativa']").sendKeys("SINALOA");sleep(1000);
            $("[id='municipioDelegacion']").sendKeys("SINALOA");sleep(6000);
            mainPage80103.btnagg.click();sleep(2000);



            $("[id='taxIdEmpresaExt']").sendKeys("12342");sleep(1000);
            $("[id='nombreEmpresaExt']").sendKeys("NOMBRE EMPRESA");sleep(1000);
            $("[id='entidadFederativaEmpresaExt']").sendKeys("ANTARTIDA");sleep(1000);
            $("[id='direccionEmpresaExtranjera']").sendKeys("Dirección Test");sleep(1000);
            mainPage80103.btnagg2.click();sleep(2000);

            $("[id='entidadFederativaPlantasIMMEX']").sendKeys("SINALOA");sleep(1000);
            $("[value='Buscar plantas IMMEX']").click();sleep(1000);
            $("[id='jqg_gridPlantasImmexDisp_1']").click();sleep(1000);
            $("[id='seleccionar_plantas']").click();sleep(1000);
            $("[id='jqg_plantasIMMEX_3']").click();sleep(1000);
//            ---------------------------------------------------------------------------------------
// Complementar Planta
            $("[id='btnAgregarComplemento']").click();sleep(1000);
            $("[id='amparoPrograma']").sendKeys("NO");sleep(1000);
            $("[id='tipoDocumento']").sendKeys("Otro");sleep(1000);
            $("[id='descripcionOtro']").sendKeys("OTRO");sleep(1000);

            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaFirma2, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaFinVig2, fechaManana);
            mainPage80103.agregaComplemento.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            Selenide.sleep(1500L);
            mainPage80103.rfcFirmanteP.sendKeys(new CharSequence[]{"LEQI8101314S7"});
            mainPage80103.tipoFirmante.sendKeys(new CharSequence[]{"Firmante principal"});
            mainPage80103.btnAgregaFirmante.click();
            metodos.scrollDecremento(2);
            mainPage80103.btnAgregaRegresar.click();

            mainPage80103.montosInversion.click();
            mainPage80103.tipoMonto.sendKeys(new CharSequence[]{"Equipo"});
            mainPage80103.cantidadTipo.sendKeys(new CharSequence[]{"1"});
            mainPage80103.descripcionTipo.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80103.valorMonto.sendKeys(new CharSequence[]{"10"});
            mainPage80103.agregarMonto.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80103.regresarMonto.click();

            mainPage80103.empleadosPlanta.click();
            mainPage80103.totalEmpleados.sendKeys(new CharSequence[]{"10"});
            mainPage80103.empleadosDirectos.click();
            mainPage80103.numEmpleadosD.sendKeys(new CharSequence[]{"10"});
            mainPage80103.cedulasEmpleados.sendKeys(new CharSequence[]{"NO"});
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.selecFechaImss, fechaManana);
            mainPage80103.agregarEmpleadosD.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80103.regresarEmpleados.click();

//Capacidad Instalada
            mainPage80103.capacidadInstalada.click();
            mainPage80103.fraccionArancel.sendKeys(new CharSequence[]{"0303599"});
            mainPage80103.turnos.sendKeys(new CharSequence[]{"2"});
            mainPage80103.horasPorTurno.sendKeys(new CharSequence[]{"6"});
            mainPage80103.cantEmpleados.sendKeys(new CharSequence[]{"5"});
            mainPage80103.maquinaria.sendKeys(new CharSequence[]{"2"});
            mainPage80103.descripcionMaquinaria.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80103.capacidadMensual.sendKeys(new CharSequence[]{"1"});
            mainPage80103.capacidadAnual.sendKeys(new CharSequence[]{"12"});
            mainPage80103.capacidadEfectiva.sendKeys(new CharSequence[]{"20"});
            mainPage80103.agregarCapacidad.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80103.regresarCapacidad.click();
            $("[id='representacionesFederalesIMMEX']").sendKeys("DURANGO");sleep(1000);
            $("[id='actividadProductiva']").sendKeys("AGRICULTURA");sleep(1000);
            metodos.scrollDecremento(6);

            //Empresas submanufactureras
            $("[for='captura.tab.empresas']").click();sleep(1000);
            $("[id='rfcEmpresaSubManufacturera']").sendKeys("TSD931210493");sleep(1000);
            $("[id='entidadFederativaEmpresaSub']").sendKeys("QUERETARO");sleep(1000);
            $("[value='Buscar plantas']").click();sleep(1000);
            $("[id='jqg_gridPlantasDispSubMan_1']").click();sleep(1000);
            mainPage80103.AgregarPlanta.click();sleep(1000);
            $("[id='cb_gridPlantasSubSeleccionada']").click();sleep(1000);
            $("[id='btnAgregarCompSub']").click();sleep(1000);
            $("[id='amparoProgramaSub']").sendKeys("SI");sleep(1000);
            $("[id='personaISR']").sendKeys("SI");sleep(1000);
            $("[id='btnAgregarDatosSubmanufacturera']").click();sleep(1000);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);

//Anexo ii y iii
              $("[for='captura.tab.anexos']").click();sleep(1000);
            mainPage80103.fraccionAnexo2.sendKeys(new CharSequence[]{"03044801"});
            mainPage80103.descAnexo2.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80103.agregaAnexo2.click();
            mainPage80103.fraccionAnexo3.sendKeys(new CharSequence[]{"95079099"});
            mainPage80103.descAnexo3.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80103.agregaAnexo3.click();
            mainPage80103.continuarSoli.click();
            Selenide.sleep(1000L);
            mainPage80103.continuarArchivos.click();
            mainPage80103.cargarArchivos.click();
            mainPage80103.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80103.adjuntarArchivos.click();
            Selenide.sleep(20000L);
            mainPage80103.cerrarArchivos.click();
            mainPage80103.continuarFirma.click();
            loginFirmSoli.firma(tramite80103);
            String folioText = mainPage80103.folio.getText();
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
            ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");

            // Ejecutar métodos seleccionados
            ProcesoOp80103(folioNumber);
            RegistrarOp80103(folioNumber);
            Dictamen80103(folioNumber);
            AutorizarDictamen80103(folioNumber);
            ProcesoConfirmarNotificaciónResolucion80103(folioNumber);


        }, repeticiones);
    }

    public void ProcesoOp80103(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        iniDriver();
        loginFirmSoli.loginFun(tramite80103fun);
        //Busqueda de Folio
        mainPage80103.Inicio.click();
        mainPage80103.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80103.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(30000);
        sleep(10000);
        mainPage80103.GenerarOp.click();
        $("[value='Continuar']").click();sleep(1000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFinVig = LocalDate.now().plusDays(1).format(formatter);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage80103.fechaVis, fechaFinVig);
        $("[id = 'btnGuardar']").click();sleep(1000);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void RegistrarOp80103(String folioNumber) {
        //Busqueda de Folio
        mainPage80103.Inicio.click();
        mainPage80103.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80103.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = 'SEOP.AC']").click();sleep(1000);
        $("[id = 'idDescripcionOpinion']").sendKeys("Prueba");sleep(1000);
        $("[value = 'Anexar información digitalizada']").click();sleep(1000);
        mainPage80103.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        $("[value = 'Enviar']").click();sleep(1000);
        $("[id = 'btnGuardar']").click();sleep(1000);
        loginFirmSoli.firma(tramite80103fun);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void Dictamen80103(String folioNumber) {
        //Busqueda de Folio
        mainPage80103.Inicio.click();
        mainPage80103.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80103.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = '?mostrarDictamen=']").click();sleep(1000);
        $("[value = 'Continuar']").click();sleep(50000);
        $("[name = 'tramite.dictamen.justificacion']").sendKeys("Test");sleep(1000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite80103fun);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void AutorizarDictamen80103(String folioNumber) {
        //Busqueda de Folio
        mainPage80103.Inicio.click();
        mainPage80103.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80103.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = 'Autorizar dictamen']").click();sleep(1000);
        loginFirmSoli.firma(tramite80103fun);
        sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion80103(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite80103);
        mainPage80103.selecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage80103.btnacep.click();sleep(1000);
        $$(By.cssSelector("a[id='Inicio']")).findBy(text("Inicio")).click();sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'buscarTareasSolicitante']").click();sleep(1000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite80103);
        sleep(4000);
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
