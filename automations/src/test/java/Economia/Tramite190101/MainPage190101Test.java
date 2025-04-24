package Economia.Tramite190101;

import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import Firmas.TramitesFirmasLG;
import com.codeborne.selenide.Condition;
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
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage190101Test {
    MainPage190101 mainPage190101 = new MainPage190101();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";

    TramitesFirmasLG tramite190101  = new TramitesFirmasLG(
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
    public void Proceso190101() {
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
        JCheckBox dictamenCheckBox = new JCheckBox("ProcesoDictamen190101");
        JCheckBox autorizacionCheckBox = new JCheckBox("ProcesoAutorizacion190101");
        JCheckBox confirmacionCheckBox = new JCheckBox("ProcesoConfirmarNotificaciónResolucion190101");

        Object[] params = {"Seleccione los métodos a ejecutar:", dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario selecciona Cancelar, termina el metodo
        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        // Recopilar los métodos seleccionados
        List<String> selectedMethods = new ArrayList<>();
        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoDictamen190101");
        if (autorizacionCheckBox.isSelected()) selectedMethods.add("ProcesoAutorizacion190101");
        if (confirmacionCheckBox.isSelected()) selectedMethods.add("ProcesoConfirmarNotificaciónResolucion190101");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        // MENÚ para elegir qué flujo se va a ejecutar
        JCheckBox flujo1CheckBox = new JCheckBox("Certificación con verificación mediante pruebas periódicas al producto");
        JCheckBox flujo2CheckBox = new JCheckBox("Certificación con verificación mediante el sistema de calidad de la línea de producción");
        JCheckBox flujo3CheckBox = new JCheckBox("Certificación por dictamen de producto para fabricante nacional o extranjero");
        JCheckBox flujo4CheckBox = new JCheckBox("Certificación de artículos reconstruidos");
        JCheckBox flujo5CheckBox = new JCheckBox("Certificación de artículos usados o de segunda mano, de segunda línea o descontinuados");
        JCheckBox flujo6CheckBox = new JCheckBox("Certificación de artículos fuera de especificación");
        Object[] flujoParams = {"Seleccione el flujo a ejecutar:", flujo1CheckBox, flujo2CheckBox, flujo3CheckBox, flujo4CheckBox, flujo5CheckBox, flujo6CheckBox, };
        int flujoSeleccionado = JOptionPane.showConfirmDialog(null, flujoParams, "Flujo de llenado", JOptionPane.OK_CANCEL_OPTION);

        if (flujoSeleccionado != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        if (flujoSeleccionado != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
            return;
        }

        if (!flujo1CheckBox.isSelected() && !flujo2CheckBox.isSelected() && !flujo3CheckBox.isSelected() &&
                !flujo4CheckBox.isSelected() && !flujo5CheckBox.isSelected() && !flujo6CheckBox.isSelected()) {
            // Si no se seleccionó ninguna opción, seleccionar automáticamente la primera opción
            flujo1CheckBox.setSelected(true);
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción. Se ha seleccionado automáticamente el primer flujo.");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            String flujo = "";
            if (flujo1CheckBox.isSelected()) flujo = "input1";
            if (flujo2CheckBox.isSelected()) flujo = "input2";
            if (flujo3CheckBox.isSelected()) flujo = "input3";
            if (flujo4CheckBox.isSelected()) flujo = "input4";
            if (flujo5CheckBox.isSelected()) flujo = "input5";
            if (flujo6CheckBox.isSelected()) flujo = "input6";
            //EJECUTA CAMPOS COMUNES
            Runnable bodegas = () -> {
                //BODEGAS
                mainPage190101.labelBodegas.click();
                sleep(1000);
                mainPage190101.selectEntidadBodega.sendKeys("SINALOA");
                mainPage190101.selectEntidadBodegaDomicilio.sendKeys("Domicilio Fiscal");
                mainPage190101.inputAgregarBodega.click();
            };
            Runnable informeLaboratorio = () -> {
                try {
                    Thread.sleep(2000);
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelInformeLaboratorio.click();
                mainPage190101.inputAgregarNoAcreditado.click();
                mainPage190101.btnBuscarLaboratorio.click();
                mainPage190101.inputLaboratorioNoAcreditado.sendKeys("LEQI8101314S7");
                mainPage190101.btnObtenerDatosLaboratorio.click();
                mainPage190101.labelCamposFormulario.click();
                mainPage190101.inputNormaAplicable.sendKeys("NOM-011-SCFI-2004");
                mainPage190101.inputMarca.sendKeys("MarcaEjemplo");
                Selenide.executeJavaScript("arguments[0].value = '06/04/2025';", mainPage190101.inputFechaInicioPruebas);sleep(100);
                Selenide.executeJavaScript("arguments[0].value = '08/05/2025';", mainPage190101.inputFechaFinalPruebas);sleep(100);
                Selenide.executeJavaScript("arguments[0].value = '22/04/2025';", mainPage190101.inputFechaEmision);sleep(100);
                Selenide.executeJavaScript("arguments[0].value = '22/04/2025';", mainPage190101.inputFechaFinal);sleep(100);
                mainPage190101.inputModeloEvaluado.sendKeys("ModeloX");
                mainPage190101.inputNumeroInforme.sendKeys("12345");
                try {
                    Thread.sleep(2000);
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelNumeroSerie.click();
                mainPage190101.inputUnidadesProducto.sendKeys("100");
                mainPage190101.inputAgregarSerial.sendKeys("ABC123456");
                mainPage190101.btnAgregarSerial.click();
                mainPage190101.btnAgregarInformeLaboratorio.click();
            };
            Runnable ampliacionTitularidad = () -> {
                mainPage190101.labelAmpliacionTitularidad.click();
                mainPage190101.inputRequiereAmplitudTitularidad.click();
                mainPage190101.inputManifiestoDesclaracion.click();
                mainPage190101.inputRFCAmpliacion.sendKeys("LEQI8101314S7");
                mainPage190101.btnAgregarAmpliacion.click();
            };
            Runnable norma = () -> {
                mainPage190101.selectClasificacionNorma.sendKeys("Instrumentos de Medición"); // Seguridad del Producto
                mainPage190101.selectNormaAplicable.sendKeys("NOM-005-SCFI-2011"); // NOM-021-ENER/SCFI-2008
                mainPage190101.inputTiuad.click();
                mainPage190101.inputSolicitudRegimen.click();
            };
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite190101);
            mainPage190101.selecRol.sendKeys("Persona Moral");
            mainPage190101.btnacep.click();
            mainPage190101.Tramites.sendKeys("Solicitudes nuevas");
            mainPage190101.SoliNew.click();
            mainPage190101.Econom.click();
            mainPage190101.linkDireccionGeneralNormas.click();
            mainPage190101.linkCerfiticacion.click();
            mainPage190101.linkCerfiticacionNOM.click(); sleep(500);
            try {
                Thread.sleep(2000); // Pausa de 3 segundos
                // Hacer scroll hasta el elemento
                mainPage190101.Scrol.scrollIntoView(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //DATOS SOLICITUD
            mainPage190101.labelDatosSolicitud.click();
            mainPage190101.labelDatosGenerales.click();
            //ejecuta el input seleccionado
            if (flujo.equals("input1")) {
                mainPage190101.input1.click();
                mainPage190101.selectClasificacionNorma.sendKeys("Instrumentos de Medición"); // Seguridad del Producto
                mainPage190101.selectNormaAplicable.sendKeys("NOM-005-SCFI-2011"); // NOM-021-ENER/SCFI-2008
                mainPage190101.inputTiuad.click();
                mainPage190101.inputSolicitudRegimen.click();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelMercancia.click();
                mainPage190101.inputNuevo.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                // Mostrar submenú solo para la certificacion
                JCheckBox tiuadCheckBox = new JCheckBox("Por Producto");
                JCheckBox ticp2CheckBox = new JCheckBox("Por Familia de Modelos");
                JCheckBox ticp3CheckBox = new JCheckBox("Por Lote");
                Object[] opcionesInput1 = {

                        "Seleccione el tipo de certificación:",
                        tiuadCheckBox, ticp2CheckBox, ticp3CheckBox
                };
                int seleccionCampos = JOptionPane.showConfirmDialog(
                        null,
                        opcionesInput1,
                        "CATEGORIA DEL PRODUCTO",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (seleccionCampos == JOptionPane.OK_OPTION) {
                    if (tiuadCheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFP\"]\n")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputSolicitudProductoMarca.sendKeys("MARCA QA");
                        mainPage190101.inputSolicitudProductoModeloRepresentativo.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipo.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipo.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProducto.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLITUD TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp2CheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFFM\"]")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputFamiliaModelos.sendKeys("MODELOS QA");
                        mainPage190101.btnAgregarFamilia.click();
                        mainPage190101.inputMarcaFamilia.sendKeys("MARCA QA");
                        mainPage190101.inputModeloRepresentativoFamilia.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipoFamilia.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipoFamilia.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProductofamilia.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLIACION TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp3CheckBox.isSelected()) {
                        $(By.xpath("//*[@id='TICP.CFL']")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputTamanoLotes.sendKeys("50");
                        mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                        mainPage190101.inputNumSerie.click();
                        mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                        mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                        mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                        mainPage190101.btnAgregarLotes.click();
                        mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                    }
                }
            }
            if (flujo.equals("input2")) {
                mainPage190101.input2.click();
                mainPage190101.inputNumeroInforme2.sendKeys("12345");
                Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage190101.inputFechaInforme);sleep(100);
                mainPage190101.btnAgregarInformeCertificacion.click();
                mainPage190101.inputCertificadoCalidad.sendKeys("23456");
                Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage190101.inputFechaNumeroCertificado);sleep(100);
                mainPage190101.btnNumeroCertificado.click();
                mainPage190101.inputCampoOrganismo.sendKeys("98676");
                norma.run();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //MERCANCIA
                mainPage190101.labelMercancia.click();
                mainPage190101.inputNuevo.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                // Mostrar submenú solo para la certificacion
                JCheckBox tiuadCheckBox = new JCheckBox("Por Producto");
                JCheckBox ticp2CheckBox = new JCheckBox("Por Familia de Modelos");
                JCheckBox ticp3CheckBox = new JCheckBox("Por Lote");
                Object[] opcionesInput1 = {
                        "Seleccione el tipo de certificación:",
                        tiuadCheckBox, ticp2CheckBox, ticp3CheckBox
                };
                int seleccionCampos = JOptionPane.showConfirmDialog(
                        null,
                        opcionesInput1,
                        "CATEGORIA DEL PRODUCTO",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (seleccionCampos == JOptionPane.OK_OPTION) {
                    if (tiuadCheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFP\"]\n")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputSolicitudProductoMarca.sendKeys("MARCA QA");
                        mainPage190101.inputSolicitudProductoModeloRepresentativo.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipo.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipo.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProducto.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLIACION TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp2CheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFFM\"]")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputFamiliaModelos.sendKeys("MODELOS QA");
                        mainPage190101.btnAgregarFamilia.click();
                        mainPage190101.inputMarcaFamilia.sendKeys("MARCA QA");
                        mainPage190101.inputModeloRepresentativoFamilia.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipoFamilia.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipoFamilia.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProductofamilia.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLIACION TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp3CheckBox.isSelected()) {
                        $(By.xpath("//*[@id='TICP.CFL']")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputTamanoLotes.sendKeys("50");
                        mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                        mainPage190101.inputNumSerie.click();
                        mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                        mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                        mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                        mainPage190101.btnAgregarLotes.click();
                        mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFORME LABORATORIO
                        informeLaboratorio.run();
                    }
                }
            }
            if (flujo.equals("input3")) {
                mainPage190101.input3.click();
                mainPage190101.inputNumeroInformeD.sendKeys("12345");
                Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage190101.inputFechaInformeD);sleep(100);
                mainPage190101.inputCampoOrganismoD.sendKeys("98676");
                mainPage190101.btnAgregarInformeCertificacionD.click();
                mainPage190101.inputnumeroDictamen.sendKeys("23456");
                Selenide.executeJavaScript("arguments[0].value = '08/04/2025';", mainPage190101.inputFechaDictamen);sleep(100);
                mainPage190101.inputOrganismoEmisorDictamen.click();
                norma.run();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelMercancia.click();
                mainPage190101.inputNuevo.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                // Mostrar submenú solo para la certificacion
                JCheckBox tiuadCheckBox = new JCheckBox("Por Producto");
                JCheckBox ticp2CheckBox = new JCheckBox("Por Familia de Modelos");
                JCheckBox ticp3CheckBox = new JCheckBox("Por Lote");
                Object[] opcionesInput1 = {
                        "Seleccione el tipo de certificación:",
                        tiuadCheckBox, ticp2CheckBox, ticp3CheckBox
                };
                int seleccionCampos = JOptionPane.showConfirmDialog(
                        null,
                        opcionesInput1,
                        "CATEGORIA DEL PRODUCTO",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (seleccionCampos == JOptionPane.OK_OPTION) {
                    if (tiuadCheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFP\"]\n")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputSolicitudProductoMarca.sendKeys("MARCA QA");
                        mainPage190101.inputSolicitudProductoModeloRepresentativo.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipo.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipo.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProducto.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //AMPLITUD TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp2CheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFFM\"]")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputFamiliaModelos.sendKeys("MODELOS QA");
                        mainPage190101.btnAgregarFamilia.click();
                        mainPage190101.inputMarcaFamilia.sendKeys("MARCA QA");
                        mainPage190101.inputModeloRepresentativoFamilia.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipoFamilia.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipoFamilia.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProductofamilia.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //AMPLIACION TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp3CheckBox.isSelected()) {
                        $(By.xpath("//*[@id='TICP.CFL']")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputTamanoLotes.sendKeys("50");
                        mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                        mainPage190101.inputNumSerie.click();
                        mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                        mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                        mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                        mainPage190101.btnAgregarLotes.click();
                        mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                    }
                }
            }
            if (flujo.equals("input4")) {
                mainPage190101.input4.click();
                norma.run();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelMercancia.click();
                mainPage190101.inputReconstruido.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                // Mostrar submenú solo para la certificacion
                JCheckBox tiuadCheckBox = new JCheckBox("Por Producto");
                JCheckBox ticp2CheckBox = new JCheckBox("Por Familia de Modelos");
                JCheckBox ticp3CheckBox = new JCheckBox("Por Lote");
                Object[] opcionesInput1 = {

                        "Seleccione el tipo de certificación:",
                        tiuadCheckBox, ticp2CheckBox, ticp3CheckBox
                };
                int seleccionCampos = JOptionPane.showConfirmDialog(
                        null,
                        opcionesInput1,
                        "CATEGORIA DEL PRODUCTO",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (seleccionCampos == JOptionPane.OK_OPTION) {
                    if (tiuadCheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFP\"]\n")).click();
                        //mainPage190101.btnAceptar.click();
                        mainPage190101.inputSolicitudProductoMarca.sendKeys("MARCA QA");
                        mainPage190101.inputSolicitudProductoModeloRepresentativo.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipo.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipo.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProducto.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFROME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLITUD TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp2CheckBox.isSelected()) {
                        $(By.xpath("//*[@id=\"TICP.CFFM\"]")).click();
                        mainPage190101.inputFamiliaModelos.sendKeys("MODELOS QA");
                        mainPage190101.btnAgregarFamilia.click();
                        mainPage190101.inputMarcaFamilia.sendKeys("MARCA QA");
                        mainPage190101.inputModeloRepresentativoFamilia.sendKeys("MODELO QA");
                        mainPage190101.inputSolicitudProductoTipoFamilia.sendKeys("QA");
                        mainPage190101.inputSolicitudProductoSubtipoFamilia.sendKeys("QA");
                        mainPage190101.textareaAccesoriosProductofamilia.sendKeys("ACCESORIOS DE QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFROME LABORATORIO
                        informeLaboratorio.run();
                        //AMPLITUD TITULARIDAD
                        ampliacionTitularidad.run();
                    }
                    if (ticp3CheckBox.isSelected()) {
                        $(By.xpath("//*[@id='TICP.CFL']")).click();
                        mainPage190101.btnAceptar.click();
                        mainPage190101.inputTamanoLotes.sendKeys("50");
                        mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                        mainPage190101.inputNumSerie.click();
                        mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                        mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                        mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                        mainPage190101.btnAgregarLotes.click();
                        mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                        mainPage190101.inputAgregarFracciones.click();sleep(500);
                        mainPage190101.inputAgregarFracciones2.click();sleep(1000);
                        mainPage190101.inputAgregarFracciones4.click();
                        //BODEGAS
                        bodegas.run();
                        //INFROME LABORATORIO
                        informeLaboratorio.run();
                    }
                }
            }
            if (flujo.equals("input5")) {
                mainPage190101.input5.click();
                norma.run();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelMercancia.click();
                mainPage190101.inputReconstruido.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                $(By.xpath("//*[@id='TICP.CFL']")).click();
                mainPage190101.btnAceptar.click();
                mainPage190101.inputTamanoLotes.sendKeys("50");
                mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                mainPage190101.inputNumSerie.click();
                mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                mainPage190101.btnAgregarLotes.click();
                mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                mainPage190101.inputAgregarFracciones.click();
                sleep(500);
                mainPage190101.inputAgregarFracciones2.click();
                sleep(1000);
                mainPage190101.inputAgregarFracciones4.click();
                //BODEGAS
                bodegas.run();
                //INFROME LABORATORIO
                informeLaboratorio.run();
            }
            if (flujo.equals("input6")) {
                mainPage190101.input6.click();
                norma.run();
                try {
                    Thread.sleep(2000); // Pausa de 3 segundos
                    // Hacer scroll hasta el elemento
                    mainPage190101.Scrol.scrollIntoView(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainPage190101.labelMercancia.click();
                mainPage190101.inputFueraEspecificaciones.click();
                mainPage190101.inputSolicitudDescripcionOtroTipo.sendKeys("PRODUCTO DE PRUEBA");
                $(By.xpath("//*[@id='TICP.CFL']")).click();
                mainPage190101.btnAceptar.click();
                mainPage190101.inputTamanoLotes.sendKeys("50");
                mainPage190101.inputUnidadMedida.sendKeys("Docenas");
                mainPage190101.inputNumSerie.click();
                mainPage190101.inputMarcaLotes.sendKeys("MARCA QA");
                mainPage190101.inputModeloLotes.sendKeys("MODELO QA");
                mainPage190101.inputSerieLotes.sendKeys("SERIE QA");
                mainPage190101.btnAgregarLotes.click();
                mainPage190101.textareaAccesoriosProductoLote.sendKeys("PRUEBA QA");
                mainPage190101.inputAgregarFracciones.click();
                sleep(500);
                mainPage190101.inputAgregarFracciones2.click();
                sleep(1000);
                mainPage190101.inputAgregarFracciones4.click();
                //BODEGAS
                bodegas.run();
                //INFROME LABORATORIO
                informeLaboratorio.run();
            }
            mainPage190101.btnGuardaSolicitud.click();

            //Firmas
//            mainPage190101.inputSiguienteButton.click();
//            loginFirmSoli.firma(tramite190101);
//
//            // Obtener el texto del folio desde mainPage190101
//            String folioText = mainPage190101.folio.getText();
//
//            // Llamar al mtodo para obtener el folio
//            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);



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

}