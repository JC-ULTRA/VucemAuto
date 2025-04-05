//package Firmas;
//
//import TestProd.MainPageProd;
//
//import static com.codeborne.selenide.Selenide.sleep;
//
//public class FirmaProdNet {
//    MainPageProd mainpageprod = new MainPageProd();
//
//    //METODO FIRMA ProdS
//    public void FirmProdS() {
//        mainpageprod.cerS.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\CredProdNet\\Certificado_FIEL_HEUE780514BVA_20210511_202915 (1).cer");sleep(300);
//        mainpageprod.keyS.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\CredProdNet\\Claveprivada_FIEL_HEUE780514BVA_20210511_202915.key");sleep(300);
//        mainpageprod.pass.setValue("tanga2017");sleep(300);
//        mainpageprod.btnIngresFs.click();sleep(300);
//    }
//
//    //METODO FIRMA ProdF
//    public void FirmProdF() {
//        mainpageprod.cerS.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\CredProdNet\\Certificado_FIEL_HEUE780514BVA_20210511_202915 (1).cer");sleep(300);
//        mainpageprod.keyS.setValue("C:\\VucemAuto\\automations\\src\\test\\resources\\CredProdNet\\Claveprivada_FIEL_HEUE780514BVA_20210511_202915.key");sleep(300);
//        mainpageprod.pass.setValue("tanga2017");sleep(300);
//        mainpageprod.btnIngresFF.click();sleep(300);
//    }
//}
