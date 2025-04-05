package TestProd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexionBD {

    // Configuración de la conexión a la base de datos
    private static final String URL = "jdbc:oracle:thin:@//172.55.3.94:1521/vucprod1";  // Ajusta el SID si es necesario
    private static final String USER = "REPORTESVUCEM";  // Usuario de la base de datos
    private static final String PASSWORD = "Wxa7#ksH2c";  // Contraseña de la base de datos

    // Método para ejecutar la consulta folio estatus inicial
    public static String consultaEstatusInicial() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String maxFolio = null;  // Guardará el valor de MAX(NUM_FOLIO_TRAMITE)

        try {
            // Establecer conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear el Statement
            statement = connection.createStatement();

            // Ejecutar la consulta
            String query = "SELECT MAX(NUM_FOLIO_TRAMITE) FROM VUC_TRAMITE vt " +
                    "WHERE vt.FEC_RECEPCION > SYSDATE AND vt.IDE_EST_TRAMITE = 'ESTTR.IN'";

            resultSet = statement.executeQuery(query);

            // Obtener el resultado de la consulta
            if (resultSet.next()) {
                maxFolio = resultSet.getString(1);  // Guardamos el resultado en la variable maxFolio
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return maxFolio;  // Devolvemos el valor obtenido
    }

    // Método para ejecutar la consulta folio estatus terminal
    public static String consultaEstatusTerminal() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String maxFolio = null;  // Guardará el valor de MAX(NUM_FOLIO_TRAMITE)

        try {
            // Establecer conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear el Statement
            statement = connection.createStatement();

            // Ejecutar la consulta
            String query = "SELECT MAX(NUM_FOLIO_TRAMITE) FROM VUC_TRAMITE vt " +
                    "WHERE vt.FEC_RECEPCION > SYSDATE AND vt.IDE_EST_TRAMITE = 'ESTTR.CN'";

            resultSet = statement.executeQuery(query);

            // Obtener el resultado de la consulta
            if (resultSet.next()) {
                maxFolio = resultSet.getString(1);  // Guardamos el resultado en la variable maxFolio
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return maxFolio;  // Devolvemos el valor obtenido
    }
}
