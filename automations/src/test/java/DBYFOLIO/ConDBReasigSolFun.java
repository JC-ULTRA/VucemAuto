package DBYFOLIO;

import java.sql.*;

public class ConDBReasigSolFun {
    // Configuración de la conexión a la base de datos
    private static final String URL = "jdbc:oracle:thin:@//10.181.233.242:1521/vucprod2"; // Ajusta si es necesario
    private static final String USER = "BPMDB24"; // Reemplaza con tu usuario
    private static final String PASSWORD = "B9w6B2a"; // Reemplaza con tu contraseña

    // Metodo para obtener la conexión a la base de datos
    private static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Metodo para realizar la consulta, actualización y volver a consultar
    public static void processFolio(String idFolio, String newRFC) {
        String query = "SELECT * FROM INSTANCE_SEQUENCE is2 WHERE ID_FOLIO_TRAMITE = ? ORDER BY id ASC";
        String update = "UPDATE INSTANCE_SEQUENCE SET ID_EMPLOYEE = ? WHERE ID_FOLIO_TRAMITE = ? AND DONE = 0";

        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            if (connection == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return;
            }

            // Realizar la consulta inicial
            selectStatement = connection.prepareStatement(query);
            selectStatement.setString(1, idFolio);
            resultSet = selectStatement.executeQuery();
            System.out.println("Consulta inicial:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Supón que hay una columna "id"
                String folio = resultSet.getString("ID_FOLIO_TRAMITE");
                String RFC = resultSet.getString("ID_EMPLOYEE");
                System.out.println("ID: " + id + ", Folio: " + folio + ", RFC: " + RFC);
            }

            // Actualizar los registros
            updateStatement = connection.prepareStatement(update);
            updateStatement.setString(1, newRFC);
            updateStatement.setString(2, idFolio);
            int rowsUpdated = updateStatement.executeUpdate();
            System.out.println("Registros actualizados: " + rowsUpdated);

            // Volver a realizar la consulta
            selectStatement = connection.prepareStatement(query);
            selectStatement.setString(1, idFolio);
            resultSet = selectStatement.executeQuery();
            System.out.println("Consulta después de la actualización:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String folio = resultSet.getString("ID_FOLIO_TRAMITE");
                String RFC = resultSet.getString("ID_EMPLOYEE");
                System.out.println("ID: " + id + ", Folio: " + folio + ", RFC: " + RFC);
                System.out.println("Esperando Proximo Proceso: ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos en el bloque finally
            try {
                if (resultSet != null) resultSet.close();
                if (selectStatement != null) selectStatement.close();
                if (updateStatement != null) updateStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}