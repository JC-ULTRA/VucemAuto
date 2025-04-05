package AGRICULTURA.Tramite220403;
import DBYFOLIO.ObtenerFolio;
import Firmas.LoginFirmSoli;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import Firmas.TramitesFirmasLG;
public class MainPage220403Test {
    MainPage220403 mainPage220403 = new MainPage220403();
    LoginFirmSoli loginFirmSoli = new LoginFirmSoli();
    ObtenerFolio obtenerFolio = new ObtenerFolio();
    //VARIABLES
    String FunRFC = "MAVL621207C95";
    String SoliRFC = "AAL0409235E6";



TramitesFirmasLG tramite220403  = new TramitesFirmasLG(
        "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\aal0409235e6.cer",
        "C:\\VucemAuto\\automations\\src\\test\\resources\\CredSoli\\AAL0409235E6_1012231310.key"
);

    String uuid = UUID.randomUUID().toString();
    int longitudDeseada = 16;
    String llavePago = uuid.replace("-", "").substring(0, longitudDeseada);
    //String llavePago = "D6FE4RG57TU6YIHMO";

    @BeforeAll

    public static void initDriver() {
        Configuration.browser = Browsers.CHROME;   //FIREFOX;CHROME
        open();
        getWebDriver().manage().window().maximize();
        //evitar timer de selenium en webdriver
        getWebDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void Proceso220403() {
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

        // Crear checkboxes para seleccionar los métodos
//        JCheckBox opinionCheckBox = new JCheckBox("ProcesoGenerarOpinion80101");


//        Object[] params = {"Seleccione los métodos a ejecutar:", opinionCheckBox, registrarOpinionCheckBoxCheckBox, dictamenCheckBox, autorizacionCheckBox, confirmacionCheckBox};
//        int option = JOptionPane.showConfirmDialog(null, params, "Opciones de Métodos", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario selecciona Cancelar, termina el metodo
//        if (option != JOptionPane.OK_OPTION) {
//            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.");
//            return;
//        }

        // Recopilar los métodos seleccionados
//        List<String> selectedMethods = new ArrayList<>();
//        if (dictamenCheckBox.isSelected()) selectedMethods.add("ProcesoGenerarOpinion80101");


        // Ejecutar el proceso con las repeticiones y los métodos seleccionados
        ejecutarProcesoNRunnable(() -> {
            // Ingreso y selección de trámite
            loginFirmSoli.login(tramite220403);
            mainPage220403.selecRol.sendKeys("Persona Moral");sleep(200);
            mainPage220403.btnacep.click();sleep(200);
            mainPage220403.Tramites.sendKeys("Solicitudes nuevas");sleep(200);
            mainPage220403.SoliNew.click();sleep(200);
            mainPage220403.agriCultura.click();sleep(200);
            mainPage220403.certSoliReq.click();sleep(200);
            mainPage220403.cerExport.click();sleep(200);
            mainPage220403.tramite220403.click();
            mainPage220403.DatosDeSoLI.shouldBe(visible).click();
            mainPage220403.checkAnimal.shouldBe(visible).click();sleep(200);
            mainPage220403.aduana.sendKeys("CD. REYNOSA, TAMPS.");sleep(200);
            mainPage220403.numConten.sendKeys("contenedor100");sleep(200);
            mainPage220403.paisOrig.sendKeys("MEXICO (ESTADOS UNIDOS MEXICANOS)");sleep(200);
            mainPage220403.entidFede.sendKeys("JALISCO)");sleep(200);
            mainPage220403.munDeOrig.sendKeys("ATENGO)");sleep(200);
            mainPage220403.puntoIngres.sendKeys("Punto de Ingreso)");sleep(200);

            //Combinación requerida
            mainPage220403.especie.sendKeys("Camarón botalón (Trachypenaeus pacifico)");
            mainPage220403.paisDestino.sendKeys("ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)");sleep(200);
            mainPage220403.nombreEmpresa.sendKeys("Maricultura del Pacífico, S.A de C.V.");sleep(200);
            mainPage220403.btnAgregar.click();

//Datos Generales de la Mercancía Animales
            mainPage220403.fracAran.sendKeys("03061999");
            mainPage220403.descrip.sendKeys("Esta es una descripción");sleep(200);
            mainPage220403.cantidadUMC.sendKeys("3563");sleep(200);
            mainPage220403.cantidadUMT.sendKeys("5464");sleep(200);
            mainPage220403.uMC.sendKeys("Kilogramo");sleep(200);
            mainPage220403.tipMerca.sendKeys("Animal");sleep(200);
            mainPage220403.uso.sendKeys("Consumo Humano");sleep(200);
            mainPage220403.nombreC.sendKeys("camaorns");sleep(200);
            mainPage220403.nombreCoun.sendKeys("camaron");sleep(200);
            mainPage220403.faseDes.sendKeys("FASE 5");sleep(200);
            mainPage220403.pres.sendKeys("presentacion");sleep(200);
            mainPage220403.paisProc.sendKeys("CHILE (REPUBLICA DE)");sleep(200);
            mainPage220403.btnAgregarAnimal.click();

            //Transporte
            mainPage220403.pestTransporte.shouldBe(visible).click();
            mainPage220403.mTransport.sendKeys("Marítimo");sleep(200);
            mainPage220403.idDeTransport.sendKeys("MAR23423");sleep(200);
            mainPage220403.nContenedor.sendKeys("CONTRwidf3");sleep(200);
            mainPage220403.nRazonSocial.sendKeys("MX TRANSPORTES");sleep(200);
            mainPage220403.numFlet.sendKeys("2342rwe");sleep(200);

            //Pago de derechos
            mainPage220403.pestaPago.shouldBe(visible).click();
            mainPage220403.banco.sendKeys("INBURSA");sleep(200);
            mainPage220403.llavePago.sendKeys(llavePago);sleep(200);
            mainPage220403.CalendarioFechaPago.shouldBe(visible).click();sleep(200);
            $(byText("6")).shouldBe(visible).click();sleep(200);

            //Terceros relacionados
            mainPage220403.pestaTerceRelacio.shouldBe(visible).click();
            mainPage220403.btnAgregarTercerR.shouldBe(visible).click();sleep(200);
            mainPage220403.checkMoral.shouldBe(visible).click();sleep(200);
            mainPage220403.nomRazSocTercer.sendKeys("Datos del Importador");sleep(200);
            mainPage220403.paisTercer.sendKeys("CHILE (REPUBLICA DE)");sleep(200);
            mainPage220403.domTercer.sendKeys("Hermenegildo Galeana #458 col: centro");sleep(200);
            mainPage220403.lada.sendKeys("52");sleep(200);
            mainPage220403.tel.sendKeys("2979785486");sleep(200);
            mainPage220403.correo.sendKeys("Ultra@ultrasist.com");sleep(200);
            mainPage220403.btnGuardar.shouldBe(visible).click();sleep(200);
            mainPage220403.btnConti.shouldBe(visible).click();sleep(200);
            mainPage220403.btnConti2.shouldBe(visible).click();sleep(200);

            loginFirmSoli.firma(tramite220403);
//            // Obtener el texto del folio desde mainPage80101
            String folioText = mainPage220403.folio.getText();
//            // Llamar al metodo para obtener el folio
            String folioNumber = obtenerFolio.obtenerFolio(folioText);
//
//            ConDBReasigSolFun.processFolio(folioNumber, FunRFC);

//            // Ejecutar métodos seleccionados
//            if (selectedMethods.contains("ProcesoGenerarOpinion80101")) {
//                ProcesoGenerarOpinion80101(folioNumber);
//            }

        }, repeticiones);

    }

//    //Proceso Generar opinion
//    public void ProcesoGenerarOpinion80101(String folioNumber) {
//        //se asigna el login a ocupar
//        open("https://wwwqa.ventanillaunica.gob.mx/ventanilla-HA/authentication.action?showLoginFuncionarios=");
//
//        //flujo de entrar y flujo completo
//        //Ingreso Y Selección de tramite
//        loginFun.loginFun80101();
//        //Busqueda de Folio
//        mainPage80101.Inicio.click();
//        mainPage80101.Folio.sendKeys(folioNumber);
//        mainPage80101.inputBuscarTareasFuncionario.click();
//        mainPage80101.tdEvaluarSolicitud.doubleClick();
//        //Solicitar Opinión
//        mainPage80101.solicitarOpinion.click();
//        mainPage80101.ContinuarOpinion.click();
//        sleep(5000);
//        mainPage80101.FechaVisitaOpinion.click();
//        mainPage80101.fechaOpinion.click();
//        mainPage80101.guardarFirmar.click();
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



    private void getImplicitWaitTimeout(int i) {
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
