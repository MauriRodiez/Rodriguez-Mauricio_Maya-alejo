package DB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

    public static void createTable(){
        Connection connection = null;

        String filePath = "/src/DB/SQL_CREATE_TABLE.sql";

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();

            String script = readSQLFile();

            statement.execute(script);


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

    public static String readSQLFile(){
        String data = null;
        try {
            File myObj = new File(System.getProperty("user.dir")+"/src/DB/SQL_CREATE_TABLE.sql");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;
        }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./Parcial", "sa", "sa");
    }

}
