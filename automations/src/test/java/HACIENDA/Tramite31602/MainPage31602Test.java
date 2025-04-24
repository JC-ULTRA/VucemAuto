package HACIENDA.Tramite31602;

import DBYFOLIO.ObtenerFolio;
import Firmas.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage31602Test {
    MainPage31602 mainPage31602 = new MainPage31602();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite31602 = new TramitesFirmasLG(
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
    public void Proceso31602() {
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
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite31602);
            mainPage31602.selecRol.sendKeys("Persona Fisica");
            sleep(200);
            mainPage31602.btnacep.click();
            mainPage31602.Tramites.sendKeys("Solicitudes nuevas");
            mainPage31602.SoliNew.click();
            mainPage31602.hacienda.click();
            mainPage31602.linkRegistrosComercioExterior.click();
            mainPage31602.linkSolicitudRegistroEsquenaIntegral.click();
            mainPage31602.linkSolicitudRegistroEsquemaCertificaci.click();
            //IVA e IEPS AA
            //Datos comunes
            mainPage31602.labelDatosComunes.click();
            sleep(4000);
            mainPage31602.inputPreOperativo.click();
            //mainPage31602.inputRegimen.click();
            mainPage31602.inputRegimen2.click();
            mainPage31602.inputRegimen3.click();
            mainPage31602.inputRegimen4.click();
            mainPage31602.selectSolicitudListaCatalogo.sendKeys("Industria de la minería y metalúrgica");
            mainPage31602.inputMapDeclaracionSolicitudAcepto.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto2.click();
            mainPage31602.inputPropios.click();
            mainPage31602.inputEmpPropios.setValue("20") ;
            mainPage31602.selectSolicitudEmpleadosPropiosBimestre.sendKeys("Enero - Febrero");
            sleep(200);
            mainPage31602.inputMapDeclaracionSolicitudAcepto3.click();
            sleep(2000);
            mainPage31602.inputAgregarSubcontratado.click();
            mainPage31602.inputSubcontratadoBusqueda.setValue("MAVL621207C95");
            mainPage31602.inputBuscar.click();
            sleep(2000);
            mainPage31602.inputSubcontratadoEmpleados.setValue("12345");
            mainPage31602.selectSubcontratadoBimestre.sendKeys("Enero - Febrero");
            sleep(2000);
            mainPage31602.inputSubcontratadoAgregarModalEsquema.should(Condition.visible).click();
            sleep(1000);
            mainPage31602.spanAceptar2.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto4.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto5.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto6.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto7.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto8.click();
            sleep(200);
            mainPage31602.selectImmex.sendKeys("82024 - Autorización Programa Nuevo Servicio");
            sleep(3000);
//            mainPage31602.inputAgregarDomicilios.click();
//            mainPage31602.selectEntidadFederativaIdc.sendKeys("SINALOA");
//            sleep(1000);
////            mainPage31602.inputGridDomiciliosModal.click();
////            mainPage31602.inputAceptarDomicilios.click();
////            sleep(3000);
            mainPage31602.check.click();
            mainPage31602.modificar.click();
            mainPage31602.InstalacionesSI.click();
            mainPage31602.selectDomicilioTipoInstalacion.sendKeys("Planta Productiva");
            sleep(3000);
            mainPage31602.inputProcesoProd.click();
            mainPage31602.inputAcredita.click();
            mainPage31602.inputAceptarDomicilios2.click();
            sleep(2000);
            $$(byText("Aceptar")).get(1).click();// Hace clic en el primer elemento con el texto "Ok"

            mainPage31602.inputMapDeclaracionSolicitudAcepto9.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto10.click();
            sleep(200);
            mainPage31602.inputArchivo.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresExtranjerosIC.xls");
            mainPage31602.inputUploadNewFileExtranjeros.should(Condition.visible).click();sleep(1000);
            mainPage31602.inputUploadNewFileExtranjeros2.click();// Primer botón
            mainPage31602.inputArchivoNacionalesIva.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\carga_proveedoresNacionesIVAIC.xls");
            mainPage31602.inputUploadFileExtranjerosNiva.should(Condition.visible).click();
            sleep(200);
            //otra forma para pasar las emergentes
            $$(byText("Ok")).get(1).click();  // Hace clic en el primer elemento con el texto "Ok"
            mainPage31602.inputMapDeclaracionSolicitudAcepto11.click();
            mainPage31602.inputInventario.click();
            mainPage31602.inputNombreInventario.setValue("QA");
            mainPage31602.inputLugarInventario.setValue("QA");
            mainPage31602.inputAnexoInventario.click();
            mainPage31602.inputAgregarInventario.click();
            $$(byText("Aceptar")).get(2).click();  // Hace clic en el primer elemento con el texto "Ok"
            mainPage31602.inputMapDeclaracionSolicitudAcepto12.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto13.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto14.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto15.click();
            mainPage31602.inputAgregarSocio.click();
            mainPage31602.selectSocioCaracter.sendKeys("Administrador único");
            sleep(2000);
            mainPage31602.inputSocioTributarMexico.click();
            sleep(200);
//            mainPage31602.selectSocioTipoPersona.sendKeys("Física");
//            sleep(2000);
//            mainPage31602.selectSocioTipoPersona.doubleClick();
//            sleep(2000);
//            mainPage31602.inputSocioNombre.setValue("QA");
//            mainPage31602.inputSocioPaterno.setValue("QA");
//            mainPage31602.inputSocioMaterno.setValue("QA");
            mainPage31602.inputSocioBusqueda.setValue("MAVL621207C95");
            mainPage31602.inputBuscar3.click();
            mainPage31602.selectSocioNacionalidad.sendKeys("AUSTRIA (REPUBLICA DE)");
            mainPage31602.inputSocioAgregarModal.click();
            $$(byText("Aceptar")).get(3).click();  // Hace clic en el primer elemento con el texto "Ok




            mainPage31602.manifestado.click();
            sleep(200);
            mainPage31602.Bajoprotesta.click();
            sleep(200);
            /// TERCEROS RELACIONADOS
            mainPage31602.labelTercerosRelacionados.click();
            mainPage31602.inputTercero.setValue("LEQI8101314S7");
            mainPage31602.inputBuscar2.should(Condition.visible).click();
            sleep(300);
            $$(byText("Aceptar")).get(4).click();// Hace clic en el primer elemento con el texto "Ok"
            sleep(300);
            mainPage31602.Agregar.click(); sleep(1000);
            mainPage31602.input.setValue("MAVL621207C95");
            mainPage31602.inputBuscarEnlaceOperativo.click();
            sleep(3000);
            mainPage31602.inputTerceroEnlaceOperativoTelefono.setValue("5564789034");
            mainPage31602.inputBuscarEnlaceOperativo2.click();
            sleep(3000);

            ///DATOS REGIMEN
            mainPage31602.DatosRegimen.click();

            mainPage31602.inputMapDeclaracionSolicitudAcepto22.click();
            mainPage31602.Indiquecumplido.click();

            mainPage31602.inputMapDeclaracionSolicitudAcepto24.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto25.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto26.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto27.click();
            ///  IVA e IEPS
            mainPage31602.spanRubroa.click();
            sleep(300);
            //mainPage31602.Manifieste.click();
            mainPage31602.Proveedores.click();
            mainPage31602.Indique.click();
            mainPage31602.inputAgregarEmp.click();
            mainPage31602.inputEmpresa.setValue("AAL0409235E6");
            mainPage31602.inputBuscarEmpresa.click();
            sleep(300);
            mainPage31602.inputGuardarEmpresa.click();
            $$(byText("Aceptar")).get(5).click();// Hace clic en el primer elemento con el texto "Ok"
            mainPage31602.inputEmpresa2.click();
            mainPage31602.inputEmpresa3.click();
            mainPage31602.tdMontoInversi.click();
            mainPage31602.inputEmpresa4.click();
            mainPage31602.tipoInversion.sendKeys("Bienes Muebles");
            mainPage31602.ValorPesos.sendKeys("100");
            mainPage31602.descripcionGeneral.sendKeys("PRUEBAS ULTRASIST QA");
            mainPage31602.btnAgregarTerritorioNacional.click();sleep(1000);
            mainPage31602.btnAceptarTerritorio.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto16.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto17.click();
            mainPage31602.inputEmpresaSolicitantePorcentaje.setValue("10");
            mainPage31602.inputEmpresaSolicitanteMonto.setValue("500");
            mainPage31602.inputMapDeclaracionSolicitudAcepto18.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto19.click();
            mainPage31602.inputMapDeclaracionSolicitudAcepto20.click();
            mainPage31602.inputFechaRegimen.setValue("12/01/2019");
            mainPage31602.inputMapDeclaracionSolicitudAcepto21.click();
            mainPage31602.inputNumEmpleados.setValue("1000");
            mainPage31602.inputMapDeclaracionSolicitudAcepto23.click();
            mainPage31602.inputNumMaquinaria.setValue("50000000");
            mainPage31602.inputSolicitudPagoReferenciaBancaria.setValue("aaaaaaa");
            mainPage31602.inputSolicitudPagoLlave.setValue("LLAVEPRUMAU12345");
            mainPage31602.selectSolicitudPagoBancoClave.sendKeys("HSBC");
            sleep(300);
//            mainPage31602.inputGuardarSolicitudParcial.should(Condition.visible).click();

            sleep(300);
            mainPage31602.fechapago.shouldBe(visible).click();
            sleep(3000);
            $(byText("7")).shouldBe(visible).click();
            sleep(3000);
            mainPage31602.inputGuardarSolicitud.should(Condition.visible).click();
            sleep(3000);
            mainPage31602.inputSiguiente.click();
            mainPage31602.inputAdjuntarDocumentos.click();
            mainPage31602.inputDocumentosFile.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile2.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile3.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile4.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile5.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile6.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile7.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile8.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile9.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile10.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile11.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile12.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile13.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile14.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile15.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile16.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile17.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile18.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile19.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.inputDocumentosFile20.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf");
            mainPage31602.spanAdjuntar.click();
            sleep(30000);
            mainPage31602.spanCerrar.click();
            mainPage31602.inputSiguienteButton.click();
            loginFirmSoli.firma(tramite31602);

            // Obtener el texto del folio desde mainPageB8
            String folioText = mainPage31602.folio.getText();

            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
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
//
        }, repeticiones);
//
//    }
//
//    //Proceso Dictamen
//    public void ProcesoDictamenB8(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFunB8();
//        //Busqueda de Folio
//        mainPage6001.Inicio.click();
//        mainPage6001.Folio.sendKeys(folioNumber);
//        mainPage6001.inputBuscarTareasFuncionario.click();
//        mainPage6001.tdEvaluarSolicitud.doubleClick();
//        //Generar Dictamen
//        mainPage6001.GenerarDic.click();
//        mainPage6001.SentidoDictamen.click();
//        mainPage6001.JustificacionDic.sendKeys("PRUEBAS QA AUTOMATIZACIÓN");
//        mainPage6001.inputMostrarFirma.click();
//        //Firma Funcionario
//        firmaFun.firmarFunB8();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber2 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber2, FunRFC);
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//    }
//
//    //Proceso Autorización
//    public void ProcesoAutorizacionB8(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//        // Ingreso y Selección de trámite
//        loginFun.loginFunB8();
//        // Búsqueda de Folio
//        mainPage6001.InicioA.click();
//        mainPage6001.FolioA.sendKeys(folioNumber);
//        mainPage6001.inputBuscarTareasFuncionarioA.click();
//        mainPage6001.tdAutorizarDictamen.doubleClick();
//        // Generar Dictamen
//        mainPage6001.inputMostrarFirma2.click();
//        // Firma Funcionario
//        firmaFun.firmarFunB8();
//
//        //despues de firmar se crea una variable de folioNumber +  numero consecutivo para reasignar
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(10000);
//            String folioNumber3 = folioNumber;
//            //se usa el campo folioNumber + numero consecutivo para pasarle el rfc que corresponga para reasignar
//            ConDBReasigSolFun.processFolio(folioNumber3, SoliRFC);
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    //Proceso Confirmar Notificación Resolución
//    public void ProcesoConfirmarNotificaciónResolucionB8(String folioNumber) {
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLogin=%22;");
//        //Ingreso Y Selección de tramite
//        loginFirmSoli.loginSolicitanteB8();
//        mainPage6001.selecRol2.sendKeys("Persona Moral");
//        mainPageB8.btnacep2.click();
//
//        //Busqueda de Folio
//        mainPage6001.linkInicio.click();
//        try {
//            Thread.sleep(5000);
//            mainPage6001.inputNumFolio.sendKeys(folioNumber);
//            mainPage6001.inputBuscarTareasSolicitanteB.click();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        mainPage6001.tdConfirmarNotificaciResoluci.doubleClick();
//        //Confirmar Notificación
//        mainPage6001.inputAcuse.click();
//        //Firma Funcionario
//        firmaSoli.firmarsolicitanteB8();
//
//        try {
//            System.out.println("Entrando al timer");
//            Thread.sleep(3000);
//            System.out.println(mainPageB8.notification.getText());
//            //se cierra el web para empezar otro proceso
//            closeWebDriver();
//            System.out.println("Saliendo del timer");
//        } catch (InterruptedException e) {
//            System.out.println("no entro");
//            throw new RuntimeException(e);
//        }
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

