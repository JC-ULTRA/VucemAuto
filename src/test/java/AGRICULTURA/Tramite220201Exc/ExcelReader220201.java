//package AGRICULTURA.Tramite220201Exc;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelReader220201 {
//
//    // Método para leer el valor de Rol
//    public static String getRolFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(0);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "DATO INGRESADO" está en la columna 0
//        String Rol = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return Rol;
//    }
//
//    // Método para leer el valor de Tipo Solicitud
//    public static String getTipSoliFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//        Row row = sheet.getRow(1);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Solicitudes nuevas Pedimento" está en la columna 1
//        String TipSoli = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return TipSoli;
//    }
//
//    public static String getAduanaIngresoFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(2);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Aduana" está en la columna 0
//        String AduanaIngreso = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return AduanaIngreso;
//    }
//
//    public static String getOficInspecFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(3);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Oficina Inspección" está en la columna 0
//        String OficInspec = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return OficInspec;
//    }
//
//    public static String getPuntoInspecFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(4);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String PuntoInspec = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return PuntoInspec;
//    }
//
//    public static String getCveUconFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(5);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String CveUcon = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return CveUcon;
//    }
//
//    public static String getEstTifFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(6);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String EstTif = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return EstTif;
//    }
//
//    public static String getNomMedVetFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(7);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String NomMedVet = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return NomMedVet;
//    }
//
//    public static String getNumGuiaFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(8);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String NumGuia = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return NumGuia;
//    }
//
//    public static String getRegiFromExcel(String filePath) throws IOException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = new XSSFWorkbook(file);  // Usar XSSFWorkbook para archivos .xlsx
//        Sheet sheet = workbook.getSheetAt(0);  // Obtener la primera hoja
//        Row row = sheet.getRow(9);  // Asumiendo que los datos están en la fila 1
//        Cell cell = row.getCell(1); // Asumiendo que "Punto Inspección" está en la columna 0
//        String Regi = getCellValue(cell);  // Método para obtener el valor de la celda
//        workbook.close();
//        return Regi;
//    }
//
//
//
//
//
//
//
//
//
//
//    // Método para obtener el valor de la celda (tanto de tipo STRING como NUMERIC)
//    private static String getCellValue(Cell cell) {
//        if (cell == null) {
//            return "";
//        }
//
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                // Si la celda es numérica, la convertimos en String
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    // Si es una fecha, devolverla como texto
//                    return cell.getDateCellValue().toString();
//                } else {
//                    // Eliminar la notación científica y los decimales innecesarios
//                    double numericValue = cell.getNumericCellValue();
//                    if (numericValue == (long) numericValue) {
//                        return String.valueOf((long) numericValue); // Eliminar decimales si es un número entero
//                    } else {
//                        return String.valueOf(numericValue).replaceAll("\\.0$", ""); // Eliminar ".0" en decimales
//                    }
//                }
//            default:
//                return "";
//        }
//    }
//
//}
//
