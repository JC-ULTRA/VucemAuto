package Economia.Tramite80104;

import DBYFOLIO.ConDBReasigSolFun;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import Metodos.Metodos;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage80104Test {
    MainPage80104 mainPage80104 = new MainPage80104();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    Metodos metodos = new Metodos();

    TramitesFirmasLG tramite80104 = new TramitesFirmasLG(
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
            "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key");

    TramitesFirmasLG tramite80104fun = new TramitesFirmasLG(
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
    public void Proceso80104() {
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
//        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen80104");
//        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion80104");
//        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion80104");
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
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen80104");
//        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion80104");
//        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion80104");
//

        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite80104);
            mainPage80104.selecRol.sendKeys("Persona Moral");sleep(1000);
            mainPage80104.btnacep.click();sleep(1000);
            $$(By.cssSelector("a[role='button']")).findBy(text("Trámites")).click();sleep(1000);
            $(withText("Solicitudes nuevas")).click();sleep(1000);
            $("[alt='Secretaría de Economía']").click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("IMMEX")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Autorización Programa Nuevo")).click();sleep(1000);
            $$(By.cssSelector("a[href='#']")).findBy(text("Autorización Programa Nuevo Controladoras ")).click();sleep(15000);
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
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaEmiActa, fechaHoy);
            $("[id='rfcRepresentante']").sendKeys("MAVL621207C95");sleep(1000);

            //Anexo1
            metodos.scrollDecremento(3);
            $("[for='captura.tab.anexoI']").click();sleep(1000);
            mainPage80104.fraccExport.sendKeys(new CharSequence[]{"03035999"});
            mainPage80104.descripcionExport.sendKeys(new CharSequence[]{"prueba"});
            mainPage80104.agregarExport.click();
            mainPage80104.selecFrac.click();
            mainPage80104.complementarFrac.click();
            mainPage80104.categoriaFrac.sendKeys(new CharSequence[]{"Producto terminado"});
            mainPage80104.valorMoneda.sendKeys(new CharSequence[]{"1"});
            mainPage80104.valorMoneda2.sendKeys(new CharSequence[]{"20"});
            mainPage80104.produccionMensual.sendKeys(new CharSequence[]{"1"});
            mainPage80104.produccionAnual.sendKeys(new CharSequence[]{"24"});
            Selenide.sleep(500L);
            mainPage80104.btnAgregar.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80104.selecFrac.click();
            mainPage80104.complementarCliente.click();
            mainPage80104.paisCliente.sendKeys(new CharSequence[]{"Angola"});
            mainPage80104.rfcCliente.sendKeys(new CharSequence[]{"QWYIE2918921"});
            mainPage80104.razonCliente.sendKeys(new CharSequence[]{"prueba"});
            mainPage80104.btnAgregarProv.click();
            mainPage80104.aceptOperacion.click();
            mainPage80104.btnRegresar.click();
            mainPage80104.selecFrac.click();
            mainPage80104.proyectoImmex.click();
            mainPage80104.tipoDocumento.sendKeys(new CharSequence[]{"Contrato de servicio"});

            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaFirma, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.vigenciaFirma, fechaManana);

            mainPage80104.rfcFirmante.sendKeys(new CharSequence[]{"LEQI8101314S7"});
            mainPage80104.razonFirmante.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80104.agregaFirmante.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80104.btnRegresarPE.click();
            mainPage80104.fraccImportacion.sendKeys(new CharSequence[]{"96011001"});
            mainPage80104.descImportacion.sendKeys(new CharSequence[]{"PRUEBAS"});
            mainPage80104.agregaFraccionImp.click();
            mainPage80104.selecImportacion.click();
            mainPage80104.completarImportacion.click();
            mainPage80104.categoriaImp.sendKeys(new CharSequence[]{"Producto terminado"});
            mainPage80104.valormonedaImp.sendKeys(new CharSequence[]{"1"});
            mainPage80104.valormonedaImp2.sendKeys(new CharSequence[]{"24"});
            mainPage80104.volumenImp.sendKeys(new CharSequence[]{"2"});
            mainPage80104.volumenImpA.sendKeys(new CharSequence[]{"48"});
            mainPage80104.agregarImport.click();
            Selenide.sleep(1000L);
            mainPage80104.aceptarImportaciuon.click();
            mainPage80104.selecImportacion.click();
            mainPage80104.provedorImport.click();
            mainPage80104.paisImport.sendKeys(new CharSequence[]{"ANGUILA"});
            mainPage80104.rfcImport.sendKeys(new CharSequence[]{"WYQTY16162YWA"});
            mainPage80104.razonImport.sendKeys(new CharSequence[]{"PRUEBAS"});
            mainPage80104.agregaProvedorImp.click();
            Selenide.sleep(1000L);
            mainPage80104.aceptarProvedorI.click();
            mainPage80104.regresarProvedorI.click();
            Selenide.sleep(1000L);

            metodos.scrollDecremento(4);
            //Federatarios y Plantas
            $("[for='captura.tab.notarios']").click();sleep(1000);

            $("[id='nombreNotario']").sendKeys("EUROFOODS DE MEXICO");sleep(1000);
            $("[id='apellidoPaterno']").sendKeys("GONZALEZ");sleep(1000);
            $("[id='apellidoMaterno']").sendKeys("PINAL");sleep(1000);
            $("[id='numeroActa']").sendKeys("123456");sleep(1000);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaActa2, fechaHoy);
            $("[id='numeroNotaria']").sendKeys("23456");sleep(1000);
            $("[id='entidadFederativa']").sendKeys("SINALOA");sleep(1000);
            $("[id='municipioDelegacion']").sendKeys("SINALOA");sleep(6000);
            mainPage80104.btnagg.click();sleep(2000);

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

            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaFirma2, fechaHoy);
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaFinVig2, fechaManana);
            mainPage80104.agregaComplemento.click();
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            Selenide.sleep(1500L);
            mainPage80104.rfcFirmanteP.sendKeys(new CharSequence[]{"LEQI8101314S7"});
            mainPage80104.tipoFirmante.sendKeys(new CharSequence[]{"Firmante principal"});
            mainPage80104.btnAgregaFirmante.click();
            metodos.scrollDecremento(2);
            mainPage80104.btnAgregaRegresar.click();

            mainPage80104.montosInversion.click();
            mainPage80104.tipoMonto.sendKeys(new CharSequence[]{"Equipo"});
            mainPage80104.cantidadTipo.sendKeys(new CharSequence[]{"1"});
            mainPage80104.descripcionTipo.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80104.valorMonto.sendKeys(new CharSequence[]{"10"});
            mainPage80104.agregarMonto.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80104.regresarMonto.click();

            mainPage80104.empleadosPlanta.click();
            mainPage80104.totalEmpleados.sendKeys(new CharSequence[]{"10"});
            mainPage80104.empleadosDirectos.click();
            mainPage80104.numEmpleadosD.sendKeys(new CharSequence[]{"10"});
            mainPage80104.cedulasEmpleados.sendKeys(new CharSequence[]{"NO"});
            executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.selecFechaImss, fechaManana);
            mainPage80104.agregarEmpleadosD.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80104.regresarEmpleados.click();

//Capacidad Instalada
            mainPage80104.capacidadInstalada.click();
            mainPage80104.fraccionArancel.sendKeys(new CharSequence[]{"0303599"});
            mainPage80104.turnos.sendKeys(new CharSequence[]{"2"});
            mainPage80104.horasPorTurno.sendKeys(new CharSequence[]{"6"});
            mainPage80104.cantEmpleados.sendKeys(new CharSequence[]{"5"});
            mainPage80104.maquinaria.sendKeys(new CharSequence[]{"2"});
            mainPage80104.descripcionMaquinaria.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80104.capacidadMensual.sendKeys(new CharSequence[]{"1"});
            mainPage80104.capacidadAnual.sendKeys(new CharSequence[]{"12"});
            mainPage80104.capacidadEfectiva.sendKeys(new CharSequence[]{"20"});
            mainPage80104.agregarCapacidad.click();
            Selenide.sleep(1000L);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);
            mainPage80104.regresarCapacidad.click();
            $("[id='representacionesFederalesIMMEX']").sendKeys("DURANGO");sleep(1000);
            $("[id='actividadProductiva']").sendKeys("AGRICULTURA");sleep(1000);
            metodos.scrollDecremento(6);

            //Empresas submanufactureras
            $("[for='captura.tab.empresas']").click();sleep(1000);
            $("[id='rfcEmpresaSubManufacturera']").sendKeys("TSD931210493");sleep(1000);
            $("[id='entidadFederativaEmpresaSub']").sendKeys("QUERETARO");sleep(1000);
            $("[value='Buscar plantas']").click();sleep(1000);
            $("[id='jqg_gridPlantasDispSubMan_1']").click();sleep(1000);
            mainPage80104.AgregarPlanta.click();sleep(1000);
            $("[id='cb_gridPlantasSubSeleccionada']").click();sleep(1000);
            $("[id='btnAgregarCompSub']").click();sleep(1000);
            $("[id='amparoProgramaSub']").sendKeys("SI");sleep(1000);
            $("[id='personaISR']").sendKeys("SI");sleep(1000);
            $("[id='btnAgregarDatosSubmanufacturera']").click();sleep(1000);
            $$(By.cssSelector("button[type='button']")).findBy(text("Aceptar")).click();sleep(1000);

//Empresas controladas
            $("[for='captura.tab.empresasControladoras']").click();sleep(1000);
            $("[id='rfcEmpresaControladora']").sendKeys("AFC000526BJ2");sleep(1000);
            $("[id='entidadFederativaEmpresaControladora']").sendKeys("CHIHUAHUA");sleep(1000);
            $("[name='buscarPlantasControladoras']").click();sleep(1000);
            mainPage80104.CheckFacturas.click();sleep(1000);
            mainPage80104.btnAgregarPlant.click();sleep(1000);

//Anexo ii y iii
            metodos.scrollDecremento(6);
            $("[for='captura.tab.anexos']").click();sleep(1000);
            mainPage80104.fraccionAnexo2.sendKeys(new CharSequence[]{"03044801"});
            mainPage80104.descAnexo2.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80104.agregaAnexo2.click();
            mainPage80104.fraccionAnexo3.sendKeys(new CharSequence[]{"95079099"});
            mainPage80104.descAnexo3.sendKeys(new CharSequence[]{"PRUEBA"});
            mainPage80104.agregaAnexo3.click();
            mainPage80104.continuarSoli.click();
            Selenide.sleep(1000L);
            mainPage80104.continuarArchivos.click();
            mainPage80104.cargarArchivos.click();
            mainPage80104.archivo1.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.archivo11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            Selenide.sleep(500L);
            mainPage80104.adjuntarArchivos.click();
            Selenide.sleep(20500L);
            mainPage80104.cerrarArchivos.click();
            mainPage80104.continuarFirma.click();
            loginFirmSoli.firma(tramite80104);sleep(4000);
            String folioText = mainPage80104.folio.getText();sleep(5000);
            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);sleep(5000);
            ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");

            // Ejecutar métodos seleccionados
            ProcesoOp80104(folioNumber);
            RegistrarOp80104(folioNumber);
            Dictamen80104(folioNumber);
            AutorizarDictamen80104(folioNumber);
            ProcesoConfirmarNotificaciónResolucion80104(folioNumber);


        }, repeticiones);
    }

    public void ProcesoOp80104(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
        iniDriver();
        loginFirmSoli.loginFun(tramite80104fun);
        //Busqueda de Folio
        mainPage80104.Inicio.click();
        mainPage80104.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80104.inputBuscarTareasFuncionario.click();sleep(1000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        sleep(10000);
        mainPage80104.GenerarOp.click();
        $("[value='Continuar']").click();sleep(1000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFinVig = LocalDate.now().plusDays(1).format(formatter);
        executeJavaScript("arguments[0].value = arguments[1];", mainPage80104.fechaVis, fechaFinVig);
        $("[id = 'btnGuardar']").click();sleep(1000);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void RegistrarOp80104(String folioNumber) {
        //Busqueda de Folio
        mainPage80104.Inicio.click();
        mainPage80104.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80104.inputBuscarTareasFuncionario.click();sleep(1000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = 'SEOP.AC']").click();sleep(1000);
        $("[id = 'idDescripcionOpinion']").sendKeys("Prueba");sleep(1000);
        $("[value = 'Anexar información digitalizada']").click();sleep(1000);
        mainPage80104.archivo12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
        $("[value = 'Enviar']").click();sleep(1000);
        $("[id = 'btnGuardar']").click();sleep(1000);
        loginFirmSoli.firma(tramite80104fun);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void Dictamen80104(String folioNumber) {
        //Busqueda de Folio
        mainPage80104.Inicio.click();
        mainPage80104.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80104.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = '?mostrarDictamen=']").click();sleep(1000);
        $("[value = 'Continuar']").click();sleep(50000);
        $("[name = 'tramite.dictamen.justificacion']").sendKeys("Test");sleep(1000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite80104fun);
        ConDBReasigSolFun.processFolio(folioNumber, "MAVL621207C95");
        sleep(4000);
    }

    public void AutorizarDictamen80104(String folioNumber) {
        //Busqueda de Folio
        mainPage80104.Inicio.click();
        mainPage80104.Folio.sendKeys(folioNumber); //se lo quite porque no tengo BD
        mainPage80104.inputBuscarTareasFuncionario.click();
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[value = 'Autorizar dictamen']").click();sleep(1000);
        loginFirmSoli.firma(tramite80104fun);
        sleep(4000);
    }

    public void ProcesoConfirmarNotificaciónResolucion80104(String folioNumber) {
        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
        loginFirmSoli.login(tramite80104);
        mainPage80104.selecRol.sendKeys("Persona Moral");sleep(1000);
        mainPage80104.btnacep.click();sleep(1000);
        $$(By.cssSelector("a[id='Inicio']")).findBy(text("Inicio")).click();sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'idNumFolio']").sendKeys(folioNumber);sleep(1000);
        $("[id = 'buscarTareasSolicitante']").click();sleep(1000);
        $$(By.cssSelector("td[role='gridcell']")).findBy(text(folioNumber)).doubleClick();sleep(50000);
        $("[name = 'mostrarFirma']").click();sleep(1000);
        loginFirmSoli.firma(tramite80104);
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