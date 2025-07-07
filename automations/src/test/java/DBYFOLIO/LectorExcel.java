package DBYFOLIO;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorExcel {

    public static Map<String, String> leerDatos(String rutaArchivo, String hoja) {
        Map<String, String> datos = new HashMap<>();
        DataFormatter formatter = new DataFormatter(); // Formatea los valores como se ven en Excel

        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(hoja);
            if (sheet == null) {
                System.err.println("❌ No se encontró la hoja: " + hoja);
                return null;
            }

            for (Row row : sheet) {
                Cell clave = row.getCell(0);
                Cell valor = row.getCell(1);
                if (clave != null && valor != null) {
                    String claveStr = formatter.formatCellValue(clave).trim();
                    String valorStr = formatter.formatCellValue(valor).trim();
                    if (!claveStr.isEmpty()) {
                        datos.put(claveStr, valorStr);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Error leyendo el archivo Excel: " + e.getMessage());
            e.printStackTrace();
        }

        return datos;
    }
}