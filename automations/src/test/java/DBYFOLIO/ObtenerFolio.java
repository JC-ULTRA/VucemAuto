package DBYFOLIO;

import com.codeborne.selenide.Selenide;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObtenerFolio {
    public static String obtenerFolio(String folioText) {
        Pattern pattern = Pattern.compile("<([^>]*)>");  // Busca cualquier cosa entre <>
        Matcher matcher = pattern.matcher(folioText);
        String folioNumber = null;

        // Crear un JFrame invisible para ser el padre del JOptionPane
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);  // Asegura que siempre esté encima de otras ventanas
        frame.setUndecorated(true);  // No queremos que el frame sea visible
        frame.setVisible(true);      // Hacerlo visible (aunque no lo veremos)
        frame.setLocationRelativeTo(null);  // Esto centrará el JOptionPane en la pantalla

        if (matcher.find()) {
            // Si se encuentra el patrón, extraer el número
            folioNumber = matcher.group(1);  // Esto extrae el número sin los corchetes
            String mensaje = "Folio Nuevo Generado:\n " + folioNumber;

            JTextArea textArea = new JTextArea(mensaje);
            textArea.setEditable(false);  // Hacer que el JTextArea no sea editable
            textArea.setPreferredSize(new Dimension(150, 35));  // Ajusta el tamaño según necesites
            textArea.setFont(new Font("Arial", Font.BOLD, 13));  // Ajustar la fuente del texto

            // Cerrar el navegador
            Selenide.closeWebDriver();

            // Mostrar el JTextArea dentro de un JOptionPane
//            JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Folio Generado, Copiar antes de Aceptar.", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Folio Generado: " + folioNumber);
        } else {
            String mensajeError = "No se encontró el número de folio. Texto original: " + folioText;

            JTextArea textAreaError = new JTextArea(mensajeError);
            textAreaError.setEditable(false);
            textAreaError.setWrapStyleWord(true);
            textAreaError.setLineWrap(true);
            textAreaError.setOpaque(false);
            textAreaError.setBackground(new Color(0, 0, 0, 0));
            textAreaError.setFont(new Font("Arial", Font.BOLD, 14));

            // Cerrar el navegador
            Selenide.closeWebDriver();

            // Mostrar el mensaje de error
            JOptionPane.showMessageDialog(frame, new JScrollPane(textAreaError), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(mensajeError);
        }

        // Cerrar el frame invisible
        frame.dispose();
        Selenide.closeWebDriver();
        return folioNumber;
    }

    public static String obtenerFolioTemp(String folioText) {
        Pattern pattern = Pattern.compile("\\b(\\d{9})\\b");
        Matcher matcher = pattern.matcher(folioText);
        String folioNumber = null;
        if (matcher.find()) {
            folioNumber = matcher.group(1);
            String mensaje = "Folio Temporal Generado: " + folioNumber;
            // Imprimir solo en consola
            System.out.println(mensaje);
            // Cerrar el navegador
            Selenide.closeWebDriver();

        } else {
            String mensajeError = "No se encontró el número de folio de 9 dígitos. Texto original: " + folioText;
            // Imprimir en consola
            System.err.println(mensajeError);
            Selenide.closeWebDriver();
        }

        return folioNumber;
    }

}
