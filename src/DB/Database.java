package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS(" +
            "ID INT AUTO_INCREMENT NOT NULL," +
            "MATRICULA VARCHAR(50)," +
            "NOMBRE VARCHAR(100)," +
            "APELLIDO VARCHAR(150))";

    public static void createTable(){
        Connection connection = null;

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./FlotaCharter", "sa", "sa");
    }

}
