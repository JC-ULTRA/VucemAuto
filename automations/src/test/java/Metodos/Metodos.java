package Metodos;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Metodos {
    public void cargarDocumentos () {
        String rutaArchivo = "C:\\VucemAuto\\automations\\src\\test\\resources\\Lorem_ipsum.pdf";
        sleep(1000);
        SelenideElement button = $x("//input[@type='button' and @value='Adjuntar documentos']");
        button.click();sleep(1000);
        ElementsCollection inputs = $$x("//input[contains(@name, 'documentos') and contains(@name, '.file')]");
        for (SelenideElement input : inputs) {
            input.uploadFile(new File(rutaArchivo));
            sleep(500);
        }
    }
    public void scrollIncremento(int veces) {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < veces; i++){
            js.executeScript("window.scrollBy(0,500);");
            sleep(500);
        }
    }
    public void scrollDecremento(int veces) {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        for (int i = 0; i < veces; i++) {
            js.executeScript("window.scrollBy(0,-500);");
            sleep(500);
        }
    }
    public void presionarEscYSpace() {
        // Utilizamos WebDriverRunner para obtener el WebDriver actual
        new Actions(WebDriverRunner.getWebDriver())
                .sendKeys(Keys.ESCAPE) // Presiona la tecla Esc
                .sendKeys(Keys.SPACE)   // Luego presiona la barra espaciadora (Space)
                .perform();             // Ejecuta las acciones
    }
}
